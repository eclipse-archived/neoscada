/*******************************************************************************
 * Copyright (c) 2006, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - documentation
 *******************************************************************************/
package org.eclipse.scada.utils.str;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.scada.utils.lang.Apply;

/**
 * A helper class for string operations
 * 
 * @author Jens Reimann
 */
public class StringHelper
{
    /**
     * Join a collection of objects to a string using a delimiter.
     * The method will take the {@link Object#toString()} result of each
     * collection
     * member and add it to the result string. Delimiters are only placed
     * between
     * elements
     * 
     * @param items
     *            The items to convert
     * @param delimiter
     *            the delimiter to use
     * @return the result string
     */
    public static String join ( final Collection<?> items, final String delimiter )
    {
        final StringBuilder buffer = new StringBuilder ();
        final Iterator<?> iter = items.iterator ();

        while ( iter.hasNext () )
        {
            buffer.append ( iter.next () );
            if ( iter.hasNext () )
            {
                buffer.append ( delimiter );
            }
        }

        return buffer.toString ();
    }

    public static String join ( final Collection<?> items, final String delimiter, final Apply<String> toApply )
    {
        final StringBuilder buffer = new StringBuilder ();
        final Iterator<?> iter = items.iterator ();

        while ( iter.hasNext () )
        {
            if ( toApply != null )
            {
                buffer.append ( toApply.apply ( String.valueOf ( iter.next () ) ) );
            }
            else
            {
                buffer.append ( iter.next () );
            }
            if ( iter.hasNext () )
            {
                buffer.append ( delimiter );
            }
        }

        return buffer.toString ();
    }

    /**
     * Join a collection of objects to a string using a delimiter.
     * The method will take the {@link Object#toString()} result of each
     * collection
     * member and add it to the result string. Delimiters are only placed
     * between
     * elements
     * 
     * @param items
     *            The items to convert
     * @param delimiter
     *            the delimiter to use
     * @return the result string
     */
    public static String join ( final Object[] items, final String delimiter )
    {
        final StringBuilder buffer = new StringBuilder ();

        for ( int i = 0; i < items.length; i++ )
        {
            if ( i != 0 )
            {
                buffer.append ( delimiter );
            }

            buffer.append ( items[i] );
        }

        return buffer.toString ();
    }

    /**
     * Make the first character of a string uppercase
     * 
     * @param text
     *            the string, may be <code>null</code>
     * @return the result, or <code>null</code> if the input was
     *         <code>null</code>
     */
    public static String toUpperFirst ( final String text )
    {
        if ( text == null )
        {
            return null;
        }
        if ( text.length () <= 1 )
        {
            return text.toUpperCase ();
        }

        return text.substring ( 0, 1 ).toUpperCase () + text.substring ( 1 );
    }

    /**
     * Make the first character of a string lowercase
     * 
     * @param text
     *            the string, may be <code>null</code>
     * @return the result, or <code>null</code> if the input was
     *         <code>null</code>
     */
    public static String toLowerFirst ( final String text )
    {
        if ( text == null )
        {
            return null;
        }
        if ( text.length () <= 1 )
        {
            return text.toLowerCase ();
        }

        return text.substring ( 0, 1 ).toLowerCase () + text.substring ( 1 );
    }
}
