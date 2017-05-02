/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.ui.views;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.QueryState;
import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hd.data.ValueInformation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class QueryDataView extends QueryViewPart implements QueryListener
{
    private static final int FIX_FRONT_COLS = 3;

    private final Map<String, TableColumn> columns = new HashMap<String, TableColumn> ();

    private TableColumn indexCol;

    private Table table;

    private Color invalidColor;

    private String[] colNames;

    private TableColumn qualityCol;

    private TableColumn manualCol;

    private TableColumn infoCol;

    private TableColumn countCol;

    @Override
    public void createPartControl ( final Composite parent )
    {
        addListener ();

        parent.setLayout ( new FillLayout () );
        this.table = new Table ( parent, SWT.FULL_SELECTION );
        this.table.setHeaderVisible ( true );

        this.indexCol = new TableColumn ( this.table, SWT.NONE );
        this.indexCol.setText ( Messages.QueryDataView_ColIndex );
        this.indexCol.setWidth ( 50 );

        this.qualityCol = new TableColumn ( this.table, SWT.NONE );
        this.qualityCol.setText ( Messages.QueryDataView_ColQuality );
        this.qualityCol.setWidth ( 75 );

        this.manualCol = new TableColumn ( this.table, SWT.NONE );
        this.manualCol.setText ( Messages.QueryDataView_ColManual );
        this.manualCol.setWidth ( 75 );

        this.invalidColor = JFaceColors.getErrorBackground ( getDisplay () );
    }

    @Override
    public void setFocus ()
    {
        this.table.setFocus ();
    }

    @Override
    protected void clear ()
    {
        clearDataSize ();
        super.clear ();
    }

    @Override
    public void updateData ( final int index, final Map<String, List<Double>> values, final List<ValueInformation> valueInformation )
    {
        getDisplay ().asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                handleUpdateData ( index, values, valueInformation );
            }
        } );
    }

    private void handleUpdateData ( final int index, final Map<String, List<Double>> values, final List<ValueInformation> valueInformation )
    {
        // FIXME: implement faster
        final int len = valueInformation.size ();
        for ( int i = 0; i < len; i++ )
        {
            final TableItem item = this.table.getItem ( i + index );

            final double quality = valueInformation.get ( i ).getQuality ();
            final double manual = valueInformation.get ( i ).getManualPercentage ();

            item.setText ( 0, String.format ( Messages.QueryDataView_Format_Index, index + i ) );
            item.setText ( 1, String.format ( Messages.QueryDataView_Format_Quality, quality ) );
            item.setText ( 2, String.format ( Messages.QueryDataView_Format_Manual, manual ) );

            for ( int j = 0; j < this.colNames.length; j++ )
            {
                final List<Double> value = values.get ( this.colNames[j] );
                item.setText ( j + FIX_FRONT_COLS, getValueString ( value.get ( i ) ) );
            }

            item.setText ( this.colNames.length + FIX_FRONT_COLS, "" + valueInformation.get ( i ).getSourceValues () ); //$NON-NLS-1$
            item.setText ( this.colNames.length + FIX_FRONT_COLS + 1, String.format ( Messages.QueryDataView_InfoFormat, valueInformation.get ( i ).getStartTimestamp (), valueInformation.get ( i ).getEndTimestamp () ) );

            if ( quality < 0.33 )
            {
                item.setBackground ( this.invalidColor );
            }
            else
            {
                item.setBackground ( null );
            }

        }
    }

    private String getValueString ( final Double value )
    {
        if ( value.isInfinite () )
        {
            return Messages.QueryDataView_Infinity;
        }
        else if ( value.isNaN () )
        {
            return Messages.QueryDataView_NaN;
        }
        return String.format ( Messages.QueryDataView_Format_Value, value );
    }

    protected Display getDisplay ()
    {
        try
        {
            return getSite ().getShell ().getDisplay ();
        }
        catch ( final Throwable e )
        {
            return null;
        }
    }

    @Override
    public void updateParameters ( final QueryParameters parameters, final Set<String> valueTypes )
    {
        getDisplay ().asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                setDataSize ( parameters.getNumberOfEntries (), valueTypes );
            }
        } );
    }

    private void setDataSize ( final int entries, final Set<String> valueTypes )
    {
        clearDataSize ();

        this.colNames = valueTypes.toArray ( new String[0] );
        for ( final String valueType : valueTypes )
        {
            final TableColumn col = new TableColumn ( this.table, SWT.NONE );
            col.setText ( valueType );
            col.setWidth ( 100 );
            col.setAlignment ( SWT.RIGHT );
            this.columns.put ( valueType, col );
        }

        this.countCol = new TableColumn ( this.table, SWT.NONE );
        this.countCol.setText ( Messages.QueryDataView_ColValues );
        this.countCol.setWidth ( 40 );

        this.infoCol = new TableColumn ( this.table, SWT.NONE );
        this.infoCol.setText ( Messages.QueryDataView_ColInfo );
        this.infoCol.setWidth ( 150 );

        this.table.clearAll ();
        this.table.setItemCount ( entries );

        for ( int i = 0; i < entries; i++ )
        {
            final TableItem item = this.table.getItem ( i );
            item.setBackground ( this.invalidColor );
            item.setText ( 0, String.format ( Messages.QueryDataView_Format_Index, i ) );
        }
    }

    private void clearDataSize ()
    {
        this.table.clearAll ();

        for ( final TableColumn col : this.columns.values () )
        {
            col.dispose ();
        }
        this.columns.clear ();

        if ( this.countCol != null )
        {
            this.countCol.dispose ();
            this.countCol = null;
        }

        if ( this.infoCol != null )
        {
            this.infoCol.dispose ();
            this.infoCol = null;
        }
    }

    @Override
    public void updateState ( final QueryState state )
    {
    }

}
