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
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.vi.model.FigureContainer;
import org.eclipse.scada.vi.ui.draw2d.BasicViewElementFactory;
import org.eclipse.scada.vi.ui.draw2d.SymbolController;

public class FigureContainerController extends FigureController
{
    private final Figure figure;

    public FigureContainerController ( final SymbolController controller, final FigureContainer element, final ResourceManager manager, final BasicViewElementFactory viewElementFactory ) throws Exception
    {
        super ( controller, manager );

        this.figure = new Figure () {
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

        if ( element.getSize () != null )
        {
            final PrecisionRectangle rect = new PrecisionRectangle ();
            rect.setPreciseSize ( element.getSize ().getWidth (), element.getSize ().getHeight () );
            this.figure.setBounds ( rect );
        }

        controller.addElement ( element, this );

        this.figure.setLayoutManager ( new StackLayout () );
        this.figure.add ( viewElementFactory.create ( controller, element.getContent () ).getFigure () );

        applyCommon ( element );
    }

    @Override
    public void setOpaque ( final Boolean flag )
    {
        setOpaque ( flag, false );
    }

    @Override
    public Figure getPropertyFigure ()
    {
        return this.figure;
    }
}
