/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common.exporter;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.common.chain.WriteHandler;
import org.eclipse.scada.da.server.common.item.factory.FolderItemFactory;
import org.eclipse.scada.da.server.common.item.factory.ItemFactory;

public class TabularExporter
{
    private final FolderItemFactory itemFactory;

    public static class Entry
    {
        private final String id;

        private final Map<String, Variant> values = new HashMap<> ();

        public Entry ( final String id )
        {
            this.id = id;
        }

        public void put ( final String key, final Variant value )
        {
            this.values.put ( key, value );
        }

        public void putAll ( final Map<String, Variant> values )
        {
            this.values.putAll ( values );
        }

        public String getId ()
        {
            return this.id;
        }

        public Map<String, Variant> getValues ()
        {
            return this.values;
        }
    }

    public static interface WriteHandlerFactory
    {
        public WriteHandler createColumnWriteHandler ( String id, String columnName );

        public WriteHandler createCommandWriteHandler ( String id, String command );
    }

    private static class Row
    {
        private final ItemFactory itemFactory;

        private final WriteHandlerFactory writeHandlerFactory;

        public Row ( final FolderItemFactory itemFactory, final String id, final WriteHandlerFactory writeHandlerFactory, final Set<String> commands )
        {
            this.itemFactory = itemFactory.createSubFolderFactory ( id );
            this.writeHandlerFactory = writeHandlerFactory;

            for ( final String command : commands )
            {
                final WriteHandler writeHandler = writeHandlerFactory.createCommandWriteHandler ( id, command );
                if ( writeHandler != null )
                {
                    this.itemFactory.createOutput ( command, null, writeHandler );
                }
            }
        }

        public void dispose ()
        {
            this.itemFactory.dispose ();
            this.items.clear ();
        }

        private final Map<String, DataItemInputChained> items = new HashMap<> ();

        public void update ( final Map<String, Variant> values )
        {
            final Set<String> currentItems = new HashSet<> ( this.items.keySet () );

            for ( final Map.Entry<String, Variant> entry : values.entrySet () )
            {
                DataItemInputChained item = this.items.get ( entry.getKey () );
                if ( item == null )
                {
                    item = createItem ( entry.getKey (), entry.getKey () );
                    this.items.put ( entry.getKey (), item );
                }
                else
                {
                    currentItems.remove ( entry.getKey () );
                }
                item.updateData ( entry.getValue (), null, null );
            }

            for ( final String itemId : currentItems )
            {
                final DataItemInputChained item = this.items.remove ( itemId );
                if ( item != null )
                {
                    this.itemFactory.disposeItem ( item );
                }
            }
        }

        public DataItemInputChained createItem ( final String id, final String columnName )
        {
            final WriteHandler writeHandler = this.writeHandlerFactory.createColumnWriteHandler ( id, columnName );
            if ( writeHandler != null )
            {
                return this.itemFactory.createInputOutput ( columnName, null, writeHandler );
            }
            else
            {
                return this.itemFactory.createInput ( columnName, null );
            }
        }
    }

    public Map<String, Row> rows = new HashMap<> ();

    private final WriteHandlerFactory writeHandlerFactory;

    private final Set<String> commands;

    public TabularExporter ( final FolderItemFactory itemFactory, final WriteHandlerFactory writeHandlerFactory, final Set<String> commands )
    {
        this.itemFactory = itemFactory;
        this.writeHandlerFactory = writeHandlerFactory;
        this.commands = commands;
    }

    public void update ( final List<Entry> entries )
    {
        final Set<String> keys = new HashSet<> ( this.rows.keySet () );

        for ( final Entry entry : entries )
        {
            Row row = this.rows.get ( entry.getId () );
            if ( row == null )
            {
                row = new Row ( this.itemFactory, entry.getId (), this.writeHandlerFactory, this.commands );
                this.rows.put ( entry.getId (), row );
            }
            else
            {
                keys.remove ( entry.getId () );
            }

            row.update ( entry.getValues () );
        }

        // remove values that disappeared

        for ( final String key : keys )
        {
            final Row row = this.rows.remove ( key );
            if ( row != null )
            {
                row.dispose ();
            }
        }
    }

    public void dispose ()
    {
        for ( final Row row : this.rows.values () )
        {
            row.dispose ();
        }
        this.rows.clear ();
    }

    public void setGlobalError ( final Throwable e )
    {
        update ( Collections.<TabularExporter.Entry> emptyList () );
    }
}
