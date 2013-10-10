/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *     Jürgen Rose - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.server.storage.postgres.internal;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.ae.server.storage.Storage;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
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

public class Activator implements BundleActivator
{
    private static final String SPECIFIC_PREFIX = "org.eclipse.scada.ae.server.storage.jdbc";

    private static final Logger logger = LoggerFactory.getLogger ( Activator.class );

    private static BundleContext context;

    private JdbcStorage jdbcStorage;

    private ServiceRegistration<?> jdbcStorageHandle;

    private SingleServiceTracker<DataSourceFactory> dataSouceFactoryTracker;

    private ScheduledExecutorService scheduler;

    static BundleContext getContext ()
    {
        return context;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
     * )
     */
    @Override
    public void start ( final BundleContext bundleContext ) throws Exception
    {
        Activator.context = bundleContext;

        final String driver = DataSourceHelper.getDriver ( SPECIFIC_PREFIX, DataSourceHelper.DEFAULT_PREFIX );

        if ( driver == null )
        {
            logger.error ( "JDBC driver is not set" );
            throw new IllegalStateException ( "JDBC driver name is not set" );
        }

        final Filter filter = context.createFilter ( "(&(objectClass=" + DataSourceFactory.class.getName () + ")(" + DataSourceFactory.OSGI_JDBC_DRIVER_CLASS + "=" + driver + "))" );
        this.dataSouceFactoryTracker = new SingleServiceTracker<DataSourceFactory> ( bundleContext, filter, new SingleServiceListener<DataSourceFactory> () {
            @Override
            public void serviceChange ( final ServiceReference<DataSourceFactory> reference, final DataSourceFactory dsf )
            {
                try
                {
                    deactivate ();
                }
                catch ( final Exception e )
                {
                    logger.error ( "an error occured on deactivating ae postgre storage", e );
                }
                if ( dsf != null )
                {
                    try
                    {
                        activate ( dsf );
                    }
                    catch ( final Exception e )
                    {
                        logger.error ( "an error occured on activating ae postgres storage", e );
                    }
                }
            }
        } );
        this.dataSouceFactoryTracker.open ();
    }

    private void activate ( final DataSourceFactory dataSourceFactory ) throws Exception
    {
        this.scheduler = Executors.newSingleThreadScheduledExecutor ( new NamedThreadFactory ( "org.eclipse.scada.ae.server.storage.postgresql/ScheduledExecutor" ) );

        final Properties dbProperties = DataSourceHelper.getDataSourceProperties ( SPECIFIC_PREFIX, DataSourceHelper.DEFAULT_PREFIX );

        final String schema = getSchema ();
        final String instance = getInstance ();
        this.jdbcStorage = new JdbcStorage ( dataSourceFactory, this.scheduler, dbProperties, DataSourceHelper.isConnectionPool ( SPECIFIC_PREFIX, DataSourceHelper.DEFAULT_PREFIX, false ), schema, instance );
        this.jdbcStorage.start ();

        final Dictionary<String, Object> properties = new Hashtable<String, Object> ( 2 );
        properties.put ( Constants.SERVICE_DESCRIPTION, "PostgreSQL specific JDBC implementation for org.eclipse.scada.ae.server.storage.Storage" );
        properties.put ( Constants.SERVICE_VENDOR, "IBH SYSTEMS GmbH" );
        this.jdbcStorageHandle = context.registerService ( new String[] { JdbcStorage.class.getName (), Storage.class.getName () }, this.jdbcStorage, properties );
    }

    private String getSchema ()
    {
        if ( !System.getProperty ( "org.eclipse.scada.ae.server.storage.jdbc.schema", "" ).trim ().isEmpty () )
        {
            return System.getProperty ( "org.eclipse.scada.ae.server.storage.jdbc.schema" ) + ".";
        }
        return "";
    }

    private String getInstance ()
    {
        return System.getProperty ( "org.eclipse.scada.ae.server.storage.jdbc.instance", "default" );
    }

    private void deactivate () throws Exception
    {
        if ( this.scheduler != null )
        {
            this.scheduler.shutdownNow ();
        }
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
     * 
     * @see
     * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        if ( this.dataSouceFactoryTracker != null )
        {
            this.dataSouceFactoryTracker.close ();
        }
        deactivate (); // redundant, but if something happened with the tracker
                       // we are sure it is shut down
        Activator.context = null;
    }
}
