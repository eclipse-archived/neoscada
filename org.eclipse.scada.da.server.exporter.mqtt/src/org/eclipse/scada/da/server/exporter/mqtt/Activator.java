/*******************************************************************************
 * Copyright (c) 2013 Jürgen Rose and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jürgen Rose - initial API and implementation
 *******************************************************************************/

package org.eclipse.scada.da.server.exporter.mqtt;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator
{

    private final static Logger logger = LoggerFactory.getLogger ( Activator.class );

    private static BundleContext context;

    static BundleContext getContext ()
    {
        return context;
    }

    private ExecutorService executor;

    private MqttExporterFactory mqttExporterFactory;

    private ServiceRegistration<ConfigurationFactory> mqttExporterFactoryRegistration;

    private MqttItemToTopicFactory mqttItemToTopicFactory;

    private ServiceRegistration<ConfigurationFactory> mqttItemToTopicFactoryRegistration;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext bundleContext ) throws Exception
    {
        logger.info ( "starting MQTT exporter" );
        Activator.context = bundleContext;

        this.executor = Executors.newSingleThreadExecutor ( new NamedThreadFactory ( getClass ().getName () ) );

        {
            this.mqttExporterFactory = new MqttExporterFactory ( context, this.executor );

            final Dictionary<String, String> properties = new Hashtable<String, String> ( 3 );
            properties.put ( Constants.SERVICE_DESCRIPTION, "A factory which creates a MQTT connection" );
            properties.put ( Constants.SERVICE_VENDOR, "IBH SYSTEMS GmbH" );
            properties.put ( ConfigurationAdministrator.FACTORY_ID, context.getBundle ().getSymbolicName () );

            this.mqttExporterFactoryRegistration = context.registerService ( ConfigurationFactory.class, this.mqttExporterFactory, properties );
        }

        {
            this.mqttItemToTopicFactory = new MqttItemToTopicFactory ( context );

            final Dictionary<String, String> properties = new Hashtable<String, String> ( 3 );
            properties.put ( Constants.SERVICE_DESCRIPTION, "A factory which creates a items which are published on MQTT" );
            properties.put ( Constants.SERVICE_VENDOR, "IBH SYSTEMS GmbH" );
            properties.put ( ConfigurationAdministrator.FACTORY_ID, context.getBundle ().getSymbolicName () + ".items" );

            this.mqttItemToTopicFactoryRegistration = context.registerService ( ConfigurationFactory.class, this.mqttItemToTopicFactory, properties );
        }
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        logger.info ( "stopping MQTT exporter" );

        if ( this.mqttItemToTopicFactoryRegistration != null )
        {
            this.mqttItemToTopicFactoryRegistration.unregister ();
        }
        if ( this.mqttItemToTopicFactory != null )
        {
            this.mqttItemToTopicFactory.dispose ();
        }

        if ( this.mqttExporterFactoryRegistration != null )
        {
            this.mqttExporterFactoryRegistration.unregister ();
        }
        if ( this.mqttExporterFactory != null )
        {
            this.mqttExporterFactory.dispose ();
        }

        this.executor = null;

        Activator.context = null;
    }
}
