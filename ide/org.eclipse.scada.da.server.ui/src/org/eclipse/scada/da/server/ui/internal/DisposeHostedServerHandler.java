/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.ui.internal;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.scada.da.server.ui.HostedServer;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.utils.SelectionHelper;

public class DisposeHostedServerHandler extends AbstractSelectionHandler
{

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        for ( final HostedServer server : SelectionHelper.iterable ( getSelection (), HostedServer.class ) )
        {
            server.dispose ();
        }
        return null;
    }

}
