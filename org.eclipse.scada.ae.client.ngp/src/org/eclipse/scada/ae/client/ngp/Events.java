/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.client.ngp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Event.EventBuilder;
import org.eclipse.scada.ae.data.EventInformation;
import org.eclipse.scada.core.Variant;

public final class Events
{
    private Events ()
    {
    }

    public static List<Event> convertToEvent ( final List<EventInformation> events )
    {
        final List<Event> result = new ArrayList<Event> ( events.size () );

        for ( final EventInformation eventInformation : events )
        {
            result.add ( convertToEvent ( eventInformation ) );
        }

        return result;
    }

    public static Event convertToEvent ( final EventInformation eventInformation )
    {
        final EventBuilder builder = Event.create ();

        builder.id ( UUID.fromString ( eventInformation.getId () ) );
        builder.sourceTimestamp ( new Date ( eventInformation.getSourceTimestamp () ) );
        builder.entryTimestamp ( new Date ( eventInformation.getEntryTimestamp () ) );

        for ( final Map.Entry<String, Variant> entry : eventInformation.getAttributes ().entrySet () )
        {
            builder.attribute ( entry.getKey (), entry.getValue () );
        }

        return builder.build ();
    }
}
