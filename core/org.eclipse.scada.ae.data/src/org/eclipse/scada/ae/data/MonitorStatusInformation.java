/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.ae.data;

public class MonitorStatusInformation implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public MonitorStatusInformation ( final String id, final org.eclipse.scada.ae.data.MonitorStatus status, final long statusTimestamp, final org.eclipse.scada.ae.data.Severity severity, final org.eclipse.scada.core.Variant value, final Long lastAknTimestamp, final String lastAknUser, final Long lastFailTimestamp, final org.eclipse.scada.core.Variant lastFailValue, final java.util.Map<String, org.eclipse.scada.core.Variant> attributes )
    {
        this.id = id;
        this.status = status;
        this.statusTimestamp = statusTimestamp;
        this.severity = severity;
        this.value = value;
        this.lastAknTimestamp = lastAknTimestamp;
        this.lastAknUser = lastAknUser;
        this.lastFailTimestamp = lastFailTimestamp;
        this.lastFailValue = lastFailValue;
        this.attributes = attributes;
    }

    private final String id;

    public String getId ()
    {
        return this.id;
    }

    private final org.eclipse.scada.ae.data.MonitorStatus status;

    public org.eclipse.scada.ae.data.MonitorStatus getStatus ()
    {
        return this.status;
    }

    private final long statusTimestamp;

    public long getStatusTimestamp ()
    {
        return this.statusTimestamp;
    }

    private final org.eclipse.scada.ae.data.Severity severity;

    public org.eclipse.scada.ae.data.Severity getSeverity ()
    {
        return this.severity;
    }

    private final org.eclipse.scada.core.Variant value;

    public org.eclipse.scada.core.Variant getValue ()
    {
        return this.value;
    }

    private final Long lastAknTimestamp;

    public Long getLastAknTimestamp ()
    {
        return this.lastAknTimestamp;
    }

    private final String lastAknUser;

    public String getLastAknUser ()
    {
        return this.lastAknUser;
    }

    private final Long lastFailTimestamp;

    public Long getLastFailTimestamp ()
    {
        return this.lastFailTimestamp;
    }

    /**
     * Hold the value that triggered the last failure
     */
    private final org.eclipse.scada.core.Variant lastFailValue;

    public org.eclipse.scada.core.Variant getLastFailValue ()
    {
        return this.lastFailValue;
    }

    private final java.util.Map<String, org.eclipse.scada.core.Variant> attributes;

    public java.util.Map<String, org.eclipse.scada.core.Variant> getAttributes ()
    {
        return this.attributes;
    }

    @Override
    public String toString ()
    {
        return "[MonitorStatusInformation - " + "id: " + this.id + ", " + "status: " + this.status + ", " + "statusTimestamp: " + this.statusTimestamp + ", " + "severity: " + this.severity + ", " + "value: " + this.value + ", " + "lastAknTimestamp: " + this.lastAknTimestamp + ", " + "lastAknUser: " + this.lastAknUser + ", " + "lastFailTimestamp: " + this.lastFailTimestamp + ", " + "lastFailValue: " + this.lastFailValue + ", " + "attributes: " + this.attributes + "]";
    }
}
