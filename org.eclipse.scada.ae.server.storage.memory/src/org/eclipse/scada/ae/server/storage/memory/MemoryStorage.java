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
import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.server.storage.BaseStorage;
import org.eclipse.scada.ae.server.storage.Query;
import org.eclipse.scada.ae.server.storage.StoreListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemoryStorage extends BaseStorage
{

    private final static Logger logger = LoggerFactory.getLogger ( MemoryStorage.class );

    private final SortedSet<Event> events = new TreeSet<Event> ();

    public MemoryStorage ()
    {
    }

    @Override
    public synchronized Query query ( final String filter ) throws Exception
    {
        return new ListQuery ( new ArrayList<Event> ( this.events ), filter );
    }

    @Override
    public Event store ( final Event event, final StoreListener listener )
    {
        logger.debug ( "Storing event in memory buffer: {}", event );
        final Event storedEvent = createEvent ( event );
        synchronized ( this )
        {
            this.events.add ( storedEvent );
        }
        listener.notify ( storedEvent );
        return storedEvent;
    }

    public Set<Event> getEvents ()
    {
        return Collections.unmodifiableSet ( this.events );
    }

    @Override
    public synchronized Event update ( final UUID id, final String comment, final StoreListener listener ) throws Exception
    {
        Event event = null;
        for ( final Event found : this.events )
        {
            if ( found.getId ().equals ( event ) )
            {
                event = found;
                break;
            }
        }
        if ( event == null )
        {
            return null;
        }
        this.events.remove ( event );
        final Event updatedEvent = Event.create ().event ( event ).attribute ( Event.Fields.COMMENT, comment ).build ();
        this.events.add ( updatedEvent );
        return updatedEvent;
    }
}
