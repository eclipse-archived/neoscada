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
package org.eclipse.scada.core.ui.connection.data;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IActionFilter;
import org.eclipse.scada.core.ui.connection.ConnectionDescriptor;
import org.eclipse.scada.core.ui.connection.ConnectionDiscoverer;
import org.eclipse.scada.core.ui.connection.ConnectionDiscoveryListener;
import org.eclipse.scada.core.ui.connection.ConnectionStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionDiscovererBean implements IAdaptable, ConnectionDiscoveryListener, IActionFilter
{

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionDiscovererBean.class );

    private final String id;

    private final String name;

    private final String description;

    private final ConnectionDiscoverer discoverer;

    private final ImageDescriptor imageDescriptor;

    private final WritableSet knownConnections = new WritableSet ();

    private final Map<ConnectionDescriptor, ConnectionHolder> connections = new HashMap<ConnectionDescriptor, ConnectionHolder> ();

    public ConnectionDiscovererBean ( final String id, final String name, final String description, final ImageDescriptor imageDescriptor, final ConnectionDiscoverer discoverer )
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.discoverer = discoverer;
        this.imageDescriptor = imageDescriptor;

        register ();
    }

    private void register ()
    {
        this.discoverer.addConnectionListener ( this );
    }

    public IObservableSet getKnownConnections ()
    {
        return Observables.proxyObservableSet ( this.knownConnections );
    }

    public ImageDescriptor getImageDescriptor ()
    {
        return this.imageDescriptor;
    }

    public String getName ()
    {
        return this.name;
    }

    public String getId ()
    {
        return this.id;
    }

    public String getDescription ()
    {
        return this.description;
    }

    @Override
    public String toString ()
    {
        return this.id;
    }

    @Override
    @SuppressWarnings ( "rawtypes" )
    public Object getAdapter ( final Class adapter )
    {
        logger.info ( "Get adaper: {}", adapter );
        if ( adapter == ConnectionDiscoverer.class )
        {
            return this.discoverer;
        }
        if ( adapter == ConnectionStore.class && this.discoverer instanceof ConnectionStore )
        {
            return this.discoverer;
        }
        if ( this.discoverer instanceof IAdaptable )
        {
            return ( (IAdaptable)this.discoverer ).getAdapter ( adapter );
        }
        return null;
    }

    @Override
    public void discoveryUpdate ( final ConnectionDescriptor[] added, final ConnectionDescriptor[] removed )
    {
        this.knownConnections.getRealm ().asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                ConnectionDiscovererBean.this.handleDiscoveryUpdate ( added, removed );
            }
        } );

    }

    protected void handleDiscoveryUpdate ( final ConnectionDescriptor[] added, final ConnectionDescriptor[] removed )
    {
        if ( removed != null )
        {
            for ( final ConnectionDescriptor info : removed )
            {
                final ConnectionHolder holder = this.connections.get ( info );
                if ( holder != null )
                {
                    this.knownConnections.remove ( holder );
                    holder.dispose ();
                }
            }
        }
        if ( added != null )
        {
            for ( final ConnectionDescriptor info : added )
            {
                final ConnectionHolder holder = new ConnectionHolder ( this, info );
                this.knownConnections.add ( holder );
                this.connections.put ( info, holder );
            }
        }
    }

    public ConnectionStore getStore ()
    {
        if ( this.discoverer instanceof ConnectionStore )
        {
            return (ConnectionStore)this.discoverer;
        }
        return null;
    }

    public boolean isStore ()
    {
        return this.discoverer instanceof ConnectionStore;
    }

    @Override
    public boolean testAttribute ( final Object target, final String name, final String value )
    {
        if ( "isStore".equals ( name ) )
        {
            return isStore () == Boolean.valueOf ( value );
        }
        return false;
    }
}
