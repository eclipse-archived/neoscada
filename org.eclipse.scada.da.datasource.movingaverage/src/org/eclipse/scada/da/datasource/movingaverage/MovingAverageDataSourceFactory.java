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
package org.eclipse.scada.da.datasource.movingaverage;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MovingAverageDataSourceFactory extends AbstractServiceConfigurationFactory<MovingAverageDataSource>
{
    private final static Logger logger = LoggerFactory.getLogger ( MovingAverageDataSourceFactory.class );

    private final ExecutorService executor;

    private final ScheduledExecutorService scheduler;

    private final ObjectPoolTracker<DataSource> poolTracker;

    private final ObjectPoolImpl<MovingAverageDataSource> avgObjectPool;

    private final ObjectPoolImpl<DataSource> dsObjectPool;

    private final ServiceRegistration<?> avgPoolRegistration;

    private final ServiceRegistration<?> dsPoolRegistration;

    public MovingAverageDataSourceFactory ( final BundleContext context, final ExecutorService executor, final ScheduledExecutorService scheduler ) throws InvalidSyntaxException
    {
        super ( context );
        this.executor = executor;
        this.scheduler = scheduler;

        this.avgObjectPool = new ObjectPoolImpl<MovingAverageDataSource> ();
        this.avgPoolRegistration = ObjectPoolHelper.registerObjectPool ( context, this.avgObjectPool, MovingAverageDataSource.class );

        this.dsObjectPool = new ObjectPoolImpl<DataSource> ();
        this.dsPoolRegistration = ObjectPoolHelper.registerObjectPool ( context, this.dsObjectPool, DataSource.class );

        this.poolTracker = new ObjectPoolTracker<DataSource> ( context, DataSource.class );
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
    protected Entry<MovingAverageDataSource> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        logger.debug ( "Creating new average source: {}", configurationId );

        final MovingAverageDataSource avg = new MovingAverageDataSource ( configurationId, this.executor, this.scheduler, this.poolTracker, this.dsObjectPool );
        avg.update ( parameters );

        final Dictionary<String, String> properties = new Hashtable<String, String> ( 1 );
        properties.put ( DataSource.DATA_SOURCE_ID, configurationId );

        this.avgObjectPool.addService ( configurationId, avg, properties );

        return new Entry<MovingAverageDataSource> ( configurationId, avg );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String id, final MovingAverageDataSource service )
    {
        logger.info ( "Disposing: {}", id );

        this.avgObjectPool.removeService ( id, service );

        service.dispose ();
    }

    @Override
    protected Entry<MovingAverageDataSource> updateService ( final UserInformation userInformation, final String configurationId, final Entry<MovingAverageDataSource> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( parameters );
        return null;
    }

}
