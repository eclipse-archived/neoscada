/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.server.common.chain.WriteHandler;
import org.eclipse.scada.da.server.common.exporter.TabularExporter;
import org.eclipse.scada.da.server.common.exporter.TabularExporter.Entry;
import org.eclipse.scada.da.server.common.exporter.TabularExporter.WriteHandlerFactory;
import org.eclipse.scada.da.server.common.item.factory.DefaultChainItemFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TabularQuery extends AbstractQuery
{
    private final static Logger logger = LoggerFactory.getLogger ( TabularQuery.class );

    private final int idColumn;

    private TabularExporter exporter;

    private final Map<String, String> updateMap;

    private WriteHandlerFactory writeHandlerFactory;

    private Map<String, String> commands;

    public TabularQuery ( final String id, final int idColumn, final int period, final String sql, final Connection connection, final Map<Integer, String> columnAliases, final Map<String, String> updateMap, final Map<String, String> commands )
    {
        super ( id, period, sql, connection, columnAliases );
        this.idColumn = idColumn;
        this.updateMap = updateMap;
        this.commands = commands;
        this.writeHandlerFactory = new WriteHandlerFactory () {

            @Override
            public WriteHandler createColumnWriteHandler ( final String id, final String columnName )
            {
                return performColumnCreateWriteHandler ( id, columnName );
            }

            @Override
            public WriteHandler createCommandWriteHandler ( final String id, final String command )
            {
                return performCreateCommandWriteHandler ( id, command );
            }

        };
    }

    protected WriteHandler performCreateCommandWriteHandler ( final String id, final String command )
    {
        final String commandSql = this.commands.get ( command );
        if ( commandSql == null || commandSql.isEmpty () )
        {
            return null;
        }

        final String sql = String.format ( commandSql, id );

        return new WriteHandler () {

            @Override
            public void handleWrite ( final Variant value, final OperationParameters operationParameters ) throws Exception
            {
                processUpdateSql ( sql, value, operationParameters );
            }
        };
    }

    protected WriteHandler performColumnCreateWriteHandler ( final String id, final String columnName )
    {
        final String updateSql = this.updateMap.get ( columnName );
        if ( updateSql == null || updateSql.isEmpty () )
        {
            return null;
        }

        final String sql = String.format ( updateSql, id );

        return new WriteHandler () {

            @Override
            public void handleWrite ( final Variant value, final OperationParameters operationParameters ) throws Exception
            {
                processUpdateSql ( sql, value, operationParameters );
            }
        };
    }

    protected void processUpdateSql ( final String updateSql, final Variant value, final OperationParameters operationParameters ) throws Exception
    {
        try (final java.sql.Connection c = this.connection.getConnection ())
        {
            c.setAutoCommit ( true );

            try (PreparedStatement stmt = c.prepareStatement ( updateSql ))
            {
                if ( stmt.getParameterMetaData ().getParameterCount () == 1 && !value.isNull () )
                {
                    stmt.setObject ( 1, value.getValue () );
                }
                stmt.executeUpdate ();
            }
        }
    }

    @Override
    public void register ( final ScheduledExecutorService timer, final DefaultChainItemFactory parentItemFactory )
    {
        super.register ( timer, parentItemFactory );
        this.exporter = new TabularExporter ( this.itemFactory, this.writeHandlerFactory, this.commands.keySet () );
    }

    @Override
    public void unregister ()
    {
        if ( this.exporter != null )
        {
            this.exporter.dispose ();
            this.exporter = null;
        }
        super.unregister ();
    }

    @Override
    protected void setGlobalError ( final Throwable e )
    {
        logger.error ( "Failed to query", e );
        this.exporter.setGlobalError ( e );
    }

    @Override
    protected void doQuery () throws Exception
    {
        logger.debug ( "Perform query" );
        try (java.sql.Connection connection = this.connection.getConnection ())
        {
            try (final PreparedStatement stmt = connection.prepareStatement ( this.sql ))
            {
                if ( this.connection.getTimeout () != null )
                {
                    stmt.setQueryTimeout ( this.connection.getTimeout () / 1000 );
                }

                try (final ResultSet result = stmt.executeQuery ())
                {
                    processResult ( result );
                }
            }
        }
    }

    private void processResult ( final ResultSet result ) throws SQLException
    {
        final List<Entry> entries = new LinkedList<> ();

        logger.trace ( "Processing result" );

        final int count = result.getMetaData ().getColumnCount ();
        logger.trace ( "Column count: {}", count );

        while ( result.next () )
        {
            logger.trace ( "Next row" );

            final String idValue = String.format ( "%s", result.getObject ( this.idColumn ) );
            final Entry entry = new Entry ( idValue );
            entries.add ( entry );

            for ( int i = 1; i <= count; i++ )
            {
                final String field = mapFieldName ( i, result );
                entry.put ( field, Variant.valueOf ( result.getObject ( i ) ) );
            }
        }

        this.exporter.update ( entries );
    }

}
