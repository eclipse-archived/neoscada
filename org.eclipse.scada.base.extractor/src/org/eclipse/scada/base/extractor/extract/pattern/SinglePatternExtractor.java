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

import org.eclipse.scada.base.extractor.extract.ItemDescriptor;
import org.eclipse.scada.base.extractor.extract.ItemValue;
import org.eclipse.scada.core.Variant;

/**
 * Execute one pattern and build one value from it
 */
public class SinglePatternExtractor extends AbstractPatternExtractor
{
    private final Pattern pattern;

    private final ValueFieldDescriptor fieldDescriptor;

    private final boolean fullMatch;

    private static ItemDescriptor DESC_VALUE;

    static
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ( 1 );
        attributes.put ( "description", Variant.valueOf ( "Result value" ) ); //$NON-NLS-1$
        DESC_VALUE = new ItemDescriptor ( "value", attributes ); //$NON-NLS-1$
    }

    public SinglePatternExtractor ( final Pattern pattern, final boolean fullMatch, final ValueFieldDescriptor fieldDescriptor )
    {
        this.pattern = pattern;
        this.fullMatch = fullMatch;
        this.fieldDescriptor = fieldDescriptor;
    }

    public SinglePatternExtractor ( final Pattern pattern, final boolean fullMatch, final FieldSpec primaryValue, final Map<String, FieldSpec> attributes )
    {
        this ( pattern, fullMatch, new ValueFieldDescriptor ( primaryValue, attributes ) );
    }

    @Override
    protected Map<ItemDescriptor, ItemValue> processData ( final String data ) throws Exception
    {
        final Map<ItemDescriptor, ItemValue> result = new HashMap<> ();

        final Matcher m = this.pattern.matcher ( data );

        boolean match;

        if ( this.fullMatch )
        {
            match = m.matches ();
        }
        else
        {
            match = m.find ();
        }

        if ( match )
        {
            result.put ( DESC_VALUE, this.fieldDescriptor.buildValue ( m ) );
        }
        else
        {
            result.put ( DESC_VALUE, new ItemValue ( Variant.NULL, NO_MATCH_ATTRIBUTES ) );
        }

        result.put ( DESC_STATE, makeState ( m, match, this.fullMatch, data ) );

        return result;
    }
}
