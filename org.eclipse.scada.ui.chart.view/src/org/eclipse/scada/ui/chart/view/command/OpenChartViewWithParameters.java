/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - change handling of invalid parameters
 *******************************************************************************/
package org.eclipse.scada.ui.chart.view.command;

import java.util.Arrays;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.connection.data.Item.Type;
import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.model.ChartFactory;
import org.eclipse.scada.ui.chart.model.Charts;
import org.eclipse.scada.ui.chart.model.CompositeArchiveQualitySeries;

/**
 * Open a chart view with parameters <br/>
 * The querySpec string format is: <code>startTimeOffset:endTimeOffset</code> or
 * <code>startTimeOffset:endTimeOffset:minValue:maxValue</code>
 */
public class OpenChartViewWithParameters extends AbstractChartHandler
{
    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        final String connectionId = event.getParameter ( "org.eclipse.scada.ui.chart.connectionId" ); //$NON-NLS-1$
        final String connectionString = event.getParameter ( "org.eclipse.scada.ui.chart.connectionString" ); //$NON-NLS-1$
        final String itemId = event.getParameter ( "org.eclipse.scada.ui.chart.itemId" ); //$NON-NLS-1$
        final String itemType = event.getParameter ( "org.eclipse.scada.ui.chart.itemType" ); //$NON-NLS-1$

        if ( connectionId == null && connectionString == null )
        {
            throw new ExecutionException ( "No connection ID or string set" );
        }
        if ( itemType == null )
        {
            throw new ExecutionException ( "Item type is not set" );
        }

        final Chart configuration = makeConfiguration ( event );

        if ( "da".equals ( itemType ) ) //$NON-NLS-1$
        {
            openDaChartView ( Arrays.asList ( new Item ( connectionId != null ? connectionId : connectionString, itemId, connectionId != null ? Type.ID : Type.URI ) ), configuration );
        }
        else if ( "hd".equals ( itemType ) ) //$NON-NLS-1$
        {
            openHdChartView ( Arrays.asList ( new org.eclipse.scada.hd.ui.connection.data.Item ( connectionId != null ? connectionId : connectionString, itemId, connectionId != null ? org.eclipse.scada.hd.ui.connection.data.Item.Type.ID : org.eclipse.scada.hd.ui.connection.data.Item.Type.URI ) ), configuration );
        }
        else
        {
            throw new ExecutionException ( String.format ( "The item type '%s' is unsupported", itemType ) );
        }

        return null;
    }

    private Chart makeConfiguration ( final ExecutionEvent event )
    {
        final String queryTimespec = event.getParameter ( "org.eclipse.scada.ui.chart.queryTimespec" ); //$NON-NLS-1$

        final Chart configuration = Charts.makeDefaultConfiguration ();

        if ( queryTimespec != null && !queryTimespec.isEmpty () )
        {
            final String toks[] = queryTimespec.split ( "[: ]+" ); //$NON-NLS-1$

            final long now = System.currentTimeMillis ();

            final int left = Integer.parseInt ( toks[0] );
            final int right = Integer.parseInt ( toks[1] );
            configuration.getSelectedXAxis ().setMinimum ( now - left );
            configuration.getSelectedXAxis ().setMaximum ( now + right );

            if ( toks.length >= 4 )
            {
                final double min = Double.parseDouble ( toks[2] );
                final double max = Double.parseDouble ( toks[3] );
                configuration.getSelectedYAxis ().setMinimum ( min );
                configuration.getSelectedYAxis ().setMaximum ( max );
            }
        }

        final CompositeArchiveQualitySeries q = ChartFactory.eINSTANCE.createCompositeArchiveQualitySeries ();
        q.setX ( configuration.getSelectedXAxis () );
        q.setY ( configuration.getSelectedYAxis () );
        q.setVisible ( true );
        q.setThreshold ( 0.75 );
        configuration.getInputs ().add ( q );

        return configuration;
    }
}
