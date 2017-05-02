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
package org.eclipse.scada.da.server.exporter.rest;

import org.eclipse.scada.utils.ExceptionHelper;

public class WriteResult
{
    private String errorInformation;

    private String stackStrace;

    public WriteResult ( final Throwable error )
    {
        if ( error != null )
        {
            this.errorInformation = ExceptionHelper.getMessage ( error );
            this.stackStrace = ExceptionHelper.formatted ( error );
        }
    }

    public WriteResult ()
    {
    }

    public void setErrorInformation ( final String errorInformation )
    {
        this.errorInformation = errorInformation;
    }

    public String getErrorInformation ()
    {
        return this.errorInformation;
    }

    public void setStackStrace ( final String stackStrace )
    {
        this.stackStrace = stackStrace;
    }

    public String getStackStrace ()
    {
        return this.stackStrace;
    }

    public boolean isError ()
    {
        return this.errorInformation != null;
    }

    @Override
    public String toString ()
    {
        if ( this.errorInformation == null )
        {
            return "[OK]";
        }
        else
        {
            final StringBuilder sb = new StringBuilder ();
            sb.append ( "[Error: " + this.errorInformation );
            if ( this.stackStrace != null )
            {
                sb.append ( "\n" );
                sb.append ( this.stackStrace );
                sb.append ( "\n" );
            }
            sb.append ( "]" );
            return sb.toString ();

        }
    }
}
