/*******************************************************************************
 * Copyright (c) 2006, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.osgi.jdbc.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DataSourceConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.eclipse.scada.utils.osgi.jdbc.CommonConnectionAccessor;
import org.osgi.service.jdbc.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PoolConnectionAccessor extends CommonConnectionAccessor
{

    private static final String PREFIX = "org.eclipse.scada.utils.osgi.jdbc.pool.";

    private final static Logger logger = LoggerFactory.getLogger ( PoolConnectionAccessor.class );

    private final PoolingDataSource dataSource;

    private final DataSource driverDataSource;

    private final GenericObjectPool<Object> connectionPool;

    private final PoolableConnectionFactory poolableConnectionFactory;

    public PoolConnectionAccessor ( final DataSourceFactory dataSourceFactory, final Properties paramProperties ) throws SQLException
    {
        logger.debug ( "Creating pool connection accessor : {}", paramProperties );

        // first remove all our properties

        this.connectionPool = new GenericObjectPool<Object> ( null );
        this.connectionPool.setMaxActive ( getInteger ( paramProperties, PREFIX + "maxActive", 8 ) );
        this.connectionPool.setMaxIdle ( getInteger ( paramProperties, PREFIX + "maxIdle", 8 ) );
        this.connectionPool.setMinIdle ( getInteger ( paramProperties, PREFIX + "minIdle", 1 ) );
        this.connectionPool.setTestOnBorrow ( getBoolean ( paramProperties, PREFIX + "testOnBorrow", true ) );
        this.connectionPool.setTestOnReturn ( getBoolean ( paramProperties, PREFIX + "testOnReturn", true ) );

        this.connectionPool.setTimeBetweenEvictionRunsMillis ( getLong ( paramProperties, PREFIX + "timeBetweenEvictionRunsMillis", -1 ) );
        this.connectionPool.setMinEvictableIdleTimeMillis ( getLong ( paramProperties, PREFIX + "minEvictableIdleTimeMillis", 30 * 60 * 1000 ) );
        this.connectionPool.setTestWhileIdle ( getBoolean ( paramProperties, PREFIX + "testWhileIdle", false ) );
        this.connectionPool.setSoftMinEvictableIdleTimeMillis ( getLong ( paramProperties, PREFIX + "softMinEvictableIdleTimeMillis", -1 ) );
        this.connectionPool.setNumTestsPerEvictionRun ( getInteger ( paramProperties, PREFIX + "numTestsPerEvictionRun", 3 ) );

        final String connectionInitSql = getString ( paramProperties, PREFIX + "connectionInitSql", null );
        final String validationQuery = getString ( paramProperties, PREFIX + "validationQuery", null );
        final Integer validationQueryTimeout = getInteger ( paramProperties, PREFIX + "validationQueryTimeout", -1 );

        this.driverDataSource = dataSourceFactory.createDataSource ( paramProperties );

        final ConnectionFactory connectionFactory = new DataSourceConnectionFactory ( this.driverDataSource );
        this.poolableConnectionFactory = new PoolableConnectionFactory ( connectionFactory, this.connectionPool, null, null, false, true );

        if ( connectionInitSql != null )
        {
            this.poolableConnectionFactory.setConnectionInitSql ( Arrays.asList ( connectionInitSql ) );
        }
        if ( validationQuery != null )
        {
            this.poolableConnectionFactory.setValidationQuery ( validationQuery );
        }
        if ( validationQueryTimeout != null )
        {
            this.poolableConnectionFactory.setValidationQueryTimeout ( validationQueryTimeout );
        }

        this.dataSource = new PoolingDataSource ( this.connectionPool );
    }

    private static long getLong ( final Properties paramProperties, final String name, final long defaultValue )
    {
        final Object value = paramProperties.remove ( name );
        if ( value instanceof Number )
        {
            logger.debug ( "Parameter value is numeric - {} -> {}", name, value );
            return ( (Number)value ).longValue ();
        }

        try
        {
            if ( value != null )
            {
                logger.debug ( "Parameter value is string - {} -> {}", name, value );
                return Long.parseLong ( value.toString () );
            }
        }
        catch ( final Exception e )
        {
        }

        final Long result = Long.getLong ( name, defaultValue );
        logger.debug ( "Parameter value via system property - {} -> {}", name, result );
        return result;
    }

    private static Integer getInteger ( final Properties paramProperties, final String name, final Integer defaultValue )
    {
        final Object value = paramProperties.remove ( name );
        if ( value instanceof Number )
        {
            logger.debug ( "Parameter value is numeric - {} -> {}", name, value );
            return ( (Number)value ).intValue ();
        }

        try
        {
            if ( value != null )
            {
                logger.debug ( "Parameter value is string - {} -> {}", name, value );
                return Integer.parseInt ( value.toString () );
            }
        }
        catch ( final Exception e )
        {
        }

        final Integer result = Integer.getInteger ( name, defaultValue );
        logger.debug ( "Parameter value via system property - {} -> {}", name, result );
        return result;
    }

    private static boolean getBoolean ( final Properties paramProperties, final String name, final boolean defaultValue )
    {
        final Object value = paramProperties.remove ( name );
        if ( value instanceof Boolean )
        {
            logger.debug ( "Parameter value is boolean - {} -> {}", name, value );
            return (Boolean)value;
        }
        if ( value instanceof Number )
        {
            logger.debug ( "Parameter value is numeric - {} -> {}", name, value );
            return ( (Number)value ).intValue () != 0;
        }

        try
        {
            if ( value != null )
            {
                logger.debug ( "Parameter value is string - %s -> %s", name, value );
                return Boolean.parseBoolean ( value.toString () );
            }
        }
        catch ( final Exception e )
        {
        }

        final boolean result = Boolean.parseBoolean ( System.getProperty ( name, "" + defaultValue ) );
        logger.debug ( "Parameter value via system property - {} -> {}", name, result );
        return result;
    }

    private static String getString ( final Properties paramProperties, final String name, final String defaultValue )
    {
        final Object value = paramProperties.remove ( name );
        if ( value instanceof String )
        {
            logger.debug ( "Parameter value is string - {} -> {}", name, value );
            return (String)value;
        }

        final String result = System.getProperty ( name, defaultValue );
        logger.debug ( "Parameter value via system property - {} -> {}", name, result );
        return result;
    }

    @Override
    public void dispose ()
    {
        logger.debug ( "Dispose" );

        super.dispose ();

        try
        {
            this.connectionPool.close ();
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to close connectionPool", e );
        }
    }

    @Override
    public Connection getConnection () throws SQLException
    {
        return this.dataSource.getConnection ();
    }
}
