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
package org.eclipse.scada.ca.servlet.jaxws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import org.eclipse.scada.ca.Configuration;
import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.data.ConfigurationInformation;
import org.eclipse.scada.ca.data.DiffEntry;
import org.eclipse.scada.ca.data.FactoryInformation;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.ExceptionHelper;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebService ( endpointInterface = "org.eclipse.scada.ca.servlet.jaxws.RemoteConfigurationAdministrator" )
public class ConfigurationAdministratorService implements RemoteConfigurationAdministrator
{
    private final static Logger logger = LoggerFactory.getLogger ( ConfigurationAdministratorService.class );

    private final SingleServiceTracker<ConfigurationAdministrator> tracker;

    private volatile ConfigurationAdministrator service;

    @Resource
    private WebServiceContext context;

    public ConfigurationAdministratorService ( final BundleContext context )
    {
        this.tracker = new SingleServiceTracker<ConfigurationAdministrator> ( context, ConfigurationAdministrator.class, new SingleServiceListener<ConfigurationAdministrator> () {

            @Override
            public void serviceChange ( final ServiceReference<ConfigurationAdministrator> reference, final ConfigurationAdministrator service )
            {
                ConfigurationAdministratorService.this.setService ( service );
            }
        } );
        this.tracker.open ();
    }

    protected void setService ( final ConfigurationAdministrator service )
    {
        this.service = service;
    }

    @WebMethod ( exclude = true )
    public void dispose ()
    {
        this.tracker.close ();
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.ca.servlet.jaxws.RemoteConfigurationAdministrator#hasService()
     */
    @Override
    public boolean hasService ()
    {
        return this.service != null;
    }

    @Override
    public FactoryInformation getFactory ( final String factoryId )
    {
        return convertFactory ( this.service.getFactory ( factoryId ), true );
    }

    @Override
    public ConfigurationInformation getConfiguration ( final String factoryId, final String configurationId )
    {
        final org.eclipse.scada.ca.Configuration cfg = this.service.getConfiguration ( factoryId, configurationId );
        return new ConfigurationInformation ( factoryId, configurationId, cfg.getState (), cfg.getData (), ExceptionHelper.formatted ( cfg.getErrorInformation () ) );
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.ca.servlet.jaxws.RemoteConfigurationAdministrator#getFactories()
     */
    @Override
    public FactoryInformation[] getFactories ()
    {
        return getFactories ( false );
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.ca.servlet.jaxws.RemoteConfigurationAdministrator#getCompleteConfiguration()
     */
    @Override
    public FactoryInformation[] getCompleteConfiguration ()
    {
        return getFactories ( true );
    }

    private FactoryInformation[] getFactories ( final boolean withConfiguration )
    {
        return convert ( this.service.getKnownFactories (), withConfiguration );
    }

    private FactoryInformation[] convert ( final org.eclipse.scada.ca.Factory[] knownFactories, final boolean withConfiguration )
    {
        final FactoryInformation[] result = new FactoryInformation[knownFactories.length];

        for ( int i = 0; i < knownFactories.length; i++ )
        {
            result[i] = convertFactory ( knownFactories[i], withConfiguration );
        }

        return result;
    }

    private FactoryInformation convertFactory ( final org.eclipse.scada.ca.Factory knownFactory, final boolean withConfiguration )
    {
        if ( knownFactory == null )
        {
            return null;
        }

        if ( withConfiguration )
        {
            return new FactoryInformation ( knownFactory.getId (), knownFactory.getDescription (), knownFactory.getState (), convert ( this.service.getConfigurations ( knownFactory.getId () ) ) );
        }
        else
        {
            return new FactoryInformation ( knownFactory.getId (), knownFactory.getDescription (), knownFactory.getState (), Collections.<ConfigurationInformation> emptyList () );
        }
    }

    private List<ConfigurationInformation> convert ( final org.eclipse.scada.ca.Configuration[] configurations )
    {
        final List<ConfigurationInformation> result = new ArrayList<ConfigurationInformation> ( configurations.length );

        for ( final Configuration c : configurations )
        {
            result.add ( new ConfigurationInformation ( c.getFactoryId (), c.getId (), c.getState (), c.getData (), ExceptionHelper.formatted ( c.getErrorInformation () ) ) );
        }

        return result;
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.ca.servlet.jaxws.RemoteConfigurationAdministrator#purge(java.lang.String, int)
     */
    @Override
    public void purge ( final String factoryId, final int timeout ) throws InterruptedException, ExecutionException, TimeoutException
    {
        logger.info ( "Request purge: {}", factoryId );

        final Collection<Future<?>> jobs = new LinkedList<Future<?>> ();

        jobs.add ( this.service.purgeFactory ( makeUserInformation (), factoryId ) );

        complete ( timeout, jobs );
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.ca.servlet.jaxws.RemoteConfigurationAdministrator#delete(java.lang.String, java.lang.String[], int)
     */
    @Override
    public void delete ( final String factoryId, final String[] configurations, final int timeout ) throws InterruptedException, ExecutionException, TimeoutException
    {
        final Collection<Future<?>> jobs = new LinkedList<Future<?>> ();

        for ( final String id : configurations )
        {
            jobs.add ( this.service.deleteConfiguration ( makeUserInformation (), factoryId, id ) );
        }

        complete ( timeout, jobs );
    }

    private void complete ( final int timeout, final Collection<? extends Future<?>> jobs ) throws InterruptedException, ExecutionException, TimeoutException
    {
        for ( final Future<?> future : jobs )
        {
            if ( timeout > 0 )
            {
                future.get ( timeout, TimeUnit.MILLISECONDS );
            }
            else
            {
                future.get ();
            }
        }
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.ca.servlet.jaxws.RemoteConfigurationAdministrator#update(java.lang.String, org.eclipse.scada.ca.servlet.jaxws.ConfigurationInformation[], int)
     */
    @Override
    public void update ( final String factoryId, final ConfigurationInformation[] configurations, final int timeout ) throws InterruptedException, ExecutionException, TimeoutException
    {
        final Collection<Future<?>> jobs = new LinkedList<Future<?>> ();

        for ( final ConfigurationInformation cfg : configurations )
        {
            jobs.add ( this.service.updateConfiguration ( makeUserInformation (), factoryId, cfg.getId (), cfg.getData (), true ) );
        }

        complete ( timeout, jobs );
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.ca.servlet.jaxws.RemoteConfigurationAdministrator#create(java.lang.String, org.eclipse.scada.ca.servlet.jaxws.ConfigurationInformation[], int)
     */
    @Override
    public void create ( final String factoryId, final ConfigurationInformation[] configurations, final int timeout ) throws InterruptedException, ExecutionException, TimeoutException
    {
        final Collection<Future<?>> jobs = new LinkedList<Future<?>> ();

        for ( final ConfigurationInformation cfg : configurations )
        {
            jobs.add ( this.service.createConfiguration ( makeUserInformation (), factoryId, cfg.getId (), cfg.getData () ) );
        }

        complete ( timeout, jobs );
    }

    @Override
    public void applyDiff ( final Collection<DiffEntry> changeSet, final int timeout ) throws InterruptedException, ExecutionException, TimeoutException
    {
        final NotifyFuture<Void> future = this.service.applyDiff ( makeUserInformation (), changeSet );

        final Collection<NotifyFuture<Void>> result = new LinkedList<NotifyFuture<Void>> ();
        result.add ( future );

        complete ( timeout, result );
    }

    protected UserInformation makeUserInformation ()
    {
        final Object username = this.context.getMessageContext ().get ( "username" );
        if ( username instanceof String )
        {
            return new UserInformation ( (String)username );
        }
        return null;
    }
}
