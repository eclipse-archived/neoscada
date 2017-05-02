/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;
import org.eclipse.scada.sec.ui.DisplayCallbackHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenConnection extends AbstractConnectionHandler
{
    private final static Logger logger = LoggerFactory.getLogger ( OpenConnection.class );

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        logger.info ( "Execute command: {}", event ); //$NON-NLS-1$

        for ( final ConnectionHolder holder : getConnections () )
        {
            holder.connect ( DisplayCallbackHandler.createDefault ( getShell () ) );
        }

        return null;
    }

}
