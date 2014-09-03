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
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.eclipse.scada.base.pipe.PipeService;
import org.eclipse.scada.base.pipe.Producer;
import org.eclipse.scada.base.pipe.Worker;
import org.eclipse.scada.base.pipe.WorkerAlreadyCreated;
import org.eclipse.scada.base.pipe.WorkerHandle;
import org.eclipse.scada.utils.str.Tables;
import org.osgi.framework.FrameworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PipeServiceImpl implements PipeService
{
    private final static Logger logger = LoggerFactory.getLogger ( PipeServiceImpl.class );

    private final File storage;

    private final AtomicLong counter = new AtomicLong ();

    private final Map<String, WorkerThread> workers = new HashMap<> ();

    private boolean started;

    private WorkerHandle testWorker;

    public PipeServiceImpl ()
    {
        this ( getDefaultDirectory () );
    }

    public PipeServiceImpl ( final File storage )
    {
        if ( !storage.isDirectory () )
        {
            throw new IllegalStateException ( String.format ( "'%s' is not a directory", storage ) );
        }
        this.storage = storage;
    }

    public synchronized void start ()
    {
        if ( this.started )
        {
            return;
        }
        this.started = true;
    }

    public synchronized void stop ()
    {
        if ( !this.started )
        {
            return;
        }
        this.started = false;

        for ( final WorkerThread thread : this.workers.values () )
        {
            thread.close ();
        }
        this.workers.clear ();
    }

    public static File getDefaultDirectory ()
    {
        final String dir = System.getProperty ( "org.eclipse.scada.base.pipe.storage", null );

        final File fdir;
        if ( dir == null )
        {
            final File base = FrameworkUtil.getBundle ( PipeServiceImpl.class ).getDataFile ( null );
            if ( base == null )
            {
                throw new IllegalStateException ( "Unable to get root folder of bundle data directory" );
            }

            fdir = new File ( base, "storage" );
        }
        else
        {
            fdir = new File ( dir );
        }

        if ( !fdir.exists () )
        {
            fdir.mkdirs ();
        }

        if ( !fdir.isDirectory () )
        {
            throw new IllegalStateException ( String.format ( "'%s' is not a valid directory or could not be created", fdir ) );
        }

        return fdir;
    }

    @Override
    public Producer createProducer ( final String pipeName )
    {
        return new Producer () {

            @Override
            public void publish ( final byte[] data ) throws IOException
            {
                publishEvent ( pipeName, data );
            }
        };
    }

    protected void publishEvent ( final String pipeName, final byte[] data ) throws IOException
    {
        final String name = encode ( pipeName );

        final File file = makeFile ( name );

        logger.trace ( "Block file: {}", file );

        if ( !file.createNewFile () )
        {
            throw new IllegalStateException ( String.format ( "File '%s' already exists", file ) );
        }

        final File partFile = new File ( file.getAbsolutePath () + ".part" );
        logger.trace ( "Part file: {}", partFile );
        try
        {
            Files.write ( partFile.toPath (), data, StandardOpenOption.CREATE_NEW );
            Files.move ( partFile.toPath (), file.toPath (), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING );
            logger.trace ( "Created data file: {} bytes", data.length );
        }
        finally
        {
            if ( partFile.exists () )
            {
                logger.trace ( "Delete part file: {}", partFile );
                partFile.delete ();
            }
        }

        notifyConsumer ( pipeName );
    }

    private synchronized void notifyConsumer ( final String pipeName )
    {
        final WorkerThread thread = this.workers.get ( pipeName );
        if ( thread != null )
        {
            logger.debug ( "Notify consumer thread: {} -> {}", pipeName, thread );
            thread.notifyNewEvent ();
        }
    }

    private File makeFile ( final String pipeName )
    {
        final long time = System.currentTimeMillis ();
        final long value = this.counter.incrementAndGet ();

        final File queueDir = getQueueDir ( pipeName );

        return new File ( queueDir, String.format ( "%08x-%08x.evt", time, value ) );
    }

    private File getQueueDir ( final String pipeName )
    {
        final File queueDir = new File ( this.storage, pipeName );
        if ( !queueDir.exists () )
        {
            queueDir.mkdir ();
        }
        if ( !queueDir.isDirectory () )
        {
            throw new IllegalStateException ( String.format ( "Unable to create queue dir: '%s'", queueDir ) );
        }
        return queueDir;
    }

    private String encode ( final String name )
    {
        try
        {
            return URLEncoder.encode ( name, "UTF-8" );
        }
        catch ( final UnsupportedEncodingException e )
        {
            return name;
        }
    }

    private class WorkerThread extends Thread
    {
        private final Worker worker;

        private final String pipeName;

        private boolean closing;

        @SuppressWarnings ( "unused" )
        private boolean closed;

        public WorkerThread ( final Worker worker, final String pipeName )
        {
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
                    List<File> files;

                    synchronized ( WorkerThread.this )
                    {
                        files = fetchNextEvents ( this.pipeName );

                        logger.trace ( "Files found: {}", files.size () );
                        if ( files.isEmpty () )
                        {
                            try
                            {
                                logger.trace ( "Waiting for new content" );
                                wait ();
                            }
                            catch ( final InterruptedException e )
                            {
                            }
                        }
                    }

                    if ( !files.isEmpty () )
                    {
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
                                try
                                {
                                    this.worker.work ( data );
                                }
                                catch ( final Exception e )
                                {
                                    logger.info ( "Worker failed", e );
                                }
                                Files.delete ( file.toPath () );
                            }
                            catch ( final IOException e )
                            {
                                logger.info ( "Failed to process file: " + file, e );
                            }
                        }
                        files.clear ();
                    }
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

    @Override
    public synchronized WorkerHandle createWorker ( final String pipeName, final Worker worker ) throws WorkerAlreadyCreated
    {
        if ( this.workers.containsKey ( pipeName ) )
        {
            throw new WorkerAlreadyCreated ( String.format ( "The consumer '%s' has already been created", pipeName ) );
        }

        final WorkerHandle handle = new WorkerHandle () {

            @Override
            public void close ()
            {
                performClose ( pipeName );
            }
        };

        final WorkerThread thread = new WorkerThread ( worker, pipeName );
        thread.setName ( "PipeWorkerThread/" + pipeName );

        this.workers.put ( pipeName, thread );
        thread.start ();

        return handle;
    }

    public List<File> fetchNextEvents ( final String pipeName )
    {
        final File dir = getQueueDir ( pipeName );

        final File[] files = dir.listFiles ();
        Arrays.sort ( files );

        final List<File> result = new LinkedList<> ();

        for ( final File file : files )
        {
            if ( !file.isFile () || !file.canRead () )
            {
                continue;
            }
            if ( file.getName ().endsWith ( ".evt" ) && file.length () > 0 )
            {
                logger.trace ( "Preparing: {}", file );
                result.add ( file );
            }
        }

        return result;
    }

    public void processNextEvent ( final Worker worker, final String pipeName ) throws IOException
    {
        final File dir = getQueueDir ( pipeName );

        final File[] files = dir.listFiles ();
        Arrays.sort ( files );

        for ( final File file : files )
        {
            if ( !file.isFile () || !file.canRead () )
            {
                continue;
            }
            if ( file.getName ().endsWith ( ".evt" ) && file.length () > 0 )
            {
                logger.trace ( "Processing: {}", file );
                final byte[] data = Files.readAllBytes ( file.toPath () );
                try
                {
                    worker.work ( data );
                }
                catch ( final Exception e )
                {
                    logger.info ( "Worker failed", e );
                }
                Files.delete ( file.toPath () );
            }
        }
    }

    protected synchronized void performClose ( final String pipeName )
    {
        final WorkerThread thread = this.workers.remove ( pipeName );
        if ( thread != null )
        {
            thread.close ();
        }
    }

    public void pipes ()
    {
        for ( final File file : this.storage.listFiles () )
        {
            if ( !file.isDirectory () )
            {
                continue;
            }

            final String pipeName = decode ( file.getName () );
            System.out.println ( pipeName );
        }
    }

    public void list ( final String pipeName )
    {
        final File dir = getQueueDir ( pipeName );

        final List<List<String>> rows = new LinkedList<> ();

        final File[] files = dir.listFiles ();
        Arrays.sort ( files );

        for ( final File f : files )
        {
            if ( !f.isFile () )
            {
                continue;
            }
            if ( !f.getName ().endsWith ( ".evt" ) )
            {
                continue;
            }
            if ( f.length () <= 0 )
            {
                continue;
            }
            final List<String> row = new LinkedList<> ();
            row.add ( f.getName () );
            row.add ( "" + f.length () );
            row.add ( String.format ( "%tc", new Date ( f.lastModified () ) ) );
            rows.add ( row );
        }
        Tables.showTable ( System.out, Arrays.asList ( "Name", "Size", "Entry Date" ), rows, 1 );
    }

    private String decode ( final String name )
    {
        try
        {
            return URLDecoder.decode ( name, "UTF-8" );
        }
        catch ( final UnsupportedEncodingException e )
        {
            return name;
        }
    }

    public void startTestWorker ( final String pipeName ) throws WorkerAlreadyCreated
    {
        final PrintStream os = System.out;

        this.testWorker = createWorker ( pipeName, new Worker () {

            @Override
            public void work ( final byte[] data )
            {
                os.format ( "Pipe event - size: %s, data: %s%n", data.length, data );
                os.flush ();

                final String str = StandardCharsets.UTF_8.decode ( ByteBuffer.wrap ( data ) ).toString ();

                os.format ( "\tString: %s%n", str );
                os.flush ();

                final String[] toks = str.split ( " " );
                if ( toks.length > 1 && toks[0].equals ( "sleep" ) )
                {
                    try
                    {
                        os.println ( "Sleeping..." );
                        os.flush ();
                        Thread.sleep ( Integer.parseInt ( toks[1] ) * 1000 );
                        os.println ( "Sleeping... done!" );
                        os.flush ();
                    }
                    catch ( NumberFormatException | InterruptedException e )
                    {
                        e.printStackTrace ( os );
                    }
                }
            }
        } );
    }

    public void closeTestWorker ()
    {
        if ( this.testWorker != null )
        {
            this.testWorker.close ();
        }
    }

    public void testPublish ( final String pipeName, final String data ) throws IOException
    {
        publishEvent ( pipeName, StandardCharsets.UTF_8.encode ( data ).array () );
    }
}
