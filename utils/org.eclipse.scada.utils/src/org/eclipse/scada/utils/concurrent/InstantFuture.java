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

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * A future that never has to run since the result is already known
 * 
 * @author Jens Reimann
 * @param <T>
 *            the type of the future
 */
public class InstantFuture<T> extends InstantFutureBase<T>
{
    private final T value;

    public InstantFuture ( final T value )
    {
        this.value = value;
    }

    @Override
    public T get () throws InterruptedException, ExecutionException
    {
        return this.value;
    }

    @Override
    public T get ( final long timeout, final TimeUnit unit ) throws InterruptedException, ExecutionException, TimeoutException
    {
        return this.value;
    }
}