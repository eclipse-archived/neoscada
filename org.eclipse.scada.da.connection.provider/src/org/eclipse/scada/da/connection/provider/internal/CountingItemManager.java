/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.connection.provider.internal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.scada.core.info.StatisticsImpl;
import org.eclipse.scada.da.client.ItemManager;
import org.eclipse.scada.da.client.ItemUpdateListener;

public class CountingItemManager implements ItemManager
{

    public final static Object REGISTERED_ITEMS = new Object ();

    private final ItemManager itemManager;

    private final StatisticsImpl statistics;

    private final Map<SubscriptionItemEntry, Object> itemRegistrationSet = new ConcurrentHashMap<SubscriptionItemEntry, Object> ();

    public CountingItemManager ( final ItemManager itemManager, final StatisticsImpl statistics )
    {
        this.itemManager = itemManager;
        this.statistics = statistics;
    }

    @Override
    public void addItemUpdateListener ( final String itemName, final ItemUpdateListener listener )
    {
        addItemRegistration ( itemName, listener );
        this.itemManager.addItemUpdateListener ( itemName, listener );
    }

    @Override
    public void removeItemUpdateListener ( final String itemName, final ItemUpdateListener listener )
    {
        removeItemRegistration ( itemName, listener );
        this.itemManager.removeItemUpdateListener ( itemName, listener );
    }

    protected void addItemRegistration ( final String itemId, final ItemUpdateListener listener )
    {
        this.itemRegistrationSet.put ( new SubscriptionItemEntry ( itemId, listener ), Boolean.TRUE );
        this.statistics.setCurrentValue ( REGISTERED_ITEMS, this.itemRegistrationSet.size () );
    }

    protected void removeItemRegistration ( final String itemId, final ItemUpdateListener listener )
    {
        this.itemRegistrationSet.remove ( new SubscriptionItemEntry ( itemId, listener ) );
        this.statistics.setCurrentValue ( REGISTERED_ITEMS, this.itemRegistrationSet.size () );
    }

}