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
package org.eclipse.scada.da.server.exporter.modbus.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.eclipse.scada.core.AttributesHelper;
import org.eclipse.scada.core.InvalidSessionException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.core.server.Hive;
import org.eclipse.scada.da.core.server.InvalidItemException;
import org.eclipse.scada.da.core.server.ItemChangeListener;
import org.eclipse.scada.da.core.server.Session;
import org.eclipse.scada.utils.concurrent.FutureListener;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractSubscriptionManager
{
    private final static Logger logger = LoggerFactory.getLogger ( AbstractSubscriptionManager.class );

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

    protected volatile boolean disposed = false;

    private final HiveSource hiveSource;

    private final HiveSourceListener hiveListener = new HiveSourceListener () {

        @Override
        public void setHive ( final Hive hive )
        {
            AbstractSubscriptionManager.this.performSetHive ( hive );
        }
    };

    /**
     * Create a new subscription manager
     * 
     * @param hiveSource
     *            the source of the hive to attach to
     * @param properties
     *            the hive connection properties
     */
    public AbstractSubscriptionManager ( final HiveSource hiveSource, final Properties properties )
    {
        this.properties = properties;
        this.hiveSource = hiveSource;
        this.hiveSource.addListener ( this.hiveListener );
    }

    protected synchronized void performSetHive ( final Hive hive )
    {
        if ( this.disposed )
        {
            return;
        }

        unbind ();
        clearCache ();
        bind ( hive );
    }

    protected void bind ( final Hive hive )
    {
        // set new hive
        this.hive = hive;

        // create new session
        if ( this.hive != null )
        {
            this.createSessionFuture = hive.createSession ( this.properties, null );
            this.createSessionFuture.addListener ( new FutureListener<Session> () {

                @Override
                public void complete ( final Future<Session> future )
                {
                    handleCreateSessionResult ( future );
                }
            } );
        }
    }

    protected void unbind ()
    {
        if ( this.session != null && this.hive != null )
        {
            try
            {
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

        try
        {
            this.session = future.get ();
            this.session.setListener ( this.itemChangeListener );
            subscribeItems ();
        }
        catch ( InterruptedException | ExecutionException e )
        {
            logger.warn ( "Failed to create hive session", e );
        }
    }

    public synchronized void dispose ()
    {
        if ( this.disposed )
        {
            return;
        }

        this.disposed = true;

        this.hiveSource.removeListener ( this.hiveListener );

        unbind ();
        clearCache ();
    }

    private void subscribeItems ()
    {
        for ( final String itemId : this.subscribeList )
        {
            performSubscribe ( itemId );
        }
    }

    protected synchronized void subscribe ( final String itemId )
    {
        logger.trace ( "Subscribe to - itemId: {}", itemId );

        if ( this.disposed )
        {
            return;
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
        if ( this.disposed )
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
        if ( this.disposed )
        {
            return Collections.emptyMap ();
        }

        return new HashMap<> ( this.cache );
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
}
