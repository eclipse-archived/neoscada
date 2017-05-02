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
package org.eclipse.scada.chart.swt.render;

import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.chart.swt.Graphics;
import org.eclipse.swt.graphics.Rectangle;

public abstract class AbstractPositionXRuler extends AbstractRuler
{
    public abstract Long getPosition ();

    protected XAxis axis;

    public AbstractPositionXRuler ( final XAxis axis )
    {
        this.axis = axis;
    }

    public void setAxis ( final XAxis axis )
    {
        this.axis = axis;
    }

    @Override
    protected void doRender ( final Graphics g, final Rectangle clientRectangle )
    {
        if ( this.axis == null )
        {
            return;
        }

        final Long position = getPosition ();

        if ( position == null )
        {
            return;
        }

        final int x = (int)this.axis.translateToClient ( clientRectangle.width, position );

        if ( x < 0 || x > clientRectangle.width )
        {
            return;
        }

        g.drawLine ( clientRectangle.x + x, clientRectangle.y, clientRectangle.x + x, clientRectangle.y + clientRectangle.height );
    }

}