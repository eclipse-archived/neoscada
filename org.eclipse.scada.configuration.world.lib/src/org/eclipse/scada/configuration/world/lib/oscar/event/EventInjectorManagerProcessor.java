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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;
import org.eclipse.scada.configuration.world.lib.oscar.TypedOscarProcessor;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.EventHandler;
import org.eclipse.scada.configuration.world.osgi.EventInjectorManager;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;

public class EventInjectorManagerProcessor extends TypedOscarProcessor<EventInjectorManager>
{
    public EventInjectorManagerProcessor ()
    {
        super ( EventInjectorManager.class );
    }

    @Override
    protected void process ( final EventInjectorManager item, final EquinoxApplication app, final OscarContext ctx, final IProgressMonitor monitor )
    {
        int priority = 0;
        for ( final EventHandler handler : item.getHandler () )
        {
            final EventHandlerProcessor processor = AdapterHelper.adapt ( handler, EventHandlerProcessor.class );
            if ( processor == null )
            {
                throw new IllegalStateException ( String.format ( "Unable to adapt class %s to %s", handler.getClass ().getName (), EventHandlerProcessor.class.getName () ) );
            }
            processor.process ( handler, ctx, priority );
            priority += 100;
        }
    }
}
