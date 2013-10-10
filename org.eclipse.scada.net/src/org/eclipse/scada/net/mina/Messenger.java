/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.net.mina;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.apache.mina.core.future.WriteFuture;
import org.eclipse.scada.core.info.StatisticsImpl;
import org.eclipse.scada.net.base.MessageListener;
import org.eclipse.scada.net.base.MessageStateListener;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.utils.MessageCreator;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Messenger implements MessageListener
{
    private static Object STATS_RECEIVED_MSGS = new Object ();

    private static Object STATS_SENT_MSGS = new Object ();

    private final static Logger logger = LoggerFactory.getLogger ( Messenger.class );

    private ScheduledFuture<?> timeoutJob;

    private static class MessageTag
    {
        private MessageStateListener listener;

        private long timestamp = 0;

        private long timeout = 0;

        private boolean canceled = false;

        public MessageStateListener getListener ()
        {
            return this.listener;
        }

        public void setListener ( final MessageStateListener listener )
        {
            this.listener = listener;
        }

        public void setTimestamp ( final long timestamp )
        {
            this.timestamp = timestamp;
        }

        public void setTimeout ( final long timeout )
        {
            this.timeout = timeout;
        }

        public synchronized boolean isTimedOut ()
        {
            if ( this.timeout <= 0 )
            {
                return this.canceled;
            }

            if ( this.canceled )
            {
                return true;
            }

            return System.currentTimeMillis () - this.timestamp >= this.timeout;
        }

        public synchronized void cancel ()
        {
            this.canceled = true;
        }

        public boolean isCanceled ()
        {
            return this.canceled;
        }
    }

    private final Map<Long, MessageTag> tagList = new HashMap<Long, MessageTag> ();

    private MessageSender connection;

    private ScheduledExecutorService timer;

    private final long sessionTimeout;

    private final long timeoutJobPeriod;

    private final StatisticsImpl statistics;

    public Messenger ( final long timeout, final StatisticsImpl statistics )
    {
        this.sessionTimeout = timeout;
        this.timeoutJobPeriod = 1000;
        this.statistics = statistics;

        statistics.setLabel ( STATS_RECEIVED_MSGS, "Received messages" );
        statistics.setLabel ( STATS_SENT_MSGS, "Sent messages" );
    }

    public long getSessionTimeout ()
    {
        return this.sessionTimeout;
    }

    @Override
    protected void finalize () throws Throwable
    {
        logger.debug ( "Finalized" );
        if ( this.timer != null )
        {
            this.timer.shutdown ();
        }
        super.finalize ();
    }

    public void connected ( final MessageSender connection )
    {
        disconnected ();

        Collection<MessageTag> tags = null;

        synchronized ( this )
        {
            if ( connection != null )
            {
                logger.info ( "Messenger connected" );

                this.connection = connection;
                tags = cleanTagList ();

                this.timer = Executors.newSingleThreadScheduledExecutor ( new NamedThreadFactory ( "MessengerTimer/" + connection, true ) );
                final Runnable runnable = new Runnable () {

                    @Override
                    public void run ()
                    {
                        Messenger.this.processTimeOuts ();
                    }

                    @Override
                    protected void finalize () throws Throwable
                    {
                        logger.debug ( "Finalized timeout job" );
                        super.finalize ();
                    }
                };
                this.timeoutJob = this.timer.scheduleWithFixedDelay ( runnable, this.sessionTimeout, this.timeoutJobPeriod, TimeUnit.MILLISECONDS );
            }
        }

        fireTimeouts ( tags );
    }

    /**
     * Disconnects the messenger from the current connection (if there is one).
     * <p>
     * Be aware that the returned message tags have to be timed out (e.g. using {@link #fireTimeouts(Collection)}), otherwise they will wait forever!
     * </p>
     * 
     * @return
     */
    protected synchronized Collection<MessageTag> performDisconnect ()
    {
        if ( this.connection != null )
        {
            this.connection = null;
            logger.info ( "Disconnected" );
            final Collection<MessageTag> tags = cleanTagList ();
            if ( this.timeoutJob != null )
            {
                this.timeoutJob.cancel ( false );
                this.timeoutJob = null;
            }
            if ( this.timer != null )
            {
                this.timer.shutdown ();
                this.timer = null;
            }
            return tags;
        }
        else
        {
            return null;
        }
    }

    public void disconnected ()
    {
        final Collection<MessageTag> tags = performDisconnect ();

        // now fire events from cleanup but outside the sync lock
        fireTimeouts ( tags );
    }

    /**
     * Fire timeouts for all provided tags
     * 
     * @param tags
     *            a list of tags to time out, accepts <code>null</code>
     */
    private static void fireTimeouts ( final Collection<MessageTag> tags )
    {
        if ( tags != null )
        {
            for ( final MessageTag tag : tags )
            {
                tag.getListener ().messageTimedOut ();
            }
        }
    }

    private final Map<Integer, MessageListener> listeners = new HashMap<Integer, MessageListener> ();

    private volatile long lastMessge;

    public void setHandler ( final int commandCode, final MessageListener handler )
    {
        this.listeners.put ( Integer.valueOf ( commandCode ), handler );
    }

    public void unsetHandler ( final int commandCode )
    {
        this.listeners.remove ( Integer.valueOf ( commandCode ) );
    }

    private Collection<MessageTag> cleanTagList ()
    {
        final Collection<MessageTag> tags = new LinkedList<MessageTag> ();

        synchronized ( this.tagList )
        {
            for ( final Map.Entry<Long, MessageTag> tag : this.tagList.entrySet () )
            {
                try
                {
                    if ( !tag.getValue ().isCanceled () )
                    {
                        tag.getValue ().cancel ();
                        tags.add ( tag.getValue () );
                    }
                }
                catch ( final Throwable e )
                {
                    logger.warn ( "Failed to handle message timeout", e );
                }
            }
            this.tagList.clear ();
        }
        return tags;
    }

    @Override
    public void messageReceived ( final Message message )
    {
        this.statistics.changeCurrentValue ( STATS_RECEIVED_MSGS, 1 );

        this.lastMessge = System.currentTimeMillis ();

        if ( logger.isDebugEnabled () )
        {
            if ( message.getReplySequence () == 0 )
            {
                logger.debug ( String.format ( "Received message: 0x%1$08X Seq: %2$d", message.getCommandCode (), message.getSequence () ) );
            }
            else
            {
                logger.debug ( String.format ( "Received message: 0x%1$08X Seq: %2$d in reply to: %3$d", message.getCommandCode (), message.getSequence (), message.getReplySequence () ) );
            }
        }

        if ( handleTagMessage ( message ) )
        {
            return;
        }
        else if ( handleDefaultMessage ( message ) )
        {
            return;
        }
        else if ( handleHandlerMessage ( message ) )
        {
            return;
        }

        handleUnknownMessage ( message );
    }

    protected void handleUnknownMessage ( final Message message )
    {
        sendMessage ( MessageCreator.createUnknownMessage ( message ) );
    }

    private boolean handleTagMessage ( final Message message )
    {
        final Long seq = Long.valueOf ( message.getReplySequence () );

        MessageTag tag = null;
        synchronized ( this.tagList )
        {
            if ( this.tagList.containsKey ( seq ) )
            {
                tag = this.tagList.get ( seq );

                // if the tag is timed out then we don't process it here and let processTimeOuts () do the job
                if ( !tag.isTimedOut () )
                {
                    this.tagList.remove ( seq );
                }
                else
                {
                    logger.info ( "Found tag for message {} but it is timed out", seq );
                    tag = null;
                    return true;
                }
            }
        }

        try
        {
            if ( tag != null )
            {
                logger.debug ( "Processing message listener for message {}", seq );
                tag.getListener ().messageReply ( message );
            }
        }
        catch ( final Throwable e )
        {
            logger.warn ( "Custom message failed", e );
        }
        return tag != null;
    }

    private void processTimeOuts ()
    {
        final List<MessageTag> removeBag = new LinkedList<MessageTag> ();

        // check for session timeout
        checkSessionTimeout ();

        // check for message timeouts
        synchronized ( this.tagList )
        {
            for ( final Iterator<Map.Entry<Long, MessageTag>> i = this.tagList.entrySet ().iterator (); i.hasNext (); )
            {
                final MessageTag tag = i.next ().getValue ();

                if ( tag.isTimedOut () )
                {
                    removeBag.add ( tag );
                    i.remove ();
                }
            }
        }

        // now send out time outs
        for ( final MessageTag tag : removeBag )
        {
            try
            {
                tag.getListener ().messageTimedOut ();
            }
            catch ( final Throwable e )
            {
                logger.info ( "Failed to handle messageTimedOut", e );
            }
        }
    }

    private void checkSessionTimeout ()
    {
        final long now = System.currentTimeMillis ();
        final long timeDiff = now - this.lastMessge;

        if ( this.connection == null )
        {
            logger.warn ( "Called without a connection" );
        }

        if ( timeDiff > this.sessionTimeout )
        {
            final Collection<MessageTag> tags;
            synchronized ( this )
            {
                if ( this.connection == null )
                {
                    return;
                }

                logger.warn ( "Closing connection due to receive timeout: {} (timeout: {})", timeDiff, this.sessionTimeout );
                // we close the connection and wait for "disconnected" to get called from outside
                this.connection.close ();

                tags = performDisconnect ();
            }
            fireTimeouts ( tags );
        }
    }

    public WriteFuture sendMessage ( final Message message )
    {
        return sendMessage ( message, null );
    }

    public WriteFuture sendMessage ( final Message message, final MessageStateListener messageListener )
    {
        return sendMessage ( message, messageListener, 0L );
    }

    protected void registerMessageTag ( final long sequence, final MessageTag messageTag )
    {
        if ( messageTag.getListener () == null )
        {
            return;
        }

        synchronized ( this.tagList )
        {
            this.tagList.put ( sequence, messageTag );
        }
    }

    /**
     * Send out a message including optional message tracking
     * 
     * @param message
     *            the message to send
     * @param listener
     *            the optional listener
     * @param timeout
     *            the timeout
     */
    public WriteFuture sendMessage ( final Message message, final MessageStateListener listener, final long timeout )
    {
        logger.debug ( "Sending message: {}", message.getCommandCode () );

        this.statistics.changeCurrentValue ( STATS_SENT_MSGS, 1 );

        final WriteFuture future;

        final MessageSender connection = this.connection;
        if ( connection != null )
        {
            final MessageTag tag = new MessageTag ();

            tag.setListener ( listener );
            tag.setTimestamp ( System.currentTimeMillis () );
            tag.setTimeout ( timeout < 0 ? 0 : timeout );

            future = connection.sendMessage ( message, new PrepareSendHandler () {

                @Override
                public void prepareSend ( final Message message )
                {
                    registerMessageTag ( message.getSequence (), tag );
                }
            } );
        }
        else
        {
            future = null;
        }

        // If the message was not sent, notify that
        if ( future == null )
        {
            if ( listener != null )
            {
                listener.messageTimedOut ();
            }
        }

        return future;
    }

    protected boolean handleDefaultMessage ( final Message message )
    {
        switch ( message.getCommandCode () )
        {
            case Message.CC_FAILED:
                String errorInfo = "";
                if ( message.getValues ().containsKey ( Message.FIELD_ERROR_INFO ) )
                {
                    errorInfo = message.getValues ().get ( Message.FIELD_ERROR_INFO ).toString ();
                }

                logger.warn ( "Failed message: {} / {} / Message: {}", new Object[] { message.getSequence (), message.getReplySequence (), errorInfo } );
                return true;

            case Message.CC_UNKNOWN_COMMAND_CODE:
                logger.warn ( "Reply to unknown message command code from peer: {} / {}", message.getSequence (), message.getReplySequence () );
                return true;

            case Message.CC_ACK:
                // no op
                return true;

            default:
                return false;
        }
    }

    protected boolean handleHandlerMessage ( final Message message )
    {
        final MessageListener listener = this.listeners.get ( message.getCommandCode () );
        if ( listener != null )
        {
            try
            {
                logger.debug ( "Let handler {} serve message {}", listener, message.getCommandCode () );
                listener.messageReceived ( message );
            }
            catch ( final Throwable e )
            {
                // reply to other peer if message processing failed
                logger.warn ( "Message processing failed", e );
                this.connection.sendMessage ( MessageCreator.createFailedMessage ( message, e ), null );
            }

            return true;
        }
        else
        {
            logger.warn ( "Received message which cannot be processed by handler! cc = {}", message.getCommandCode () );
            return false;
        }

    }

}
