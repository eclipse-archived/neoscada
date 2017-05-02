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

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.vi.model.Shape;
import org.eclipse.scada.vi.ui.draw2d.SymbolController;
import org.eclipse.swt.SWT;

public abstract class ShapeController extends FigureController
{

    public ShapeController ( final SymbolController controller, final ResourceManager manager )
    {
        super ( controller, manager );
    }

    protected void applyCommon ( final Shape element )
    {
        super.applyCommon ( element );

        setLineWidth ( element.getLineWidth () );
        setAntialias ( element.getAntialias () );
        setAlpha ( element.getAlpha () );
        setFill ( element.isFill () );
        setOutline ( element.isOutline () );
    }

    public void setOutline ( final boolean flag )
    {
        getPropertyFigure ().setOutline ( flag );
    }

    public void setAlpha ( final Double alpha )
    {
        if ( alpha != null )
        {
            getPropertyFigure ().setAlpha ( (int) ( Math.max ( 0.0, Math.min ( 1.0, alpha ) ) * 255.0 ) );
        }
        else
        {
            getPropertyFigure ().setAlpha ( null );
        }
    }

    public void setLineWidth ( final float width )
    {
        getPropertyFigure ().setLineWidthFloat ( width );
    }

    public void setFill ( final boolean state )
    {
        getPropertyFigure ().setFill ( state );
    }

    protected void setAntialias ( final Boolean value, final boolean defaultValue )
    {
        if ( value == null )
        {
            getPropertyFigure ().setAntialias ( defaultValue ? SWT.ON : SWT.OFF );
        }
        else
        {
            getPropertyFigure ().setAntialias ( value ? SWT.ON : SWT.OFF );
        }
    }

    public abstract void setAntialias ( Boolean value );

    @Override
    protected abstract org.eclipse.draw2d.Shape getPropertyFigure ();

}