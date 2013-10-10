/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.AttributesHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.subscription.SubscriptionInformation;
import org.eclipse.scada.core.subscription.SubscriptionSource;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.ItemListener;
import org.eclipse.scada.da.server.common.impl.stats.HiveEventListener;

/**
 * A subscription source for data items. This SubscriptionSource does not use a
 * hint object.
 * 
 * @author Jens Reimann
 */
public class DataItemSubscriptionSource implements SubscriptionSource, ItemListener
{
    private DataItem dataItem = null;

    private final Set<DataItemSubscriptionListener> listeners = new HashSet<DataItemSubscriptionListener> ( 1 );

    private boolean bound = false;

    private Variant cacheValue = null;

    private final Map<String, Variant> cacheAttributes = new HashMap<String, Variant> ();

    private final HiveEventListener hiveEventListener;

    private final Executor executor;

    public DataItemSubscriptionSource ( final Executor executor, final DataItem dataItem, final HiveEventListener hiveEventListener )
    {
        super ();
        this.dataItem = dataItem;
        this.hiveEventListener = hiveEventListener;
        this.executor = executor;
    }

    /**
     * Bind us to the data item
     */
    private synchronized void bind ()
    {
        if ( this.bound )
        {
            return;
        }

        this.bound = true;

        final DataItem item = this.dataItem;
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                item.setListener ( DataItemSubscriptionSource.this );
            }
        } );
    }

    /**
     * Unbind us from the data item
     */
    private synchronized void unbind ()
    {
        if ( !this.bound )
        {
            return;
        }

        this.cacheValue = null;
        this.cacheAttributes.clear ();
        this.bound = false;

        final DataItem item = this.dataItem;
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                item.setListener ( null );
            }
        } );
    }

    @Override
    public synchronized void addListener ( final Collection<SubscriptionInformation> listeners )
    {
        for ( final SubscriptionInformation listener : listeners )
        {
            this.listeners.add ( (DataItemSubscriptionListener)listener.getListener () );
            // send current state

            final DataItem dataItem = this.dataItem;
            final Variant cacheValue = this.cacheValue;
            final Map<String, Variant> attributes = new HashMap<String, Variant> ( this.cacheAttributes );

            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    ( (DataItemSubscriptionListener)listener.getListener () ).dataChanged ( dataItem, cacheValue, attributes, true );
                }
            } );
        }

        if ( !this.listeners.isEmpty () )
        {
            bind ();
        }
    }

    @Override
    public synchronized void removeListener ( final Collection<SubscriptionInformation> listeners )
    {
        for ( final SubscriptionInformation listener : listeners )
        {
            this.listeners.remove ( listener.getListener () );
        }

        if ( this.listeners.isEmpty () )
        {
            unbind ();
        }
    }

    @Override
    public boolean supportsListener ( final SubscriptionInformation subscriptionInformation )
    {
        return subscriptionInformation.getListener () instanceof DataItemSubscriptionListener;
    }

    @Override
    public synchronized void dataChanged ( final DataItem item, final Variant variant, final Map<String, Variant> attributes, final boolean cache )
    {
        // update attributes
        if ( attributes != null )
        {
            AttributesHelper.mergeAttributes ( this.cacheAttributes, attributes );
        }
        // update value
        if ( variant != null )
        {
            this.cacheValue = variant;
        }

        final DataItemSubscriptionListener[] listeners = this.listeners.toArray ( new DataItemSubscriptionListener[this.listeners.size ()] );

        if ( listeners.length > 0 )
        {
            // send out the events
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    fireDataChange ( item, variant, attributes, cache, listeners );
                }
            } );
        }

        if ( this.hiveEventListener != null )
        {
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    updateStats ( item, variant, attributes, cache );
                }
            } );
        }

    }

    private static void fireDataChange ( final DataItem item, final Variant variant, final Map<String, Variant> attributes, final boolean cache, final DataItemSubscriptionListener[] listeners )
    {
        for ( final DataItemSubscriptionListener listener : listeners )
        {
            listener.dataChanged ( item, variant, attributes, cache );
        }
    }

    private void updateStats ( final DataItem item, final Variant variant, final Map<String, Variant> attributes, final boolean cache )
    {
        // send out the hive events
        if ( variant != null )
        {
            this.hiveEventListener.valueChanged ( item, variant, cache );
        }
        if ( attributes != null )
        {
            this.hiveEventListener.attributesChanged ( item, attributes.size () );
        }
    }
}
