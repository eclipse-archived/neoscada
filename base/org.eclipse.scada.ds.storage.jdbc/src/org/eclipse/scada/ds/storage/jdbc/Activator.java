/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - further development
 *******************************************************************************/
package org.eclipse.scada.ds.storage.jdbc;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.ds.DataStore;
import org.eclipse.scada.ds.storage.jdbc.internal.BufferingStorageDao;
import org.eclipse.scada.ds.storage.jdbc.internal.CachingStorageDao;
import org.eclipse.scada.ds.storage.jdbc.internal.JdbcStorageDao;
import org.eclipse.scada.ds.storage.jdbc.internal.JdbcStorageDaoBase64Impl;
import org.eclipse.scada.ds.storage.jdbc.internal.JdbcStorageDaoBlobImpl;
import org.eclipse.scada.ds.storage.jdbc.internal.StorageImpl;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.jdbc.DataSourceFactoryTracker;
import org.eclipse.scada.utils.osgi.jdbc.DataSourceHelper;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.jdbc.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator
{

    private static final String DS_PREFIX = "org.eclipse.scada.ds.storage.jdbc";

    private final static Logger logger = LoggerFactory.getLogger ( Activator.class );

    private DataSourceFactoryTracker dataSourceFactoryTracker;

    private ServiceRegistration<DataStore> serviceHandle;

    private StorageImpl storageImpl;

    private ScheduledExecutorService scheduler;

    private static enum Type
    {
        BASE64,
        BLOB;
    }

    private static Type getType ()
    {
        final String type = System.getProperty ( "org.eclipse.scada.ds.storage.jdbc.encoder", "blob" );
        try
        {
            return Type.valueOf ( type.toUpperCase () );
        }
        catch ( final Exception e )
        {
            return Type.BLOB;
        }
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.scheduler = Executors.newSingleThreadScheduledExecutor ( new NamedThreadFactory ( context.getBundle ().getSymbolicName () ) );
        final String driver = DataSourceHelper.getDriver ( DS_PREFIX, DataSourceHelper.DEFAULT_PREFIX );

        if ( driver == null )
        {
            logger.error ( "JDBC driver is not set" );
            throw new IllegalStateException ( "JDBC driver name is not set" );
        }

        this.dataSourceFactoryTracker = new DataSourceFactoryTracker ( context, driver, new SingleServiceListener<DataSourceFactory> () {

            @Override
            public void serviceChange ( final ServiceReference<DataSourceFactory> reference, final DataSourceFactory service )
            {
                unregister ();
                if ( service != null )
                {
                    register ( service, context );
                }
            }
        } );
        this.dataSourceFactoryTracker.open ( true );
    }

    protected void register ( final DataSourceFactory service, final BundleContext context )
    {
        JdbcStorageDao storage = null;

        try
        {
            switch ( getType () )
            {
                case BLOB:
                    logger.info ( "Registering BLOB implemenation" );
                    storage = configure ( new JdbcStorageDaoBlobImpl ( service, getDataSourceProperties (), isConnectionPool () ) );
                    break;
                case BASE64:
                    logger.info ( "Registering BASE64 implemenation" );
                    storage = configure ( new JdbcStorageDaoBase64Impl ( service, getDataSourceProperties (), isConnectionPool () ) );
                    break;
            }
        }
        catch ( final Exception e )
        {
            logger.error ( "Failed to create service", e );
        }

        if ( storage != null )
        {
            this.storageImpl = new StorageImpl ( storage );

            final Dictionary<String, Object> properties = new Hashtable<String, Object> ( 1 );
            properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
            this.serviceHandle = context.registerService ( org.eclipse.scada.ds.DataStore.class, this.storageImpl, properties );
        }
    }

    private JdbcStorageDao configure ( final JdbcStorageDao storageImpl )
    {
        JdbcStorageDao result = storageImpl;
        if ( !Boolean.getBoolean ( "org.eclipse.scada.ds.storage.jdbc.disableBuffer" ) )
        {
            logger.info ( "Adding write buffer" );
            result = new BufferingStorageDao ( result );
        }
        if ( !Boolean.getBoolean ( "org.eclipse.scada.ds.storage.jdbc.disableCache" ) )
        {
            logger.info ( "Adding cache" );
            result = new CachingStorageDao ( result, this.scheduler, Long.getLong ( "org.eclipse.scada.ds.storage.jdbc.cleanUpCacheDelay", 10 * 60 ) ); // default is 10 min
        }
        return result;
    }

    private static Properties getDataSourceProperties ()
    {
        return DataSourceHelper.getDataSourceProperties ( DS_PREFIX, DataSourceHelper.DEFAULT_PREFIX );
    }

    private static boolean isConnectionPool ()
    {
        return DataSourceHelper.isConnectionPool ( DS_PREFIX, DataSourceHelper.DEFAULT_PREFIX, false );
    }

    protected void unregister ()
    {
        if ( this.serviceHandle != null )
        {
            this.serviceHandle.unregister ();
            this.serviceHandle = null;
        }

        if ( this.storageImpl != null )
        {
            this.storageImpl.dispose ();
            this.storageImpl = null;
        }
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        unregister ();
        this.dataSourceFactoryTracker.close ();
        if ( this.scheduler != null )
        {
            this.scheduler.shutdownNow ();
            this.scheduler = null;
        }
    }

}
