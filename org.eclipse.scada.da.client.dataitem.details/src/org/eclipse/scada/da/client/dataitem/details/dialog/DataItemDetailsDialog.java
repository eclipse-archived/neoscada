/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.dataitem.details.dialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.scada.da.client.dataitem.details.DetailsViewComposite;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class DataItemDetailsDialog extends Dialog
{

    private final Item item;

    private DetailsViewComposite view;

    public DataItemDetailsDialog ( final Shell parent, final Item item )
    {
        super ( parent );
        setShellStyle ( SWT.CLOSE | SWT.TITLE | SWT.MIN | SWT.MAX | SWT.RESIZE | SWT.BORDER | SWT.MODELESS );
        setBlockOnOpen ( false );
        this.item = item;
    }

    @Override
    protected void createButtonsForButtonBar ( final Composite parent )
    {
        createButton ( parent, IDialogConstants.CLOSE_ID, IDialogConstants.CLOSE_LABEL, true );
    }

    @Override
    protected void buttonPressed ( final int buttonId )
    {
        if ( buttonId == IDialogConstants.CLOSE_ID )
        {
            closePressed ();
        }
    }

    protected void closePressed ()
    {
        setReturnCode ( OK );
        close ();
    }

    @Override
    protected void configureShell ( final Shell newShell )
    {
        super.configureShell ( newShell );
        newShell.setText ( String.format ( Messages.DataItemDetailsDialog_Shell_TitleFormat, this.item.getId () ) );
    }

    @Override
    protected Control createDialogArea ( final Composite parent )
    {
        final Composite composite = (Composite)super.createDialogArea ( parent );
        getShell ().setMinimumSize ( 100, 360 );
        composite.setLayout ( new FillLayout () );
        this.view = new DetailsViewComposite ( composite, SWT.NONE );
        this.view.setDataItem ( this.item );

        return composite;
    }
}
