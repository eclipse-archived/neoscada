/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;

/**
 * A data item which performs the notification asynchronously
 * 
 * @author Jens Reimann
 */
public class AsyncDataItem extends DataItem
{

    /**
     * The executor to use
     */
    private final ExecutorService executor;

    public AsyncDataItem ( final String itemId )
    {
        this ( itemId, (ItemManager)null );
    }

    public AsyncDataItem ( final String itemId, final ItemManager connection )
    {
        this ( itemId, connection, Executors.newSingleThreadExecutor ( new NamedThreadFactory ( "AsyncDataItem/" + itemId ) ) );
    }

    public AsyncDataItem ( final String itemId, final ItemManager connection, final ExecutorService executor )
    {
        super ( itemId );

        this.executor = executor;

        if ( connection != null )
        {
            register ( connection );
        }
    }

    @Override
    protected void performNotifyDataChange ( final Variant value, final Map<String, Variant> attributes, final boolean cache )
    {
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                AsyncDataItem.this.handlePerformNotifyDataChange ( value, attributes, cache );
            }
        } );
    }

    @Override
    protected void performNotifySubscriptionChange ( final SubscriptionState subscriptionState, final Throwable subscriptionError )
    {
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                AsyncDataItem.this.handlePerformNotifySubscriptionChange ( subscriptionState, subscriptionError );
            }
        } );
    }

    @Override
    protected void finalize () throws Throwable
    {
        this.executor.shutdown ();
        super.finalize ();
    }

}
