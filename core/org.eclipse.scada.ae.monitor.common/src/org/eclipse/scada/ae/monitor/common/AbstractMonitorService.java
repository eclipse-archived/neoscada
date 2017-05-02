/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.monitor.common;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.ae.data.MonitorStatus;
import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.ae.monitor.MonitorListener;
import org.eclipse.scada.ae.monitor.MonitorService;
import org.eclipse.scada.utils.interner.InternerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Interner;

public abstract class AbstractMonitorService implements MonitorService
{
    private final static Logger logger = LoggerFactory.getLogger ( AbstractMonitorService.class );

    protected Set<MonitorListener> monitorListeners = new HashSet<MonitorListener> ();

    private final String id;

    private final Executor executor;

    protected MonitorStatusInformation currentState;

    private final Interner<String> stringInterner;

    public AbstractMonitorService ( final String id, final Executor executor, final Interner<String> stringInterner )
    {
        this.executor = executor;
        this.id = id;

        this.stringInterner = stringInterner == null ? InternerHelper.makeNoOpInterner () : stringInterner;

        this.currentState = new MonitorStatusInformation ( id, MonitorStatus.INIT, System.currentTimeMillis (), null, null, null, null, null, null, null );
    }

    @Override
    public String getId ()
    {
        return this.id;
    }

    protected String intern ( final String string )
    {
        return this.stringInterner.intern ( string );
    }

    @Override
    public synchronized void addStatusListener ( final MonitorListener listener )
    {
        if ( listener == null )
        {
            return;
        }

        if ( this.monitorListeners.add ( listener ) )
        {
            final MonitorStatusInformation state = this.currentState;
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    listener.statusChanged ( state );
                }
            } );
        }
    }

    protected synchronized void notifyStateChange ( final MonitorStatusInformation state )
    {
        final MonitorListener[] listeners = this.monitorListeners.toArray ( new MonitorListener[this.monitorListeners.size ()] );

        this.currentState = state;

        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                for ( final MonitorListener listener : listeners )
                {
                    try
                    {
                        listener.statusChanged ( state );
                    }
                    catch ( final Throwable e )
                    {
                        logger.warn ( "Failed to notify", e ); //$NON-NLS-1$
                    }
                }
            }
        } );
    }

    @Override
    public synchronized void removeStatusListener ( final MonitorListener listener )
    {
        this.monitorListeners.remove ( listener );
    }

}
