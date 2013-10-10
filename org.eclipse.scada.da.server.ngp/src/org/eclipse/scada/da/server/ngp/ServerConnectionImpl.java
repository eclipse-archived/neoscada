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
package org.eclipse.scada.da.server.ngp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

import org.apache.mina.core.session.IoSession;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.ErrorInformation;
import org.eclipse.scada.core.data.Response;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.core.server.ngp.ServiceServerConnection;
import org.eclipse.scada.da.core.Location;
import org.eclipse.scada.da.core.WriteAttributeResult;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.core.browser.DataItemEntry;
import org.eclipse.scada.da.core.browser.Entry;
import org.eclipse.scada.da.core.browser.FolderEntry;
import org.eclipse.scada.da.core.server.Hive;
import org.eclipse.scada.da.core.server.ItemChangeListener;
import org.eclipse.scada.da.core.server.Session;
import org.eclipse.scada.da.core.server.browser.FolderListener;
import org.eclipse.scada.da.data.AttributeWriteResultEntry;
import org.eclipse.scada.da.data.BrowserEntry;
import org.eclipse.scada.da.data.FolderEntryType;
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
import org.eclipse.scada.utils.ExceptionHelper;
import org.eclipse.scada.utils.concurrent.FutureListener;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerConnectionImpl extends ServiceServerConnection<Session, Hive>
{

    private final static Logger logger = LoggerFactory.getLogger ( ServerConnectionImpl.class );

    private final ItemChangeListener itemChangeListener = new ItemChangeListener () {

        @Override
        public void subscriptionChanged ( final String itemId, final SubscriptionState subscriptionState )
        {
            handleSubscriptionChanged ( itemId, subscriptionState );
        }

        @Override
        public void dataChanged ( final String itemId, final Variant value, final Map<String, Variant> attributes, final boolean cache )
        {
            handleDataChanged ( itemId, value, attributes, cache );
        }
    };

    private final FolderListener folderListener = new FolderListener () {

        @Override
        public void folderChanged ( final Location location, final List<Entry> added, final Set<String> removed, final boolean full )
        {
            handleFolderChanged ( location, added, removed, full );
        }

    };

    public ServerConnectionImpl ( final IoSession session, final Hive service )
    {
        super ( session, service );
    }

    private static List<BrowserEntry> convertEntries ( final Collection<Entry> added )
    {
        if ( added == null )
        {
            return null;
        }

        final List<BrowserEntry> result = new ArrayList<BrowserEntry> ( added.size () );

        for ( final Entry entry : added )
        {
            final BrowserEntry newEntry = convertEntry ( entry );
            if ( newEntry != null )
            {
                result.add ( newEntry );
            }
        }

        return result;
    }

    private static BrowserEntry convertEntry ( final Entry entry )
    {
        if ( entry instanceof FolderEntry )
        {
            return new BrowserEntry ( entry.getName (), FolderEntryType.FOLDER, null, entry.getAttributes (), null );
        }
        else if ( entry instanceof DataItemEntry )
        {
            return new BrowserEntry ( entry.getName (), FolderEntryType.ITEM, ( (DataItemEntry)entry ).getId (), entry.getAttributes (), ( (DataItemEntry)entry ).getIODirections () );
        }
        else
        {
            return null;
        }
    }

    protected void handleDataChanged ( final String itemId, final Variant value, final Map<String, Variant> attributes, final boolean cache )
    {
        final AttributesTransport transport = new AttributesTransport ( attributes );
        sendMessage ( new ItemDataUpdate ( itemId, value, transport.getAddedOrUpdated (), transport.getRemoved (), cache ) );
    }

    protected void handleSubscriptionChanged ( final String itemId, final SubscriptionState subscriptionState )
    {
        sendMessage ( new ItemStateUpdate ( itemId, subscriptionState, null ) );
    }

    protected void handleFolderChanged ( final Location location, final Collection<Entry> added, final Set<String> removed, final boolean full )
    {
        sendMessage ( new FolderDataUpdate ( location.asList (), convertEntries ( added ), removed, full ) );
    }

    /**
     * @since 1.1
     */
    @Override
    protected void initializeSession ( final Session session )
    {
        super.initializeSession ( session );
        session.setListener ( this.itemChangeListener );
        session.setListener ( this.folderListener );
    }

    @Override
    public void handleMessageReceived ( final Object message ) throws Exception
    {
        if ( message instanceof SubscribeItem )
        {
            handleSubscribeItem ( (SubscribeItem)message );
        }
        else if ( message instanceof UnsubscibeItem )
        {
            handleUnsubscibeItem ( (UnsubscibeItem)message );
        }
        else if ( message instanceof SubscribeFolder )
        {
            handelSubscribeFolder ( (SubscribeFolder)message );
        }
        else if ( message instanceof UnsubscribeFolder )
        {
            handelUnsubscribeFolder ( (UnsubscribeFolder)message );
        }
        else if ( message instanceof BrowseFolder )
        {
            handleBrowseFolder ( (BrowseFolder)message );
        }
        else if ( message instanceof StartWriteValue )
        {
            handleStartWriteValue ( (StartWriteValue)message );
        }
        else if ( message instanceof StartWriteAttributes )
        {
            handleStartWriteAttributes ( (StartWriteAttributes)message );
        }
        else
        {
            super.handleMessageReceived ( message );
        }
    }

    private void handleStartWriteValue ( final StartWriteValue message )
    {
        try
        {
            final CallbackHandler callbackHandler = createCallbackHandler ( message.getCallbackHandlerId () );
            final NotifyFuture<WriteResult> future = this.service.startWrite ( this.session, message.getItemId (), message.getValue (), message.getOperationParameters (), callbackHandler );
            future.addListener ( new FutureListener<WriteResult> () {

                @Override
                public void complete ( final Future<WriteResult> future )
                {
                    try
                    {
                        future.get ();
                        sendMessage ( new WriteValueResult ( new Response ( message.getRequest () ), null ) );
                    }
                    catch ( final Exception e )
                    {
                        logger.warn ( "Failed to complete write value", e );
                        sendWriteValueError ( message, e, 0x05L );
                    }
                }
            } );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to start write value", e );
            sendWriteValueError ( message, e, 0x04L );
        }
    }

    private void sendWriteValueError ( final StartWriteValue message, final Exception e, final Long code )
    {
        sendMessage ( new WriteValueResult ( new Response ( message.getRequest () ), new ErrorInformation ( code, e.getMessage (), ExceptionHelper.formatted ( e ) ) ) );
    }

    private void handleStartWriteAttributes ( final StartWriteAttributes message )
    {
        try
        {
            final CallbackHandler callbackHandler = createCallbackHandler ( message.getCallbackHandlerId () );
            final NotifyFuture<WriteAttributeResults> future = this.service.startWriteAttributes ( this.session, message.getItemId (), message.getAttributes (), message.getOperationParameters (), callbackHandler );
            future.addListener ( new FutureListener<WriteAttributeResults> () {

                @Override
                public void complete ( final Future<WriteAttributeResults> future )
                {
                    try
                    {
                        final WriteAttributeResults result = future.get ();
                        sendMessage ( new WriteAttributesResult ( new Response ( message.getRequest () ), convertResult ( result ), null ) );
                    }
                    catch ( final Exception e )
                    {
                        logger.warn ( "Failed to complete write attributes", e );
                        sendWriteAttributesError ( message, e, 0x07L );
                    }
                }
            } );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to start write attributes", e );
            sendWriteAttributesError ( message, e, 0x06L );
        }
    }

    protected List<AttributeWriteResultEntry> convertResult ( final WriteAttributeResults attributeResult )
    {
        if ( attributeResult == null )
        {
            return null;
        }

        final List<AttributeWriteResultEntry> result = new ArrayList<AttributeWriteResultEntry> ( attributeResult.size () );

        for ( final Map.Entry<String, WriteAttributeResult> entry : attributeResult.entrySet () )
        {
            result.add ( new AttributeWriteResultEntry ( entry.getKey (), convertEntry ( entry.getValue () ) ) );
        }

        return result;
    }

    private ErrorInformation convertEntry ( final WriteAttributeResult value )
    {
        if ( ( value == null ) || value.isSuccess () || ( value.getError () == null ) )
        {
            return null;
        }

        return new ErrorInformation ( null, value.getError ().getMessage (), ExceptionHelper.formatted ( value.getError () ) );
    }

    private void sendWriteAttributesError ( final StartWriteAttributes message, final Exception e, final Long code )
    {
        sendMessage ( new WriteAttributesResult ( new Response ( message.getRequest () ), null, new ErrorInformation ( code, e.getMessage (), ExceptionHelper.formatted ( e ) ) ) );
    }

    private void handleBrowseFolder ( final BrowseFolder message )
    {
        try
        {
            final NotifyFuture<Entry[]> future = this.service.getBrowser ().startBrowse ( this.session, new Location ( message.getLocation () ) );
            future.addListener ( new FutureListener<Entry[]> () {

                @Override
                public void complete ( final Future<Entry[]> future )
                {
                    try
                    {
                        final Entry[] result = future.get ();
                        sendMessage ( new BrowseResult ( new Response ( message.getRequest () ), convertEntries ( result ), null ) );
                    }
                    catch ( final Exception e )
                    {
                        logger.warn ( "Browse completed with error", e );
                        sendBrowseError ( message, e, 0x03L );
                    }
                }
            } );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to browse", e );
            sendBrowseError ( message, e, 0x02L );
        }
    }

    protected List<BrowserEntry> convertEntries ( final Entry[] result )
    {
        return convertEntries ( Arrays.asList ( result ) );
    }

    private void handelSubscribeFolder ( final SubscribeFolder message )
    {
        try
        {
            this.service.getBrowser ().subscribe ( this.session, new Location ( message.getLocation () ) );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to subscribe", e );
        }
    }

    private void handelUnsubscribeFolder ( final UnsubscribeFolder message )
    {
        try
        {
            this.service.getBrowser ().unsubscribe ( this.session, new Location ( message.getLocation () ) );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to unsubscribe", e );
        }
    }

    private void handleUnsubscibeItem ( final UnsubscibeItem message )
    {
        try
        {
            this.service.unsubscribeItem ( this.session, message.getItemId () );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to unsubscribe", e );
            sendMessage ( new ItemStateUpdate ( message.getItemId (), SubscriptionState.DISCONNECTED, new ErrorInformation ( 0x01L, e.getMessage (), ExceptionHelper.formatted ( e ) ) ) );
        }
    }

    private void handleSubscribeItem ( final SubscribeItem message )
    {
        try
        {
            this.service.subscribeItem ( this.session, message.getItemId () );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to subscribe", e );
            sendMessage ( new ItemStateUpdate ( message.getItemId (), SubscriptionState.DISCONNECTED, new ErrorInformation ( 0x01L, e.getMessage (), ExceptionHelper.formatted ( e ) ) ) );
        }
    }

    private void sendBrowseError ( final BrowseFolder message, final Exception e, final Long code )
    {
        sendMessage ( new BrowseResult ( new Response ( message.getRequest () ), null, new ErrorInformation ( code, e.getMessage (), ExceptionHelper.formatted ( e ) ) ) );
    }
}
