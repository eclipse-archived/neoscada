/*******************************************************************************
 * Copyright (c) 2013 Jürgen Rose and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jürgen Rose - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.storage.postgres.internal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Event.Fields;
import org.eclipse.scada.ae.server.storage.BaseStorage;
import org.eclipse.scada.ae.server.storage.Query;
import org.eclipse.scada.ae.server.storage.StoreListener;
import org.eclipse.scada.ae.server.storage.postgres.JdbcDao;
import org.eclipse.scada.ae.server.storage.postgres.NodeIdProvider;
import org.eclipse.scada.utils.collection.BoundedPriorityQueueSet;
import org.eclipse.scada.utils.filter.Filter;
import org.eclipse.scada.utils.filter.FilterParseException;
import org.eclipse.scada.utils.filter.FilterParser;
import org.eclipse.scada.utils.osgi.jdbc.CommonConnectionAccessor;
import org.eclipse.scada.utils.osgi.jdbc.DataSourceConnectionAccessor;
import org.eclipse.scada.utils.osgi.jdbc.pool.PoolConnectionAccessor;
import org.eclipse.scada.utils.osgi.jdbc.task.CommonConnectionTask;
import org.eclipse.scada.utils.osgi.jdbc.task.ConnectionContext;
import org.osgi.service.jdbc.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcStorage extends BaseStorage
{
    private static final Logger logger = LoggerFactory.getLogger ( JdbcStorage.class );

    private final CommonConnectionAccessor accessor;

    private final ScheduledExecutorService scheduler;

    private final ExecutorService dbExecutor;

    private final List<JdbcQuery> openQueries = new CopyOnWriteArrayList<JdbcQuery> ();

    private final BoundedPriorityQueueSet<Event> errorQueue = new BoundedPriorityQueueSet<Event> ( 1000 );

    private final Queue<StoreTask> storeQueue = new ConcurrentLinkedQueue<StoreTask> ();

    private final JdbcDao jdbcDao;

    private ScheduledFuture<?> scheduledProcessStoreQueue;

    private ScheduledFuture<?> scheduledProcessErrorQueue;

    private ScheduledFuture<?> scheduledCleanUpJob;

    public JdbcStorage ( final DataSourceFactory dataSourceFactory, final ScheduledExecutorService scheduler, final Properties dbProperties, final boolean usePool, final String schema, final String instance ) throws SQLException
    {
        super ();
        this.accessor = usePool ? new PoolConnectionAccessor ( dataSourceFactory, dbProperties ) : new DataSourceConnectionAccessor ( dataSourceFactory, dbProperties );
        this.jdbcDao = new JdbcDao ( this.accessor, schema, instance, new NodeIdProvider () {
            @Override
            public String getNodeId ()
            {
                return JdbcStorage.this.getNodeId ();
            }
        } );
        this.scheduler = scheduler;
        this.dbExecutor = Executors.newSingleThreadExecutor ();
    }

    public void start ()
    {
        this.scheduledProcessStoreQueue = this.scheduler.scheduleWithFixedDelay ( new Runnable () {
            @Override
            public void run ()
            {
                if ( storeQueue.size () > 0 )
                {
                    try
                    {
                        processStoreQueue ( getBatchSize () );
                    }
                    catch ( Exception e )
                    {
                        logger.error ( "call to processStoreQueue failed", e );
                    }
                }
            }
        }, 1, 1, TimeUnit.SECONDS );
        this.scheduledProcessErrorQueue = this.scheduler.scheduleWithFixedDelay ( new Runnable () {
            @Override
            public void run ()
            {
                processErrorQueue ();
            }
        }, 30, 30, TimeUnit.SECONDS );
        this.scheduledCleanUpJob = this.scheduler.scheduleWithFixedDelay ( new CleanUpJob ( this.jdbcDao ), CleanUpJob.getCleanupPeriod (), CleanUpJob.getCleanupPeriod (), TimeUnit.SECONDS );
    }

    public void dispose ()
    {
        if ( this.scheduledProcessStoreQueue != null )
        {
            this.scheduledProcessStoreQueue.cancel ( false );
        }
        if ( this.scheduledProcessErrorQueue != null )
        {
            this.scheduledProcessErrorQueue.cancel ( false );
        }
        if ( this.scheduledCleanUpJob != null )
        {
            this.scheduledCleanUpJob.cancel ( false );
        }
        for ( final JdbcQuery query : this.openQueries )
        {
            query.dispose ();
        }
        this.dbExecutor.shutdownNow ();
    }

    @Override
    public Event store ( final Event event, final StoreListener listener )
    {
        // create Event with entry timestamp and new ID
        final Event eventToStore = createEvent ( event );
        if ( getBatchSize () > 1 )
        {
            storeQueue.offer ( new StoreTask ( listener, eventToStore, true ) );
        }
        else
        {
            doStore ( Arrays.asList ( new StoreTask ( listener, eventToStore, true ) ) );
        }
        return eventToStore;
    }

    private Future<Void> doStore ( final List<StoreTask> batch )
    {
        return this.dbExecutor.submit ( new Callable<Void> () {
            @Override
            public Void call () throws Exception
            {
                logger.trace ( "doStore -> Callable started" );
                try
                {
                    JdbcStorage.this.accessor.doWithConnection ( new CommonConnectionTask<Void> () {
                        @Override
                        public Void performTask ( final ConnectionContext connectionContext ) throws Exception
                        {
                            connectionContext.setAutoCommit ( false );
                            for ( StoreTask task : batch )
                            {
                                JdbcStorage.this.jdbcDao.store ( connectionContext, task.getEventToStore () );
                                if ( isReplication () )
                                {
                                    JdbcStorage.this.jdbcDao.storeReplication ( connectionContext, task.getEventToStore () );
                                }
                            }
                            connectionContext.commit ();
                            return null;
                        }
                    } );
                    for ( StoreTask task : batch )
                    {
                        if ( task.getListener () != null )
                        {
                            try
                            {
                                task.getListener ().notify ( task.getEventToStore () );
                            }
                            catch ( final Exception e )
                            {
                                logger.error ( "call to listener failed", e );
                            }
                        }
                    }
                }
                catch ( final Exception e )
                {
                    for ( StoreTask task : batch )
                    {
                        if ( task.isStoreInErrorQueue () )
                        {
                            logger.error ( "storing event failed, putting it on error queue", e );
                            JdbcStorage.this.errorQueue.offer ( task.getEventToStore () );
                        }
                        else
                        {
                            logger.error ( "storing event failed", e );
                        }
                    }
                }
                logger.trace ( "doStore -> Callable finished" );
                return null;
            }
        } );
    }

    @Override
    public Event update ( final UUID id, final String comment, final StoreListener listener ) throws Exception
    {
        final Future<Event> future = this.dbExecutor.submit ( new Callable<Event> () {
            @Override
            public Event call () throws Exception
            {
                return JdbcStorage.this.jdbcDao.load ( id );
            }
        } );
        final Event event = future.get ( 10, TimeUnit.SECONDS );
        final Event eventToStore = Event.create ().event ( event ).attribute ( Fields.COMMENT, comment ).build ();
        this.dbExecutor.submit ( new Callable<Event> () {
            @Override
            public Event call () throws Exception
            {
                JdbcStorage.this.accessor.doWithConnection ( new CommonConnectionTask<Void> () {
                    @Override
                    public Void performTask ( final ConnectionContext connectionContext ) throws Exception
                    {
                        connectionContext.setAutoCommit ( false );
                        JdbcStorage.this.jdbcDao.update ( connectionContext, eventToStore );
                        connectionContext.commit ();
                        return null;
                    }
                } );
                if ( listener != null )
                {
                    try
                    {
                        listener.notify ( eventToStore );
                    }
                    catch ( final Exception e )
                    {
                        logger.error ( "call to listener failed", e );
                    }
                }
                return eventToStore;
            }
        } );
        return eventToStore;
    }

    private void processStoreQueue ( final int size ) throws InterruptedException, ExecutionException
    {
        logger.debug ( "processing store queue, contains approximately {} elements", this.storeQueue.size () );
        final List<StoreTask> batch = new ArrayList<StoreTask> ( size );
        for ( int i = 0; i < size; i++ )
        {
            StoreTask task = storeQueue.poll ();
            if ( task != null )
            {
                batch.add ( task );
            }
        }
        Future<Void> future = doStore ( batch );
        future.get ();
    }

    private void processErrorQueue ()
    {
        logger.debug ( "processing error queue, contains approximately {} elements", this.errorQueue.size () );
        final int size = this.errorQueue.size ();
        final Set<Event> eventsNotSaved = new HashSet<Event> ();
        for ( int i = 0; i < size; i++ )
        {
            final Event event = this.errorQueue.poll ();
            if ( event == null )
            {
                break;
            }
            logger.trace ( "try to store event {} again", event );
            try
            {
                // first check if event may exist already in DB
                final Event existingEvent = this.jdbcDao.load ( event.getId () );
                if ( existingEvent != Event.NULL_EVENT )
                {
                    logger.trace ( "event {} was already in database", event.getId () );
                    // ok it was already stored, so we can it ignore
                    continue;
                }
                final Future<Void> future = doStore ( Arrays.asList ( new StoreTask ( null, event, false ) ) );
                future.get ();
            }
            catch ( final Exception e )
            {
                logger.trace ( "storing of event {} failed again", event );
                eventsNotSaved.add ( event );
            }
        }
        // add to queue again
        for ( final Event event : eventsNotSaved )
        {
            this.errorQueue.offer ( event );
        }
    }

    @Override
    public Query query ( final String filter ) throws Exception
    {
        try
        {
            final Filter parsedFilter = new FilterParser ( filter ).getFilter ();
            return new JdbcQuery ( this.jdbcDao, parsedFilter, this.scheduler, this.openQueries );
        }
        catch ( final FilterParseException e )
        {
            logger.error ( "failed to parse filter", e );
            throw e;
        }
    }

    private boolean isReplication ()
    {
        return Boolean.getBoolean ( "org.eclipse.scada.ae.server.storage.jdbc.enableReplication" );
    }

    private int getBatchSize ()
    {
        final Integer size = Integer.getInteger ( "org.eclipse.scada.ae.server.storage.postgres.batchSize", 1 );
        return size < 1 ? 1 : size;
    }
}
