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

import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;
import org.eclipse.scada.configuration.world.osgi.EventHandler;

public abstract class BasicEventHandlerProcessor implements EventHandlerProcessor
{
    private final String typeId;

    public BasicEventHandlerProcessor ( final String typeId )
    {
        this.typeId = typeId;
    }

    protected abstract Map<String, String> makeData ( final EventHandler eventHandler, String id );

    @Override
    public void process ( final EventHandler eventHandler, final OscarContext ctx, final int priority )
    {
        final String id = String.format ( "%s", priority );
        addEntry ( ctx, id, priority, makeData ( eventHandler, id ) );
    }

    protected void addEntry ( final OscarContext ctx, final String configurationId, final int priority, final Map<String, String> properties )
    {
        final Map<String, String> data = new HashMap<> ();
        data.put ( "type.id", this.typeId );
        data.put ( "priority", "" + priority );

        for ( final Map.Entry<String, String> entry : properties.entrySet () )
        {
            data.put ( "properties." + entry.getKey (), entry.getValue () );
        }

        ctx.addData ( "org.eclipse.scada.ae.server.injector", configurationId, data );
    }

}