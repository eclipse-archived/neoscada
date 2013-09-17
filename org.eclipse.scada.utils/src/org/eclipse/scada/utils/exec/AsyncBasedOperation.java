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

/**
 * Implements an operation that is based on a asynchronous operation.
 * 
 * @author jens
 * @param <R>
 *            The result type
 * @param <T>
 *            The argument type
 */

public abstract class AsyncBasedOperation<R, T> implements Operation<R, T>
{

    @Override
    public R execute ( final T arg0 ) throws Exception
    {
        final OperationResult<R> result = startExecute ( arg0 );

        result.complete ();

        if ( result.isSuccess () )
        {
            return result.get ();
        }
        else
        {
            throw result.getException ();
        }
    }

    protected abstract void startExecute ( OperationResult<R> or, T arg0 );

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
