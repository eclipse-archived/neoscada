/*******************************************************************************
 * Copyright (c) 2006, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - further development
 *******************************************************************************/
package org.eclipse.scada.sec.authn.osgi.cfg.priority;

import java.util.List;
import java.util.concurrent.Future;

import org.eclipse.scada.sec.AuthenticationException;
import org.eclipse.scada.sec.AuthenticationImplementation;
import org.eclipse.scada.sec.AuthenticationService;
import org.eclipse.scada.sec.StatusCodes;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.authn.CredentialsRequest;
import org.eclipse.scada.sec.callback.Callback;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.sec.callback.Callbacks;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.IteratingFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @since 1.1
 */
public class Authenticator implements AuthenticationImplementation
{

    private final class GroupIteratorFuture extends IteratingFuture<UserInformation, ConfigurationGroup>
    {
        private final CallbackHandler callbackHandler;

        private int counter = 1;

        public GroupIteratorFuture ( final Iterable<ConfigurationGroup> iterable, final CallbackHandler callbackHandler )
        {
            super ( iterable );
            this.callbackHandler = callbackHandler;
        }

        @Override
        protected void handleComplete ( final Future<UserInformation> future, final ConfigurationGroup group ) throws Exception
        {
            logger.debug ( "Handle complete - future: {}, group: {}", future, group );

            final UserInformation userInformation = future.get ();
            if ( userInformation != null )
            {
                setResult ( userInformation );
            }
            else
            {
                if ( this.counter < group.getRetries () )
                {
                    logger.debug ( "Retry current group - retry #{} of {}", this.counter, group.getRetries () );
                    this.counter++;
                    processCurrent ();
                }
                else
                {
                    logger.debug ( "Try next authorization group" );
                    this.counter = 1;
                    processNext ();
                }
            }
        }

        @Override
        protected NotifyFuture<UserInformation> perform ( final ConfigurationGroup group )
        {
            logger.debug ( "Process group: {}", group );
            return authenticate ( this.callbackHandler, group );
        }

        @Override
        protected NotifyFuture<UserInformation> last ()
        {
            return new InstantErrorFuture<UserInformation> ( new AuthenticationException ( StatusCodes.INVALID_USER_OR_PASSWORD ) );
        }
    }

    private final static Logger logger = LoggerFactory.getLogger ( Authenticator.class );

    private ConfigurationManagerImpl manager;

    public void activate ( final BundleContext context )
    {
        this.manager = new ConfigurationManagerImpl ( context );
    }

    public void deactivate ()
    {
        this.manager.dispose ();
    }

    @Override
    public UserInformation getUser ( final String user )
    {
        logger.debug ( "Getting user information - {}", user );

        final Configuration cfg = this.manager.getConfiguration ();

        for ( final ConfigurationGroup group : cfg.getGroups () )
        {
            for ( final AuthenticationService service : group.getServices () )
            {
                final UserInformation result = service.getUser ( user );
                if ( result != null )
                {
                    logger.debug ( "Found user information from service - service: {}, user: {}", service, result );
                    return result;
                }
            }
        }

        logger.debug ( "None found" );
        return null;
    }

    @Override
    public NotifyFuture<UserInformation> authenticate ( final CallbackHandler callbackHandler )
    {
        logger.debug ( "Start authenticating - callbackHandler: {}", callbackHandler );

        final Configuration configuration;
        try
        {
            configuration = this.manager.getConfiguration ();
            if ( configuration == null )
            {
                return new InstantErrorFuture<UserInformation> ( new AuthenticationException ( StatusCodes.AUTHENTICATION_FAILED, "No authentication configuration available" ) );
            }
        }
        catch ( final Exception e )
        {
            return new InstantErrorFuture<UserInformation> ( new AuthenticationException ( StatusCodes.AUTHENTICATION_FAILED, e ) );
        }

        return new GroupIteratorFuture ( configuration.getGroups (), callbackHandler ).startIterating ();
    }

    protected NotifyFuture<UserInformation> authenticate ( final CallbackHandler callbackHandler, final ConfigurationGroup group )
    {
        final CredentialsRequest request = new CredentialsRequest ();

        for ( final AuthenticationService service : group.getServices () )
        {
            logger.debug ( "Let service join: {}", service );
            service.joinRequest ( request );
        }

        final NotifyFuture<Callback[]> future = Callbacks.callback ( callbackHandler, request.buildCallbacks () );

        return new ProcessCallbacksFuture ( future ) {
            @Override
            protected CredentialsRequest getRequest ()
            {
                return request;
            }

            @Override
            protected List<AuthenticationService> getServices ()
            {
                return group.getServices ();
            }
        };
    }
}
