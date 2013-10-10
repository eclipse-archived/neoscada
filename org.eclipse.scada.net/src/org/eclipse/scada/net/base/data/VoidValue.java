/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.net.base.data;

import org.eclipse.scada.utils.lang.Immutable;

/**
 * A void value type.
 * <p>
 * A void instance is equal to all other void instances since they don't have a real value.
 * 
 * @author Jens Reimann
 */
@Immutable
public class VoidValue extends Value
{
    public final static VoidValue INSTANCE = new VoidValue ();

    protected VoidValue ()
    {
    }

    @Override
    public int hashCode ()
    {
        return 31;
    }

    @Override
    public boolean equals ( final Object other )
    {
        if ( this == other )
        {
            return true;
        }
        if ( other == null )
        {
            return false;
        }
        if ( getClass () != other.getClass () )
        {
            return false;
        }
        return true;
    }

}
