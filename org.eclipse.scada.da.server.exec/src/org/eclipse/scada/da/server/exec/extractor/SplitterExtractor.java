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
import java.util.StringTokenizer;

import org.eclipse.scada.da.server.exec.command.ExecutionResult;

public class SplitterExtractor extends AbstractArrayExtractor
{

    private final String pattern;

    public SplitterExtractor ( final String id, final String pattern, final List<FieldMapping> fields )
    {
        super ( id, fields );
        this.pattern = pattern;
    }

    @Override
    protected String[] getFields ( final ExecutionResult result )
    {
        final StringTokenizer tok = new StringTokenizer ( result.getOutput (), this.pattern );
        final String[] fields = new String[tok.countTokens ()];

        int i = 0;
        while ( tok.hasMoreElements () )
        {
            fields[i] = tok.nextToken ();
            i++;
        }

        return fields;
    }

}
