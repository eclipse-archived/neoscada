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
 * Base interface for operations (either sync or async based).
 * 
 * @param <R>
 *            The result type
 * @param <T>
 *            The argument type
 *            <p>
 *            The idea behind operations is that you have:
 *            <ul>
 *            <li>Synchronous operations</li>
 *            <li>Asynchronous operations</li>
 *            <li>Synchronous callers</li>
 *            <li>Asynchronous callers</li>
 *            <li>Callback callers</li>
 *            </ul>
 *            If you wish to:
 *            <ul>
 *            <li>Implement an operation that is synchronous you need to derive
 *            from {@link SyncBasedOperation}</li>
 *            <li>Implement an operation that s asynchronous you need to derive
 *            from {@link AsyncBasedOperation}</li>
 *            <li>Call an operation synchronously see {@link #execute}</li>
 *            <li>Call an operation asynchronously see
 *            {@link #startExecute(Object)}</li>
 *            <li>Call an operation an get notified by callback
 *            {@link #startExecute(OperationResultHandler handler, Object arg0)}
 *            </li>
 *            </ul>
 * @author jens
 */
public interface Operation<R, T>
{
    public R execute ( T arg0 ) throws Exception;

    public OperationResult<R> startExecute ( T arg0 );

    public OperationResult<R> startExecute ( OperationResultHandler<R> handler, T arg0 );
}
