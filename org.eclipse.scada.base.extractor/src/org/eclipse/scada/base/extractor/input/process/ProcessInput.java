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
package org.eclipse.scada.base.extractor.input.process;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.base.extractor.input.AbstractScheduledInput;
import org.eclipse.scada.base.extractor.input.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessInput extends AbstractScheduledInput
{
    private final static Logger logger = LoggerFactory.getLogger ( ProcessInput.class );

    private final ProcessBuilder processBuilder;

    private final Charset charset;

    public ProcessInput ( final ScheduledExecutorService executor, final ProcessBuilder processBuilder, final Charset charset, final long period )
    {
        super ( executor, period );

        this.charset = charset;

        this.processBuilder = processBuilder;
    }

    @Override
    protected Data makeData () throws Exception
    {
        logger.debug ( "Starting process: {}", this.processBuilder );

        final Process p = this.processBuilder.start ();

        try
        {
            close ( p.getOutputStream () );

            final CaptureOutputThread inputReader = new CaptureOutputThread ( p.getInputStream () );
            final CaptureOutputThread errorReader = new CaptureOutputThread ( p.getErrorStream () );

            logger.trace ( "Starting readers" );

            inputReader.start ();
            errorReader.start ();

            logger.debug ( "Begin waitFor" );

            final int rc = p.waitFor ();

            logger.debug ( "Process returned - rc = {}", rc );

            inputReader.join ();
            errorReader.join ();

            logger.debug ( "Threads returned as well" );

            Throwable error = null;
            if ( errorReader.getError () != null )
            {
                error = errorReader.getError ();
            }
            if ( inputReader.getError () != null )
            {
                error = inputReader.getError ();
            }

            logger.trace ( "Return data" );

            return new ProcessData ( convert ( inputReader.getData (), this.charset ), convert ( errorReader.getData (), this.charset ), rc, error );
        }
        catch ( final Exception e )
        {
            return new Data ( null, e );
        }
        finally
        {
            close ( p.getInputStream () );
            close ( p.getErrorStream () );
        }
    }

    private void close ( final Closeable closeable )
    {
        if ( closeable != null )
        {
            try
            {
                closeable.close ();
            }
            catch ( final IOException e )
            {
                logger.warn ( "Failed to close", e );
            }
        }
    }
}
