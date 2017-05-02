/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.str;

import java.util.Map;

import org.eclipse.scada.utils.str.StringReplacer.ReplaceSource;

/**
 * A replacer which allows to process additional operators in the key. <br/>
 * The syntax of the key is
 * <code>&lt;name&gt;[&lt;operator&gt;[&lt;argument&gt;]]</code>.
 * All examples assume that the default pattern (${var}) is being used.
 * The following operators are possible: <h2>: - Default value</h2>
 * <table>
 * <tr>
 * <th>Example</th>
 * <th>Result</th>
 * </tr>
 * <tr>
 * <td>Hello ${var:default}!</td>
 * <td>If "var" is set to "test": "Hello test!"<br/>
 * If "var" is unset: "Hello default!"</td>
 * </tr>
 * </table>
 */
public class ExtendedPropertiesReplacer implements ReplaceSource
{
    private final Map<?, ?> properties;

    private final boolean failOnMissingKey;

    public ExtendedPropertiesReplacer ( final Map<?, ?> properties, final boolean failOnMissingKey )
    {
        this.properties = properties;
        this.failOnMissingKey = failOnMissingKey;
    }

    public ExtendedPropertiesReplacer ( final Map<?, ?> properties )
    {
        this ( properties, false );
    }

    @Override
    public String replace ( final String context, final String key )
    {
        String name = key;
        String op = null;
        String arg = null;

        for ( int i = 0; i < key.length (); i++ )
        {
            final char c = key.charAt ( i );
            if ( c == ':' )
            {
                name = key.substring ( 0, i );
                op = Character.toString ( c );
                if ( i + 1 < key.length () )
                {
                    arg = key.substring ( i + 1, key.length () );
                }
                else
                {
                    arg = null;
                }
                break;
            }
        }

        final String value = getValue ( name );

        if ( op == null || op.equals ( "" ) )
        {
            if ( value == null && this.failOnMissingKey )
            {
                throw new IllegalStateException ( String.format ( "Key '%s' not found", context ) );
            }
            return value == null ? context : value;
        }
        else if ( op.equals ( ":" ) )
        {
            return value == null ? arg : value;
        }

        if ( this.failOnMissingKey )
        {
            throw new IllegalStateException ( String.format ( "Unable to replace '%s'", context ) );
        }
        else
        {
            return context;
        }
    }

    private String getValue ( final String name )
    {
        final Object v = this.properties.get ( name );
        if ( v == null )
        {
            return null;
        }
        else
        {
            return v.toString ();
        }
    }

}
