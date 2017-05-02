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
package org.eclipse.scada.protocol.ngp.common.mc;

import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.WriteRequest;
import org.apache.mina.core.write.WriteRequestWrapper;
import org.eclipse.scada.protocol.ngp.common.mc.message.DataMessage;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.MessageProtocol;

public class DataMessageFilter extends IoFilterAdapter
{

    private final MessageProtocol messageProtocol;

    public DataMessageFilter ( final MessageProtocol messageProtocol )
    {
        if ( messageProtocol == null )
        {
            throw new IllegalArgumentException ( "'messageProtocol' must not be null" );
        }

        this.messageProtocol = messageProtocol;
    }

    @Override
    public void filterWrite ( final NextFilter nextFilter, final IoSession session, final WriteRequest writeRequest ) throws Exception
    {
        final Object message = this.messageProtocol.getEncoder ().encodeMessage ( writeRequest.getMessage () );

        nextFilter.filterWrite ( session, new WriteRequestWrapper ( writeRequest ) {
            @Override
            public Object getMessage ()
            {
                return message;
            }
        } );
    }

    @Override
    public void messageReceived ( final NextFilter nextFilter, final IoSession session, final Object message ) throws Exception
    {
        if ( ! ( message instanceof DataMessage ) )
        {
            throw new IllegalStateException ( String.format ( "Can only handle messages of type %s. This message is: %s", DataMessage.class, message.getClass () ) );
        }

        nextFilter.messageReceived ( session, this.messageProtocol.getDecoder ().decodeMessage ( (DataMessage)message ) );
    }
}
