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

import java.io.IOException;
import java.net.SocketAddress;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.DefaultTransportMetadata;
import org.apache.mina.core.session.DummySession;
import org.apache.mina.core.session.IoSessionConfig;
import org.eclipse.scada.protocol.ngp.common.mc.frame.Frame;
import org.eclipse.scada.protocol.ngp.common.mc.frame.Frame.FrameType;
import org.eclipse.scada.protocol.ngp.common.mc.frame.FrameDecoder;
import org.junit.Test;

import com.google.common.io.LineProcessor;
import com.google.common.io.Resources;

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

        for ( final IoBuffer data : loadBuffer ( resourceName ) )
        {
            System.out.println ( "Pushing data packet - " + data.getHexDump () );
            decoder.decode ( session, data, out );
        }

        out.assertMessages ( expectedFrames );
    }

    private static List<IoBuffer> loadBuffer ( final String string ) throws IOException
    {
        System.out.println ( "Loading buffer - " + string );

        final URL url = Resources.getResource ( FrameDecoderTest.class, string );

        return Resources.readLines ( url, Charset.forName ( "UTF-8" ), new LineProcessor<List<IoBuffer>> () {

            private final List<IoBuffer> result = new LinkedList<> ();

            private IoBuffer buffer = null;

            protected void pushBuffer ()
            {
                if ( this.buffer == null )
                {
                    return;
                }

                this.buffer.flip ();
                this.result.add ( this.buffer );

                this.buffer = null;
            }

            @Override
            public boolean processLine ( String line ) throws IOException
            {
                line = line.replaceAll ( "#.*", "" ); // clear comments

                if ( line.isEmpty () )
                {
                    pushBuffer ();
                    return true;
                }

                final String[] toks = line.split ( "\\s+" );

                if ( toks.length <= 0 )
                {
                    pushBuffer ();
                    return true;
                }

                if ( this.buffer == null )
                {
                    // start a new buffer
                    this.buffer = IoBuffer.allocate ( 0 );
                    this.buffer.setAutoExpand ( true );
                }

                for ( final String tok : toks )
                {
                    this.buffer.put ( Byte.parseByte ( tok, 16 ) );
                }
                return true;
            }

            @Override
            public List<IoBuffer> getResult ()
            {
                pushBuffer (); // last chance to add something
                return this.result;
            }
        } );
    }
}
