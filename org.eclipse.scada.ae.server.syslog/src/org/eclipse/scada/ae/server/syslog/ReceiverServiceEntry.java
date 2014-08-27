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

import org.eclipse.scada.ae.event.EventProcessor;

public class ReceiverServiceEntry
{
    private ReceiverService service;

    private final EventProcessor processor;

    public ReceiverServiceEntry ( final EventProcessor processor, final ReceiverConfiguration cfg )
    {
        this.processor = processor;
        createService ( cfg );
    }

    private synchronized void createService ( final ReceiverConfiguration cfg )
    {
        this.service = new ReceiverService ( this.processor, cfg );
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
