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
package org.eclipse.scada.da.datasource.sum;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantType;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.datasource.DataSourceHandler;
import org.eclipse.scada.da.datasource.sum.Activator;
import org.eclipse.scada.da.datasource.sum.SumDataSource;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.InvalidSyntaxException;

public class PerfTest1
{
    private static class DataSourceHandlerImplementation implements DataSourceHandler
    {
        private final DataItemValue value;

        public DataSourceHandlerImplementation ( final Variant value, final Boolean error, final Boolean alarm, final Boolean warning, final Boolean manual, final Boolean blocked )
        {
            final DataItemValue.Builder builder = new Builder ();

            builder.setValue ( value );
            builder.setTimestamp ( System.currentTimeMillis () );
            builder.setSubscriptionState ( SubscriptionState.CONNECTED );

            if ( error != null )
            {
                builder.setAttribute ( "error", Variant.valueOf ( error ) );
            }
            if ( alarm != null )
            {
                builder.setAttribute ( "alarm", Variant.valueOf ( alarm ) );
            }
            if ( warning != null )
            {
                builder.setAttribute ( "warning", Variant.valueOf ( warning ) );
            }
            if ( manual != null )
            {
                builder.setAttribute ( "manual", Variant.valueOf ( manual ) );
            }
            if ( blocked != null )
            {
                builder.setAttribute ( "blocked", Variant.valueOf ( blocked ) );
            }

            this.value = builder.build ();
        }

        @Override
        public DataItemValue getValue ()
        {
            return this.value;
        }

        @Override
        public VariantType getType ()
        {
            return VariantType.DOUBLE;
        }

        @Override
        public void dispose ()
        {
        }
    }

    private ExecutorService executor;

    private ObjectPoolTracker<DataSource> poolTracker;

    @Before
    public void setup () throws InvalidSyntaxException
    {
        this.executor = Executors.newSingleThreadExecutor ();
        this.poolTracker = new ObjectPoolTracker<DataSource> ( Activator.instance.context, DataSource.class );
        this.poolTracker.open ();
    }

    @After
    public void dispose ()
    {
        this.poolTracker.close ();
        this.executor.shutdown ();
    }

    @Test
    public void test1 () throws Exception
    {
        final SumDataSource ds = new SumDataSource ( this.poolTracker, this.executor );

        final Map<String, String> parameters = new HashMap<String, String> ();

        parameters.put ( "groups", "alarm,warning,error,manual,blocked,ackRequired" );

        ds.update ( parameters );

        @SuppressWarnings ( "unchecked" )
        final Map<String, DataSourceHandler>[] updates = new Map[10000];
        for ( int i = 0; i < updates.length; i++ )
        {
            updates[i] = generateMap ( 100 );
        }

        processTest1 ( ds, updates );
    }

    protected void processTest1 ( final SumDataSource ds, final Map<String, DataSourceHandler>[] updates )
    {
        for ( final Map<String, DataSourceHandler> update : updates )
        {
            ds.aggregate ( update, Collections.<String, DataSourceHandler> emptyMap () );
        }
    }

    private final Random r = new Random ();

    private Map<String, DataSourceHandler> generateMap ( final int count )
    {
        final Map<String, DataSourceHandler> result = new HashMap<String, DataSourceHandler> ();

        for ( int i = 0; i < count; i++ )
        {
            result.put ( "" + i, createSimHandler ( Variant.valueOf ( this.r.nextDouble () ), this.r.nextBoolean (), this.r.nextBoolean (), this.r.nextBoolean (), this.r.nextBoolean (), this.r.nextBoolean () ) );
        }

        return result;
    }

    protected DataSourceHandler createSimHandler ( final Variant value, final boolean error, final boolean alarm, final boolean warning, final boolean manual, final boolean blocked )
    {
        return new DataSourceHandlerImplementation ( value, error, alarm, warning, manual, blocked );
    }
}
