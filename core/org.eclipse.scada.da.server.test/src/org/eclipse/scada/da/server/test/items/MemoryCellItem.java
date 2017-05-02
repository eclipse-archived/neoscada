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
package org.eclipse.scada.da.server.test.items;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.AttributeManager;
import org.eclipse.scada.da.server.common.DataItemOutput;
import org.eclipse.scada.da.server.common.WriteAttributesHelper;
import org.eclipse.scada.da.server.common.chain.MemoryItemChained;
import org.eclipse.scada.da.server.test.Hive;
import org.eclipse.scada.utils.collection.MapBuilder;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public class MemoryCellItem extends DataItemOutput
{
    private final Hive hive;

    private Map<Integer, MemoryItemChained> items = new HashMap<Integer, MemoryItemChained> ();

    private AttributeManager attributes = null;

    private FolderCommon folder = null;

    public MemoryCellItem ( final Hive hive, final String name, final FolderCommon folder )
    {
        super ( name );
        this.hive = hive;
        this.folder = folder;

        this.attributes = new AttributeManager ( this );

        updateCells ( 0 );
    }

    @Override
    public Map<String, Variant> getAttributes ()
    {
        return this.attributes.getCopy ();
    }

    @Override
    public NotifyFuture<WriteAttributeResults> startSetAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        return new InstantFuture<WriteAttributeResults> ( WriteAttributesHelper.errorUnhandled ( null, attributes ) );
    }

    @Override
    public NotifyFuture<WriteResult> startWriteValue ( final Variant value, final OperationParameters operationParameters )
    {
        int num;
        try
        {
            num = value.asInteger ();
            updateCells ( num );
            return new InstantFuture<WriteResult> ( WriteResult.OK );
        }
        catch ( final Throwable e )
        {
            return new InstantErrorFuture<WriteResult> ( e );
        }
    }

    private void setSizeAttribute ( final int num )
    {
        this.attributes.update ( "size", Variant.valueOf ( num ) );
    }

    private void updateCells ( int num )
    {
        if ( num < 0 )
        {
            num = 0;
        }

        synchronized ( this.items )
        {
            final Map<Integer, MemoryItemChained> newItems = new HashMap<Integer, MemoryItemChained> ( num );

            int pos;
            for ( pos = 0; pos < num && pos < this.items.size (); pos++ )
            {
                if ( this.items.containsKey ( pos ) )
                {
                    newItems.put ( pos, this.items.get ( pos ) );
                    this.items.remove ( pos );
                }
            }

            for ( final Map.Entry<Integer, MemoryItemChained> entry : this.items.entrySet () )
            {
                this.folder.remove ( entry.getKey ().toString () );
                this.hive.unregisterItem ( entry.getValue () );
            }

            for ( int i = pos; i < num; i++ )
            {
                final MemoryItemChained item = new MemoryItemChained ( getInformation ().getName () + "-" + i );

                MemoryChainedItem.applyDefaultInputChain ( this.hive, item );

                this.hive.registerItem ( item );
                this.folder.add ( String.valueOf ( i ), item, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "Cell #" + i + " of " + num + " automaticall provided memory cells." ) ).getMap () );
                newItems.put ( i, item );
            }

            this.items = newItems;

            setSizeAttribute ( num );
        }
    }
}
