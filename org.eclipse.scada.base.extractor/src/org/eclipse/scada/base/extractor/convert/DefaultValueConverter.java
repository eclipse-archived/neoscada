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
package org.eclipse.scada.base.extractor.convert;

import org.eclipse.scada.core.Variant;

public class DefaultValueConverter implements ValueConverter
{
    public static final ValueConverter INSTANCE = new DefaultValueConverter ();

    @Override
    public Variant convert ( final String string )
    {
        if ( "true".equalsIgnoreCase ( string ) )
        {
            return Variant.TRUE;
        }
        else if ( "false".equalsIgnoreCase ( string ) )
        {
            return Variant.FALSE;
        }

        try
        {
            return Variant.valueOf ( Long.parseLong ( string ) );
        }
        catch ( final NumberFormatException e )
        {
        }

        try
        {
            return Variant.valueOf ( Double.parseDouble ( string ) );
        }
        catch ( final NumberFormatException e )
        {
        }
        return Variant.valueOf ( string );
    }

}
