/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.ui.importer.wizard;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.scada.ca.ui.util.DiffController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.TableItem;

public class IgnorePage extends WizardPage
{

    private final DiffController mergeController;

    private TableViewer factoriesViewer;

    private TreeViewer fieldsViewer;

    public IgnorePage ( final DiffController mergeController )
    {
        super ( "ignorePage" );//$NON-NLS-1$
        setTitle ( Messages.IgnorePage_Title );

        this.mergeController = mergeController;
    }

    public void createControl ( final Composite parent )
    {
        final Composite wrapper = new Composite ( parent, SWT.NONE );
        wrapper.setLayout ( new FillLayout () );

        final TabFolder folder = new TabFolder ( wrapper, SWT.TOP );

        {
            final TabItem item = new TabItem ( folder, SWT.NONE );
            item.setText ( Messages.IgnorePage_TabItem_Factories_Text );
            item.setControl ( createFactoriesTab ( folder ) );
        }

        {
            final TabItem item = new TabItem ( folder, SWT.NONE );
            item.setText ( Messages.IgnorePage_TabItem_Fields_Text );
            item.setControl ( createFieldsTab ( folder ) );
        }

        setControl ( wrapper );
    }

    @Override
    public void setVisible ( final boolean visible )
    {
        super.setVisible ( visible );

        if ( visible )
        {
            final Object[] data = this.mergeController.makeKnownFactories ().toArray ();
            this.factoriesViewer.setInput ( data );

            final Set<String> factories = this.mergeController.getIgnoreFactories ();

            // select all
            for ( final TableItem item : this.factoriesViewer.getTable ().getItems () )
            {
                item.setChecked ( factories.contains ( item.getData () ) );
            }

            // set ignore fields
            this.fieldsViewer.setInput ( this.mergeController.getIgnoreFields () );
        }
    }

    private Control createFieldsTab ( final Composite parent )
    {
        this.fieldsViewer = new TreeViewer ( parent );

        this.fieldsViewer.setContentProvider ( new ITreeContentProvider () {

            public void inputChanged ( final Viewer viewer, final Object oldInput, final Object newInput )
            {
            }

            public void dispose ()
            {
            }

            public Object[] getElements ( final Object inputElement )
            {
                return getChildren ( inputElement );
            }

            public boolean hasChildren ( final Object element )
            {
                final Object[] childs = getChildren ( element );
                if ( childs == null )
                {
                    return false;
                }
                return childs.length > 0;
            }

            public Object getParent ( final Object element )
            {
                return null;
            }

            @SuppressWarnings ( "unchecked" )
            public Object[] getChildren ( final Object parentElement )
            {
                if ( parentElement instanceof Map<?, ?> )
                {
                    return ( (Map<?, ?>)parentElement ).entrySet ().toArray ();
                }
                else if ( parentElement instanceof Map.Entry<?, ?> )
                {
                    return ( (Map.Entry<?, Collection<Object>>)parentElement ).getValue ().toArray ();
                }
                return null;
            }
        } );
        this.fieldsViewer.setInput ( this.mergeController.getIgnoreFields () );
        this.fieldsViewer.setLabelProvider ( new LabelProvider () {
            @Override
            public String getText ( final Object element )
            {
                if ( element instanceof Map.Entry<?, ?> )
                {
                    return String.format ( "%s", ( (Map.Entry<?, ?>)element ).getKey () ); //$NON-NLS-1$
                }
                return String.format ( "%s", element ); //$NON-NLS-1$
            }
        } );
        this.fieldsViewer.setAutoExpandLevel ( TreeViewer.ALL_LEVELS );

        return this.fieldsViewer.getControl ();
    }

    private Control createFactoriesTab ( final Composite parent )
    {
        final Composite wrapper = new Composite ( parent, SWT.NONE );
        wrapper.setLayout ( new GridLayout ( 1, true ) );

        this.factoriesViewer = new TableViewer ( wrapper, SWT.H_SCROLL | SWT.V_SCROLL | SWT.CHECK | SWT.BORDER );

        this.factoriesViewer.setComparator ( new ViewerComparator () );
        this.factoriesViewer.setContentProvider ( new ArrayContentProvider () );
        this.factoriesViewer.getControl ().addListener ( SWT.Selection, new Listener () {
            public void handleEvent ( final Event event )
            {
                IgnorePage.this.mergeController.setIgnoreFactories ( gatherIgnoredFactories () );
            }
        } );
        this.factoriesViewer.getControl ().setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        final Composite buttonBar = new Composite ( wrapper, SWT.NONE );
        buttonBar.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false ) );
        final RowLayout layout = new RowLayout ( SWT.HORIZONTAL );
        layout.wrap = false;
        buttonBar.setLayout ( layout );

        final Button selectButton = new Button ( buttonBar, SWT.PUSH );
        selectButton.setText ( Messages.IgnorePage_SelectAll_Text );
        selectButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                setFieldSelection ( true );
            }
        } );

        final Button deselectButton = new Button ( buttonBar, SWT.PUSH );
        deselectButton.setText ( Messages.IgnorePage_DeselectAll_Text );
        deselectButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                setFieldSelection ( false );
            }
        } );

        return wrapper;
    }

    protected void setFieldSelection ( final boolean state )
    {
        for ( final TableItem item : this.factoriesViewer.getTable ().getItems () )
        {
            item.setChecked ( state );
        }
    }

    protected Set<String> gatherIgnoredFactories ()
    {
        final Set<String> result = new HashSet<String> ();
        for ( final TableItem item : this.factoriesViewer.getTable ().getItems () )
        {
            if ( item.getChecked () )
            {
                final String data = (String)item.getData ();
                result.add ( data );
            }
        }
        return result;
    }

}
