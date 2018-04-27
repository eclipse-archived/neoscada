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
package org.eclipse.neoscada.protocol.iec60870.apci;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.eclipse.neoscada.protocol.iec60870.ProtocolOptions;
import org.eclipse.neoscada.protocol.iec60870.apci.UnnumberedControl.Function;
import org.eclipse.neoscada.protocol.iec60870.asdu.MessageManager;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.DataTransmissionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.EncoderException;
import io.netty.util.ReferenceCountUtil;

public class MessageChannel extends ChannelDuplexHandler
{
    private final static Logger logger = LoggerFactory.getLogger ( MessageChannel.class );

    private ChannelHandlerContext ctx;

    private final ProtocolOptions options;

    private Timer timer1;

    private Timer timer2;

    private Timer timer3;

    private final AckBuffer ackBuffer;

    /**
     * Sequence number of next incoming packet
     */
    private int receiveCounter;

    /**
     * Sequence number of last acknowledged packet
     */
    private int ackSentCounter = -1;

    private final Queue<WriteEvent> messageBuffer = new LinkedList<> ();

    private final MessageManager manager;

    private final List<MessageSource> sources = new LinkedList<> ();

    private Runnable startTimers;

    private static class WriteEvent
    {
        private final ByteBuf msg;

        private final ChannelPromise promise;

        private final ChannelHandlerContext ctx;

        WriteEvent ( final ChannelHandlerContext ctx, final ByteBuf msg, final ChannelPromise promise )
        {
            this.ctx = ctx;
            this.msg = msg;
            this.promise = promise;
        }
    }

    public MessageChannel ( final ProtocolOptions options, final MessageManager manager )
    {
        this.options = options != null ? options : new ProtocolOptions.Builder ().build ();
        this.ackBuffer = new AckBuffer ( options.getMaxUnacknowledged (), options.getMaxSequenceNumber () );
        this.manager = manager;
    }

    @Override
    public void channelActive ( final ChannelHandlerContext ctx ) throws Exception
    {
        this.ctx = ctx;

        this.timer1 = new Timer ( ctx, "T1", new TimerHandler () {
            @Override
            public void handleTimeout ()
            {
                handleTimeout1 ();
            }
        } );
        this.timer2 = new Timer ( ctx, "T2", new TimerHandler () {
            @Override
            public void handleTimeout ()
            {
                handleTimeout2 ();
            }
        } );
        this.timer3 = new Timer ( ctx, "T3", new TimerHandler () {
            @Override
            public void handleTimeout ()
            {
                handleTimeout3 ();
            }
        } );

        startTimers = new Runnable () {
            @Override
            public void run ()
            {
                MessageChannel.this.timer1.start ( MessageChannel.this.options.getTimeout1 () );
                MessageChannel.this.timer3.start ( MessageChannel.this.options.getTimeout3 () );
            }
        };

        super.channelActive ( ctx );
    }

    @Override
    public void channelInactive ( final ChannelHandlerContext ctx ) throws Exception
    {
        logger.info ( "Channel inactive" );
        super.channelInactive ( ctx );

        this.timer1.dispose ();
        this.timer2.dispose ();
        this.timer3.dispose ();
    }

    protected void handleTimeout1 ()
    {
        // expiration of timer #1 -> close
        logger.warn ( "Closing connection due to timeout: {}", this.ctx );
        this.ctx.close ();
    }

    protected void handleTimeout2 ()
    {
        sendSupervisory ();
    }

    private void sendSupervisory ()
    {
        synchronized ( this )
        {
            if ( this.ackSentCounter != this.receiveCounter )
            {
                this.ackSentCounter = this.receiveCounter;
                this.ctx.write ( new Supervisory ( this.receiveCounter ) );
            }
        }
        this.ctx.flush ();
    }

    protected void handleTimeout3 ()
    {
        // expiration of timer #3 -> TESTFR
        sendTestAct ();
    }

    @Override
    public void channelRead ( final ChannelHandlerContext ctx, final Object msg ) throws Exception
    {
        logger.trace ( "channelRead - message: {}, ctx: {}", msg, ctx );

        // we received something - restart t3
        this.timer3.restart ( this.options.getTimeout3 () );

        if ( msg instanceof InformationTransfer )
        {
            handleAck ( ctx, ( (InformationTransfer)msg ).getReceiveSequenceNumber () );
            handleInformationTransfer ( (InformationTransfer)msg );
        }
        else if ( msg instanceof UnnumberedControl )
        {
            handleFunction ( ( (UnnumberedControl)msg ).getFunction () );
        }
        else if ( msg instanceof Supervisory )
        {
            handleAck ( ctx, ( (Supervisory)msg ).getReceiveSequenceNumber () );
        }
    }

    protected void handleInformationTransfer ( final InformationTransfer msg )
    {
        synchronized ( this )
        {
            final int nr = msg.getSendSequenceNumber ();
            if ( nr != this.receiveCounter )
            {
                throw new RuntimeException ( String.format ( "Sequence error - expected: %s, received: %s", this.receiveCounter, nr ) );
            }

            incrementReceiveCounter ();

            if ( this.receiveCounter - this.ackSentCounter >= this.options.getAcknowledgeWindow () )
            {
                // send S format right now
                this.timer2.stop (); // just in case the timer was already started
                sendSupervisory ();
            }
            else
            {
                //  schedule transmission for later -> start timer #2
                this.timer2.start ( this.options.getTimeout2 () );
            }
        }

        processInformationTransfer ( this.ctx, msg );
    }

    private void processInformationTransfer ( final ChannelHandlerContext ctx, final Object msg )
    {
        final List<Object> out = new LinkedList<> ();

        logger.trace ( "Passing to manager: {}", msg );
        final ByteBuf errorData = this.manager.receiveMessage ( (InformationTransfer)msg, out );
        if ( errorData != null )
        {
            logger.debug ( "Write error reply" );
            writeMessageToChannel ( ctx, errorData, null );
            ctx.flush ();
        }

        for ( final Object newMsg : out )
        {
            logger.trace ( "Passing message: {}", newMsg );
            ctx.fireChannelRead ( newMsg );
        }
    }

    private void incrementReceiveCounter ()
    {
        this.receiveCounter++;
        if ( this.receiveCounter > this.options.getMaxSequenceNumber () )
        {
            logger.info ( "Reset receive counter" );
            this.receiveCounter = 0;
        }
    }

    protected synchronized void handleAck ( final ChannelHandlerContext ctx, final int receiveSequenceNumber )
    {
        logger.trace ( "Received ACK up to: {}", receiveSequenceNumber );

        // handle ack
        this.ackBuffer.gotAck ( receiveSequenceNumber );

        // now try to flush messages from the buffer
        sendFromBuffer ();
        // try to send from sources
        sendFromSources ();

        ctx.flush ();
    }

    /**
     * Send messages from the local message buffer<br/>
     * <p>
     * <em>Note:</em> This method does not flush the context
     * </p>
     */
    private void sendFromBuffer ()
    {
        while ( !this.ackBuffer.isFull () && !this.messageBuffer.isEmpty () )
        {
            final WriteEvent event = this.messageBuffer.poll ();
            writeMessageToChannel ( event.ctx, event.msg, event.promise );
            if ( logger.isDebugEnabled () )
            {
                logger.debug ( "Sending message from buffer: {} remaining", this.messageBuffer.size () );
            }
        }

        if ( logger.isTraceEnabled () )
        {
            logger.trace ( "AckBuffer(full) : {}, messageBuffer(empty): {}", this.ackBuffer.isFull (), this.messageBuffer.isEmpty () );
        }
    }

    /**
     * Send messages from the message sources <br/>
     * <p>
     * <em>Note:</em> This method does not flush the context
     * </p>
     */
    private void sendFromSources ()
    {
        if ( this.ackBuffer.isFull () )
        {
            return;
        }

        // this method does not cycle through the buffers

        final Iterator<MessageSource> i = this.sources.iterator ();

        source: while ( i.hasNext () && !this.ackBuffer.isFull () /* check again [1] */ )
        {
            final MessageSource source = i.next ();
            logger.trace ( "Try source: {}", source );

            while ( !this.ackBuffer.isFull () )
            {
                final Object msg = source.poll ();
                logger.trace ( "Polled message: {}", msg );
                if ( msg == null )
                {
                    continue source; // try next source
                }
                writeMessageToChannel ( this.ctx, encode ( this.ctx, msg ), null );
            }
        }

        /*
         * [1] check again to prevent unnecessary iterations over the sources list
         */
    }

    private void sendTestAct ()
    {
        logger.info ( "Request TESTFR: {}", this.ctx );
        this.timer1.start ( this.options.getTimeout1 () );
        this.ctx.writeAndFlush ( new UnnumberedControl ( Function.TESTFR_ACT ) );
    }

    @Override
    public void write ( final ChannelHandlerContext ctx, final Object msg, final ChannelPromise promise ) throws Exception
    {
        logger.trace ( "Write {}", msg );
        synchronized ( this )
        {
            if ( msg instanceof DataTransmissionMessage )
            {
                switch ( (DataTransmissionMessage)msg )
                {
                    case REQUEST_START:
                        ctx.write ( new UnnumberedControl ( Function.STARTDT_ACT ), promise );
                        break;
                    case CONFIRM_START:
                        ctx.write ( new UnnumberedControl ( Function.STARTDT_CONFIRM ), promise );
                        break;
                    case REQUEST_STOP:
                        ctx.write ( new UnnumberedControl ( Function.STOPDT_ACT ), promise );
                        break;
                    case CONFIRM_STOP:
                        ctx.write ( new UnnumberedControl ( Function.STOPDT_CONFIRM ), promise );
                        break;
                    default:
                        throw new EncoderException ( String.format ( "Unknown data transmission message: %s", msg ) );
                }
            }
            else if ( msg == MessageSource.NOTIFY_TOKEN )
            {
                handleMessageSourceUpdates ( ctx );
            }
            else
            {
                handleMessageWrite ( ctx, msg, promise );
            }
        }
    }

    private synchronized void handleMessageSourceUpdates ( final ChannelHandlerContext ctx )
    {
        if ( this.ackBuffer.isFull () )
        {
            logger.trace ( "Received notify token but buffer is full" );
            return;
        }

        /*
         * we can directly send from the sources since either is the message buffer
         * not empty, but then also the ackBuffer full. Which it is not at this point.
         *
         * Or the ackBuffer has room, so there won't be any message in the message buffer left.
         */

        sendFromSources ();

        // we have to flush manually
        ctx.flush ();
    }

    private void handleMessageWrite ( final ChannelHandlerContext ctx, final Object msg, final ChannelPromise promise )
    {
        final ByteBuf data = encode ( ctx, msg );

        if ( data == null )
        {
            // ignore
            return;
        }

        // if the buffer is full
        if ( this.ackBuffer.isFull () )
        {
            logger.trace ( "Store message for later transmission" );
            // ... store now and re-try later
            this.messageBuffer.add ( new WriteEvent ( ctx, data, promise ) );
        }
        else
        {
            writeMessageToChannel ( ctx, data, promise );
        }
    }

    private ByteBuf encode ( final ChannelHandlerContext ctx, final Object msg )
    {
        ByteBuf buf = ctx.alloc ().buffer ( 255 );
        try
        {
            this.manager.encodeMessage ( msg, buf );
            if ( buf.isReadable () )
            {
                // copy away the reference so it does not get released
                final ByteBuf buf2 = buf;
                buf = null;
                return buf2;
            }
        }
        finally
        {
            ReferenceCountUtil.release ( buf );
        }
        return null;
    }

    private void writeMessageToChannel ( final ChannelHandlerContext ctx, final ByteBuf data, final ChannelPromise promise )
    {
        final int seq = this.ackBuffer.addMessage ( data );

        if ( promise == null )
        {
            ctx.write ( new InformationTransfer ( seq, this.receiveCounter, data ) );
        }
        else
        {
            ctx.write ( new InformationTransfer ( seq, this.receiveCounter, data ), promise );
        }

        logger.trace ( "Enqueued message as {} : {}", seq, data );

        // we can stop timer #2 here ... will be restarted by receive
        this.timer2.stop ();
    }

    private void handleFunction ( final Function function )
    {
        logger.debug ( "Handle U-format function: {}", function );

        this.timer1.stop ();
        this.timer3.restart ( this.options.getTimeout3 () );

        switch ( function )
        {
            case STARTDT_ACT:
                this.ctx.fireChannelRead ( DataTransmissionMessage.REQUEST_START );
                return;
            case STOPDT_ACT:
                this.ctx.fireChannelRead ( DataTransmissionMessage.REQUEST_STOP );
                return;
            case STARTDT_CONFIRM:
                this.ctx.fireChannelRead ( DataTransmissionMessage.CONFIRM_START );
                return;
            case STOPDT_CONFIRM:
                this.ctx.fireChannelRead ( DataTransmissionMessage.CONFIRM_STOP );
                return;
            case TESTFR_ACT:
                // simply reply with confirm
                this.ctx.writeAndFlush ( new UnnumberedControl ( Function.TESTFR_CONFIRM ) );
                return;
            case TESTFR_CONFIRM:
                // no-op
                return;
            default:
                throw new DecoderException ( String.format ( "Cannot handle function: %s" + function ) );
        }
    }

    public synchronized void addSource ( final MessageSource messageSource )
    {
        this.sources.add ( messageSource );
    }

    public void startTimers ()
    {
        if ( startTimers != null )
        {
            startTimers.run ();
        }
    }
}
