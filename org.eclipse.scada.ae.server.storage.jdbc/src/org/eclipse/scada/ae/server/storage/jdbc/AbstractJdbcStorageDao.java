/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jürgen Rose - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.server.storage.jdbc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Event.EventBuilder;
import org.eclipse.scada.ae.Event.Fields;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantEditor;
import org.eclipse.scada.utils.filter.Filter;
import org.eclipse.scada.utils.interner.InternerHelper;
import org.eclipse.scada.utils.osgi.jdbc.task.CommonConnectionTask;
import org.eclipse.scada.utils.osgi.jdbc.task.ConnectionContext;
import org.eclipse.scada.utils.str.StringHelper;
import org.osgi.service.jdbc.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Interner;

public abstract class AbstractJdbcStorageDao extends BaseStorageDao
{

    private static final Logger logger = LoggerFactory.getLogger ( AbstractJdbcStorageDao.class );

    private static enum ReplicationDataFormat
    {
        BLOB,
        BYTES;
    }

    private final String cleanupArchiveSql = "DELETE FROM %sOPENSCADA_AE_EVENTS " //
            + "WHERE ENTRY_TIMESTAMP < ?";

    private final String insertEventSql = "INSERT INTO %sOPENSCADA_AE_EVENTS " //
            + "(ID, INSTANCE_ID, SOURCE_TIMESTAMP, ENTRY_TIMESTAMP, MONITOR_TYPE, EVENT_TYPE, " //
            + "VALUE_TYPE, VALUE_STRING, VALUE_INTEGER, VALUE_DOUBLE, MESSAGE, " //
            + "MESSAGE_CODE, PRIORITY, SOURCE, ACTOR_NAME, ACTOR_TYPE, SEVERITY)" //
            + " VALUES " //
            + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private final String insertAttributesSql = "INSERT INTO %sOPENSCADA_AE_EVENTS_ATTR " //
            + "(ID, KEY, VALUE_TYPE, VALUE_STRING, VALUE_INTEGER, VALUE_DOUBLE)" //
            + " VALUES " //
            + "(?, ?, ?, ?, ?, ?)";

    private final String deleteAttributesSql = "DELETE FROM %sOPENSCADA_AE_EVENTS_ATTR " //
            + "WHERE ID = ? AND KEY = ?";

    private final String selectEventSql = "SELECT E.ID, E.INSTANCE_ID, E.SOURCE_TIMESTAMP, E.ENTRY_TIMESTAMP, E.MONITOR_TYPE, E.EVENT_TYPE, " //
            + "E.VALUE_TYPE, E.VALUE_STRING, E.VALUE_INTEGER, E.VALUE_DOUBLE, E.MESSAGE, " //
            + "E.MESSAGE_CODE, E.PRIORITY, E.SOURCE, E.ACTOR_NAME, E.ACTOR_TYPE, E.SEVERITY, " //
            + "A.KEY, A.VALUE_TYPE, A.VALUE_STRING, A.VALUE_INTEGER, A.VALUE_DOUBLE " //
            + "FROM %1$sOPENSCADA_AE_EVENTS E LEFT JOIN %1$sOPENSCADA_AE_EVENTS_ATTR A ON (A.ID = E.ID) ";

    private final String insertReplicationEventSql = "INSERT INTO %sOPENSCADA_AE_REP " //
            + "(ID, ENTRY_TIMESTAMP, NODE_ID, DATA)" //
            + " VALUES " // 
            + "(?, ?, ?, ?)";

    private final String whereSql = " WHERE E.INSTANCE_ID = ? ";

    private final String defaultOrder = " ORDER BY E.SOURCE_TIMESTAMP DESC, E.ENTRY_TIMESTAMP DESC";

    private static final int NODE_ID_LENGTH = Integer.getInteger ( "org.eclipse.scada.ae.server.storage.jdbc.fields.nodeId.length", 32 );

    private final Interner<String> stringInterner;

    private final ReplicationDataFormat dataFormat = makeDataFormat ();

    private String hostName;

    public AbstractJdbcStorageDao ( final DataSourceFactory dataSourceFactory, final Properties properties, final boolean usePool, final Interner<String> stringInterner ) throws SQLException
    {
        super ( dataSourceFactory, properties, usePool );
        this.stringInterner = stringInterner == null ? InternerHelper.makeNoOpInterner () : stringInterner;
    }

    private ReplicationDataFormat makeDataFormat ()
    {
        try
        {
            return ReplicationDataFormat.valueOf ( System.getProperty ( "org.eclipse.scada.ae.server.storage.jdbc.replicationDataFormat", ReplicationDataFormat.BYTES.name () ) ); //$NON-NLS-1$
        }
        catch ( final Exception e )
        {
            return ReplicationDataFormat.BYTES;
        }
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.ae.server.storage.jdbc.StorageDao#storeEvent(org.eclipse.scada.ae.Event)
     */
    @Override
    public void storeEvent ( final Event event ) throws Exception
    {
        this.accessor.doWithConnection ( new CommonConnectionTask<Void> () {
            @Override
            protected Void performTask ( final ConnectionContext connectionContext ) throws Exception
            {
                connectionContext.setAutoCommit ( false );
                performStoreEvent ( event, connectionContext );
                connectionContext.commit ();

                return null;
            }
        } );
    }

    protected void storeReplicationEvent ( final Event event, final Connection con ) throws Exception
    {
        final PreparedStatement stmt = con.prepareStatement ( String.format ( this.insertReplicationEventSql, getSchema () ) );
        try
        {
            stmt.setString ( 1, event.getId ().toString () );
            stmt.setTimestamp ( 2, new java.sql.Timestamp ( event.getEntryTimestamp ().getTime () ) );
            stmt.setString ( 3, clip ( NODE_ID_LENGTH, getNodeId () ) );

            switch ( this.dataFormat )
            {
                case BLOB:
                    setReplicationDataBlob ( stmt, event );
                    break;

                case BYTES:
                    //$FALL-THROUGH$
                default:
                    setReplicationDataBytes ( stmt, event );
                    break;
            }

            stmt.executeUpdate ();
        }
        finally
        {
            stmt.close ();
        }
    }

    private String getNodeId ()
    {
        final String nodeId = System.getProperty ( "org.eclipse.scada.ae.server.storage.jdbc.replicationNodeId", null );
        if ( nodeId != null && !nodeId.isEmpty () )
        {
            return nodeId;
        }
        if ( nodeId != null && nodeId.isEmpty () )
        {
            return null;
        }

        if ( this.hostName == null )
        {
            // get hostname - by OS

            this.hostName = System.getenv ( "HOSTNAME" );
            if ( this.hostName != null )
            {
                return this.hostName;
            }

            // get hostname - by java

            try
            {
                this.hostName = InetAddress.getLocalHost ().getHostName ();
                return this.hostName;
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to lookup hostname", e );

            }
            this.hostName = "<unknown>";
            return this.hostName;
        }
        else
        {
            return this.hostName;
        }
    }

    private static byte[] serializeEvent ( final Event event ) throws IOException
    {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream ();
        final ObjectOutputStream oos = new ObjectOutputStream ( bos );
        oos.writeObject ( event );
        bos.close ();
        return bos.toByteArray ();
    }

    private static void setReplicationDataBytes ( final PreparedStatement stmt, final Event event ) throws IOException, SQLException
    {
        stmt.setBytes ( 4, serializeEvent ( event ) );
    }

    private static void setReplicationDataBlob ( final PreparedStatement stmt, final Event event ) throws SQLException, IOException
    {
        final Blob blob = stmt.getConnection ().createBlob ();

        final ObjectOutputStream oos = new ObjectOutputStream ( blob.setBinaryStream ( 1 ) );
        oos.writeObject ( event );
        oos.close ();

        stmt.setBlob ( 4, blob );
    }

    private void storeEventData ( final Event event, final Connection con ) throws SQLException
    {
        Statement stm1 = null;
        Statement stm2 = null;
        {
            final PreparedStatement stm = con.prepareStatement ( String.format ( this.insertEventSql, getSchema () ) );
            stm.setString ( 1, event.getId ().toString () );
            stm.setString ( 2, getInstance () );
            stm.setTimestamp ( 3, new java.sql.Timestamp ( event.getSourceTimestamp ().getTime () ) );
            stm.setTimestamp ( 4, new java.sql.Timestamp ( event.getEntryTimestamp ().getTime () ) );
            stm.setString ( 5, clip ( 32, Variant.valueOf ( event.getField ( Fields.MONITOR_TYPE ) ).asString ( "" ) ) );
            stm.setString ( 6, clip ( 32, Variant.valueOf ( event.getField ( Fields.EVENT_TYPE ) ).asString ( "" ) ) );
            stm.setString ( 7, clip ( 32, Variant.valueOf ( event.getField ( Fields.VALUE ) ).getType ().name () ) );
            stm.setString ( 8, clip ( getMaxLength (), Variant.valueOf ( event.getField ( Fields.VALUE ) ).asString ( "" ) ) );
            final Long longValue = Variant.valueOf ( event.getField ( Fields.VALUE ) ).asLong ( null );
            if ( longValue == null )
            {
                stm.setNull ( 9, Types.BIGINT );
            }
            else
            {
                stm.setLong ( 9, longValue );
            }
            final Double doubleValue = Variant.valueOf ( event.getField ( Fields.VALUE ) ).asDouble ( null );
            if ( doubleValue == null )
            {
                stm.setNull ( 10, Types.DOUBLE );
            }
            else
            {
                stm.setDouble ( 10, longValue );
            }
            stm.setString ( 11, clip ( getMaxLength (), Variant.valueOf ( event.getField ( Fields.MESSAGE ) ).asString ( "" ) ) );
            stm.setString ( 12, clip ( 255, Variant.valueOf ( event.getField ( Fields.MESSAGE_CODE ) ).asString ( "" ) ) );
            stm.setInt ( 13, Variant.valueOf ( event.getField ( Fields.PRIORITY ) ).asInteger ( 50 ) );
            stm.setString ( 14, clip ( 255, Variant.valueOf ( event.getField ( Fields.SOURCE ) ).asString ( "" ) ) );
            stm.setString ( 15, clip ( 128, Variant.valueOf ( event.getField ( Fields.ACTOR_NAME ) ).asString ( "" ) ) );
            stm.setString ( 16, clip ( 32, Variant.valueOf ( event.getField ( Fields.ACTOR_TYPE ) ).asString ( "" ) ) );
            stm.setString ( 17, clip ( 32, Variant.valueOf ( event.getField ( Fields.PRIORITY ) ).asString ( "" ) ) );
            stm.addBatch ();
            try
            {
                stm.executeBatch ();
            }
            catch ( final SQLException e )
            {
                logSQLError ( e );
                throw e;
            }
            stm1 = stm;
        }

        {
            final PreparedStatement stm = con.prepareStatement ( String.format ( this.insertAttributesSql, getSchema () ) );
            boolean hasAttr = false;
            for ( final String attr : event.getAttributes ().keySet () )
            {
                if ( SqlConverter.inlinedAttributes.contains ( attr ) )
                {
                    continue;
                }
                stm.setString ( 1, event.getId ().toString () );
                stm.setString ( 2, attr );
                stm.setString ( 3, clip ( 32, event.getAttributes ().get ( attr ).getType ().name () ) );
                stm.setString ( 4, clip ( getMaxLength (), event.getAttributes ().get ( attr ).asString ( "" ) ) );
                final Long longValue = Variant.valueOf ( event.getAttributes ().get ( attr ) ).asLong ( null );
                if ( longValue == null )
                {
                    stm.setNull ( 5, Types.BIGINT );
                }
                else
                {
                    stm.setLong ( 5, longValue );
                }
                final Double doubleValue = Variant.valueOf ( event.getAttributes ().get ( attr ) ).asDouble ( null );
                if ( doubleValue == null )
                {
                    stm.setNull ( 6, Types.DOUBLE );
                }
                else
                {
                    stm.setDouble ( 6, doubleValue );
                }
                stm.addBatch ();
                hasAttr = true;
            }
            if ( hasAttr )
            {
                try
                {
                    stm.executeBatch ();
                }
                catch ( final SQLException e )
                {
                    logSQLError ( e );
                    throw e;
                }
            }
            stm2 = stm;
        }
        closeStatement ( stm1 );
        closeStatement ( stm2 );
    }

    protected void logSQLError ( final SQLException e )
    {
        SQLException ex = e;
        while ( ex != null )
        {
            logger.info ( "Batch update - next exception", ex );
            ex = ex.getNextException ();
        }
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.ae.server.storage.jdbc.StorageDao#loadEvent(java.util.UUID)
     */
    @Override
    public Event loadEvent ( final UUID id ) throws SQLException
    {
        final Connection con = createConnection ();
        try
        {
            final String sql = this.selectEventSql + this.whereSql + " AND E.ID = ? " + this.defaultOrder;
            final PreparedStatement stm = con.prepareStatement ( String.format ( sql, getSchema () ), ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY );

            try
            {
                stm.setString ( 1, getInstance () );
                stm.setString ( 2, id.toString () );
                final ResultSet result = stm.executeQuery ();
                try
                {
                    final List<Event> events = new ArrayList<Event> ();
                    final boolean hasMore = toEventList ( result, events, true, 1 );

                    if ( hasMore )
                    {
                        logger.warn ( "more distinct records found for id {}, this shouldn't happen at all", id );
                    }
                    if ( events != null && !events.isEmpty () )
                    {
                        return events.get ( 0 );
                    }
                    return null;
                }
                finally
                {
                    result.close ();
                }
            }
            finally
            {
                closeStatement ( stm );
            }
        }
        finally
        {
            closeConnection ( con );
        }
    }

    /**
     * Get an open result result for a filter
     * <p>
     * The caller has to close the result set and the connection
     * </p>
     */
    @Override
    public ResultSet queryEvents ( final Filter filter ) throws SQLException, NotSupportedException
    {
        final Connection con = createConnection ();
        con.setAutoCommit ( Boolean.getBoolean ( "org.eclipse.scada.ae.server.storage.jdbc.query.autoCommit" ) );
        final SqlCondition condition = SqlConverter.toSql ( getSchema (), filter );
        String sql = this.selectEventSql + StringHelper.join ( condition.joins, " " ) + this.whereSql;
        sql += condition.condition;
        sql += this.defaultOrder;
        final String querySql = String.format ( sql, getSchema () );
        logger.debug ( "executing query: {} with parameters {} / {}", new Object[] { querySql, condition.joinParameters, condition.parameters } );
        final PreparedStatement stm = con.prepareStatement ( querySql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY );
        stm.setFetchSize ( Integer.getInteger ( "org.eclipse.scada.ae.server.storage.jdbc.query.fetchSize", 1000 ) );
        int i = 0;
        for ( final String parameter : condition.joinParameters )
        {
            i += 1;
            stm.setString ( i, parameter );
        }
        i += 1;
        stm.setString ( i, getInstance () );
        for ( final Serializable parameter : condition.parameters )
        {
            i += 1;
            stm.setObject ( i, parameter );
        }
        final ResultSet rs = stm.executeQuery ();
        logger.debug ( "query completed, returning resultset" );
        return rs;
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.ae.server.storage.jdbc.StorageDao#toEventList(java.sql.ResultSet, java.util.Collection, boolean, long)
     */
    @Override
    public boolean toEventList ( final ResultSet rs, final Collection<Event> events, final boolean isBeforeFirst, final long count ) throws SQLException
    {
        UUID lastId = null;
        EventBuilder eb = Event.create ();
        boolean hasMore = true;
        long l = 0;

        while ( true )
        {
            if ( isBeforeFirst )
            {
                hasMore = rs.next ();
                if ( !hasMore )
                {
                    break;
                }
            }
            final UUID id = UUID.fromString ( rs.getString ( 1 ) );
            if ( lastId != null && !id.equals ( lastId ) )
            {
                events.add ( eb.build () );
                l += 1;
                if ( l == count )
                {
                    break;
                }
                lastId = id;
                eb = Event.create ();
            }
            else if ( lastId == null )
            {
                lastId = id;
            }
            // base event
            eb.id ( id );
            final Date sourceTimestamp = new Date ( rs.getTimestamp ( 3 ).getTime () );
            final Date entryTimestamp = new Date ( rs.getTimestamp ( 4 ).getTime () );
            final String monitorType = intern ( rs.getString ( 5 ) );
            final String eventType = intern ( rs.getString ( 6 ) );
            String valueType = intern ( rs.getString ( 7 ) );
            String valueString = intern ( rs.getString ( 8 ) );
            final String message = rs.getString ( 11 );
            final String messageCode = intern ( rs.getString ( 12 ) );
            final Integer priority = rs.getInt ( 13 );
            final String source = intern ( rs.getString ( 14 ) );
            final String actor = intern ( rs.getString ( 15 ) );
            final String actorType = intern ( rs.getString ( 16 ) );
            final String severity = intern ( rs.getString ( 17 ) );

            eb.sourceTimestamp ( sourceTimestamp );
            eb.entryTimestamp ( entryTimestamp );
            eb.attribute ( Fields.MONITOR_TYPE, monitorType );
            eb.attribute ( Fields.EVENT_TYPE, eventType );
            if ( valueType != null && valueString != null )
            {
                eb.attribute ( Fields.VALUE, VariantEditor.toVariant ( valueType, valueString ) );
            }
            eb.attribute ( Fields.MESSAGE, message );
            eb.attribute ( Fields.MESSAGE_CODE, messageCode );
            eb.attribute ( Fields.PRIORITY, priority );
            eb.attribute ( Fields.SOURCE, source );
            eb.attribute ( Fields.ACTOR_NAME, actor );
            eb.attribute ( Fields.ACTOR_TYPE, actorType );
            eb.attribute ( Fields.SEVERITY, severity );

            // other attributes
            final String field = intern ( rs.getString ( 18 ) );
            valueType = intern ( rs.getString ( 19 ) );
            valueString = rs.getString ( 20 );
            if ( field != null )
            {
                if ( valueType != null && valueString != null )
                {
                    eb.attribute ( field, VariantEditor.toVariant ( valueType, valueString ) );
                }
                else
                {
                    eb.attribute ( field, Variant.NULL );
                }
            }

            hasMore = rs.next ();
            if ( !hasMore )
            {
                events.add ( eb.build () );
                break;
            }
        }
        return hasMore;
    }

    protected String intern ( final String string )
    {
        return this.stringInterner.intern ( string );
    }

    @Override
    protected String getDeleteAttributesSql ()
    {
        return this.deleteAttributesSql;
    }

    @Override
    protected String getInsertAttributesSql ()
    {
        return this.insertAttributesSql;
    }

    public void cleanupArchive ()
    {
        try
        {
            cleanupArchive ( getCleanupDays () );
        }
        catch ( final Exception e )
        {
            logger.error ( "Failed to clean up archive", e );
        }
    }

    /**
     * Cleanup the archive
     * 
     * @param days
     *            days in the past that should remain in the archive
     * @return the number of entries deleted or -1 if the parameters <q>days</q>
     *         was negative or zero.
     */
    protected int cleanupArchive ( final int days ) throws Exception
    {
        logger.info ( "Request to clean up archive - days: {}", days );
        if ( days <= 0 )
        {
            logger.info ( "Skipping archive cleanup" );
            return -1;
        }

        final Calendar c = Calendar.getInstance ();
        c.add ( Calendar.DAY_OF_MONTH, -days );

        return getAccessor ().doWithConnection ( new CommonConnectionTask<Integer> () {
            @Override
            protected Integer performTask ( final ConnectionContext connectionContext ) throws Exception
            {
                connectionContext.setAutoCommit ( true );

                final java.sql.Date d = new java.sql.Date ( c.getTimeInMillis () );
                logger.info ( "Starting to delete events up to {}", d );
                final int result = connectionContext.update ( String.format ( AbstractJdbcStorageDao.this.cleanupArchiveSql, getSchema () ), d );
                logger.info ( "Successfully cleaned up {} entries", result );

                return result;
            }
        } );
    }

    protected void performStoreEvent ( final Event event, final ConnectionContext connectionContext ) throws SQLException, Exception
    {
        storeEventData ( event, connectionContext.getConnection () );
    }
}
