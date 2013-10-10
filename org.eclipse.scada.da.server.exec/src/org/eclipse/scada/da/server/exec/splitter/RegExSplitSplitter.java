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

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class RegExSplitSplitter implements Splitter
{

    private final Pattern pattern;

    public RegExSplitSplitter ( final Pattern pattern )
    {
        this.pattern = pattern;
    }

    public SplitResult split ( final String inputBuffer )
    {
        final SplitResult result = new SplitResult ();

        final List<String> list = Arrays.asList ( this.pattern.split ( inputBuffer ) );

        if ( list.size () >= 2 )
        {
            final String last = list.remove ( list.size () );
            result.setLines ( list.toArray ( new String[0] ) );
            result.setRemainingBuffer ( last );
        }
        else
        {
            result.setRemainingBuffer ( inputBuffer );
        }

        return result;
    }
}
