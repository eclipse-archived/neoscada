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
package org.eclipse.scada.utils.concurrent;

import java.util.concurrent.Future;

/**
 * A future handler which calls a method and passes on the result to itself,
 * implementing another future.
 * 
 * @since 1.1
 */
public abstract class CallingFuture<T, T2> extends AbstractFuture<T2>
{
    private final NotifyFuture<T> future;

    public CallingFuture ( final NotifyFuture<T> future )
    {
        this.future = future;
        this.future.addListener ( new FutureListener<T> () {
            @Override
            public void complete ( final Future<T> future )
            {
                handleComplete ( future );
            }
        } );
    }

    public abstract T2 call ( final Future<T> future ) throws Exception;

    protected void handleComplete ( final Future<T> future )
    {
        try
        {
            setResult ( call ( future ) );
        }
        catch ( final Exception e )
        {
            setError ( e );
        }
    }

    @Override
    public boolean cancel ( final boolean mayInterruptIfRunning )
    {
        this.future.cancel ( mayInterruptIfRunning );
        return super.cancel ( mayInterruptIfRunning );
    }
}
