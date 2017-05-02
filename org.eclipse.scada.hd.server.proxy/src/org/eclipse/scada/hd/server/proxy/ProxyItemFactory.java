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
package org.eclipse.scada.hd.server.proxy;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.hd.server.common.HistoricalItem;
import org.eclipse.scada.sec.UserInformation;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class ProxyItemFactory extends AbstractServiceConfigurationFactory<ProxyHistoricalItem>
{

    private final Executor executor;

    public ProxyItemFactory ( final BundleContext context, final Executor executor )
    {
        super ( context );
        this.executor = executor;
    }

    @Override
    protected Entry<ProxyHistoricalItem> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final ProxyHistoricalItem service = new ProxyHistoricalItem ( context, this.executor, configurationId, parameters );

        final Dictionary<String, Object> properties = new Hashtable<String, Object> ();
        properties.put ( Constants.SERVICE_DESCRIPTION, "A proxy to historical items" );
        properties.put ( Constants.SERVICE_PID, configurationId );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );

        final ServiceRegistration<HistoricalItem> handle = context.registerService ( HistoricalItem.class, service, properties );
        return new Entry<ProxyHistoricalItem> ( configurationId, service, handle );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final ProxyHistoricalItem service )
    {
        service.dispose ();
    }

    @Override
    protected Entry<ProxyHistoricalItem> updateService ( final UserInformation userInformation, final String configurationId, final Entry<ProxyHistoricalItem> entry, final Map<String, String> parameters ) throws Exception
    {
        final BundleContext context = entry.getHandle ().getReference ().getBundle ().getBundleContext ();
        entry.getHandle ().unregister ();
        disposeService ( userInformation, configurationId, entry.getService () );
        return createService ( userInformation, configurationId, context, parameters );
    }
}
