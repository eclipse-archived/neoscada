/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.storage.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.UUID;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.core.VariantType;
import org.eclipse.scada.utils.osgi.jdbc.CommonConnectionAccessor;
import org.eclipse.scada.utils.osgi.jdbc.DataSourceConnectionAccessor;
import org.eclipse.scada.utils.osgi.jdbc.pool.PoolConnectionAccessor;
import org.eclipse.scada.utils.osgi.jdbc.task.CommonConnectionTask;
import org.eclipse.scada.utils.osgi.jdbc.task.ConnectionContext;
import org.osgi.service.jdbc.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseStorageDao implements StorageDao
{
    private static final Logger logger = LoggerFactory.getLogger ( BaseStorageDao.class );

    private String schema = "";

    private int maxLength = 4000;

    private String instance = "default";

    protected final CommonConnectionAccessor accessor;

    public BaseStorageDao ( final DataSourceFactory dataSourceFactory, final Properties paramProperties, final boolean usePool ) throws SQLException
    {
        this.accessor = usePool ? new PoolConnectionAccessor ( dataSourceFactory, paramProperties ) : new DataSourceConnectionAccessor ( dataSourceFactory, paramProperties );
    }

    @Override
    public void dispose ()
    {
        this.accessor.dispose ();
    }

    public void setSchema ( final String schema )
    {
        this.schema = schema;
    }

    public String getSchema ()
    {
        return this.schema;
    }

    public void setMaxLength ( final int maxLength )
    {
        this.maxLength = maxLength;
    }

    public int getMaxLength ()
    {
        return this.maxLength;
    }

    public void setInstance ( final String instance )
    {
        this.instance = instance;
    }

    public String getInstance ()
    {
        return this.instance;
    }

    public Connection createConnection () throws SQLException
    {
        final Connection connection = this.accessor.getConnection ();
        connection.setAutoCommit ( false );
        return connection;
    }

    protected CommonConnectionAccessor getAccessor ()
    {
        return this.accessor;
    }

    public void closeStatement ( final Statement statement )
    {
        try
        {
            if ( statement == null || statement.isClosed () )
            {
                return;
            }
            statement.close ();
        }
        catch ( final SQLException e )
        {
            logger.debug ( "Exception on closing statement", e );
        }
    }

    public void closeConnection ( final Connection connection )
    {
        try
        {
            if ( connection == null || connection.isClosed () )
            {
                return;
            }
            connection.close ();
        }
        catch ( final SQLException e )
        {
            logger.debug ( "Exception on closing statement", e );
        }
    }

    @Override
    public void updateComment ( final UUID id, final String comment ) throws Exception
    {
        this.accessor.doWithConnection ( new CommonConnectionTask<Void> () {

            @Override
            protected Void performTask ( final ConnectionContext connectionContext ) throws Exception
            {
                connectionContext.setAutoCommit ( false );
                performUpdateCommand ( id, comment, connectionContext.getConnection () );
                return null;
            }
        } );
    }

    private void performUpdateCommand ( final UUID id, final String comment, final Connection con ) throws SQLException
    {
        final PreparedStatement stm1 = con.prepareStatement ( String.format ( getDeleteAttributesSql (), getSchema () ) );
        try
        {
            stm1.setString ( 1, id.toString () );
            stm1.setString ( 2, Event.Fields.COMMENT.getName () );
            stm1.addBatch ();
            stm1.execute ();

            final PreparedStatement stm2 = con.prepareStatement ( String.format ( getInsertAttributesSql (), getSchema () ) );
            try
            {
                stm2.setString ( 1, id.toString () );
                stm2.setString ( 2, Event.Fields.COMMENT.getName () );
                stm2.setString ( 3, VariantType.STRING.name () );
                stm2.setString ( 4, clip ( getMaxLength (), comment ) );
                stm2.setLong ( 5, (Long)null );
                stm2.setDouble ( 6, (Double)null );
                stm2.addBatch ();
                stm2.execute ();

                con.commit ();
            }
            finally
            {
                closeStatement ( stm2 );
            }
        }
        finally
        {
            closeStatement ( stm1 );
        }
    }

    protected String clip ( final int i, final String string )
    {
        if ( string == null )
        {
            return null;
        }
        if ( i < 1 || string.length () <= i )
        {
            return string;
        }
        return string.substring ( 0, i );
    }

    protected int getCleanupDays ()
    {
        return Integer.getInteger ( "org.eclipse.scada.ae.server.storage.jdbc.archiveDays", -1 );
    }

    protected abstract String getDeleteAttributesSql ();

    protected abstract String getInsertAttributesSql ();
}
