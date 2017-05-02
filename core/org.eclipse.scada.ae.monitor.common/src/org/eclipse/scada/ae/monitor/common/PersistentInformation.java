/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.monitor.common;

import java.io.Serializable;

import org.eclipse.scada.core.Variant;

public final class PersistentInformation implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Long lastAckTimestamp;

    private String lastAckUser;

    private Long lastFailTimestamp;

    private Variant lastFailValue;

    public Long getLastAckTimestamp ()
    {
        return this.lastAckTimestamp;
    }

    public void setLastAckTimestamp ( final Long lastAckTimestamp )
    {
        this.lastAckTimestamp = lastAckTimestamp;
    }

    public String getLastAckUser ()
    {
        return this.lastAckUser;
    }

    public void setLastAckUser ( final String lastAckUser )
    {
        this.lastAckUser = lastAckUser;
    }

    public Long getLastFailTimestamp ()
    {
        return this.lastFailTimestamp;
    }

    public void setLastFailTimestamp ( final Long lastFailTimestamp )
    {
        this.lastFailTimestamp = lastFailTimestamp;
    }

    public Variant getLastFailValue ()
    {
        return this.lastFailValue;
    }

    public void setLastFailValue ( final Variant lastFailValue )
    {
        this.lastFailValue = lastFailValue;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[lastAckTimestamp: %s, lastAckUser: %s, lastFailTimestamp: %s, lastFailValue: %s]", this.lastAckTimestamp, this.lastAckUser, this.lastFailTimestamp, this.lastFailValue );
    }

}