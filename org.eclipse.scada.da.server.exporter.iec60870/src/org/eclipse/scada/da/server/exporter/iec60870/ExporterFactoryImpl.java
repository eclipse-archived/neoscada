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
package org.eclipse.scada.da.server.exporter.iec60870;

import java.util.Map;

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

public class ExporterFactoryImpl extends AbstractServiceConfigurationFactory<IecExport>
{

    private final ScheduledExportedExecutorService executor;

    private final ServiceListenerHiveSource hiveSource;

    private final ObjectPoolImpl<DataItem> itemPool;

    private final ServiceRegistration<?> itemPoolHandle;

    public ExporterFactoryImpl ()
    {
        super ( FrameworkUtil.getBundle ( ExporterFactoryImpl.class ).getBundleContext () );

        this.executor = new ScheduledExportedExecutorService ( FrameworkUtil.getBundle ( ExporterFactoryImpl.class ).getSymbolicName (), 1 );

        this.hiveSource = new ServiceListenerHiveSource ( FrameworkUtil.getBundle ( ExporterFactoryImpl.class ).getBundleContext (), this.executor );
        this.hiveSource.open ();

        this.itemPool = new ObjectPoolImpl<> ();
        this.itemPoolHandle = ObjectPoolHelper.registerObjectPool ( FrameworkUtil.getBundle ( ExporterFactoryImpl.class ).getBundleContext (), this.itemPool, DataItem.class );
    }

    @Override
    protected Entry<IecExport> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final IecExport service = new IecExport ( configurationId, parameters, this.executor, this.itemPool, this.hiveSource );
        return new Entry<IecExport> ( configurationId, service );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final IecExport service )
    {
        service.dispose ();
    }

    @Override
    protected Entry<IecExport> updateService ( final UserInformation userInformation, final String configurationId, final Entry<IecExport> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( parameters );
        return null; // no change
    }

    @Override
    public synchronized void dispose ()
    {
        super.dispose ();

        this.itemPoolHandle.unregister ();
        this.itemPool.dispose ();

        this.hiveSource.close ();
        this.executor.shutdown ();
    }

}
