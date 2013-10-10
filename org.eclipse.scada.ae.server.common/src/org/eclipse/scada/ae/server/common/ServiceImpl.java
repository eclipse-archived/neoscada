/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.server.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.scada.ae.Query;
import org.eclipse.scada.ae.QueryListener;
import org.eclipse.scada.ae.UnknownQueryException;
import org.eclipse.scada.ae.data.BrowserEntry;
import org.eclipse.scada.ae.data.BrowserType;
import org.eclipse.scada.ae.server.Service;
import org.eclipse.scada.ae.server.Session;
import org.eclipse.scada.ae.server.common.akn.AknHandler;
import org.eclipse.scada.ae.server.common.event.EventQuery;
import org.eclipse.scada.ae.server.common.event.EventQuerySource;
import org.eclipse.scada.ae.server.common.monitor.MonitorQuery;
import org.eclipse.scada.ae.server.common.monitor.MonitorQuerySource;
import org.eclipse.scada.core.InvalidSessionException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.core.server.common.AuthorizedOperation;
import org.eclipse.scada.core.server.common.osgi.AbstractServiceImpl;
import org.eclipse.scada.core.server.common.session.AbstractSessionImpl;
import org.eclipse.scada.core.subscription.SubscriptionManager;
import org.eclipse.scada.core.subscription.ValidationException;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceImpl extends AbstractServiceImpl<Session, SessionImpl> implements Service, ServiceListener
{
    private final static Logger logger = LoggerFactory.getLogger ( ServiceImpl.class );

    private final SubscriptionManager monitorSubscriptions;

    private final SubscriptionManager eventSubscriptions;

    private final BundleContext context;

    private final Map<String, MonitorQuery> conditionQueryRefs = new HashMap<String, MonitorQuery> ();

    private final Map<String, EventQuery> eventQueryRefs = new HashMap<String, EventQuery> ();

    private final Map<String, BrowserEntry> browserCache = new HashMap<String, BrowserEntry> ();

    private final ServiceTracker<AknHandler, AknHandler> aknTracker;

    private ExecutorService queryLoadExecutor;

    private ExecutorService eventExecutor;

    private ServiceListener conditionServiceListener;

    private ServiceListener eventServiceListener;

    public ServiceImpl ( final BundleContext context, final Executor executor ) throws InvalidSyntaxException
    {
        super ( context, executor );

        this.context = context;
        this.monitorSubscriptions = new SubscriptionManager ();
        this.eventSubscriptions = new SubscriptionManager ();

        // create akn handler
        this.aknTracker = new ServiceTracker<AknHandler, AknHandler> ( context, AknHandler.class, null );
    }

    @Override
    public NotifyFuture<Void> acknowledge ( final Session session, final String monitorId, final Date aknTimestamp, final OperationParameters operationParameters, final CallbackHandler callbackHandler ) throws InvalidSessionException
    {
        final SessionImpl sessionImpl = validateSession ( session, SessionImpl.class );

        logger.debug ( "Request akn: {} ({}): sessionUser: {}", new Object[] { monitorId, aknTimestamp, sessionImpl.getUserInformation () } );

        return new AuthorizedOperation<Void, AbstractSessionImpl> ( this.authorizationProvider, sessionImpl, "MONITOR", monitorId, "AKN", null, operationParameters, callbackHandler, DEFAULT_RESULT ) {
            @Override
            protected NotifyFuture<Void> granted ( final org.eclipse.scada.core.server.OperationParameters effectiveOperationParameters )
            {
                processAcknowledge ( monitorId, aknTimestamp, effectiveOperationParameters, callbackHandler );
                return new InstantFuture<Void> ( null );
            }
        };
    }

    protected void processAcknowledge ( final String monitorId, final Date aknTimestamp, final org.eclipse.scada.core.server.OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        logger.debug ( "Processing akn: {} ({}): effective: {}", new Object[] { monitorId, aknTimestamp, operationParameters.getUserInformation ().getName () } );

        for ( final Object o : this.aknTracker.getServices () )
        {
            if ( o instanceof AknHandler )
            {
                if ( ( (AknHandler)o ).acknowledge ( monitorId, operationParameters, aknTimestamp ) )
                {
                    break;
                }
            }
        }
    }

    protected void addMonitorQuery ( final String id, final MonitorQuery query )
    {
        logger.info ( "Adding new query: {}", id );
        this.monitorSubscriptions.setSource ( id, new MonitorQuerySource ( id, query ) );

        final Map<String, Variant> attributes = new HashMap<String, Variant> ();
        final BrowserEntry entry = new BrowserEntry ( id, EnumSet.of ( BrowserType.MONITORS ), attributes );

        triggerBrowserChange ( Arrays.asList ( entry ), null, false );
    }

    protected void removeMonitorQuery ( final String id, final MonitorQuery query )
    {
        logger.info ( "Removing query: {}", id );
        this.monitorSubscriptions.setSource ( id, null );

        triggerBrowserChange ( null, Collections.singleton ( id ), false );
    }

    protected void addEventQuery ( final String id, final EventQuery query )
    {
        logger.info ( "Adding new event query: {}", id );
        this.eventSubscriptions.setSource ( id, new EventQuerySource ( id, query ) );

        final Map<String, Variant> attributes = new HashMap<String, Variant> ();
        final BrowserEntry entry = new BrowserEntry ( id, EnumSet.of ( BrowserType.EVENTS ), attributes );

        triggerBrowserChange ( Arrays.asList ( entry ), null, false );
    }

    protected void removeEventQuery ( final String id, final EventQuery query )
    {
        logger.info ( "Removing event query: {}", id );
        this.eventSubscriptions.setSource ( id, null );

        triggerBrowserChange ( null, Collections.singleton ( id ), false );

        logger.info ( "Removed event query: {}", id );
    }

    protected synchronized void triggerBrowserChange ( final List<BrowserEntry> entries, final Set<String> removed, final boolean full )
    {
        if ( full )
        {
            this.browserCache.clear ();
        }

        if ( removed != null )
        {
            for ( final String id : removed )
            {
                this.browserCache.remove ( id );
            }
        }
        if ( entries != null )
        {
            for ( final BrowserEntry entry : entries )
            {
                this.browserCache.put ( entry.getId (), entry );
            }
        }
        for ( final SessionImpl session : this.sessions )
        {
            session.dataChanged ( entries, removed, full );
        }
    }

    @Override
    public Query createQuery ( final Session session, final String queryType, final String queryData, final QueryListener listener ) throws InvalidSessionException
    {
        // validate the session
        final SessionImpl sessionImpl = validateSession ( session, SessionImpl.class );

        final QueryImpl query = new QueryImpl ( this.context, sessionImpl, this.eventExecutor, this.queryLoadExecutor, queryType, queryData, listener );

        // might dispose us if the session was disposed
        sessionImpl.addQuery ( query );

        if ( !query.isDisposed () )
        {
            query.start ();
            return query;
        }
        else
        {
            // we got disposed since we added ourself to a disposed session
            throw new InvalidSessionException ();
        }
    }

    @Override
    public void subscribeConditionQuery ( final Session session, final String queryId ) throws InvalidSessionException, UnknownQueryException
    {
        final SessionImpl sessionImpl = validateSession ( session, SessionImpl.class );

        logger.info ( "Request condition subscription: " + queryId );

        try
        {
            this.monitorSubscriptions.subscribe ( queryId, sessionImpl.getMonitorListener () );
        }
        catch ( final ValidationException e )
        {
            logger.warn ( "Failed to subscribe", e );
            throw new UnknownQueryException ();
        }
    }

    @Override
    public void unsubscribeConditionQuery ( final Session session, final String queryId ) throws InvalidSessionException
    {
        final SessionImpl sessionImpl = validateSession ( session, SessionImpl.class );

        logger.info ( "Request condition unsubscription: " + queryId );
        this.monitorSubscriptions.unsubscribe ( queryId, sessionImpl.getMonitorListener () );
    }

    @Override
    public void subscribeEventQuery ( final Session session, final String queryId ) throws InvalidSessionException, UnknownQueryException
    {
        final SessionImpl sessionImpl = validateSession ( session, SessionImpl.class );
        logger.info ( "Request event subscription: " + queryId );

        try
        {
            this.eventSubscriptions.subscribe ( queryId, sessionImpl.getEventListener () );
        }
        catch ( final ValidationException e )
        {
            logger.warn ( "Failed to subscribe", e );
            throw new UnknownQueryException ();
        }
    }

    @Override
    public void unsubscribeEventQuery ( final Session session, final String queryId ) throws InvalidSessionException
    {
        final SessionImpl sessionImpl = validateSession ( session, SessionImpl.class );

        logger.info ( "Request event unsubscription: " + queryId );
        this.eventSubscriptions.unsubscribe ( queryId, sessionImpl.getEventListener () );
    }

    @Override
    public void closeSession ( final Session session ) throws InvalidSessionException
    {
        SessionImpl sessionImpl = null;
        synchronized ( this )
        {
            if ( this.sessions.remove ( session ) )
            {
                sessionImpl = (SessionImpl)session;

                // now dispose
                sessionImpl.dispose ();
            }
        }

        if ( sessionImpl != null )
        {
            this.monitorSubscriptions.unsubscribeAll ( sessionImpl.getMonitorListener () );
            this.eventSubscriptions.unsubscribeAll ( sessionImpl.getEventListener () );
        }
    }

    @Override
    protected SessionImpl createSessionInstance ( final UserInformation user, final Map<String, String> sessionProperties )
    {
        final SessionImpl session = new SessionImpl ( user, sessionProperties );
        this.sessions.add ( session );

        // copy data
        final List<BrowserEntry> browserCache = new ArrayList<BrowserEntry> ( this.browserCache.values () );

        if ( !browserCache.isEmpty () )
        {
            // notify current data if we have some
            this.eventExecutor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    session.dataChanged ( browserCache, null, true );
                }
            } );
        }

        return session;
    }

    @Override
    public synchronized void start () throws Exception
    {
        logger.info ( "Staring new service" );
        super.start ();

        this.queryLoadExecutor = Executors.newCachedThreadPool ( new NamedThreadFactory ( "ServiceImpl/QueryLoad" ) );
        this.eventExecutor = Executors.newSingleThreadExecutor ( new NamedThreadFactory ( "ServiceImpl/Event" ) );

        // create monitor query listener
        synchronized ( this )
        {
            this.context.addServiceListener ( this.conditionServiceListener = new ServiceListener () {

                @Override
                public void serviceChanged ( final ServiceEvent event )
                {
                    ServiceImpl.this.serviceChanged ( event );
                }
            }, "(" + Constants.OBJECTCLASS + "=" + MonitorQuery.class.getName () + ")" );
            final Collection<ServiceReference<MonitorQuery>> refs = this.context.getServiceReferences ( MonitorQuery.class, null );
            if ( refs != null )
            {
                for ( final ServiceReference<MonitorQuery> ref : refs )
                {
                    checkAddConditionQuery ( ref );
                }
            }
        }

        // create event query listener
        synchronized ( this )
        {
            this.context.addServiceListener ( this.eventServiceListener = new ServiceListener () {

                @Override
                public void serviceChanged ( final ServiceEvent event )
                {
                    ServiceImpl.this.serviceChanged ( event );
                }
            }, "(" + Constants.OBJECTCLASS + "=" + EventQuery.class.getName () + ")" );
            final Collection<ServiceReference<EventQuery>> refs = this.context.getServiceReferences ( EventQuery.class, null );
            if ( refs != null )
            {
                for ( final ServiceReference<EventQuery> ref : refs )
                {
                    checkAddEventQuery ( ref );
                }
            }
        }

        this.aknTracker.open ( true );
    }

    @Override
    public synchronized void stop () throws Exception
    {
        logger.info ( "Stopping service" );

        // close sessions
        for ( final SessionImpl session : this.sessions )
        {
            session.dispose ();
        }

        // remove service listener
        this.context.removeServiceListener ( this.conditionServiceListener );
        this.context.removeServiceListener ( this.eventServiceListener );
        this.conditionServiceListener = null;
        this.eventServiceListener = null;

        // shut down
        this.aknTracker.close ();

        this.queryLoadExecutor.shutdown ();
        this.queryLoadExecutor = null;

        this.eventExecutor.shutdown ();
        this.eventExecutor = null;

        super.stop ();
    }

    @Override
    public synchronized void serviceChanged ( final ServiceEvent event )
    {
        logger.debug ( "Service changed: {}", event );
        final ServiceReference<?> ref = event.getServiceReference ();

        try
        {
            switch ( event.getType () )
            {
                case ServiceEvent.REGISTERED:
                    checkAddConditionQuery ( ref );
                    checkAddEventQuery ( ref );
                    break;
                case ServiceEvent.UNREGISTERING:
                    final String id = getQueryId ( ref );
                    final MonitorQuery query = this.conditionQueryRefs.remove ( id );
                    if ( query != null )
                    {
                        removeMonitorQuery ( id, query );
                        this.context.ungetService ( ref );
                    }
                    final EventQuery eventQuery = this.eventQueryRefs.remove ( id );
                    if ( eventQuery != null )
                    {
                        removeEventQuery ( id, eventQuery );
                        this.context.ungetService ( ref );
                    }
                    break;
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to handle service change", e );
        }
    }

    private void checkAddConditionQuery ( final ServiceReference<?> ref )
    {
        logger.info ( "Checking query: " + ref );

        final Object o = this.context.getService ( ref );
        if ( o instanceof MonitorQuery )
        {
            final MonitorQuery query = (MonitorQuery)o;
            final String id = getQueryId ( ref );
            if ( id != null )
            {
                this.conditionQueryRefs.put ( id, query );
                addMonitorQuery ( id, query );
            }
        }
        else
        {
            this.context.ungetService ( ref );
        }
    }

    private void checkAddEventQuery ( final ServiceReference<?> ref )
    {
        logger.info ( "Checking query: " + ref );

        final Object o = this.context.getService ( ref );
        if ( o instanceof EventQuery )
        {
            final EventQuery query = (EventQuery)o;
            final String id = getQueryId ( ref );
            if ( id != null )
            {
                this.eventQueryRefs.put ( id, query );
                addEventQuery ( id, query );
            }
        }
        else
        {
            this.context.ungetService ( ref );
        }
    }

    private String getQueryId ( final ServiceReference<?> ref )
    {
        final Object p = ref.getProperty ( Constants.SERVICE_PID );
        if ( p != null )
        {
            return p.toString ();
        }
        else
        {
            return null;
        }

    }
}
