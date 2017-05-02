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
package org.eclipse.scada.ae.server.info.internal;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.ae.monitor.MonitorService;
import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

public class InfoServiceFactory extends AbstractServiceConfigurationFactory<InfoService>
{
    public final static String FACTORY_ID = "ae.server.info";

    private final ObjectPoolImpl<DataSource> dataSourcePool;

    private final Executor executor;

    private final ObjectPoolTracker<MonitorService> monitorPoolTracker;

    public InfoServiceFactory ( final BundleContext context, final Executor executor, final ObjectPoolTracker<MonitorService> monitorPoolTracker, final ObjectPoolImpl<DataSource> dataSourcePool )
    {
        super ( context );
        this.executor = executor;
        this.monitorPoolTracker = monitorPoolTracker;
        this.dataSourcePool = dataSourcePool;
    }

    @Override
    protected Entry<InfoService> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final InfoService query = new InfoService ( context, this.executor, this.monitorPoolTracker, this.dataSourcePool );
        query.update ( parameters );

        final Dictionary<String, String> properties = new Hashtable<String, String> ();
        properties.put ( Constants.SERVICE_PID, configurationId );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );

        return new Entry<InfoService> ( configurationId, query, context.registerService ( InfoService.class.getName (), query, properties ) );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final InfoService service )
    {
        service.dispose ();
    }

    @Override
    protected Entry<InfoService> updateService ( final UserInformation userInformation, final String configurationId, final Entry<InfoService> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( parameters );
        return entry;
    }
}
