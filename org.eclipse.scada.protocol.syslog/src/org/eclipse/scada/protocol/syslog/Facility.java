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

/**
 * Facilities <br/>
 * According to RFC5424 - Section 6.2.1 PRI
 */
public enum Facility
{
    KERNEL,
    USER,
    MAIL,
    SYSTEM_DAEMON,
    SECURITY,
    INTERNAL,
    LP,
    NEWS,
    UUCP,
    CLOCK,
    SECURITY2,
    FTP,
    NTP,
    AUDIT,
    ALERT,
    CLOCK2,
    LOCAL0,
    LOCAL1,
    LOCAL2,
    LOCAL3,
    LOCAL4,
    LOCAL5,
    LOCAL6,
    LOCAL7;
}
