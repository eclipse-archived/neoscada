/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d.primitives;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.scada.vi.model.GridAlignment;
import org.eclipse.scada.vi.model.GridChild;
import org.eclipse.scada.vi.model.GridContainer;
import org.eclipse.scada.vi.ui.draw2d.BasicViewElementFactory;
import org.eclipse.scada.vi.ui.draw2d.Controller;
import org.eclipse.scada.vi.ui.draw2d.SymbolController;

public class GridContainerController implements Controller
{
    private final Figure figure;

    public GridContainerController ( final SymbolController controller, final GridContainer element, final BasicViewElementFactory factory ) throws Exception
    {
        this.figure = new Figure ();

        final GridLayout gridLayout = new GridLayout ( element.getColumns (), element.isEqualWidth () );
        gridLayout.horizontalSpacing = element.getHorizontalSpacing ();
        gridLayout.verticalSpacing = element.getVerticalSpacing ();
        gridLayout.marginHeight = element.getMarginHeight ();
        gridLayout.marginWidth = element.getMarginWidth ();

        this.figure.setLayoutManager ( gridLayout );

        for ( final GridChild child : element.getChildren () )
        {
            final Controller elementController = factory.create ( controller, child.getElement () );
            final IFigure childFigure = elementController.getFigure ();
            this.figure.add ( childFigure, convert ( child ) );
        }

        controller.addElement ( element, this );
    }

    private Object convert ( final GridChild child )
    {
        final GridData gd = new GridData ();

        gd.horizontalAlignment = convert ( child.getHorizontalAlignment () );
        gd.verticalAlignment = convert ( child.getVerticalAlignment () );
        gd.grabExcessHorizontalSpace = child.isGrabHorizontalSpace ();
        gd.grabExcessVerticalSpace = child.isGrabVerticalSpace ();
        gd.horizontalSpan = child.getSpanCols ();
        gd.verticalSpan = child.getSpanRows ();
        if ( child.getWidthHint () != null )
        {
            gd.widthHint = child.getWidthHint ();
        }
        if ( child.getHeightHint () != null )
        {
            gd.heightHint = child.getHeightHint ();
        }

        return gd;
    }

    private int convert ( final GridAlignment alignment )
    {
        switch ( alignment )
        {
            case BEGINNING:
                return GridData.BEGINNING;
            case END:
                return GridData.END;
            case CENTER:
                return GridData.CENTER;
            case FILL:
                return GridData.FILL;
            default:
                return GridData.BEGINNING;
        }
    }

    @Override
    public IFigure getFigure ()
    {
        return this.figure;
    }

}
