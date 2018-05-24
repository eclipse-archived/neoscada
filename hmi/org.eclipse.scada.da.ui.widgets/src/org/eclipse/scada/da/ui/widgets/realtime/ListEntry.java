/*******************************************************************************
 * Copyright (c) 2010, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - clean up
 *******************************************************************************/
package org.eclipse.scada.da.ui.widgets.realtime;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.core.ui.styles.StateStyler;
import org.eclipse.scada.core.ui.styles.StyleBlinker;
import org.eclipse.scada.core.ui.styles.StyleBlinker.CurrentStyle;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.ui.connection.data.DataItemHolder;
import org.eclipse.scada.da.ui.connection.data.DataSourceListener;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.styles.DataItemValueStateExtractor;
import org.eclipse.scada.da.ui.widgets.internal.Activator;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListEntry extends Observable implements IAdaptable, IPropertySource, DataSourceListener
{

    private final static Logger logger = LoggerFactory.getLogger ( ListEntry.class );

    private enum Properties
    {
        ITEM_ID,
        CONNECTION_URI,
        VALUE,
        SUBSCRIPTION_STATE
    };

    private DataItemHolder dataItem;

    private Item item;

    private DataItemValue value;

    private final StateStyler styler;

    private final StyleBlinker blinker;

    private CurrentStyle currentStyle = CurrentStyle.EMPTY;

    public ListEntry ()
    {
        this.blinker = new StyleBlinker () {

            @Override
            public void update ( final CurrentStyle style )
            {
                handleStyleUpdate ( style );
            }
        };
        this.styler = new StateStyler ( this.blinker );
    }

    public Item getItem ()
    {
        return this.item;
    }

    public DataItemHolder getDataItem ()
    {
        return this.dataItem;
    }

    public synchronized void setDataItem ( final Item item )
    {
        clear ();
        this.item = item;
        this.dataItem = new DataItemHolder ( Activator.getDefault ().getBundle ().getBundleContext (), item, this );
    }

    public void dispose ()
    {
        this.styler.dispose ();
        this.blinker.dispose ();
        clear ();
    }

    public synchronized void clear ()
    {
        this.item = null;
        if ( this.dataItem != null )
        {
            this.dataItem.dispose ();
        }
    }

    public DataItemValue getItemValue ()
    {
        final DataItemValue value = this.value;
        if ( value != null )
        {
            return value;
        }
        else
        {
            return DataItemValue.DISCONNECTED;
        }
    }

    public Variant getValue ()
    {
        if ( this.value == null )
        {
            return Variant.NULL;
        }
        return this.value.getValue ();
    }

    public SubscriptionState getSubscriptionState ()
    {
        if ( this.value == null )
        {
            return SubscriptionState.DISCONNECTED;
        }
        return this.value.getSubscriptionState ();
    }

    public synchronized List<AttributePair> getAttributes ()
    {
        if ( this.value == null )
        {
            return new LinkedList<AttributePair> ();
        }

        final List<AttributePair> pairs = new ArrayList<AttributePair> ( this.value.getAttributes ().size () );
        for ( final Map.Entry<String, Variant> entry : this.value.getAttributes ().entrySet () )
        {
            pairs.add ( new AttributePair ( this.item, entry.getKey (), entry.getValue () ) );
        }
        return pairs;
    }

    /**
     * check if attributes are in the list
     * 
     * @return <code>true</code> if the attributes list is not empty
     */
    public synchronized boolean hasAttributes ()
    {
        if ( this.value == null )
        {
            return false;
        }
        return !this.value.getAttributes ().isEmpty ();
    }

    public Throwable getSubscriptionError ()
    {
        if ( this.value == null )
        {
            return null;
        }
        return this.value.getSubscriptionError ();
    }

    @Override
    public void updateData ( final DataItemValue value )
    {
        this.value = value;
        this.styler.style ( new DataItemValueStateExtractor ( value ) );
        setChanged ();
        notifyObservers ( value );
    }

    protected void handleStyleUpdate ( final CurrentStyle style )
    {
        this.currentStyle = style;
        setChanged ();
        notifyObservers ( this.value );
    }

    public Image getImage ()
    {
        return this.currentStyle.image;
    }

    public Color getBackground ()
    {
        return this.currentStyle.background;
    }

    public Color getForeground ()
    {
        return this.currentStyle.foreground;
    }

    public Font getFont ()
    {
        return this.currentStyle.font;
    }

    @Override
    @SuppressWarnings ( "rawtypes" )
    public Object getAdapter ( final Class adapter )
    {
        logger.trace ( "Request adapter to : {}", adapter );

        if ( adapter == DataItemValue.class && this.value != null )
        {
            return this.value;
        }
        if ( adapter == Item.class && this.item != null )
        {
            return new Item ( this.item );
        }
        return null;
    }

    // IPropertySource Methods

    @Override
    public Object getEditableValue ()
    {
        return this.item.getId ();
    }

    @Override
    public IPropertyDescriptor[] getPropertyDescriptors ()
    {
        final List<IPropertyDescriptor> result = new LinkedList<IPropertyDescriptor> ();

        {
            final PropertyDescriptor pd = new PropertyDescriptor ( Properties.ITEM_ID, Messages.ListEntry_Property_Name_Id );
            pd.setCategory ( Messages.ListEntry_Property_Category_Id );
            pd.setAlwaysIncompatible ( true );
            result.add ( pd );
        }
        {
            final PropertyDescriptor pd = new PropertyDescriptor ( Properties.CONNECTION_URI, Messages.ListEntry_Property_Name_Connection );
            pd.setCategory ( Messages.ListEntry_Property_Category_Connection );
            pd.setAlwaysIncompatible ( true );
            result.add ( pd );
        }
        {
            final PropertyDescriptor pd = new PropertyDescriptor ( Properties.VALUE, Messages.ListEntry_Property_Name_Value );
            pd.setCategory ( Messages.ListEntry_Property_Category_Value );
            pd.setAlwaysIncompatible ( true );
            result.add ( pd );
        }
        {
            final PropertyDescriptor pd = new PropertyDescriptor ( Properties.SUBSCRIPTION_STATE, Messages.ListEntry_Property_Name_Subscription );
            pd.setCategory ( Messages.ListEntry_Property_Category_State );
            pd.setAlwaysIncompatible ( true );
            result.add ( pd );
        }

        return result.toArray ( new IPropertyDescriptor[0] );
    }

    @Override
    public Object getPropertyValue ( final Object id )
    {
        if ( id instanceof Properties )
        {
            switch ( (Properties)id )
            {
                case ITEM_ID:
                    return this.item.getId ();
                case CONNECTION_URI:
                    return this.item.getConnectionString ();
                case VALUE:
                    return this.value;
                case SUBSCRIPTION_STATE:
                    if ( this.value == null )
                    {
                        return SubscriptionState.DISCONNECTED;
                    }
                    return this.value.getSubscriptionState ();
            }
        }
        return null;
    }

    @Override
    public boolean isPropertySet ( final Object id )
    {
        return false;
    }

    @Override
    public void resetPropertyValue ( final Object id )
    {
    }

    @Override
    public void setPropertyValue ( final Object id, final Object value )
    {
    }
}
