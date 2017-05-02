/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.io.common;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.apache.mina.core.filterchain.IoFilter.NextFilter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * this implements a {@link ProtocolDecoder} which detects a frame end
 * based on the absence of new data (timeout).
 * <p>
 * Some protocol use a timeout to detect a frame end. e.g. Modbus defines a
 * <q>end-of-frame</q> as a timeout of x milliseconds in which no data is sent.
 * This decoder helps to implement such protocols.
 * <p>
 * In order to use it you will need to derive your class from this one and
 * implement {@link #timeout(IoSession, ProtocolDecoderOutput)} which will be
 * called in the case of the timeout. The timeout detect will be started by
 * calling {@link #tick(IoSession, ProtocolDecoderOutput)}. It will remember the
 * output and pass it later on to the
 * {@link #timeout(IoSession, ProtocolDecoderOutput)} call. So when you read
 * data in your
 * {@link ProtocolDecoder#decode(IoSession, org.apache.mina.common.ByteBuffer, ProtocolDecoderOutput)}
 * you simply call {@link #tick(IoSession, ProtocolDecoderOutput)} and the
 * timeout is started or pushed back if it was already started.
 * <p>
 * If you need to clear the timeout use {@link #clear(IoSession)}
 * 
 * @author Jens Reimann
 */
public abstract class TimedEndDecoder implements ProtocolDecoder
{
    private final static Logger LOGGER = LoggerFactory.getLogger ( TimedEndDecoder.class );

    private static final String CONTEXT = "timedEndContext";

    private final Set<Context> contextSet = new CopyOnWriteArraySet<Context> ();

    private final ScheduledExecutorService scheduler;

    private ScheduledFuture<?> job;

    private final long timeout;

    protected NextFilter nextFilter;

    /**
     * Create a new instance
     * 
     * @param scheduler
     *            the scheduler to use for cyclic jobs
     * @param timeout
     *            the timeout in milliseconds for the end-of-frame detection
     */
    public TimedEndDecoder ( final ScheduledExecutorService scheduler, final long timeout, final TimeUnit timeUnit )
    {
        this.scheduler = scheduler;
        this.timeout = TimeUnit.MILLISECONDS.convert ( timeout, timeUnit );
        LOGGER.debug ( "Running with a timeout of {} ms", this.timeout );
    }

    private synchronized void addJob ()
    {
        if ( this.job == null )
        {
            this.job = this.scheduler.scheduleAtFixedRate ( new Runnable () {

                @Override
                public void run ()
                {
                    tick ();
                }
            }, this.timeout, this.timeout, TimeUnit.MILLISECONDS );
        }
    }

    private synchronized void removeJob ()
    {
        if ( this.job != null )
        {
            this.job.cancel ( true );
            this.job = null;
        }
    }

    protected void tick ()
    {
        LOGGER.trace ( "Checking contexts" );

        int i = 0;

        // check each registered context object
        for ( final Context ctx : this.contextSet )
        {
            ctx.check ();
            i++;
        }

        LOGGER.trace ( "Checked {}", i );
    }

    @Override
    public void dispose ( final IoSession session ) throws Exception
    {
        // remove the context from the session and kill the cyclic check
        final Context ctx = (Context)session.getAttribute ( CONTEXT );
        if ( ctx != null )
        {
            unregisterContext ( ctx );
            ctx.dispose ();
            session.removeAttribute ( CONTEXT );
        }
    }

    /**
     * Register a context and start the cyclic job if needed
     * 
     * @param ctx
     *            the context to add
     */
    private synchronized void registerContext ( final Context ctx )
    {
        this.contextSet.add ( ctx );
        if ( this.contextSet.size () == 1 )
        {
            // start thread
            addJob ();
        }
    }

    /**
     * Unregister a context and stop the cyclic job if needed
     * 
     * @param ctx
     *            the context to remove
     */
    private synchronized void unregisterContext ( final Context ctx )
    {
        this.contextSet.remove ( ctx );
        if ( this.contextSet.isEmpty () )
        {
            // stop thread
            removeJob ();
        }
    }

    /**
     * Handle the timeout situation
     * 
     * @param session
     *            the session for which the timeout occurred
     * @param out
     *            the output
     */
    public abstract void timeout ( IoSession session, ProtocolDecoderOutput out ) throws Exception;

    private void wrapTimeout ( final IoSession session, final ProtocolDecoderOutput out )
    {
        try
        {
            timeout ( session, out );
        }
        catch ( final Throwable e )
        {
            try
            {
                session.getHandler ().exceptionCaught ( session, e );
            }
            catch ( final Throwable ee )
            {
                LOGGER.warn ( "Exception was thrown during handling Exception", ee );
            }
        }
    }

    /**
     * Start or tick the end-of-frame detection for this session
     * 
     * @param session
     *            the session
     * @param out
     *            the protocol decoder output to use for the finished frame
     */
    public void tick ( final IoSession session, final ProtocolDecoderOutput out )
    {
        getTimedContext ( session, true ).tick ( out );
    }

    /**
     * Clear the end-of-frame detection for this session
     * 
     * @param session
     *            the session
     */
    public void clear ( final IoSession session )
    {
        final Context ctx = getTimedContext ( session, false );
        if ( ctx != null )
        {
            ctx.clear ();
        }
    }

    /**
     * Get the context for a session
     * 
     * @param session
     *            the session
     * @return the context
     */
    private Context getTimedContext ( final IoSession session, final boolean create )
    {
        Context ctx = (Context)session.getAttribute ( CONTEXT );
        if ( ctx == null && create )
        {
            ctx = new Context ( this, this.timeout, session );
            registerContext ( ctx );
            session.setAttribute ( CONTEXT, ctx );
        }
        return ctx;
    }

    private class Context
    {
        private Long lastData = null;

        private final TimedEndDecoder decoder;

        private final long timeout;

        private final IoSession session;

        private boolean disposed = false;

        private ProtocolDecoderOutput out;

        public Context ( final TimedEndDecoder decoder, final long timeout, final IoSession session )
        {
            this.decoder = decoder;
            this.timeout = timeout;
            this.session = session;
        }

        public synchronized void tick ( final ProtocolDecoderOutput out )
        {
            this.lastData = System.currentTimeMillis ();
            this.out = out;
        }

        public synchronized void clear ()
        {
            this.lastData = null;
            this.out = null;
        }

        public synchronized void check ()
        {
            if ( this.disposed )
            {
                return;
            }

            if ( this.lastData == null )
            {
                return;
            }

            if ( System.currentTimeMillis () - this.lastData > this.timeout )
            {
                final ProtocolDecoderOutput out = this.out;
                clear ();
                this.decoder.wrapTimeout ( this.session, out );
            }
        }

        public synchronized void dispose ()
        {
            this.disposed = true;
        }
    }

    public synchronized void setNextFilter ( final NextFilter nextFilter )
    {
        this.nextFilter = nextFilter;
    }

}
