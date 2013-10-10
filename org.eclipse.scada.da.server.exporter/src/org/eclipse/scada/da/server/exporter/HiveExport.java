/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.da.core.server.Hive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HiveExport
{

    private final static Logger logger = LoggerFactory.getLogger ( HiveExport.class );

    private final Hive hive;

    private final Collection<Export> exports = new CopyOnWriteArrayList<Export> ();

    public HiveExport ( final Hive hive )
    {
        super ();
        this.hive = hive;
    }

    public synchronized void start () throws Exception
    {
        logger.info ( "Starting hive: {}", this.hive );

        this.hive.start ();

        for ( final Export export : this.exports )
        {
            try
            {
                export.start ();
            }
            catch ( final Exception e )
            {
                logger.error ( "Failed to start export", e );
            }
        }
    }

    public synchronized void stop () throws Exception
    {
        logger.info ( "Stopping hive: {}", this.hive );

        for ( final Export export : this.exports )
        {
            try
            {
                export.stop ();
            }
            catch ( final Exception e )
            {
                logger.error ( "Failed to stop export", e );
            }
        }

        this.hive.stop ();
    }

    public Export addExport ( final String endpointUri ) throws ConfigurationException
    {
        logger.info ( "Adding export: {}", endpointUri );

        final ConnectionInformation ci = ConnectionInformation.fromURI ( endpointUri );
        final Export export = findExport ( ci );

        if ( export != null )
        {
            this.exports.add ( export );
        }
        else
        {
            logger.info ( "No exporter found for endpoint: {}", endpointUri );
            throw new ConfigurationException ( String.format ( "No exporter found for endpoint: %s", endpointUri ) );
        }

        return export;
    }

    protected Export findExport ( final ConnectionInformation ci ) throws ConfigurationException
    {
        logger.info ( "Requested export to: {}", ci );

        if ( !ci.getInterface ().equalsIgnoreCase ( "da" ) )
        {
            throw new ConfigurationException ( String.format ( "Interface must be 'da' but is '%s'", ci.getInterface () ) );
        }

        try
        {
            if ( ci.getDriver ().equalsIgnoreCase ( "net" ) || ci.getDriver ().equalsIgnoreCase ( "gmpp" ) )
            {
                logger.debug ( "Create new 'net' exporter" );
                return new NetExport ( this.hive, ci );
            }
            else if ( ci.getDriver ().equalsIgnoreCase ( "ngp" ) )
            {
                logger.debug ( "Create new 'ngp' exporter" );
                return new NgpExport ( this.hive, ci );
            }
            else
            {
                throw new ConfigurationException ( String.format ( "Driver '%s' is unknown", ci.getDriver () ) );
            }
        }
        catch ( final Throwable e )
        {
            throw new ConfigurationException ( "Failed to configure exporter", e );
        }
    }

    public Collection<Export> getExports ()
    {
        return Collections.unmodifiableCollection ( this.exports );
    }
}
