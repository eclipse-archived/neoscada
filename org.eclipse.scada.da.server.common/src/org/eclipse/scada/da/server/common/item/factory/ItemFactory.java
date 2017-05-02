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

import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.DataItemCommand;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.common.chain.WriteHandler;
import org.eclipse.scada.da.server.common.chain.WriteHandlerItem;

public interface ItemFactory
{
    public abstract DataItemCommand createCommand ( String localId, Map<String, Variant> properties );

    public abstract DataItemInputChained createInput ( String localId, Map<String, Variant> properties );

    public abstract WriteHandlerItem createInputOutput ( String localId, Map<String, Variant> properties, WriteHandler writeHandler );

    public abstract WriteHandlerItem createOutput ( String localId, Map<String, Variant> properties, WriteHandler writeHandler );

    /**
     * Dispose an item if it was created by this factory
     * <p>
     * If the item was not created by this factory or was already disposed this
     * is no error and no exception is thrown
     * </p>
     * 
     * @param dataItem
     *            data item to dispose
     */
    public abstract void disposeItem ( DataItem dataItem );

    /**
     * Dispose the factory
     * <p>
     * All items that where created by this factory and where not disposed up to
     * now are being disposed
     * </p>
     * <p>
     * After a call to this method it is not possible to create new items.
     * Multiple calls to {@link #dispose()} or calls to
     * {@link #disposeAllItems()} are possible.
     * </p>
     */
    public abstract void dispose ();

    /**
     * Dispose all items at once
     * <p>
     * After a call to this method it is still possible to create new items
     * </p>
     */
    public abstract void disposeAllItems ();

}
