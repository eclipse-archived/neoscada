/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - added RoundedRectangleController
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d.primitives;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.vi.model.RoundedRectangle;
import org.eclipse.scada.vi.ui.draw2d.SymbolController;

public class RoundedRectangleController extends ShapeController
{
    private final org.eclipse.draw2d.RoundedRectangle figure;

    public RoundedRectangleController ( final SymbolController controller, final RoundedRectangle element, final ResourceManager manager )
    {
        super ( controller, manager );

        this.figure = new org.eclipse.draw2d.RoundedRectangle () {
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

        if ( element.getCorner () != null )
        {
            setCorner ( Double.valueOf ( Math.round ( element.getCorner ().getWidth () ) ).intValue (), Double.valueOf ( Math.round ( element.getCorner ().getWidth () ) ).intValue () );
        }
        else
        {
            setCorner ( 0, 0 );
        }

        controller.addElement ( element, this );

        applyCommon ( element );
    }

    private void setCorner ( int width, int height )
    {
        this.figure.setCornerDimensions ( new Dimension ( width, height ) );
    }

    @Override
    public void setOpaque ( final Boolean flag )
    {
        setOpaque ( flag, true );
    }

    @Override
    public void setAntialias ( final Boolean value )
    {
        setAntialias ( value, false );
    }

    @Override
    protected org.eclipse.draw2d.RoundedRectangle getPropertyFigure ()
    {
        return this.figure;
    }
}
