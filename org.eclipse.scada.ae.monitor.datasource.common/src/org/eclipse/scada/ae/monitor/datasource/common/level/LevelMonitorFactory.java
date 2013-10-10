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
package org.eclipse.scada.ae.monitor.datasource.common.level;

import java.util.concurrent.Executor;

import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.monitor.MonitorService;
import org.eclipse.scada.ae.monitor.common.DataItemMonitor;
import org.eclipse.scada.ae.monitor.datasource.AbstractMonitorFactory;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.utils.osgi.pool.ManageableObjectPool;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;

import com.google.common.collect.Interner;

public class LevelMonitorFactory extends AbstractMonitorFactory
{

    public static final String FACTORY_ID = "org.eclipse.scada.ae.monitor.level";

    private final Executor executor;

    private final Interner<String> stringInterner;

    private final ObjectPoolTracker<MasterItem> poolTracker;

    public LevelMonitorFactory ( final BundleContext context, final ManageableObjectPool<MonitorService> servicePool, final EventProcessor eventProcessor, final Executor executor, final Interner<String> stringInterner, final ObjectPoolTracker<MasterItem> poolTracker )
    {
        super ( context, servicePool, eventProcessor );
        this.executor = executor;
        this.stringInterner = stringInterner;
        this.poolTracker = poolTracker;
    }

    @Override
    protected DataItemMonitor createInstance ( final String configurationId, final EventProcessor eventProcessor )
    {
        return new LevelMonitor ( this.context, this.executor, this.stringInterner, this.poolTracker, eventProcessor, configurationId, FACTORY_ID, "LEVEL" );
    }

}
