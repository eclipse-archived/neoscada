/*******************************************************************************
 * Copyright (c) 2006, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - further development
 *     IBH SYSTEMS GmbH - more documentation, added nested processing
 *******************************************************************************/
package org.eclipse.scada.utils.str;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;

/**
 * A helper class for replacing strings in strings
 * <p>
 * The default is to replace <code>${var}</code> with
 * <q>var</q> from a {@link Map} instance. But there are other ways possible by
 * using different {@link Pattern} and {@link ReplaceSource} implementations.
 * </p>
 * <p>
 * In order to replace a string with the ${var} pattern using Java System
 * Properties use:
 * </p>
 * <blockquote>
 *
 * <pre>
 * String str = StringReplacer.replace ( &quot;Hello ${user.name}!&quot;, System.getProperties () );
 * </pre>
 *
 * </blockquote>
 * <p>
 * Replacing a variables in a string with bean like references use:
 * </p>
 * <blockquote>
 *
 * <pre>
 * class User
 * {
 *     private String name;
 * 
 *     public String getName ()
 *     {
 *         return name;
 *     };
 * 
 *     User ( String name )
 *     {
 *         this.name = name;
 *     }
 * }
 * 
 * Map&lt;String, User&gt; userMap = Collections.singletonMap ( &quot;user&quot;, new User ( &quot;Arthur Dent&quot; ) );
 * 
 * String str = StringReplacer.replace ( &quot;Hello ${user.name}!&quot;, userMap );
 * </pre>
 *
 * </blockquote>
 *
 * @author Jens Reimann
 */
public class StringReplacer
{

    public static interface ReplaceSource
    {
        public String replace ( String context, String key );
    }

    /**
     * The default pattern: <code>${var}</code>
     */
    public static final Pattern DEFAULT_PATTERN = Pattern.compile ( "\\$\\{([^{}]*?)\\}" );

    /**
     * Replace with the default pattern of <code>${var}</code>
     *
     * @param string
     *            the string which should be processed, may be <code>null</code>
     * @param properties
     *            the properties used for replacing
     * @return the source string with patterns replaced
     */
    public static String replace ( final String string, final Map<?, ?> properties )
    {
        return replace ( string, newSource ( properties ), DEFAULT_PATTERN );
    }

    /**
     * Create a new ReplaceSource for Map sources
     * <p>
     * The source will not replace elements that are not found in the map.
     * </p>
     *
     * @param properties
     *            the Map acting as a source
     * @return the new replace source based on the Map
     */
    public static ReplaceSource newSource ( final Map<?, ?> properties )
    {
        return new ReplaceSource () {

            @Override
            public String replace ( final String context, final String key )
            {
                final Object result = properties.get ( key );
                if ( result == null )
                {
                    return context;
                }
                return result.toString ();
            }
        };
    }

    /**
     * Create a new ReplaceSource for Map sources which allows additional
     * operators.
     *
     * @see ExtendedPropertiesReplacer
     * @param properties
     *            the Map acting as a source
     * @return the new replace source based on the Map
     */
    public static ReplaceSource newExtendedSource ( final Map<?, ?> properties )
    {
        return new ExtendedPropertiesReplacer ( properties );
    }

    /**
     * Create a new ReplaceSource that handles bean references
     *
     * @param properties
     *            the properties to use for replacing
     * @return the new ReplaceSource instance
     */
    public static ReplaceSource newBeansSource ( final Map<?, ?> properties )
    {
        return new ReplaceSource () {

            @Override
            public String replace ( final String context, final String key )
            {
                String result = null;
                try
                {
                    result = BeanUtils.getProperty ( properties, key );
                }
                catch ( final Exception e )
                {
                }
                if ( result != null )
                {
                    return result;
                }
                else
                {
                    return context;
                }
            }
        };
    }

    /**
     * Replace variables in a string
     *
     * @param string
     *            the string to process
     * @param replaceSource
     *            the source of the replacements
     * @param pattern
     *            the pattern for detecting variables
     * @param nested
     *            <code>true</code> if the replacement process should honor
     *            nested replacements
     * @return the replaced string, or <code>null</code> if the input string was
     *         <code>null</code>
     */
    public static String replace ( final String string, final ReplaceSource replaceSource, final Pattern pattern, final boolean nested )
    {
        if ( string == null )
        {
            return null;
        }

        final Matcher m = pattern.matcher ( string );

        boolean result = m.find ();
        if ( result )
        {
            final StringBuffer sb = new StringBuffer ();
            do
            {

                final String key;
                if ( m.groupCount () > 0 )
                {
                    key = m.group ( 1 );
                }
                else
                {
                    key = null;
                }

                String replacement = replaceSource.replace ( m.group ( 0 ), key );
                if ( replacement == null )
                {
                    m.appendReplacement ( sb, "" );
                }
                else
                {
                    replacement = replacement.replace ( "\\", "\\\\" ).replace ( "$", "\\$" );
                    m.appendReplacement ( sb, replacement );
                }

                result = m.find ();
            } while ( result );
            m.appendTail ( sb );

            final String resultString = sb.toString ();
            if ( nested && !string.equals ( resultString ) )
            {
                /*
                 * only try again if we should handle nested replacements and if something changed
                 */
                return replace ( resultString, replaceSource, pattern, true );
            }
            else
            {
                return resultString;
            }
        }
        else
        {
            return string;
        }
    }

    /**
     * Replace variables in a string <br/>
     * Actually calls
     * <code>replace ( string, replcaeSource, pattern, true )</code>.
     */
    public static String replace ( final String string, final ReplaceSource replaceSource, final Pattern pattern )
    {
        return replace ( string, replaceSource, pattern, true );
    }
}
