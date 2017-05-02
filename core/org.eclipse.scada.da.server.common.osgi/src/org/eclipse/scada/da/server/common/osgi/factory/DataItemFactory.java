/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common.osgi.factory;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.DataItemCommand;
import org.eclipse.scada.da.server.common.chain.AttributeWriteHandler;
import org.eclipse.scada.da.server.common.chain.AttributeWriteHandlerItem;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.common.chain.WriteHandler;
import org.eclipse.scada.da.server.common.chain.WriteHandlerItem;
import org.eclipse.scada.da.server.common.item.factory.ItemFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class DataItemFactory implements ItemFactory
{
    private final BundleContext context;

    private final String globalId;

    private final Executor executor;

    private final Map<String, DataItem> items = new HashMap<String, DataItem> ();

    private final Map<String, ServiceRegistration<DataItem>> itemRegs = new HashMap<String, ServiceRegistration<DataItem>> ();

    private final String delimiter = ".";

    public DataItemFactory ( final BundleContext context, final Executor executor, final String globalId )
    {
        this.executor = executor;
        this.context = context;
        this.globalId = globalId;
    }

    @Override
    public synchronized DataItemInputChained createInput ( final String localId, final Map<String, Variant> properties )
    {
        final DataItem item = this.items.get ( localId );
        if ( item == null )
        {
            final String id = getId ( localId );
            final DataItemInputChained newItem = new DataItemInputChained ( id, this.executor );
            registerItem ( newItem, localId, fixProperties ( properties ) );
            return newItem;
        }
        else
        {
            if ( item instanceof DataItemInputChained )
            {
                return (DataItemInputChained)item;
            }
            else
            {
                return null;
            }
        }
    }

    public synchronized WriteHandlerItem createOutput ( final String localId, final Map<String, Variant> properties, final WriteHandler writeHandler )
    {
        final DataItem item = this.items.get ( localId );
        if ( item == null )
        {
            final String id = getId ( localId );
            final WriteHandlerItem newItem = new WriteHandlerItem ( id, writeHandler, this.executor );
            registerItem ( newItem, localId, fixProperties ( properties ) );
            return newItem;
        }
        else
        {
            if ( item instanceof WriteHandlerItem )
            {
                return (WriteHandlerItem)item;
            }
            else
            {
                return null;
            }
        }
    }

    public synchronized AttributeWriteHandlerItem createOutput ( final String localId, final Map<String, Variant> properties, final AttributeWriteHandler writeHandler )
    {
        final DataItem item = this.items.get ( localId );
        if ( item == null )
        {
            final String id = getId ( localId );
            final AttributeWriteHandlerItem newItem = new AttributeWriteHandlerItem ( id, writeHandler, this.executor );
            registerItem ( newItem, localId, fixProperties ( properties ) );
            return newItem;
        }
        else if ( item instanceof AttributeWriteHandlerItem )
        {
            return (AttributeWriteHandlerItem)item;
        }
        else
        {
            return null;
        }
    }

    @Override
    public synchronized DataItemCommand createCommand ( final String localId, final Map<String, Variant> properties )
    {
        final DataItem item = this.items.get ( localId );
        if ( item == null )
        {
            final DataItemCommand newItem = new DataItemCommand ( getId ( localId ), this.executor );
            registerItem ( item, localId, fixProperties ( properties ) );
            return newItem;
        }
        else if ( item instanceof DataItemCommand )
        {
            return (DataItemCommand)item;
        }

        return null;
    }

    @Override
    public WriteHandlerItem createInputOutput ( final String localId, final Map<String, Variant> properties, final WriteHandler writeHandler )
    {
        return createOutput ( localId, properties, writeHandler );
    }

    private Map<String, Variant> fixProperties ( final Map<String, Variant> properties )
    {
        final Map<String, Variant> localProperties;
        if ( properties != null )
        {
            localProperties = properties;
        }
        else
        {
            localProperties = new HashMap<String, Variant> ( 0 );
        }
        return localProperties;
    }

    protected void registerItem ( final DataItem newItem, final String localId, final Map<String, Variant> properties )
    {
        final Dictionary<String, String> props = new Hashtable<String, String> ();

        fillProperties ( properties, props );

        final ServiceRegistration<DataItem> handle = this.context.registerService ( DataItem.class, newItem, props );
        this.items.put ( localId, newItem );
        this.itemRegs.put ( localId, handle );
    }

    protected void fillProperties ( final Map<String, Variant> properties, final Dictionary<String, String> props )
    {
        final Variant description = properties.get ( "description" );
        if ( description != null )
        {
            final String str = description.asString ( null );
            if ( str != null )
            {
                props.put ( Constants.SERVICE_DESCRIPTION, str );
            }
        }
    }

    protected String getId ( final String localId )
    {
        if ( this.globalId == null )
        {
            return localId;
        }
        else
        {
            return this.globalId + this.delimiter + localId;
        }
    }

    @Override
    public synchronized void disposeAllItems ()
    {
        for ( final ServiceRegistration<DataItem> reg : this.itemRegs.values () )
        {
            reg.unregister ();
        }
        this.items.clear ();
        this.itemRegs.clear ();
    }

    @Override
    public synchronized void disposeItem ( final DataItem dataItem )
    {
        // FIXME: do a quicker lookup of the item in question
        for ( final Map.Entry<String, DataItem> entry : this.items.entrySet () )
        {
            if ( entry.getValue () == dataItem )
            {
                this.items.remove ( entry.getKey () );
                final ServiceRegistration<DataItem> reg = this.itemRegs.remove ( entry.getKey () );
                reg.unregister ();
                return;
            }
        }
    }

    @Override
    public synchronized void dispose ()
    {
        disposeAllItems ();
    }
}
