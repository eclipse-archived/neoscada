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
package org.eclipse.scada.configuration.generator.world.oscar;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.generator.world.oscar.item.Items;
import org.eclipse.scada.configuration.lib.Names;
import org.eclipse.scada.configuration.world.osgi.DataAccessExporter;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.Exporter;
import org.eclipse.scada.configuration.world.osgi.ItemExport;
import org.eclipse.scada.configuration.world.osgi.ItemInformation;

public class ItemExportProcessor extends BasicOscarProcessor
{

    private final EquinoxApplication app;

    public ItemExportProcessor ( final EquinoxApplication app, final OscarContext ctx )
    {
        super ( app, ctx );
        this.app = app;
    }

    public void process ()
    {
        for ( final Exporter exporter : this.app.getExporter () )
        {
            if ( exporter instanceof DataAccessExporter )
            {
                processExporter ( (DataAccessExporter)exporter );
            }
        }
    }

    private void processExporter ( final DataAccessExporter exporter )
    {
        for ( final ItemExport export : exporter.getExports () )
        {
            final String masterId = Items.makeMasterId ( export.getItem () );

            final ItemInformation info = export.getItem ().getInformation ();
            final String description = info != null ? info.getDescription () : null;

            addAlias ( Names.makeName ( exporter ) + "/" + export.getExportName (), export.getExportName (), masterId, description );
        }
    }

    private void addAlias ( final String id, final String itemId, final String dataSourceId, final String description )
    {
        final Map<String, String> data = new HashMap<String, String> ();

        data.put ( "datasource.id", dataSourceId ); //$NON-NLS-1$
        data.put ( "item.id", itemId ); //$NON-NLS-1$
        if ( description != null )
        {
            data.put ( "description", description ); //$NON-NLS-1$
        }

        addData ( Factories.FACTORY_DA_EXPORTER, id, data );
    }

}
