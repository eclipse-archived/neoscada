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
package org.eclipse.scada.da.client.ngp;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.client.NoConnectionException;
import org.eclipse.scada.core.client.ngp.ConnectionBaseImpl;
import org.eclipse.scada.core.data.ErrorInformation;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.core.data.Request;
import org.eclipse.scada.core.data.ResponseMessage;
import org.eclipse.scada.core.data.UserInformation;
import org.eclipse.scada.da.client.BrowseOperationCallback;
import org.eclipse.scada.da.client.Connection;
import org.eclipse.scada.da.client.FolderListener;
import org.eclipse.scada.da.client.ItemUpdateListener;
import org.eclipse.scada.da.client.WriteAttributeOperationCallback;
import org.eclipse.scada.da.client.WriteOperationCallback;
import org.eclipse.scada.da.client.ngp.internal.Helper;
import org.eclipse.scada.da.common.ngp.ProtocolConfigurationFactoryImpl;
import org.eclipse.scada.da.core.Location;
import org.eclipse.scada.da.core.WriteAttributeResult;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.core.browser.Entry;
import org.eclipse.scada.da.data.AttributeWriteResultEntry;
import org.eclipse.scada.da.data.BrowserEntry;
import org.eclipse.scada.da.data.message.BrowseFolder;
import org.eclipse.scada.da.data.message.BrowseResult;
import org.eclipse.scada.da.data.message.FolderDataUpdate;
import org.eclipse.scada.da.data.message.ItemDataUpdate;
import org.eclipse.scada.da.data.message.ItemStateUpdate;
import org.eclipse.scada.da.data.message.StartWriteAttributes;
import org.eclipse.scada.da.data.message.StartWriteValue;
import org.eclipse.scada.da.data.message.SubscribeFolder;
import org.eclipse.scada.da.data.message.SubscribeItem;
import org.eclipse.scada.da.data.message.UnsubscibeItem;
import org.eclipse.scada.da.data.message.UnsubscribeFolder;
import org.eclipse.scada.da.data.message.WriteAttributesResult;
import org.eclipse.scada.da.data.message.WriteValueResult;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.ExecutorFuture;
import org.eclipse.scada.utils.concurrent.FutureListener;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionImpl extends ConnectionBaseImpl implements Connection
{

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionImpl.class );

    static
    {
        DriverFactoryImpl.registerDriver ();
    }

    public static class WriteFuture extends ExecutorFuture<WriteResult> implements FutureListener<ResponseMessage>
    {
        public WriteFuture ( final Executor executor, final NotifyFuture<ResponseMessage> future )
        {
            super ( executor );
            future.addListener ( this );
        }

        @Override
        public void complete ( final Future<ResponseMessage> future )
        {
            try
            {
                final ResponseMessage response = future.get ();
                if ( response instanceof WriteValueResult )
                {
                    if ( ( (WriteValueResult)response ).getErrorInformation () == null )
                    {
                        setResult ( WriteResult.OK );
                    }
                    else
                    {
                        setError ( new OperationException ( ( (WriteValueResult)response ).getErrorInformation ().getMessage () ).fillInStackTrace () );
                    }
                }
                else
                {
                    setError ( new IllegalStateException ( String.format ( "Wrong reply - expected: %s, got: %s", WriteValueResult.class, response ) ) );
                }
            }
            catch ( final Exception e )
            {
                setError ( e );
            }
        }
    }

    public static class WriteAttributesFuture extends ExecutorFuture<WriteAttributeResults> implements FutureListener<ResponseMessage>
    {
        public WriteAttributesFuture ( final Executor executor, final NotifyFuture<ResponseMessage> future )
        {
            super ( executor );
            future.addListener ( this );
        }

        @Override
        public void complete ( final Future<ResponseMessage> future )
        {
            try
            {
                final ResponseMessage response = future.get ();
                if ( response instanceof WriteAttributesResult )
                {
                    if ( ( (WriteAttributesResult)response ).getErrorInformation () == null )
                    {
                        setResult ( convertResults ( ( (WriteAttributesResult)response ).getAttributeResults () ) );
                    }
                    else
                    {
                        setError ( new OperationException ( ( (WriteAttributesResult)response ).getErrorInformation ().getMessage () ).fillInStackTrace () );
                    }
                }
                else
                {
                    setError ( new IllegalStateException ( String.format ( "Wrong reply - expected: %s, got: %s", WriteAttributesResult.class, response ) ) );
                }
            }
            catch ( final Exception e )
            {
                setError ( e );
            }
        }
    }

    public static class BrowseFuture extends ExecutorFuture<Entry[]> implements FutureListener<ResponseMessage>
    {
        public BrowseFuture ( final Executor executor, final NotifyFuture<ResponseMessage> future )
        {
            super ( executor );
            future.addListener ( this );
        }

        @Override
        public void complete ( final Future<ResponseMessage> future )
        {
            try
            {
                final ResponseMessage response = future.get ();
                if ( response instanceof BrowseResult )
                {
                    if ( ( (BrowseResult)response ).getErrorInformation () == null )
                    {
                        setResult ( Helper.convert ( ( (BrowseResult)response ).getBrowserData () ) );
                    }
                    else
                    {
                        setError ( new OperationException ( ( (BrowseResult)response ).getErrorInformation ().getMessage () ).fillInStackTrace () );
                    }
                }
                else
                {
                    setError ( new IllegalStateException ( String.format ( "Wrong reply - expected: %s, got: %s", BrowseResult.class, response ) ) );
                }
            }
            catch ( final Exception e )
            {
                setError ( e );
            }
        }
    }

    private final Map<String, ItemUpdateListener> itemListeners = new HashMap<String, ItemUpdateListener> ();

    private final Map<Location, FolderListener> folderListeners = new HashMap<Location, FolderListener> ();

    public ConnectionImpl ( final ConnectionInformation connectionInformation ) throws Exception
    {
        super ( new ProtocolConfigurationFactoryImpl ( connectionInformation ), connectionInformation );
    }

    public static WriteAttributeResults convertResults ( final List<AttributeWriteResultEntry> attributeResults )
    {
        final WriteAttributeResults result = new WriteAttributeResults ();

        for ( final AttributeWriteResultEntry entry : attributeResults )
        {
            result.put ( entry.getAttribute (), convertResult ( entry.getErrorInformation () ) );
        }

        return result;
    }

    private static WriteAttributeResult convertResult ( final ErrorInformation errorInformation )
    {
        if ( errorInformation == null )
        {
            return WriteAttributeResult.OK;
        }
        else
        {
            return new WriteAttributeResult ( new OperationException ( errorInformation.getMessage () ).fillInStackTrace () );
        }
    }

    @Override
    public synchronized void browse ( final Location location, final BrowseOperationCallback callback )
    {
        final NotifyFuture<Entry[]> future = browse ( location );
        if ( callback != null )
        {
            future.addListener ( new FutureListener<Entry[]> () {

                @Override
                public void complete ( final Future<Entry[]> future )
                {
                    try
                    {
                        callback.complete ( future.get () );
                    }
                    catch ( final Exception e )
                    {
                        callback.error ( e );
                    }
                }
            } );
        }
    }

    public synchronized NotifyFuture<Entry[]> browse ( final Location location )
    {
        return new BrowseFuture ( this.executor, sendRequestMessage ( new BrowseFolder ( nextRequest (), location.asList () ) ) );
    }

    @Override
    public void write ( final String itemId, final Variant value, final OperationParameters operationParameters, final WriteOperationCallback callback )
    {
        final NotifyFuture<WriteResult> future = startWrite ( itemId, value, operationParameters, (CallbackHandler)null );
        org.eclipse.scada.da.client.Helper.transformWrite ( future, callback );
    }

    @Override
    public synchronized NotifyFuture<WriteResult> startWrite ( final String itemId, final Variant value, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        final Request request = nextRequest ();
        final Long callbackHandlerId = registerCallbackHandler ( request, callbackHandler );
        return new WriteFuture ( this.executor, sendRequestMessage ( new StartWriteValue ( request, itemId, value, makeParameters ( operationParameters ), callbackHandlerId ) ) );
    }

    @Override
    public void writeAttributes ( final String itemId, final Map<String, Variant> attributes, final OperationParameters operationParameters, final WriteAttributeOperationCallback callback )
    {
        final NotifyFuture<WriteAttributeResults> future = startWriteAttributes ( itemId, attributes, operationParameters, (CallbackHandler)null );
        org.eclipse.scada.da.client.Helper.transformWriteAttributes ( callback, future );
    }

    @Override
    public synchronized NotifyFuture<WriteAttributeResults> startWriteAttributes ( final String itemId, final Map<String, Variant> attributes, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        final Request request = nextRequest ();
        final Long callbackHandlerId = registerCallbackHandler ( request, callbackHandler );
        return new WriteAttributesFuture ( this.executor, sendRequestMessage ( new StartWriteAttributes ( nextRequest (), itemId, attributes, makeParameters ( operationParameters ), callbackHandlerId ) ) );
    }

    @Override
    public void subscribeFolder ( final Location location ) throws NoConnectionException, OperationException
    {
        sendMessage ( new SubscribeFolder ( location.asList () ) );
    }

    @Override
    public void unsubscribeFolder ( final Location location ) throws NoConnectionException, OperationException
    {
        sendMessage ( new UnsubscribeFolder ( location.asList () ) );
    }

    @Override
    public synchronized FolderListener setFolderListener ( final Location location, final FolderListener listener )
    {
        return this.folderListeners.put ( location, listener );
    }

    @Override
    public void subscribeItem ( final String itemId ) throws NoConnectionException, OperationException
    {
        logger.debug ( "Subscribe item: {}", itemId );
        sendMessage ( new SubscribeItem ( itemId ) );
    }

    @Override
    public void unsubscribeItem ( final String itemId ) throws NoConnectionException, OperationException
    {
        sendMessage ( new UnsubscibeItem ( itemId ) );
    }

    @Override
    public synchronized ItemUpdateListener setItemUpdateListener ( final String itemId, final ItemUpdateListener listener )
    {
        return this.itemListeners.put ( itemId, listener );
    }

    @Override
    protected synchronized void handleMessage ( final Object message )
    {
        if ( message instanceof ItemDataUpdate )
        {
            handleItemDataUpdate ( (ItemDataUpdate)message );
        }
        else if ( message instanceof FolderDataUpdate )
        {
            handleFolderDataUpdate ( (FolderDataUpdate)message );
        }
        else if ( message instanceof ItemStateUpdate )
        {
            handleItemStateUpdate ( (ItemStateUpdate)message );
        }
        else
        {
            super.handleMessage ( message );
        }
    }

    private void handleFolderDataUpdate ( final FolderDataUpdate message )
    {
        final FolderListener listener = this.folderListeners.get ( new Location ( message.getLocation () ) );
        if ( listener != null )
        {
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    listener.folderChanged ( convert ( message.getAddedOrModified () ), message.getRemoved (), message.isFull () );
                }
            } );
        }
    }

    private void handleItemDataUpdate ( final ItemDataUpdate message )
    {
        final ItemUpdateListener listener = this.itemListeners.get ( message.getItemId () );
        if ( listener != null )
        {
            this.executor.execute ( new Runnable () {
                @Override
                public void run ()
                {
                    listener.notifyDataChange ( message.getValue (), makeAttributes ( message.getAddedOrUpdated (), message.getRemoved () ), message.isCacheValue () );
                }
            } );
        }
    }

    private void handleItemStateUpdate ( final ItemStateUpdate message )
    {
        final ItemUpdateListener listener = this.itemListeners.get ( message.getItemId () );
        if ( listener != null )
        {
            this.executor.execute ( new Runnable () {
                @Override
                public void run ()
                {
                    listener.notifySubscriptionChange ( message.getSubscriptionState (), null );
                }
            } );
        }
    }

    @Override
    public ScheduledExecutorService getExecutor ()
    {
        return this.executor;
    }

    protected static Map<String, Variant> makeAttributes ( final Map<String, Variant> addedOrUpdated, final Set<String> removed )
    {
        final int addedOrUpdatedSize = addedOrUpdated != null ? addedOrUpdated.size () : 0;
        final int removedSize = removed != null ? removed.size () : 0;

        final Map<String, Variant> result = new HashMap<String, Variant> ( addedOrUpdatedSize + removedSize );

        if ( addedOrUpdated != null )
        {
            result.putAll ( addedOrUpdated );
        }
        if ( removed != null )
        {
            for ( final String itemId : removed )
            {
                result.put ( itemId, null );
            }
        }

        return result;
    }

    protected Collection<Entry> convert ( final List<BrowserEntry> addedOrModified )
    {
        return Arrays.asList ( Helper.convert ( addedOrModified ) );
    }

    protected static org.eclipse.scada.core.data.OperationParameters makeParameters ( final OperationParameters operationParameters )
    {
        if ( operationParameters == null )
        {
            return null;
        }

        final Map<String, String> properties = new HashMap<String, String> ( 0 );

        UserInformation userInformation = null;

        if ( operationParameters.getUserInformation () != null )
        {
            userInformation = new UserInformation ( operationParameters.getUserInformation ().getName () );
        }

        return new org.eclipse.scada.core.data.OperationParameters ( userInformation, properties );
    }

}
