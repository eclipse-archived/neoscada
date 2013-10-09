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

import java.io.NotSerializableException;
import java.io.Serializable;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.protocol.ngp.common.mc.message.DataMessage;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.MessageDecoder;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.MessageEncoder;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.MessageProtocol;

public class ObjectSerializationProtocol implements MessageProtocol, MessageEncoder, MessageDecoder
{

    private final ClassLoader classLoader;

    public ObjectSerializationProtocol ()
    {
        this.classLoader = Thread.currentThread ().getContextClassLoader ();
    }

    public ObjectSerializationProtocol ( final ClassLoader classLoader )
    {
        this.classLoader = classLoader;
    }

    @Override
    public MessageEncoder getEncoder ()
    {
        return this;
    }

    @Override
    public MessageDecoder getDecoder ()
    {
        return this;
    }

    @Override
    public Object decodeMessage ( final DataMessage message ) throws Exception
    {
        return message.getData ().getObject ( this.classLoader );
    }

    @Override
    public DataMessage encodeMessage ( final Object message ) throws Exception
    {
        if ( ! ( message instanceof Serializable ) )
        {
            if ( message != null )
            {
                throw new NotSerializableException ( message.getClass ().getName () );
            }
            else
            {
                throw new NotSerializableException ();
            }
        }

        final IoBuffer data = IoBuffer.allocate ( 64 );
        data.setAutoExpand ( true );
        data.putObject ( message );
        data.flip ();
        return new DataMessage ( data );
    }
}
