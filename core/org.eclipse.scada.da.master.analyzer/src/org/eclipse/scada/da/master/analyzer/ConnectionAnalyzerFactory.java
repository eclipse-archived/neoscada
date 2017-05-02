/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.master.analyzer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionAnalyzerFactory
{
    private final static Logger logger = LoggerFactory.getLogger ( ConnectionAnalyzerFactory.class );

    private final ServiceTracker<ConnectionService, ConnectionService> connectionTracker;

    private final Map<ConnectionService, ConnectionAnalyzer> serviceMap = new HashMap<ConnectionService, ConnectionAnalyzer> ();

    private final BundleContext context;

    private final ScheduledExecutorService executor;

    public ConnectionAnalyzerFactory ( final ScheduledExecutorService executor, final BundleContext context )
    {
        this.executor = executor;
        this.context = context;
        this.connectionTracker = new ServiceTracker<ConnectionService, ConnectionService> ( context, ConnectionService.class, new ServiceTrackerCustomizer<ConnectionService, ConnectionService> () {

            @Override
            public void removedService ( final ServiceReference<ConnectionService> reference, final ConnectionService service )
            {
                ConnectionAnalyzerFactory.this.removeService ( service );
            }

            @Override
            public void modifiedService ( final ServiceReference<ConnectionService> reference, final ConnectionService service )
            {

            }

            @Override
            public ConnectionService addingService ( final ServiceReference<ConnectionService> reference )
            {
                try
                {
                    logger.debug ( "Found new service: {}", reference );
                    final ConnectionService service = context.getService ( reference );
                    ConnectionAnalyzerFactory.this.addService ( reference, service );
                    return service;
                }
                catch ( final Throwable e )
                {
                    logger.warn ( "Failed to add service", e );
                }
                context.ungetService ( reference );
                return null;
            }
        } );
        this.connectionTracker.open ();
    }

    public void dispose ()
    {
        this.connectionTracker.close ();
    }

    protected void addService ( final ServiceReference<ConnectionService> reference, final ConnectionService service )
    {
        logger.info ( "Adding service: {} -> {}", new Object[] { reference, service } );

        final ConnectionAnalyzer analyzer = new ConnectionAnalyzer ( this.executor, this.context, reference, service );
        this.serviceMap.put ( service, analyzer );
    }

    protected void removeService ( final ConnectionService service )
    {
        logger.info ( "Removing service: {}", service );

        final ConnectionAnalyzer analyzer = this.serviceMap.remove ( service );
        if ( analyzer != null )
        {
            analyzer.dispose ();
        }
    }
}
