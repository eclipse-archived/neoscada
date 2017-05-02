/*******************************************************************************
 * Copyright (c) 2010, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - add equals check
 *******************************************************************************/
package org.eclipse.scada.ca.ui.importer.wizard;

import java.util.Map;

import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.scada.ca.data.DiffEntry;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

public class DiffEntryLabelProvider extends CellLabelProvider
{

    private static final int MAX_STR_LENGTH = 200;

    private final Color equalFgColor;

    private final ResourceManager resourceManager;

    private final ColorDescriptor equalFgColorDesc = ColorDescriptor.createFrom ( new RGB ( 127, 127, 127 ) );

    public DiffEntryLabelProvider ( final ResourceManager resourceManager )
    {
        this.resourceManager = resourceManager;
        this.equalFgColor = resourceManager.createColor ( this.equalFgColorDesc );
    }

    @Override
    public void dispose ()
    {
        this.resourceManager.destroyColor ( this.equalFgColorDesc );
    }

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

            final boolean isEqual = equals ( entry.getNewValue (), entry.getOldValue () );
            if ( isEqual )
            {
                cell.setForeground ( this.equalFgColor );
            }

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

    private boolean equals ( final String newValue, final String oldValue )
    {
        if ( newValue == oldValue )
        {
            return true;
        }

        if ( newValue == null )
        {
            return false;
        }

        return newValue.equals ( oldValue );
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
