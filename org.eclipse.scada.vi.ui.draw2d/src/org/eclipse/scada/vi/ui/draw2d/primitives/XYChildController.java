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
package org.eclipse.scada.vi.ui.draw2d.primitives;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.PrecisionDimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;

public class XYChildController
{
    private final Rectangle rect;

    private final IFigure figure;

    public XYChildController ( final IFigure childFigure, final Rectangle rect )
    {
        this.figure = childFigure;
        this.rect = rect;
    }

    public void setPosition ( final double x, final double y )
    {
        this.rect.setLocation ( new PrecisionPoint ( x, y ) );
        this.figure.getParent ().setConstraint ( this.figure, this.rect );
    }

    public void setDimension ( final double width, final double height )
    {
        this.rect.setSize ( new PrecisionDimension ( width, height ) );
        this.figure.getParent ().setConstraint ( this.figure, this.rect );
    }
}
