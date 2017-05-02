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
package org.eclipse.scada.sec.auth.logon;

import java.util.concurrent.Future;

import org.eclipse.scada.sec.AuthenticationImplementation;
import org.eclipse.scada.sec.AuthorizationResult;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.authz.AuthorizationContext;
import org.eclipse.scada.sec.authz.AuthorizationRule;
import org.eclipse.scada.utils.concurrent.CallingFuture;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @since 1.1
 */
public final class AuthorizationRuleImpl implements AuthorizationRule
{

    private final static Logger logger = LoggerFactory.getLogger ( AuthorizationRuleImpl.class );

    private final AuthenticationImplementation authenticator;

    public AuthorizationRuleImpl ( final AuthenticationImplementation authenticator )
    {
        this.authenticator = authenticator;
    }

    @Override
    public void dispose ()
    {
    }

    @Override
    public NotifyFuture<AuthorizationResult> authorize ( final AuthorizationContext context )
    {
        logger.debug ( "Authorizing - request: {}", context.getRequest () );

        final UserInformation userInformation = context.getRequest ().getUserInformation ();
        if ( userInformation != null && !userInformation.isAnonymous () )
        {
            // no need to log on anything
            return new InstantFuture<AuthorizationResult> ( null );
        }

        final NotifyFuture<UserInformation> future = this.authenticator.authenticate ( context.getCallbackHandler () );
        return new CallingFuture<UserInformation, AuthorizationResult> ( future ) {

            @Override
            public AuthorizationResult call ( final Future<UserInformation> future ) throws Exception
            {
                final AuthorizationResult result = process ( context, future );
                logger.debug ( "Result of authorize call: {}", result );
                return result;
            }
        };
    }

    protected AuthorizationResult process ( final AuthorizationContext context, final Future<UserInformation> future ) throws Exception
    {
        try
        {
            context.changeUserInformation ( future.get () );
            return null;
        }
        catch ( final Exception e )
        {
            logger.debug ( "Failed to authorize logon", e );
            return AuthorizationResult.createReject ( e );
        }
    }

}