/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - extend for more use cases
 *******************************************************************************/
package org.eclipse.scada.da.ui.connection.data;

import java.util.Map;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.client.Connection;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.ConnectionStateListener;
import org.eclipse.scada.core.connection.provider.ConnectionIdTracker;
import org.eclipse.scada.core.connection.provider.ConnectionRequest;
import org.eclipse.scada.core.connection.provider.ConnectionRequestTracker;
import org.eclipse.scada.core.connection.provider.ConnectionTracker;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.da.connection.provider.ConnectionService;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.ui.connection.data.ItemListenerHolder.HolderListener;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An abstract base class for implementing item holders <br/>
 * Note: Implementations must call {@link #init()} in order to start the
 * listening
 * 
 * @author Jens Reimann
 */
public abstract class AbstractItemHolder
{
    private final static Logger logger = LoggerFactory.getLogger ( AbstractItemHolder.class );

    protected final Item item;

    private final BundleContext context;

    private final ConnectionTracker tracker;

    private ConnectionService connection;

    private final HolderListener holderListener;

    private final ConnectionStateListener connectionStateListener = new ConnectionStateListener () {

        @Override
        public void stateChange ( final Connection connection, final ConnectionState state, final Throwable error )
        {
            fireConnectionStateChange ( connection, state, error );
        }
    };

    public AbstractItemHolder ( final BundleContext context, final Item item, final HolderListener holderListener )
    {
        this.context = context;
        this.item = item;

        this.holderListener = holderListener;

        switch ( item.getType () )
        {
            case ID:
                this.tracker = new ConnectionIdTracker ( this.context, item.getConnectionString (), new ConnectionTracker.Listener () {

                    @Override
                    public void setConnection ( final org.eclipse.scada.core.connection.provider.ConnectionService connectionService )
                    {
                        AbstractItemHolder.this.setConnection ( (ConnectionService)connectionService );
                    }
                } );
                break;

            case URI:
            default:
                this.tracker = new ConnectionRequestTracker ( this.context, createRequest (), new ConnectionTracker.Listener () {

                    @Override
                    public void setConnection ( final org.eclipse.scada.core.connection.provider.ConnectionService connectionService )
                    {
                        AbstractItemHolder.this.setConnection ( (ConnectionService)connectionService );
                    }
                } );

                break;
        }
    }

    protected synchronized void init ()
    {
        this.tracker.listen ();
    }

    protected synchronized void setConnection ( final ConnectionService connectionService )
    {
        fireConnectionChange ( connectionService );

        try
        {
            if ( this.connection != null )
            {
                unbindConnection ();
            }
            if ( connectionService != null )
            {
                bindConnection ( connectionService );
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to set connection", e );
        }
    }

    protected void fireConnectionChange ( final ConnectionService connection )
    {
        if ( this.holderListener != null )
        {
            try
            {
                this.holderListener.connectionChange ( connection );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Listener threw exception", e );
            }
        }
    }

    protected void fireConnectionStateChange ( final Connection connection, final ConnectionState state, final Throwable error )
    {
        if ( this.holderListener != null )
        {
            try
            {
                this.holderListener.connectionStateChange ( connection, state, error );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Listener threw exception", e );
            }
        }
    }

    protected void bindConnection ( final ConnectionService connectionService )
    {
        this.connection = connectionService;
        if ( this.holderListener != null )
        {
            this.connection.getConnection ().addConnectionStateListener ( this.connectionStateListener );
        }
    }

    protected void unbindConnection ()
    {
        if ( this.holderListener != null )
        {
            this.connection.getConnection ().removeConnectionStateListener ( this.connectionStateListener );
        }
        this.connection = null;
    }

    protected ConnectionRequest createRequest ()
    {
        return new ConnectionRequest ( null, ConnectionInformation.fromURI ( this.item.getConnectionString () ), null, false );
    }

    public synchronized void dispose ()
    {
        unbindConnection ();
        this.tracker.close ();
    }

    public synchronized NotifyFuture<WriteResult> startWrite ( final Variant value, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        if ( this.connection == null )
        {
            return new InstantErrorFuture<WriteResult> ( new IllegalStateException ( "No connection bound" ) );
        }
        return this.connection.getConnection ().startWrite ( this.item.getId (), value, operationParameters, callbackHandler );
    }

    public synchronized NotifyFuture<WriteAttributeResults> startWriteAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        if ( this.connection == null )
        {
            return new InstantErrorFuture<WriteAttributeResults> ( new IllegalStateException ( "No connection bound" ) );
        }
        return this.connection.getConnection ().startWriteAttributes ( this.item.getId (), attributes, operationParameters, callbackHandler );
    }

    public NotifyFuture<WriteResult> write ( final Variant value )
    {
        return write ( value, null, null );
    }

    public synchronized NotifyFuture<WriteResult> write ( final Variant value, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        if ( this.connection == null )
        {
            return new InstantErrorFuture<WriteResult> ( new IllegalStateException ( "No connection bound" ) );
        }
        return this.connection.getConnection ().startWrite ( this.item.getId (), value, operationParameters, callbackHandler );
    }

    public NotifyFuture<WriteAttributeResults> writeAtrtibutes ( final Map<String, Variant> attributes )
    {
        return writeAtrtibutes ( attributes, null, null );
    }

    public synchronized NotifyFuture<WriteAttributeResults> writeAtrtibutes ( final Map<String, Variant> attributes, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        if ( this.connection == null )
        {
            return new InstantErrorFuture<WriteAttributeResults> ( new IllegalStateException ( "No connection bound" ) );
        }
        return this.connection.getConnection ().startWriteAttributes ( this.item.getId (), attributes, operationParameters, callbackHandler );
    }

    public Item getItem ()
    {
        return this.item;
    }

    public boolean waitForConnection ( final long timeout ) throws InterruptedException
    {
        return this.tracker.waitForService ( timeout ) != null;
    }

}