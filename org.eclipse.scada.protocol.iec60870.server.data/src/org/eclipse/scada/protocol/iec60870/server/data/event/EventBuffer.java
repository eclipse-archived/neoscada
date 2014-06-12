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
package org.eclipse.scada.protocol.iec60870.server.data.event;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.Value;

public class EventBuffer<T>
{
    private static class Header
    {
        private final CauseOfTransmission causeOfTransmission;

        private final ASDUAddress asduAddress;

        public Header ( final CauseOfTransmission causeOfTransmission, final ASDUAddress asduAddress )
        {
            this.causeOfTransmission = causeOfTransmission;
            this.asduAddress = asduAddress;
        }

        public ASDUAddress getAsduAddress ()
        {
            return this.asduAddress;
        }

        public CauseOfTransmission getCauseOfTransmission ()
        {
            return this.causeOfTransmission;
        }

        @Override
        public int hashCode ()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ( this.asduAddress == null ? 0 : this.asduAddress.hashCode () );
            result = prime * result + ( this.causeOfTransmission == null ? 0 : this.causeOfTransmission.hashCode () );
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
            final Header other = (Header)obj;
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
            if ( this.causeOfTransmission == null )
            {
                if ( other.causeOfTransmission != null )
                {
                    return false;
                }
            }
            else if ( !this.causeOfTransmission.equals ( other.causeOfTransmission ) )
            {
                return false;
            }
            return true;
        }

    }

    private static class Entry<T>
    {
        private final InformationObjectAddress address;

        private final Header header;

        private final Value<T> value;

        public Entry ( final Header header, final InformationObjectAddress address, final Value<T> value )
        {
            this.header = header;
            this.address = address;
            this.value = value;
        }

        public InformationObjectAddress getAddress ()
        {
            return this.address;
        }

        public Header getHeader ()
        {
            return this.header;
        }

        public Value<T> getValue ()
        {
            return this.value;
        }
    }

    private final LinkedList<Entry<T>> entries = new LinkedList<> ();

    private final Map<Header, Integer> causeCounter = new HashMap<> ();

    private final int numberOfDuplicates;

    public EventBuffer ( final int numberOfDuplicates )
    {
        this.numberOfDuplicates = numberOfDuplicates;
    }

    public void append ( final CauseOfTransmission causeOfTransmission, final ASDUAddress asduAddress, final InformationObjectAddress address, final Value<T> value )
    {
        removeDuplicates ( address, new Header ( causeOfTransmission, asduAddress ) );

        this.entries.add ( new Entry<T> ( new Header ( causeOfTransmission, asduAddress ), address, value ) );

        incrementCauseCounter ( new Header ( causeOfTransmission, asduAddress ), 1 );
    }

    public int getCauseCounter ( final CauseOfTransmission causeOfTransmission, final ASDUAddress asduAddress )
    {
        final Integer result = this.causeCounter.get ( new Header ( causeOfTransmission, asduAddress ) );
        if ( result == null )
        {
            return 0;
        }
        else
        {
            return result;
        }
    }

    private void removeDuplicates ( final InformationObjectAddress address, final Header header )
    {
        int count = 0;
        int removed = 0;

        final Iterator<Entry<T>> i = this.entries.iterator ();
        while ( i.hasNext () )
        {
            final Entry<T> entry = i.next ();
            if ( !entry.getAddress ().equals ( address ) )
            {
                continue;
            }
            if ( !entry.getHeader ().equals ( header ) )
            {
                continue;
            }

            count++;
            if ( count >= this.numberOfDuplicates )
            {
                removed++;
                i.remove ();
            }
        }

        incrementCauseCounter ( header, -removed );
    }

    private void incrementCauseCounter ( final Header header, final int amount )
    {
        final Integer counter = this.causeCounter.get ( header );
        if ( counter == null )
        {
            this.causeCounter.put ( header, Math.max ( 0, amount ) );
        }
        else
        {
            this.causeCounter.put ( header, counter + amount );
        }
    }

    public <M> M poll ( final MessageBuilder<T, M> builder )
    {
        final Iterator<Entry<T>> i = this.entries.iterator ();

        Header header = null;

        final Set<InformationObjectAddress> visited = new HashSet<> ();
        final Set<InformationObjectAddress> added = new HashSet<> ();

        int removed = 0;

        boolean accepts = true;

        while ( i.hasNext () && accepts )
        {
            final Entry<T> entry = i.next ();

            final boolean seenWithOtherCause = visited.contains ( entry.getAddress () );
            final boolean contained = added.contains ( entry.getAddress () );

            if ( header == null )
            {
                // this is our first one
                header = entry.getHeader ();
                builder.start ( header.getCauseOfTransmission (), header.getAsduAddress () );
                i.remove ();
                accepts = builder.addEntry ( entry.getAddress (), entry.getValue () );
                added.add ( entry.getAddress () );
                removed++;
            }
            else if ( !header.equals ( entry.getHeader () ) )
            {
                if ( contained )
                {
                    break;
                }
                else
                {
                    visited.add ( entry.getAddress () );
                    continue;
                }
            }
            else if ( !seenWithOtherCause )
            {
                i.remove ();
                accepts = builder.addEntry ( entry.getAddress (), entry.getValue () );
                added.add ( entry.getAddress () );
                removed++;
            }
        }

        if ( header == null )
        {
            // we never started
            return null;
        }

        incrementCauseCounter ( header, -removed );

        return builder.build ();
    }
}
