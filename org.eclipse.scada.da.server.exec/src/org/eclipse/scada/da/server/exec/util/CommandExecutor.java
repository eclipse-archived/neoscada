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

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.scada.da.server.exec.command.ExecutionResult;
import org.eclipse.scada.da.server.exec.command.ProcessListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandExecutor
{
    private final static Logger logger = LoggerFactory.getLogger ( CommandExecutor.class );

    /**
     * This method executes the specified command on the shell using the passed objects as information provider.
     * 
     */
    public static ExecutionResult executeCommand ( final ProcessBuilder processBuilder, final ProcessListener listener )
    {
        final ExecutionResult result = new ExecutionResult ();

        Process p = null;
        // Execute the command
        try
        {
            // Execute and wait
            final long start = System.currentTimeMillis ();
            p = processBuilder.start ();

            if ( listener != null )
            {
                listener.processCreated ( p );
            }

            closeStream ( p.getOutputStream () );

            p.waitFor ();
            final long end = System.currentTimeMillis ();

            result.setRuntime ( end - start );

            // Get exit value
            final int exitValue = p.exitValue ();
            result.setExitValue ( exitValue );

            // Get result
            final InputStream input = p.getInputStream ();
            result.setOutput ( inputStreamToString ( input ) );

            final InputStream error = p.getErrorStream ();
            result.setErrorOutput ( inputStreamToString ( error ) );
        }
        catch ( final Throwable e )
        {
            result.setExecutionError ( e );
            return result;
        }
        finally
        {
            if ( listener != null )
            {
                listener.processCompleted ();
            }

            if ( p != null )
            {
                closeStream ( p.getErrorStream () );
                closeStream ( p.getInputStream () );
                closeStream ( p.getOutputStream () );
            }
        }

        return result;
    }

    protected static void closeStream ( final Closeable stream )
    {
        if ( stream == null )
        {
            return;
        }
        try
        {
            stream.close ();
        }
        catch ( final IOException e )
        {
            logger.warn ( "Failed to close stream", e );
        }
    }

    /**
     * Read from an inputStream and place the output in a string
     * @param inputStream
     * @return
     */
    private static String inputStreamToString ( final InputStream inputStream ) throws IOException
    {
        final InputStreamReader inputStreamReader = new InputStreamReader ( inputStream );
        final BufferedReader br = new BufferedReader ( inputStreamReader );

        String output = "";
        String line = "";
        while ( ( line = br.readLine () ) != null )
        {
            output += line;
        }
        return output;
    }
}
