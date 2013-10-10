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
package org.eclipse.scada.da.server.common.chain;

import java.util.EnumSet;

import org.eclipse.scada.da.data.IODirection;

public class ChainProcessEntry
{
    private EnumSet<IODirection> _when = EnumSet.noneOf ( IODirection.class );

    private ChainItem _what = null;

    public ChainProcessEntry ( final EnumSet<IODirection> when, final ChainItem what )
    {
        super ();
        this._when = when;
        this._what = what;
    }

    public ChainProcessEntry ()
    {
        super ();
    }

    public ChainItem getWhat ()
    {
        return this._what;
    }

    public void setWhat ( final ChainItem what )
    {
        this._what = what;
    }

    public EnumSet<IODirection> getWhen ()
    {
        return this._when;
    }

    public void setWhen ( final EnumSet<IODirection> when )
    {
        this._when = when;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this._what == null ? 0 : this._what.hashCode () );
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
        final ChainProcessEntry other = (ChainProcessEntry)obj;
        if ( this._what == null )
        {
            if ( other._what != null )
            {
                return false;
            }
        }
        else if ( !this._what.equals ( other._what ) )
        {
            return false;
        }
        return true;
    }
}
