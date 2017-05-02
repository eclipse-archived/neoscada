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
package org.eclipse.scada.protocol.sfp.messages;

public class WriteResult
{
    private final int operationId;

    private final int errorCode;

    private final String errorMessage;

    public WriteResult ( final int operationId, final int errorCode, final String errorMessage )
    {
        this.operationId = operationId;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getOperationId ()
    {
        return this.operationId;
    }

    public int getErrorCode ()
    {
        return this.errorCode;
    }

    public String getErrorMessage ()
    {
        return this.errorMessage;
    }
}
