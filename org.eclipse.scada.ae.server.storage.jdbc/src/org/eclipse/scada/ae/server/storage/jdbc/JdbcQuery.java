/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.storage.jdbc;

import java.lang.ref.WeakReference;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.server.storage.Query;
import org.eclipse.scada.utils.filter.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcQuery implements Query
{
    private static final Logger logger = LoggerFactory.getLogger ( JdbcQuery.class );

    private final StorageDao jdbcStorageDao;

    private ResultSet resultSet;

    private Statement statement;

    private boolean hasMore;

    private WeakReference<List<JdbcQuery>> openQueries;

    private ScheduledFuture<Boolean> future;

    public JdbcQuery ( final StorageDao jdbcStorageDao, final Filter filter, final ScheduledExecutorService executor, final List<JdbcQuery> openQueries ) throws SQLException, NotSupportedException
    {
        openQueries.add ( this );
        this.openQueries = new WeakReference<List<JdbcQuery>> ( openQueries );
        this.jdbcStorageDao = jdbcStorageDao;
        this.resultSet = jdbcStorageDao.queryEvents ( filter );
        this.statement = this.resultSet.getStatement ();
        this.hasMore = this.resultSet.next ();
        this.future = executor.schedule ( new Callable<Boolean> () {
            @Override
            public Boolean call ()
            {
                logger.warn ( "Query '{}' was open for over an hour, or service is being shut down, and will now be closed automatically" );
                dispose ();
                return true;
            }
        }, 1, TimeUnit.HOURS );
    }

    @Override
    public boolean hasMore ()
    {
        return this.hasMore;
    }

    @Override
    public List<Event> getNext ( final long count ) throws Exception
    {
        final List<Event> result = new ArrayList<Event> ();
        if ( this.hasMore )
        {
            if ( this.resultSet.isClosed () )
            {
                throw new RuntimeException ( "ResultSet is closed (probably due to a timeout), please create a new query" );
            }
            this.hasMore = this.jdbcStorageDao.toEventList ( this.resultSet, result, false, count );
        }
        return result;
    }

    @Override
    public void dispose ()
    {
        this.hasMore = false;
        if ( this.resultSet != null )
        {

            Connection connection = null;
            try
            {
                connection = this.statement.getConnection ();
            }
            catch ( final SQLException e )
            {
                logger.warn ( "Failed to get connection from statement", e );
            }

            try
            {
                if ( this.resultSet != null )
                {
                    this.resultSet.close ();
                }
            }
            catch ( final SQLException e )
            {
                logger.warn ( "error on closing database resources", e );
            }
            try
            {
                if ( this.statement != null && !this.statement.isClosed () )
                {
                    this.statement.close ();
                }
            }
            catch ( final SQLException e )
            {
                logger.warn ( "error on closing database resources", e );
            }
            try
            {
                if ( connection != null && !connection.isClosed () )
                {
                    connection.close ();
                }
            }
            catch ( final SQLException e )
            {
                logger.warn ( "error on closing database connection", e );
            }
        }
        final List<JdbcQuery> openQueries = this.openQueries.get ();
        if ( openQueries != null )
        {
            openQueries.remove ( this );
        }
        if ( this.future != null )
        {
            this.future.cancel ( false );
        }
    }
}
