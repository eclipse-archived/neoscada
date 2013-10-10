/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.net.mina;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.net.base.data.DoubleValue;
import org.eclipse.scada.net.base.data.ListValue;
import org.eclipse.scada.net.base.data.LongValue;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.base.data.StringValue;
import org.eclipse.scada.net.mina.GMPPProtocolDecoder;
import org.eclipse.scada.net.mina.GMPPProtocolEncoder;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtocolGMPPTest
{

    private final static Logger log = LoggerFactory.getLogger ( ProtocolGMPPTest.class );

    private void performTest ( final Collection<BytePacketTestImpl> packets, final Collection<Message> messages ) throws Exception
    {
        final InputStreamTestImpl stream = new InputStreamTestImpl ( packets );

        final GMPPProtocolDecoder decoder = new GMPPProtocolDecoder ();
        final GMPPProtocolEncoder encoder = new GMPPProtocolEncoder ();

        final InputAssertions in = new InputAssertions ();

        stream.run ( decoder, encoder, in );

        in.assertMessages ( messages );
    }

    private void performScatterTest ( final Collection<BytePacketTestImpl> packets, final Collection<Message> messages, final int scatterSize ) throws Exception
    {
        log.info ( "Running scatter test with: " + scatterSize );

        final List<BytePacketTestImpl> scatteredPackets = new ArrayList<BytePacketTestImpl> ();

        final byte[] data = new byte[scatterSize];
        int pos = 0;

        for ( final BytePacketTestImpl packet : packets )
        {
            for ( final byte b : packet.getBytes () )
            {
                data[pos] = b;
                pos++;
                if ( data.length == pos )
                {
                    scatteredPackets.add ( new BytePacketTestImpl ( data ) );
                    pos = 0;
                }
            }
        }

        if ( pos > 0 )
        {
            final byte[] addData = new byte[pos];
            for ( int i = 0; i < pos; i++ )
            {
                addData[i] = data[i];
            }

            scatteredPackets.add ( new BytePacketTestImpl ( addData ) );
        }

        performTest ( scatteredPackets, messages );
    }

    private void performScatterTest ( final Collection<BytePacketTestImpl> packets, final Collection<Message> messages, final int... scatterSize ) throws Exception
    {
        for ( final int i : scatterSize )
        {
            performScatterTest ( packets, messages, i );
        }
    }

    private void performAllTests ( final Collection<BytePacketTestImpl> packets, final Collection<Message> messages ) throws Exception
    {
        performTest ( packets, messages );

        performScatterTest ( packets, messages, 2, 3, 5, 10 );
    }

    @Test
    public void testPacket1 () throws Exception
    {
        log.info ( "Running test1" );

        final List<BytePacketTestImpl> packets = new ArrayList<BytePacketTestImpl> ();
        packets.add ( new BytePacketTestImpl ( " 00 00 00 01" + // command code
        " 00 00 00 00 00 00 00 00" + // timestamp
        " 00 00 00 00 00 00 00 02" + // sequence
        " 00 00 00 00 00 00 00 03" + // reply sequence
        " 00 00 00 20" + // body size
        " 00 00 00 07" + // VT_MAP
        " 00 00 00 18" + // VT_MAP - size
        " 00 00 00 01" + // VT_MAP - item count
        " 00 00 00 01" + // VT_STRING
        " 00 00 00 04" + // string length
        " 74 65 73 74" + // empty string
        " 00 00 00 04" + // name length
        " 74 65 73 74" + // empty name
        "" ) );

        Message message;

        final List<Message> messages = new ArrayList<Message> ();

        message = new Message ();
        message.setCommandCode ( 1 );
        message.setSequence ( 2 );
        message.setReplySequence ( 3 );
        message.getValues ().put ( "test", new StringValue ( "test" ) );

        messages.add ( message );

        performAllTests ( packets, messages );
    }

    public void testPacket2 () throws Exception
    {
        log.info ( "Running test2" );
        final List<BytePacketTestImpl> packets = new ArrayList<BytePacketTestImpl> ();
        Message message;
        final List<Message> messages = new ArrayList<Message> ();

        for ( int i = 0; i < 1000; i++ )
        {
            final int commandCode = i % 255;
            final String strCommandCode = Integer.toHexString ( commandCode );
            packets.add ( new BytePacketTestImpl ( " 00 00 00 " + strCommandCode + // command code
            " 00 00 00 00 00 00 00 00" + // timestamp
            " 00 00 00 00 00 00 00 02" + // sequence
            " 00 00 00 00 00 00 00 03" + // reply sequence
            " 00 00 00 00" + // number of values
            " 00 00 00 00" + // body size
            "" ) );

            message = new Message ();
            message.setCommandCode ( commandCode );
            message.setSequence ( 2 );
            message.setReplySequence ( 3 );
            messages.add ( message );

        }

        performAllTests ( packets, messages );
    }

    private void performCode ( final Message message, final BytePacketTestImpl expectedBuffer ) throws Exception
    {
        final GMPPProtocolEncoder encoder = new GMPPProtocolEncoder ();

        final OutputAssertions out = new OutputAssertions ();
        encoder.encode ( null, message, out );

        final IoBuffer byteBuffer = out.getBuffer ();
        byteBuffer.flip ();

        final int max = Math.max ( byteBuffer.remaining (), expectedBuffer.getBytes ().length );
        System.out.println ( "Buffer sizes: " + byteBuffer.remaining () + "/" + expectedBuffer.getBytes ().length );
        for ( int i = 0; i < max; i++ )
        {
            String line = "";

            Byte b1 = null;
            Byte b2 = null;

            if ( i < byteBuffer.remaining () )
            {
                b1 = byteBuffer.get ( i );
                line += String.format ( "%1$02X - ", b1 );
            }
            else
            {
                line += "   - ";
            }
            if ( i < expectedBuffer.getBytes ().length )
            {
                b2 = expectedBuffer.getBytes ()[i];
                line += String.format ( "%1$02X", b2 );
            }
            else
            {
                line += "  ";
            }

            if ( b1 == null || b2 == null )
            {
            }
            else if ( !b1.equals ( b2 ) )
            {
                line += " X";
            }

            System.out.println ( line );
        }

        Assert.assertTrue ( "Compare buffer", expectedBuffer.equalToBuffer ( byteBuffer ) );
    }

    @Test
    public void testEncode1 () throws Exception
    {
        log.info ( "Running encode1" );

        final Message message = new Message ();
        message.setTimestamp ( 0 );
        message.setCommandCode ( 1 );
        message.setSequence ( 2 );
        message.setReplySequence ( 3 );
        message.getValues ().put ( "test", new StringValue ( "test" ) );

        final BytePacketTestImpl packet = new BytePacketTestImpl ( " 00 00 00 01" + // command code
        " 00 00 00 00 00 00 00 00" + // timestamp
        " 00 00 00 00 00 00 00 02" + // sequence
        " 00 00 00 00 00 00 00 03" + // reply sequence
        " 00 00 00 20" + // body size
        " 00 00 00 07" + // VT_MAP
        " 00 00 00 18" + // VT_MAP - size
        " 00 00 00 01" + // VT_MAP - item count
        " 00 00 00 01" + // VT_STRING
        " 00 00 00 04" + // string length
        " 74 65 73 74" + // test string
        " 00 00 00 04" + // name length
        " 74 65 73 74" + // test name
        "" );

        performCode ( message, packet );
    }

    @Test
    public void testEncode2 () throws Exception
    {
        log.info ( "Running encode2" );

        final Message message = new Message ();
        message.setTimestamp ( 0 );
        message.setCommandCode ( 1 + 0xFF );
        message.setSequence ( 2 );
        message.setReplySequence ( 1 + 0xFF );
        message.getValues ().put ( "test", new StringValue ( "test" ) );
        message.getValues ().put ( "tett", new StringValue ( "tett" ) );

        final BytePacketTestImpl packet = new BytePacketTestImpl ( " 00 00 01 00" + // command code
        " 00 00 00 00 00 00 00 00" + // timestamp
        " 00 00 00 00 00 00 00 02" + // sequence
        " 00 00 00 00 00 00 01 00" + // reply sequence
        " 00 00 00 34" + // body size
        " 00 00 00 07" + // VT_MAP
        " 00 00 00 2C" + // VT_MAP - size
        " 00 00 00 02" + // VT_MAP - item count
        " 00 00 00 01" + // VT_STRING
        " 00 00 00 04" + // string length
        " 74 65 74 74" + // empty string
        " 00 00 00 04" + // name length
        " 74 65 74 74" + // test name
        " 00 00 00 01" + // VT_STRING
        " 00 00 00 04" + // string length
        " 74 65 73 74" + // test string
        " 00 00 00 04" + // name length
        " 74 65 73 74" + // test name
        "" );

        performCode ( message, packet );
    }

    @Test
    public void testEncode3 () throws Exception
    {
        log.info ( "Running encode3" );

        final Message message = new Message ();
        message.setTimestamp ( 0 );
        message.setCommandCode ( 1 + 0xFF );
        message.setSequence ( 2 );
        message.setReplySequence ( 1 + 0xFF );
        final ListValue list = new ListValue ();
        list.getValues ().add ( new StringValue ( "tett" ) );
        list.getValues ().add ( new StringValue ( "teut" ) );
        message.getValues ().put ( "test", list );

        final BytePacketTestImpl packet = new BytePacketTestImpl ( " 00 00 01 00" + // command code
        " 00 00 00 00 00 00 00 00" + // timestamp
        " 00 00 00 00 00 00 00 02" + // sequence
        " 00 00 00 00 00 00 01 00" + // reply sequence
        " 00 00 00 38" + // body size
        " 00 00 00 07" + // VT_MAP
        " 00 00 00 30" + // VT_MAP - size
        " 00 00 00 01" + // VT_MAP - item count
        " 00 00 00 06" + // VT_LIST
        " 00 00 00 1C" + // data length
        " 00 00 00 02" + // number of list items
        " 00 00 00 01" + // VT_STRING
        " 00 00 00 04" + // string length
        " 74 65 74 74" + // test string
        " 00 00 00 01" + // VT_STRING
        " 00 00 00 04" + // string length
        " 74 65 75 74" + // test string
        " 00 00 00 04" + // name length - of VT_LIST
        " 74 65 73 74" + // test name
        "" );

        performCode ( message, packet );
    }

    @Test
    public void testPerformance () throws Exception
    {
        final Message message = new Message ();

        message.getValues ().put ( "string-0", new StringValue ( "test" ) );
        message.getValues ().put ( "string-1", new StringValue ( "test" ) );
        message.getValues ().put ( "int-0", LongValue.valueOf ( 0 ) );
        message.getValues ().put ( "int-1", LongValue.valueOf ( 0 ) );
        message.getValues ().put ( "double-0", new DoubleValue ( 1.234 ) );
        message.getValues ().put ( "double-1", new DoubleValue ( 1.234 ) );

        final GMPPProtocolEncoder encoder = new GMPPProtocolEncoder ();

        log.info ( "Start performance run" );

        final long start = System.currentTimeMillis ();
        for ( int i = 0; i < 10 * 1000; i++ )
        {
            final OutputAssertions out = new OutputAssertions ();
            encoder.encode ( null, message, out );
        }
        final long end = System.currentTimeMillis ();

        log.info ( "Processing took: " + ( end - start ) + " ms" );

    }
}
