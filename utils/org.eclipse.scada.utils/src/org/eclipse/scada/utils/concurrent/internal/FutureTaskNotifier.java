/*******************************************************************************
 * Copyright (c) 2006, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.concurrent.internal;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;

import org.eclipse.scada.utils.concurrent.FutureListener;

public class FutureTaskNotifier<T>
{

    private final Object lock = new Object ();

    private final Set<FutureListener<T>> listeners = new HashSet<FutureListener<T>> ( 1 );

    private final Set<Runnable> runnables = new HashSet<Runnable> ();

    private boolean done = false;

    private final Future<T> future;

    public FutureTaskNotifier ( final Future<T> future )
    {
        this.future = future;
    }

    public void done ()
    {
        Set<FutureListener<T>> listeners;
        final Set<Runnable> runnables;
        synchronized ( this.lock )
        {
            if ( this.done )
            {
                return;
            }

            this.done = true;
            listeners = new HashSet<FutureListener<T>> ( this.listeners );
            runnables = new HashSet<Runnable> ( this.runnables );
        }

        // notify
        for ( final FutureListener<T> listener : listeners )
        {
            try
            {
                listener.complete ( this.future );
            }
            catch ( final Throwable e )
            {
            }
        }
        for ( final Runnable runnable : runnables )
        {
            try
            {
                runnable.run ();
            }
            catch ( final Throwable e )
            {
            }
        }

        // just clean up
        this.listeners.clear ();
        this.runnables.clear ();
    }

    public void addListener ( final Runnable listener )
    {
        boolean notifyNow = false;
        synchronized ( this.lock )
        {
            if ( this.done )
            {
                notifyNow = true;
            }
            else
            {
                this.runnables.add ( listener );
            }
        }

        if ( notifyNow )
        {
            listener.run ();
        }
    }

    public void removeListener ( final Runnable listener )
    {
        synchronized ( this.lock )
        {
            this.runnables.remove ( listener );
        }
    }

    public void addListener ( final FutureListener<T> listener )
    {
        boolean notifyNow = false;
        synchronized ( this.lock )
        {
            if ( this.done )
            {
                notifyNow = true;
            }
            else
            {
                this.listeners.add ( listener );
            }
        }

        if ( notifyNow )
        {
            listener.complete ( this.future );
        }
    }

    public void removeListener ( final FutureListener<T> listener )
    {
        synchronized ( this.lock )
        {
            this.listeners.remove ( listener );
        }
    }

}
