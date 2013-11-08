/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.modbus.message;

import org.eclipse.scada.protocol.modbus.Constants;
import org.eclipse.scada.protocol.modbus.io.ModbusProtocolError;

public class ModbusApplicationHeader
{
    public static final int MBAP_HEADER_SIZE = 7;

    public static final int PROTOCOL_IDENTIFIER = 0;

    final int transactionIdentifier;

    final int protocolIdentifier;

    final int length;

    final byte unitIdentifier;

    public ModbusApplicationHeader ( final int transactionIdentifier, final int protocolIdentifier, final int length, final byte unitIdentifier )
    {
        if ( protocolIdentifier != PROTOCOL_IDENTIFIER )
        {
            throw new ModbusProtocolError ( String.format ( "protocolIdentifier must be %s but is %s", PROTOCOL_IDENTIFIER, protocolIdentifier ) );
        }
        if ( length > Constants.MAX_PDU_SIZE + 1 )
        {
            throw new ModbusProtocolError ( String.format ( "length must be less or equal than %s", Constants.MAX_PDU_SIZE + 1 ) );
        }
        this.transactionIdentifier = transactionIdentifier;
        this.protocolIdentifier = protocolIdentifier;
        this.length = length;
        this.unitIdentifier = unitIdentifier;
    }

    public int getTransactionIdentifier ()
    {
        return this.transactionIdentifier;
    }

    public int getProtocolIdentifier ()
    {
        return this.protocolIdentifier;
    }

    public int getLength ()
    {
        return this.length;
    }

    public byte getUnitIdentifier ()
    {
        return this.unitIdentifier;
    }
}