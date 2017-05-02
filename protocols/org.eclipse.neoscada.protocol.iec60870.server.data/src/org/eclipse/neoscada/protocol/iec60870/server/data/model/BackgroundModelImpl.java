/*******************************************************************************
 * Copyright (c) 2016 Red Hat Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.server.data.model;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.SortedMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.eclipse.neoscada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Value;
import org.eclipse.neoscada.protocol.iec60870.server.data.BackgroundIterator;
import org.eclipse.neoscada.protocol.iec60870.server.data.event.MessageBuilder;
import org.eclipse.neoscada.protocol.iec60870.server.data.event.SimpleBooleanBuilder;
import org.eclipse.neoscada.protocol.iec60870.server.data.event.SimpleFloatBuilder;
import org.eclipse.neoscada.protocol.iec60870.server.data.event.SimpleScaledBuilder;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BackgroundModelImpl implements BackgroundModel
{
    private static final Logger logger = LoggerFactory.getLogger ( BackgroundModelImpl.class );

    private static final SimpleFloatBuilder FLOAT_BUILDER = new SimpleFloatBuilder ( false ); // background is always without timestamps

    private static final SimpleScaledBuilder SCALED_BUILDER = new SimpleScaledBuilder ( false ); // background is always without timestamps

    private static final SimpleBooleanBuilder BOOLEAN_BUILDER = new SimpleBooleanBuilder ( false ); // background is always without timestamps

    private final static class BackgroundState
    {
        public Entry<Integer, SortedMap<Integer, Value<?>>> asduAddress;

        public Iterator<Entry<Integer, SortedMap<Integer, Value<?>>>> asduAddressIterator;

        public Iterator<Entry<Integer, Value<?>>> addressIterator;

        public SortedMap<Integer, Value<?>> addressMap;

        @Override
        public String toString ()
        {
            return String.format ( "[asduAddress: %s, asduAddressIterator: %s, addressMap: %s, addressIterator: %s]", this.asduAddress, this.asduAddressIterator, this.addressMap, this.addressIterator );
        }
    }

    private final class BackgroundIteratorImpl implements BackgroundIterator
    {
        private final BackgroundState state = new BackgroundState ();

        @Override
        public Object nextMessage ()
        {
            return proceedBackgroundScan ( this.state );
        }
    }

    private final ExecutorService backgroundExecutor;

    private final Map<Integer, SortedMap<Integer, Value<?>>> cache;

    private final Object modelLock;

    public BackgroundModelImpl ( final SortedMap<Integer, SortedMap<Integer, Value<?>>> cache, final Object modelLock )
    {
        this.backgroundExecutor = Executors.newSingleThreadExecutor ( new NamedThreadFactory ( "org.eclipse.neoscada.da.server.exporter.iec60870.DataModel/background" ) );
        this.cache = cache;
        this.modelLock = modelLock;
    }

    @Override
    public Optional<BackgroundIterator> createBackgroundIterator ()
    {
        return Optional.of ( new BackgroundIteratorImpl () );
    }

    private Object proceedBackgroundScan ( final BackgroundState state )
    {
        try
        {
            logger.debug ( "Background scan - {}", state );
            final Object msg = this.backgroundExecutor.submit ( () -> internalBackgroundScan ( state ) ).get ();
            logger.debug ( "Background scan result - {}", msg );

            return msg;
        }
        catch ( InterruptedException | ExecutionException e )
        {
            throw new RuntimeException ( "Failed to perform background scan", e );
        }
    }

    private static MessageBuilder<?, ?> createBuilder ( final Object value )
    {
        if ( value instanceof Boolean )
        {
            return BOOLEAN_BUILDER.create ();
        }
        else if ( value instanceof Short )
        {
            return SCALED_BUILDER.create ();
        }
        else if ( value instanceof Number )
        {
            return FLOAT_BUILDER.create ();
        }
        throw new IllegalStateException ( String.format ( "Value type %s is unsupported", value.getClass () ) );
    }

    protected Object internalBackgroundScan ( final BackgroundState state )
    {
        synchronized ( this.modelLock )
        {
            try
            {
                return internalNext ( state );
            }
            catch ( final ConcurrentModificationException e )
            {
                // this may happen if between the last and this call our cache map was structurally modified

                // reset ...

                state.asduAddressIterator = null;
                state.addressIterator = null;

                // ... and retry

                return internalNext ( state );
            }
        }
    }

    @SuppressWarnings ( { "rawtypes", "unchecked" } )
    private Object internalNext ( final BackgroundState state )
    {
        if ( state.asduAddressIterator == null )
        {
            state.asduAddressIterator = this.cache.entrySet ().iterator ();
        }

        if ( state.asduAddress == null )
        {
            if ( !state.asduAddressIterator.hasNext () )
            {
                return null;
            }
            else
            {
                state.asduAddress = state.asduAddressIterator.next ();
            }
        }

        if ( state.addressIterator == null )
        {
            state.addressMap = state.asduAddress.getValue ();
            state.addressIterator = state.addressMap.entrySet ().iterator ();
        }

        MessageBuilder<?, ?> builder = null;
        do
        {
            if ( !state.addressIterator.hasNext () )
            {
                // end of entries for current common ASDU address
                state.addressIterator = null; // reset address iterator
                state.asduAddress = null;

                if ( builder != null )
                {
                    return builder.build (); // end this message
                }
                else
                {
                    return null; // we never had content
                }
            }

            final Entry<Integer, Value<?>> entry = state.addressIterator.next ();

            if ( builder == null )
            {
                builder = createBuilder ( entry.getValue ().getValue () );
                builder.start ( CauseOfTransmission.BACKGROUND, ASDUAddress.valueOf ( state.asduAddress.getKey () ) );
            }

            if ( !builder.accepts ( entry.getValue () ) )
            {
                // next starting point
                state.addressMap = state.asduAddress.getValue ().tailMap ( entry.getKey () );
                state.addressIterator = state.addressMap.entrySet ().iterator ();
                // stop right now
                return builder.build ();
            }
            else
            {
                if ( !builder.addEntry ( InformationObjectAddress.valueOf ( entry.getKey () ), (Value)entry.getValue () ) )
                {
                    // builder is full
                    return builder.build ();
                }
            }
        } while ( true );
    }

    @Override
    public Runnable dispose ()
    {
        this.backgroundExecutor.shutdown ();
        return () -> {
            try
            {
                this.backgroundExecutor.awaitTermination ( Long.MAX_VALUE, TimeUnit.MILLISECONDS );
            }
            catch ( final InterruptedException e )
            {
                throw new RuntimeException ( e );
            }
        };
    }

}
