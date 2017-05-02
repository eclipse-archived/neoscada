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

import java.beans.PropertyEditorSupport;

public class VariantEditor extends PropertyEditorSupport
{

    public static Variant toVariant ( final String type, final String value )
    {
        if ( type == null || value == null )
        {
            return null;
        }

        if ( type.equalsIgnoreCase ( "INT" ) || type.equalsIgnoreCase ( "INT32" ) || type.equalsIgnoreCase ( "INTEGER" ) )
        {
            return Variant.valueOf ( Integer.parseInt ( value ) );
        }
        else if ( type.equalsIgnoreCase ( "BOOLEAN" ) || type.equalsIgnoreCase ( "BOOL" ) )
        {
            return Variant.valueOf ( Boolean.parseBoolean ( value ) );
        }
        else if ( type.equalsIgnoreCase ( "DOUBLE" ) || type.equalsIgnoreCase ( "FLOAT" ) )
        {
            return Variant.valueOf ( Double.parseDouble ( value ) );
        }
        else if ( type.equalsIgnoreCase ( "LONG" ) || type.equalsIgnoreCase ( "INT64" ) )
        {
            return Variant.valueOf ( Long.parseLong ( value ) );
        }
        else if ( type.equalsIgnoreCase ( "STRING" ) || type.equalsIgnoreCase ( "UNKNOWN" ) )
        {
            return Variant.valueOf ( value );
        }
        else if ( type.equalsIgnoreCase ( "NULL" ) )
        {
            return Variant.NULL;
        }
        else
        {
            throw new IllegalArgumentException ( String.format ( "'%s' is not a valid variant type", type ) );
        }
    }

    public static Variant toVariant ( final String text ) throws IllegalArgumentException
    {
        if ( text == null )
        {
            return null;
        }

        final String[] toks = text.split ( "#", 2 );
        if ( toks.length > 1 )
        {
            return toVariant ( toks[0], toks[1] );
        }
        else
        {
            return Variant.valueOf ( text );
        }
    }

    @Override
    public void setAsText ( final String text ) throws IllegalArgumentException
    {
        setValue ( toVariant ( text ) );
    }
}
