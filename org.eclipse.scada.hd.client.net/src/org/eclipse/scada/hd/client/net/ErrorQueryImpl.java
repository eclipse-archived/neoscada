/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.client.net;

import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.QueryState;
import org.eclipse.scada.hd.data.QueryParameters;

public class ErrorQueryImpl implements Query
{

    public ErrorQueryImpl ( final QueryListener listener )
    {
        listener.updateState ( QueryState.DISCONNECTED );
    }

    @Override
    public void close ()
    {
        // nothing to do
    }

    @Override
    public void changeParameters ( final QueryParameters parameters )
    {
    }

}
