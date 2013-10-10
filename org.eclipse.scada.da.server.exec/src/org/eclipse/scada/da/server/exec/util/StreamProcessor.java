/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exec.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.CharBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A stream processor which will read from the stream and notify with string messages
 * @author Jens Reimann
 *
 */
public abstract class StreamProcessor implements Runnable
{
    private final static Logger logger = LoggerFactory.getLogger ( StreamProcessor.class );

    private final InputStream stream;

    private final int bufferSize;

    private final CharBuffer charBuffer;

    public StreamProcessor ( final InputStream stream, final int bufferSize )
    {
        this.stream = stream;
        this.bufferSize = bufferSize;
        this.charBuffer = CharBuffer.allocate ( this.bufferSize );
    }

    public void run ()
    {
        try
        {
            read ();
            streamClosed ();
        }
        catch ( final Throwable e )
        {
            readerFailed ( e );
        }
        finally
        {
            close ();
        }
    }

    private void streamClosed ()
    {
        logger.error ( "Stream closed" );
    }

    private void readerFailed ( final Throwable e )
    {
        logger.error ( "Failed failed", e );
    }

    private void read () throws IOException
    {
        int i;

        int offset = 0;
        final byte[] buffer = new byte[this.bufferSize];

        while ( ( i = this.stream.read ( buffer, offset, buffer.length - offset ) ) > 0 )
        {
            logger.debug ( String.format ( "Read %s bytes", i ) );

            final ByteArrayInputStream inputStream = new ByteArrayInputStream ( buffer, 0, i );
            handleNewInput ( new InputStreamReader ( inputStream ) );
            logger.debug ( String.format ( "%s byte(s) remaining", inputStream.available () ) );
            offset = inputStream.available ();

            if ( buffer.length - offset <= 0 )
            {
                throw new RuntimeException ( "Buffer is full" );
            }
        }
    }

    private void handleNewInput ( final InputStreamReader inputStreamReader )
    {
        try
        {
            this.charBuffer.clear ();
            while ( inputStreamReader.read ( this.charBuffer ) > 0 )
            {
                this.charBuffer.flip ();
                if ( logger.isDebugEnabled () )
                {
                    logger.debug ( "Reader: " + this.charBuffer.toString () );
                }
                handleInput ( this.charBuffer.toString () );
                this.charBuffer.clear ();
            }
        }
        catch ( final IOException e )
        {
        }
    }

    protected abstract void handleInput ( String input );

    private void close ()
    {
        try
        {
            this.stream.close ();
        }
        catch ( final IOException e )
        {
        }
    }
}
