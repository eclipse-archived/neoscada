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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

import org.eclipse.scada.base.extractor.extract.ItemValue;
import org.eclipse.scada.core.Variant;

public class ValueFieldDescriptor
{
    private final FieldSpec primaryValue;

    private final Map<String, FieldSpec> attributes;

    public ValueFieldDescriptor ( final FieldSpec primaryValue, final Map<String, FieldSpec> attributes )
    {
        this.primaryValue = primaryValue;
        this.attributes = attributes == null ? Collections.<String, FieldSpec> emptyMap () : attributes;
    }

    public FieldSpec getPrimaryValue ()
    {
        return this.primaryValue;
    }

    public Map<String, FieldSpec> getAttributes ()
    {
        return this.attributes;
    }

    public ItemValue buildValue ( final Matcher m ) throws Exception
    {
        // primary value

        final Variant value = this.primaryValue.extractValue ( m );

        // secondaries

        final Map<String, Variant> attributes = new HashMap<String, Variant> ( this.attributes.size () );
        for ( final Map.Entry<String, FieldSpec> entry : this.attributes.entrySet () )
        {
            attributes.put ( entry.getKey (), entry.getValue ().extractValue ( m ) );
        }

        // result

        return new ItemValue ( value, attributes );
    }
}