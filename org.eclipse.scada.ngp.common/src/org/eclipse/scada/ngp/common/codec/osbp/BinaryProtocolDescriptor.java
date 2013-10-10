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
package org.eclipse.scada.ngp.common.codec.osbp;

import java.util.Collection;

import org.apache.mina.core.session.IoSession;
import org.eclipse.scada.protocol.ngp.common.mc.DataMessageFilter;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.ProtocolDescriptor;

public abstract class BinaryProtocolDescriptor implements ProtocolDescriptor
{
    protected final BinaryContext binaryContext;

    public BinaryProtocolDescriptor ( final BinaryContext binaryContext )
    {
        this.binaryContext = binaryContext;
    }

    protected abstract Collection<BinaryMessageCodec> getCodecs ();

    @Override
    public void activate ( final IoSession session )
    {
        final DataMessageFilter filter = new DataMessageFilter ( new BinaryProtocol ( this.binaryContext, getCodecs () ) );
        session.getFilterChain ().addLast ( "dataMessage", filter );
    }

}
