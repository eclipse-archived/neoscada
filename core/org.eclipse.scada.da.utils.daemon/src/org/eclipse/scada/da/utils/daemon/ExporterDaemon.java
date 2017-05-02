/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.utils.daemon;

import java.io.File;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.eclipse.scada.da.server.exporter.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Wrapping the exporter controller into a jakarta daemon
 * 
 * @see Daemon
 * @author Jens Reimann
 */
public class ExporterDaemon implements Daemon
{

    private static final Logger logger = LoggerFactory.getLogger ( ExporterDaemon.class );

    private Controller controller;

    @Override
    public void destroy ()
    {
        this.controller = null;
    }

    @Override
    public void init ( final DaemonContext ctx ) throws Exception
    {
        logger.info ( "Initializing ExporterDaemon" );

        if ( ctx.getArguments ().length < 1 )
        {
            logger.warn ( "No arguments passed. No config file available" );
            throw new Exception ( "Invalid arguments: exporter <configfile>" );
        }

        final String fileName = ctx.getArguments ()[0];
        logger.info ( "Loading configuration from: {}", fileName );
        final File configFile = new File ( fileName );
        if ( !configFile.canRead () )
        {
            throw new Exception ( String.format ( "'%s' is not a file or can not be read", fileName ) );
        }

        this.controller = new Controller ( configFile );
    }

    @Override
    public void start () throws Exception
    {
        logger.info ( "Starting ExporterDaemon" );
        this.controller.start ();
    }

    @Override
    public void stop () throws Exception
    {
        logger.info ( "Stopping service" );
        this.controller.stop ();
    }

}
