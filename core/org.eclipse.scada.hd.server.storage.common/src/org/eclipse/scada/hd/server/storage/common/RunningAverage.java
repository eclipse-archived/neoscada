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
package org.eclipse.scada.hd.server.storage.common;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

// for calculation use algorithm found at 
// http://en.wikipedia.org/wiki/Algorithms_for_calculating_variance#Weighted_incremental_algorithm
//
// which is
//
// def weighted_incremental_variance(dataWeightPairs):
//     sumweight = 0
//     mean = 0
//     M2 = 0
// 
//     for x, weight in dataWeightPairs:
//         temp = weight + sumweight
//         delta = x − mean
//         R = delta * weight / temp
//         mean = mean + R
//         M2 = M2 + sumweight * delta * R
//         sumweight = temp
//  
//     variance_n = M2/sumweight
//     variance = variance_n * len(dataWeightPairs)/(len(dataWeightPairs) − 1)
//
// in this case we use the variable numOfIncrements for the expression len(dataWeightPairs)
// which has to be updated on every value change

public class RunningAverage
{
    private long firstTimestamp;

    private double lastValue = Double.NaN;

    private long lastTimestamp;

    private final MathContext mathContext = new MathContext ( 10, RoundingMode.HALF_DOWN );

    private BigDecimal M2 = BigDecimal.ZERO;

    private BigDecimal mean = BigDecimal.ZERO;

    private long sumWeight = 0;

    private long numOfIncrements = 0;

    private boolean hadValue = false;

    public void next ( final double value, final long timestamp )
    {
        increment ( timestamp );

        this.hadValue = this.hadValue || ( !Double.isNaN ( this.lastValue ) );

        this.lastValue = value;
        this.lastTimestamp = timestamp;
    }

    private void increment ( final long timestamp )
    {
        final long offset = timestamp - this.lastTimestamp;
        final long newSumWeight = offset + this.sumWeight;

        if ( offset > 0 )
        {
            if ( !Double.isNaN ( this.lastValue ) )
            {
                final BigDecimal delta = BigDecimal.valueOf ( this.lastValue ).subtract ( this.mean );
                final BigDecimal R = delta.multiply ( BigDecimal.valueOf ( offset ) ).divide ( BigDecimal.valueOf ( newSumWeight ), this.mathContext );
                this.mean = this.mean.add ( R );
                this.M2 = this.M2.add ( BigDecimal.valueOf ( this.sumWeight ).multiply ( delta ).multiply ( R ) );
                this.hadValue = true;
                this.sumWeight = newSumWeight;
                this.numOfIncrements += 1;
            }
        }
    }

    public void step ( final long timestamp )
    {
        this.firstTimestamp = timestamp;
        this.lastTimestamp = timestamp;

        this.M2 = BigDecimal.ZERO;
        this.mean = BigDecimal.ZERO;
        this.sumWeight = 0;
        this.numOfIncrements = 0;
        this.hadValue = false;
    }

    public double getAverage ( final long lastTimestamp )
    {
        increment ( lastTimestamp );
        if ( ( lastTimestamp == this.firstTimestamp ) || !this.hadValue )
        {
            return Double.NaN;
        }
        else
        {
            return this.mean.doubleValue ();
        }
    }

    public double getDeviation ( final long lastTimestamp )
    {
        increment ( lastTimestamp );
        if ( ( lastTimestamp == this.firstTimestamp ) || !this.hadValue )
        {
            return Double.NaN;
        }
        else
        {
            // if numOfIncrements is only 1, then a division by 0 could happen
            // in this case the deviation is 0 anyway, so return this early
            if ( this.numOfIncrements < 2 )
            {
                return 0.0;
            }
            final BigDecimal variance_n = this.M2.divide ( BigDecimal.valueOf ( this.sumWeight ), this.mathContext );
            final BigDecimal variance = variance_n.multiply ( BigDecimal.valueOf ( this.numOfIncrements ).divide ( BigDecimal.valueOf ( this.numOfIncrements - 1 ), this.mathContext ) );
            return Math.sqrt ( variance.doubleValue () );
        }
    }
}