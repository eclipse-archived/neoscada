/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.ui.connection.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.scada.hd.ui.connection.internal.QueryBufferBean;
import org.eclipse.scada.hd.ui.data.AbstractQueryBuffer;

public class RemoveQueryHandler extends AbstractQueryHandler
{

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        for ( final AbstractQueryBuffer query : getQueries () )
        {
            if ( query instanceof QueryBufferBean )
            {
                ( (QueryBufferBean)query ).remove ();
            }
        }
        return null;
    }

}
