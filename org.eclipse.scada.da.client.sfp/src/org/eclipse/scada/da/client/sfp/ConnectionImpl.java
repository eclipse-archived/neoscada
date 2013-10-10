/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.sfp;

import java.nio.charset.Charset;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.NoConnectionException;
import org.eclipse.scada.core.client.common.ClientBaseConnection;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.BrowseOperationCallback;
import org.eclipse.scada.da.client.Connection;
import org.eclipse.scada.da.client.FolderListener;
import org.eclipse.scada.da.client.ItemUpdateListener;
import org.eclipse.scada.da.client.WriteAttributeOperationCallback;
import org.eclipse.scada.da.client.WriteOperationCallback;
import org.eclipse.scada.da.client.sfp.strategy.ReadAllStrategy;
import org.eclipse.scada.da.core.Location;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.protocol.sfp.Sessions;
import org.eclipse.scada.protocol.sfp.messages.Hello;
import org.eclipse.scada.protocol.sfp.messages.Welcome;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionImpl extends ClientBaseConnection implements Connection
{

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionImpl.class );

    private ReadAllStrategy strategy;

    private long pollTime;

    private final Set<String> subscribedItems = new HashSet<> ();

    private final Map<String, ItemUpdateListener> itemListeners = new HashMap<> ();

    private final Set<Location> subscribedFolders = new HashSet<> ();

    private final Map<Location, FolderListener> folderListeners = new HashMap<> ();

    public ConnectionImpl ( final ConnectionInformation connectionInformation ) throws Exception
    {
        super ( new HandlerFactory (), new FilterChainBuilder (), connectionInformation );

        final String pollTime = connectionInformation.getProperties ().get ( "pollTime" );
        if ( pollTime != null )
        {
            this.pollTime = Long.parseLong ( pollTime );
        }
        else
        {
            this.pollTime = 1_000L;
        }
    }

    @Override
    protected void onConnectionConnected ()
    {
        getSession ().getConfig ().setReaderIdleTime ( (int) ( TimeUnit.MILLISECONDS.toSeconds ( this.pollTime ) * 3 ) + 1 );
        sendHello ();
    }

    private void sendHello ()
    {
        final Hello message = new Hello ( (short)1, EnumSet.noneOf ( Hello.Features.class ) );
        sendMessage ( message );
    }

    @Override
    protected synchronized void handleMessage ( final Object message )
    {
        logger.debug ( "Handle message: {}", message );
        if ( message instanceof Welcome )
        {
            processWelcome ( (Welcome)message );
        }
        else
        {
            this.strategy.handleMessage ( message );
        }
    }

    private void processWelcome ( final Welcome message )
    {
        final String charsetName = message.getProperties ().get ( "charset" );
        if ( charsetName != null )
        {
            final Charset charset = Charset.forName ( charsetName );
            Sessions.setCharset ( getSession (), charset );
        }

        this.strategy = new ReadAllStrategy ( new ConnectionHandler () {

            @Override
            public void sendMessage ( final Object message )
            {
                ConnectionImpl.this.sendMessage ( message );
            }

            @Override
            public ScheduledExecutorService getExecutor ()
            {
                return ConnectionImpl.this.getExecutor ();
            };

            @Override
            public ConnectionState getConnectionState ()
            {
                return ConnectionImpl.this.getState ();
            }
        }, this.pollTime );

        // the subscription maps emulate a server state here, so we initialize them empty
        // as the server would do
        this.subscribedItems.clear ();
        this.subscribedFolders.clear ();

        this.strategy.setAllItemListeners ( this.itemListeners );
        this.strategy.setAllFolderListeners ( this.folderListeners );

        switchState ( ConnectionState.BOUND, null );

        logger.debug ( "Processed welcome" );
    }

    @Override
    protected void onConnectionClosed ()
    {
        synchronized ( this )
        {
            if ( this.strategy != null )
            {
                this.strategy.dispose ();
                this.strategy = null;
            }
        }
        super.onConnectionClosed ();
    }

    @Override
    public void browse ( final Location location, final BrowseOperationCallback callback )
    {
    }

    @Override
    public void write ( final String itemId, final Variant value, final OperationParameters operationParameters, final WriteOperationCallback callback )
    {
        final NotifyFuture<WriteResult> future = startWrite ( itemId, value, operationParameters, (CallbackHandler)null );
        org.eclipse.scada.da.client.Helper.transformWrite ( future, callback );
    }

    @Override
    public void writeAttributes ( final String itemId, final Map<String, Variant> attributes, final OperationParameters operationParameters, final WriteAttributeOperationCallback callback )
    {
        final NotifyFuture<WriteAttributeResults> future = startWriteAttributes ( itemId, attributes, operationParameters, (CallbackHandler)null );
        org.eclipse.scada.da.client.Helper.transformWriteAttributes ( callback, future );
    }

    @Override
    public synchronized NotifyFuture<WriteResult> startWrite ( final String itemId, final Variant value, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        if ( this.strategy != null )
        {
            return this.strategy.startWrite ( itemId, value );
        }
        else
        {
            return new InstantErrorFuture<> ( new IllegalStateException ( "No connection" ) );
        }
    }

    @Override
    public NotifyFuture<WriteAttributeResults> startWriteAttributes ( final String itemId, final Map<String, Variant> attributes, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        return new InstantErrorFuture<> ( new RuntimeException ( "The small footprint protocol does not allow writing attributes" ) );
    }

    @Override
    public void subscribeFolder ( final Location location ) throws NoConnectionException, OperationException
    {
        if ( this.subscribedFolders.add ( location ) )
        {
            if ( this.strategy != null )
            {
                this.strategy.subscribeFolder ( location );
            }
        }
        this.strategy.subscribeFolder ( location );
    }

    @Override
    public void unsubscribeFolder ( final Location location ) throws NoConnectionException, OperationException
    {
        this.subscribedFolders.remove ( location );
        if ( this.subscribedFolders.remove ( location ) )
        {
            if ( this.strategy != null )
            {
                this.strategy.unsubscribeFolder ( location );
            }
        }
    }

    @Override
    public FolderListener setFolderListener ( final Location location, final FolderListener listener )
    {
        final FolderListener old = this.folderListeners.put ( location, listener );

        if ( this.strategy != null )
        {
            this.strategy.setFolderListener ( location, listener );
        }

        return old;
    }

    @Override
    public synchronized void subscribeItem ( final String itemId ) throws NoConnectionException, OperationException
    {
        logger.debug ( "Subscribe - itemId: {}", itemId );

        if ( this.subscribedItems.add ( itemId ) )
        {
            if ( this.strategy != null )
            {
                this.strategy.subscribeItem ( itemId );
            }
        }
    }

    @Override
    public synchronized void unsubscribeItem ( final String itemId ) throws NoConnectionException, OperationException
    {
        logger.debug ( "Unsubscribe - itemId: {}", itemId );

        if ( this.subscribedItems.remove ( itemId ) )
        {
            if ( this.strategy != null )
            {
                this.strategy.unsubscribeItem ( itemId );
            }
        }
    }

    @Override
    public synchronized ItemUpdateListener setItemUpdateListener ( final String itemId, final ItemUpdateListener listener )
    {
        logger.debug ( "Setting item update listener - itemId: {}, listener: {}", itemId, listener );

        final ItemUpdateListener old = this.itemListeners.put ( itemId, listener );

        if ( this.strategy != null )
        {
            this.strategy.setItemUpateListener ( itemId, listener );
        }
        else
        {
            getExecutor ().execute ( new Runnable () {
                @Override
                public void run ()
                {
                    listener.notifySubscriptionChange ( SubscriptionState.DISCONNECTED, null );
                };
            } );
        }

        return old;
    }

    @Override
    public ScheduledExecutorService getExecutor ()
    {
        return this.executor;
    }

}
