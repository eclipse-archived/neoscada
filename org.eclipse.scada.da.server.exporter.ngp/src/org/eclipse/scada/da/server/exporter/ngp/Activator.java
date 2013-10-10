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
package org.eclipse.scada.da.server.exporter.ngp;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.da.server.ngp.Exporter;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.eclipse.scada.core.server.exporter.ExporterInformation;
import org.eclipse.scada.da.core.server.Hive;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
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

    private SingleServiceTracker<Hive> tracker;

    private Exporter exporter;

    private Set<ExporterInformation> exportedInformation;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext bundleContext ) throws Exception
    {
        Activator.context = bundleContext;

        this.tracker = new SingleServiceTracker<Hive> ( context, Hive.class, new SingleServiceListener<Hive> () {

            @Override
            public void serviceChange ( final ServiceReference<Hive> reference, final Hive service )
            {
                handleServiceChange ( service );
            }

        } );
        this.tracker.open ();
    }

    private final Collection<ServiceRegistration<ExporterInformation>> registeredExportInformation = new LinkedList<ServiceRegistration<ExporterInformation>> ();

    protected void handleServiceChange ( final Hive service )
    {
        logger.warn ( "Exporting new service: {}", service );

        try
        {
            if ( this.exporter != null )
            {
                this.exporter.stop ();
                this.exporter = null;
            }

            // unregister all
            unregisterAllExportInformations ();

            if ( service != null )
            {
                this.exporter = new Exporter ( service, ConnectionInformation.fromURI ( System.getProperty ( "openscada.da.ngp.exportUri", "da:ngp://0.0.0.0:2101" ) ) );
                this.exporter.start ();

                this.exportedInformation = this.exporter.getExporterInformation ();
                for ( final ExporterInformation ei : this.exportedInformation )
                {
                    final ServiceRegistration<ExporterInformation> reg = context.registerService ( ExporterInformation.class, ei, null );
                    if ( reg != null )
                    {
                        this.registeredExportInformation.add ( reg );
                    }
                }
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to export hd service", e );
        }
    }

    private void unregisterAllExportInformations ()
    {
        for ( final ServiceRegistration<ExporterInformation> reg : this.registeredExportInformation )
        {
            reg.unregister ();
        }
        this.registeredExportInformation.clear ();
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        unregisterAllExportInformations ();

        this.tracker.close ();
        if ( this.exporter != null )
        {
            this.exporter.stop ();
            this.exporter = null;
        }
        Activator.context = null;
    }

}
