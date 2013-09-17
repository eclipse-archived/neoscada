/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - further development
 *******************************************************************************/
package org.eclipse.scada.sec;

import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.lang.Immutable;
import org.eclipse.scada.utils.statuscodes.CodedExceptionBase;
import org.eclipse.scada.utils.statuscodes.StatusCode;

/**
 * The result of an authentication request
 * 
 * @author Jens Reimann
 * @since 0.1.0
 */
@Immutable
public class AuthorizationResult
{

    private final StatusCode errorCode;

    private final String message;

    public static final AuthorizationResult GRANTED = new AuthorizationResult ();

    public static final AuthorizationResult ABSTAIN = null;

    public static AuthorizationResult createGranted ()
    {
        return GRANTED;
    }

    public static AuthorizationResult createAbstain ()
    {
        return ABSTAIN;
    }

    public static AuthorizationResult createReject ( final StatusCode statusCode, final String message )
    {
        if ( statusCode == null )
        {
            return createGranted ();
        }
        else
        {
            return new AuthorizationResult ( statusCode, message );
        }
    }

    public static AuthorizationResult createReject ( final Throwable error )
    {
        if ( error == null )
        {
            return createGranted ();
        }
        else if ( error instanceof CodedExceptionBase )
        {
            return new AuthorizationResult ( ( (CodedExceptionBase)error ).getStatus (), error.getMessage () );
        }
        else
        {
            return new AuthorizationResult ( StatusCodes.UNKNOWN_STATUS_CODE, error.getMessage () );
        }
    }

    protected AuthorizationResult ()
    {
        this.errorCode = null;
        this.message = null;
    }

    protected AuthorizationResult ( final StatusCode errorCode, final String message )
    {
        this.errorCode = errorCode;
        this.message = message;
    }

    public boolean isGranted ()
    {
        return this.errorCode == null && this.message == null;
    }

    public StatusCode getErrorCode ()
    {
        return this.errorCode;
    }

    public String getMessage ()
    {
        return this.message;
    }

    public <T> NotifyFuture<T> asFuture ()
    {
        final PermissionDeniedException e = asException ();
        if ( e == null )
        {
            return null;
        }
        else
        {
            return new InstantErrorFuture<T> ( e.fillInStackTrace () );
        }
    }

    /**
     * @since 1.1
     */
    public PermissionDeniedException asException ()
    {
        if ( isGranted () )
        {
            return null;
        }
        else
        {
            return new PermissionDeniedException ( this.errorCode, this.message );
        }
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder ( "[" );

        if ( this.errorCode == null )
        {
            sb.append ( "GRANTED" );
        }
        else
        {
            sb.append ( String.format ( "%s: %s", this.errorCode, this.message ) );
        }

        sb.append ( "]" );

        return sb.toString ();
    }

}
