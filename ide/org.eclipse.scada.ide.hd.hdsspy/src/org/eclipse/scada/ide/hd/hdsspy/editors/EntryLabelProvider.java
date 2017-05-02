/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ide.hd.hdsspy.editors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.scada.ide.hd.hdsspy.Activator;
import org.eclipse.swt.graphics.RGB;

public class EntryLabelProvider extends StyledCellLabelProvider
{
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss.SSS" );

    private final LocalResourceManager resourceManager;

    public EntryLabelProvider ()
    {
        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources () );
    }

    @Override
    public void update ( final ViewerCell cell )
    {
        final ArchiveEntry entry = (ArchiveEntry)cell.getElement ();

        if ( cell.getColumnIndex () == 0 )
        {
            if ( entry.isHeartbeat () )
            {
                if ( entry.isDeleted () )
                {
                    cell.setImage ( this.resourceManager.createImageWithDefault ( Activator.getImageDescriptor ( "icons/heart-empty.png" ) ) );
                }
                else
                {
                    cell.setImage ( this.resourceManager.createImageWithDefault ( Activator.getImageDescriptor ( "icons/heart.png" ) ) );
                }
            }
        }

        if ( entry.isDeleted () )
        {
            cell.setForeground ( this.resourceManager.createColor ( new RGB ( 128, 128, 128 ) ) );
        }
        else if ( entry.isError () )
        {
            cell.setForeground ( this.resourceManager.createColor ( new RGB ( 255, 0, 0 ) ) );
        }

        switch ( cell.getColumnIndex () )
        {
            case 0:
                cell.setText ( DATE_FORMAT.format ( entry.getTimestamp () ) );
                break;
            case 1:
                cell.setText ( "" + entry.getValue () );
                break;
            case 2:
                cell.setText ( makeCheck ( entry.isError () ) );
                break;
            case 3:
                cell.setText ( makeCheck ( entry.isManual () ) );
                break;
            case 4:
                cell.setText ( makeCheck ( entry.isDeleted () ) );
                break;
            case 5:
                cell.setText ( makeCheck ( entry.isHeartbeat () ) );
                break;
        }
    }

    private String makeCheck ( final boolean state )
    {
        return state ? "X" : "";
    };

    @Override
    public void dispose ()
    {
        super.dispose ();
    }
}
