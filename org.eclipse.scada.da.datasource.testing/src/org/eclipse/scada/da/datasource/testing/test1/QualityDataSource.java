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

public class QualityDataSource extends ScheduledDataSource implements DefaultDataSource
{
    private int timespan;

    private double value;

    public QualityDataSource ( final ScheduledExecutorService scheduler )
    {
        super ( scheduler );
    }

    @Override
    protected void tick ()
    {
        final long time = System.currentTimeMillis ();

        final Variant value = Variant.valueOf ( this.value );

        final boolean good = time / this.timespan % 2 == 0;

        final Map<String, Variant> attributes = new HashMap<String, Variant> ();
        attributes.put ( "error", Variant.valueOf ( good ) );

        setValue ( Variant.valueOf ( value ), attributes );
    }

    @Override
    public void update ( final Map<String, String> properties )
    {
        this.timespan = getInteger ( properties, "timestamp", 10 * 1000 );
        this.value = getDouble ( properties, "value", 0 );
        super.update ( properties );
    }

    protected void setValue ( final Variant variant, final Map<String, Variant> origAttributes )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ( origAttributes );
        attributes.put ( "timestamp", Variant.valueOf ( System.currentTimeMillis () + this.timeDiff ) );
        updateData ( new DataItemValue ( variant, attributes, SubscriptionState.CONNECTED ) );
    }

}
