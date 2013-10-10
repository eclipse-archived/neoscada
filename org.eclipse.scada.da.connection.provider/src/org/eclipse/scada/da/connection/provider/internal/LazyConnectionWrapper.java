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
package org.eclipse.scada.da.connection.provider.internal;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.ConnectionStateListener;
import org.eclipse.scada.core.client.NoConnectionException;
import org.eclipse.scada.core.client.PrivilegeListener;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.core.info.StatisticEntry;
import org.eclipse.scada.core.info.StatisticsImpl;
import org.eclipse.scada.core.info.StatisticsProvider;
import org.eclipse.scada.da.client.BrowseOperationCallback;
import org.eclipse.scada.da.client.Connection;
import org.eclipse.scada.da.client.FolderListener;
import org.eclipse.scada.da.client.ItemUpdateListener;
import org.eclipse.scada.da.client.WriteAttributeOperationCallback;
import org.eclipse.scada.da.client.WriteOperationCallback;
import org.eclipse.scada.da.core.Location;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.sec.callback.CallbackFactory;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public abstract class LazyConnectionWrapper implements Connection, StatisticsProvider
{
    private static final Object STATS_REQUEST_OPEN = new Object ();

    private static final Object STATS_ITEM_SUBSCRIPTIONS = new Object ();

    private static final Object STATS_LINGERING_CLOSE = new Object ();

    private final Set<String> subscribedItems = new HashSet<String> ();

    private final Connection connection;

    private final StatisticsImpl statistics = new StatisticsImpl ();

    private final Integer lingeringTimeout;

    private long disconnectTimestamp;

    private final Runnable performConnectionCheck = new Runnable () {
        @Override
        public void run ()
        {
            synchronized ( LazyConnectionWrapper.this )
            {
                checkConnection ();
            }
        }
    };

    public LazyConnectionWrapper ( final Connection connection, final Integer lingeringTimeout )
    {
        this.connection = connection;
        this.lingeringTimeout = lingeringTimeout;
        this.statistics.setLabel ( STATS_REQUEST_OPEN, "Requesting connection" );
        this.statistics.setLabel ( STATS_ITEM_SUBSCRIPTIONS, "Item subscriptions" );
        this.statistics.setLabel ( STATS_LINGERING_CLOSE, "Lingering close active" );
    }

    @Override
    public void setCallbackFactory ( final CallbackFactory callbackFactory )
    {
        this.connection.setCallbackFactory ( callbackFactory );
    }

    @Override
    public void connect ()
    {
        this.connection.connect ();
    }

    @Override
    public void connect ( final CallbackHandler callbackHandler )
    {
        this.connection.connect ( callbackHandler );
    }

    @Override
    public void disconnect ()
    {
        this.connection.disconnect ();
    }

    @Override
    public void dispose ()
    {
        this.connection.dispose ();
    }

    @Override
    public void addConnectionStateListener ( final ConnectionStateListener connectionStateListener )
    {
        this.connection.addConnectionStateListener ( connectionStateListener );
    }

    @Override
    public void removeConnectionStateListener ( final ConnectionStateListener connectionStateListener )
    {
        this.connection.removeConnectionStateListener ( connectionStateListener );
    }

    @Override
    public ConnectionState getState ()
    {
        return this.connection.getState ();
    }

    @Override
    public ConnectionInformation getConnectionInformation ()
    {
        return this.connection.getConnectionInformation ();
    }

    @Override
    public Map<String, String> getSessionProperties ()
    {
        return this.connection.getSessionProperties ();
    }

    @Override
    public void addPrivilegeListener ( final PrivilegeListener listener )
    {
        this.connection.addPrivilegeListener ( listener );
    }

    @Override
    public void removePrivilegeListener ( final PrivilegeListener listener )
    {
        this.connection.removePrivilegeListener ( listener );
    }

    @Override
    public Set<String> getPrivileges ()
    {
        return this.connection.getPrivileges ();
    }

    @Override
    public void browse ( final Location location, final BrowseOperationCallback callback )
    {
        this.connection.browse ( location, callback );
    }

    @Override
    public void write ( final String itemId, final Variant value, final OperationParameters operationParameters, final WriteOperationCallback callback )
    {
        this.connection.write ( itemId, value, operationParameters, callback );
    }

    @Override
    public void writeAttributes ( final String itemId, final Map<String, Variant> attributes, final OperationParameters operationParameters, final WriteAttributeOperationCallback callback )
    {
        this.connection.writeAttributes ( itemId, attributes, operationParameters, callback );
    }

    @Override
    public NotifyFuture<WriteResult> startWrite ( final String itemId, final Variant value, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        return this.connection.startWrite ( itemId, value, operationParameters, callbackHandler );
    }

    @Override
    public NotifyFuture<WriteAttributeResults> startWriteAttributes ( final String itemId, final Map<String, Variant> attributes, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        return this.connection.startWriteAttributes ( itemId, attributes, operationParameters, callbackHandler );
    }

    @Override
    public void subscribeFolder ( final Location location ) throws NoConnectionException, OperationException
    {
        this.connection.subscribeFolder ( location );
    }

    @Override
    public void unsubscribeFolder ( final Location location ) throws NoConnectionException, OperationException
    {
        this.connection.unsubscribeFolder ( location );
    }

    @Override
    public FolderListener setFolderListener ( final Location location, final FolderListener listener )
    {
        return this.connection.setFolderListener ( location, listener );
    }

    @Override
    public void subscribeItem ( final String itemId ) throws NoConnectionException, OperationException
    {
        synchronized ( this )
        {
            if ( this.subscribedItems.add ( itemId ) )
            {
                this.statistics.setCurrentValue ( STATS_ITEM_SUBSCRIPTIONS, this.subscribedItems.size () );
                checkConnection ();
            }
        }
        this.connection.subscribeItem ( itemId );
    }

    @Override
    public void unsubscribeItem ( final String itemId ) throws NoConnectionException, OperationException
    {
        synchronized ( this )
        {
            if ( this.subscribedItems.remove ( itemId ) )
            {
                this.statistics.setCurrentValue ( STATS_ITEM_SUBSCRIPTIONS, this.subscribedItems.size () );
                checkConnection ();
            }
        }
        this.connection.unsubscribeItem ( itemId );
    }

    private void checkConnection ()
    {
        if ( this.subscribedItems.isEmpty () )
        {
            if ( this.lingeringTimeout == null )
            {
                // no lingering ... close
                this.statistics.setCurrentValue ( STATS_REQUEST_OPEN, 0 );
                performDisconnect ();
            }
            else if ( this.disconnectTimestamp != 0 && this.disconnectTimestamp + this.lingeringTimeout <= System.currentTimeMillis () )
            {
                // we lingered long enough ... close
                this.statistics.setCurrentValue ( STATS_REQUEST_OPEN, 0 );
                this.statistics.setCurrentValue ( STATS_LINGERING_CLOSE, 0 );
                this.disconnectTimestamp = 0;
                performDisconnect ();
            }
            else
            {
                // start lingering ... 
                this.disconnectTimestamp = System.currentTimeMillis ();
                this.statistics.setCurrentValue ( STATS_LINGERING_CLOSE, 1 );
                this.connection.getExecutor ().schedule ( this.performConnectionCheck, this.lingeringTimeout, TimeUnit.MILLISECONDS );
            }
        }
        else
        {
            this.statistics.setCurrentValue ( STATS_REQUEST_OPEN, 1 );
            performConnect ();
            if ( this.lingeringTimeout != null )
            {
                this.disconnectTimestamp = 0;
                this.statistics.setCurrentValue ( STATS_LINGERING_CLOSE, 0 );
            }
        }
    }

    protected abstract void performConnect ();

    protected abstract void performDisconnect ();

    @Override
    public ItemUpdateListener setItemUpdateListener ( final String itemId, final ItemUpdateListener listener )
    {
        return this.connection.setItemUpdateListener ( itemId, listener );
    }

    @Override
    public ScheduledExecutorService getExecutor ()
    {
        return this.connection.getExecutor ();
    }

    @Override
    public Collection<StatisticEntry> getStatistics ()
    {
        final Collection<StatisticEntry> result = new LinkedList<StatisticEntry> ();

        if ( this.connection instanceof StatisticsProvider )
        {
            result.addAll ( ( (StatisticsProvider)this.connection ).getStatistics () );
        }
        result.addAll ( this.statistics.getEntries () );

        return result;
    }

}
