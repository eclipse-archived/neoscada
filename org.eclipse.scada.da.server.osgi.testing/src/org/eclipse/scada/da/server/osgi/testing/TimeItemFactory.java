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
package org.eclipse.scada.da.server.osgi.testing;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.da.server.common.DataItem;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class TimeItemFactory extends AbstractServiceConfigurationFactory<TimeDataItem>
{

    private final ScheduledExecutorService executor;

    public TimeItemFactory ( final ScheduledExecutorService executor, final BundleContext context )
    {
        super ( context );
        this.executor = executor;
    }

    @Override
    protected Entry<TimeDataItem> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final TimeDataItem dataItem = new TimeDataItem ( configurationId, this.executor );

        dataItem.update ( parameters );

        final Dictionary<String, Object> properties = new Hashtable<String, Object> ();
        final ServiceRegistration<DataItem> handle = context.registerService ( DataItem.class, dataItem, properties );

        return new Entry<TimeDataItem> ( configurationId, dataItem, handle );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final TimeDataItem service )
    {
        service.dispose ();
    }

    @Override
    protected Entry<TimeDataItem> updateService ( final UserInformation userInformation, final String configurationId, final Entry<TimeDataItem> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( parameters );
        return null;
    }

}
