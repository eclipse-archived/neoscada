/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.arduino;

public enum DataType
{
    BOOLEAN ( (byte)0x01 ),
    INT32 ( (byte)0x02 ),
    INT64 ( (byte)0x03 ),
    FLOAT64 ( (byte)0x04 ), ;

    private byte dataType;

    private DataType ( final byte dataType )
    {
        this.dataType = dataType;
    }

    public byte getDataType ()
    {
        return this.dataType;
    }
}
