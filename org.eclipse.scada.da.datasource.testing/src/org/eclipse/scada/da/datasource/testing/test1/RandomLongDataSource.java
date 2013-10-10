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
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.datasource.testing.DefaultDataSource;

public class RandomLongDataSource extends ScheduledDataSource implements DefaultDataSource
{
    private final Random r;

    private long variance;

    private long lastSwitch = System.currentTimeMillis ();

    @SuppressWarnings ( "unused" )
    private long offset;

    private long switchDelay = 10 * 1000;

    public RandomLongDataSource ( final ScheduledExecutorService scheduler )
    {
        super ( scheduler );
        this.r = new Random ();
    }

    @Override
    protected void tick ()
    {

        final long now = System.currentTimeMillis ();

        if ( now - this.lastSwitch > this.switchDelay )
        {
            this.lastSwitch = now;
            this.offset += this.r.nextLong () % this.variance;
        }

        setValue ( Variant.valueOf ( this.r.nextLong () % this.variance ) );
    }

    @Override
    public void update ( final Map<String, String> properties )
    {
        this.variance = getLong ( properties, "variance", 100 );
        this.switchDelay = getLong ( properties, "switchDelay", 10 * 1000 );

        super.update ( properties );
    }

    private void setValue ( final Variant variant )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ();
        attributes.put ( "timestamp", Variant.valueOf ( System.currentTimeMillis () + this.timeDiff ) );
        updateData ( new DataItemValue ( variant, attributes, SubscriptionState.CONNECTED ) );
    }

}
