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
package org.eclipse.scada.ca.server.osgi;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ca.Configuration;
import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.Factory;
import org.eclipse.scada.ca.data.DiffEntry;
import org.eclipse.scada.ca.server.FactoryWithData;
import org.eclipse.scada.ca.server.Service;
import org.eclipse.scada.ca.server.Session;
import org.eclipse.scada.core.InvalidSessionException;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.core.server.common.AuthorizedOperation;
import org.eclipse.scada.core.server.common.osgi.AbstractServiceImpl;
import org.eclipse.scada.core.server.common.session.AbstractSessionImpl;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.ExportedExecutorService;
import org.eclipse.scada.utils.concurrent.FutureTask;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.osgi.framework.BundleContext;

public class ServiceImpl extends AbstractServiceImpl<Session, SessionImpl> implements Service
{
    private final ConfigurationAdministrator service;

    private final ExportedExecutorService executor;

    public ServiceImpl ( final ConfigurationAdministrator service, final BundleContext context, final Executor executor ) throws Exception
    {
        super ( context, executor );
        this.service = service;
        this.executor = new ExportedExecutorService ( "org.eclipse.scada.ca.server.osgi.ServiceImpl", 1, 1, 1, TimeUnit.MINUTES ); //$NON-NLS-1$
    }

    @Override
    public void stop () throws Exception
    {
        super.stop ();
        this.executor.shutdown ();
    }

    @Override
    protected SessionImpl createSessionInstance ( final UserInformation userInformation, final Map<String, String> properties )
    {
        return new SessionImpl ( userInformation, properties );
    }

    @Override
    public synchronized NotifyFuture<Void> applyDiff ( final Session session, final Collection<DiffEntry> changeSet, final OperationParameters operationParameters, final CallbackHandler callbackHandler ) throws InvalidSessionException
    {
        final SessionImpl sessionImpl = validateSession ( session, SessionImpl.class );

        return new AuthorizedOperation<Void, AbstractSessionImpl> ( this.authorizationProvider, sessionImpl, "CFG", null, "APPLY_DIFF", null, operationParameters, callbackHandler, DEFAULT_RESULT ) {
            @Override
            protected NotifyFuture<Void> granted ( final org.eclipse.scada.core.server.OperationParameters effectiveOperationParameters )
            {
                return processApplyDiff ( effectiveOperationParameters.getUserInformation (), changeSet );
            }
        };
    }

    protected NotifyFuture<Void> processApplyDiff ( final UserInformation userInformation, final Collection<DiffEntry> changeSet )
    {
        return this.service.applyDiff ( userInformation, changeSet );
    }

    @Override
    public synchronized NotifyFuture<FactoryWithData> getFactory ( final Session session, final String factoryId ) throws InvalidSessionException
    {
        validateSession ( session, SessionImpl.class );

        final FutureTask<FactoryWithData> task = new FutureTask<FactoryWithData> ( new Callable<FactoryWithData> () {

            @Override
            public FactoryWithData call () throws Exception
            {
                final Factory factory = ServiceImpl.this.service.getFactory ( factoryId );
                final Configuration[] configurations = ServiceImpl.this.service.getConfigurations ( factoryId );

                return new FactoryWithData ( factory, configurations );
            }
        } );
        this.executor.submit ( task );
        return task;
    }

    @Override
    public synchronized NotifyFuture<Factory[]> getKnownFactories ( final Session session ) throws InvalidSessionException
    {
        validateSession ( session, SessionImpl.class );

        final FutureTask<Factory[]> task = new FutureTask<Factory[]> ( new Callable<Factory[]> () {

            @Override
            public Factory[] call () throws Exception
            {
                return ServiceImpl.this.service.getKnownFactories ();
            }
        } );
        this.executor.submit ( task );
        return task;
    }

    @Override
    public NotifyFuture<Configuration[]> getConfigurations ( final Session session, final String factoryId ) throws InvalidSessionException
    {
        validateSession ( session, SessionImpl.class );

        final FutureTask<Configuration[]> task = new FutureTask<Configuration[]> ( new Callable<Configuration[]> () {

            @Override
            public Configuration[] call () throws Exception
            {
                return ServiceImpl.this.service.getConfigurations ( factoryId );
            }
        } );
        this.executor.submit ( task );
        return task;
    }

    @Override
    public synchronized NotifyFuture<Configuration> getConfiguration ( final Session session, final String factoryId, final String configurationId ) throws InvalidSessionException
    {
        validateSession ( session, SessionImpl.class );

        final FutureTask<Configuration> task = new FutureTask<Configuration> ( new Callable<Configuration> () {

            @Override
            public Configuration call () throws Exception
            {
                return ServiceImpl.this.service.getConfiguration ( factoryId, configurationId );
            }
        } );
        this.executor.submit ( task );
        return task;

    }

}
