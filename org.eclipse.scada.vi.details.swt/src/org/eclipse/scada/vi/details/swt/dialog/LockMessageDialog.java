/*******************************************************************************
 * Copyright (c) 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.dialog;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class LockMessageDialog extends TitleAreaDialog
{

    private Text text;

    private String textString;

    public LockMessageDialog ( final Shell shell, final String defaultString )
    {
        super ( shell );
        setBlockOnOpen ( true );
        this.textString = defaultString;
    }

    public String openDialog ()
    {
        if ( open () == Window.OK )
        {
            return getText ();
        }
        else
        {
            return null;
        }
    }

    @Override
    protected void okPressed ()
    {
        this.textString = this.text.getText ();
        super.okPressed ();
    }

    public String getText ()
    {
        return this.textString;
    }

    @Override
    protected Control createDialogArea ( final Composite parent )
    {
        setMessage ( Messages.LockMessageDialog_DialogMessage );
        setTitle ( Messages.LockMessageDialog_DialogTitle );
        getShell ().setText ( Messages.LockMessageDialog_DialogTitle );

        final Composite wrapper = (Composite)super.createDialogArea ( parent );

        this.text = new Text ( wrapper, SWT.BORDER | SWT.MULTI );
        this.text.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );
        if ( this.textString != null )
        {
            this.text.setText ( this.textString );
            this.text.setSelection ( 0, this.text.getText ().length () );
        }

        return wrapper;
    }

}
