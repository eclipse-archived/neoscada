/*******************************************************************************
 * Copyright (c) 2006, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - further development
 *******************************************************************************/
package org.eclipse.scada.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionHelper
{

    /**
     * Get the root cause of an exception
     * 
     * @param e
     *            the exception to check, must not be <code>null</code>
     * @return the root cause, is never <code>null</code>
     */
    public static Throwable getRootCause ( Throwable e )
    {
        if ( e == null )
        {
            return null;
        }

        while ( e.getCause () != null )
        {
            e = e.getCause ();
        }
        return e;
    }

    /**
     * Get the message of the root cause
     * 
     * @param e
     *            the exception from which the message should be extracted
     * @return the message of the root cause
     * @see StatusHelper#extractMessage(Throwable)
     */
    public static String getMessage ( final Throwable e )
    {
        return extractMessage ( getRootCause ( e ) );
    }

    /**
     * Extract the message from an exception
     * 
     * @param e
     *            the exception to extract the message from
     * @return either the localized message, the message or the class name (in
     *         that order)
     */
    public static String extractMessage ( final Throwable e )
    {
        if ( e == null )
        {
            return null;
        }

        if ( e.getLocalizedMessage () != null )
        {
            return e.getLocalizedMessage ();
        }
        else if ( e.getMessage () != null )
        {
            return e.getMessage ();
        }
        else
        {
            return e.getClass ().getName ();
        }
    }

    /**
     * Format exception as string
     * 
     * @param e
     *            the exception to format, may be <code>null</code>
     * @return the formatted exception or <code>null</code> if the exception was
     *         <code>null</code>.
     */
    public static String formatted ( final Throwable e )
    {
        if ( e == null )
        {
            return null;
        }

        final StringWriter sw = new StringWriter ();
        final PrintWriter pw = new PrintWriter ( sw );

        e.printStackTrace ( pw );

        pw.close ();

        return sw.toString ();
    }
}
