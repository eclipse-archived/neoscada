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

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.scada.base.extractor.convert.ValueConverter;
import org.eclipse.scada.base.extractor.extract.ItemDescriptor;
import org.eclipse.scada.base.extractor.extract.ItemValue;
import org.eclipse.scada.core.Variant;

public class VariableFieldPatternExtractor extends AbstractPatternExtractor
{

    private final Pattern fieldPattern;

    private final int fieldNameGroup;

    private final int valueGroup;

    private final ValueConverter converter;

    public VariableFieldPatternExtractor ( final Pattern fieldPattern, final int fieldNameGroup, final int valueGroup, final ValueConverter converter )
    {
        this.fieldPattern = fieldPattern;
        this.fieldNameGroup = fieldNameGroup;
        this.valueGroup = valueGroup;
        this.converter = converter != null ? converter : ValueConverter.NULL;
    }

    @Override
    protected Map<ItemDescriptor, ItemValue> processData ( final String data ) throws Exception
    {
        final Matcher m = this.fieldPattern.matcher ( data );

        final Map<ItemDescriptor, ItemValue> result = new HashMap<ItemDescriptor, ItemValue> ();

        while ( m.find () )
        {
            final String fieldName = m.group ( this.fieldNameGroup );
            final Variant value = this.converter.convert ( m.group ( this.valueGroup ) );

            result.put ( new ItemDescriptor ( fieldName, null ), new ItemValue ( value, null ) );
        }

        return result;
    }

}
