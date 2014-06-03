/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - bug fixes and enhancements
 *******************************************************************************/
package org.eclipse.scada.vi.ui.chart.draw2d;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.vi.chart.model.ChartView;
import org.eclipse.scada.vi.ui.draw2d.ErrorFigure;
import org.eclipse.scada.vi.ui.draw2d.SymbolController;
import org.eclipse.scada.vi.ui.draw2d.primitives.FigureController;
import org.eclipse.swt.widgets.Display;

public class ChartController extends FigureController
{
    private final ChartFigure figure;

    private final Figure wrapperFigure;

    private final ErrorFigure errorFigure;

    public ChartController ( final SymbolController symbolController, final ResourceManager resourceManager, final ChartView view )
    {
        super ( symbolController, resourceManager );

        this.wrapperFigure = new Figure () {
            @Override
            public void addNotify ()
            {
                super.addNotify ();
                start ();
            }

            @Override
            public void removeNotify ()
            {
                stop ();
                super.removeNotify ();
            }
        };

        this.wrapperFigure.setOpaque ( false );
        this.figure = new ChartFigure ( Display.getCurrent (), resourceManager );

        this.wrapperFigure.setLayoutManager ( new StackLayout () );
        this.wrapperFigure.add ( this.figure );
        this.errorFigure = new ErrorFigure ();

        symbolController.addElement ( view, this );

        applyCommon ( view );
    }

    protected void applyCommon ( final ChartView view )
    {
        setChartConfigurationUri ( view.getConfigurationUri () );
        super.applyCommon ( view );
    }

    public void setChartConfigurationUri ( final String configurationUri )
    {
        if ( this.wrapperFigure.getChildren ().contains ( this.errorFigure ) )
        {
            this.wrapperFigure.remove ( this.errorFigure );
        }

        if ( this.figure != null && configurationUri != null )
        {
            try
            {
                this.figure.setConfiguration ( ChartHelper.loadConfiguraton ( configurationUri ) );
            }
            catch ( final Exception e )
            {
                this.wrapperFigure.add ( this.errorFigure );
                this.errorFigure.setException ( e );
            }
        }
    }

    @Override
    public IFigure getPropertyFigure ()
    {
        return this.figure;
    }

    @Override
    public IFigure getFigure ()
    {
        return this.wrapperFigure;
    }

    @Override
    public void setOpaque ( final Boolean flag )
    {
        setOpaque ( flag, false );
    }

}
