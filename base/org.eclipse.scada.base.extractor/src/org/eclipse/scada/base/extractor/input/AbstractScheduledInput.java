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
package org.eclipse.scada.base.extractor.input;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public abstract class AbstractScheduledInput extends AbstractInput
{

    protected static Object convert ( final byte[] data, final Charset charset )
    {
        if ( data == null )
        {
            return null;
        }

        if ( charset == null )
        {
            return data;
        }

        final CharBuffer cb = charset.decode ( ByteBuffer.wrap ( data ) );
        return cb.toString ();
    }

    private final ScheduledExecutorService executor;

    private ScheduledFuture<?> job;

    private final Runnable command = new Runnable () {

        @Override
        public void run ()
        {
            process ();
        }
    };

    private boolean running;

    private final long period;

    public AbstractScheduledInput ( final ScheduledExecutorService executor, final long period )
    {
        super ( executor );
        this.executor = executor;
        this.period = period;
    }

    @Override
    public synchronized void start ()
    {
        if ( this.job == null )
        {
            this.job = this.executor.scheduleAtFixedRate ( this.command, 0, this.period, TimeUnit.MILLISECONDS );
        }
    }

    @Override
    public synchronized void stop ()
    {
        if ( this.job != null )
        {
            this.job.cancel ( false );

            while ( this.running )
            {
                try
                {
                    wait ();
                }
                catch ( final InterruptedException e )
                {
                    break;
                }
            }

            fireDisposed ();
            this.job = null;
        }
    }

    protected void process ()
    {
        try
        {
            synchronized ( this )
            {
                this.running = true;
            }
            final Data data = makeData ();
            if ( data != null )
            {
                fireData ( data );
            }
        }
        catch ( final Exception e )
        {
            fireData ( new Data ( null, e ) );
        }
        finally
        {
            synchronized ( this )
            {
                this.running = false;
                notifyAll ();
            }
        }

    }

    protected abstract Data makeData () throws Exception;

}
