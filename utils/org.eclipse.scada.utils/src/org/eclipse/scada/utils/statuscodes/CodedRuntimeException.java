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
package org.eclipse.scada.utils.statuscodes;

public class CodedRuntimeException extends RuntimeException implements CodedExceptionBase
{

    private static final long serialVersionUID = -1075738726086251513L;

    private final StatusCode statusCode;

    public CodedRuntimeException ( final StatusCode statusCode )
    {
        super ();
        this.statusCode = statusCode;
    }

    public CodedRuntimeException ( final StatusCode statusCode, final String message )
    {
        super ( message );
        this.statusCode = statusCode;
    }

    public CodedRuntimeException ( final StatusCode statusCode, final String message, final Throwable cause )
    {
        super ( message, cause );
        this.statusCode = statusCode;
    }

    public CodedRuntimeException ( final StatusCode statusCode, final Throwable cause )
    {
        super ( cause );
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage ()
    {
        final String message = this.statusCode + ": " + super.getMessage ();
        return message;
    }

    @Override
    public StatusCode getStatus ()
    {
        return this.statusCode;
    }

    @Override
    public String getOriginalMessage ()
    {
        return super.getMessage ();
    }
}
