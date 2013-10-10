/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.client.ngp.test;

import org.eclipse.scada.core.client.Connection;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.ConnectionStateListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DumpingStateListener implements ConnectionStateListener
{

    private final static Logger logger = LoggerFactory.getLogger ( DumpingStateListener.class );

    @Override
    public void stateChange ( final Connection connection, final ConnectionState state, final Throwable error )
    {
        logger.info ( "Connection state changed - {} -> {}: {}", new Object[] { connection, state, error } );
    }

}
