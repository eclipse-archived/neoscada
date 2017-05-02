/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - change interface for forward correction
 *******************************************************************************/
package org.eclipse.scada.hds;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.scada.utils.lang.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataFilePool
{

    private final static Logger logger = LoggerFactory.getLogger ( DataFilePool.class );

    private class AccessorWrapper implements DataFileAccessor
    {

        private final DataFileAccessor accessor;

        private final File file;

        private long accesses;

        private Date lastAccess = new Date ();

        public AccessorWrapper ( final File file, final DataFileAccessor accessor )
        {
            this.file = file;
            this.accessor = accessor;
        }

        @Override
        public void insertValue ( final double value, final Date date, final boolean error, final boolean manual, final boolean heartbeat ) throws IOException
        {
            check ();
            this.accessor.insertValue ( value, date, error, manual, heartbeat );
        }

        @Override
        public boolean visit ( final ValueVisitor visitor ) throws Exception
        {
            check ();
            return this.accessor.visit ( visitor );
        }

        @Override
        public boolean visitFirstValue ( final ValueVisitor visitor ) throws Exception
        {
            check ();
            return this.accessor.visitFirstValue ( visitor );
        }

        @Override
        public void forwardCorrect ( final double value, final Date date ) throws Exception
        {
            check ();
            this.accessor.forwardCorrect ( value, date );
        }

        @Override
        public Date getStart ()
        {
            return this.accessor.getStart ();
        }

        @Override
        public Date getEnd ()
        {
            return this.accessor.getEnd ();
        }

        @Override
        public void delete ()
        {
            check ();
            this.accessor.delete ();
            dispose ();
        }

        @Override
        public void dispose ()
        {
            giveBack ( this );
        }

        public File getFile ()
        {
            return this.file;
        }

        public DataFileAccessor getTarget ()
        {
            return this.accessor;
        }

        protected void check ()
        {
            this.accesses++;
            this.lastAccess = new Date ();
        }

        @SuppressWarnings ( "unused" )
        public long getAccesses ()
        {
            return this.accesses;
        }

        public Date getLastAccess ()
        {
            return this.lastAccess;
        }

    }

    private static final long LOCK_TIME = 10 * 1000;

    private final Lock lock = new ReentrantLock ();

    private final Condition condition = this.lock.newCondition ();

    private final long timeout;

    private final Map<File, AccessorWrapper> freePool = new HashMap<File, AccessorWrapper> ();

    private final Map<File, AccessorWrapper> usedPool = new HashMap<File, AccessorWrapper> ();

    private boolean disposed;

    private int instanceCountTarget;

    public DataFilePool ( final int instanceCountTarget )
    {
        this ( LOCK_TIME );
        this.instanceCountTarget = instanceCountTarget;
    }

    /**
     * Create a new data file pool
     *
     * @param timeout
     *            in milliseconds
     */
    public DataFilePool ( final long timeout )
    {
        this.timeout = timeout;
    }

    public DataFileAccessor getAccessor ( final File file ) throws Exception
    {
        final Pair<DataFileAccessor, Boolean> result = getAccessor ( file, null, null, false );
        if ( result == null )
        {
            return null;
        }
        return result.first;
    }

    /**
     * get access to a file
     * <p>
     * If the parameter <code>create</code> is <code>true</code> then start and
     * end must not be null
     * </p>
     *
     * @param file
     *            the file to get access to
     * @param start
     *            the start date required for creating the file, can be
     *            <code>null</code> if <code>create</code> is <code>false</code>
     * @param end
     *            the end date required for creating the file, can be
     *            <code>null</code> if <code>create</code> is <code>false</code>
     * @param create
     *            <code>true</code> will create a new file it if the file does
     *            not currently exists
     * @return the accessor information
     * @throws Exception
     *             if anything goes wrong
     */
    public Pair<DataFileAccessor, Boolean> getAccessor ( final File file, final Date start, final Date end, final boolean create ) throws Exception
    {
        final Date deadline = new Date ( System.currentTimeMillis () + this.timeout );

        logger.debug ( "Looking for file: {}", file );

        if ( this.lock.tryLock ( this.timeout, TimeUnit.MILLISECONDS ) )
        {
            if ( this.disposed )
            {
                throw new IllegalStateException ( "Pool is disposed" );
            }

            try
            {
                if ( file.exists () )
                {
                    logger.debug ( "File exists" );
                    return new Pair<DataFileAccessor, Boolean> ( waitForFile ( file, deadline ), false );
                }
                else if ( create )
                {
                    logger.debug ( "File does not exists and we are requested to create" );
                    final AccessorWrapper result = wrap ( file, DataFileAccessorImpl.create ( file, start, end ) );
                    this.usedPool.put ( file, result );
                    return new Pair<DataFileAccessor, Boolean> ( result, true );
                }
                else
                {
                    logger.debug ( "File does not exists and no request to create" );
                    return null;
                }
            }
            finally
            {
                this.lock.unlock ();
            }
        }
        else
        {
            throw new IllegalStateException ( String.format ( "Failed to acquire create lock within %s ms", this.timeout ) );
        }
    }

    private AccessorWrapper waitForFile ( final File file, final Date deadline ) throws Exception
    {
        logger.info ( "Waiting until {} for {}", deadline, file );

        final long startTix = System.currentTimeMillis ();

        try
        {
            do
            {
                if ( this.usedPool.containsKey ( file ) )
                {
                    // still used, wait again
                    continue;
                }

                final AccessorWrapper result = this.freePool.remove ( file );
                if ( result != null )
                {
                    logger.debug ( "Fetching file {} from free pool", file );
                    // mark as used
                    this.usedPool.put ( file, result );
                    // success, bring it home
                    return result;
                }

                // resource was neither used nor free, so we need to create it
                final AccessorWrapper newResult = wrap ( file, new DataFileAccessorImpl ( file ) );
                this.usedPool.put ( file, newResult );
                logger.debug ( "Acquired resource {} by creating accessor", file );
                return newResult;
            } while ( this.condition.awaitUntil ( deadline ) );

            throw new IllegalStateException ( String.format ( "Failed to acquire create lock within %s ms for resource %s", this.timeout, file ) );
        }
        finally
        {
            logger.info ( "Waiting took {} ms", System.currentTimeMillis () - startTix );
        }
    }

    protected AccessorWrapper wrap ( final File file, final DataFileAccessor accessor )
    {
        // we need to lock here
        this.lock.lock ();
        try
        {
            closeUnused ();
            return new AccessorWrapper ( file, accessor );
        }
        finally
        {
            this.lock.unlock ();
        }
    }

    private void closeUnused ()
    {
        final int instances = this.usedPool.size () + this.freePool.size ();

        int num = instances - this.instanceCountTarget;

        if ( num <= 0 )
        {
            return;
        }

        logger.debug ( "Trying to reduce by {}", num );

        final LinkedList<AccessorWrapper> entries = new LinkedList<AccessorWrapper> ( this.freePool.values () );

        // sort by access date
        Collections.sort ( entries, new Comparator<AccessorWrapper> () {
            @Override
            public int compare ( final AccessorWrapper o1, final AccessorWrapper o2 )
            {
                return o1.getLastAccess ().compareTo ( o2.getLastAccess () );
            }

        } );

        while ( !this.freePool.isEmpty () && !entries.isEmpty () && num > 0 )
        {
            final AccessorWrapper entry = entries.pollLast ();

            logger.debug ( "Removing {} from pool", entry.getFile () );
            this.freePool.remove ( entry.getFile () );
            entry.getTarget ().dispose ();

            num--;
        }
    }

    public void giveBack ( final AccessorWrapper accessor )
    {
        logger.debug ( "Giving back: {}", accessor.getFile () );

        this.lock.lock ();
        try
        {
            if ( this.usedPool.remove ( accessor.getFile () ) != null )
            {
                this.freePool.put ( accessor.getFile (), accessor );
            }
            this.condition.signalAll ();
        }
        finally
        {
            this.lock.unlock ();
        }
    }

    public void dispose ()
    {
        this.lock.lock ();
        try
        {
            // mark disposed
            this.disposed = true;

            // wait for resources
            while ( !this.usedPool.isEmpty () )
            {
                while ( !this.condition.await ( 30, TimeUnit.SECONDS ) )
                {
                    logger.warn ( "Still waiting for resources to be returned" );
                }
            }
        }
        catch ( final InterruptedException e )
        {
            logger.warn ( "Failed to await end of dispose", e );
            return;
        }
        finally
        {
            try
            {
                // dipose what is possible to dispose
                disposeFreePool ();
            }
            finally
            {
                this.lock.unlock ();
            }
        }

    }

    private void disposeFreePool ()
    {
        for ( final Map.Entry<File, AccessorWrapper> wrapper : this.freePool.entrySet () )
        {
            try
            {
                wrapper.getValue ().getTarget ().dispose ();
            }
            catch ( final Exception e )
            {
                logger.warn ( String.format ( "Failed to dispose %s", wrapper.getKey () ), e );
            }
        }
        this.freePool.clear ();
    }
}
