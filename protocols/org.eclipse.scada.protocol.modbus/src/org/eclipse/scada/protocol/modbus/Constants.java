/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.modbus;

import java.nio.ByteOrder;

public interface Constants
{

    public static final int MAX_PDU_SIZE = 253;

    public static final int RTU_HEADER_SIZE = 3;

    public static final int TCP_HEADER_SIZE = 7;

    public static final byte FUNCTION_CODE_ERROR_FLAG = (byte)0x80;

    public static final byte FUNCTION_CODE_READ_DISCRETE_INPUTS = 0x02;

    public static final byte FUNCTION_CODE_READ_COILS = 0x01;

    public static final byte FUNCTION_CODE_WRITE_SINGLE_COIL = 0x05;

    public static final byte FUNCTION_CODE_READ_INPUT_REGISTERS = 0x04;

    public static final byte FUNCTION_CODE_READ_HOLDING_REGISTERS = 0x03;

    public static final byte FUNCTION_CODE_WRITE_SINGLE_REGISTER = 0x06;

    public static final byte FUNCTION_CODE_WRITE_MULTIPLE_REGISTERS = 0x10;

    public static final byte FUNCTION_CODE_WRITE_MULTIPLE_COILS = 0x0F;

    public static final int EXCEPTION_ILLEGAL_FUNCTION = 1;

    public static final int EXCEPTION_ILLEGAL_DATA_ADDRESS = 2;

    public static final int EXCEPTION_ILLEGAL_DATA_VALUE = 3;

    public static final int EXCEPTION_SLAVE_DEVICE_FAILURE = 4;

    public static final int EXCEPTION_ACKNOWLEDGE = 5;

    public static final int EXCEPTION_SLAVE_DEVICE_BUSY = 6;

    public static final int EXCEPTION_NEGATIVE_EXCEPTION_ACKNOWLEDGE = 7;

    public static final int EXCEPTION_MEMORY_ERROR = 8;

    public static final ByteOrder DEFAULT_BYTE_ORDER = ByteOrder.BIG_ENDIAN;
}
