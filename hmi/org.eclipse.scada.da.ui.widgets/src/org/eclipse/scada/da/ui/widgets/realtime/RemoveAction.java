/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.ui.widgets.realtime;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

public class RemoveAction extends Action implements ISelectionChangedListener, IEditorActionDelegate
{
    private RealtimeListAdapter view = null;

    private Collection<ListEntry> entries;

    public RemoveAction ( final RealtimeListAdapter view )
    {
        super ( Messages.RemoveAction_Name, ImageDescriptor.createFromFile ( RemoveAction.class, "icons/delete_obj.gif" ) );

        this.view = view;
    }

    @Override
    public void run ()
    {
        if ( this.entries == null || this.view == null )
        {
            return;
        }
        this.view.remove ( this.entries );
    }

    @Override
    public void selectionChanged ( final SelectionChangedEvent event )
    {
        setSelection ( event.getSelection () );
    }

    @Override
    public void setActiveEditor ( final IAction action, final IEditorPart targetEditor )
    {
        if ( targetEditor instanceof RealtimeListAdapter )
        {
            this.view = (RealtimeListAdapter)targetEditor;
        }
    }

    @Override
    public void run ( final IAction action )
    {
        run ();
    }

    @Override
    public void selectionChanged ( final IAction action, final ISelection selection )
    {
        setSelection ( selection );
    }

    private void setSelection ( final ISelection selection )
    {
        this.entries = new LinkedList<ListEntry> ();

        if ( selection instanceof IStructuredSelection )
        {
            final Iterator<?> i = ( (IStructuredSelection)selection ).iterator ();
            while ( i.hasNext () )
            {
                final Object o = i.next ();
                if ( o instanceof ListEntry )
                {
                    this.entries.add ( (ListEntry)o );
                }
            }
        }
    }
}
