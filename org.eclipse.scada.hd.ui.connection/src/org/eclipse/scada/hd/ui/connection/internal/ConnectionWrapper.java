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
package org.eclipse.scada.hd.ui.connection.internal;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.scada.hd.connection.provider.ConnectionService;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;

public class ConnectionWrapper extends WritableSet implements PropertyChangeListener
{

    private final ConnectionHolder holder;

    private ConnectionService service;

    private QueryWrapper queryManager;

    public ConnectionWrapper ( final ConnectionHolder target )
    {
        this.holder = target;

        synchronized ( this )
        {
            this.holder.addPropertyChangeListener ( ConnectionHolder.PROP_CONNECTION_SERVICE, this );
            triggerUpdate ();
        }
    }

    @Override
    public synchronized void dispose ()
    {
        this.holder.removePropertyChangeListener ( ConnectionHolder.PROP_CONNECTION_SERVICE, this );
        super.dispose ();
    }

    @Override
    public synchronized void propertyChange ( final PropertyChangeEvent evt )
    {
        triggerUpdate ();
    }

    private void triggerUpdate ()
    {
        getRealm ().asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                update ();
            }
        } );
    }

    private void update ()
    {
        setStale ( true );

        try
        {
            clearConnection ();

            final ConnectionService service = (ConnectionService)this.holder.getConnectionService ();
            this.service = service;
            if ( this.service != null )
            {
                this.queryManager = new QueryWrapper ( service );
                add ( this.queryManager );
                add ( new ItemListWrapper ( this ) );
            }
        }
        finally
        {
            setStale ( false );
        }
    }

    public QueryWrapper getQueryManager ()
    {
        return this.queryManager;
    }

    private void clearConnection ()
    {
        clear ();
        this.service = null;
        if ( this.queryManager != null )
        {
            this.queryManager.dispose ();
        }
    }

    public ConnectionService getService ()
    {
        return this.service;
    }

}
