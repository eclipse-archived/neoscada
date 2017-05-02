/*******************************************************************************
 * Copyright (c) 2006, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.osgi.exporter;

import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractExporter implements ServiceListener
{
    private final static Logger logger = LoggerFactory.getLogger ( AbstractExporter.class );

    private final BundleContext context;

    public AbstractExporter ( final BundleContext context )
    {
        this.context = context;
    }

    public void init () throws InvalidSyntaxException
    {
        final String filter = String.format ( "(%s=%s)", JaxWsExporter.EXPORT_ENABLED, true );
        synchronized ( this )
        {
            this.context.addServiceListener ( this, filter );
            final ServiceReference<?>[] refs = this.context.getServiceReferences ( (String)null, filter );
            if ( refs != null )
            {
                for ( final ServiceReference<?> ref : refs )
                {
                    addService ( ref );
                }
            }
        }
    }

    public void dispose ()
    {
        this.context.removeServiceListener ( this );
    }

    protected abstract void exportService ( final ServiceReference<?> reference, final Object service );

    @Override
    public synchronized void serviceChanged ( final ServiceEvent event )
    {
        switch ( event.getType () )
        {
            case ServiceEvent.REGISTERED:
                addService ( event.getServiceReference () );
                break;
            case ServiceEvent.UNREGISTERING:
                removeService ( event.getServiceReference () );
                break;
        }

    }

    private void removeService ( final ServiceReference<?> serviceReference )
    {
        this.context.ungetService ( serviceReference );
        unexportService ( serviceReference );
    }

    protected abstract void unexportService ( ServiceReference<?> serviceReference );

    private void addService ( final ServiceReference<?> reference )
    {
        logger.debug ( "Found new service: {}", reference );

        Object service = this.context.getService ( reference );
        try
        {
            exportService ( reference, service );
            service = null;
        }
        finally
        {
            if ( service != null )
            {
                this.context.ungetService ( reference );
            }
        }
    }

}
