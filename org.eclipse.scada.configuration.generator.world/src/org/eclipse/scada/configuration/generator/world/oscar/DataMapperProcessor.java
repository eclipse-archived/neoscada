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

import org.eclipse.scada.configuration.lib.Names;
import org.eclipse.scada.configuration.world.osgi.DataMapper;
import org.eclipse.scada.configuration.world.osgi.DataMapperEntry;
import org.eclipse.scada.configuration.world.osgi.JdbcDataMapper;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.SimpleDataMapper;

public class DataMapperProcessor extends BasicOscarProcessor
{
    private final MasterServer app;

    public DataMapperProcessor ( final MasterServer app, final OscarContext ctx )
    {
        super ( app, ctx );
        this.app = app;
    }

    public void process ()
    {
        for ( final DataMapper dataMapper : this.app.getDataMapper () )
        {
            if ( dataMapper instanceof SimpleDataMapper )
            {
                processSimple ( (SimpleDataMapper)dataMapper );
            }
            else if ( dataMapper instanceof JdbcDataMapper )
            {
                processJdbc ( (JdbcDataMapper)dataMapper );
            }
        }
    }

    private void processJdbc ( final JdbcDataMapper dataMapper )
    {
        final Map<String, String> data = new HashMap<String, String> ();

        data.put ( "jdbcDriver", dataMapper.getJdbcDriver () );
        data.put ( "sql", dataMapper.getSql () );

        data.putAll ( Helper.makeAttributes ( "properties.", dataMapper.getProperties () ) );

        addData ( Factories.FACTORY_JDBC_DATA_MAPPER, Names.makeName ( dataMapper ), data );
    }

    private void processSimple ( final SimpleDataMapper dataMapper )
    {
        final Map<String, String> data = new HashMap<String, String> ();

        for ( final DataMapperEntry entry : dataMapper.getEntries () )
        {
            data.put ( "data." + entry.getKey (), entry.getValue () );
        }

        addData ( Factories.FACTORY_SIMPLE_DATA_MAPPER, Names.makeName ( dataMapper ), data );
    }

}
