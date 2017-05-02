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
package org.eclipse.scada.da.server.common.osgi.factory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.common.chain.item.ChainCreator;
import org.eclipse.scada.da.server.common.item.factory.ItemFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleObjectExporter<T>
{

    private final static Logger logger = LoggerFactory.getLogger ( SimpleObjectExporter.class );

    private final Class<? extends T> objectClass;

    private final ItemFactory factory;

    private final String prefix;

    private final Map<String, DataItemInputChained> itemMap = new HashMap<String, DataItemInputChained> ();

    public SimpleObjectExporter ( final Class<? extends T> objectClass, final ItemFactory factory, final String prefix )
    {
        this.objectClass = objectClass;
        this.factory = factory;
        this.prefix = prefix;

        createFields ();
        setValue ( null );
    }

    /**
     * Set the current value with default timestamp handling
     * 
     * @param value
     *            the new value to set
     */
    public void setValue ( final T value )
    {
        setValue ( value, false );
    }

    /**
     * Set the current value and apply the current timestamp to all values
     * <p>
     * All values will receive exactly the same timestamp
     * </p>
     * 
     * @param value
     *            the new value
     * @param forceTimestamp
     *            the flag whether to force a timestamp update for all values
     */
    public void setValue ( final T value, final boolean forceTimestamp )
    {
        final Long timestamp;
        if ( forceTimestamp )
        {
            timestamp = System.currentTimeMillis ();
        }
        else
        {
            timestamp = null;
        }

        try
        {
            final BeanInfo bi = Introspector.getBeanInfo ( this.objectClass );
            for ( final PropertyDescriptor pd : bi.getPropertyDescriptors () )
            {
                final DataItemInputChained item = this.itemMap.get ( pd.getName () );

                if ( value != null )
                {
                    try
                    {
                        final Object data = pd.getReadMethod ().invoke ( value );
                        setItemValue ( pd, item, data, timestamp );
                    }
                    catch ( final Exception e )
                    {
                        setItemError ( pd, item, e );
                    }
                }
                else
                {
                    setItemError ( pd, item, null );
                }

            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to set value" );
            for ( final DataItemInputChained item : this.itemMap.values () )
            {
                setItemError ( null, item, e );
            }
        }
    }

    private void setItemError ( final PropertyDescriptor pd, final DataItemInputChained item, final Exception e )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ();

        if ( pd != null )
        {
            fillAttributes ( pd, attributes );
        }

        if ( e != null )
        {
            attributes.put ( "invocation.error", Variant.TRUE );
            attributes.put ( "invocation.error.message", Variant.valueOf ( e.getMessage () ) );
        }
        else
        {
            attributes.put ( "null.error", Variant.TRUE );
        }

        item.updateData ( Variant.NULL, attributes, AttributeMode.SET );
    }

    private void fillAttributes ( final PropertyDescriptor pd, final Map<String, Variant> attributes )
    {
        attributes.put ( "property.name", Variant.valueOf ( pd.getName () ) );
        attributes.put ( "property.type", Variant.valueOf ( pd.getPropertyType ().getName () ) );
    }

    private void setItemValue ( final PropertyDescriptor pd, final DataItemInputChained item, final Object data, final Long timestamp )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ();

        fillAttributes ( pd, attributes );

        if ( timestamp != null )
        {
            attributes.put ( "timestamp", Variant.valueOf ( timestamp ) );
        }

        item.updateData ( Variant.valueOf ( data ), attributes, AttributeMode.SET );
    }

    private void createFields ()
    {
        try
        {
            final BeanInfo bi = Introspector.getBeanInfo ( this.objectClass );
            for ( final PropertyDescriptor pd : bi.getPropertyDescriptors () )
            {
                if ( pd.getReadMethod () != null )
                {
                    createDataItem ( pd );
                }
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to create fields", e );
        }
    }

    private void createDataItem ( final PropertyDescriptor pd )
    {
        final String name = pd.getName ();

        final Map<String, Variant> properties = new HashMap<String, Variant> ();
        if ( pd.getShortDescription () != null )
        {
            properties.put ( "description", Variant.valueOf ( pd.getShortDescription () ) );
        }
        else
        {
            properties.put ( "description", Variant.valueOf ( "Field: " + pd.getName () ) );
        }

        final DataItemInputChained item = this.factory.createInput ( this.prefix + "." + name, properties );

        ChainCreator.applyDefaultInputChain ( item );

        this.itemMap.put ( name, item );
    }
}
