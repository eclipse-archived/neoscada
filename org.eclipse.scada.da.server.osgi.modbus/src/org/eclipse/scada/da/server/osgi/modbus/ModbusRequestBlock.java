/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/

package org.eclipse.scada.da.server.osgi.modbus;

import java.util.concurrent.Executor;

import org.eclipse.scada.da.server.common.memory.AbstractRequestBlock;
import org.eclipse.scada.protocol.modbus.message.ErrorResponse;
import org.eclipse.scada.protocol.modbus.message.ReadResponse;
import org.eclipse.scada.protocol.modbus.message.WriteDataRequest;
import org.eclipse.scada.protocol.modbus.message.WriteSingleCoilRequest;
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

    public ModbusRequestBlock ( final Executor executor, final String id, final String name, final String mainTypeName, final ModbusSlave slave, final BundleContext context, final Request request, final boolean enableStatistics )
    {
        super ( context, executor, mainTypeName, "modbus." + id, "modbus." + id, enableStatistics, request.getPeriod (), request.getCount (), slave.getTimeoutQuietPeriod (), request.isEager () );

        this.id = id;

        this.request = request;
        this.slave = slave;
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
                handleData ( ( (ReadResponse)message ).getData () );
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

    @Override
    public Object createPollRequest ()
    {
        return this.slave.createPollRequest ( this.request );
    }

    @Override
    public int getStartAddress ()
    {
        return this.request.getStartAddress ();
    }

    private int toGlobalAddress ( final int blockAddress )
    {
        return this.request.getStartAddress () + blockAddress;
    }

    @Override
    public void writeBit ( final int blockAddress, final int subIndex, final boolean value )
    {
        if ( this.request.getType () != RequestType.COIL )
        {
            throw new IllegalStateException ( String.format ( "Modbus can only write bits when the block is of type %s", RequestType.COIL ) );
        }
        this.slave.writeCommand ( new WriteSingleCoilRequest ( this.slave.getSlaveAddress (), toGlobalAddress ( blockAddress * 8 + subIndex ), value ), this.request.getTimeout () );
        requestUpdate ();
    }

    @Override
    public void writeData ( final int blockAddress, final byte[] data )
    {
        if ( this.request.getType () != RequestType.HOLDING )
        {
            throw new IllegalStateException ( String.format ( "Modbus can only write data when the block is of type %s", RequestType.HOLDING ) );
        }
        this.slave.writeCommand ( new WriteDataRequest ( this.slave.getSlaveAddress (), toGlobalAddress ( blockAddress ), data ), this.request.getTimeout () );
        requestUpdate ();
    }

}
