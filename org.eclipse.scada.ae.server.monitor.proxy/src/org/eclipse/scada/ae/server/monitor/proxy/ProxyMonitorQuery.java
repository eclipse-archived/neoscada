/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.server.monitor.proxy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.ae.server.common.monitor.MonitorQuery;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.sec.UserInformation;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProxyMonitorQuery extends MonitorQuery
{

    private final static Logger logger = LoggerFactory.getLogger ( ProxyMonitorQuery.class );

    private final Map<String, RemoteMonitorQueryListener> remoteListenerMap = new HashMap<String, RemoteMonitorQueryListener> ();

    private final Map<String, LocalMonitorQueryListener> localListenerMap = new HashMap<String, LocalMonitorQueryListener> ();

    private final BundleContext context;

    private final Lock lock = new ReentrantLock ();

    public ProxyMonitorQuery ( final BundleContext context, final Executor executor )
    {
        super ( executor );
        this.context = context;
    }

    @Override
    public synchronized void dispose ()
    {
        this.lock.lock ();
        try
        {
            for ( final RemoteMonitorQueryListener listener : this.remoteListenerMap.values () )
            {
                listener.dispose ();
            }
            this.remoteListenerMap.clear ();
            for ( final LocalMonitorQueryListener listener : this.localListenerMap.values () )
            {
                listener.dispose ();
            }
            this.localListenerMap.clear ();
        }
        finally
        {
            this.lock.unlock ();
        }

        super.dispose ();
    }

    public void update ( final UserInformation userInformation, final Map<String, String> parameters ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        final Set<String> remoteQueryStrings = new HashSet<String> ();
        for ( final Map.Entry<String, String> query : cfg.getPrefixed ( "remote.queries." ).entrySet () )
        {
            remoteQueryStrings.add ( query.getValue () );
        }

        final Set<String> localQueryStrings = new HashSet<String> ();
        for ( final Map.Entry<String, String> query : cfg.getPrefixed ( "local.queries." ).entrySet () )
        {
            localQueryStrings.add ( query.getValue () );
        }

        this.lock.lock ();
        try
        {
            setRemoteQueries ( remoteQueryStrings );
            setLocalQueries ( localQueryStrings );
        }
        finally
        {
            this.lock.unlock ();
        }
    }

    private void setLocalQueries ( final Set<String> queryStrings ) throws InvalidSyntaxException
    {
        // remove all which are missing
        final Set<String> current = new HashSet<String> ( this.localListenerMap.keySet () );
        current.removeAll ( queryStrings );
        for ( final String queryString : current )
        {
            final LocalMonitorQueryListener queryListener = this.localListenerMap.remove ( queryString );
            if ( queryListener != null )
            {
                logger.info ( "Disposing query: {}", queryString );
                queryListener.dispose ();
            }
        }

        // now add the new ones
        for ( final String queryString : queryStrings )
        {
            logger.info ( "Adding query: {}", queryString );
            final LocalMonitorQueryListener MonitorQueryListener = createLocalQueryListener ( queryString );
            this.localListenerMap.put ( queryString, MonitorQueryListener );
        }
    }

    private void setRemoteQueries ( final Set<String> queryStrings )
    {
        // remove all which are missing
        final Set<String> current = new HashSet<String> ( this.remoteListenerMap.keySet () );
        current.removeAll ( queryStrings );
        for ( final String queryString : current )
        {
            final RemoteMonitorQueryListener queryListener = this.remoteListenerMap.remove ( queryString );
            if ( queryListener != null )
            {
                logger.info ( "Disposing query: {}", queryString );
                queryListener.dispose ();
            }
        }

        // now add the new ones
        for ( final String queryString : queryStrings )
        {
            logger.info ( "Adding query: {}", queryString );
            final String[] tok = queryString.split ( "#", 2 );
            final RemoteMonitorQueryListener MonitorQueryListener = createQueryListener ( tok[0], tok[1] );
            this.remoteListenerMap.put ( queryString, MonitorQueryListener );
        }
    }

    private RemoteMonitorQueryListener createQueryListener ( final String connectionId, final String monitorQueryId )
    {
        return new RemoteMonitorQueryListener ( this.context, connectionId, monitorQueryId, this, this.lock );
    }

    private LocalMonitorQueryListener createLocalQueryListener ( final String monitorQueryId ) throws InvalidSyntaxException
    {
        return new LocalMonitorQueryListener ( this.context, monitorQueryId, this, this.lock );
    }

    void handleDataUpdate ( final List<MonitorStatusInformation> addedOrUpdated, final Set<String> removed )
    {
        logger.debug ( "handleDataUpdate - added: @{}, removed: @{}", new Object[] { addedOrUpdated == null ? -1 : addedOrUpdated.size (), removed == null ? -1 : removed.size () } );
        // we may only send updates
        updateData ( addedOrUpdated, removed, false );
    }
}
