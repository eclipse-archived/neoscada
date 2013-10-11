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

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.vi.ui.draw2d.SymbolController;

public class EllipseController extends ShapeController
{
    private final Ellipse figure;

    public EllipseController ( final SymbolController controller, final org.eclipse.scada.vi.model.Ellipse element, final ResourceManager manager )
    {
        super ( controller, manager );
        final PrecisionRectangle rect = new PrecisionRectangle ();
        if ( element.getSize () != null )
        {
            rect.setPreciseSize ( element.getSize ().getWidth (), element.getSize ().getHeight () );
        }
        this.figure = new Ellipse () {
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
        this.figure.setBounds ( rect );

        controller.addElement ( element, this );

        applyCommon ( element );
    }

    @Override
    public void setOpaque ( final Boolean flag )
    {
        setOpaque ( flag, true );
    }

    @Override
    public void setAntialias ( final Boolean value )
    {
        setAntialias ( value, true );
    }

    @Override
    public Shape getPropertyFigure ()
    {
        return this.figure;
    }
}
