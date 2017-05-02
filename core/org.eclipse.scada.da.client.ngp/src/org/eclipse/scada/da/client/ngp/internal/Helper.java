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
package org.eclipse.scada.da.client.ngp.internal;

import java.util.List;

import org.eclipse.scada.da.core.browser.Entry;
import org.eclipse.scada.da.data.BrowserEntry;

public final class Helper
{
    private Helper ()
    {
    }

    public static Entry[] convert ( final List<BrowserEntry> browserData )
    {
        if ( browserData == null )
        {
            return new Entry[0];
        }

        final Entry[] result = new Entry[browserData.size ()];
        int i = 0;
        for ( final BrowserEntry entry : browserData )
        {
            result[i] = convertEntry ( entry );
            i++;
        }
        return result;
    }

    public static Entry convertEntry ( final BrowserEntry entry )
    {
        switch ( entry.getEntryType () )
        {
            case ITEM:
                return new DataItemEntryCommon ( entry.getName (), entry.getIoDirection (), entry.getAttributes (), entry.getItemId () );
            default:
                return new FolderEntryCommon ( entry.getName (), entry.getAttributes () );
        }
    }
}
