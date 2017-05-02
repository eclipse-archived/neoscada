/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.concurrent;

import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @since 1.1
 * @author Jens Reimann
 * @param <T>
 *            the type of the future
 * @param <S>
 *            the type of the list
 */
public abstract class IteratingFuture<T, S> extends AbstractFuture<T>
{

    private final static Logger logger = LoggerFactory.getLogger ( IteratingFuture.class );

    public final class FutureListenerImpl implements FutureListener<T>
    {
        private final S current;

        public FutureListenerImpl ( final S current )
        {
            this.current = current;
        }

        @Override
        public void complete ( final Future<T> future )
        {
            try
            {
                doComplete ( future, this.current );
            }
            catch ( final Exception e )
            {
                logger.debug ( "Failed to complete", e );
                setError ( e );
            }
        }
    }

    private final Iterator<? extends S> iterator;

    private S current;

    private volatile NotifyFuture<T> currentFuture;

    private boolean canceled;

    public IteratingFuture ( final Iterable<? extends S> iterable )
    {
        this.iterator = iterable.iterator ();
    }

    /**
     * Start iterating over the list
     * 
     * @return this instance
     */
    public IteratingFuture<T, S> startIterating ()
    {
        processNext ();
        return this;
    }

    protected void processCurrent ()
    {
        try
        {
            process ( perform ( this.current ) );
        }
        catch ( final Exception e )
        {
            logger.debug ( "Failed to process current", e );
            setError ( e );
        }
    }

    protected void processNext ()
    {
        try
        {
            process ( next () );
        }
        catch ( final Exception e )
        {
            logger.debug ( "Failed to process next", e );
            setError ( e );
        }
    }

    private void process ( final NotifyFuture<T> future )
    {
        synchronized ( this )
        {
            if ( this.canceled )
            {
                future.cancel ( true );
                throw new CancellationException ();
            }
            else
            {
                this.currentFuture = future;
            }
        }

        future.addListener ( new FutureListenerImpl ( this.current ) );
    }

    @Override
    public boolean cancel ( final boolean mayInterruptIfRunning )
    {
        final NotifyFuture<T> current;

        synchronized ( this )
        {
            this.canceled = true;
            current = this.currentFuture;
        }

        if ( current != null )
        {
            current.cancel ( mayInterruptIfRunning );
        }

        return super.cancel ( mayInterruptIfRunning );
    }

    private NotifyFuture<T> next ()
    {
        if ( this.iterator.hasNext () )
        {
            this.current = this.iterator.next ();
            return perform ( this.current );
        }
        else
        {
            this.current = null;
            return last ();
        }
    }

    protected void doComplete ( final Future<T> future, final S current ) throws Exception
    {
        this.currentFuture = null;
        handleComplete ( future, current );
    }

    protected abstract void handleComplete ( final Future<T> future, S current ) throws Exception;

    protected abstract NotifyFuture<T> perform ( S s );

    protected abstract NotifyFuture<T> last ();

}
