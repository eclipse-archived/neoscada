/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.modbus.internal;

import java.util.Map;

import org.apache.mina.core.service.IoProcessor;
import org.apache.mina.core.service.SimpleIoProcessorPool;
import org.apache.mina.transport.socket.nio.NioProcessor;
import org.apache.mina.transport.socket.nio.NioSession;
import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.exporter.common.ServiceListenerHiveSource;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.concurrent.ScheduledExportedExecutorService;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExporterFactoryImpl extends AbstractServiceConfigurationFactory<ModbusExportImpl>
{
    private final static Logger logger = LoggerFactory.getLogger ( ExporterFactoryImpl.class );

    private final ScheduledExportedExecutorService executor;

    private final ServiceListenerHiveSource hiveSource;

    private final IoProcessor<NioSession> processor;

    private final ObjectPoolImpl<DataItem> itemPool;

    private final ServiceRegistration<?> itemPoolHandler;

    public ExporterFactoryImpl ()
    {
        super ( FrameworkUtil.getBundle ( ExporterFactoryImpl.class ).getBundleContext () );

        this.executor = new ScheduledExportedExecutorService ( FrameworkUtil.getBundle ( ExporterFactoryImpl.class ).getSymbolicName (), 1 );

        this.processor = new SimpleIoProcessorPool<> ( NioProcessor.class );

        this.hiveSource = new ServiceListenerHiveSource ( FrameworkUtil.getBundle ( ExporterFactoryImpl.class ).getBundleContext (), this.executor );
        this.hiveSource.open ();

        this.itemPool = new ObjectPoolImpl<> ();
        this.itemPoolHandler = ObjectPoolHelper.registerObjectPool ( FrameworkUtil.getBundle ( ExporterFactoryImpl.class ).getBundleContext (), this.itemPool, DataItem.class );
    }

    @Override
    public void dispose ()
    {
        logger.info ( "Disposing" ); //$NON-NLS-1$

        this.itemPoolHandler.unregister ();

        super.dispose ();

        this.itemPool.dispose ();
        this.processor.dispose ();
        this.hiveSource.close ();
        this.executor.shutdown ();
    }

    @Override
    protected Entry<ModbusExportImpl> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final ModbusExportImpl service = new ModbusExportImpl ( configurationId, this.executor, this.processor, this.hiveSource, this.itemPool );
        service.update ( parameters );
        return new Entry<> ( configurationId, service );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final ModbusExportImpl service )
    {
        service.dispose ();
    }

    @Override
    protected Entry<ModbusExportImpl> updateService ( final UserInformation userInformation, final String configurationId, final Entry<ModbusExportImpl> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( parameters );
        return null;
    }

}
