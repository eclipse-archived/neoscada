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
package org.eclipse.scada.protocol.iec60870.apci;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AckBuffer
{
    private final static Logger logger = LoggerFactory.getLogger ( AckBuffer.class );

    private static class Entry
    {
        @SuppressWarnings ( "unused" )
        Object message;

        @SuppressWarnings ( "unused" )
        long timestamp;

        int ack;

        public void clear ()
        {
            this.message = null;
            this.ack = -1;
        }
    }

    private int sendIndex;

    private int ackIndex;

    private final int maxSequence;

    private int sequence = 0;

    private int ackSequence = 0;

    private final Entry[] buffer;

    public AckBuffer ( final int size, final int maxSequence )
    {
        this.buffer = new Entry[size];

        for ( int i = 0; i < size; i++ )
        {
            this.buffer[i] = new Entry ();
            this.buffer[i].ack = -1;
        }

        this.maxSequence = maxSequence;
    }

    public int addMessage ( final Object message )
    {
        if ( isFull () )
        {
            throw new IndexOutOfBoundsException ( "Buffer is full" );
        }

        final int seq = this.sequence;
        this.sequence = ( this.sequence + 1 ) % this.maxSequence;
        final int ack = this.sequence;

        if ( this.sequence == 0 )
        {
            logger.info ( "Sequence resetted" );
        }

        // store the message and time in the current position
        final Entry entry = this.buffer[this.sendIndex];
        entry.message = message;
        entry.timestamp = System.currentTimeMillis ();
        entry.ack = ack;

        // advance buffer position
        this.sendIndex = ( this.sendIndex + 1 ) % this.buffer.length;

        logger.trace ( "Add - Buffer - sendIndex: {}, ackIndex: {}", this.sendIndex, this.ackIndex );

        return seq;
    }

    public boolean isFull ()
    {
        /* sendIndex is pointing to the next entry.
         * If is still filled we are full */
        return this.buffer[this.sendIndex].ack >= 0;
    }

    public void gotAck ( final int sequenceNumber )
    {
        logger.trace ( "Ack - {}", sequenceNumber );

        if ( sequenceNumber % this.maxSequence == this.ackSequence )
        {
            // duplicate
            return;
        }

        // we try as long as the indexes don't match and we have remaining messages in the buffer
        while ( this.buffer[this.ackIndex].ack >= 0 && this.buffer[this.ackIndex].ack != sequenceNumber )
        {
            this.buffer[this.ackIndex].clear ();

            this.ackIndex = ( this.ackIndex + 1 ) % this.buffer.length;

            logger.trace ( "Ack - Buffer - sendIndex: {}, ackIndex: {}", this.sendIndex, this.ackIndex );
        }

        if ( this.buffer[this.ackIndex].ack != sequenceNumber )
        {
            // error -> we consumed all our ack buffer, but still don't have a matching ack number
            // -> this is a protocol error
            throw new IllegalStateException ( String.format ( "Received invalid ack message ack number: %s, lastMessage: %s", sequenceNumber, this.buffer[this.ackIndex].ack ) );
        }

        this.buffer[this.ackIndex].clear ();
        this.ackIndex = ( this.ackIndex + 1 ) % this.buffer.length;
        this.ackSequence = sequenceNumber % this.maxSequence;
    }

    public int getOutstandingAcks ()
    {
        if ( this.ackSequence <= this.sequence )
        {
            return this.sequence - this.ackSequence;
        }
        else
        {
            // we do have a roll over
            return this.maxSequence - this.ackSequence + this.sequence;
        }
    }
}
