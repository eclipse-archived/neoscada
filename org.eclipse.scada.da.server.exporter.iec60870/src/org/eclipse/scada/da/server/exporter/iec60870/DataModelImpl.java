/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.iec60870;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.core.NotConvertableException;
import org.eclipse.scada.core.NullValueException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.server.exporter.common.HiveSource;
import org.eclipse.scada.da.server.exporter.common.SingleSubscriptionManager;
import org.eclipse.scada.da.server.exporter.common.SingleSubscriptionManager.Listener;
import org.eclipse.scada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.scada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.QualityInformation;
import org.eclipse.scada.protocol.iec60870.asdu.types.Value;
import org.eclipse.scada.protocol.iec60870.io.MirrorCommand;
import org.eclipse.scada.protocol.iec60870.server.data.AbstractBaseDataModel;
import org.eclipse.scada.protocol.iec60870.server.data.BackgroundIterator;
import org.eclipse.scada.protocol.iec60870.server.data.DataListener;
import org.eclipse.scada.protocol.iec60870.server.data.DefaultSubscription;
import org.eclipse.scada.protocol.iec60870.server.data.Subscription;
import org.eclipse.scada.protocol.iec60870.server.data.event.MessageBuilder;
import org.eclipse.scada.protocol.iec60870.server.data.event.SimpleBooleanBuilder;
import org.eclipse.scada.protocol.iec60870.server.data.event.SimpleFloatBuilder;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * An IEC60870-5 data model for Eclipse SCADA <br/>
 * <h1>Implementation details</h1>
 * <p>
 * All entries are initialized with {@link DataItemValue#DISCONNECTED} in order
 * to populate the caches. This will allow the background transfer to already
 * have data before changes came in. And also prevent the cache structures to
 * change, so the background transmission may hold the iterators.
 * </p>
 */
public class DataModelImpl extends AbstractBaseDataModel
{
    private static final SimpleFloatBuilder FLOAT_BUILDER = new SimpleFloatBuilder ( false );

    private static final SimpleBooleanBuilder BOOLEAN_BUILDER = new SimpleBooleanBuilder ( false );

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

    private final static class AddressKey
    {
        private final int asduAddress;

        private final int address;

        public AddressKey ( final int asduAddress, final int address )
        {
            this.asduAddress = asduAddress;
            this.address = address;
        }

        @Override
        public int hashCode ()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + this.address;
            result = prime * result + this.asduAddress;
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
            final AddressKey other = (AddressKey)obj;
            if ( this.address != other.address )
            {
                return false;
            }
            if ( this.asduAddress != other.asduAddress )
            {
                return false;
            }
            return true;
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

    private final static Logger logger = LoggerFactory.getLogger ( DataModelImpl.class );

    private final SingleSubscriptionManager manager;

    /*
     * we use a sorted map, so that the addresses are sorted and we
     * can generate continuous addresses in the message builders
     */
    private final Map<Integer, SortedMap<Integer, Value<?>>> cache;

    private final InformationBean info;

    private final ExecutorService backgroundExecutor;

    private final Map<AddressKey, String> addressMap = new HashMap<> ();

    public DataModelImpl ( final HiveSource hiveSource, final Set<MappingEntry> entries, final Properties hiveProperties, final InformationBean info )
    {
        super ( "org.eclipse.scada.da.server.exporter.iec60870.DataModel" );

        this.backgroundExecutor = Executors.newSingleThreadExecutor ( new NamedThreadFactory ( "org.eclipse.scada.da.server.exporter.iec60870.DataModel/background" ) );

        this.info = info;

        for ( final MappingEntry entry : entries )
        {
            this.addressMap.put ( new AddressKey ( entry.getAsduAddress (), entry.getAddress () ), entry.getItemId () );
        }

        this.cache = new HashMap<> ();

        this.manager = new SingleSubscriptionManager ( this.executor, hiveSource, hiveProperties, "IEC60870/DataModel" );
        this.manager.start ();

        attach ( entries );
    }

    @Override
    public synchronized Subscription subscribe ( final DataListener listener )
    {
        final Subscription result = super.subscribe ( listener );
        this.info.setNumberOfSubscriptions ( getNumberOfSubscriptions () );
        return result;
    }

    @Override
    protected synchronized ListenableFuture<Void> disposeSubscription ( final DefaultSubscription subscription )
    {
        final ListenableFuture<Void> result = super.disposeSubscription ( subscription );
        this.info.setNumberOfSubscriptions ( getNumberOfSubscriptions () );
        return result;
    }

    private void attach ( final Set<MappingEntry> entries )
    {
        for ( final MappingEntry entry : entries )
        {
            logger.debug ( "Attaching to: {}", entry );
            handleStateChanged ( entry, DataItemValue.DISCONNECTED, false );
            this.manager.addListener ( entry.getItemId (), new Listener () {

                @Override
                public void stateChanged ( final String itemId, final DataItemValue value )
                {
                    handleStateChanged ( entry, value, true );
                }
            } );
        }
    }

    protected synchronized void handleStateChanged ( final MappingEntry entry, final DataItemValue value, final boolean notify )
    {
        logger.trace ( "Handle state change - entry: {}, value: {}", entry, value );

        SortedMap<Integer, Value<?>> unit = this.cache.get ( entry.getAsduAddress () );
        if ( unit == null )
        {
            unit = new TreeMap<> ();
            this.cache.put ( entry.getAsduAddress (), unit );
        }

        final Value<?> iecValue = convert ( entry, value );
        logger.trace ( "Converted to: {}", iecValue );
        unit.put ( entry.getAddress (), iecValue );

        notifyChange ( entry, iecValue );
    }

    private Value<?> convert ( final MappingEntry entry, final DataItemValue value )
    {
        Variant v = value.getValue ();
        if ( v == null )
        {
            v = Variant.NULL;
        }

        try
        {
            final Object cv;
            if ( value.getValue () == null || value.getValue ().isNull () )
            {
                // VariantType#NULL is null
                cv = null;
            }
            else
            {
                cv = convertValue ( entry, value );
            }

            if ( cv == null )
            {
                return errorValue ( entry );
            }
            return new Value<Object> ( cv, convertTimestamp ( value ), convertQuality ( value ) );
        }
        catch ( final Exception e )
        {
            logger.debug ( "Conversion error", e );
            return errorValue ( entry );
        }
    }

    private long convertTimestamp ( final DataItemValue value )
    {
        if ( value == null )
        {
            return System.currentTimeMillis ();
        }
        final Variant ts = value.getAttributes ().get ( "timestamp" );
        if ( ts == null || ts.isNull () )
        {
            return System.currentTimeMillis ();
        }
        return ts.asLong ( System.currentTimeMillis () );
    }

    private Object convertValue ( final MappingEntry entry, final DataItemValue value ) throws NullValueException, NotConvertableException
    {
        Variant v = value.getValue ();

        if ( v == null )
        {
            v = Variant.NULL;
        }

        if ( entry.getValueType () == null )
        {
            // don't convert ... well ...
            final Serializable ov = v.getValue ();

            if ( ov instanceof Number )
            {
                return ( (Number)ov ).floatValue ();
            }
            else if ( ov instanceof String )
            {
                return Double.parseDouble ( (String)ov );
            }

            // could be only be NULL or BOOLEAN
            return ov;
        }

        switch ( entry.getValueType () )
        {
            case BOOLEAN:
                return v.asBoolean ();
            case FLOAT:
                return (float)v.asDouble ();
            default:
                throw new IllegalStateException ( String.format ( "Value type %s unknown", entry.getValueType () ) );
        }
    }

    private QualityInformation convertQuality ( final DataItemValue value )
    {
        final boolean valid = value.isConnected () && !value.isError ();
        final boolean substituted = value.isManual ();
        final boolean blocked = value.isBlocked ();
        final boolean topical = true;
        return new QualityInformation ( blocked, substituted, topical, valid );
    }

    private Value<?> errorValue ( final MappingEntry entry )
    {
        switch ( entry.getValueType () )
        {
            case FLOAT:
                return new Value<Float> ( 0.0f, System.currentTimeMillis (), QualityInformation.INVALID );
            case BOOLEAN:
            default:
                return new Value<Boolean> ( false, System.currentTimeMillis (), QualityInformation.INVALID );
        }
    }

    @Override
    public void dispose ()
    {
        this.manager.stop ();
        this.backgroundExecutor.shutdown ();
        super.dispose ();
    }

    @Override
    public void disposeAndWait () throws InterruptedException
    {
        super.disposeAndWait ();
        this.backgroundExecutor.awaitTermination ( Long.MAX_VALUE, TimeUnit.MILLISECONDS );
    }

    @Override
    public ListenableFuture<Value<?>> read ( final ASDUAddress asduAddress, final InformationObjectAddress address )
    {
        return this.executor.submit ( new Callable<Value<?>> () {

            @Override
            public Value<?> call () throws Exception
            {
                return performRead ( asduAddress, address );
            }
        } );
    }

    protected synchronized Value<?> performRead ( final ASDUAddress asduAddress, final InformationObjectAddress address )
    {
        final Map<Integer, Value<?>> map = this.cache.get ( asduAddress.getAddress () );
        if ( map == null )
        {
            return null;
        }

        return map.get ( address.getAddress () );
    }

    @Override
    public synchronized ListenableFuture<Void> readAll ( final ASDUAddress asduAddress, final Runnable prepare, final DataListener listener )
    {
        final Map<Integer, Value<?>> map = this.cache.get ( asduAddress.getAddress () );
        if ( map == null )
        {
            return null;
        }

        final Map<Integer, Value<?>> map2 = new HashMap<> ( map ); // copy

        this.executor.submit ( prepare );

        return this.executor.submit ( new Callable<Void> () {

            @Override
            public Void call ()
            {
                performReadAll ( asduAddress, listener, map2 );
                return null;
            }
        } );
    }

    protected synchronized void performReadAll ( final ASDUAddress asduAddress, final DataListener listener, final Map<Integer, Value<?>> map )
    {
        for ( final Map.Entry<Integer, Value<?>> entry : map.entrySet () )
        {
            fireListener ( asduAddress, listener, entry );
        }
    }

    @Override
    public void forAllAsdu ( final Function<ASDUAddress, Void> function, final Runnable ifNoneFound )
    {
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                performForAllAsdu ( function, ifNoneFound );
            }
        } );
    }

    protected synchronized void performForAllAsdu ( final Function<ASDUAddress, Void> function, final Runnable ifNoneFound )
    {
        if ( this.cache.isEmpty () )
        {
            this.executor.execute ( ifNoneFound );
            return;
        }

        for ( final Integer asdu : this.cache.keySet () )
        {
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    function.apply ( ASDUAddress.valueOf ( asdu ) );
                }
            } );
        }
    }

    @Override
    public BackgroundIterator createBackgroundIterator ()
    {
        return new BackgroundIteratorImpl ();
    }

    public Object proceedBackgroundScan ( final BackgroundState state )
    {
        try
        {
            logger.debug ( "Background scan - {}", state );

            final Object msg = this.backgroundExecutor.submit ( new Callable<Object> () {
                @Override
                public Object call () throws Exception
                {
                    return internalBackgroundScan ( state );
                }
            } ).get ();
            logger.debug ( "Background scan result - {}", msg );
            return msg;
        }
        catch ( InterruptedException | ExecutionException e )
        {
            throw new RuntimeException ( "Failed to perform background scan", e );
        }
    }

    @SuppressWarnings ( { "unchecked", "rawtypes" } )
    protected synchronized Object internalBackgroundScan ( final BackgroundState state )
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
                // end of entries for current common asdu address
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

    @SuppressWarnings ( "unchecked" )
    private void notifyChange ( final MappingEntry entry, final Value<?> iecValue )
    {
        final Object rawValue = iecValue.getValue ();

        logger.trace ( "Notify raw value: {} ({})", rawValue, rawValue != null ? rawValue.getClass () : null );

        if ( rawValue instanceof Boolean )
        {
            notifyChangeBoolean ( ASDUAddress.valueOf ( entry.getAsduAddress () ), new InformationObjectAddress ( entry.getAddress () ), Collections.singletonList ( (Value<Boolean>)iecValue ) );
        }
        else if ( rawValue instanceof Float )
        {
            notifyChangeFloat ( ASDUAddress.valueOf ( entry.getAsduAddress () ), new InformationObjectAddress ( entry.getAddress () ), Collections.singletonList ( (Value<Float>)iecValue ) );
        }
    }

    @SuppressWarnings ( "unchecked" )
    private static void fireListener ( final ASDUAddress asduAddress, final DataListener listener, final Map.Entry<Integer, Value<?>> entry )
    {
        final Value<?> ve = entry.getValue ();
        final Object v = ve.getValue ();

        if ( v instanceof Boolean )
        {
            listener.dataChangeBoolean ( asduAddress, InformationObjectAddress.valueOf ( entry.getKey () ), Collections.singletonList ( (Value<Boolean>)ve ) );
        }
        else if ( v instanceof Float )
        {
            listener.dataChangeFloat ( asduAddress, InformationObjectAddress.valueOf ( entry.getKey () ), Collections.singletonList ( (Value<Float>)ve ) );
        }
    }

    private static MessageBuilder<?, ?> createBuilder ( final Object value )
    {
        if ( value instanceof Boolean )
        {
            return BOOLEAN_BUILDER.create ();
        }
        else if ( value instanceof Number )
        {
            return FLOAT_BUILDER.create ();
        }
        throw new IllegalStateException ( String.format ( "Value type %s is unsupported", value.getClass () ) );
    }

    private static class WriteRequest
    {
        private final ASDUAddress asduAddress;

        private final InformationObjectAddress address;

        private final Variant value;

        public WriteRequest ( final ASDUAddress asduAddress, final InformationObjectAddress address, final Variant value )
        {
            this.asduAddress = asduAddress;
            this.address = address;
            this.value = value;
        }

        public InformationObjectAddress getAddress ()
        {
            return this.address;
        }

        public ASDUAddress getAsduAddress ()
        {
            return this.asduAddress;
        }

        public Variant getValue ()
        {
            return this.value;
        }

        @Override
        public String toString ()
        {
            return String.format ( "[WriteRequest - asduAddress: %s, objectAddress: %s, value: %s", this.asduAddress, this.address, this.value );
        }
    }

    private WriteRequest convert ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final Variant value )
    {
        return new WriteRequest ( header.getAsduAddress (), informationObjectAddress, value );
    }

    @Override
    public void writeCommand ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final boolean state, final byte type, final MirrorCommand mirrorCommand, final boolean execute )
    {
        performWrite ( header, informationObjectAddress, Variant.valueOf ( state ), mirrorCommand, execute );
    }

    @Override
    public void writeValue ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final float value, final byte type, final MirrorCommand mirrorCommand, final boolean execute )
    {
        performWrite ( header, informationObjectAddress, Variant.valueOf ( value ), mirrorCommand, execute );
    }

    @Override
    public void writeScaledValue ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final short value, final byte type, final MirrorCommand mirrorCommand, final boolean execute )
    {
        performWrite ( header, informationObjectAddress, Variant.valueOf ( value ), mirrorCommand, execute );
    }

    private void performWrite ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final Variant value, final MirrorCommand mirrorCommand, final boolean execute )
    {
        final WriteRequest request = convert ( header, informationObjectAddress, value );
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                if ( !performWrite ( request, mirrorCommand, execute ) )
                {
                    mirrorCommand.sendActivationConfirm ( false );
                }
                // actterm will be sent be the write method itself
            }
        } );
    }

    protected synchronized boolean performWrite ( final WriteRequest request, final MirrorCommand mirrorCommand, final boolean execute )
    {
        logger.debug ( "Request to write - request: {}, execute: {}", request, execute );

        final String itemId = this.addressMap.get ( new AddressKey ( request.getAsduAddress ().getAddress (), request.getAddress ().getAddress () ) );
        if ( itemId == null )
        {
            logger.info ( "Item for request not found - request: {}", request );
            return false;
        }

        logger.debug ( "Request to write to item: {}", itemId );

        mirrorCommand.sendActivationConfirm ( true );

        if ( execute )
        {
            final NotifyFuture<WriteResult> future = this.manager.writeValue ( itemId, request.getValue (), null, null );
            future.addListener ( new Runnable () {

                @Override
                public void run ()
                {
                    logger.debug ( "Write command completed - request: {}, item: {}", request, itemId );
                    mirrorCommand.sendActivationTermination ();
                }
            } );
        }

        return true;
    }
}
