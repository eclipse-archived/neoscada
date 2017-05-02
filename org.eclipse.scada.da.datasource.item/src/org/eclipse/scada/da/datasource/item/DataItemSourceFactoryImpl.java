/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.datasource.item;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class DataItemSourceFactoryImpl extends AbstractServiceConfigurationFactory<DataItemSourceImpl>
{
    public static final String FACTORY_ID = "da.datasource.dataitem";

    private final ObjectPoolImpl<DataSource> objectPool;

    private final Executor executor;

    private final ServiceRegistration<?> objectPoolHandler;

    public DataItemSourceFactoryImpl ( final BundleContext context, final Executor executor )
    {
        super ( context );

        this.executor = executor;

        this.objectPool = new ObjectPoolImpl<DataSource> ();
        this.objectPoolHandler = ObjectPoolHelper.registerObjectPool ( context, this.objectPool, DataSource.class );
    }

    @Override
    protected Entry<DataItemSourceImpl> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final DataItemSourceImpl service = new DataItemSourceImpl ( context, this.executor );

        service.update ( parameters );

        final Dictionary<?, ?> properties = new Hashtable<String, String> ( 1 );
        this.objectPool.addService ( configurationId, service, properties );

        return new Entry<DataItemSourceImpl> ( configurationId, service );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final DataItemSourceImpl service )
    {
        this.objectPool.removeService ( configurationId, service );
        service.dispose ();
    }

    @Override
    protected Entry<DataItemSourceImpl> updateService ( final UserInformation userInformation, final String configurationId, final Entry<DataItemSourceImpl> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( parameters );
        return null;
    }

    @Override
    public synchronized void dispose ()
    {
        this.objectPoolHandler.unregister ();

        this.objectPool.dispose ();

        super.dispose ();
    }

}
