/*******************************************************************************
 * Copyright (c) 2006, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.concurrent;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NamedThreadFactory implements ThreadFactory
{

    private final static Logger logger = LoggerFactory.getLogger ( NamedThreadFactory.class );

    private final AtomicLong counter;

    private final String name;

    private final boolean daemon;

    private final boolean logExceptions;

    public NamedThreadFactory ( final String name )
    {
        this ( name, false );
    }

    public NamedThreadFactory ( final String name, final boolean daemon )
    {
        this ( name, daemon, true );
    }

    public NamedThreadFactory ( final String name, final boolean daemon, final boolean logExceptions )
    {
        this.logExceptions = logExceptions;
        this.counter = new AtomicLong ();
        this.name = name;
        this.daemon = daemon;
        if ( name == null )
        {
            throw new IllegalArgumentException ( String.format ( "'name' must not be null" ) );
        }
    }

    @Override
    public Thread newThread ( final Runnable r )
    {
        final Thread t = new Thread ( r, createName () );
        t.setDaemon ( this.daemon );

        if ( this.logExceptions && !Boolean.getBoolean ( "org.eclipse.scada.utils.concurrent.noDefaultLogger" ) )
        {
            t.setUncaughtExceptionHandler ( new UncaughtExceptionHandler () {

                @Override
                public void uncaughtException ( final Thread t, final Throwable e )
                {
                    logger.warn ( String.format ( "Thread %s failed and nobody cared", t ), e );
                }
            } );
        }
        return t;
    }

    protected String createName ()
    {
        return String.format ( "%s/%s", this.name, this.counter.incrementAndGet () );
    }
}