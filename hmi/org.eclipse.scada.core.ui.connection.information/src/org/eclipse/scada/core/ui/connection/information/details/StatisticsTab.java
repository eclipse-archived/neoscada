/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.information.details;

import org.eclipse.jface.databinding.viewers.ObservableSetContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.eclipse.scada.core.connection.provider.info.ConnectionInformationProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.scada.core.ui.connection.information.ConnectionInformationWrapper;
import org.eclipse.scada.core.ui.connection.information.InformationBeanComparator;
import org.eclipse.scada.core.ui.connection.information.LabelProvider;

public class StatisticsTab implements DetailsTab
{

    private TabItem item;

    private ConnectionInformationWrapper wrapper;

    private Object provider;

    private TableViewer viewer;

    private ObservableSetContentProvider contentProvider;

    @Override
    public void setSelection ( final ConnectionService connectionService )
    {
        if ( connectionService instanceof ConnectionInformationProvider )
        {
            setProvider ( (ConnectionInformationProvider)connectionService );
        }
    }

    private void setProvider ( final ConnectionInformationProvider provider )
    {
        if ( this.wrapper != null )
        {
            this.viewer.setInput ( null );
            this.wrapper.dispose ();
            this.wrapper = null;
        }
        this.provider = provider;
        if ( this.provider != null )
        {
            this.wrapper = new ConnectionInformationWrapper ( provider );

            this.viewer.setInput ( this.wrapper );
        }
    }

    protected void handleDispose ()
    {
        setProvider ( null );
    }

    @Override
    public void createTab ( final TabFolder tabFolder )
    {
        this.item = new TabItem ( tabFolder, SWT.NONE );
        this.item.setText ( Messages.StatisticsTab_TabItem_Label );
        this.item.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                handleDispose ();
            }
        } );

        this.viewer = new TableViewer ( tabFolder, SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL );
        this.contentProvider = new ObservableSetContentProvider ();
        this.viewer.setContentProvider ( this.contentProvider );

        this.viewer.getTable ().setHeaderVisible ( true );

        final TableLayout layout = new TableLayout ();
        this.viewer.getTable ().setLayout ( layout );

        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.setLabelProvider ( new LabelProvider ( this.contentProvider.getRealizedElements () ) );
            layout.addColumnData ( new ColumnWeightData ( 100 ) );
        }
        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.setLabelProvider ( new LabelProvider ( this.contentProvider.getRealizedElements () ) );
            layout.addColumnData ( new ColumnWeightData ( 50 ) );
            col.getColumn ().setText ( Messages.StatisticsTab_Col_Current_Label );
        }
        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.setLabelProvider ( new LabelProvider ( this.contentProvider.getRealizedElements () ) );
            layout.addColumnData ( new ColumnWeightData ( 50 ) );
            col.getColumn ().setText ( Messages.StatisticsTab_Col_Min_Label );
        }
        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.setLabelProvider ( new LabelProvider ( this.contentProvider.getRealizedElements () ) );
            layout.addColumnData ( new ColumnWeightData ( 50 ) );
            col.getColumn ().setText ( Messages.StatisticsTab_Col_Max_Label );
        }

        this.viewer.setComparator ( new InformationBeanComparator () );

        this.item.setControl ( this.viewer.getControl () );
    }

}
