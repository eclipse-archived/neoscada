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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.scada.base.pipe.PipeService;
import org.eclipse.scada.base.pipe.Producer;
import org.eclipse.scada.base.pipe.Worker;
import org.eclipse.scada.base.pipe.WorkerAlreadyCreated;
import org.eclipse.scada.base.pipe.WorkerHandle;
import org.eclipse.scada.utils.io.RecursiveDeleteVisitor;
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

    static class MetaInfo
    {
        public MetaInfo ( final long timestamp, final long retry )
        {
            this.timestamp = timestamp;
            this.retry = retry;
        }

        long timestamp;

        long retry;
    }

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
            public void publish ( final byte[] data, final int retries ) throws IOException
            {
                publishEvent ( pipeName, data, retries );
            }
        };
    }

    protected void publishEvent ( final String pipeName, final byte[] data, final int retries ) throws IOException
    {
        final String name = encode ( pipeName );

        final MetaInfo info = new MetaInfo ( 0, retries );
        final File file = makeFile ( name, info );

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

    File makeFile ( final String pipeName, final MetaInfo info )
    {
        long time;
        final long retry = info == null ? 0 : info.retry;

        if ( info == null || info.timestamp <= 0 )
        {
            time = System.currentTimeMillis ();
        }
        else
        {
            time = info.timestamp;
        }

        final long value = this.counter.incrementAndGet ();

        final File queueDir = getQueueDir ( pipeName );

        return new File ( queueDir, String.format ( "%016x-%016x-%08x.evt", time, value, retry ) );
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

        final WorkerThread thread = new WorkerThread ( this, worker, pipeName );
        thread.setName ( "PipeWorkerThread/" + pipeName );

        this.workers.put ( pipeName, thread );
        thread.start ();

        return handle;
    }

    public Long fetchNextEvents ( final String pipeName, final int max, final List<File> result )
    {
        final File dir = getQueueDir ( pipeName );

        final File[] files = dir.listFiles ();
        Arrays.sort ( files );

        final long now = System.currentTimeMillis ();

        Long endTime = null;

        for ( final File file : files )
        {
            if ( !file.isFile () || !file.canRead () )
            {
                continue;
            }
            if ( file.getName ().endsWith ( ".evt" ) && file.length () > 0 )
            {
                logger.trace ( "Preparing: {}", file );

                final MetaInfo info = parse ( file.getName () );
                if ( info == null )
                {
                    logger.info ( "Broken file name: {}", file.getName () );
                    continue;
                }

                final long timestamp = info.timestamp;

                if ( timestamp > now )
                {
                    if ( endTime == null || endTime > timestamp )
                    {
                        if ( logger.isTraceEnabled () )
                        {
                            logger.trace ( "Setting end time to {} (in {} ms)", timestamp, timestamp - now );
                        }
                        endTime = timestamp;
                    }
                    logger.debug ( "Postponed item: {}", file.getName () );
                    continue;
                }

                result.add ( file );
            }
            if ( max > 0 && result.size () > max )
            {
                // abort since we are full
                return endTime;
            }
        }

        return endTime;
    }

    private static final Pattern FILE_PATTERN = Pattern.compile ( "([0-9a-z]+)-([0-9a-z]+)-([0-9a-z]+)\\.evt", Pattern.CASE_INSENSITIVE );

    static MetaInfo parse ( final String n )
    {
        final Matcher m = FILE_PATTERN.matcher ( n );
        if ( !m.matches () )
        {
            return null;
        }

        final long timestamp = Long.parseLong ( m.group ( 1 ), 16 );
        final long retry = Long.parseLong ( m.group ( 3 ), 16 );

        return new MetaInfo ( timestamp, retry );
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
            if ( f.length () <= 0 )
            {
                continue;
            }
            final MetaInfo info = parse ( f.getName () );
            if ( info == null )
            {
                continue;
            }

            final List<String> row = new LinkedList<> ();
            row.add ( f.getName () );
            row.add ( "" + f.length () );
            row.add ( String.format ( "%tc", new Date ( f.lastModified () ) ) );
            row.add ( String.format ( "%tc", new Date ( info.timestamp ) ) );
            row.add ( "" + info.retry );
            rows.add ( row );
        }
        Tables.showTable ( System.out, Arrays.asList ( "Name", "Size", "Entry Date", "Schedule", "Retry" ), rows, 3 );
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
                else if ( toks.length > 0 && toks[0].equals ( "error" ) )
                {
                    throw new RuntimeException ( "Test Exception" );
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
        publishEvent ( pipeName, StandardCharsets.UTF_8.encode ( data ).array (), 2 );
    }

    public void drop ( final String pipeName ) throws IOException
    {
        final File dir = getQueueDir ( pipeName );

        File ndir;
        int i = 0;
        do
        {
            ndir = new File ( dir.getName () + "-" + i );
            i++;
        } while ( ndir.exists () );

        Files.move ( dir.toPath (), ndir.toPath (), StandardCopyOption.ATOMIC_MOVE );
        Files.walkFileTree ( ndir.toPath (), new RecursiveDeleteVisitor () );
    }
}
