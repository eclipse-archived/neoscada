/*******************************************************************************
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.asdu;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.neoscada.protocol.iec60870.asdu.types.ASDU;
import org.eclipse.scada.utils.ExceptionHelper;

public class Dumper
{
    private final PrintWriter buffer;

    private final int level;

    public Dumper ( final PrintWriter buffer )
    {
        this ( buffer, 0 );
    }

    protected Dumper ( final PrintWriter buffer, final int level )
    {
        this.buffer = buffer;
        this.level = level;
    }

    public void field ( final String fieldName, final Object value )
    {
        indent ( 1 );

        this.buffer.format ( "%s : ", fieldName );
        if ( value instanceof Dumpable )
        {
            DumperHelper.dump ( (Dumpable)value, createChild () );
        }
        else if ( value instanceof Collection<?> )
        {
            final Collection<?> col = (Collection<?>)value;
            switch ( col.size () )
            {
                case 0:
                    this.buffer.print ( "<empty>" );
                    break;
                case 1:
                    this.buffer.print ( value );
                    break;
                default:
                    this.buffer.println ( "[" );
                    for ( final Object o : col )
                    {
                        indent ( 2 );
                        this.buffer.println ( o );
                    }
                    indent ( 1 );
                    this.buffer.print ( "]" );
                    break;
            }
        }
        else
        {
            this.buffer.print ( value );
        }

        this.buffer.println ();
    }

    private void indent ( final int offset )
    {
        for ( int i = 0; i < this.level + offset; i++ )
        {
            this.buffer.print ( "  " );
        }
    }

    public void start ( final Dumpable object )
    {
        indent ( 0 );
        this.buffer.append ( object.getClass ().getName () );
        final ASDU asdu = object.getClass ().getAnnotation ( ASDU.class );
        if ( asdu != null )
        {
            this.buffer.format ( "(%s=%s)", asdu.name (), asdu.id () & 0xFF );
        }
        this.buffer.println ();

        indent ( 0 );
        this.buffer.println ( "----- START ----" );
    }

    public void end ()
    {
        indent ( 0 );
        this.buffer.print ( "-----  END  ----" );
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
