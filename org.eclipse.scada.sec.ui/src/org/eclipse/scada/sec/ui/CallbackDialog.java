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
package org.eclipse.scada.sec.ui;

import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class CallbackDialog extends TitleAreaDialog
{
    private final List<CallbackWidgetFactory> factories;

    private DataBindingContext dbc;

    public CallbackDialog ( final Shell parentShell, final List<CallbackWidgetFactory> callbacks )
    {
        super ( parentShell );
        this.factories = callbacks;
    }

    public boolean openDialog ()
    {
        if ( this.factories.isEmpty () )
        {
            return false;
        }
        else
        {
            open ();
            return true;
        }
    }

    @Override
    protected Control createDialogArea ( final Composite parent )
    {
        final Composite wrapper = (Composite)super.createDialogArea ( parent );

        initializeDialogUnits ( wrapper );
        final Composite contents = createComposite ( wrapper );
        contents.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );
        Dialog.applyDialogFont ( wrapper );

        return wrapper;
    }

    private Composite createComposite ( final Composite wrapper )
    {
        this.dbc = new DataBindingContext ( SWTObservables.getRealm ( wrapper.getDisplay () ) );

        wrapper.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                CallbackDialog.this.dbc.dispose ();
            }
        } );

        final Composite composite = new Composite ( wrapper, SWT.NONE );
        composite.setLayout ( new GridLayout ( 2, false ) );

        for ( final CallbackWidgetFactory factory : this.factories )
        {
            factory.createGridWidgets ( this.dbc, composite );
        }

        return composite;
    }

    @Override
    protected void okPressed ()
    {
        for ( final CallbackWidgetFactory factory : this.factories )
        {
            factory.complete ();
        }
        super.okPressed ();
    }
}
