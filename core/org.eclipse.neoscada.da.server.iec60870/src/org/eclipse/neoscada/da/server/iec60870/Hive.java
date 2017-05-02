/*******************************************************************************
 * Copyright (c) 2014, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.da.server.iec60870;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.neoscada.da.server.iec60870.Connection.FullAddress;
import org.eclipse.neoscada.da.server.iec60870.cfg.CAConfigurationFactory;
import org.eclipse.neoscada.da.server.iec60870.cfg.ConfigurationFactory;
import org.eclipse.neoscada.da.server.iec60870.cfg.ConfigurationFactory.Receiver;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.ValidationStrategy;
import org.eclipse.scada.da.server.common.impl.SessionCommon;
import org.eclipse.scada.da.server.common.impl.WriteHandler;
import org.eclipse.scada.da.server.common.osgi.AbstractOsgiHiveCommon;
import org.eclipse.scada.utils.concurrent.ExportedExecutorService;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;

public class Hive extends AbstractOsgiHiveCommon
{
    final static Logger logger = LoggerFactory.getLogger ( Hive.class );

    private final Receiver configurationReceiver = new Receiver () {

        @Override
        public void removeConnection ( final String id )
        {
            performRemoveConnection ( id );
        }

        @Override
        public ListenableFuture<Void> addConnection ( final String id, final ConnectionConfiguration configuration )
        {
            return performAddConnection ( id, configuration );
        }
    };

    private final ConfigurationFactory factory;

    private ExportedExecutorService executor;

    private final Map<String, Connection> connections = new HashMap<> ();

    private final FolderCommon rootFolder;

    public Hive ()
    {
        this ( new CAConfigurationFactory ( FrameworkUtil.getBundle ( Hive.class ).getBundleContext () ), FrameworkUtil.getBundle ( Hive.class ).getBundleContext () );
    }

    public Hive ( final ConfigurationFactory factory, final BundleContext context )
    {
        super ( context );

        this.factory = factory;

        setValidatonStrategy ( ValidationStrategy.GRANT_ALL );

        this.rootFolder = new FolderCommon ();
        setRootFolder ( this.rootFolder );
    }

    FolderCommon getRootFolder ()
    {
        return this.rootFolder;
    }

    @Override
    protected void performStart () throws Exception
    {
        this.executor = new ExportedExecutorService ( Hive.class.getName (), 0, 1, 1, TimeUnit.MINUTES );

        super.performStart ();

        this.factory.setReceiver ( this.configurationReceiver );
    }

    @Override
    protected void performStop () throws Exception
    {
        this.factory.setReceiver ( null );

        super.performStop ();

        ExecutorService service = null;

        synchronized ( this )
        {
            if ( this.executor != null )
            {
                service = this.executor;
                this.executor.shutdown ();
                this.executor = null;
            }
        }
        if ( service != null )
        {
            service.awaitTermination ( Long.MAX_VALUE, TimeUnit.MILLISECONDS );
        }
    }

    @Override
    public String getHiveId ()
    {
        return Hive.class.getPackage ().getName ();
    }

    protected synchronized ListenableFuture<Void> performAddConnection ( final String id, final ConnectionConfiguration configuration )
    {
        logger.debug ( "adding connection - id: {}, cfg: {}", id, configuration );

        if ( this.executor == null )
        {
            logger.debug ( "Hive is not started" );
            return Futures.immediateFailedFuture ( new IllegalStateException ( "Hive is not started" ) );
        }

        final ListenableFutureTask<Void> task = ListenableFutureTask.create ( new Callable<Void> () {

            @Override
            public Void call () throws Exception
            {
                try
                {
                    handleAddConnection ( id, configuration );
                }
                catch ( final Exception e )
                {
                    logger.warn ( "Failed to create connection", e );
                    throw new InvocationTargetException ( e );
                }
                return null;
            }
        } );
        this.executor.execute ( task );
        return task;
    }

    protected void performRemoveConnection ( final String id )
    {
        synchronized ( this )
        {
            if ( this.executor == null )
            {
                return;
            }

            this.executor.execute ( new Runnable () {
                @Override
                public void run ()
                {
                    handleRemoveConnection ( id );
                }
            } );
        }
    }

    protected synchronized void handleAddConnection ( final String id, final ConnectionConfiguration configuration )
    {
        logger.debug ( "Handling: add connection, id: {}, cfg: {}", id, configuration );
        final Connection old = this.connections.remove ( id );
        if ( old != null )
        {
            old.dispose ();
        }

        this.connections.put ( id, new Connection ( id, this, this.executor, configuration ) );
    }

    protected synchronized void handleRemoveConnection ( final String id )
    {
        logger.debug ( "Handling: remove connection, id: {}", id );

        final Connection connection = this.connections.remove ( id );
        if ( connection != null )
        {
            connection.dispose ();
        }
    }

    private static final String PREFIX = ".data.";

    private static final int PREFIX_LEN = PREFIX.length ();

    @Override
    protected synchronized WriteHandler getWriteHandler ( final SessionCommon session, final String itemId )
    {
        for ( final Map.Entry<String, Connection> entry : this.connections.entrySet () )
        {
            final String id = entry.getKey ();
            logger.trace ( "Search for connection - prefix: {}{} / itemId ", id, PREFIX, itemId );
            if ( !itemId.startsWith ( id + PREFIX ) )
            {
                continue;
            }

            return newConnectionWriteHandler ( entry.getValue (), itemId.substring ( id.length () + PREFIX_LEN ) );
        }

        return super.getWriteHandler ( session, itemId );
    }

    private WriteHandler newConnectionWriteHandler ( final Connection connection, final String localItemId )
    {
        logger.debug ( "Create write handler for - connection: {}, address: {}", connection, localItemId );

        final FullAddress address = connection.parseFullAddress ( localItemId );

        logger.debug ( "Write handler for  - {} / {}", address.commonAddress, address.objectAddress );

        return new WriteHandler () {
            @Override
            public NotifyFuture<WriteResult> startWriteValue ( final Variant value, final OperationParameters effectiveOperationParameters )
            {
                return connection.handleStartWriteValue ( address.commonAddress, address.objectAddress, value, effectiveOperationParameters );
            }
        };
    }

}
