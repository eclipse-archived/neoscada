/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.server.common;

import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Future;

import org.eclipse.scada.core.server.Service;
import org.eclipse.scada.core.server.Session;
import org.eclipse.scada.core.server.common.session.AbstractSessionImpl;
import org.eclipse.scada.sec.AuthenticationImplementation;
import org.eclipse.scada.sec.AuthorizationImplementation;
import org.eclipse.scada.sec.AuthorizationReply;
import org.eclipse.scada.sec.AuthorizationRequest;
import org.eclipse.scada.sec.AuthorizationResult;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.audit.AuditLogService;
import org.eclipse.scada.sec.audit.log.slf4j.LogServiceImpl;
import org.eclipse.scada.sec.authz.AuthorizationContext;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.CallingFuture;
import org.eclipse.scada.utils.concurrent.FutureListener;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ServiceCommon<S extends Session, SI extends AbstractSessionImpl> implements Service<S>
{

    private final static Logger logger = LoggerFactory.getLogger ( ServiceCommon.class );

    protected static final AuthorizationResult DEFAULT_RESULT = AuthorizationResult.createReject ( org.eclipse.scada.sec.StatusCodes.AUTHORIZATION_FAILED, Messages.getString ( "ServiceCommon.DefaultMessage" ) ); //$NON-NLS-1$

    private AuthorizationImplementation authorizationImplementation;

    private AuthenticationImplementation authenticationImplementation;

    private AuditLogService auditLogService;

    public ServiceCommon ()
    {
        this.authenticationImplementation = new DefaultAuthentication ();
        this.authorizationImplementation = new DefaultAuthorization ( new AuthenticationImplementation () {

            @Override
            public UserInformation getUser ( final String user )
            {
                return ServiceCommon.this.authenticationImplementation.getUser ( user );
            }

            @Override
            public NotifyFuture<UserInformation> authenticate ( final CallbackHandler callbackHandler )
            {
                return ServiceCommon.this.authenticationImplementation.authenticate ( callbackHandler );
            }
        } );
        this.auditLogService = new LogServiceImpl ();
    }

    public void setAuditLogService ( final AuditLogService auditLogService )
    {
        this.auditLogService = auditLogService == null ? new LogServiceImpl () : auditLogService;
    }

    protected void setAuthenticationImplementation ( final AuthenticationImplementation authenticationImplementation )
    {
        this.authenticationImplementation = authenticationImplementation;
    }

    protected void setAuthorizationImplementation ( final AuthorizationImplementation authorizationImplementation )
    {
        this.authorizationImplementation = authorizationImplementation;
    }

    protected Set<String> extractPrivileges ( final Properties properties )
    {
        final Set<String> result = new HashSet<String> ();

        for ( final Map.Entry<Object, Object> entry : properties.entrySet () )
        {
            if ( entry.getKey () instanceof String && entry.getValue () instanceof String )
            {
                final String key = (String)entry.getKey ();
                if ( key.startsWith ( "session.privilege." ) ) //$NON-NLS-1$
                {
                    final String priv = key.substring ( "session.privilege.".length () ); //$NON-NLS-1$
                    result.add ( priv );
                }
            }
        }

        return result;
    }

    /**
     * Wraps the call to {@link #authenticate(Properties)} so that the correct
     * exceptions are thrown for a {@link #createSession(Properties)} call.
     * 
     * @param properties
     *            the user session properties
     * @param callbackHandler
     *            the callback handler which handles callbacks
     * @param sessionResultProperties
     *            the map will be filled with the resulting session properties
     * @return the user information returned by
     *         {@link #authenticate(Properties)}
     * @see #authenticate(Properties)
     * @since 1.1
     */
    protected NotifyFuture<UserInformation> loginUser ( final Properties properties, final CallbackHandler callbackHandler )
    {
        final NotifyFuture<AuthorizationReply> future = authorize ( new AuthorizationRequest ( "SESSION", null, "CONNECT", UserInformation.ANONYMOUS, null ), callbackHandler );
        return new CallingFuture<AuthorizationReply, UserInformation> ( future ) {

            @Override
            public UserInformation call ( final Future<AuthorizationReply> future ) throws Exception
            {
                final AuthorizationReply authResult = future.get ();

                final Exception e = authResult.getResult ().asException ();
                if ( e != null )
                {
                    logger.debug ( "Failed to login user", e );
                    throw e;
                }

                return authResult.getUserInformation ();
            }
        };
    }

    /**
     * @since 1.1
     */
    protected void fillSessionProperties ( final UserInformation userInformation, final Map<String, String> sessionResultProperties )
    {
        if ( userInformation != null && !userInformation.isAnonymous () )
        {
            sessionResultProperties.put ( "userInformation.name", userInformation.getName () ); //$NON-NLS-1$
        }
        if ( userInformation != null && userInformation.getRoles () != null )
        {
            for ( final String role : userInformation.getRoles () )
            {
                sessionResultProperties.put ( String.format ( "userInformation.roles.%s", role ), "true" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
    }

    /**
     * @since 1.1
     */
    protected NotifyFuture<AuthorizationReply> authorize ( final AuthorizationRequest request, final CallbackHandler callbackHandler )
    {
        return authorize ( request, callbackHandler, DEFAULT_RESULT );
    }

    /**
     * Authorize an operation
     * <p>
     * The default implementation grants everything. Override to change
     * according to your needs.
     * </p>
     * 
     * @param objectType
     *            the type of the object the operation takes place
     * @param objectId
     *            the id of the object the operation takes place
     * @param userInformation
     *            the user information
     * @param context
     *            the context information
     * @param defaultResult
     *            the default result that should be returned if no one votes,
     *            must not be <code>null</code>
     * @return the authorization result, never returns <code>null</code>
     * @since 1.1
     */
    protected NotifyFuture<AuthorizationReply> authorize ( final AuthorizationRequest request, final CallbackHandler callbackHandler, final AuthorizationResult defaultResult )
    {
        final AuthorizationContext context = new AuthorizationContext ();
        context.setCallbackHandler ( callbackHandler );
        context.setRequest ( request );

        // log the request
        this.auditLogService.authorizationRequested ( request );

        final NotifyFuture<AuthorizationReply> result = this.authorizationImplementation.authorize ( context, defaultResult );

        // log the result, when it will be available
        result.addListener ( new FutureListener<AuthorizationReply> () {

            @Override
            public void complete ( final Future<AuthorizationReply> future )
            {
                try
                {
                    ServiceCommon.this.auditLogService.authorizationDone ( context, request, future.get () );
                }
                catch ( final Exception e )
                {
                    ServiceCommon.this.auditLogService.authorizationFailed ( context, request, e );
                }
            }
        } );

        return result;
    }

    /**
     * @since 1.1
     */
    protected NotifyFuture<UserInformation> makeEffectiveUserInformation ( final AbstractSessionImpl session, final String targetUser, final CallbackHandler handler )
    {
        UserInformation sessionUser = session.getUserInformation ();
        if ( sessionUser == null )
        {
            logger.debug ( "Session has no user information. Using anonymous." );
            sessionUser = UserInformation.ANONYMOUS;
        }

        if ( targetUser == null )
        {
            logger.info ( "target user is null" );
            return new InstantFuture<UserInformation> ( sessionUser );
        }

        // check if user differs
        if ( targetUser.equals ( sessionUser.getName () ) )
        {
            logger.debug ( "Session user and target user match ... using session user" );
            // session is already is proxy user
            return new InstantFuture<UserInformation> ( sessionUser );
        }

        logger.debug ( "Trying to set target user: {}", targetUser );

        // try to set proxy user
        final NotifyFuture<AuthorizationReply> future = authorize ( new AuthorizationRequest ( "SESSION", targetUser, "PROXY_USER", session.getUserInformation (), null ), handler );

        return new CallingFuture<AuthorizationReply, UserInformation> ( future ) {

            @Override
            public UserInformation call ( final Future<AuthorizationReply> future ) throws Exception
            {
                final AuthorizationReply result = future.get ();
                if ( !result.isGranted () )
                {
                    logger.info ( "Proxy user is not allowed" );
                    // not allowed to use proxy user
                    throw result.getResult ().asException ();
                }

                return ServiceCommon.this.authenticationImplementation.getUser ( targetUser );
            }
        };
    }

}
