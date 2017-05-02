/*******************************************************************************
 * Copyright (c) 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.server.importer.hsdb;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.Properties;

import org.eclipse.scada.hds.AbstractValueSource;
import org.eclipse.scada.hds.ValueVisitor;
import org.eclipse.scada.utils.lang.Immutable;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HSDBValueSource extends AbstractValueSource
{

    private final static Logger logger = LoggerFactory.getLogger ( HSDBValueSource.class );

    private final File root;

    private final Collection<FileEntry> entries;

    @Immutable
    private static class FileEntry
    {
        private final Date startTimestamp;

        private final Date endTimestamp;

        private final File file;

        public FileEntry ( final Date startTimestamp, final Date endTimestamp, final File file )
        {
            super ();
            this.startTimestamp = startTimestamp;
            this.endTimestamp = endTimestamp;
            this.file = file;
        }

        public File getFile ()
        {
            return this.file;
        }

        public Date getEndTimestamp ()
        {
            return this.endTimestamp;
        }

        public Date getStartTimestamp ()
        {
            return this.startTimestamp;
        }
    }

    private final Date startTimestamp;

    private final Date endTimestamp;

    public HSDBValueSource ( final BundleContext context, final File root, final String name ) throws FileNotFoundException, IOException
    {
        this.root = root;

        final Properties p = new Properties ();
        p.load ( new FileInputStream ( new File ( root, name + ".va_ctrl" ) ) );
        final int numEntries = Integer.parseInt ( p.getProperty ( "hsdb.manager.knownFragmentsCount" ) );

        Date startTimestamp = null;

        Date endTimestamp = null;

        this.entries = new LinkedList<FileEntry> ();
        for ( int i = 0; i < numEntries; i++ )
        {
            final FileEntry file = makeFile ( p, i );
            if ( file != null )
            {
                if ( startTimestamp == null || startTimestamp.after ( file.getStartTimestamp () ) )
                {
                    startTimestamp = file.getStartTimestamp ();
                }
                if ( endTimestamp == null || endTimestamp.before ( file.getEndTimestamp () ) )
                {
                    endTimestamp = file.getStartTimestamp ();
                }
                this.entries.add ( file );
            }
        }

        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;

    }

    private FileEntry makeFile ( final Properties p, final int i )
    {
        final String level = p.getProperty ( "hsdb.manager.knownFragment.compressionLevel." + i );
        if ( !"0".equals ( level ) )
        {
            logger.info ( "Ignoring compression levels ({})", level );
            return null;
        }

        final long start = Long.parseLong ( p.getProperty ( "hsdb.manager.knownFragment.startTime." + i ) );
        final long end = Long.parseLong ( p.getProperty ( "hsdb.manager.knownFragment.endTime." + i ) );
        final File file = new File ( this.root, new File ( p.getProperty ( "hsdb.manager.knownFragment.name." + i ) ).getName () );
        if ( !file.canRead () )
        {
            logger.warn ( "File {} not found.", file );
        }

        return new FileEntry ( new Date ( start ), new Date ( end ), file );
    }

    public Date getStartTimestamp ()
    {
        return this.startTimestamp;
    }

    public Date getEndTimestamp ()
    {
        return this.endTimestamp;
    }

    @Override
    public boolean visit ( final ValueVisitor visitor, final Date start, final Date end )
    {
        logger.debug ( "Visiting - start: {}, end: {}", start, end );

        FileEntry first = null;

        // sequential
        for ( final FileEntry entry : this.entries )
        {
            logger.debug ( "File - start: {}, end: {}", entry.getStartTimestamp (), entry.getEndTimestamp () );

            if ( entry.getEndTimestamp ().before ( start ) )
            {
                logger.debug ( "Before start. Skipping... for now" );
                if ( first == null || first.endTimestamp.before ( entry.getEndTimestamp () ) )
                {
                    logger.debug ( "Remember for previous file: {}", entry.getFile () );
                    first = entry;
                }
                continue;
            }
            if ( entry.getStartTimestamp ().after ( end ) )
            {
                logger.debug ( "After end. Skipping..." );
                continue;
            }

            if ( !visitFile ( entry, visitor ) )
            {
                return false;
            }
        }

        if ( first != null )
        {
            logger.debug ( "Visiting previous file: {}", first );
            return visitFile ( first, visitor );
        }
        else
        {
            return true;
        }
    }

    protected boolean visitFile ( final FileEntry entry, final ValueVisitor visitor )
    {
        try
        {
            logger.debug ( "Visiting file: {}", entry.getFile () );
            if ( !parseFile ( entry, visitor ) )
            {
                return false;
            }
            return true;
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed reading " + entry.getFile (), e );
            if ( !visitor.value ( Double.NaN, entry.getStartTimestamp (), true, false ) )
            {
                return false;
            }
            return true;
        }
    }

    private boolean parseFile ( final FileEntry entry, final ValueVisitor visitor ) throws IOException
    {
        final InputStream input = new BufferedInputStream ( new FileInputStream ( entry.getFile () ) );
        try
        {
            final byte[] header = new byte[8 + 8];
            if ( input.read ( header ) != header.length )
            {
                throw new IOException ( "Corrupt header" );
            }

            final ByteBuffer headerBuffer = ByteBuffer.wrap ( header );
            headerBuffer.getLong ();
            final long dataStart = headerBuffer.getLong ();

            if ( dataStart <= header.length )
            {
                throw new IOException ( "Illegal data start address" );
            }

            input.skip ( dataStart - header.length );
            final byte[] recordArray = new byte[41];
            final ByteBuffer record = ByteBuffer.wrap ( recordArray );

            while ( input.read ( record.array () ) == recordArray.length )
            {
                byte parityCalc = 0x5A;
                for ( int i = 0; i < 40; i++ )
                {
                    parityCalc = (byte) ( parityCalc ^ record.get ( i ) );
                }

                final Date timestamp = new Date ( record.getLong () );
                final long quality = record.getLong ();
                final long manual = record.getLong ();
                @SuppressWarnings ( "unused" )
                final long sourceCount = record.getLong ();
                final double value = record.getDouble ();
                final byte parity = record.get ();

                record.clear ();

                if ( parity != parityCalc )
                {
                    logger.warn ( "Parity does not match - read: {}, calc: {}", parity, parityCalc );
                    continue;
                }

                logger.trace ( "Visiting value - timestamp: {}, value: {}", timestamp, value );
                if ( !visitor.value ( value, timestamp, quality == 100, manual != 0 ) )
                {

                    return false;
                }
            }

            return true;
        }
        finally
        {
            input.close ();
        }
    }

    public void dispose ()
    {
    }

}
