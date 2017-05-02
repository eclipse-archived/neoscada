/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.storage.memory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.filter.EventMatcher;
import org.eclipse.scada.ae.filter.internal.EventMatcherImpl;
import org.eclipse.scada.ae.server.storage.Query;
import org.eclipse.scada.utils.filter.FilterParseException;

public class ListQuery implements Query
{

    private final Iterator<Event> iterator;

    private final EventMatcher eventMatcher;

    private Event bufferedEvent = null;

    public ListQuery ( final List<Event> events, final String filter ) throws FilterParseException
    {
        this.eventMatcher = new EventMatcherImpl ( filter );
        this.iterator = events.iterator ();
    }

    @Override
    public List<Event> getNext ( final long count ) throws Exception
    {
        final List<Event> result = new ArrayList<Event> ();

        if ( this.bufferedEvent != null )
        {
            result.add ( this.bufferedEvent );
            this.bufferedEvent = null;
            if ( count == 1 )
            {
                return result;
            }
        }

        while ( next () != null )
        {
            result.add ( this.bufferedEvent );
            this.bufferedEvent = null;
            if ( result.size () == count )
            {
                break;
            }
        }
        return result;
    }

    @Override
    public boolean hasMore ()
    {
        if ( this.bufferedEvent == null && this.iterator.hasNext () )
        {
            next ();
        }
        return this.bufferedEvent != null;
    }

    private Event next ()
    {
        while ( this.iterator.hasNext () )
        {
            final Event event = this.iterator.next ();
            if ( this.eventMatcher.matches ( event ) )
            {
                this.bufferedEvent = event;
                return event;
            }
        }
        return null;
    }

    @Override
    public void dispose ()
    {
    }
}
