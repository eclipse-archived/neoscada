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
package org.eclipse.scada.ae.ui.testing.navigator;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.scada.ae.BrowserListener;
import org.eclipse.scada.ae.connection.provider.ConnectionService;
import org.eclipse.scada.ae.ui.connection.data.BrowserEntryBean;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;

public class ConnectionWrapper extends WritableSet implements PropertyChangeListener
{
    private final ConnectionHolder holder;

    private ConnectionService service;

    private final Map<String, BrowserEntryBean> entries = new HashMap<String, BrowserEntryBean> ();

    private BrowserListener listener;

    private QueryListWrapper wrapper;

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

    public synchronized void propertyChange ( final PropertyChangeEvent evt )
    {
        triggerUpdate ();
    }

    private void triggerUpdate ()
    {
        getRealm ().asyncExec ( new Runnable () {

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
                setupConnection ();
            }
        }
        finally
        {
            setStale ( false );
        }
    }

    private void setupConnection ()
    {
        add ( this.wrapper = new QueryListWrapper ( this ) );
    }

    private void clearConnection ()
    {
        clear ();

        if ( this.service != null )
        {
            this.service.getConnection ().removeBrowserListener ( this.listener );
        }
        this.listener = null;
        if ( this.wrapper != null )
        {
            remove ( this.wrapper );
            this.wrapper.dispose ();
            this.wrapper = null;
        }

        this.entries.clear ();
        this.service = null;
    }

    public ConnectionService getService ()
    {
        return this.service;
    }

}
