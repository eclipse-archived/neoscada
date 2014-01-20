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
package org.eclipse.scada.protocol.ngp.common.test;

import java.net.SocketAddress;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.DefaultTransportMetadata;
import org.apache.mina.core.session.DummySession;
import org.apache.mina.core.session.IoSessionConfig;
import org.eclipse.scada.protocol.ngp.common.mc.frame.Frame;
import org.eclipse.scada.protocol.ngp.common.mc.frame.Frame.FrameType;
import org.eclipse.scada.protocol.ngp.common.mc.frame.FrameDecoder;
import org.eclipse.scada.protocol.utils.BufferLoader;
import org.junit.Test;

public class FrameDecoderTest
{
    @Test
    public void testSingleEmptyMessage () throws Exception
    {
        testFrames ( "data/emptyMessageSingle.txt", new Frame ( FrameType.MESSAGE, IoBuffer.allocate ( 0 ) ) );
    }

    @Test
    public void testSingleEmptySplit1Message () throws Exception
    {
        testFrames ( "data/emptyMessageSingle.split1.txt", new Frame ( FrameType.MESSAGE, IoBuffer.allocate ( 0 ) ) );
    }

    @Test
    public void testMultiEmptyMessage () throws Exception
    {
        testFrames ( "data/emptyMessageMulti.txt",
                new Frame ( FrameType.MESSAGE, IoBuffer.allocate ( 0 ) ),
                new Frame ( FrameType.MESSAGE, IoBuffer.allocate ( 0 ) ) );
    }

    @Test
    public void testSingleDummySplit1Message () throws Exception
    {
        testFrames ( "data/dummyMessageSingle.split1.txt", new Frame ( FrameType.MESSAGE, makeSimpleData ( 1 ) ) );
    }

    @Test
    public void testSingleDummyMessage () throws Exception
    {
        testFrames ( "data/dummyMessageSingle.txt", new Frame ( FrameType.MESSAGE, makeSimpleData ( 1 ) ) );
    }

    @Test
    public void testMultiDummyMessage () throws Exception
    {
        testFrames ( "data/dummyMessageMulti.txt",
                new Frame ( FrameType.MESSAGE, makeSimpleData ( 1 ) ),
                new Frame ( FrameType.MESSAGE, makeSimpleData ( 2 ) ) );
    }

    @Test
    public void testMultiDummySplit1Message () throws Exception
    {
        testFrames ( "data/dummyMessageMulti.split1.txt",
                new Frame ( FrameType.MESSAGE, makeSimpleData ( 1 ) ),
                new Frame ( FrameType.MESSAGE, makeSimpleData ( 2 ) ) );
    }

    private IoBuffer makeSimpleData ( final int value )
    {
        final IoBuffer d = IoBuffer.allocate ( 4 );
        d.putInt ( value );
        d.flip ();
        return d;
    }

    protected void testFrames ( final String resourceName, final Frame... expectedFrames ) throws Exception
    {
        final FrameDecoder decoder = new FrameDecoder ();
        final MockProtocolDecoderOutput out = new MockProtocolDecoderOutput ();
        final DummySession session = new DummySession ();

        session.setTransportMetadata ( new DefaultTransportMetadata ( "eclipse.scada", "test", false, true, SocketAddress.class, IoSessionConfig.class, Object.class ) );

        for ( final IoBuffer data : BufferLoader.loadBuffersFromResource ( FrameDecoderTest.class, resourceName ) )
        {
            System.out.println ( "Pushing data packet - " + data.getHexDump () );
            decoder.decode ( session, data, out );
        }

        out.assertMessages ( expectedFrames );
    }
}
