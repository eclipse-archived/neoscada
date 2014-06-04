/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.chart.swt.controller;

import java.util.Arrays;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.chart.YAxis;

public abstract class AbstractMouseHandler
{
    private final IObservableList xAxis;

    private final IObservableList yAxis;

    public static interface AxisFunction<T>
    {
        public void process ( T axis );
    }

    public AbstractMouseHandler ( final IObservableList/*XAxis*/xAxis, final IObservableList/*YAxis*/yAxis )
    {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public AbstractMouseHandler ( final XAxis xAxis, final YAxis yAxis )
    {
        this ( Observables.staticObservableList ( Arrays.asList ( xAxis ) ), Observables.staticObservableList ( Arrays.asList ( yAxis ) ) );
    }

    protected void processX ( final AxisFunction<XAxis> func )
    {
        for ( final Object o : this.xAxis )
        {
            func.process ( (XAxis)o );
        }
    }

    protected void processY ( final AxisFunction<YAxis> func )
    {
        for ( final Object o : this.yAxis )
        {
            func.process ( (YAxis)o );
        }
    }
}
