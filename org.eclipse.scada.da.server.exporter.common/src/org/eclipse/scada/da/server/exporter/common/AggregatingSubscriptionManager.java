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

import java.util.Properties;
import java.util.Set;
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

    /**
     * Create a new subscription manager
     *
     * @param executor
     *            a single threaded executor
     * @param hiveSource
     *            the source of the hive to attach to
     * @param properties
     *            the session properties for the hive
     * @param logName
     *            An optional name of the actor, which will be used for logging
     * @param listener
     *            optionally a listener that will get a call when any of the
     *            values in the cache changed
     */
    public AggregatingSubscriptionManager ( final ScheduledExecutorService executor, final HiveSource hiveSource, final Properties properties, final String logName, final Listener listener )
    {
        super ( hiveSource, properties, executor, logName );
        this.executor = executor;
        this.listener = listener;
    }

    /**
     * Create a new subscription manager
     *
     * @param executor
     *            a single threaded executor
     * @param hiveSource
     *            the source of the hive to attach to
     * @param properties
     *            the session properties for the hive
     * @param logName
     *            An optional name of the actor, which will be used for logging
     */
    public AggregatingSubscriptionManager ( final ScheduledExecutorService executor, final HiveSource hiveSource, final Properties properties, final String logName )
    {
        this ( executor, hiveSource, properties, logName, null );
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

        if ( this.listener == null )
        {
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

    @Override
    public void subscribeAll ( final Set<String> itemIds )
    {
        super.subscribeAll ( itemIds );
    }

}
