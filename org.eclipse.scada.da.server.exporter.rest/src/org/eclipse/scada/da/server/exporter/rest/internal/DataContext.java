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
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.server.exporter.common.AggregatingSubscriptionManager;
import org.eclipse.scada.da.server.exporter.common.HiveSource;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public class DataContext
{
    private final AggregatingSubscriptionManager subscriptionManager;

    public DataContext ( final ScheduledExecutorService executor, final HiveSource hiveSource, final Map<String, String> properties )
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        final Properties hiveProperties = cfg.getPrefixedProperties ( "hive." );
        this.subscriptionManager = new AggregatingSubscriptionManager ( executor, hiveSource, hiveProperties );

        this.subscriptionManager.start ();

        this.subscriptionManager.subscribeAll ( cfg.getStringSet ( "items." ) );
    }

    public DataItemValue getValue ( final String itemId )
    {
        return this.subscriptionManager.getCacheValue ( itemId );
    }

    public NotifyFuture<WriteResult> writeValue ( final String itemId, final Variant value )
    {
        return this.subscriptionManager.writeValue ( itemId, value, null, null );
    }

    public NotifyFuture<WriteAttributeResults> writeAttributes ( final String itemId, final Map<String, Variant> attributes )
    {
        return this.subscriptionManager.writeAttributes ( itemId, attributes, null, null );
    }

    public void dispose ()
    {
        this.subscriptionManager.stop ();
    }

}
