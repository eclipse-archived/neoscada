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
package org.eclipse.scada.configuration.lib;

import org.eclipse.scada.configuration.world.osgi.DataAccessExporter;
import org.eclipse.scada.configuration.world.osgi.Exporter;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.ItemExport;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.ValueArchive;
import org.eclipse.scada.configuration.world.osgi.ValueArchiveServer;

public class Items
{
    public static void addItem ( final MasterServer master, final Item item )
    {
        // adding item
        master.getItems ().add ( item );

        // export item on all DA exporters

        for ( final Exporter exporter : master.getExporter () )
        {
            if ( exporter instanceof DataAccessExporter )
            {
                final ItemExport itemExport = OsgiFactory.eINSTANCE.createItemExport ();
                itemExport.setExportName ( item.getName () );
                itemExport.setItem ( item );
                ( (DataAccessExporter)exporter ).getExports ().add ( itemExport );
            }
        }
    }

    public static void addArchive ( final ValueArchiveServer archiveServer, final Item item )
    {
        final ValueArchive archive = OsgiFactory.eINSTANCE.createValueArchive ();
        archiveServer.getArchives ().add ( archive );
        archive.setName ( item.getName () );

        archive.getItems ().add ( item );
    }

}
