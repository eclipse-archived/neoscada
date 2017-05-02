/*******************************************************************************
 * Copyright (c) 2006, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.concurrent;

/**
 * A base class for instant futures
 * 
 * @author Jens Reimann
 * @param <T>
 *            the value type
 */
public abstract class InstantFutureBase<T> implements NotifyFuture<T>
{

    public InstantFutureBase ()
    {
        super ();
    }

    @Override
    public boolean isCancelled ()
    {
        return false;
    }

    @Override
    public boolean isDone ()
    {
        return true;
    }

    @Override
    public boolean cancel ( final boolean mayInterruptIfRunning )
    {
        return false;
    }

    @Override
    public void addListener ( final FutureListener<T> listener )
    {
        // we can simple trigger the listener
        listener.complete ( this );
    }

    @Override
    public void removeListener ( final FutureListener<T> listener )
    {
        // nothing to do
    }

    @Override
    public void addListener ( final Runnable listener )
    {
        listener.run ();
    }

    @Override
    public void removeListener ( final Runnable listener )
    {
        // nothing to do
    }

}