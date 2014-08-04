/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.common;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.da.core.server.Hive;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ServiceListenerHiveSource implements HiveSource
{

    private final SingleServiceTracker<Hive> tracker;

    private final Set<HiveSourceListener> listeners = new HashSet<> ();

    private final SingleServiceListener<Hive> listener = new SingleServiceListener<Hive> () {
        @Override
        public void serviceChange ( final ServiceReference<Hive> reference, final Hive service )
        {
            handleServiceChange ( service );
        }
    };

    private Hive service;

    private final Executor executor;

    public ServiceListenerHiveSource ( final BundleContext context, final Executor executor )
    {
        this.executor = executor;
        this.tracker = new SingleServiceTracker<Hive> ( context, Hive.class, this.listener );
    }

    protected synchronized void handleServiceChange ( final Hive service )
    {
        this.service = service;

        for ( final HiveSourceListener listener : this.listeners )
        {
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    listener.setHive ( service );
                }
            } );
        }
    }

    public void open ()
    {
        this.tracker.open ();
    }

    public void close ()
    {
        this.tracker.close ();

        synchronized ( this )
        {
            this.service = null;

            for ( final HiveSourceListener listener : this.listeners )
            {
                this.executor.execute ( new Runnable () {

                    @Override
                    public void run ()
                    {
                        listener.setHive ( null );
                    }
                } );
            }
        }
    }

    @Override
    public synchronized void addListener ( final HiveSourceListener listener )
    {
        final boolean added = this.listeners.add ( listener );
        final Hive hive = this.service;

        if ( added && hive != null )
        {
            this.executor.execute ( new Runnable () {
                @Override
                public void run ()
                {
                    listener.setHive ( hive );
                };
            } );
        }
    }

    @Override
    public synchronized void removeListener ( final HiveSourceListener listener )
    {
        this.listeners.remove ( listener );
    }

}
