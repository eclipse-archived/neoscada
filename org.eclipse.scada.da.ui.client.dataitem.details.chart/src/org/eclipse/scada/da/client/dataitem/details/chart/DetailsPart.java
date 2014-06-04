/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - adapt to changed interfaces of chart
 *******************************************************************************/
package org.eclipse.scada.da.client.dataitem.details.chart;

import org.eclipse.scada.chart.swt.ChartArea;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.dataitem.details.VisibilityController;
import org.eclipse.scada.da.ui.connection.data.DataItemHolder;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.model.ChartFactory;
import org.eclipse.scada.ui.chart.model.DataItemSeries;
import org.eclipse.scada.ui.chart.model.IdItem;
import org.eclipse.scada.ui.chart.model.UriItem;
import org.eclipse.scada.ui.chart.model.XAxis;
import org.eclipse.scada.ui.chart.model.YAxis;
import org.eclipse.scada.ui.chart.viewer.ChartViewer;
import org.eclipse.scada.ui.chart.viewer.CompositeExtensionSpace;
import org.eclipse.scada.ui.utils.layout.GridLayoutFactory;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.statushandlers.StatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DetailsPart implements org.eclipse.scada.da.client.dataitem.details.part.DetailsPart
{

    private final static Logger logger = LoggerFactory.getLogger ( DetailsPart.class );

    private Button startButton;

    private Composite wrapper;

    private Item item;

    private ChartViewer chart;

    private ChartArea chartArea;

    private Composite extensionSpace;

    @Override
    public void createPart ( final Composite parent )
    {
        parent.setLayout ( new FillLayout () );
        createButton ( parent );
    }

    private void createButton ( final Composite parent )
    {
        this.wrapper = new Composite ( parent, SWT.NONE );
        final GridLayout layout = new GridLayout ( 1, true );
        layout.marginHeight = layout.marginWidth = 0;
        this.wrapper.setLayout ( layout );

        this.startButton = new Button ( this.wrapper, SWT.PUSH );
        this.startButton.setLayoutData ( new GridData ( SWT.CENTER, SWT.CENTER, true, true ) );
        this.startButton.setText ( Messages.DetailsPart_startButton_label );
        this.startButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                try
                {
                    start ();
                }
                catch ( final Exception ex )
                {
                    logger.error ( "Failed to start chart", ex ); //$NON-NLS-1$
                    StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, ex ), StatusManager.BLOCK );
                }
            }
        } );
    }

    @Override
    public void dispose ()
    {
        if ( this.chartArea != null )
        {
            this.chartArea.dispose ();
            this.chartArea = null;
        }
        if ( this.chart != null )
        {
            this.chart.dispose ();
            this.chart = null;
        }
    }

    protected void start ()
    {
        this.startButton.dispose ();
        this.startButton = null;

        if ( this.item == null )
        {
            return;
        }

        org.eclipse.scada.ui.chart.model.Item item;

        switch ( this.item.getType () )
        {
            case ID:
                item = ChartFactory.eINSTANCE.createIdItem ();
                ( (IdItem)item ).setConnectionId ( this.item.getConnectionString () );
                break;
            case URI:
                item = ChartFactory.eINSTANCE.createUriItem ();
                ( (UriItem)item ).setConnectionUri ( this.item.getConnectionString () );
                break;
            default:
                return;
        }

        item.setItemId ( this.item.getId () );

        final Chart chartModel = ChartFactory.eINSTANCE.createChart ();
        chartModel.setMutable ( false );
        chartModel.setShowCurrentTimeRuler ( true );
        chartModel.setTitle ( Messages.DetailsPart_ChartModel_title );

        final XAxis x = ChartFactory.eINSTANCE.createXAxis ();
        x.setLabel ( Messages.DetailsPart_ChartModel_x_label );
        x.setFormat ( Messages.DetailsPart_ChartModel_x_format );
        x.setMinimum ( System.currentTimeMillis () );
        x.setMaximum ( System.currentTimeMillis () + 900 * 1000 );

        final YAxis y = ChartFactory.eINSTANCE.createYAxis ();
        y.setLabel ( Messages.DetailsPart_ChartModel_y_label );
        y.setMinimum ( -100.0 );
        y.setMaximum ( 100.0 );

        chartModel.getSelectedXAxis ().add ( x );
        chartModel.getSelectedYAxis ().add ( y );

        chartModel.getControllers ().add ( ChartFactory.eINSTANCE.createMouseController () );
        chartModel.getControllers ().add ( ChartFactory.eINSTANCE.createTimeNowAction () );

        final DataItemSeries dataItemSeries = ChartFactory.eINSTANCE.createDataItemSeries ();
        dataItemSeries.setX ( x );
        dataItemSeries.setY ( y );
        dataItemSeries.setLabel ( item.getItemId () );
        dataItemSeries.setItem ( item );

        chartModel.getBottom ().add ( x );
        chartModel.getLeft ().add ( y );
        chartModel.getInputs ().add ( dataItemSeries );

        this.wrapper.setLayout ( GridLayoutFactory.slimStack () );

        this.extensionSpace = new Composite ( this.wrapper, SWT.NONE );
        this.extensionSpace.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false ) );
        this.extensionSpace.setLayout ( new RowLayout ( SWT.HORIZONTAL ) );

        this.chartArea = new ChartArea ( this.wrapper, SWT.NONE );
        this.chartArea.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        this.chart = new ChartViewer ( this.chartArea.getDisplay (), this.chartArea.getChartRenderer (), chartModel, new CompositeExtensionSpace ( this.extensionSpace ), null );
        this.wrapper.layout ();
    }

    @Override
    public void setDataItem ( final DataItemHolder item )
    {
        if ( item != null )
        {
            this.item = item.getItem ();
        }
        else
        {
            this.item = null;
        }
    }

    @Override
    public void updateData ( final DataItemValue value )
    {
        // no-op
    }

    @Override
    public void setVisibilityController ( final VisibilityController visibilityController )
    {
        visibilityController.show ();
    }
}
