/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.component.script;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.component.script.ScriptContext.Item;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.osgi.framework.Constants;

public class ItemWrapper implements Item
{

    private final DataItemInputChained dataItem;

    private final ObjectPoolImpl<DataItem> objectPool;

    public ItemWrapper ( final ObjectPoolImpl<DataItem> objectPool, final DataItemInputChained dataItem, final Map<String, Variant> attributes )
    {
        this.dataItem = dataItem;
        this.objectPool = objectPool;

        final Dictionary<String, Object> properties = new Hashtable<String, Object> ();

        // not quite all attributes, be we tried
        if ( attributes.containsKey ( "description" ) )
        {
            properties.put ( Constants.SERVICE_DESCRIPTION, attributes.get ( "description" ).asString ( "" ) );
        }

        this.objectPool.addService ( dataItem.getInformation ().getName (), dataItem, properties );
    }

    @Override
    public String getItemId ()
    {
        return this.dataItem.getInformation ().getName ();
    }

    @Override
    public void updateData ( final Variant value, final Map<String, Variant> attributes, final AttributeMode attributeMode )
    {
        this.dataItem.updateData ( value, attributes, attributeMode );
    }

    @Override
    public void dispose ()
    {
        this.objectPool.removeService ( this.dataItem.getInformation ().getName (), this.dataItem );
    }

}
