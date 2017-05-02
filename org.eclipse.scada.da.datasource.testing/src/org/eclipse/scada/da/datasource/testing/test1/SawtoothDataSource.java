/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.datasource.testing.test1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.datasource.testing.DefaultDataSource;

public class SawtoothDataSource extends ScheduledDataSource implements DefaultDataSource
{
    private Long startIndex;

    private double factor;

    private int cap;

    private int precision;

    private Variant lastValue;

    public SawtoothDataSource ( final ScheduledExecutorService scheduler )
    {
        super ( scheduler );
    }

    @Override
    protected void tick ()
    {
        if ( this.startIndex == null )
        {
            this.startIndex = System.currentTimeMillis ();
        }

        final long now = System.currentTimeMillis ();
        final long ms = ( now - this.startIndex ) / this.precision % this.cap;

        final double value = ms * this.factor;

        setValue ( Variant.valueOf ( value ) );
    }

    @Override
    public void update ( final Map<String, String> properties )
    {
        this.factor = getDouble ( properties, "factor", 1 );
        this.cap = getInteger ( properties, "cap", 1000 );
        this.precision = getInteger ( properties, "precision", 1000 );

        super.update ( properties );
    }

    private void setValue ( final Variant variant )
    {
        if ( this.lastValue == null || !this.lastValue.equals ( variant ) )
        {
            this.lastValue = variant;
            final Map<String, Variant> attributes = new HashMap<String, Variant> ( 1 );
            attributes.put ( "timestamp", Variant.valueOf ( System.currentTimeMillis () + this.timeDiff ) );
            updateData ( new DataItemValue ( variant, attributes, SubscriptionState.CONNECTED ) );
        }
    }

}
