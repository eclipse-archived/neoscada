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
package org.eclipse.scada.core.ui.connection.wizards;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.jface.databinding.viewers.ObservableSetContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.scada.core.ui.connection.Activator;
import org.eclipse.scada.core.ui.connection.ConnectionStore;
import org.eclipse.scada.core.ui.connection.views.ConnectionLabelProvider;
import org.eclipse.scada.ui.utils.SelectionHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class SelectConnectionStorePage extends WizardPage
{
    private TableViewer tableViewer;

    private IObservableSet stores;

    protected SelectConnectionStorePage ()
    {
        super ( "selectConnectionStore" ); //$NON-NLS-1$
        setTitle ( "Select store" );
        setDescription ( "The connection will be added to the selected store" );
    }

    @Override
    public void createControl ( final Composite parent )
    {
        // stores must not be disposed!
        this.stores = Activator.getDefault ().getStoresSet ();

        this.tableViewer = new TableViewer ( parent );
        setControl ( this.tableViewer.getControl () );
        this.tableViewer.setContentProvider ( new ObservableSetContentProvider () );
        this.tableViewer.setLabelProvider ( new ConnectionLabelProvider () );
        this.tableViewer.setInput ( this.stores );

        this.tableViewer.addSelectionChangedListener ( new ISelectionChangedListener () {

            @Override
            public void selectionChanged ( final SelectionChangedEvent event )
            {
                update ();
            }
        } );

        update ();
    }

    private void update ()
    {
        final ConnectionStore store = getStore ();

        if ( store == null )
        {
            setMessage ( "A connection store has to be selected to which the connection should be added", SWT.ERROR );
        }
        else
        {
            setMessage ( null );
        }

        setPageComplete ( store != null );
    }

    public ConnectionStore getStore ()
    {
        return SelectionHelper.first ( this.tableViewer.getSelection (), ConnectionStore.class );
    }
}
