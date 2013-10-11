/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.provider;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.scada.core.ui.connection.creator.ConnectionCreatorHelper;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin
{

    // The plug-in ID
    public static final String PLUGIN_ID = "org.eclipse.scada.core.ui.connection.provider";

    // The shared instance
    private static Activator plugin;

    private final Set<ServiceRegistration<?>> registrations = new HashSet<ServiceRegistration<?>> ();

    private final Set<ConnectionService> services = new HashSet<ConnectionService> ();

    /**
     * The constructor
     */
    public Activator ()
    {

    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        super.start ( context );
        plugin = this;

        createConnections ();
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        disposeConnections ();

        plugin = null;
        super.stop ( context );
    }

    private void createConnections ()
    {
        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( "org.eclipse.scada.core.ui.connection.provider.connectionInstance" ) )
        {
            if ( !"connectionInstance".equals ( ele.getName () ) )
            {
                continue;
            }
            final String id = ele.getAttribute ( "servicePid" );
            final String uri = ele.getAttribute ( "uri" );
            final String autoReconnect = ele.getAttribute ( "autoReconnect" );
            createConnection ( id, uri, autoReconnect );
        }
    }

    private void createConnection ( final String id, final String uri, final String autoReconnect )
    {
        try
        {
            Integer autoReconnectDelay = null;
            if ( autoReconnect != null )
            {
                autoReconnectDelay = Integer.valueOf ( autoReconnect );
            }
            final ConnectionService service = ConnectionCreatorHelper.createConnection ( ConnectionInformation.fromURI ( uri ), autoReconnectDelay, false );
            if ( service != null )
            {
                if ( this.services.add ( service ) )
                {
                    service.connect ();
                    registerService ( id, uri, service );
                }
            }
            else
            {
                getLog ().log ( new Status ( IStatus.WARNING, PLUGIN_ID, String.format ( "Unable to find connection creator for %s", uri ) ) );
            }
        }
        catch ( final Exception e )
        {
            getLog ().log ( new Status ( IStatus.ERROR, PLUGIN_ID, "Failed to create connection", e ) );
        }
    }

    private void registerService ( final String id, final String uri, final ConnectionService service )
    {
        final Dictionary<String, Object> properties = new Hashtable<String, Object> ();
        properties.put ( Constants.SERVICE_PID, id );
        properties.put ( ConnectionService.CONNECTION_URI, uri );

        final Class<?>[] clazzes = service.getSupportedInterfaces ();

        final String[] clazzStr = new String[clazzes.length];
        for ( int i = 0; i < clazzes.length; i++ )
        {
            clazzStr[i] = clazzes[i].getName ();
        }

        final ServiceRegistration<?> handle = getBundle ().getBundleContext ().registerService ( clazzStr, service, properties );
        this.registrations.add ( handle );
    }

    private void disposeConnections ()
    {
        for ( final ServiceRegistration<?> reg : this.registrations )
        {
            reg.unregister ();
        }
        for ( final ConnectionService service : this.services )
        {
            service.dispose ();
        }
        this.services.clear ();
        this.registrations.clear ();
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static Activator getDefault ()
    {
        return plugin;
    }
}
