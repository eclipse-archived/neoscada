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

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.eclipse.scada.protocol.ngp.common.mc.frame.Frame;
import org.eclipse.scada.protocol.ngp.common.mc.frame.Frame.FrameType;

public class MessageChannelKeepAliveFactory implements KeepAliveMessageFactory
{
    @Override
    public boolean isResponse ( final IoSession session, final Object message )
    {
        return message instanceof Frame && ( (Frame)message ).getType () == FrameType.PONG;
    }

    @Override
    public boolean isRequest ( final IoSession session, final Object message )
    {
        return message instanceof Frame && ( (Frame)message ).getType () == FrameType.PING;
    }

    @Override
    public Object getResponse ( final IoSession session, final Object message )
    {
        return new Frame ( FrameType.PONG );
    }

    @Override
    public Object getRequest ( final IoSession session )
    {
        return new Frame ( FrameType.PING );
    }
}