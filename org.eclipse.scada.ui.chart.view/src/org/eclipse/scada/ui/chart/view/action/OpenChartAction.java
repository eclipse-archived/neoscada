/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.chart.view.action;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.connection.data.ItemSelectionHelper;
import org.eclipse.scada.ui.chart.view.Activator;
import org.eclipse.scada.ui.chart.view.ChartView;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenChartAction implements IViewActionDelegate, IObjectActionDelegate
{

    private final static Logger logger = LoggerFactory.getLogger ( OpenChartAction.class );

    private IWorkbenchPartSite site = null;

    private IStructuredSelection selection = null;

    @Override
    public void init ( final IViewPart view )
    {
        this.site = view.getSite ();
    }

    @Override
    public void run ( final IAction action )
    {
        if ( this.selection == null )
        {
            return;
        }

        final StringBuilder sb = new StringBuilder ();

        for ( final Item item : ItemSelectionHelper.getSelection ( this.selection ) )
        {
            sb.append ( item.getId () );
        }

        String secondaryId = sb.toString ();
        secondaryId = secondaryId.replace ( "_", "__" ); //$NON-NLS-1$ //$NON-NLS-2$
        secondaryId = secondaryId.replace ( ":", "_" ); //$NON-NLS-1$ //$NON-NLS-2$

        try
        {
            final IViewPart viewer = this.site.getPage ().showView ( ChartView.VIEW_ID, secondaryId, IWorkbenchPage.VIEW_ACTIVATE );

            for ( final Item item : ItemSelectionHelper.getSelection ( this.selection ) )
            {
                if ( viewer instanceof ChartView )
                {
                    ( (ChartView)viewer ).addItem ( item );
                }
            }

        }
        catch ( final PartInitException e )
        {
            logger.error ( "Failed to create view", e ); //$NON-NLS-1$
            Activator.getDefault ().getLog ().log ( e.getStatus () );
        }
        catch ( final Exception e )
        {
            logger.error ( "Failed to create view", e ); //$NON-NLS-1$
            Activator.getDefault ().getLog ().log ( new Status ( IStatus.ERROR, Activator.PLUGIN_ID, 1, "Failed to create chart view", e ) );
        }

    }

    @Override
    public void selectionChanged ( final IAction action, final ISelection selection )
    {
        if ( selection instanceof IStructuredSelection )
        {
            this.selection = (IStructuredSelection)selection;
        }
        else
        {
            this.selection = null;
        }
    }

    @Override
    public void setActivePart ( final IAction action, final IWorkbenchPart targetPart )
    {
        this.site = targetPart.getSite ();
    }

}
