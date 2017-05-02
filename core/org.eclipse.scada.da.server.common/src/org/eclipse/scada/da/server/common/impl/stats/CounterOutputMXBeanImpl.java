/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common.impl.stats;

public class CounterOutputMXBeanImpl implements CounterOutputMXBean
{
    private double average;

    private long total;

    @Override
    public double getAverage ()
    {
        return this.average;
    }

    public void setAverage ( final double average )
    {
        this.average = average;
    }

    @Override
    public long getTotal ()
    {
        return this.total;
    }

    public void setTotal ( final long total )
    {
        this.total = total;
    }

}
