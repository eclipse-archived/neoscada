/*******************************************************************************
 * Copyright (c) 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     Red Hat Inc - refactoring and enhancements
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
import org.eclipse.neoscada.protocol.iec60870.asdu.types.CauseOfTransmission;
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
        public void notifyBoolean ( CauseOfTransmission cause, ASDUAddress key, List<InformationEntry<Boolean>> booleans );

        public void notifyFloat ( CauseOfTransmission cause, ASDUAddress key, List<InformationEntry<Float>> floats );

        public void notifyShort ( CauseOfTransmission cause, ASDUAddress key, List<InformationEntry<Short>> shorts );
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
    public synchronized void notifyChange ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final InformationObjectAddress informationObjectAddress, final Value<?> value )
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
                    performFlush ( cache, cause );
                }
            } );
        }

        // add to cache

        asduCache.put ( informationObjectAddress, value );

        // trigger flush

        triggerFlush ( cause );
    }

    /**
     * Trigger a flush
     * <p>
     * If a flush is already pending, then nothing will happen
     * </p>
     */
    private synchronized void triggerFlush ( final CauseOfTransmission cause )
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
                flush ( cause );
            }
        }, this.flushDelay, TimeUnit.MILLISECONDS );
    }

    /**
     * Flush the current buffer
     */
    private void flush ( final CauseOfTransmission cause )
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

        performFlush ( cache, cause );
    }

    @SuppressWarnings ( "unchecked" )
    private void performFlush ( final Map<ASDUAddress, Map<InformationObjectAddress, Value<?>>> cache, final CauseOfTransmission cause )
    {
        for ( final Map.Entry<ASDUAddress, Map<InformationObjectAddress, Value<?>>> entry : cache.entrySet () )
        {
            List<InformationEntry<Boolean>> booleans = null;
            List<InformationEntry<Float>> floats = null;
            List<InformationEntry<Short>> shorts = null;

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
                else if ( value.getValue () instanceof Short )
                {
                    shorts = add ( shorts, ioa, (Value<Short>)value );
                }
            }

            // send out what we have sorted out

            if ( booleans != null )
            {
                this.context.notifyBoolean ( cause, entry.getKey (), booleans );
            }
            if ( floats != null )
            {
                this.context.notifyFloat ( cause, entry.getKey (), floats );
            }
            if ( shorts != null )
            {
                this.context.notifyShort ( cause, entry.getKey (), shorts );
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
