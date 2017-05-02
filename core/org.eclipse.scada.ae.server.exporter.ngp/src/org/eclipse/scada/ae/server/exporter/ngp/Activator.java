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
package org.eclipse.scada.ae.server.exporter.ngp;

import org.eclipse.scada.ae.server.Service;
import org.eclipse.scada.ae.server.ngp.Exporter;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator
{

    private final static Logger logger = LoggerFactory.getLogger ( Activator.class );

    private static BundleContext context;

    static BundleContext getContext ()
    {
        return context;
    }

    private SingleServiceTracker<Service> tracker;

    private Exporter exporter;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext bundleContext ) throws Exception
    {
        Activator.context = bundleContext;

        this.tracker = new SingleServiceTracker<Service> ( context, Service.class, new SingleServiceListener<Service> () {

            @Override
            public void serviceChange ( final ServiceReference<Service> reference, final Service service )
            {
                handleServiceChange ( service );
            }

        } );
        this.tracker.open ();
    }

    protected void handleServiceChange ( final Service service )
    {
        logger.warn ( "Exporting new service: {}", service );

        try
        {
            if ( this.exporter != null )
            {
                this.exporter.stop ();
                this.exporter = null;
            }
            if ( service != null )
            {
                this.exporter = new Exporter ( service, ConnectionInformation.fromURI ( System.getProperty ( "org.eclipse.scada.ae.server.exporter.ngp.exportUri", "ae:ngp://0.0.0.0:2201" ) ) );
                this.exporter.start ();
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to export hd service", e );
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
        if ( this.exporter != null )
        {
            this.exporter.stop ();
            this.exporter = null;
        }
        Activator.context = null;
    }

}
