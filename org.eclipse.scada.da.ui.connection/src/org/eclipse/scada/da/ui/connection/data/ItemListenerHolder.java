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
package org.eclipse.scada.da.ui.connection.data;

import org.eclipse.scada.core.client.Connection;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.da.client.ItemUpdateListener;
import org.eclipse.scada.da.connection.provider.ConnectionService;
import org.osgi.framework.BundleContext;

public class ItemListenerHolder extends AbstractItemHolder
{
    private final ItemUpdateListener listener;

    private ConnectionService connection;

    public interface HolderListener
    {
        public void connectionChange ( ConnectionService connection );

        public void connectionStateChange ( Connection connection, ConnectionState state, Throwable error );
    }

    public ItemListenerHolder ( final BundleContext context, final Item item, final ItemUpdateListener listener )
    {
        super ( context, item, null );
        this.listener = listener;

        init ();
    }

    public ItemListenerHolder ( final BundleContext context, final Item item, final ItemUpdateListener listener, final HolderListener holderListener )
    {
        super ( context, item, holderListener );
        this.listener = listener;

        init ();
    }

    @Override
    protected void bindConnection ( final ConnectionService connectionService )
    {
        super.bindConnection ( connectionService );
        if ( connectionService != null )
        {
            connectionService.getItemManager ().addItemUpdateListener ( this.item.getId (), this.listener );
            this.connection = connectionService;
        }
    }

    @Override
    protected void unbindConnection ()
    {
        if ( this.connection != null )
        {
            this.connection.getItemManager ().removeItemUpdateListener ( this.item.getId (), this.listener );
            this.connection = null;
        }
        super.unbindConnection ();
    }

}
