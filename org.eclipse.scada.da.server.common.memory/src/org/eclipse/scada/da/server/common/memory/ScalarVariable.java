/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - refactor for generic memory devices
 *******************************************************************************/
package org.eclipse.scada.da.server.common.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.core.WriteAttributeResult;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.osgi.pool.ManageableObjectPool;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.chain.item.SumAlarmChainItem;
import org.eclipse.scada.da.server.common.chain.item.SumErrorChainItem;
import org.eclipse.scada.da.server.common.chain.item.SumPatternAttributesChainItem;
import org.osgi.framework.BundleContext;

public abstract class ScalarVariable implements Variable
{
    private final String name;

    protected final int index;

    private final Executor executor;

    protected MemoryDeviceDataitem item;

    private final Attribute[] attributes;

    private int offset;

    protected MemoryRequestBlock block;

    private final ManageableObjectPool<DataItem> itemPool;

    public ScalarVariable ( final String name, final int index, final Executor executor, final ManageableObjectPool<DataItem> itemPool, final Attribute... attributes )
    {
        this.name = name;
        this.index = index;
        this.executor = executor;
        this.attributes = attributes;
        this.itemPool = itemPool;
    }

    @Override
    public void handleError ( final int errorCode )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ();

        for ( final Attribute attr : this.attributes )
        {
            attr.handleError ( attributes );
        }

        attributes.put ( "device.error", Variant.TRUE );
        attributes.put ( "device.error.code", Variant.valueOf ( errorCode ) );

        this.item.updateData ( Variant.NULL, attributes, AttributeMode.SET );
    }

    @Override
    public void handleDisconnect ()
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ();

        for ( final Attribute attr : this.attributes )
        {
            attr.handleError ( attributes );
        }

        attributes.put ( "communcation.error", Variant.TRUE );

        this.item.updateData ( Variant.NULL, attributes, AttributeMode.SET );
    }

    @Override
    public void handleFailure ( final Throwable e )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ();

        for ( final Attribute attr : this.attributes )
        {
            attr.handleError ( attributes );
        }

        attributes.put ( "generic.error", Variant.TRUE );
        attributes.put ( "generic.error.message", Variant.valueOf ( e.getMessage () ) );

        this.item.updateData ( Variant.NULL, attributes, AttributeMode.SET );
    }

    @Override
    public void start ( final String parentName, final BundleContext context, final MemoryRequestBlock block, final int offset )
    {
        this.offset = offset;
        this.block = block;

        for ( final Attribute attr : this.attributes )
        {
            attr.start ( block, offset );
        }

        String itemId;
        if ( parentName != null )
        {
            itemId = parentName + "." + this.name;
        }
        else
        {
            itemId = this.name;
        }
        this.item = new MemoryDeviceDataitem ( itemId, this.executor, this );

        this.item.addChainElement ( IODirection.INPUT, new SumAlarmChainItem () );
        this.item.addChainElement ( IODirection.INPUT, new SumErrorChainItem () );
        this.item.addChainElement ( IODirection.INPUT, new SumPatternAttributesChainItem ( "manual", ".*\\.manual\\.active$" ) );

        this.itemPool.addService ( itemId, this.item, null );
        // this.handle = context.registerService ( DataItem.class.getName (), this.item, null );

    }

    protected NotifyFuture<WriteResult> handleWrite ( final Variant value )
    {
        return new InstantErrorFuture<WriteResult> ( new IllegalStateException ( "Operation not implemented" ) );
    }

    @Override
    public void stop ( final BundleContext context )
    {
        for ( final Attribute attr : this.attributes )
        {
            attr.stop ();
        }

        this.itemPool.removeService ( this.item.getInformation ().getName (), this.item );

    }

    protected abstract Variant extractValue ( IoBuffer data, Map<String, Variant> attributes );

    @Override
    public void handleData ( final IoBuffer data, final Variant timestamp )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ();

        final Variant value = extractValue ( data, attributes );

        for ( final Attribute attr : this.attributes )
        {
            attr.handleData ( data, attributes, timestamp );
        }

        attributes.put ( "globalIndex", Variant.valueOf ( this.offset + this.index ) );

        this.item.updateData ( value, attributes, AttributeMode.SET );
    }

    protected int toAddress ( final int localAddress )
    {
        return this.offset + localAddress - this.block.getStartAddress ();
    }

    public Map<String, WriteAttributeResult> handleAttributes ( final Map<String, Variant> requests )
    {
        final Map<String, WriteAttributeResult> result = new HashMap<String, WriteAttributeResult> ();

        for ( final Map.Entry<String, Variant> entry : requests.entrySet () )
        {
            for ( final Attribute attr : this.attributes )
            {
                if ( attr.getName ().equals ( entry.getKey () ) )
                {
                    try
                    {
                        attr.handleWrite ( entry.getValue () );
                        result.put ( entry.getKey (), WriteAttributeResult.OK );
                    }
                    catch ( final Throwable e )
                    {
                        result.put ( entry.getKey (), new WriteAttributeResult ( e ) );
                    }
                }
            }
        }

        return result;
    }
}
