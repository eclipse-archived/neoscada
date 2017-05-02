/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.master.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.da.core.WriteAttributeResult;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.datasource.base.AbstractDataSourceHandler;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.da.master.MasterItemHandler;
import org.eclipse.scada.da.master.WriteRequest;
import org.eclipse.scada.da.master.WriteRequestResult;
import org.eclipse.scada.utils.concurrent.AbstractFuture;
import org.eclipse.scada.utils.concurrent.FutureListener;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MasterItemImpl extends AbstractDataSourceHandler implements MasterItem
{

    private final static boolean LOG_SUPPRESS = Boolean.getBoolean ( "org.eclipse.scada.da.master.internal.masterItemLogSuppressProcess" );

    private static class WriteListenerAttributeImpl extends AbstractFuture<WriteAttributeResults> implements WriteListener
    {
        @Override
        public void complete ( final WriteResult result )
        {
            setResult ( new WriteAttributeResults () );
        }

        @Override
        public void complete ( final WriteAttributeResults results )
        {
            setResult ( results );
        }

        @Override
        public void failed ( final String error )
        {
            setError ( new OperationException ( error ).fillInStackTrace () );
        }

        @Override
        public void error ( final Throwable error )
        {
            setError ( error );
        }
    }

    private static class WriteListenerValueImpl extends AbstractFuture<WriteResult> implements WriteListener
    {

        @Override
        public void complete ( final WriteResult result )
        {
            setResult ( result );
        }

        @Override
        public void complete ( final WriteAttributeResults results )
        {
            setResult ( new WriteResult () );
        }

        @Override
        public void failed ( final String error )
        {
            setError ( new OperationException ( error ).fillInStackTrace () );
        }

        @Override
        public void error ( final Throwable error )
        {
            setError ( error );
        }
    }

    private static interface WriteListener
    {
        public void complete ( WriteResult result );

        public void complete ( WriteAttributeResults results );

        public void failed ( String error );

        public void error ( Throwable error );
    }

    private final static Logger logger = LoggerFactory.getLogger ( MasterItemImpl.class );

    private volatile DataItemValue sourceValue;

    private static class HandlerEntry implements Comparable<HandlerEntry>
    {
        private final MasterItemHandler handler;

        private final int priority;

        public HandlerEntry ( final MasterItemHandler handler, final int priority )
        {
            this.handler = handler;
            this.priority = priority;
        }

        public MasterItemHandler getHandler ()
        {
            return this.handler;
        }

        @Override
        public int compareTo ( final HandlerEntry o )
        {
            return this.priority < o.priority ? -1 : this.priority == o.priority ? 0 : 1;
        }

        @Override
        public int hashCode ()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ( this.handler == null ? 0 : this.handler.hashCode () );
            return result;
        }

        @Override
        public boolean equals ( final Object obj )
        {
            if ( this == obj )
            {
                return true;
            }
            if ( obj == null )
            {
                return false;
            }
            if ( getClass () != obj.getClass () )
            {
                return false;
            }
            final HandlerEntry other = (HandlerEntry)obj;
            if ( this.handler == null )
            {
                if ( other.handler != null )
                {
                    return false;
                }
            }
            else if ( !this.handler.equals ( other.handler ) )
            {
                return false;
            }
            return true;
        }

        public int getPriority ()
        {
            return this.priority;
        }
    }

    private final List<HandlerEntry> itemHandler = new LinkedList<HandlerEntry> ();

    private final Executor executor;

    private String dataSourceId;

    private boolean debug = false;

    private boolean dontOverrideSubscription = false;

    private final Lock processTriggerLock = new ReentrantLock ();

    private boolean processTriggered;

    private final Runnable processRunnable = new Runnable () {
        @Override
        public void run ()
        {
            MasterItemImpl.this.doReprocess ();
        }
    };

    private final String id;

    public MasterItemImpl ( final Executor executor, final BundleContext context, final String id, final ObjectPoolTracker<DataSource> dataSourcePoolTracker ) throws InvalidSyntaxException
    {
        super ( dataSourcePoolTracker );
        this.id = id;
        this.executor = executor;
        stateChanged ( initValue () );
    }

    private static DataItemValue initValue ()
    {
        final DataItemValue.Builder builder = new Builder ();
        builder.setAttribute ( "master.uninitialized", Variant.TRUE );
        return builder.build ();
    }

    @Override
    protected Executor getExecutor ()
    {
        return this.executor;
    }

    @Override
    public void dispose ()
    {
        synchronized ( this.itemHandler )
        {
            this.itemHandler.clear ();
        }
        super.dispose ();
    }

    @Override
    public void addHandler ( final MasterItemHandler handler, final int priority )
    {
        synchronized ( this.itemHandler )
        {
            logger.debug ( "Adding handler: {}/{}", new Object[] { handler, priority } );

            final HandlerEntry entry = new HandlerEntry ( handler, priority );
            if ( this.itemHandler.contains ( entry ) )
            {
                return;
            }

            this.itemHandler.add ( entry );
            Collections.sort ( this.itemHandler );

            logger.debug ( "Added handler: {}/{}", new Object[] { handler, priority } );
        }
        // re-process
        reprocess ();
    }

    @Override
    public void reprocess ()
    {
        try
        {
            this.processTriggerLock.lock ();
            if ( this.processTriggered )
            {
                if ( LOG_SUPPRESS )
                {
                    logger.trace ( "Suppressed process()" );
                }
                return;
            }

            this.processTriggered = true;

            this.executor.execute ( this.processRunnable );
        }
        finally
        {
            this.processTriggerLock.unlock ();
        }
    }

    /**
     * Re-process with the same source value
     */
    protected void doReprocess ()
    {
        try
        {
            this.processTriggerLock.lock ();
            this.processTriggered = false;
        }
        finally
        {
            this.processTriggerLock.unlock ();
        }

        handleProcess ();
    }

    /**
     * handle the processing
     * 
     * @param value
     *            the source value
     */
    protected synchronized void handleProcess ()
    {
        logger.debug ( "Reprocessing" );
        updateData ( processHandler ( this.sourceValue ) );
    }

    @Override
    protected synchronized void stateChanged ( final DataItemValue value )
    {
        logger.debug ( "state change: {}", value );
        if ( value != null )
        {
            if ( value.isConnected () || this.dontOverrideSubscription )
            {
                this.sourceValue = value;
            }
            else
            {
                final Builder builder = new Builder ( value );
                builder.setSubscriptionState ( SubscriptionState.CONNECTED );
                this.sourceValue = builder.build ();
            }
        }
        else
        {
            final Builder builder = new Builder ();
            builder.setAttribute ( "master.source.error", Variant.TRUE );
            builder.setAttribute ( "master.datasource.id", Variant.valueOf ( this.dataSourceId ) );
            this.sourceValue = builder.build ();
        }

        reprocess ();
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.da.master.interal.MasterImpl#removeHandler(org.eclipse.scada.da.master.MasterItemHandler)
     */
    @Override
    public void removeHandler ( final MasterItemHandler handler )
    {
        synchronized ( this.itemHandler )
        {
            logger.debug ( "Before - Handlers: {}", this.itemHandler.size () );

            if ( this.itemHandler.remove ( new HandlerEntry ( handler, 0 ) ) )
            {
                logger.debug ( "Removed handler: {}", handler );
                reprocess ();
            }

            logger.debug ( "After - Handlers: {}", this.itemHandler.size () );
        }
    }

    protected DataItemValue processHandler ( DataItemValue value )
    {
        logger.debug ( "Processing handlers" );

        final ArrayList<HandlerEntry> handler;
        synchronized ( this.itemHandler )
        {
            handler = new ArrayList<HandlerEntry> ( this.itemHandler );
        }

        final Map<String, Object> context = new HashMap<String, Object> ();

        final DataItemValue.Builder builder = new Builder ( value );

        for ( final HandlerEntry entry : handler )
        {
            logger.debug ( "Process: {} -> {}", new Object[] { entry.getPriority (), entry.getHandler () } );
            entry.getHandler ().dataUpdate ( context, builder );
        }

        if ( this.debug )
        {
            builder.setAttribute ( "master.debug.handlerCount", Variant.valueOf ( handler.size () ) );
            value = builder.build ();
        }

        return builder.build ();
    }

    @Override
    public synchronized NotifyFuture<WriteResult> startWriteValue ( final Variant value, final OperationParameters operationParameters )
    {
        final WriteListenerValueImpl task = new WriteListenerValueImpl ();
        processWrite ( new WriteRequest ( value, operationParameters ), task );
        return task;
    }

    @Override
    public synchronized NotifyFuture<WriteAttributeResults> startWriteAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        final WriteListenerAttributeImpl task = new WriteListenerAttributeImpl ();
        processWrite ( new WriteRequest ( attributes, operationParameters ), task );
        return task;
    }

    private void processWrite ( final WriteRequest writeRequest, final WriteListener listener )
    {

        final DataSource dataSource = getDataSource ();
        if ( dataSource == null )
        {
            listener.error ( new OperationException ( "No connection" ).fillInStackTrace () );
            return;
        }

        // FIXME: combined value and attribute writes will be a problem
        try
        {
            final WriteRequestResult result = preProcessWrite ( writeRequest );
            final Throwable error = result.getError ();

            if ( error != null )
            {
                listener.error ( error );
                return;
            }

            // process value
            final Variant value = result.getValue ();
            if ( value != null )
            {
                final NotifyFuture<WriteResult> task = dataSource.startWriteValue ( value, writeRequest.getOperationParameters () );
                task.addListener ( new FutureListener<WriteResult> () {

                    @Override
                    public void complete ( final Future<WriteResult> future )
                    {
                        try
                        {
                            listener.complete ( future.get () );
                        }
                        catch ( final Throwable e )
                        {
                            logger.info ( "Failed to write value", e );
                            listener.error ( e );
                        }
                    }
                } );
            }

            // process attributes
            final Map<String, Variant> attributes = result.getAttributes ();
            if ( !attributes.isEmpty () )
            {
                final NotifyFuture<WriteAttributeResults> task = dataSource.startWriteAttributes ( attributes, writeRequest.getOperationParameters () );
                task.addListener ( new FutureListener<WriteAttributeResults> () {

                    @Override
                    public void complete ( final Future<WriteAttributeResults> future )
                    {
                        try
                        {
                            listener.complete ( mergeResults ( result.getAttributeResults (), future.get () ) );
                        }
                        catch ( final Throwable e )
                        {
                            logger.info ( "Failed to write attributes", e );
                            listener.error ( e );
                        }
                    }
                } );
            }
            else if ( !result.getAttributeResults ().isEmpty () )
            {
                listener.complete ( result.getAttributeResults () );
            }
        }
        catch ( final Throwable e )
        {
            // total failure
            logger.info ( "Failed to write to master item", e );
            listener.error ( e );
        }
    }

    /**
     * Merge the two result sets
     * 
     * @param firstResult
     *            first set
     * @param secondResult
     *            second set
     * @return the merged result
     */
    protected WriteAttributeResults mergeResults ( final WriteAttributeResults firstResult, final WriteAttributeResults secondResult )
    {
        final WriteAttributeResults newResults = new WriteAttributeResults ();
        if ( firstResult != null )
        {
            newResults.putAll ( firstResult );
        }
        if ( secondResult != null )
        {
            newResults.putAll ( secondResult );
        }
        return newResults;
    }

    private WriteRequestResult preProcessWrite ( final WriteRequest writeRequest )
    {
        final HandlerEntry[] handlers;
        synchronized ( this.itemHandler )
        {
            handlers = this.itemHandler.toArray ( new HandlerEntry[this.itemHandler.size ()] );
        }

        WriteRequest request = writeRequest;
        WriteRequestResult finalResult = new WriteRequestResult ( writeRequest.getValue (), writeRequest.getAttributes (), null );
        for ( int i = handlers.length; i > 0; i-- )
        {
            final HandlerEntry handler = handlers[i - 1];
            final WriteRequestResult nextResult = handler.getHandler ().processWrite ( request );

            if ( nextResult != null )
            {
                finalResult = mergeNextResult ( finalResult, nextResult );
                if ( finalResult.getError () != null )
                {
                    // abort here .. we got an error
                    return finalResult;
                }

                final Map<String, Variant> nextAttributes = finalResult.getAttributes ();

                // remove all attribute requests for which we have a result
                for ( final Map.Entry<String, WriteAttributeResult> entry : finalResult.getAttributeResults ().entrySet () )
                {
                    nextAttributes.remove ( entry.getKey () );
                }

                request = new WriteRequest ( finalResult.getValue (), nextAttributes, writeRequest.getOperationParameters () );
            }
        }

        return finalResult;
    }

    private static WriteRequestResult mergeNextResult ( final WriteRequestResult finalResult, final WriteRequestResult nextResult )
    {
        if ( nextResult.getError () != null )
        {
            return nextResult;
        }

        // merge current and previous results
        final WriteAttributeResults result = new WriteAttributeResults ();
        if ( nextResult.getAttributeResults () != null )
        {
            result.putAll ( nextResult.getAttributeResults () );
        }
        if ( finalResult.getAttributeResults () != null )
        {
            result.putAll ( finalResult.getAttributeResults () );
        }

        return new WriteRequestResult ( nextResult.getValue (), nextResult.getAttributes (), result );
    }

    public synchronized void update ( final Map<String, String> properties ) throws InvalidSyntaxException
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        this.dataSourceId = cfg.getString ( "datasource.id" );
        this.dontOverrideSubscription = cfg.getBoolean ( "dontOverrideSubscription", false );
        this.debug = cfg.getBoolean ( "debug", false );

        stateChanged ( null );

        setDataSource ( this.dataSourceId );
    }

    @Override
    public String toString ()
    {
        return String.format ( getClass ().getSimpleName () + ": " + this.id );
    }

}
