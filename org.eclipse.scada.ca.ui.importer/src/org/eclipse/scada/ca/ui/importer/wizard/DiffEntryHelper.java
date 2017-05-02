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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.scada.ca.data.DiffEntry;

public final class DiffEntryHelper
{
    private DiffEntryHelper ()
    {
    }

    public static Object[] diffChilds ( final DiffEntry entry )
    {
        final Map<String, DiffSubEntry> childs = makeChilds ( entry );

        final List<DiffSubEntry> result = new ArrayList<DiffSubEntry> ( childs.values () );

        Collections.sort ( result );

        return result.toArray ();
    }

    public static Object diffChildsByIndex ( final DiffEntry entry, final int index )
    {
        final Map<String, DiffSubEntry> childs = makeChilds ( entry );

        final List<DiffSubEntry> result = new ArrayList<DiffSubEntry> ( childs.values () );

        Collections.sort ( result );

        return result.get ( index );
    }

    private static Map<String, DiffSubEntry> makeChilds ( final DiffEntry entry )
    {
        final Map<String, DiffSubEntry> childs = new LinkedHashMap<String, DiffSubEntry> ();

        // new entries
        if ( entry.getAddedOrUpdatedData () != null )
        {
            for ( final Map.Entry<String, String> data : entry.getAddedOrUpdatedData ().entrySet () )
            {
                final DiffSubEntry subEntry = new DiffSubEntry ( entry, data.getKey () );
                subEntry.setNewValue ( data.getValue () );
                childs.put ( data.getKey (), subEntry );
            }
        }

        // removed entries
        if ( entry.getRemovedData () != null )
        {
            for ( final String removed : entry.getRemovedData () )
            {
                final DiffSubEntry subEntry = new DiffSubEntry ( entry, removed );
                subEntry.setNewValue ( null );
                childs.put ( removed, subEntry );
            }
        }

        // old entries
        if ( entry.getOldData () != null )
        {
            for ( final Map.Entry<String, String> data : entry.getOldData ().entrySet () )
            {
                DiffSubEntry subEntry = childs.get ( data.getKey () );
                if ( subEntry == null )
                {
                    subEntry = new DiffSubEntry ( entry, data.getKey () );
                    childs.put ( data.getKey (), subEntry );
                }
                subEntry.setOldValue ( data.getValue () );
            }
        }
        return childs;
    }

}
