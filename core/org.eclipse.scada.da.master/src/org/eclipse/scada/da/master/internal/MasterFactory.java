/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.master.internal;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.concurrent.ExecutorServiceExporterImpl;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class MasterFactory extends AbstractServiceConfigurationFactory<MasterItemImpl>
{
    public static final String ITEM_ID = "item.id";

    public static final String CONNECTION_ID = "connection.id";

    private final ExecutorService executor;

    private final ObjectPoolImpl<DataSource> dataSourcePool;

    private final ObjectPoolImpl<MasterItem> masterItemPool;

    private final ServiceRegistration<?> dataSourcePoolHandler;

    private final ServiceRegistration<?> masterItemPoolHandler;

    private final ObjectPoolTracker<DataSource> objectPoolTracker;

    private final ExecutorServiceExporterImpl executorExporter;

    public MasterFactory ( final BundleContext context, final ObjectPoolTracker<DataSource> dataSourceTracker )
    {
        super ( context );

        this.objectPoolTracker = dataSourceTracker;

        this.executor = new ThreadPoolExecutor ( 1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable> (), new NamedThreadFactory ( "MasterItemFactory" ) );
        this.executorExporter = new ExecutorServiceExporterImpl ( this.executor, "MasterItemFactory" );

        this.dataSourcePool = new ObjectPoolImpl<DataSource> ();
        this.dataSourcePoolHandler = ObjectPoolHelper.registerObjectPool ( context, this.dataSourcePool, DataSource.class );

        this.masterItemPool = new ObjectPoolImpl<MasterItem> ();
        this.masterItemPoolHandler = ObjectPoolHelper.registerObjectPool ( context, this.masterItemPool, MasterItem.class );
    }

    @Override
    protected Entry<MasterItemImpl> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final MasterItemImpl service = new MasterItemImpl ( this.executor, context, configurationId, this.objectPoolTracker );

        service.update ( parameters );

        final Dictionary<String, String> properties = new Hashtable<String, String> ();
        properties.put ( Constants.SERVICE_PID, configurationId );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "Master Data Item" );

        this.dataSourcePool.addService ( configurationId, service, properties );
        this.masterItemPool.addService ( configurationId, service, properties );

        return new Entry<MasterItemImpl> ( configurationId, service );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final MasterItemImpl service )
    {
        this.dataSourcePool.removeService ( configurationId, service );
        this.masterItemPool.removeService ( configurationId, service );
        service.dispose ();
    }

    @Override
    protected Entry<MasterItemImpl> updateService ( final UserInformation userInformation, final String configurationId, final Entry<MasterItemImpl> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( parameters );
        return null;
    }

    @Override
    public synchronized void dispose ()
    {
        super.dispose ();

        this.dataSourcePoolHandler.unregister ();
        this.masterItemPoolHandler.unregister ();

        this.dataSourcePool.dispose ();
        this.masterItemPool.dispose ();

        this.executorExporter.dispose ();

        this.executor.shutdown ();
    }

}
