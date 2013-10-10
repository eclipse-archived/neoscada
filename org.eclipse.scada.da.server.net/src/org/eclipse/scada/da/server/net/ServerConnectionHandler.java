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
package org.eclipse.scada.da.server.net;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Future;

import org.apache.mina.core.session.IoSession;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.InvalidSessionException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.core.net.MessageHelper;
import org.eclipse.scada.core.server.Session.SessionListener;
import org.eclipse.scada.da.core.Location;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.core.browser.Entry;
import org.eclipse.scada.da.core.server.Hive;
import org.eclipse.scada.da.core.server.InvalidItemException;
import org.eclipse.scada.da.core.server.ItemChangeListener;
import org.eclipse.scada.da.core.server.Session;
import org.eclipse.scada.da.core.server.browser.FolderListener;
import org.eclipse.scada.da.core.server.browser.HiveBrowser;
import org.eclipse.scada.da.core.server.browser.NoSuchFolderException;
import org.eclipse.scada.da.net.handler.ListBrowser;
import org.eclipse.scada.da.net.handler.Messages;
import org.eclipse.scada.da.net.handler.WriteAttributesOperation;
import org.eclipse.scada.net.base.MessageListener;
import org.eclipse.scada.net.base.data.LongValue;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.base.data.StringValue;
import org.eclipse.scada.net.utils.MessageCreator;
import org.eclipse.scada.sec.callback.PropertiesCredentialsCallback;
import org.eclipse.scada.utils.concurrent.FutureListener;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.concurrent.task.DefaultTaskHandler;
import org.eclipse.scada.utils.concurrent.task.ResultFutureHandler;
import org.eclipse.scada.utils.concurrent.task.ResultHandler;
import org.eclipse.scada.utils.concurrent.task.TaskHandler;
import org.eclipse.scada.utils.lang.Holder;
import org.eclipse.scada.core.server.net.AbstractServerConnectionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerConnectionHandler extends AbstractServerConnectionHandler implements ItemChangeListener, FolderListener
{

    public final static String VERSION = "0.1.8";

    private final static Logger logger = LoggerFactory.getLogger ( ServerConnectionHandler.class );

    private Hive hive = null;

    private Session session = null;

    private final TaskHandler taskHandler = new DefaultTaskHandler ();

    private final Set<Long> taskMap = new HashSet<Long> ();

    public ServerConnectionHandler ( final Hive hive, final IoSession ioSession, final ConnectionInformation connectionInformation )
    {
        super ( ioSession, connectionInformation );

        this.hive = hive;

        this.messenger.setHandler ( MessageHelper.CC_CREATE_SESSION, new MessageListener () {

            @Override
            public void messageReceived ( final Message message )
            {
                createSession ( message );
            }
        } );

        this.messenger.setHandler ( MessageHelper.CC_CLOSE_SESSION, new MessageListener () {

            @Override
            public void messageReceived ( final Message message )
            {
                closeSession ();
            }
        } );

        this.messenger.setHandler ( Messages.CC_SUBSCRIBE_ITEM, new MessageListener () {

            @Override
            public void messageReceived ( final Message message )
            {
                subscribe ( message );
            }
        } );

        this.messenger.setHandler ( Messages.CC_UNSUBSCRIBE_ITEM, new MessageListener () {

            @Override
            public void messageReceived ( final Message message )
            {
                unsubscribe ( message );
            }
        } );

        this.messenger.setHandler ( Messages.CC_WRITE_OPERATION, new MessageListener () {

            @Override
            public void messageReceived ( final Message message )
            {
                performWrite ( message );
            }
        } );

        this.messenger.setHandler ( Messages.CC_WRITE_ATTRIBUTES_OPERATION, new MessageListener () {

            @Override
            public void messageReceived ( final Message message )
            {
                performWriteAttributes ( message );
            }
        } );

        this.messenger.setHandler ( Messages.CC_BROWSER_LIST_REQ, new MessageListener () {

            @Override
            public void messageReceived ( final Message message )
            {
                performBrowse ( message );
            }
        } );

        this.messenger.setHandler ( Messages.CC_BROWSER_SUBSCRIBE, new MessageListener () {

            @Override
            public void messageReceived ( final Message message )
            {
                performBrowserSubscribe ( message );
            }
        } );

        this.messenger.setHandler ( Messages.CC_BROWSER_UNSUBSCRIBE, new MessageListener () {

            @Override
            public void messageReceived ( final Message message )
            {
                performBrowserUnsubscribe ( message );
            }
        } );
    }

    private void createSession ( final Message message )
    {
        // if session exists this is an error
        if ( this.session != null )
        {
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( message, "Connection already bound to a session" ) );
            return;
        }

        // get the session properties
        final Properties props = new Properties ();
        MessageHelper.getProperties ( props, message.getValues ().get ( "properties" ) );

        debugSessionDelay ( props );

        // now check client version
        final String clientVersion = props.getProperty ( "client-version", "" );
        if ( clientVersion.equals ( "" ) )
        {
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( message, "client does not pass \"client-version\" property! You may need to upgrade your client!" ) );
            return;
        }
        // client version does not match server version
        if ( !clientVersion.equals ( VERSION ) )
        {
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( message, String.format ( "protocol version mismatch: client '%s' server: '%s'", clientVersion, VERSION ) ) );
            return;
        }

        this.hive.createSession ( props, new PropertiesCredentialsCallback ( props ) ).addListener ( new FutureListener<Session> () {

            @Override
            public void complete ( final Future<Session> future )
            {
                handleCreateSessionComplete ( future, message, props );
            }
        } );

    }

    /**
     * @since 1.0
     */
    protected void handleCreateSessionComplete ( final Future<Session> future, final Message message, final Properties props )
    {
        try
        {
            this.session = future.get ();
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to create session", e );
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( message, e ) );
            return;
        }

        // unknown reason why we did not get a session
        if ( this.session == null )
        {
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( message, "unable to create session" ) );
            return;
        }

        // we have a working session .. so connect listeners
        this.session.setListener ( (ItemChangeListener)this );
        this.session.setListener ( (FolderListener)this );

        // send success
        replySessionCreated ( props, message, this.session.getProperties () );

        // hook up privs
        this.session.addSessionListener ( new SessionListener () {

            @Override
            public void privilegeChange ()
            {
                sendPrivilegeChange ( ServerConnectionHandler.this.session.getPrivileges () );
            }
        } );
    }

    private void debugSessionDelay ( final Properties props )
    {
        try
        {
            final String delayString = props.getProperty ( "debug.sessionDelay" );
            if ( delayString == null || delayString.isEmpty () )
            {
                return;
            }
            final long delay = Long.parseLong ( delayString );

            if ( delay > 0 )
            {
                logger.warn ( "Delaying session creation by {} ms", delay );

                Thread.sleep ( delay );
            }
        }
        catch ( final Exception e )
        {
        }
    }

    private void disposeSession ()
    {
        // if session does not exists, silently ignore it
        if ( this.session != null )
        {
            try
            {
                this.hive.closeSession ( this.session );
            }
            catch ( final InvalidSessionException e )
            {
                logger.warn ( "Failed to close session", e );
            }
        }
    }

    private void closeSession ()
    {
        cleanUp ();
    }

    private void subscribe ( final Message message )
    {
        if ( this.session == null )
        {
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( message, "No session" ) );
            return;
        }

        final String itemName = message.getValues ().get ( "item-id" ).toString ();
        final boolean initial = message.getValues ().containsKey ( "cache-read" );

        logger.debug ( "Subscribe to {} initial {}", itemName, initial );

        try
        {
            this.hive.subscribeItem ( this.session, itemName );
        }
        catch ( final InvalidSessionException e )
        {
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( message, "Invalid session" ) );
        }
        catch ( final InvalidItemException e )
        {
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( message, "Invalid item" ) );
        }

    }

    private void unsubscribe ( final Message message )
    {
        if ( this.session == null )
        {
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( message, "No session" ) );
            return;
        }

        final String itemName = message.getValues ().get ( "item-id" ).toString ();

        try
        {
            this.hive.unsubscribeItem ( this.session, itemName );
        }
        catch ( final InvalidSessionException e )
        {
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( message, "Invalid session" ) );
        }
        catch ( final InvalidItemException e )
        {
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( message, "Invalid item" ) );
        }
    }

    @Override
    protected void cleanUp ()
    {
        super.cleanUp ();
        disposeSession ();
    }

    @Override
    public void dataChanged ( final String itemId, final Variant value, final Map<String, Variant> attributes, final boolean cache )
    {
        logger.debug ( "Data changed - itemId: {}, value: {}, attributes: {}, cache: {}", new Object[] { itemId, value, attributes, cache } );

        this.messenger.sendMessage ( Messages.notifyData ( itemId, value, attributes, cache ) );
    }

    @Override
    public void subscriptionChanged ( final String item, final SubscriptionState subscriptionState )
    {
        this.messenger.sendMessage ( Messages.notifySubscriptionChange ( item, subscriptionState ) );
    }

    private void performWrite ( final Message request )
    {
        final Holder<String> itemId = new Holder<String> ();
        final Holder<Variant> value = new Holder<Variant> ();
        final Holder<OperationParameters> operationParameters = new Holder<OperationParameters> ();

        org.eclipse.scada.da.net.handler.WriteOperation.parse ( request, itemId, value, operationParameters );

        try
        {
            final NotifyFuture<WriteResult> task = this.hive.startWrite ( this.session, itemId.value, value.value, operationParameters.value, null );
            final TaskHandler.Handle handle = this.taskHandler.addTask ( task );

            try
            {
                final Message reply = MessageCreator.createACK ( request );
                reply.getValues ().put ( "id", new LongValue ( handle.getId () ) );
                this.messenger.sendMessage ( reply );
            }
            catch ( final Throwable e )
            {
                task.cancel ( true );
                throw e;
            }

            scheduleTask ( task, handle.getId (), new ResultHandler<WriteResult> () {

                @Override
                public void completed ( final WriteResult result )
                {
                    final Message replyMessage = new Message ( Messages.CC_WRITE_OPERATION_RESULT );
                    replyMessage.getValues ().put ( "id", new LongValue ( handle.getId () ) );
                    ServerConnectionHandler.this.messenger.sendMessage ( replyMessage );
                    handle.dispose ();
                }

                @Override
                public void failed ( final Throwable e )
                {
                    logger.debug ( "Failed to process write request", e );

                    final Message replyMessage = new Message ( Messages.CC_WRITE_OPERATION_RESULT );
                    replyMessage.getValues ().put ( Message.FIELD_ERROR_INFO, new StringValue ( e.getMessage () ) );
                    replyMessage.getValues ().put ( "id", new LongValue ( handle.getId () ) );
                    ServerConnectionHandler.this.messenger.sendMessage ( replyMessage );
                    handle.dispose ();
                }
            } );

        }
        catch ( final Throwable e )
        {
            logger.debug ( String.format ( "Failed to write to item: %s", itemId.value ), e );
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( request, e ) );
        }
    }

    private <T> void scheduleTask ( final NotifyFuture<T> task, final long id, final ResultHandler<T> resultHandler )
    {
        task.addListener ( new ResultFutureHandler<T> ( resultHandler ) );
    }

    private void removeTask ( final long id )
    {
        synchronized ( this.taskMap )
        {
            this.taskMap.remove ( id );
        }
    }

    private void performWriteAttributes ( final Message request )
    {
        final Holder<String> itemId = new Holder<String> ();
        final Holder<Map<String, Variant>> attributes = new Holder<Map<String, Variant>> ();
        final Holder<OperationParameters> operationParameters = new Holder<OperationParameters> ();

        WriteAttributesOperation.parseRequest ( request, itemId, attributes, operationParameters );

        try
        {
            final NotifyFuture<WriteAttributeResults> task = this.hive.startWriteAttributes ( this.session, itemId.value, attributes.value, operationParameters.value, null );
            final TaskHandler.Handle handle = this.taskHandler.addTask ( task );

            try
            {
                final Message reply = MessageCreator.createACK ( request );
                reply.getValues ().put ( "id", new LongValue ( handle.getId () ) );
                this.messenger.sendMessage ( reply );
            }
            catch ( final Throwable e )
            {
                task.cancel ( true );
                throw e;
            }

            scheduleTask ( task, handle.getId (), new ResultHandler<WriteAttributeResults> () {

                @Override
                public void completed ( final WriteAttributeResults result )
                {
                    final Message message = WriteAttributesOperation.createResponse ( handle.getId (), result );
                    ServerConnectionHandler.this.messenger.sendMessage ( message );
                    handle.dispose ();
                }

                @Override
                public void failed ( final Throwable e )
                {
                    final Message message = WriteAttributesOperation.createResponse ( handle.getId (), e );
                    ServerConnectionHandler.this.messenger.sendMessage ( message );
                    handle.dispose ();
                }
            } );

        }
        catch ( final Throwable e )
        {
            logger.debug ( String.format ( "Failed to write attributes to item: %s", itemId.value ), e );
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( request, e ) );
        }
    }

    private void performBrowse ( final Message request )
    {
        final String[] location = ListBrowser.parseRequest ( request );

        final HiveBrowser browser = this.hive.getBrowser ();
        if ( browser == null )
        {
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( request, "Browsing not supported" ) );
            return;
        }

        try
        {
            final NotifyFuture<Entry[]> task = browser.startBrowse ( this.session, new Location ( location ) );

            final TaskHandler.Handle handle = this.taskHandler.addTask ( task );

            try
            {
                final Message reply = MessageCreator.createACK ( request );
                reply.getValues ().put ( "id", new LongValue ( handle.getId () ) );
                this.messenger.sendMessage ( reply );
            }
            catch ( final Throwable e )
            {
                removeTask ( handle.getId () );
                task.cancel ( true );
                throw e;
            }

            scheduleTask ( task, handle.getId (), new ResultHandler<Entry[]> () {

                @Override
                public void completed ( final Entry[] result )
                {
                    ServerConnectionHandler.this.messenger.sendMessage ( ListBrowser.createResponse ( handle.getId (), result ) );
                    handle.dispose ();
                }

                @Override
                public void failed ( final Throwable e )
                {
                    ServerConnectionHandler.this.messenger.sendMessage ( ListBrowser.createResponse ( handle.getId (), e.getMessage () ) );
                    handle.dispose ();
                }
            } );

        }
        catch ( final Throwable e )
        {
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( request, e ) );
        }
    }

    @Override
    public void folderChanged ( final Location location, final List<Entry> added, final Set<String> removed, final boolean full )
    {
        logger.debug ( "Got folder change event from hive for folder: {}", location );
        this.messenger.sendMessage ( ListBrowser.createEvent ( location.asArray (), added, removed, full ) );
    }

    private void performBrowserSubscribe ( final Message message )
    {
        final HiveBrowser browser = this.hive.getBrowser ();

        if ( browser == null )
        {
            logger.warn ( "Unable to subscribe to folder: no hive browser set" );
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( message, "Interface not supported" ) );
            return;
        }

        final Location location = new Location ( ListBrowser.parseSubscribeMessage ( message ) );

        try
        {
            logger.debug ( "Subscribe to folder: {}", location.toString () );
            browser.subscribe ( this.session, location );
        }
        catch ( final NoSuchFolderException e )
        {
            logger.warn ( "Unable to subscribe to folder: " + location, e );
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( message, "Folder not found" ) );
            return;
        }
        catch ( final InvalidSessionException e )
        {
            logger.warn ( "Unable to subscribe to folder: " + location, e );
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( message, "Invalid session" ) );
            return;
        }
        catch ( final Exception e )
        {
            logger.warn ( "Browsing failed", e );
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( message, e ) );
            return;
        }
    }

    private void performBrowserUnsubscribe ( final Message message )
    {
        final HiveBrowser browser = this.hive.getBrowser ();

        if ( browser == null )
        {
            logger.warn ( "Unable to unsubscribe from folder: no hive browser set" );
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( message, "Interface not supported" ) );
            return;
        }

        final Location location = new Location ( ListBrowser.parseUnsubscribeMessage ( message ) );

        try
        {
            logger.debug ( "Unsubscribe from folder: {}", location.toString () );
            browser.unsubscribe ( this.session, location );
        }
        catch ( final NoSuchFolderException e )
        {
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( message, "Folder not found" ) );
            return;
        }
        catch ( final InvalidSessionException e )
        {
            this.messenger.sendMessage ( MessageCreator.createFailedMessage ( message, "Invalid session" ) );
            return;
        }
    }

}
