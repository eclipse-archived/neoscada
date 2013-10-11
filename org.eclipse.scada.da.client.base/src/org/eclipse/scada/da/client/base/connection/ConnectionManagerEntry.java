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
package org.eclipse.scada.da.client.base.connection;

import org.eclipse.scada.da.client.Connection;

public class ConnectionManagerEntry
{
    private Connection connection;

    private Object itemManager;

    public void setConnection ( final Connection connection )
    {
        this.connection = connection;
    }

    public Connection getConnection ()
    {
        return this.connection;
    }

    public void setItemManager ( final Object itemManager )
    {
        this.itemManager = itemManager;
    }

    public Object getItemManager ()
    {
        return this.itemManager;
    }

    public void dispose ()
    {
        this.connection.disconnect ();
        this.connection = null;
        this.itemManager = null;
    }
}