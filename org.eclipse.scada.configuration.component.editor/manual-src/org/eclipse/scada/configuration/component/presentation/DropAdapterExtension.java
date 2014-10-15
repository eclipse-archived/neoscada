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
package org.eclipse.scada.configuration.component.presentation;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.ComponentFactory;
import org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition;
import org.eclipse.scada.configuration.component.ExternalValue;
import org.eclipse.scada.configuration.component.SingleValue;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.connection.dnd.ItemTransfer;
import org.eclipse.scada.ui.utils.SelectionHelper;
import org.eclipse.scada.ui.utils.SelectionHelper.ListMode;
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
        System.out.println ( object.getClass () );

        if ( object instanceof Item[] )
        {
            final Collection<ExternalValue> result = new LinkedList<> ();
            for ( final Item item : (Item[])object )
            {
                final ExternalValue v = ComponentFactory.eINSTANCE.createExternalValue ();
                v.setName ( item.getId () );
                v.setSourceName ( item.getId () );
                result.add ( v );
                // FIXME: ask for connection
                // FIXME: ask for master
            }
            return result;
        }
        if ( object instanceof ISelection )
        {
            final List<Component> list = SelectionHelper.list ( (ISelection)object, ListMode.NONE, Component.class );
            if ( list != null )
            {
                final Collection<ComponentReferenceInputDefinition> result = new LinkedList<> ();

                for ( final Component c : list )
                {
                    final ComponentReferenceInputDefinition ref = ComponentFactory.eINSTANCE.createComponentReferenceInputDefinition ();
                    ref.setComponent ( c );

                    if ( c instanceof SingleValue )
                    {
                        ref.getLocalTag ().add ( ( (SingleValue)c ).getName () );
                    }

                    result.add ( ref );
                }
                System.out.println ( "TEST" );

                return result;
            }
        }

        return super.extractDragSource ( object );
    }

}
