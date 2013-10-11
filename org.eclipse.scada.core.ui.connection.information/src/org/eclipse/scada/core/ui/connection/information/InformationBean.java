/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.information;

import org.eclipse.scada.core.info.StatisticEntry;
import org.eclipse.scada.utils.beans.AbstractPropertyChange;

public class InformationBean extends AbstractPropertyChange implements Comparable<InformationBean>
{
    public static final String PROP_LABEL = "label";

    public static final String PROP_VALUE = "value";

    public static final String PROP_MIN = "min";

    public static final String PROP_MAX = "max";

    private String label;

    private Number value;

    private Number min;

    private Number max;

    public String getLabel ()
    {
        return this.label;
    }

    public void setLabel ( final String label )
    {
        firePropertyChange ( PROP_LABEL, this.label, this.label = label );
    }

    public Number getValue ()
    {
        return this.value;
    }

    public void setValue ( final Number value )
    {
        firePropertyChange ( PROP_VALUE, this.value, this.value = value );
    }

    public void update ( final StatisticEntry entry )
    {
        setLabel ( entry.getLabel () );
        if ( entry.getValue () != null )
        {
            setValue ( entry.getValue ().getCurrent () );
            setMin ( entry.getValue ().getMinimum () );
            setMax ( entry.getValue ().getMaximum () );
        }
    }

    public Number getMin ()
    {
        return this.min;
    }

    public void setMin ( final Number min )
    {
        firePropertyChange ( PROP_MIN, this.min, this.min = min );
    }

    public Number getMax ()
    {
        return this.max;
    }

    public void setMax ( final Number max )
    {
        firePropertyChange ( PROP_MAX, this.max, this.max = max );
    }

    @Override
    public int compareTo ( final InformationBean o )
    {
        return this.label.compareTo ( o.getLabel () );
    }
}
