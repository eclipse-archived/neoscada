/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.relp.data;

public class AbstractGenericResponse
{
    private final long transactionId;

    private final int code;

    private final String message;

    public AbstractGenericResponse ( final long transactionId, final int code, final String message )
    {
        this.transactionId = transactionId;
        this.code = code;
        this.message = message;
    }

    public long getTransactionId ()
    {
        return this.transactionId;
    }

    public int getCode ()
    {
        return this.code;
    }

    public String getMessage ()
    {
        return this.message;
    }

}