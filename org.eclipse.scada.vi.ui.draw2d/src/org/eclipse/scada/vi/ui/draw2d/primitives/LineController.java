/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - cleanups
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d.primitives;

import org.eclipse.draw2d.PolylineShape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.vi.model.Line;
import org.eclipse.scada.vi.model.Position;
import org.eclipse.scada.vi.ui.draw2d.SymbolController;

public class LineController extends ShapeController
{
    private final PolylineShape figure;

    private PointList points;

    public LineController ( final SymbolController controller, final Line element, final ResourceManager manager )
    {
        super ( controller, manager );

        this.figure = new PolylineShape () {
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

        final PointList points = new PointList ();
        for ( final Position pos : element.getPoints () )
        {
            final Point p = new PrecisionPoint ( pos.getX (), pos.getY () );
            points.addPoint ( p );
        }
        setPoints ( points );

        controller.addElement ( element, this );

        applyCommon ( element );
    }

    public void setPoints ( final PointList points )
    {
        this.points = points;

        this.figure.setPoints ( this.points );
    }

    /**
     * Set points as string
     * <p>
     * <code>
     * 1.5;2.5|1.5;2.5
     * </code>
     * </p>
     * 
     * @param points
     */
    public void setPointsString ( final String pointsString )
    {
        final PointList pointList = new PointList ();

        final String[] points = pointsString.split ( "\\|" );
        for ( final String point : points )
        {
            final String[] toks = point.split ( ";" );
            final PrecisionPoint p = new PrecisionPoint ( Double.parseDouble ( toks[0] ), Double.parseDouble ( toks[1] ) );
            pointList.addPoint ( p );
        }
        setPoints ( pointList );
    }

    @Override
    public void setPreferredSize ( final Dimension size )
    {
        if ( size == null )
        {
            super.setPreferredSize ( this.points.getBounds ().expand ( 10, 10 ).getSize () );
        }
        else
        {
            super.setPreferredSize ( size );
        }
    }

    @Override
    public void setAntialias ( final Boolean value )
    {
        setAntialias ( value, true );
    }

    @Override
    public void setOpaque ( final Boolean flag )
    {
        setOpaque ( flag, true );
    }

    @Override
    protected PolylineShape getPropertyFigure ()
    {
        return this.figure;
    }
}
