/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.concurrent;

import java.util.concurrent.Executor;

public class ExecutorFuture<T> extends AbstractFuture<T>
{
    private final Executor executor;

    public ExecutorFuture ( final Executor executor )
    {
        this.executor = executor;
    }

    public void asyncSetResult ( final T result )
    {
        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                setResult ( result );
            };
        } );
    }

    public void asyncSetError ( final Throwable error )
    {
        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                setError ( error );
            };
        } );
    }
}