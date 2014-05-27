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
package org.eclipse.scada.utils.ui.server.internal.app;

import java.util.Set;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.application.AbstractEntryPoint;
import org.eclipse.rap.rwt.service.ServerPushSession;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.eclipse.scada.utils.ui.server.internal.FactoryImpl;
import org.eclipse.scada.utils.ui.server.internal.PageManager;
import org.eclipse.scada.utils.ui.server.internal.Properties;
import org.eclipse.scada.utils.ui.server.internal.SecurityProvider;
import org.eclipse.scada.utils.ui.server.internal.Session;
import org.eclipse.scada.utils.ui.server.internal.SessionListener;
import org.eclipse.scada.utils.ui.server.internal.TreeNode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

public class MainEntryPoint extends AbstractEntryPoint
{
    protected static final String PLUGIN_ID = "org.eclipse.scada.utils.ui.server";

    private ObservableListTreeContentProvider treeContentProvider;

    private final DisposeListener disposeListener = new DisposeListener () {

        private static final long serialVersionUID = 1L;

        @Override
        public void widgetDisposed ( final DisposeEvent event )
        {
            handleDispose ();
        }
    };

    private Display display;

    private PageManager manager;

    private ServerPushSession session;

    private Label headerLabel;

    private DataBindingContext dbc;

    private TreeViewer viewer;

    private boolean handlingEvent;

    private final SingleServiceListener<SecurityProvider> securityProviderListener = new SingleServiceListener<SecurityProvider> () {

        @Override
        public void serviceChange ( final ServiceReference<SecurityProvider> reference, final SecurityProvider service )
        {
            setSecurityService ( service );
        }
    };

    private SingleServiceTracker<SecurityProvider> serviceTracker;

    private SecurityProvider securityProvider;

    private Button logonButton;

    private Button logoutButton;

    private Session userSession;

    @Override
    protected void createContents ( final Composite parent )
    {
        this.display = parent.getDisplay ();
        this.dbc = new DataBindingContext ( SWTObservables.getRealm ( this.display ) );

        this.session = new ServerPushSession ();
        this.session.start ();

        this.serviceTracker = new SingleServiceTracker<SecurityProvider> ( FrameworkUtil.getBundle ( MainEntryPoint.class ).getBundleContext (), SecurityProvider.class, this.securityProviderListener );

        this.manager = new PageManager ( SWTObservables.getRealm ( parent.getDisplay () ), FrameworkUtil.getBundle ( MainEntryPoint.class ).getBundleContext () );

        final FormLayout layout = new FormLayout ();
        parent.setLayout ( layout );

        final Composite header = createHeader ( parent );
        final Composite footer = createFooter ( parent );

        final SashForm sash = new SashForm ( parent, SWT.HORIZONTAL );
        createMenu ( sash );
        final Composite main = createMain ( sash );
        sash.setWeights ( new int[] { 10, 90 } );

        {
            final FormData fd = new FormData ();
            fd.left = new FormAttachment ( 0 );
            fd.right = new FormAttachment ( 100 );
            fd.top = new FormAttachment ( header );
            fd.bottom = new FormAttachment ( footer );
            fd.width = 200;
            sash.setLayoutData ( fd );
        }

        {
            final FormData fd = new FormData ();
            fd.left = new FormAttachment ( 0 );
            fd.right = new FormAttachment ( 100 );
            fd.height = 75;
            fd.top = new FormAttachment ( 0 );
            header.setLayoutData ( fd );
        }

        {
            final FormData fd = new FormData ();
            fd.left = new FormAttachment ( 0 );
            fd.right = new FormAttachment ( 100 );
            fd.bottom = new FormAttachment ( 100 );
            footer.setLayoutData ( fd );
        }

        this.manager.setMainArea ( main );

        parent.addDisposeListener ( this.disposeListener );

        this.serviceTracker.open ();
    }

    protected void setSecurityService ( final SecurityProvider service )
    {
        if ( this.display.isDisposed () )
        {
            return;
        }

        this.display.asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                if ( !MainEntryPoint.this.display.isDisposed () )
                {
                    handleSetSecurityService ( service );
                }
            }
        } );
    }

    protected void handleSetSecurityService ( final SecurityProvider service )
    {
        this.securityProvider = service;
        this.logonButton.setVisible ( this.securityProvider != null );
        this.logoutButton.setVisible ( this.securityProvider != null );
    }

    private Composite createMain ( final Composite parent )
    {
        final Composite main = new Composite ( parent, SWT.NONE );
        return main;
    }

    protected void handleDispose ()
    {
        if ( this.serviceTracker != null )
        {
            this.serviceTracker.close ();
            this.serviceTracker = null;
        }
        if ( this.session != null )
        {
            this.session.stop ();
            this.session = null;
        }
        if ( this.manager != null )
        {
            this.manager.dispose ();
            this.manager = null;
        }
        if ( this.dbc != null )
        {
            this.dbc.dispose ();
            this.dbc = null;
        }
    }

    private Composite createMenu ( final Composite parent )
    {
        final Composite menu = new Composite ( parent, SWT.NONE );

        menu.setLayout ( new FillLayout () );

        this.viewer = new TreeViewer ( menu, SWT.FULL_SELECTION );

        this.treeContentProvider = new ObservableListTreeContentProvider ( new FactoryImpl (), null );
        this.viewer.setContentProvider ( this.treeContentProvider );

        this.viewer.setLabelProvider ( new TreeNodeLabelProvider ( this.viewer,
                BeansObservables.observeMap ( this.treeContentProvider.getRealizedElements (), TreeNode.PROP_NAME ),
                BeansObservables.observeMap ( this.treeContentProvider.getRealizedElements (), TreeNode.PROP_PROVIDER_SET )
                ) );

        this.viewer.setInput ( this.manager.getRootNode () );

        this.viewer.addSelectionChangedListener ( new ISelectionChangedListener () {

            @Override
            public void selectionChanged ( final SelectionChangedEvent event )
            {
                handleSelectionChanged ( event );
            }
        } );

        this.viewer.setAutoExpandLevel ( 2 );

        return menu;
    }

    protected void handleSelectionChanged ( final SelectionChangedEvent event )
    {
        if ( this.handlingEvent )
        {
            return;
        }

        final TreeNode node = (TreeNode) ( (IStructuredSelection)event.getSelection () ).getFirstElement ();
        final TreeNode nodeShown = this.manager.showPage ( node );

        try
        {
            this.handlingEvent = true;
            // select the node, could also be the old one
            this.viewer.setSelection ( new StructuredSelection ( nodeShown ), true );
        }
        finally
        {
            this.handlingEvent = false;
        }
    }

    private Composite createHeader ( final Composite parent )
    {
        final Composite header = new Composite ( parent, SWT.NONE );

        header.setLayout ( new GridLayout ( 2, false ) );

        header.setData ( RWT.CUSTOM_VARIANT, "header" ); //$NON-NLS-1$
        header.setBackgroundMode ( SWT.INHERIT_DEFAULT );

        this.headerLabel = new Label ( header, SWT.NONE );
        this.headerLabel.setLayoutData ( new GridData ( SWT.FILL, SWT.CENTER, true, true ) );
        this.headerLabel.setData ( RWT.CUSTOM_VARIANT, "headerLabel" ); //$NON-NLS-1$

        this.dbc.bindValue ( SWTObservables.observeText ( this.headerLabel ), this.manager.getPageName () );

        this.logonButton = new Button ( header, SWT.PUSH );
        this.logonButton.setVisible ( false );
        this.logonButton.setText ( "Logon" );
        this.logonButton.addSelectionListener ( new SelectionAdapter () {
            private static final long serialVersionUID = 1L;

            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                handleLogon ();
            }
        } );

        this.logoutButton = new Button ( header, SWT.PUSH );
        this.logoutButton.setVisible ( false );
        this.logoutButton.setText ( "Logout" );
        this.logoutButton.addSelectionListener ( new SelectionAdapter () {
            private static final long serialVersionUID = 1L;

            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                handleLogout ();
            }
        } );

        return header;
    }

    protected void handleLogout ()
    {
        if ( this.userSession != null )
        {
            this.userSession.close ();
            this.userSession = null;
        }
    }

    protected void setSession ( final Session session )
    {
        this.userSession = session;
        this.logonButton.setEnabled ( session == null );
        this.logoutButton.setEnabled ( session != null );
    }

    protected void handleLogon ()
    {
        this.logonButton.setEnabled ( false );

        this.securityProvider.startLogon ( new SessionListener () {

            @Override
            public void opened ( final Session session )
            {
                if ( !MainEntryPoint.this.display.isDisposed () )
                {
                    MainEntryPoint.this.display.asyncExec ( new Runnable () {
                        @Override
                        public void run ()
                        {
                            setSession ( session );
                        };
                    } );
                }
            }

            @Override
            public void permissionsChanged ( final Set<String> added, final Set<String> removed )
            {
                // forward to page manager
            }

            @Override
            public void closed ( final Throwable e )
            {
                if ( !MainEntryPoint.this.display.isDisposed () )
                {
                    MainEntryPoint.this.display.asyncExec ( new Runnable () {
                        @Override
                        public void run ()
                        {
                            sessionClosed ( e );
                        }

                    } );
                }
                // forward to page manager                
            }
        } );
    }

    private void sessionClosed ( final Throwable e )
    {
        setSession ( null );
        if ( e != null )
        {
            final IStatus status = StatusHelper.convertStatus ( PLUGIN_ID, e );
            ErrorDialog.openError ( getShell (), "Session", null, status );
        }
    }

    private Composite createFooter ( final Composite parent )
    {
        final Composite footer = new Composite ( parent, SWT.NONE );

        footer.setLayout ( new RowLayout () );

        footer.setData ( RWT.CUSTOM_VARIANT, "footer" );
        footer.setBackgroundMode ( SWT.INHERIT_DEFAULT );

        final Label label = new Label ( footer, SWT.NONE );
        label.setText ( System.getProperty ( Properties.FOOTER_TEXT, "Eclipse SCADA Admin Console" ) );

        return footer;
    }

}
