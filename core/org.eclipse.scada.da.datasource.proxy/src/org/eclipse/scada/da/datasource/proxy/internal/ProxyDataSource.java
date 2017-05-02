/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.datasource.proxy.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.datasource.DataSourceListener;
import org.eclipse.scada.da.datasource.MultiDataSourceTracker;
import org.eclipse.scada.da.datasource.MultiDataSourceTracker.ServiceListener;
import org.eclipse.scada.da.datasource.base.AbstractDataSource;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProxyDataSource extends AbstractDataSource implements ServiceListener
{

    private final static Logger logger = LoggerFactory.getLogger ( ProxyDataSource.class );

    private final Executor executor;

    private MultiDataSourceTracker tracker;

    private Map<DataSource, SourceHandler> sources = new HashMap<DataSource, SourceHandler> ( 2 );

    private Set<String> sourceIds;

    private final ObjectPoolTracker<DataSource> poolTracker;

    public ProxyDataSource ( final ObjectPoolTracker<DataSource> poolTracker, final Executor executor )
    {
        this.poolTracker = poolTracker;
        this.executor = executor;
    }

    @Override
    protected Executor getExecutor ()
    {
        return this.executor;
    }

    public void dispose ()
    {
        for ( final SourceHandler handler : this.sources.values () )
        {
            handler.dispose ();
        }
        this.sources.clear ();
        this.sourceIds.clear ();
        if ( this.tracker != null )
        {
            this.tracker.close ();
            this.tracker = null;
        }
    }

    public void update ( final Map<String, String> properties ) throws Exception
    {
        setSources ( properties.get ( "sources" ) );
    }

    private void setSources ( final String str ) throws InvalidSyntaxException
    {
        if ( this.tracker != null )
        {
            this.tracker.close ();
            this.tracker = null;
        }

        this.sourceIds = convertSources ( str );
        this.sources = new HashMap<DataSource, ProxyDataSource.SourceHandler> ( this.sourceIds.size () );

        if ( this.sourceIds.isEmpty () )
        {
            // nothing to do if we don't have any source
            return;
        }

        this.tracker = new MultiDataSourceTracker ( this.poolTracker, this.sourceIds, this );
        this.tracker.open ();
    }

    private Set<String> convertSources ( final String sources )
    {
        if ( sources == null )
        {
            throw new IllegalArgumentException ( "'sources' must be set" );
        }

        return new LinkedHashSet<String> ( Arrays.asList ( sources.split ( "[, ]+" ) ) );
    }

    private int getPriority ( final String id, final Dictionary<?, ?> properties )
    {
        final Object o = properties.get ( Constants.SERVICE_RANKING );

        if ( o == null )
        {
            return getDefaultPriority ( id );
        }

        if ( o instanceof Number )
        {
            return ( (Number)o ).intValue ();
        }

        try
        {
            return Integer.parseInt ( o.toString () );
        }
        catch ( final NumberFormatException e )
        {
            return getDefaultPriority ( id );
        }
    }

    private int getDefaultPriority ( final String dataSourceId )
    {
        int start = 100;
        for ( final String id : this.sourceIds )
        {
            if ( id != null && id.equals ( dataSourceId ) )
            {
                return start;
            }
            start--;
        }

        return Integer.MIN_VALUE;
    }

    private class DataItemValueEntry implements Comparable<DataItemValueEntry>
    {
        private final DataItemValue value;

        private final int priority;

        DataItemValueEntry ( final DataItemValue value, final int priority )
        {
            this.value = value;
            this.priority = priority;
        }

        @Override
        public int compareTo ( final DataItemValueEntry other )
        {
            if ( this.priority == other.priority )
            {
                return 0;
            }
            else if ( this.priority > other.priority )
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }

        public DataItemValue getValue ()
        {
            return this.value;
        }

    }

    private class SourceHandler implements DataSourceListener
    {
        private final DataSource dataSource;

        private int priority;

        private DataItemValue value;

        SourceHandler ( final DataSource dataSource, final int priority )
        {
            this.dataSource = dataSource;
            this.priority = priority;

            dataSource.addListener ( this );
        }

        public void dispose ()
        {
            this.dataSource.removeListener ( this );
        }

        public void setPriority ( final int priority )
        {
            this.priority = priority;
        }

        public DataItemValueEntry getEntry ()
        {
            return new DataItemValueEntry ( this.value, this.priority );
        }

        @Override
        public void stateChanged ( final DataItemValue value )
        {
            this.value = value;
            ProxyDataSource.this.update ();
        }
    }

    protected synchronized void update ()
    {
        final ArrayList<DataItemValueEntry> entries = new ArrayList<DataItemValueEntry> ( this.sources.size () );

        for ( final SourceHandler handler : this.sources.values () )
        {
            final DataItemValueEntry entry = handler.getEntry ();
            if ( entry != null && entry.getValue () != null && entry.getValue ().isConnected () )
            {
                entries.add ( entry );
            }
        }

        Collections.sort ( entries );

        DataItemValue value;
        if ( entries.isEmpty () )
        {
            value = null;
        }
        else
        {
            value = entries.get ( entries.size () - 1 ).getValue ();
        }
        updateData ( value );
    }

    private synchronized void addSource ( final DataSource dataSource, final int priority )
    {
        logger.info ( "Adding source: {} / {}", new Object[] { dataSource, priority } );

        final SourceHandler handler = new SourceHandler ( dataSource, priority );

        final SourceHandler oldHandler = this.sources.put ( dataSource, handler );
        if ( oldHandler != null )
        {
            oldHandler.dispose ();
        }

        update ();
    }

    private synchronized void updateSource ( final DataSource dataSource, final int priority )
    {
        logger.info ( "Updating source: {} / {}", new Object[] { dataSource, priority } );

        final SourceHandler handler = this.sources.get ( dataSource );
        if ( handler != null )
        {
            handler.setPriority ( priority );
            update ();
        }
    }

    private synchronized void removeSource ( final DataSource dataSource )
    {
        logger.info ( "Removing source: {}", dataSource );

        final SourceHandler handler = this.sources.remove ( dataSource );
        if ( handler != null )
        {
            handler.dispose ();
            update ();
        }
    }

    @Override
    public NotifyFuture<WriteAttributeResults> startWriteAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        // FIXME: implement write call
        return new InstantErrorFuture<WriteAttributeResults> ( new OperationException ( "'writeAttributes' not supported" ) );
    }

    @Override
    public NotifyFuture<WriteResult> startWriteValue ( final Variant value, final OperationParameters operationParameters )
    {
        // FIXME: implement write call
        return new InstantErrorFuture<WriteResult> ( new OperationException ( "'writeAttributes' not supported" ) );
    }

    @Override
    public void dataSourceAdded ( final String id, final Dictionary<?, ?> properties, final DataSource dataSource )
    {
        addSource ( dataSource, getPriority ( id, properties ) );
    }

    @Override
    public void dataSourceModified ( final String id, final Dictionary<?, ?> properties, final DataSource dataSource )
    {
        updateSource ( dataSource, getPriority ( id, properties ) );
    }

    @Override
    public void dataSourceRemoved ( final String id, final Dictionary<?, ?> properties, final DataSource dataSource )
    {
        removeSource ( dataSource );
    }

}
