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

import org.eclipse.scada.base.extractor.extract.AbstractStringExtractor;
import org.eclipse.scada.base.extractor.extract.ItemDescriptor;
import org.eclipse.scada.base.extractor.extract.ItemValue;
import org.eclipse.scada.core.Variant;

public abstract class AbstractPatternExtractor extends AbstractStringExtractor
{

    protected static final ItemDescriptor DESC_STATE;

    protected static final HashMap<String, Variant> NO_MATCH_ATTRIBUTES;

    static
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ( 1 );
        attributes.put ( "description", Variant.valueOf ( "Internal state" ) ); //$NON-NLS-1$
        DESC_STATE = new ItemDescriptor ( "state", attributes );

        NO_MATCH_ATTRIBUTES = new HashMap<String, Variant> ( 1 );
        NO_MATCH_ATTRIBUTES.put ( "nomatch.error", Variant.TRUE ); //$NON-NLS-1$
    }

    protected ItemValue makeState ( final Matcher m, final boolean didMatch, final boolean fullMatch, final String data )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ( 1 );

        attributes.put ( "matcher.matches", Variant.valueOf ( didMatch ) ); //$NON-NLS-1$
        if ( didMatch )
        {
            attributes.put ( "matcher.groupCount", Variant.valueOf ( m.groupCount () ) ); //$NON-NLS-1$
        }

        if ( !didMatch )
        {
            attributes.put ( "matcher.input.data", Variant.valueOf ( limit ( data ) ) ); //$NON-NLS-1$
            attributes.put ( "matcher.fullMatch", Variant.valueOf ( fullMatch ) ); //$NON-NLS-1$
            attributes.put ( "matcher.pattern", Variant.valueOf ( m.pattern ().pattern () ) ); //$NON-NLS-1$
        }

        return new ItemValue ( Variant.valueOf ( didMatch ? "MATCH" : "NO-MATCH" ), attributes ); //$NON-NLS-1$ //$NON-NLS-2$
    }

    protected static String limit ( final String data )
    {
        final int max = Integer.getInteger ( "org.eclipse.scada.base.extractor.extract.pattern.maxErrorData", 1000 ); //$NON-NLS-1$
        if ( data == null || data.length () <= max )
        {
            return data;
        }
        else
        {
            return data.substring ( 0, max ) + "…";
        }
    }

}