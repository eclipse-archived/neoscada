/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.login.toolbar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;
import org.eclipse.scada.core.ui.connection.login.LoginSession;
import org.eclipse.scada.core.ui.connection.login.SessionListener;
import org.eclipse.scada.core.ui.connection.login.SessionManager;

public class LoginStatusControl extends WorkbenchWindowControlContribution implements SessionListener
{

    private Label statusLabel;

    public LoginStatusControl ()
    {
    }

    public LoginStatusControl ( final String id )
    {
        super ( id );
    }

    @Override
    public void dispose ()
    {
        super.dispose ();
        SessionManager.getDefault ().removeListener ( this );
    }

    @Override
    protected Control createControl ( final Composite parent )
    {
        final Composite wrapper = new Composite ( parent, SWT.NONE );

        final GridLayout layout = new GridLayout ( 1, true );
        layout.marginHeight = layout.marginWidth = 0;

        wrapper.setLayout ( layout );

        this.statusLabel = new Label ( wrapper, SWT.NONE );

        this.statusLabel.setText ( Messages.LoginStatusControl_StatusLabel_Text );
        final GridData gd = new GridData ( SWT.FILL, SWT.CENTER, false, true );
        gd.widthHint = 150;
        this.statusLabel.setLayoutData ( gd );

        SessionManager.getDefault ().addListener ( this );

        return wrapper;
    }

    public void sessionChanged ( final LoginSession session )
    {
        if ( session == null )
        {
            this.statusLabel.setText ( Messages.LoginStatusControl_StatusLabel_NoSession );
        }
        else
        {
            this.statusLabel.setText ( String.format ( Messages.LoginStatusControl_StatusLabel_SessionFormat, getUserName ( session.getUsername () ), session.getLoginContext ().getName () ) );
        }
    }

    private Object getUserName ( final String username )
    {
        if ( username == null )
        {
            return Messages.LoginStatusControl_Text_Anonymous;
        }
        else
        {
            return username;
        }
    }
}
