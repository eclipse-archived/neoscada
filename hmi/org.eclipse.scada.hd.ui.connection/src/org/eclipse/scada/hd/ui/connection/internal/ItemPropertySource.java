/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.ui.connection.internal;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.scada.hd.ui.connection.internal.ItemWrapper.Properties;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

final class ItemPropertySource implements IPropertySource
{

    private final ItemWrapper itemWrapper;

    public ItemPropertySource ( final ItemWrapper itemWrapper )
    {
        this.itemWrapper = itemWrapper;
    }

    @Override
    public void setPropertyValue ( final Object id, final Object value )
    {
    }

    @Override
    public void resetPropertyValue ( final Object id )
    {
    }

    @Override
    public boolean isPropertySet ( final Object id )
    {
        return false;
    }

    @Override
    public Object getPropertyValue ( final Object id )
    {
        if ( id instanceof Properties )
        {
            switch ( (Properties)id )
            {
                case CONNECTION_URI:
                    return this.itemWrapper.getConnection ().getService ().getConnection ().getConnectionInformation ().toString ();
                case ITEM_ID:
                    return this.itemWrapper.getItemInformation ().getItemId ();
            }
        }
        else if ( id instanceof String )
        {
            return this.itemWrapper.getItemInformation ().getAttributes ().get ( id ).toLabel ();
        }
        return null;
    }

    @Override
    public IPropertyDescriptor[] getPropertyDescriptors ()
    {
        final Collection<IPropertyDescriptor> result = new ArrayList<IPropertyDescriptor> ();

        PropertyDescriptor p;

        p = new PropertyDescriptor ( Properties.CONNECTION_URI, Messages.ItemPropertySource_Connection_URI_Label );
        p.setCategory ( Messages.ItemPropertySource_Connection_Category );
        result.add ( p );

        p = new PropertyDescriptor ( Properties.ITEM_ID, Messages.ItemPropertySource_Item_ID_Label );
        p.setCategory ( Messages.ItemPropertySource_Item_Category );
        result.add ( p );

        for ( final String key : this.itemWrapper.getItemInformation ().getAttributes ().keySet () )
        {
            p = new PropertyDescriptor ( key, key );
            p.setCategory ( Messages.ItemPropertySource_Item_Attributes_Category );
            result.add ( p );
        }

        return result.toArray ( new IPropertyDescriptor[0] );
    }

    @Override
    public Object getEditableValue ()
    {
        return null;
    }
}