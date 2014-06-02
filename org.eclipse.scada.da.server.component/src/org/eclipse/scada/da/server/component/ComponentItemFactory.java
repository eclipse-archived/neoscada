/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.component;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.da.server.browser.common.query.ItemDescriptor;
import org.eclipse.scada.da.server.browser.common.query.ItemStorage;
import org.eclipse.scada.da.server.common.DataItemInformationBase;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComponentItemFactory
{
    private final static Logger logger = LoggerFactory.getLogger ( ComponentItemFactory.class );

    private final Hive hive;

    private final ItemStorage storage;

    private final String prefix;

    private final Map<String, org.eclipse.scada.da.server.browser.common.query.ItemDescriptor> items = new HashMap<> ();

    public ComponentItemFactory ( final Hive hive, final ItemStorage storage, final String prefix )
    {
        this.hive = hive;
        this.storage = storage;
        this.prefix = prefix;
    }

    public void dispose ()
    {
        for ( final org.eclipse.scada.da.server.browser.common.query.ItemDescriptor desc : this.items.values () )
        {
            this.storage.removed ( desc );
            this.hive.unregisterItem ( desc.getItem () );
        }
        this.items.clear ();
    }

    public DataItemInputChained createInput ( final String localId, final Map<String, Variant> attributes )
    {
        final DataItemInputChained item = new DataItemInputChained ( new DataItemInformationBase ( makeId ( localId ), EnumSet.of ( IODirection.INPUT ) ), this.hive.getOperationService () );

        final org.eclipse.scada.da.server.browser.common.query.ItemDescriptor desc = new org.eclipse.scada.da.server.browser.common.query.ItemDescriptor ( item, attributes );
        this.hive.registerItem ( item );
        this.storage.added ( desc );

        this.items.put ( localId, desc );

        return item;
    }

    private String makeId ( final String id )
    {
        return this.prefix + "." + id;
    }

    public void disposeItem ( final String localId )
    {
        logger.debug ( "Dispose item: {}", localId );

        final ItemDescriptor desc = this.items.remove ( localId );
        if ( desc == null )
        {
            logger.debug ( "Item not found" );
            return;
        }

        this.hive.unregisterItem ( desc.getItem () );
        this.storage.removed ( desc );
    }
}
