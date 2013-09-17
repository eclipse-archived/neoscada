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
package org.eclipse.scada.utils.osgi;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleServiceTracker<T>
{

    private final static Logger logger = LoggerFactory.getLogger ( SingleServiceTracker.class );

    private final class ServiceTrackerCustomizerImplementation implements ServiceTrackerCustomizer<T, T>
    {
        @Override
        public void removedService ( final ServiceReference<T> reference, final T service )
        {
            SingleServiceTracker.this.removedService ( reference, service );
        }

        @Override
        public void modifiedService ( final ServiceReference<T> reference, final T service )
        {
            SingleServiceTracker.this.modifiedService ( reference, service );
        }

        @Override
        public T addingService ( final ServiceReference<T> reference )
        {
            return SingleServiceTracker.this.addingService ( reference );
        }
    }

    private final ServiceTracker<T, T> tracker;

    private final BundleContext context;

    private T currentService;

    private final SingleServiceListener<T> listener;

    private ServiceReference<T> currentRef;

    public SingleServiceTracker ( final BundleContext context, final Filter filter, final SingleServiceListener<T> listener )
    {
        this.context = context;
        this.listener = listener;
        this.tracker = new ServiceTracker<T, T> ( context, filter, new ServiceTrackerCustomizerImplementation () );
    }

    public SingleServiceTracker ( final BundleContext context, final String clazz, final SingleServiceListener<T> listener )
    {
        this.context = context;
        this.listener = listener;
        this.tracker = new ServiceTracker<T, T> ( context, clazz, new ServiceTrackerCustomizerImplementation () );
    }

    public SingleServiceTracker ( final BundleContext context, final Class<T> clazz, final SingleServiceListener<T> listener )
    {
        this.context = context;
        this.listener = listener;
        this.tracker = new ServiceTracker<T, T> ( context, clazz, new ServiceTrackerCustomizerImplementation () );
    }

    /**
     * @see ServiceTracker#open()
     */
    public synchronized void open ()
    {
        this.tracker.open ();
    }

    /**
     * @see ServiceTracker#open(boolean)
     */
    public synchronized void open ( final boolean trackAllServices )
    {
        this.tracker.open ( trackAllServices );
    }

    /**
     * @see ServiceTracker#close()
     */
    public synchronized void close ()
    {
        this.tracker.close ();
        if ( this.currentService != null )
        {
            logger.warn ( "Should be null by the tracker#close call" );
            this.currentService = null;
            notifyService ( null, null );
        }
    }

    protected synchronized T addingService ( final ServiceReference<T> reference )
    {
        logger.info ( "Adding service: {}", reference );

        final T service = this.context.getService ( reference );

        if ( this.currentService == null )
        {
            // take the first we have
            this.currentService = service;
            this.currentRef = reference;

            notifyService ( this.currentRef, this.currentService );
        }
        else if ( isHigher ( reference, this.currentRef ) )
        {
            this.currentRef = reference;
            this.currentService = service;

            notifyService ( this.currentRef, this.currentService );
        }

        return service;
    }

    private boolean isHigher ( final ServiceReference<T> reference, final ServiceReference<T> currentRef )
    {
        int ref1 = 0;
        int ref2 = 0;

        try
        {
            ref1 = (Integer)reference.getProperty ( Constants.SERVICE_RANKING );
        }
        catch ( final Exception e )
        {
        }

        try
        {
            ref2 = (Integer)currentRef.getProperty ( Constants.SERVICE_RANKING );
        }
        catch ( final Exception e )
        {
        }

        return ref1 > ref2;
    }

    protected void modifiedService ( final ServiceReference<T> reference, final Object service )
    {
        /* do nothing */
    }

    protected synchronized void removedService ( final ServiceReference<T> reference, final Object service )
    {
        this.context.ungetService ( reference );

        if ( this.currentService == service )
        {
            final ServiceReference<T> ref = this.tracker.getServiceReference ();
            if ( ref != null )
            {
                this.currentService = this.tracker.getService ( ref );
                this.currentRef = ref;
                logger.info ( "Setting next service: {} / {}", new Object[] { ref, this.currentService } );
                notifyService ( this.currentRef, this.currentService );
            }
            else
            {
                logger.info ( "no more services left" );
                this.currentService = null;
                this.currentRef = null;
                notifyService ( null, null );
            }
        }
    }

    private void notifyService ( final ServiceReference<T> reference, final T service )
    {
        if ( this.listener != null )
        {
            try
            {
                this.listener.serviceChange ( reference, service );
            }
            catch ( final Exception e )
            {
                logger.debug ( "Failed to notify service", e );
            }
        }
    }

    public T waitForService ( final long timeout ) throws InterruptedException
    {
        return this.tracker.waitForService ( timeout );
    }

    public T getService ()
    {
        return this.tracker.getService ();
    }

}
