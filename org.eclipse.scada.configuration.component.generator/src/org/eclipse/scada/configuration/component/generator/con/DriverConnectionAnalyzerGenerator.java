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
package org.eclipse.scada.configuration.component.generator.con;

import org.eclipse.scada.configuration.component.DriverConnectionAnalyzer;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.lib.Locator;
import org.eclipse.scada.configuration.world.osgi.Connection;
import org.eclipse.scada.configuration.world.osgi.DataAccessConnection;
import org.eclipse.scada.configuration.world.osgi.MasterServer;

public class DriverConnectionAnalyzerGenerator extends ConnectionAnalyzerGenerator
{

    private final DriverConnectionAnalyzer analyzer;

    public DriverConnectionAnalyzerGenerator ( final DriverConnectionAnalyzer analyzer )
    {
        super ( analyzer );
        this.analyzer = analyzer;
    }

    @Override
    public void createItems ( final ItemCreator itemCreator )
    {
        final String name = this.analyzer.getConnection ().getName ();

        createForConnection ( itemCreator, new ConnectionProvider () {
            @Override
            public Connection getConnection ( final MasterServer master )
            {
                return Locator.findConnection ( master, name, DataAccessConnection.class );
            }
        } );
    }
}
