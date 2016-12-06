/*******************************************************************************
 * Copyright (c) 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     Red Hat Inc - refactoring
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.server.data.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.neoscada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationEntry;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Value;

/**
 * This is a change model which sends out aggregated change events
 */
public class BufferingChangeModel implements ChangeModel
{
    public static interface Context
    {
        public void notifyBoolean ( ASDUAddress key, List<InformationEntry<Boolean>> booleans );

        public void notifyFloat ( ASDUAddress key, List<InformationEntry<Float>> floats );
    }

    private final Context context;

    private final ScheduledExecutorService executor;

    private final long flushDelay;

    private Map<ASDUAddress, Map<InformationObjectAddress, Value<?>>> cache = new HashMap<> ();

    private ScheduledFuture<?> future;

    /**
     * Create a new buffering change model
     *
     * @param executor
     *            a single threaded scheduled executor
     * @param flushDelay
     *            the minimum delay between flushes
     */
    public BufferingChangeModel ( final Context context, final ScheduledExecutorService executor, final long flushDelay )
    {
        this.context = context;
        this.executor = executor;
        this.flushDelay = flushDelay;
    }

    @Override
    public synchronized void notifyChange ( final ASDUAddress asduAddress, final InformationObjectAddress informationObjectAddress, final Value<?> value )
    {
        Map<InformationObjectAddress, Value<?>> asduCache = this.cache.get ( asduAddress );
        if ( asduCache == null )
        {
            asduCache = new HashMap<> ();
            this.cache.put ( asduAddress, asduCache );
        }

        if ( asduCache.containsKey ( value ) )
        {
            // we would overwrite data, flush immediately

            final Map<ASDUAddress, Map<InformationObjectAddress, Value<?>>> cache = this.cache;
            this.cache = new HashMap<> ();

            // create a new entry since we just created a new cache map

            asduCache = new HashMap<> ();
            this.cache.put ( asduAddress, asduCache );

            // flush, not holding the lock, and in order with other flushes

            this.executor.execute ( new Runnable () {
                @Override
                public void run ()
                {
                    performFlush ( cache );
                }
            } );
        }

        // add to cache

        asduCache.put ( informationObjectAddress, value );

        // trigger flush

        triggerFlush ();
    }

    /**
     * Trigger a flush
     * <p>
     * If a flush is already pending, then nothing will happen
     * </p>
     */
    private synchronized void triggerFlush ()
    {
        if ( this.future != null )
        {
            // there is already a flush pending
            return;
        }

        // schedule new flush

        this.future = this.executor.schedule ( new Runnable () {
            @Override
            public void run ()
            {
                flush ();
            }
        }, this.flushDelay, TimeUnit.MILLISECONDS );
    }

    /**
     * Flush the current buffer
     */
    private void flush ()
    {
        Map<ASDUAddress, Map<InformationObjectAddress, Value<?>>> cache;
        synchronized ( this )
        {
            if ( this.future == null )
            {
                return;
            }

            // replace cache with new one

            cache = this.cache;
            this.cache = new HashMap<> ();

            this.future = null;
        }

        // flush outside the lock

        performFlush ( cache );
    }

    @SuppressWarnings ( "unchecked" )
    private void performFlush ( final Map<ASDUAddress, Map<InformationObjectAddress, Value<?>>> cache )
    {
        for ( final Map.Entry<ASDUAddress, Map<InformationObjectAddress, Value<?>>> entry : cache.entrySet () )
        {
            List<InformationEntry<Boolean>> booleans = null;
            List<InformationEntry<Float>> floats = null;

            for ( final Map.Entry<InformationObjectAddress, Value<?>> valueEntry : entry.getValue ().entrySet () )
            {
                final InformationObjectAddress ioa = valueEntry.getKey ();
                final Value<?> value = valueEntry.getValue ();

                if ( value.getValue () instanceof Boolean )
                {
                    booleans = add ( booleans, ioa, (Value<Boolean>)value );
                }
                else if ( value.getValue () instanceof Float )
                {
                    floats = add ( floats, ioa, (Value<Float>)value );
                }
            }

            // send out what we have sorted out

            if ( booleans != null )
            {
                this.context.notifyBoolean ( entry.getKey (), booleans );
            }
            if ( floats != null )
            {
                this.context.notifyFloat ( entry.getKey (), floats );
            }
        }
    }

    private <T> List<InformationEntry<T>> add ( List<InformationEntry<T>> values, final InformationObjectAddress ioa, final Value<T> value )
    {
        if ( values == null )
        {
            values = new LinkedList<> ();
        }

        values.add ( new InformationEntry<> ( ioa, value ) );

        return values;
    }

    @Override
    public synchronized Runnable dispose ()
    {
        if ( this.future != null )
        {
            this.future.cancel ( false );
            this.future = null;
        }

        // pending data will get discarded, this is ok

        return () -> {
        };
    }

}
