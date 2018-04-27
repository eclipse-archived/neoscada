/*******************************************************************************
 * Copyright (c) 2016, 2017 Red Hat Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.server.data.model;

import static java.util.Optional.ofNullable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import org.eclipse.neoscada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.CommandValue;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationEntry;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Value;
import org.eclipse.neoscada.protocol.iec60870.io.MirrorCommand;
import org.eclipse.neoscada.protocol.iec60870.server.data.AbstractBaseDataModel;
import org.eclipse.neoscada.protocol.iec60870.server.data.BackgroundIterator;
import org.eclipse.neoscada.protocol.iec60870.server.data.DataListener;
import org.eclipse.neoscada.protocol.iec60870.server.data.Stopping;
import org.eclipse.neoscada.protocol.iec60870.server.data.model.WriteModel.Action;
import org.eclipse.neoscada.protocol.iec60870.server.data.model.WriteModel.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.ListenableFuture;

public abstract class ChangeDataModel extends AbstractBaseDataModel
{
    private static final Logger logger = LoggerFactory.getLogger ( ChangeDataModel.class );

    /*
     * we use a sorted map, so that the addresses are sorted and we
     * can generate continuous addresses in the message builders
     */
    private final SortedMap<Integer, SortedMap<Integer, Value<?>>> cache = new TreeMap<> ();

    private ChangeModel changeModel;

    private WriteModel writeModel;

    private BackgroundModel backgroundModel;

    /**
     * Create a ChangeModel for this data model instance
     * <p>
     * This method is called exactly once by the {@link #start()} method
     * </p>
     *
     * @return a new change model instance
     */
    protected abstract ChangeModel createChangeModel ();

    /**
     * Create a WriteModel for this data model instance
     * <p>
     * This method is called exactly once by the {@link #start()} method
     * </p>
     *
     * @return a new write model instance
     */
    protected abstract WriteModel createWriteModel ();

    /**
     * Create a BackgroundModel for this data model instance
     * <p>
     * This method is called exactly once by the {@link #start()} method
     * </p>
     *
     * @return a new background model instance
     */
    protected abstract BackgroundModel createBackgroundModel ();

    public ChangeDataModel ( final String threadName )
    {
        super ( threadName );
    }

    @Override
    public synchronized void start ()
    {
        if ( this.changeModel != null )
        {
            // second start
            return;
        }

        super.start ();

        this.changeModel = createChangeModel ();
        this.writeModel = createWriteModel ();
        this.backgroundModel = createBackgroundModel ();
    }

    @Override
    public Stopping stop ()
    {
        return internalDispose ().andThen ( super.stop () );
    }

    private synchronized Stopping internalDispose ()
    {
        final Optional<Runnable> cmDispose = ofNullable ( this.changeModel ).map ( ChangeModel::dispose );
        final Optional<Runnable> wmDispose = ofNullable ( this.writeModel ).map ( WriteModel::dispose );
        final Optional<Runnable> bmDispose = ofNullable ( this.backgroundModel ).map ( BackgroundModel::dispose );

        this.changeModel = null;
        this.writeModel = null;
        this.backgroundModel = null;

        return new Stopping () {

            @Override
            public void await () throws Exception
            {
                cmDispose.ifPresent ( Runnable::run );
                wmDispose.ifPresent ( Runnable::run );
                bmDispose.ifPresent ( Runnable::run );
            }
        };
    }

    protected BackgroundModel makeDefaultBackgroundModel ()
    {
        return new BackgroundModelImpl ( this.cache, this );
    }

    protected ChangeModel makeInstantChangeModel ()
    {
        return new InstantChangeModel ( new InstantChangeModel.Context () {

            @Override
            public void notifyChangeBoolean ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final InformationObjectAddress startAddress, final List<Value<Boolean>> values )
            {
                ChangeDataModel.this.notifyChangeBoolean ( cause, asduAddress, startAddress, values );
            }

            @Override
            public void notifyChangeFloat ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final InformationObjectAddress startAddress, final List<Value<Float>> values )
            {
                ChangeDataModel.this.notifyChangeFloat ( cause, asduAddress, startAddress, values );
            }

            @Override
            public void notifyChangeShort ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final InformationObjectAddress startAddress, final List<Value<Short>> values )
            {
                ChangeDataModel.this.notifyChangeShort ( cause, asduAddress, startAddress, values );
            }

        } );
    }

    protected ChangeModel makeBufferingChangeModel ( final long flushDelay )
    {
        return new BufferingChangeModel ( new BufferingChangeModel.Context () {

            @Override
            public void notifyBoolean ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final List<InformationEntry<Boolean>> values )
            {
                ChangeDataModel.this.notifyChangeBoolean ( cause, asduAddress, values );
            }

            @Override
            public void notifyFloat ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final List<InformationEntry<Float>> values )
            {
                ChangeDataModel.this.notifyChangeFloat ( cause, asduAddress, values );
            }

            @Override
            public void notifyShort ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final List<InformationEntry<Short>> values )
            {
                ChangeDataModel.this.notifyChangeShort ( cause, asduAddress, values );
            }
        }, this.executor, flushDelay );
    }

    @Override
    public BackgroundIterator createBackgroundIterator ()
    {
        return this.backgroundModel.createBackgroundIterator ().orElse ( null );
    }

    protected synchronized void notifyDataChange ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final InformationObjectAddress informationObjectAddress, final Value<?> value, final boolean notify )
    {
        logger.trace ( "Notify data change - ASDU: {}, IOA: {}, value: {}", asduAddress, informationObjectAddress, value );

        SortedMap<Integer, Value<?>> unit = this.cache.get ( asduAddress.getAddress () );
        if ( unit == null )
        {
            unit = new TreeMap<> ();
            this.cache.put ( asduAddress.getAddress (), unit );
        }

        unit.put ( informationObjectAddress.getAddress (), value );

        this.changeModel.notifyChange ( cause, asduAddress, informationObjectAddress, value );
    }

    @Override
    public void writeValue ( ASDUHeader header, InformationObjectAddress informationObjectAddress, CommandValue<?> value, byte type, MirrorCommand mirrorCommand, boolean execute )
    {
        scheduleCommand ( new WriteModel.Request<> ( header, informationObjectAddress, value, type, execute ), mirrorCommand, WriteModel::prepareWriteValue );
    }

    private synchronized <T> void scheduleCommand ( final Request<T> request, final MirrorCommand mirrorCommand, final BiFunction<WriteModel, Request<T>, Action> func )
    {
        // make a copy so that when we got stopped, we still have our reference
        final WriteModel writeModel = this.writeModel;

        this.executor.execute ( () -> {
            final Action action = func.apply ( writeModel, request );
            if ( action == null )
            {
                mirrorCommand.sendActivationConfirm ( false );
                return;
            }

            mirrorCommand.sendActivationConfirm ( true );

            action.execute ().whenComplete ( ( v, e ) -> {
                logger.debug ( "Write command completed - request: {}", request );
                mirrorCommand.sendActivationTermination ();
            } );
        } );
    }

    @Override
    public ListenableFuture<Value<?>> read ( final ASDUAddress asduAddress, final InformationObjectAddress address )
    {
        return this.executor.submit ( () -> performRead ( asduAddress, address ) );
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
    public synchronized ListenableFuture<Void> readAll (  final CauseOfTransmission cause, final ASDUAddress asduAddress, final Runnable prepare, final DataListener listener )
    {
        final Map<Integer, Value<?>> map = this.cache.get ( asduAddress.getAddress () );
        if ( map == null )
        {
            return null;
        }

        final Map<Integer, Value<?>> map2 = new HashMap<> ( map ); // copy

        this.executor.submit ( prepare );

        return this.executor.submit ( () -> performReadAll ( cause, asduAddress, listener, map2 ), null );
    }

    protected synchronized void performReadAll ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final DataListener listener, final Map<Integer, Value<?>> map )
    {
        for ( final Map.Entry<Integer, Value<?>> entry : map.entrySet () )
        {
            fireListener ( cause, asduAddress, listener, entry );
        }
    }

    @SuppressWarnings ( "unchecked" )
    private static void fireListener ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final DataListener listener, final Map.Entry<Integer, Value<?>> entry )
    {
        final Value<?> ve = entry.getValue ();
        final Object v = ve.getValue ();

        if ( v instanceof Boolean )
        {
            listener.dataChangeBoolean ( cause, asduAddress, InformationObjectAddress.valueOf ( entry.getKey () ), Collections.singletonList ( (Value<Boolean>)ve ) );
        }
        else if ( v instanceof Float )
        {
            listener.dataChangeFloat ( cause, asduAddress, InformationObjectAddress.valueOf ( entry.getKey () ), Collections.singletonList ( (Value<Float>)ve ) );
        }
        else if ( v instanceof Short )
        {
            listener.dataChangeShort ( cause, asduAddress, InformationObjectAddress.valueOf ( entry.getKey () ), Collections.singletonList ( (Value<Short>)ve ) );
        }
        // FIXME: scaled values
    }

    @Override
    public void forAllAsdu ( final Consumer<ASDUAddress> function, final Runnable ifNoneFound )
    {
        this.executor.execute ( () -> performForAllAsdu ( function, ifNoneFound ) );
    }

    protected synchronized void performForAllAsdu ( final Consumer<ASDUAddress> function, final Runnable ifNoneFound )
    {
        if ( this.cache.isEmpty () )
        {
            this.executor.execute ( ifNoneFound );
            return;
        }

        for ( final Integer asdu : this.cache.keySet () )
        {
            this.executor.execute ( () -> function.accept ( ASDUAddress.valueOf ( asdu ) ) );
        }
    }

}
