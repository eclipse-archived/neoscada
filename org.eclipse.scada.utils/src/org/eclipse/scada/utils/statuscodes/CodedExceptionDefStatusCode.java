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

public abstract class CodedExceptionDefStatusCode extends Exception implements CodedExceptionBase

{

    private static final long serialVersionUID = 2893453354487364387L;

    private StatusCode statusCode;

    public CodedExceptionDefStatusCode ()
    {
        super ();
        setStatusCode ( generateStatusCode () );
    }

    public CodedExceptionDefStatusCode ( final String message )
    {
        super ( message );
        setStatusCode ( generateStatusCode () );
    }

    public CodedExceptionDefStatusCode ( final Throwable cause )
    {
        super ( cause );
        setStatusCode ( generateStatusCode () );
    }

    public CodedExceptionDefStatusCode ( final String message, final Throwable cause )
    {
        super ( message, cause );
        setStatusCode ( generateStatusCode () );
    }

    /**
     * the implementation of setStatusCode must provide the statuscode you want
     * your exception to have.
     * either get it from the local statusCode file (StatusCodes) or create a
     * new statusCode (new StatusCode()).
     */
    protected abstract StatusCode generateStatusCode ();

    private void setStatusCode ( final StatusCode status )
    {
        this.statusCode = status;
    }

    @Override
    public StatusCode getStatus ()
    {
        return this.statusCode;
    }

    @Override
    public String getMessage ()
    {
        final String message = this.statusCode + ": " + super.getMessage ();
        return message;
    }

    @Override
    public String getOriginalMessage ()
    {
        return super.getMessage ();
    }

}
