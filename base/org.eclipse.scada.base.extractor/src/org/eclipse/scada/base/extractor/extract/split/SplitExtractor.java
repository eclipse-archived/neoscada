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
package org.eclipse.scada.base.extractor.extract.split;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.base.extractor.extract.AbstractStringExtractor;
import org.eclipse.scada.base.extractor.extract.Extractor;
import org.eclipse.scada.base.extractor.extract.ItemDescriptor;
import org.eclipse.scada.base.extractor.extract.ItemValue;
import org.eclipse.scada.base.extractor.input.Data;

public class SplitExtractor extends AbstractStringExtractor
{
    private final String splitPattern;

    private final Map<String, Extractor> subExtractors;

    private final Extractor subExtractor;

    public SplitExtractor ( final String splitPattern, final Extractor subExtractor )
    {
        this.splitPattern = splitPattern;
        this.subExtractors = null;
        this.subExtractor = subExtractor;
    }

    public SplitExtractor ( final String splitPattern, final Map<String, Extractor> subExtractors )
    {
        this.splitPattern = splitPattern;
        this.subExtractors = subExtractors;
        this.subExtractor = null;
    }

    @Override
    protected Map<ItemDescriptor, ItemValue> processData ( final String data ) throws Exception
    {
        final String[] toks = data.split ( this.splitPattern );

        final Map<ItemDescriptor, ItemValue> result = new HashMap<ItemDescriptor, ItemValue> ();

        for ( int i = 0; i < toks.length; i++ )
        {
            if ( this.subExtractors != null )
            {
                extractMany ( toks, result, i );
            }
            else if ( this.subExtractor != null )
            {
                extractSingle ( toks, result, i );
            }
        }

        return result;
    }

    private void extractSingle ( final String[] toks, final Map<ItemDescriptor, ItemValue> result, final int i )
    {
        extract ( toks, result, i, null, this.subExtractor );
    }

    private void extractMany ( final String[] toks, final Map<ItemDescriptor, ItemValue> result, final int i )
    {
        for ( final Map.Entry<String, Extractor> entry : this.subExtractors.entrySet () )
        {
            extract ( toks, result, i, entry.getKey (), entry.getValue () );
        }
    }

    private void extract ( final String[] toks, final Map<ItemDescriptor, ItemValue> result, final int i, final String prefix, final Extractor value )
    {
        final Result localResult = value.processData ( new Data ( toks[i], null ) );

        if ( localResult.getError () != null )
        {
            throw new RuntimeException ( localResult.getError () );
        }
        if ( localResult.getItemValues () != null )
        {
            for ( final Map.Entry<ItemDescriptor, ItemValue> valueEntry : localResult.getItemValues ().entrySet () )
            {
                final ItemDescriptor globalDesc = makeGlobal ( "" + i, prefix, valueEntry.getKey () );
                result.put ( globalDesc, valueEntry.getValue () );
            }
        }
    }

    private ItemDescriptor makeGlobal ( final String row, final String prefix, final ItemDescriptor descriptor )
    {
        final String localId;
        if ( prefix == null )
        {
            localId = row + "." + descriptor.getLocalId ();
        }
        else
        {
            localId = row + "." + prefix + "." + descriptor.getLocalId ();
        }

        return new ItemDescriptor ( localId, descriptor.getAttributes () );
    }

}
