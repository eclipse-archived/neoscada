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
package org.eclipse.scada.ae.monitor.script;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.monitor.MonitorService;
import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import com.google.common.collect.Interner;

public class ScriptMonitorFactory extends AbstractServiceConfigurationFactory<ScriptMonitor>
{

    public static final String FACTORY_ID = "org.eclipse.scada.ae.monitor.script"; //$NON-NLS-1$

    private final Interner<String> stringInterner;

    private final Executor executor;

    private final EventProcessor eventProcessor;

    private final ObjectPoolTracker<DataSource> dataSourcePoolTracker;

    private final ObjectPoolTracker<MasterItem> masterItemPoolTracker;

    private final ServiceTracker<ConfigurationAdministrator, ConfigurationAdministrator> caTracker;

    private final ObjectPoolImpl<MonitorService> monitorServicePool;

    public ScriptMonitorFactory ( final BundleContext context, final Executor executor, final Interner<String> stringInterner, final EventProcessor eventProcessor, final ObjectPoolTracker<DataSource> dataSourcePoolTracker, final ObjectPoolTracker<MasterItem> masterItemPoolTracker, final ServiceTracker<ConfigurationAdministrator, ConfigurationAdministrator> caTracker, final ObjectPoolImpl<MonitorService> monitorServicePool )
    {
        super ( context );
        this.executor = executor;
        this.stringInterner = stringInterner;
        this.eventProcessor = eventProcessor;
        this.dataSourcePoolTracker = dataSourcePoolTracker;
        this.masterItemPoolTracker = masterItemPoolTracker;
        this.caTracker = caTracker;
        this.monitorServicePool = monitorServicePool;
    }

    @Override
    protected Entry<ScriptMonitor> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final ScriptMonitor service = new ScriptMonitor ( configurationId, FACTORY_ID, this.executor, context, this.stringInterner, this.eventProcessor, this.dataSourcePoolTracker, this.masterItemPoolTracker, this.caTracker );

        service.update ( userInformation, parameters );
        this.monitorServicePool.addService ( configurationId, service, new Hashtable<String, String> ( 0 ) );

        return new Entry<ScriptMonitor> ( configurationId, service );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final ScriptMonitor service )
    {
        this.monitorServicePool.removeService ( configurationId, service );
        service.dispose ();
    }

    @Override
    protected Entry<ScriptMonitor> updateService ( final UserInformation userInformation, final String configurationId, final Entry<ScriptMonitor> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( userInformation, parameters );
        return null;
    }

}
