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
package org.eclipse.scada.ae.monitor.datasource;

import java.security.KeyStore.Builder;

import org.eclipse.scada.ae.data.MonitorStatus;
import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.utils.interner.InternerHelper;

import com.google.common.collect.Interner;

public class MonitorStateInjector
{
    private String prefix;

    private MonitorStatus state;

    private boolean active;

    private boolean akn;

    private boolean unsafe;

    private boolean alarm;

    private Severity severity;

    private final Interner<String> stringInterner;

    private String attributeActive;

    private String attributeState;

    private String attributeUnsafe;

    private String attributeInfo;

    private String attributeWarning;

    private String attributeAlarm;

    private String attributeError;

    private String attributeInfoAckRequired;

    private String attributeWarningAckRequired;

    private String attributeAlarmAckRequired;

    private String attributeErrorAckRequired;

    public MonitorStateInjector ( final Interner<String> stringInterner )
    {
        this.stringInterner = stringInterner == null ? InternerHelper.makeNoOpInterner () : stringInterner;
    }

    public void notifyStateChange ( final MonitorStatusInformation status )
    {
        // evaluate status bits for later use ... but only when updating
        this.state = status.getStatus ();
        this.active = this.state != MonitorStatus.INACTIVE;
        this.akn = this.state == MonitorStatus.NOT_AKN || this.state == MonitorStatus.NOT_OK_NOT_AKN;
        this.unsafe = this.state == MonitorStatus.UNSAFE;
        this.alarm = this.state == MonitorStatus.NOT_OK || this.state == MonitorStatus.NOT_OK_AKN || this.state == MonitorStatus.NOT_OK_NOT_AKN;
        this.severity = status.getSeverity ();
    }

    protected String intern ( final String value )
    {
        return this.stringInterner.intern ( value );
    }

    public void setPrefix ( final String prefix )
    {
        this.prefix = prefix;

        // pre-generate attributes in order to do it only once
        this.attributeActive = intern ( this.prefix + ".active" );

        this.attributeState = intern ( this.prefix + ".state" );
        this.attributeUnsafe = intern ( this.prefix + ".unsafe" );

        this.attributeInfo = intern ( this.prefix + ".info" );
        this.attributeWarning = intern ( this.prefix + ".warning" );
        this.attributeAlarm = intern ( this.prefix + ".alarm" );
        this.attributeError = intern ( this.prefix + ".error" );

        this.attributeInfoAckRequired = intern ( this.prefix + ".info.ackRequired" );
        this.attributeWarningAckRequired = intern ( this.prefix + ".warning.ackRequired" );
        this.attributeAlarmAckRequired = intern ( this.prefix + ".alarm.ackRequired" );
        this.attributeErrorAckRequired = intern ( this.prefix + ".error.ackRequired" );
    }

    /**
     * Inject attributes to the value after the value update has been performed
     * using {@link #performDataUpdate(Builder)}
     * 
     * @param builder
     *            the builder to use for changing information
     */
    public void injectAttributes ( final DataItemValue.Builder builder )
    {
        builder.setAttribute ( this.attributeActive, Variant.valueOf ( this.active ) );

        builder.setAttribute ( this.attributeState, Variant.valueOf ( this.state ) );

        builder.setAttribute ( this.attributeUnsafe, Variant.valueOf ( this.unsafe ) );

        // be sure we don't have a null value
        final Severity severity = this.severity == null ? Severity.ALARM : this.severity;

        switch ( severity )
        {
            case INFORMATION:
                builder.setAttribute ( this.attributeInfo, Variant.valueOf ( this.alarm ) );
                builder.setAttribute ( this.attributeInfoAckRequired, Variant.valueOf ( this.akn ) );
                break;
            case WARNING:
                builder.setAttribute ( this.attributeWarning, Variant.valueOf ( this.alarm ) );
                builder.setAttribute ( this.attributeWarningAckRequired, Variant.valueOf ( this.akn ) );
                break;
            case ALARM:
                builder.setAttribute ( this.attributeAlarm, Variant.valueOf ( this.alarm ) );
                builder.setAttribute ( this.attributeAlarmAckRequired, Variant.valueOf ( this.akn ) );
                break;
            case ERROR:
                builder.setAttribute ( this.attributeError, Variant.valueOf ( this.alarm ) );
                builder.setAttribute ( this.attributeErrorAckRequired, Variant.valueOf ( this.akn ) );
                break;
        }
    }
}