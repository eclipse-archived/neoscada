/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.ui.connection.internal;

import java.util.Calendar;

import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hd.ui.data.QueryBuffer;

public class QueryBufferBean extends QueryBuffer
{
    private final QueryWrapper parent;

    public QueryBufferBean ( final QueryWrapper queryManager, final String itemId )
    {
        super ( queryManager.getService ().getConnection (), itemId, createRequestParameters () );
        this.parent = queryManager;
    }

    private static QueryParameters createRequestParameters ()
    {
        final Calendar start = Calendar.getInstance ();
        final Calendar end = (Calendar)start.clone ();
        start.add ( Calendar.MINUTE, -500 );
        end.add ( Calendar.MINUTE, 10 );

        return new QueryParameters ( start.getTimeInMillis (), end.getTimeInMillis (), 25 );
    }

    public QueryWrapper getParent ()
    {
        return this.parent;
    }

    public void remove ()
    {
        close ();
        this.parent.removeQuery ( this );
    }
}
