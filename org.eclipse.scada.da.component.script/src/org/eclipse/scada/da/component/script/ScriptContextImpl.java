/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.component.script;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.connection.provider.ConnectionIdTracker;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.core.server.OperationParametersHelper;
import org.eclipse.scada.da.connection.provider.ConnectionService;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.common.chain.WriteHandler;
import org.eclipse.scada.da.server.common.chain.WriteHandlerItem;
import org.osgi.framework.BundleContext;

public class ScriptContextImpl implements ScriptContext
{

    private final BundleContext context;

    private final Map<String, String> parameters;

    private final Executor executor;

    private final Map<String, Item> items = new HashMap<String, ScriptContext.Item> ();

    private final Lock itemsLock = new ReentrantLock ();

    private final ObjectPoolImpl<DataItem> objectPool;

    public ScriptContextImpl ( final Executor executor, final ObjectPoolImpl<DataItem> objectPool, final String id, final BundleContext context, final Map<String, String> parameters )
    {
        this.executor = executor;
        this.context = context;
        this.objectPool = objectPool;
        this.parameters = Collections.unmodifiableMap ( parameters );
    }

    @Override
    public Item registerItem ( final String itemId, final Map<String, Variant> attributes, final WriteHandler writeHandler )
    {
        if ( writeHandler != null )
        {
            return registerItem ( new ItemWrapper ( this.objectPool, new WriteHandlerItem ( itemId, writeHandler, this.executor ), attributes ) );
        }
        else
        {
            return registerItem ( new ItemWrapper ( this.objectPool, new DataItemInputChained ( itemId, this.executor ), attributes ) );
        }
    }

    private Item registerItem ( final Item item )
    {
        this.itemsLock.lock ();
        try
        {
            final Item oldItem = this.items.remove ( item.getItemId () );
            if ( oldItem != null )
            {
                oldItem.dispose ();
            }

            this.items.put ( item.getItemId (), item );

            return item;
        }
        finally
        {
            this.itemsLock.unlock ();
        }
    }

    @Override
    public void unregisterItem ( final String itemId )
    {
        final Item item;

        this.itemsLock.lock ();
        try
        {
            item = this.items.remove ( itemId );
        }
        finally
        {
            this.itemsLock.unlock ();
        }

        if ( item != null )
        {
            item.dispose ();
        }
    }

    @Override
    public void unregisterItem ( final Item item )
    {
        unregisterItem ( item.getItemId () );
    }

    @Override
    public void writeDataItem ( final String connectionId, final String itemId, final Variant value, final OperationParameters operationParameters ) throws Exception
    {
        final ConnectionIdTracker tracker = new ConnectionIdTracker ( this.context, connectionId, null, ConnectionService.class );
        tracker.open ();
        try
        {
            final ConnectionService service = (ConnectionService)tracker.waitForService ( 0 );
            if ( service != null )
            {
                service.getConnection ().write ( itemId, value, OperationParametersHelper.toData ( operationParameters ), null );
            }
        }
        finally
        {
            tracker.close ();
        }
    }

    @Override
    public void dispose ()
    {
        this.itemsLock.lock ();
        try
        {
            for ( final Item item : this.items.values () )
            {
                item.dispose ();
            }
            this.items.clear ();
        }
        finally
        {
            this.itemsLock.unlock ();
        }
    }

    @Override
    public Map<String, String> getParameters ()
    {
        return this.parameters;
    }

}
