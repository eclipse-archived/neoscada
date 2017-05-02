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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.ae.monitor.MonitorListener;
import org.eclipse.scada.ae.monitor.MonitorService;
import org.eclipse.scada.ae.server.common.monitor.MonitorQuery;
import org.eclipse.scada.utils.filter.Filter;
import org.eclipse.scada.utils.filter.FilterParser;
import org.eclipse.scada.utils.filter.bean.BeanMatcher;
import org.eclipse.scada.utils.osgi.pool.AllObjectPoolServiceTracker;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolListener;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BundleMonitorQuery extends MonitorQuery implements MonitorListener
{

    private final static Logger logger = LoggerFactory.getLogger ( BundleMonitorQuery.class );

    private final Set<MonitorService> services = new HashSet<MonitorService> ();

    private final AllObjectPoolServiceTracker<MonitorService> tracker;

    private final Map<String, MonitorStatusInformation> cachedData = new HashMap<String, MonitorStatusInformation> ();

    private Filter filter = Filter.EMPTY;

    public BundleMonitorQuery ( final Executor executor, final BundleContext context, final ObjectPoolTracker<MonitorService> poolTracker ) throws InvalidSyntaxException
    {
        super ( executor );
        this.tracker = new AllObjectPoolServiceTracker<MonitorService> ( poolTracker, new ObjectPoolListener<MonitorService> () {

            @Override
            public void serviceRemoved ( final MonitorService service, final Dictionary<?, ?> properties )
            {
                BundleMonitorQuery.this.handleRemoved ( service );
            }

            @Override
            public void serviceModified ( final MonitorService service, final Dictionary<?, ?> properties )
            {
            }

            @Override
            public void serviceAdded ( final MonitorService service, final Dictionary<?, ?> properties )
            {
                BundleMonitorQuery.this.handleAdded ( service );
            }
        } );
        this.tracker.open ();
    }

    protected synchronized void handleAdded ( final MonitorService service )
    {
        if ( this.services.add ( service ) )
        {
            service.addStatusListener ( this );
        }
    }

    protected synchronized void handleRemoved ( final MonitorService service )
    {
        if ( this.services.remove ( service ) )
        {
            service.removeStatusListener ( this );

            this.cachedData.remove ( service.getId () );
            updateData ( null, Collections.singleton ( service.getId () ), false );
        }
    }

    public void update ( final Map<String, String> parameters )
    {
        final String filterStr = parameters.get ( "filter" );

        logger.debug ( "Setting new filter: {}", filterStr );

        final FilterParser parser = new FilterParser ( filterStr );
        setFilter ( parser.getFilter () );
    }

    /**
     * Sets the new filter and actualizes the data set
     */
    protected synchronized void setFilter ( final Filter filter )
    {
        logger.debug ( "SetFilter: {}", filter );

        if ( filter == null )
        {
            this.filter = Filter.EMPTY;
        }
        else
        {
            this.filter = filter;
        }

        setData ( getFiltered () );
    }

    protected synchronized MonitorStatusInformation[] getFiltered ()
    {
        final List<MonitorStatusInformation> result = new ArrayList<MonitorStatusInformation> ();

        for ( final MonitorStatusInformation ci : this.cachedData.values () )
        {
            if ( matchesFilter ( ci ) )
            {
                result.add ( ci );
            }
        }

        return result.toArray ( new MonitorStatusInformation[result.size ()] );
    }

    private boolean matchesFilter ( final MonitorStatusInformation status )
    {
        return BeanMatcher.matches ( this.filter, status, true, null );
    }

    @Override
    public synchronized void dispose ()
    {
        super.dispose ();
        for ( final MonitorService service : this.services )
        {
            service.removeStatusListener ( this );
        }

        this.services.clear ();
        this.tracker.close ();
    }

    @Override
    public synchronized void statusChanged ( final MonitorStatusInformation status )
    {
        logger.debug ( "Status changed: {}", status );

        this.cachedData.put ( status.getId (), status );

        if ( matchesFilter ( status ) )
        {
            updateData ( Arrays.asList ( status ), null, false );
        }
        else
        {
            updateData ( null, Collections.singleton ( status.getId () ), false );
        }
    }
}
