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

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegExMatchSplitter implements Splitter
{
    private final static Logger logger = LoggerFactory.getLogger ( RegExMatchSplitter.class );

    private final Pattern pattern;

    public RegExMatchSplitter ( final Pattern pattern )
    {
        this.pattern = pattern;
    }

    public SplitResult split ( final String inputBuffer )
    {
        final SplitResult result = new SplitResult ();

        final ArrayList<String> list = new ArrayList<String> ();

        boolean hadMatch = false;
        final Matcher m = this.pattern.matcher ( inputBuffer );
        logger.debug ( "Matcher: " + m );

        while ( m.find () )
        {
            hadMatch = true;
            list.add ( m.group () );
        }

        if ( hadMatch )
        {
            result.setLines ( list.toArray ( new String[0] ) );
            result.setRemainingBuffer ( inputBuffer.substring ( m.end () ) );
            return result;
        }
        else
        {
            return null;
        }
    }
}
