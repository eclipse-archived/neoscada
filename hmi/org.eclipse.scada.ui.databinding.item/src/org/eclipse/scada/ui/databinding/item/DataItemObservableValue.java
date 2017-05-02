/*******************************************************************************
 * Copyright (c) 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ui.databinding.item;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.scada.core.connection.provider.ConnectionIdTracker;
import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.eclipse.scada.core.connection.provider.ConnectionTracker;
import org.eclipse.scada.core.connection.provider.ConnectionTracker.Listener;
import org.eclipse.scada.da.client.DataItem;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.ItemManager;
import org.osgi.framework.BundleContext;

public class DataItemObservableValue extends AbstractObservableValue
{

    public static final class ReplaceInvalidValuePolicy implements InvalidValuePolicy
    {

        private final DataItemValue replacement;

        public ReplaceInvalidValuePolicy ( final DataItemValue replacement )
        {
            this.replacement = replacement;
        }

        @Override
        public boolean isInvalid ( final DataItemValue value )
        {
            if ( value == null )
            {
                return true;
            }
            if ( !value.isConnected () || value.isError () )
            {
                return true;
            }
            return false;
        }

        @Override
        public DataItemValue processInvalid ( final DataItemValue value )
        {
            return this.replacement;
        }

    }

    public static final InvalidValuePolicy VALUE_POLICY_REPLACE_DISCONNECTED = new ReplaceInvalidValuePolicy ( DataItemValue.DISCONNECTED );

    public static final InvalidValuePolicy VALUE_POLICY_IGNORE = new InvalidValuePolicy () {

        @Override
        public boolean isInvalid ( final DataItemValue value )
        {
            return false;
        }

        @Override
        public DataItemValue processInvalid ( final DataItemValue value )
        {
            return value;
        }
    };

    private final ConnectionTracker tracker;

    private DataItemValue value = DataItemValue.DISCONNECTED;

    private DataItem dataItem;

    private String itemId;

    private Observer observer;

    private org.eclipse.scada.da.connection.provider.ConnectionService service;

    private final InvalidValuePolicy invalidValuePolicy;

    public DataItemObservableValue ( final BundleContext context, final String connectionId, final String itemId )
    {
        this ( context, connectionId, itemId, VALUE_POLICY_REPLACE_DISCONNECTED, Realm.getDefault() );
    }
    
    public DataItemObservableValue ( final BundleContext context, final String connectionId, final String itemId, Realm realm )
    {
        this ( context, connectionId, itemId, VALUE_POLICY_REPLACE_DISCONNECTED, realm );
    }

    public DataItemObservableValue ( final BundleContext context, final String connectionId, final String itemId, final InvalidValuePolicy invalidValuePolicy )
    {
    	this ( context, connectionId, itemId, invalidValuePolicy, Realm.getDefault() );
    }
    
    public DataItemObservableValue ( final BundleContext context, final String connectionId, final String itemId, final InvalidValuePolicy invalidValuePolicy, Realm realm )
    {
    	super ( realm );
        this.invalidValuePolicy = invalidValuePolicy;
        this.itemId = itemId;
        final Listener listener = new Listener () {

            @Override
            public void setConnection ( final ConnectionService connectionService )
            {
                bind ( connectionService );
            }
        };
        this.tracker = new ConnectionIdTracker ( context, connectionId, listener, org.eclipse.scada.da.connection.provider.ConnectionService.class );
        this.tracker.open ();
    }

    protected synchronized void bind ( final ConnectionService connectionService )
    {
        unbind ();
        this.service = null;

        if ( connectionService instanceof org.eclipse.scada.da.connection.provider.ConnectionService )
        {
            this.service = (org.eclipse.scada.da.connection.provider.ConnectionService)connectionService;
            bind ();
        }
    }

    private void bind ()
    {
        if ( this.service != null && this.itemId != null )
        {
            final ItemManager im = this.service.getItemManager ();
            this.dataItem = new DataItem ( this.itemId );
            this.dataItem.addObserver ( this.observer = createObserver () );
            this.dataItem.register ( im );
        }
    }

    private Observer createObserver ()
    {
        return new Observer () {

            @Override
            public void update ( final Observable o, final Object arg )
            {
                if ( arg instanceof DataItemValue )
                {
                    handleUpdate ( this, (DataItemValue)arg );
                }
            }
        };
    }

    protected synchronized void handleUpdate ( final Observer observer, DataItemValue value )
    {
        if ( observer != this.observer )
        {
            return;
        }

        if ( this.invalidValuePolicy.isInvalid ( value ) )
        {
            value = this.invalidValuePolicy.processInvalid ( value );
        }

        fireChange ( this.value, this.value = value );
    }

    private void fireChange ( final DataItemValue oldValue, final DataItemValue newValue )
    {
        final ValueDiff diff = new ValueDiff () {

            @Override
            public Object getOldValue ()
            {
                return oldValue;
            }

            @Override
            public Object getNewValue ()
            {
                return newValue;
            }
        };
        getRealm ().asyncExec ( new Runnable () {
            @Override
            public void run ()
            {
                fireValueChange ( diff );
            };
        } );
    }

    protected synchronized void unbind ()
    {
        this.observer = null;
        if ( this.dataItem != null )
        {
            this.dataItem.unregister ();
            this.dataItem.deleteObservers ();
            handleUpdate ( null, DataItemValue.DISCONNECTED );
        }
    }

    @Override
    public synchronized void dispose ()
    {
        this.service = null;
        this.tracker.close ();
        unbind ();
        super.dispose ();
    }

    @Override
    public Object getValueType ()
    {
        return DataItemValue.class;
    }

    @Override
    protected Object doGetValue ()
    {
        return this.value;
    }

    public String getItemId ()
    {
        return this.itemId;
    }

    public synchronized void setItemId ( final String itemId )
    {
        if ( this.itemId == null && itemId == null )
        {
            return;
        }
        if ( this.itemId != null && this.itemId.equals ( itemId ) )
        {
            return;
        }

        // unregister
        unbind ();

        // set new id
        this.itemId = itemId;

        // register
        bind ();

        if ( itemId == null )
        {
            handleUpdate ( this.observer, DataItemValue.DISCONNECTED );
        }

    }
}
