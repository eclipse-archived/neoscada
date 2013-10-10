/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.osgi.exporter.net;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.da.server.net.Exporter;
import org.eclipse.scada.core.server.exporter.ExporterInformation;
import org.eclipse.scada.da.core.server.Hive;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator
{

    private final static Logger logger = LoggerFactory.getLogger ( Activator.class );

    private ServiceListener listener;

    private ServiceReference<?> currentServiceReference;

    private BundleContext context;

    private ConnectionInformation connectionInformation;

    private Exporter exporter;

    private Hive currentService;

    private ServiceRegistration<ExporterInformation> exporterHandle;

    public Activator ()
    {
        try
        {
            final String uri = System.getProperty ( "org.eclipse.scada.da.server.osgi.exporter.net.exportUri", "da:net://0.0.0.0:1202" );
            if ( uri == null || uri.isEmpty () )
            {
                this.connectionInformation = null;
            }
            else
            {
                this.connectionInformation = ConnectionInformation.fromURI ( uri );
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to parse export uri", e );
            this.connectionInformation = null;
        }
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.context = context;

        context.addServiceListener ( this.listener = new ServiceListener () {

            @Override
            public void serviceChanged ( final ServiceEvent event )
            {
                switch ( event.getType () )
                {
                    case ServiceEvent.REGISTERED:
                        Activator.this.startExporter ( event.getServiceReference () );
                        break;
                    case ServiceEvent.UNREGISTERING:
                        Activator.this.stopExporter ( event.getServiceReference () );
                        break;
                }
            }
        }, "(" + Constants.OBJECTCLASS + "=" + Hive.class.getName () + ")" );

        startExporter ( context.getServiceReference ( Hive.class ) );
    }

    protected void stopExporter ( final ServiceReference<?> serviceReference )
    {
        if ( this.currentServiceReference != serviceReference )
        {
            logger.warn ( "Received stop event for unknown reference - current: {}, event: {}", this.currentServiceReference, serviceReference );
            return;
        }

        try
        {
            if ( this.exporterHandle != null )
            {
                this.exporterHandle.unregister ();
                this.exporterHandle = null;
            }

            this.exporter.stop ();
        }
        catch ( final Throwable e )
        {
            logger.warn ( "Failed to stop exporter", e );
        }
        finally
        {
            this.context.ungetService ( this.currentServiceReference );
            this.currentService = null;
            this.exporter = null;
            this.currentServiceReference = null;
        }

    }

    protected void startExporter ( final ServiceReference<?> serviceReference )
    {
        if ( this.connectionInformation == null || this.currentServiceReference != null || serviceReference == null )
        {
            return;
        }

        final Object o = this.context.getService ( serviceReference );
        if ( o instanceof Hive )
        {
            try
            {
                logger.info ( "Exporting: {} ", serviceReference );
                this.currentService = (Hive)o;
                this.exporter = new Exporter ( this.currentService, this.connectionInformation );
                this.exporter.start ();

                final String description = "" + serviceReference.getProperty ( Constants.SERVICE_DESCRIPTION );

                final ExporterInformation info = new ExporterInformation ( this.connectionInformation, description );
                this.exporterHandle = this.context.registerService ( ExporterInformation.class, info, null );
            }
            catch ( final Throwable e )
            {
                logger.error ( "Failed to export", e );
                this.exporter = null;
                this.currentService = null;
                this.context.ungetService ( serviceReference );
            }
        }
        else
        {
            this.context.ungetService ( serviceReference );
        }

    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        if ( this.exporterHandle != null )
        {
            this.exporterHandle.unregister ();
            this.exporterHandle = null;
        }

        context.removeServiceListener ( this.listener );
        this.context = null;
    }

}
