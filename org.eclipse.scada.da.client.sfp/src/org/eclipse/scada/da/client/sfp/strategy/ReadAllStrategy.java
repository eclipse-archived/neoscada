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
package org.eclipse.scada.da.client.sfp.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.FolderListener;
import org.eclipse.scada.da.client.ItemUpdateListener;
import org.eclipse.scada.da.client.sfp.ConnectionHandler;
import org.eclipse.scada.da.core.Location;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.protocol.sfp.messages.BrowseUpdate;
import org.eclipse.scada.protocol.sfp.messages.DataUpdate;
import org.eclipse.scada.protocol.sfp.messages.ReadAll;
import org.eclipse.scada.protocol.sfp.messages.SubscribeBrowse;
import org.eclipse.scada.protocol.sfp.messages.WriteCommand;
import org.eclipse.scada.protocol.sfp.messages.DataUpdate.Entry;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadAllStrategy
{
    private final static Logger logger = LoggerFactory.getLogger ( ReadAllStrategy.class );

    private final ConnectionHandler connectionHandler;

    private ScheduledFuture<?> pollJob;

    private Set<Integer> previousRegisters = new HashSet<> ();

    private final DataManager dataManager;

    private final FolderManager folderManager;

    private final long pollDelay;

    private final Random random = new Random ();

    private final Map<Integer, WriteHandler> writeHandlerMap = new HashMap<> ();

    public ReadAllStrategy ( final ConnectionHandler connectionHandler, final long pollDelay )
    {
        logger.debug ( "Created new strategy" );

        this.pollDelay = pollDelay;

        this.connectionHandler = connectionHandler;

        this.dataManager = new DataManager ( connectionHandler );
        this.folderManager = new FolderManager ( connectionHandler );

        this.connectionHandler.sendMessage ( new SubscribeBrowse () );
    }

    protected void triggerReadAll ()
    {
        this.connectionHandler.sendMessage ( new ReadAll () );
    }

    public void handleMessage ( final Object message )
    {
        if ( message instanceof DataUpdate )
        {
            processDataUpdate ( (DataUpdate)message );
        }
        else if ( message instanceof BrowseUpdate )
        {
            processBrowseUpdate ( (BrowseUpdate)message );
        }
        else if ( message instanceof org.eclipse.scada.protocol.sfp.messages.WriteResult )
        {
            processWriteResult ( (org.eclipse.scada.protocol.sfp.messages.WriteResult)message );
        }
    }

    private void processWriteResult ( final org.eclipse.scada.protocol.sfp.messages.WriteResult message )
    {
        logger.debug ( "Processing write result" );

        final WriteHandler handler = this.writeHandlerMap.remove ( message.getOperationId () );
        if ( handler == null )
        {
            logger.warn ( "No handler found for operation: {}", message.getOperationId () );
            return;
        }

        // complete outside any locks
        execute ( new Runnable () {
            @Override
            public void run ()
            {
                handler.complete ( message );
            };
        } );
    }

    private void processBrowseUpdate ( final BrowseUpdate message )
    {
        logger.debug ( "Browse data update:" );
        for ( final BrowseUpdate.Entry entry : message.getEntries () )
        {
            logger.trace ( "\t{} = '{}'", entry.getRegister (), entry.getName () );
        }

        // update browser

        for ( final BrowseUpdate.Entry entry : message.getEntries () )
        {
            this.dataManager.addMapping ( entry.getRegister (), entry.getName (), entry.getUnit () );

            final String[] toks = makeItemHiearchy ( entry.getName () );
            final LinkedList<String> hier = new LinkedList<> ( Arrays.asList ( toks ) );
            if ( hier.size () == 1 )
            {
                this.folderManager.addEntry ( new Location (), entry.getName (), entry.getName (), entry.getDescription () );
            }
            else
            {
                // last segment is the name
                final String name = hier.removeLast ();
                this.folderManager.addEntry ( new Location ( hier ), name, entry.getName (), entry.getDescription () );
            }
        }

        // finally we can start the poller, if not already done

        if ( this.pollJob == null )
        {
            this.pollJob = this.connectionHandler.getExecutor ().scheduleWithFixedDelay ( new Runnable () {

                @Override
                public void run ()
                {
                    triggerReadAll ();
                }
            }, 0, this.pollDelay, TimeUnit.MILLISECONDS );
        }
    }

    private String[] makeItemHiearchy ( final String name )
    {
        return name.split ( "\\." );
    }

    private void processDataUpdate ( final DataUpdate message )
    {
        final Set<Integer> registers = new HashSet<> ();

        for ( final DataUpdate.Entry entry : message.getEntries () )
        {
            final DataItemValue value = convert ( entry );
            // final String itemId = "" + entry.getRegister ();
            // internalUpdate ( itemId, value );
            this.dataManager.updateData ( entry.getRegister (), value );
            registers.add ( entry.getRegister () );
        }

        this.previousRegisters.removeAll ( registers );

        // now process the removed keys
        for ( final Integer removed : this.previousRegisters )
        {
            this.dataManager.removeRegister ( removed );
            //   internalRemove ( removed );
        }

        this.previousRegisters = registers;
    }

    private static DataItemValue convert ( final Entry entry )
    {
        final Map<String, Variant> attributes = new HashMap<> ( 10 );

        attributes.put ( "timestamp", Variant.valueOf ( entry.getTimestamp () ) );

        attributes.put ( "sfp.register", Variant.valueOf ( entry.getRegister () ) );

        attributes.put ( "error", Variant.valueOf ( entry.getStates ().contains ( DataUpdate.State.ERROR ) ) );
        attributes.put ( "alarm", Variant.valueOf ( entry.getStates ().contains ( DataUpdate.State.ALARM ) ) );
        attributes.put ( "warning", Variant.valueOf ( entry.getStates ().contains ( DataUpdate.State.WARNING ) ) );
        attributes.put ( "error.ackRequired", Variant.valueOf ( entry.getStates ().contains ( DataUpdate.State.ERROR_ACK ) ) );
        attributes.put ( "alarm.ackRequired", Variant.valueOf ( entry.getStates ().contains ( DataUpdate.State.ALARM_ACK ) ) );
        attributes.put ( "warning.ackRequired", Variant.valueOf ( entry.getStates ().contains ( DataUpdate.State.WARNING_ACK ) ) );
        attributes.put ( "manual", Variant.valueOf ( entry.getStates ().contains ( DataUpdate.State.MANUAL_OVERRIDE ) ) );
        attributes.put ( "blocked", Variant.valueOf ( entry.getStates ().contains ( DataUpdate.State.BLOCKED ) ) );

        return new DataItemValue ( entry.getValue (), attributes, SubscriptionState.CONNECTED );
    }

    public void dispose ()
    {
        if ( this.pollJob != null )
        {
            this.pollJob.cancel ( false );
            this.pollJob = null;
        }

        if ( !this.writeHandlerMap.isEmpty () )
        {
            final List<WriteHandler> handlers = new ArrayList<> ( this.writeHandlerMap.values () );

            execute ( new Runnable () {
                @Override
                public void run ()
                {
                    for ( final WriteHandler handler : handlers )
                    {
                        handler.cancel ( false );
                    }

                };
            } );
            this.writeHandlerMap.clear ();
        }

        this.folderManager.dispose ();
        this.dataManager.dispose ();
    }

    public void subscribeItem ( final String itemId )
    {
        logger.debug ( "Subscribe item: {}", itemId );

        this.dataManager.subscribeItem ( itemId );
    }

    public void unsubscribeItem ( final String itemId )
    {
        logger.debug ( "Unsubscribe item: {}", itemId );

        this.dataManager.unsubscribeItem ( itemId );
    }

    public void setItemUpateListener ( final String itemId, final ItemUpdateListener listener )
    {
        this.dataManager.setItemUpateListener ( itemId, listener );
    }

    public void setAllItemListeners ( final Map<String, ItemUpdateListener> itemListeners )
    {
        this.dataManager.setAllItemListeners ( itemListeners );
    }

    protected void execute ( final Runnable command )
    {
        this.connectionHandler.getExecutor ().execute ( command );
    }

    public void subscribeFolder ( final Location location )
    {
        this.folderManager.subscribeFolder ( location );
    }

    public void unsubscribeFolder ( final Location location )
    {
        this.folderManager.unsubscribeFolder ( location );
    }

    public void setFolderListener ( final Location location, final FolderListener listener )
    {
        this.folderManager.setFolderListener ( location, listener );
    }

    public void setAllFolderListeners ( final Map<Location, FolderListener> folderListeners )
    {
        for ( final Map.Entry<Location, FolderListener> entry : folderListeners.entrySet () )
        {
            setFolderListener ( entry.getKey (), entry.getValue () );
        }
    }

    public NotifyFuture<WriteResult> startWrite ( final String itemId, final Variant value )
    {
        int operationId;
        do
        {
            operationId = this.random.nextInt ();
        } while ( this.writeHandlerMap.containsKey ( operationId ) );

        final WriteHandler writeHandler = new WriteHandler ();

        final Integer registerNumber = this.dataManager.findRegister ( itemId );
        if ( registerNumber == null )
        {
            return new InstantErrorFuture<> ( new RuntimeException ( String.format ( "Item '%s' is unknown", itemId ) ) );
        }

        this.connectionHandler.sendMessage ( new WriteCommand ( registerNumber, value, operationId ) );

        this.writeHandlerMap.put ( operationId, writeHandler );

        return writeHandler;
    }
}
