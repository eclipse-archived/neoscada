/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - allow controlling the XY child properties
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d.primitives;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.scada.vi.model.XYChild;
import org.eclipse.scada.vi.model.XYContainer;
import org.eclipse.scada.vi.ui.draw2d.BasicViewElementFactory;
import org.eclipse.scada.vi.ui.draw2d.Controller;
import org.eclipse.scada.vi.ui.draw2d.SymbolController;

public class XYContainerController implements Controller
{
    private final Figure figure;

    public XYContainerController ( final SymbolController controller, final XYContainer element, final BasicViewElementFactory factory ) throws Exception
    {
        this.figure = new Figure ();

        this.figure.setLayoutManager ( new XYLayout () );

        for ( final XYChild child : element.getChildren () )
        {
            final Controller elementController = factory.create ( controller, child.getElement () );
            final IFigure childFigure = elementController.getFigure ();

            final Rectangle rect = factory.create ( child.getPosition (), child.getDimension () );
            controller.addRawElement ( child.getName (), new XYChildController ( childFigure, rect ) );
            this.figure.add ( childFigure, rect );
        }

        controller.addElement ( element, this );
    }

    @Override
    public IFigure getFigure ()
    {
        return this.figure;
    }

}
