/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *     IBH SYSTEMS GmbH - some minor fixes
 *******************************************************************************/

package org.eclipse.scada.da.server.osgi.modbus;

import java.nio.ByteOrder;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.da.server.common.memory.AbstractRequestBlock;
import org.eclipse.scada.protocol.modbus.Constants;
import org.eclipse.scada.protocol.modbus.codec.ModbusProtocol;
import org.eclipse.scada.protocol.modbus.io.ChecksumProtocolException;
import org.eclipse.scada.protocol.modbus.message.ErrorResponse;
import org.eclipse.scada.protocol.modbus.message.ReadResponse;
import org.eclipse.scada.protocol.modbus.message.WriteMultiDataRequest;
import org.eclipse.scada.protocol.modbus.message.WriteSingleDataRequest;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class ModbusRequestBlock extends AbstractRequestBlock
{
    private final static Logger logger = LoggerFactory.getLogger ( ModbusRequestBlock.class );

    private final Request request;

    private final ModbusSlave slave;

    private final String id;

    private final AtomicInteger transactionId;

    private final ByteOrder dataOrder;

    public ModbusRequestBlock ( final Executor executor, final String id, final String name, final String mainTypeName, final ModbusSlave slave, final BundleContext context, final Request request, final AtomicInteger transactionId, final boolean enableStatistics )
    {
        super ( context, executor, mainTypeName, "modbus.data." + id, "modbus.block." + id, enableStatistics, request.getPeriod (), request.getCount (), slave.getTimeoutQuietPeriod (), request.isEager () );

        this.id = id;

        this.request = request;
        this.slave = slave;
        this.transactionId = transactionId;
        this.dataOrder = request.getDataOrder ();

        initialize ();
    }

    @Override
    public long getPollRequestTimeout ()
    {
        return this.request.getTimeout ();
    }

    /**
     * The the configured request
     * 
     * @return the request
     */
    public Request getRequest ()
    {
        return this.request;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[Request - %s]", this.request );
    }

    @Override
    public synchronized void handleFailure ( final Throwable e )
    {
        if ( e instanceof ChecksumProtocolException )
        {
            recordChecksumError ();
        }
        super.handleFailure ( e );
    }

    @Override
    public boolean handleMessage ( final Object message )
    {
        MDC.put ( "modbus.block", this.id );
        try
        {
            logger.debug ( "Handle message - message: {}", message );

            if ( message instanceof ErrorResponse )
            {
                logger.debug ( "Handle error" );
                final byte slaveAddress = ( (ErrorResponse)message ).getUnitIdentifier ();
                if ( this.slave.getSlaveAddress () != slaveAddress )
                {
                    logger.info ( "Reply was not for us" );
                    return false;
                }
                handleError ( ( (ErrorResponse)message ).getExceptionCode () );

                return true;
            }
            else if ( message instanceof ReadResponse )
            {
                logger.debug ( "Handle data" );
                final byte slaveAddress = ( (ReadResponse)message ).getUnitIdentifier ();
                if ( this.slave.getSlaveAddress () != slaveAddress )
                {
                    logger.info ( "Reply was not for us (we: {}, they: {})", this.slave.getSlaveAddress (), slaveAddress );
                    return false;
                }
                handleData ( (ReadResponse)message );
                return true;
            }
            else
            {
                logger.info ( "Unknown message" );
                return false;
            }
        }
        finally
        {
            MDC.remove ( "modbus.block" );
        }
    }

    protected void handleData ( final ReadResponse readResponse )
    {
        IoBuffer data = readResponse.getData ();

        if ( this.dataOrder != ByteOrder.BIG_ENDIAN )
        {
            switch ( readResponse.getFunctionCode () )
            {
                case Constants.FUNCTION_CODE_READ_HOLDING_REGISTERS: //$FALL-THROUGH$
                case Constants.FUNCTION_CODE_READ_INPUT_REGISTERS:
                    // only switch bytes if byte order is not BIG_ENDIAN and we do read analog registers
                    data = ModbusProtocol.convertData ( readResponse.getData (), this.dataOrder );
                    break;
            }
        }
        handleData ( data );
    }

    @Override
    public Object createPollRequest ()
    {
        return this.slave.createPollRequest ( this.transactionId.incrementAndGet (), this.request );
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.da.server.common.memory.MemoryRequestBlock#getStartAddress()
     * 
     * in this case it is actually the modbus register
     */
    @Override
    public int getStartAddress ()
    {
        return this.request.getStartAddress ();
    }

    private int toWriteAddress ( final int blockAddress )
    {
        // blockAddress is given in bytes, but we have to align it
        // back to the actual modbus register
        return this.request.getStartAddress () + blockAddress / 2;
    }

    private int toWriteAddressBit ( final int blockAddress, final int subIndex )
    {
        // blockAddress is given in bytes, but we have to align it
        // back to the actual modbus register, in this case it is just 
        // a continuous address space
        return this.request.getStartAddress () + blockAddress * 8 + subIndex;
    }

    @Override
    public void writeBit ( final int blockAddress, final int subIndex, final boolean value )
    {
        if ( this.request.getType () != RequestType.COIL )
        {
            throw new IllegalStateException ( String.format ( "Modbus can only write bits when the block is of type %s", RequestType.COIL ) );
        }
        this.slave.writeCommand ( new WriteSingleDataRequest ( this.transactionId.incrementAndGet (), this.slave.getSlaveAddress (), Constants.FUNCTION_CODE_WRITE_SINGLE_COIL, toWriteAddressBit ( blockAddress, subIndex ), value ), this.request.getTimeout () );
        // FUNCTION_CODE_WRITE_MULTIPLE_COILS is not supported at the moment, since we do not support setting multiple bits at once.
        requestUpdate ();
    }

    @Override
    public void writeData ( final int blockAddress, byte[] data )
    {
        if ( this.request.getType () != RequestType.HOLDING )
        {
            throw new IllegalStateException ( String.format ( "Modbus can only write data when the block is of type %s", RequestType.HOLDING ) );
        }
        if ( data.length == 2 )
        {
            final IoBuffer buffer = IoBuffer.wrap ( data );
            buffer.order ( this.dataOrder );
            final int value = buffer.getUnsignedShort ();
            this.slave.writeCommand ( new WriteSingleDataRequest ( this.transactionId.incrementAndGet (), this.slave.getSlaveAddress (), Constants.FUNCTION_CODE_WRITE_SINGLE_REGISTER, toWriteAddress ( blockAddress ), value ), this.request.getTimeout () );
        }
        else
        {
            data = ModbusProtocol.encodeData ( data, this.dataOrder ); // apply requested byte order
            this.slave.writeCommand ( new WriteMultiDataRequest ( this.transactionId.incrementAndGet (), this.slave.getSlaveAddress (), Constants.FUNCTION_CODE_WRITE_MULTIPLE_REGISTERS, toWriteAddress ( blockAddress ), data ), this.request.getTimeout () );
        }
        requestUpdate ();
    }

}
