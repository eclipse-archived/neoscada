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
package org.eclipse.scada.ds.storage.jdbc.internal;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.eclipse.scada.ds.DataNode;
import org.eclipse.scada.utils.codec.Base64;
import org.eclipse.scada.utils.osgi.jdbc.CommonConnectionAccessor;
import org.eclipse.scada.utils.osgi.jdbc.DataSourceConnectionAccessor;
import org.eclipse.scada.utils.osgi.jdbc.pool.PoolConnectionAccessor;
import org.eclipse.scada.utils.osgi.jdbc.task.CommonConnectionTask;
import org.eclipse.scada.utils.osgi.jdbc.task.ConnectionContext;
import org.eclipse.scada.utils.osgi.jdbc.task.RowCallback;
import org.osgi.service.jdbc.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcStorageDaoBase64Impl implements JdbcStorageDao
{

    public static class AllProcessor implements RowCallback
    {
        private final Collection<DataNode> result;

        private String currentNodeId;

        private StringBuilder dataBuilder = new StringBuilder ();

        public AllProcessor ( final Collection<DataNode> result )
        {
            this.result = result;
        }

        public Collection<DataNode> getResult ()
        {
            return this.result;
        }

        @Override
        public void processRow ( final ResultSet resultSet ) throws SQLException
        {
            final String nodeId = resultSet.getString ( 1 );
            final String data = resultSet.getString ( 2 );

            if ( nodeId == null )
            {
                this.currentNodeId = null;
                return;
            }
            if ( this.currentNodeId == null || nodeId.equals ( this.currentNodeId ) )
            {
                this.dataBuilder.append ( data );
            }
            else
            {
                appendCurrent ();
                this.dataBuilder = new StringBuilder ( data );
            }

            this.currentNodeId = nodeId;
        }

        public void finish ()
        {
            if ( this.dataBuilder.length () > 0 )
            {
                appendCurrent ();
            }
        }

        private void appendCurrent ()
        {
            try
            {
                this.result.add ( new DataNode ( this.currentNodeId, Base64.decode ( this.dataBuilder.toString () ) ) );
            }
            catch ( final IOException e )
            {
                logger.warn ( "Failed to convert data node" );
            }
        }

    }

    private final static Logger logger = LoggerFactory.getLogger ( JdbcStorageDaoBase64Impl.class );

    private final String instanceId = System.getProperty ( "org.eclipse.scada.ds.storage.jdbc.instance", "default" );

    private int chunkSize = Integer.getInteger ( "org.eclipse.scada.ds.storage.jdbc.chunkSize", 0 );

    private static final String TABLE_NAME = System.getProperty ( "org.eclipse.scada.ds.storage.jdbc.table", "datastore" );

    private static final String SQL_INSERT = String.format ( "insert into %s ( node_id, instance_id, sequence_nr, data ) values ( ?, ?, ?, ? )", TABLE_NAME );

    private static final String SQL_SELECT = String.format ( "select data from %s where node_id=? and instance_id=? order by sequence_nr", TABLE_NAME );

    private static final String SQL_SELECT_ALL = String.format ( "select node_id,data from %s where instance_id=? order by sequence_nr", TABLE_NAME );

    private static final String SQL_DELETE = String.format ( "delete from %s where node_id=? and instance_id=?", TABLE_NAME );

    private final CommonConnectionAccessor accessor;

    public JdbcStorageDaoBase64Impl ( final DataSourceFactory dataSourceFactory, final Properties paramProperties, final boolean usePool ) throws SQLException
    {
        this.accessor = usePool ? new PoolConnectionAccessor ( dataSourceFactory, paramProperties ) : new DataSourceConnectionAccessor ( dataSourceFactory, paramProperties );
        if ( this.chunkSize <= 0 )
        {
            this.chunkSize = Integer.MAX_VALUE;
        }
    }

    @Override
    public void dispose ()
    {
        this.accessor.dispose ();
    }

    @Override
    public DataNode readNode ( final String nodeId )
    {
        final List<String> result = findAllNode ( nodeId );

        if ( result.isEmpty () )
        {
            return null;
        }
        else
        {
            // merge node
            final StringBuilder sb = new StringBuilder ();
            for ( final String entry : result )
            {
                sb.append ( entry );
            }
            try
            {
                final String data = sb.toString ();
                logger.debug ( "Read: {}", data );
                return new DataNode ( nodeId, Base64.decode ( data ) );
            }
            catch ( final IOException e )
            {
                logger.warn ( "Failed to decode data node", e );
                return null;
            }
        }
    }

    @Override
    public Collection<DataNode> readAllNodes ()
    {
        logger.info ( "Read all nodes" );

        return this.accessor.doWithConnection ( new CommonConnectionTask<AllProcessor> () {
            @Override
            protected AllProcessor performTask ( final ConnectionContext connectionContext ) throws SQLException
            {
                final AllProcessor result = new AllProcessor ( new LinkedList<DataNode> () );
                connectionContext.query ( result, SQL_SELECT_ALL, JdbcStorageDaoBase64Impl.this.instanceId );
                return result;
            }
        } ).getResult ();
    }

    private List<String> findAllNode ( final String nodeId )
    {
        logger.debug ( "Find node: {}", nodeId );

        return this.accessor.doWithConnection ( new CommonConnectionTask<List<String>> () {
            @Override
            protected List<String> performTask ( final ConnectionContext connectionContext ) throws SQLException
            {
                return connectionContext.queryForList ( String.class, SQL_SELECT, nodeId, JdbcStorageDaoBase64Impl.this.instanceId );
            }
        } );
    }

    protected void deleteNode ( final ConnectionContext context, final String nodeId ) throws SQLException
    {
        context.update ( SQL_DELETE, nodeId, JdbcStorageDaoBase64Impl.this.instanceId );
    }

    @Override
    public void deleteNode ( final String nodeId )
    {
        this.accessor.doWithConnection ( new CommonConnectionTask<Void> () {

            @Override
            protected Void performTask ( final ConnectionContext connectionContext ) throws Exception
            {
                connectionContext.setAutoCommit ( false );
                deleteNode ( connectionContext, nodeId );
                connectionContext.commit ();
                return null;
            }
        } );
    }

    @Override
    public void writeNode ( final DataNode node )
    {
        final String data;

        if ( node != null && node.getData () != null )
        {
            data = Base64.encodeBytes ( node.getData () );
        }
        else
        {
            data = null;
        }

        logger.debug ( "Write data node: {} -> {}", node, data );

        this.accessor.doWithConnection ( new CommonConnectionTask<Void> () {

            @Override
            protected Void performTask ( final ConnectionContext connectionContext ) throws Exception
            {
                connectionContext.setAutoCommit ( false );

                deleteNode ( connectionContext, node.getId () );
                insertNode ( connectionContext, node, data );

                connectionContext.commit ();
                return null;
            }
        } );

    }

    protected void insertNode ( final ConnectionContext connectionContext, final DataNode node, final String data ) throws SQLException
    {
        if ( data == null )
        {
            return;
        }

        final PreparedStatement stmt = connectionContext.getConnection ().prepareStatement ( SQL_INSERT );

        final int len = data.length ();

        for ( int i = 0; i <= len / this.chunkSize; i++ )
        {
            int end = ( i + 1 ) * this.chunkSize;
            if ( end > len )
            {
                end = len;
            }

            final String chunk = data.substring ( i * this.chunkSize, end );

            stmt.setObject ( 1, node.getId () );
            stmt.setObject ( 2, this.instanceId );
            stmt.setObject ( 3, i );
            stmt.setObject ( 4, chunk );
            stmt.addBatch ();
        }

        stmt.executeBatch ();
    }
}
