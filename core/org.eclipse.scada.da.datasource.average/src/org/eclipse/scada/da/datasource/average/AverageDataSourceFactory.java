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
package org.eclipse.scada.da.datasource.average;

import java.util.Map;
import java.util.concurrent.ExecutorService;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceRegistration;

public class AverageDataSourceFactory extends AbstractServiceConfigurationFactory<AverageDataSource>
{
    private final ExecutorService executor;

    private final ObjectPoolTracker<DataSource> poolTracker;

    private final ObjectPoolImpl<AverageDataSource> avgObjectPool;

    private final ObjectPoolImpl<DataSource> dsObjectPool;

    private final ServiceRegistration<?> avgPoolRegistration;

    private final ServiceRegistration<?> dsPoolRegistration;

    public AverageDataSourceFactory ( final BundleContext context, final ExecutorService executor ) throws InvalidSyntaxException
    {
        super ( context );
        this.executor = executor;

        this.avgObjectPool = new ObjectPoolImpl<AverageDataSource> ();
        this.avgPoolRegistration = ObjectPoolHelper.registerObjectPool ( context, this.avgObjectPool, AverageDataSource.class );

        this.dsObjectPool = new ObjectPoolImpl<DataSource> ();
        this.dsPoolRegistration = ObjectPoolHelper.registerObjectPool ( context, this.dsObjectPool, DataSource.class );

        this.poolTracker = new ObjectPoolTracker<DataSource> ( context, DataSource.class.getName () );
        this.poolTracker.open ();
    }

    @Override
    public synchronized void dispose ()
    {
        this.dsPoolRegistration.unregister ();
        this.avgPoolRegistration.unregister ();

        this.dsObjectPool.dispose ();
        this.avgObjectPool.dispose ();

        this.poolTracker.close ();
        super.dispose ();
    }

    @Override
    protected Entry<AverageDataSource> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final AverageDataSource dataSource = new AverageDataSource ( configurationId, this.poolTracker, this.executor, this.dsObjectPool );
        dataSource.update ( parameters );

        this.avgObjectPool.addService ( configurationId, dataSource, null );

        return new Entry<AverageDataSource> ( configurationId, dataSource );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final AverageDataSource service )
    {
        this.avgObjectPool.removeService ( configurationId, service );
        service.dispose ();
    }

    @Override
    protected Entry<AverageDataSource> updateService ( final UserInformation userInformation, final String configurationId, final Entry<AverageDataSource> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( parameters );
        return null;
    }
}
