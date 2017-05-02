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
package org.eclipse.scada.ae.server.monitor.proxy;

import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;

import org.eclipse.scada.ae.client.MonitorListener;
import org.eclipse.scada.ae.connection.provider.ConnectionService;
import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.core.connection.provider.ConnectionIdTracker;
import org.eclipse.scada.core.connection.provider.ConnectionTracker.Listener;
import org.eclipse.scada.core.data.SubscriptionState;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class RemoteMonitorQueryListener extends AbstractMonitorQueryListener implements Listener, MonitorListener
{

    private final static Logger logger = LoggerFactory.getLogger ( RemoteMonitorQueryListener.class );

    private final ConnectionIdTracker tracker;

    private ConnectionService connection;

    private final String monitorQueryId;

    public RemoteMonitorQueryListener ( final BundleContext context, final String connectionId, final String monitorQueryId, final ProxyMonitorQuery proxyMonitorQuery, final Lock lock )
    {
        super ( proxyMonitorQuery, lock, connectionId + "#" + monitorQueryId );
        logger.info ( "Creating new listener - connection: {}, query: {}", connectionId, monitorQueryId );

        this.monitorQueryId = monitorQueryId;

        this.tracker = new ConnectionIdTracker ( context, connectionId, this, ConnectionService.class );
        this.tracker.open ();
    }

    @Override
    public void dispose ()
    {
        this.tracker.close ();

        super.dispose ();
    }

    @Override
    public void setConnection ( final org.eclipse.scada.core.connection.provider.ConnectionService connectionService )
    {
        logger.debug ( "Setting connection: {}", connectionService );

        this.lock.lock ();
        try
        {
            if ( this.connection != null )
            {
                this.connection.getConnection ().setMonitorListener ( this.monitorQueryId, null );
                clearAll ();
            }

            this.connection = (ConnectionService)connectionService;

            if ( this.connection != null )
            {
                this.connection.getConnection ().setMonitorListener ( this.monitorQueryId, this );
            }
        }
        finally
        {
            this.lock.unlock ();
        }
    }

    @Override
    public void statusChanged ( final SubscriptionState state )
    {
        logger.info ( "State of {} changed: {}", this.info, state );
        switch ( state )
        {
            case DISCONNECTED:
                //$FALL-THROUGH$
            case GRANTED:
                clearAll ();
                break;
            case CONNECTED:
                break;
        }
    }

    @Override
    public void dataChanged ( final List<MonitorStatusInformation> addedOrUpdated, final Set<String> removed, final boolean full )
    {
        handleDataChanged ( addedOrUpdated, removed, full );
    }
}