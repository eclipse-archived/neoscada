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

import java.io.Serializable;
import java.math.BigDecimal;

import org.eclipse.scada.utils.lang.Immutable;

/**
 * A variant data type that can hold any scalar value type.
 * 
 * @author Jens Reimann &lt;jens.reimann@th4-systems.com&gt;
 */
@Immutable
public class Variant implements Serializable, Comparable<Variant>
{

    private static final long serialVersionUID = 1L;

    /**
     * A default NULL instance
     */
    public static final Variant NULL = new Variant ();

    /**
     * A default BOOL#true instance
     */
    public static final Variant TRUE = new Variant ( true );

    /**
     * A default BOOL#false instance
     */
    public static final Variant FALSE = new Variant ( false );

    private static final int MAX_PRE_INSTANCES = 256;

    private static final Variant[] preIntInstances = new Variant[MAX_PRE_INSTANCES];

    private static final Variant[] preLongInstances = new Variant[MAX_PRE_INSTANCES];

    static
    {
        for ( int i = 0; i < preIntInstances.length; i++ )
        {
            preIntInstances[i] = new Variant ( i );
            preLongInstances[i] = new Variant ( (long)i );
        }
    }

    private static final VariantComparator comparator = new VariantComparator ();

    public static Variant valueOf ( final long value )
    {
        if ( value >= 0 && value < preLongInstances.length )
        {
            return preLongInstances[(int)value];
        }
        else
        {
            return new Variant ( value );
        }
    }

    public static Variant valueOf ( final int value )
    {
        if ( value >= 0 && value < preIntInstances.length )
        {
            return preIntInstances[value];
        }
        else
        {
            return new Variant ( value );
        }
    }

    public static Variant valueOf ( final double value )
    {
        return new Variant ( value );
    }

    public static Variant valueOf ( final boolean value )
    {
        return value ? TRUE : FALSE;
    }

    public static Variant valueOf ( final Object value )
    {
        if ( value == null )
        {
            return NULL;
        }
        if ( value instanceof Variant )
        {
            return (Variant)value;
        }
        if ( value instanceof Boolean )
        {
            return valueOf ( ( (Boolean)value ).booleanValue () );
        }
        if ( value instanceof Long )
        {
            return valueOf ( ( (Long)value ).longValue () );
        }
        if ( value instanceof Integer )
        {
            return valueOf ( ( (Integer)value ).intValue () );
        }
        if ( value instanceof Double )
        {
            return valueOf ( ( (Double)value ).doubleValue () );
        }
        return new Variant ( value );
    }

    private Serializable value;

    protected Variant ()
    {
    }

    protected Variant ( final Object object )
    {
        setValue ( object );
    }

    protected Variant ( final boolean value )
    {
        setValue ( value );
    }

    protected Variant ( final double value )
    {
        setValue ( value );
    }

    protected Variant ( final int value )
    {
        setValue ( value );
    }

    protected Variant ( final long value )
    {
        setValue ( value );
    }

    protected Variant ( final String value )
    {
        setValue ( value );
    }

    protected Variant ( final Variant other )
    {
        this ( other != null ? other.value : null );
    }

    public boolean isNull ()
    {
        return this.value == null;
    }

    /**
     * Set the value based on a known object type
     * <p>
     * If the value object is not know it is converted to a string
     * 
     * @param value
     *            the value to set
     */
    private void setValue ( final Object value )
    {
        if ( value == null )
        {
            this.value = null;
        }
        else if ( value instanceof Variant )
        {
            setValue ( ( (Variant)value ).value );
        }
        else if ( value instanceof Short )
        {
            setValue ( ( (Short)value ).intValue () );
        }
        else if ( value instanceof Long )
        {
            setValue ( ( (Long)value ).longValue () );
        }
        else if ( value instanceof Integer )
        {
            setValue ( ( (Integer)value ).intValue () );
        }
        else if ( value instanceof String )
        {
            setValue ( (String)value );
        }
        else if ( value instanceof Boolean )
        {
            setValue ( ( (Boolean)value ).booleanValue () );
        }
        else if ( value instanceof Double )
        {
            setValue ( ( (Double)value ).doubleValue () );
        }
        else if ( value instanceof Float )
        {
            setValue ( ( (Float)value ).doubleValue () );
        }
        else if ( value instanceof BigDecimal )
        {
            setValue ( ( (BigDecimal)value ).doubleValue () );
        }
        else if ( value instanceof Number )
        {
            setValue ( ( (Number)value ).longValue () );
        }
        else
        {
            setValue ( value.toString () );
        }
    }

    private void setValue ( final boolean value )
    {
        this.value = Boolean.valueOf ( value );
    }

    private void setValue ( final int value )
    {
        this.value = Integer.valueOf ( value );
    }

    private void setValue ( final long value )
    {
        this.value = Long.valueOf ( value );
    }

    private void setValue ( final String value )
    {
        if ( value != null )
        {
            this.value = value;
        }
        else
        {
            this.value = null;
        }
    }

    private void setValue ( final double value )
    {
        this.value = Double.valueOf ( value );
    }

    /**
     * Get the string representation of the variant value.
     * 
     * @return The string representation of the variant value.
     * @throws NullValueException
     *             thrown if the variant if of type {@link VariantType#NULL}
     */
    public String asString () throws NullValueException
    {
        if ( isNull () )
        {
            throw new NullValueException ();
        }

        return this.value.toString ();
    }

    /**
     * Get the string representation of the variant value or a default value if
     * the variant is of type {@link VariantType#NULL}.
     * 
     * @return The string representation of the variant value or the default
     *         value.
     */
    public String asString ( final String defaultValue )
    {
        if ( isNull () )
        {
            return defaultValue;
        }

        return this.value.toString ();
    }

    /**
     * @param defaultValue
     *            the default value
     * @return the value as a double or the default value if the value cannot be
     *         provided as a double
     */
    public Double asDouble ( final Double defaultValue )
    {
        try
        {
            return asDouble ();
        }
        catch ( final NullValueException e )
        {
            return defaultValue;
        }
        catch ( final NotConvertableException e )
        {
            return defaultValue;
        }
    }

    public double asDouble () throws NullValueException, NotConvertableException
    {
        if ( isNull () )
        {
            throw new NullValueException ();
        }

        try
        {
            if ( this.value instanceof Boolean )
            {
                return ( (Boolean)this.value ).booleanValue () ? 1.0 : 0.0;
            }
            if ( this.value instanceof Double )
            {
                return ( (Double)this.value ).doubleValue ();
            }
            if ( this.value instanceof Integer )
            {
                return ( (Integer)this.value ).doubleValue ();
            }
            if ( this.value instanceof Long )
            {
                return ( (Long)this.value ).doubleValue ();
            }
            if ( this.value instanceof String )
            {
                return Double.parseDouble ( (String)this.value );
            }
        }
        catch ( final NumberFormatException e )
        {
            throw new NotConvertableException ( this.value );
        }

        throw new NotConvertableException ( this.value );
    }

    /**
     * @param defaultValue
     *            the default value
     * @return the value as an integer or the default value if the value cannot
     *         be provided as an integer
     */
    public Integer asInteger ( final Integer defaultValue )
    {
        try
        {
            return asInteger ();
        }
        catch ( final NullValueException e )
        {
            return defaultValue;
        }
        catch ( final NotConvertableException e )
        {
            return defaultValue;
        }
    }

    public int asInteger () throws NullValueException, NotConvertableException
    {
        if ( isNull () )
        {
            throw new NullValueException ();
        }

        try
        {
            if ( this.value instanceof Boolean )
            {
                return ( (Boolean)this.value ).booleanValue () ? 1 : 0;
            }
            if ( this.value instanceof Double )
            {
                return ( (Double)this.value ).intValue ();
            }
            if ( this.value instanceof Integer )
            {
                return ( (Integer)this.value ).intValue ();
            }
            if ( this.value instanceof Long )
            {
                return ( (Long)this.value ).intValue ();
            }
            if ( this.value instanceof String )
            {
                return Integer.parseInt ( (String)this.value );
            }
        }
        catch ( final NumberFormatException e )
        {
            throw new NotConvertableException ( this.value );
        }

        throw new NotConvertableException ( this.value );
    }

    /**
     * @param defaultValue
     *            the default value
     * @return the value as a long or the default value if the value cannot be
     *         provided as a long
     */
    public Long asLong ( final Long defaultValue )
    {
        try
        {
            return asLong ();
        }
        catch ( final NullValueException e )
        {
            return defaultValue;
        }
        catch ( final NotConvertableException e )
        {
            return defaultValue;
        }
    }

    public long asLong () throws NullValueException, NotConvertableException
    {
        if ( isNull () )
        {
            throw new NullValueException ();
        }

        try
        {
            if ( this.value instanceof Boolean )
            {
                return ( (Boolean)this.value ).booleanValue () ? 1L : 0L;
            }
            if ( this.value instanceof Double )
            {
                return ( (Double)this.value ).longValue ();
            }
            if ( this.value instanceof Integer )
            {
                return ( (Integer)this.value ).longValue ();
            }
            if ( this.value instanceof Long )
            {
                return ( (Long)this.value ).longValue ();
            }
            if ( this.value instanceof String )
            {
                return Long.parseLong ( (String)this.value );
            }
        }
        catch ( final NumberFormatException e )
        {
            throw new NotConvertableException ( this.value );
        }

        throw new NotConvertableException ( this.value );
    }

    /**
     * Get the value as boolean value If the value is <code>null</code> then
     * <code>false</code> is returned. If the value is a boolean it will simply
     * return the value itself. If the value is a numeric
     * value (double, long, integer) is will return <code>false</code> if the
     * value zero and <code>true</code> otherwise. If the value is a string then
     * <code>false</code> is returned if the string is
     * empty. If the string can be converted to a number (long or double) it
     * will be compared to that number. Otherwise it will be compared case
     * insensitive against the string
     * 
     * <pre>
     * true
     * </pre>
     * 
     * .
     * 
     * @return The boolean value of this variant
     */
    public boolean asBoolean ()
    {
        try
        {
            if ( this.value == null )
            {
                return false;
            }
            if ( this.value instanceof Boolean )
            {
                return ( (Boolean)this.value ).booleanValue ();
            }
            if ( this.value instanceof Double )
            {
                return ( (Double)this.value ).doubleValue () != 0;
            }
            if ( this.value instanceof Integer )
            {
                return ( (Integer)this.value ).intValue () != 0;
            }
            if ( this.value instanceof Long )
            {
                return ( (Long)this.value ).longValue () != 0;
            }
            if ( this.value instanceof String )
            {
                final String str = (String)this.value;
                if ( str.length () == 0 )
                {
                    return false;
                }
                try
                {
                    final long i = Long.parseLong ( str );
                    return i != 0;
                }
                catch ( final NumberFormatException e )
                {
                }
                try
                {
                    final double i = Double.parseDouble ( str );
                    return i != 0;
                }
                catch ( final NumberFormatException e )
                {
                }
                return Boolean.parseBoolean ( str );
            }
        }
        catch ( final Exception e )
        {
        }
        return false;
    }

    /**
     * Return the value as boolean
     * 
     * @param defaultValue
     *            the default value
     * @return the value as a boolean or the default value if the value is null
     */
    public Boolean asBoolean ( final Boolean defaultValue )
    {
        if ( isNull () )
        {
            return defaultValue;
        }
        return asBoolean ();
    }

    /**
     * Convert the variant to a java object of the type specified by the
     * variantType parameter
     * <p>
     * The default value must be of the type of the variant type parameter,
     * otherwise a class cast exception will be thrown. The default value may
     * also be null.
     * </p>
     * 
     * @see #as(VariantType)
     * @param variantType
     *            the variant type to convert to (may be <code>null</code>)
     * @param defaultValue
     *            the default value in case the conversion fails or the variant
     *            is NULL
     * @return the resulting java object
     */
    public Serializable as ( final VariantType variantType, final Serializable defaultValue )
    {
        if ( variantType == null )
        {
            return getValue ();
        }

        switch ( variantType )
        {
            case BOOLEAN:
                return asBoolean ( (Boolean)defaultValue );
            case DOUBLE:
                return asDouble ( (Double)defaultValue );
            case INT32:
                return asInteger ( (Integer)defaultValue );
            case INT64:
                return asLong ( (Long)defaultValue );
            case STRING:
                return asString ( (String)defaultValue );
            case NULL:
                return null;
            case UNKNOWN:
                return getValue ();
        }
        return getValue ();
    }

    /**
     * Convert the variant to a java object of the type specified by the
     * variantType parameter
     * <p>
     * The method converts the current variant to a plain java
     * {@link Serializable} of the requested type. For the list of types than
     * can be expected see the java type field of {@link VariantType}.
     * </p>
     * <p>
     * There are some special cases for this method:
     * <ul>
     * <li>If the parameter variantType is null the java object currently set
     * will be returned without any conversion</li>
     * <li>If the variant type {@link VariantType#UNKNOWN} is requested the java
     * object currently set will be returned without any conversion</li>
     * <li>If the {@link VariantType#NULL} is requested always <code>null</code>
     * will be returned
     * </ul>
     * </p>
     * 
     * @param variantType
     *            the target type
     * @return the resulting java object
     * @throws NullValueException
     *             in case the variant was of type null and should be converted
     *             to some other type
     * @throws NotConvertableException
     *             in case the variant cannot be converted to the target value
     */
    public Serializable as ( final VariantType variantType ) throws NullValueException, NotConvertableException
    {
        if ( variantType == null )
        {
            return getValue ();
        }

        switch ( variantType )
        {
            case BOOLEAN:
                return asBoolean ();
            case DOUBLE:
                return asDouble ();
            case INT32:
                return asInteger ();
            case INT64:
                return asLong ();
            case STRING:
                return asString ();
            case NULL:
                return null;
            case UNKNOWN:
                return getValue ();
        }
        return getValue ();
    }

    public boolean isBoolean ()
    {
        if ( isNull () )
        {
            return false;
        }

        return this.value instanceof Boolean;
    }

    public boolean isString ()
    {
        if ( isNull () )
        {
            return false;
        }

        return this.value instanceof String;
    }

    public boolean isDouble ()
    {
        if ( isNull () )
        {
            return false;
        }

        return this.value instanceof Double;
    }

    public boolean isInteger ()
    {
        if ( isNull () )
        {
            return false;
        }

        return this.value instanceof Integer;
    }

    public boolean isLong ()
    {
        if ( isNull () )
        {
            return false;
        }

        return this.value instanceof Long;
    }

    public boolean isNumber ()
    {
        if ( isNull () )
        {
            return false;
        }

        return this.value instanceof Number;
    }

    @Override
    public boolean equals ( final Object obj )
    {
        if ( ! ( obj instanceof Variant ) )
        {
            // also catches null case
            return false;
        }

        if ( obj == this )
        {
            return true;
        }

        final Variant other = (Variant)obj;

        try
        {
            if ( other.isNull () )
            {
                return isNull ();
            }
            else if ( isNull () )
            {
                return other.isNull ();
            }
            else if ( other.isBoolean () )
            {
                return compareToBoolean ( other.asBoolean () );
            }
            else if ( other.isDouble () )
            {
                return compareToDouble ( other.asDouble () );
            }
            else if ( other.isLong () )
            {
                return compareToLong ( other.asLong () );
            }
            else if ( other.isInteger () )
            {
                return compareToInteger ( other.asInteger () );
            }
            else if ( other.isString () )
            {
                return compareToString ( other.asString () );
            }

            return false;
        }
        catch ( final NullValueException e )
        {
            // should never happen since we check using isNull()
            return false;
        }
        catch ( final NotConvertableException e )
        {
            // if it cannot be converted it should not be equal
            return false;
        }
    }

    @Override
    public int hashCode ()
    {
        if ( this.value == null )
        {
            return 31;
        }
        return this.value.hashCode ();
    }

    private boolean compareToString ( final String s )
    {
        if ( isNull () )
        {
            return false;
        }

        try
        {
            if ( isDouble () )
            {
                return asDouble () == Double.parseDouble ( s );
            }
            else if ( isBoolean () )
            {
                return asBoolean () == new Variant ( s ).asBoolean ();
            }
            else if ( isLong () )
            {
                return asLong () == Long.parseLong ( s );
            }
            else if ( isInteger () )
            {
                return asInteger () == Integer.parseInt ( s );
            }
            else
            {
                return asString ().equals ( s );
            }
        }
        catch ( final Exception e )
        {
            return false;
        }
    }

    private boolean compareToInteger ( final int i )
    {
        if ( isNull () )
        {
            return false;
        }

        try
        {
            if ( isDouble () )
            {
                return asDouble () == i;
            }
            else if ( isBoolean () )
            {
                return asBoolean () ? i != 0 : i == 0;
            }
            else if ( isLong () )
            {
                return asLong () == i;
            }
            else
            {
                return asInteger () == i;
            }
        }
        catch ( final Exception e )
        {
            return false;
        }
    }

    private boolean compareToLong ( final long l )
    {
        if ( isNull () )
        {
            return false;
        }

        try
        {
            if ( isDouble () )
            {
                return asDouble () == l;
            }
            else if ( isBoolean () )
            {
                return asBoolean () ? l != 0 : l == 0;
            }
            else
            {
                return asLong () == l;
            }
        }
        catch ( final Exception e )
        {
            return false;
        }
    }

    private boolean compareToDouble ( final double d )
    {
        if ( isNull () )
        {
            return false;
        }

        try
        {
            if ( isBoolean () )
            {
                return asBoolean () ? d != 0 : d == 0;
            }
            return asDouble () == d;
        }
        catch ( final Exception e )
        {
            return false;
        }
    }

    private boolean compareToBoolean ( final boolean b )
    {
        return asBoolean () == b;
    }

    public String toLabel ( final String defaultLabel )
    {
        if ( this.value == null )
        {
            return defaultLabel;
        }
        else
        {
            return this.value.toString ();
        }
    }

    public String toLabel ()
    {
        return toLabel ( "" );
    }

    /**
     * Get the string representation of the variant (not the variant value).
     * This includes also the variant type.
     * <p>
     * The format is
     * <q>VariantType#VariantValue</q>.
     * <p>
     * If you want to get the string representation of the variant value itself
     * use {@link #asString()} instead.
     */
    @Override
    public String toString ()
    {
        return VariantType.fromJavaObject ( this.value ) + "#" + toLabel ();
    }

    /**
     * @return type from Type enumeration fitting for current value
     */
    public VariantType getType ()
    {
        return VariantType.fromJavaObject ( this.value );
    }

    /**
     * Get the internal variant value
     * 
     * @return the internal variant value
     */
    public Serializable getValue ()
    {
        return this.value;
    }

    @Override
    public int compareTo ( final Variant o )
    {
        return comparator.compare ( this, o );
    }
}
