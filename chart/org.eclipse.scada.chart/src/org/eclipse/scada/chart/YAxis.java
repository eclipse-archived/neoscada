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
package org.eclipse.scada.chart;

import org.eclipse.scada.utils.beans.AbstractPropertyChange;

public class YAxis extends AbstractPropertyChange
{
    public static final String PROP_MIN = "min";

    public static final String PROP_MAX = "max";

    public static final String PROP_LABEL = "label";

    private double min;

    private double max;

    private String label;

    public String getLabel ()
    {
        return this.label;
    }

    public void setLabel ( final String label )
    {
        firePropertyChange ( PROP_LABEL, this.label, this.label = label );
    }

    public double getMin ()
    {
        return this.min;
    }

    public void setMin ( final double min )
    {
        firePropertyChange ( PROP_MIN, this.min, this.min = min );
    }

    public double getMax ()
    {
        return this.max;
    }

    public void setMax ( final double max )
    {
        firePropertyChange ( PROP_MAX, this.max, this.max = max );
    }

    public void setMinMax ( final double min, final double max )
    {
        if ( min >= max )
        {
            return;
        }

        setMin ( min );
        setMax ( max );
    }

    public void zoom ( final double factor )
    {
        final double diff = ( this.max - this.min ) * factor;

        if ( factor > 1.0 )
        {
            setMinMax ( this.min - diff, this.max + diff );
        }
        else
        {
            setMinMax ( this.min + diff, this.max - diff );
        }
    }

    public void transform ( final double offset, final int clientHeight )
    {
        final double diff = this.max - this.min;
        final double factor = diff / clientHeight;

        final double clientOffset = offset * factor;

        setMinMax ( this.min - clientOffset, this.max - clientOffset );
    }

    public float translateToClient ( final int height, final double value )
    {
        final double diffY = this.max - this.min;
        final double factorY = height / diffY;

        return (float) ( height - factorY * ( value - this.min ) );

    }

    public double translateToValue ( final int height, final float position )
    {
        final double pos = 1.0 - position / height;

        final double diffX = this.max - this.min;

        return diffX * pos + this.min;
    }

}
