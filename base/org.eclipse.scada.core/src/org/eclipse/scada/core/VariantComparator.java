/*******************************************************************************
 * Copyright (c) 2006, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core;

import java.io.Serializable;
import java.util.Comparator;

public class VariantComparator implements Comparator<Variant>, Serializable
{
    private static final long serialVersionUID = 1L;

    @Override
    public int compare ( final Variant o1, final Variant o2 )
    {
        // special cases
        if ( o1 == o2 )
        {
            return 0;
        }
        if ( o1 == null && o2 == null )
        {
            return 0;
        }
        if ( o1 == null && o2.isNull () )
        {
            return 0;
        }
        if ( o2 == null && o1.isNull () )
        {
            return 0;
        }
        if ( o1 != null && o2 != null && o1.isNull () && o2.isNull () )
        {
            return 0;
        }
        // check if one of the parameters is null
        if ( o1 == null || o1.isNull () )
        {
            return -1;
        }
        if ( o2 == null || o2.isNull () )
        {
            return 1;
        }

        // first check for strings

        if ( o1.isString () || o2.isString () )
        {
            try
            {
                // try to convert to double
                o1.asDouble ();
                o2.asDouble ();
            }
            catch ( final Exception e )
            {
                return o1.asString ( "" ).compareTo ( o2.asString ( "" ) );
            }
        }

        // compare by double value

        final double v1 = o1.asDouble ( 0.0 );
        final double v2 = o2.asDouble ( 0.0 );

        return Double.compare ( v1, v2 );
    }
}
