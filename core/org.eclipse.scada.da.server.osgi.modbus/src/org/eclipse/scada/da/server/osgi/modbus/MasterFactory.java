/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.osgi.modbus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

import org.apache.mina.transport.socket.nio.NioProcessor;
import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.osgi.framework.BundleContext;

public class MasterFactory extends AbstractServiceConfigurationFactory<ModbusMaster>
{
    public static interface Listener
    {
        public void masterAdded ( String id, ModbusMaster master );

        public void masterRemoved ( String id, ModbusMaster master );
    }

    private final Set<Listener> listeners = new HashSet<> ();

    private final Map<String, ModbusMaster> masters = new HashMap<> ();

    private final ScheduledExecutorService executor;

    private final NioProcessor processor;

    public MasterFactory ( final BundleContext context, final ScheduledExecutorService executor, final NioProcessor processor )
    {
        super ( context, true );
        this.executor = executor;
        this.processor = processor;
    }

    @Override
    protected synchronized Entry<ModbusMaster> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final ModbusMaster master = ModbusMaster.create ( context, this.executor, configurationId, this.processor, parameters );

        this.masters.put ( configurationId, master );
        fireAdded ( configurationId, master );

        return new Entry<ModbusMaster> ( configurationId, master );
    }

    @Override
    protected synchronized void disposeService ( final UserInformation userInformation, final String configurationId, final ModbusMaster service )
    {
        this.masters.remove ( configurationId );
        fireRemoved ( configurationId, service );
        service.dispose ();
    }

    @Override
    protected Entry<ModbusMaster> updateService ( final UserInformation userInformation, final String configurationId, final Entry<ModbusMaster> entry, final Map<String, String> parameters ) throws Exception
    {
        // will never get called since we are "createOnly"
        return null;
    }

    private void fireAdded ( final String configurationId, final ModbusMaster master )
    {
        for ( final Listener listener : this.listeners )
        {
            listener.masterAdded ( configurationId, master );
        }
    }

    private void fireRemoved ( final String configurationId, final ModbusMaster master )
    {
        for ( final Listener listener : this.listeners )
        {
            listener.masterRemoved ( configurationId, master );
        }
    }

    public synchronized void addMasterListener ( final Listener listener )
    {
        if ( this.listeners.add ( listener ) )
        {
            resend ( listener );
        }
    }

    public synchronized void removeMasterListener ( final Listener listener )
    {
        this.listeners.remove ( listener );
    }

    public synchronized void resend ( final Listener listener )
    {
        for ( final Map.Entry<String, ModbusMaster> entry : this.masters.entrySet () )
        {
            listener.masterAdded ( entry.getKey (), entry.getValue () );
        }
    }

}
