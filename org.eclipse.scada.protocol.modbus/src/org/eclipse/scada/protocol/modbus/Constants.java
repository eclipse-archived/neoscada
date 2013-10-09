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
package org.eclipse.scada.protocol.modbus;

public interface Constants
{

    public static final int MAX_PDU_SIZE = 253;

    public static final int RTU_HEADER_SIZE = 3;

    public static final byte FUNCTION_CODE_ERROR_FLAG = (byte)0x80;

    public static final byte FUNCTION_CODE_READ_DISCRETE_INPUTS = 0x02;

    public static final byte FUNCTION_CODE_READ_COILS = 0x01;

    public static final byte FUNCTION_CODE_WRITE_SINGLE_COIL = 0x05;

    public static final byte FUNCTION_CODE_READ_INPUT_REGISTERS = 0x04;

    public static final byte FUNCTION_CODE_READ_HOLDING_REGISTERS = 0x03;

    public static final byte FUNCTION_CODE_WRITE_SINGLE_REGISTER = 0x06;

    public static final byte FUNCTION_CODE_WRITE_MULTIPLE_REGISTERS = 0x10;

}
