/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.common.exporter;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.core.NotConvertableException;
import org.eclipse.scada.core.NullValueException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.DataItemCommand;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.common.chain.WriteHandler;
import org.eclipse.scada.da.server.common.item.factory.ItemFactory;
import org.eclipse.scada.utils.lang.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractObjectExporter implements Disposable
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractObjectExporter.class );

    protected ItemFactory factory;

    protected final Map<String, DataItem> items = new HashMap<String, DataItem> ();

    protected final Map<String, Map<String, Variant>> attributes = new HashMap<String, Map<String, Variant>> ();

    private final boolean readOnly;

    private final boolean nullIsError;

    private final String prefix;

    /**
     * Create a new object factory
     * <p>
     * </p>
     * 
     * @param itemFactory
     *            the item factory to use
     * @param readOnly
     *            flag if all properties should be created read-only
     * @param nullIsError
     *            flag whether controls if <code>null</code> mean <q>error</q>
     * @param prefix
     *            a local item prefix
     */
    public AbstractObjectExporter ( final ItemFactory itemFactory, final boolean readOnly, final boolean nullIsError, final String prefix )
    {
        this.factory = itemFactory;
        this.readOnly = readOnly;
        this.nullIsError = nullIsError;
        this.prefix = prefix;
    }

    @Override
    public void dispose ()
    {
        this.factory.dispose ();
    }

    /**
     * create data items from the properties
     */
    protected void createDataItems ( final Class<?> targetClazz )
    {
        try
        {
            final BeanInfo bi = Introspector.getBeanInfo ( targetClazz );
            for ( final PropertyDescriptor pd : bi.getPropertyDescriptors () )
            {
                final DataItem item = createItem ( pd, targetClazz );
                this.items.put ( pd.getName (), item );

                final Map<String, Variant> itemAttributes = new HashMap<String, Variant> ();
                fillAttributes ( pd, itemAttributes );
                this.attributes.put ( pd.getName (), itemAttributes );

                initAttribute ( pd );
            }
        }
        catch ( final IntrospectionException e )
        {
            logger.info ( "Failed to read initial item", e );
        }
    }

    protected void updateItemsFromTarget ()
    {
        final Set<String> updatedAttributes = new HashSet<String> ();
        try
        {
            final Object target = getTarget ();
            if ( target != null )
            {
                final BeanInfo bi = Introspector.getBeanInfo ( target.getClass () );
                for ( final PropertyDescriptor pd : bi.getPropertyDescriptors () )
                {
                    updatedAttributes.add ( pd.getName () );
                    initAttribute ( pd );
                }
            }
        }
        catch ( final IntrospectionException e )
        {
            logger.info ( "Failed to read item", e );
        }

        for ( final String key : this.items.keySet () )
        {
            if ( !updatedAttributes.contains ( key ) )
            {
                updateAttribute ( key, null, null, getAdditionalAttributes () );
            }
        }
    }

    protected Map<String, Variant> getAdditionalAttributes ()
    {
        return null;
    }

    /**
     * read the initial value of the property
     * 
     * @param pd
     */
    protected void initAttribute ( final PropertyDescriptor pd )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ();
        fillAttributes ( pd, attributes );

        final Map<String, Variant> additionalAttributes = getAdditionalAttributes ();
        if ( additionalAttributes != null )
        {
            attributes.putAll ( additionalAttributes );
        }

        final Object target = getTarget ();

        final Method m = pd.getReadMethod ();
        if ( m != null )
        {
            try
            {
                if ( target != null )
                {
                    updateAttribute ( pd.getName (), m.invoke ( target ), null, attributes );
                }
                else
                {
                    updateAttribute ( pd.getName (), null, null, attributes );
                }
            }
            catch ( final Throwable e )
            {
                updateAttribute ( pd.getName (), null, e, attributes );
            }
        }
    }

    protected void fillAttributes ( final PropertyDescriptor pd, final Map<String, Variant> attributes )
    {
        attributes.put ( "property.writeable", Variant.valueOf ( pd.getWriteMethod () != null ) );
        attributes.put ( "property.readable", Variant.valueOf ( pd.getReadMethod () != null ) );
        attributes.put ( "property.bound", Variant.valueOf ( pd.isBound () ) );
        attributes.put ( "property.expert", Variant.valueOf ( pd.isExpert () ) );
        attributes.put ( "property.constrained", Variant.valueOf ( pd.isConstrained () ) );
        attributes.put ( "property.label", Variant.valueOf ( pd.getDisplayName () ) );
        attributes.put ( "property.type", Variant.valueOf ( pd.getPropertyType ().getName () ) );
        attributes.put ( "property.name", Variant.valueOf ( pd.getName () ) );
        attributes.put ( "description", Variant.valueOf ( pd.getShortDescription () ) );
    }

    /**
     * Find the annotation
     * <p>
     * The following search order processed
     * <ol>
     * <li>Check the field with the same name as the property, process through
     * all superclasses</li>
     * <li>Check the read method</li>
     * <li>Check the write method</li>
     * </ol>
     * </p>
     * 
     * @param pd
     *            the property descriptor to check
     * @param clazz
     *            class instance
     * @return the annotation or <code>null</code> if none was found
     */
    protected ItemName findAnnotation ( final PropertyDescriptor pd, final Class<?> clazz )
    {
        final String name = pd.getName ();

        try
        {
            final Field field = findField ( name, clazz );
            final ItemName itemName = field.getAnnotation ( ItemName.class );
            if ( itemName != null )
            {
                return itemName;
            }
        }
        catch ( final NoSuchFieldException e )
        {
        }

        if ( pd.getReadMethod () != null && pd.getReadMethod ().getAnnotation ( ItemName.class ) != null )
        {
            return pd.getReadMethod ().getAnnotation ( ItemName.class );
        }

        if ( pd.getWriteMethod () != null && pd.getWriteMethod ().getAnnotation ( ItemName.class ) != null )
        {
            return pd.getWriteMethod ().getAnnotation ( ItemName.class );
        }

        return null;
    }

    protected String makeItemName ( final PropertyDescriptor pd, final Class<?> clazz )
    {
        try
        {
            final ItemName itemName = findAnnotation ( pd, clazz );
            if ( itemName == null )
            {
                return addPrefix ( pd.getName () );
            }
            else
            {
                return addPrefix ( itemName.value () );
            }
        }
        catch ( final Exception e )
        {
            return addPrefix ( pd.getName () );
        }
    }

    private String addPrefix ( final String name )
    {
        if ( this.prefix == null )
        {
            return name;
        }
        else
        {
            return this.prefix + name;
        }
    }

    private Field findField ( final String name, final Class<?> clazz ) throws NoSuchFieldException
    {
        try
        {
            return clazz.getDeclaredField ( name );
        }
        catch ( final NoSuchFieldException e )
        {
            final Class<?> superClazz = clazz.getSuperclass ();
            if ( superClazz == null || superClazz == Object.class )
            {
                throw new NoSuchFieldException ( name );
            }
            return findField ( name, superClazz );
        }
    }

    private DataItem createItem ( final PropertyDescriptor pd, final Class<?> clazz )
    {
        final boolean writeable = !this.readOnly && pd.getWriteMethod () != null;
        final boolean readable = pd.getReadMethod () != null;

        final String itemName = makeItemName ( pd, clazz );

        final Map<String, Variant> properties = new HashMap<String, Variant> ();

        if ( pd.getShortDescription () != null )
        {
            properties.put ( "description", Variant.valueOf ( pd.getShortDescription () ) );
        }

        if ( writeable && readable )
        {
            return this.factory.createInputOutput ( itemName, properties, new WriteHandler () {

                @Override
                public void handleWrite ( final Variant value, final OperationParameters operationParameters ) throws Exception
                {
                    writeAttribute ( pd, value );
                }
            } );
        }
        else if ( readable )
        {
            return this.factory.createInput ( itemName, properties );
        }
        else if ( writeable )
        {
            final DataItemCommand item = this.factory.createCommand ( itemName, properties );
            item.addListener ( new DataItemCommand.Listener () {

                @Override
                public void command ( final Variant value ) throws Exception
                {
                    writeAttribute ( pd, value );
                }
            } );
            return item;
        }
        return null;
    }

    protected void updateAttribute ( final String propertyName, final Object newValue, final Throwable e, final Map<String, Variant> additionalAttributes )
    {
        final DataItem item = this.items.get ( propertyName );
        if ( item == null )
        {
            return;
        }

        if ( item instanceof DataItemInputChained )
        {
            final Map<String, Variant> attributes = new HashMap<String, Variant> ();

            final Map<String, Variant> itemAttributes = this.attributes.get ( propertyName );

            if ( itemAttributes != null )
            {
                attributes.putAll ( itemAttributes );
            }

            if ( additionalAttributes != null )
            {
                attributes.putAll ( additionalAttributes );
            }

            if ( e != null )
            {
                attributes.put ( "value.error", Variant.TRUE );
                attributes.put ( "value.error.message", Variant.valueOf ( e.getMessage () ) );
            }

            if ( this.nullIsError && newValue == null )
            {
                attributes.put ( "null.error", Variant.TRUE );
            }

            final DataItemInputChained inputItem = (DataItemInputChained)item;
            inputItem.updateData ( Variant.valueOf ( newValue ), attributes, AttributeMode.SET );
        }
    }

    /**
     * Get the current target or <code>null</code> if there is none
     * 
     * @return the current target
     */
    protected abstract Object getTarget ();

    protected void writeAttribute ( final PropertyDescriptor pd, final Variant value ) throws Exception
    {
        final Method m = pd.getWriteMethod ();
        if ( m == null )
        {
            throw new RuntimeException ( "Failed to write since write method cannot be found" );
        }

        final Object target = getTarget ();

        if ( target == null )
        {
            throw new RuntimeException ( "No current target attached" );
        }

        final Class<?> targetType = pd.getPropertyType ();
        final Object o = convertWriteType ( targetType, value );

        if ( o != null )
        {
            // try the direct approach
            m.invoke ( target, o );
        }
        else
        {
            // try a "by string" approach
            final PropertyEditor pe = PropertyEditorManager.findEditor ( targetType );
            pe.setAsText ( value.asString () );
        }

    }

    /**
     * Convert the value to the target type if possible.
     * 
     * @param targetType
     *            The expected target type
     * @param value
     *            the source value
     * @return an instance of the source value in the target type (if possible)
     *         or <code>null</code> otherwise
     * @throws NotConvertableException
     * @throws NullValueException
     */
    private Object convertWriteType ( final Class<?> targetType, final Variant value ) throws NullValueException, NotConvertableException
    {
        if ( targetType.isAssignableFrom ( Variant.class ) )
        {
            return value;
        }
        if ( value == null || value.isNull () )
        {
            return null;
        }

        if ( targetType.isAssignableFrom ( Long.class ) || targetType.isAssignableFrom ( long.class ) )
        {
            return value.asLong ();
        }
        if ( targetType.isAssignableFrom ( Integer.class ) || targetType.isAssignableFrom ( int.class ) )
        {
            return value.asInteger ();
        }
        if ( targetType.isAssignableFrom ( Double.class ) || targetType.isAssignableFrom ( double.class ) )
        {
            return value.asDouble ();
        }
        if ( targetType.isAssignableFrom ( Boolean.class ) || targetType.isAssignableFrom ( boolean.class ) )
        {
            return value.asBoolean ();
        }
        if ( targetType.isAssignableFrom ( String.class ) )
        {
            return value.asString ();
        }

        return null;
    }

}
