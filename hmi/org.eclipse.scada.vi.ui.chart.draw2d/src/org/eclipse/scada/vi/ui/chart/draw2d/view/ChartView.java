/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - additional work
 *******************************************************************************/
package org.eclipse.scada.vi.ui.chart.draw2d.view;

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.chart.swt.ChartArea;
import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.selector.ChartInputSelector;
import org.eclipse.scada.ui.chart.viewer.ChartViewer;
import org.eclipse.scada.ui.chart.viewer.CompositeExtensionSpace;
import org.eclipse.scada.ui.chart.viewer.ResetHandler;
import org.eclipse.scada.ui.utils.layout.GridLayoutFactory;
import org.eclipse.scada.vi.ui.chart.draw2d.ChartHelper;
import org.eclipse.scada.vi.ui.user.viewer.AbstractViewInstance;
import org.eclipse.scada.vi.ui.user.viewer.ViewInstanceDescriptor;
import org.eclipse.scada.vi.ui.user.viewer.ViewManagerContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.services.IEvaluationService;

public class ChartView extends AbstractViewInstance
{
    private ChartViewer chart;

    private final Composite viewHolder;

    private ChartArea chartArea;

    private final boolean showSelector;

    private SashForm wrapper;

    private Chart configuration;

    private ChartInputSelector selector;

    private final ViewManagerContext viewManagerContext;

    public ChartView ( final ViewManagerContext viewManagerContext, final ResourceManager manager, final ViewInstanceDescriptor descriptor, final Composite viewHolder, final IEvaluationService evaluationService, final boolean showSelector )
    {
        super ( viewManagerContext, descriptor, evaluationService );
        this.showSelector = showSelector;
        this.viewHolder = viewHolder;
        this.viewManagerContext = viewManagerContext;
    }

    @Override
    public void setFocus ()
    {
        this.chartArea.setFocus ();
    }

    @Override
    public Control getControl ()
    {
        return this.wrapper;
    }

    @Override
    protected void activateView ()
    {
        if ( this.chart != null )
        {
            return;
        }

        this.wrapper = new SashForm ( this.viewHolder, SWT.HORIZONTAL );
        this.wrapper.setLayout ( new FillLayout ( SWT.HORIZONTAL ) );

        final Composite subWrapper = new Composite ( this.wrapper, SWT.NONE );
        subWrapper.setLayout ( GridLayoutFactory.slimStack () );
        final Composite extensionSpace = new Composite ( subWrapper, SWT.NONE );
        extensionSpace.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false ) );
        extensionSpace.setLayout ( new RowLayout ( SWT.HORIZONTAL ) );

        this.chartArea = new ChartArea ( subWrapper, SWT.NONE );
        this.chartArea.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        this.configuration = ChartHelper.loadConfiguraton ( this.descriptor.getUri ().toString () );
        this.chart = new ChartViewer ( this.chartArea.getDisplay (), this.chartArea.getChartRenderer (), this.configuration, new CompositeExtensionSpace ( extensionSpace ), new ResetHandler () {

            @Override
            public void reset ()
            {
                reload ();
            }
        } );

        if ( this.showSelector )
        {
            this.selector = new ChartInputSelector ( this.wrapper, this.chart, true );
            this.wrapper.setWeights ( new int[] { 85, 15 } );
        }

        this.viewManagerContext.setSelectionProvider ( this.chart );
        this.chart.setFocus ();
    }

    @Override
    protected void deactivateView ()
    {
        this.viewManagerContext.setSelectionProvider ( null );

        if ( this.chart != null )
        {
            this.chart.dispose ();
            this.chart = null;
        }
        if ( this.chartArea != null )
        {
            this.chartArea.dispose ();
            this.chartArea = null;
        }
        if ( this.selector != null )
        {
            this.selector.dispose ();
            this.selector = null;
        }
        if ( this.wrapper != null )
        {
            this.wrapper.dispose ();
            this.wrapper = null;
        }
    }

}
