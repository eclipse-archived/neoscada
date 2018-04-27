/*******************************************************************************
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.server.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.neoscada.protocol.iec60870.apci.MessageSource;
import org.eclipse.neoscada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.InterrogationCommand;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Cause;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Causes;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationEntry;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.StandardCause;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Value;
import org.eclipse.neoscada.protocol.iec60870.server.data.event.EventQueue;
import org.eclipse.neoscada.protocol.iec60870.server.data.event.SimpleBooleanBuilder;
import org.eclipse.neoscada.protocol.iec60870.server.data.event.SimpleFloatBuilder;
import org.eclipse.neoscada.protocol.iec60870.server.data.event.SimpleScaledBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

public class DataModuleMessageSource implements MessageSource
{
    private final static Logger logger = LoggerFactory.getLogger ( DataModuleMessageSource.class );

    private static enum InterrogationState
    {
        WAITING,
        RUNNING,
        FLUSHING
    }

    private static class InterrogationRequest
    {
        private final ASDUAddress asduAddress;

        private final byte sourceAddress;

        private final short causeValue;

        // the QOI is not part of the equals method, since it actually is a duplicate value to the cause value
        private final short qualifierOfInterrogation;

        public InterrogationRequest ( final ASDUAddress asduAddress, final Cause cause, final short qualifierOfInterrogation, final byte sourceAddress )
        {
            this.asduAddress = asduAddress;
            this.causeValue = cause.getValue ();
            this.qualifierOfInterrogation = qualifierOfInterrogation;
            this.sourceAddress = sourceAddress;
        }

        @Override
        public String toString ()
        {
            return String.format ( "[%s - %s - %02x]", this.asduAddress, this.qualifierOfInterrogation, this.sourceAddress );
        }

        @Override
        public int hashCode ()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ( this.asduAddress == null ? 0 : this.asduAddress.hashCode () );
            result = prime * result + this.causeValue;
            result = prime * result + this.sourceAddress;
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
            final InterrogationRequest other = (InterrogationRequest)obj;
            if ( this.asduAddress == null )
            {
                if ( other.asduAddress != null )
                {
                    return false;
                }
            }
            else if ( !this.asduAddress.equals ( other.asduAddress ) )
            {
                return false;
            }
            if ( this.causeValue != other.causeValue )
            {
                return false;
            }
            if ( this.sourceAddress != other.sourceAddress )
            {
                return false;
            }
            return true;
        }

    }

    private static class InterrogationInstance
    {
        private InterrogationState state;

        private ASDUAddress asduAddress;

        private short qualifierOfInterrogation;

        private CauseOfTransmission expectedCauseOfTransmission;

        @Override
        public String toString ()
        {
            return String.format ( "[ASDU: %s, QOI: %s, Cause: %s -> %s]", this.asduAddress, this.qualifierOfInterrogation, this.expectedCauseOfTransmission, this.state );
        }
    }

    private final Map<InterrogationRequest, InterrogationInstance> currentInterrogation = new HashMap<> ();

    private final EventQueue<Boolean> booleanEventBuffer;

    private final EventQueue<Float> floatEventBuffer;

    private final EventQueue<Short> shortEventBuffer;

    private final List<EventQueue<?>> buffers = new ArrayList<> ();

    /**
     * A queue of priority messages
     */
    private final Queue<Object> messages = new LinkedList<> ();

    private int bufferIndex;

    private final ChannelWriter writer;

    private final DataModel model;

    private BackgroundIterator backgroundIterator;

    private long lastBackgroundStart;

    private final long backgroundScanPeriod;

    private final ScheduledExecutorService executor;

    public DataModuleMessageSource ( final DataModuleOptions options, final ScheduledExecutorService executor, final ChannelWriter writer, final DataModel model, final long backgroundScanPeriod )
    {
        this.executor = executor;
        this.writer = writer;
        this.model = model;
        this.backgroundScanPeriod = backgroundScanPeriod;

        // create the buffers - spontaneous
        this.booleanEventBuffer = new EventQueue<> ( options.getSpontaneousDuplicates (), new SimpleBooleanBuilder ( options.isBooleansWithTimestamp () ) );
        this.floatEventBuffer = new EventQueue<> ( options.getSpontaneousDuplicates (), new SimpleFloatBuilder ( options.isFloatsWithTimestamp () ) );
        this.shortEventBuffer = new EventQueue<> ( options.getSpontaneousDuplicates (), new SimpleScaledBuilder ( options.isFloatsWithTimestamp () ) );

        // create initial instance
        createBackgroundScan ();

        this.buffers.add ( this.booleanEventBuffer );
        this.buffers.add ( this.floatEventBuffer );
        this.buffers.add ( this.shortEventBuffer );
    }

    @Override
    public synchronized Object poll ()
    {
        // first check for messages from the priority queue

        Object msg = this.messages.poll ();
        if ( msg != null )
        {
            return msg;
        }

        // next check for some interrogation completion

        for ( final Map.Entry<InterrogationRequest, InterrogationInstance> entry : this.currentInterrogation.entrySet () )
        {
            final InterrogationInstance currentInterrogation = entry.getValue ();

            if ( currentInterrogation.state == InterrogationState.FLUSHING && !hasInterrogationValues ( currentInterrogation ) )
            {
                // clear state
                this.currentInterrogation.remove ( entry.getKey () ); // this will break the entry set iterator

                final InterrogationCommand reply = createCurrentInterrogationReply ( entry.getValue (), StandardCause.ACTIVATION_TERMINATION );

                return reply; // we must return since we modified the currentInterrogation map
            }
        }

        // now fetch from the buffers

        msg = pollFromBuffers ();
        if ( msg != null )
        {
            return msg;
        }

        // now fetch from background transmission

        msg = pollFromBackground ();
        if ( msg != null )
        {
            return msg;
        }

        // nothing to send for now

        return null;
    }

    /**
     * Poll the next event from the next buffer
     *
     * @return the next message to send or <code>null</code> if no message is
     *         pending
     */
    private Object pollFromBuffers ()
    {
        /*
         * This loop cycles through all buffer and looks for a message to send.
         * If the buffer has a message it will return the message. Otherwise
         * it will check the next buffer.
         *
         * However the buffer index will be incremented each time. So if the buffer
         * returned a message the index is still incremented to give other buffers
         * a chance. We are not draining one buffer at a time since this might
         * lead to the possibility that one buffer gets filled while it gets drained
         * and so other buffers never get transmitted.
         */
        final int startIndex = this.bufferIndex;

        do
        {
            final EventQueue<?> buffer = this.buffers.get ( this.bufferIndex );
            this.bufferIndex++;
            if ( this.bufferIndex >= this.buffers.size () )
            {
                this.bufferIndex = 0;
                // don't return here, wait until we come back to our original position
            }

            final Object msg = buffer.poll ();
            if ( msg != null )
            {
                return msg;
            }
        } while ( startIndex != this.bufferIndex );

        // all buffers are empty
        return null;
    }

    private void createBackgroundScan ()
    {
        logger.info ( "Start new background scan - grace period: {}", this.backgroundScanPeriod );
        if ( this.backgroundScanPeriod > 0 && this.model != null && this.executor != null )
        {
            this.backgroundIterator = this.model.createBackgroundIterator ();
            this.lastBackgroundStart = System.currentTimeMillis ();

            // trigger message poll after grace period
            this.executor.schedule ( new Runnable () {

                @Override
                public void run ()
                {
                    logger.info ( "Background scan grace period expired" );
                    // notify that there is new data, which is our background scan
                    DataModuleMessageSource.this.writer.notifyMoreData ();
                }
            }, this.backgroundScanPeriod, TimeUnit.MILLISECONDS );
        }
        else
        {
            // unsupported in this case
            this.backgroundIterator = null;
        }
    }

    private Object pollFromBackground ()
    {
        if ( this.backgroundIterator == null )
        {
            // not supported
            return null;
        }

        final long diff = System.currentTimeMillis () - this.lastBackgroundStart;
        logger.trace ( "pollFromBackground - timeToLast: {}, period: {}", diff, this.backgroundScanPeriod );
        if ( diff < this.backgroundScanPeriod )
        {
            // not for now
            return null;
        }

        final Object msg = this.backgroundIterator.nextMessage ();
        if ( msg != null )
        {
            return msg;
        }

        // msg is null

        // start next round
        createBackgroundScan ();

        // but wait for until the delay period is over
        return null;
    }

    private static InterrogationCommand createCurrentInterrogationReply ( final InterrogationInstance currentInterrogation, final Cause cause )
    {
        return new InterrogationCommand ( new ASDUHeader ( new CauseOfTransmission ( cause, currentInterrogation.expectedCauseOfTransmission.getSourceAddress () ), currentInterrogation.asduAddress ), currentInterrogation.qualifierOfInterrogation );
    }

    private boolean hasInterrogationValues ( final InterrogationInstance instance )
    {
        if ( instance == null )
        {
            return false;
        }

        for ( final EventQueue<?> buffer : this.buffers )
        {
            if ( buffer.getCauseCounter ( instance.expectedCauseOfTransmission, instance.asduAddress ) > 0 )
            {
                return true;
            }
        }

        return false;
    }

    // boolean

    public synchronized void sendBooleanValue ( final ASDUHeader header, final InformationObjectAddress address, final Value<Boolean> value )
    {
        recordCause ( header.getAsduAddress (), header.getCauseOfTransmission () );
        this.booleanEventBuffer.append ( header.getCauseOfTransmission (), header.getAsduAddress (), address, value );
        this.writer.notifyMoreData ();
    }

    public synchronized void sendBooleanValues ( final ASDUHeader header, final InformationObjectAddress startAddress, final List<Value<Boolean>> values )
    {
        recordCause ( header.getAsduAddress (), header.getCauseOfTransmission () );
        this.booleanEventBuffer.append ( header.getCauseOfTransmission (), header.getAsduAddress (), startAddress, values );
        this.writer.notifyMoreData ();
    }

    public synchronized void sendBooleanValues ( final ASDUHeader header, final List<InformationEntry<Boolean>> values )
    {
        recordCause ( header.getAsduAddress (), header.getCauseOfTransmission () );
        this.booleanEventBuffer.append ( header.getCauseOfTransmission (), header.getAsduAddress (), values );
        this.writer.notifyMoreData ();
    }

    // float

    public synchronized void sendFloatValue ( final ASDUHeader header, final InformationObjectAddress address, final Value<Float> value )
    {
        recordCause ( header.getAsduAddress (), header.getCauseOfTransmission () );
        this.floatEventBuffer.append ( header.getCauseOfTransmission (), header.getAsduAddress (), address, value );
        this.writer.notifyMoreData ();
    }

    public synchronized void sendFloatValues ( final ASDUHeader header, final InformationObjectAddress startAddress, final List<Value<Float>> values )
    {
        recordCause ( header.getAsduAddress (), header.getCauseOfTransmission () );
        this.floatEventBuffer.append ( header.getCauseOfTransmission (), header.getAsduAddress (), startAddress, values );
        this.writer.notifyMoreData ();
    }

    public synchronized void sendFloatValues ( final ASDUHeader header, final List<InformationEntry<Float>> values )
    {
        recordCause ( header.getAsduAddress (), header.getCauseOfTransmission () );
        this.floatEventBuffer.append ( header.getCauseOfTransmission (), header.getAsduAddress (), values );
        this.writer.notifyMoreData ();
    }

    // short

    public synchronized void sendShortValue ( final ASDUHeader header, final InformationObjectAddress address, final Value<Short> value )
    {
        recordCause ( header.getAsduAddress (), header.getCauseOfTransmission () );
        this.shortEventBuffer.append ( header.getCauseOfTransmission (), header.getAsduAddress (), address, value );
        this.writer.notifyMoreData ();
    }

    public synchronized void sendShortValues ( final ASDUHeader header, final InformationObjectAddress startAddress, final List<Value<Short>> values )
    {
        recordCause ( header.getAsduAddress (), header.getCauseOfTransmission () );
        this.shortEventBuffer.append ( header.getCauseOfTransmission (), header.getAsduAddress (), startAddress, values );
        this.writer.notifyMoreData ();
    }

    public synchronized void sendShortValues ( final ASDUHeader header, final List<InformationEntry<Short>> values )
    {
        recordCause ( header.getAsduAddress (), header.getCauseOfTransmission () );
        this.shortEventBuffer.append ( header.getCauseOfTransmission (), header.getAsduAddress (), values );
        this.writer.notifyMoreData ();
    }

    public static class InterrogationException extends Exception
    {
        private static final long serialVersionUID = 1L;

        private final Cause errorCause;

        public InterrogationException ( final String message, final Cause errorCause )
        {
            super ( message );
            this.errorCause = errorCause;
        }

        public Cause getErrorCause ()
        {
            return this.errorCause;
        }
    }

    /**
     * Start the process of interrogation
     *
     * @param asduAddress
     * @param causeOfTransmission
     * @param qualifierOfInterrogation
     * @return the cause of transmission expected for updates during the
     *         interrogation (station, group, ...). If it is <code>null</code>
     *         the interrogation request was simply ignored.
     */
    public void startInterrogation ( final InterrogationCommand msg )
    {
        final short qualifierOfInterrogation = msg.getQualifierOfInterrogation ();

        final Cause cause = convert ( qualifierOfInterrogation );
        if ( cause == null )
        {
            logger.info ( "Ignoring unknown qualifier of interrogation (QOI) : {}", qualifierOfInterrogation );
            this.writer.write ( msg.mirror ( StandardCause.UNKNOWN_REASON ) );
            this.writer.flush ();
            return;
        }

        synchronized ( this )
        {
            logger.debug ( "Starting interrogation" );
            if ( msg.getHeader ().getAsduAddress ().isBroadcast () )
            {
                logger.debug ( "Broadcast interrogation" );
                this.model.forAllAsdu ( new Function<ASDUAddress, Void> () {

                    @Override
                    public Void apply ( final ASDUAddress asduAddress )
                    {
                        logger.debug ( "Broadcast member: {}", asduAddress );
                        final InterrogationRequest request = new InterrogationRequest ( asduAddress, cause, msg.getQualifierOfInterrogation (), msg.getHeader ().getCauseOfTransmission ().getSourceAddress () );
                        tryStartInterrogation ( msg, request );
                        return null;
                    }

                }, new Runnable () {

                    @Override
                    public void run ()
                    {
                        logger.info ( "No ASDU common addresses registered" );
                        DataModuleMessageSource.this.writer.write ( msg.mirror ( StandardCause.UNKNOWN_ASDU_ADDRESS ) );
                        DataModuleMessageSource.this.writer.flush ();
                    }
                } );
            }
            else
            {
                logger.debug ( "Interrogation for: {}", msg.getHeader ().getAsduAddress () );

                final InterrogationRequest request = new InterrogationRequest ( msg.getHeader ().getAsduAddress (), cause, msg.getQualifierOfInterrogation (), msg.getHeader ().getCauseOfTransmission ().getSourceAddress () );
                tryStartInterrogation ( msg, request );
            }
        }
    }

    private void tryStartInterrogation ( final InterrogationCommand msg, final InterrogationRequest request )
    {
        logger.debug ( "tryStartInterrogation - msg: {}, request: {}", msg, request );

        if ( !this.currentInterrogation.containsKey ( request ) )
        {
            createNewInterrogation ( msg, request );
        }
        else
        {
            logger.warn ( "GA already running: {}", request );
            // ignore
        }
    }

    /**
     * Create a new interrogation instance and kick off the process <br/>
     * This method may only be called when no other interrogation is currently
     * running.
     *
     * @param msg
     * @param asduAddress
     * @param causeOfTransmission
     * @param qualifierOfInterrogation
     * @param cause
     * @return
     * @throws InterrogationException
     */
    private void createNewInterrogation ( final InterrogationCommand msg, final InterrogationRequest request )
    {
        logger.debug ( "Create new interrogation - msg: {}, request: {}", msg, request );

        final InterrogationInstance currentInterrogation = new InterrogationInstance ();
        currentInterrogation.state = InterrogationState.WAITING;
        currentInterrogation.asduAddress = request.asduAddress;
        currentInterrogation.qualifierOfInterrogation = request.qualifierOfInterrogation;
        currentInterrogation.expectedCauseOfTransmission = new CauseOfTransmission ( convert ( request.qualifierOfInterrogation ), request.sourceAddress );

        final ListenableFuture<Void> future = this.model.readAll ( currentInterrogation.expectedCauseOfTransmission, request.asduAddress, new Runnable () {
            @Override
            public void run ()
            {
                logger.info ( "Prepare interrogation" );
                try
                {
                    // we may directly push that to the outbound queue
                    DataModuleMessageSource.this.executor.submit ( new Runnable () {
                        @Override
                        public void run ()
                        {
                            // we need to send this out in the executor of the IO loop ...
                            DataModuleMessageSource.this.writer.write ( createCurrentInterrogationReply ( currentInterrogation, StandardCause.ACTIVATION_CONFIRM ) );
                            DataModuleMessageSource.this.writer.flush ();
                        };
                    } ).get (); // ... and wait for it, so that we are sure everything else is sent afterwards
                }
                catch ( final Exception e )
                {
                    logger.warn ( "Failed to send out interrogation confirm", e );
                }
                logger.debug ( "Flushed" );
            }
        }, new DataListenerImpl ( this ) );

        if ( future == null )
        {
            logger.info ( "Failed to start interrogation" );
            this.writer.write ( msg.mirror ( StandardCause.UNKNOWN_ASDU_ADDRESS ) );
            this.writer.flush ();
            return;
        }

        this.currentInterrogation.put ( request, currentInterrogation );

        Futures.addCallback ( future, new FinallyFutureCallback<Void> () {

            @Override
            public void onFinally ()
            {
                logger.info ( "Finished interrogation" );
                completeInterrogation ( request );
            }
        }, this.executor );
    }

    private static Cause convert ( final short qualifierOfInterrogation )
    {
        if ( qualifierOfInterrogation == 20 )
        {
            return StandardCause.STATION_REQUEST;
        }
        else if ( qualifierOfInterrogation > 20 && qualifierOfInterrogation <= 36 )
        {
            return Causes.valueOf ( qualifierOfInterrogation );
        }
        else
        {
            return null;
        }
    }

    public synchronized void completeInterrogation ( final InterrogationRequest request )
    {
        logger.info ( "Complete interrogation: {}", request );

        final InterrogationInstance currentInterrogation = this.currentInterrogation.get ( request );

        if ( currentInterrogation == null )
        {
            return;
        }

        if ( currentInterrogation.state == InterrogationState.WAITING )
        {
            // push reply - early finish
            logger.info ( "No data. Early finish." );
            this.writer.write ( createCurrentInterrogationReply ( currentInterrogation, StandardCause.ACTIVATION_TERMINATION ) );
            this.writer.flush ();
            this.currentInterrogation.remove ( request );
        }
        else if ( currentInterrogation.state == InterrogationState.RUNNING )
        {
            // delay reply
            logger.info ( "Has data. Lazy finish." );
            currentInterrogation.state = InterrogationState.FLUSHING;
            this.writer.notifyMoreData ();
        }
    }

    private void recordCause ( final ASDUAddress asduAddress, final CauseOfTransmission causeOfTransmission )
    {
        // note: this method is also called for values that come in "normally"

        logger.debug ( "Record cause: {}, {}", asduAddress, causeOfTransmission );

        if ( !Causes.isInterrogation ( causeOfTransmission.getCause () ) )
        {
            return;
        }

        final InterrogationRequest request = new InterrogationRequest ( asduAddress, causeOfTransmission.getCause (), /*[1]*/(short)0, causeOfTransmission.getSourceAddress () );

        /*
         * [1] We can use zero here since the QOI is not part of the equals method in InterrogationRequest
         */

        final InterrogationInstance currentInterrogation = this.currentInterrogation.get ( request );
        logger.debug ( "Instance: {}", currentInterrogation );

        if ( currentInterrogation != null && currentInterrogation.state == InterrogationState.WAITING )
        {
            logger.debug ( "Check cause" );
            if ( causeOfTransmission.equals ( currentInterrogation.expectedCauseOfTransmission ) )
            {
                logger.debug ( "Set request to RUNNING: {}", currentInterrogation );
                currentInterrogation.state = InterrogationState.RUNNING;
            }
        }
    }
}
