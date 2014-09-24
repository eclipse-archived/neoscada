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

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.protocol.modbus.message.BaseMessage;
import org.eclipse.scada.protocol.modbus.message.ReadRequest;
import org.eclipse.scada.protocol.modbus.message.WriteMultiDataRequest;
import org.eclipse.scada.protocol.modbus.message.WriteSingleDataRequest;

public abstract class AbstractDataSlave implements Slave
{

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
                    case 1:
                    case 2:
                    {
                        final boolean[] data = handleReadDigital ( fc == 1 ? DigitalType.COIL : DigitalType.DISCRETE, msg.getStartAddress (), msg.getQuantity () );
                        if ( data != null )
                        {
                            ctx.sendReadReply ( baseMessage, data );
                            return;
                        }
                    }
                    break;

                    case 3:
                    case 4:
                    {
                        final int[] data = handleReadAnalog ( fc == 3 ? AnalogType.HOLDING : AnalogType.INPUT, msg.getStartAddress (), msg.getQuantity () );
                        if ( data != null )
                        {
                            ctx.sendReadReply ( baseMessage, data );
                            return;
                        }
                    }
                    break;

                    default:
                        ctx.sendExceptionReply ( baseMessage, 1 );
                        return;
                }

                // no data
                ctx.sendExceptionReply ( baseMessage, 2 );
            }
            else if ( baseMessage instanceof WriteSingleDataRequest )
            {
                final WriteSingleDataRequest msg = (WriteSingleDataRequest)baseMessage;
                handleWrite ( msg.getAddress (), new int[] { msg.getValue () } );
            }
            else if ( baseMessage instanceof WriteMultiDataRequest )
            {
                final WriteMultiDataRequest msg = (WriteMultiDataRequest)baseMessage;

                final int[] regs = new int[msg.getNumRegisters ()];
                final IoBuffer data = IoBuffer.wrap ( msg.getData () );

                for ( int i = 0; i < msg.getNumRegisters (); i++ )
                {
                    regs[i] = data.getUnsignedShort ();
                }

                handleWrite ( msg.getStartAddress (), regs );
            }
            else
            {
                ctx.sendExceptionReply ( baseMessage, 1 );
            }
        }
        catch ( final ModbusRequestException e )
        {
            ctx.sendExceptionReply ( baseMessage, e.getExceptionCode () );
        }
        catch ( final Exception e )
        {
            ctx.sendExceptionReply ( baseMessage, 4 );
        }
    }

    protected abstract boolean[] handleReadDigital ( DigitalType type, final int startAddress, final int quantity ) throws ModbusRequestException;

    protected abstract int[] handleReadAnalog ( AnalogType type, final int startAddress, final int quantity ) throws ModbusRequestException;

    protected abstract void handleWrite ( final int address, final int[] value ) throws ModbusRequestException;

}
