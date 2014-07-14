/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.iec60870;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.da.server.common.impl.HiveCommon;
import org.eclipse.scada.da.server.iec60870.cfg.CAConfigurationFactory;
import org.eclipse.scada.da.server.iec60870.cfg.ConfigurationFactory;
import org.eclipse.scada.da.server.iec60870.cfg.ConfigurationFactory.Receiver;
import org.eclipse.scada.utils.concurrent.ExportedExecutorService;
import org.osgi.framework.FrameworkUtil;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;

public class Hive extends HiveCommon
{
    private final Receiver configurationReceiver = new Receiver () {

        @Override
        public void removeConnection ( final String id )
        {
            performRemoveConnection ( id );
        }

        @Override
        public ListenableFuture<Void> addConnection ( final String id, final ConnectionConfiguration configuration )
        {
            return performAddConnection ( id, configuration );
        }
    };

    private final ConfigurationFactory factory;

    private ExportedExecutorService executor;

    private final Map<String, Connection> connections = new HashMap<> ();

    public Hive ()
    {
        this ( new CAConfigurationFactory ( FrameworkUtil.getBundle ( Hive.class ).getBundleContext () ) );
    }

    public Hive ( final ConfigurationFactory factory )
    {
        this.factory = factory;
    }

    @Override
    protected void performStart () throws Exception
    {
        this.executor = new ExportedExecutorService ( Hive.class.getName (), 0, 1, 1, TimeUnit.MINUTES );
        super.performStart ();
        this.factory.setReceiver ( this.configurationReceiver );
    }

    @Override
    protected void performStop () throws Exception
    {
        this.factory.setReceiver ( null );

        super.performStop ();

        ExecutorService service = null;

        synchronized ( this )
        {
            if ( this.executor != null )
            {
                service = this.executor;
                this.executor.shutdown ();
                this.executor = null;
            }
        }
        if ( service != null )
        {
            service.awaitTermination ( Long.MAX_VALUE, TimeUnit.MILLISECONDS );
        }
    }

    @Override
    public String getHiveId ()
    {
        return Hive.class.getPackage ().getName ();
    }

    protected synchronized ListenableFuture<Void> performAddConnection ( final String id, final ConnectionConfiguration configuration )
    {
        if ( this.executor == null )
        {
            return Futures.immediateFailedFuture ( new IllegalStateException ( "Hive is not started" ) );
        }

        return ListenableFutureTask.create ( new Runnable () {

            @Override
            public void run ()
            {
                handleAddConnection ( id, configuration );
            }
        }, null );
    }

    protected void performRemoveConnection ( final String id )
    {
        synchronized ( this )
        {
            if ( this.executor == null )
            {
                return;
            }

            this.executor.execute ( new Runnable () {
                @Override
                public void run ()
                {
                    handleRemoveConnection ( id );
                }
            } );
        }
    }

    protected synchronized void handleAddConnection ( final String id, final ConnectionConfiguration configuration )
    {
        final Connection old = this.connections.remove ( id );
        if ( old != null )
        {
            old.dispose ();
        }
        this.connections.put ( id, new Connection ( configuration ) );
    }

    protected synchronized void handleRemoveConnection ( final String id )
    {
        final Connection connection = this.connections.remove ( id );
        if ( connection != null )
        {
            connection.dispose ();
        }
    }

}
