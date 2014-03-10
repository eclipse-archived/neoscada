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

    static
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ( 1 );
        attributes.put ( "description", Variant.valueOf ( "Internal state" ) );
        DESC_STATE = new ItemDescriptor ( "state", attributes );
    }

    protected ItemValue makeState ( final Matcher m, final boolean didMatch )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ( 1 );

        attributes.put ( "matcher.matches", Variant.valueOf ( didMatch ) );
        if ( didMatch )
        {
            attributes.put ( "matcher.groupCount", Variant.valueOf ( m.groupCount () ) );
        }

        return new ItemValue ( Variant.valueOf ( didMatch ? "MATCH" : "NO-MATCH" ), attributes );
    }

}