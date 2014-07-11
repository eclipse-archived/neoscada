/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.ui.internal;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.scada.da.server.ui.ServerDescriptor;
import org.eclipse.scada.da.server.ui.ServerManager;

public class ServerManagerImpl implements ServerManager
{
    private final WritableSet servers;

    public ServerManagerImpl ( final Realm realm )
    {
        this.servers = new WritableSet ( realm );
    }

    @Override
    public void register ( final ServerDescriptor descriptor )
    {
        this.servers.getRealm ().exec ( new Runnable () {

            @Override
            public void run ()
            {
                if ( !ServerManagerImpl.this.servers.isDisposed () )
                {
                    ServerManagerImpl.this.servers.add ( descriptor );
                }
            }
        } );
    }

    @Override
    public void unregister ( final ServerDescriptor descriptor )
    {
        this.servers.getRealm ().exec ( new Runnable () {
            @Override
            public void run ()
            {
                if ( !ServerManagerImpl.this.servers.isDisposed () )
                {
                    ServerManagerImpl.this.servers.remove ( descriptor );
                }
            }
        } );
    }

    @Override
    public IObservableSet getServers ()
    {
        return this.servers;
    }

    public void dispose ()
    {
        for ( final Object o : this.servers )
        {
            final ServerDescriptor desc = (ServerDescriptor)o;
            try
            {
                desc.stop ();
            }
            catch ( final CoreException e )
            {
            }
        }

        if ( !this.servers.isDisposed () )
        {
            this.servers.dispose ();
        }
    }
}
