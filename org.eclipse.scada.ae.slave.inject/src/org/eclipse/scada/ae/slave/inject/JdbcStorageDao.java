/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.slave.inject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.utils.osgi.BundleObjectInputStream;
import org.eclipse.scada.utils.osgi.jdbc.data.SingleColumnRowMapper;
import org.eclipse.scada.utils.osgi.jdbc.task.CommonConnectionTask;
import org.eclipse.scada.utils.osgi.jdbc.task.ConnectionContext;
import org.eclipse.scada.utils.osgi.jdbc.task.RowCallback;
import org.eclipse.scada.ae.server.storage.jdbc.AbstractJdbcStorageDao;
import org.osgi.service.jdbc.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Interner;

public class JdbcStorageDao extends AbstractJdbcStorageDao
{

    public class RowHandler implements RowCallback
    {
        private final ConnectionContext connectionContext;

        private int count;

        public RowHandler ( final ConnectionContext connectionContext )
        {
            this.connectionContext = connectionContext;
        }

        @Override
        public void processRow ( final ResultSet resultSet ) throws SQLException
        {
            this.count++;
            JdbcStorageDao.this.processRow ( this.connectionContext, resultSet );
        }

        public int getCount ()
        {
            return this.count;
        }
    }

    private final boolean deleteFailed = Boolean.getBoolean ( "org.eclipse.scada.ae.slave.inject.deleteFailed" );

    private final static Logger logger = LoggerFactory.getLogger ( JdbcStorageDao.class );

    public JdbcStorageDao ( final DataSourceFactory dataSourceFactory, final Properties properties, final boolean usePool, final Interner<String> stringInterner ) throws SQLException
    {
        super ( dataSourceFactory, properties, usePool, stringInterner );
    }

    private String getReplicationSelectSql ()
    {
        return System.getProperty ( "org.eclipse.scada.ae.slave.inject.selectSql", String.format ( "SELECT ID, ENTRY_TIMESTAMP, NODE_ID, DATA FROM %sOPENSCADA_AE_REP", getReplicationSchema () ) );
    }

    private String getReplicationDeleteSql ()
    {
        return System.getProperty ( "org.eclipse.scada.ae.slave.inject.deleteSql", String.format ( "DELETE FROM %sOPENSCADA_AE_REP where ID=?", getReplicationSchema () ) );
    }

    private String getReplicationSchema ()
    {
        return System.getProperty ( "org.eclipse.scada.ae.slave.inject.schema", "" );
    }

    protected int runOnce ()
    {
        return this.accessor.doWithConnection ( new CommonConnectionTask<Integer> () {

            @Override
            protected Integer performTask ( final ConnectionContext connectionContext ) throws Exception
            {
                connectionContext.setAutoCommit ( false );
                final int result = processOnce ( connectionContext );
                connectionContext.commit ();
                return result;
            }
        } );
    }

    protected int processOnce ( final ConnectionContext connectionContext ) throws SQLException
    {
        final String selectSql = getReplicationSelectSql ();

        final RowHandler rowHandler = new RowHandler ( connectionContext );
        connectionContext.query ( rowHandler, selectSql );
        return rowHandler.getCount ();
    }

    protected void processRow ( final ConnectionContext connectionContext, final ResultSet resultSet ) throws SQLException
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

        final byte[] data = resultSet.getBytes ( 4 );

        logger.debug ( "Injecting event {} from node {}, timeDiff: {} ms, dataSize: {}", new Object[] { id, nodeId, System.currentTimeMillis () - entryTimestamp.getTime (), data.length } );

        try
        {
            logger.debug ( "Storing event" );
            storeEvent ( deserializeEvent ( data ) );
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

    private Event deserializeEvent ( final byte[] data ) throws IOException, ClassNotFoundException
    {
        logger.debug ( "Deserialize event" );

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

    private void deleteReplicationEntry ( final ConnectionContext connectionContext, final String id ) throws SQLException
    {
        connectionContext.update ( getReplicationDeleteSql (), id );
    }

    private boolean entryExists ( final ConnectionContext connectionContext, final String id ) throws SQLException
    {
        logger.debug ( "Checking if entry already exists" );

        final List<Number> result = connectionContext.query ( new SingleColumnRowMapper<Number> ( Number.class ), String.format ( "SELECT COUNT(*) FROM %sOPENSCADA_AE_EVENTS WHERE ID=?", getSchema () ), id );
        if ( result.isEmpty () )
        {
            return false;
        }

        return result.get ( 0 ).intValue () > 0;
    }
}
