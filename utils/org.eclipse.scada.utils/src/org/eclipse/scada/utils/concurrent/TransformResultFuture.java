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

public abstract class TransformResultFuture<From, To> extends AbstractFuture<To>
{

    private final NotifyFuture<From> fromFuture;

    public TransformResultFuture ( final NotifyFuture<From> fromFuture )
    {
        this.fromFuture = fromFuture;
        this.fromFuture.addListener ( new FutureListener<From> () {

            @Override
            public void complete ( final Future<From> future )
            {
                process ( future );
            }
        } );
    }

    private void process ( final Future<From> future )
    {
        try
        {
            setResult ( transform ( future.get () ) );
        }
        catch ( final Exception e )
        {
            setError ( e );
        }
    }

    protected abstract To transform ( From from ) throws Exception;

    @Override
    public boolean cancel ( final boolean mayInterruptIfRunning )
    {
        this.fromFuture.cancel ( mayInterruptIfRunning );
        return super.cancel ( mayInterruptIfRunning );
    }

}
