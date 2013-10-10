/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.hd.server.storage.hds;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.data.HistoricalItemInformation;
import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hd.server.common.HistoricalItem;
import org.eclipse.scada.hd.server.storage.common.QueryImpl;
import org.eclipse.scada.hd.server.storage.common.ValueSourceManager;
import org.eclipse.scada.hds.DataFilePool;
import org.eclipse.scada.hds.DataStoreAccesor;
import org.eclipse.scada.hds.DataStoreListener;
import org.eclipse.scada.hds.ValueVisitor;
import org.eclipse.scada.utils.concurrent.FutureTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractStorageImpl implements HistoricalItem, ValueSourceManager
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractStorageImpl.class );

    private final File file;

    protected final String id;

    protected final DataStoreAccesor nativeLevel;

    protected final ReadWriteLock rwLock = new ReentrantReadWriteLock ();

    protected final Lock writeLock = this.rwLock.writeLock ();

    protected final Lock readLock = this.rwLock.readLock ();

    private boolean disposed;

    private final ScheduledExecutorService queryExecutor;

    private final Set<QueryImpl> queries = new HashSet<QueryImpl> ();

    private final Set<Future<?>> jobs = new CopyOnWriteArraySet<Future<?>> ();

    private final Lock jobLock = new ReentrantLock ();

    private final Condition jobCondition = this.jobLock.newCondition ();

    private final ScheduledExecutorService eventExecutor;

    public AbstractStorageImpl ( final File file, final DataFilePool pool, final ScheduledExecutorService queryExecutor, final ScheduledExecutorService eventExecutor ) throws Exception
    {
        this.file = file;

        this.queryExecutor = queryExecutor;
        this.eventExecutor = eventExecutor;

        final Properties p = new Properties ();
        p.loadFromXML ( new FileInputStream ( new File ( file, "settings.xml" ) ) );
        this.id = p.getProperty ( "id" );

        this.nativeLevel = new DataStoreAccesor ( new File ( file, "native" ), pool );
        this.nativeLevel.addListener ( new DataStoreListener () {

            @Override
            public void storeChanged ( final Date start, final Date end )
            {
                handleStoreChanged ( start, end );
            }
        } );
    }

    protected void addJob ( final FutureTask<Void> task )
    {
        this.jobs.add ( task );
    }

    protected void removeJob ( final Future<Void> future )
    {
        this.jobLock.lock ();
        try
        {
            this.jobs.remove ( future );
            this.jobCondition.signalAll ();
        }
        finally
        {
            this.jobLock.unlock ();
        }
    }

    public StorageInformation getStorageInformation ()
    {
        final StorageConfiguration configuration = new StorageConfiguration ( this.nativeLevel.getTimeSlice (), this.nativeLevel.getCount () );
        final StorageInformation information = new StorageInformation ( this.id, this.file, configuration );
        return information;
    }

    @Override
    public HistoricalItemInformation getInformation ()
    {
        final Map<String, Variant> properties = new HashMap<String, Variant> ( 0 );
        final HistoricalItemInformation info = new HistoricalItemInformation ( this.id, properties );
        return info;
    }

    protected static interface QueryRunnable
    {
        public void run ( final QueryImpl query ) throws Exception;
    }

    protected void runOnQuery ( final QueryRunnable runnable )
    {
        this.readLock.lock ();
        try
        {
            for ( final QueryImpl query : this.queries )
            {
                try
                {
                    runnable.run ( query );
                }
                catch ( final Exception e )
                {
                    logger.warn ( "Failed to run query update", e );
                }
            }
        }
        finally
        {
            this.readLock.unlock ();
        }
    }

    protected void handleStoreChanged ( final Date start, final Date end )
    {
        runOnQuery ( new QueryRunnable () {

            @Override
            public void run ( final QueryImpl query ) throws Exception
            {
                if ( query.isUpdateData () )
                {
                    AbstractStorageImpl.this.queryExecutor.execute ( new Runnable () {
                        @Override
                        public void run ()
                        {
                            query.dataChanged ( start, end );
                        };
                    } );
                }
            }
        } );
    }

    protected void notifyData ( final double value, final Date timestamp, final boolean error, final boolean manual )
    {
        runOnQuery ( new QueryRunnable () {

            @Override
            public void run ( final QueryImpl query ) throws Exception
            {
                if ( query.isUpdateData () )
                {
                    AbstractStorageImpl.this.queryExecutor.execute ( new Runnable () {
                        @Override
                        public void run ()
                        {
                            query.updateData ( value, timestamp, error, manual );
                        };
                    } );
                }
            }
        } );
    }

    @Override
    public Query createQuery ( final QueryParameters parameters, final QueryListener listener, final boolean updateData )
    {
        this.writeLock.lock ();

        try
        {
            if ( this.disposed )
            {
                logger.warn ( "Unable to create query. We are disposed" );
                return null;
            }

            final QueryImpl query = new QueryImpl ( this, this.queryExecutor, this.eventExecutor, parameters, listener, updateData, null, null );

            this.queries.add ( query );

            return query;
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    @Override
    public void queryClosed ( final QueryImpl query )
    {
        this.writeLock.lock ();
        try
        {
            this.queries.remove ( query );
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    @Override
    public boolean visit ( final QueryParameters parameters, final ValueVisitor visitor )
    {
        return this.nativeLevel.visit ( visitor, new Date ( parameters.getStartTimestamp () ), new Date ( parameters.getEndTimestamp () ) );
    }

    public void dispose ()
    {
        this.writeLock.lock ();
        try
        {
            // mark disposed
            this.disposed = true;

        }
        finally
        {
            this.writeLock.unlock ();
        }

        this.jobLock.lock ();
        try
        {
            // close queries
            final Set<QueryImpl> queries = new HashSet<QueryImpl> ( this.queries );
            for ( final QueryImpl query : queries )
            {
                query.close ();
            }
            this.queries.clear ();

            // dispose updates
            while ( !this.jobs.isEmpty () )
            {
                try
                {
                    this.jobCondition.await ();
                }
                catch ( final InterruptedException e )
                {
                    logger.warn ( "Failed to wait for update jobs", e );
                    Thread.interrupted ();
                    break;
                }
            }

            // dispose levels
            this.nativeLevel.dispose ();
        }
        finally
        {
            this.jobLock.unlock ();
        }
    }

}
