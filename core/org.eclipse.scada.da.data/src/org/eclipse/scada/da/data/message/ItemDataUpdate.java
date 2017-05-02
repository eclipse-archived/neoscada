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

public class ItemDataUpdate implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public ItemDataUpdate ( final String itemId, final org.eclipse.scada.core.Variant value, final java.util.Map<String, org.eclipse.scada.core.Variant> addedOrUpdated, final java.util.Set<String> removed, final boolean cacheValue )
    {
        this.itemId = itemId;
        this.value = value;
        this.addedOrUpdated = addedOrUpdated;
        this.removed = removed;
        this.cacheValue = cacheValue;
    }

    private final String itemId;

    public String getItemId ()
    {
        return this.itemId;
    }

    private final org.eclipse.scada.core.Variant value;

    public org.eclipse.scada.core.Variant getValue ()
    {
        return this.value;
    }

    private final java.util.Map<String, org.eclipse.scada.core.Variant> addedOrUpdated;

    public java.util.Map<String, org.eclipse.scada.core.Variant> getAddedOrUpdated ()
    {
        return this.addedOrUpdated;
    }

    private final java.util.Set<String> removed;

    public java.util.Set<String> getRemoved ()
    {
        return this.removed;
    }

    private final boolean cacheValue;

    public boolean isCacheValue ()
    {
        return this.cacheValue;
    }

    @Override
    public String toString ()
    {
        return "[ItemDataUpdate - " + "itemId: " + this.itemId + ", " + "value: " + this.value + ", " + "addedOrUpdated: " + this.addedOrUpdated + ", " + "removed: " + this.removed + ", " + "cacheValue: " + this.cacheValue + "]";
    }
}
