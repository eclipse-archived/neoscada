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
package org.eclipse.scada.configuration.world.lib.oscar;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.scada.configuration.world.lib.oscar.item.Items;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.MarkerEntry;
import org.eclipse.scada.configuration.world.osgi.MarkerGroup;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.utils.str.StringHelper;

public class MarkerGroupProcessor extends BasicOscarProcessor
{

    private final MasterServer app;

    private final MasterHandlerPriorities priorities;

    public MarkerGroupProcessor ( final MasterServer app, final OscarContext ctx, final MasterHandlerPriorities priorities )
    {
        super ( app, ctx );
        this.app = app;
        this.priorities = priorities;
    }

    public void process ()
    {
        if ( this.app.getMarkers () == null )
        {
            return;
        }

        for ( final MarkerGroup group : this.app.getMarkers ().getMarkerGroups () )
        {
            final Map<String, String> attributes = new HashMap<> ();
            addMarker ( group.getName (), group.getItems (), group.getMarkers (), attributes );
        }
    }

    private void addMarker ( final String id, final Collection<Item> items, final Collection<MarkerEntry> entries, final Map<String, String> attributes )
    {
        final Map<String, String> data = new HashMap<> ();

        final int priority = this.priorities.findPriority ( Factories.FACTORY_MASTER_HANDLER_MARKER, id );
        data.put ( "handlerPriority", "" + priority );

        final Set<String> masterIds = new TreeSet<String> ();
        for ( final Item item : items )
        {
            masterIds.add ( Items.makeMasterId ( item ) );
        }

        data.put ( "master.id", StringHelper.join ( masterIds, ", " ) ); //$NON-NLS-1$ //$NON-NLS-2$
        data.put ( "exportAttribute", "true" ); //$NON-NLS-1$ //$NON-NLS-2$
        data.put ( "alwaysExport", "true" ); //$NON-NLS-1$ //$NON-NLS-2$

        for ( final MarkerEntry entry : entries )
        {
            data.put ( "marker." + entry.getName (), entry.getValue () == null ? "" : entry.getValue () ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        Configurations.applyInfoAttributes ( attributes, data );

        addData ( Factories.FACTORY_MASTER_HANDLER_MARKER, id, data );
    }

}
