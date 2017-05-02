/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.exporter.http;

import java.io.Serializable;
import java.util.Date;

public class DataPoint implements Serializable
{
    private static final long serialVersionUID = -3829410505213908520L;

    private Date timestamp;

    private Double value;

    private Double quality;

    private Double manual;

    public DataPoint ()
    {
    }

    public Date getTimestamp ()
    {
        return this.timestamp;
    }

    public void setTimestamp ( final Date timestamp )
    {
        this.timestamp = timestamp;
    }

    public Double getValue ()
    {
        return this.value;
    }

    public void setValue ( final Double value )
    {
        this.value = value;
    }

    public Double getQuality ()
    {
        return this.quality;
    }

    public void setQuality ( final Double quality )
    {
        this.quality = quality;
    }

    public Double getManual ()
    {
        return this.manual;
    }

    public void setManual ( final Double manual )
    {
        this.manual = manual;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.manual == null ? 0 : this.manual.hashCode () );
        result = prime * result + ( this.quality == null ? 0 : this.quality.hashCode () );
        result = prime * result + ( this.timestamp == null ? 0 : this.timestamp.hashCode () );
        result = prime * result + ( this.value == null ? 0 : this.value.hashCode () );
        return result;
    }

    @Override
    public boolean equals ( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( getClass () != obj.getClass () )
        {
            return false;
        }
        final DataPoint other = (DataPoint)obj;
        if ( this.manual == null )
        {
            if ( other.manual != null )
            {
                return false;
            }
        }
        else if ( !this.manual.equals ( other.manual ) )
        {
            return false;
        }
        if ( this.quality == null )
        {
            if ( other.quality != null )
            {
                return false;
            }
        }
        else if ( !this.quality.equals ( other.quality ) )
        {
            return false;
        }
        if ( this.timestamp == null )
        {
            if ( other.timestamp != null )
            {
                return false;
            }
        }
        else if ( !this.timestamp.equals ( other.timestamp ) )
        {
            return false;
        }
        if ( this.value == null )
        {
            if ( other.value != null )
            {
                return false;
            }
        }
        else if ( !this.value.equals ( other.value ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString ()
    {
        return "DataPoint [manual=" + this.manual + ", quality=" + this.quality + ", timestamp=" + this.timestamp + ", value=" + this.value + "]";
    }
}
