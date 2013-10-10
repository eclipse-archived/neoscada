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
package org.eclipse.scada.da.server.common.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;

import org.eclipse.scada.core.InvalidSessionException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.core.server.common.session.AbstractSessionImpl;
import org.eclipse.scada.da.core.server.ItemChangeListener;
import org.eclipse.scada.da.core.server.Session;
import org.eclipse.scada.da.core.server.browser.FolderListener;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionCommon extends AbstractSessionImpl implements Session, DataItemSubscriptionListener
{

    private final static Logger logger = LoggerFactory.getLogger ( SessionCommon.class );

    private final HiveCommon hive;

    private volatile ItemChangeListener listener;

    private final SessionCommonData data = new SessionCommonData ();

    private volatile FolderListener folderListener;

    private boolean disposed;

    private final Collection<Future<?>> tasks = new ConcurrentLinkedQueue<Future<?>> ();

    public SessionCommon ( final HiveCommon hive, final UserInformation userInformation, final Map<String, String> properties )
    {
        super ( userInformation, properties );

        this.hive = hive;
    }

    public HiveCommon getHive ()
    {
        return this.hive;
    }

    @Override
    public void setListener ( final ItemChangeListener listener )
    {
        this.listener = listener;
    }

    public ItemChangeListener getListener ()
    {
        return this.listener;
    }

    public SessionCommonData getData ()
    {
        return this.data;
    }

    public FolderListener getFolderListener ()
    {
        return this.folderListener;
    }

    @Override
    public void setListener ( final FolderListener folderListener )
    {
        this.folderListener = folderListener;
    }

    // Data item listener stuff
    @Override
    public void updateStatus ( final Object topic, final SubscriptionState subscriptionState )
    {
        final ItemChangeListener listener;

        if ( ( listener = this.listener ) != null )
        {
            listener.subscriptionChanged ( topic.toString (), subscriptionState );
        }
    }

    @Override
    public void dataChanged ( final DataItem item, final Variant value, final Map<String, Variant> attributes, final boolean cache )
    {
        logger.debug ( "Data changed - itemId: {}, value: {}, attributes: {}, cache: {}", new Object[] { item.getInformation ().getName (), value, attributes, cache } );

        final ItemChangeListener listener;

        if ( ( listener = this.listener ) != null )
        {
            listener.dataChanged ( item.getInformation ().getName (), value, attributes, cache );
        }
    }

    /**
     * Add a future to the session.
     * <p>
     * The future will be canceled when the session is completed. The session
     * subscribes to the future state in order to remove the future from the
     * session one it is completed.
     * </p>
     * 
     * @param future
     *            the future to add
     * @throws InvalidSessionException
     *             in case the session was already disposed
     */
    public void addFuture ( final NotifyFuture<?> future ) throws InvalidSessionException
    {
        synchronized ( this.tasks )
        {
            if ( !this.disposed )
            {
                this.tasks.add ( future );
            }
            else
            {
                throw new InvalidSessionException ();
            }
        }

        // now add the listener
        future.addListener ( new Runnable () {

            @Override
            public void run ()
            {
                removeFuture ( future );
            }
        } );
    }

    public void removeFuture ( final NotifyFuture<?> future )
    {
        synchronized ( this.tasks )
        {
            if ( !this.disposed )
            {
                this.tasks.remove ( future );
            }
        }
    }

    /**
     * Dispose the session
     */
    @Override
    public void dispose ()
    {
        final Collection<Future<?>> tasks;
        synchronized ( this.tasks )
        {
            this.disposed = true;

            tasks = new ArrayList<Future<?>> ( this.tasks );
            this.tasks.clear ();
        }

        for ( final Future<?> task : tasks )
        {
            try
            {
                task.cancel ( false );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to cancel task", e );
            }
        }
    }
}
