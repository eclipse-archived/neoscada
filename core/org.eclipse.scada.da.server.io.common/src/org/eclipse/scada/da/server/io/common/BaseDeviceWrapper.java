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
package org.eclipse.scada.da.server.io.common;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.DataItemCommand;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.common.impl.HiveCommon;
import org.eclipse.scada.utils.collection.MapBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseDeviceWrapper implements ConnectionListener
{

    private static final Logger logger = LoggerFactory.getLogger ( BaseDeviceWrapper.class );

    protected static final int RECONNECT_DELAY = 5 * 1000;

    protected String deviceTag;

    private final HiveCommon hive;

    private final FolderCommon rootFolder;

    protected FolderCommon baseFolder;

    protected ConnectionState state = ConnectionState.DISCONNECTED;

    private final ScheduledExecutorService scheduler;

    private BaseDevice device;

    private final DataItemInputChained connectionStateItem;

    private final DataItemInputChained stateItem;

    private final DataItemInputChained timeoutItem;

    private ScheduledFuture<?> tickJob;

    private long lastReply = 0;

    private boolean timeout = false;

    private static final int JOB_PERIOD = 1 * 1000;

    public BaseDeviceWrapper ( final HiveCommon hive, final String deviceTag, final ScheduledExecutorService scheduler, final FolderCommon rootFolder )
    {
        this.hive = hive;
        this.deviceTag = deviceTag;
        this.rootFolder = rootFolder;
        this.scheduler = scheduler;

        // create our device folder and attach it
        this.baseFolder = new FolderCommon ();
        this.rootFolder.add ( this.deviceTag, this.baseFolder, new MapBuilder<String, Variant> ().getMap () );

        // create the items
        this.connectionStateItem = createInput ( "connection" );
        this.stateItem = createInput ( "state" );
        this.timeoutItem = createInput ( "timeout" );
    }

    protected void tick ()
    {
        updateTimeoutCondition ();
        updateDeviceState ();
    }

    public void start ()
    {
        if ( this.device != null )
        {
            throw new RuntimeException ( "Device is already initialized" );
        }

        this.tickJob = this.scheduler.scheduleAtFixedRate ( new Runnable () {

            @Override
            public void run ()
            {
                try
                {
                    tick ();
                }
                catch ( final Throwable e )
                {
                    logger.debug ( "Failed to tick", e );
                }
            }
        }, JOB_PERIOD, JOB_PERIOD, TimeUnit.MILLISECONDS );

        // set up initial data
        setConnectionState ( ConnectionState.DISCONNECTED );

        this.device = createDevice ();
        this.device.addConnectionListener ( this );

        // and connect the device
        connect ();
    }

    public void stop ()
    {
        if ( this.device != null )
        {
            this.tickJob.cancel ( false );
            this.device.dispose ();

            setConnectionState ( ConnectionState.DISCONNECTED );
            this.rootFolder.remove ( this.baseFolder );
        }
        this.device = null;
    }

    protected abstract BaseDevice createDevice ();

    /**
     * generate an item name based on item name and device tag
     * 
     * @param item
     *            the requested item name
     * @return the generated item name
     */
    public String getItemId ( final String item )
    {
        return this.deviceTag + "." + item;
    }

    /**
     * create a new input item
     * 
     * @param itemName
     *            the item name
     * @return the input item
     */
    protected DataItemInputChained createInput ( final String itemName )
    {
        final DataItemInputChained item = new DataItemInputChained ( getItemId ( itemName ), this.hive.getOperationService () );
        this.hive.registerItem ( item );
        this.baseFolder.add ( itemName, item, new MapBuilder<String, Variant> ().getMap () );
        return item;
    }

    /**
     * create a command item
     * 
     * @param itemName
     *            the item name
     * @return the command item
     */
    protected DataItemCommand createCommand ( final String itemName )
    {
        final DataItemCommand item = new DataItemCommand ( getItemId ( itemName ), this.hive.getOperationService () );
        this.hive.registerItem ( item );
        this.baseFolder.add ( itemName, item, new MapBuilder<String, Variant> ().getMap () );
        return item;
    }

    /**
     * set a new connection state
     * 
     * @param state
     *            the new connection state
     */
    protected synchronized void setConnectionState ( final ConnectionState state )
    {
        logger.debug ( "Setting state to: {}", state );

        onPreStateChange ( this.state, state );

        this.state = state;

        this.connectionStateItem.updateData ( Variant.valueOf ( state.name () ), null, null );

        onPostStateChange ();
    }

    protected void onPostStateChange ()
    {
    }

    protected void onPreStateChange ( final ConnectionState oldState, final ConnectionState newState )
    {
    }

    /**
     * perform a connect of the communication channel to the device
     */
    protected synchronized void connect ()
    {
        if ( this.device == null )
        {
            return;
        }

        if ( !this.device.isConnected () )
        {
            this.device.connect ();
            setConnectionState ( ConnectionState.CONNECTING );
        }
    }

    /**
     * schedule a reconnect <br/>
     * if the device is disconnected it will set the state to
     * {@link ConnectionState#WAITING} and schedule the connect call.
     */
    protected synchronized void reconnect ()
    {
        if ( this.state.equals ( ConnectionState.DISCONNECTED ) )
        {
            if ( this.device == null )
            {
                return;
            }

            setConnectionState ( ConnectionState.WAITING );
            this.scheduler.schedule ( new Runnable () {

                @Override
                public void run ()
                {
                    connect ();
                }
            }, RECONNECT_DELAY, TimeUnit.MILLISECONDS );
        }
    }

    /**
     * get information if communication channel is connected
     * 
     * @return <code>true</code> if the connection is established
     */
    public boolean isConnected ()
    {
        return this.state.equals ( ConnectionState.CONNECTED );
    }

    /**
     * called when the data connection was lost
     */
    @Override
    public void closed ( final Throwable error )
    {
        setConnectionState ( ConnectionState.DISCONNECTED );
        reconnect ();
    }

    /**
     * called when the data connection could not be opened
     */
    @Override
    public void connectFailed ( final Throwable error )
    {
        setConnectionState ( ConnectionState.DISCONNECTED );
        reconnect ();
    }

    /**
     * called when the data connection is established
     */
    @Override
    public void opened ()
    {
        setConnectionState ( ConnectionState.CONNECTED );
    }

    /**
     * Update the state items from the current device state
     */
    private void updateDeviceState ()
    {
        this.stateItem.updateData ( Variant.valueOf ( isDeviceOk () ), null, null );
    }

    /**
     * Check if the device communication is connected and the device
     * communication is not timed out.
     * 
     * @return device state
     */
    public boolean isDeviceOk ()
    {
        return !isTimeout () && isConnected ();
    }

    /**
     * get information if the communication to the device is timed out
     * 
     * @return <code>true</code> if the device is in time out
     */
    public boolean isTimeoutCondition ()
    {
        return System.currentTimeMillis () - this.lastReply > getTimeoutValue ();
    }

    public boolean isTimeout ()
    {
        return this.timeout;
    }

    protected abstract long getTimeoutValue ();

    protected void tickLastInput ()
    {
        this.lastReply = System.currentTimeMillis ();
        updateTimeoutCondition ();
        updateDeviceState ();
    }

    private synchronized void updateTimeoutCondition ()
    {
        if ( isTimeout () != isTimeoutCondition () )
        {
            this.timeout = isTimeoutCondition ();
            onTimeout ( isTimeout () );
        }

        // always update timeout to show initial data
        this.timeoutItem.updateData ( Variant.valueOf ( isTimeout () ), null, null );
    }

    protected void onTimeout ( final boolean timeout )
    {
    }

    protected HiveCommon getHive ()
    {
        return this.hive;
    }
}
