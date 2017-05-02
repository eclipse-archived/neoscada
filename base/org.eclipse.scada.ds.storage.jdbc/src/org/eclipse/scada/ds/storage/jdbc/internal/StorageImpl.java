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
package org.eclipse.scada.ds.storage.jdbc.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ds.DataNode;
import org.eclipse.scada.ds.storage.AbstractStorage;
import org.eclipse.scada.utils.concurrent.ExportedExecutorService;
import org.eclipse.scada.utils.concurrent.FutureTask;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StorageImpl extends AbstractStorage
{
    private final static Logger logger = LoggerFactory.getLogger ( StorageImpl.class );

    private final JdbcStorageDao storage;

    private final ExecutorService executorService;

    public StorageImpl ( final JdbcStorageDao storage )
    {
        this.executorService = new ExportedExecutorService ( StorageImpl.class.getName (), 1, 1, 0L, TimeUnit.MILLISECONDS );

        this.storage = storage;
    }

    @Override
    protected Executor getExecutor ()
    {
        return this.executorService;
    }

    @Override
    public synchronized void dispose ()
    {
        super.dispose ();

        this.executorService.shutdown ();
        this.storage.dispose ();
    }

    @Override
    public synchronized NotifyFuture<DataNode> readNode ( final String nodeId )
    {
        try
        {
            final FutureTask<DataNode> task = new FutureTask<DataNode> ( new Callable<DataNode> () {

                @Override
                public DataNode call () throws Exception
                {
                    return StorageImpl.this.storage.readNode ( nodeId );
                }
            } );

            this.executorService.execute ( task );
            return task;
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to load data node", e );
            return new InstantErrorFuture<DataNode> ( e );
        }
    }

    @Override
    public synchronized NotifyFuture<Void> writeNode ( final DataNode node )
    {
        try
        {
            final FutureTask<Void> task = new FutureTask<Void> ( new Callable<Void> () {

                @Override
                public Void call () throws Exception
                {
                    try
                    {
                        StorageImpl.this.storage.writeNode ( node );
                        fireUpdate ( node );
                    }
                    catch ( final Exception e )
                    {
                        logger.warn ( "Failed to write node", e );
                        throw new RuntimeException ( "Failed to write node", e );
                    }
                    return null;
                }
            } );

            this.executorService.execute ( task );
            return task;
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to write data node", e );
            return new InstantErrorFuture<Void> ( e );
        }
    }

    @Override
    public synchronized NotifyFuture<Void> deleteNode ( final String nodeId )
    {
        try
        {
            final FutureTask<Void> task = new FutureTask<Void> ( new Callable<Void> () {

                @Override
                public Void call () throws Exception
                {
                    StorageImpl.this.storage.deleteNode ( nodeId );
                    return null;
                }
            } );

            this.executorService.execute ( task );
            return task;
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to write data node", e );
            return new InstantErrorFuture<Void> ( e );
        }
    }
}
