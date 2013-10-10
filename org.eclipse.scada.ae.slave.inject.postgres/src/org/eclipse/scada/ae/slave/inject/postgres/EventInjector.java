/*******************************************************************************
 * Copyright (c) 2013 Jürgen Rose and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jürgen Rose - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.slave.inject.postgres;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.server.storage.BaseStorage;
import org.eclipse.scada.ae.server.storage.Query;
import org.eclipse.scada.ae.server.storage.StoreListener;
import org.eclipse.scada.ae.server.storage.postgres.EventConverter;
import org.eclipse.scada.ae.server.storage.postgres.JdbcDao;
import org.eclipse.scada.ae.server.storage.postgres.NodeIdProvider;
import org.eclipse.scada.utils.concurrent.ScheduledExportedExecutorService;
import org.eclipse.scada.utils.osgi.BundleObjectInputStream;
import org.eclipse.scada.utils.osgi.jdbc.CommonConnectionAccessor;
import org.eclipse.scada.utils.osgi.jdbc.DataSourceConnectionAccessor;
import org.eclipse.scada.utils.osgi.jdbc.data.SingleColumnRowMapper;
import org.eclipse.scada.utils.osgi.jdbc.pool.PoolConnectionAccessor;
import org.eclipse.scada.utils.osgi.jdbc.task.CommonConnectionTask;
import org.eclipse.scada.utils.osgi.jdbc.task.ConnectionContext;
import org.eclipse.scada.utils.osgi.jdbc.task.RowCallback;
import org.osgi.service.jdbc.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventInjector extends BaseStorage
{

    private final static Logger logger = LoggerFactory.getLogger ( EventInjector.class );

    private static final String replicateEventSelectSql = "SELECT id, entry_timestamp, node_id, data FROM %sOPENSCADA_AE_REP LIMIT %s;";

    private static final String replicateEventDeleteSql = "DELETE FROM %sOPENSCADA_AE_REP WHERE ID = ?;";

    private static final String eventExistsSql = "SELECT count(id) FROM %sOPENSCADA_AE_EVENTS_JSON WHERE ID = ?::UUID;";

    private final boolean deleteFailed = Boolean.getBoolean ( "org.eclipse.scada.ae.slave.inject.deleteFailed" );

    private final CommonConnectionAccessor accessor;

    private final JdbcDao jdbcDao;

    private final ScheduledExportedExecutorService scheduler;

    private String schema;

    public EventInjector ( final DataSourceFactory dataSourceFactory, final Properties dataSourceProperties, final Integer delay, final boolean usePool, final String schema, final String instance ) throws SQLException
    {
        logger.info ( "Starting event injector" ); //$NON-NLS-1$
        this.schema = schema;
        this.accessor = usePool ? new PoolConnectionAccessor ( dataSourceFactory, dataSourceProperties ) : new DataSourceConnectionAccessor ( dataSourceFactory, dataSourceProperties );
        this.jdbcDao = new JdbcDao ( this.accessor, schema, instance, new NodeIdProvider () {
            @Override
            public String getNodeId ()
            {
                return EventInjector.this.getNodeId ();
            }
        } );
        this.scheduler = new ScheduledExportedExecutorService ( "org.eclipse.scada.ae.slave.inject", 1 ); //$NON-NLS-1$

        this.scheduler.scheduleWithFixedDelay ( new Runnable () {

            @Override
            public void run ()
            {
                process ();
            }
        }, 0, delay, TimeUnit.MILLISECONDS );
    }

    public void dispose ()
    {
        logger.info ( "Disposing event injector ..." ); //$NON-NLS-1$

        this.scheduler.shutdown ();

        logger.info ( "Disposing event injector ... done!" ); //$NON-NLS-1$
    }

    private void process ()
    {
        try
        {
            final int result = doProcess ();
            if ( result > 0 )
            {
                logger.info ( "Processed {} entries", result );
            }
            else
            {
                logger.debug ( "Processed {} entries", result );
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to process", e );
        }
    }

    private int doProcess ()
    {
        return this.accessor.doWithConnection ( new CommonConnectionTask<Integer> () {
            @Override
            protected Integer performTask ( final ConnectionContext connectionContext ) throws Exception
            {
                final AtomicInteger i = new AtomicInteger ( 0 );
                connectionContext.setAutoCommit ( false );
                connectionContext.query ( new RowCallback () {
                    @Override
                    public void processRow ( final ResultSet resultSet ) throws SQLException
                    {
                        EventInjector.this.processRow ( resultSet, connectionContext );
                        i.incrementAndGet ();
                    }
                }, String.format ( replicateEventSelectSql, EventInjector.this.schema, getLimit () ) );
                connectionContext.commit ();
                return i.get ();
            }
        } );
    }

    private Integer getLimit ()
    {
        return Integer.getInteger ( "org.eclipse.scada.ae.slave.inject.limit", 2000 );
    }

    private void processRow ( final ResultSet resultSet, final ConnectionContext connectionContext ) throws SQLException
    {
        final String id = resultSet.getString ( 1 );

        logger.debug ( "Processing event {}", id );

        if ( entryExists ( connectionContext, id ) )
        {
            logger.debug ( "Entry exists ... only delete" );
            deleteReplicationEntry ( connectionContext, id );
            return;
        }

        final Timestamp entryTimestamp = resultSet.getTimestamp ( 2 );
        final String nodeId = resultSet.getString ( 3 );

        logger.trace ( "Injecting event {} from node {}, timeDiff: {} ms", new Object[] { id, nodeId, System.currentTimeMillis () - entryTimestamp.getTime () } );

        try
        {
            logger.debug ( "Storing event" );
            this.jdbcDao.store ( connectionContext, toEvent ( resultSet ) );
            deleteReplicationEntry ( connectionContext, id );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to decode and store event", e );
            if ( this.deleteFailed )
            {
                deleteReplicationEntry ( connectionContext, id );
            }
        }

    }

    private Event toEvent ( final ResultSet resultSet ) throws SQLException, IOException, ClassNotFoundException
    {
        byte[] data;
        switch ( this.jdbcDao.dataFormat )
        {
            case JSON:
                return EventConverter.INSTANCE.toEvent ( resultSet.getString ( 4 ) );
            case BLOB:
                final Blob blob = resultSet.getBlob ( 4 );
                data = blob.getBytes ( 0, Long.valueOf ( blob.length () ).intValue () );
                blob.free ();
                break;
            case BYTES:
                //$FALL-THROUGH$
            default:
                data = resultSet.getBytes ( 4 );
                break;
        }

        logger.trace ( "Deserialize event" );

        final BundleObjectInputStream stream = new BundleObjectInputStream ( new ByteArrayInputStream ( data ), Activator.getContext ().getBundle () );
        try
        {
            final Object o = stream.readObject ();
            if ( o instanceof Event )
            {
                return (Event)o;
            }
            else if ( o == null )
            {
                logger.warn ( "Found null event" );
                return null;
            }
            else
            {
                logger.warn ( "Expected event type {} but found {}. Discarding...", Event.class, o.getClass () );
                return null;
            }
        }
        finally
        {
            stream.close ();
        }
    }

    private boolean entryExists ( final ConnectionContext connectionContext, final String id ) throws SQLException
    {
        logger.debug ( "Checking if entry already exists" );

        final List<Number> result;
        result = connectionContext.query ( new SingleColumnRowMapper<Number> ( Number.class ), String.format ( eventExistsSql, this.schema ), id );
        if ( result.isEmpty () )
        {
            return false;
        }

        return result.get ( 0 ).intValue () > 0;
    }

    private void deleteReplicationEntry ( final ConnectionContext connectionContext, final String id ) throws SQLException
    {
        connectionContext.update ( String.format ( replicateEventDeleteSql, this.schema ), id );
    }

    @Override
    public Event store ( final Event event, final StoreListener listener )
    {
        throw new UnsupportedOperationException ();
    }

    @Override
    public Query query ( final String filter ) throws Exception
    {
        throw new UnsupportedOperationException ();
    }

    @Override
    public Event update ( final UUID id, final String comment, final StoreListener listener ) throws Exception
    {
        throw new UnsupportedOperationException ();
    }

}
