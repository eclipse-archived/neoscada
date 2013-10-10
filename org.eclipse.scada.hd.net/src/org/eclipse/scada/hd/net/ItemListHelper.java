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
package org.eclipse.scada.hd.net;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.scada.core.net.MessageHelper;
import org.eclipse.scada.hd.data.HistoricalItemInformation;
import org.eclipse.scada.net.base.data.ListValue;
import org.eclipse.scada.net.base.data.MapValue;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.base.data.StringValue;
import org.eclipse.scada.net.base.data.Value;
import org.eclipse.scada.net.base.data.VoidValue;

public class ItemListHelper
{

    public static final String FIELD_ADDED = "added";

    public static final String FIELD_REMOVED = "removed";

    public static final String FIELD_FULL = "full";

    public static Set<HistoricalItemInformation> fromValue ( final Value baseValue )
    {
        if ( ! ( baseValue instanceof ListValue ) )
        {
            return null;
        }

        final Set<HistoricalItemInformation> result = new HashSet<HistoricalItemInformation> ();

        final ListValue value = (ListValue)baseValue;

        for ( final Value entryValue : value.getValues () )
        {
            final HistoricalItemInformation entry = fromValueEntry ( entryValue );
            if ( entry != null )
            {
                result.add ( entry );
            }
        }
        return result;
    }

    private static HistoricalItemInformation fromValueEntry ( final Value entryValue )
    {
        if ( ! ( entryValue instanceof MapValue ) )
        {
            return null;
        }

        final MapValue value = (MapValue)entryValue;
        try
        {

            final String id = ( (StringValue)value.get ( "id" ) ).getValue ();

            final Value attributes = value.get ( "attributes" );
            if ( ! ( attributes instanceof MapValue ) )
            {
                return null;
            }

            return new HistoricalItemInformation ( id, MessageHelper.mapToAttributes ( (MapValue)attributes ) );
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

    public static Value toValueAdded ( final Collection<HistoricalItemInformation> added )
    {
        final ListValue result = new ListValue ();

        if ( added != null )
        {
            for ( final HistoricalItemInformation entry : added )
            {
                result.add ( toValue ( entry ) );
            }
        }

        return result;
    }

    private static Value toValue ( final HistoricalItemInformation entry )
    {
        final MapValue value = new MapValue ();

        value.put ( "id", new StringValue ( entry.getItemId () ) );
        value.put ( "attributes", MessageHelper.attributesToMap ( entry.getAttributes () ) );

        return value;
    }

    public static Value toValueRemoved ( final Collection<String> removed )
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

    public static Message createRequestList ( final boolean flag )
    {
        final Message message = new Message ( flag ? Messages.CC_HD_START_LIST : Messages.CC_HD_STOP_LIST );
        return message;
    }
}
