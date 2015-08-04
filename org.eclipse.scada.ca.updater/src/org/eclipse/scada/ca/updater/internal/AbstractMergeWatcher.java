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

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.utils.concurrent.ScheduledExportedExecutorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractMergeWatcher
{
    private final static Logger logger = LoggerFactory.getLogger ( AbstractMergeWatcher.class );

    /**
     * The path we are interested in
     */
    private final Path path;

    private final long delay;

    private final TimeUnit timeUnit;

    private final WatchService ws;

    private final Thread runner;

    protected final boolean watchFile;

    /**
     * The path we are actually watching
     */
    private final Path watchPath;

    private final ScheduledExportedExecutorService executor;

    private long marker;

    public AbstractMergeWatcher ( Path path, final long delay, final TimeUnit timeUnit ) throws IOException
    {
        this.path = path;
        this.delay = delay;
        this.timeUnit = timeUnit;

        if ( !Files.exists ( path ) )
        {
            throw new IllegalArgumentException ( String.format ( "Failed to watch: %s. Path does not exists.", path ) );
        }

        this.ws = path.getFileSystem ().newWatchService ();

        if ( Files.isRegularFile ( path ) )
        {
            path = path.getParent ();
            logger.debug ( "Watching parent directory: {}", path );
            path.register ( this.ws, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE );
            this.watchFile = true;
        }
        else
        {
            logger.debug ( "Watching directory: {}", path );
            path.register ( this.ws, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE );
            this.watchFile = false;
        }

        this.watchPath = path;

        this.runner = new Thread () {
            @Override
            public void run ()
            {
                try
                {
                    logger.info ( "Starting scanner thread" );
                    scanner ();
                }
                finally
                {
                    logger.info ( "Exiting scanner thread" );
                }
            }
        };
        this.runner.start ();

        this.executor = ScheduledExportedExecutorService.newSingleThreadExportedScheduledExecutor ( "org.eclipse.scada.ca.updater/MergeWatcher" );
    }

    public void close () throws IOException
    {
        logger.info ( "Closing merge watcher" );
        this.ws.close ();
        try
        {
            this.runner.join ();
        }
        catch ( final InterruptedException e )
        {
            return;
        }
        logger.info ( "Merge watcher is shut down" );

        this.executor.shutdown ();
    }

    protected void scanner ()
    {
        logger.trace ( "Watching for events" );
        while ( true )
        {
            WatchKey key = null;
            try
            {
                key = this.ws.take ();
                logger.trace ( "Took events: {}", key.watchable () );

                final List<WatchEvent<?>> events = key.pollEvents ();
                for ( final WatchEvent<?> evt : events )
                {
                    processEvent ( evt );
                }
            }
            catch ( final InterruptedException | ClosedWatchServiceException e )
            {
                return;
            }
            finally
            {
                if ( key != null )
                {
                    key.reset ();
                }
            }
        }
    }

    private void processEvent ( final WatchEvent<?> evt )
    {
        logger.trace ( "Event: {} / {}", evt.kind (), evt );

        if ( evt.kind () == StandardWatchEventKinds.ENTRY_CREATE )
        {
            final Path path = (Path)evt.context ();
            logger.trace ( "Created: {}", path );
            processChange ( this.watchPath.resolve ( path ) );
        }
        else if ( evt.kind () == StandardWatchEventKinds.ENTRY_DELETE )
        {
            final Path path = (Path)evt.context ();
            logger.trace ( "Deleted: {}", path );
            processChange ( this.watchPath.resolve ( path ) );
        }
        else if ( evt.kind () == StandardWatchEventKinds.ENTRY_MODIFY )
        {
            final Path path = (Path)evt.context ();
            logger.trace ( "Modified: {}", path );
            processChange ( this.watchPath.resolve ( path ) );
        }
    }

    private void processChange ( final Path path )
    {
        logger.trace ( "Process change: {}", path );
        try
        {
            if ( this.watchFile && Files.isSameFile ( this.path, path ) )
            {
                triggerChange ();
            }
            else if ( !this.watchFile )
            {
                triggerChange ();
            }
        }
        catch ( final NoSuchFileException e )
        {
            // file already got deleted, ignore
        }
        catch ( final IOException e )
        {
            logger.debug ( "Failed to process change event", e );
        }
    }

    private void triggerChange ()
    {
        logger.info ( "Trigger change" );

        synchronized ( this )
        {
            this.marker++;
            final long marker = this.marker;

            this.executor.schedule ( new Runnable () {

                @Override
                public void run ()
                {
                    fireChange ( marker );
                }
            }, this.delay, this.timeUnit );
        }
    }

    protected void fireChange ( final long marker )
    {
        synchronized ( this )
        {
            logger.trace ( "Markers - current: {}, called: {}", this.marker, marker );

            if ( this.marker != marker )
            {
                // somebody else pushed our marker ... ignore
                return;
            }
        }

        processFireChange ();
    }

    protected abstract void processFireChange ();

}
