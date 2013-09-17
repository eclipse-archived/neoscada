/*******************************************************************************
 * Copyright (c) 2006, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/package org.eclipse.scada.utils.exec;

import org.eclipse.scada.utils.exec.OperationResultHandler;

class OperationHandlerTestImpl<R> implements OperationResultHandler<R>
{
    R _result = null;

    Exception _exception = null;

    boolean _failure = false;

    boolean _success = false;

    @Override
    public void failure ( final Exception e )
    {
        this._result = null;
        this._exception = e;
        this._success = false;
        this._failure = true;
    }

    @Override
    public void success ( final R result )
    {
        this._result = result;
        this._exception = null;
        this._success = true;
        this._failure = false;
    }

    public Exception getException ()
    {
        return this._exception;
    }

    public boolean isFailure ()
    {
        return this._failure;
    }

    public R getResult ()
    {
        return this._result;
    }

    public boolean isSuccess ()
    {
        return this._success;
    }

}