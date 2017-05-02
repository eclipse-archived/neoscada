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
package org.eclipse.scada.utils.reflect;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public final class Reflections
{
    private Reflections ()
    {
    }

    /**
     * Find all declared fields of a class
     * 
     * @param clazz
     *            the class to start searching for fields
     * @return The collection of fields, never returns <code>null</code>
     */
    public static Collection<Field> findAllFields ( Class<?> clazz )
    {
        final Collection<Field> result = new LinkedList<> ();

        while ( clazz != null )
        {
            result.addAll ( Arrays.asList ( clazz.getDeclaredFields () ) );
            clazz = clazz.getSuperclass ();
        }

        return result;
    }

    /**
     * Find a field from all declared fields of a class
     * 
     * @param clazz
     *            the class to start searching for the field
     * @param fieldName
     *            the name of the field to search for
     * @return the field or <code>null</code> if the field was not found
     */
    public static Field findField ( Class<?> clazz, final String fieldName )
    {
        while ( clazz != null )
        {
            try
            {
                return clazz.getDeclaredField ( fieldName );
            }
            catch ( final NoSuchFieldException e )
            {
                // continue search
            }
            clazz = clazz.getSuperclass ();
        }
        return null;
    }

}
