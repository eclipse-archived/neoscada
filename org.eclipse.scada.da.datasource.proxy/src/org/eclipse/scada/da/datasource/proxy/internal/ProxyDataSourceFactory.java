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
package org.eclipse.scada.da.datasource.proxy.internal;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceRegistration;

public class ProxyDataSourceFactory extends AbstractServiceConfigurationFactory<ProxyDataSource>
{
    private final ExecutorService executor;

    private final ObjectPoolTracker<DataSource> poolTracker;

    private final ObjectPoolImpl<DataSource> objectPool;

    private final ServiceRegistration<?> poolRegistration;

    public ProxyDataSourceFactory ( final BundleContext context ) throws InvalidSyntaxException
    {
        super ( context );
        this.executor = Executors.newSingleThreadExecutor ( new NamedThreadFactory ( context.getBundle ().getSymbolicName () ) );

        this.objectPool = new ObjectPoolImpl<DataSource> ();
        this.poolRegistration = ObjectPoolHelper.registerObjectPool ( context, this.objectPool, DataSource.class );

        this.poolTracker = new ObjectPoolTracker<DataSource> ( context, DataSource.class.getName () );
        this.poolTracker.open ();
    }

    @Override
    public synchronized void dispose ()
    {
        this.poolRegistration.unregister ();
        this.objectPool.dispose ();

        this.poolTracker.close ();
        super.dispose ();
        this.executor.shutdown ();

    }

    @Override
    protected Entry<ProxyDataSource> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final ProxyDataSource dataSource = new ProxyDataSource ( this.poolTracker, this.executor );
        dataSource.update ( parameters );

        this.objectPool.addService ( configurationId, dataSource, null );

        return new Entry<ProxyDataSource> ( configurationId, dataSource );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final ProxyDataSource service )
    {
        this.objectPool.removeService ( configurationId, service );
        service.dispose ();
    }

    @Override
    protected Entry<ProxyDataSource> updateService ( final UserInformation userInformation, final String configurationId, final Entry<ProxyDataSource> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( parameters );
        return null;
    }
}
