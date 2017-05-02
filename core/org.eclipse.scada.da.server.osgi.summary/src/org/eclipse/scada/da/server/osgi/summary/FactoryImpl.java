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
package org.eclipse.scada.da.server.osgi.summary;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ManageableObjectPool;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;

public class FactoryImpl extends AbstractServiceConfigurationFactory<AttributeDataSourceSummarizer>
{

    public static final String FACTORY_ID = "org.eclipse.scada.da.server.osgi.summary.attribute";

    private final Executor executor;

    private final ObjectPoolTracker<DataSource> tracker;

    private final ManageableObjectPool<DataSource> pool;

    public FactoryImpl ( final Executor executor, final BundleContext context, final ObjectPoolTracker<DataSource> tracker, final ManageableObjectPool<DataSource> pool )
    {
        super ( context );
        this.executor = executor;
        this.tracker = tracker;
        this.pool = pool;
    }

    @Override
    protected Entry<AttributeDataSourceSummarizer> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final AttributeDataSourceSummarizer service = new AttributeDataSourceSummarizer ( this.executor, this.tracker );
        service.update ( parameters );

        final Dictionary<String, String> properties = new Hashtable<String, String> ();
        properties.put ( DataSource.DATA_SOURCE_ID, configurationId );
        this.pool.addService ( configurationId, service, properties );
        return new Entry<AttributeDataSourceSummarizer> ( configurationId, service );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final AttributeDataSourceSummarizer service )
    {
        this.pool.removeService ( configurationId, service );
        service.dispose ();
    }

    @Override
    protected Entry<AttributeDataSourceSummarizer> updateService ( final UserInformation userInformation, final String configurationId, final Entry<AttributeDataSourceSummarizer> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( parameters );
        return null;
    }

}
