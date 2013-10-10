/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.hd.server.storage.common;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hds.ValueVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryImpl implements Query
{

    private final static Logger logger = LoggerFactory.getLogger ( QueryImpl.class );

    private final ValueSourceManager storage;

    private final ExecutorService executor;

    private final QueryListener listener;

    private final boolean updateData;

    private final QueryBuffer buffer;

    private static class LoadState
    {
        private final boolean loading;

        private final boolean closed;

        private final QueryParameters parameters;

        public LoadState ( final boolean closed, final boolean loading, final QueryParameters parameters )
        {
            super ();
            this.closed = closed;
            this.loading = loading;

            this.parameters = parameters;
        }

        public QueryParameters getParameters ()
        {
            return this.parameters;
        }

        public boolean isLoading ()
        {
            return this.loading;
        }

        public boolean isClosed ()
        {
            return this.closed;
        }

        @Override
        public String toString ()
        {
            return String.format ( "[loading: %s, closed: %s, parameters: %s]", this.loading, this.closed, this.parameters );
        }
    }

    private final AtomicReference<LoadState> state = new AtomicReference<LoadState> ();

    /**
     * Create a new common query
     * 
     * @param storage
     *            the value source manager
     * @param executor
     *            a single threaded executor for posting events
     * @param eventExecutor
     * @param parameters
     *            the initial query parameters
     * @param listener
     *            the query listener, must not be <code>null</code>
     * @param updateData
     *            request data updates
     * @param fixedStartDate
     *            an optional fixed start date before which all query data is
     *            invalid
     * @param fixedEndDate
     *            an optional fixed end date after which all query data is
     *            invalid
     */
    public QueryImpl ( final ValueSourceManager storage, final ScheduledExecutorService executor, final ScheduledExecutorService eventExecutor, final QueryParameters parameters, final QueryListener listener, final boolean updateData, final Date fixedStartDate, final Date fixedEndDate )
    {
        this.storage = storage;
        this.executor = executor;
        this.listener = listener;
        this.updateData = updateData;

        this.buffer = new QueryBuffer ( this.listener, eventExecutor, fixedStartDate, fixedEndDate );

        this.state.set ( new LoadState ( false, false, parameters ) );

        changeParameters ( parameters, true );
    }

    @Override
    public void close ()
    {
        if ( !requestClose () )
        {
            return;
        }

        // we should wait here for the close to be acknowledged by the loader
        while ( this.state.get ().isLoading () )
        {
            logger.debug ( "Waiting for loader to complete" );
            try
            {
                // FIXME: waiting should not be time based
                Thread.sleep ( 100 );
            }
            catch ( final InterruptedException e )
            {
                logger.warn ( "Got interrupted while waiting for loader to complete", e );
                break;
            }
        }

        this.buffer.close ();
        this.storage.queryClosed ( this );
    }

    /**
     * Request a close of the query
     * 
     * @return <code>true</code> if the close was requested, <code>false</code>
     *         if the close already was requested by someone else
     */
    private boolean requestClose ()
    {
        LoadState expect;
        LoadState update;

        do
        {
            expect = this.state.get ();
            if ( expect.isClosed () )
            {
                logger.info ( "Query already closed" );
                return false;
            }

            update = new LoadState ( true, expect.isLoading (), expect.getParameters () );
        } while ( !this.state.compareAndSet ( expect, update ) );

        logger.info ( "Close requested" );
        return true;
    }

    @Override
    public void changeParameters ( final QueryParameters parameters )
    {
        changeParameters ( parameters, false );
    }

    public void changeParameters ( final QueryParameters parameters, final boolean force )
    {
        logger.debug ( "Change parameters to - force: {}, parameters: {}", force, parameters );

        int i = 0;
        LoadState update;
        LoadState expect;

        boolean shouldStart;
        do
        {
            expect = this.state.get ();
            logger.debug ( "Try parameter update - {} - {}", i, expect );

            if ( expect.isClosed () )
            {
                logger.info ( "Query is closed. Bye!" );
                return;
            }

            if ( !force && parameterEquals ( expect.getParameters (), parameters ) )
            {
                logger.info ( "This is not an actual parameter change. Aborting..." );
                return;
            }

            shouldStart = !expect.isLoading ();

            update = new LoadState ( false, expect.isLoading (), parameters );
            logger.debug ( "Try to apply state: {}", update );
            i++;
        } while ( !this.state.compareAndSet ( expect, update ) );

        if ( shouldStart )
        {
            startLoad ();
        }

        logger.debug ( "State applied: {}", update );

    }

    private static boolean parameterEquals ( final QueryParameters first, final QueryParameters second )
    {
        if ( first == second )
        {
            return true;
        }
        if ( first == null )
        {
            return false;
        }

        // now both are non-null
        if ( first.getStartTimestamp () != second.getStartTimestamp () )
        {
            return false;
        }
        if ( first.getEndTimestamp () != second.getEndTimestamp () )
        {
            return false;
        }
        if ( first.getNumberOfEntries () != second.getNumberOfEntries () )
        {
            return false;
        }
        return true;
    }

    public void reload ()
    {
        changeParameters ( this.state.get ().getParameters () );
    }

    private void startLoad ()
    {
        logger.info ( "Starting load" );

        this.executor.submit ( new Runnable () {
            @Override
            public void run ()
            {
                performLoad ();
            }
        } );
    }

    protected void performLoad ()
    {
        logger.debug ( "Performing load" );

        LoadState expect;
        LoadState update;

        do
        {
            expect = this.state.get ();
            if ( expect.isLoading () )
            {
                // someone else started loading data ... we can stop
                logger.debug ( "Found loading state. Bye!" );
                return;
            }

            if ( expect.isClosed () )
            {
                // the query got closed .. we can stop
                logger.debug ( "Found closed state. Bye!" );
                return;
            }

            if ( parameterEquals ( this.buffer.getParameters (), expect.getParameters () ) )
            {
                logger.debug ( "Target state is no change from current state" );
                return;
            }

            // the new state would be that we are loading, try to set and be the first
            update = new LoadState ( false, true, expect.getParameters () );
        } while ( !this.state.compareAndSet ( expect, update ) );

        // now we are the only running loader
        final LoadState current = expect;

        try
        {
            logger.debug ( "Processing: {}", current );

            this.buffer.changeParameters ( current.getParameters () );
            final boolean complete = this.storage.visit ( current.getParameters (), new ValueVisitor () {

                @Override
                public boolean value ( final double value, final Date date, final boolean error, final boolean manual )
                {
                    QueryImpl.this.buffer.insertData ( value, date, error, manual );
                    final boolean result = shouldContinue ( current.getParameters () );
                    if ( !result )
                    {
                        logger.info ( "Requesting early stop" );
                    }
                    return result;
                }
            } );

            if ( complete )
            {
                // only complete the buffer if it was a complete run
                this.buffer.complete ();
            }

            if ( this.state.get ().isClosed () )
            {
                logger.info ( "Query closed. Bye" );
                // query is close ... quick goodbye
                return;
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to query", e );
            throw new RuntimeException ( "Failed to query", e );
        }
        finally
        {
            logger.debug ( "End loading" );
            if ( endLoading ( current ) )
            {
                logger.debug ( "Triggering loading restart" );
                startLoad ();
            }
            logger.debug ( "Loading ended" );
        }
    }

    /**
     * Have the requested parameters changed
     * 
     * @param loadingParameters
     *            the current loading parameters
     * @return <code>true</code> if the provided loading parameters are
     *         different to the current state parameters
     */
    private boolean hasChanged ( final QueryParameters loadingParameters )
    {
        final QueryParameters currentParameters = this.state.get ().getParameters ();
        /*
         * we can compare references here since this is quicker than comparing equality
         * this may cause a double load when the user scroll forward and backward to the same position
         * but is less overhead then comparing equality each time a row was loaded
         */
        return loadingParameters != currentParameters;
    }

    /**
     * Should the current loading continue
     * 
     * @param queryParameters
     * @return
     */
    protected boolean shouldContinue ( final QueryParameters queryParameters )
    {
        final LoadState currentState = this.state.get ();
        if ( currentState.isClosed () )
        {
            logger.debug ( "Detected closed query" );
            return false;
        }

        if ( hasChanged ( queryParameters ) )
        {
            logger.debug ( "Detected parameter change" );
            return false;
        }

        return true;
    }

    /**
     * @return <code>true</code> if another load run is needed
     */
    private boolean endLoading ( final LoadState ours )
    {
        logger.debug ( "End loading - our state: {}", ours );

        LoadState expect;
        LoadState update;

        boolean needStart;
        do
        {
            expect = this.state.get ();
            update = new LoadState ( expect.isClosed (), false, expect.getParameters () );

            needStart = !update.isClosed () && !parameterEquals ( ours.getParameters (), update.getParameters () );

        } while ( !this.state.compareAndSet ( expect, update ) );

        logger.debug ( "State after loading - restart: {}, {}", needStart, update );

        return needStart;
    }

    public boolean isUpdateData ()
    {
        return this.updateData;
    }

    public void updateData ( final double value, final Date timestamp, final boolean error, final boolean manual )
    {
        if ( this.state.get ().isClosed () )
        {
            return;
        }
        this.buffer.updateData ( value, timestamp, error, manual );
    }

    public void dataChanged ( final Date start, final Date end )
    {
        // TODO: implement a partial reload
        reload ();
    }
}
