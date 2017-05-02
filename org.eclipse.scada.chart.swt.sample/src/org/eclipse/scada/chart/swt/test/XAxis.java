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

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.chart.swt.Helper;
import org.eclipse.scada.chart.swt.Helper.Entry;

public class XAxis
{
    protected static void test ( final TimeUnit unit, final int diff, final int pixels, final int labelSize )
    {
        final long max = System.currentTimeMillis ();
        final long min = max - unit.toMillis ( diff );

        final int nticks = pixels / labelSize;

        final long range = max - min;
        final long step = (long)Helper.niceNum ( range / ( nticks - 1 ), true );

        final long graphmin = (long) ( Math.floor ( min / step ) * step );
        final long graphmax = (long) ( Math.ceil ( max / step ) * step );

        final List<Entry<Long>> values = Helper.chartTimes ( min, max, 1320, 100, Helper.makeFormat ( range ) );

        System.out.println ( "Range: " + range );
        System.out.println ( "Step: " + step );

        System.out.println ( String.format ( "%1$tF %1$tT.%1$TL", new Date ( graphmin ) ) );
        System.out.println ( String.format ( "%1$tF %1$tT.%1$TL", new Date ( graphmax ) ) );

        for ( int i = 0; i < values.size (); i++ )
        {
            System.out.print ( i + " -> " + values.get ( i ) );
            System.out.println ();
        }
    }

    public static void main ( final String[] args )
    {
        test ( TimeUnit.HOURS, 1, 1320, 80 );
    }

}
