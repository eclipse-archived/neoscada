/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.mqtt;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MqttBrokerFactory extends AbstractServiceConfigurationFactory<MqttBroker>
{
    private final static Logger logger = LoggerFactory.getLogger ( MqttBrokerFactory.class );

    private final ExecutorService executor;

    public MqttBrokerFactory ( final BundleContext context, final ExecutorService executor )
    {
        super ( context );
        this.executor = executor;
    }

    @Override
    protected org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory.Entry<MqttBroker> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final MqttBrokerImpl mqttBroker = new MqttBrokerImpl ( this.executor );

        mqttBroker.update ( parameters );

        final Dictionary<String, String> properties = new Hashtable<String, String> ();
        properties.put ( Constants.SERVICE_DESCRIPTION, "Eclipse SCADA MQTT broker wrapper" );
        properties.put ( Constants.SERVICE_PID, configurationId );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );

        return new Entry<MqttBroker> ( configurationId, mqttBroker, context.registerService ( MqttBroker.class, mqttBroker, properties ) );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final MqttBroker service )
    {
        try
        {
            ( (MqttBrokerImpl)service ).dispose ();
        }
        catch ( final Exception e )
        {
            logger.error ( "error on disposing MqttExporter", e );
        }
    }

    @Override
    protected org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory.Entry<MqttBroker> updateService ( final UserInformation userInformation, final String configurationId, final org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory.Entry<MqttBroker> entry, final Map<String, String> parameters ) throws Exception
    {
        ( (MqttBrokerImpl)entry.getService () ).update ( parameters );
        return null;
    }
}
