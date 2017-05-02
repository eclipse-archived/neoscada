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
package org.eclipse.scada.core;

import java.util.HashMap;
import java.util.Map;

/**
 * provides a enumeration for all types of a variant
 * the ordinal values for each type are taken from Java's
 * serialization protocol
 * 
 * @author Juergen Rose &lt;juergen.rose@th4-systems.com&gt;
 */
public enum VariantType
{
    BOOLEAN ( (byte)'Z', Boolean.class ),
    INT32 ( (byte)'I', Integer.class ),
    INT64 ( (byte)'J', Long.class ),
    DOUBLE ( (byte)'D', Double.class ),
    STRING ( (byte)'t', String.class ),
    NULL ( (byte)'p', null ),
    UNKNOWN ( (byte)'s', Object.class );

    private byte type;

    private Class<?> clazz;

    private static final int approximateNumberOfTypes = 10;

    private static final Map<Byte, VariantType> values = new HashMap<Byte, VariantType> ( approximateNumberOfTypes );

    private static final Map<Class<?>, VariantType> valuesByClass = new HashMap<Class<?>, VariantType> ( approximateNumberOfTypes );

    static
    {
        for ( final VariantType t : VariantType.values () )
        {
            values.put ( t.toValue (), t );
            valuesByClass.put ( t.toJavaType (), t );
        }
    }

    /**
     * @param b
     *            ordinal value
     * @param clazz
     *            corresponding java class
     */
    VariantType ( final byte b, final Class<?> clazz )
    {
        this.type = b;
        this.clazz = clazz;
    }

    /**
     * converts ordinal value to corresponding VariantType
     * 
     * @param value
     * @return
     */
    public static VariantType fromValue ( final byte value )
    {
        return values.get ( value );
    }

    /**
     * @param clazz
     *            Java class
     * @return VariantType for given JavaType
     */
    public static VariantType fromJavaType ( final Class<?> clazz )
    {
        return valuesByClass.get ( clazz );
    }

    /**
     * @param object
     *            Object for which type is to determine
     * @return VariantType equivalent for class of given Java object
     */
    public static VariantType fromJavaObject ( final Object object )
    {
        return object == null ? NULL : fromJavaType ( object.getClass () );
    }

    /**
     * @return underlying ordinal value
     */
    public byte toValue ()
    {
        return this.type;
    }

    /**
     * @return equivalent Java Type
     */
    public Class<? extends Object> toJavaType ()
    {
        return this.clazz;
    }
}
