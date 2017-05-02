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
package org.eclipse.scada.sec.osgi;

import org.eclipse.scada.sec.AuthenticationException;
import org.eclipse.scada.sec.AuthorizationImplementation;
import org.eclipse.scada.sec.AuthorizationReply;
import org.eclipse.scada.sec.AuthorizationResult;
import org.eclipse.scada.sec.StatusCodes;
import org.eclipse.scada.sec.authz.AuthorizationContext;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @since 1.1
 */
public class TrackingAuthorizationImplementation implements AuthorizationImplementation
{
    private final static Logger logger = LoggerFactory.getLogger ( TrackingAuthorizationImplementation.class );

    private final SingleServiceTracker<AuthorizationManager> tracker;

    public TrackingAuthorizationImplementation ( final BundleContext context )
    {
        this.tracker = new SingleServiceTracker<AuthorizationManager> ( context, AuthorizationManager.class, null );
    }

    public void open ()
    {
        this.tracker.open ();
    }

    public void close ()
    {
        this.tracker.close ();
    }

    @Override
    public NotifyFuture<AuthorizationReply> authorize ( final AuthorizationContext context, final AuthorizationResult defaultResult )
    {
        logger.trace ( "Authorizing - {}", context );

        final AuthorizationManager service = this.tracker.getService ();
        if ( service == null )
        {
            logger.info ( "We don't have an authorization manager" );
            return new InstantErrorFuture<AuthorizationReply> ( new AuthenticationException ( StatusCodes.AUTHORIZATION_FAILED, Messages.getString ( "TrackingAuthenticationImplementation.DefaultMessage" ) ) );
        }

        return service.authorize ( context, defaultResult );
    }

}
