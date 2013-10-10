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
package org.eclipse.scada.net.base.data;

import java.util.LinkedList;
import java.util.List;

public class ValueTools
{
    public static Long toLong ( final Value value, final Long defaultValue )
    {
        try
        {
            if ( value instanceof IntegerValue )
            {
                return Long.valueOf ( ( (IntegerValue)value ).getValue () );
            }
            else if ( value instanceof LongValue )
            {
                return ( (LongValue)value ).getValue ();
            }
            else if ( value instanceof DoubleValue )
            {
                return (long) ( (DoubleValue)value ).getValue ();
            }
            else if ( value instanceof StringValue )
            {
                final String data = ( (StringValue)value ).getValue ();
                return Long.decode ( data );
            }
            else
            {
                return defaultValue;
            }
        }
        catch ( final Exception e )
        {
            return defaultValue;
        }
    }

    public static long toLong ( final Value value, final long defaultValue )
    {
        return toLong ( value, defaultValue );
    }

    public static Integer toInteger ( final Value value, final Integer defaultValue )
    {
        try
        {
            if ( value instanceof IntegerValue )
            {
                return ( (IntegerValue)value ).getValue ();
            }
            else if ( value instanceof LongValue )
            {
                return (int) ( (LongValue)value ).getValue ();
            }
            else if ( value instanceof DoubleValue )
            {
                return (int) ( (DoubleValue)value ).getValue ();
            }
            else if ( value instanceof StringValue )
            {
                final String data = ( (StringValue)value ).getValue ();
                return Integer.decode ( data );
            }
            else
            {
                return defaultValue;
            }
        }
        catch ( final Exception e )
        {
            return defaultValue;
        }
    }

    public static int toInteger ( final Value value, final int defaultValue )
    {
        return toInteger ( value, Integer.valueOf ( defaultValue ) );
    }

    public static ListValue toStringList ( final Iterable<?> list )
    {
        final ListValue listValue = new ListValue ();

        for ( final Object obj : list )
        {
            listValue.add ( new StringValue ( obj.toString () ) );
        }

        return listValue;
    }

    public static List<String> fromStringList ( final ListValue list )
    {
        final List<String> newList = new LinkedList<String> ();

        for ( final Value value : list.getValues () )
        {
            newList.add ( value.toString () );
        }

        return newList;
    }
}
