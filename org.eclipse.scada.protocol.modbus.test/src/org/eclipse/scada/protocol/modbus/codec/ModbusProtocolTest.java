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
package org.eclipse.scada.protocol.modbus.codec;

import java.nio.ByteOrder;

import org.apache.mina.core.buffer.IoBuffer;
import org.junit.Assert;
import org.junit.Test;

public class ModbusProtocolTest
{
    @Test
    public void test1 ()
    {
        Assert.assertEquals ( "makeOrder", ByteOrder.BIG_ENDIAN, ModbusProtocol.makeOrder ( "BIG_ENDIAN", ByteOrder.BIG_ENDIAN ) );
        Assert.assertEquals ( "makeOrder", ByteOrder.LITTLE_ENDIAN, ModbusProtocol.makeOrder ( "LITTLE_ENDIAN", ByteOrder.BIG_ENDIAN ) );
    }

    @Test
    public void byteOrderTest1 ()
    {
        testByteOrder ( new int[] { 0x00, 0xFF }, new int[] { 0x00, 0xFF }, ByteOrder.BIG_ENDIAN );
        testByteOrder ( new int[] { 0x00, 0xFF }, new int[] { 0xFF, 0x00 }, ByteOrder.LITTLE_ENDIAN );
    }

    @Test
    public void byteOrderTest2 ()
    {
        testByteOrder ( new int[] { 0x00, 0xFF, 0x00, 0xFF }, new int[] { 0x00, 0xFF, 0x00, 0xFF }, ByteOrder.BIG_ENDIAN );
        testByteOrder ( new int[] { 0x00, 0xFF, 0x00, 0xFF }, new int[] { 0xFF, 0x00, 0xFF, 0x00 }, ByteOrder.LITTLE_ENDIAN );
    }

    private void testByteOrder ( final int[] src, final int[] exp, final ByteOrder dataOrder )
    {
        final byte[] srcb = new byte[src.length];
        final byte[] expb = new byte[exp.length];

        final IoBuffer dstBuf = ModbusProtocol.convertData ( IoBuffer.wrap ( srcb ), dataOrder );

        Assert.assertArrayEquals ( "Wrong byte order", expb, dstBuf.array () );
    }
}
