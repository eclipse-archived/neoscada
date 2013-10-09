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


package org.eclipse.scada.protocol.ngp.common.mc.frame;

import org.apache.mina.core.buffer.IoBuffer;

public class Frame
{
    public static enum FrameType
    {
        HELLO,
        MESSAGE,
        ACCEPT,
        CLOSE,
        START,
        PING,
        PONG;
    }

    private final FrameType type;

    private final IoBuffer data;

    public Frame ( final FrameType type )
    {
        this ( type, IoBuffer.allocate ( 0 ) );
    }

    public Frame ( final FrameType type, final IoBuffer data )
    {
        this.type = type;
        this.data = data;
    }

    public IoBuffer getData ()
    {
        return this.data;
    }

    public FrameType getType ()
    {
        return this.type;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[Frame: %s - %s]", this.type, this.data );
    }
}
