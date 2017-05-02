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
package org.eclipse.scada.da.data.message;

public class FolderDataUpdate implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public FolderDataUpdate ( final java.util.List<String> location, final java.util.List<org.eclipse.scada.da.data.BrowserEntry> addedOrModified, final java.util.Set<String> removed, final boolean full )
    {
        this.location = location;
        this.addedOrModified = addedOrModified;
        this.removed = removed;
        this.full = full;
    }

    private final java.util.List<String> location;

    public java.util.List<String> getLocation ()
    {
        return this.location;
    }

    private final java.util.List<org.eclipse.scada.da.data.BrowserEntry> addedOrModified;

    public java.util.List<org.eclipse.scada.da.data.BrowserEntry> getAddedOrModified ()
    {
        return this.addedOrModified;
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
        return "[FolderDataUpdate - " + "location: " + this.location + ", " + "addedOrModified: " + this.addedOrModified + ", " + "removed: " + this.removed + ", " + "full: " + this.full + "]";
    }
}
