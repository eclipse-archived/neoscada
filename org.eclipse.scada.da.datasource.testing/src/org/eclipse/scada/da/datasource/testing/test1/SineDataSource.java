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

public class SineDataSource extends ScheduledDataSource implements DefaultDataSource
{

    private double factor1;

    private double factor2;

    private double amp1;

    private double amp2;

    public SineDataSource ( final ScheduledExecutorService scheduler )
    {
        super ( scheduler );
    }

    @Override
    protected void tick ()
    {
        final double time = System.currentTimeMillis () / 1000.0;

        final double value = this.amp1 * Math.sin ( time / this.factor1 ) + this.amp2 * Math.sin ( time / this.factor2 );
        setValue ( Variant.valueOf ( value ) );
    }

    @Override
    public void update ( final Map<String, String> properties )
    {
        this.timeDiff = getInteger ( properties, "time.diff", 0 );
        this.factor1 = getDouble ( properties, "factor1", 2000.0 );
        this.factor2 = getDouble ( properties, "factor2", 20.0 );

        this.amp1 = getDouble ( properties, "amp1", 100 );
        this.amp2 = getDouble ( properties, "amp2", 5 );

        super.update ( properties );
    }

    private void setValue ( final Variant variant )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ( 1 );
        attributes.put ( "timestamp", Variant.valueOf ( System.currentTimeMillis () + this.timeDiff ) );
        updateData ( new DataItemValue ( variant, attributes, SubscriptionState.CONNECTED ) );
    }

}
