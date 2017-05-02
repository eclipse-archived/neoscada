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
package org.eclipse.scada.da.datasource.totalizer;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.buffer.BufferedDataSource;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.ds.DataNodeTracker;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TotalizerDataSourceFactory extends AbstractServiceConfigurationFactory<TotalizerDataSource>
{
    private final static Logger logger = LoggerFactory.getLogger ( TotalizerDataSourceFactory.class );

    private final ScheduledExecutorService executor;

    private final ObjectPoolTracker<BufferedDataSource> poolTracker;

    private final ObjectPoolImpl<DataSource> objectPool;

    private final ServiceRegistration<?> poolRegistration;

    private final DataNodeTracker dataNodeTracker;

    public TotalizerDataSourceFactory ( final BundleContext context, final ScheduledExecutorService executor ) throws InvalidSyntaxException
    {
        super ( context );
        this.executor = executor;

        this.objectPool = new ObjectPoolImpl<DataSource> ();
        this.poolRegistration = ObjectPoolHelper.registerObjectPool ( context, this.objectPool, DataSource.class );

        this.poolTracker = new ObjectPoolTracker<BufferedDataSource> ( context, BufferedDataSource.class.getName () );
        this.poolTracker.open ();

        this.dataNodeTracker = new DataNodeTracker ( context );
        this.dataNodeTracker.open ();
    }

    @Override
    public synchronized void dispose ()
    {
        this.dataNodeTracker.close ();
        this.poolRegistration.unregister ();
        this.objectPool.dispose ();
        this.poolTracker.close ();
        super.dispose ();
    }

    @Override
    protected Entry<TotalizerDataSource> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        logger.debug ( "Creating new totalizer source: {}", configurationId );

        final TotalizerDataSource source = new TotalizerDataSource ( this.executor, this.poolTracker, this.dataNodeTracker );
        source.update ( parameters );

        final Dictionary<String, String> properties = new Hashtable<String, String> ();
        properties.put ( DataSource.DATA_SOURCE_ID, configurationId );

        this.objectPool.addService ( configurationId, source, properties );

        return new Entry<TotalizerDataSource> ( configurationId, source );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final TotalizerDataSource service )
    {
        logger.info ( "Disposing: {}", configurationId );

        this.objectPool.removeService ( configurationId, service );
        service.dispose ();
    }

    @Override
    protected Entry<TotalizerDataSource> updateService ( final UserInformation userInformation, final String configurationId, final Entry<TotalizerDataSource> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( parameters );
        return null;
    }
}
