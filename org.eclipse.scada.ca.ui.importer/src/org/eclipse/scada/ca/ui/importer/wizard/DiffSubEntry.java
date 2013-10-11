/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.ui.importer.wizard;

import org.eclipse.scada.ca.data.DiffEntry;

public final class DiffSubEntry implements Comparable<DiffSubEntry>
{
    private final String key;

    private String oldValue;

    private String newValue;

    private final DiffEntry parentEntry;

    public DiffSubEntry ( final DiffEntry entry, final String key )
    {
        super ();
        this.parentEntry = entry;
        this.key = key;
    }

    public DiffEntry getParentEntry ()
    {
        return this.parentEntry;
    }

    public String getKey ()
    {
        return this.key;
    }

    public String getOldValue ()
    {
        return this.oldValue;
    }

    public void setOldValue ( final String oldValue )
    {
        this.oldValue = oldValue;
    }

    public String getNewValue ()
    {
        return this.newValue;
    }

    public void setNewValue ( final String newValue )
    {
        this.newValue = newValue;
    }

    @Override
    public int compareTo ( final DiffSubEntry o )
    {
        return this.key.compareTo ( o.key );
    }

}