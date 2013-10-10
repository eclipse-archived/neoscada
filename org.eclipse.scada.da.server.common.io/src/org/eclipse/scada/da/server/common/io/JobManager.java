/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common.io;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.apache.mina.core.session.IoSession;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobManager
{
    private final static Logger logger = LoggerFactory.getLogger ( JobManager.class );

    private IoSession session;

    private final Map<String, PollRequest> blocks = new HashMap<String, PollRequest> ();

    private final ScheduledExecutorService executor;

    private ScheduledFuture<?> job;

    private Job currentJob;

    private final Queue<Job> writeQueue = new ConcurrentLinkedQueue<Job> ();

    private ScheduledExecutorService createdExector;

    private static interface Job
    {
        public void handleMessage ( final Object message );

        public long getTimeoutTime ();

        public void start ( IoSession session );

        public void handleTimeout ();
    }

    private static abstract class BaseJob implements Job
    {
        private final long timeoutTime;

        public BaseJob ( final long timeout )
        {
            this.timeoutTime = timeout > 0 ? System.currentTimeMillis () + timeout : 0;
            logger.trace ( "Job timeout: {} -> {}", timeout, this.timeoutTime );
        }

        @Override
        public long getTimeoutTime ()
        {
            return this.timeoutTime;
        }
    }

    private static class ReadJob extends BaseJob
    {
        private final PollRequest block;

        public ReadJob ( final PollRequest block )
        {
            super ( block.getPollRequestTimeout () );
            this.block = block;
        }

        @Override
        public void handleMessage ( final Object message )
        {
            logger.debug ( "Result: {} - for: {}", message, this.block );

            if ( !this.block.handleMessage ( message ) )
            {
                logger.warn ( "Got wrong message as reply: {}", message );
                this.block.handleFailure ();
            }
        }

        @Override
        public void handleTimeout ()
        {
            this.block.handleTimeout ();
        }

        @Override
        public void start ( final IoSession session )
        {
            final Object request = this.block.createPollRequest ();
            logger.debug ( "Start request: {}", request );
            session.write ( request );
        }

        @Override
        public String toString ()
        {
            return String.format ( "[ReadJob: %s, timeoutTime: %s]", this.block, getTimeoutTime () );
        }
    }

    private static class WriteJob extends BaseJob
    {
        private final Object request;

        public WriteJob ( final Object request, final long timeout )
        {
            super ( timeout );
            this.request = request;
        }

        @Override
        public void start ( final IoSession session )
        {
            session.write ( this.request );
        }

        @Override
        public void handleTimeout ()
        {
            // TODO: no-op for now 
        }

        @Override
        public void handleMessage ( final Object message )
        {
            // TODO: no-op for now
        }
    }

    public JobManager ( final String threadName )
    {
        this.executor = this.createdExector = Executors.newSingleThreadScheduledExecutor ( new NamedThreadFactory ( threadName ) );
    }

    public JobManager ( final ScheduledExecutorService executor )
    {
        this.executor = executor;
        this.createdExector = null;
    }

    public synchronized void setSession ( final IoSession session )
    {
        logger.debug ( "Setting session: {}", session );

        this.session = session;
        setTimerState ( session != null );
        if ( session == null )
        {
            this.currentJob = null;
            // discard write requests
            this.writeQueue.clear ();
            // handle data disconnect
            handleDataDisconnected ();
        }
    }

    private void setTimerState ( final boolean flag )
    {
        final boolean currentState = this.job != null;

        if ( currentState == flag )
        {
            logger.info ( "Timer is in correct state: {} / {}", new Object[] { currentState, flag } );
            return;
        }

        if ( flag )
        {
            logger.info ( "Starting timer" );
            this.job = this.executor.scheduleWithFixedDelay ( new Runnable () {

                @Override
                public void run ()
                {
                    JobManager.this.tick ();
                }
            }, 0, 100, TimeUnit.MILLISECONDS );
        }
        else
        {
            logger.info ( "Stopping timer" );
            this.job.cancel ( false );
            this.job = null;
        }
    }

    public synchronized void messageReceived ( final Object message )
    {
        logger.trace ( "messageReceived - currentJob: {}, message: {}", this.currentJob, message );

        if ( this.currentJob != null )
        {
            try
            {
                this.currentJob.handleMessage ( message );
            }
            finally
            {
                this.currentJob = null;
                startNextJob ();
            }
        }
        else
        {
            logger.warn ( "Message without a job: {}", message );
        }
    }

    protected synchronized void tick ()
    {
        if ( this.currentJob != null )
        {
            logger.trace ( "Ticked with current job" );
            if ( isCurrentJobTimeout () )
            {
                handleTimeout ();
            }
            return;
        }

        logger.info ( "No job active when ticking... adding job!" );
        startNextJob ();
        logger.info ( "New job: {}", this.currentJob );
    }

    protected boolean isCurrentJobTimeout ()
    {
        return this.currentJob.getTimeoutTime () > 0 && this.currentJob.getTimeoutTime () < System.currentTimeMillis ();
    }

    private void handleTimeout ()
    {
        logger.debug ( "Job timed out: {}", this.currentJob );

        this.currentJob.handleTimeout ();
        this.currentJob = null;

        startNextJob ();
    }

    private void startNextJob ()
    {
        this.currentJob = getNextWriteJob ();
        if ( this.currentJob == null )
        {
            this.currentJob = getNextReadJob ();
        }

        logger.debug ( "Next job: {}", this.currentJob );

        if ( this.currentJob != null )
        {
            this.currentJob.start ( this.session );
        }
    }

    /**
     * Get the next read job
     * 
     * @return the next read job or <code>null</code> if no blocks need to be
     *         refreshed
     */
    private Job getNextReadJob ()
    {

        final long now = System.currentTimeMillis ();

        final PollRequest request = findNextBestPollRequest ( now );

        if ( request != null )
        {
            return new ReadJob ( request );
        }
        else
        {
            return null;
        }
    }

    private PollRequest findNextBestPollRequest ( final long now )
    {
        PollRequest nextRequest = null;
        long nextPriority = 0;
        for ( final PollRequest request : this.blocks.values () )
        {
            final Long priority = request.updatePriority ( now );

            logger.trace ( "Checking request: {} - {}", priority, request );

            if ( priority == null )
            {
                continue;
            }

            if ( nextRequest == null )
            {
                logger.trace ( "First request" );
                nextRequest = request;
                nextPriority = priority;
            }
            else if ( priority > nextPriority )
            {
                logger.trace ( "Better request" );
                nextRequest = request;
                nextPriority = priority;
            }
        }

        return nextRequest;
    }

    /**
     * Get the next job from the write queue if there is any
     * 
     * @return the next write job or <code>null</code> if there is none
     */
    private Job getNextWriteJob ()
    {
        return this.writeQueue.poll ();
    }

    public void dispose ()
    {
        synchronized ( this )
        {
            for ( final PollRequest block : this.blocks.values () )
            {
                block.dispose ();
            }

            if ( this.job != null )
            {
                this.job.cancel ( false );
            }
        }

        if ( this.createdExector != null )
        {
            this.createdExector.shutdown ();
        }
    }

    protected void handleDataDisconnected ()
    {
        for ( final PollRequest block : this.blocks.values () )
        {
            block.handleDisconnect ();
        }
    }

    public synchronized void addBlock ( final String id, final PollRequest block )
    {
        logger.debug ( "Adding block: {}", id );

        if ( this.blocks.containsKey ( id ) )
        {
            throw new IllegalArgumentException ( String.format ( "Block '%s' is already registered with device", id ) );
        }

        this.blocks.put ( id, block );
    }

    public synchronized void removeBlock ( final String id )
    {
        logger.debug ( "Removing block: {}", id );

        final PollRequest oldBlock = this.blocks.remove ( id );
        if ( oldBlock != null )
        {
            oldBlock.dispose ();
        }
    }

    public void addWriteRequest ( final Object request, final long timeout )
    {
        this.writeQueue.add ( new WriteJob ( request, timeout ) );
    }

}
