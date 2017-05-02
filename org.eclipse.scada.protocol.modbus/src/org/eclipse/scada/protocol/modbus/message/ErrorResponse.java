/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.modbus.message;

import org.eclipse.scada.protocol.modbus.Constants;

/**
 * An error response to a request
 */
public class ErrorResponse extends BaseMessage
{
    private final byte exceptionCode;

    /**
     * Create a new error response
     *
     * @param transactionId
     *            the request transaction id
     * @param unitIdentifier
     *            the request unit id
     * @param functionCode
     *            the original function code, no having the exception flag set
     * @param exceptionCode
     *            the exception code. Also see {@link Constants}.
     */
    public ErrorResponse ( final int transactionId, final byte unitIdentifier, final byte functionCode, final byte exceptionCode )
    {
        super ( transactionId, unitIdentifier, functionCode );
        this.exceptionCode = exceptionCode;
    }

    public byte getExceptionCode ()
    {
        return this.exceptionCode;
    }

    @Override
    public String toString ()
    {
        return "ErrorResponse [unitIdentifier=" + this.unitIdentifier + ", functionCode=" + ( this.functionCode - (byte)0x80 ) + ", exceptionCode=" + this.exceptionCode + "]";
    }
}
