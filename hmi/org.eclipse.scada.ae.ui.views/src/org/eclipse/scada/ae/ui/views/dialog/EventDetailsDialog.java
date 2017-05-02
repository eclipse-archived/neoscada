/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.dialog;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.ui.views.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class EventDetailsDialog extends TrayDialog
{
    private Event event;

    public EventDetailsDialog ( final IShellProvider parentShell )
    {
        super ( parentShell );
    }

    public EventDetailsDialog ( final Shell shell )
    {
        super ( shell );
    }

    @Override
    protected IDialogSettings getDialogBoundsSettings ()
    {
        return DialogSettings.getOrCreateSection ( Activator.getDefault ().getDialogSettings (), "EventDetailsDialog" );
    }

    @Override
    protected void createButtonsForButtonBar ( final Composite parent )
    {
        createButton ( parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true );
    }

    @Override
    protected boolean isResizable ()
    {
        return true;
    }

    @Override
    protected void configureShell ( final Shell newShell )
    {
        newShell.setText ( "Event details" );
        super.configureShell ( newShell );
    }

    @Override
    protected Control createDialogArea ( final Composite parent )
    {
        final Composite content = (Composite)super.createDialogArea ( parent );

        content.setLayout ( new FillLayout () );
        final TableViewer viewer = new TableViewer ( content, SWT.FULL_SELECTION );

        viewer.getTable ().setHeaderVisible ( true );

        final TableLayout layout = new TableLayout ();
        viewer.getTable ().setLayout ( layout );

        final TableViewerColumn colKey = new TableViewerColumn ( viewer, SWT.NONE );
        layout.addColumnData ( new ColumnWeightData ( 10 ) );
        colKey.getColumn ().setText ( "Key" );
        colKey.setLabelProvider ( new CellLabelProvider () {

            @Override
            public void update ( final ViewerCell cell )
            {
                final Map.Entry<?, ?> event = (Entry<?, ?>)cell.getElement ();
                cell.setText ( "" + event.getKey () );
            }
        } );

        final TableViewerColumn colValue = new TableViewerColumn ( viewer, SWT.NONE );
        layout.addColumnData ( new ColumnWeightData ( 10 ) );
        colValue.getColumn ().setText ( "Value" );
        colValue.setLabelProvider ( new CellLabelProvider () {

            @Override
            public void update ( final ViewerCell cell )
            {
                final Map.Entry<?, ?> event = (Entry<?, ?>)cell.getElement ();
                cell.setText ( "" + event.getValue () );
            }
        } );

        viewer.setContentProvider ( new ArrayContentProvider () );
        viewer.setInput ( this.event.getAttributes ().entrySet ().toArray ( new Map.Entry[0] ) );

        Dialog.applyDialogFont ( viewer.getControl () );

        return content;
    }

    public void open ( final Event event )
    {
        this.event = event;
        super.open ();
    }

}
