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
package org.eclipse.scada.utils.pkg.deb.control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.scada.utils.pkg.deb.InvalidValueException;

/**
 * The definition of a field of a control file
 */
public class ControlFieldDefinition implements Comparable<ControlFieldDefinition>
{
    private final String name;

    private final FieldType type;

    private final Pattern pattern;

    private final String id;

    public ControlFieldDefinition ( final String name, final FieldType type, final Pattern pattern )
    {
        validateName ( name );

        this.name = name;
        this.type = type;
        this.pattern = pattern;

        this.id = name.toUpperCase ();
    }

    public ControlFieldDefinition ( final String name, final FieldType type )
    {
        this ( name, type, null );
    }

    public FieldType getType ()
    {
        return this.type;
    }

    public String getName ()
    {
        return this.name;
    }

    public void validateValue ( final String value )
    {
        if ( value == null )
        {
            throw new InvalidValueException ( String.format ( "Value must not be null" ) );
        }

        if ( this.pattern == null )
        {
            return;
        }

        final Matcher m = this.pattern.matcher ( value );
        if ( !m.matches () )
        {
            throw new InvalidValueException ( String.format ( "Field '%s' must match pattern: %s", this.name, this.pattern.pattern () ) );
        }
    }

    public ControlField createField ( final String value, final String firstLine )
    {
        validateValue ( value );
        return new ControlField ( this, value, firstLine );
    }

    public ControlField createField ( final String value )
    {
        return createField ( value, null );
    }

    protected static void validateNonEmpty ( final String label, final String value ) throws InvalidValueException
    {
        if ( value == null )
        {
            throw new InvalidValueException ( String.format ( "'%s' must not be null" ) );
        }
        if ( value.isEmpty () )
        {
            throw new InvalidValueException ( String.format ( "'%s' must not be empty" ) );
        }
    }

    protected static void validateName ( final String name ) throws InvalidValueException
    {
        validateNonEmpty ( "Name", name );
        for ( int i = 0; i < name.length (); i++ )
        {
            validateFieldChar ( name.charAt ( i ), name );
        }
    }

    private static void validateFieldChar ( final char c, final String value )
    {
        if ( c >= 33 && c <= 57 || c >= 59 && c <= 126 )
        {
            return;
        }

        throw new InvalidValueException ( String.format ( "String must be US-ASCII based letters only: %s", value ) );
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.id == null ? 0 : this.id.hashCode () );
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
        final ControlFieldDefinition other = (ControlFieldDefinition)obj;
        if ( this.id == null )
        {
            if ( other.id != null )
            {
                return false;
            }
        }
        else if ( !this.id.equals ( other.id ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo ( final ControlFieldDefinition other )
    {
        return this.id.compareTo ( other.id );
    }
}
