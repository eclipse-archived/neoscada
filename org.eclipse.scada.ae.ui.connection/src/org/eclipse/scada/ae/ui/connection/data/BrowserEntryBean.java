/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.connection.data;

import org.eclipse.scada.ae.connection.provider.ConnectionService;
import org.eclipse.scada.ae.data.BrowserEntry;

public class BrowserEntryBean
{
    private final BrowserEntry entry;

    private final ConnectionService connection;

    public BrowserEntryBean ( final ConnectionService connection, final BrowserEntry entry )
    {
        this.connection = connection;
        this.entry = entry;
    }

    public ConnectionService getConnection ()
    {
        return this.connection;
    }

    public BrowserEntry getEntry ()
    {
        return this.entry;
    }

    public void dispose ()
    {
    }
}
