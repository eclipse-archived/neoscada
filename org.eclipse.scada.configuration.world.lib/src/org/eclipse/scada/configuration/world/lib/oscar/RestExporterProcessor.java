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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.lib.Properties;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.RestExporter;

public class RestExporterProcessor extends TypedOscarProcessor<RestExporter>
{

    public RestExporterProcessor ()
    {
        super ( RestExporter.class );
    }

    @Override
    protected void process ( final RestExporter exporter, final EquinoxApplication app, final OscarContext ctx, final IProgressMonitor monitor )
    {
        final Map<String, String> data = new HashMap<String, String> ( exporter.getItems ().size () + exporter.getHiveProperties ().size () );

        data.putAll ( Properties.makeAttributes ( "hiveProperties.", exporter.getHiveProperties () ) );

        for ( final Item item : exporter.getItems () )
        {
            data.put ( "items." + item.getName (), item.getName () );
        }

        ctx.addData ( Factories.FACTORY_DA_REST_EXPORTER, exporter.getContextId (), data );
    }

}
