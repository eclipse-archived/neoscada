/*******************************************************************************
 * Copyright (c) 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.updater.internal;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator
{
    private final static Logger logger = LoggerFactory.getLogger ( Activator.class );

    private AbstractMergeWatcher mergeWatcher;

    private long settleTimeout;

    private SingleServiceTracker<ConfigurationAdministrator> tracker;

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.settleTimeout = Long.getLong ( "org.eclipse.scada.ca.updater.watcher.settleTimeout", 10_000 );

        if ( !Boolean.getBoolean ( "org.eclipse.scada.ca.updater.active" ) )
        {
            return;
        }

        this.tracker = new SingleServiceTracker<> ( context, ConfigurationAdministrator.class, new SingleServiceListener<ConfigurationAdministrator> () {

            @Override
            public void serviceChange ( final ServiceReference<ConfigurationAdministrator> reference, final ConfigurationAdministrator service )
            {
                setService ( service );
            }
        } );
        this.tracker.open ();
    }

    protected void setService ( final ConfigurationAdministrator service )
    {
        logger.info ( "Service change -> {}", service );

        try
        {
            closeMergeWatcher ();
        }
        catch ( final IOException e )
        {
            logger.warn ( "Failed to close watcher", e );
        }

        if ( service != null )
        {
            this.mergeWatcher = startMergeWatcher ( service );
        }
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.tracker.close ();
        closeMergeWatcher ();
    }

    private void closeMergeWatcher () throws IOException
    {
        if ( this.mergeWatcher != null )
        {
            this.mergeWatcher.close ();
            this.mergeWatcher = null;
        }
    }

    private AbstractMergeWatcher startMergeWatcher ( final ConfigurationAdministrator admin )
    {
        final Path path = findMergePath ();
        if ( path != null )
        {
            try
            {
                return new UpdatingMergeWatcher ( admin, path, this.settleTimeout, TimeUnit.MILLISECONDS );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to start merge watcher", e );
            }
        }

        logger.warn ( "Automatic configuration merger is active, but no merge path could be found!" );

        return null;
    }

    private Path findMergePath ()
    {
        try
        {
            Path path;

            path = findMergePathFrom ( "org.eclipse.scada.ca.updater.mergeUrl" );
            if ( path != null )
            {
                return path;
            }

            path = findMergePathFrom ( "org.eclipse.scada.ca.file.provisionJsonUrl" );
            if ( path != null )
            {
                return path;
            }

            // finally ... nothing

            return null;
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to find merge URI", e );
            return null;
        }
    }

    private Path findMergePathFrom ( final String propertyName )
    {
        try
        {
            final String uriValue = System.getProperty ( propertyName );
            if ( uriValue == null )
            {
                return null;
            }
            final Path path = Paths.get ( URI.create ( uriValue ) );
            if ( path == null )
            {
                return null;
            }
            return path;
        }
        catch ( final Exception e )
        {
            logger.warn ( String.format ( "Failed to find merge URI from '%s'", propertyName ), e );
            return null;
        }
    }

}
