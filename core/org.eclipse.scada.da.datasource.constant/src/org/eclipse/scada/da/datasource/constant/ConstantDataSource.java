/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.datasource.constant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.VariantEditor;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.da.datasource.base.AbstractInputDataSource;

public class ConstantDataSource extends AbstractInputDataSource
{

    private final Executor executor;

    public ConstantDataSource ( final Executor executor )
    {
        this.executor = executor;
    }

    @Override
    protected Executor getExecutor ()
    {
        return this.executor;
    }

    public synchronized void update ( final Map<String, String> parameters ) throws Exception
    {
        final Builder builder = new DataItemValue.Builder ();

        try
        {
            final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

            // set main value
            builder.setValue ( VariantEditor.toVariant ( cfg.getStringChecked ( "value", "'value' must be provided" ) ) );

            builder.setTimestamp ( makeTimestamp ( cfg ) );

            // set attributes
            for ( final Map.Entry<String, String> entry : cfg.getPrefixed ( "attributes." ).entrySet () )
            {
                builder.setAttribute ( entry.getKey (), VariantEditor.toVariant ( entry.getValue () ) );
            }

            // set as last step
            builder.setSubscriptionState ( SubscriptionState.CONNECTED );
        }
        finally
        {
            updateData ( builder.build () );
        }
    }

    private Calendar makeTimestamp ( final ConfigurationDataHelper cfg ) throws ParseException
    {
        final Calendar c = Calendar.getInstance ();

        final String timeString = cfg.getString ( "timeString" );
        if ( timeString != null && !timeString.isEmpty () )
        {
            c.setTime ( new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss.SSS" ).parse ( timeString ) );
        }

        final long timeDiff = cfg.getLong ( "timeDiff.value", 0 );
        final TimeUnit timeDiffUnit = TimeUnit.valueOf ( cfg.getString ( "timeDiff.unit", TimeUnit.MILLISECONDS.toString () ) );

        c.add ( Calendar.MILLISECOND, (int)TimeUnit.MILLISECONDS.convert ( timeDiff, timeDiffUnit ) );

        return c;
    }
}
