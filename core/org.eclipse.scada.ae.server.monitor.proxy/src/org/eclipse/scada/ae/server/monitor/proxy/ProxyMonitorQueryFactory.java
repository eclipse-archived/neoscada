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
package org.eclipse.scada.ae.server.monitor.proxy;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.ae.server.common.monitor.MonitorQuery;
import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProxyMonitorQueryFactory extends AbstractServiceConfigurationFactory<ProxyMonitorQuery>
{

    private final static Logger logger = LoggerFactory.getLogger ( ProxyMonitorQueryFactory.class );

    public static final String FACTORY_ID = "org.eclipse.scada.ae.server.monitor.proxy";

    private final Executor executor;

    public ProxyMonitorQueryFactory ( final BundleContext context, final Executor executor )
    {
        super ( context );
        this.executor = executor;
    }

    @Override
    protected Entry<ProxyMonitorQuery> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        logger.info ( "Creating new proxy query: {}", configurationId );

        final ProxyMonitorQuery service = new ProxyMonitorQuery ( context, this.executor );

        final Hashtable<String, Object> properties = new Hashtable<String, Object> ();
        properties.put ( Constants.SERVICE_PID, configurationId );
        final ServiceRegistration<MonitorQuery> handle = context.registerService ( MonitorQuery.class, service, properties );

        service.update ( userInformation, parameters );

        return new Entry<ProxyMonitorQuery> ( configurationId, service, handle );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final ProxyMonitorQuery service )
    {
        service.dispose ();
    }

    @Override
    protected Entry<ProxyMonitorQuery> updateService ( final UserInformation userInformation, final String configurationId, final Entry<ProxyMonitorQuery> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( userInformation, parameters );
        return null;
    }

}
