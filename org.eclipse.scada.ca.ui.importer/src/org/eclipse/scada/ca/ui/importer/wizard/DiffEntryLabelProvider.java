/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.ui.importer.wizard;

import java.util.Map;

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.scada.ca.data.DiffEntry;

public class DiffEntryLabelProvider extends CellLabelProvider
{

    private static final int MAX_STR_LENGTH = 200;

    @Override
    public void update ( final ViewerCell cell )
    {
        final Object ele = cell.getElement ();

        if ( ele instanceof DiffEntry )
        {
            final DiffEntry entry = (DiffEntry)ele;

            final int idx = cell.getColumnIndex ();
            switch ( idx )
            {
                case 0:
                    cell.setText ( entry.getFactoryId () );
                    break;

                case 1:
                    cell.setText ( entry.getConfigurationId () );
                    break;

                case 2:
                    cell.setText ( entry.getOperation ().toString () );
                    break;

                case 3:
                    cell.setText ( formatData ( entry.getAddedOrUpdatedData (), MAX_STR_LENGTH ) );
                    break;

                case 4:
                    cell.setText ( formatData ( entry.getOldData (), MAX_STR_LENGTH ) );
                    break;
            }
        }

        else if ( ele instanceof DiffSubEntry )
        {
            final DiffSubEntry entry = (DiffSubEntry)ele;

            final int idx = cell.getColumnIndex ();
            switch ( idx )
            {
                case 0:
                    break;

                case 1:
                    cell.setText ( entry.getKey () );
                    break;

                case 2:
                    break;

                case 3:
                    cell.setText ( entry.getNewValue () );
                    break;

                case 4:
                    cell.setText ( entry.getOldValue () );
                    break;
            }
        }
    }

    private String formatData ( final Map<String, String> data, final int maxLen )
    {
        if ( data == null )
        {
            return null;
        }

        final String str = data.toString ();
        if ( maxLen > 0 && str.length () > maxLen )
        {
            return str.substring ( 0, maxLen ) + "…";
        }
        else
        {
            return str;
        }
    }

}
