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
package org.eclipse.scada.hd.ui.data;

import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.client.Connection;
import org.eclipse.scada.hd.data.QueryParameters;

public class QueryBuffer extends AbstractQueryBuffer
{
    public QueryBuffer ( final Connection connection, final String itemId, final QueryParameters requestParameters )
    {
        this ( connection, itemId, requestParameters, null );
    }

    public QueryBuffer ( final Connection connection, final String itemId, final QueryParameters requestParameters, final QueryListener listener )
    {
        super ( itemId );

        if ( listener != null )
        {
            this.listeners.add ( listener );
        }

        setRequestParameters ( requestParameters );

        createQuery ( connection, itemId );
    }

}
