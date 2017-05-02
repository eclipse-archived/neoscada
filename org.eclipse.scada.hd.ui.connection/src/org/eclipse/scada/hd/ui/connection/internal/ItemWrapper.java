/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - allow dragging items with type ID
 *******************************************************************************/
package org.eclipse.scada.hd.ui.connection.internal;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.scada.hd.data.HistoricalItemInformation;
import org.eclipse.scada.hd.ui.connection.data.Item;
import org.eclipse.scada.hd.ui.connection.data.Item.Type;
import org.eclipse.ui.views.properties.IPropertySource;

public class ItemWrapper extends PlatformObject implements IAdaptable
{
    enum Properties
    {
        CONNECTION_URI,
        ITEM_ID
    }

    private final ConnectionWrapper connection;

    private final HistoricalItemInformation itemInformation;

    public ItemWrapper ( final ConnectionWrapper connection, final HistoricalItemInformation itemInformation )
    {
        this.connection = connection;
        this.itemInformation = itemInformation;
    }

    public HistoricalItemInformation getItemInformation ()
    {
        return this.itemInformation;
    }

    public ConnectionWrapper getConnection ()
    {
        return this.connection;
    }

    @Override
    @SuppressWarnings ( "rawtypes" )
    public Object getAdapter ( final Class adapter )
    {
        if ( adapter == IPropertySource.class )
        {
            return new ItemPropertySource ( this );
        }
        else if ( adapter == Item.class )
        {
            return makeItem ();
        }
        return super.getAdapter ( adapter );
    }

    protected Item makeItem ()
    {
        final String serviceId = this.connection.getDescriptor ().getServiceId ();
        if ( serviceId != null )
        {
            return new Item ( serviceId, this.itemInformation.getItemId (), Type.ID );
        }
        else
        {
            return new Item ( this.connection.getService ().getConnection ().getConnectionInformation ().toString (), this.itemInformation.getItemId (), Type.URI );
        }
    }
}
