/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.simulation.component.modules;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.browser.common.query.ItemDescriptor;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.DataItemCommand;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.simulation.component.Hive;

public class BaseModule
{
    private Hive hive = null;

    private String base = null;

    private final Map<String, DataItem> items = new HashMap<String, DataItem> ();

    public BaseModule ( final Hive hive, final String base )
    {
        this.hive = hive;
        this.base = base;
    }

    public void dispose ()
    {
        for ( final DataItem item : this.items.values () )
        {
            this.hive.unregisterItem ( item );
            this.hive.getStorage ().removed ( new ItemDescriptor ( item, new HashMap<String, Variant> () ) );
        }
        this.items.clear ();
    }

    protected DataItemInputChained getInput ( final String name, final Map<String, Variant> attributes )
    {
        final String id = getItemId ( name );

        final DataItem dataItem = this.items.get ( name );
        if ( dataItem != null )
        {
            if ( dataItem instanceof DataItemInputChained )
            {
                return (DataItemInputChained)dataItem;
            }
            else
            {
                throw new ItemAlreadyRegisteredException ( name );
            }
        }

        final DataItemInputChained item = new DataItemInputChained ( id, this.hive.getOperationService () );
        this.items.put ( name, item );
        this.hive.registerItem ( item );

        final ItemDescriptor idesc = new ItemDescriptor ( item, attributes );
        this.hive.getStorage ().added ( idesc );
        return item;
    }

    protected DataItemCommand getOutput ( final String name, final Map<String, Variant> attributes )
    {
        final String id = getItemId ( name );

        final DataItem dataItem = this.items.get ( name );
        if ( dataItem != null )
        {
            if ( dataItem instanceof DataItemCommand )
            {
                return (DataItemCommand)dataItem;
            }
            else
            {
                throw new ItemAlreadyRegisteredException ( name );
            }
        }

        final DataItemCommand item = new DataItemCommand ( id, this.hive.getOperationService () );
        this.items.put ( name, item );
        this.hive.registerItem ( item );

        final ItemDescriptor idesc = new ItemDescriptor ( item, attributes );
        this.hive.getStorage ().added ( idesc );
        return item;
    }

    private String getItemId ( final String name )
    {
        return this.base + "." + name;
    }
}
