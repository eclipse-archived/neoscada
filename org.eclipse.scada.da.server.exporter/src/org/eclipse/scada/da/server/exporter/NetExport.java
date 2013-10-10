/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.da.server.net.Exporter;
import org.eclipse.scada.da.core.server.Hive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetExport implements Export
{

    private final static Logger logger = LoggerFactory.getLogger ( NetExport.class );

    private Hive hive = null;

    private Exporter exporter = null;

    private final ConnectionInformation connectionInformation;

    public NetExport ( final Hive hive, final ConnectionInformation connectionInformation ) throws Exception
    {
        super ();
        this.hive = hive;

        this.connectionInformation = connectionInformation;

        logger.debug ( "Instatiate exporter class" );

        this.exporter = new Exporter ( this.hive, this.connectionInformation );
    }

    @Override
    public synchronized void start () throws Exception
    {
        if ( this.exporter == null )
        {
            return;
        }

        logger.info ( "Starting exporter ({}) on port {}", this.hive, this.connectionInformation );

        this.exporter.start ();
    }

    @Override
    public void stop () throws Exception
    {
        this.exporter.stop ();
    }

    @Override
    public ConnectionInformation getConnectionInformation ()
    {
        return this.connectionInformation;
    }
}
