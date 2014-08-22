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
package org.eclipse.scada.protocol.syslog;

public interface Constants
{
    public static final byte SP = 32;

    public static final byte LF = 10;

    public static final String LF_STRING = "\n";

    public static final String SP_STRING = " ";

    public static final String OFFER_PROTOCOL_VERSION = "relp_version";

    public static final String OFFER_COMMANDS = "commands";

    public static final String CMD_SYSLOG = "syslog";

    public static final String CMD_OPEN = "open";

    public static final String CMD_RESPONSE = "rsp";
}
