/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.login.dialog;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.DialogTray;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.scada.core.ui.connection.login.Activator;
import org.eclipse.scada.core.ui.connection.login.LoginContext;
import org.eclipse.scada.core.ui.connection.login.LoginHandler;
import org.eclipse.scada.core.ui.connection.login.factory.ConnectionLoginFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginDialog extends TitleAreaDialog
{

    private static final String SETTING_AS_PROPERTIES = "transmitCredentialsAsProperties"; //$NON-NLS-1$

    private static final String SETTING_USER = "user"; //$NON-NLS-1$

    private static final String SETTING_CONTEXT = "context"; //$NON-NLS-1$

    private final static Logger logger = LoggerFactory.getLogger ( LoginDialog.class );

    private ComboViewer contextSelector;

    private Text userText;

    private Text passwordText;

    private final LoginContext[] contexts;

    private LoginContext loginContext;

    private ConnectionAnalyzer analyzer;

    private ContextCreator creator;

    private String user;

    private String password;

    private final IDialogSettings dialogSettings;

    private boolean flagCredentialsAsProperties;

    public LoginDialog ( final Shell parentShell )
    {
        super ( parentShell );
        setBlockOnOpen ( true );
        setTitle ( Messages.LoginDialog_Dlg_Title );
        setHelpAvailable ( false );

        this.contexts = Activator.getDefault ().getContextList ();
        this.dialogSettings = getDialogSection ();
    }

    private IDialogSettings getDialogSection ()
    {
        IDialogSettings section = Activator.getDefault ().getDialogSettings ().getSection ( "LoginDialog" ); //$NON-NLS-1$
        if ( section == null )
        {
            section = Activator.getDefault ().getDialogSettings ().addNewSection ( "LoginDialog" ); //$NON-NLS-1$
        }
        return section;
    }

    @Override
    protected boolean isResizable ()
    {
        return true;
    }

    /**
     * Save current state to the dialog settings
     */
    private void saveTo ()
    {
        if ( this.loginContext != null && this.user != null )
        {
            this.dialogSettings.put ( SETTING_CONTEXT, this.loginContext.getId () );
            this.dialogSettings.put ( SETTING_USER, this.user );
            this.dialogSettings.put ( SETTING_AS_PROPERTIES, this.flagCredentialsAsProperties );
        }
    }

    /**
     * Load the current state from the dialog settings
     */
    private void loadFrom ()
    {
        this.flagCredentialsAsProperties = this.dialogSettings.getBoolean ( SETTING_AS_PROPERTIES );
        final String user = this.dialogSettings.get ( SETTING_USER );
        final String contextId = this.dialogSettings.get ( SETTING_CONTEXT );
        if ( user != null && contextId != null )
        {
            this.userText.setText ( user );
            for ( final LoginContext context : this.contexts )
            {
                if ( context.getId ().equals ( contextId ) )
                {
                    this.contextSelector.setSelection ( new StructuredSelection ( context ), true );
                }
            }
            this.passwordText.setFocus ();
        }
        else
        {
            this.contextSelector.getControl ().setFocus ();
        }
    }

    private void update ()
    {
        final Button button = getButton ( OK );
        try
        {
            setMessage ( Messages.LoginDialog_DefaultMessage, IMessageProvider.INFORMATION );
            validate ();

            button.setEnabled ( true );
        }
        catch ( final Exception e )
        {
            button.setEnabled ( false );
            setMessage ( e.getMessage (), IMessageProvider.ERROR );
        }

    }

    private void validate ()
    {
        this.user = this.userText.getText ();
        this.password = this.passwordText.getText ();

        this.loginContext = null;
        final ISelection sel = this.contextSelector.getSelection ();
        if ( sel instanceof IStructuredSelection )
        {
            if ( ! ( (IStructuredSelection)sel ).isEmpty () )
            {
                final Object o = ( (IStructuredSelection)sel ).getFirstElement ();
                if ( o instanceof LoginContext )
                {
                    this.loginContext = (LoginContext)o;
                }
            }
        }

        if ( this.loginContext == null )
        {
            throw new IllegalStateException ( Messages.LoginDialog_Error_NoLoginContext );
        }

        if ( this.password == null || this.password.length () == 0 )
        {
            // set to null in case this is an empty string
            this.password = null;
            setMessage ( Messages.LoginDialog_Message_EmptyPassword, IMessageProvider.WARNING );
        }
        if ( this.user == null || this.user.length () == 0 )
        {
            // set to null in case this is an empty string
            this.user = null;
            setMessage ( Messages.LoginDialog_Message_EmptyUsername, IMessageProvider.WARNING );
        }
    }

    @Override
    protected void configureShell ( final Shell newShell )
    {
        super.configureShell ( newShell );
        newShell.setText ( Messages.LoginDialog_Shell_Text );
    }

    @Override
    protected Control createDialogArea ( final Composite parent )
    {
        final Composite wrapper = (Composite)super.createDialogArea ( parent );

        initializeDialogUnits ( wrapper );
        final Composite contents = createComposite ( wrapper );
        contents.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );
        Dialog.applyDialogFont ( wrapper );

        setTitle ( Messages.LoginDialog_Dlg_Title );

        return wrapper;
    }

    @Override
    protected Control createButtonBar ( final Composite parent )
    {
        final Control control = super.createButtonBar ( parent );

        update ();
        loadFrom ();

        return control;
    }

    private Composite createComposite ( final Composite parent )
    {
        final Composite contents = new Composite ( parent, SWT.NONE );

        contents.setLayout ( new GridLayout ( 2, false ) );

        Label label;

        // context
        label = new Label ( contents, SWT.NONE );
        label.setText ( Messages.LoginDialog_Label_Context_Text );
        this.contextSelector = new ComboViewer ( contents, SWT.READ_ONLY );
        this.contextSelector.setContentProvider ( new ArrayContentProvider () );
        this.contextSelector.setLabelProvider ( new LabelProvider () {
            @Override
            public String getText ( final Object element )
            {
                final LoginContext ctx = (LoginContext)element;
                return ctx.getName ();
            };
        } );
        this.contextSelector.setInput ( this.contexts );
        applyLayout ( this.contextSelector.getControl () );
        this.contextSelector.addSelectionChangedListener ( new ISelectionChangedListener () {

            @Override
            public void selectionChanged ( final SelectionChangedEvent event )
            {
                update ();
            }
        } );

        // username
        label = new Label ( contents, SWT.NONE );
        label.setText ( Messages.LoginDialog_Label_User_Text );
        this.userText = new Text ( contents, SWT.BORDER );
        this.userText.setMessage ( Messages.LoginDialog_Text_User_Message );
        applyLayout ( this.userText );
        this.userText.addModifyListener ( new ModifyListener () {

            @Override
            public void modifyText ( final ModifyEvent e )
            {
                update ();
            }
        } );

        // password
        label = new Label ( contents, SWT.NONE );
        label.setText ( Messages.LoginDialog_Label_Password_Text );
        this.passwordText = new Text ( contents, SWT.BORDER | SWT.PASSWORD );
        this.passwordText.setMessage ( Messages.LoginDialog_Text_Password_Message );
        applyLayout ( this.passwordText );
        this.passwordText.addModifyListener ( new ModifyListener () {

            @Override
            public void modifyText ( final ModifyEvent e )
            {
                update ();
            }
        } );

        final Button adv = new Button ( contents, SWT.CHECK );
        adv.setText ( Messages.LoginDialog_AdvancedButton_Text );
        adv.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                toggleAdvanced ( adv.getSelection () );
            }
        } );
        adv.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false, 2, 1 ) );

        this.analyzer = new ConnectionAnalyzer ( contents, SWT.NONE );
        this.analyzer.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true, 2, 1 ) );
        this.analyzer.setBackground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_RED ) );

        return contents;
    }

    protected void toggleAdvanced ( final boolean selection )
    {
        if ( selection )
        {
            openTray ( new DialogTray () {

                @Override
                protected Control createContents ( final Composite parent )
                {
                    return createAdvancedContent ( parent );
                }
            } );
        }
        else
        {
            closeTray ();
        }
    }

    private Composite createAdvancedContent ( final Composite advWrapper )
    {
        final Composite advContent = new Composite ( advWrapper, SWT.NONE );
        advContent.setLayout ( new GridLayout ( 1, false ) );

        final Button credentialsAsProperties = new Button ( advContent, SWT.CHECK );
        credentialsAsProperties.setText ( Messages.LoginDialog_CredentialsButtons_Text );
        credentialsAsProperties.setToolTipText ( Messages.LoginDialog_CredentialsButtons_ToolTip );

        credentialsAsProperties.setSelection ( this.flagCredentialsAsProperties );
        credentialsAsProperties.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                LoginDialog.this.flagCredentialsAsProperties = credentialsAsProperties.getSelection ();
            }
        } );

        return advContent;
    }

    private void applyLayout ( final Control control )
    {
        control.setLayoutData ( new GridData ( SWT.FILL, SWT.CENTER, true, false ) );
    }

    @Override
    protected void okPressed ()
    {
        startLogin ( this.loginContext );
    }

    private void startLogin ( final LoginContext loginContext )
    {
        if ( this.creator != null )
        {
            logger.error ( "Found pre-existing creator instance. This should not happen!" ); //$NON-NLS-1$
            this.creator.dispose ();
            this.creator = null;
        }

        final Button button = getButton ( OK );

        button.setEnabled ( false );
        this.contextSelector.getControl ().setEnabled ( false );
        this.userText.setEnabled ( false );
        this.passwordText.setEnabled ( false );

        // close tray ... put seats in an upright position
        if ( getTray () != null )
        {
            closeTray ();
        }

        this.analyzer.clear ();

        final Realm realm = SWTObservables.getRealm ( getShell ().getDisplay () );
        this.creator = new ContextCreator ( realm, loginContext, this.analyzer, new ContextCreatorResultListener () {

            @Override
            public void complete ( final Collection<LoginHandler> result )
            {
                handleComplete ( result );
            }
        } );

        final Map<String, String> properties = new HashMap<String, String> ();
        if ( this.flagCredentialsAsProperties )
        {
            properties.put ( ConnectionLoginFactory.OPTION_CREDENTIALS_AS_PROPERTIES, "true" ); //$NON-NLS-1$
        }

        this.creator.start ( this.userText.getText (), this.passwordText.getText (), properties );
    }

    protected void handleComplete ( final Collection<LoginHandler> result )
    {
        if ( this.creator == null )
        {
            logger.error ( "Creating is null but we got a result. This should also never happen!" ); //$NON-NLS-1$
            return;
        }

        this.creator.dispose ();
        this.creator = null;

        if ( result == null )
        {
            final Button button = getButton ( OK );
            button.setEnabled ( true );

            this.contextSelector.getControl ().setEnabled ( true );
            this.userText.setEnabled ( true );
            this.passwordText.setEnabled ( true );
        }
        else
        {
            saveTo ();
            Activator.getDefault ().setLoginSession ( this.user, this.password, this.loginContext, result );
            super.okPressed ();
        }
    }

    @Override
    protected void cancelPressed ()
    {
        if ( this.creator != null )
        {
            this.creator.dispose ();
            this.creator = null;
            // will receive result
        }
        else
        {
            super.cancelPressed ();
        }
    }
}
