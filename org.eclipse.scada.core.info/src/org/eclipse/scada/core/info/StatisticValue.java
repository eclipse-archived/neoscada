/*******************************************************************************
 * Copyright (c) 2006, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.info;

import org.eclipse.scada.utils.lang.Immutable;

@Immutable
public class StatisticValue
{
    private final Number minimum;

    private final Number maximum;

    private final Number current;

    public StatisticValue ( final Number minimum, final Number maximum, final Number current )
    {
        super ();
        this.minimum = minimum;
        this.maximum = maximum;
        this.current = current;
    }

    public Number getMinimum ()
    {
        return this.minimum;
    }

    public Number getMaximum ()
    {
        return this.maximum;
    }

    public Number getCurrent ()
    {
        return this.current;
    }

    @Override
    public String toString ()
    {
        return String.format ( "%s [%s-%s]", this.current, this.minimum, this.maximum );
    }

}
