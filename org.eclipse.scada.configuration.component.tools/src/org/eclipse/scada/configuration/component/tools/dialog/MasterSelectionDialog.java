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
package org.eclipse.scada.configuration.component.tools.dialog;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.infrastructure.SystemNode;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.configuration.infrastructure.provider.InfrastructureItemProviderAdapterFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class MasterSelectionDialog extends TitleAreaDialog
{
    private final World world;

    private final WritableValue masterValue = new WritableValue ();

    private Button replace;

    private boolean replaceValue;

    public MasterSelectionDialog ( final Shell parentShell, final World world )
    {
        super ( parentShell );
        this.world = world;
        setHelpAvailable ( false );
    }

    public MasterServer getMaster ()
    {
        final Object value = this.masterValue.getValue ();
        if ( value instanceof MasterServer )
        {
            return (MasterServer)value;
        }
        else
        {
            return null;
        }
    }

    @Override
    protected Control createDialogArea ( final Composite parent )
    {
        setTitle ( "Select master server" );
        setMessage ( "Choose a master server from the world model" );

        final Composite composite = (Composite)super.createDialogArea ( parent );

        final Composite wrapper = new Composite ( composite, SWT.NONE );
        wrapper.setLayout ( new GridLayout ( 1, true ) );
        wrapper.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        final ObservablesManager mgr = new ObservablesManager ();

        final TreeViewer viewer = new TreeViewer ( wrapper );
        viewer.setAutoExpandLevel ( 2 );
        viewer.getControl ().setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true, 1, 1 ) );
        viewer.addDoubleClickListener ( new IDoubleClickListener () {

            @Override
            public void doubleClick ( final DoubleClickEvent event )
            {
                handleDoubleClick ();
            }
        } );

        final Button add = new Button ( wrapper, SWT.RADIO );
        add.setText ( "Add master server" );
        add.setToolTipText ( "Assign the component to the selected master server in addition" );

        this.replace = new Button ( wrapper, SWT.RADIO );
        this.replace.setText ( "Replace all master servers" );
        this.replace.setToolTipText ( "Assign the component soley to the selected master server" );
        this.replace.setSelection ( true );

        mgr.runAndCollect ( new Runnable () {

            @Override
            public void run ()
            {
                createDataModel ( viewer );
            }
        } );

        return composite;
    }

    public boolean isReplace ()
    {
        return this.replaceValue;
    }

    protected void handleDoubleClick ()
    {
        if ( getMaster () != null )
        {
            setReturnCode ( OK );
            close ();
        }
    }

    @Override
    protected void okPressed ()
    {
        this.replaceValue = this.replace.getSelection ();
        super.okPressed ();
    }

    protected void createDataModel ( final TreeViewer viewer )
    {
        final DataBindingContext dbc = new DataBindingContext ();

        final IObservableFactory listFactory = new IObservableFactory () {

            @Override
            public IObservable createObservable ( final Object target )
            {
                if ( target instanceof IObservableList )
                {
                    return (IObservableList)target;
                }

                else if ( target instanceof World )
                {
                    return EMFObservables.observeList ( (EObject)target, InfrastructurePackage.Literals.WORLD__NODES );
                }
                else if ( target instanceof SystemNode )
                {
                    return EMFObservables.observeList ( (EObject)target, InfrastructurePackage.Literals.SYSTEM_NODE__MASTERS );
                }

                return null;
            }
        };

        final AdapterFactory adapterFactory = new InfrastructureItemProviderAdapterFactory ();
        final AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider ( adapterFactory );

        final ObservableListTreeContentProvider cp = new ObservableListTreeContentProvider ( listFactory, null );
        viewer.setContentProvider ( cp );
        viewer.setLabelProvider ( labelProvider );

        viewer.setInput ( EMFObservables.observeList ( this.world, InfrastructurePackage.Literals.WORLD__NODES ) );

        viewer.setFilters ( new ViewerFilter[] { new ViewerFilter () {

            @Override
            public boolean select ( final Viewer viewer, final Object parentElement, final Object element )
            {
                // filter out everything we are not interested in
                return element instanceof SystemNode || element instanceof MasterServer;
            }
        } } );

        dbc.bindValue ( ViewersObservables.observeSingleSelection ( viewer ), this.masterValue );
        this.masterValue.addValueChangeListener ( new IValueChangeListener () {

            @Override
            public void handleValueChange ( final ValueChangeEvent event )
            {
                update ();
            }
        } );

        viewer.getControl ().addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                dbc.dispose ();
            }
        } );
    }

    @Override
    protected Control createContents ( final Composite parent )
    {
        final Control result = super.createContents ( parent );
        update ();
        return result;
    }

    private void update ()
    {
        final Button button = getButton ( OK );
        if ( button == null )
        {
            // too early
            return;
        }
        button.setEnabled ( getMaster () != null );
    }

}
