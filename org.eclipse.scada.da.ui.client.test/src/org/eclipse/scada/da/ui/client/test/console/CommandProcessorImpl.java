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
package org.eclipse.scada.da.ui.client.test.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandProcessorImpl
{

    private final static Logger logger = LoggerFactory.getLogger ( CommandProcessorImpl.class );

    private final Map<String, CommandHandler> commands = new HashMap<String, CommandHandler> ();

    private final PrintStream output;

    private final PrintStream error;

    private Thread reader;

    private final InputStream input;

    public CommandProcessorImpl ( final String name, final InputStream input, final OutputStream output, final OutputStream error )
    {
        this.output = new PrintStream ( output );
        this.error = new PrintStream ( error );
        this.input = input;

        this.reader = new Thread ( "ConsoleReader - " + name ) {
            @Override
            public void run ()
            {
                try
                {
                    runReader ();
                }
                catch ( final Exception e )
                {
                    synchronized ( CommandProcessorImpl.this )
                    {
                        logger.debug ( "Reader thread died", e );
                        CommandProcessorImpl.this.reader = null;
                    }
                }
            }
        };
        this.reader.start ();
    }

    public void addCommand ( final String name, final CommandHandler command )
    {
        this.commands.put ( name, command );
    }

    public synchronized void dispose ()
    {
        this.output.close ();
        this.error.close ();

        try
        {
            this.input.close ();
        }
        catch ( final IOException e1 )
        {
        }

        if ( this.reader != null )
        {
            try
            {
                this.reader.join ();
            }
            catch ( final InterruptedException e )
            {
            }
            this.reader = null;
        }
    }

    protected void runReader () throws IOException
    {
        final BufferedReader reader = new BufferedReader ( new InputStreamReader ( this.input, Charset.forName ( "UTF-8" ) ) );

        try
        {
            String line = null;
            while ( ( line = reader.readLine () ) != null )
            {
                processLine ( line );
            }
        }
        finally
        {
            try
            {
                reader.close ();
            }
            catch ( final IOException e )
            {
            }
        }
    }

    protected void processLine ( final String line )
    {
        final String[] toks = line.split ( "\\s+", 2 );
        if ( toks.length < 1 )
        {
            return;
        }

        final CommandHandler command = this.commands.get ( toks[0] );
        if ( command == null )
        {
            this.error.printf ( "Command '%s' is unknown", toks[0] );
            this.error.println ();
            return;
        }

        try
        {
            command.runCommand ( new CommandContext () {

                @Override
                public PrintStream getOutputStream ()
                {
                    return CommandProcessorImpl.this.output;
                }

                @Override
                public PrintStream getErrorStream ()
                {
                    return CommandProcessorImpl.this.error;
                }
            } );
        }
        catch ( final Exception e )
        {
            e.printStackTrace ( this.error );
        }
    }
}
