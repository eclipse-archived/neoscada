/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.base.action;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.scada.da.client.base.Activator;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.connection.data.ItemSelectionHelper;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;

public abstract class AbstractItemAction implements org.eclipse.ui.IObjectActionDelegate
{

    protected final Collection<Item> items = new LinkedList<Item> ();

    protected IWorkbenchPage page;

    private final String message;

    public AbstractItemAction ( final String message )
    {
        super ();
        this.message = message;
    }

    public void setActivePart ( final IAction action, final IWorkbenchPart targetPart )
    {
        this.page = targetPart.getSite ().getPage ();
    }

    protected abstract void processItem ( final Item item ) throws PartInitException;

    public void run ( final IAction action )
    {
        final MultiStatus status = new MultiStatus ( Activator.PLUGIN_ID, 0, this.message, null );
        for ( final Item item : this.items )
        {
            try
            {
                processItem ( item );
            }
            catch ( final PartInitException e )
            {
                status.add ( e.getStatus () );
            }
        }
        if ( !status.isOK () )
        {
            showError ( status );
        }
    }

    protected void showError ( final MultiStatus status )
    {
        ErrorDialog.openError ( this.page.getWorkbenchWindow ().getShell (), "View Error", "Failed to show data item details", status );
    }

    protected String asSecondardId ( final Item item )
    {
        return item.getId ().replace ( "_", "__" ).replace ( ':', '_' );
    }

    public void selectionChanged ( final IAction action, final ISelection selection )
    {
        clearSelection ();

        this.items.addAll ( ItemSelectionHelper.getSelection ( selection ) );
    }

    protected void clearSelection ()
    {
        this.items.clear ();
    }

}