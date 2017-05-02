/*******************************************************************************
 * Copyright (c) 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.server.storage.hds;

import org.eclipse.scada.utils.lang.Immutable;

@Immutable
public class StorageConfiguration
{
    private final long timeSlice;

    private final int count;

    public StorageConfiguration ( final long timeSlice, final int count )
    {
        super ();
        this.timeSlice = timeSlice;
        this.count = count;
    }

    public int getCount ()
    {
        return this.count;
    }

    public long getTimeSlice ()
    {
        return this.timeSlice;
    }
}
