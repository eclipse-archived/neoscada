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
        private final ASDUAddress asduAddress;

        private final InformationObjectAddress address;

        private final Value<?> value;

        public Event ( final ASDUAddress asduAddress, final InformationObjectAddress address, final Value<?> value )
        {
            this.asduAddress = asduAddress;
            this.address = address;
            this.value = value;
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
            return String.format ( "[Event - ASDU: %s, IOA: %s, value: %s", this.asduAddress, this.address, this.value );
        }
    }

    private final LinkedList<Event> events = new LinkedList<> ();

    public LinkedList<Event> getEvents ()
    {
        return this.events;
    }

    private <T> void sequentialChange ( final ASDUAddress asduAddress, final InformationObjectAddress startAddress, final List<Value<T>> values )
    {
        int i = 0;
        for ( final Value<?> value : values )
        {
            this.events.add ( new Event ( asduAddress, startAddress.increment ( i ), value ) );
            i++;
        }
    }

    private <T> void change ( final ASDUAddress asduAddress, final List<InformationEntry<T>> values )
    {
        for ( final InformationEntry<?> entry : values )
        {
            this.events.add ( new Event ( asduAddress, entry.getAddress (), entry.getValue () ) );
        }
    }

    @Override
    public void dataChangeBoolean ( final ASDUAddress asduAddress, final InformationObjectAddress startAddress, final List<Value<Boolean>> values )
    {
        sequentialChange ( asduAddress, startAddress, values );
    }

    @Override
    public void dataChangeBoolean ( final ASDUAddress asduAddress, final List<InformationEntry<Boolean>> values )
    {
        change ( asduAddress, values );
    }

    @Override
    public void dataChangeFloat ( final ASDUAddress asduAddress, final List<InformationEntry<Float>> values )
    {
        change ( asduAddress, values );
    }

    @Override
    public void dataChangeFloat ( final ASDUAddress asduAddress, final InformationObjectAddress startAddress, final List<Value<Float>> values )
    {
        sequentialChange ( asduAddress, startAddress, values );
    }

    public void assertEvents ( final Event... events )
    {
        Assert.assertArrayEquals ( events, this.events.toArray ( new Event[this.events.size ()] ) );
    }

}
