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

import java.util.Map;
import java.util.concurrent.ExecutorService;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MqttExporterFactory extends AbstractServiceConfigurationFactory<MqttExporter>
{
    private final static Logger logger = LoggerFactory.getLogger ( MqttExporterFactory.class );

    private final ExecutorService executor;

    public MqttExporterFactory ( final BundleContext context, final ExecutorService executor )
    {
        super ( context );
        this.executor = executor;
    }

    @Override
    protected Entry<MqttExporter> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final MqttExporter mqttExporter = new MqttExporter ( context, this.executor );
        mqttExporter.update ( parameters );
        mqttExporter.start ();
        return new Entry<MqttExporter> ( configurationId, mqttExporter );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final MqttExporter mqttExporter )
    {
        try
        {
            mqttExporter.stop ();
        }
        catch ( final Exception e )
        {
            logger.error ( "error on disposing MqttExporter", e );
        }
    }

    @Override
    protected Entry<MqttExporter> updateService ( final UserInformation userInformation, final String configurationId, final Entry<MqttExporter> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().stop ();
        entry.getService ().update ( parameters );
        entry.getService ().start ();
        return null;
    }

}
