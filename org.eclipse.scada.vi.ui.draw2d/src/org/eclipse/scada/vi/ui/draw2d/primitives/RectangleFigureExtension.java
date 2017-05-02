/*******************************************************************************
 * Copyright (c) 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d.primitives;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Rectangle;

public class RectangleFigureExtension extends Shape
{
    /**
     * 
     */
    private final ShapeController controller;

    /**
     * @param rectangleController
     */
    public RectangleFigureExtension ( final ShapeController controller )
    {
        this.controller = controller;
    }

    /**
     * @see Shape#fillShape(Graphics)
     */
    @Override
    protected void fillShape ( final Graphics graphics )
    {
        graphics.fillRectangle ( getBounds () );
    }

    /**
     * @see Shape#outlineShape(Graphics)
     */
    @Override
    protected void outlineShape ( final Graphics graphics )
    {
        final float lineInset = Math.max ( 1.0f, getLineWidthFloat () ) / 2.0f;
        final int inset1 = (int)Math.floor ( lineInset );
        final int inset2 = (int)Math.ceil ( lineInset );

        final Rectangle r = Rectangle.SINGLETON.setBounds ( getBounds () );
        r.x += inset1;
        r.y += inset1;
        r.width -= inset1 + inset2;
        r.height -= inset1 + inset2;

        graphics.drawRectangle ( r );
    }

    @Override
    public void addNotify ()
    {
        super.addNotify ();
        this.controller.start ();
    }

    @Override
    public void removeNotify ()
    {
        this.controller.stop ();
        super.removeNotify ();
    }
}