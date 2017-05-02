/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.handler;

import java.util.Date;

import org.eclipse.scada.ae.data.MonitorStatus;
import org.eclipse.scada.utils.lang.Immutable;

@Immutable
public class AckInformation
{
    private final String monitorId;

    private final Date timestamp;

    private final MonitorStatus monitorStatus;

    public AckInformation ( final String monitorId, final Long timestamp, final MonitorStatus monitorStatus )
    {
        this ( monitorId, timestamp == null ? null : new Date ( timestamp ), monitorStatus );
    }

    public AckInformation ( final String monitorId, final Date timestamp, final MonitorStatus monitorStatus )
    {
        this.monitorId = monitorId;
        this.timestamp = timestamp;

        this.monitorStatus = monitorStatus;
    }

    public MonitorStatus getMonitorStatus ()
    {
        return this.monitorStatus;
    }

    public String getMonitorId ()
    {
        return this.monitorId;
    }

    public Date getTimestamp ()
    {
        return this.timestamp;
    }
}
