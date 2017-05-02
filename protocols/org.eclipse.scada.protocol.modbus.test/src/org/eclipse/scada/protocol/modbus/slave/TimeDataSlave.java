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

public class TimeDataSlave extends AbstractDataSlave
{

    @Override
    protected int[] handleReadAnalog ( final AnalogType type, final int startAddress, final int quantity )
    {
        final int result[] = new int[quantity];

        for ( int i = 0; i < result.length; i++ )
        {
            result[i] = (int) ( System.currentTimeMillis () / 1000 & 0xFFFF );
        }

        return result;
    }

    @Override
    protected void handleDigitalWrite ( final int address, final boolean[] value ) throws ModbusRequestException
    {
        throw new ModbusRequestException ( 1 );
    }

    @Override
    protected void handleAnalogWrite ( final int address, final int[] value )
    {
        throw new ModbusRequestException ( 1 );
    }

    @Override
    protected boolean[] handleReadDigital ( final DigitalType type, final int startAddress, final int quantity ) throws ModbusRequestException
    {
        final long now = System.currentTimeMillis () / 1000;
        final boolean[] result = new boolean[quantity];

        for ( int i = 0; i < quantity; i++ )
        {
            if ( ( now + i ) % quantity == 0 )
            {
                result[i] = true;
            }
        }
        return result;
    }
}
