/*******************************************************************************
 * Copyright (c) 2006, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - add login timeout
 *******************************************************************************/
package org.eclipse.scada.utils.osgi.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.osgi.service.jdbc.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSourceConnectionAccessor extends CommonConnectionAccessor
{

    private final static Logger logger = LoggerFactory.getLogger ( DataSourceConnectionAccessor.class );

    private final DataSource dataSource;

    public DataSourceConnectionAccessor ( final DataSourceFactory dataSourceFactory, final Properties paramProperties ) throws SQLException
    {
        this ( dataSourceFactory, paramProperties, null );
    }

    /**
     * @since 0.2.0
     */
    public DataSourceConnectionAccessor ( final DataSourceFactory dataSourceFactory, final Properties paramProperties, final Long loginTimeout ) throws SQLException
    {
        logger.debug ( "Creating default data source accessor" );
        this.dataSource = dataSourceFactory.createDataSource ( paramProperties );

        if ( loginTimeout != null && loginTimeout > 0 )
        {
            this.dataSource.setLoginTimeout ( (int) ( loginTimeout / 1000 ) );
        }
    }

    public DataSource getDataSource ()
    {
        return this.dataSource;
    }

    @Override
    public Connection getConnection () throws SQLException
    {
        return this.dataSource.getConnection ();
    }
}
