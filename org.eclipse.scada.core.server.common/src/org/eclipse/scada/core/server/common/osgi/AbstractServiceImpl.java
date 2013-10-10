/*******************************************************************************
 * Copyright (c) 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.server.common.osgi;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

import org.eclipse.scada.core.InvalidSessionException;
import org.eclipse.scada.core.server.Session;
import org.eclipse.scada.core.server.common.AuthorizationProvider;
import org.eclipse.scada.core.server.common.ServiceCommon;
import org.eclipse.scada.core.server.common.session.AbstractSessionImpl;
import org.eclipse.scada.core.server.common.session.PrivilegeListenerImpl;
import org.eclipse.scada.core.server.common.session.AbstractSessionImpl.DisposeListener;
import org.eclipse.scada.sec.AuthorizationReply;
import org.eclipse.scada.sec.AuthorizationRequest;
import org.eclipse.scada.sec.AuthorizationResult;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.sec.osgi.TrackingAuditLogImplementation;
import org.eclipse.scada.sec.osgi.TrackingAuthenticationImplementation;
import org.eclipse.scada.sec.osgi.TrackingAuthorizationImplementation;
import org.eclipse.scada.sec.osgi.TrackingAuthorizationTracker;
import org.eclipse.scada.utils.concurrent.CallingFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;

public abstract class AbstractServiceImpl<S extends Session, SI extends AbstractSessionImpl> extends ServiceCommon<S, SI>
{

    private final TrackingAuthorizationImplementation authorizationHelper;

    protected final Set<SI> sessions = new CopyOnWriteArraySet<SI> ();

    private final TrackingAuthorizationTracker authorizationTracker;

    private final Executor executor;

    protected final AuthorizationProvider<AbstractSessionImpl> authorizationProvider = new AuthorizationProvider<AbstractSessionImpl> () {

        @Override
        public NotifyFuture<UserInformation> impersonate ( final AbstractSessionImpl session, final String targetUserName, final CallbackHandler handler )
        {
            return makeEffectiveUserInformation ( session, targetUserName, handler );
        }

        @Override
        public NotifyFuture<AuthorizationReply> authorize ( final AuthorizationRequest authorizationRequest, final CallbackHandler handler, final AuthorizationResult defaultResult )
        {
            return AbstractServiceImpl.this.authorize ( authorizationRequest, handler, defaultResult );
        }
    };

    private final TrackingAuthenticationImplementation authenticationImplemenation;

    private final TrackingAuditLogImplementation auditLogTracker;

    public AbstractServiceImpl ( final BundleContext context, final Executor executor ) throws InvalidSyntaxException
    {
        this.executor = executor;
        this.authorizationHelper = new TrackingAuthorizationImplementation ( context );
        this.authorizationTracker = new TrackingAuthorizationTracker ( context );

        this.authenticationImplemenation = new TrackingAuthenticationImplementation ( context );

        this.auditLogTracker = new TrackingAuditLogImplementation ( context );

        setAuthorizationImplementation ( this.authorizationHelper );
        setAuthenticationImplementation ( this.authenticationImplemenation );
        setAuditLogService ( this.auditLogTracker );
    }

    @Override
    public void start () throws Exception
    {
        this.authorizationHelper.open ();
        this.authorizationTracker.open ();
        this.authenticationImplemenation.open ();
        this.auditLogTracker.open ();
    }

    @Override
    public void stop () throws Exception
    {
        // close sessions
        for ( final SI session : this.sessions )
        {
            session.dispose ();
        }

        this.auditLogTracker.close ();
        this.authenticationImplemenation.close ();
        this.authorizationHelper.close ();
        this.authorizationTracker.close ();
    }

    @SuppressWarnings ( "unchecked" )
    @Override
    public void closeSession ( final S session ) throws InvalidSessionException
    {
        SI sessionImpl = null;
        synchronized ( this )
        {
            if ( this.sessions.remove ( session ) )
            {
                sessionImpl = (SI)session;
            }
        }

        if ( sessionImpl != null )
        {
            // now dispose
            sessionImpl.dispose ();

            handleSessionClosed ( sessionImpl );
        }
    }

    protected void handleSessionClosed ( final SI session )
    {
    }

    /**
     * @since 1.1
     */
    @Override
    public NotifyFuture<S> createSession ( final Properties properties, final CallbackHandler callbackHandler )
    {
        final NotifyFuture<UserInformation> loginFuture = loginUser ( properties, callbackHandler );

        return new CallingFuture<UserInformation, S> ( loginFuture ) {

            @Override
            public S call ( final Future<UserInformation> future ) throws Exception
            {
                return createSession ( future, properties, callbackHandler );
            }
        };
    }

    /**
     * @since 1.1
     */
    @SuppressWarnings ( "unchecked" )
    protected S createSession ( final Future<UserInformation> loginFuture, final Properties properties, final CallbackHandler callbackHandler ) throws Exception
    {
        final UserInformation user = loginFuture.get ();

        final SI session;
        synchronized ( this )
        {

            final Map<String, String> sessionProperties = new HashMap<String, String> ();

            session = createSessionInstance ( user, sessionProperties );

            final Set<String> privileges = extractPrivileges ( properties );
            final SessionPrivilegeTracker privTracker = new SessionPrivilegeTracker ( this.executor, new PrivilegeListenerImpl ( session ), this.authorizationTracker, privileges, user );

            session.addDisposeListener ( new DisposeListener () {

                @Override
                public void disposed ()
                {
                    privTracker.dispose ();
                }
            } );

            this.sessions.add ( session );

            handleSessionCreated ( session );
        }

        return (S)session;
    }

    protected void handleSessionCreated ( final SI session )
    {
    }

    protected abstract SI createSessionInstance ( UserInformation user, Map<String, String> sessionProperties );

    protected synchronized SI validateSession ( final S session, final Class<SI> sessionImplClazz ) throws InvalidSessionException
    {
        if ( !this.sessions.contains ( session ) )
        {
            throw new InvalidSessionException ();
        }

        try
        {
            return sessionImplClazz.cast ( session );
        }
        catch ( final ClassCastException e )
        {
            throw new InvalidSessionException ();
        }
    }

}
