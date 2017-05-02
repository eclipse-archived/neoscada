/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - use new adapter helper
 *******************************************************************************/
package org.eclipse.scada.da.ui.connection.views;

import java.util.Arrays;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.core.browser.DataItemEntry;
import org.eclipse.scada.da.core.browser.FolderEntry;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.ui.databinding.CommonListeningLabelProvider;
import org.eclipse.scada.ui.databinding.StyledViewerLabel;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;

public class ConnectionLabelProvider extends CommonListeningLabelProvider
{
    private final ResourceManager resource = new LocalResourceManager ( JFaceResources.getResources () );

    public ConnectionLabelProvider ()
    {
        super ( "org.eclipse.scada.da.ui.connection.provider" );
    }

    @Override
    public void dispose ()
    {
        this.resource.dispose ();
        super.dispose ();
    }

    @Override
    public void updateLabel ( final StyledViewerLabel label, final Object element )
    {
        final FolderEntry folderEntry = AdapterHelper.adapt ( element, FolderEntry.class );
        if ( folderEntry != null )
        {
            updateFolder ( label, folderEntry );
        }

        final DataItemEntry dataItemEntry = AdapterHelper.adapt ( element, DataItemEntry.class );
        if ( dataItemEntry != null )
        {
            updateItem ( label, dataItemEntry );
        }
    }

    private void updateItem ( final StyledViewerLabel label, final DataItemEntry dataItemEntry )
    {
        String itemName = dataItemEntry.getName ();
        if ( itemName == null || itemName.length () == 0 )
        {
            itemName = " ";
        }
        label.setText ( itemName );

        if ( dataItemEntry.getIODirections ().containsAll ( Arrays.asList ( IODirection.INPUT, IODirection.OUTPUT ) ) )
        {
            label.setImage ( this.resource.createImage ( ImageDescriptor.createFromFile ( ConnectionLabelProvider.class, "icons/item_io.gif" ) ) );
        }
        else if ( dataItemEntry.getIODirections ().contains ( IODirection.INPUT ) )
        {
            label.setImage ( this.resource.createImage ( ImageDescriptor.createFromFile ( ConnectionLabelProvider.class, "icons/item_i.gif" ) ) );
        }
        else if ( dataItemEntry.getIODirections ().contains ( IODirection.OUTPUT ) )
        {
            label.setImage ( this.resource.createImage ( ImageDescriptor.createFromFile ( ConnectionLabelProvider.class, "icons/item_o.gif" ) ) );
        }
        else
        {
            label.setImage ( this.resource.createImage ( ImageDescriptor.createFromFile ( ConnectionLabelProvider.class, "icons/item.gif" ) ) );
        }
    }

    private void updateFolder ( final StyledViewerLabel label, final FolderEntry folderEntry )
    {
        label.setImage ( this.resource.createImage ( ImageDescriptor.createFromFile ( ConnectionLabelProvider.class, "icons/folder.gif" ) ) );

        String folderName = folderEntry.getName ();
        if ( folderName == null || folderName.length () == 0 )
        {
            folderName = " ";
        }
        label.setText ( folderName );
    }

    @Override
    public String getDescription ( final Object anElement )
    {
        final DataItemEntry dataItemEntry = AdapterHelper.adapt ( anElement, DataItemEntry.class );
        if ( dataItemEntry != null )
        {
            final String itemId = dataItemEntry.getId ();

            final Variant value = dataItemEntry.getAttributes ().get ( "description" );
            if ( value != null )
            {
                return String.format ( "%s (%s)", itemId, value.asString ( "" ) );
            }
            else
            {
                return itemId;
            }
        }

        final FolderEntry folderEntry = AdapterHelper.adapt ( anElement, FolderEntry.class );
        if ( folderEntry != null )
        {
            final Variant value = folderEntry.getAttributes ().get ( "description" );
            if ( value != null )
            {
                return value.asString ( null );
            }
        }
        return super.getDescription ( anElement );
    }
}
