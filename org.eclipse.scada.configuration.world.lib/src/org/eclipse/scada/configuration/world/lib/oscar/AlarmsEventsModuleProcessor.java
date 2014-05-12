/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.lib.Locator;
import org.eclipse.scada.configuration.lib.Names;
import org.eclipse.scada.configuration.lib.Nodes;
import org.eclipse.scada.configuration.lib.Properties;
import org.eclipse.scada.configuration.utils.TypeVisitor;
import org.eclipse.scada.configuration.utils.TypeWalker;
import org.eclipse.scada.configuration.world.NamedDocumentable;
import org.eclipse.scada.configuration.world.osgi.AknProxy;
import org.eclipse.scada.configuration.world.osgi.AlarmsEventsConnection;
import org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule;
import org.eclipse.scada.configuration.world.osgi.EventPool;
import org.eclipse.scada.configuration.world.osgi.EventPoolProxy;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.MonitorPool;
import org.eclipse.scada.configuration.world.osgi.MonitorPoolProxy;
import org.eclipse.scada.configuration.world.osgi.PullEvents;

public class AlarmsEventsModuleProcessor extends BasicOscarProcessor
{
    private final MasterServer app;

    public AlarmsEventsModuleProcessor ( final MasterServer app, final OscarContext ctx )
    {
        super ( app, ctx );
        this.app = app;
    }

    public void process ( final IProgressMonitor monitor )
    {
        try
        {
            new TypeWalker<> ( AlarmsEventsModule.class ).walk ( this.app, new TypeVisitor<AlarmsEventsModule> () {

                @Override
                public void visit ( final AlarmsEventsModule item ) throws Exception
                {
                    process ( item );
                }
            } );
        }
        catch ( final Exception e )
        {
            throw new RuntimeException ( e );
        }
        finally
        {
            monitor.done ();
        }
    }

    protected void process ( final AlarmsEventsModule module )
    {
        for ( final EventPoolProxy proxy : module.getEventPoolProxies () )
        {
            processEventProxy ( proxy );
        }

        for ( final MonitorPoolProxy proxy : module.getMonitorPoolProxies () )
        {
            processMonitorProxy ( proxy );
        }

        for ( final AknProxy proxy : module.getAknProxies () )
        {
            processAknProxy ( proxy );
        }

        for ( final PullEvents pull : module.getPullEvents () )
        {
            processPullEvents ( pull );
        }
    }

    private void processPullEvents ( final PullEvents pull )
    {
        final Map<String, String> data = new HashMap<String, String> ();

        data.put ( "driverName", pull.getJdbcDriverName () );
        Helper.addOptional ( data, "customDeleteSql", pull.getCustomDeleteSql () );
        Helper.addOptional ( data, "customSelectSql", pull.getCustomSelectSql () );
        data.putAll ( Properties.makeAttributes ( "jdbcProperties", pull.getJdbcProperties () ) );
        Helper.addOptional ( data, "delay", pull.getJobInterval () );

        addData ( Factories.FACTORY_AE_PULL_EVENTS, Names.makeName ( pull ), data );
    }

    private void processAknProxy ( final AknProxy proxy )
    {
        final Map<String, String> data = new HashMap<String, String> ();

        final boolean isLocal = Nodes.isLocal ( proxy.getConnection ().getEndpoint ().getNode (), this.app );

        data.put ( "pattern", "" + proxy.getPattern () );
        data.put ( "authorative", "" + proxy.isAuthorative () );
        data.put ( "connection.id", proxy.getConnection ().makeUri ( isLocal ) );
        data.put ( "priority", "" + proxy.getPriority () );

        addData ( Factories.FACTORY_AE_AKN_PROXY, String.format ( "%s-%s", proxy.getConnection ().getEndpoint ().getNode ().getHostName (), proxy.getPriority () ), data );
    }

    private void processEventProxy ( final EventPoolProxy proxy )
    {
        final Map<String, String> data = new HashMap<String, String> ();

        final String id = Names.makeName ( proxy );

        data.put ( "poolSize", "" + proxy.getSize () ); //$NON-NLS-1$ //$NON-NLS-2$

        {
            int i = 0;
            for ( final EventPool remote : proxy.getRemote () )
            {
                data.put ( "remote.queries." + i, makeUri ( this.app, remote ) ); //$NON-NLS-1$
                i++;
            }
        }
        {
            int i = 0;
            for ( final EventPool local : proxy.getLocal () )
            {
                data.put ( "local.queries." + i, Names.makeName ( local ) ); //$NON-NLS-1$
                i++;
            }
        }

        addData ( Factories.FACTORY_AE_EVENT_PROXY_QUERY, id, data );
    }

    private void processMonitorProxy ( final MonitorPoolProxy proxy )
    {
        final Map<String, String> data = new HashMap<String, String> ();

        final String id = Names.makeName ( proxy );

        {
            int i = 0;
            for ( final MonitorPool remote : proxy.getRemote () )
            {
                data.put ( "remote.queries." + i, makeUri ( this.app, remote ) ); //$NON-NLS-1$
                i++;
            }
        }
        {
            int i = 0;
            for ( final MonitorPool local : proxy.getLocal () )
            {
                data.put ( "local.queries." + i, Names.makeName ( local ) ); //$NON-NLS-1$
                i++;
            }
        }

        addData ( Factories.FACTORY_AE_MONITOR_PROXY_QUERY, id, data );
    }

    private String makeUri ( final MasterServer from, final NamedDocumentable remote )
    {
        final MasterServer to = Locator.findApplication ( remote, MasterServer.class );
        if ( to == null )
        {
            throw new IllegalStateException ( String.format ( "No master server found for pool %s", remote.getName () ) );
        }

        final AlarmsEventsConnection connection = Locator.findPossibleConnection ( from, to, AlarmsEventsConnection.class );

        return connection.getName () + "#" + Names.makeName ( remote );
    }
}
