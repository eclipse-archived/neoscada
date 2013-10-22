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
package org.eclipse.scada.configuration.generator.text;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AnnotationMessageProcessor implements MessageTarget
{

    private final Object target;

    public AnnotationMessageProcessor ( final Object target )
    {
        this.target = target;
    }

    private static interface FieldProcessor
    {
        public void process ( Object target, Field field, Message message );
    }

    protected void processFields ( final FieldProcessor processor )
    {
        for ( final Field field : findAllFields () )
        {
            final Message message = field.getAnnotation ( Message.class );
            if ( message == null )
            {
                continue;
            }

            if ( !field.isAccessible () )
            {
                field.setAccessible ( true );
                try
                {
                    processor.process ( this.target, field, message );
                }
                finally
                {
                    field.setAccessible ( false );
                }
            }
            else
            {
                processor.process ( this.target, field, message );
            }
        }
    }

    @Override
    public Map<String, String> getMessages ()
    {
        final Map<String, String> result = new HashMap<String, String> ();

        processFields ( new FieldProcessor () {

            @Override
            public void process ( final Object target, final Field field, final Message message )
            {
                try
                {
                    addResult ( result, message.id (), field.get ( target ) );
                }
                catch ( final IllegalAccessException e )
                {
                }
            }
        } );

        return result;
    }

    public Collection<Field> findAllFields ()
    {
        final Collection<Field> result = new LinkedList<> ();

        Class<?> clazz = this.target.getClass ();
        while ( clazz != null )
        {
            result.addAll ( Arrays.asList ( clazz.getDeclaredFields () ) );
            clazz = clazz.getSuperclass ();
        }

        return result;
    }

    private void addResult ( final Map<String, String> result, final String name, final Object value )
    {
        if ( value instanceof String )
        {
            result.put ( name, (String)value );
        }
    }

    public void setMessages ( final Map<String, String> overrides )
    {

        processFields ( new FieldProcessor () {

            @Override
            public void process ( final Object target, final Field field, final Message message )
            {
                try
                {
                    setMessage ( field, message.defaultText (), overrides == null ? null : overrides.get ( message.id () ) );
                }
                catch ( final IllegalAccessException e )
                {
                }
            }
        } );
    }

    protected void setMessage ( final Field field, final String defaultText, final String overrideText ) throws IllegalAccessException
    {
        if ( overrideText != null )
        {
            field.set ( this.target, overrideText );
            return;
        }
        if ( defaultText != null )
        {
            field.set ( this.target, defaultText );
            return;
        }
    }

}
