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
package org.eclipse.scada.da.data;

public class BrowserEntry implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public BrowserEntry ( final String name, final org.eclipse.scada.da.data.FolderEntryType entryType, final String itemId, final java.util.Map<String, org.eclipse.scada.core.Variant> attributes, final java.util.Set<org.eclipse.scada.da.data.IODirection> ioDirection )
    {
        this.name = name;
        this.entryType = entryType;
        this.itemId = itemId;
        this.attributes = attributes;
        this.ioDirection = ioDirection;
    }

    private final String name;

    public String getName ()
    {
        return this.name;
    }

    private final org.eclipse.scada.da.data.FolderEntryType entryType;

    public org.eclipse.scada.da.data.FolderEntryType getEntryType ()
    {
        return this.entryType;
    }

    private final String itemId;

    public String getItemId ()
    {
        return this.itemId;
    }

    private final java.util.Map<String, org.eclipse.scada.core.Variant> attributes;

    public java.util.Map<String, org.eclipse.scada.core.Variant> getAttributes ()
    {
        return this.attributes;
    }

    private final java.util.Set<org.eclipse.scada.da.data.IODirection> ioDirection;

    public java.util.Set<org.eclipse.scada.da.data.IODirection> getIoDirection ()
    {
        return this.ioDirection;
    }

    @Override
    public String toString ()
    {
        return "[BrowserEntry - " + "name: " + this.name + ", " + "entryType: " + this.entryType + ", " + "itemId: " + this.itemId + ", " + "attributes: " + this.attributes + ", " + "ioDirection: " + this.ioDirection + "]";
    }
}
