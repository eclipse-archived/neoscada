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
package org.eclipse.scada.ca.testing;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.ca.SelfManagedConfigurationFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

public class Activator implements BundleActivator
{

    private ConfigurationFactoryImpl service;

    private SelfManagedConfigurationFactoryImpl service2;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.service = new ConfigurationFactoryImpl ();
        this.service2 = new SelfManagedConfigurationFactoryImpl ( "testing.selfManaged.factory" );
        this.service2.start ();

        // add plain factory
        Dictionary<String, Object> properties = new Hashtable<String, Object> ();
        properties.put ( ConfigurationAdministrator.FACTORY_ID, "testing.factory" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "Testing Factory" );

        context.registerService ( ConfigurationFactory.class.getName (), this.service, properties );

        // add self managed factory

        properties = new Hashtable<String, Object> ();
        properties.put ( ConfigurationAdministrator.FACTORY_ID, "testing.selfManaged.factory" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "Self Managed Testing Factory" );

        context.registerService ( SelfManagedConfigurationFactory.class.getName (), this.service2, properties );
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.service2.stop ();
        this.service2 = null;
    }

}
