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
package org.eclipse.scada.base.extractor.extract;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.base.extractor.convert.ValueConverter;
import org.eclipse.scada.core.Variant;

/**
 * An extractor that simply takes the whole string
 */
public class PlainTextExtractor extends AbstractStringExtractor
{
    private static final ItemDescriptor DESC_VALUE;

    static
    {
        final Map<String, Variant> attributes = new HashMap<> ( 1 );
        attributes.put ( "description", Variant.valueOf ( "Plain text value" ) );
        DESC_VALUE = new ItemDescriptor ( "text", attributes );
    }

    private final boolean trim;

    private final ValueConverter converter;

    public PlainTextExtractor ( final boolean trim, final ValueConverter converter )
    {
        this.trim = trim;
        this.converter = converter != null ? converter : ValueConverter.NULL;
    }

    @Override
    protected Map<ItemDescriptor, ItemValue> processData ( final String data ) throws Exception
    {
        return Collections.singletonMap ( DESC_VALUE, new ItemValue ( Variant.valueOf ( this.converter.convert ( this.trim ? data.trim () : data ) ), null ) );
    }

}
