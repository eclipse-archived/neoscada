/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.base.pipe.internal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.base.pipe.Worker;
import org.eclipse.scada.base.pipe.internal.PipeServiceImpl.MetaInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class WorkerThread extends Thread
{
    private final static Logger logger = LoggerFactory.getLogger ( WorkerThread.class );

    private final PipeServiceImpl pipeService;

    private final Worker worker;

    private final String pipeName;

    private boolean closing;

    @SuppressWarnings ( "unused" )
    private boolean closed;

    public WorkerThread ( final PipeServiceImpl pipeServiceImpl, final Worker worker, final String pipeName )
    {
        this.pipeService = pipeServiceImpl;
        this.worker = worker;
        this.pipeName = pipeName;
    }

    @Override
    public void run ()
    {
        logger.info ( "Starting worker thread: {} -> {}", this.pipeName, this.worker );

        try
        {
            while ( !this.closing )
            {
                runOnce ();
            }
        }
        finally
        {
            logger.info ( "Closing worker thread" );
            synchronized ( WorkerThread.this )
            {
                this.closed = true;
                notifyAll ();
            }
        }
    }

    private void runOnce ()
    {
        final List<File> files = new LinkedList<> ();

        synchronized ( WorkerThread.this )
        {
            Long endWait = this.pipeService.fetchNextEvents ( this.pipeName, 100, files );

            logger.trace ( "Files found: {}", files.size () );
            if ( files.isEmpty () )
            {
                try
                {
                    logger.trace ( "Waiting for new content" );
                    if ( endWait != null )
                    {
                        final long delay = endWait - System.currentTimeMillis ();
                        if ( delay > 0 )
                        {
                            logger.trace ( "Waiting for {} ms ...", delay );
                            wait ( delay );
                        }
                        else
                        {
                            endWait = null;
                        }
                    }
                    else
                    {
                        logger.trace ( "Waiting..." );
                        wait ();
                    }
                }
                catch ( final InterruptedException e )
                {
                }
            }
        }

        if ( files.isEmpty () )
        {
            return;
        }

        logger.trace ( "Processing files" );
        for ( final File file : files )
        {
            if ( this.closing )
            {
                logger.debug ( "Early abort while processing..." );
                return;
            }
            try
            {
                logger.trace ( "Processing: {}", file );
                final byte[] data = Files.readAllBytes ( file.toPath () );
                boolean worked = false;
                try
                {
                    this.worker.work ( data );
                    worked = true;
                }
                catch ( final Exception e )
                {
                    logger.info ( "Worker failed", e );
                }
                if ( worked )
                {
                    // delete
                    Files.delete ( file.toPath () );
                }
                else
                {
                    // postpone
                    final MetaInfo info = PipeServiceImpl.parse ( file.getName () );
                    if ( info != null )
                    {
                        info.timestamp = System.currentTimeMillis () + 1_000 * 60;
                        info.retry--;
                    }
                    if ( info.retry > 0 )
                    {
                        final File newFile = this.pipeService.makeFile ( this.pipeName, info );
                        logger.debug ( "Postponing event - {} -> {}", file.getName (), newFile.getName () );
                        Files.move ( file.toPath (), newFile.toPath (), StandardCopyOption.ATOMIC_MOVE );
                    }
                    else
                    {
                        logger.debug ( "Purging event - {}", file.getName () );
                        Files.delete ( file.toPath () );
                    }
                }
            }
            catch ( final IOException e )
            {
                logger.info ( "Failed to process file: " + file, e );
            }
        }
    }

    public synchronized void notifyNewEvent ()
    {
        logger.trace ( "Notify worker thread" );
        notifyAll ();
    }

    public synchronized void close ()
    {
        this.closing = true;
        notifyAll ();
    }
}