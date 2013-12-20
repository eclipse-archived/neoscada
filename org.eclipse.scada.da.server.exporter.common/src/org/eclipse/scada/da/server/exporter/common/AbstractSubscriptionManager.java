/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.core.AttributesHelper;
import org.eclipse.scada.core.InvalidSessionException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.core.server.Hive;
import org.eclipse.scada.da.core.server.InvalidItemException;
import org.eclipse.scada.da.core.server.ItemChangeListener;
import org.eclipse.scada.da.core.server.Session;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.sec.callback.PropertiesCredentialsCallback;
import org.eclipse.scada.utils.concurrent.FutureListener;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractSubscriptionManager
{
    private final static Logger logger = LoggerFactory.getLogger ( AbstractSubscriptionManager.class );

    private static final long RECREATE_DELAY = Long.getLong ( "org.eclipse.scada.da.server.exporter.common.hive.recreateDelay", 10_000 );

    private Hive hive;

    private final Properties properties;

    private Session session;

    private NotifyFuture<Session> createSessionFuture;

    private final Set<String> subscribeList = new HashSet<> ();

    protected final Map<String, DataItemValue> cache = new HashMap<> ();

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

    protected volatile boolean started = false;

    private final HiveSource hiveSource;

    private final HiveSourceListener hiveListener = new HiveSourceListener () {

        @Override
        public void setHive ( final Hive hive )
        {
            AbstractSubscriptionManager.this.performSetHive ( hive );
        }
    };

    private final ScheduledExecutorService executor;

    private ScheduledFuture<?> sessionJob;

    /**
     * Create a new subscription manager
     * 
     * @param hiveSource
     *            the source of the hive to attach to
     * @param properties
     *            the hive connection properties
     */
    public AbstractSubscriptionManager ( final HiveSource hiveSource, final Properties properties, final ScheduledExecutorService executor )
    {
        this.properties = properties;
        this.hiveSource = hiveSource;
        this.executor = executor;
    }

    public synchronized void start ()
    {
        if ( this.started )
        {
            return;
        }

        this.started = true;
        this.hiveSource.addListener ( this.hiveListener );
    }

    public synchronized void stop ()
    {
        if ( !this.started )
        {
            return;
        }

        logger.debug ( "Stopping..." );

        this.started = false;
        this.subscribeList.clear ();

        this.hiveSource.removeListener ( this.hiveListener );

        unbind ();
        clearCache ();
    }

    protected synchronized void performSetHive ( final Hive hive )
    {
        logger.debug ( "Perform set hive: {}", hive );

        if ( !this.started )
        {
            return;
        }

        unbind ();
        clearCache ();
        bind ( hive );
    }

    protected void bind ( final Hive hive )
    {
        logger.debug ( "Binding to hive: {}", hive );

        // set new hive
        this.hive = hive;

        // create new session
        if ( this.hive != null )
        {
            logger.info ( "Creating new session" );

            createSession ();
        }
    }

    private synchronized void createSession ()
    {
        if ( this.hive == null )
        {
            logger.debug ( "Hive is gone, so stop it" );
            return;
        }

        logger.debug ( "Start creating a new session" );

        this.createSessionFuture = this.hive.createSession ( this.properties, new PropertiesCredentialsCallback ( this.properties ) );
        this.createSessionFuture.addListener ( new FutureListener<Session> () {

            @Override
            public void complete ( final Future<Session> future )
            {
                handleCreateSessionResult ( future );
            }
        } );
    }

    protected void unbind ()
    {
        if ( this.sessionJob != null )
        {
            this.sessionJob.cancel ( false );
            this.sessionJob = null;
        }

        if ( this.session != null && this.hive != null )
        {
            try
            {
                logger.debug ( "Closing session: {}", this.session );
                this.hive.closeSession ( this.session );
            }
            catch ( final InvalidSessionException e )
            {
                logger.warn ( "Failed to close old session", e );
            }
            this.session = null;
            this.hive = null;
        }

        if ( this.createSessionFuture != null )
        {
            this.createSessionFuture.cancel ( true );
            this.createSessionFuture = null;
        }
    }

    protected synchronized void handleCreateSessionResult ( final Future<Session> future )
    {
        this.createSessionFuture = null;

        logger.debug ( "Creation session call returned" );

        try
        {
            this.session = future.get ();
            logger.debug ( "Got session: {}", this.session );
            this.session.setListener ( this.itemChangeListener );
            subscribeItems ();
        }
        catch ( InterruptedException | ExecutionException e )
        {
            logger.warn ( "Failed to create hive session", e );
            rescheduleSession ();
        }
    }

    private synchronized void rescheduleSession ()
    {
        logger.info ( "Reschedule session creation" );
        this.sessionJob = this.executor.schedule ( new Runnable () {

            @Override
            public void run ()
            {
                timerCreateSession ();
            }
        }, RECREATE_DELAY, TimeUnit.MILLISECONDS );
    }

    private synchronized void timerCreateSession ()
    {
        logger.debug ( "Starting session by timer" );
        this.sessionJob = null;
        createSession ();
    }

    private void subscribeItems ()
    {
        logger.debug ( "Subscribe to known items - {}", this.subscribeList.size () );

        for ( final String itemId : this.subscribeList )
        {
            performSubscribe ( itemId );
        }
    }

    /**
     * Subscribe to an item
     * <p>
     * Subscriptions may only be made after the manager was started using
     * {@link #start()}.
     * </p>
     * 
     * @param itemId
     *            id of the item to subscribe to
     */
    protected synchronized void subscribe ( final String itemId )
    {
        logger.trace ( "Subscribe to - itemId: {}", itemId );

        if ( this.started )
        {
            throw new IllegalStateException ( "Items may only be subscribed when manager is started" );
        }

        if ( !this.subscribeList.add ( itemId ) )
        {
            return;
        }

        if ( this.hive == null || this.session == null )
        {
            return;
        }
        performSubscribe ( itemId );
    }

    /**
     * Subscribe to multiple items
     * <p>
     * Subscriptions may only be made after the manager was started using
     * {@link #start()}.
     * </p>
     * 
     * @param itemIds
     *            the ids of the items to subscribe to
     */
    protected synchronized void subscribeAll ( final Set<String> itemIds )
    {
        if ( itemIds == null )
        {
            return;
        }

        for ( final String itemId : itemIds )
        {
            subscribe ( itemId );
        }
    }

    private void performSubscribe ( final String itemId )
    {
        try
        {
            logger.debug ( "Perform subscribe - itemId: {}", itemId );
            this.hive.subscribeItem ( this.session, itemId );
        }
        catch ( InvalidSessionException | InvalidItemException e )
        {
            putState ( itemId, new DataItemValue ( Variant.NULL, null, SubscriptionState.DISCONNECTED, e ) );
        }
    }

    protected synchronized void unsubscribe ( final String itemId )
    {
        if ( this.started )
        {
            return;
        }

        if ( !this.subscribeList.remove ( itemId ) )
        {
            return;
        }
        putState ( itemId, null );

        if ( this.hive != null && this.session != null )
        {
            try
            {
                this.hive.unsubscribeItem ( this.session, itemId );
            }
            catch ( InvalidSessionException | InvalidItemException e )
            {
                logger.warn ( "Failed to unsubscribe item", e );
            }
        }

    }

    protected void clearCache ()
    {
        this.cache.clear ();
    }

    protected void putState ( final String itemId, final DataItemValue value )
    {
        logger.trace ( "Cache put - itemId: {}, value: {}", itemId, value );

        if ( value == null )
        {
            this.cache.remove ( itemId );
        }
        else
        {
            this.cache.put ( itemId, value );
        }
    }

    public synchronized Map<String, DataItemValue> getCacheCopy ()
    {
        if ( !this.started )
        {
            return Collections.emptyMap ();
        }

        return new HashMap<> ( this.cache );
    }

    public synchronized DataItemValue getCacheValue ( final String itemId )
    {
        if ( !this.started )
        {
            return null;
        }
        return this.cache.get ( itemId );
    }

    protected synchronized void handleDataChanged ( final String itemId, final Variant value, final Map<String, Variant> attributes, final boolean cache )
    {
        logger.trace ( "DataChange - itemId: {}, value: {}, attributes: {}, cache: {}", itemId, value, attributes, cache );

        if ( !this.subscribeList.contains ( itemId ) || this.session == null || this.hive == null )
        {
            return;
        }

        if ( cache )
        {
            // full update
            putState ( itemId, new DataItemValue ( value, attributes, SubscriptionState.CONNECTED, null ) );
            return;
        }

        final DataItemValue oldState = this.cache.get ( itemId );
        if ( oldState == null )
        {
            // initial update
            putState ( itemId, new DataItemValue ( value, attributes, SubscriptionState.CONNECTED, null ) );
            return;
        }

        final DataItemValue.Builder builder = new DataItemValue.Builder ( oldState );
        if ( value != null )
        {
            builder.setValue ( value );
        }
        if ( attributes != null )
        {
            AttributesHelper.mergeAttributes ( builder.getAttributes (), attributes );
        }

        // put the state to the cache
        putState ( itemId, builder.build () );
    }

    protected void handleSubscriptionChanged ( final String itemId, final SubscriptionState subscriptionState )
    {
        if ( !this.subscribeList.contains ( itemId ) || this.session == null || this.hive == null )
        {
            return;
        }

        final DataItemValue oldState = this.cache.get ( itemId );
        if ( oldState == null )
        {
            // initial update
            putState ( itemId, new DataItemValue ( Variant.NULL, null, subscriptionState, null ) );
            return;
        }

        final DataItemValue.Builder builder = new DataItemValue.Builder ( oldState );
        builder.setSubscriptionState ( subscriptionState );

        // put the state to the cache
        putState ( itemId, builder.build () );
    }

    public synchronized NotifyFuture<WriteResult> writeValue ( final String itemId, final Variant value, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        try
        {
            return this.hive.startWrite ( this.session, itemId, value, operationParameters, callbackHandler );
        }
        catch ( final Exception e )
        {
            return new InstantErrorFuture<> ( e );
        }
    }

    public synchronized NotifyFuture<WriteAttributeResults> writeAttributes ( final String itemId, final Map<String, Variant> attributes, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        try
        {
            return this.hive.startWriteAttributes ( this.session, itemId, attributes, operationParameters, callbackHandler );
        }
        catch ( final Exception e )
        {
            return new InstantErrorFuture<> ( e );
        }
    }
}
