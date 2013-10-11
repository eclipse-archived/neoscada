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
package org.eclipse.scada.ca.ui.importer.wizard;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.scada.ca.data.DiffEntry;
import org.eclipse.scada.ca.ui.importer.Activator;
import org.eclipse.scada.ca.ui.util.DiffController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.statushandlers.StatusManager;

public class PreviewPage extends WizardPage
{

    private final DiffController mergeController;

    private TreeViewer viewer;

    private Label statsLabel;

    public PreviewPage ( final DiffController mergeController )
    {
        super ( "previewPage" ); //$NON-NLS-1$
        setTitle ( Messages.PreviewPage_PageTitle );
        this.mergeController = mergeController;
    }

    @Override
    public void createControl ( final Composite parent )
    {
        final Composite wrapper = new Composite ( parent, SWT.NONE );
        wrapper.setLayout ( new GridLayout ( 1, false ) );

        this.viewer = new TreeViewer ( wrapper, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.VIRTUAL );
        this.viewer.getControl ().setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        final TableLayout layout = new TableLayout ();
        this.viewer.getTree ().setLayout ( layout );

        TreeViewerColumn col;
        col = new TreeViewerColumn ( this.viewer, SWT.NONE );
        col.getColumn ().setText ( Messages.PreviewPage_ColFactoryText );
        layout.addColumnData ( new ColumnWeightData ( 10 ) );
        col.setLabelProvider ( new DiffEntryLabelProvider () );

        col = new TreeViewerColumn ( this.viewer, SWT.NONE );
        col.getColumn ().setText ( Messages.PreviewPage_ColConfigurationText );
        layout.addColumnData ( new ColumnWeightData ( 20 ) );
        col.setLabelProvider ( new DiffEntryLabelProvider () );

        col = new TreeViewerColumn ( this.viewer, SWT.NONE );
        col.getColumn ().setText ( Messages.PreviewPage_ColOperationText );
        layout.addColumnData ( new ColumnWeightData ( 10 ) );
        col.setLabelProvider ( new DiffEntryLabelProvider () );

        col = new TreeViewerColumn ( this.viewer, SWT.NONE );
        col.getColumn ().setText ( Messages.PreviewPage_ColDataText );
        layout.addColumnData ( new ColumnWeightData ( 20 ) );
        col.setLabelProvider ( new DiffEntryLabelProvider () );

        col = new TreeViewerColumn ( this.viewer, SWT.NONE );
        col.getColumn ().setText ( Messages.PreviewPage_ColCurrentDataText );
        layout.addColumnData ( new ColumnWeightData ( 20 ) );
        col.setLabelProvider ( new DiffEntryLabelProvider () );

        this.viewer.getTree ().setHeaderVisible ( true );

        this.viewer.setContentProvider ( new LazyDiffEntryTreeProvider () );
        this.viewer.setUseHashlookup ( true );

        this.statsLabel = new Label ( wrapper, SWT.NONE );
        this.statsLabel.setLayoutData ( new GridData ( SWT.FILL, SWT.CENTER, true, false ) );

        setControl ( wrapper );
    }

    @Override
    public void setVisible ( final boolean visible )
    {
        super.setVisible ( visible );
        if ( visible )
        {
            try
            {
                getContainer ().run ( false, false, new IRunnableWithProgress () {

                    @Override
                    public void run ( final IProgressMonitor monitor ) throws InvocationTargetException, InterruptedException
                    {
                        setMergeResult ( PreviewPage.this.mergeController.merge ( monitor ) );
                    }
                } );
            }
            catch ( final Exception e )
            {
                final Status status = new Status ( IStatus.ERROR, Activator.PLUGIN_ID, Messages.PreviewPage_StatusErrorFailedToMerge, e );
                StatusManager.getManager ().handle ( status );
                ErrorDialog.openError ( getShell (), Messages.PreviewPage_TitleErrorFailedToMerge, Messages.PreviewPage_MessageErrorFailedToMerge, status );
            }
        }
    }

    private void setMergeResult ( final List<DiffEntry> merge )
    {
        Collections.sort ( merge, new DiffEntryComparator () );

        this.viewer.setInput ( merge );

        this.statsLabel.setText ( MessageFormat.format ( Messages.PreviewPage_StatusLabel, merge.size () ) );
    }

}
