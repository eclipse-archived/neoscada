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
package org.eclipse.scada.ae.server.ngp;

import java.net.InetSocketAddress;
import java.util.Collection;

import org.apache.mina.core.session.IoSession;
import org.eclipse.scada.ae.server.Service;
import org.eclipse.scada.core.server.ngp.ServerBase;
import org.eclipse.scada.core.server.ngp.ServerConnection;
import org.eclipse.scada.protocol.ngp.common.ProtocolConfigurationFactory;

public class Server extends ServerBase
{

    private final Service service;

    public Server ( final Collection<InetSocketAddress> addresses, final ProtocolConfigurationFactory protocolConfigurationFactory, final Service service ) throws Exception
    {
        super ( addresses, protocolConfigurationFactory );
        this.service = service;
    }

    @Override
    public ServerConnection createNewConnection ( final IoSession session )
    {
        return new ServerConnectionImpl ( session, this.service );
    }

}
