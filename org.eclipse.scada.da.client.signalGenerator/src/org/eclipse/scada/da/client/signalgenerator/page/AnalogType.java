/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.signalgenerator.page;

import java.util.Random;

import org.eclipse.scada.core.Variant;

public enum AnalogType
{
    SINE ( Messages.getString ( "AnalogType.TypeSine.label" ) ) //$NON-NLS-1$
    {
        @Override
        public Variant generate ( final double timeIndex, final double min, final double max, final double period )
        {
            double val = Math.sin ( timeIndex * 1.0 / period );
            val = scale ( min, max, val );
            return Variant.valueOf ( val );
        }

    },
    COSINE ( Messages.getString ( "AnalogType.TypeCosine.label" ) ) //$NON-NLS-1$
    {
        @Override
        public Variant generate ( final double timeIndex, final double min, final double max, final double period )
        {
            double val = Math.cos ( timeIndex * 1.0 / period );
            val = scale ( min, max, val );
            return Variant.valueOf ( val );
        }

    },
    RANDOM_NORMAL ( Messages.getString ( "AnalogType.TypeRandom.label" ) ) //$NON-NLS-1$
    {
        private final Random r = new Random ();

        @Override
        public Variant generate ( final double timeIndex, final double min, final double max, final double period )
        {
            final double range = max - min;
            return Variant.valueOf ( this.r.nextDouble () * range + min );
        }
    },
    RANDOM_GAUSSIAN ( Messages.getString ( "AnalogType.TypeRandomGaussian.label" ) ) //$NON-NLS-1$
    {
        private final Random r = new Random ();

        @Override
        public Variant generate ( final double timeIndex, final double min, final double max, final double period )
        {
            return Variant.valueOf ( scale ( min, max, this.r.nextGaussian () / 2.0 ) );
        }
    },
    TRIANGLE ( Messages.getString ( "AnalogType.TypeTriangle.label" ) ) //$NON-NLS-1$
    {
        @Override
        public Variant generate ( final double timeIndex, final double min, final double max, final double period )
        {
            final double range = max - min;
            final double val = timeIndex / period % range + min;

            return Variant.valueOf ( val );
        }
    },
    SQUARE ( Messages.getString ( "AnalogType.TypeSquare.label" ) ) //$NON-NLS-1$
    {
        @Override
        public Variant generate ( final double timeIndex, final double min, final double max, final double period )
        {
            final double val = (long)timeIndex / (long)period % 2;
            return Variant.valueOf ( val == 0 ? min : max );
        }
    };

    public abstract Variant generate ( final double timeIndex, final double min, final double max, final double period );

    private static double scale ( final double min, final double max, double val )
    {
        final double range = ( max - min ) / 2.0;
        final double offset = min + range;
        val = val * range + offset;
        return val;
    }

    private final String label;

    private AnalogType ( final String label )
    {
        this.label = label;
    }

    public String toLabel ()
    {
        return this.label;
    }

}
