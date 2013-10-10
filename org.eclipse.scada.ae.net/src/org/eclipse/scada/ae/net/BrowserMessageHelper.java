/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.net;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.scada.ae.data.BrowserEntry;
import org.eclipse.scada.ae.data.BrowserType;
import org.eclipse.scada.core.net.MessageHelper;
import org.eclipse.scada.net.base.data.ListValue;
import org.eclipse.scada.net.base.data.MapValue;
import org.eclipse.scada.net.base.data.StringValue;
import org.eclipse.scada.net.base.data.Value;
import org.eclipse.scada.net.base.data.VoidValue;

public class BrowserMessageHelper
{

    public static List<BrowserEntry> fromValue ( final Value baseValue )
    {
        if ( ! ( baseValue instanceof ListValue ) )
        {
            return null;
        }

        final List<BrowserEntry> result = new ArrayList<BrowserEntry> ();

        final ListValue value = (ListValue)baseValue;

        for ( final Value entryValue : value.getValues () )
        {
            final BrowserEntry entry = fromValueEntry ( entryValue );
            if ( entry != null )
            {
                result.add ( entry );
            }
        }

        return result;
    }

    private static Set<BrowserType> getTypes ( final Value value )
    {
        final EnumSet<BrowserType> result = EnumSet.noneOf ( BrowserType.class );

        if ( value instanceof ListValue )
        {
            for ( final Value entry : ( (ListValue)value ).getValues () )
            {
                if ( entry instanceof StringValue )
                {
                    String strValue = ( (StringValue)entry ).getValue ();
                    if ( strValue == "CONDITIONS" )
                    {
                        // convert for old connections
                        strValue = "MONITORS";
                    }

                    final BrowserType type = BrowserType.valueOf ( strValue );
                    if ( type != null )
                    {
                        result.add ( type );
                    }
                }
            }
        }
        if ( result.isEmpty () )
        {
            return null;
        }
        return result;
    }

    private static BrowserEntry fromValueEntry ( final Value entryValue )
    {
        if ( ! ( entryValue instanceof MapValue ) )
        {
            return null;
        }

        final MapValue value = (MapValue)entryValue;
        try
        {

            final String id = ( (StringValue)value.get ( "id" ) ).getValue ();

            final Set<BrowserType> types = getTypes ( value.get ( "types" ) );
            if ( types == null )
            {
                return null;
            }

            final Value attributes = value.get ( "attributes" );

            if ( ! ( attributes instanceof MapValue ) )
            {
                return null;
            }

            return new BrowserEntry ( id, types, MessageHelper.mapToAttributes ( (MapValue)attributes ) );
        }
        catch ( final ClassCastException e )
        {
            return null;
        }
        catch ( final NullPointerException e )
        {
            return null;
        }
    }

    public static Value toValue ( final List<BrowserEntry> added )
    {
        final ListValue result = new ListValue ();

        if ( added != null )
        {
            for ( final BrowserEntry entry : added )
            {
                result.add ( toValue ( entry ) );
            }
        }

        return result;
    }

    private static Value toValue ( final BrowserEntry entry )
    {
        final MapValue value = new MapValue ();

        value.put ( "id", new StringValue ( entry.getId () ) );
        final ListValue types = new ListValue ();
        for ( final BrowserType type : entry.getTypes () )
        {
            types.add ( new StringValue ( type.toString () ) );
        }
        value.put ( "types", types );
        value.put ( "attributes", MessageHelper.attributesToMap ( entry.getAttributes () ) );

        return value;
    }

    public static Value toValue ( final Set<String> removed )
    {
        if ( removed == null )
        {
            return VoidValue.INSTANCE;
        }

        final ListValue result = new ListValue ();

        for ( final String entry : removed )
        {
            result.add ( new StringValue ( entry ) );
        }

        return result;
    }

    public static Set<String> fromValueRemoved ( final Value value )
    {
        if ( ! ( value instanceof ListValue ) )
        {
            return null;
        }

        final Set<String> removed = new HashSet<String> ();
        for ( final Value entryValue : ( (ListValue)value ).getValues () )
        {
            if ( entryValue instanceof StringValue )
            {
                removed.add ( ( (StringValue)entryValue ).getValue () );
            }
        }

        return removed;
    }
}
