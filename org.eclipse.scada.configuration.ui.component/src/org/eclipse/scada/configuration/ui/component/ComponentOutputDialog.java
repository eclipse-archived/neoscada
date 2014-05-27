/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.ui.component;

import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.databinding.viewers.ObservableSetTreeContentProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.scada.configuration.ui.component.Helper.ItemEntry;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.ui.databinding.ObservableMapStyledCellLabelProvider;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;
import org.eclipse.scada.utils.str.StringHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class ComponentOutputDialog extends Dialog
{

    private TreeViewer viewer;

    private final IObservableSet input;

    private ObservableSetTreeContentProvider contentProvider;

    protected ComponentOutputDialog ( final IShellProvider parentShell, final IObservableSet input )
    {
        super ( parentShell );
        this.input = input;
        setBlockOnOpen ( false );
    }

    public ComponentOutputDialog ( final Shell parentShell, final IObservableSet input )
    {
        super ( parentShell );
        this.input = input;
        setBlockOnOpen ( false );
    }

    @Override
    protected void createButtonsForButtonBar ( final Composite parent )
    {
        createButton ( parent, IDialogConstants.CLOSE_ID, IDialogConstants.CLOSE_LABEL, true );
    }

    @Override
    protected boolean isResizable ()
    {
        return true;
    }

    @Override
    protected IDialogSettings getDialogBoundsSettings ()
    {
        return DialogSettings.getOrCreateSection ( Activator.getDefault ().getDialogSettings (), "componentOutputDialog" ); //$NON-NLS-1$
    }

    @Override
    protected void buttonPressed ( final int buttonId )
    {
        okPressed (); // we always simply close
    }

    @Override
    protected Control createDialogArea ( final Composite parent )
    {
        getShell ().setText ( "Component Output" );

        final Composite composite = (Composite)super.createDialogArea ( parent );

        composite.setLayout ( new FillLayout () );

        final TableLayout layout = new TableLayout ();

        this.viewer = new TreeViewer ( composite, SWT.FULL_SELECTION | SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL );
        this.viewer.setAutoExpandLevel ( 2 );
        this.viewer.getTree ().setHeaderVisible ( true );
        this.viewer.getTree ().setLayout ( layout );

        this.viewer.setContentProvider ( this.contentProvider = new ObservableSetTreeContentProvider ( new ComponentOutputObservableFactory (), null ) );

        {
            final TreeViewerColumn col1 = new TreeViewerColumn ( this.viewer, SWT.NONE );
            col1.getColumn ().setText ( "Name" );
            col1.setLabelProvider ( new NameLabelProvider ( getShell ().getDisplay (), this.contentProvider.getKnownElements () ) );
            layout.addColumnData ( new ColumnWeightData ( 100 ) );
        }

        {
            final IObservableMap map = PojoProperties.value ( "item" ).observeDetail ( this.contentProvider.getKnownElements () );
            final IObservableMap map2 = EMFProperties.value ( OsgiPackage.Literals.ITEM__NAME ).observeDetail ( map );

            final TreeViewerColumn col2 = new TreeViewerColumn ( this.viewer, SWT.NONE );
            col2.getColumn ().setText ( "Item ID" );
            col2.setLabelProvider ( new ObservableMapStyledCellLabelProvider ( map2 ) );
            layout.addColumnData ( new ColumnWeightData ( 100 ) );
        }

        {
            final IObservableMap map = PojoProperties.value ( "item" ).observeDetail ( this.contentProvider.getKnownElements () ); //$NON-NLS-1$
            final IObservableMap map2 = EMFProperties.value ( OsgiPackage.Literals.ITEM__INFORMATION ).observeDetail ( map );
            final IObservableMap map3 = EMFProperties.value ( OsgiPackage.Literals.ITEM_INFORMATION__DESCRIPTION ).observeDetail ( map2 );

            final TreeViewerColumn col2 = new TreeViewerColumn ( this.viewer, SWT.NONE );
            col2.getColumn ().setText ( "Description" );
            col2.setLabelProvider ( new ObservableMapStyledCellLabelProvider ( map3 ) );
            layout.addColumnData ( new ColumnWeightData ( 200 ) );
        }

        {
            final IObservableMap map = PojoProperties.value ( "item" ).observeDetail ( this.contentProvider.getKnownElements () ); //$NON-NLS-1$

            final TreeViewerColumn col2 = new TreeViewerColumn ( this.viewer, SWT.NONE );
            col2.getColumn ().setText ( "Type" );
            col2.setLabelProvider ( new ObservableMapStyledCellLabelProvider ( map ) {
                @Override
                public void update ( final ViewerCell cell )
                {
                    final Object element = cell.getElement ();
                    final Item value = (Item)this.attributeMaps[0].get ( element );
                    if ( value == null )
                    {
                        return;
                    }

                    final StyledString s = new StyledString ();
                    s.append ( value.eClass ().getName () );

                    s.append ( String.format ( " (%s)", value.eClass ().getEPackage ().getName () ), StyledString.QUALIFIER_STYLER ); //$NON-NLS-1$

                    cell.setText ( s.getString () );
                    cell.setStyleRanges ( s.getStyleRanges () );
                }
            } );
            layout.addColumnData ( new ColumnWeightData ( 50 ) );
        }

        this.viewer.getControl ().addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                handleDispose ();
            }
        } );
        this.viewer.setComparator ( new ViewerComparator () {
            @Override
            public int compare ( final Viewer viewer, final Object e1, final Object e2 )
            {
                final ItemEntry i1 = AdapterHelper.adapt ( e1, ItemEntry.class );
                final ItemEntry i2 = AdapterHelper.adapt ( e2, ItemEntry.class );
                if ( i1 == i2 )
                {
                    return 0;
                }
                if ( i1 == null )
                {
                    return -1;
                }
                return StringHelper.join ( i1.getLocal (), "." ).compareTo ( StringHelper.join ( i2.getLocal (), "." ) ); //$NON-NLS-1$ //$NON-NLS-2$
            };
        } );
        this.viewer.setInput ( this.input );

        return composite;
    }

    protected void handleDispose ()
    {
        this.contentProvider.dispose ();

        this.input.dispose ();
    }
}
