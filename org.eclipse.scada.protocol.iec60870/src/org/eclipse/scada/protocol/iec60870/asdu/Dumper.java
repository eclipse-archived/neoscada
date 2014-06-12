/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.iec60870.asdu;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.scada.protocol.iec60870.asdu.types.ASDU;
import org.eclipse.scada.utils.ExceptionHelper;

public class Dumper
{
    private static String NL = System.getProperty ( "line.separator", "\n" );

    private final StringBuilder buffer;

    private final int level;

    public Dumper ( final StringBuilder buffer )
    {
        this ( buffer, 0 );
    }

    protected Dumper ( final StringBuilder buffer, final int level )
    {
        this.buffer = buffer;
        this.level = level;
    }

    public void field ( final String fieldName, final Object value )
    {
        indent ( 1 );

        this.buffer.append ( fieldName ).append ( " : " );
        if ( value instanceof Dumpable )
        {
            DumperHelper.dump ( (Dumpable)value, createChild () );
        }
        else
        {
            this.buffer.append ( value );
        }

        this.buffer.append ( NL );
    }

    private void indent ( final int offset )
    {
        for ( int i = 0; i < this.level + offset; i++ )
        {
            this.buffer.append ( "  " );
        }
    }

    public void start ( final Dumpable object )
    {
        indent ( 0 );
        this.buffer.append ( object.getClass ().getName () );
        final ASDU asdu = object.getClass ().getAnnotation ( ASDU.class );
        if ( asdu != null )
        {
            this.buffer.append ( "(" );
            this.buffer.append ( asdu.name () ).append ( '=' ).append ( asdu.id () & 0xFF );
            this.buffer.append ( ")" );
        }
        this.buffer.append ( NL );

        indent ( 0 );
        this.buffer.append ( "----- START ----" ).append ( NL );
    }

    public void end ()
    {
        indent ( 0 );
        this.buffer.append ( "-----  END  ----" );
    }

    public Dumper createChild ()
    {
        return new Dumper ( this.buffer, this.level + 1 );
    }

    protected void fields ( final Class<?> clazz, final Object object, final Set<Class<?>> classes )
    {
        if ( clazz == null )
        {
            return;
        }

        if ( classes.contains ( clazz ) )
        {
            return;
        }

        classes.add ( clazz );

        fields ( clazz.getSuperclass (), object, classes );

        for ( final Class<?> iface : clazz.getInterfaces () )
        {
            fields ( iface, object, classes );
        }

        for ( final Field field : clazz.getDeclaredFields () )
        {
            if ( Modifier.isStatic ( field.getModifiers () ) )
            {
                // skip static fields
                continue;
            }

            try
            {
                boolean changed = false;
                if ( !field.isAccessible () )
                {
                    changed = true;
                    field.setAccessible ( true );
                }
                try
                {
                    field ( field.getName (), field.get ( object ) );
                }
                finally
                {
                    if ( changed )
                    {
                        field.setAccessible ( false );
                    }
                }
            }
            catch ( final Exception e )
            {
                field ( field.getName (), String.format ( "<EXCEPTION: %s>", ExceptionHelper.getMessage ( e ) ) );
            }
        }
    }

    public void fields ( final Object object )
    {
        fields ( object.getClass (), object, new HashSet<Class<?>> () );
    }
}
