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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.QueryState;
import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hd.data.ValueInformation;
import org.eclipse.scada.hd.server.common.HistoricalItem;
import org.eclipse.scada.hd.server.proxy.ProxyHistoricalItem.ItemListener;
import org.eclipse.scada.hd.server.proxy.ProxyValueSource.ServiceEntry;

public class QueryImpl implements Query, ItemListener
{

    private final ProxyHistoricalItem item;

    private QueryParameters parameters;

    private final boolean updateData;

    private final Executor executor;

    private final Set<ServiceEntry> items = new HashSet<ServiceEntry> ();

    private final Map<HistoricalItem, QueryEntry> queries = new HashMap<HistoricalItem, QueryEntry> ();

    private final ProxyQueryBuffer queryBuffer;

    public static class QueryEntry implements QueryListener, QueryDataHolder, Comparable<QueryEntry>
    {
        private Query query;

        private final QueryImpl impl;

        private QueryState state;

        @SuppressWarnings ( "unused" )
        private Set<String> valueTypes;

        private QueryParameters parameters;

        private HashMap<String, List<Double>> values;

        private List<ValueInformation> valueInformation;

        private final int priority;

        public QueryEntry ( final QueryImpl impl, final int priority )
        {
            this.impl = impl;
            this.priority = priority;
        }

        public void setQuery ( final Query query )
        {
            this.query = query;
        }

        public Query getQuery ()
        {
            return this.query;
        }

        @Override
        public QueryParameters getParameters ()
        {
            return this.parameters;
        }

        @Override
        public QueryState getState ()
        {
            return this.state;
        }

        @Override
        public List<ValueInformation> getValueInformation ()
        {
            return this.valueInformation;
        }

        @Override
        public HashMap<String, List<Double>> getValues ()
        {
            return this.values;
        }

        @Override
        public void updateState ( final QueryState state )
        {
            this.state = state;

            render ();
        }

        @Override
        public void updateParameters ( final QueryParameters parameters, final Set<String> valueTypes )
        {
            this.parameters = parameters;
            this.valueTypes = valueTypes;

            final int size = parameters.getNumberOfEntries ();
            this.values = new HashMap<String, List<Double>> ();
            for ( final String type : valueTypes )
            {
                this.values.put ( type, new ArrayList<Double> ( Arrays.asList ( new Double[size] ) ) );
            }
            this.valueInformation = new ArrayList<ValueInformation> ( Arrays.asList ( new ValueInformation[size] ) );

            render ();
        }

        @Override
        public void updateData ( final int index, final Map<String, List<Double>> values, final List<ValueInformation> valueInformation )
        {
            final List<ValueInformation> subVi = this.valueInformation.subList ( index, index + valueInformation.size () );
            subVi.clear ();
            subVi.addAll ( valueInformation );

            for ( final Map.Entry<String, List<Double>> entry : values.entrySet () )
            {
                final List<Double> valueArray = this.values.get ( entry.getKey () );

                final List<Double> subVs = valueArray.subList ( index, index + valueInformation.size () );
                subVs.clear ();
                subVs.addAll ( entry.getValue () );
            }

            render ();
        }

        private void render ()
        {
            this.impl.render ();
        }

        @Override
        public int compareTo ( final QueryEntry o )
        {
            return Integer.valueOf ( this.priority ).compareTo ( o.priority );
        }
    }

    public QueryImpl ( final ProxyHistoricalItem item, final QueryParameters parameters, final QueryListener listener, final boolean updateData, final Executor executor )
    {
        this.item = item;
        this.parameters = parameters;

        this.updateData = updateData;
        this.executor = executor;

        this.queryBuffer = new ProxyQueryBuffer ( listener, parameters, executor );

        item.addListener ( this );
    }

    @Override
    public synchronized void close ()
    {
        this.queryBuffer.close ();
        this.item.removeListener ( this );
        for ( final QueryEntry query : this.queries.values () )
        {
            query.getQuery ().close ();
        }
    }

    @Override
    public synchronized void changeParameters ( final QueryParameters parameters )
    {
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                handleChangeParameters ( parameters );
            }
        } );
    }

    protected synchronized void handleChangeParameters ( final QueryParameters parameters )
    {
        this.parameters = parameters;
        this.queryBuffer.changeParameters ( parameters );
        for ( final QueryEntry query : this.queries.values () )
        {
            query.getQuery ().changeParameters ( parameters );
        }
    }

    @Override
    public synchronized void listenersChanges ( final Collection<ServiceEntry> added, final Collection<ServiceEntry> removed )
    {
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                performChange ( added, removed );
            }
        } );
    }

    private synchronized void performChange ( final Collection<ServiceEntry> added, final Collection<ServiceEntry> removed )
    {
        for ( final ServiceEntry item : added )
        {
            if ( this.items.add ( item ) )
            {
                final QueryEntry entry = new QueryEntry ( this, item.getPriority () );
                final Query query = item.getItem ().createQuery ( this.parameters, entry, this.updateData );
                entry.setQuery ( query );
                this.queries.put ( item.getItem (), entry );
            }
        }
        for ( final ServiceEntry item : removed )
        {
            if ( this.items.remove ( item ) )
            {
                final QueryEntry query = this.queries.remove ( item.getItem () );
                if ( query != null )
                {
                    query.getQuery ().close ();
                }
            }
        }
    }

    public synchronized void render ()
    {
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                performRender ();
            }
        } );
    }

    protected synchronized void performRender ()
    {
        final List<QueryEntry> entries = new ArrayList<QueryImpl.QueryEntry> ( this.queries.values () );
        Collections.sort ( entries );
        this.queryBuffer.render ( entries );
    }
}
