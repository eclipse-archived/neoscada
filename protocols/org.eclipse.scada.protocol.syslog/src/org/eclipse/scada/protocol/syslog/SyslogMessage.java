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

import java.util.Calendar;

public class SyslogMessage
{
    private final Facility facility;

    private final Severity severity;

    private final Calendar timestamp;

    private final String hostname;

    private final String processName;

    private final Long processId;

    private final String message;

    public SyslogMessage ( final Facility facility, final Severity severity, final Calendar timestamp, final String hostname, final String processName, final Long processId, final String message )
    {
        this.facility = facility;
        this.severity = severity;
        this.timestamp = timestamp;
        this.hostname = hostname;
        this.processName = processName;
        this.processId = processId;
        this.message = message;
    }

    public Facility getFacility ()
    {
        return this.facility;
    }

    public Severity getSeverity ()
    {
        return this.severity;
    }

    public Calendar getTimestamp ()
    {
        return this.timestamp;
    }

    public String getHostname ()
    {
        return this.hostname;
    }

    public String getProcessName ()
    {
        return this.processName;
    }

    public Long getProcessId ()
    {
        return this.processId;
    }

    public String getMessage ()
    {
        return this.message;
    }

    @Override
    public String toString ()
    {
        final String proc = this.processId != null ? this.processName + "[" + this.processId + "]" : this.processName;
        return String.format ( "%tc %s %s.%s %s: %s", this.timestamp, this.hostname, this.facility, this.severity, proc, this.message );
    }
}
