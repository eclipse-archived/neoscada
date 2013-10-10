/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.InvalidOperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.utils.concurrent.FutureTask;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataItemCommand extends DataItemOutput
{

    private final static Logger logger = LoggerFactory.getLogger ( DataItemCommand.class );

    /**
     * The listener interface
     * 
     * @author Jens Reimann
     */
    public static interface Listener
    {
        public void command ( Variant value ) throws Exception;
    }

    private final List<Listener> listeners = new CopyOnWriteArrayList<Listener> ();

    private final Executor executor;

    public DataItemCommand ( final String id, final Executor executor )
    {
        super ( id );
        this.executor = executor;
    }

    @Override
    public NotifyFuture<WriteResult> startWriteValue ( final Variant value, final OperationParameters operationParameters )
    {
        final FutureTask<WriteResult> task = new FutureTask<WriteResult> ( new Callable<WriteResult> () {

            @Override
            public WriteResult call () throws Exception
            {
                processWrite ( value );
                return null;
            }
        } );

        this.executor.execute ( task );

        return task;
    }

    public void processWrite ( final Variant value ) throws InvalidOperationException
    {
        for ( final Listener listener : this.listeners )
        {
            try
            {
                listener.command ( value );
            }
            catch ( final Throwable e )
            {
                logger.warn ( "Failed to run listener", e );
                throw new InvalidOperationException ();
            }
        }
    }

    /**
     * Add a new listener which gets called on write requests
     * 
     * @param listener
     *            listener to add
     */
    public void addListener ( final Listener listener )
    {
        this.listeners.add ( listener );
    }

    /**
     * Remove a listener from the list
     * 
     * @param listener
     *            listener to remove
     */
    public void removeListener ( final Listener listener )
    {
        this.listeners.remove ( listener );
    }

    @Override
    public Map<String, Variant> getAttributes ()
    {
        return new HashMap<String, Variant> ();
    }

    @Override
    public NotifyFuture<WriteAttributeResults> startSetAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        return new InstantFuture<WriteAttributeResults> ( WriteAttributesHelper.errorUnhandled ( null, attributes ) );
    }

}
