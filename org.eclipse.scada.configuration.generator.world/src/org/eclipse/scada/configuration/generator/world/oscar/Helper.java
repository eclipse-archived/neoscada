/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.generator.world.oscar;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.configuration.world.osgi.PropertyEntry;
import org.eclipse.scada.core.VariantType;

public final class Helper
{
    private Helper ()
    {
    }

    public static Map<String, String> makeAttributes ( final Collection<PropertyEntry> properties )
    {
        return makeAttributes ( null, properties );
    }

    public static Map<String, String> makeAttributes ( final String prefix, final Collection<PropertyEntry> properties )
    {
        final Map<String, String> result = new HashMap<> ();

        for ( final PropertyEntry entry : properties )
        {
            if ( prefix != null )
            {
                result.put ( prefix + entry.getKey (), entry.getValue () );
            }
            else
            {
                result.put ( entry.getKey (), entry.getValue () );
            }
        }

        return result;
    }

    /**
     * Add the entry if the value is not null or empty
     * 
     * @param data
     *            to which the key/value pair should be added
     * @param key
     *            the key
     * @param value
     *            the optional value
     */
    public static void addOptional ( final Map<String, String> data, final String key, final String value )
    {
        if ( value != null && !value.isEmpty () )
        {
            data.put ( key, value );
        }
    }

    public static void addOptional ( final Map<String, String> data, final String key, final Integer value )
    {
        if ( value != null )
        {
            data.put ( key, value.toString () );
        }
    }

    public static VariantType convert ( final DataType dataType )
    {
        if ( dataType == null )
        {
            return null;
        }

        switch ( dataType )
        {
            case BOOLEAN:
                return VariantType.BOOLEAN;
            case FLOAT:
                return VariantType.DOUBLE;
            case INT32:
                return VariantType.INT32;
            case INT64:
                return VariantType.INT64;
            case NULL:
                return VariantType.NULL;
            case STRING:
                return VariantType.STRING;
            case VARIANT:
                return null;
        }
        throw new IllegalStateException ( String.format ( "The data type %s is unknown", dataType ) );
    }

}
