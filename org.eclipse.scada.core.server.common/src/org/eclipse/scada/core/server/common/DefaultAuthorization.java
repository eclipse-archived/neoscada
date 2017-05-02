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
package org.eclipse.scada.core.server.common;

import org.eclipse.scada.sec.AuthenticationImplementation;
import org.eclipse.scada.sec.AuthorizationImplementation;
import org.eclipse.scada.sec.AuthorizationReply;
import org.eclipse.scada.sec.AuthorizationResult;
import org.eclipse.scada.sec.auth.logon.LogonAuthorizationService;
import org.eclipse.scada.sec.authz.AuthorizationContext;
import org.eclipse.scada.sec.authz.AuthorizationRule;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.concurrent.TransformResultFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The default authorization
 * <p>
 * The default implementation will allow everything and has one special rule for
 * the logon process. When the request is for
 * <q>SESSION</q> and
 * <q>CONNECT</q> the call will be directed to a local held instance of
 * LogonAuthorizationService which is configured to use the provided
 * AuthenticationImplementation for authentication.
 * </p>
 * <p>
 * Now if the logon service accepts for abstains the logon and with it the while
 * authorization will be successful.
 * </p>
 * 
 * @since 1.1
 */
public class DefaultAuthorization implements AuthorizationImplementation
{

    private final static Logger logger = LoggerFactory.getLogger ( DefaultAuthorization.class );

    private final LogonAuthorizationService logonHandler;

    private final AuthorizationRule rule;

    public DefaultAuthorization ( final AuthenticationImplementation authenticator )
    {
        this.logonHandler = new LogonAuthorizationService ();
        this.logonHandler.setAuthenticator ( authenticator );
        this.rule = this.logonHandler.createRule ( null );
    }

    @Override
    public NotifyFuture<AuthorizationReply> authorize ( final AuthorizationContext context, final AuthorizationResult defaultResult )
    {
        logger.debug ( "Requesting authorization - {} ... defaulting to GRANTED", new Object[] { context.getRequest (), defaultResult } ); //$NON-NLS-1$

        if ( "SESSION".equals ( context.getRequest ().getObjectType () ) && "CONNECT".equals ( context.getRequest ().getAction () ) )
        {
            logger.debug ( "Default authentication is handled here" );

            return new TransformResultFuture<AuthorizationResult, AuthorizationReply> ( this.rule.authorize ( context ) ) {
                @Override
                protected AuthorizationReply transform ( final AuthorizationResult from )
                {
                    logger.debug ( "Default authentication call result: {}", from );
                    if ( from == null )
                    {
                        /* our one and only module abstained ... but we know that would never accept a request. So on this case
                         * we can accept it */
                        return AuthorizationReply.createGranted ( context );
                    }
                    else
                    {
                        // we have a result .. use it .. although it probably is a reject
                        return AuthorizationReply.create ( from, context );
                    }
                }
            };
        }
        else
        {
            return new InstantFuture<AuthorizationReply> ( AuthorizationReply.createGranted ( context ) );
        }
    }
}
