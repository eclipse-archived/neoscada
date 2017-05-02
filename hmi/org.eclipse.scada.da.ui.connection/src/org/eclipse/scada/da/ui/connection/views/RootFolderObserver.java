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
package org.eclipse.scada.da.ui.connection.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.scada.da.connection.provider.ConnectionService;
import org.eclipse.scada.da.ui.connection.internal.FolderEntryWrapper;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;

public class RootFolderObserver extends FolderObserver implements PropertyChangeListener
{
    final ConnectionHolder connectionHolder;

    public RootFolderObserver ( final ConnectionHolder connectionHolder )
    {
        super ();

        this.connectionHolder = connectionHolder;
        synchronized ( this )
        {
            connectionHolder.addPropertyChangeListener ( ConnectionHolder.PROP_CONNECTION_SERVICE, this );
            updateConnection ();
        }
    }

    @Override
    public synchronized void dispose ()
    {
        this.connectionHolder.removePropertyChangeListener ( ConnectionHolder.PROP_CONNECTION_SERVICE, this );
        setFolderManager ( null );
        super.dispose ();
    }

    @Override
    public synchronized void propertyChange ( final PropertyChangeEvent evt )
    {
        updateConnection ();
    }

    private void updateConnection ()
    {
        final org.eclipse.scada.core.connection.provider.ConnectionService connection = this.connectionHolder.getConnectionService ();
        if ( connection == null )
        {
            setConnection ( null );
        }
        else if ( connection instanceof ConnectionService )
        {
            setConnection ( (ConnectionService)connection );
        }
    }

    private synchronized void setConnection ( final ConnectionService connectionService )
    {
        if ( connectionService != null )
        {
            setFolderManager ( new FolderEntryWrapper ( this.connectionHolder, connectionService.getFolderManager () ) );
        }
        else
        {
            this.data.clear ();
        }
    }
}
