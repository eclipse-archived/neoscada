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
package org.eclipse.scada.sec.osgi.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.sec.AuthorizationReply;
import org.eclipse.scada.sec.AuthorizationRequest;
import org.eclipse.scada.sec.AuthorizationResult;
import org.eclipse.scada.sec.AuthorizationService;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.authz.AuthorizationContext;
import org.eclipse.scada.sec.osgi.AuthorizationHelper;
import org.eclipse.scada.sec.osgi.AuthorizationManager;
import org.eclipse.scada.sec.osgi.AuthorizationTracker;
import org.eclipse.scada.utils.ExceptionHelper;
import org.eclipse.scada.utils.concurrent.ExportedExecutorService;
import org.eclipse.scada.utils.concurrent.FutureListener;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.str.Tables;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jens Reimann
 * @since 1.1
 */
public class AuthorizationManagerImpl implements AuthorizationManager, ConfigurationFactory, AuthorizationTracker
{

    private final static Logger logger = LoggerFactory.getLogger ( AuthorizationManagerImpl.class );

    private ServiceTracker<AuthorizationService, AuthorizationService> tracker;

    private final Set<MonitorImpl> monitors = new LinkedHashSet<MonitorImpl> ();

    private final HashMap<String, AuthorizationService> services = new HashMap<String, AuthorizationService> ();

    private ExecutorService executor;

    private List<ConfigurationEntry> configurationCache = Collections.emptyList ();

    public void activate ( final BundleContext context )
    {
        this.executor = new ExportedExecutorService ( AuthorizationManagerImpl.class.getName (), 1, 1, 1, TimeUnit.MINUTES );
        this.tracker = new ServiceTracker<AuthorizationService, AuthorizationService> ( context, AuthorizationService.class, new ServiceTrackerCustomizerImplementation ( this, context ) );

        this.tracker.open ();
    }

    public void deactivate ()
    {
        final ExecutorService exeService;

        synchronized ( this )
        {
            this.tracker.close ();
            this.tracker = null;
            invalidateAll ();

            exeService = this.executor;
            this.executor = null;
        }

        exeService.shutdown ();
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.sec.osgi.manager.AuthorizationTracker#createMonitor(org.eclipse.scada.sec.osgi.manager.Listener, org.eclipse.scada.sec.AuthorizationRequest)
     */
    @Override
    public synchronized Monitor createMonitor ( final Listener listener, final AuthorizationRequest request )
    {
        final MonitorImpl monitor = new MonitorImpl ( this, listener, request );

        this.monitors.add ( monitor );

        revalidateMonitor ( monitor );

        return monitor;
    }

    public synchronized void disposeMonitor ( final MonitorImpl monitor )
    {
        this.monitors.remove ( monitor );
    }

    private void invalidateAll ()
    {
        for ( final MonitorImpl monitor : this.monitors )
        {
            monitorSetResult ( monitor, AuthorizationReply.create ( AuthorizationHelper.DEFAULT_RESULT, monitor.getContext () ) );
        }
    }

    private void monitorSetResult ( final MonitorImpl monitor, final AuthorizationReply result )
    {
        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                monitor.setResult ( result );
            }
        } );
    }

    synchronized void addService ( final AuthorizationService service, final String[] serviceTypes )
    {
        logger.debug ( "Service added - {} / {}", service, serviceTypes );

        for ( final String serviceType : serviceTypes )
        {
            this.services.put ( serviceType, service );
        }

        realizeAll ();
    }

    private void realizeAll ()
    {
        int realized = 0;
        for ( final ConfigurationEntry cfg : this.configuration.values () )
        {
            if ( cfg.realize () )
            {
                realized++;
            }
        }

        logger.info ( "Realized {} entries", realized );
        if ( realized > 0 )
        {
            revalidateAll ();
        }
    }

    synchronized void removeService ( final AuthorizationService service )
    {
        logger.debug ( "Service removed - {}", service );

        boolean removedService = false;
        final Iterator<Map.Entry<String, AuthorizationService>> i = this.services.entrySet ().iterator ();
        while ( i.hasNext () )
        {
            final Map.Entry<String, AuthorizationService> entry = i.next ();
            if ( entry.getValue () == service )
            {
                i.remove ();
                removedService = true;
            }
        }

        boolean removed = false;

        if ( removedService )
        {
            for ( final ConfigurationEntry cfg : this.configuration.values () )
            {
                if ( cfg.realizedBy ( service ) )
                {
                    cfg.unrealize ();
                    removed = true;
                }
            }
        }

        if ( removed )
        {
            revalidateAll ();
        }
    }

    public synchronized void revalidateAll ()
    {
        for ( final MonitorImpl monitor : this.monitors )
        {
            revalidateMonitor ( monitor );
        }
    }

    private void revalidateMonitor ( final MonitorImpl monitor )
    {
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                performRevalidate ( monitor );
            }
        } );

    }

    protected void performRevalidate ( final MonitorImpl monitor )
    {
        authorize ( monitor.getContext (), AuthorizationHelper.DEFAULT_RESULT ).addListener ( new FutureListener<AuthorizationReply> () {

            @Override
            public void complete ( final Future<AuthorizationReply> future )
            {
                try
                {
                    monitorSetResult ( monitor, future.get () );
                }
                catch ( final Exception e )
                {
                    logger.warn ( "Failed to check", e );
                    monitorSetResult ( monitor, AuthorizationReply.create ( AuthorizationResult.createReject ( e ), monitor.getContext () ) );
                }
            }
        } );
    }

    protected synchronized Iterable<ConfigurationEntry> getCurrentRules ()
    {
        return this.configurationCache;
    }

    /**
     * Single shot authorization
     */
    @Override
    public NotifyFuture<AuthorizationReply> authorize ( final AuthorizationContext context, final AuthorizationResult defaultResult )
    {
        return AuthorizationHelper.authorize ( getCurrentRules (), context, defaultResult );
    }

    private final Map<String, ConfigurationEntry> configuration = new HashMap<String, ConfigurationEntry> ();

    @Override
    public synchronized void update ( final UserInformation userInformation, final String configurationId, final Map<String, String> parameters ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        final String serviceType = cfg.getStringChecked ( "serviceType", "The 'serviceType' must be set" ); //$NON-NLS-1$
        final int priority = cfg.getIntegerChecked ( "priority", "'priority' must be set" );

        final ConfigurationEntry newCfg = new ConfigurationEntry ( this, configurationId, serviceType, priority, cfg.getPrefixed ( "properties." ) ); //$NON-NLS-1$
        newCfg.setPreFilter ( parameters );

        final ConfigurationEntry oldCfg = this.configuration.put ( configurationId, newCfg );
        if ( oldCfg != null )
        {
            oldCfg.dispose ();
        }

        newCfg.realize ();

        updateCache ();

        // last step is to revalidate all monitors
        revalidateAll ();
    }

    private void updateCache ()
    {
        this.configurationCache = new ArrayList<ConfigurationEntry> ( this.configuration.values () );
        Collections.sort ( this.configurationCache );
    }

    @Override
    public synchronized void delete ( final UserInformation userInformation, final String configurationId ) throws Exception
    {
        final ConfigurationEntry oldCfg = this.configuration.remove ( configurationId );
        if ( oldCfg == null )
        {
            // removed something that was not there
            return;
        }

        oldCfg.dispose ();

        updateCache ();

        // last step is to revalidate all monitors
        revalidateAll ();
    }

    public synchronized AuthorizationService findService ( final String serviceType )
    {
        return this.services.get ( serviceType );
    }

    public void list ()
    {
        final List<List<String>> data = new LinkedList<List<String>> ();

        for ( final ConfigurationEntry cfg : this.configurationCache )
        {
            final List<String> row = new LinkedList<String> ();
            row.add ( cfg.getId () );
            row.add ( "" + cfg.getPriority () );
            row.add ( cfg.getServiceType () );
            row.add ( cfg.isRealized () ? "X" : "" );
            row.add ( cfg.getTypeFilter () == null ? "" : cfg.getTypeFilter ().toString () );
            row.add ( cfg.getIdFilter () == null ? "" : cfg.getIdFilter ().toString () );
            row.add ( cfg.getActionFilter () == null ? "" : cfg.getActionFilter ().toString () );
            row.add ( ExceptionHelper.getMessage ( cfg.getError () ) );
            data.add ( row );
        }

        Tables.showTable ( System.out, Arrays.asList ( "ID", "Priority", "ServiceType", "Realized", "TypeFilter", "IdFilter", "ActionFilter", "Error" ), data, 2 );
    }
}
