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

import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.DataItemCommand;
import org.eclipse.scada.da.server.common.DataItemInformationBase;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.common.chain.WriteHandler;
import org.eclipse.scada.da.server.common.chain.WriteHandlerItem;

/**
 * This item factory only creates the items but does not register them anywhere
 * 
 * @author Jens Reimann
 */
public class CommonItemFactory implements ItemFactory
{
    protected static final String DEFAULT_ID_DELIMITER = ".";

    private String baseId = null;

    private String idDelimiter = DEFAULT_ID_DELIMITER;

    protected Map<String, DataItem> itemMap = new HashMap<String, DataItem> ();

    private final Set<ItemFactory> factorySet = new HashSet<ItemFactory> ();

    private boolean disposed = false;

    private final CommonItemFactory parentItemFactory;

    private final Executor executor;

    public CommonItemFactory ( final Executor executor )
    {
        this ( executor, null, null, DEFAULT_ID_DELIMITER );
    }

    public CommonItemFactory ( final Executor executor, final CommonItemFactory parentItemFactory, final String baseId, final String idDelimiter )
    {
        this.executor = executor;
        this.parentItemFactory = parentItemFactory;
        if ( parentItemFactory != null )
        {
            parentItemFactory.addSubFactory ( this );
        }

        this.idDelimiter = idDelimiter;

        if ( this.idDelimiter == null )
        {
            this.idDelimiter = DEFAULT_ID_DELIMITER;
        }

        if ( parentItemFactory != null )
        {
            this.baseId = parentItemFactory.getBaseId () + this.idDelimiter + baseId;
        }
        else
        {
            this.baseId = baseId;
        }
    }

    /**
     * Change the ID delimiter.
     * <p>
     * Note that items which have already been created will not but updated to
     * use the new delimiter
     * 
     * @param idDelimiter
     *            the new delimiter to use
     */
    public void setIdDelimiter ( final String idDelimiter )
    {
        if ( idDelimiter == null )
        {
            this.idDelimiter = DEFAULT_ID_DELIMITER;
        }
        else
        {
            this.idDelimiter = idDelimiter;
        }
    }

    public boolean isDisposed ()
    {
        return this.disposed;
    }

    /**
     * Generate a global Id by using the base id and the local id
     * 
     * @param localId
     *            the local id
     * @return the global id
     */
    protected String generateId ( final String localId )
    {
        if ( this.baseId == null )
        {
            return localId;
        }
        else
        {
            return this.baseId + this.idDelimiter + localId;
        }
    }

    private void registerItem ( final DataItem newItem )
    {
        final DataItem oldItem = this.itemMap.put ( newItem.getInformation ().getName (), newItem );
        if ( oldItem != null )
        {
            disposeItem ( oldItem );
        }
    }

    protected DataItemCommand constructCommand ( final String localId )
    {
        final DataItemCommand commandItem = new DataItemCommand ( generateId ( localId ), this.executor );
        registerItem ( commandItem );
        return commandItem;
    }

    protected DataItemInputChained constructInput ( final String localId )
    {
        final DataItemInputChained inputItem = new DataItemInputChained ( generateId ( localId ), this.executor );
        registerItem ( inputItem );
        return inputItem;
    }

    protected WriteHandlerItem constructInputOutput ( final String localId, final WriteHandler writeHandler )
    {
        final WriteHandlerItem ioItem = new WriteHandlerItem ( generateId ( localId ), writeHandler, this.executor );
        registerItem ( ioItem );
        return ioItem;
    }

    protected WriteHandlerItem constructWriteHandler ( final String localId, final WriteHandler writeHandler )
    {
        final WriteHandlerItem item = new WriteHandlerItem ( new DataItemInformationBase ( generateId ( localId ), EnumSet.of ( IODirection.OUTPUT ) ), writeHandler, this.executor );
        registerItem ( item );
        return item;
    }

    @Override
    public void dispose ()
    {
        if ( isDisposed () )
        {
            return;
        }

        this.disposed = true;

        if ( this.parentItemFactory != null )
        {
            this.parentItemFactory.removeSubFactory ( this );
        }

        disposeAllItems ();

        // make a copy so that we can iterate over it and remove factories 
        final Set<ItemFactory> factoryMap = new HashSet<ItemFactory> ( this.factorySet );

        for ( final ItemFactory factory : factoryMap )
        {
            factory.dispose ();
        }

        this.factorySet.clear ();
    }

    /**
     * Dispose all items but not the factory itself
     */
    @Override
    public void disposeAllItems ()
    {
        this.itemMap.clear ();
    }

    @Override
    public void disposeItem ( final DataItem item )
    {
        this.itemMap.remove ( item.getInformation ().getName () );
    }

    @Override
    public DataItemCommand createCommand ( final String localId, final Map<String, Variant> properties )
    {
        return constructCommand ( localId );
    }

    @Override
    public DataItemInputChained createInput ( final String localId, final Map<String, Variant> properties )
    {
        return constructInput ( localId );
    }

    @Override
    public WriteHandlerItem createOutput ( final String localId, final Map<String, Variant> properties, final WriteHandler writeHandler )
    {
        return constructWriteHandler ( localId, writeHandler );
    }

    @Override
    public WriteHandlerItem createInputOutput ( final String localId, final Map<String, Variant> properties, final WriteHandler writeHandler )
    {
        return constructInputOutput ( localId, writeHandler );
    }

    public String getBaseId ()
    {
        return this.baseId;
    }

    public boolean addSubFactory ( final ItemFactory itemFactory )
    {
        return this.factorySet.add ( itemFactory );
    }

    public boolean removeSubFactory ( final ItemFactory itemFactory )
    {
        return this.factorySet.remove ( itemFactory );
    }
}
