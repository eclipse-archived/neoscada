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
package org.eclipse.scada.da.datasource.delta;

import java.util.Map;
import java.util.concurrent.ExecutorService;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class DeltaDataSourceFactory extends AbstractServiceConfigurationFactory<DeltaDataSource>
{

    private final ExecutorService executor;

    private final ObjectPoolImpl<DataSource> objectPool;

    private final ServiceRegistration<?> poolRegistration;

    private final ObjectPoolTracker<DataSource> tracker;

    public DeltaDataSourceFactory ( final BundleContext context, final ExecutorService executor, final ObjectPoolTracker<DataSource> tracker )
    {
        super ( context );
        this.executor = executor;
        this.tracker = tracker;

        this.objectPool = new ObjectPoolImpl<DataSource> ();
        this.poolRegistration = ObjectPoolHelper.registerObjectPool ( context, this.objectPool, DataSource.class );
    }

    @Override
    public synchronized void dispose ()
    {
        this.poolRegistration.unregister ();
        this.objectPool.dispose ();
        super.dispose ();
    }

    @Override
    protected Entry<DeltaDataSource> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final DeltaDataSource service = new DeltaDataSource ( this.executor, this.tracker );
        service.update ( parameters );

        this.objectPool.addService ( configurationId, service, null );

        return new Entry<DeltaDataSource> ( configurationId, service );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final DeltaDataSource service )
    {
        this.objectPool.removeService ( configurationId, service );
    }

    @Override
    protected Entry<DeltaDataSource> updateService ( final UserInformation userInformation, final String configurationId, final org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory.Entry<DeltaDataSource> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( parameters );
        return null;
    }

}
