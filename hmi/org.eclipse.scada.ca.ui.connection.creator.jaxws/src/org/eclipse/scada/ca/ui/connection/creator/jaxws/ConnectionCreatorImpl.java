/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.ui.connection.creator.jaxws;

import org.eclipse.scada.ca.connection.provider.ConnectionServiceImpl;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.eclipse.scada.core.ui.connection.creator.ConnectionCreator;

public class ConnectionCreatorImpl implements ConnectionCreator
{
    @Override
    public ConnectionService createConnection ( final ConnectionInformation connectionInformation, final Integer autoReconnectDelay, final boolean lazyActivation )
    {
        return new ConnectionServiceImpl ( new DummyConnection ( connectionInformation ), autoReconnectDelay );
    }
}
