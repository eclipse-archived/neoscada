/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - additional work
 *******************************************************************************/
package org.eclipse.scada.ca.common.factory;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public abstract class AbstractServiceConfigurationFactory<T> implements ConfigurationFactory
{

    private final Map<String, Entry<T>> services = new HashMap<String, Entry<T>> ();

    private final BundleContext context;

    private final boolean canOnlyRecreate;

    protected static class Entry<T>
    {
        private final String id;

        private final T service;

        private final ServiceRegistration<?> handle;

        /**
         * Create a new service entry that is registered with OSGi
         * 
         * @param service
         *            the service
         * @param handle
         *            the service registration
         */
        public Entry ( final String id, final T service, final ServiceRegistration<?> handle )
        {
            this.id = id;
            this.service = service;
            this.handle = handle;
        }

        /**
         * Create a new service entry that is not registered with OSGi
         * 
         * @param service
         *            the service
         */
        public Entry ( final String id, final T service )
        {
            this.id = id;
            this.service = service;
            this.handle = null;
        }

        public ServiceRegistration<?> getHandle ()
        {
            return this.handle;
        }

        public T getService ()
        {
            return this.service;
        }

        public String getId ()
        {
            return this.id;
        }
    }

    public AbstractServiceConfigurationFactory ( final BundleContext context )
    {
        this ( context, false );
    }

    public AbstractServiceConfigurationFactory ( final BundleContext context, final boolean canOnlyRecreate )
    {
        this.context = context;
        this.canOnlyRecreate = canOnlyRecreate;
    }

    public synchronized void dispose ()
    {
        for ( final Entry<T> entry : this.services.values () )
        {
            disposeService ( null, entry.getId (), entry.getService () );
            unregisterService ( entry );
        }
        this.services.clear ();
    }

    /**
     * Unregister the service entry with OSGi
     * 
     * @param entry
     *            the entry to unregister
     */
    protected void unregisterService ( final Entry<T> entry )
    {
        final ServiceRegistration<?> handle = entry.getHandle ();
        if ( handle != null )
        {
            handle.unregister ();
        }
    }

    @Override
    public synchronized void delete ( final UserInformation userInformation, final String configurationId ) throws Exception
    {
        final Entry<T> entry = this.services.remove ( configurationId );
        if ( entry != null )
        {
            disposeService ( userInformation, configurationId, entry.getService () );
            unregisterService ( entry );
        }
    }

    @Override
    public synchronized void update ( final UserInformation userInformation, final String configurationId, final Map<String, String> parameters ) throws Exception
    {
        if ( this.canOnlyRecreate )
        {
            // delete first so we will call create in the next step
            delete ( userInformation, configurationId );
        }

        Entry<T> entry = this.services.get ( configurationId );
        if ( entry != null )
        {
            final Entry<T> newEntry = updateService ( userInformation, configurationId, entry, parameters );
            if ( newEntry != null && newEntry != entry )
            {
                // replace with the new entry
                disposeService ( userInformation, configurationId, entry.getService () );
                unregisterService ( entry );
                this.services.put ( configurationId, newEntry );
            }
        }
        else
        {
            entry = createService ( userInformation, configurationId, this.context, parameters );
            if ( entry != null )
            {
                this.services.put ( configurationId, entry );
            }
        }
    }

    /**
     * Create a new service instance
     * <p>
     * The method must also register the service with the OSGi bundle context if
     * needed. The service registration must then be placed into the result that
     * is returned. This is an optional step. There is no need to register the
     * created service.
     * </p>
     * 
     * @param principal
     * @param configurationId
     *            the configuration id for which the service should be created
     * @param context
     *            the bundle context
     * @param parameters
     *            the initial parameters
     * @return a new entry instance which holds the service. This method must
     *         never return <code>null</code>
     * @throws Exception
     *             if anything goes wrong
     */
    protected abstract Entry<T> createService ( UserInformation userInformation, String configurationId, BundleContext context, final Map<String, String> parameters ) throws Exception;

    /**
     * Dispose a service
     * <p>
     * If the service entry contains a service handle, the service is
     * automatically unregistered.
     * </p>
     * 
     * @param userInformation
     * @param configurationId
     * @param service
     */
    protected abstract void disposeService ( UserInformation userInformation, String configurationId, T service );

    /**
     * Update a service configuration
     * <p>
     * If a new service entry is returned the old one will get disposed after
     * the call returns
     * </p>
     * 
     * @param principal
     * @param configurationId
     *            the configuration to update
     * @param entry
     *            the original service entry
     * @param parameters
     *            the new parameters
     * @return the new service entry or <code>null</code> if the entry did not
     *         change
     * @throws Exception
     *             if anything goes wrong
     */
    protected abstract Entry<T> updateService ( UserInformation userInformation, String configurationId, Entry<T> entry, Map<String, String> parameters ) throws Exception;

    protected synchronized Entry<T> getService ( final String configurationId )
    {
        return this.services.get ( configurationId );
    }
}
