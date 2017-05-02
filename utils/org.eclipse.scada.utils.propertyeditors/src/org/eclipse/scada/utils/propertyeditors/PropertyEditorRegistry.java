/*******************************************************************************
 * Copyright (c) 2006, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.propertyeditors;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author jrose
 */
public class PropertyEditorRegistry
{

    private final ConcurrentMap<String, PropertyEditor> propertyEditors = new ConcurrentHashMap<String, PropertyEditor> ();

    public PropertyEditorRegistry ()
    {
        this ( false );
    }

    public PropertyEditorRegistry ( final boolean fillWithDefault )
    {
        if ( fillWithDefault )
        {
            registerCustomEditor ( Boolean.class, new BooleanEditor () );
            registerCustomEditor ( boolean.class, new BooleanEditor () );
            registerCustomEditor ( Byte.class, new ByteEditor () );
            registerCustomEditor ( byte.class, new ByteEditor () );
            registerCustomEditor ( Double.class, new DoubleEditor () );
            registerCustomEditor ( double.class, new DoubleEditor () );
            registerCustomEditor ( Float.class, new FloatEditor () );
            registerCustomEditor ( float.class, new FloatEditor () );
            registerCustomEditor ( Integer.class, new IntegerEditor () );
            registerCustomEditor ( int.class, new IntegerEditor () );
            registerCustomEditor ( Long.class, new LongEditor () );
            registerCustomEditor ( long.class, new LongEditor () );
            registerCustomEditor ( Short.class, new ShortEditor () );
            registerCustomEditor ( short.class, new ShortEditor () );

            registerCustomEditor ( String.class, new StringEditor () );
            registerCustomEditor ( Date.class, new DateEditor () );
            registerCustomEditor ( UUID.class, new UUIDEditor () );
            registerCustomEditor ( Number.class, new NumberEditor () );
        }
    }

    public Map<String, PropertyEditor> getPropertyEditors ()
    {
        return Collections.unmodifiableMap ( this.propertyEditors );
    }

    /**
     * @param requiredType
     * @param propertyPath
     * @return
     */
    public PropertyEditor findCustomEditor ( final Class<?> requiredType, final String propertyPath )
    {
        // first try to find exact match
        String key = requiredType.getCanonicalName () + ":" + propertyPath;
        PropertyEditor pe = this.propertyEditors.get ( key );
        // 2nd: try to find for class only
        if ( pe == null )
        {
            key = requiredType.getCanonicalName () + ":";
            pe = this.propertyEditors.get ( key );
        }
        // 3rd: try to get internal
        if ( pe == null )
        {
            pe = PropertyEditorManager.findEditor ( requiredType );
        }
        return pe;
    }

    /**
     * @param requiredType
     * @return
     */
    public PropertyEditor findCustomEditor ( final Class<?> requiredType )
    {
        return findCustomEditor ( requiredType, "" );
    }

    /**
     * @param requiredType
     * @param propertyEditor
     */
    public final void registerCustomEditor ( final Class<?> requiredType, final PropertyEditor propertyEditor )
    {
        registerCustomEditor ( requiredType, "", propertyEditor );
    }

    /**
     * @param requiredType
     * @param propertyPath
     * @param propertyEditor
     */
    public void registerCustomEditor ( final Class<?> requiredType, final String propertyPath, final PropertyEditor propertyEditor )
    {
        final String key = requiredType.getCanonicalName () + ":" + propertyPath;
        this.propertyEditors.put ( key, propertyEditor );
    }
}
