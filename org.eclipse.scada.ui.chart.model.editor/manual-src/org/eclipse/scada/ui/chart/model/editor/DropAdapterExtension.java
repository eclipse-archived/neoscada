/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.chart.model.editor;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.scada.hd.ui.connection.data.Item;
import org.eclipse.scada.hd.ui.connection.dnd.ItemTransfer;
import org.eclipse.scada.ui.chart.model.ArchiveSeries;
import org.eclipse.scada.ui.chart.model.ChartFactory;
import org.eclipse.scada.ui.chart.model.IdItem;
import org.eclipse.scada.ui.chart.model.UriItem;
import org.eclipse.swt.dnd.DropTargetEvent;

public class DropAdapterExtension extends EditingDomainViewerDropAdapter
{
    public DropAdapterExtension ( final EditingDomain domain, final Viewer viewer )
    {
        super ( domain, viewer );
    }

    @Override
    protected Collection<?> getDragSource ( final DropTargetEvent event )
    {
        // Check whether the current data type can be transfered locally.
        //
        final ItemTransfer itemTransfer = ItemTransfer.getInstance ();
        if ( itemTransfer.isSupportedType ( event.currentDataType ) )
        {
            // Motif kludge: we would get something random instead of null.
            //
            if ( IS_MOTIF )
            {
                return null;
            }

            // Transfer the data and, if non-null, extract it.
            //
            final Object object = itemTransfer.nativeToJava ( event.currentDataType );
            return object == null ? null : extractDragSource ( object );
        }
        else
        {
            return super.getDragSource ( event );
        }
    }

    @Override
    protected Collection<?> extractDragSource ( final Object object )
    {
        if ( object instanceof Item[] )
        {
            final Collection<Object> result = new LinkedList<> ();
            for ( final Item item : (Item[])object )
            {
                final ArchiveSeries as = ChartFactory.eINSTANCE.createArchiveSeries ();
                as.setLabel ( item.toLabel () );
                switch ( item.getType () )
                {
                    case ID:
                    {
                        final IdItem itemRef = ChartFactory.eINSTANCE.createIdItem ();
                        itemRef.setConnectionId ( item.getConnectionString () );
                        itemRef.setItemId ( item.getId () );
                        as.setItem ( itemRef );
                        break;
                    }
                    case URI:
                    {
                        final UriItem itemRef = ChartFactory.eINSTANCE.createUriItem ();
                        itemRef.setConnectionUri ( item.getConnectionString () );
                        itemRef.setItemId ( item.getId () );
                        as.setItem ( itemRef );
                        break;
                    }
                    default:
                        continue;
                }

                result.add ( as );
            }
            return result;
        }
        else
        {
            return super.extractDragSource ( object );
        }
    }
}