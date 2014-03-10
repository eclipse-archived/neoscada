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
package org.eclipse.scada.base.extractor.extract.pattern;

import java.util.regex.Matcher;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantType;

public abstract class FieldSpec
{
    private final VariantType variantType;

    public FieldSpec ()
    {
        this.variantType = null;
    }

    public FieldSpec ( final VariantType variantType )
    {
        this.variantType = variantType;
    }

    protected Variant convert ( final String value ) throws Exception
    {
        if ( value == null )
        {
            return Variant.NULL;
        }

        final Variant variant = Variant.valueOf ( value );
        if ( variant == null || this.variantType == null )
        {
            // return as-is
            return variant;
        }

        return Variant.valueOf ( variant.as ( this.variantType ) );
    }

    public abstract Variant extractValue ( Matcher matcher ) throws Exception;
}