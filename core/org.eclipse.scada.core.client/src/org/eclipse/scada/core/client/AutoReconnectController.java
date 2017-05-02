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
package org.eclipse.scada.core.client;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A automatic reconnect controller which keeps connection in the requested
 * state
 * <p>
 * In order to use the reconnect controller put the connection in the
 * constructor and call {@link #connect()}.
 * 
 * <pre>
 * <code>
 * Connection connection = ...;
 * AutoReconnectController controller = new AutoReconnectController ( connection );
 * controller.connect ();
 * </code>
 * </pre>
 * <p>
 * The {@link AutoReconnectController} needs to be disposed since 0.17.0
 * 
 * @since 0.12.0
 * @author Jens Reimann
 */
public class AutoReconnectController implements ConnectionStateListener
{

    private final static Logger logger = LoggerFactory.getLogger ( AutoReconnectController.class );

    private static final long DEFAULT_RECONNECT_DELAY = Long.getLong ( "org.eclipse.scada.core.client.defaultReconnectDelay", 10 * 1000 );

    private final Connection connection;

    private boolean connect;

    private final long reconnectDelay;

    private ScheduledExecutorService executor;

    private long lastTimestamp;

    private ConnectionState state;

    private boolean checkScheduled;

    private long lastStateChange;

    private CallbackHandler connectCallbackHandler;

    private ScheduledFuture<?> zombieJob;

    /**
     * Create a new reconnect controller for the provided connection using the
     * default reconnect delay
     * 
     * @param connection
     *            the connection to manage
     */
    public AutoReconnectController ( final Connection connection )
    {
        this ( connection, DEFAULT_RECONNECT_DELAY );
    }

    /**
     * Create a new reconnect controller for the provided connection
     * 
     * @param connection
     *            the connection to manage
     * @param reconnectDelay
     *            the minimum delay between reconnect attempts
     */
    public AutoReconnectController ( final Connection connection, long reconnectDelay )
    {
        this.connection = connection;
        this.reconnectDelay = reconnectDelay;

        if ( this.connection == null )
        {
            throw new IllegalArgumentException ( "'connection' must not be null" );
        }

        if ( reconnectDelay <= 0 )
        {
            reconnectDelay = DEFAULT_RECONNECT_DELAY;
        }

        final ThreadFactory threadFactory = new NamedThreadFactory ( "AutoReconnect/" + connection.getConnectionInformation ().toMaskedString () );
        synchronized ( this )
        {
            this.executor = Executors.newSingleThreadScheduledExecutor ( threadFactory );
        }

        this.connection.addConnectionStateListener ( this );

        if ( !Boolean.getBoolean ( "org.eclipse.scada.core.client.AutoReconnectController.disableZombieMode" ) )
        {
            this.zombieJob = this.executor.scheduleWithFixedDelay ( new Runnable () {

                @Override
                public void run ()
                {
                    checkDead ();
                }
            }, reconnectDelay, reconnectDelay, TimeUnit.MILLISECONDS );
        }
    }

    protected void checkDead ()
    {
        synchronized ( this )
        {
            // Check if we are lying dead in the water
            if ( this.lastStateChange == 0 )
            {
                return;
            }

            if ( this.state != ConnectionState.CONNECTING )
            {
                // no need to do anything
                return;
            }

            if ( System.currentTimeMillis () - this.lastStateChange < this.reconnectDelay * 3 )
            {
                // too early for considering dead
                return;
            }

        }

        // dead - kill the zombie - outside the lock to avoid deadlocks
        logger.error ( "Found zombie : {} {}", new Object[] { this.state, this.lastStateChange } );
        this.connection.disconnect ();
    }

    /**
     * Dispose controller forcibly
     * <p>
     * This will also close the connection
     * </p>
     */
    public void dispose ()
    {
        dispose ( true );
    }

    /**
     * Dispose controller forcibly
     * 
     * @param disconnect
     *            if <code>true</code> the connection will also be disconnected
     */
    public void dispose ( final boolean disconnect )
    {
        logger.debug ( "Disposing - disconnect: {}", disconnect );

        final ScheduledExecutorService executor;

        synchronized ( this )
        {
            executor = this.executor;
            if ( this.executor != null )
            {
                if ( disconnect )
                {
                    disconnect ();
                }
                this.executor = null;
            }
        }

        if ( this.zombieJob != null )
        {
            this.zombieJob.cancel ( false );
            this.zombieJob = null;
        }

        if ( executor != null )
        {
            // shutdown outside of sync lock
            executor.shutdown ();
        }
    }

    @Override
    protected void finalize () throws Throwable
    {
        logger.debug ( "Finalized" );
        if ( this.executor != null )
        {
            this.executor.shutdown ();
            this.executor = null;
        }
        super.finalize ();
    }

    public synchronized void connect ()
    {
        connect ( null );
    }

    /**
     * @since 1.1
     */
    public synchronized void connect ( final CallbackHandler connectCallbackHandler )
    {
        this.connectCallbackHandler = connectCallbackHandler;
        logger.debug ( "Request to connect" );
        if ( this.connect == true )
        {
            return;
        }
        this.connect = true;

        // we want that now!
        this.lastTimestamp = 0;

        triggerUpdate ( this.connection.getState () );
    }

    public synchronized void disconnect ()
    {
        logger.debug ( "Request to disconnect" );

        if ( this.connect == false )
        {
            return;
        }
        this.connect = false;

        // we want that now!
        this.lastTimestamp = 0;

        triggerUpdate ( this.connection.getState () );
    }

    @Override
    public void stateChange ( final Connection connection, final ConnectionState state, final Throwable error )
    {
        logger.info ( String.format ( "State change: %s", state ), error );
        triggerUpdate ( state );
    }

    private synchronized void triggerUpdate ( final ConnectionState state )
    {
        this.state = state;
        this.lastStateChange = System.currentTimeMillis ();

        if ( !this.checkScheduled && this.executor != null )
        {
            this.checkScheduled = true;
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    performUpdate ( state );
                }
            } );
        }
    }

    private void performUpdate ( final ConnectionState state )
    {
        logger.debug ( "Performing update: {}", state );

        final long now = System.currentTimeMillis ();
        final long diff = now - this.lastTimestamp;

        logger.debug ( String.format ( "Last action: %s, diff: %s, delay: %s", this.lastTimestamp, diff, this.reconnectDelay ) );

        if ( diff > this.reconnectDelay )
        {
            performCheckNow ();
        }
        else
        {
            final long delay = this.reconnectDelay - diff;
            logger.info ( "Delaying next check by {} milliseconds", delay );
            this.executor.schedule ( new Runnable () {

                @Override
                public void run ()
                {
                    performCheckNow ();
                }
            }, delay, TimeUnit.MILLISECONDS );
        }

        this.lastTimestamp = System.currentTimeMillis ();
    }

    private void performCheckNow ()
    {
        ConnectionState currentState;
        boolean connect;
        synchronized ( this )
        {
            currentState = this.state;
            connect = this.connect;
            this.checkScheduled = false;
        }

        logger.debug ( String.format ( "Performing state check: %s (request: %s)", currentState, connect ) );

        switch ( currentState )
        {
            case CLOSED:
                if ( connect )
                {
                    logger.info ( "Trigger connect" );
                    this.connection.connect ( this.connectCallbackHandler );
                }
                break;
            case LOOKUP:
            case CONNECTING:
            case CONNECTED:
            case BOUND:
                if ( !connect )
                {
                    logger.info ( "Trigger disconnect" );
                    this.connection.disconnect ();
                }
                break;
            default:
                logger.info ( "Do nothing" );
                break;
        }
    }

}
