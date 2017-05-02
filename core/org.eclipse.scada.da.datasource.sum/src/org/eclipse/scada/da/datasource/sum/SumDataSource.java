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
package org.eclipse.scada.da.datasource.sum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.datasource.DataSourceHandler;
import org.eclipse.scada.da.datasource.MultiDataSourceListener;
import org.eclipse.scada.da.datasource.base.AbstractDataSource;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SumDataSource extends AbstractDataSource
{
    private final static Logger logger = LoggerFactory.getLogger ( SumDataSource.class );

    private final Executor executor;

    private Set<String> groups;

    private Entry[] entries;

    private Entry errorEntry;

    private final MultiDataSourceListener itemListener;

    private final MultiDataSourceListener subItemListener;

    public SumDataSource ( final ObjectPoolTracker<DataSource> poolTracker, final Executor executor )
    {
        this.executor = executor;

        this.itemListener = new MultiDataSourceListener ( poolTracker ) {

            @Override
            protected void handleChange ( final Map<String, DataSourceHandler> sources )
            {
                SumDataSource.this.handleChange ();
            }
        };

        this.subItemListener = new MultiDataSourceListener ( poolTracker ) {

            @Override
            protected void handleChange ( final Map<String, DataSourceHandler> sources )
            {
                SumDataSource.this.handleChange ();
            }
        };
    }

    public void dispose ()
    {
        this.itemListener.dispose ();
        this.subItemListener.dispose ();
    }

    @Override
    protected Executor getExecutor ()
    {
        return this.executor;
    }

    @Override
    public NotifyFuture<WriteAttributeResults> startWriteAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        return new InstantErrorFuture<WriteAttributeResults> ( new OperationException ( "Not supported" ) );
    }

    @Override
    public NotifyFuture<WriteResult> startWriteValue ( final Variant value, final OperationParameters operationParameters )
    {
        return new InstantErrorFuture<WriteResult> ( new OperationException ( "Not supported" ) );
    }

    public synchronized void update ( final Map<String, String> parameters ) throws Exception
    {
        String groupsString = parameters.get ( "groups" ); //$NON-NLS-1$
        if ( groupsString == null )
        {
            groupsString = ""; //$NON-NLS-1$
        }

        this.itemListener.clearSources ();
        this.subItemListener.clearSources ();

        this.groups = new HashSet<String> ( Arrays.asList ( groupsString.split ( ", ?" ) ) ); //$NON-NLS-1$

        for ( final Map.Entry<String, String> entry : parameters.entrySet () )
        {
            final String key = entry.getKey ();

            if ( key.startsWith ( "datasource." ) ) //$NON-NLS-1$
            {
                final String id = entry.getValue ();

                logger.info ( "Adding datasource: {} -> {}", key, id ); //$NON-NLS-1$
                this.itemListener.addDataSource ( key, id, null );
            }
            else if ( key.startsWith ( "subDatasource." ) ) //$NON-NLS-1$
            {
                final String id = entry.getValue ();

                logger.info ( "Adding sub datasource: {} -> {}", key, id ); //$NON-NLS-1$
                this.subItemListener.addDataSource ( key, id, null );
            }
        }

        // prepare groups
        final LinkedList<Entry> localEntries = new LinkedList<Entry> ();
        for ( final String group : this.groups )
        {
            localEntries.add ( new Entry ( group ) );
        }
        this.entries = localEntries.toArray ( new Entry[localEntries.size ()] );

        this.errorEntry = null;
        for ( final Entry entry : this.entries )
        {
            if ( "error".equals ( entry.name ) ) //$NON-NLS-1$
            {
                this.errorEntry = entry;
            }
        }

        handleChange ();
    }

    protected synchronized void handleChange ()
    {
        updateData ( aggregate ( this.itemListener.getSourcesCopy (), this.subItemListener.getSourcesCopy () ) );
    }

    private boolean isDebug ()
    {
        return Boolean.getBoolean ( "org.eclipse.scada.da.datasource.sum.debug" ); //$NON-NLS-1$
    }

    private static class Entry
    {
        private final String name;

        private boolean active;

        public Entry ( final String name )
        {
            this.name = name;
        }
    }

    protected synchronized DataItemValue aggregate ( final Map<String, DataSourceHandler> values, final Map<String, DataSourceHandler> subValues )
    {
        // setup builder

        final Builder builder = new Builder ();
        builder.setSubscriptionState ( SubscriptionState.CONNECTED );

        int count = values.size ();

        final boolean debug = isDebug ();

        // reset

        for ( final Entry group : this.entries )
        {
            group.active = false;
        }

        // aggregate states

        aggregateValues ( values, builder, debug, false );
        count += aggregateValues ( subValues, builder, debug, true );

        // apply attributes

        for ( final Entry group : this.entries )
        {
            builder.setAttribute ( group.name, Variant.valueOf ( group.active ) );
        }

        // set the main value to the count of items
        builder.setValue ( Variant.valueOf ( count ) );

        return builder.build ();
    }

    private int aggregateValues ( final Map<String, DataSourceHandler> values, final Builder builder, final boolean debug, final boolean doCount )
    {
        int result = 0;

        for ( final Map.Entry<String, DataSourceHandler> entry : values.entrySet () )
        {
            final DataItemValue value = entry.getValue ().getValue ();

            if ( this.errorEntry != null )
            {
                if ( value == null || !value.isConnected () )
                {
                    this.errorEntry.active = true;
                    continue; // skip further processing on this item
                }
            }

            if ( doCount )
            {
                result += value.getValue ().asInteger ( 0 );
            }

            for ( final Entry group : this.entries )
            {
                if ( value.isAttribute ( group.name, false ) )
                {
                    if ( debug )
                    {
                        builder.setAttribute ( String.format ( "sum.%s.%s", group, entry.getKey () ), Variant.TRUE ); //$NON-NLS-1$
                    }
                    group.active = true;
                }
            }
        }

        return result;
    }

}
