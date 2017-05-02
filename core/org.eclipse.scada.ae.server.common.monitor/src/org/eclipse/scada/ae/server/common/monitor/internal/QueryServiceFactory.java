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
package org.eclipse.scada.ae.server.common.monitor.internal;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.ae.monitor.MonitorService;
import org.eclipse.scada.ae.server.common.monitor.MonitorQuery;
import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

public class QueryServiceFactory extends AbstractServiceConfigurationFactory<BundleMonitorQuery>
{
    public final static String FACTORY_ID = "ae.monitor.query";

    private final ObjectPoolTracker<MonitorService> poolTracker;

    private final Executor executor;

    public QueryServiceFactory ( final Executor executor, final BundleContext context, final ObjectPoolTracker<MonitorService> poolTracker )
    {
        super ( context );
        this.executor = executor;
        this.poolTracker = poolTracker;
    }

    @Override
    protected Entry<BundleMonitorQuery> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final BundleMonitorQuery query = new BundleMonitorQuery ( this.executor, context, this.poolTracker );
        query.update ( parameters );

        final Dictionary<String, String> properties = new Hashtable<String, String> ();
        properties.put ( Constants.SERVICE_PID, configurationId );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );

        return new Entry<BundleMonitorQuery> ( configurationId, query, context.registerService ( MonitorQuery.class, query, properties ) );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final BundleMonitorQuery service )
    {
        service.dispose ();
    }

    @Override
    protected Entry<BundleMonitorQuery> updateService ( final UserInformation userInformation, final String configurationId, final Entry<BundleMonitorQuery> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( parameters );
        return entry;
    }

}
