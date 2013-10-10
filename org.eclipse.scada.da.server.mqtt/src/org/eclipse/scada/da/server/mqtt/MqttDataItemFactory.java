/*******************************************************************************
 * Copyright (c) 2013 Jürgen Rose and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jürgen Rose - initial API and implementation
 *******************************************************************************/

package org.eclipse.scada.da.server.mqtt;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;

import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.mqtt.MqttBroker;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MqttDataItemFactory extends AbstractServiceConfigurationFactory<MqttDataitem> implements ServiceTrackerCustomizer<MqttBroker, MqttBroker>
{

    private final static Logger logger = LoggerFactory.getLogger ( MqttDataItemFactory.class );

    public static final Object FACTORY_ID = "org.eclipse.scada.da.server.mqtt";

    private final ExecutorService executor;

    private final BundleContext context;

    private final ObjectPoolImpl<DataItem> itemPool;

    private final ServiceTracker<MqttBroker, MqttBroker> tracker;

    private final ConcurrentSkipListSet<MqttDataitem> unassigned = new ConcurrentSkipListSet<MqttDataitem> ();

    private final ConcurrentMap<String, ConcurrentSkipListSet<MqttDataitem>> assigned = new ConcurrentHashMap<> ();

    public MqttDataItemFactory ( final ExecutorService executor, final BundleContext context, final ObjectPoolImpl<DataItem> itemPool )
    {
        super ( context );
        this.executor = executor;
        this.context = context;
        this.itemPool = itemPool;
        this.tracker = new ServiceTracker<> ( context, MqttBroker.class, this );
        this.tracker.open ( true );
    }

    @Override
    public synchronized void dispose ()
    {
        super.dispose ();
    }

    @Override
    protected Entry<MqttDataitem> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {

        final MqttDataitem service = new MqttDataitem ( configurationId, this.executor );
        service.update ( parameters );
        findAndAssignBroker ( service );
        this.itemPool.addService ( configurationId, service, null );

        return new Entry<MqttDataitem> ( configurationId, service );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final MqttDataitem service )
    {
        removeFromBrokers ( service );
        this.itemPool.removeService ( configurationId, service );
    }

    @Override
    protected Entry<MqttDataitem> updateService ( final UserInformation userInformation, final String configurationId, final org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory.Entry<MqttDataitem> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( parameters );
        removeFromBrokers ( entry.getService () );
        findAndAssignBroker ( entry.getService () );
        return null;
    }

    @Override
    public MqttBroker addingService ( final ServiceReference<MqttBroker> reference )
    {
        final String brokerId = (String)reference.getProperty ( Constants.SERVICE_PID );
        if ( brokerId == null )
        {
            logger.warn ( "Failed to set broker {}. '{}' is not set", reference, Constants.SERVICE_PID );
            return null;
        }
        final MqttBroker broker = this.context.getService ( reference );
        assignBroker ( brokerId, broker );
        return broker;
    }

    @Override
    public void modifiedService ( final ServiceReference<MqttBroker> reference, final MqttBroker service )
    {
        final String brokerId = (String)reference.getProperty ( Constants.SERVICE_PID );
        if ( brokerId == null )
        {
            logger.warn ( "Failed to change broker {}. '{}' is not set", reference, Constants.SERVICE_PID );
            return;
        }
        removeBroker ( brokerId );
        assignBroker ( brokerId, service );
    }

    @Override
    public void removedService ( final ServiceReference<MqttBroker> reference, final MqttBroker service )
    {
        final String brokerId = (String)reference.getProperty ( Constants.SERVICE_PID );
        if ( brokerId == null )
        {
            logger.warn ( "Failed to remove broker {}. '{}' is not set", reference, Constants.SERVICE_PID );
            return;
        }
        removeBroker ( brokerId );
    }

    private void removeBroker ( final String brokerId )
    {
        final ConcurrentSkipListSet<MqttDataitem> mqttDataitems = this.assigned.remove ( brokerId );
        if ( mqttDataitems != null )
        {
            for ( final MqttDataitem mqttDataitem : mqttDataitems )
            {
                mqttDataitem.unsetBroker ();
            }
            this.unassigned.addAll ( mqttDataitems );
        }
    }

    private void assignBroker ( final String brokerId, final MqttBroker broker )
    {
        final List<MqttDataitem> matching = new LinkedList<> ();
        for ( final MqttDataitem mqttDataitem : this.unassigned )
        {
            if ( ( mqttDataitem.getBrokerId () != null ) && mqttDataitem.getBrokerId ().equals ( brokerId ) )
            {
                matching.add ( mqttDataitem );
            }
        }
        this.unassigned.removeAll ( matching );
        for ( final MqttDataitem mqttDataitem : matching )
        {
            mqttDataitem.setBroker ( broker );
        }
        this.assigned.putIfAbsent ( brokerId, new ConcurrentSkipListSet<MqttDataitem> () );
        this.assigned.get ( brokerId ).addAll ( matching );
    }

    private void findAndAssignBroker ( final MqttDataitem service )
    {
        if ( ( service.getBrokerId () == null ) || service.getBrokerId ().trim ().equals ( "" ) )
        {
            logger.trace ( "no broker id set" );
            service.connectionLost ( new RuntimeException ( "broker is not set" ) );
            this.unassigned.add ( service );
            return;
        }
        if ( this.tracker.getServiceReferences () != null )
        {
            for ( final ServiceReference<MqttBroker> reference : this.tracker.getServiceReferences () )
            {
                final String brokerId = (String)reference.getProperty ( Constants.SERVICE_PID );
                if ( brokerId == null )
                {
                    logger.warn ( "Can not use broker {}. '{}' is not set", reference, Constants.SERVICE_PID );
                    continue;
                }
                if ( brokerId.equals ( service.getBrokerId () ) )
                {
                    this.unassigned.remove ( service );
                    service.setBroker ( this.context.getService ( reference ) );
                    this.assigned.putIfAbsent ( brokerId, new ConcurrentSkipListSet<MqttDataitem> () );
                    this.assigned.get ( brokerId ).add ( service );
                }
            }
        }
        if ( !service.isBrokerSet () )
        {
            service.connectionLost ( new RuntimeException ( "broker is not set" ) );
            this.unassigned.add ( service );
        }
    }

    private void removeFromBrokers ( final MqttDataitem service )
    {
        this.unassigned.remove ( service );
        if ( service.getBrokerId () != null )
        {
            final Set<MqttDataitem> mqttDataitems = this.assigned.get ( service.getBrokerId () );
            if ( mqttDataitems != null )
            {
                mqttDataitems.remove ( service );
            }
        }
    }
}
