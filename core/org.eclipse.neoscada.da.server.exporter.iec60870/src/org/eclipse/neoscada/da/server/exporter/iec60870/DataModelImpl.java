/*******************************************************************************
 * Copyright (c) 2014, 2017 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     Red Hat Inc - refactor and allow re-use outside of exporter
 *******************************************************************************/
package org.eclipse.neoscada.da.server.exporter.iec60870;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.eclipse.neoscada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.QualityInformation;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Value;
import org.eclipse.neoscada.protocol.iec60870.server.data.DataListener;
import org.eclipse.neoscada.protocol.iec60870.server.data.DefaultSubscription;
import org.eclipse.neoscada.protocol.iec60870.server.data.Stopping;
import org.eclipse.neoscada.protocol.iec60870.server.data.Subscription;
import org.eclipse.neoscada.protocol.iec60870.server.data.model.BackgroundModel;
import org.eclipse.neoscada.protocol.iec60870.server.data.model.ChangeDataModel;
import org.eclipse.neoscada.protocol.iec60870.server.data.model.ChangeModel;
import org.eclipse.neoscada.protocol.iec60870.server.data.model.WriteModel;
import org.eclipse.neoscada.protocol.iec60870.server.data.model.WriteModel.Action;
import org.eclipse.scada.core.NotConvertableException;
import org.eclipse.scada.core.NullValueException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.server.exporter.common.HiveSource;
import org.eclipse.scada.da.server.exporter.common.SingleSubscriptionManager;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.ListenableFuture;

/**
 * An IEC60870-5 data model for Eclipse SCADA <br/>
 * <h1>Implementation details</h1>
 * <p>
 * All entries are initialized with {@link DataItemValue#DISCONNECTED} in order
 * to populate the caches. This will allow the background transfer to already
 * have data before changes came in.
 * </p>
 */
public class DataModelImpl extends ChangeDataModel
{
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

    private final static Logger logger = LoggerFactory.getLogger ( DataModelImpl.class );

    private final Long flushDelay;

    private final boolean supportBackgroundScan;

    private SingleSubscriptionManager manager;

    private final InformationBean info;

    private final Map<AddressKey, String> addressMap = new HashMap<> ();

    private final HiveSource hiveSource;

    private final Set<MappingEntry> entries;

    private final Properties hiveProperties;

    public DataModelImpl ( final HiveSource hiveSource, final Set<MappingEntry> entries, final Properties hiveProperties, final InformationBean info, final Long flushDelay, final boolean supportBackgroundScan, final Long period )
    {
        super ( "org.eclipse.neoscada.da.server.exporter.iec60870.DataModel" );

        this.flushDelay = flushDelay;
        this.supportBackgroundScan = supportBackgroundScan;

        this.hiveSource = hiveSource;
        this.entries = new HashSet<> ( entries );
        this.hiveProperties = hiveProperties;

        this.info = info;

        for ( final MappingEntry entry : entries )
        {
            this.addressMap.put ( new AddressKey ( entry.getAsduAddress ().getAddress (), entry.getAddress ().getAddress () ), entry.getItemId () );
        }
    }

    @Override
    protected BackgroundModel createBackgroundModel ()
    {
        if ( this.supportBackgroundScan )
        {
            return makeDefaultBackgroundModel ();
        }
        else
        {
            return BackgroundModel.NONE;
        }
    }

    @Override
    protected ChangeModel createChangeModel ()
    {
        return this.flushDelay == null ? makeInstantChangeModel () : makeBufferingChangeModel ( this.flushDelay );
    }

    @Override
    protected WriteModel createWriteModel ()
    {
        return new WriteModel () {

            @Override
            public Action prepareWriteValue ( final Request<?> request )
            {
                return DataModelImpl.this.prepareWriteValue ( request );
            }
        };
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
            this.manager.addListener ( entry.getItemId (), ( itemId, value ) -> handleStateChanged ( entry, value, true ) );
        }
    }

    protected synchronized void handleStateChanged ( final MappingEntry entry, final DataItemValue value, final boolean notify )
    {
        logger.trace ( "Handle state change - entry: {}, value: {}", entry, value );

        final Value<?> iecValue = convert ( entry, value );
        logger.trace ( "Converted to: {}", iecValue );

        notifyDataChange ( CauseOfTransmission.SPONTANEOUS, entry.getAsduAddress (), entry.getAddress (), iecValue, notify );
    }

    private static Value<?> convert ( final MappingEntry entry, final DataItemValue value )
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
            return new Value<> ( cv, convertTimestamp ( value ), convertQuality ( value ) );
        }
        catch ( final Exception e )
        {
            logger.debug ( "Conversion error", e );
            return errorValue ( entry );
        }
    }

    private static long convertTimestamp ( final DataItemValue value )
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

    private static Object convertValue ( final MappingEntry entry, final DataItemValue value ) throws NullValueException, NotConvertableException
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

    private static QualityInformation convertQuality ( final DataItemValue value )
    {
        final boolean valid = value.isConnected () && !value.isError ();
        final boolean substituted = value.isManual ();
        final boolean blocked = value.isBlocked ();
        final boolean topical = true;
        return new QualityInformation ( blocked, substituted, topical, valid );
    }

    private static Value<?> errorValue ( final MappingEntry entry )
    {
        switch ( entry.getValueType () )
        {
            case FLOAT:
                return new Value<> ( 0.0f, System.currentTimeMillis (), QualityInformation.INVALID );
            case BOOLEAN:
            default:
                return new Value<> ( false, System.currentTimeMillis (), QualityInformation.INVALID );
        }
    }

    @Override
    public synchronized void start ()
    {
        super.start ();

        // initialize after the executor has been initialized

        this.manager = new SingleSubscriptionManager ( this.executor, this.hiveSource, this.hiveProperties, "IEC60870/DataModel" );
        this.manager.start ();

        attach ( this.entries );
    }

    @Override
    public Stopping stop ()
    {
        this.manager.stop ();
        return super.stop ();
    }

    protected Action prepareWriteValue ( final WriteModel.Request<?> request )
    {
        return prepareWrite ( request, Variant.valueOf ( request.getValue () ) );
    }

    private synchronized Action prepareWrite ( final WriteModel.Request<?> request, final Variant value )
    {
        logger.debug ( "Request to write - request: {}, value: {}", request, value );

        final String itemId = this.addressMap.get ( new AddressKey ( request.getHeader ().getAsduAddress ().getAddress (), request.getAddress ().getAddress () ) );
        if ( itemId == null )
        {
            logger.info ( "Item for request not found - request: {}", request );
            return null;
        }

        logger.debug ( "Request to write to item: {}", itemId );

        if ( !request.isExecute () )
        {
            return () -> CompletableFuture.completedFuture ( null );
        }
        else
        {
            return new Action () {

                @Override
                public CompletionStage<Void> execute ()
                {
                    final NotifyFuture<WriteResult> future = DataModelImpl.this.manager.writeValue ( itemId, value, null, null );

                    final CompletableFuture<Void> result = new CompletableFuture<> ();
                    future.addListener ( () -> result.complete ( null ) );

                    return result;
                }
            };
        }
    }
}
