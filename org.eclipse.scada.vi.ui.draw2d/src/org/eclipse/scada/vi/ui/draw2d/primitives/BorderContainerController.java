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

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.scada.vi.model.Alignment;
import org.eclipse.scada.vi.model.BorderChild;
import org.eclipse.scada.vi.model.BorderContainer;
import org.eclipse.scada.vi.ui.draw2d.BasicViewElementFactory;
import org.eclipse.scada.vi.ui.draw2d.Controller;
import org.eclipse.scada.vi.ui.draw2d.SymbolController;

public class BorderContainerController implements Controller
{
    private final Figure figure;

    private BorderLayout layout;

    public BorderContainerController ( final SymbolController controller, final BorderContainer element, final BasicViewElementFactory factory ) throws Exception
    {
        this.figure = new Figure ();

        this.figure.setLayoutManager ( this.layout = new BorderLayout () );

        this.layout.setHorizontalSpacing ( element.getHorizontalSpacing () );
        this.layout.setVerticalSpacing ( element.getVerticalSpacing () );

        for ( final BorderChild child : element.getChildren () )
        {
            final Controller elementController = factory.create ( controller, child.getElement () );
            final IFigure childFigure = elementController.getFigure ();

            controller.addRawElement ( child.getName (), new BorderChildController ( childFigure ) );

            this.figure.add ( childFigure, convert ( child.getAlignment () ) );
        }

        controller.addElement ( element, this );
    }

    public static Object convert ( final Alignment alignment )
    {
        switch ( alignment )
        {
            case BOTTOM:
                return BorderLayout.BOTTOM;
            case TOP:
                return BorderLayout.TOP;
            case CENTER:
                return BorderLayout.CENTER;
            case LEFT:
                return BorderLayout.LEFT;
            case RIGHT:
                return BorderLayout.RIGHT;
            default:
                return null;
        }
    }

    @Override
    public IFigure getFigure ()
    {
        return this.figure;
    }

}
