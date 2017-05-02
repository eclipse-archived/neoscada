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
package org.eclipse.scada.hd.data.message;

public class ListUpdate implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public ListUpdate ( final java.util.Set<org.eclipse.scada.hd.data.HistoricalItemInformation> addedOrModified, final java.util.Set<String> removed, final boolean fullUpdate )
    {
        this.addedOrModified = addedOrModified;
        this.removed = removed;
        this.fullUpdate = fullUpdate;
    }

    private final java.util.Set<org.eclipse.scada.hd.data.HistoricalItemInformation> addedOrModified;

    public java.util.Set<org.eclipse.scada.hd.data.HistoricalItemInformation> getAddedOrModified ()
    {
        return this.addedOrModified;
    }

    private final java.util.Set<String> removed;

    public java.util.Set<String> getRemoved ()
    {
        return this.removed;
    }

    private final boolean fullUpdate;

    public boolean isFullUpdate ()
    {
        return this.fullUpdate;
    }

    @Override
    public String toString ()
    {
        return "[ListUpdate - " + "addedOrModified: " + this.addedOrModified + ", " + "removed: " + this.removed + ", " + "fullUpdate: " + this.fullUpdate + "]";
    }
}
