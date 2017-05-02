/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common;

import java.util.EnumSet;
import java.util.Set;

import org.eclipse.scada.da.core.DataItemInformation;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.utils.lang.Immutable;
import org.eclipse.scada.utils.str.StringHelper;

/**
 * Default implementation of data {@link DataItemInformation}
 * 
 * @author Jens Reimann
 */
@Immutable
public class DataItemInformationBase implements org.eclipse.scada.da.core.DataItemInformation
{
    private final String id;

    private final Set<IODirection> ioDirection;

    public DataItemInformationBase ( final String id, final Set<IODirection> ioDirection )
    {
        super ();
        this.id = id;
        this.ioDirection = EnumSet.copyOf ( ioDirection );
    }

    public DataItemInformationBase ( final String id )
    {
        super ();
        this.id = id;
        this.ioDirection = EnumSet.allOf ( IODirection.class );
    }

    public DataItemInformationBase ( final DataItemInformation information )
    {
        super ();

        this.id = information.getName ();
        this.ioDirection = EnumSet.copyOf ( information.getIODirection () );
    }

    @Override
    public Set<IODirection> getIODirection ()
    {
        return this.ioDirection;
    }

    @Override
    public String getName ()
    {
        return this.id;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.id == null ? 0 : this.id.hashCode () );
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
        if ( getClass () != obj.getClass () )
        {
            return false;
        }
        final DataItemInformationBase other = (DataItemInformationBase)obj;
        if ( this.id == null )
        {
            if ( other.id != null )
            {
                return false;
            }
        }
        else if ( !this.id.equals ( other.id ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[%s, %s]", this.id, StringHelper.join ( this.ioDirection, ", " ) );
    }

}
