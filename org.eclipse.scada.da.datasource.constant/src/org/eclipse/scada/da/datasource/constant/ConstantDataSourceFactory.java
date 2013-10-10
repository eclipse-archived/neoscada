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
package org.eclipse.scada.da.datasource.constant;

import java.util.Map;
import java.util.concurrent.ExecutorService;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ConstantDataSourceFactory extends AbstractServiceConfigurationFactory<ConstantDataSource>
{

    private final ExecutorService executor;

    private final ObjectPoolImpl<DataSource> objectPool;

    private final ServiceRegistration<?> poolRegistration;

    public ConstantDataSourceFactory ( final BundleContext context, final ExecutorService executor )
    {
        super ( context );
        this.executor = executor;

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
    protected Entry<ConstantDataSource> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final ConstantDataSource service = new ConstantDataSource ( this.executor );
        service.update ( parameters );

        this.objectPool.addService ( configurationId, service, null );

        return new Entry<ConstantDataSource> ( configurationId, service );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final ConstantDataSource service )
    {
        this.objectPool.removeService ( configurationId, service );
    }

    @Override
    protected Entry<ConstantDataSource> updateService ( final UserInformation userInformation, final String configurationId, final org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory.Entry<ConstantDataSource> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( parameters );
        return null;
    }

}
