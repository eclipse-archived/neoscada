/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection;

import org.eclipse.scada.core.ConnectionInformation;

public class ConnectionDescriptor
{
    private final ConnectionInformation connectionInformation;

    private final String serviceId;

    private final String description;

    public ConnectionDescriptor ( final ConnectionInformation connectionInformation )
    {
        this ( connectionInformation, null, null );
    }

    public ConnectionDescriptor ( final ConnectionInformation connectionInformation, final String serviceId, final String description )
    {
        this.connectionInformation = connectionInformation;
        this.serviceId = serviceId;
        this.description = description;
    }

    public ConnectionInformation getConnectionInformation ()
    {
        return this.connectionInformation;
    }

    public String getServiceId ()
    {
        return this.serviceId;
    }

    public String getDescription ()
    {
        return this.description;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.connectionInformation == null ? 0 : this.connectionInformation.hashCode () );
        result = prime * result + ( this.serviceId == null ? 0 : this.serviceId.hashCode () );
        return result;
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
        if ( ! ( obj instanceof ConnectionDescriptor ) )
        {
            return false;
        }
        final ConnectionDescriptor other = (ConnectionDescriptor)obj;
        if ( this.connectionInformation == null )
        {
            if ( other.connectionInformation != null )
            {
                return false;
            }
        }
        else if ( !this.connectionInformation.equals ( other.connectionInformation ) )
        {
            return false;
        }
        if ( this.serviceId == null )
        {
            if ( other.serviceId != null )
            {
                return false;
            }
        }
        else if ( !this.serviceId.equals ( other.serviceId ) )
        {
            return false;
        }
        return true;
    }

}
