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
package org.eclipse.scada.chart.swt.test;

import java.util.List;

import org.eclipse.scada.chart.swt.Helper;
import org.eclipse.scada.chart.swt.Helper.Entry;

public class YAxis
{
    public static void main ( final String[] args )
    {
        final List<Entry<Double>> values = Helper.chartValues ( -10, 100, 1320, 30 );
        for ( int i = 0; i < values.size (); i++ )
        {
            System.out.println ( i + " -> " + values.get ( i ) );
        }
    }

}
