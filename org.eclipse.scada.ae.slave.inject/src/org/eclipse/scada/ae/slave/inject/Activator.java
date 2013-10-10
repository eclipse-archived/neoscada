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
package org.eclipse.scada.ae.slave.inject;

import java.sql.SQLException;

import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.jdbc.DataSourceFactoryTracker;
import org.eclipse.scada.utils.osgi.jdbc.DataSourceHelper;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.jdbc.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator
{

    private static final String SPECIFIC_PREFIX = "org.eclipse.scada.ae.slave.inject";

    private final static Logger logger = LoggerFactory.getLogger ( Activator.class );

    private static BundleContext context;

    static BundleContext getContext ()
    {
        return context;
    }

    private DataSourceFactoryTracker tracker;

    private EventInjector injector;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
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

        this.tracker = new DataSourceFactoryTracker ( bundleContext, driver, new SingleServiceListener<DataSourceFactory> () {

            @Override
            public void serviceChange ( final ServiceReference<DataSourceFactory> reference, final DataSourceFactory service )
            {
                setService ( service );
            }
        } );
        this.tracker.open ();
    }

    protected void setService ( final DataSourceFactory service )
    {
        if ( this.injector != null )
        {
            this.injector.dispose ();
            this.injector = null;
        }

        if ( service != null )
        {
            try
            {
                this.injector = new EventInjector ( service, DataSourceHelper.getDataSourceProperties ( SPECIFIC_PREFIX, DataSourceHelper.DEFAULT_PREFIX ), Integer.getInteger ( "org.eclipse.scada.ae.slave.inject.loopDelay", 10 * 1000 ) );
            }
            catch ( final SQLException e )
            {
                logger.warn ( "Failed to start event injector", e ); //$NON-NLS-1$
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        this.tracker.close ();

        if ( this.injector != null )
        {
            this.injector.dispose ();
            this.injector = null;
        }

        Activator.context = null;
    }

}
