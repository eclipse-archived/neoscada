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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.eclipse.scada.ds.DataNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CachingStorageDao implements JdbcStorageDao
{

    private final static Logger logger = LoggerFactory.getLogger ( CachingStorageDao.class );

    private final JdbcStorageDao targetDao;

    private final Map<String, DataNode> cacheMap;

    private final ReadWriteLock lock = new ReentrantReadWriteLock ();

    private final Lock readLock = this.lock.readLock ();

    private final Lock writeLock = this.lock.writeLock ();

    private final ScheduledFuture<?> clearCacheFuture;

    public CachingStorageDao ( final JdbcStorageDao targetDao, final ScheduledExecutorService scheduler, final long cleanUpCacheDelay )
    {
        if ( targetDao == null )
        {
            throw new IllegalArgumentException ( "'targetDao' must not be null" );
        }
        if ( scheduler == null )
        {
            throw new IllegalArgumentException ( "'scheduler' must not be null" );
        }
        this.targetDao = targetDao;
        try
        {
            this.writeLock.lock ();

            logger.info ( "Starting cache prefill" );

            final Collection<DataNode> nodes = targetDao.readAllNodes ();
            this.cacheMap = new HashMap<String, DataNode> ( nodes.size () );

            logger.debug ( "Prefill found {} entries", nodes.size () );

            for ( final DataNode node : nodes )
            {
                this.cacheMap.put ( node.getId (), node );
            }

            logger.info ( "Prefill complete" );

            this.clearCacheFuture = scheduler.schedule ( new Runnable () {
                @Override
                public void run ()
                {
                    CachingStorageDao.this.clearCache ();
                }
            }, cleanUpCacheDelay, TimeUnit.SECONDS );
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    @Override
    public Collection<DataNode> readAllNodes ()
    {
        try
        {
            this.readLock.lock ();
            return new ArrayList<DataNode> ( this.cacheMap.values () );
        }
        finally
        {
            this.readLock.unlock ();
        }
    }

    @Override
    public DataNode readNode ( final String nodeId )
    {
        try
        {
            this.readLock.lock ();
            if ( this.cacheMap.containsKey ( nodeId ) )
            {
                return this.cacheMap.get ( nodeId );
            }
        }
        finally
        {
            this.readLock.unlock ();
        }

        // releasing all locks could cause multiple reads, but this is ok
        final DataNode dataNode = this.targetDao.readNode ( nodeId );

        try
        {
            this.writeLock.lock ();
            // check if entry was inserted meanwhile (might be a write)
            if ( this.cacheMap.containsKey ( nodeId ) )
            {
                return this.cacheMap.get ( nodeId );
            }
            this.cacheMap.put ( nodeId, dataNode );
            return dataNode;
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    @Override
    public void writeNode ( final DataNode node )
    {
        try
        {
            this.writeLock.lock ();
            this.cacheMap.put ( node.getId (), node );
        }
        finally
        {
            this.writeLock.unlock ();
        }
        this.targetDao.writeNode ( node );
    }

    @Override
    public void deleteNode ( final String nodeId )
    {
        try
        {
            this.writeLock.lock ();
            this.cacheMap.remove ( nodeId );
        }
        finally
        {
            this.writeLock.unlock ();
        }
        this.targetDao.deleteNode ( nodeId );
    }

    private void clearCache ()
    {
        logger.info ( "clearing cache" );
        try
        {
            this.writeLock.lock ();
            this.cacheMap.clear ();
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    @Override
    public void dispose ()
    {
        if ( this.clearCacheFuture != null )
        {
            this.clearCacheFuture.cancel ( false );
        }
        clearCache ();
        this.targetDao.dispose ();
    }

}
