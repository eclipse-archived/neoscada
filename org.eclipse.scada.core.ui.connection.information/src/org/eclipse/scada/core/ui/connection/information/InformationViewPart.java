/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.information;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.databinding.viewers.ObservableSetTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.scada.core.connection.provider.info.ConnectionInformationProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.ViewPart;

public class InformationViewPart extends ViewPart
{

    private ConnectionInformationList list;

    private TreeViewer viewer;

    @Override
    public void createPartControl ( final Composite parent )
    {
        this.list = new ConnectionInformationList ();

        parent.setLayout ( new FillLayout () );

        this.viewer = new TreeViewer ( parent, SWT.FULL_SELECTION );

        this.viewer.getTree ().setHeaderVisible ( true );

        final TableLayout layout = new TableLayout ();
        this.viewer.getTree ().setLayout ( layout );

        final ObservableSetTreeContentProvider contentProvider = new ObservableSetTreeContentProvider ( new IObservableFactory () {

            @Override
            public IObservable createObservable ( final Object target )
            {
                if ( target instanceof IObservable )
                {
                    return (IObservable)target;
                }
                else if ( target instanceof ConnectionInformationProvider )
                {
                    return new ConnectionInformationWrapper ( (ConnectionInformationProvider)target );
                }
                return null;
            }
        }, new TreeStructureAdvisor () {} );

        {
            final TreeViewerColumn col = new TreeViewerColumn ( this.viewer, SWT.NONE );
            col.setLabelProvider ( new LabelProvider ( contentProvider.getRealizedElements () ) );
            layout.addColumnData ( new ColumnWeightData ( 100 ) );
        }
        {
            final TreeViewerColumn col = new TreeViewerColumn ( this.viewer, SWT.NONE );
            col.setLabelProvider ( new LabelProvider ( contentProvider.getRealizedElements () ) );
            layout.addColumnData ( new ColumnWeightData ( 50 ) );
            col.getColumn ().setText ( "Current" );
        }
        {
            final TreeViewerColumn col = new TreeViewerColumn ( this.viewer, SWT.NONE );
            col.setLabelProvider ( new LabelProvider ( contentProvider.getRealizedElements () ) );
            layout.addColumnData ( new ColumnWeightData ( 50 ) );
            col.getColumn ().setText ( "Min" );
        }
        {
            final TreeViewerColumn col = new TreeViewerColumn ( this.viewer, SWT.NONE );
            col.setLabelProvider ( new LabelProvider ( contentProvider.getRealizedElements () ) );
            layout.addColumnData ( new ColumnWeightData ( 50 ) );
            col.getColumn ().setText ( "Max" );
        }

        this.viewer.setContentProvider ( contentProvider );
        this.viewer.setInput ( this.list.getList () );
        this.viewer.setComparator ( new InformationBeanComparator () );

        getViewSite ().setSelectionProvider ( this.viewer );
        hookContextMenu ( getViewSite () );
    }

    private void hookContextMenu ( final IViewSite viewSite )
    {
        final MenuManager menuMgr = new MenuManager ( "#PopupMenu" ); //$NON-NLS-1$
        menuMgr.setRemoveAllWhenShown ( true );
        menuMgr.addMenuListener ( new IMenuListener () {
            @Override
            public void menuAboutToShow ( final IMenuManager manager )
            {
                fillContextMenu ( manager );
            }
        } );
        final Menu menu = menuMgr.createContextMenu ( this.viewer.getControl () );
        this.viewer.getControl ().setMenu ( menu );
        viewSite.registerContextMenu ( menuMgr, this.viewer );
    }

    private void fillContextMenu ( final IMenuManager manager )
    {
        manager.add ( new Separator ( IWorkbenchActionConstants.MB_ADDITIONS ) );
    }

    @Override
    public void setFocus ()
    {
        this.viewer.getControl ().setFocus ();
    }

    @Override
    public void dispose ()
    {
        this.list.dispose ();
        super.dispose ();
    }

}
