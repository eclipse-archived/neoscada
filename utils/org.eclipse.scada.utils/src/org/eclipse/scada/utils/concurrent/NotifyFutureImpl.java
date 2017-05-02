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

/**
 * An implementation of {@link NotifyFuture} which can publicly be accessed
 * 
 * @since 1.1
 */
public class NotifyFutureImpl<T> extends AbstractFuture<T>
{
    @Override
    public void setError ( final Throwable error )
    {
        super.setError ( error );
    }

    @Override
    public void setResult ( final T result )
    {
        super.setResult ( result );
    }
}
