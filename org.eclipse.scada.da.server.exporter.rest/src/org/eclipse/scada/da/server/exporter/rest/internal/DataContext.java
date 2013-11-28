/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.rest.internal;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.server.exporter.common.AggregatingSubscriptionManager;
import org.eclipse.scada.da.server.exporter.common.HiveSource;

public class DataContext
{
    private final AggregatingSubscriptionManager subscriptionManager;

    public DataContext ( final ScheduledExecutorService executor, final HiveSource hiveSource, final Map<String, String> properties )
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        final Properties hiveProperties = cfg.getPrefixedProperties ( "hive." );
        this.subscriptionManager = new AggregatingSubscriptionManager ( executor, hiveSource, hiveProperties );

        this.subscriptionManager.subscribeAll ( cfg.getStringSet ( "items." ) );

        this.subscriptionManager.start ();
    }

    public DataItemValue getValue ( final String itemId )
    {
        return this.subscriptionManager.getCacheValue ( itemId );
    }

    public void dispose ()
    {
        this.subscriptionManager.stop ();
    }

}
