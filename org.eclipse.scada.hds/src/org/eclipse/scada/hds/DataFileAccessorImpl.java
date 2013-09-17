/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hds;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataFileAccessorImpl implements DataFileAccessor
{
    private final static Logger logger = LoggerFactory.getLogger ( DataFileAccessorImpl.class );

    protected static final byte FLAG_DELETED = 0x08;

    protected static final byte FLAG_HEARTBEAT = 0x04;

    protected static final byte FLAG_MANUAL = 0x02;

    protected static final byte FLAG_ERROR = 0x01;

    protected static final int HEADER_SIZE = 4 + 4 + 8 + 8;

    private static final int ENTRY_SIZE = 8 + 8 + 1;

    protected RandomAccessFile file;

    protected final FileChannel channel;

    protected Date start;

    protected Date end;

    private final File fileInfo;

    public DataFileAccessorImpl ( final File file ) throws Exception
    {
        this.fileInfo = file;
        this.file = new RandomAccessFile ( file, "rw" );

        try
        {
            this.channel = this.file.getChannel ();

            final ByteBuffer buffer = ByteBuffer.allocate ( HEADER_SIZE );

            while ( buffer.hasRemaining () )
            {
                final int rc = this.channel.read ( buffer );
                if ( rc < 0 )
                {
                    break;
                }
                logger.debug ( "Read {} bytes", rc );
            }

            buffer.flip ();

            final int magic = buffer.getInt ();
            final int version = buffer.getInt ();
            this.start = new Date ( buffer.getLong () );
            this.end = new Date ( buffer.getLong () );

            logger.debug ( "Header - magic: {}, version: {}, start: {}, end: {}", new Object[] { magic, version, this.start, this.end } );

            if ( logger.isDebugEnabled () )
            {
                logger.debug ( "File position after header: {}", this.channel.position () );
            }

            // set position to end of file
            this.channel.position ( this.channel.size () );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to open file", e );
            this.file.close ();
            throw e;
        }
    }

    @Override
    public Date getStart ()
    {
        return this.start;
    }

    @Override
    public Date getEnd ()
    {
        return this.end;
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.hds.DataFileAccessor#insertValue(double, java.util.Date, boolean, boolean, boolean)
     */
    @Override
    public void insertValue ( final double value, final Date date, final boolean error, final boolean manual, final boolean heartbeat ) throws IOException
    {
        if ( logger.isDebugEnabled () )
        {
            logger.debug ( "File position - before: {}", this.channel.position () );
        }

        final ByteBuffer buffer = ByteBuffer.allocate ( 100 );
        buffer.putDouble ( value );
        buffer.putLong ( date.getTime () );

        byte flag;
        if ( heartbeat )
        {
            flag = FLAG_HEARTBEAT;
        }
        else
        {
            flag = (byte) ( ( error ? FLAG_ERROR : 0x00 ) | ( manual ? FLAG_MANUAL : 0x00 ) );
        }

        logger.debug ( "Writing flag: {}", flag );
        buffer.put ( flag );

        buffer.flip ();

        while ( buffer.hasRemaining () )
        {
            final int rc = this.channel.write ( buffer );
            if ( rc < 0 )
            {
                throw new IOException ( "Failed to write data" );
            }
            logger.debug ( "Wrote {} bytes", rc );
        }

        if ( logger.isDebugEnabled () )
        {
            logger.debug ( "File position - after: {}", this.channel.position () );
        }
    }

    @Override
    public boolean visitFirstValue ( final ValueVisitor visitor ) throws Exception
    {
        logger.debug ( "Welcome backwards seeking visitor: {}", visitor );

        final long startPosition = this.channel.position ();

        logger.debug ( "Seeking at position: {}", startPosition );

        final ByteBuffer buffer = ByteBuffer.allocate ( ENTRY_SIZE );

        try
        {
            while ( this.channel.position () > HEADER_SIZE )
            {
                logger.debug ( "At position: {}", this.channel.position () );

                this.channel.position ( this.channel.position () - ENTRY_SIZE );
                if ( read ( buffer ) != ENTRY_SIZE )
                {
                    break;
                }

                buffer.flip ();

                final double value = buffer.getDouble ();
                final Date timestamp = new Date ( buffer.getLong () );
                final byte flags = buffer.get ();

                logger.debug ( "Stumbled upon {}/{}/{} when searching backwards", new Object[] { value, timestamp, flags } );

                if ( ( flags & FLAG_HEARTBEAT ) == 0 && ( flags & FLAG_DELETED ) == 0 && !Double.isNaN ( value ) )
                {
                    visitor.value ( value, timestamp, ( flags & FLAG_ERROR ) > 0, ( flags & FLAG_MANUAL ) > 0 );
                    return true;
                }

                buffer.clear ();
                this.channel.position ( this.channel.position () - ENTRY_SIZE );
            }
        }
        finally
        {
            this.channel.position ( startPosition );
            logger.debug ( "Returned to position: {}", startPosition );
        }
        return false;
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.hds.DataFileAccessor#visit(org.eclipse.scada.hds.ValueVisitor)
     */
    @Override
    public boolean visit ( final ValueVisitor visitor ) throws IOException
    {
        logger.debug ( "Welcome visitor: {}", visitor );

        final long position = this.channel.position ();

        try
        {
            this.channel.position ( HEADER_SIZE );

            final ByteBuffer buffer = ByteBuffer.allocate ( ENTRY_SIZE );

            while ( read ( buffer ) == ENTRY_SIZE )
            {
                buffer.flip ();

                final double value = buffer.getDouble ();
                final long timestamp = buffer.getLong ();
                final byte flags = buffer.get ();

                logger.debug ( "Visit value - flag: {}", flags );

                if ( ( flags & FLAG_HEARTBEAT ) == 0 && ( flags & FLAG_DELETED ) == 0 )
                {
                    final boolean cont = visitor.value ( value, new Date ( timestamp ), ( flags & FLAG_ERROR ) > 0, ( flags & FLAG_MANUAL ) > 0 );
                    if ( !cont )
                    {
                        logger.debug ( "Stopping visit by request on visitor" );
                        return false; // stop reading
                    }
                }
                buffer.clear ();
            }
        }
        finally
        {
            this.channel.position ( position );
            logger.debug ( "Returned to position: {}", position );
        }

        return true; // continue reading
    }

    private int read ( final ByteBuffer buffer ) throws IOException
    {
        while ( this.channel.read ( buffer ) > 0 && buffer.hasRemaining () )
        {
        }
        return buffer.position ();
    }

    @Override
    public void forwardCorrect ( final double value, final Date timestamp, final boolean error, final boolean manual ) throws Exception
    {
        final long position = this.channel.position ();
        try
        {
            this.channel.position ( HEADER_SIZE );

            final ByteBuffer buffer = ByteBuffer.allocate ( ENTRY_SIZE );

            while ( read ( buffer ) == ENTRY_SIZE )
            {
                buffer.flip ();

                final double entryValue = buffer.getDouble ();
                final Date entryTimestamp = new Date ( buffer.getLong () );
                final byte flags = buffer.get ();

                logger.debug ( "Checking value - flag: {}", flags );

                if ( ( flags & FLAG_HEARTBEAT ) == 0 && ( flags & FLAG_DELETED ) == 0 )
                {
                    if ( entryTimestamp.after ( timestamp ) )
                    {
                        logger.info ( "Rewriting history - delete - timestamp: {}, value: {}", entryTimestamp, entryValue );
                        // replace the flag value, mark as deleted
                        // the flag is one byte behind the current position
                        this.channel.position ( this.channel.position () - 1 );
                        this.channel.write ( ByteBuffer.wrap ( new byte[] { (byte) ( flags | FLAG_DELETED ) } ) );
                    }
                }
                buffer.clear ();
            }

        }
        finally
        {
            this.channel.position ( position );
            logger.debug ( "Returned to position: {}", position );
        }
    }

    /**
     * Dispose the file. Close all resources.
     */
    @Override
    public void dispose ()
    {
        logger.debug ( "Closing {}", this.fileInfo );
        if ( this.file == null )
        {
            // alread disposed
            return;
        }

        try
        {
            this.file.close ();
            this.file = null;
        }
        catch ( final IOException e )
        {
            logger.warn ( "Failed to close file", e );
        }
    }

    /**
     * Dispose and delete the file
     */
    @Override
    public void delete ()
    {
        if ( this.file == null )
        {
            // already disposed
            return;
        }

        // dispose first to close file
        dispose ();

        if ( !this.fileInfo.exists () )
        {
            logger.warn ( "File does not exists?! {}", this.fileInfo );
        }

        if ( !this.fileInfo.delete () )
        {
            logger.warn ( "Failed to delete: {}", this.fileInfo );
        }
        else
        {
            logger.info ( "Deleted file: {}", this.fileInfo );
        }
    }

    /**
     * Initialize a new file, write the empty structure to disk and return a new
     * accessor to it
     * 
     * @param file
     *            The file to create. This file must not exists.
     * @param startDate
     *            the start date of the file
     * @param endDate
     *            the end date of the file
     * @return a newly created file accessor
     * @throws Exception
     *             if anything goes wrong
     */
    public static DataFileAccessorImpl create ( final File file, final Date startDate, final Date endDate ) throws Exception
    {
        logger.debug ( "Creating new file: {}", file );

        if ( !file.createNewFile () )
        {
            throw new IllegalStateException ( String.format ( "Unable to create file %s, already exists", file ) );
        }

        final FileOutputStream out = new FileOutputStream ( file );

        try
        {
            final FileChannel channel = out.getChannel ();

            final ByteBuffer buffer = ByteBuffer.allocate ( 100 );
            buffer.putInt ( 0x1202 ); // magic marker
            buffer.putInt ( 0x0101 ); // version
            buffer.putLong ( startDate.getTime () ); // start timestamp
            buffer.putLong ( endDate.getTime () ); // end timestamp

            buffer.flip ();

            while ( buffer.hasRemaining () )
            {
                final int rc = channel.write ( buffer );
                logger.debug ( "Header written - {} bytes", rc );
            }

            return new DataFileAccessorImpl ( file );
        }
        finally
        {
            out.close ();
        }
    }

}