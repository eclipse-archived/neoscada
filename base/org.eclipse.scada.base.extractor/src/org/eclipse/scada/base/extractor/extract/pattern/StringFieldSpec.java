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

public class StringFieldSpec extends FieldSpec
{
    private final String group;

    public StringFieldSpec ( final String group )
    {
        this.group = group;
    }

    public StringFieldSpec ( final String group, final VariantType variantType )
    {
        super ( variantType );
        this.group = group;
    }

    @Override
    public Variant extractValue ( final Matcher matcher ) throws Exception
    {
        return convert ( matcher.group ( this.group ) );
    }
}