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
package org.eclipse.scada.utils.inject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.scada.utils.str.StringHelper;

public class InjectHelper
{

    public static void injectFields ( final Object target, final Collection<Field> fields, final Map<String, Object> context, final List<Object> specialInstances )
    {
        fields: for ( final Field field : fields )
        {
            // check annotation

            final Inject inject = field.getAnnotation ( Inject.class );
            if ( inject == null )
            {
                continue;
            }

            // eval name

            String name;
            final Named named = field.getAnnotation ( Named.class );
            if ( named != null )
            {
                name = named.value ();
            }
            else
            {
                name = field.getName ();
            }

            // optional

            final boolean optional = field.getAnnotation ( Optional.class ) != null;

            // check for special instances

            if ( named == null )
            {
                for ( final Object o : specialInstances )
                {
                    if ( field.getType ().isAssignableFrom ( o.getClass () ) )
                    {
                        try
                        {
                            setField ( target, field, o );
                        }
                        catch ( final Exception e )
                        {
                            throw new RuntimeException ( e );
                        }
                        // continue with other fields
                        continue fields;
                    }
                }
            }

            if ( !context.containsKey ( name ) )
            {
                if ( !optional )
                {
                    throw new IllegalStateException ( String.format ( "Unable to find '%s' in current context - Context: %s", name, context ) );
                }
                continue; // field is optional
            }

            final Object value = context.get ( name );
            if ( !field.getType ().isAssignableFrom ( value.getClass () ) )
            {
                throw new IllegalStateException ( String.format ( "Field '%s' cannot be assigned - sourceType %s is incompatible with fieldType %s", field.getName (), value.getClass (), field.getType () ) );
            }

            try
            {
                setField ( target, field, value );
            }
            catch ( final Exception e )
            {
                throw new RuntimeException ( e );
            }
        }
    }

    /**
     * Set a field value
     * <p>
     * The method will try to set the field using a setter first.
     * </p>
     * 
     * @param target
     *            the target object
     * @param field
     *            the field to set
     * @param value
     *            the value to set
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void setField ( final Object target, final Field field, final Object value ) throws IllegalArgumentException, IllegalAccessException
    {
        try
        {
            // try setter first
            final Method setter = target.getClass ().getMethod ( "set" + StringHelper.toUpperFirst ( field.getName () ), field.getType () );
            setter.invoke ( target, value );
        }
        catch ( final Exception e )
        {
            // continue with field access
        }

        if ( field.isAccessible () )
        {
            field.set ( target, value );
        }
        else
        {
            field.setAccessible ( true );
            try
            {
                field.set ( target, value );
            }
            finally
            {
                field.setAccessible ( false );
            }
        }
    }

    public static Object getField ( final Object target, final Field field ) throws IllegalArgumentException, IllegalAccessException
    {
        if ( field.isAccessible () )
        {
            return field.get ( target );
        }
        else
        {
            field.setAccessible ( true );
            try
            {
                return field.get ( target );
            }
            finally
            {
                field.setAccessible ( false );
            }
        }
    }

}
