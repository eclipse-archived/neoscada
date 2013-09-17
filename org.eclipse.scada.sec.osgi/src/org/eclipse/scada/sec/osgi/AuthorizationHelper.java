/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - further development
 *******************************************************************************/
package org.eclipse.scada.sec.osgi;

import java.util.concurrent.Future;

import org.eclipse.scada.sec.AuthorizationReply;
import org.eclipse.scada.sec.AuthorizationResult;
import org.eclipse.scada.sec.StatusCodes;
import org.eclipse.scada.sec.authz.AuthorizationContext;
import org.eclipse.scada.sec.authz.AuthorizationRule;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.IteratingFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.concurrent.TransformResultFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorizationHelper
{
    public static final class IteratingAuthorizer extends IteratingFuture<AuthorizationResult, AuthorizationRule>
    {
        private final AuthorizationResult defaultResult;

        private final AuthorizationContext context;

        public IteratingAuthorizer ( final Iterable<? extends AuthorizationRule> iterable, final AuthorizationResult defaultResult, final AuthorizationContext context )
        {
            super ( iterable );
            this.defaultResult = defaultResult;
            this.context = context;
        }

        @Override
        protected void handleComplete ( final Future<AuthorizationResult> future, final AuthorizationRule current ) throws Exception
        {
            final AuthorizationResult reply = future.get ();
            if ( reply == null )
            {
                // abstain

                logger.debug ( "We got an abstain" );
                processNext ();
            }
            else
            {
                // rejected or granted

                logger.debug ( "Somebody voted: {}", reply );
                setResult ( reply );
            }
        }

        @Override
        protected NotifyFuture<AuthorizationResult> perform ( final AuthorizationRule s )
        {
            logger.debug ( "Try next service: {}", s );
            return s.authorize ( this.context );
        }

        @Override
        protected NotifyFuture<AuthorizationResult> last ()
        {
            return new InstantFuture<AuthorizationResult> ( this.defaultResult );
        }
    }

    public static final AuthorizationResult DEFAULT_RESULT = AuthorizationResult.createReject ( StatusCodes.AUTHORIZATION_FAILED, Messages.getString ( "AuthorizationHelper.DefaultMessage" ) ); //$NON-NLS-1$

    private final static Logger logger = LoggerFactory.getLogger ( AuthorizationHelper.class );

    public static NotifyFuture<AuthorizationReply> authorize ( final Iterable<? extends AuthorizationRule> services, final AuthorizationContext context, final AuthorizationResult defaultResult )
    {
        logger.debug ( "Iterating authorize - {}", context.getRequest () );

        final IteratingFuture<AuthorizationResult, AuthorizationRule> future = new IteratingAuthorizer ( services, defaultResult, context );

        future.startIterating ();

        return new TransformResultFuture<AuthorizationResult, AuthorizationReply> ( future ) {

            @Override
            protected AuthorizationReply transform ( final AuthorizationResult from ) throws Exception
            {
                logger.debug ( "Transforming result: {}", from );
                if ( from == null )
                {
                    return AuthorizationReply.create ( defaultResult, context );
                }
                else
                {
                    return AuthorizationReply.create ( from, context );
                }
            }

        };
    }

}
