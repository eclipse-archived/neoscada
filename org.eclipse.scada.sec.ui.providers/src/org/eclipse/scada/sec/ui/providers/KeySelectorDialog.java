/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *     IBH SYSTEMS GmbH - use new selection helper
 *******************************************************************************/
package org.eclipse.scada.sec.ui.providers;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.scada.sec.ui.DisplayCallbackHandler;
import org.eclipse.scada.sec.ui.providers.internal.Activator;
import org.eclipse.scada.ui.utils.SelectionHelper;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;

public class KeySelectorDialog extends TitleAreaDialog
{

    private final class ButtonUpdater implements IValueChangeListener
    {
        @Override
        public void handleValueChange ( final ValueChangeEvent event )
        {
            updateButtons ();
        }
    }

    private KeyTreeViewer viewer;

    private KeyFactoryManager manager;

    private final String title;

    private final String defaultMessage;

    private Key selectedKey;

    private IObservableValue lockedKeyObs;

    private Button unlockButton;

    private Locked lockable;

    private KeyInformation keyInformation;

    private final Integer maximumTimeout;

    private Spinner spinner;

    private Label spinnerLabel;

    private Button spinnerCheck;

    public KeySelectorDialog ( final Shell parentShell, final String title, final String defaultMessage, final Integer maximumTimeoutMinutes )
    {
        super ( parentShell );
        this.title = title;
        this.defaultMessage = defaultMessage;
        this.maximumTimeout = maximumTimeoutMinutes;
    }

    @Override
    protected boolean isResizable ()
    {
        return true;
    }

    @Override
    protected Control createDialogArea ( final Composite parent )
    {
        final Composite composite = (Composite)super.createDialogArea ( parent );

        getShell ().setText ( this.title );
        setTitle ( this.title );
        setMessage ( this.defaultMessage );

        this.manager = new KeyFactoryManager ( SWTObservables.getRealm ( parent.getDisplay () ) );

        this.viewer = new KeyTreeViewer ( composite );
        this.viewer.setInput ( this.manager );

        this.viewer.getTreeViewer ().addSelectionChangedListener ( new ISelectionChangedListener () {

            @Override
            public void selectionChanged ( final SelectionChangedEvent event )
            {
                update ( event.getSelection () );
            }
        } );

        this.viewer.getControl ().addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                handleDispose ();
            }
        } );
        this.viewer.getControl ().setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        if ( isDefaultAllowed () )
        {
            final Composite spinnerWrapper = new Composite ( composite, SWT.NONE );
            spinnerWrapper.setLayout ( new GridLayout ( 3, false ) );

            this.spinnerCheck = new Button ( spinnerWrapper, SWT.CHECK );
            this.spinnerCheck.setText ( Messages.KeySelectorDialog_Remember_Text );
            this.spinnerCheck.addSelectionListener ( new SelectionAdapter () {
                @Override
                public void widgetSelected ( final SelectionEvent e )
                {
                    updateSpinnerSelection ();
                };
            } );
            this.spinnerCheck.setLayoutData ( new GridData ( SWT.FILL, SWT.CENTER, false, true ) );

            this.spinner = new Spinner ( spinnerWrapper, SWT.BORDER );
            this.spinner.setMinimum ( 0 );
            this.spinner.setMaximum ( this.maximumTimeout );
            this.spinner.setLayoutData ( new GridData ( SWT.FILL, SWT.CENTER, false, true ) );

            this.spinnerLabel = new Label ( spinnerWrapper, SWT.NONE );
            this.spinnerLabel.setText ( Messages.KeySelectorDialog_RememberLabel_Text_Minutes );
            this.spinnerLabel.setLayoutData ( new GridData ( SWT.FILL, SWT.CENTER, false, true ) );

            this.spinner.addSelectionListener ( new SelectionAdapter () {
                @Override
                public void widgetSelected ( final SelectionEvent e )
                {
                    updateSpinnerSelection ();
                }
            } );
        }

        updateSpinnerSelection ();

        return composite;
    }

    private boolean isDefaultAllowed ()
    {
        if ( this.maximumTimeout == null )
        {
            return false;
        }
        return this.maximumTimeout > 0;
    }

    protected void updateSpinnerSelection ()
    {
        this.spinner.setEnabled ( this.spinnerCheck.getSelection () );
        final int selection = this.spinner.getSelection ();
        if ( selection <= 0 )
        {
            this.spinnerLabel.setText ( Messages.KeySelectorDialog_RememberLabel_Text_Forever );
        }
        else if ( selection == 1 )
        {
            this.spinnerLabel.setText ( Messages.KeySelectorDialog_RememberLabel_Text_Minute );
        }
        else
        {
            this.spinnerLabel.setText ( Messages.KeySelectorDialog_RememberLabel_Text_Minutes );
        }
    }

    @Override
    protected void createButtonsForButtonBar ( final Composite parent )
    {
        super.createButtonsForButtonBar ( parent );

        this.unlockButton = createButton ( parent, IDialogConstants.INTERNAL_ID, Messages.KeySelectorDialog_ButtonUnlock_Text, false );
    }

    @Override
    protected void buttonPressed ( final int buttonId )
    {
        if ( buttonId == IDialogConstants.INTERNAL_ID )
        {
            performUnlock ( this.lockable );
        }
        super.buttonPressed ( buttonId );
    }

    private void performUnlock ( final Locked locked )
    {
        try
        {
            locked.unlock ( new DisplayCallbackHandler ( getShell (), Messages.KeySelectorDialog_Callback_Title, Messages.KeySelectorDialog_Callback_Description ) );
        }
        catch ( final Exception e )
        {
            ErrorDialog.openError ( getShell (), Messages.KeySelectorDialog_Error_Title, Messages.KeySelectorDialog_Error_Text, StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }
    }

    @Override
    protected Control createButtonBar ( final Composite parent )
    {
        final Control result = super.createButtonBar ( parent );

        // disable the OK button for now
        update ( StructuredSelection.EMPTY );

        return result;
    }

    protected void update ( final ISelection selection )
    {
        if ( this.lockedKeyObs != null )
        {
            this.lockedKeyObs.dispose ();
        }

        this.selectedKey = SelectionHelper.first ( selection, Key.class );
        this.lockable = SelectionHelper.first ( selection, Locked.class );

        if ( this.lockable != null )
        {
            this.lockedKeyObs = BeansObservables.observeValue ( this.lockable, Locked.PROP_LOCKED );
            this.lockedKeyObs.addValueChangeListener ( new ButtonUpdater () );
        }

        updateButtons ();
    }

    protected void updateButtons ()
    {
        final Button ok = getButton ( IDialogConstants.OK_ID );
        if ( ok != null )
        {
            ok.setEnabled ( hasKeySelected () );
        }
        this.unlockButton.setEnabled ( this.lockable != null && this.lockable.isLocked () );
    }

    private boolean hasKeySelected ()
    {
        return this.selectedKey != null && !this.selectedKey.isLocked ();
    }

    protected void handleDispose ()
    {
        this.viewer.dispose ();
        this.manager.dispose ();
    }

    public KeyInformation getKeyInformation ()
    {
        return this.keyInformation;
    }

    @Override
    protected void okPressed ()
    {
        if ( this.selectedKey != null )
        {
            this.keyInformation = new KeyInformation ( this.selectedKey.getName (), this.selectedKey.getKey (), this.selectedKey.getCertificate () );
        }
        else
        {
            this.keyInformation = null;
        }

        if ( this.spinner != null && this.spinnerCheck != null && this.spinnerCheck.getSelection () )
        {
            KeyInstanceManager.getInstance ( getShell ().getDisplay () ).setDefaultKey ( this.keyInformation, this.spinner.getSelection () * 60 * 1000 );
        }

        super.okPressed ();
    }
}
