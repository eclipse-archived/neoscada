/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/


package org.eclipse.scada.protocol.ngp.common.mc.handshake;

import org.apache.mina.core.filterchain.IoFilter.NextFilter;
import org.apache.mina.core.session.IoSession;
import org.eclipse.scada.protocol.ngp.common.ProtocolConfiguration;

public class HandshakeContext
{
    private final ProtocolConfiguration protocolConfiguration;

    private final boolean clientMode;

    private final IoSession session;

    private final NextFilter nextFilter;

    public HandshakeContext ( final ProtocolConfiguration protocolConfiguration, final boolean clientMode, final IoSession session, final NextFilter nextFilter )
    {
        super ();
        this.protocolConfiguration = protocolConfiguration;
        this.clientMode = clientMode;
        this.session = session;
        this.nextFilter = nextFilter;
    }

    public ProtocolConfiguration getProtocolConfiguration ()
    {
        return this.protocolConfiguration;
    }

    public boolean isClientMode ()
    {
        return this.clientMode;
    }

    public IoSession getSession ()
    {
        return this.session;
    }

    public NextFilter getNextFilter ()
    {
        return this.nextFilter;
    }

}
