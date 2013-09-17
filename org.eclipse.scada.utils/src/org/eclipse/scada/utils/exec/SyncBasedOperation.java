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
package org.eclipse.scada.utils.exec;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Implements an operation that is based on a synchronous operation
 * 
 * @author jens
 * @param <R>
 *            The result type
 * @param <T>
 *            The argument type
 */
public abstract class SyncBasedOperation<R, T> implements Operation<R, T>
{

    private static Executor defaultExecutor = Executors.newCachedThreadPool ();

    private Executor executor = null;

    private void performJob ( final OperationResult<R> or, final T arg0 )
    {
        try
        {
            final R result = execute ( arg0 );
            or.notifySuccess ( result );
        }
        catch ( final Exception e )
        {
            or.notifyFailure ( e );
        }
    }

    public SyncBasedOperation ()
    {
        this ( defaultExecutor );
    }

    public SyncBasedOperation ( final Executor executor )
    {
        this.executor = executor;
    }

    private void startExecute ( final OperationResult<R> or, final T arg0 )
    {
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                performJob ( or, arg0 );
            }
        } );
    }

    @Override
    public OperationResult<R> startExecute ( final T arg0 )
    {
        final OperationResult<R> or = new OperationResult<R> ();

        startExecute ( or, arg0 );

        return or;
    }

    @Override
    public OperationResult<R> startExecute ( final OperationResultHandler<R> handler, final T arg0 )
    {
        final OperationResult<R> or = new OperationResult<R> ( handler );

        startExecute ( or, arg0 );

        return or;
    }
}
