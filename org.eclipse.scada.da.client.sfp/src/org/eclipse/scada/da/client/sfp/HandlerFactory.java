/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.sfp;

import org.apache.mina.core.service.IoHandler;
import org.eclipse.scada.core.client.common.ClientBaseConnection;
import org.eclipse.scada.core.client.common.ClientConnectionHandler;
import org.eclipse.scada.core.client.common.IoHandlerFactory;

final class HandlerFactory implements IoHandlerFactory
{
    @Override
    public IoHandler create ( final ClientBaseConnection connection ) throws Exception
    {
        return new ClientConnectionHandler ( connection );
    }
}