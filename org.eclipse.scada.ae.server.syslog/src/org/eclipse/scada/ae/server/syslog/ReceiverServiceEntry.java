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
package org.eclipse.scada.ae.server.syslog;

import org.eclipse.scada.ae.server.injector.EventInjectorQueue;

public class ReceiverServiceEntry
{
    private ReceiverService service;

    private final EventInjectorQueue injector;

    public ReceiverServiceEntry ( final EventInjectorQueue injector, final ReceiverConfiguration cfg )
    {
        this.injector = injector;
        createService ( cfg );
    }

    private synchronized void createService ( final ReceiverConfiguration cfg )
    {
        this.service = new ReceiverService ( this.injector, cfg );
    }

    public synchronized void update ( final ReceiverConfiguration cfg )
    {
        dispose ();
        createService ( cfg );
    }

    public synchronized void dispose ()
    {
        if ( this.service != null )
        {
            this.service.dispose ();
            this.service = null;
        }
    }

}
