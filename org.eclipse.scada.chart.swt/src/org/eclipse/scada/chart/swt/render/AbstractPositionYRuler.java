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

import org.eclipse.scada.chart.YAxis;
import org.eclipse.scada.chart.swt.Graphics;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;

public abstract class AbstractPositionYRuler extends AbstractRuler
{

    protected YAxis axis;

    private int style;

    public AbstractPositionYRuler ( final YAxis axis, final int style )
    {
        this.axis = axis;
        this.style = style;
    }

    public void setStyle ( final int style )
    {
        this.style = style;
    }

    public void setAxis ( final YAxis axis )
    {
        this.axis = axis;
    }

    public abstract Double getPosition ();

    @Override
    protected void doRender ( final Graphics g, final Rectangle clientRectangle )
    {
        if ( this.axis == null )
        {
            return;
        }

        final Double position = getPosition ();
        if ( position == null )
        {
            return;
        }

        final int y = (int)this.axis.translateToClient ( clientRectangle.height, getPosition () );

        if ( ( this.style & SWT.TOP ) > 0 )
        {
            g.fillRectangle ( clientRectangle.x, clientRectangle.y, clientRectangle.width, y );
        }
        else if ( ( this.style & SWT.BOTTOM ) > 0 )
        {
            g.fillRectangle ( clientRectangle.x, y, clientRectangle.width, clientRectangle.height - y );
        }
        else
        {
            if ( y < 0 || y > clientRectangle.width )
            {
                return;
            }
            g.drawLine ( clientRectangle.x, clientRectangle.y + y, clientRectangle.width, clientRectangle.y + y );
        }
    }

}