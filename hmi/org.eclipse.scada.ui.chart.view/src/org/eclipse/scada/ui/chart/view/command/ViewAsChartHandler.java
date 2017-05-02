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
package org.eclipse.scada.ui.chart.view.command;

import java.util.List;
import java.util.UUID;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.ui.chart.configuration.Charts;
import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.view.ChartView;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.utils.SelectionHelper;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

public class ViewAsChartHandler extends AbstractSelectionHandler
{

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        // get the items first, the creation of the view will change the selection
        final List<Item> daItems = SelectionHelper.list ( getSelection (), Item.class );
        final List<org.eclipse.scada.hd.ui.connection.data.Item> hdItems = SelectionHelper.list ( getSelection (), org.eclipse.scada.hd.ui.connection.data.Item.class );

        final String secondaryId = UUID.randomUUID ().toString ();

        final IViewPart viewer;
        try
        {
            viewer = getWorkbenchWindow ().getActivePage ().showView ( ChartView.VIEW_ID, secondaryId, IWorkbenchPage.VIEW_ACTIVATE );
        }
        catch ( final PartInitException e )
        {
            throw new ExecutionException ( "Failed to open chart view", e );
        }

        if ( viewer instanceof ChartView )
        {
            final Chart cfg = ( (ChartView)viewer ).getConfiguration ();

            for ( final Item item : daItems )
            {
                Charts.addItem ( cfg, item );
            }
            for ( final org.eclipse.scada.hd.ui.connection.data.Item item : hdItems )
            {
                Charts.addItem ( cfg, item );
            }

            if ( !hdItems.isEmpty () )
            {
                Charts.addCompositeQuality ( cfg );
            }
        }

        return null;
    }
}
