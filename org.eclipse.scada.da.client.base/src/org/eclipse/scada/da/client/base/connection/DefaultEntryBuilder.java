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

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.da.client.Connection;
import org.eclipse.scada.da.client.ItemManagerImpl;
import org.eclipse.scada.da.client.connector.Activator;

/**
 * Build a simple connection
 * @author Jens Reimann
 *
 */
public class DefaultEntryBuilder implements EntryBuilder
{
    public ConnectionManagerEntry build ( final ConnectionInformation connectionInformation, final boolean requireOpen )
    {
        if ( connectionInformation == null )
        {
            return null;
        }

        final ConnectionManagerEntry entry = new ConnectionManagerEntry ();

        final Connection connection = (Connection)Activator.createConnection ( connectionInformation );

        if ( connection == null )
        {
            return null;
        }

        setupConnection ( connection, requireOpen );

        entry.setConnection ( connection );
        entry.setItemManager ( new ItemManagerImpl ( entry.getConnection () ) );

        return entry;
    }

    /**
     * configure the new connection
     * @param connection the connection to configure
     * @param requireOpen flag which indicates if the connection should be opened
     */
    protected void setupConnection ( final Connection connection, final boolean requireOpen )
    {
        if ( requireOpen )
        {
            connection.connect ();
        }
    }

}
