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
package org.eclipse.scada.da.server.proxy.item;

import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.ItemUpdateListener;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.proxy.connection.ProxySubConnection;

public class ProxyItemUpdateListener implements ItemUpdateListener
{
    private final ProxyDataItem item;

    private final ProxySubConnection subConnection;

    private final Executor executor;

    public ProxyItemUpdateListener ( final Executor executor, final ProxyDataItem item, final ProxySubConnection subConnection )
    {
        this.executor = executor;
        this.item = item;
        this.subConnection = subConnection;
    }

    public void notifyDataChange ( final Variant value, final Map<String, Variant> attributes, final boolean cache )
    {
        this.executor.execute ( new Runnable () {

            public void run ()
            {
                ProxyItemUpdateListener.this.item.getProxyValueHolder ().updateData ( ProxyItemUpdateListener.this.subConnection.getId (), value, attributes, cache ? AttributeMode.SET : AttributeMode.UPDATE );
            }
        } );

    }

    public void notifySubscriptionChange ( final SubscriptionState subscriptionState, final Throwable subscriptionError )
    {
        this.executor.execute ( new Runnable () {

            public void run ()
            {
                ProxyItemUpdateListener.this.item.getProxyValueHolder ().updateSubscriptionState ( ProxyItemUpdateListener.this.subConnection.getId (), subscriptionState, subscriptionError );
            }
        } );

    }
}