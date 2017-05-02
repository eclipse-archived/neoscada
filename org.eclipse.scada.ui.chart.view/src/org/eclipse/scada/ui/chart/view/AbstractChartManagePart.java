/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - allow setting the chart configuration
 *******************************************************************************/
package org.eclipse.scada.ui.chart.view;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.scada.ui.chart.viewer.ChartViewer;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

public abstract class AbstractChartManagePart extends ViewPart
{
    public abstract void setChartViewer ( ChartViewer chartViewer );

    protected void attachSelectionService ()
    {
        getViewSite ().getWorkbenchWindow ().getSelectionService ().addPostSelectionListener ( new ISelectionListener () {

            @Override
            public void selectionChanged ( final IWorkbenchPart part, final ISelection selection )
            {
                handleSelectionChanged ( selection );
            }

        } );
        handleSelectionChanged ( getViewSite ().getWorkbenchWindow ().getSelectionService ().getSelection () );
    }

    protected void handleSelectionChanged ( final ISelection sel )
    {
        if ( sel == null || sel.isEmpty () )
        {
            return;
        }
        if ( ! ( sel instanceof IStructuredSelection ) )
        {
            return;
        }

        final Object o = ( (IStructuredSelection)sel ).getFirstElement ();
        if ( ! ( o instanceof ChartViewer ) )
        {
            return;
        }

        setChartViewer ( (ChartViewer)o );
    }

}
