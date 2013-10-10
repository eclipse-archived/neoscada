/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.server.proxy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.data.HistoricalItemInformation;
import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hd.server.common.HistoricalItem;
import org.eclipse.scada.hd.server.proxy.ProxyValueSource.ServiceEntry;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;

public class ProxyHistoricalItem implements HistoricalItem
{
    private final String id;

    private final BundleContext context;

    private final Collection<ProxyValueSource> sources = new LinkedList<ProxyValueSource> ();

    private Set<QueryImpl> queries = new HashSet<QueryImpl> ();

    private final Set<ServiceEntry> items = new HashSet<ServiceEntry> ();

    public interface ItemListener
    {
        public void listenersChanges ( Collection<ServiceEntry> added, Collection<ServiceEntry> removed );
    }

    private final Set<ItemListener> listeners = new HashSet<ProxyHistoricalItem.ItemListener> ();

    private final Executor executor;

    public ProxyHistoricalItem ( final BundleContext context, final Executor executor, final String configurationId, final Map<String, String> parameters )
    {
        this.id = configurationId;
        this.context = context;
        this.executor = executor;

        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        final String items = cfg.getStringChecked ( "items", "'items' must be one or more historical items" );
        final String splitter = cfg.getString ( "splitter", "[ ,]+" );

        int i = 0;
        for ( final String item : items.split ( splitter ) )
        {
            try
            {
                createItem ( item, i );
            }
            catch ( final Exception e )
            {
                disposeItems ();
                throw new RuntimeException ( "Failed to create item", e );
            }
            i++;
        }
    }

    private void disposeItems ()
    {
        for ( final ProxyValueSource source : this.sources )
        {
            source.dispose ();
        }
        this.sources.clear ();
    }

    private void createItem ( final String item, final int priority ) throws InvalidSyntaxException
    {
        final ProxyValueSource source = new ProxyValueSource ( this.context, item, this, priority );
        this.sources.add ( source );
    }

    @Override
    public Query createQuery ( final QueryParameters parameters, final QueryListener listener, final boolean updateData )
    {
        final QueryImpl query = new QueryImpl ( this, parameters, listener, updateData, this.executor );
        synchronized ( this )
        {
            if ( this.queries == null )
            {
                query.close ();
                return null;
            }
            this.queries.add ( query );
            return query;
        }
    }

    @Override
    public HistoricalItemInformation getInformation ()
    {
        final Map<String, Variant> properties = new HashMap<String, Variant> ( 1 );
        return new HistoricalItemInformation ( this.id, properties );
    }

    public void dispose ()
    {
        Set<QueryImpl> queries;
        synchronized ( this )
        {
            queries = new HashSet<QueryImpl> ( this.queries );
            this.queries = null;
        }

        for ( final QueryImpl query : queries )
        {
            query.close ();
        }
    }

    public synchronized void addListener ( final ItemListener listener )
    {
        if ( this.listeners.add ( listener ) )
        {
            final Collection<ServiceEntry> items = new HashSet<ServiceEntry> ( this.items );
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    listener.listenersChanges ( items, Collections.<ServiceEntry> emptyList () );
                }
            } );
        }
    }

    public synchronized void removeListener ( final ItemListener listener )
    {
        this.listeners.remove ( listener );
    }

    public synchronized void addSource ( final ServiceEntry service )
    {
        if ( this.items.add ( service ) )
        {
            notifySources ( Arrays.asList ( service ), Collections.<ServiceEntry> emptyList () );
        }
    }

    public synchronized void removeSource ( final ServiceEntry service )
    {
        if ( this.items.remove ( service ) )
        {
            notifySources ( Collections.<ServiceEntry> emptyList (), Arrays.asList ( service ) );
        }
    }

    private void notifySources ( final List<ServiceEntry> added, final List<ServiceEntry> removed )
    {
        for ( final ItemListener listener : this.listeners )
        {
            this.executor.execute ( new Runnable () {
                @Override
                public void run ()
                {
                    listener.listenersChanges ( added, removed );
                }
            } );
        }
    }

}
