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
package org.eclipse.scada.da.ui.client.test.console;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.console.IOConsole;

public class ItemTraceIOConsole extends IOConsole
{
    private final ItemTrace trace;

    public ItemTraceIOConsole ( final ItemTrace trace, final String name, final ImageDescriptor imageDescriptor )
    {
        super ( name, imageDescriptor );
        this.trace = trace;
    }

    public ItemTraceIOConsole ( final ItemTrace trace, final String name, final String consoleType, final ImageDescriptor imageDescriptor, final boolean autoLifecycle )
    {
        super ( name, consoleType, imageDescriptor, autoLifecycle );
        this.trace = trace;
    }

    public ItemTraceIOConsole ( final ItemTrace trace, final String name, final String consoleType, final ImageDescriptor imageDescriptor, final String encoding, final boolean autoLifecycle )
    {
        super ( name, consoleType, imageDescriptor, encoding, autoLifecycle );
        this.trace = trace;
    }

    public ItemTraceIOConsole ( final ItemTrace trace, final String name, final String consoleType, final ImageDescriptor imageDescriptor )
    {
        super ( name, consoleType, imageDescriptor );
        this.trace = trace;
    }

    public void stop ()
    {
        this.trace.stop ();
    }
}
