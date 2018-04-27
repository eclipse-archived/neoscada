/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     Red Hat Inc -refactor data model
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.server.data.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import org.eclipse.neoscada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.CommandValue;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.QualityInformation;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.StandardCause;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Value;
import org.eclipse.neoscada.protocol.iec60870.io.MirrorCommand;
import org.eclipse.neoscada.protocol.iec60870.server.data.AbstractBaseDataModel;
import org.eclipse.neoscada.protocol.iec60870.server.data.BackgroundIterator;
import org.eclipse.neoscada.protocol.iec60870.server.data.DataListener;
import org.eclipse.neoscada.protocol.iec60870.server.data.event.MessageBuilder;
import org.eclipse.neoscada.protocol.iec60870.server.data.event.SimpleFloatBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.ListenableFuture;

public class SineDataModel extends AbstractBaseDataModel
{
    private static final SimpleFloatBuilder BUILDER = new SimpleFloatBuilder ( false );

    private final class BackgroundIteratorImpl implements BackgroundIterator
    {
        private final AtomicInteger position = new AtomicInteger ();

        @Override
        public Object nextMessage ()
        {
            return proceedBackgroundScan ( this.position );
        }
    }

    private static final ASDUAddress ASDU_ADDRESS = ASDUAddress.valueOf ( 1 );

    private final static Logger logger = LoggerFactory.getLogger ( SineDataModel.class );

    private final List<Value<Float>> values;

    private final int size;

    private final InformationObjectAddress startAddress = new InformationObjectAddress ( 1 );

    public SineDataModel ( final int size )
    {
        super ( "SineDataModel" );

        this.size = size;
        this.values = new ArrayList<> ( size );

        for ( int i = 0; i < size; i++ )
        {
            this.values.add ( new Value<> ( 0.0f, System.currentTimeMillis (), QualityInformation.INVALID ) );
        }

        this.executor.scheduleAtFixedRate ( new Runnable () {

            @Override
            public void run ()
            {
                update ();
            }
        }, 0, 250, TimeUnit.MILLISECONDS );
    }

    protected synchronized void update ()
    {
        final long tix = System.currentTimeMillis ();
        for ( int i = 0; i < this.size; i++ )
        {
            this.values.set ( i, Value.ok ( (float)Math.sin ( Math.toRadians ( tix / 1000.0 ) ) * i ) );
        }
        notifyChangeFloat ( CauseOfTransmission.SPONTANEOUS, ASDU_ADDRESS, this.startAddress, this.values );
    }

    @Override
    public ListenableFuture<Value<?>> read ( final ASDUAddress asduAddress, final InformationObjectAddress address )
    {
        if ( ASDU_ADDRESS.equals ( asduAddress.getAddress () ) )
        {
            return null;
        }

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
        return this.values.get ( address.getAddress () );
    }

    @Override
    public ListenableFuture<Void> readAll ( CauseOfTransmission cause, final ASDUAddress asduAddress, final Runnable prepare, final DataListener listener )
    {
        if ( asduAddress.getAddress () != 1 )
        {
            return null;
        }

        this.executor.submit ( prepare );

        return this.executor.submit ( new Callable<Void> () {

            @Override
            public Void call () throws Exception
            {
                return performReadAll ( listener );
            }
        } );
    }

    protected synchronized Void performReadAll ( final DataListener listener )
    {
        logger.debug ( "performReadAll" );

        listener.dataChangeFloat ( CauseOfTransmission.SPONTANEOUS, ASDU_ADDRESS, this.startAddress, new ArrayList<> ( this.values ) );

        logger.debug ( "performReadAll - done" );
        return null;
    }

    @Override
    public void forAllAsdu ( final Consumer<ASDUAddress> function, final Runnable ifNoneFound )
    {
        // we only have one

        function.accept ( ASDU_ADDRESS );;
    }

    @Override
    public BackgroundIterator createBackgroundIterator ()
    {
        return new BackgroundIteratorImpl ();
    }

    protected Object proceedBackgroundScan ( final AtomicInteger positionRef )
    {
        final int position = positionRef.get ();
        if ( position >= this.size )
        {
            return null;
        }

        try
        {
            return this.executor.submit ( new Callable<Object> () {
                @Override
                public Object call () throws Exception
                {
                    return internalBackgroundScan ( positionRef );
                }
            } ).get ();
        }
        catch ( final Exception e )
        {
            throw new RuntimeException ( "Failed to perform background scan", e );
        }
    }

    private synchronized Object internalBackgroundScan ( final AtomicInteger positionRef )
    {
        int position = positionRef.get ();

        final MessageBuilder<Float, ?> builder = BUILDER.create ();
        builder.start ( CauseOfTransmission.BACKGROUND, ASDU_ADDRESS );

        while ( builder.addEntry ( new InformationObjectAddress ( this.startAddress.getAddress () + position ), this.values.get ( position ) ) )
        {
            position++;
        }

        positionRef.set ( position );

        return builder.build ();
    }

    private void performWrite ( final MirrorCommand mirrorCommand, final boolean execute )
    {
        mirrorCommand.sendActivationConfirm ( true );
        if ( execute )
        {
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    handleWriteCommand ( mirrorCommand );
                }
            } );
        }
    }

    @Override
    public void writeValue ( ASDUHeader header, InformationObjectAddress informationObjectAddress, CommandValue<?> value, byte type, MirrorCommand mirrorCommand, boolean execute )
    {
        performWrite ( mirrorCommand, execute );
    }

    protected synchronized void handleWriteCommand ( final MirrorCommand mirrorCommand )
    {
        // we silently accept it
        mirrorCommand.sendActivationTermination ();
    }

}
