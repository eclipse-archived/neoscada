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
package org.eclipse.scada.ae.monitor.datasource.common.remote;

import java.io.Serializable;
import java.util.Date;

import org.eclipse.scada.ae.data.MonitorStatus;

public class PersistentState implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String lastAckUser;

    private MonitorStatus state;

    private Date timestamp;

    private Date ackTimestamp;

    public PersistentState ()
    {
        this.state = MonitorStatus.INIT;
    }

    public String getLastAckUser ()
    {
        return this.lastAckUser;
    }

    public void setLastAckUser ( final String lastAckUser )
    {
        this.lastAckUser = lastAckUser;
    }

    public MonitorStatus getState ()
    {
        return this.state;
    }

    public void setState ( final MonitorStatus state )
    {
        this.state = state;
    }

    public Date getAckTimestamp ()
    {
        return this.ackTimestamp;
    }

    public Date getTimestamp ()
    {
        return this.timestamp;
    }

    public void setAckTimestamp ( final Date ackTimestamp )
    {
        this.ackTimestamp = ackTimestamp;
    }

    public void setTimestamp ( final Date timestamp )
    {
        this.timestamp = timestamp;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[PersistentState - State: %s, Timestamp: %s, LastAckUser: %s, LastAckTimestamp: %s", this.state, this.timestamp, this.lastAckUser, this.ackTimestamp );
    }
}
