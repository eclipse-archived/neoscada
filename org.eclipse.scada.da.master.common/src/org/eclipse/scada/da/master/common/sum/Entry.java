/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.master.common.sum;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.utils.str.StringHelper;

public class Entry
{
    private final String tag;

    private final String attributeName;

    private final String attributeCountName;

    private final String suffix;

    private final Pattern pattern;

    private final String contextAttribute;

    private final String prefix;

    private final boolean debug;

    private Set<Object> contextSet;

    private int matches;

    public Entry ( final String tag, final String prefix, final String suffix, final String pattern, final boolean debug )
    {
        this.tag = tag;
        this.prefix = prefix;
        this.attributeName = String.format ( "%s.%s", this.prefix, this.tag );
        this.attributeCountName = this.attributeName + ".count";
        this.contextAttribute = this.tag + ".set";

        this.suffix = suffix == null ? "." + tag : suffix;
        this.pattern = makePattern ( pattern );

        this.debug = debug;
    }

    public void convertSource ( final Builder builder )
    {
        Variant sourceValue;

        sourceValue = builder.getAttributes ().remove ( this.tag );
        if ( sourceValue != null )
        {
            builder.setAttribute ( this.attributeName, sourceValue );
        }

        sourceValue = builder.getAttributes ().remove ( this.attributeCountName );
        if ( sourceValue != null && this.debug )
        {
            builder.setAttribute ( String.format ( "%s.%s.count", this.prefix, this.tag ), sourceValue );
        }

        sourceValue = builder.getAttributes ().remove ( this.tag + ".items" );
        if ( sourceValue != null && this.debug )
        {
            builder.setAttribute ( String.format ( "%s.%s.items", this.prefix, this.tag ), sourceValue );
        }
    }

    public void start ( final Map<String, Object> context, final Builder builder )
    {
        this.contextSet = getContextSet ( context, this.contextAttribute );

        if ( this.debug )
        {
            builder.setAttribute ( this.prefix + ".before", Variant.valueOf ( StringHelper.join ( this.contextSet, "," ) ) );
        }

        this.matches = 0;
    }

    public void check ( final String name, final Variant value )
    {
        if ( matches ( name, value ) )
        {
            if ( !this.contextSet.contains ( name ) )
            {
                this.matches++;
                this.contextSet.add ( name );
            }
        }
    }

    public void end ( final Map<String, Object> context, final Builder builder )
    {
        if ( this.debug )
        {
            builder.setAttribute ( this.prefix + ".after", Variant.valueOf ( StringHelper.join ( this.contextSet, "," ) ) );
        }

        builder.setAttribute ( this.tag, Variant.valueOf ( this.matches != 0 ) );
        if ( this.debug )
        {
            builder.setAttribute ( this.tag + ".count", Variant.valueOf ( this.matches ) );
        }

        this.contextSet = null;
    }

    private boolean matches ( final String name, final Variant value )
    {
        // if the value is null it will never match
        if ( value == null || name == null )
        {
            return false;
        }

        if ( this.pattern != null )
        {
            // if a pattern is defined ...
            if ( !this.pattern.matcher ( name ).matches () )
            {
                // ... it has to match
                return false;
            }
        }
        else
        {
            // otherwise the suffix ...
            if ( !name.endsWith ( this.suffix ) )
            {
                // ... must match
                return false;
            }
        }

        /* finally check the value itself, this may trigger
         * parsing the value as boolean (e.g. from a string) so we do this last
         */
        return value.asBoolean ();
    }

    @SuppressWarnings ( "unchecked" )
    private static Set<Object> getContextSet ( final Map<String, Object> context, final String contextAttribute )
    {
        final Object o = context.get ( contextAttribute );
        if ( o instanceof Set<?> )
        {
            return (Set<Object>)o;
        }
        else
        {
            final Set<Object> set = new HashSet<Object> ();
            context.put ( contextAttribute, set );
            return set;
        }
    }

    private static Pattern makePattern ( final String string )
    {
        if ( string == null )
        {
            return null;
        }
        return Pattern.compile ( string );
    }

}