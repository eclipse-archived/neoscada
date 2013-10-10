/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.common.item.factory;

import java.util.ArrayList;

import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.DataItemCommand;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.common.chain.WriteHandler;
import org.eclipse.scada.da.server.common.chain.WriteHandlerItem;
import org.eclipse.scada.da.server.common.impl.HiveCommon;

/**
 * This item factory creates the items and registers them in the hive
 * 
 * @author jens
 */
public class HiveItemFactory extends CommonItemFactory
{
    protected HiveCommon hive;

    public HiveItemFactory ( final HiveCommon hive )
    {
        super ( hive.getOperationService () );
        this.hive = hive;
    }

    public HiveItemFactory ( final CommonItemFactory parentItemFactory, final HiveCommon hive, final String baseId, final String idDelimiter )
    {
        super ( hive.getOperationService (), parentItemFactory, baseId, idDelimiter );
        this.hive = hive;
    }

    @Override
    protected DataItemCommand constructCommand ( final String localId )
    {
        final DataItemCommand item = super.constructCommand ( localId );
        this.hive.registerItem ( item );
        return item;
    }

    @Override
    protected WriteHandlerItem constructWriteHandler ( final String localId, final WriteHandler writeHandler )
    {
        final WriteHandlerItem item = super.constructWriteHandler ( localId, writeHandler );
        this.hive.registerItem ( item );
        return item;
    }

    @Override
    protected DataItemInputChained constructInput ( final String localId )
    {
        final DataItemInputChained item = super.constructInput ( localId );
        this.hive.registerItem ( item );
        return item;
    }

    @Override
    protected WriteHandlerItem constructInputOutput ( final String localId, final WriteHandler writeHandler )
    {
        final WriteHandlerItem item = super.constructInputOutput ( localId, writeHandler );
        this.hive.registerItem ( item );
        return item;
    }

    @Override
    public void disposeItem ( final DataItem item )
    {
        super.disposeItem ( item );
        this.hive.unregisterItem ( item );
    }

    @Override
    public void disposeAllItems ()
    {
        for ( final DataItem item : new ArrayList<DataItem> ( this.itemMap.values () ) )
        {
            this.hive.unregisterItem ( item );
        }
        super.disposeAllItems ();
    }
}
