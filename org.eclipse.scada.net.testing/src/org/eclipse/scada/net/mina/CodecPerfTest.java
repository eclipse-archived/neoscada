/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.net.mina;

import java.util.LinkedList;
import java.util.concurrent.Callable;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.filterchain.IoFilter.NextFilter;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.eclipse.scada.net.base.data.BooleanValue;
import org.eclipse.scada.net.base.data.IntegerValue;
import org.eclipse.scada.net.base.data.ListValue;
import org.eclipse.scada.net.base.data.MapValue;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.base.data.StringValue;
import org.eclipse.scada.net.mina.GMPPProtocolDecoder;
import org.eclipse.scada.net.mina.GMPPProtocolEncoder;
import org.junit.Test;

public class CodecPerfTest
{
    public static class TestingEncoderOutput implements ProtocolEncoderOutput
    {
        private final LinkedList<Object> data = new LinkedList<Object> ();

        @Override
        public void write ( final Object data )
        {
            this.data.add ( data );
        }

        @Override
        public void mergeAll ()
        {
        }

        @Override
        public WriteFuture flush ()
        {
            return null;
        }

        public LinkedList<Object> getData ()
        {
            return this.data;
        }
    }

    private static final int NUM_STRINGS = 10;

    private static final int NUM_INTS = 10;

    private static final int NUM_BOOLEAN = 10;

    private static final int NUM_MAPS = 10;

    private static final int NUM_LISTS = 10;

    private static final int LIST_SIZE = 100;

    public Message[] generateData ( final int count, final int complexity )
    {
        final Message[] messages = new Message[count];

        for ( int i = 0; i < count; i++ )
        {
            messages[i] = createMessage ( i, complexity );
        }

        return messages;
    }

    private Message createMessage ( final long sequence, final int complexity )
    {
        final Message message = new Message ();
        message.setCommandCode ( 0 );
        message.setTimestamp ( 0 );
        message.setSequence ( sequence );

        message.setValues ( createPayload ( complexity ) );

        return message;
    }

    private MapValue createPayload ( final int complexity )
    {
        final MapValue value = new MapValue ();

        for ( int i = 0; i < NUM_STRINGS; i++ )
        {
            value.put ( "string-" + i, new StringValue ( "string-" + i ) );
        }
        for ( int i = 0; i < NUM_INTS; i++ )
        {
            value.put ( "int-" + i, IntegerValue.valueOf ( i ) );
        }
        for ( int i = 0; i < NUM_BOOLEAN; i++ )
        {
            value.put ( "boolean-" + i, BooleanValue.valueOf ( i % 2 == 0 ) );
        }
        if ( complexity > 0 )
        {
            for ( int i = 0; i < NUM_MAPS; i++ )
            {
                value.put ( "map-" + i, createPayload ( complexity - 1 ) );
            }
            for ( int i = 0; i < NUM_LISTS; i++ )
            {
                value.put ( "list-" + i, createList ( complexity - 1 ) );
            }
        }

        return value;
    }

    private ListValue createList ( final int complexity )
    {
        final ListValue value = new ListValue ( LIST_SIZE );
        for ( int i = 0; i < LIST_SIZE; i++ )
        {
            value.add ( createPayload ( complexity ) );
        }
        return value;
    }

    @Test
    public void test1 ()
    {
        final Message[] data = makeTestData ();
        System.out.println ( String.format ( "Total: %s MB, Free: %s MB", Runtime.getRuntime ().totalMemory () / ( 1024 * 1024 ), Runtime.getRuntime ().freeMemory () / ( 1024 * 1024 ) ) );
        System.out.println ( data[0] );
    }

    private Message[] makeTestData ()
    {
        try
        {
            return measure ( "Generate data", new Callable<Message[]> () {
                @Override
                public Message[] call () throws Exception
                {
                    return generateData ( 300, 1 );
                }
            } );
        }
        catch ( final Exception e )
        {
            return null;
        }
    }

    @Test
    public void test2 () throws Exception
    {
        repeat ( new Callable<Void> () {

            @Override
            public Void call ()
            {
                test1 ();
                return null;
            }
        }, 10 );
    }

    @Test
    public void test3 () throws Exception
    {
        final Message[] data = makeTestData ();

        final LinkedList<Object> encodedData = measure ( "Encode", new Callable<LinkedList<Object>> () {

            @Override
            public LinkedList<Object> call () throws Exception
            {
                return encode ( data );
            }
        } );

        measure ( "Decode", new Callable<Void> () {
            @Override
            public Void call () throws Exception
            {
                decode ( encodedData );
                return null;
            }
        } );

    }

    private void decode ( final LinkedList<Object> encodedData ) throws Exception
    {
        final GMPPProtocolDecoder decoder = new GMPPProtocolDecoder ();
        final ProtocolDecoderOutput out = new ProtocolDecoderOutput () {

            @Override
            public void write ( final Object data )
            {
                // discard
            }

            @Override
            public void flush ( final NextFilter nextFilter, final IoSession session )
            {
            }
        };
        final IoSession session = new ProtocolCodecSession ();
        for ( final Object object : encodedData )
        {
            if ( object instanceof IoBuffer )
            {
                decoder.decode ( session, (IoBuffer)object, out );
            }
        }

    }

    private LinkedList<Object> encode ( final Message[] data ) throws Exception
    {
        final GMPPProtocolEncoder encoder = new GMPPProtocolEncoder ();
        final TestingEncoderOutput out = new TestingEncoderOutput ();
        for ( int i = 0; i < data.length; i++ )
        {
            encoder.encode ( null, data[i], out );
        }
        return out.getData ();
    }

    protected <T> T measure ( final String taskName, final Callable<T> r ) throws Exception
    {
        final long start = System.currentTimeMillis ();
        final T t = r.call ();
        final long end = System.currentTimeMillis ();
        System.out.println ( taskName + " - Time: " + ( end - start ) + " ms " );
        return t;
    }

    protected void repeat ( final Callable<Void> r, final int count ) throws Exception
    {
        for ( int i = 0; i < count; i++ )
        {
            r.call ();
        }
    }
}
