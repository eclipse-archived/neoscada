/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ca.server.ngp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

import org.apache.mina.core.session.IoSession;
import org.eclipse.scada.ca.Configuration;
import org.eclipse.scada.ca.Factory;
import org.eclipse.scada.ca.data.ConfigurationInformation;
import org.eclipse.scada.ca.data.FactoryInformation;
import org.eclipse.scada.ca.data.message.ApplyDiffRequest;
import org.eclipse.scada.ca.data.message.ApplyDiffResponse;
import org.eclipse.scada.ca.data.message.ErrorResponse;
import org.eclipse.scada.ca.data.message.GetConfigurationRequest;
import org.eclipse.scada.ca.data.message.GetConfigurationResponse;
import org.eclipse.scada.ca.data.message.GetFactoriesRequest;
import org.eclipse.scada.ca.data.message.GetFactoriesResponse;
import org.eclipse.scada.ca.data.message.GetFactoryWithDataRequest;
import org.eclipse.scada.ca.data.message.GetFactoryWithDataResponse;
import org.eclipse.scada.ca.server.FactoryWithData;
import org.eclipse.scada.ca.server.Service;
import org.eclipse.scada.ca.server.Session;
import org.eclipse.scada.core.InvalidSessionException;
import org.eclipse.scada.core.data.ErrorInformation;
import org.eclipse.scada.core.data.Request;
import org.eclipse.scada.core.data.Response;
import org.eclipse.scada.core.data.ResponseMessage;
import org.eclipse.scada.core.server.ngp.ServiceServerConnection;
import org.eclipse.scada.utils.ExceptionHelper;
import org.eclipse.scada.utils.concurrent.FutureListener;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerConnectionImpl extends ServiceServerConnection<Session, Service>
{

    private final static Logger logger = LoggerFactory.getLogger ( ServerConnectionImpl.class );

    private abstract class ErrorAwareHandler<M> implements FutureListener<M>
    {
        private final Request request;

        public ErrorAwareHandler ( final Request request, final NotifyFuture<M> future )
        {
            this.request = request;
            future.addListener ( this );
        }

        @Override
        public void complete ( final Future<M> future )
        {
            logger.debug ( "Request completed" );

            try
            {
                final M result = future.get ();
                sendMessage ( handle ( new Response ( this.request ), result ) );
            }
            catch ( final Exception e )
            {
                logger.info ( "Request failure", e );
                sendMessage ( new ErrorResponse ( new Response ( this.request ), makeErrorInformation ( e ) ) );
            }
        }

        protected abstract ResponseMessage handle ( Response response, M result );

        private ErrorInformation makeErrorInformation ( final Exception e )
        {
            return new ErrorInformation ( null, e.getMessage (), ExceptionHelper.formatted ( e ) );
        }
    }

    public ServerConnectionImpl ( final IoSession session, final Service service )
    {
        super ( session, service );
    }

    @Override
    public void messageReceived ( final Object message ) throws Exception
    {
        logger.trace ( "Received message: {}", message );

        if ( message instanceof GetFactoriesRequest )
        {
            handleGetFactories ( (GetFactoriesRequest)message );
        }
        else if ( message instanceof GetFactoryWithDataRequest )
        {
            handleGetFactoryWithData ( (GetFactoryWithDataRequest)message );
        }
        else if ( message instanceof GetConfigurationRequest )
        {
            handleGetConfigurationRequest ( (GetConfigurationRequest)message );
        }
        else if ( message instanceof ApplyDiffRequest )
        {
            handleApplyDiff ( (ApplyDiffRequest)message );
        }
        else
        {
            super.messageReceived ( message );
        }
    }

    protected void handleApplyDiff ( final ApplyDiffRequest message ) throws InvalidSessionException
    {
        new ErrorAwareHandler<Void> ( message.getRequest (), this.service.applyDiff ( this.session, message.getDiffs (), message.getOperationParameters (), createCallbackHandler ( message.getCallbackHandlerId () ) ) ) {
            @Override
            protected ResponseMessage handle ( final Response response, final Void result )
            {
                return new ApplyDiffResponse ( new Response ( message.getRequest () ) );
            }
        };
    }

    protected void handleGetConfigurationRequest ( final GetConfigurationRequest message ) throws InvalidSessionException
    {
        new ErrorAwareHandler<Configuration> ( message.getRequest (), this.service.getConfiguration ( this.session, message.getFactoryId (), message.getConfigurationId () ) ) {
            @Override
            protected ResponseMessage handle ( final Response response, final Configuration result )
            {
                return new GetConfigurationResponse ( new Response ( message.getRequest () ), convertConfiguration ( result ) );
            }
        };
    }

    protected void handleGetFactoryWithData ( final GetFactoryWithDataRequest message ) throws InvalidSessionException
    {
        new ErrorAwareHandler<FactoryWithData> ( message.getRequest (), this.service.getFactory ( this.session, message.getFactoryId () ) ) {
            @Override
            protected ResponseMessage handle ( final Response response, final FactoryWithData result )
            {
                return new GetFactoryWithDataResponse ( new Response ( message.getRequest () ), convertFactory ( result ) );
            }
        };
    }

    protected void handleGetFactories ( final GetFactoriesRequest message ) throws InvalidSessionException
    {
        new ErrorAwareHandler<Factory[]> ( message.getRequest (), this.service.getKnownFactories ( this.session ) ) {
            @Override
            protected ResponseMessage handle ( final Response response, final Factory[] result )
            {
                return new GetFactoriesResponse ( new Response ( message.getRequest () ), convertFactories ( result ) );
            }
        };
    }

    protected FactoryInformation convertFactory ( final FactoryWithData result )
    {
        final Factory factory = result.getFactory ();
        final Configuration[] configurations = result.getConfigurations ();
        return new FactoryInformation ( factory.getId (), factory.getDescription (), factory.getState (), convertConfigurations ( configurations ) );
    }

    private List<ConfigurationInformation> convertConfigurations ( final Configuration[] configurations )
    {
        if ( configurations == null )
        {
            return null;
        }

        final List<ConfigurationInformation> result = new ArrayList<ConfigurationInformation> ( configurations.length );

        for ( final Configuration configuration : configurations )
        {
            result.add ( convertConfiguration ( configuration ) );
        }
        return result;
    }

    private ConfigurationInformation convertConfiguration ( final Configuration configuration )
    {
        return new ConfigurationInformation ( configuration.getFactoryId (), configuration.getId (), configuration.getState (), configuration.getData (), ExceptionHelper.formatted ( configuration.getErrorInformation () ) );
    }

    protected List<FactoryInformation> convertFactories ( final Factory[] factories )
    {
        if ( factories == null )
        {
            return null;
        }

        final List<FactoryInformation> result = new ArrayList<FactoryInformation> ( factories.length );

        for ( final Factory factory : factories )
        {
            result.add ( new FactoryInformation ( factory.getId (), factory.getDescription (), factory.getState (), Collections.<ConfigurationInformation> emptyList () ) );
        }
        return result;
    }

}
