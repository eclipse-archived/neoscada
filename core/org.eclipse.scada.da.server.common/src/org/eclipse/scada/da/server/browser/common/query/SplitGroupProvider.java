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

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SplitGroupProvider implements GroupProvider
{

    private final static Logger logger = LoggerFactory.getLogger ( SplitGroupProvider.class );

    private final NameProvider nameProvider;

    private final Pattern regex;

    private final int skipPrefix;

    private final int skipSuffix;

    public SplitGroupProvider ( final NameProvider nameProvider, final String regex )
    {
        this ( nameProvider, Pattern.compile ( regex ), 0, 0 );
    }

    public SplitGroupProvider ( final NameProvider nameProvider, final Pattern pattern, final int skipPrefix, final int skipSuffix )
    {
        this.nameProvider = nameProvider;
        this.regex = pattern;
        this.skipPrefix = skipPrefix;
        this.skipSuffix = skipSuffix;
    }

    public SplitGroupProvider ( final NameProvider nameProvider, final String regex, final int skipPrefix, final int skipSuffix )
    {
        this ( nameProvider, Pattern.compile ( regex ), skipPrefix, skipSuffix );
    }

    public String[] getGrouping ( final ItemDescriptor descriptor )
    {
        if ( this.nameProvider == null )
        {
            return null;
        }

        final String name = this.nameProvider.getName ( descriptor );

        if ( name == null )
        {
            return null;
        }

        try
        {
            final String[] tok = this.regex.split ( name );
            if ( this.skipPrefix + this.skipSuffix >= tok.length )
            {
                // no groups
                return new String[0];
            }
            final String[] result = new String[tok.length - ( this.skipPrefix + this.skipSuffix )];
            for ( int i = this.skipPrefix; i < tok.length - this.skipSuffix; i++ )
            {
                result[i - this.skipPrefix] = tok[i];
            }
            return result;
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to split", e );
            return null;
        }
    }

}
