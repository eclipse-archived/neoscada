/*******************************************************************************
 * Copyright (c) 2013, 2014 Jürgen Rose and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jürgen Rose - initial API and implementation
 *     IBH SYSTEMS GmbH - some enhancements
 *******************************************************************************/
package org.eclipse.scada.ae.server.storage.postgres;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Event.Fields;
import org.eclipse.scada.ae.server.storage.postgres.internal.SqlConverter;
import org.eclipse.scada.utils.filter.Filter;
import org.eclipse.scada.utils.osgi.jdbc.CommonConnectionAccessor;
import org.eclipse.scada.utils.osgi.jdbc.data.RowMapperAdapter;
import org.eclipse.scada.utils.osgi.jdbc.data.RowMapperException;
import org.eclipse.scada.utils.osgi.jdbc.data.RowMapperMappingException;
import org.eclipse.scada.utils.osgi.jdbc.task.CommonConnectionTask;
import org.eclipse.scada.utils.osgi.jdbc.task.ConnectionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcDao
{
    public enum ReplicationDataFormat
    {
        BLOB,
        BYTES,
        JSON,
        ARRAY;
    }

    private static class EventRowMapper extends RowMapperAdapter<Event>
    {
        private EventRowMapper ()
        {
        }

        @Override
        public Event mapRow ( final ResultSet resultSet ) throws SQLException, RowMapperMappingException
        {
            try
            {
                return EventConverter.INSTANCE.fromSqlArray ( resultSet.getArray ( 1 ) );
            }
            catch ( final ParseException e )
            {
                throw new RowMapperException ( e );
            }
        }

        @Override
        public Event nullObject ()
        {
            return Event.NULL_EVENT;
        }

        private static EventRowMapper INSTANCE = new EventRowMapper ();
    }

    private static final Logger logger = LoggerFactory.getLogger ( JdbcDao.class );

    private static final String cleanupArchiveSql = "DELETE FROM %sES_AE_EVENTS_HSTORE " //
            + "WHERE instance_id = ? AND SOURCE_TIMESTAMP < ?";

    private static final String cleanupReplicationSql = "DELETE FROM %sES_AE_REP " //
            + "WHERE ENTRY_TIMESTAMP < ?";

    private static final String loadEventSql = "SELECT hstore_to_array(data) FROM %sES_AE_EVENTS_HSTORE " //
            + "WHERE instance_id = ? AND ID = ?::UUID";

    private static final String storeEventSql = "INSERT INTO %sES_AE_EVENTS_HSTORE " //
            + "(id, instance_id, source_timestamp, entry_timestamp, data) " //
            + "VALUES " //
            + "(?::UUID, ?, ?, ?, hstore(?));"; //

    private static final String replicateEventSql = "INSERT INTO %sES_AE_REP " //
            + "(id, entry_timestamp, node_id, data) " //
            + "VALUES " //
            + "(?::VARCHAR, ?, ?, ?);"; //

    private static final String updateEventSql = "UPDATE %sES_AE_EVENTS_HSTORE " //
            + "SET data = hstore(?) WHERE id = ?::UUID;"; //

    private static final String selectEventsSql = "SELECT hstore_to_array(data) FROM %sES_AE_EVENTS_HSTORE " //
            + "WHERE instance_id = ? "; //

    private static final String defaultOrderSql = " ORDER BY source_timestamp DESC, entry_timestamp DESC, id DESC;";

    private static final int NODE_ID_LENGTH = Integer.getInteger ( "org.eclipse.scada.ae.server.storage.jdbc.fields.nodeId.length", 32 );

    public final ReplicationDataFormat dataFormat = makeDataFormat ();

    private final CommonConnectionAccessor accessor;

    private final String schema;

    private final String instance;

    private final NodeIdProvider nodeIdProvider;

    public JdbcDao ( final CommonConnectionAccessor accessor, final String schema, final String instance, final NodeIdProvider nodeIdProvider )
    {
        this.accessor = accessor;
        this.schema = schema;
        this.instance = instance;
        this.nodeIdProvider = nodeIdProvider;
    }

    public Event load ( final UUID id )
    {
        logger.trace ( "try to load event with id {}", id );
        return this.accessor.doWithConnection ( new CommonConnectionTask<Event> () {
            @Override
            protected Event performTask ( final ConnectionContext connectionContext ) throws Exception
            {
                return connectionContext.queryForObject ( EventRowMapper.INSTANCE, String.format ( loadEventSql, JdbcDao.this.schema ), JdbcDao.this.instance, id );
            }
        } );
    }

    public void store ( final ConnectionContext connectionContext, final Event event ) throws SQLException
    {
        logger.trace ( "try to store event {}", event );
        final Object[] parameters = new Object[5];
        parameters[0] = event.getId ();
        parameters[1] = JdbcDao.this.instance;
        parameters[2] = new Timestamp ( event.getSourceTimestamp ().getTime () );
        parameters[3] = new Timestamp ( event.getEntryTimestamp ().getTime () );
        parameters[4] = EventConverter.INSTANCE.toSqlArray ( connectionContext.getConnection (), event );
        connectionContext.update ( String.format ( storeEventSql, JdbcDao.this.schema ), parameters );
    }

    public void storeReplication ( final ConnectionContext connectionContext, final Event event ) throws SQLException, IOException
    {
        logger.trace ( "try to store replication event {}", event );
        final Object[] parameters = new Object[4];
        parameters[0] = event.getId ();
        parameters[1] = new Timestamp ( event.getEntryTimestamp ().getTime () );
        parameters[2] = clip ( NODE_ID_LENGTH, JdbcDao.this.nodeIdProvider.getNodeId () );
        // depending on format provide parameter as one of the given data types
        ObjectOutputStream oos;
        switch ( JdbcDao.this.dataFormat )
        {
            case ARRAY:
                parameters[3] = EventConverter.INSTANCE.toSqlArray ( connectionContext.getConnection (), event );
            case JSON:
                parameters[3] = EventConverter.INSTANCE.toJson ( event );
                break;
            case BLOB:
                final Blob blob = connectionContext.getConnection ().createBlob ();
                oos = new ObjectOutputStream ( blob.setBinaryStream ( 1 ) );
                oos.writeObject ( event );
                oos.close ();
                parameters[3] = blob;
                break;
            case BYTES:
                //$FALL-THROUGH$
            default:
                final ByteArrayOutputStream bos = new ByteArrayOutputStream ();
                oos = new ObjectOutputStream ( bos );
                oos.writeObject ( event );
                oos.close ();
                parameters[3] = bos.toByteArray ();
                break;
        }
        connectionContext.update ( String.format ( replicateEventSql, JdbcDao.this.schema ), parameters );
    }

    public void update ( final ConnectionContext connectionContext, final Event event ) throws SQLException
    {
        logger.trace ( "try to update event {}", event );
        connectionContext.update ( String.format ( updateEventSql, JdbcDao.this.schema ), EventConverter.INSTANCE.toSqlArray ( connectionContext.getConnection (), event ), event.getId () );
        connectionContext.update ( String.format ( updateEventSql, JdbcDao.this.schema ), null, event.getId () );
    }

    public int cleanUp ( final Date date )
    {
        logger.trace ( "cleanUp called with date {}", date );
        return this.accessor.doWithConnection ( new CommonConnectionTask<Integer> () {
            @Override
            protected Integer performTask ( final ConnectionContext connectionContext ) throws Exception
            {
                connectionContext.setAutoCommit ( false );
                final int i = connectionContext.update ( String.format ( cleanupArchiveSql, JdbcDao.this.schema ), JdbcDao.this.instance, new Timestamp ( date.getTime () ) );
                final int j = connectionContext.update ( String.format ( cleanupReplicationSql, JdbcDao.this.schema ), new Timestamp ( date.getTime () ) );
                if ( j > 0 )
                {
                    final Date ts = new Date ( System.currentTimeMillis () );
                    final Event event = Event.create ().id ( UUID.randomUUID () ).sourceTimestamp ( ts ).entryTimestamp ( ts ).attribute ( Fields.MESSAGE, "deleted events from replication table due to call to cleanUp" ).attribute ( Fields.VALUE, j ).build ();
                    storeReplication ( connectionContext, event );
                }
                connectionContext.commit ();
                return i;
            }
        } );
    }

    public ResultSet queryEvents ( final Filter filter ) throws SQLException, NotSupportedException
    {
        final Connection con = this.accessor.getConnection ();
        // build sql
        final SqlConverter.SqlCondition condition = SqlConverter.toSql ( this.schema, filter );
        final String sql = selectEventsSql + condition.condition + defaultOrderSql;
        final String querySql = String.format ( sql, this.schema );

        logger.debug ( "executing query: {} with parameters {}", querySql, condition.parameters );

        final PreparedStatement stm = con.prepareStatement ( querySql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY );
        stm.setFetchSize ( Integer.getInteger ( "org.eclipse.scada.ae.server.storage.jdbc.query.fetchSize", 1000 ) );
        int i = 1;
        stm.setString ( 1, this.instance );
        for ( final Serializable parameter : condition.parameters )
        {
            i += 1;
            stm.setObject ( i, parameter );
        }
        final ResultSet rs = stm.executeQuery ();
        logger.debug ( "query completed, returning resultset" );
        return rs;
    }

    private String clip ( final int i, final String string )
    {
        if ( string == null )
        {
            return null;
        }
        if ( ( i < 1 ) || ( string.length () <= i ) )
        {
            return string;
        }
        return string.substring ( 0, i );
    }

    private ReplicationDataFormat makeDataFormat ()
    {
        try
        {
            return ReplicationDataFormat.valueOf ( System.getProperty ( "org.eclipse.scada.ae.server.storage.jdbc.replicationDataFormat", ReplicationDataFormat.ARRAY.name () ) ); //$NON-NLS-1$
        }
        catch ( final Exception e )
        {
            return ReplicationDataFormat.ARRAY;
        }
    }
}
