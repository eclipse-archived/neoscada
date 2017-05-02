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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.scada.core.Variant;

public class BooleanSetValueConverter implements ValueConverter
{

    private final Set<String> trueValues;

    private final Set<String> falseValues;

    private final Variant otherwise;

    private final boolean ignoreCase;

    public BooleanSetValueConverter ( final Set<String> trueValues, final Set<String> falseValues, final Boolean otherwise, final boolean ignoreCase )
    {
        if ( ignoreCase )
        {
            this.trueValues = uppercase ( trueValues );
            this.falseValues = uppercase ( falseValues );
        }
        else
        {
            this.trueValues = trueValues;
            this.falseValues = falseValues;
        }

        this.otherwise = Variant.valueOf ( otherwise );
        this.ignoreCase = ignoreCase;
    }

    private static Set<String> uppercase ( final Set<String> values )
    {
        final Set<String> result = new HashSet<> ( values.size () );
        for ( final String value : values )
        {
            result.add ( value.toUpperCase () );
        }
        return result;
    }

    @Override
    public Variant convert ( final String input )
    {
        if ( input == null )
        {
            return this.otherwise;
        }

        final String value = this.ignoreCase ? input.toUpperCase () : input;
        if ( this.trueValues.contains ( value ) )
        {
            return Variant.TRUE;
        }
        if ( this.falseValues.contains ( value ) )
        {
            return Variant.FALSE;
        }
        return this.otherwise;
    }

}
