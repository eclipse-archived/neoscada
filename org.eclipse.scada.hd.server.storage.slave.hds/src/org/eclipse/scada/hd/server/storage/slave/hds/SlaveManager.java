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
package org.eclipse.scada.hd.server.storage.slave.hds;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.hds.DataFilePool;
import org.eclipse.scada.utils.concurrent.ScheduledExportedExecutorService;
import org.eclipse.scada.utils.str.StringReplacer;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

public class SlaveManager
{

    private static final String BASE_PATH_PROP = "org.eclipse.scada.hd.server.storage.slave.hds.basePath";

    private ScheduledExecutorService executor;

    private final List<StorageManager> storageManagers = new LinkedList<> ();

    private DataFilePool pool;

    private ScheduledExportedExecutorService eventExecutor;

    public SlaveManager ()
    {
        final BundleContext bundleContext = FrameworkUtil.getBundle ( SlaveManager.class ).getBundleContext ();

        this.executor = new ScheduledExportedExecutorService ( BASE_PATH_PROP, 1 );
        this.eventExecutor = new ScheduledExportedExecutorService ( "org.eclipse.scada.hd.server.storage.slave.hds.events", 1 );

        this.pool = new DataFilePool ( Integer.getInteger ( "org.eclipse.scada.hd.server.storage.slave.hds.instanceCountTarget", 10 ) );

        final String basePaths = System.getProperty ( BASE_PATH_PROP );
        if ( basePaths == null || basePaths.isEmpty () )
        {
            throw new IllegalStateException ( String.format ( "Property '%s' must be set in order to activate bundle.", BASE_PATH_PROP ) );
        }

        try
        {
            for ( String path : basePaths.split ( ":" ) )
            {
                // replace variables in path, like "user.home"
                path = StringReplacer.replace ( path, System.getProperties () );
                if ( path.startsWith ( "@" ) )
                {
                    final File dir = new File ( path.substring ( 1 ) );
                    if ( !dir.isDirectory () )
                    {
                        throw new IllegalStateException ( String.format ( "'%s' is not a directory", dir ) );
                    }
                    // FIXME: this should be done periodically
                    for ( final File child : dir.listFiles () )
                    {
                        this.storageManagers.add ( new StorageManager ( bundleContext, child, this.pool, this.executor, this.eventExecutor ) );
                    }
                }
                else
                {
                    this.storageManagers.add ( new StorageManager ( bundleContext, new File ( path ), this.pool, this.executor, this.eventExecutor ) );
                }
            }
        }
        catch ( final Exception e )
        {
            dispose ();
            throw new RuntimeException ( "Failed to start up service", e );
        }
    }

    public void dispose ()
    {
        if ( this.pool != null )
        {
            this.pool.dispose ();
            this.pool = null;
        }

        for ( final StorageManager manager : this.storageManagers )
        {
            manager.dispose ();
        }
        this.storageManagers.clear ();

        if ( this.executor != null )
        {
            this.executor.shutdown ();
            this.executor = null;
        }

        if ( this.eventExecutor != null )
        {
            this.eventExecutor.shutdown ();
            this.eventExecutor = null;
        }
    }

    public void listslaves ()
    {
        for ( final StorageManager sm : this.storageManagers )
        {
            System.out.println ( sm.getBase () );
        }
    }

    public void dumpslaves ()
    {
        for ( final StorageManager sm : this.storageManagers )
        {
            System.out.println ( ">>>>>>>>>>>>>>>>>>>> " + sm.getBase () );
            sm.listfiles ( System.out );
            System.out.println ( "<<<<<<<<<<<<<<<<<<<< " + sm.getBase () );
        }
    }

}
