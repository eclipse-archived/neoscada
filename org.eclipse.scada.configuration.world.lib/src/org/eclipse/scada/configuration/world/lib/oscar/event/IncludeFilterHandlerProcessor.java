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

import org.eclipse.scada.configuration.world.osgi.EventHandler;
import org.eclipse.scada.configuration.world.osgi.IncludeEventFilter;

public class IncludeFilterHandlerProcessor extends BasicEventHandlerProcessor implements EventHandlerProcessor
{

    public IncludeFilterHandlerProcessor ()
    {
        super ( "include" );
    }

    @Override
    protected Map<String, String> makeData ( final EventHandler eventHandler, final String id )
    {
        final IncludeEventFilter handler = (IncludeEventFilter)eventHandler;

        final Map<String, String> result = new HashMap<> ( 1 );
        result.put ( "filter", handler.getFilter () );
        return result;
    }

}
