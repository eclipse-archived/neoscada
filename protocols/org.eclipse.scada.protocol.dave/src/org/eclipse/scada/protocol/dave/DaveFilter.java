/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - refactoring for a generic memory driver system
 *******************************************************************************/

package org.eclipse.scada.protocol.dave;

import java.util.Collection;
import java.util.LinkedList;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.WriteRequest;
import org.apache.mina.core.write.WriteRequestWrapper;
import org.eclipse.scada.protocol.dave.DaveReadRequest.Request;
import org.eclipse.scada.protocol.dave.DaveReadRequest.Request.AddressType;
import org.eclipse.scada.protocol.dave.DaveReadResult.Result;
import org.eclipse.scada.protocol.iso8073.DataTPDU;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaveFilter extends IoFilterAdapter
{

    private static final byte PACKET_START_MAGIC = 0x32;

    private final static Logger logger = LoggerFactory.getLogger ( DaveFilter.class );

    @Override
    public void sessionOpened ( final NextFilter nextFilter, final IoSession session ) throws Exception
    {
        logger.info ( "Sending hello" );

        final byte[] data = new byte[] { //
        0x00, 0x00, //
        (byte)0xff, (byte)0xff,//
        0x00, 0x08, // plen
        0x00, 0x00, // dlen
        (byte)0xf0, 0x00, //
        0x00, 0x01, // 
        0x00, 0x01, // 
        (byte)0xFF, (byte)0xFF // our PDU 
        };

        final IoBuffer buffer = IoBuffer.allocate ( 0 ).setAutoExpand ( true );

        buffer.put ( PACKET_START_MAGIC );
        buffer.put ( (byte)0x01 ); // type

        buffer.put ( data );
        buffer.flip ();

        session.write ( new DataTPDU ( buffer ) );

        nextFilter.sessionOpened ( session );
    }

    @Override
    public void filterWrite ( final NextFilter nextFilter, final IoSession session, final WriteRequest writeRequest ) throws Exception
    {
        if ( ! ( writeRequest.getMessage () instanceof DaveMessage ) )
        {
            super.filterWrite ( nextFilter, session, writeRequest );
            return;
        }

        final DaveMessage message = (DaveMessage)writeRequest.getMessage ();

        final IoBuffer data = IoBuffer.allocate ( 0 ).setAutoExpand ( true );

        if ( message instanceof DaveReadRequest )
        {
            encodeHeader ( message, data, (byte)1 );

            // == PDU parameters
            final int parameterStart = data.position ();
            encodeReadRequests ( (DaveReadRequest)message, data );
            final int parameterEnd = data.position ();

            finishEncode ( data, (short) ( parameterEnd - parameterStart ), (short)0 );
        }
        else if ( message instanceof DaveWriteRequest )
        {
            encodeHeader ( message, data, (byte)1 );
            final int parameterStart = data.position ();
            encodeWriteRequestsParameters ( (DaveWriteRequest)message, data );
            final int parameterEnd = data.position ();

            final int dataStart = data.position ();
            encodeWriteRequestsData ( (DaveWriteRequest)message, data );
            final int dataEnd = data.position ();

            finishEncode ( data, (short) ( parameterEnd - parameterStart ), (short) ( dataEnd - dataStart ) );
        }

        data.flip ();

        final DataTPDU pdu = new DataTPDU ( data );

        filterWrite ( nextFilter, session, new WriteRequestWrapper ( writeRequest ) {
            @Override
            public Object getMessage ()
            {
                return pdu;
            }
        } );
    }

    /**
     * Encode the data section of the write request
     * 
     * @param message
     * @param data
     */
    private void encodeWriteRequestsData ( final DaveWriteRequest message, final IoBuffer data )
    {
        for ( final DaveWriteRequest.Request request : message.getRequests () )
        {

            if ( request.getType () == AddressType.BIT )
            {
                data.put ( new byte[] { 0x00, 0x03 } );
            }
            else
            {
                data.put ( new byte[] { 0x00, 0x04 } );
            }

            final IoBuffer requestData = request.getData ();

            data.putShort ( (short) ( request.getCount () * startFactor ( request ) ) );

            data.put ( requestData );
        }
    }

    /**
     * Encode the parameters section of the write request
     * 
     * @param message
     * @param data
     */
    private void encodeWriteRequestsParameters ( final DaveWriteRequest message, final IoBuffer data )
    {
        // -- Write Command
        data.put ( DaveCommandCodes.DAVE_WRITE.getCommandCode () );
        data.put ( (byte)message.getRequests ().size () ); // possibly the number of write requests

        for ( final DaveWriteRequest.Request request : message.getRequests () )
        {
            encodeAddress ( data, request );
        }
    }

    private short startFactor ( final org.eclipse.scada.protocol.dave.DaveReadRequest.Request request )
    {
        switch ( request.getType () )
        {
            case BIT:
                return 1;
            case BYTE:
                return 8;
            case WORD:
                return 16;
            default:
                return 8;
        }
    }

    private void encodeReadRequests ( final DaveReadRequest message, final IoBuffer data )
    {
        // -- Read Command
        data.put ( DaveCommandCodes.DAVE_READ.getCommandCode () );
        data.put ( (byte)message.getRequests ().size () ); // possibly the number of read requests

        for ( final Request request : message.getRequests () )
        {
            encodeAddress ( data, request );
        }
    }

    /**
     * Encode the request address in the parameters area
     * 
     * @param data
     * @param request
     */
    private void encodeAddress ( final IoBuffer data, final Request request )
    {
        data.put ( (byte)0x12 );
        data.put ( (byte)0x0a ); // could be the length of the parameter
        data.put ( (byte)0x10 );

        data.put ( request.getType ().getType () );

        data.putShort ( request.getCount () ); // length in bytes
        data.putShort ( request.getBlock () ); // DB number
        data.put ( request.getArea () );
        data.putMediumInt ( request.getStart () * startFactor ( request ) ); // start address in bits
    }

    private void finishEncode ( final IoBuffer data, final short parameterLen, final short dataLen )
    {
        // set parameter len
        data.putShort ( 6, parameterLen );
        // set data len
        data.putShort ( 8, dataLen );
    }

    private void encodeHeader ( final DaveMessage message, final IoBuffer data, final byte type )
    {
        // == PDU header
        data.put ( PACKET_START_MAGIC );
        data.put ( type );
        data.put ( (byte)0 );
        data.put ( (byte)0 );
        data.putShort ( (short)0 ); // req nr

        data.putShort ( (short)0 ); // parameter len
        data.putShort ( (short)0 ); // data len

        if ( type == 2 || type == 3 )
        {
            data.put ( (byte)0 );
            data.put ( (byte)0 );
        }
    }

    @Override
    public void messageReceived ( final NextFilter nextFilter, final IoSession session, final Object message ) throws Exception
    {
        if ( ! ( message instanceof DataTPDU ) )
        {
            return;
        }

        final DataTPDU data = (DataTPDU)message;

        final IoBuffer buffer = data.getData ();

        final DaveMessage daveMessage = decode ( buffer );
        if ( daveMessage != null )
        {
            nextFilter.messageReceived ( session, daveMessage );
        }
    }

    private DaveMessage decode ( final IoBuffer buffer )
    {
        final byte start = buffer.get ();
        if ( start != PACKET_START_MAGIC )
        {
            throw new IllegalStateException ( String.format ( "packet header must be 0x32 but is %02x", start ) );
        }

        final byte type = buffer.get ();
        logger.debug ( "Type: {}" );

        buffer.get (); // unknown
        buffer.get (); // unknown

        buffer.getUnsignedShort (); // request id

        final int plen = buffer.getUnsignedShort ();
        final int dlen = buffer.getUnsignedShort ();

        int errorInfo;
        if ( type == 2 || type == 3 )
        {
            errorInfo = buffer.getUnsignedShort ();
            logger.debug ( "Error info: {}", errorInfo );
        }
        else
        {
            errorInfo = 0;
        }

        final IoBuffer parameters = IoBuffer.allocate ( plen );
        final IoBuffer data = IoBuffer.allocate ( dlen );

        buffer.get ( parameters.array () );
        buffer.get ( data.array () );

        logger.debug ( "plen: {}, dlen: {}, remain: {}", new Object[] { plen, dlen, buffer.remaining () } );
        logger.debug ( "Parameters: {}", parameters );
        logger.debug ( "Data: {}", data );

        if ( parameters.remaining () == 2 && parameters.get ( 0 ) == (byte)4 )
        {
            // Data read reply
            return decodeDataReadReply ( parameters, data );
        }
        else if ( parameters.remaining () == 8 && parameters.get ( 0 ) == (byte)0xF0 )
        {
            // FIXME: better detection
            final int maxPDU = parameters.getUnsignedShort ( 6 );
            return new DaveConnectionEstablishedMessage ( maxPDU );
        }
        else
        {
            return new DaveGenericMessage ( parameters, data );
        }
    }

    private DaveMessage decodeDataReadReply ( final IoBuffer parameters, final IoBuffer data )
    {
        parameters.get (); // command code

        final short count = parameters.getUnsigned ();

        final Collection<Result> result = new LinkedList<Result> ();

        for ( int i = 0; i < count; i++ )
        {
            final short q = data.getUnsigned ();
            if ( q == 0xFF && data.remaining () > 4 )
            {
                final byte type = data.get ();
                int len = data.getUnsignedShort ();
                if ( type == 4 )
                {
                    len >>= 3;
                }

                final IoBuffer valueData = IoBuffer.allocate ( len );
                data.get ( valueData.array () );
                result.add ( new Result ( valueData ) );

                if ( len % 2 != 0 && data.remaining () > 0 )
                {
                    data.get ();
                }
            }
            else if ( q != 0xFF )
            {
                result.add ( new Result ( q ) );
            }
        }

        return new DaveReadResult ( result );
    }
}
