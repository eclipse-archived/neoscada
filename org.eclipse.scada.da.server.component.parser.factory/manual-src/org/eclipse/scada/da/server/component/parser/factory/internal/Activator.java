/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.component.parser.factory.internal;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{

    private FactoryImpl service;

    private ServiceRegistration<ConfigurationFactory> handle;

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.service = new FactoryImpl ( context );

        final Dictionary<String, Object> properties = new Hashtable<> ();
        properties.put ( Constants.SERVICE_DESCRIPTION, "A factory for parser components" );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        properties.put ( ConfigurationAdministrator.FACTORY_ID, org.eclipse.scada.da.server.component.parser.factory.Constants.FACTORY_ID );

        this.handle = context.registerService ( ConfigurationFactory.class, this.service, properties );
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        if ( this.handle != null )
        {
            this.handle.unregister ();
            this.handle = null;
        }
        if ( this.service != null )
        {
            this.service.dispose ();
            this.service = null;
        }
    }
}
