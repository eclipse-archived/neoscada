/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - some minor enhancements
 *******************************************************************************/
package org.eclipse.scada.ca;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantEditor;
import org.eclipse.scada.utils.str.StringHelper;

public class ConfigurationDataHelper
{
    private final Map<String, String> data;

    public ConfigurationDataHelper ( final Map<String, String> parameters )
    {
        this.data = parameters;
    }

    /**
     * The actual configuration data
     *
     * @return the configuration data
     */
    public Map<String, String> getData ()
    {
        return this.data;
    }

    /**
     * Get an integer from the data or <code>null</code> if the parameter is not
     * set or not an integer
     *
     * @param name
     *            the name of the parameter
     * @return the integer or <code>null</code>
     */
    public Integer getInteger ( final String name )
    {
        final String str = this.data.get ( name );
        if ( str == null )
        {
            return null;
        }
        try
        {
            return Integer.parseInt ( str );
        }
        catch ( final NumberFormatException e )
        {
            return null;
        }
    }

    /**
     * Get an integer from the data or the default value if the parameter is not
     * set or not an integer
     *
     * @param name
     *            the name of the parameter
     * @param defaultValue
     *            the default value
     * @return the integer or the default value
     */
    public int getInteger ( final String name, final int defaultValue )
    {
        final Integer result = getInteger ( name );
        if ( result == null )
        {
            return defaultValue;
        }
        return result;
    }

    /**
     * Get an integer from the configuration data
     * <p>
     * If the parameter is not set a {@link IllegalArgumentException} will be
     * thrown. If the data can not be parsed to an integer a
     * {@link NumberFormatException} will be thrown.
     * </p>
     *
     * @param name
     *            the name of the parameter to get
     * @param errorMessage
     *            the error message if the string is not set
     * @return the value as integer
     * @throws NumberFormatException
     * @throws IllegalArgumentException
     */
    public int getIntegerChecked ( final String name, final String errorMessage ) throws IllegalArgumentException, NumberFormatException
    {
        final String str = this.data.get ( name );
        if ( str == null )
        {
            throw new IllegalArgumentException ( errorMessage );
        }
        return Integer.parseInt ( str );
    }

    /**
     * Get a long from the data or <code>null</code> if the parameter is not set
     * or not a long
     *
     * @param name
     *            the name of the parameter
     * @return the long or <code>null</code>
     */
    public Long getLong ( final String name )
    {
        final String str = this.data.get ( name );
        if ( str == null )
        {
            return null;
        }
        try
        {
            return Long.parseLong ( str );
        }
        catch ( final NumberFormatException e )
        {
            return null;
        }
    }

    /**
     * Get a long from the data or the default value if the parameter is not set
     * or not a long
     *
     * @param name
     *            the name of the parameter
     * @param defaultValue
     *            the default value
     * @return the long or the default value
     */
    public long getLong ( final String name, final long defaultValue )
    {
        final Long result = getLong ( name );
        if ( result == null )
        {
            return defaultValue;
        }
        return result;
    }

    /**
     * Get a long from the configuration data
     * <p>
     * If the parameter is not set a {@link IllegalArgumentException} will be
     * thrown. If the data can not be parsed to a long a
     * {@link NumberFormatException} will be thrown.
     * </p>
     *
     * @param name
     *            the name of the parameter to get
     * @param errorMessage
     *            the error message if the string is not set
     * @return the value as long
     * @throws NumberFormatException
     * @throws IllegalArgumentException
     */
    public long getLongChecked ( final String name, final String errorMessage ) throws IllegalArgumentException, NumberFormatException
    {
        final String str = this.data.get ( name );
        if ( str == null )
        {
            throw new IllegalArgumentException ( errorMessage );
        }
        return Long.parseLong ( str );
    }

    /**
     * Get a non-empty string from the configuration.
     *
     * @param name
     *            the name of the parameters to get
     * @return returns <code>null</code> if the parameter is not set or is an
     *         empty string. Otherwise the string itself will be returned.
     */
    public String getStringNonEmpty ( final String name )
    {
        final String result = this.data.get ( name );
        if ( result == null )
        {
            return null;
        }
        if ( "".equals ( result ) )
        {
            return null;
        }
        return result;
    }

    /**
     * Get a string from the configuration
     *
     * @param name
     *            the name of the string to get
     * @return the string data or <code>null</code> if the string was not set
     */
    public String getString ( final String name )
    {
        return this.data.get ( name );
    }

    public String getString ( final String name, final String defaultValue )
    {
        final String str = this.data.get ( name );
        if ( str != null )
        {
            return str;
        }
        else
        {
            return defaultValue;
        }
    }

    /**
     * Get a string from the configuration data
     *
     * @param name
     *            the name of the parameter to get
     * @param errorMessage
     *            the error message if the string is not set
     * @return the string data
     * @throws IllegalArgumentException
     *             if the string is not set
     */
    public String getStringChecked ( final String name, final String errorMessage ) throws IllegalArgumentException
    {
        final String str = this.data.get ( name );
        if ( str == null )
        {
            throw new IllegalArgumentException ( errorMessage );
        }
        else
        {
            return str;
        }
    }

    /**
     * Get a non-null, non-empty string from the configuration data
     *
     * @param name
     *            the name of the parameter to get
     * @param errorMessage
     *            the error message if the string is not set or empty
     * @return a not-null, non-empty string
     * @throws IllegalArgumentException
     *             if the string is not set or is empty
     */
    public String getStringNonEmptyChecked ( final String name, final String errorMessage ) throws IllegalArgumentException
    {
        final String str = this.data.get ( name );
        if ( str != null && !str.isEmpty () )
        {
            return str;
        }

        throw new IllegalArgumentException ( errorMessage );
    }

    /**
     * Get a whitelisted string from the configuration data
     *
     * @param name
     *            the name of the parameter to get
     * @param whitelist
     *            the list of allowed values
     * @return the string data
     * @throws IllegalArgumentException
     *             if the string is not set
     */
    public String getStringOfChecked ( final String name, final Collection<String> whitelisted ) throws IllegalArgumentException
    {
        final String str = this.data.get ( name );
        if ( str == null )
        {
            throw new IllegalArgumentException ( String.format ( "'%s' was null, but must be on of %s", name, whitelisted ) );
        }
        else
        {
            if ( whitelisted.contains ( str ) )
            {
                return str;
            }
            throw new IllegalArgumentException ( String.format ( "'%s' is not part of the allowed parameters (%s)", str, whitelisted ) );
        }
    }

    /**
     * Get a whitelisted string from the configuration data
     *
     * @param name
     *            the name of the parameter to get
     * @param defaultValue
     *            the default value
     * @param whitelist
     *            the list of allowed values
     * @return the string data
     * @throws IllegalArgumentException
     *             if the string is not set
     */
    public String getStringOfChecked ( final String name, final String defaultValue, final Collection<String> whitelisted ) throws IllegalArgumentException
    {
        if ( !whitelisted.contains ( defaultValue ) )
        {
            throw new IllegalArgumentException ( String.format ( "the defaultValue '%s' is not part of the allowed parameters (%s)", defaultValue, whitelisted ) );
        }
        String str = this.data.get ( name );
        if ( str == null )
        {
            str = defaultValue;
        }
        if ( whitelisted.contains ( str ) )
        {
            return str;
        }
        throw new IllegalArgumentException ( String.format ( "'%s' is not part of the allowed parameters (%s)", str, whitelisted ) );
    }

    /**
     * Get all values of the keys that start with a specific prefix
     *
     * @param prefix
     *            the prefix
     * @return the set of values, never <code>null</code>
     */
    public Set<String> getStringSet ( final String prefix )
    {
        final Set<String> result = new HashSet<String> ();

        for ( final Map.Entry<String, String> entry : this.data.entrySet () )
        {
            if ( entry.getKey ().startsWith ( prefix ) )
            {
                result.add ( entry.getValue () );
            }
        }

        return result;
    }

    /**
     * Get an integer from the data or <code>null</code> if the parameter is not
     * set or not an integer
     *
     * @param name
     *            the name of the parameter
     * @return the integer or <code>null</code>
     */
    public Double getDouble ( final String name )
    {
        final String str = this.data.get ( name );
        if ( str == null )
        {
            return null;
        }
        try
        {
            return Double.parseDouble ( str );
        }
        catch ( final NumberFormatException e )
        {
            return null;
        }
    }

    /**
     * Get an integer from the data or the default value if the parameter is not
     * set or not an integer
     *
     * @param name
     *            the name of the parameter
     * @param defaultValue
     *            the default value
     * @return the integer or the default value
     */
    public double getDouble ( final String name, final double defaultValue )
    {
        final Double result = getDouble ( name );
        if ( result == null )
        {
            return defaultValue;
        }
        return result;
    }

    /**
     * Get an integer from the configuration data
     * <p>
     * If the parameter is not set a {@link IllegalArgumentException} will be
     * thrown. If the data can not be parsed to an integer a
     * {@link NumberFormatException} will be thrown.
     * </p>
     *
     * @param name
     *            the name of the parameter to get
     * @param errorMessage
     *            the error message if the string is not set
     * @return the value as integer
     * @throws NumberFormatException
     * @throws IllegalArgumentException
     */
    public double getDoubleChecked ( final String name, final String errorMessage ) throws IllegalArgumentException, NumberFormatException
    {
        final String str = this.data.get ( name );
        if ( str == null )
        {
            throw new IllegalArgumentException ( errorMessage );
        }
        return Double.parseDouble ( str );
    }

    public boolean getBooleanChecked ( final String name, final String errorMessage )
    {
        final String str = this.data.get ( name );
        if ( str == null )
        {
            throw new IllegalArgumentException ( errorMessage );
        }
        return Boolean.parseBoolean ( str );
    }

    /**
     * Get a boolean from the data or <code>null</code> if the parameter is not
     * set or not a boolean
     *
     * @param name
     *            the name of the parameter
     * @return the boolean or <code>null</code>
     */
    public Boolean getBoolean ( final String name )
    {
        final String str = this.data.get ( name );
        if ( str == null )
        {
            return null;
        }
        try
        {
            return Boolean.parseBoolean ( str );
        }
        catch ( final NumberFormatException e )
        {
            return null;
        }
    }

    /**
     * Get a boolean from the data or the default value if the parameter is not
     * set or not a boolean
     *
     * @param name
     *            the name of the parameter
     * @param defaultValue
     *            the default value
     * @return the boolean or the default value
     */
    public boolean getBoolean ( final String name, final boolean defaultValue )
    {
        final Boolean result = getBoolean ( name );
        if ( result == null )
        {
            return defaultValue;
        }
        return result;
    }

    /**
     * Get an variant from the data or <code>null</code> if the parameter is not
     * set or not an variant
     *
     * @param name
     *            the name of the parameter
     * @return the variant or <code>null</code>
     */
    public Variant getVariant ( final String name )
    {
        final String str = this.data.get ( name );
        if ( str == null )
        {
            return null;
        }
        try
        {
            return VariantEditor.toVariant ( str );
        }
        catch ( final IllegalArgumentException e )
        {
            return null;
        }
    }

    /**
     * Get an variant from the data or the default value if the parameter is not
     * set or not an variant
     *
     * @param name
     *            the name of the parameter
     * @param defaultValue
     *            the default value
     * @return the variant or the default value
     */
    public Variant getVariant ( final String name, final Variant defaultValue )
    {
        final Variant result = getVariant ( name );
        if ( result == null )
        {
            return defaultValue;
        }
        return result;
    }

    public Variant getVariantChecked ( final String name, final String errorMessage ) throws IllegalArgumentException
    {
        final String str = this.data.get ( name );
        if ( str == null )
        {
            throw new IllegalArgumentException ( errorMessage );
        }
        return VariantEditor.toVariant ( str );
    }

    /**
     * Extracts attributes that start with a prefix and return the matching
     * entries only with the key truncated by the prefix.
     * <p>
     * If you want your prefix to be "prefix." you must also add the dot.
     * </p>
     *
     * @param prefix
     *            the prefix to use
     * @return the result map
     */
    public Map<String, String> getPrefixed ( final String prefix )
    {
        if ( prefix == null )
        {
            return Collections.emptyMap ();
        }

        final int prefixLen = prefix.length ();

        final Map<String, String> result = new HashMap<String, String> ( 8 );

        for ( final Map.Entry<String, String> entry : this.data.entrySet () )
        {
            final String key = entry.getKey ();
            if ( key == null || !key.startsWith ( prefix ) )
            {
                continue;
            }

            final String subKey = key.substring ( prefixLen );
            result.put ( subKey, entry.getValue () );
        }

        return result;
    }

    /**
     * Create a configuration data helper containing only the parameters having
     * the provided prefix, including their prefix removed.
     *
     * @see #getPrefixed(String)
     * @param prefix
     *            the prefix
     * @return the new set of data
     */
    public ConfigurationDataHelper getPrefixedHelper ( final String prefix )
    {
        return new ConfigurationDataHelper ( getPrefixed ( prefix ) );
    }

    /**
     * Convenience method to get prefixed attributes as {@link Properties}
     * object
     * <p>
     * Actually calls {@link #getPrefixed(String)}
     * </p>
     *
     * @param prefix
     *            the prefix to use
     * @return the result properties
     */
    public Properties getPrefixedProperties ( final String prefix )
    {
        final Properties p = new Properties ();
        p.putAll ( getPrefixed ( prefix ) );
        return p;
    }

    /**
     * Scan by prefix and aggregate by the remainder <br/>
     * <p>
     * This will aggregate from:
     * </p>
     * <p>
     * <code>
     * a=b
     * c=d
     * entry.group1=foo
     * entry.group1.a=value1
     * entry.group1.b=value2
     * entry.group2.a=value3
     * entry.group2.c=value4
     * </code>
     * </p>
     * <p>
     * Using the pattern "<code>entry\\.(?<group.*>)\\.(?<key.*?>)</code>". To:
     * </p>
     * <p>
     * <code>
     * group1 = {
     *  a=value1
     *  b=value2
     * }
     * group2 = {
     *  a=value3
     *  c=value4
     * }
     * </code>
     * </p>
     * <p>
     * <em>Note:</em> Key that do not match at all won't get transfered into the
     * result maps.
     * </p>
     *
     * @param data
     *            the data to scan
     * @param pattern
     *            a pattern that identifies the group part and the key part from
     *            the original key. The pattern must have two named groups:
     *            "group" and "key".
     * @return A map of maps: group to map(key to value)
     */
    public Map<String, Map<String, String>> getAggregated ( final Pattern pattern )
    {
        final Map<String, Map<String, String>> result = new HashMap<> ();

        for ( final Map.Entry<String, String> entry : this.data.entrySet () )
        {
            final Matcher m = pattern.matcher ( entry.getKey () );
            if ( m.matches () )
            {
                final String group = m.group ( "group" ); //$NON-NLS-1$
                final String key = m.group ( "key" ); //$NON-NLS-1$
                Map<String, String> map = result.get ( group );
                if ( map == null )
                {
                    map = new HashMap<> ();
                    result.put ( group, map );
                }
                map.put ( key, entry.getValue () );
            }
        }

        return result;
    }

    public <E extends Enum<E>> E getEnumChecked ( final String name, final Class<E> enumType, final String errorMessage )
    {
        return makeEnum ( enumType, null, getStringChecked ( name, errorMessage ), false );
    }

    public <E extends Enum<E>> E getEnum ( final String name, final Class<E> enumType )
    {
        return makeEnum ( enumType, null, getString ( name ), false );
    }

    public <E extends Enum<E>> E getEnum ( final String name, final Class<E> enumType, final E defaultValue )
    {
        return makeEnum ( enumType, defaultValue, getString ( name ), false );
    }

    public static <E extends Enum<E>> E makeEnum ( final Class<E> enumType, final E defaultValue, final String stringValue, final boolean ignoreMissing )
    {
        if ( stringValue == null )
        {
            return defaultValue;
        }
        try
        {
            return Enum.valueOf ( enumType, stringValue );
        }
        catch ( final IllegalArgumentException e )
        {
            if ( ignoreMissing )
            {
                return defaultValue;
            }
            else
            {
                throw new IllegalArgumentException ( makeEnumError ( enumType, stringValue ), e );
            }
        }
    }

    protected static <E extends Enum<E>> String makeEnumError ( final Class<E> enumType, final String stringValue )
    {
        return String.format ( "Value '%s' is not contained in enum. (Possible values: %s)", stringValue, StringHelper.join ( enumType.getEnumConstants (), ", " ) );
    }

    /**
     * Return the time zone <br/>
     * <em>Note:</em> The method internally calls
     * {@link TimeZone#getTimeZone(String)} in order
     * to convert the configured string to the actual time zone.
     *
     * @param name
     *            the name of the parameter
     * @param defaultValue
     *            the default value
     * @return the configured time zone, or the default value if none was
     *         configured
     */
    public TimeZone getTimeZone ( final String name, final TimeZone defaultValue )
    {
        final String timeZoneId = getString ( name, null );
        if ( timeZoneId == null || timeZoneId.isEmpty () )
        {
            return defaultValue;
        }

        return TimeZone.getTimeZone ( timeZoneId );
    }
}
