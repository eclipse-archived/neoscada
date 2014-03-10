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

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractInput implements Input
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractInput.class );

    private final Set<Listener> listeners = new HashSet<> ();

    private final Executor executor;

    public AbstractInput ( final Executor executor )
    {
        this.executor = executor;
    }

    @Override
    public synchronized void addInputListener ( final Listener listener )
    {
        if ( this.listeners.add ( listener ) )
        {
            // do something
        }
    }

    @Override
    public synchronized void removeInputListener ( final Listener listener )
    {
        if ( this.listeners.remove ( listener ) )
        {
            // do something
        }
    }

    protected synchronized void fireData ( final Data data )
    {
        final Listener[] listeners = this.listeners.toArray ( new Listener[this.listeners.size ()] );
        try
        {
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    processFireData ( listeners, data );
                }
            } );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to fireData", e );
        }
    }

    protected void processFireData ( final Listener[] listeners, final Data data )
    {
        for ( final Listener l : listeners )
        {
            try
            {
                l.processInput ( data );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to process listener", e );
            }
        }
    }

    @Override
    public synchronized void dispose ()
    {
        stop ();
        this.listeners.clear ();
    }

}
