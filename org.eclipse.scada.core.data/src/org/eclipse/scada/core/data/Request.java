/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.core.data;

public class Request implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public Request ( final long requestId )
    {
        this.requestId = requestId;
    }

    private final long requestId;

    public long getRequestId ()
    {
        return this.requestId;
    }

    @Override
    public boolean equals ( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }

        if ( ! ( obj instanceof Request ) )
        {
            return false;
        }
        final Request other = (Request)obj;

        if ( this.requestId != other.requestId )
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;

        result = prime * result + (int) ( this.requestId ^ this.requestId >>> 32 );

        return result;
    }

    @Override
    public String toString ()
    {
        return "[Request - " + "requestId: " + this.requestId + "]";
    }
}
