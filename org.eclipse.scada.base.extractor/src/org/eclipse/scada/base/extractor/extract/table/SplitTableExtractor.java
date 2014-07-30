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
package org.eclipse.scada.base.extractor.extract.table;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.base.extractor.convert.ValueConverter;
import org.eclipse.scada.base.extractor.extract.AbstractStringExtractor;
import org.eclipse.scada.base.extractor.extract.ItemDescriptor;
import org.eclipse.scada.base.extractor.extract.ItemValue;

public class SplitTableExtractor extends AbstractStringExtractor
{
    private final String fieldSeparatorPattern;

    private final String lineSeparatorPattern;

    private final int idColumn;

    private final String[] header;

    private final ValueConverter converter;

    public SplitTableExtractor ( final String lineSeparatorPattern, final String fieldSeparatorPattern, final int idColumn )
    {
        this.lineSeparatorPattern = lineSeparatorPattern;
        this.fieldSeparatorPattern = fieldSeparatorPattern;
        this.idColumn = idColumn;
        this.header = null;
        this.converter = ValueConverter.NULL;
    }

    public SplitTableExtractor ( final String lineSeparatorPattern, final String fieldSeparatorPattern, final int idColumn, final String[] header, final ValueConverter converter )
    {
        this.lineSeparatorPattern = lineSeparatorPattern;
        this.fieldSeparatorPattern = fieldSeparatorPattern;
        this.idColumn = idColumn;
        this.header = header;
        this.converter = converter != null ? converter : ValueConverter.NULL;
    }

    @Override
    protected Map<ItemDescriptor, ItemValue> processData ( final String data ) throws Exception
    {
        final Map<ItemDescriptor, ItemValue> result = new HashMap<> ();

        final String[] lines = data.split ( this.lineSeparatorPattern );

        final String[] header;

        int start;
        if ( this.header != null )
        {
            start = 0;
            header = this.header;
        }
        else
        {
            start = 1;
            header = splitFields ( lines[0] );
        }

        for ( int i = start; i < lines.length; i++ )
        {
            final String[] fields = splitFields ( lines[i] );
            final String id = fields[this.idColumn];

            for ( int j = 0; j < fields.length; j++ )
            {
                final ItemDescriptor desc = new ItemDescriptor ( id + "." + header[j], null );
                result.put ( desc, new ItemValue ( this.converter.convert ( fields[j] ), null ) );
            }
        }

        return result;
    }

    private String[] splitFields ( final String string )
    {
        return string.split ( this.fieldSeparatorPattern );
    }
}
