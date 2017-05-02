/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/

package org.eclipse.scada.core.client.ngp;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IoSession;
import org.eclipse.scada.core.client.common.ClientBaseConnection;
import org.eclipse.scada.core.client.common.ClientConnectionHandler;
import org.eclipse.scada.protocol.ngp.common.ProtocolConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientProtocolConnectionHandler extends ClientConnectionHandler implements IoHandler
{
    final static Logger logger = LoggerFactory.getLogger ( ClientProtocolConnectionHandler.class );

    private final ProtocolConfiguration protocolConfiguration;

    public ClientProtocolConnectionHandler ( final ClientBaseConnection connection, final ProtocolConfiguration protocolConfiguration )
    {
        super ( connection );
        this.protocolConfiguration = protocolConfiguration;
    }

    @Override
    public void sessionCreated ( final IoSession session ) throws Exception
    {
        this.protocolConfiguration.assign ( session );
    }

}
