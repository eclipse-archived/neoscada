/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.browser.common.query.GroupFolder;
import org.eclipse.scada.da.server.browser.common.query.GroupProvider;
import org.eclipse.scada.da.server.browser.common.query.IDNameProvider;
import org.eclipse.scada.da.server.browser.common.query.ItemDescriptor;
import org.eclipse.scada.da.server.browser.common.query.Matcher;
import org.eclipse.scada.da.server.browser.common.query.NullNameProvider;
import org.eclipse.scada.da.server.browser.common.query.QueryFolder;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.DataItemCommand;
import org.eclipse.scada.da.server.common.MemoryDataItem;
import org.eclipse.scada.da.server.common.exporter.ObjectExporter;
import org.eclipse.scada.da.server.common.factory.DataItemValidator;
import org.eclipse.scada.da.server.common.impl.HiveCommon;
import org.eclipse.scada.da.server.common.item.factory.FolderItemFactory;
import org.eclipse.scada.da.server.test.items.FactoryMemoryCell;
import org.eclipse.scada.da.server.test.items.MemoryCellItem;
import org.eclipse.scada.da.server.test.items.MemoryChainedItem;
import org.eclipse.scada.da.server.test.items.SuspendItem;
import org.eclipse.scada.da.server.test.items.TestItem1;
import org.eclipse.scada.da.server.test.items.TestItem2;
import org.eclipse.scada.da.server.test.items.TimeDataItem;
import org.eclipse.scada.da.server.test.items.WriteDelayItem;
import org.eclipse.scada.da.server.test.model.TestModelObject;
import org.eclipse.scada.utils.collection.MapBuilder;

public class Hive extends HiveCommon
{

    private final List<ItemDescriptor> changingItems = new LinkedList<ItemDescriptor> ();

    private final QueryFolder queryFolderFactory;

    private final List<DataItem> transientItems = new LinkedList<DataItem> ();

    private final FolderCommon testFolder;

    @SuppressWarnings ( "unused" )
    private FolderItemFactory itemFactory;

    private final Timer timer;

    private ObjectExporter objectExporter;

    private TestModelObject testObject;

    public Hive () throws IOException
    {
        this.timer = new Timer ( true );

        // create root folder
        final FolderCommon rootFolder = new FolderCommon ();
        setRootFolder ( rootFolder );

        // create and register test folder
        this.testFolder = new FolderCommon ();
        rootFolder.add ( "test", this.testFolder, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "This folder contains numerous test data items!" ) ).getMap () );
        final FolderCommon helloWorldFolder = new FolderCommon ();
        rootFolder.add ( "Hello World!", helloWorldFolder, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "This folder hello world items! Actually there are several tree entries that point to one item instance!" ) ).getMap () );

        // query folders
        final QueryFolder queryFolderRoot = new QueryFolder ( new Matcher () {

            @Override
            public boolean matches ( final ItemDescriptor desc )
            {
                return true;
            }
        }, new NullNameProvider () );
        final QueryFolder queryFolder1 = new QueryFolder ( new Matcher () {

            @Override
            public boolean matches ( final ItemDescriptor desc )
            {
                return desc.getItem ().getInformation ().getName ().matches ( ".*e+.*" );
            }
        }, new IDNameProvider () );

        queryFolderRoot.addChild ( "query", queryFolder1, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "contains items the have an 'e' in their id" ) ).getMap () );
        this.testFolder.add ( "storage", queryFolderRoot, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "storage based folder for grouping and query folders" ) ).getMap () );

        // memory cell factory
        this.queryFolderFactory = new QueryFolder ( new Matcher () {

            @Override
            public boolean matches ( final ItemDescriptor desc )
            {
                return desc.getItem ().getInformation ().getName ().matches ( "memory\\.[a-z0-9]+" );
            }
        }, new IDNameProvider () );
        this.testFolder.add ( "memory-factory", this.queryFolderFactory, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "storage folder for items automatically created by the memory cell factory" ) ).getMap () );

        // Group Folders
        final GroupFolder groupFolder = new GroupFolder ( new GroupProvider () {

            @Override
            public String[] getGrouping ( final ItemDescriptor descriptor )
            {
                final String id = descriptor.getItem ().getInformation ().getName ();
                if ( id.length () >= 2 )
                {
                    return new String[] { String.valueOf ( id.charAt ( 0 ) ), String.valueOf ( id.charAt ( 1 ) ) };
                }
                else
                {
                    return null;
                }
            }
        }, new IDNameProvider () );
        queryFolderRoot.addChild ( "grouping1", groupFolder, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "Items with an ID of lenght >=2 will be pre-grouped by their first two characters" ) ).getMap () );

        DataItem item;
        final MapBuilder<String, Variant> builder = new MapBuilder<String, Variant> ();

        registerItem ( item = new MemoryDataItem ( "memory" ) );
        this.testFolder.add ( "memory", item, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "A memory cell that simply maps the output to its input." ) ).getMap () );

        registerItem ( item = new TestItem2 ( this, "memory-chained" ) );
        this.testFolder.add ( "memory-chained", item, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "A memory cell that simply maps the output to its input using a chain." ) ).getMap () );

        registerItem ( item = new TestItem1 ( "test-1" ) );
        this.testFolder.add ( "test-1", item, new MapBuilder<String, Variant> ().getMap () );

        DataItemCommand cmd;
        cmd = new DataItemCommand ( "hello", getOperationService () );
        cmd.addListener ( new DataItemCommand.Listener () {

            @Override
            public void command ( final Variant value )
            {
                System.out.println ( "Hello World!" );
            }
        } );
        registerItem ( item = cmd );
        helloWorldFolder.add ( "hello world", item, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "This cell triggers a command on the server. On the server it will print out 'Hello World'. On the client side you will see nothing ;-)" ) ).put ( "lang", Variant.valueOf ( "en" ) ).getMap () );
        helloWorldFolder.add ( "おはよう", item, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "This cell triggers a command on the server. On the server it will print out 'Hello World'. On the client side you will see nothing ;-)" ) ).put ( "lang", Variant.valueOf ( "ja" ) ).getMap () );
        helloWorldFolder.add ( "你好", item, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "This cell triggers a command on the server. On the server it will print out 'Hello World'. On the client side you will see nothing ;-)" ) ).put ( "lang", Variant.valueOf ( "zh" ) ).getMap () );
        helloWorldFolder.add ( "नमस्ते", item, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "This cell triggers a command on the server. On the server it will print out 'Hello World'. On the client side you will see nothing ;-)" ) ).put ( "lang", Variant.valueOf ( "hi" ) ).getMap () );
        helloWorldFolder.add ( "Hallo Welt!", item, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "This cell triggers a command on the server. On the server it will print out 'Hello World'. On the client side you will see nothing ;-)" ) ).put ( "lang", Variant.valueOf ( "de" ) ).getMap () );

        cmd = new DataItemCommand ( "command", getOperationService () );
        cmd.addListener ( new DataItemCommand.Listener () {

            @Override
            public void command ( final Variant value )
            {
                System.out.println ( "Command is: " + value.asString ( "<null>" ) );
            }
        } );
        registerItem ( item = cmd );
        this.testFolder.add ( "command", item, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "Like the 'hello world' item it will print out something on the server. Instead of using a fixed string the value that was written to it is used." ) ).getMap () );

        registerItem ( item = new TimeDataItem ( "time", this.timer ) );
        builder.clear ();
        builder.put ( "description", Variant.valueOf ( "Need the unix time in microseconds? You get it here!" ) );
        this.testFolder.add ( "time", item, builder.getMap () );
        this.changingItems.add ( new ItemDescriptor ( item, builder.getMap () ) );

        this.testFolder.add ( String.valueOf ( System.currentTimeMillis () ), item, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "Alias to 'time' but with a name that will change every server startup." ) ).getMap () );

        final MemoryChainedItem memoryChainedItem = new MemoryChainedItem ( this, "chained" );
        registerItem ( memoryChainedItem );
        this.testFolder.add ( "chained", memoryChainedItem, new MapBuilder<String, Variant> ().getMap () );

        registerItem ( item = new WriteDelayItem ( "write-delay", getOperationService () ) );
        this.testFolder.add ( "write delay", item, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "Simulate a long running write operation here. The value written to the data item is used as microsecond delay that the write operation will take." ) ).getMap () );

        registerItem ( item = new SuspendItem ( "suspendable" ) );
        builder.clear ();
        builder.put ( "description", Variant.valueOf ( "This item is suspendable and will print is suspend status when it changes. WriteAttributeResult can only be seen on the server itself." ) );
        this.testFolder.add ( "suspendable", item, builder.getMap () );
        this.changingItems.add ( new ItemDescriptor ( item, builder.getMap () ) );

        final FolderCommon memoryFolder = new FolderCommon ();
        rootFolder.add ( "memory-cell", memoryFolder, new HashMap<String, Variant> () );
        registerItem ( item = new MemoryCellItem ( this, "memory-cell", memoryFolder ) );
        memoryFolder.add ( "control", item, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "This is the control item of the data cell. Write to number of cells you want to this item. The memory cells wil be created dynamically." ) ).getMap () );
        addDataItemValidator ( new DataItemValidator () {

            @Override
            public boolean isValid ( final String itemId )
            {
                return itemId.matches ( "memory-cell-[0-9]+" );
            }
        } );

        // do some stuff in the query folders
        final Thread changeThread = new Thread ( new Runnable () {

            @Override
            public void run ()
            {
                while ( true )
                {
                    for ( final ItemDescriptor desc : Hive.this.changingItems )
                    {
                        queryFolderRoot.added ( desc );
                    }
                    addTransientItems ();
                    try
                    {
                        Thread.sleep ( 5 * 1000 );
                    }
                    catch ( final InterruptedException e )
                    {
                        e.printStackTrace ();
                    }
                    for ( final ItemDescriptor desc : Hive.this.changingItems )
                    {
                        queryFolderRoot.removed ( desc );
                    }
                    removeTransientItems ();
                    try
                    {
                        Thread.sleep ( 5 * 1000 );
                    }
                    catch ( final InterruptedException e )
                    {
                        e.printStackTrace ();
                    }
                }
            }
        } );
        changeThread.setDaemon ( true );
        changeThread.start ();

        setupExporter ( rootFolder );
    }

    @Override
    public String getHiveId ()
    {
        return "org.eclipse.scada.da.server.test";
    }

    private void setupExporter ( final FolderCommon rootFolder )
    {
        this.objectExporter = new ObjectExporter ( new FolderItemFactory ( this, rootFolder, "objectExporter", "objectExporter" ) );
        this.objectExporter.attachTarget ( this.testObject = new TestModelObject () );
        this.testObject.setLongValue ( 1234 );
    }

    public void addMemoryFactoryItem ( final FactoryMemoryCell item, final Map<String, Variant> browserAttributes )
    {
        final ItemDescriptor desc = new ItemDescriptor ( item, browserAttributes );
        this.queryFolderFactory.added ( desc );
        registerItem ( item );
    }

    public void removeMemoryFactoryItem ( final FactoryMemoryCell item )
    {
        unregisterItem ( item );
        this.queryFolderFactory.removeAllForItem ( item );
    }

    protected void addTransientItems ()
    {
        DataItem transientItem;

        transientItem = new FactoryMemoryCell ( this, "transient-memory-cell-1" );
        registerItem ( transientItem );
        this.testFolder.add ( "transient", transientItem, new HashMap<String, Variant> () );
        this.transientItems.add ( transientItem );

        transientItem = new TimeDataItem ( "transient-time", this.timer );
        registerItem ( transientItem );
        this.testFolder.add ( "transient-time", transientItem, new HashMap<String, Variant> () );
        this.transientItems.add ( transientItem );
    }

    protected void removeTransientItems ()
    {
        for ( DataItem transientItem : this.transientItems )
        {
            this.testFolder.remove ( transientItem );
            unregisterItem ( transientItem );
            transientItem = null;
        }
        this.transientItems.clear ();
    }
}
