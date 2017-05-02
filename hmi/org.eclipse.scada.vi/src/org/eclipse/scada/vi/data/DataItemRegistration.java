/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.data;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.scada.core.connection.provider.ConnectionIdTracker;
import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.eclipse.scada.da.client.DataItem;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.connection.data.Item.Type;
import org.osgi.framework.BundleContext;

public class DataItemRegistration implements Observer
{
    private final RegistrationManager registrationManager;

    private final String name;

    private final ConnectionIdTracker connectionTracker;

    private org.eclipse.scada.da.connection.provider.ConnectionService connectionService;

    private DataItem dataItem;

    private final boolean ignoreSummary;

    private final boolean nullInvalid;

    private final Item item;

    public DataItemRegistration ( final RegistrationManager registrationManager, final BundleContext context, final String name, final String itemId, final String connectionId, final boolean ignoreSummary, final boolean nullInvalid )
    {
        this.registrationManager = registrationManager;
        this.name = name;
        this.item = new Item ( connectionId, itemId, Type.ID );
        this.ignoreSummary = ignoreSummary;
        this.nullInvalid = nullInvalid;

        this.connectionTracker = new ConnectionIdTracker ( context, connectionId, new ConnectionIdTracker.Listener () {

            @Override
            public void setConnection ( final ConnectionService connectionService )
            {
                DataItemRegistration.this.setConnection ( connectionService );
            }
        } );
    }

    public void open ()
    {
        this.connectionTracker.open ();
    }

    public void close ()
    {
        this.connectionTracker.close ();
        disconnect ();
        notifyChange ( DataItemValue.DISCONNECTED );
    }

    public boolean isIgnoreSummary ()
    {
        return this.ignoreSummary;
    }

    public boolean isNullInvalid ()
    {
        return this.nullInvalid;
    }

    public Item getItem ()
    {
        return this.item;
    }

    protected synchronized void setConnection ( final ConnectionService connectionService )
    {
        disconnect ();

        if ( connectionService instanceof org.eclipse.scada.da.connection.provider.ConnectionService )
        {
            this.connectionService = (org.eclipse.scada.da.connection.provider.ConnectionService)connectionService;
            this.dataItem = new DataItem ( this.item.getId () );
            this.dataItem.addObserver ( this );
            this.dataItem.register ( this.connectionService.getItemManager () );
        }

        // at the end we are disconnected ... notify as last operation
        if ( this.connectionService == null )
        {
            notifyChange ( DataItemValue.DISCONNECTED );
        }
    }

    private void disconnect ()
    {
        if ( this.connectionService != null )
        {
            this.connectionService = null;
        }
        if ( this.dataItem != null )
        {
            this.dataItem.deleteObservers ();
            this.dataItem.unregister ();
            this.dataItem = null;
        }
    }

    public void notifyChange ( final DataItemValue value )
    {
        this.registrationManager.notifyChange ( this.name, this.item, value, this.ignoreSummary, this.nullInvalid );
    }

    @Override
    public void update ( final Observable o, final Object arg )
    {
        if ( o == this.dataItem && arg instanceof DataItemValue )
        {
            notifyChange ( (DataItemValue)arg );
        }
    }
}
