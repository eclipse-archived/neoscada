/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.server.http.monitor;

import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.monitor.MonitorService;
import org.eclipse.scada.ae.server.common.akn.AknHandler;
import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.lang.Pair;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventMonitorFactory extends AbstractServiceConfigurationFactory<EventMonitor> implements AknHandler, EventMonitorEvaluator
{
    public static final String FACTORY_ID = "ae.monitor.ae.event.external";

    private static final Logger logger = LoggerFactory.getLogger ( EventMonitorFactory.class );

    private final Executor executor;

    private final ObjectPoolImpl<MonitorService> servicePool;

    private final EventProcessor eventProcessor;

    private final ConcurrentMap<String, EventMonitor> monitors = new ConcurrentHashMap<String, EventMonitor> ();

    public EventMonitorFactory ( final BundleContext context, final Executor executor, final ObjectPoolImpl<MonitorService> servicePool, final EventProcessor eventProcessor )
    {
        super ( context );
        this.executor = executor;
        this.servicePool = servicePool;
        this.eventProcessor = eventProcessor;
    }

    @Override
    protected Entry<EventMonitor> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final EventMonitor instance = new EventMonitorImpl ( context, this.executor, this.eventProcessor, configurationId );

        instance.update ( userInformation, parameters );

        this.monitors.put ( configurationId, instance );

        final Dictionary<String, String> properties = new Hashtable<String, String> ();
        this.servicePool.addService ( configurationId, instance, properties );

        return new Entry<EventMonitor> ( configurationId, instance );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final EventMonitor service )
    {
        this.monitors.remove ( configurationId );
        this.servicePool.removeService ( configurationId, service );
        service.dispose ();
    }

    @Override
    protected Entry<EventMonitor> updateService ( final UserInformation userInformation, final String configurationId, final AbstractServiceConfigurationFactory.Entry<EventMonitor> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( userInformation, parameters );
        return null;
    }

    @Override
    public boolean acknowledge ( final String monitorId, final OperationParameters operationParameters, final Date aknTimestamp )
    {
        logger.debug ( "Try to process ACK: {}", monitorId );

        final EventMonitor monitor = this.monitors.get ( monitorId );
        if ( monitor != null )
        {
            monitor.akn ( operationParameters == null ? null : operationParameters.getUserInformation (), aknTimestamp );
            return true;
        }

        return false;
    }

    @Override
    public Event evaluate ( final Event event )
    {
        for ( final EventMonitor monitor : this.monitors.values () )
        {
            final Pair<Boolean, Event> result = monitor.evaluate ( event );
            if ( result.first )
            {
                return result.second;
            }
        }
        return event;
    }
}