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
package org.eclipse.scada.protocol.modbus.slave;

import java.nio.ByteOrder;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.protocol.modbus.Constants;
import org.eclipse.scada.protocol.modbus.message.BaseMessage;
import org.eclipse.scada.protocol.modbus.message.ReadRequest;
import org.eclipse.scada.protocol.modbus.message.WriteMultiDataRequest;
import org.eclipse.scada.protocol.modbus.message.WriteSingleDataRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractDataSlave implements Slave
{
    private static final Logger logger = LoggerFactory.getLogger ( AbstractDataSlave.class );

    private final ByteOrder order;

    public AbstractDataSlave ()
    {
        this ( Constants.DEFAULT_BYTE_ORDER );
    }

    public AbstractDataSlave ( final ByteOrder order )
    {
        this.order = order;
    }

    @Override
    public void dispose ()
    {
    }

    @Override
    public void handleMessage ( final SessionContext ctx, final BaseMessage baseMessage )
    {
        try
        {
            if ( baseMessage instanceof ReadRequest )
            {
                final ReadRequest msg = (ReadRequest)baseMessage;

                final byte fc = msg.getFunctionCode ();

                switch ( fc )
                {
                    case Constants.FUNCTION_CODE_READ_COILS:
                    case Constants.FUNCTION_CODE_READ_DISCRETE_INPUTS:
                    {
                        final boolean[] data = handleReadDigital ( fc == Constants.FUNCTION_CODE_READ_COILS ? DigitalType.COIL : DigitalType.DISCRETE, msg.getStartAddress (), msg.getQuantity () );
                        if ( data != null )
                        {
                            ctx.sendReadReply ( baseMessage, data );
                            return;
                        }
                    }
                        break;

                    case Constants.FUNCTION_CODE_READ_HOLDING_REGISTERS:
                    case Constants.FUNCTION_CODE_READ_INPUT_REGISTERS:
                    {
                        final int[] data = handleReadAnalog ( fc == Constants.FUNCTION_CODE_READ_HOLDING_REGISTERS ? AnalogType.HOLDING : AnalogType.INPUT, msg.getStartAddress (), msg.getQuantity () );
                        if ( data != null )
                        {
                            ctx.sendReadReply ( baseMessage, data, this.order );
                            return;
                        }
                    }
                        break;

                    default:
                        ctx.sendExceptionReply ( baseMessage, Constants.EXCEPTION_ILLEGAL_FUNCTION );
                        return;
                }

                // no data
                ctx.sendExceptionReply ( baseMessage, Constants.EXCEPTION_ILLEGAL_DATA_ADDRESS );
            }
            else if ( baseMessage instanceof WriteSingleDataRequest )
            {
                final WriteSingleDataRequest msg = (WriteSingleDataRequest)baseMessage;
                final byte fc = msg.getFunctionCode ();
                switch ( fc )
                {
                    case Constants.FUNCTION_CODE_WRITE_SINGLE_COIL:
                        handleDigitalWrite ( msg.getAddress (), new boolean[] { msg.isTrue () } );
                        ctx.sendWriteReply ( msg );
                        return;
                    case Constants.FUNCTION_CODE_WRITE_SINGLE_REGISTER:
                        processAnalogWrite ( msg.getAddress (), 1, msg.getData () );
                        ctx.sendWriteReply ( msg );
                        return;
                    default:
                        ctx.sendExceptionReply ( baseMessage, Constants.EXCEPTION_ILLEGAL_FUNCTION );
                        return;
                }
            }
            else if ( baseMessage instanceof WriteMultiDataRequest )
            {
                final WriteMultiDataRequest msg = (WriteMultiDataRequest)baseMessage;

                final byte fc = msg.getFunctionCode ();
                switch ( fc )
                {
                    case Constants.FUNCTION_CODE_WRITE_MULTIPLE_COILS:
                        processDigitalWrite ( msg );
                        ctx.sendWriteReply ( msg );
                        break;
                    case Constants.FUNCTION_CODE_WRITE_MULTIPLE_REGISTERS:
                        processAnalogWrite ( msg.getStartAddress (), msg.getNumRegisters (), msg.getData () );
                        ctx.sendWriteReply ( msg );
                        return;
                    default:
                        ctx.sendExceptionReply ( baseMessage, Constants.EXCEPTION_ILLEGAL_FUNCTION );
                        return;
                }

            }
            else
            {
                ctx.sendExceptionReply ( baseMessage, Constants.EXCEPTION_ILLEGAL_FUNCTION );
            }
        }
        catch ( final ModbusRequestException e )
        {
            logger.debug ( "Modbus request exception", e );
            ctx.sendExceptionReply ( baseMessage, e.getExceptionCode () );
        }
        catch ( final Exception e )
        {
            logger.debug ( "Failed to handle message", e );
            ctx.sendExceptionReply ( baseMessage, Constants.EXCEPTION_SLAVE_DEVICE_FAILURE );
        }
    }

    private void processAnalogWrite ( final int startAddress, final int numRegisters, final byte[] rawData )
    {
        final int[] regs = new int[numRegisters];
        final IoBuffer data = IoBuffer.wrap ( rawData );

        data.order ( this.order );

        for ( int i = 0; i < numRegisters; i++ )
        {
            regs[i] = data.getUnsignedShort ();
        }

        handleAnalogWrite ( startAddress, regs );
    }

    private void processDigitalWrite ( final WriteMultiDataRequest msg )
    {
        final boolean[] regs = new boolean[msg.getNumRegisters ()];

        final byte[] data = msg.getData ();

        for ( int i = 0; i < msg.getNumRegisters (); i++ )
        {
            regs[i] = ( data[i >> 8] & 1 << i % 8 ) > 0;
        }

        handleDigitalWrite ( msg.getStartAddress (), regs );
    }

    protected abstract boolean[] handleReadDigital ( DigitalType type, final int startAddress, final int quantity ) throws ModbusRequestException;

    protected abstract int[] handleReadAnalog ( AnalogType type, final int startAddress, final int quantity ) throws ModbusRequestException;

    protected abstract void handleAnalogWrite ( final int address, final int[] values ) throws ModbusRequestException;

    protected abstract void handleDigitalWrite ( final int address, final boolean[] values ) throws ModbusRequestException;

}
