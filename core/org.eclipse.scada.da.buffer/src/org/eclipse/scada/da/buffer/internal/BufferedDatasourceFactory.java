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
package org.eclipse.scada.da.buffer.internal;

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

public class BufferedDatasourceFactory extends AbstractServiceConfigurationFactory<BufferedDataSource>
{
    private final static Logger logger = LoggerFactory.getLogger ( BufferedDatasourceFactory.class );

    private final BundleContext context;

    private final ScheduledExecutorService executor;

    private final ObjectPoolTracker<DataSource> poolTracker;

    private final ObjectPoolImpl<BufferedDataSource> objectPool;

    private final ServiceRegistration<?> poolRegistration;

    private DataNodeTracker dataNodeTracker;

    public BufferedDatasourceFactory ( final BundleContext context, final ScheduledExecutorService executor ) throws InvalidSyntaxException
    {
        super ( context );
        this.context = context;
        this.executor = executor;

        this.objectPool = new ObjectPoolImpl<BufferedDataSource> ();
        this.poolRegistration = ObjectPoolHelper.registerObjectPool ( context, this.objectPool, BufferedDataSource.class );

        this.poolTracker = new ObjectPoolTracker<DataSource> ( context, DataSource.class.getName () );
        this.poolTracker.open ();

        this.dataNodeTracker = new DataNodeTracker ( context );
        this.dataNodeTracker.open ();
    }

    @Override
    public synchronized void dispose ()
    {
        this.poolRegistration.unregister ();
        this.objectPool.dispose ();
        this.poolTracker.close ();
        this.dataNodeTracker.close ();
        super.dispose ();
    }

    @Override
    protected Entry<BufferedDataSource> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        logger.debug ( "Creating new change counter source: {}", configurationId );

        final BufferedDataSourceImpl source = new BufferedDataSourceImpl ( this.context, this.executor, this.poolTracker, this.dataNodeTracker, configurationId, objectPool );
        source.update ( parameters );

        return new Entry<BufferedDataSource> ( configurationId, source );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final BufferedDataSource service )
    {
        logger.info ( "Disposing: {}", configurationId );

        this.objectPool.removeService ( configurationId, service );
        ( (BufferedDataSourceImpl)service ).dispose ();
    }

    @Override
    protected Entry<BufferedDataSource> updateService ( final UserInformation userInformation, final String configurationId, final Entry<BufferedDataSource> entry, final Map<String, String> parameters ) throws Exception
    {
        ( (BufferedDataSourceImpl)entry.getService () ).update ( parameters );
        return null;
    }
}
