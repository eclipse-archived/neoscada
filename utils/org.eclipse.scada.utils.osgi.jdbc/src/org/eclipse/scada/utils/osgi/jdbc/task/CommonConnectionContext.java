/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jürgen Rose - further development
 *******************************************************************************/
package org.eclipse.scada.utils.osgi.jdbc.task;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.scada.utils.osgi.jdbc.data.RowMapper;
import org.eclipse.scada.utils.osgi.jdbc.data.RowMapperException;
import org.eclipse.scada.utils.osgi.jdbc.data.SingleColumnRowMapper;
import org.eclipse.scada.utils.sql.SqlHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CommonConnectionContext implements ConnectionContext
{

    private final static Logger logger = LoggerFactory.getLogger ( CommonConnectionContext.class );

    @Override
    public void setAutoCommit ( final boolean autoCommit ) throws SQLException
    {
        getConnection ().setAutoCommit ( autoCommit );
    }

    @Override
    public void commit () throws SQLException
    {
        getConnection ().commit ();
    }

    @Override
    public void rollback () throws SQLException
    {
        getConnection ().rollback ();
    }

    private static class CaptureMappedResultSetProcessor<T> implements ResultSetProcessor
    {
        private List<T> result;

        private final RowMapper<T> mapper;

        public CaptureMappedResultSetProcessor ( final RowMapper<T> mapper )
        {
            this.mapper = mapper;
        }

        @Override
        public void processResult ( final ResultSet resultSet ) throws SQLException, RowMapperException
        {
            this.result = new ArrayList<T> ();

            this.mapper.validate ( resultSet );

            while ( resultSet.next () )
            {
                final T mapped = this.mapper.mapRow ( resultSet );
                if ( mapped != null )
                {
                    this.result.add ( mapped );
                }
            }
        }

        public List<T> getResult ()
        {
            return this.result;
        }
    }

    // ==== QUERY

    @Override
    public <T> List<T> queryForList ( final Class<T> clazz, final String sql, final Object... parameters ) throws SQLException
    {
        return query ( new SingleColumnRowMapper<T> ( clazz ), sql, parameters );
    }

    @Override
    public <T> List<T> queryForList ( final Class<T> clazz, final String sql, final Map<String, Object> parameters ) throws SQLException
    {
        return query ( new SingleColumnRowMapper<T> ( clazz ), sql, parameters );
    }

    @Override
    public <T> List<T> query ( final RowMapper<T> rowMapper, final String sql, final Object... parameters ) throws SQLException
    {
        final CaptureMappedResultSetProcessor<T> crsp = new CaptureMappedResultSetProcessor<T> ( rowMapper );
        query ( crsp, sql, parameters );
        return crsp.getResult ();
    }

    @Override
    public <T> List<T> query ( final RowMapper<T> rowMapper, final String sql, final Map<String, Object> parameters ) throws SQLException
    {
        final CaptureMappedResultSetProcessor<T> crsp = new CaptureMappedResultSetProcessor<T> ( rowMapper );
        query ( crsp, sql, parameters );
        return crsp.getResult ();
    }

    @Override
    public void query ( final RowCallback callback, final String sql, final Object... parameters ) throws SQLException
    {
        query ( new ResultSetProcessor () {

            @Override
            public void processResult ( final ResultSet resultSet ) throws SQLException
            {
                while ( resultSet.next () )
                {
                    callback.processRow ( resultSet );
                }
            }
        }, sql, parameters );
    }

    @Override
    public void query ( final RowCallback callback, final String sql, final Map<String, Object> parameters ) throws SQLException
    {
        query ( new ResultSetProcessor () {

            @Override
            public void processResult ( final ResultSet resultSet ) throws SQLException
            {
                while ( resultSet.next () )
                {
                    callback.processRow ( resultSet );
                }
            }
        }, sql, parameters );
    }

    @Override
    public void query ( final ResultSetProcessor resultSetProcessor, final String sql, final Map<String, Object> parameters ) throws SQLException
    {
        logger.trace ( "Preparing query SQL - {}", sql );

        final Map<String, List<Integer>> posMap = new HashMap<String, List<Integer>> ();
        final String convertedSql = SqlHelper.convertSql ( sql, posMap );

        logger.trace ( "Converted sql from '{}' to '{}' for positional parameters", sql, convertedSql );
        query ( resultSetProcessor, convertedSql, SqlHelper.expandParameters ( posMap, parameters ) );
    }

    @Override
    public void query ( final ResultSetProcessor resultSetProcessor, final String sql, final Object... parameters ) throws SQLException
    {
        logger.trace ( "Preparing query SQL - {}", sql );
        final PreparedStatement stmt = getConnection ().prepareStatement ( sql );
        try
        {
            applyParameters ( stmt, parameters );
            final ResultSet rs = stmt.executeQuery ();

            try
            {
                resultSetProcessor.processResult ( rs );
            }
            finally
            {
                if ( rs != null )
                {
                    rs.close ();
                }
            }
        }
        finally
        {
            if ( stmt != null )
            {
                stmt.close ();
            }
        }
    }

    @Override
    public <T> T queryForObject ( final RowMapper<T> rowMapper, final String sql, final Map<String, Object> parameters ) throws SQLException
    {
        final CaptureMappedResultSetProcessor<T> crsp = new CaptureMappedResultSetProcessor<T> ( rowMapper );
        query ( crsp, sql, parameters );
        if ( crsp.getResult ().size () == 0 )
        {
            return null;
        }
        else if ( crsp.getResult ().size () > 1 )
        {
            throw new SQLException ( "too many results" );
        }
        else
        {
            return crsp.getResult ().get ( 0 );
        }
    }

    @Override
    public <T> T queryForObject ( final RowMapper<T> rowMapper, final String sql, final Object... parameters ) throws SQLException
    {
        final CaptureMappedResultSetProcessor<T> crsp = new CaptureMappedResultSetProcessor<T> ( rowMapper );
        query ( crsp, sql, parameters );
        if ( crsp.getResult ().size () == 0 )
        {
            return null;
        }
        else if ( crsp.getResult ().size () > 1 )
        {
            throw new SQLException ( "too many results" );
        }
        else
        {
            return crsp.getResult ().get ( 0 );
        }
    }

    protected void applyParameters ( final PreparedStatement stmt, final Object... parameters ) throws SQLException
    {
        if ( parameters != null )
        {
            for ( int i = 0; i < parameters.length; i++ )
            {
                logger.trace ( "Set parameter #{} - {}", i + 1, parameters[i] );
                stmt.setObject ( i + 1, parameters[i] );
            }
        }
    }

    // === UPDATE

    @Override
    public int update ( final String sql, final Object... parameters ) throws SQLException
    {
        logger.trace ( "Preparing update SQL - {}", sql );

        final PreparedStatement stmt = getConnection ().prepareStatement ( sql );
        try
        {
            applyParameters ( stmt, parameters );
            return stmt.executeUpdate ();
        }
        finally
        {
            if ( stmt != null )
            {
                stmt.close ();
            }
        }
    }

    @Override
    public int update ( final String sql, final Map<String, Object> parameters ) throws SQLException
    {
        final Map<String, List<Integer>> posMap = new HashMap<String, List<Integer>> ();
        return update ( SqlHelper.convertSql ( sql, posMap ), SqlHelper.expandParameters ( posMap, parameters ) );
    }
}
