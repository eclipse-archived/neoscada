/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.iec60870.asdu;

import io.netty.buffer.ByteBuf;

import java.lang.invoke.MethodHandle;

import org.eclipse.scada.protocol.iec60870.ProtocolOptions;

public class ReflectionMessageCodec<T> implements MessageCodec
{
    private final MethodHandle parseMethod;

    private final MethodHandle encodeMethod;

    public ReflectionMessageCodec ( final Class<T> clazz, final MethodHandle parseMethod, final MethodHandle encodeMethod )
    {
        this.parseMethod = parseMethod;
        this.encodeMethod = encodeMethod;
    }

    @Override
    public T parse ( final ProtocolOptions options, final byte length, final ASDUHeader header, final ByteBuf data )
    {
        try
        {
            return (T)this.parseMethod.invoke ( options, length, header, data );
        }
        catch ( final Throwable e )
        {
            throw new RuntimeException ( "Failed to parse message", e );
        }
    }

    @Override
    public void encode ( final ProtocolOptions options, final Object msg, final ByteBuf out )
    {
        try
        {
            this.encodeMethod.bindTo ( msg ).invoke ( options, out );
        }
        catch ( final Throwable e )
        {
            throw new RuntimeException ( "Failed to encode message", e );
        }
    }

}
