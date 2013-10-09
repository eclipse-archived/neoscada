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
package org.eclipse.scada.protocol.modbus.io;

public class ChecksumProtocolException extends RuntimeException
{

    private static final long serialVersionUID = 1L;

    public ChecksumProtocolException ()
    {
        super ();
    }

    public ChecksumProtocolException ( final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace )
    {
        super ( message, cause, enableSuppression, writableStackTrace );
    }

    public ChecksumProtocolException ( final String message, final Throwable cause )
    {
        super ( message, cause );
    }

    public ChecksumProtocolException ( final String message )
    {
        super ( message );
    }

    public ChecksumProtocolException ( final Throwable cause )
    {
        super ( cause );
    }

}
