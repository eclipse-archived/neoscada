/*******************************************************************************
 * Copyright (c) 2013, 2014 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *     IBH SYSTEMS GmbH - add JDBC properties
 *******************************************************************************/
package org.eclipse.scada.da.server.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.jdbc.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultConnectionFactory implements ConnectionFactory
{
    private final static Logger logger = LoggerFactory.getLogger ( DefaultConnectionFactory.class );

    private final BundleContext bundleContext;

    private final Set<String> forNameSet = new HashSet<> ();

    public DefaultConnectionFactory ( final BundleContext bundleContext )
    {
        this.bundleContext = bundleContext;
    }

    @Override
    public Connection createConnection ( final String connectionClass, final String uri, final Properties properties, final Integer timeout ) throws Exception
    {
        if ( this.bundleContext == null && !this.forNameSet.contains ( connectionClass ) )
        {
            logger.info ( "Try loading driver using Class.forName()" );
            // we only do this outside of OSGi
            this.forNameSet.add ( connectionClass );
            try
            {
                if ( connectionClass != null )
                {
                    Class.forName ( connectionClass );
                }
            }
            catch ( final Throwable e )
            {
                logger.error ( "Failed to initialize connection", e );
            }
        }

        if ( timeout != null )
        {
            DriverManager.setLoginTimeout ( timeout / 1000 );
        }

        try
        {
            logger.debug ( "Try to create a connection using plain JDBC" );
            return DriverManager.getConnection ( uri, properties );
        }
        catch ( final SQLException e )
        {
            // try different approach
            logger.info ( "Failed to get connection", e );
        }

        try
        {
            if ( this.bundleContext != null )
            {
                logger.debug ( "Try to create a connection using OSGi - class: {}", connectionClass );

                final Collection<ServiceReference<DataSourceFactory>> refs = this.bundleContext.getServiceReferences ( DataSourceFactory.class, "(" + DataSourceFactory.OSGI_JDBC_DRIVER_CLASS + "=" + connectionClass + ")" );
                if ( refs != null )
                {
                    for ( final ServiceReference<DataSourceFactory> ref : refs )
                    {
                        logger.debug ( "Checking service ref: {}", ref );
                        final DataSourceFactory service = this.bundleContext.getService ( ref );
                        try
                        {
                            final Driver driver = service.createDriver ( null );
                            if ( driver.acceptsURL ( uri ) )
                            {
                                final Properties p = new Properties ();
                                p.put ( DataSourceFactory.JDBC_URL, uri );
                                return driver.connect ( uri, p );
                            }
                        }
                        finally
                        {
                            // this is actually "a bit bad", since the reference to the object (connection) is still held
                            this.bundleContext.ungetService ( ref );
                        }
                    }
                }
            }
        }
        catch ( final Exception e )
        {
            logger.info ( "Failed to load driver using OSGi", e );
            // try different approach
        }

        // fail
        throw new IllegalStateException ( String.format ( "Unable for find a suitable driver for '%s'", uri ) );
    }
}
