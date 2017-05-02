/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.ui.providers.internal;

import org.eclipse.scada.sec.ui.providers.KeySelectorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;

public class DefaultPage extends org.eclipse.jface.preference.PreferencePage implements IWorkbenchPreferencePage
{

    @Override
    public void init ( final IWorkbench workbench )
    {
    }

    @Override
    protected Control createContents ( final Composite parent )
    {
        final Composite wrapper = new Composite ( parent, SWT.NONE );
        wrapper.setLayout ( new GridLayout ( 1, false ) );

        final Label label = new Label ( wrapper, SWT.NONE );
        label.setText ( "Preferences for Eclipse SCADA Security" );

        final Button testButton = new Button ( wrapper, SWT.NONE );
        testButton.setText ( "Test key selection…" );
        testButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                openDialog ();
            }
        } );

        return wrapper;
    }

    protected void openDialog ()
    {
        new KeySelectorDialog ( PlatformUI.getWorkbench ().getActiveWorkbenchWindow ().getShell (), "Select key", "Select a key for testing", 5 ).open ();
    }

}
