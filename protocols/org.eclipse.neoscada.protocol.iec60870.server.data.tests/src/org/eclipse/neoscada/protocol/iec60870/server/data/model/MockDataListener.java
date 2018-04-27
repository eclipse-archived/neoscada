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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.neoscada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationEntry;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Value;
import org.eclipse.neoscada.protocol.iec60870.server.data.DataListener;
import org.junit.Assert;

public class MockDataListener implements DataListener
{

    public static final Value<Boolean> TRUE = Value.TRUE ();

    public static final Value<Boolean> FALSE = Value.FALSE ();

    public static class Event
    {
        private final CauseOfTransmission cause;

        private final ASDUAddress asduAddress;

        private final InformationObjectAddress address;

        private final Value<?> value;

        public Event ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final InformationObjectAddress address, final Value<?> value )
        {
            this.cause = cause;
            this.asduAddress = asduAddress;
            this.address = address;
            this.value = value;
        }

        public CauseOfTransmission getCause ()
        {
            return this.cause;
        }
        
        public ASDUAddress getAsduAddress ()
        {
            return this.asduAddress;
        }

        public InformationObjectAddress getAddress ()
        {
            return this.address;
        }

        public Value<?> getValue ()
        {
            return this.value;
        }

        @Override
        public int hashCode ()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ( this.cause == null ? 0 : this.cause.hashCode () );
            result = prime * result + ( this.address == null ? 0 : this.address.hashCode () );
            result = prime * result + ( this.asduAddress == null ? 0 : this.asduAddress.hashCode () );
            result = prime * result + ( this.value == null ? 0 : this.value.hashCode () );
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
            final Event other = (Event)obj;
            if ( this.cause == null )
            {
                if ( other.cause != null )
                {
                    return false;
                }
            }
            else if ( !this.cause.equals ( other.cause ) )
            {
                return false;
            }
            if ( this.address == null )
            {
                if ( other.address != null )
                {
                    return false;
                }
            }
            else if ( !this.address.equals ( other.address ) )
            {
                return false;
            }
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
            if ( this.value == null )
            {
                if ( other.value != null )
                {
                    return false;
                }
            }
            else if ( !this.value.equals ( other.value ) )
            {
                return false;
            }
            return true;
        }

        @Override
        public String toString ()
        {
            return String.format ( "[Event - ASDU: %s, IOA: %s, cause: %s, value: %s", this.asduAddress, this.address, this.cause, this.value );
        }
    }

    private final LinkedList<Event> events = new LinkedList<> ();

    public LinkedList<Event> getEvents ()
    {
        return this.events;
    }

    private <T> void sequentialChange ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final InformationObjectAddress startAddress, final List<Value<T>> values )
    {
        int i = 0;
        for ( final Value<?> value : values )
        {
            this.events.add ( new Event ( cause, asduAddress, startAddress.increment ( i ), value ) );
            i++;
        }
    }

    private <T> void change ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final List<InformationEntry<T>> values )
    {
        for ( final InformationEntry<?> entry : values )
        {
            this.events.add ( new Event ( cause, asduAddress, entry.getAddress (), entry.getValue () ) );
        }
    }

    @Override
    public void dataChangeBoolean ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final InformationObjectAddress startAddress, final List<Value<Boolean>> values )
    {
        sequentialChange ( cause, asduAddress, startAddress, values );
    }

    @Override
    public void dataChangeBoolean ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final List<InformationEntry<Boolean>> values )
    {
        change ( cause, asduAddress, values );
    }

    @Override
    public void dataChangeFloat ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final List<InformationEntry<Float>> values )
    {
        change ( cause, asduAddress, values );
    }

    @Override
    public void dataChangeShort ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final InformationObjectAddress startAddress, final List<Value<Short>> values )
    {
        sequentialChange ( cause, asduAddress, startAddress, values );
    }

    @Override
    public void dataChangeShort ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final List<InformationEntry<Short>> values )
    {
        change ( cause, asduAddress, values );
    }

    @Override
    public void dataChangeFloat (final CauseOfTransmission cause, final ASDUAddress asduAddress, final InformationObjectAddress startAddress, final List<Value<Float>> values )
    {
        sequentialChange ( cause, asduAddress, startAddress, values );
    }

    public void assertEvents ( final Event... events )
    {
        Assert.assertArrayEquals ( events, this.events.toArray ( new Event[this.events.size ()] ) );
    }

}
