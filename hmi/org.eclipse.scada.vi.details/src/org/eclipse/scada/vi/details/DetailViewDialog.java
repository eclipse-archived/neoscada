/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.scada.core.ui.connection.login.LoginSession;
import org.eclipse.scada.core.ui.connection.login.SessionListener;
import org.eclipse.scada.core.ui.connection.login.SessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DetailViewDialog implements SessionListener
{

    private static final Logger logger = LoggerFactory.getLogger ( DetailViewDialog.class );

    private static final String detailRole = System.getProperty ( "org.eclipse.scada.vi.details.roles.detailView", "operator" ); //$NON-NLS-1$  //$NON-NLS-2$

    private static final String debugInformationRole = System.getProperty ( "org.eclipse.scada.vi.details.roles.debugInformation", "developer" ); //$NON-NLS-1$  //$NON-NLS-2$

    private Shell shell;

    private final Shell parentShell;

    private final Map<String, String> properties;

    private final String id;

    private DetailView detailView;

    private LoginSession session;

    public DetailViewDialog ( final Shell parentShell, final String id, final Map<String, String> properties )
    {
        this.parentShell = parentShell;
        this.id = id;
        this.properties = new HashMap<String, String> ( properties );
        this.session = SessionManager.getDefault ().getSession ();
    }

    public void open ()
    {
        try
        {
            if ( this.session == null || !this.session.hasRole ( detailRole ) )
            {
                ErrorDialog.openError ( this.parentShell, Messages.DetailViewDialog_ErrorDialog_Title, Messages.DetailViewDialog_ErrorDialog_NoSession, new Status ( IStatus.ERROR, Activator.PLUGIN_ID, String.format ( Messages.DetailViewDialog_ErrorMessage_NoSession, this.id ) ) );
                return;
            }

            this.detailView = DetailViewManager.openView ( this.id, this.properties );

            if ( this.detailView == null )
            {
                ErrorDialog.openError ( this.parentShell, Messages.DetailViewDialog_ErrorDialog_Title, Messages.DetailViewDialog_ErrorDialog_Message_NotFound, new Status ( IStatus.ERROR, Activator.PLUGIN_ID, String.format ( Messages.DetailViewDialog_ErrorMessage_NotFound, this.id ) ) );
                return;
            }
        }
        catch ( final CoreException e )
        {
            logger.warn ( "Failed to load view", e ); //$NON-NLS-1$
            ErrorDialog.openError ( this.parentShell, Messages.DetailViewDialog_ErrorDialog_Title, Messages.DetailViewDialog_ExceptionDialog_Message, e.getStatus () );
            return;
        }

        this.shell = new Shell ( this.parentShell, SWT.RESIZE | SWT.CLOSE | SWT.BORDER | SWT.TITLE | SWT.MODELESS );
        this.shell.setMinimumSize ( 400, 100 );
        this.shell.setText ( makeTitle () );
        this.shell.setToolTipText ( "" ); //$NON-NLS-1$

        if ( this.session.hasRole ( debugInformationRole ) )
        {
            for ( final String key : this.properties.keySet () )
            {
                this.shell.setToolTipText ( this.shell.getToolTipText () + this.properties.get ( key ) + "\n" ); //$NON-NLS-1$
            }
        }
        this.shell.addShellListener ( new ShellAdapter () {
            @Override
            public void shellClosed ( final ShellEvent e )
            {
                dispose ();
            }
        } );

        this.shell.setLayout ( new FillLayout () );

        this.shell.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent arg0 )
            {
                dispose ();
            }
        } );

        this.detailView.init ( this.shell, this.properties );

        this.shell.pack ();
        this.shell.open ();
        SessionManager.getDefault ().addListener ( this );
    }

    protected String makeTitle ()
    {
        final String title = this.properties.get ( "title" ); //$NON-NLS-1$
        if ( title != null )
        {
            return title;
        }

        final String linkName = this.properties.get ( "linkName" ); //$NON-NLS-1$
        final String linkDetailView = this.properties.get ( "linkDetailView" ); //$NON-NLS-1$

        if ( linkName != null && linkDetailView != null )
        {
            return String.format ( "%s | %s", linkName, linkDetailView ); //$NON-NLS-1$
        }

        return "Detail View";
    }

    public void dispose ()
    {
        SessionManager.getDefault ().removeListener ( DetailViewDialog.this );

        if ( this.detailView != null )
        {
            this.detailView.dispose ();
        }

        if ( this.shell != null )
        {
            if ( !this.shell.isDisposed () )
            {
                this.shell.dispose ();
            }
        }
    }

    @Override
    public void sessionChanged ( final LoginSession session )
    {
        this.session = session;

        if ( session != null && session.hasRole ( detailRole ) )
        {
            return;
        }

        if ( this.session == null )
        {
            this.shell.getDisplay ().asyncExec ( new Runnable () {

                @Override
                public void run ()
                {
                    DetailViewDialog.this.dispose ();
                }
            } );
        }
    }
}
