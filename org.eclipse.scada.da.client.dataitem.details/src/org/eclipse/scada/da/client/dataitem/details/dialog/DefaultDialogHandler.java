/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.dataitem.details.dialog;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.connection.data.Item.Type;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;

public class DefaultDialogHandler extends AbstractSelectionHandler
{

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        final String connectionId = event.getParameter ( "org.eclipse.scada.da.client.dataitem.details.connectionId" ); //$NON-NLS-1$
        final String connectionUri = event.getParameter ( "org.eclipse.scada.da.client.dataitem.details.connectionUri" ); //$NON-NLS-1$
        final String itemId = event.getParameter ( "org.eclipse.scada.da.client.dataitem.details.itemId" ); //$NON-NLS-1$

        if ( connectionId == null && connectionUri == null || itemId == null )
        {
            return null;
        }

        if ( connectionId != null )
        {
            open ( connectionId, itemId, Type.ID );
        }
        else
        {
            open ( connectionUri, itemId, Type.URI );
        }
        return null;
    }

    private void open ( final String connectionId, final String itemId, final Type type )
    {
        final DataItemDetailsDialog dlg = new DataItemDetailsDialog ( getShell (), new Item ( connectionId, itemId, type ) );
        dlg.open ();
    }

}
