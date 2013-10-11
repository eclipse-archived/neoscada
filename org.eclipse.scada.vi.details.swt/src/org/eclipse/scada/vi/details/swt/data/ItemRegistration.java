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
package org.eclipse.scada.vi.details.swt.data;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.scada.core.connection.provider.ConnectionIdTracker;
import org.eclipse.scada.core.connection.provider.ConnectionTracker;
import org.eclipse.scada.core.connection.provider.ConnectionTracker.Listener;
import org.eclipse.scada.da.client.DataItem;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.connection.provider.ConnectionService;
import org.eclipse.scada.vi.details.swt.Activator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemRegistration
{

    private static final Logger logger = LoggerFactory.getLogger ( ItemRegistration.class );

    private final Object key;

    private final ItemListener listener;

    private final ConnectionTracker tracker;

    private DataItem item;

    private DataItemValue currentValue;

    private final DataItemDescriptor itemDescriptor;

    public ItemRegistration ( final Object key, final DataItemDescriptor itemDescriptor, final ItemListener listener )
    {
        this.key = key;
        this.listener = listener;
        this.itemDescriptor = itemDescriptor;

        this.tracker = new ConnectionIdTracker ( Activator.getDefault ().getBundle ().getBundleContext (), itemDescriptor.getConnectionInformation (), new Listener () {

            @Override
            public void setConnection ( final org.eclipse.scada.core.connection.provider.ConnectionService connectionService )
            {
                ItemRegistration.this.handleSetConnection ( (ConnectionService)connectionService );
            }
        } );
    }

    public void open ()
    {
        this.tracker.open ();
    }

    public void close ()
    {
        this.tracker.close ();
    }

    protected void handleSetConnection ( final ConnectionService connectionService )
    {
        logger.info ( "Connection Set: {}", connectionService ); //$NON-NLS-1$

        if ( connectionService != null )
        {
            attach ( connectionService );
        }
        else
        {
            detach ();
        }

    }

    private void detach ()
    {
        if ( this.item != null )
        {
            this.item.unregister ();
            this.item = null;
            fireUpdate ( null );
        }
    }

    private void attach ( final ConnectionService connectionService )
    {
        detach ();

        this.item = new DataItem ( this.itemDescriptor.getItemId () );
        this.item.addObserver ( new Observer () {

            @Override
            public void update ( final Observable o, final Object arg )
            {
                ItemRegistration.this.handleUpdate ( (DataItemValue)arg );
            }
        } );
        this.item.register ( connectionService.getItemManager () );
    }

    protected void handleUpdate ( final DataItemValue value )
    {
        this.currentValue = value;
        fireUpdate ( value );
    }

    private void fireUpdate ( final DataItemValue value )
    {
        if ( this.listener != null )
        {
            try
            {
                this.listener.dataItemUpdate ( this.key, value );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to fire update", e ); //$NON-NLS-1$
            }
        }
    }

    public DataItemValue getCurrentValue ()
    {
        return this.currentValue;
    }
}