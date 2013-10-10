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

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.eclipse.scada.net.mina.GMPPProtocolDecoder;
import org.eclipse.scada.net.mina.GMPPProtocolEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BytePacketTestImpl
{

    private final static Logger logger = LoggerFactory.getLogger ( BytePacketTestImpl.class );

    private int preDelay = 0;

    private final byte[] bytes;

    private final int postDelay = 0;

    static byte[] fromString ( final String str )
    {
        final String dataStr = str.trim ();
        final String[] toks = dataStr.split ( "\\s" );

        final byte[] binary = new byte[toks.length];

        for ( int i = 0; i < toks.length; i++ )
        {
            if ( toks[i].length () > 0 )
            {
                binary[i] = (byte)Integer.parseInt ( toks[i], 16 );
            }
        }
        return binary;
    }

    /**
     * 
     */
    public BytePacketTestImpl ( final byte[] bytes, final int preDelay, final int postDelay )
    {
        super ();
        this.preDelay = preDelay;
        this.bytes = bytes.clone ();
        this.preDelay = postDelay;
    }

    public BytePacketTestImpl ( final byte[] bytes, final int preDelay )
    {
        this ( bytes, preDelay, 0 );
    }

    public BytePacketTestImpl ( final String bytes )
    {
        this ( fromString ( bytes ) );
    }

    public BytePacketTestImpl ( final byte[] bytes )
    {
        this ( bytes, 0, 0 );
    }

    public void process ( final GMPPProtocolDecoder decoder, final GMPPProtocolEncoder encoder, final ProtocolDecoderOutput in ) throws Exception
    {
        final IoBuffer buffer = IoBuffer.allocate ( this.bytes.length );
        buffer.put ( this.bytes );
        buffer.flip ();

        try
        {
            Thread.sleep ( this.preDelay );
            decoder.decode ( null, buffer, in );
            Thread.sleep ( this.postDelay );
        }
        catch ( final InterruptedException e )
        {
            e.printStackTrace ();
        }
    }

    public byte[] getBytes ()
    {
        return this.bytes.clone ();
    }

    public boolean equalToBuffer ( final IoBuffer buffer )
    {
        if ( this.bytes.length != buffer.remaining () )
        {
            System.err.println ( String.format ( "Length mismatch: (e: %s, a: %s)", this.bytes.length, buffer.remaining () ) );
            return false;
        }

        for ( int i = 0; i < this.bytes.length; i++ )
        {
            logger.info ( "Expected/Current: " + this.bytes[i] + "/" + buffer.get ( i ) );
            if ( this.bytes[i] != buffer.get ( i ) )
            {
                return false;
            }
        }
        return true;
    }

}
