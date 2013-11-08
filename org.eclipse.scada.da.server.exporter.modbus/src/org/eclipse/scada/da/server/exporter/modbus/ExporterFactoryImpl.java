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
package org.eclipse.scada.da.server.exporter.modbus;

import java.util.Map;

import org.apache.mina.core.service.IoProcessor;
import org.apache.mina.core.service.SimpleIoProcessorPool;
import org.apache.mina.transport.socket.nio.NioProcessor;
import org.apache.mina.transport.socket.nio.NioSession;
import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.server.exporter.modbus.common.ServiceListenerHiveSource;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.concurrent.ScheduledExportedExecutorService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

public class ExporterFactoryImpl extends AbstractServiceConfigurationFactory<ModbusExport>
{
    private final ScheduledExportedExecutorService executor;

    private final ServiceListenerHiveSource hiveSource;

    private final IoProcessor<NioSession> processor;

    public ExporterFactoryImpl ()
    {
        super ( FrameworkUtil.getBundle ( ExporterFactoryImpl.class ).getBundleContext () );

        this.executor = new ScheduledExportedExecutorService ( "org.eclipse.scada.da.server.exporter.modbus", 1 );

        this.processor = new SimpleIoProcessorPool<> ( NioProcessor.class );

        this.hiveSource = new ServiceListenerHiveSource ( FrameworkUtil.getBundle ( ExporterFactoryImpl.class ).getBundleContext (), this.executor );
        this.hiveSource.open ();
    }

    @Override
    public void dispose ()
    {
        super.dispose ();

        this.processor.dispose ();

        this.hiveSource.close ();
        this.executor.shutdown ();
    }

    @Override
    protected Entry<ModbusExport> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final ModbusExport service = new ModbusExport ( this.executor, this.processor, this.hiveSource );
        service.update ( parameters );
        return new Entry<ModbusExport> ( configurationId, service );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final ModbusExport service )
    {
        service.dispose ();
    }

    @Override
    protected Entry<ModbusExport> updateService ( final UserInformation userInformation, final String configurationId, final Entry<ModbusExport> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( parameters );
        return null;
    }

}
