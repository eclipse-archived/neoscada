/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exec.extractor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.scada.da.server.exec.command.ExecutionResult;

public class RegExExtractor extends AbstractArrayExtractor
{

    private final Pattern pattern;

    private final boolean requireFullMatch;

    public RegExExtractor ( final String id, final Pattern pattern, final boolean requireFullMatch, final List<FieldMapping> groups )
    {
        super ( id, groups );
        this.pattern = pattern;
        this.requireFullMatch = requireFullMatch;
    }

    @Override
    protected String[] getFields ( final ExecutionResult result )
    {
        final Matcher m = this.pattern.matcher ( result.getOutput () );
        if ( this.requireFullMatch )
        {
            if ( !m.matches () )
            {
                throw new RuntimeException ( "Failed to match input" );
            }
            return convertToResult ( m );
        }
        else
        {
            if ( !m.find () )
            {
                throw new RuntimeException ( "Failed to match input" );
            }
            return convertToResult ( m );
        }
    }

    private String[] convertToResult ( final Matcher m )
    {
        final String[] result = new String[m.groupCount () + 1];
        for ( int i = 0; i < result.length; i++ )
        {
            result[i] = m.group ( i );
        }
        return result;
    }

}
