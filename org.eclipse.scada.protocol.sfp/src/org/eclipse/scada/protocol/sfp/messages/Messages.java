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

public interface Messages
{
    byte MC_HELLO = 0x01;

    byte MC_WELCOME = 0x02;

    byte MC_READ_ALL = 0x03;

    byte MC_DATA_UPDATE = 0x04;

    byte MC_START_BROWSE = 0x05;

    byte MC_STOP_BROWSE = 0x06;

    byte MC_NS_ADDED = 0x07;

    byte MC_WRITE_COMMAND = 0x08;

    byte MC_WRITE_RESULT = 0x09;
}
