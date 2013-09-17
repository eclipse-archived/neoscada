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

import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.management.ManagementFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.eclipse.scada.ds.DataNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BufferingStorageDao implements BufferingStorageDaoMXBean, JdbcStorageDao
{

    private final static Logger logger = LoggerFactory.getLogger ( BufferingStorageDao.class );

    private final JdbcStorageDao targetDao;

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock ();

    private final ReadLock readLock = this.lock.readLock ();

    private final WriteLock writeLock = this.lock.writeLock ();

    private Map<String, DataNode> queueMap = new HashMap<String, DataNode> ();

    private Map<String, DataNode> writeMap = new HashMap<String, DataNode> ();

    private final Condition writeCondition = this.writeLock.newCondition ();

    private boolean disposed;

    private volatile Thread writerThread;

    private final MBeanServer mbs;

    private ObjectName name;

    /**
     * Create a new buffering storage DAO
     * <p>
     * Requests will be passed on to the target DAO as necessary. The target DOA
     * will be disposed by this class.
     * </p>
     * 
     * @param targetDao
     *            the target DAO
     */
    public BufferingStorageDao ( final JdbcStorageDao targetDao )
    {
        this.targetDao = targetDao;
        startWriter ();

        this.mbs = ManagementFactory.getPlatformMBeanServer ();

        try
        {
            this.name = new ObjectName ( "org.eclipse.scada.ds.storage.jdbc.JdbcStorageDao", "key", "BufferingStorageDao" );
            this.mbs.registerMBean ( this, this.name );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to export", e );
        }
    }

    protected synchronized void startWriter ()
    {
        if ( this.disposed )
        {
            logger.warn ( "We are disposed. Not starting writer" );
            return;
        }

        this.writerThread = new Thread ( "BufferingStorageDao" ) {
            @Override
            public void run ()
            {
                writer ();
            }
        };
        this.writerThread.start ();
        this.writerThread.setUncaughtExceptionHandler ( new UncaughtExceptionHandler () {

            @Override
            public void uncaughtException ( final Thread t, final Throwable e )
            {
                logger.error ( "Writer thread failed. Restarting ...", e );
                startWriter ();
            }
        } );
    }

    @Override
    public Collection<DataNode> readAllNodes ()
    {
        try
        {
            this.readLock.lock ();
            if ( this.disposed )
            {
                return null;
            }

            // read all data nodes by ...

            final Set<DataNode> result = new HashSet<DataNode> ();

            // ... reading from target first
            result.addAll ( this.targetDao.readAllNodes () );
            // ... override with writeMap
            result.addAll ( this.writeMap.values () );
            // ... override with queueMap
            result.addAll ( this.queueMap.values () );

            // return result
            return result;
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

            if ( this.disposed )
            {
                return null;
            }

            if ( this.queueMap.containsKey ( nodeId ) )
            {
                return this.queueMap.get ( nodeId );
            }
            else if ( this.writeMap.containsKey ( nodeId ) )
            {
                return this.writeMap.get ( nodeId );
            }
            else
            {
                return this.targetDao.readNode ( nodeId );
            }
        }
        finally
        {
            this.readLock.unlock ();
        }
    }

    @Override
    public void writeNode ( final DataNode node )
    {
        try
        {
            this.writeLock.lock ();

            if ( this.disposed )
            {
                return;
            }

            this.queueMap.put ( node.getId (), node );

            this.writeCondition.signal ();
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    @Override
    public void deleteNode ( final String nodeId )
    {
        try
        {
            this.writeLock.lock ();
            if ( this.disposed )
            {
                return;
            }

            this.queueMap.put ( nodeId, null );

            this.writeCondition.signal ();
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    protected void writer ()
    {
        logger.info ( "Starting writer" );
        while ( true )
        {
            // transfer from queue to write map
            try
            {
                this.writeLock.lock ();

                // timed wait in order to process re-tries
                this.writeCondition.await ( 1, TimeUnit.MINUTES );

                this.writeMap.putAll ( this.queueMap );
                this.queueMap = new HashMap<String, DataNode> ();
            }
            catch ( final InterruptedException e )
            {
                // just checking
            }
            finally
            {
                this.writeLock.unlock ();
            }

            // process writes
            final Map<String, DataNode> failMap = performWrites ();

            // remove from write queue
            try
            {
                this.writeLock.lock ();

                // re-add all failed entries
                this.writeMap = new HashMap<String, DataNode> ( failMap );
            }
            finally
            {
                this.writeLock.unlock ();
            }

            // check exit condition
            try
            {
                this.readLock.lock ();

                if ( !this.writeMap.isEmpty () )
                {
                    logger.error ( "Write map still contains {} entries but we are exiting!", this.writeMap.size () );
                }

                if ( this.disposed )
                {
                    logger.info ( "Detected shutdown signal" );
                    // dispose target
                    this.targetDao.dispose ();
                    // exit loop
                    return;
                }
            }
            finally
            {
                this.readLock.unlock ();
            }
        }
    }

    private Map<String, DataNode> performWrites ()
    {
        final Map<String, DataNode> failMap = new HashMap<String, DataNode> ( this.writeMap.size () );

        for ( final Map.Entry<String, DataNode> entry : this.writeMap.entrySet () )
        {
            try
            {
                if ( entry.getValue () == null )
                {
                    this.targetDao.deleteNode ( entry.getKey () );
                }
                else
                {
                    this.targetDao.writeNode ( entry.getValue () );
                }

            }
            catch ( final Exception e )
            {
                failMap.put ( entry.getKey (), entry.getValue () );
                logger.warn ( "Failed to store data node", e );
            }
        }

        return failMap;
    }

    /**
     * This will dispose ourself and the target dao
     */
    @Override
    public void dispose ()
    {
        shutdown ();

        // at the moment we do not wait for the end
        try
        {
            this.writerThread.join ( 5000 );
            if ( this.writerThread.isAlive () )
            {
                logger.warn ( "Writer thread is still alive after 5000ms" );
            }
        }
        catch ( final InterruptedException e )
        {
            // consuming interruption
            logger.warn ( "Failed to wait for end of writer", e );
        }

        try
        {
            this.mbs.unregisterMBean ( this.name );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to unregister: " + this.name, e );
        }
    }

    private void shutdown ()
    {
        try
        {
            this.writeLock.lock ();
            this.disposed = true;
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    @Override
    public int getQueueSize ()
    {
        try
        {
            this.readLock.lock ();
            return this.queueMap.size ();
        }
        finally
        {
            this.readLock.unlock ();
        }
    }
}
