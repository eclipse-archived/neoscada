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
package org.eclipse.scada.ae.server.injector.internal;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.server.injector.EventInjector;

public class EventInjectorImpl implements EventInjector
{
    private final EventProcessor processor;

    public EventInjectorImpl ( final EventProcessor processor )
    {
        this.processor = processor;
    }

    @Override
    public void injectEvent ( final Event event )
    {
        this.processor.publishEvent ( event );
    }

    public void dispose ()
    {
    }
}
