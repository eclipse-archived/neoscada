/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ca.jdbc;

import java.lang.reflect.InvocationTargetException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.FreezableConfigurationAdministrator;
import org.eclipse.scada.ca.jdbc.internal.ConfigurationAdministratorImpl;
import org.eclipse.scada.ca.jdbc.internal.JdbcStorageDAOImpl;
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

    private static final String CA_PREFIX = "org.eclipse.scada.ca.jdbc";

    private final static Logger logger = LoggerFactory.getLogger ( Activator.class );

    private DataSourceFactoryTracker dataSourceFactoryTracker;

    private ConfigurationAdministratorImpl configAdmin;

    private ServiceRegistration<?> serviceHandle;

    private JdbcStorageDAOImpl storage;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        final String driver = DataSourceHelper.getDriver ( CA_PREFIX, DataSourceHelper.DEFAULT_PREFIX );

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
                    try
                    {
                        register ( service, context );
                    }
                    catch ( final Exception e )
                    {
                        logger.error ( "Failed to start configuration administrator", e );
                    }
                }
            }
        } );
        this.dataSourceFactoryTracker.open ( true );
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
    }

    protected void register ( final DataSourceFactory service, final BundleContext context ) throws Exception
    {
        logger.info ( "Registering services - service: {}, context: {}", service, context );

        this.storage = new JdbcStorageDAOImpl ( service, getDataSourceProperties (), isConnectionPool () );

        final ConfigurationAdministratorImpl configAdmin = new ConfigurationAdministratorImpl ( context, this.storage );
        try
        {
            configAdmin.start ();
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to start CA", e );

            try
            {
                configAdmin.dispose ();
            }
            catch ( final Exception e2 )
            {
                logger.warn ( "Failed to early dispose CA after error", e );
            }

            throw new InvocationTargetException ( e );
        }

        // started ... now announce
        this.configAdmin = configAdmin;

        final Dictionary<String, Object> properties = new Hashtable<String, Object> ( 2 );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "A JDBC based configuration administrator" );

        this.serviceHandle = context.registerService ( new String[] { ConfigurationAdministrator.class.getName (), FreezableConfigurationAdministrator.class.getName () }, this.configAdmin, properties );
    }

    public static boolean isConnectionPool ()
    {
        return DataSourceHelper.isConnectionPool ( CA_PREFIX, DataSourceHelper.DEFAULT_PREFIX, false );
    }

    private static Properties getDataSourceProperties ()
    {
        return DataSourceHelper.getDataSourceProperties ( CA_PREFIX, DataSourceHelper.DEFAULT_PREFIX );
    }

    protected void unregister ()
    {
        logger.info ( "Unregistering services" );

        if ( this.serviceHandle != null )
        {
            logger.info ( "Unregistering CA" );
            this.serviceHandle.unregister ();
            this.serviceHandle = null;
        }

        if ( this.configAdmin != null )
        {
            logger.info ( "Disposing CA" );
            this.configAdmin.dispose ();
            this.configAdmin = null;
        }

        if ( this.storage != null )
        {
            logger.info ( "Disposing storage" );
            this.storage.dispose ();
            this.storage = null;
        }
    }

}
