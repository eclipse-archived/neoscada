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

import java.util.concurrent.TimeUnit;

import org.eclipse.scada.utils.beans.AbstractPropertyChange;

public class XAxis extends AbstractPropertyChange
{
    public static final String PROP_MIN = "min";

    public static final String PROP_MAX = "max";

    public static final String PROP_LABEL = "label";

    private long min;

    private long max;

    private String label;

    public String getLabel ()
    {
        return this.label;
    }

    public void setLabel ( final String label )
    {
        firePropertyChange ( PROP_LABEL, this.label, this.label = label );
    }

    public long getMin ()
    {
        return this.min;
    }

    public void setMin ( final long min )
    {
        firePropertyChange ( PROP_MIN, this.min, this.min = min );
    }

    public long getMax ()
    {
        return this.max;
    }

    public void setMax ( final long max )
    {
        firePropertyChange ( PROP_MAX, this.max, this.max = max );
    }

    public void setMinMax ( final long min, final long max )
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
        double diff = this.max - this.min;
        diff = diff * factor;

        if ( factor > 1.0 )
        {
            setMinMax ( (long) ( this.min - diff ), (long) ( this.max + diff ) );
        }
        else
        {
            setMinMax ( (long) ( this.min + diff ), (long) ( this.max - diff ) );
        }
    }

    public void transform ( final long offset, final int clientWidth )
    {
        final long diff = this.max - this.min;
        final double factor = (double)diff / (double)clientWidth;

        final long clientOffset = (long) ( offset * factor );

        setMinMax ( this.min + clientOffset, this.max + clientOffset );
    }

    public float translateToClient ( final int width, final long time )
    {
        final double diffX = this.max - this.min;
        final double factorX = width / diffX;

        return (float) ( factorX * ( time - this.min ) );
    }

    public long translateToValue ( final int width, final float position )
    {
        final double pos = position / width;

        final long diffX = this.max - this.min;

        return (long) ( diffX * pos ) + this.min;
    }

    public void setByTimespan ( final long amount, final TimeUnit timeUnit )
    {
        final long millis = timeUnit.toMillis ( amount );

        final long pos = this.min + ( this.max - this.min ) / 2;
        setMinMax ( pos - millis / 2, pos + millis / 2 );
    }

    public void shiftByTimespan ( final long duration, final TimeUnit timeUnit )
    {
        final long millis = timeUnit.toMillis ( duration );
        setMinMax ( this.min + millis, this.max + millis );
    }

    public void setNowCenter ()
    {
        setCenter ( System.currentTimeMillis () );
    }

    public void setCenter ( final long center )
    {
        final long diff = this.max - this.min;
        setMinMax ( center - diff / 2, center + diff / 2 );
    }

    /**
     * Set the start timestamp but don't change the period
     * 
     * @param milliseconds
     *            the new start timestamp
     */
    public void setStartTimestamp ( final long milliseconds )
    {
        final long diff = this.max - this.min;
        setMinMax ( milliseconds, milliseconds + diff );
    }

}
