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
package org.eclipse.scada.da.server.exec.splitter;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SplitSplitter implements Splitter
{

    private final String pattern;

    public SplitSplitter ( final String pattern )
    {
        this.pattern = pattern;
    }

    public SplitResult split ( final String inputBuffer )
    {
        final SplitResult result = new SplitResult ();

        final StringTokenizer tok = new StringTokenizer ( inputBuffer, this.pattern, true );

        final List<String> resultList = new LinkedList<String> ();

        while ( tok.hasMoreTokens () )
        {
            final String token = tok.nextToken ();
            if ( !this.pattern.equals ( token ) )
            {
                if ( tok.hasMoreElements () )
                {
                    resultList.add ( token );
                }
                else
                {
                    result.setRemainingBuffer ( token );
                }
            }
        }

        result.setLines ( resultList.toArray ( new String[resultList.size ()] ) );

        return result;
    }
}
