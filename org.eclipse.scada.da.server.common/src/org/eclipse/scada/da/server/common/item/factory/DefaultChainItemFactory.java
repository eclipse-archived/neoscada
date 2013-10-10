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

import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.chain.DataItemBaseChained;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.common.chain.WriteHandler;
import org.eclipse.scada.da.server.common.chain.WriteHandlerItem;
import org.eclipse.scada.da.server.common.chain.item.ChainCreator;
import org.eclipse.scada.da.server.common.impl.HiveCommon;

/**
 * An item factory with a default chain of item entries
 * <p>
 * In order to apply your own chain you may override
 * {@link #applyChain(DataItemBaseChained)}
 * 
 * @author Jens Reimann
 */
public class DefaultChainItemFactory extends FolderItemFactory
{

    public DefaultChainItemFactory ( final HiveCommon hive, final FolderCommon parentFolder, final String baseId, final String folderName )
    {
        super ( hive, parentFolder, baseId, folderName );
    }

    public DefaultChainItemFactory ( final CommonItemFactory parentFactory, final HiveCommon hive, final FolderCommon parentFolder, final String baseId, final String folderName, final String idDelimiter )
    {
        super ( parentFactory, hive, parentFolder, baseId, folderName, idDelimiter );
    }

    public DefaultChainItemFactory ( final CommonItemFactory parentFactory, final HiveCommon hive, final FolderCommon parentFolder, final String baseId, final String folderName )
    {
        super ( parentFactory, hive, parentFolder, baseId, folderName );
    }

    /**
     * Create a new sub factory
     * <p>
     * Sub-factories get disposed when the parent factory is disposed
     * </p>
     * 
     * @param name
     *            the name of the sub-factory, this will be the folder name and
     *            added to the item id as local part
     */
    @Override
    public DefaultChainItemFactory createSubFolderFactory ( final String name )
    {
        final DefaultChainItemFactory factory = new DefaultChainItemFactory ( this, this.hive, this.folder, name, name );
        addSubFactory ( factory );
        return factory;
    }

    @Override
    public DataItemInputChained constructInput ( final String localId )
    {
        final DataItemInputChained item = super.constructInput ( localId );

        applyChain ( item );

        return item;
    }

    @Override
    public WriteHandlerItem constructInputOutput ( final String localId, final WriteHandler writeHandler )
    {
        final WriteHandlerItem item = super.constructInputOutput ( localId, writeHandler );

        applyChain ( item );

        return item;
    }

    @Override
    protected WriteHandlerItem constructWriteHandler ( final String localId, final WriteHandler writeHandler )
    {
        final WriteHandlerItem item = super.constructWriteHandler ( localId, writeHandler );
        applyChain ( item );
        return item;
    }

    /**
     * Apply our chain of elements
     * 
     * @param item
     *            the item to which the chain should be applied
     */
    protected void applyChain ( final DataItemBaseChained item )
    {
        ChainCreator.applyDefaultInputChain ( item );
    }

}
