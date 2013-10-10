/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.client.ngp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

import org.eclipse.scada.ca.client.Connection;
import org.eclipse.scada.ca.client.FactoriesListener;
import org.eclipse.scada.ca.common.ngp.ProtocolConfigurationFactoryImpl;
import org.eclipse.scada.ca.data.ConfigurationInformation;
import org.eclipse.scada.ca.data.DiffEntry;
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
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.client.ngp.ConnectionBaseImpl;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.core.data.Request;
import org.eclipse.scada.core.data.ResponseMessage;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.ExecutorFuture;
import org.eclipse.scada.utils.concurrent.FutureListener;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionImpl extends ConnectionBaseImpl implements Connection
{
    private final static Logger logger = LoggerFactory.getLogger ( ConnectionImpl.class );

    protected static abstract class ErrorAwareFuture<Res extends ResponseMessage, M> extends ExecutorFuture<M>
    {
        public ErrorAwareFuture ( final Executor executor, final Class<Res> responseClazz, final NotifyFuture<ResponseMessage> listener )
        {
            super ( executor );
            listener.addListener ( new FutureListener<ResponseMessage> () {
                @Override
                public void complete ( final Future<ResponseMessage> future )
                {
                    try
                    {
                        final ResponseMessage result = future.get ();

                        if ( responseClazz.isAssignableFrom ( result.getClass () ) )
                        {
                            asyncSetResult ( handleResponse ( responseClazz.cast ( result ) ) );
                        }
                        else if ( result instanceof ErrorResponse )
                        {
                            asyncSetError ( new OperationException ( ( (ErrorResponse)result ).getErrorInformation ().getMessage () ) );
                        }
                        else
                        {
                            asyncSetError ( new OperationException ( String.format ( "Wrong reply in message. Expected: %s, Received: %s", responseClazz.getClass (), result.getClass () ) ) );
                        }
                    }
                    catch ( final Exception e )
                    {
                        asyncSetError ( e );
                    }
                }
            } );
        }

        public abstract M handleResponse ( final Res response ) throws Exception;

    }

    private final Set<FactoriesListener> listeners = new HashSet<FactoriesListener> ();

    private FactoryInformation[] factories = new FactoryInformation[0];

    public ConnectionImpl ( final ConnectionInformation connectionInformation ) throws Exception
    {
        super ( new ProtocolConfigurationFactoryImpl ( connectionInformation ), connectionInformation );
    }

    @Override
    protected void onConnectionBound ()
    {
        super.onConnectionBound ();
        getFactories ().addListener ( new FutureListener<FactoryInformation[]> () {

            @Override
            public void complete ( final Future<FactoryInformation[]> future )
            {
                try
                {
                    setFactories ( future.get () );
                }
                catch ( final Exception e )
                {
                    logger.warn ( "Failed to load initial factories list", e );
                }
            }
        } );
    }

    @Override
    protected void onConnectionClosed ()
    {
        setFactories ( new FactoryInformation[0] );

        super.onConnectionClosed ();
    }

    protected synchronized void setFactories ( final FactoryInformation[] factories )
    {
        this.factories = factories;

        if ( !isDisposed () )
        {
            for ( final FactoriesListener listener : this.listeners )
            {
                this.executor.execute ( new Runnable () {

                    @Override
                    public void run ()
                    {
                        listener.updateFactories ( factories );
                    }
                } );
            }
        }
    }

    @Override
    public synchronized void addFactoriesListener ( final FactoriesListener listener )
    {
        if ( this.listeners.add ( listener ) )
        {
            final FactoryInformation[] factories = this.factories;

            this.executor.execute ( new Runnable () {
                @Override
                public void run ()
                {
                    listener.updateFactories ( factories );
                };
            } );
        }
    }

    @Override
    public synchronized void removeFactoriesListener ( final FactoriesListener listener )
    {
        this.listeners.remove ( listener );
    }

    @Override
    public synchronized NotifyFuture<FactoryInformation[]> getFactories ()
    {
        logger.debug ( "Getting all factories" );

        return new ErrorAwareFuture<GetFactoriesResponse, FactoryInformation[]> ( this.executor, GetFactoriesResponse.class, sendRequestMessage ( new GetFactoriesRequest ( nextRequest () ) ) ) {
            @Override
            public FactoryInformation[] handleResponse ( final GetFactoriesResponse result )
            {
                return result.getFactories ().toArray ( new FactoryInformation[result.getFactories ().size ()] );
            }
        };
    }

    @Override
    public synchronized NotifyFuture<FactoryInformation> getFactoryWithData ( final String factoryId )
    {
        logger.debug ( "Getting factory: {}", factoryId );
        return new ErrorAwareFuture<GetFactoryWithDataResponse, FactoryInformation> ( this.executor, GetFactoryWithDataResponse.class, sendRequestMessage ( new GetFactoryWithDataRequest ( nextRequest (), factoryId ) ) ) {
            @Override
            public FactoryInformation handleResponse ( final GetFactoryWithDataResponse result )
            {
                return result.getFactory ();
            }
        };
    }

    @Override
    public synchronized NotifyFuture<ConfigurationInformation> getConfiguration ( final String factoryId, final String configurationId )
    {
        logger.debug ( "Getting configuration: {} - {}", factoryId, configurationId );

        return new ErrorAwareFuture<GetConfigurationResponse, ConfigurationInformation> ( this.executor, GetConfigurationResponse.class, sendRequestMessage ( new GetConfigurationRequest ( nextRequest (), factoryId, configurationId ) ) ) {
            @Override
            public ConfigurationInformation handleResponse ( final GetConfigurationResponse result )
            {
                return result.getConfiguration ();
            }
        };
    }

    @Override
    public NotifyFuture<Void> applyDiff ( final List<DiffEntry> changeSet, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        logger.debug ( "Apply diff: {} changes", changeSet.size () );

        final Request request = nextRequest ();
        final Long callbackHandlerId = registerCallbackHandler ( request, callbackHandler );

        return new ErrorAwareFuture<ApplyDiffResponse, Void> ( this.executor, ApplyDiffResponse.class, sendRequestMessage ( new ApplyDiffRequest ( request, changeSet, operationParameters, callbackHandlerId ) ) ) {
            @Override
            public Void handleResponse ( final ApplyDiffResponse result )
            {
                // TODO: provide real response
                return null;
            }
        };
    }
}
