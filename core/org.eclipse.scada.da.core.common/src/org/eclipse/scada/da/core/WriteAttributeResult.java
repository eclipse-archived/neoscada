/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.core;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.scada.utils.lang.Immutable;

@Immutable
public class WriteAttributeResult
{
    private Throwable error = null;

    /**
     * A constant that represents the <q>OK</q> state
     */
    public static final WriteAttributeResult OK = new WriteAttributeResult ();

    /**
     * Create an <q>OK</q> result
     * @deprecated use the {@link #OK} constant instead
     */
    @Deprecated
    public WriteAttributeResult ()
    {
    }

    /**
     * Create a result with error information
     * @param error the error or <code>null</code> if the result is "ok"
     */
    public WriteAttributeResult ( final Throwable error )
    {
        this.error = error;
    }

    public Throwable getError ()
    {
        return this.error;
    }

    public boolean isError ()
    {
        return this.error != null;
    }

    public boolean isSuccess ()
    {
        return this.error == null;
    }

    @Override
    public String toString ()
    {
        if ( this.error == null )
        {
            return "OK";
        }
        String message = this.error.getMessage ();
        if ( message == null )
        {
            final StringWriter sw = new StringWriter ();
            final PrintWriter pw = new PrintWriter ( sw );
            this.error.printStackTrace ( pw );
            pw.close ();
            message = sw.toString ();
        }
        return message;
    }
}