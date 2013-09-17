/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.osgi;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.scada.sec.AuthorizationReply;
import org.eclipse.scada.sec.AuthorizationRequest;
import org.eclipse.scada.sec.authz.AuthorizationContext;
import org.eclipse.scada.utils.concurrent.ExportedExecutorService;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrackingAuthorizationTracker implements AuthorizationTracker
{

    private final static Logger logger = LoggerFactory.getLogger ( TrackingAuthorizationTracker.class );

    private static final AtomicInteger INSTANCE_COUNT = new AtomicInteger ();

    private final SingleServiceListener<AuthorizationTracker> listener = new SingleServiceListener<AuthorizationTracker> () {

        @Override
        public void serviceChange ( final ServiceReference<AuthorizationTracker> reference, final AuthorizationTracker service )
        {
            setService ( service );
        }
    };

    private final SingleServiceTracker<AuthorizationTracker> tracker;

    private final Set<MonitorImpl> monitors = new HashSet<MonitorImpl> ();

    private AuthorizationTracker service;

    private ExportedExecutorService executor;

    public TrackingAuthorizationTracker ( final BundleContext context )
    {
        this.tracker = new SingleServiceTracker<AuthorizationTracker> ( context, AuthorizationTracker.class, this.listener );
    }

    public void open ()
    {
        this.executor = new ExportedExecutorService ( getName (), 1, 1, 1, TimeUnit.MINUTES );
        this.tracker.open ();
    }

    private static String getName ()
    {
        return String.format ( "%s/%s", TrackingAuthorizationTracker.class.getName (), INSTANCE_COUNT.incrementAndGet () );
    }

    public void close ()
    {
        this.tracker.close ();
        this.executor.shutdown ();
    }

    private class MonitorImpl implements Monitor
    {

        private final Listener listener;

        private final AuthorizationRequest request;

        private Monitor monitor;

        private boolean disposed;

        private final Executor executor;

        private final AuthorizationContext context;

        public MonitorImpl ( final Listener listener, final AuthorizationRequest request, final Executor executor )
        {
            this.listener = listener;
            this.request = request;
            this.executor = executor;
            this.context = new AuthorizationContext ();
            this.context.setRequest ( request );
        }

        public synchronized void setService ( final AuthorizationTracker authorizationTracker )
        {
            logger.debug ( "Setting service - disposed: {}, monitor: {}, service: {}", new Object[] { this.disposed, this.monitor, authorizationTracker } );

            if ( this.disposed )
            {
                return;
            }

            if ( this.monitor != null )
            {
                this.monitor.dispose ();
            }

            if ( authorizationTracker != null )
            {
                this.monitor = authorizationTracker.createMonitor ( this.listener, this.request );
            }
            else
            {
                fireListener ( AuthorizationReply.create ( AuthorizationHelper.DEFAULT_RESULT, this.context ) );
            }
        }

        protected void fireListener ( final AuthorizationReply result )
        {
            logger.debug ( "Fire listener - request: {}, result: {}", this.request, result );

            this.executor.execute ( new Runnable () {
                @Override
                public void run ()
                {
                    MonitorImpl.this.listener.resultChanged ( result );
                }
            } );
        }

        @Override
        public void dispose ()
        {
            logger.debug ( "Dispose" );

            synchronized ( this )
            {
                this.disposed = true;
                if ( this.disposed )
                {
                    return;
                }
                this.monitor.dispose ();
                this.monitor = null;
            }
            disposeMonitor ( MonitorImpl.this );
        }

    }

    protected synchronized void setService ( final AuthorizationTracker service )
    {
        this.service = service;
        for ( final MonitorImpl monitor : this.monitors )
        {
            monitor.setService ( service );
        }
    }

    public synchronized void disposeMonitor ( final MonitorImpl monitor )
    {
        this.monitors.remove ( monitor );
    }

    @Override
    public synchronized Monitor createMonitor ( final Listener listener, final AuthorizationRequest request )
    {
        logger.debug ( "Creating monitor - listener: {}, request: {}", listener, request );

        final MonitorImpl monitor = new MonitorImpl ( listener, request, this.executor );

        monitor.setService ( this.service );

        this.monitors.add ( monitor );

        return monitor;
    }

}
