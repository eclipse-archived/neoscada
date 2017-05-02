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

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.base.extractor.transform.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractInput implements Input
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractInput.class );

    private final Set<Listener> listeners = new HashSet<> ();

    private final Executor executor;

    private Data lastData;

    private final List<Transformer> transformers = new LinkedList<> ();

    public AbstractInput ( final Executor executor )
    {
        this.executor = executor;
    }

    @Override
    public synchronized void addTransformer ( final Transformer transformer )
    {
        this.transformers.add ( transformer );
    }

    @Override
    public synchronized void removeTransformer ( final Transformer transformer )
    {
        this.transformers.remove ( transformer );
    }

    public synchronized void setTransformers ( final Transformer[] transformers )
    {
        this.transformers.clear ();
        this.transformers.addAll ( Arrays.asList ( transformers ) );
    }

    @Override
    public synchronized void addInputListener ( final Listener listener )
    {
        if ( this.listeners.add ( listener ) )
        {
            if ( this.lastData != null )
            {
                final Data data = this.lastData;
                this.executor.execute ( new Runnable () {
                    @Override
                    public void run ()
                    {
                        processFireData ( new Listener[] { listener }, data );
                    }
                } );
            }
        }
    }

    @Override
    public synchronized void removeInputListener ( final Listener listener )
    {
        this.listeners.remove ( listener );
    }

    protected synchronized void fireDisposed ()
    {
        fireData ( new Data ( null, new InputDisposed () ) );
    }

    protected synchronized void fireData ( final Data data )
    {
        final Data transformedData = transform ( data );

        final Listener[] listeners = this.listeners.toArray ( new Listener[this.listeners.size ()] );
        this.lastData = data;
        try
        {
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    processFireData ( listeners, transformedData );
                }
            } );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to fireData", e );
        }
    }

    protected Data transform ( Data data )
    {
        if ( this.transformers.isEmpty () )
        {
            return data;
        }

        for ( final Transformer t : this.transformers )
        {
            try
            {
                data = t.transform ( data );
            }
            catch ( final Exception e )
            {
                data = new Data ( null, e );
            }
        }
        return data;
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
