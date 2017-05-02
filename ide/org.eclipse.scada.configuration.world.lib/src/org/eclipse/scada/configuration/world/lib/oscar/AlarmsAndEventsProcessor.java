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
package org.eclipse.scada.configuration.world.lib.oscar;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.lib.Names;
import org.eclipse.scada.configuration.lib.Properties;
import org.eclipse.scada.configuration.world.osgi.EventPool;
import org.eclipse.scada.configuration.world.osgi.ExternalEventFilter;
import org.eclipse.scada.configuration.world.osgi.ExternalEventMonitor;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.MonitorPool;
import org.eclipse.scada.configuration.world.osgi.SimpleExternalEventFilter;
import org.eclipse.scada.configuration.world.osgi.StaticExternalEventFilter;

public class AlarmsAndEventsProcessor extends BasicOscarProcessor
{
    private final MasterServer app;

    public AlarmsAndEventsProcessor ( final MasterServer app, final OscarContext ctx )
    {
        super ( app, ctx );
        this.app = app;
    }

    public void process ()
    {
        createServerInformation ();
        for ( final MonitorPool pool : this.app.getMonitorPools () )
        {
            createMonitorPool ( pool );
        }
        for ( final EventPool pool : this.app.getEventPools () )
        {
            createEventPool ( pool );
        }
        for ( final ExternalEventMonitor eventMonitor : this.app.getExternalEventMonitors () )
        {
            createExternalEventMonitor ( eventMonitor );
        }

        createExternalFilters ();
    }

    private void createExternalFilters ()
    {
        {
            int priority = 100;
            for ( final ExternalEventFilter filter : this.app.getExternalEventFilters () )
            {
                createFilter ( filter, priority );
                priority += 100;
            }
        }
    }

    private void createFilter ( final ExternalEventFilter filter, final int priority )
    {
        final Map<String, String> data = new HashMap<String, String> ();
        data.put ( "priority", "" + priority ); //$NON-NLS-1$ //$NON-NLS-2$
        data.put ( "id", Names.makeName ( filter ) ); // for now ... //$NON-NLS-1$

        if ( filter instanceof SimpleExternalEventFilter )
        {
            data.put ( "type", "filter" ); //$NON-NLS-1$ //$NON-NLS-2$
            data.put ( "filter", ( (SimpleExternalEventFilter)filter ).getFilter () );
            addData ( Factories.FACTORY_EXTERNAL_EVENT_FILTER, Names.makeName ( filter ), data );
        }
        else if ( filter instanceof StaticExternalEventFilter )
        {
            data.put ( "type", "static" ); //$NON-NLS-1$ //$NON-NLS-2$
            data.put ( "value", ( (StaticExternalEventFilter)filter ).getValue () );
            addData ( Factories.FACTORY_EXTERNAL_EVENT_FILTER, Names.makeName ( filter ), data );
        }
    }

    private void createExternalEventMonitor ( final ExternalEventMonitor eventMonitor )
    {
        final Map<String, String> data = new HashMap<String, String> ();

        data.put ( "filter", eventMonitor.getFilter () ); //$NON-NLS-1$
        Configurations.applyInfoAttributes ( Properties.makeAttributes ( eventMonitor.getProperties () ), data );

        addData ( Factories.FACTORY_AE_EXTERNAL, Names.makeName ( eventMonitor ), data );
    }

    private void createEventPool ( final EventPool pool )
    {
        final Map<String, String> data = new HashMap<String, String> ();
        data.put ( "filter", pool.getFilter () ); //$NON-NLS-1$
        data.put ( "size", "" + pool.getSize () ); //$NON-NLS-1$ //$NON-NLS-2$
        addData ( Factories.FACTORY_AE_EVENT_POOL, Names.makeName ( pool ), data );
    }

    private void createMonitorPool ( final MonitorPool pool )
    {
        final Map<String, String> data = new HashMap<String, String> ();
        data.put ( "filter", pool.getFilter () ); //$NON-NLS-1$
        addData ( Factories.FACTORY_AE_MONITOR_POOL, Names.makeName ( pool ), data );
    }

    private void createServerInformation ()
    {
        final String prefix = this.app.getAeServerInformationPrefix ();
        if ( prefix != null && !prefix.isEmpty () )
        {
            final Map<String, String> data = new HashMap<String, String> ( 1 );
            data.put ( "prefix", prefix ); //$NON-NLS-1$ 
            addData ( Factories.FACTORY_AE_SERVER_INFO, prefix, data );
        }
    }

}
