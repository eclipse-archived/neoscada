/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.monitor.script;

import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;

public class ScriptMonitorResult
{
    public static final ScriptMonitorResult UNSAFE;

    public static final ScriptMonitorResult INACTIVE;

    static
    {
        UNSAFE = new ScriptMonitorResult ();
        UNSAFE.monitorStatus = State.UNSAFE;

        INACTIVE = new ScriptMonitorResult ();
        INACTIVE.monitorStatus = State.INACTIVE;
    }

    State monitorStatus;

    Variant value;

    Long valueTimestamp;

    Severity severity;

    Boolean requireAck;

    public ScriptMonitorResult ()
    {
    }

    public ScriptMonitorResult ( final Variant value, final Long valueTimestamp )
    {
        this.monitorStatus = State.OK;
        this.value = value;
        this.valueTimestamp = valueTimestamp;
    }

    public ScriptMonitorResult ( final Variant value, final Long valueTimestamp, final Severity severity, final boolean requireAck )
    {
        this.monitorStatus = State.FAILURE;
        this.value = value;
        this.valueTimestamp = valueTimestamp;
        this.severity = severity;
        this.requireAck = requireAck;
    }

    public static class OkBuilder
    {
        public static final OkBuilder INSTANCE = new OkBuilder ();

        public ScriptMonitorResult build ( final DataItemValue value )
        {
            final Variant timestamp = value.getAttributes ().get ( "timestamp" );
            return new ScriptMonitorResult ( value.getValue (), timestamp == null ? null : timestamp.asLong ( null ) );
        }

        public ScriptMonitorResult build ( final Variant value, final Long valueTimestamp )
        {
            return new ScriptMonitorResult ( value, valueTimestamp );
        }
    }

    public static class FailureBuilder
    {
        public static final FailureBuilder INSTANCE = new FailureBuilder ();

        public ScriptMonitorResult build ( final DataItemValue value, final Severity severity, final boolean requireAck )
        {
            final Variant timestamp = value.getAttributes ().get ( "timestamp" );
            return new ScriptMonitorResult ( value.getValue (), timestamp == null ? null : timestamp.asLong ( null ), severity, requireAck );
        }

        public ScriptMonitorResult build ( final Variant value, final Long valueTimestamp, final Severity severity, final boolean requireAck )
        {
            return new ScriptMonitorResult ( value, valueTimestamp, severity, requireAck );
        }
    }

    public State getMonitorStatus ()
    {
        return this.monitorStatus;
    }

    public void setMonitorStatus ( final State monitorStatus )
    {
        this.monitorStatus = monitorStatus;
    }

    public Variant getValue ()
    {
        return this.value;
    }

    public void setValue ( final Variant value )
    {
        this.value = value;
    }

    public Long getValueTimestamp ()
    {
        return this.valueTimestamp;
    }

    public void setValueTimestamp ( final Long valueTimestamp )
    {
        this.valueTimestamp = valueTimestamp;
    }

    public Severity getSeverity ()
    {
        return this.severity;
    }

    public void setSeverity ( final Severity severity )
    {
        this.severity = severity;
    }

    public Boolean getRequireAck ()
    {
        return this.requireAck;
    }

    public void setRequireAck ( final Boolean requireAck )
    {
        this.requireAck = requireAck;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[%s: %s - %s - %s - %s]", this.monitorStatus, this.severity, this.value, this.valueTimestamp, this.requireAck );
    }

}