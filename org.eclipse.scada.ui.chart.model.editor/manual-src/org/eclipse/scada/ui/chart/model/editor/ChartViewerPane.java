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
package org.eclipse.scada.ui.chart.model.editor;

import org.eclipse.scada.chart.swt.ChartArea;
import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.viewer.ChartViewer;
import org.eclipse.scada.ui.chart.viewer.CompositeExtensionSpace;
import org.eclipse.scada.ui.utils.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchPage;

public class ChartViewerPane
{
    protected ChartViewer viewer;

    private ChartArea chartArea;

    private Composite wrapper;

    private final Chart configuration;

    public ChartViewerPane ( final IWorkbenchPage page, final Chart chart )
    {
        this.configuration = chart;
    }

    public void createControl ( final Composite parent )
    {
        this.wrapper = new Composite ( parent, SWT.NONE );
        this.wrapper.setLayout ( GridLayoutFactory.slimStack () );

        final Composite extensionSpace = new Composite ( this.wrapper, SWT.NONE );
        extensionSpace.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false ) );
        extensionSpace.setLayout ( new RowLayout ( SWT.HORIZONTAL ) );
        this.chartArea = new ChartArea ( this.wrapper, SWT.NONE );
        this.chartArea.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );
        this.viewer = new ChartViewer ( this.chartArea.getDisplay (), this.chartArea.getChartRenderer (), this.configuration, new CompositeExtensionSpace ( extensionSpace ), null );

        parent.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                handleDispose ();
            }
        } );
    }

    protected void handleDispose ()
    {
        if ( this.viewer != null )
        {
            this.viewer.dispose ();
            this.viewer = null;
        }
    }

    public Control getControl ()
    {
        return this.wrapper;
    }
}
