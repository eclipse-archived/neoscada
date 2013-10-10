/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.browser.common.query;

import java.util.Collection;
import java.util.LinkedList;
import java.util.regex.Pattern;

import org.eclipse.scada.utils.str.StringHelper;

public class SplitNameProvider implements NameProvider
{

    private final Pattern pattern;

    private final NameProvider nameProvider;

    private final int fromStart;

    private final int fromEnd;

    private final String delimiter;

    public SplitNameProvider ( final NameProvider nameProvider, final Pattern pattern, final int fromStart, final int fromEnd, final String delimiter )
    {
        this.nameProvider = nameProvider;
        this.pattern = pattern;
        this.fromStart = fromStart;
        this.fromEnd = fromEnd;
        this.delimiter = delimiter;
    }

    public SplitNameProvider ( final NameProvider nameProvider, final String pattern, final int fromStart, final int fromEnd, final String delimiter )
    {
        this ( nameProvider, Pattern.compile ( pattern ), fromStart, fromEnd, delimiter );
    }

    public String getName ( final ItemDescriptor descriptor )
    {
        final String name = this.nameProvider.getName ( descriptor );

        final Collection<String> result = new LinkedList<String> ();
        final String[] toks = this.pattern.split ( name );
        for ( int i = 0; i < toks.length; i++ )
        {
            if ( i < this.fromStart || i >= toks.length - this.fromEnd )
            {
                result.add ( toks[i] );
            }
        }

        return StringHelper.join ( result, this.delimiter );
    }
}
