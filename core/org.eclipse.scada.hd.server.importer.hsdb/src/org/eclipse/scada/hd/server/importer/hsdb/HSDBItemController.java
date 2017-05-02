/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.server.importer.hsdb;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.hd.data.HistoricalItemInformation;
import org.eclipse.scada.hd.server.common.HistoricalItem;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class HSDBItemController
{
    private final HSDBValueSource source;

    private final HSDBHistoricalItem item;

    private final ServiceRegistration<HistoricalItem> handle;

    public HSDBItemController ( final String id, final ScheduledExecutorService executor, final BundleContext context, final HSDBValueSource source )
    {
        this.source = source;

        final Map<String, Variant> properties = new HashMap<String, Variant> ();

        final HistoricalItemInformation information = new HistoricalItemInformation ( id, properties );
        this.item = new HSDBHistoricalItem ( executor, source, information );

        final Dictionary<String, Object> serviceProperties = new Hashtable<String, Object> ();
        serviceProperties.put ( Constants.SERVICE_PID, id );
        serviceProperties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        this.handle = context.registerService ( HistoricalItem.class, this.item, serviceProperties );
    }

    public void dispose ()
    {
        this.handle.unregister ();
        this.source.dispose ();
    }
}
