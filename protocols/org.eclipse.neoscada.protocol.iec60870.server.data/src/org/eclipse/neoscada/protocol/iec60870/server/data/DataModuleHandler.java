/*******************************************************************************
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     Red Hat Inc - refactor
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.server.data;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.neoscada.protocol.iec60870.apci.MessageChannel;
import org.eclipse.neoscada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.DataTransmissionMessage;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.InterrogationCommand;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.ReadCommand;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.ValueCommandMessage;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.StandardCause;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Value;
import org.eclipse.neoscada.protocol.iec60870.io.AbstractModuleHandler;
import org.eclipse.neoscada.protocol.iec60870.io.MirrorCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import io.netty.channel.ChannelHandlerContext;

public class DataModuleHandler extends AbstractModuleHandler
{
    private final static Logger logger = LoggerFactory.getLogger ( DataModuleHandler.class );

    private final DataModel dataModel;

    private Subscription subscription;

    private ChannelHandlerContext ctx;

    private final boolean spontaneous;

    private DataListenerImpl spontHandler;

    private final MessageChannel messageChannel;

    private DataModuleMessageSource source;

    private boolean subscribed;

    private final int backgroundScanPeriod;

    private final DataModuleOptions options;

    public DataModuleHandler ( final DataModuleOptions options, final MessageChannel messageChannel, final DataModel dataModel )
    {
        this.options = options;
        this.messageChannel = messageChannel;
        this.dataModel = dataModel;

        this.spontaneous = options.isSpontaneous ();
        this.backgroundScanPeriod = options.getBackgroundScanPeriod ();
    }

    @Override
    public void channelActive ( final ChannelHandlerContext ctx ) throws Exception
    {
        logger.debug ( "Channel active - {}", ctx );

        // we may and must remember the channel context, to know were to send notifications to
        this.ctx = ctx;

        this.source = new DataModuleMessageSource ( this.options, ctx.executor (), new ContextChannelWriter ( ctx ), this.dataModel, this.backgroundScanPeriod );
        this.messageChannel.addSource ( this.source );

        this.spontHandler = new DataListenerImpl ( this.source );
        this.messageChannel.startTimers();

        super.channelActive ( ctx );
    }

    @Override
    public void channelInactive ( final ChannelHandlerContext ctx ) throws Exception
    {
        // stop the subscription
        stopSubscription ( null );
        // and pass on the event
        super.channelInactive ( ctx );
    }

    @Override
    public void channelRead ( final ChannelHandlerContext ctx, final Object msg ) throws Exception
    {
        logger.debug ( "channelRead - msg: {}, ctx: {}", msg, ctx );

        try
        {
            if ( msg == DataTransmissionMessage.REQUEST_START )
            {
                startDataTransmission ( ctx );
            }
            else if ( msg == DataTransmissionMessage.REQUEST_STOP )
            {
                stopDataTransmission ( ctx );
            }
            else if ( msg instanceof ReadCommand )
            {
                handleReadCommand ( ctx, (ReadCommand)msg );
            }
            else if ( msg instanceof InterrogationCommand )
            {
                handleInterrogationCommand ( ctx, (InterrogationCommand)msg );
            }
            else if ( msg instanceof ValueCommandMessage )
            {
                handleWriteValue ( ctx, (ValueCommandMessage)msg );
            }
            else
            {
                // otherwise pass the message on to the next handler
                ctx.fireChannelRead ( msg );
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to process message", e );
            throw new InvocationTargetException ( e );
        }
    }

    private void handleWriteValue ( final ChannelHandlerContext ctx, final ValueCommandMessage msg )
    {
        final MirrorCommand mc = new DefaultMirrorCommand<ValueCommandMessage> ( ctx, msg );
        this.dataModel.writeValue ( msg.getHeader (), msg.getInformationObjectAddress (), msg.getValue (), msg.getType (), mc, msg.isExecute () );
    }

    private void stopDataTransmission ( final ChannelHandlerContext ctx )
    {
        // stopping is simple
        stopSubscription ( ctx );
    }

    private void startDataTransmission ( final ChannelHandlerContext ctx )
    {
        // send out the confirmation right now
        ctx.writeAndFlush ( DataTransmissionMessage.CONFIRM_START );
        if ( this.spontaneous )
        {
            startSubscription ( ctx );
            logger.debug ( "Started subscription" );
        }
        else
        {
            // we just fake it
            logger.debug ( "Started subscription (fake)" );
        }
    }

    private void startSubscription ( final ChannelHandlerContext ctx )
    {
        logger.info ( "Start subscription - active: {}", this.subscription != null );

        synchronized ( this )
        {
            if ( this.subscribed )
            {
                return;
            }
            this.subscribed = true;
        }

        this.subscription = this.dataModel.subscribe ( this.spontHandler );
    }

    private void stopSubscription ( final ChannelHandlerContext ctx )
    {
        logger.info ( "Stop subscription - active: {}", this.subscription != null );

        Subscription subscription;

        synchronized ( this )
        {
            if ( !this.subscribed )
            {
                return;
            }

            this.subscribed = false;

            subscription = this.subscription;
            this.subscription = null;
        }

        if ( subscription == null )
        {
            // this should never happen ...
            if ( ctx != null )
            {
                ctx.writeAndFlush ( DataTransmissionMessage.CONFIRM_STOP );
            }
            return;
        }

        // there might still be some event pending ...
        final ListenableFuture<Void> future = subscription.dispose ();
        if ( ctx != null )
        {
            Futures.addCallback ( future, new CloseOnFailureCallback ( ctx ) {

                @Override
                public void onSuccess ( final Void result )
                {
                    // ... now they have all been sent
                    ctx.writeAndFlush ( DataTransmissionMessage.CONFIRM_STOP );
                }
            } );
        }
    }

    private void handleReadCommand ( final ChannelHandlerContext ctx, final ReadCommand msg )
    {
        logger.debug ( "Handle read command" );

        if ( msg.getHeader ().getCauseOfTransmission ().getCause () != StandardCause.REQUEST )
        {
            ctx.writeAndFlush ( msg.mirror ( StandardCause.UNKNOWN_REASON, true ) );
            return;
        }

        final InformationObjectAddress address = msg.getInformationObjectAddress ();
        final ASDUHeader header = msg.getHeader ();

        final ListenableFuture<Value<?>> result = this.dataModel.read ( header.getAsduAddress (), address );
        if ( result != null )
        {
            Futures.addCallback ( result, new FutureCallback<Value<?>> () {

                @Override
                public void onSuccess ( final Value<?> result )
                {
                    handleReadCommandComplete ( header, address, result );
                }

                @Override
                public void onFailure ( final Throwable t )
                {
                    handleReadFailure ( header, address, t );
                }
            } );
        }
        else
        {
            handleReadFailure ( header, address, null );
        }
    }

    protected void handleReadFailure ( final ASDUHeader originalHeader, final InformationObjectAddress address, final Throwable t )
    {
        // TODO: check if this is really the correct behavior
        this.ctx.writeAndFlush ( new ReadCommand ( originalHeader.clone ( StandardCause.UNKNOWN_INFORMATION_OBJECT_ADDRESS ), address ) );
    }

    @SuppressWarnings ( "unchecked" )
    protected void handleReadCommandComplete ( final ASDUHeader originalHeader, final InformationObjectAddress address, final Value<?> result )
    {
        if ( result == null )
        {
            this.ctx.writeAndFlush ( new ReadCommand ( originalHeader.clone ( StandardCause.UNKNOWN_INFORMATION_OBJECT_ADDRESS ), address ) );
            return;
        }

        final ASDUHeader header = originalHeader.clone ( StandardCause.REQUEST );
        final Object value = result.getValue ();

        if ( value instanceof Boolean )
        {
            this.source.sendBooleanValue ( header, address, (Value<Boolean>)result );
        }
        else if ( value instanceof Float )
        {
            this.source.sendFloatValue ( header, address, (Value<Float>)result );
        }
        else
        {
            handleReadFailure ( originalHeader, address, null );
        }
    }

    private void handleInterrogationCommand ( final ChannelHandlerContext ctx, final InterrogationCommand msg )
    {
        logger.debug ( "Handle interrogation command" );

        this.source.startInterrogation ( msg );
    }
}
