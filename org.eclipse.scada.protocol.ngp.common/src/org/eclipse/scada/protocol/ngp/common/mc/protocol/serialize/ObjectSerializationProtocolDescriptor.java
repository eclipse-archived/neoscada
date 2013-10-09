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
package org.eclipse.scada.protocol.ngp.common.mc.protocol.serialize;

import org.apache.mina.core.session.IoSession;
import org.eclipse.scada.protocol.ngp.common.mc.DataMessageFilter;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.ProtocolDescriptor;

public class ObjectSerializationProtocolDescriptor implements ProtocolDescriptor
{

    private final ClassLoader classLoader;

    private final String protocolId;

    public ObjectSerializationProtocolDescriptor ( final String protocolId, final ClassLoader classLoader )
    {
        this.protocolId = protocolId == null ? "java" : protocolId;
        this.classLoader = classLoader == null ? Thread.currentThread ().getContextClassLoader () : classLoader;
    }

    @Override
    public String getProtocolId ()
    {
        return this.protocolId;
    }

    @Override
    public void activate ( final IoSession session )
    {
        final DataMessageFilter filter = new DataMessageFilter ( new ObjectSerializationProtocol ( this.classLoader ) );
        session.getFilterChain ().addLast ( "dataMessage", filter );
    }

}
