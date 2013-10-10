/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Query extends AbstractQuery
{
    private final static Logger logger = LoggerFactory.getLogger ( Query.class );

    private final Map<String, DataItemInputChained> items = new HashMap<String, DataItemInputChained> ();

    public Query ( final String id, final int period, final String sql, final Connection connection, final Map<Integer, String> columnAliases )
    {
        super ( id, period, sql, connection, columnAliases );
    }

    @Override
    protected void setGlobalError ( final Throwable e )
    {
        logger.error ( "Failed to query", e );

        for ( final Map.Entry<String, DataItemInputChained> entry : this.items.entrySet () )
        {
            setError ( entry.getKey (), e );
        }
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
                    if ( result.next () )
                    {
                        final int count = result.getMetaData ().getColumnCount ();

                        for ( int i = 0; i < count; i++ )
                        {
                            updateField ( i + 1, result );
                        }
                    }
                }
            }
        }
    }

    private void updateField ( final int i, final ResultSet result ) throws SQLException
    {
        final String field = mapFieldName ( i, result );

        try
        {
            setValue ( field, Variant.valueOf ( result.getObject ( i ) ) );
        }
        catch ( final Throwable e )
        {
            setError ( field, e );
        }
    }

    private DataItemInputChained getItem ( final String key )
    {
        DataItemInputChained item = this.items.get ( key );
        if ( item != null )
        {
            return item;
        }

        item = this.itemFactory.createInput ( key, null );
        this.items.put ( key, item );

        return item;
    }

    private void setValue ( final String key, final Variant value )
    {
        logger.debug ( "Setting value: {} = {}", key, value );

        final Map<String, Variant> attributes = new HashMap<String, Variant> ();
        attributes.put ( "jdbc.error", null );
        attributes.put ( "jdbc.error.message", null );

        getItem ( key ).updateData ( value, attributes, AttributeMode.UPDATE );
    }

    private void setError ( final String key, final Throwable e )
    {
        logger.debug ( "Setting error: {} = {}", key, e.getMessage () );

        final Map<String, Variant> attributes = new HashMap<String, Variant> ();
        attributes.put ( "jdbc.error", Variant.TRUE );
        attributes.put ( "jdbc.error.message", Variant.valueOf ( e.getMessage () ) );

        getItem ( key ).updateData ( null, attributes, AttributeMode.UPDATE );
    }

}
