/*******************************************************************************
 * Copyright (c) 2006, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - further development
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
 * <code>
 * String str = StringReplacer.replace ( "Hello ${user.name}!", System.getProperties () );
 * </code>
 * 
 * @author Jens Reimann
 */
public class StringReplacer
{

    public static interface ReplaceSource
    {
        public String replace ( String context, String key );
    }

    public static final Pattern DEFAULT_PATTERN = Pattern.compile ( "\\$\\{(.*?)\\}" );

    /**
     * Replace with the default pattern of <code>${var}</code>
     * 
     * @param string
     * @param properties
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

    public static String replace ( final String string, final ReplaceSource replaceSource, final Pattern pattern )
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
            return sb.toString ();
        }
        else
        {
            return string;
        }
    }
}
