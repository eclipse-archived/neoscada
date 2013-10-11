/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.ui.connection.data;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.connection.provider.ConnectionIdTracker;
import org.eclipse.scada.core.connection.provider.ConnectionRequest;
import org.eclipse.scada.core.connection.provider.ConnectionRequestTracker;
import org.eclipse.scada.core.connection.provider.ConnectionTracker;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.da.client.DataItem;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.connection.provider.ConnectionService;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.osgi.framework.BundleContext;

public class DataItemHolder
{
    private final Item item;

    private final BundleContext context;

    private final ConnectionTracker tracker;

    private final DataSourceListener listener;

    private ConnectionService connection;

    private DataItem dataItem;

    private final Observer observer;

    public DataItemHolder ( final BundleContext context, final Item item, final DataSourceListener listener )
    {
        this.context = context;
        this.item = item;

        synchronized ( this )
        {
            this.listener = listener;

            this.observer = new Observer () {

                @Override
                public void update ( final Observable o, final Object arg )
                {
                    DataItemHolder.this.update ( o, arg );
                }
            };

            switch ( item.getType () )
            {
                case ID:
                    this.tracker = new ConnectionIdTracker ( this.context, item.getConnectionString (), new ConnectionTracker.Listener () {

                        @Override
                        public void setConnection ( final org.eclipse.scada.core.connection.provider.ConnectionService connectionService )
                        {
                            DataItemHolder.this.setConnection ( (ConnectionService)connectionService );
                        }
                    } );
                    break;

                case URI:
                default:
                    this.tracker = new ConnectionRequestTracker ( this.context, createRequest (), new ConnectionTracker.Listener () {

                        @Override
                        public void setConnection ( final org.eclipse.scada.core.connection.provider.ConnectionService connectionService )
                        {
                            DataItemHolder.this.setConnection ( (ConnectionService)connectionService );
                        }
                    } );

                    break;
            }
        }
        this.tracker.listen ();

    }

    protected void update ( final Observable o, final Object arg )
    {
        if ( o != this.dataItem )
        {
            return;
        }
        if ( ! ( arg instanceof DataItemValue ) )
        {
            return;
        }
        fireListenerChange ( (DataItemValue)arg );
    }

    protected synchronized void setConnection ( final ConnectionService connectionService )
    {
        clearConnection ();
        createConnection ( connectionService );
    }

    private synchronized void createConnection ( final ConnectionService connectionService )
    {
        this.connection = connectionService;
        if ( this.connection != null )
        {
            this.dataItem = new DataItem ( this.item.getId () );
            this.dataItem.addObserver ( this.observer );
            this.dataItem.register ( this.connection.getItemManager () );
        }
    }

    private synchronized void clearConnection ()
    {
        if ( this.dataItem != null )
        {
            this.dataItem.deleteObserver ( this.observer );
            this.dataItem.unregister ();
            this.dataItem = null;
        }
        if ( this.connection != null )
        {
            this.connection = null;
        }
        fireListenerChange ( null );
    }

    private synchronized void fireListenerChange ( final DataItemValue value )
    {
        if ( this.listener != null )
        {
            this.listener.updateData ( value );
        }
    }

    private ConnectionRequest createRequest ()
    {
        return new ConnectionRequest ( null, ConnectionInformation.fromURI ( this.item.getConnectionString () ), null, false );
    }

    public synchronized void dispose ()
    {
        clearConnection ();
        this.tracker.close ();
    }

    public NotifyFuture<WriteResult> startWrite ( final Variant value, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        return this.connection.getConnection ().startWrite ( this.item.getId (), value, operationParameters, callbackHandler );
    }

    public NotifyFuture<WriteAttributeResults> startWriteAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        return this.connection.getConnection ().startWriteAttributes ( this.item.getId (), attributes, operationParameters, callbackHandler );
    }

    public NotifyFuture<WriteResult> write ( final Variant value )
    {
        return write ( value, null, null );
    }

    public NotifyFuture<WriteResult> write ( final Variant value, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        return this.connection.getConnection ().startWrite ( this.item.getId (), value, operationParameters, callbackHandler );
    }

    public NotifyFuture<WriteAttributeResults> writeAtrtibutes ( final Map<String, Variant> attributes )
    {
        return writeAtrtibutes ( attributes, null, null );
    }

    public NotifyFuture<WriteAttributeResults> writeAtrtibutes ( final Map<String, Variant> attributes, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        return this.connection.getConnection ().startWriteAttributes ( this.item.getId (), attributes, operationParameters, callbackHandler );
    }

    public Item getItem ()
    {
        return this.item;
    }

    public boolean waitForConnection ( final long timeout ) throws InterruptedException
    {
        return this.tracker.waitForService ( timeout ) != null;
    }
}
