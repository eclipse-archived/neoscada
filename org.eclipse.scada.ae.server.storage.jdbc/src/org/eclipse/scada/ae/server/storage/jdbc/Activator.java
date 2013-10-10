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
package org.eclipse.scada.ae.server.storage.jdbc;

import java.sql.SQLException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;

import org.eclipse.scada.ae.server.storage.Storage;
import org.eclipse.scada.utils.interner.InternerHelper;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.eclipse.scada.utils.osgi.jdbc.DataSourceHelper;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.jdbc.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Interner;

public class Activator implements BundleActivator
{
    private static final String SPECIFIC_PREFIX = "org.eclipse.scada.ae.server.storage.jdbc";

    private static final Logger logger = LoggerFactory.getLogger ( Activator.class );

    private static BundleContext context;

    private JdbcStorage jdbcStorage;

    private ServiceRegistration<?> jdbcStorageHandle;

    private final int maxLength = 4000;

    private SingleServiceTracker<DataSourceFactory> dataSouceFactoryTracker;

    private Interner<String> stringInterner;

    static BundleContext getContext ()
    {
        return context;
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext bundleContext ) throws Exception
    {
        Activator.context = bundleContext;

        this.stringInterner = InternerHelper.makeInterner ( "org.eclipse.scada.ae.monitor.dataitem.stringInternerType", "weak" );

        final String driver = DataSourceHelper.getDriver ( SPECIFIC_PREFIX, DataSourceHelper.DEFAULT_PREFIX );

        if ( driver == null )
        {
            logger.error ( "JDBC driver is not set" );
            throw new IllegalStateException ( "JDBC driver name is not set" );
        }

        logger.info ( "Using driver: {}", driver );

        final Filter filter = context.createFilter ( "(&(objectClass=" + DataSourceFactory.class.getName () + ")(" + DataSourceFactory.OSGI_JDBC_DRIVER_CLASS + "=" + driver + "))" );
        this.dataSouceFactoryTracker = new SingleServiceTracker<DataSourceFactory> ( bundleContext, filter, new SingleServiceListener<DataSourceFactory> () {
            @Override
            public void serviceChange ( final ServiceReference<DataSourceFactory> reference, final DataSourceFactory dsf )
            {
                logger.info ( "Service change: {}", reference );

                try
                {
                    deactivate ();
                }
                catch ( final Exception e )
                {
                    logger.error ( "an error occured on deactivating ae jdbc storage", e );
                }
                if ( dsf != null )
                {
                    try
                    {
                        activate ( dsf );
                    }
                    catch ( final Exception e )
                    {
                        logger.error ( "an error occured on activating ae jdbc storage", e );
                    }
                }
            }
        } );
        this.dataSouceFactoryTracker.open ();
    }

    private void activate ( final DataSourceFactory dataSourceFactory ) throws Exception
    {
        logger.info ( "Activating: {}", dataSourceFactory );

        final Properties dbProperties = DataSourceHelper.getDataSourceProperties ( SPECIFIC_PREFIX, DataSourceHelper.DEFAULT_PREFIX );

        this.jdbcStorage = createJdbcStorage ( dataSourceFactory, dbProperties, DataSourceHelper.isConnectionPool ( SPECIFIC_PREFIX, DataSourceHelper.DEFAULT_PREFIX, false ) );
        this.jdbcStorage.start ();

        final Dictionary<String, Object> properties = new Hashtable<String, Object> ( 2 );
        properties.put ( Constants.SERVICE_DESCRIPTION, "JDBC implementation for org.eclipse.scada.ae.server.storage.Storage" );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        properties.put ( "osgi.command.scope", "ae" );
        properties.put ( "osgi.command.function", new String[] { "cleanupArchive", "showQueueSize" } );
        this.jdbcStorageHandle = context.registerService ( new String[] { JdbcStorage.class.getName (), Storage.class.getName () }, this.jdbcStorage, properties );
    }

    private void deactivate () throws Exception
    {
        logger.info ( "Deactivating" );

        if ( this.jdbcStorageHandle != null )
        {
            this.jdbcStorageHandle.unregister ();
            this.jdbcStorageHandle = null;
        }
        if ( this.jdbcStorage != null )
        {
            this.jdbcStorage.dispose ();
            this.jdbcStorage = null;
        }
    };

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        if ( this.dataSouceFactoryTracker != null )
        {
            this.dataSouceFactoryTracker.close ();
        }
        deactivate (); // redundant, but if something happened with the tracker we are sure it is shut down
        Activator.context = null;
    }

    private JdbcStorage createJdbcStorage ( final DataSourceFactory dataSourceFactory, final Properties dbParameters, final boolean usePool ) throws SQLException
    {
        final AbstractJdbcStorageDao jdbcStorageDao = new JdbcStorageDao ( dataSourceFactory, dbParameters, usePool, this.stringInterner );
        jdbcStorageDao.setInstance ( System.getProperty ( "org.eclipse.scada.ae.server.storage.jdbc.instance", "default" ) );
        jdbcStorageDao.setMaxLength ( Integer.getInteger ( "org.eclipse.scada.ae.server.storage.jdbc.maxlength", this.maxLength ) );
        if ( !System.getProperty ( "org.eclipse.scada.ae.server.storage.jdbc.schema", "" ).trim ().isEmpty () )
        {
            jdbcStorageDao.setSchema ( System.getProperty ( "org.eclipse.scada.ae.server.storage.jdbc.schema" ) + "." );
        }
        return new JdbcStorage ( jdbcStorageDao );
    }
}
