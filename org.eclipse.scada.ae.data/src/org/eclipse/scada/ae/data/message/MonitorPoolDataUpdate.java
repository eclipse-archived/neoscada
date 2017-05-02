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
package org.eclipse.scada.ae.data.message;

public class MonitorPoolDataUpdate implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public MonitorPoolDataUpdate ( final String monitorPoolId, final java.util.List<org.eclipse.scada.ae.data.MonitorStatusInformation> addedOrUpdated, final java.util.Set<String> removed, final boolean full )
    {
        this.monitorPoolId = monitorPoolId;
        this.addedOrUpdated = addedOrUpdated;
        this.removed = removed;
        this.full = full;
    }

    private final String monitorPoolId;

    public String getMonitorPoolId ()
    {
        return this.monitorPoolId;
    }

    private final java.util.List<org.eclipse.scada.ae.data.MonitorStatusInformation> addedOrUpdated;

    public java.util.List<org.eclipse.scada.ae.data.MonitorStatusInformation> getAddedOrUpdated ()
    {
        return this.addedOrUpdated;
    }

    private final java.util.Set<String> removed;

    public java.util.Set<String> getRemoved ()
    {
        return this.removed;
    }

    private final boolean full;

    public boolean isFull ()
    {
        return this.full;
    }

    @Override
    public String toString ()
    {
        return "[MonitorPoolDataUpdate - " + "monitorPoolId: " + this.monitorPoolId + ", " + "addedOrUpdated: " + this.addedOrUpdated + ", " + "removed: " + this.removed + ", " + "full: " + this.full + "]";
    }
}
