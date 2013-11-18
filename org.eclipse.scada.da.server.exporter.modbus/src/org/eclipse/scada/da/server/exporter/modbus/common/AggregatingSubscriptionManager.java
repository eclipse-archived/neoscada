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
package org.eclipse.scada.da.server.exporter.modbus.common;

import java.util.Properties;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.da.client.DataItemValue;

public class AggregatingSubscriptionManager extends AbstractSubscriptionManager
{

    public interface Listener
    {
        public void stateUpdate ();
    }

    private final Listener listener;

    protected final ScheduledExecutorService executor;

    public AggregatingSubscriptionManager ( final ScheduledExecutorService executor, final HiveSource hiveSource, final Properties properties, final Listener listener )
    {
        super ( hiveSource, properties );
        this.executor = executor;
        this.listener = listener;
    }

    @Override
    public synchronized void stop ()
    {
        super.stop ();
        notifyStateUpdate ( true ); // explicitly notify ignoring the dispose state
    }

    private void notifyStateUpdate ( final boolean ignoreDisposed )
    {
        if ( this.started && !ignoreDisposed )
        {
            // early check
            return;
        }

        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                if ( !AggregatingSubscriptionManager.this.started || ignoreDisposed )
                {
                    AggregatingSubscriptionManager.this.listener.stateUpdate ();
                }
            }
        } );
    }

    @Override
    protected void clearCache ()
    {
        super.clearCache ();
        notifyStateUpdate ( false );
    }

    @Override
    protected void putState ( final String itemId, final DataItemValue value )
    {
        super.putState ( itemId, value );
        notifyStateUpdate ( false );
    }

    @Override
    public synchronized void subscribe ( final String itemId )
    {
        super.subscribe ( itemId );
    }

    @Override
    public synchronized void unsubscribe ( final String itemId )
    {
        super.unsubscribe ( itemId );
    }
}
