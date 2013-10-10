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
package org.eclipse.scada.hd.server.storage.slave.hds;

import java.io.File;
import java.io.IOException;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseWatcher
{

    private final static Logger logger = LoggerFactory.getLogger ( BaseWatcher.class );

    private final Path base;

    private final WatchService watcher;

    private final WatchKey baseKey;

    private final StorageManager storageManager;

    private final Map<Path, StorageWatcher> watcherMap = new HashMap<Path, StorageWatcher> ();

    private static class StorageWatcher
    {
        private final StorageManager storageManager;

        private final Path path;

        private final BaseWatcher baseWatcher;

        private final WatchKey key;

        private WatchKey nativeKey;

        private String id;

        private final WatchService watcher;

        public StorageWatcher ( final StorageManager storageManager, final BaseWatcher baseWatcher, final Path path, final WatchService watcher ) throws IOException
        {
            this.storageManager = storageManager;
            this.baseWatcher = baseWatcher;
            this.watcher = watcher;
            this.path = path;

            this.key = path.register ( watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY );
            baseWatcher.addWatcherMap ( path, this );
            baseWatcher.addWatcherMap ( new File ( path.toFile (), "native" ).toPath (), this );

            final File nativeDir = new File ( path.toFile (), "native" );
            if ( nativeDir.exists () && nativeDir.isDirectory () )
            {
                this.nativeKey = nativeDir.toPath ().register ( this.watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE );
                check ();
            }
        }

        public void check ()
        {
            final String id = this.storageManager.probe ( this.path.toFile () );
            if ( id == null )
            {
                logger.info ( "Path {} is not a valid storage", this.path );
                storageRemoved ();
            }
            else
            {
                storageAdded ( id );
            }
        }

        private void storageRemoved ()
        {
            if ( this.id != null )
            {
                this.baseWatcher.removeStorage ( this.id, this.path.toFile () );
                this.id = null;
            }
        }

        private void storageAdded ( final String id )
        {
            try
            {
                this.id = null;
                this.baseWatcher.addStorage ( id, this.path.toFile () );
                this.id = id;
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to add storage", e );
            }
        }

        public void dispose ()
        {
            this.baseWatcher.removeWatcherMap ( this.path );
            this.baseWatcher.removeWatcherMap ( new File ( this.path.toFile (), "native" ).toPath () );

            this.key.cancel ();

            if ( this.nativeKey != null )
            {
                this.nativeKey.cancel ();
                this.nativeKey = null;
            }

            if ( this.id != null )
            {
                this.baseWatcher.removeStorage ( this.id, this.path.toFile () );
            }
        }

        public void handleEvent ( final Path watchable, final WatchEvent<?> event ) throws IOException
        {
            final Path path = (Path)event.context ();
            logger.debug ( "Change {} for base: {} on {}", new Object[] { event.kind (), watchable, path } );

            if ( watchable.endsWith ( "native" ) && path.toString ().equals ( "settings.xml" ) )
            {
                if ( event.kind () != StandardWatchEventKinds.ENTRY_DELETE )
                {
                    check ();
                }
                else
                {
                    storageRemoved ();
                }
            }
            else
            {
                if ( path.toString ().equals ( "settings.xml" ) )
                {
                    if ( event.kind () == StandardWatchEventKinds.ENTRY_CREATE )
                    {
                        this.nativeKey = new File ( watchable.toFile (), "native" ).toPath ().register ( this.watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE );
                    }
                }
                else if ( path.toString ().endsWith ( ".hds" ) )
                {
                    if ( this.id != null )
                    {
                        this.storageManager.fileChanged ( this.path.toFile (), this.id, path.toFile () );
                    }
                }
            }
        }
    }

    public BaseWatcher ( final StorageManager storageManager, final File base ) throws IOException
    {
        this.storageManager = storageManager;
        this.base = base.toPath ();
        this.watcher = FileSystems.getDefault ().newWatchService ();

        this.baseKey = base.toPath ().register ( this.watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE );

        logger.debug ( "Checking for initial storages" );

        for ( final File child : this.base.toFile ().listFiles () )
        {
            logger.debug ( "Found initial storage dir - {}", child );
            checkAddStorage ( child.toPath () );
        }

        startWatcher ();
    }

    private final AtomicInteger threadCounter = new AtomicInteger ();

    private void startWatcher ()
    {
        final Thread t = new Thread ( "BaseWatcher/" + this.threadCounter.incrementAndGet () ) {
            @Override
            public void run ()
            {
                try
                {
                    runWatcher ();
                }
                catch ( final ClosedWatchServiceException e )
                {
                    logger.info ( "Watcher closed", e );
                }
                catch ( final Exception e )
                {
                    logger.warn ( "Watcher failed", e );
                    startWatcher ();
                }
            };
        };
        t.start ();
    }

    protected void runWatcher () throws Exception
    {
        for ( ;; )
        {
            final WatchKey key = this.watcher.take ();
            checkKey ( key );
        }
    }

    private void checkKey ( final WatchKey key ) throws IOException
    {
        if ( this.baseKey == key )
        {
            checkBaseEvents ( key, key.pollEvents () );
            if ( !this.baseKey.reset () )
            {
                logger.warn ( "Base key got invalidated" );
                this.watcher.close ();
            }
        }
        else
        {
            final Path base = (Path)key.watchable ();

            if ( ! ( key.watchable () instanceof Path ) )
            {
                // don't reset
                return;
            }

            final StorageWatcher w = this.watcherMap.get ( base );
            if ( w == null )
            {
                logger.info ( "Event for unknown target: {}", base );
                // don't reset
                return;
            }
            try
            {
                for ( final WatchEvent<?> event : key.pollEvents () )
                {
                    if ( ! ( event.context () instanceof Path ) )
                    {
                        continue;
                    }

                    w.handleEvent ( (Path)key.watchable (), event );
                }
            }
            finally
            {
                if ( !key.reset () )
                {
                    w.dispose ();
                }
            }
        }
    }

    protected void addWatcherMap ( final Path path, final StorageWatcher watcher )
    {
        this.watcherMap.put ( path, watcher );
    }

    protected void removeWatcherMap ( final Path path )
    {
        this.watcherMap.remove ( path );
    }

    private void checkBaseEvents ( final WatchKey key, final List<WatchEvent<?>> events )
    {
        for ( final WatchEvent<?> event : events )
        {
            if ( ! ( event.context () instanceof Path ) )
            {
                continue;
            }

            final Path path = this.base.resolve ( (Path)event.context () );

            logger.debug ( "Event for {}, {} : {} -> {}", new Object[] { event.context (), key.watchable (), event.kind (), path } );

            if ( event.kind () == StandardWatchEventKinds.ENTRY_DELETE )
            {
                // check delete
                checkDeleteStorage ( path );
            }
            else
            {
                try
                {
                    checkAddStorage ( path );
                }
                catch ( final IOException e )
                {
                    logger.warn ( "Failed to check for storage", e );
                }
            }
        }
    }

    private void checkDeleteStorage ( final Path path )
    {
        final StorageWatcher w = this.watcherMap.remove ( path );
        if ( w != null )
        {
            logger.debug ( "Disposing watcher {}", path );
            w.dispose ();
        }
    }

    private void checkAddStorage ( final Path path ) throws IOException
    {
        if ( !this.watcherMap.containsKey ( path ) )
        {
            logger.debug ( "Creating new StorageWatcher for {}", path );
            new StorageWatcher ( this.storageManager, this, path, this.watcher );
        }
        else
        {
            logger.debug ( "Path already known" );
        }
    }

    /**
     * Add a new storage that was found
     * 
     * @param id
     *            the ID of the storage
     * @param file
     *            the base directory of the storage
     * @throws Exception
     */
    protected void addStorage ( final String id, final File file ) throws Exception
    {
        logger.info ( "Add storage: {} - {}", id, file );
        this.storageManager.addStorage ( file );
    }

    /**
     * Remove a storage that was registered earlier
     * 
     * @param id
     *            the ID of the storage to remove
     * @param file
     */
    public void removeStorage ( final String id, final File file )
    {
        logger.info ( "Removing storage: {}", id );
        this.storageManager.removeStorage ( file );
    }

    public void dispose ()
    {
        for ( final StorageWatcher sw : this.watcherMap.values () )
        {
            sw.dispose ();
        }
        this.watcherMap.clear ();

        if ( this.watcher != null )
        {
            try
            {
                this.watcher.close ();
            }
            catch ( final IOException e )
            {
                logger.warn ( "Failed to close WatchService", e );
            }
        }

    }
}
