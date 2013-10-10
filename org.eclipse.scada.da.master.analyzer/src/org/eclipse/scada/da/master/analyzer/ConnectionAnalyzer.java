/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.master.analyzer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.client.Connection;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.ConnectionStateListener;
import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.eclipse.scada.core.connection.provider.info.ConnectionInformationProvider;
import org.eclipse.scada.core.info.StatisticEntry;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.server.common.osgi.factory.DataItemFactory;
import org.eclipse.scada.utils.ExceptionHelper;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.common.chain.WriteHandler;
import org.eclipse.scada.da.server.common.exporter.StaticObjectExporter;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConnectionAnalyzer implements ConnectionStateListener
{
    private final static long STATISTICS_DELAY = Long.getLong ( "org.eclipse.scada.da.master.analyzer.statisticsDelay", 5 ); //$NON-NLS-1$

    private final DataItemFactory factory;

    private final StaticObjectExporter<ConnectionAnalyzerStatus> exporter;

    private final ConnectionAnalyzerStatus value;

    private final ConnectionService service;

    private final ScheduledFuture<?> job;

    private final DataItemInputChained statisticsItem;

    public ConnectionAnalyzer ( final ScheduledExecutorService executor, final BundleContext context, final ServiceReference<?> reference, final ConnectionService service )
    {
        this.factory = new DataItemFactory ( context, executor, "org.eclipse.scada.da.master.analyzer.connectionService." + makeId ( reference ) ); //$NON-NLS-1$
        this.exporter = new StaticObjectExporter<ConnectionAnalyzerStatus> ( this.factory, ConnectionAnalyzerStatus.class, false, false, "state." ); //$NON-NLS-1$

        this.statisticsItem = this.factory.createInput ( "statistics", null ); //$NON-NLS-1$

        this.value = new ConnectionAnalyzerStatus ();

        this.value.setUri ( makeUri ( service ) );

        this.exporter.setTarget ( this.value );

        this.job = executor.scheduleWithFixedDelay ( new Runnable () {
            @Override
            public void run ()
            {
                refresh ();
            }
        }, 0, STATISTICS_DELAY, TimeUnit.SECONDS );

        this.factory.createOutput ( "connect", null, new WriteHandler () { //$NON-NLS-1$

            @Override
            public void handleWrite ( final Variant value, final OperationParameters operationParameters ) throws Exception
            {
                ConnectionAnalyzer.this.handleConnect ();
            }
        } );

        this.factory.createOutput ( "disconnect", null, new WriteHandler () { //$NON-NLS-1$

            @Override
            public void handleWrite ( final Variant value, final OperationParameters operationParameters ) throws Exception
            {
                ConnectionAnalyzer.this.handleDisconnect ();
            }
        } );

        this.service = service;

        stateChange ( service.getConnection (), service.getConnection ().getState (), null );
        service.getConnection ().addConnectionStateListener ( this );
    }

    protected void refresh ()
    {
        final Map<String, Variant> result = new HashMap<String, Variant> ();
        if ( this.service instanceof ConnectionInformationProvider )
        {
            final Collection<StatisticEntry> statistics = ( (ConnectionInformationProvider)this.service ).getStatistics ();

            for ( final StatisticEntry entry : statistics )
            {
                try
                {
                    result.put ( String.format ( "statistics.%s.current", entry.getLabel () ), Variant.valueOf ( entry.getValue ().getCurrent () ) ); //$NON-NLS-1$
                    result.put ( String.format ( "statistics.%s.min", entry.getLabel () ), Variant.valueOf ( entry.getValue ().getMinimum () ) ); //$NON-NLS-1$
                    result.put ( String.format ( "statistics.%s.max", entry.getLabel () ), Variant.valueOf ( entry.getValue ().getMaximum () ) ); //$NON-NLS-1$
                }
                catch ( final Exception e )
                {
                }
            }
            this.statisticsItem.updateData ( makeJson ( statistics ), result, AttributeMode.SET );
        }
    }

    private Variant makeJson ( final Collection<StatisticEntry> statistics )
    {
        final GsonBuilder builder = new GsonBuilder ();
        final Gson gson = builder.create ();
        return Variant.valueOf ( gson.toJson ( statistics ) );
    }

    /**
     * Get the uri of the connection service
     * 
     * @param service
     *            the service
     * @return the connection uri or <code>null</code>
     */
    private String makeUri ( final ConnectionService service )
    {
        if ( service != null )
        {
            final Connection connection = service.getConnection ();
            if ( connection != null )
            {
                final ConnectionInformation info = connection.getConnectionInformation ();
                if ( info != null )
                {
                    return info.toMaskedString ();
                }
            }
        }
        return null;
    }

    protected void handleDisconnect ()
    {
        final ConnectionService service = this.service;
        if ( service != null )
        {
            service.disconnect ();
        }
    }

    protected void handleConnect ()
    {
        final ConnectionService service = this.service;
        if ( service != null )
        {
            service.connect ();
        }
    }

    public void dispose ()
    {
        this.job.cancel ( false );
        this.service.getConnection ().removeConnectionStateListener ( this );
        this.factory.dispose ();
    }

    private static String makeId ( final ServiceReference<?> reference )
    {
        final Object id = reference.getProperty ( Constants.SERVICE_PID );
        if ( id instanceof String )
        {
            return (String)id;
        }

        return "" + reference.getProperty ( Constants.SERVICE_ID );
    }

    @Override
    public void stateChange ( final Connection connection, final ConnectionState state, final Throwable error )
    {
        this.value.setState ( state );
        this.value.setConnected ( state == ConnectionState.BOUND );
        this.value.setLastException ( ExceptionHelper.formatted ( error ) );
        this.value.setLastError ( ExceptionHelper.getMessage ( error ) );
        this.exporter.setTarget ( this.value );
    }

}
