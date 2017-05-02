/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.common.factory;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public abstract class AbstractServiceFactory implements ConfigurationFactory
{

    private final Map<String, Service> instances = new HashMap<String, Service> ();

    private final Map<String, ServiceRegistration<?>> regs = new HashMap<String, ServiceRegistration<?>> ();

    private final BundleContext context;

    public AbstractServiceFactory ( final BundleContext context )
    {
        this.context = context;
    }

    public synchronized void dispose ()
    {
        for ( final ServiceRegistration<?> reg : this.regs.values () )
        {
            reg.unregister ();
        }
        for ( final Service service : this.instances.values () )
        {
            service.dispose ();
        }
        this.instances.clear ();
        this.regs.clear ();
    }

    @Override
    public synchronized void delete ( final UserInformation information, final String configurationId ) throws Exception
    {
        final ServiceRegistration<?> reg = this.regs.remove ( configurationId );
        if ( reg != null )
        {
            reg.unregister ();
        }

        final Service service = this.instances.remove ( configurationId );

        if ( service != null )
        {
            service.dispose ();
        }
    }

    @Override
    public synchronized void update ( final UserInformation information, final String configurationId, final Map<String, String> properties ) throws Exception
    {
        final Service service = this.instances.get ( configurationId );
        if ( service != null )
        {
            // update
            service.update ( information, properties );
        }
        else
        {
            // create
            final Service newService = createService ( information, configurationId, properties );
            if ( newService != null )
            {
                final ServiceRegistration<?> reg = registerService ( information, this.context, configurationId, newService );

                if ( reg != null )
                {
                    this.regs.put ( configurationId, reg );
                    this.instances.put ( configurationId, newService );
                }
                else
                {
                    newService.dispose ();
                }
            }
        }
    }

    protected abstract Service createService ( UserInformation information, String configurationId, Map<String, String> properties ) throws Exception;

    protected abstract ServiceRegistration<?> registerService ( UserInformation information, BundleContext context, String configurationId, Service service );

}
