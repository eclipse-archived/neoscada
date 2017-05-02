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
package org.eclipse.scada.configuration.world.lib.oscar.event;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.lib.Properties;
import org.eclipse.scada.configuration.world.PropertyEntry;
import org.eclipse.scada.configuration.world.osgi.EventHandler;
import org.eclipse.scada.configuration.world.osgi.MailEventHandler;

public class MailHandlerProcessor extends BasicEventHandlerProcessor implements EventHandlerProcessor
{

    public MailHandlerProcessor ()
    {
        super ( "mail" );
    }

    @Override
    protected Map<String, String> makeData ( final EventHandler eventHandler, final String id )
    {
        final MailEventHandler handler = (MailEventHandler)eventHandler;

        final Map<String, String> result = new HashMap<> ();

        result.put ( "queue.id", id );
        // the next line might override the queue id, if present
        Properties.putNonEmpty ( result, "queue.id", handler.getQueueId () );

        Properties.putNonEmpty ( result, "username", handler.getUsername () );
        Properties.putNonEmpty ( result, "password", handler.getPassword () );
        Properties.putNonEmpty ( result, "from", handler.getFrom () );

        int i = 0;
        for ( final String to : handler.getTo () )
        {
            result.put ( "to." + i, to );
            i++;
        }

        for ( final PropertyEntry pe : handler.getSessionProperties () )
        {
            result.put ( "session." + pe.getKey (), pe.getValue () );
        }

        return result;
    }

}
