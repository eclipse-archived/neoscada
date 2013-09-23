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

public abstract class FunctionSeriesData extends AbstractFunctionSeriesData
{

    public FunctionSeriesData ( final Realm realm, final XAxis xAxis, final YAxis yAxis )
    {
        super ( realm, xAxis, yAxis );
        this.request = new Request ( xAxis.getMin (), xAxis.getMax (), 1 );
    }

    @Override
    public SeriesViewData getViewData ()
    {
        return makeData ( this.request );
    }
}
