/*******************************************************************************
 * Copyright (c) 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ui.databinding.item;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.scada.core.Variant;

public class VariantToLongConverter extends Converter
{
    private final Long defaultValue;

    public VariantToLongConverter ()
    {
        this ( null );
    }

    public VariantToLongConverter ( final Long defaultValue )
    {
    	super ( Variant.class, Long.class );
        this.defaultValue = defaultValue;
    }

    @Override
    public Object convert ( final Object fromObject )
    {
        return ( (Variant)fromObject ).asLong ( this.defaultValue );
    }
}