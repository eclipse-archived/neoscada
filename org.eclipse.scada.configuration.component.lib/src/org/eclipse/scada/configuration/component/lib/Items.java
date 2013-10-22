/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.DanglingItemReference;
import org.eclipse.scada.configuration.generator.GeneratorContext;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Items
{

    private static final String ATTR_LOCAL_TAG_MAP = "localTagMap";

    private final static Logger logger = LoggerFactory.getLogger ( Items.class );

    public static Item findMasterItem ( final MasterServer master, final String name )
    {
        // FIXME: speed up
        for ( final Item item : master.getItems () )
        {
            if ( item.getName ().equals ( name ) )
            {
                return item;
            }
        }
        return null;
    }

    public static Item replaceDanglingReference ( final GeneratorContext ctx, final MasterServer master, final Item item )
    {
        if ( ! ( item instanceof DanglingItemReference ) )
        {
            return item;
        }

        final DanglingItemReference dref = (DanglingItemReference)item;

        final Item replacement = Activator.getDefault ().getResolver ().resolveReference ( ctx, master, dref );

        if ( replacement == null )
        {
            throw new IllegalStateException ( String.format ( "Unable to find item for dangling reference: %s on %s", item, master ) );
        }

        logger.debug ( "Replacing item - {} -> {}", item, replacement );

        return replacement;
    }

    public static void replaceDanglingReferences ( final GeneratorContext ctx, final MasterServer master, final EList<Item> sourceItems )
    {
        final ArrayList<Item> items = new ArrayList<> ();

        for ( final Item item : sourceItems )
        {
            items.add ( replaceDanglingReference ( ctx, master, item ) );
        }

        // finally set the new item list
        ECollections.setEList ( sourceItems, items );
    }

    public static void registerMappedItem ( final GeneratorContext ctx, final Component component, final List<String> originalLocalTags, final Item item )
    {
        if ( component == null )
        {
            return;
        }

        @SuppressWarnings ( "unchecked" )
        Map<List<String>, Item> tagMap = (Map<List<String>, Item>)ctx.getAttribute ( component, ATTR_LOCAL_TAG_MAP );
        if ( tagMap == null )
        {
            tagMap = new HashMap<> ();
            ctx.setAttribute ( component, ATTR_LOCAL_TAG_MAP, tagMap );
        }
        tagMap.put ( originalLocalTags, item );
    }

    public static Item findMappedItem ( final GeneratorContext ctx, final Component component, final List<String> localTags )
    {
        @SuppressWarnings ( "unchecked" )
        final Map<List<String>, Item> tagMap = (Map<List<String>, Item>)ctx.getAttribute ( component, ATTR_LOCAL_TAG_MAP );
        if ( tagMap == null )
        {
            return null;
        }
        logger.debug ( "Mapped content: {}", tagMap );
        return tagMap.get ( localTags );
    }

    public static Item getMappedItem ( final GeneratorContext ctx, final Component component, final List<String> localTags )
    {
        final Item item = findMappedItem ( ctx, component, localTags );
        if ( item == null )
        {
            throw new IllegalStateException ( String.format ( "Unable to find item for local tag %s on component %s", localTags, component ) );
        }
        return item;
    }

}
