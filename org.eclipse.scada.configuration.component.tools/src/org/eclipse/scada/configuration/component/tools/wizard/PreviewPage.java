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
package org.eclipse.scada.configuration.component.tools.wizard;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.scada.configuration.component.ExternalValue;
import org.eclipse.scada.configuration.component.provider.ComponentItemProviderAdapterFactory;
import org.eclipse.scada.ui.utils.SelectionHelper;
import org.eclipse.scada.utils.ExceptionHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public class PreviewPage extends WizardPage
{
    private static class Entry
    {
        private final ExternalValue item;

        private final String newName;

        private final Exception exception;

        public Entry ( final ExternalValue item, final String newName )
        {
            this.item = item;
            this.newName = newName;
            this.exception = null;
        }

        public Entry ( final ExternalValue item, final Exception e )
        {
            this.item = item;
            this.newName = null;
            this.exception = e;
        }

        public String getNewName ()
        {
            return this.newName;
        }

        public ExternalValue getItem ()
        {
            return this.item;
        }

        public Exception getException ()
        {
            return this.exception;
        }
    }

    private final ScriptPage scriptPage;

    private final IStructuredSelection selection;

    private TableViewer viewer;

    private AdapterFactoryLabelProvider labelProvider;

    public PreviewPage ( final ScriptPage scriptPage, final IStructuredSelection selection )
    {
        super ( "preview" );
        this.scriptPage = scriptPage;
        this.selection = selection;
    }

    @Override
    public void dispose ()
    {
        super.dispose ();
        this.labelProvider.dispose ();
    }

    @Override
    public void createControl ( final Composite parent )
    {
        setTitle ( "Preview result" );
        setMessage ( "Check the result" );

        this.viewer = new TableViewer ( parent, SWT.FULL_SELECTION | SWT.BORDER );
        this.viewer.getControl ().setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );
        setControl ( this.viewer.getControl () );

        this.viewer.getTable ().setHeaderVisible ( true );

        this.viewer.setContentProvider ( new ArrayContentProvider () );

        final AdapterFactory adapterFactory = new ComponentItemProviderAdapterFactory ();
        this.labelProvider = new AdapterFactoryLabelProvider ( adapterFactory );

        final TableLayout layout = new TableLayout ();
        this.viewer.getTable ().setLayout ( layout );

        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            layout.addColumnData ( new ColumnWeightData ( 10 ) );
            col.getColumn ().setText ( "Item" );
            col.setLabelProvider ( new CellLabelProvider () {

                @Override
                public void update ( final ViewerCell cell )
                {
                    cell.setText ( PreviewPage.this.labelProvider.getText ( ( (Entry)cell.getElement () ).getItem () ) );
                    cell.setImage ( PreviewPage.this.labelProvider.getImage ( ( (Entry)cell.getElement () ).getItem () ) );
                }
            } );
        }
        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            layout.addColumnData ( new ColumnWeightData ( 10 ) );

            col.getColumn ().setText ( "Old name" );
            col.setLabelProvider ( new CellLabelProvider () {

                @Override
                public void update ( final ViewerCell cell )
                {
                    cell.setText ( ( (Entry)cell.getElement () ).getItem ().getSourceName () );
                }
            } );
        }
        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            layout.addColumnData ( new ColumnWeightData ( 10 ) );

            col.getColumn ().setText ( "Result" );
            col.setLabelProvider ( new CellLabelProvider () {

                @Override
                public void update ( final ViewerCell cell )
                {
                    renderResult ( cell, (Entry)cell.getElement () );
                }
            } );
        }
    }

    protected void renderResult ( final ViewerCell cell, final Entry element )
    {
        if ( element.getException () != null )
        {
            cell.setText ( ExceptionHelper.getMessage ( element.getException () ) );
            cell.setImage ( JFaceResources.getImage ( Dialog.DLG_IMG_MESSAGE_ERROR ) );
        }
        else
        {
            cell.setText ( element.getNewName () );
            cell.setImage ( null );
        }
    }

    public void refresh ()
    {
        final List<Entry> entries = new LinkedList<> ();
        for ( final ExternalValue v : SelectionHelper.iterable ( this.selection, ExternalValue.class ) )
        {
            entries.add ( eval ( v ) );
        }
        this.viewer.setInput ( entries.toArray () );
    }

    private Entry eval ( final ExternalValue v )
    {
        try
        {
            return new Entry ( v, convert ( v ) );
        }
        catch ( final Exception e )
        {
            return new Entry ( v, e );
        }
    }

    private String convert ( final ExternalValue v ) throws Exception
    {
        return SetExternalNameWizard.evalName ( this.scriptPage.getScript (), v );
    }

    @Override
    public void setVisible ( final boolean visible )
    {
        super.setVisible ( visible );
        if ( visible )
        {
            refresh ();
        }
    }
}
