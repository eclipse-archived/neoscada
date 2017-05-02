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
package org.eclipse.scada.ae.ui.connection.internal;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.scada.ae.BrowserListener;
import org.eclipse.scada.ae.connection.provider.ConnectionService;
import org.eclipse.scada.ae.data.BrowserEntry;
import org.eclipse.scada.ae.ui.connection.data.BrowserEntryBean;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionWrapper extends WritableSet implements PropertyChangeListener
{

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionWrapper.class );

    private final ConnectionHolder holder;

    private ConnectionService service;

    private final Map<String, BrowserEntryBean> entries = new HashMap<String, BrowserEntryBean> ();

    private BrowserListener listener;

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
        this.service.getConnection ().addBrowserListener ( this.listener = new BrowserListener () {

            @Override
            public void dataChanged ( final List<BrowserEntry> addedOrUpdated, final Set<String> removed, final boolean full )
            {
                ConnectionWrapper.this.dataChanged ( addedOrUpdated, removed, full );
            }
        } );
    }

    private void clearConnection ()
    {
        clear ();
        for ( final BrowserEntryBean entry : this.entries.values () )
        {
            entry.dispose ();
        }

        if ( this.service != null )
        {
            this.service.getConnection ().removeBrowserListener ( this.listener );
        }
        this.listener = null;

        this.entries.clear ();
        this.service = null;
    }

    public ConnectionService getService ()
    {
        return this.service;
    }

    public void dataChanged ( final List<BrowserEntry> addedOrUpdated, final Set<String> removed, final boolean full )
    {
        getRealm ().asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                handleDataChanged ( addedOrUpdated, removed, full );

            }
        } );
    }

    protected void handleDataChanged ( final List<BrowserEntry> addedOrUpdated, final Set<String> removed, final boolean full )
    {
        if ( isDisposed () )
        {
            return;
        }

        setStale ( true );
        try
        {
            if ( full )
            {
                clear ();
            }
            if ( removed != null )
            {
                for ( final String item : removed )
                {
                    final BrowserEntryBean entry = this.entries.remove ( item );
                    if ( entry != null )
                    {
                        logger.debug ( "Removing: {}", entry );
                        remove ( entry );
                        entry.dispose ();
                    }
                }
            }
            if ( addedOrUpdated != null )
            {
                for ( final BrowserEntry entry : addedOrUpdated )
                {
                    final BrowserEntryBean newEntry = new BrowserEntryBean ( this.service, entry );
                    final BrowserEntryBean oldEntry = this.entries.put ( entry.getId (), newEntry );
                    if ( oldEntry != null )
                    {
                        logger.debug ( "Removing old: {}", entry.getId () );
                        remove ( oldEntry );
                        oldEntry.dispose ();
                    }
                    logger.debug ( "Adding: {}", entry.getId () );
                    add ( newEntry );
                }
            }
        }
        finally
        {
            setStale ( false );
        }
    }

}
