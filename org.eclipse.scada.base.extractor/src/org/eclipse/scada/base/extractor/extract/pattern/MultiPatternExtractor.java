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

public class MultiPatternExtractor extends AbstractPatternExtractor
{
    private final Pattern pattern;

    private final Fields fields;

    private static ItemDescriptor DESC_VALUE;

    static
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ( 1 );
        attributes.put ( "description", Variant.valueOf ( "Result value" ) );
        DESC_VALUE = new ItemDescriptor ( "value", attributes );

    }

    public static class Fields
    {
        private final Map<ItemDescriptor, ValueFieldDescriptor> fields;

        public Fields ( final Map<ItemDescriptor, ValueFieldDescriptor> fields )
        {
            this.fields = fields;
        }

        public Map<ItemDescriptor, ValueFieldDescriptor> getFields ()
        {
            return this.fields;
        }

        public void buildResult ( final Map<ItemDescriptor, ItemValue> result, final Matcher m ) throws Exception
        {
            for ( final Map.Entry<ItemDescriptor, ValueFieldDescriptor> entry : this.fields.entrySet () )
            {
                result.put ( entry.getKey (), entry.getValue ().buildValue ( m ) );
            }
        }
    }

    public MultiPatternExtractor ( final Pattern pattern, final Fields fields )
    {
        this.pattern = pattern;
        this.fields = fields;
    }

    @Override
    protected Map<ItemDescriptor, ItemValue> processData ( final String data ) throws Exception
    {
        final Map<ItemDescriptor, ItemValue> result = new HashMap<> ();

        final Matcher m = this.pattern.matcher ( data );

        final boolean match = m.matches ();

        if ( match )
        {
            this.fields.buildResult ( result, m );
        }
        else
        {
            result.put ( DESC_VALUE, new ItemValue ( Variant.NULL, NO_MATCH_ATTRIBUTES ) );
        }

        result.put ( DESC_STATE, makeState ( m, match, true, data ) );

        return result;
    }

}
