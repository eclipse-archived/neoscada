/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.client.ngp;

import org.apache.mina.core.service.IoHandler;
import org.eclipse.scada.core.client.common.ClientBaseConnection;
import org.eclipse.scada.core.client.common.IoHandlerFactory;
import org.eclipse.scada.protocol.ngp.common.ProtocolConfigurationFactory;

public class ProtocolIoHandlerFactory implements IoHandlerFactory
{

    private final ProtocolConfigurationFactory protocolConfigurationFactory;

    public ProtocolIoHandlerFactory ( final ProtocolConfigurationFactory protocolConfigurationFactory )
    {
        this.protocolConfigurationFactory = protocolConfigurationFactory;
    }

    @Override
    public IoHandler create ( final ClientBaseConnection clientBaseConnection ) throws Exception
    {
        return new ClientProtocolConnectionHandler ( clientBaseConnection, this.protocolConfigurationFactory.createConfiguration ( true ) );
    }

}
