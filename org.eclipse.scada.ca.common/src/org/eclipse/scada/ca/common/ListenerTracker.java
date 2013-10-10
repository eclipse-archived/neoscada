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
package org.eclipse.scada.ca.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.scada.ca.ConfigurationAdministratorListener;
import org.eclipse.scada.ca.ConfigurationEvent;
import org.eclipse.scada.ca.FactoryEvent;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListenerTracker
{

    private final static Logger logger = LoggerFactory.getLogger ( ListenerTracker.class );

    private final ServiceTracker<ConfigurationAdministratorListener, ConfigurationAdministratorListener> listenerTracker;

    private final ExecutorService executor;

    public ListenerTracker ( final BundleContext context )
    {
        this.executor = Executors.newSingleThreadExecutor ( new NamedThreadFactory ( "org.eclipse.scada.ca.common.ListenerTracker" ) );
        this.listenerTracker = new ServiceTracker<ConfigurationAdministratorListener, ConfigurationAdministratorListener> ( context, ConfigurationAdministratorListener.class, null );
    }

    public void open ()
    {
        this.listenerTracker.open ();
    }

    public void close ()
    {
        this.listenerTracker.close ();
    }

    public void dispose ()
    {
        this.executor.shutdown ();
    }

    public void fireEvent ( final ConfigurationEvent configurationEvent )
    {
        logger.debug ( "Fire configuration event: {}", configurationEvent );

        final Object[] services = this.listenerTracker.getServices ();

        if ( services != null && services.length > 0 )
        {
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    if ( services != null )
                    {
                        for ( final Object o : services )
                        {
                            if ( o instanceof ConfigurationAdministratorListener )
                            {
                                final ConfigurationAdministratorListener listener = (ConfigurationAdministratorListener)o;
                                try
                                {
                                    listener.configurationEvent ( configurationEvent );
                                }
                                catch ( final Throwable e )
                                {
                                    logger.warn ( "Failed to handle listener", e );
                                }
                            }
                        }
                    }
                }
            } );
        }
    }

    public void fireEvent ( final FactoryEvent factoryEvent )
    {
        logger.debug ( "Fire factory event: {}", factoryEvent );

        final Object[] services = this.listenerTracker.getServices ();
        if ( services != null && services.length > 0 )
        {
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    if ( services != null )
                    {
                        for ( final Object o : services )
                        {
                            if ( o instanceof ConfigurationAdministratorListener )
                            {
                                final ConfigurationAdministratorListener listener = (ConfigurationAdministratorListener)o;
                                try
                                {
                                    listener.factoryEvent ( factoryEvent );
                                }
                                catch ( final Throwable e )
                                {
                                    logger.warn ( "Failed to handle listener", e );
                                }
                            }
                        }
                    }
                }
            } );
        }
    }
}
