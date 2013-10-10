/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.net.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.net.MessageHelper;
import org.eclipse.scada.da.core.browser.DataItemEntry;
import org.eclipse.scada.da.core.browser.Entry;
import org.eclipse.scada.da.core.browser.FolderEntry;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.net.base.data.IntegerValue;
import org.eclipse.scada.net.base.data.ListValue;
import org.eclipse.scada.net.base.data.LongValue;
import org.eclipse.scada.net.base.data.MapValue;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.base.data.StringValue;
import org.eclipse.scada.net.base.data.Value;
import org.eclipse.scada.net.base.data.ValueTools;
import org.eclipse.scada.net.base.data.VoidValue;
import org.eclipse.scada.utils.lang.Holder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListBrowser
{

    private final static Logger logger = LoggerFactory.getLogger ( ListBrowser.class );

    public static Message createRequest ( final String[] path )
    {
        final Message message = new Message ( Messages.CC_BROWSER_LIST_REQ );

        final ListValue value = new ListValue ();
        for ( final String tok : path )
        {
            value.add ( new StringValue ( tok ) );
        }
        message.getValues ().put ( "path", value );

        return message;
    }

    public static String[] parseRequest ( final Message message )
    {
        final List<String> list = new ArrayList<String> ();
        List<Value> listValue = null;

        if ( message.getValues ().containsKey ( "path" ) )
        {
            if ( message.getValues ().get ( "path" ) instanceof ListValue )
            {
                listValue = ( (ListValue)message.getValues ().get ( "path" ) ).getValues ();
            }
        }

        if ( listValue == null )
        {
            return new String[0];
        }

        for ( final Value value : listValue )
        {
            list.add ( value.toString () );
        }

        return list.toArray ( new String[0] );
    }

    private static void createEntries ( final Message message, final String field, final Iterable<Entry> entries )
    {
        final ListValue list = new ListValue ();
        for ( final Entry entry : entries )
        {
            final MapValue mapValue = new MapValue ();

            mapValue.put ( "name", new StringValue ( entry.getName () ) );
            mapValue.put ( "attributes", MessageHelper.attributesToMap ( entry.getAttributes () ) );

            if ( entry instanceof FolderEntry )
            {
                mapValue.put ( "type", new StringValue ( "folder" ) );
            }
            else if ( entry instanceof DataItemEntry )
            {
                mapValue.put ( "type", new StringValue ( "item" ) );
                final DataItemEntry dataItemEntry = (DataItemEntry)entry;
                mapValue.put ( "item-id", new StringValue ( dataItemEntry.getId () ) );
                mapValue.put ( "io-direction", IntegerValue.valueOf ( Messages.encodeIO ( dataItemEntry.getIODirections () ) ) );
            }
            else
            {
                mapValue.put ( "type", new StringValue ( "unknown" ) );
            }

            list.add ( mapValue );
        }
        message.getValues ().put ( field, list );
    }

    public static Message createResponse ( final long id, final Entry[] entries )
    {
        final Message message = new Message ( Messages.CC_BROWSER_LIST_RES );

        createEntries ( message, "entries", Arrays.asList ( entries ) );
        message.getValues ().put ( "id", new LongValue ( id ) );

        return message;
    }

    public static Message createResponse ( final long id, final String failure )
    {
        final Message message = new Message ( Messages.CC_BROWSER_LIST_RES );

        message.getValues ().put ( Message.FIELD_ERROR_INFO, new StringValue ( failure ) );
        message.getValues ().put ( "id", new LongValue ( id ) );

        return message;
    }

    private static void parseEntries ( final Message message, final String field, final List<Entry> list )
    {
        list.clear ();

        if ( !message.getValues ().containsKey ( field ) )
        {
            logger.warn ( "Required value '{}' missing", field );
            return;
        }

        if ( ! ( message.getValues ().get ( field ) instanceof ListValue ) )
        {
            logger.warn ( "'{}' must be of type 'list'", field );
            return;
        }

        final ListValue entries = (ListValue)message.getValues ().get ( field );

        for ( final Value value : entries.getValues () )
        {
            if ( ! ( value instanceof MapValue ) )
            {
                logger.warn ( "list value is not of type 'map'. Skipping!" );
                continue;
            }
            final MapValue mapValue = (MapValue)value;

            Entry entry = null;
            if ( !mapValue.containsKey ( "type" ) )
            {
                logger.warn ( "map misses required value 'type'" );
                continue;
            }
            if ( !mapValue.containsKey ( "name" ) )
            {
                logger.warn ( "map misses required value 'name'" );
                continue;
            }
            if ( !mapValue.containsKey ( "attributes" ) )
            {
                logger.warn ( "map misses required value 'attributes'" );
                continue;
            }
            if ( ! ( mapValue.get ( "attributes" ) instanceof MapValue ) )
            {
                logger.warn ( "map entry 'attributes' is not of type MapValue" );
                continue;
            }

            final String type = mapValue.get ( "type" ).toString ();
            final Map<String, Variant> attributes = MessageHelper.mapToAttributes ( (MapValue)mapValue.get ( "attributes" ) );

            logger.debug ( "entry type: '{}'" );

            if ( type.equals ( "folder" ) )
            {
                entry = new FolderEntryCommon ( mapValue.get ( "name" ).toString (), attributes );
            }
            else if ( type.equals ( "item" ) )
            {
                if ( !mapValue.containsKey ( "item-id" ) )
                {
                    logger.warn ( "map entry is an item but misses 'item-id' " );
                    continue;
                }
                if ( !mapValue.containsKey ( "io-direction" ) )
                {
                    logger.warn ( "map entry is an item but misses 'io-direction' " );
                    continue;
                }

                final String id = mapValue.get ( "item-id" ).toString ();

                final Set<IODirection> io = Messages.decodeIO ( ValueTools.toInteger ( mapValue.get ( "io-direction" ), 0 ) );

                entry = new DataItemEntryCommon ( mapValue.get ( "name" ).toString (), io, attributes, id );
            }

            // now add the entry
            if ( entry != null )
            {
                list.add ( entry );
            }
        }
    }

    public static Entry[] parseResponse ( final Message message )
    {
        final List<Entry> list = new ArrayList<Entry> ();
        parseEntries ( message, "entries", list );
        return list.toArray ( new Entry[list.size ()] );
    }

    public static void parseEvent ( final Message message, final List<String> path, final List<Entry> added, final List<String> removed, final Holder<Boolean> full )
    {
        // first clear what we have
        path.clear ();
        added.clear ();
        removed.clear ();

        // path 
        if ( message.getValues ().containsKey ( "path" ) )
        {
            if ( message.getValues ().get ( "path" ) instanceof ListValue )
            {
                path.addAll ( ValueTools.fromStringList ( (ListValue)message.getValues ().get ( "path" ) ) );
            }
        }

        // added
        parseEntries ( message, "added", added );

        // full
        full.value = message.getValues ().containsKey ( "full" );

        // removed
        if ( message.getValues ().containsKey ( "removed" ) )
        {
            if ( message.getValues ().get ( "removed" ) instanceof ListValue )
            {
                final ListValue listValue = (ListValue)message.getValues ().get ( "removed" );
                for ( final Value value : listValue.getValues () )
                {
                    removed.add ( value.toString () );
                }
            }
        }
    }

    public static Message createEvent ( final String[] path, final Collection<Entry> added, final Collection<String> removed, final boolean full )
    {
        final Message message = new Message ( Messages.CC_BROWSER_EVENT );

        if ( full )
        {
            message.getValues ().put ( "full", VoidValue.INSTANCE );
        }

        message.getValues ().put ( "path", ValueTools.toStringList ( Arrays.asList ( path ) ) );
        message.getValues ().put ( "removed", ValueTools.toStringList ( removed ) );

        createEntries ( message, "added", added );

        return message;
    }

    private static Message createRegMessage ( final int commandCode, final String[] path )
    {
        final Message message = new Message ( commandCode );

        message.getValues ().put ( "path", ValueTools.toStringList ( Arrays.asList ( path ) ) );

        return message;
    }

    public static Message createSubscribe ( final String[] path )
    {
        return createRegMessage ( Messages.CC_BROWSER_SUBSCRIBE, path );
    }

    public static Message createUnsubscribe ( final String[] path )
    {
        return createRegMessage ( Messages.CC_BROWSER_UNSUBSCRIBE, path );
    }

    private static String[] parseRegMessage ( final Message message )
    {
        if ( !message.getValues ().containsKey ( "path" ) )
        {
            return new String[0];
        }
        if ( ! ( message.getValues ().get ( "path" ) instanceof ListValue ) )
        {
            return new String[0];
        }
        return ValueTools.fromStringList ( (ListValue)message.getValues ().get ( "path" ) ).toArray ( new String[0] );
    }

    public static String[] parseSubscribeMessage ( final Message message )
    {
        return parseRegMessage ( message );
    }

    public static String[] parseUnsubscribeMessage ( final Message message )
    {
        return parseRegMessage ( message );
    }
}
