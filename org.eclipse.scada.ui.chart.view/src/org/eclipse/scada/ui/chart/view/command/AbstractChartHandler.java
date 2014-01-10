/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.chart.view.command;

import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.scada.da.ui.connection.commands.AbstractItemHandler;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.view.AbstractChartView;
import org.eclipse.scada.ui.chart.view.TransientChartView;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

public abstract class AbstractChartHandler extends AbstractItemHandler
{

    protected void openDaChartView ( final Collection<Item> items, final Chart configuration ) throws ExecutionException
    {
        if ( items.isEmpty () )
        {
            return;
        }
        final StringBuilder sb = new StringBuilder ();
        for ( final Item item : items )
        {
            sb.append ( asSecondardId ( item ) );
        }

        IViewPart viewer;
        try
        {
            viewer = getActivePage ().showView ( TransientChartView.VIEW_ID, sb.toString (), IWorkbenchPage.VIEW_ACTIVATE );
        }
        catch ( final PartInitException e )
        {
            throw new ExecutionException ( "Failed to open view", e );
        }

        if ( viewer instanceof TransientChartView )
        {
            if ( configuration != null )
            {
                ( (TransientChartView)viewer ).setConfiguration ( configuration );
            }

            for ( final Item item : items )
            {
                ( (AbstractChartView)viewer ).addItem ( item );

            }
        }
    }

    protected void openHdChartView ( final Collection<org.eclipse.scada.hd.ui.connection.data.Item> items, final Chart configuration ) throws ExecutionException
    {
        if ( items.isEmpty () )
        {
            return;
        }
        final StringBuilder sb = new StringBuilder ();
        for ( final org.eclipse.scada.hd.ui.connection.data.Item item : items )
        {
            sb.append ( asSecondardId ( item ) );
        }

        IViewPart viewer;
        try
        {
            viewer = getActivePage ().showView ( TransientChartView.VIEW_ID, sb.toString (), IWorkbenchPage.VIEW_ACTIVATE );
        }
        catch ( final PartInitException e )
        {
            throw new ExecutionException ( "Failed to open view", e );
        }

        if ( viewer instanceof TransientChartView )
        {

            if ( configuration != null )
            {
                ( (TransientChartView)viewer ).setConfiguration ( configuration );
            }

            for ( final org.eclipse.scada.hd.ui.connection.data.Item item : items )
            {
                ( (AbstractChartView)viewer ).addItem ( item );
            }
        }

    }

    protected String asSecondardId ( final org.eclipse.scada.hd.ui.connection.data.Item item )
    {
        return item.getId ().replace ( "_", "__" ).replace ( ':', '_' );
    }

}