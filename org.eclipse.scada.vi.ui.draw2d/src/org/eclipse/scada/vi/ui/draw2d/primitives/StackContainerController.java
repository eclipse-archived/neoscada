/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - fix click issue
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d.primitives;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.scada.vi.model.Primitive;
import org.eclipse.scada.vi.model.StackContainer;
import org.eclipse.scada.vi.ui.draw2d.BasicViewElementFactory;
import org.eclipse.scada.vi.ui.draw2d.Controller;
import org.eclipse.scada.vi.ui.draw2d.SymbolController;

public class StackContainerController implements Controller
{
    private final Figure figure;

    private StackLayout layout;

    public StackContainerController ( final SymbolController controller, final StackContainer element, final BasicViewElementFactory factory ) throws Exception
    {
        this.figure = new Layer ();
        this.figure.setOpaque ( false );

        this.figure.setLayoutManager ( this.layout = new StackLayout () );

        this.layout.setObserveVisibility ( true );

        for ( final Primitive child : element.getChildren () )
        {
            final Controller elementController = factory.create ( controller, child );
            final IFigure childFigure = elementController.getFigure ();

            controller.addRawElement ( child.getName (), elementController );

            this.figure.add ( childFigure );
        }

        controller.addElement ( element, this );
    }

    @Override
    public IFigure getFigure ()
    {
        return this.figure;
    }

}
