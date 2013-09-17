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

public class CodedException extends Exception implements CodedExceptionBase
{
    private static final long serialVersionUID = 2962144070439177464L;

    protected StatusCode status;

    public CodedException ( final StatusCode statusCode )
    {
        super ();
        this.status = statusCode;
    }

    public CodedException ( final StatusCode statusCode, final String message )
    {
        super ( message );
        this.status = statusCode;
    }

    public CodedException ( final StatusCode statusCode, final Throwable cause )
    {
        super ( cause );
        this.status = statusCode;
    }

    public CodedException ( final StatusCode statusCode, final String message, final Throwable cause )
    {
        super ( message, cause );
        this.status = statusCode;
    }

    @Override
    public StatusCode getStatus ()
    {
        return this.status;
    }

    /**
     * overrides getMessage to produce a message bearing the assigned statusCode
     * and the
     * the default Message of this exception type
     */
    @Override
    public String getMessage ()
    {
        final String message = getStatus () + ": " + super.getMessage ();
        return message;
    }

    @Override
    public String getOriginalMessage ()
    {
        return super.getMessage ();
    }
}
