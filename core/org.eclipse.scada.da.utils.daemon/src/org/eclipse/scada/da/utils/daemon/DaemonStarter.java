/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.utils.daemon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A simple implementation of the {@link DaemonController} interface for
 * local starting of {@link Daemon} implementations.
 * 
 * @author Jens Reimann
 */
public class DaemonStarter implements DaemonController
{

    private static final Logger logger = LoggerFactory.getLogger ( DaemonStarter.class );

    public static void main ( final String[] args ) throws Exception
    {
        if ( args.length == 0 )
        {
            throw new RuntimeException ( "syntax: DaemonStarter <daemon class name>" );
        }

        final Queue<String> argList = new LinkedList<String> ();
        argList.addAll ( Arrays.asList ( args ) );

        new DaemonStarter ( Class.forName ( argList.poll () ), argList.toArray ( new String[0] ) );

        while ( true )
        {
            Thread.sleep ( 1000 );
        }
    }

    private final Daemon daemon;

    public DaemonStarter ( final Class<?> className, final String[] args ) throws Exception
    {
        final Object o = className.newInstance ();
        if ( ! ( o instanceof Daemon ) )
        {
            throw new RuntimeException ( String.format ( "Class must implement '%s'", Daemon.class ) );
        }

        final DaemonController controller = this;
        this.daemon = (Daemon)o;
        this.daemon.init ( new DaemonContext () {

            @Override
            public String[] getArguments ()
            {
                return args;
            }

            @Override
            public DaemonController getController ()
            {
                return controller;
            }
        } );
        this.daemon.start ();

    }

    @Override
    public void fail () throws IllegalStateException
    {
        logger.error ( "Service failed" );
        System.exit ( -1 );
    }

    @Override
    public void fail ( final String arg0 ) throws IllegalStateException
    {
        logger.error ( "Service failed: " + arg0 );
        System.exit ( -1 );
    }

    @Override
    public void fail ( final Exception arg0 ) throws IllegalStateException
    {
        logger.error ( "Service failed", arg0 );
    }

    @Override
    public void fail ( final String arg0, final Exception arg1 ) throws IllegalStateException
    {
        logger.error ( String.format ( "Service failed: '%s'", arg0 ), arg1 );
    }

    @Override
    public void reload () throws IllegalStateException
    {
        try
        {
            this.daemon.stop ();
            this.daemon.start ();
        }
        catch ( final Exception e )
        {
            fail ( "Failed to reload", e );
        }
    }

    @Override
    public void shutdown () throws IllegalStateException
    {
        if ( this.daemon != null )
        {
            try
            {
                this.daemon.stop ();
            }
            catch ( final Exception e )
            {
                fail ( "Failed to shut down", e );
            }
        }
        System.exit ( 0 );
    }
}
