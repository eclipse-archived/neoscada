/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common;

import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.core.WriteAttributeResult;
import org.eclipse.scada.da.core.WriteAttributeResults;

public class WriteAttributesHelper
{
    /**
     * This method sets all unprocessed attribute write requests to an <q>unsupported</q> error ({@link UnsupportedOperationException});
     * 
     * @param initialResults
     *            The results generated so far
     * @param attributes
     *            The attributes to write
     * @return the initial results including the unprocessed results
     */
    public static WriteAttributeResults errorUnhandled ( final WriteAttributeResults initialResults, final Map<String, Variant> attributes )
    {
        final WriteAttributeResults writeAttributeResults;

        if ( initialResults == null )
        {
            writeAttributeResults = new WriteAttributeResults ();
        }
        else
        {
            writeAttributeResults = initialResults;
        }

        for ( final String name : attributes.keySet () )
        {
            if ( !writeAttributeResults.containsKey ( name ) )
            {
                writeAttributeResults.put ( name, new WriteAttributeResult ( new UnsupportedOperationException ( "Operation not supported" ) ) );
            }
        }
        return writeAttributeResults;
    }

    /**
     * This method sets all unprocessed attribute write requests to {@link WriteAttributeResult#OK}
     * 
     * @param initialResults
     *            The results generated so far
     * @param attributes
     *            The attributes to write
     * @return the initial results including the unprocessed results
     */
    public static WriteAttributeResults okUnhandled ( final WriteAttributeResults initialResults, final Map<String, Variant> attributes )
    {
        final WriteAttributeResults writeAttributeResults;

        if ( initialResults == null )
        {
            writeAttributeResults = new WriteAttributeResults ();
        }
        else
        {
            writeAttributeResults = initialResults;
        }

        for ( final String name : attributes.keySet () )
        {
            if ( !writeAttributeResults.containsKey ( name ) )
            {
                writeAttributeResults.put ( name, WriteAttributeResult.OK );
            }
        }
        return writeAttributeResults;
    }
}
