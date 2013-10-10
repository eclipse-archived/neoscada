/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.net.base;

import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.utils.exec.LongRunningListener;
import org.eclipse.scada.utils.exec.LongRunningState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongRunningOperation implements org.eclipse.scada.utils.exec.LongRunningOperation
{

    private final static Logger logger = LoggerFactory.getLogger ( LongRunningOperation.class );

    @SuppressWarnings ( "unused" )
    private LongRunningController controller = null;

    private LongRunningListener listener = null;

    private long id = 0;

    private LongRunningState longRunningState = LongRunningState.REQUESTED;

    private Throwable error = null;

    private Message reply = null;

    protected LongRunningOperation ( final LongRunningController controller, final LongRunningListener listener )
    {
        super ();
        this.controller = controller;
        this.listener = listener;
    }

    protected long getId ()
    {
        return this.id;
    }

    private synchronized void stateChange ( final LongRunningState state, final Message message, final Throwable error )
    {
        logger.debug ( "LongRunningState change: {}", state.toString () );

        this.longRunningState = state;
        this.reply = message;
        this.error = error;

        if ( this.listener != null )
        {
            this.listener.stateChanged ( this, state, error );
        }
    }

    protected synchronized void fail ( final Throwable error )
    {
        stateChange ( LongRunningState.FAILURE, null, error );

        notifyAll ();
    }

    protected synchronized void granted ( final long id )
    {
        logger.debug ( "Granted: {}", id );
        this.id = id;

        stateChange ( LongRunningState.RUNNING, null, null );
    }

    protected synchronized void result ( final Message message )
    {
        logger.debug ( "Result: {}", this.id );

        stateChange ( LongRunningState.SUCCESS, message, null );

        notifyAll ();
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.net.base.ILongRunningOperation#isComplete()
     */
    public synchronized boolean isComplete ()
    {
        return this.longRunningState.equals ( LongRunningState.SUCCESS ) || this.longRunningState.equals ( LongRunningState.FAILURE );
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.net.base.ILongRunningOperation#getError()
     */
    public Throwable getError ()
    {
        return this.error;
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.net.base.ILongRunningOperation#getReply()
     */
    public Message getReply ()
    {
        return this.reply;
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.net.base.ILongRunningOperation#getState()
     */
    public LongRunningState getState ()
    {
        return this.longRunningState;
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.net.base.ILongRunningOperation#waitForCompletion()
     */
    public synchronized void waitForCompletion () throws InterruptedException
    {
        while ( !isComplete () )
        {
            wait ();
        }
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.net.base.ILongRunningOperation#waitForCompletion(int)
     */
    public synchronized void waitForCompletion ( final int timeout ) throws InterruptedException
    {
        while ( !isComplete () )
        {
            wait ( timeout );
        }
    }
}