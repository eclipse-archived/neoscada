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
package org.eclipse.scada.configuration.generator.world.oscar.item;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.generator.world.oscar.Configurations;
import org.eclipse.scada.configuration.lib.Names;
import org.eclipse.scada.configuration.world.osgi.Item;

public final class Items
{
    private static final String delimiter = ".";

    private Items ()
    {
    }

    public static String makeId ( final Item item, final String tag )
    {
        return item.getName () + delimiter + tag;
    }

    public static String makeMasterId ( final Item item )
    {
        return makeId ( item, "master" ); //$NON-NLS-1$
    }

    private static void addAttribute ( final Map<String, String> attributes, final String key, final String value )
    {
        if ( value != null )
        {
            attributes.put ( key, value );
        }
    }

    public static Map<String, String> createInfoAttributes ( final Item item )
    {
        final Map<String, String> attributes = new HashMap<> ();

        Configurations.fillAttributesWithHierarchy ( attributes, Names.makeHierarchy ( item ) );

        attributes.put ( "item", item.getName () );

        if ( item.getInformation () != null )
        {
            addAttribute ( attributes, "system", item.getInformation ().getSystem () );
            addAttribute ( attributes, "unit", item.getInformation ().getUnit () );
            addAttribute ( attributes, "itemDescription", item.getInformation ().getDescription () );
        }

        return attributes;
    }

    public static void fillForMasterHandler ( final Map<String, String> data, final Item item, final int priority )
    {
        fillForMasterHandler ( data, item, priority, true );
    }

    public static void fillForMasterHandler ( final Map<String, String> data, final Item item, final int priority, final boolean infoAttributes )
    {
        if ( infoAttributes )
        {
            Configurations.applyInfoAttributes ( createInfoAttributes ( item ), data );
        }

        data.put ( "master.id", Items.makeMasterId ( item ) );

        data.put ( "handlerPriority", "" + priority );
    }
}
