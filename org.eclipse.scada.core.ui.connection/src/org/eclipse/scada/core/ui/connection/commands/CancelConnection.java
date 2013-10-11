/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.scada.core.client.Connection;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.scada.core.ui.connection.Activator;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CancelConnection extends AbstractConnectionHandler
{
    private final static Logger logger = LoggerFactory.getLogger ( OpenConnection.class );

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        logger.info ( "Execute command: {}", event ); //$NON-NLS-1$

        for ( final ConnectionHolder holder : getConnections () )
        {
            invokeCancel ( holder.getConnectionService ().getConnection () );
        }

        return null;
    }

    private void invokeCancel ( final Connection connection )
    {
        try
        {
            connection.getClass ().getMethod ( "cancelConnection" ).invoke ( connection );
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.BLOCK );
        }
    }

}
