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
package org.eclipse.scada.protocol.sfp.messages;

public enum DataType
{
    DEAD ( (byte)0x00 ), //
    NULL ( (byte)0x01 ), //
    BOOLEAN ( (byte)0x02 ), //
    INT32 ( (byte)0x03 ), //
    INT64 ( (byte)0x04 ), //
    DOUBLE ( (byte)0x05 ), //
    STRING ( (byte)0x06 ) //
    ;

    private byte dataType;

    private DataType ( final byte dataType )
    {
        this.dataType = dataType;
    }

    public byte getDataType ()
    {
        return this.dataType;
    }

    public static DataType fromByte ( final byte b )
    {
        for ( final DataType dt : values () )
        {
            if ( dt.dataType == b )
            {
                return dt;
            }
        }
        return null;
    }
}
