/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.monitor.datasource;

import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.monitor.MonitorService;
import org.eclipse.scada.ae.monitor.common.DataItemMonitor;
import org.eclipse.scada.ae.server.common.akn.AknHandler;
import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ManageableObjectPool;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractMonitorFactory extends AbstractServiceConfigurationFactory<DataItemMonitor> implements AknHandler
{
    private final static Logger logger = LoggerFactory.getLogger ( AbstractMonitorFactory.class );

    protected final BundleContext context;

    protected abstract DataItemMonitor createInstance ( final String configurationId, final EventProcessor eventProcessor );

    protected final EventProcessor eventProcessor;

    private final ManageableObjectPool<MonitorService> servicePool;

    public AbstractMonitorFactory ( final BundleContext context, final ManageableObjectPool<MonitorService> servicePool, final EventProcessor eventProcessor )
    {
        super ( context );
        this.context = context;
        this.servicePool = servicePool;
        this.eventProcessor = eventProcessor;
    }

    @Override
    protected Entry<DataItemMonitor> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final DataItemMonitor instance = createInstance ( configurationId, this.eventProcessor );

        instance.update ( userInformation, parameters );

        final Dictionary<String, String> properties = new Hashtable<String, String> ();
        this.servicePool.addService ( configurationId, instance, properties );

        return new Entry<DataItemMonitor> ( configurationId, instance );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String id, final DataItemMonitor service )
    {
        this.servicePool.removeService ( id, service );
        service.dispose ();
    }

    @Override
    protected Entry<DataItemMonitor> updateService ( final UserInformation userInformation, final String configurationId, final Entry<DataItemMonitor> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( userInformation, parameters );
        return null;
    }

    @Override
    public synchronized boolean acknowledge ( final String monitorId, final OperationParameters operationParameters, final Date aknTimestamp )
    {
        logger.debug ( "Try to process ACK: {}", monitorId );

        final Entry<DataItemMonitor> entry = getService ( monitorId );
        if ( entry != null )
        {
            entry.getService ().akn ( operationParameters == null ? null : operationParameters.getUserInformation (), aknTimestamp );
            return true;
        }
        else
        {
            logger.info ( "Monitor '{}' could not be found in this factory ({})", monitorId, getClass () );
        }

        return false;
    }

}