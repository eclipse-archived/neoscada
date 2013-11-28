/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.rest.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.da.server.exporter.common.ServiceListenerHiveSource;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.concurrent.ScheduledExportedExecutorService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurationFactoryImpl implements ConfigurationFactory, DataContextProvider
{
    private final static Logger logger = LoggerFactory.getLogger ( ConfigurationFactoryImpl.class );

    private final Map<String, DataContext> contextMap = new HashMap<String, DataContext> ();

    private final Lock readLock;

    private final Lock writeLock;

    private final ScheduledExecutorService executor;

    private final ServiceListenerHiveSource hiveSource;

    public ConfigurationFactoryImpl ()
    {
        final ReadWriteLock lock = new ReentrantReadWriteLock ();
        this.readLock = lock.readLock ();
        this.writeLock = lock.writeLock ();

        final BundleContext context = FrameworkUtil.getBundle ( DataContext.class ).getBundleContext ();

        this.executor = new ScheduledExportedExecutorService ( "org.eclipse.scada.da.server.exporter.rest", 1 );
        this.hiveSource = new ServiceListenerHiveSource ( context, this.executor );
        this.hiveSource.open ();
    }

    @Override
    public DataContext getContext ( final String contextId )
    {
        this.readLock.lock ();
        try
        {
            return this.contextMap.get ( contextId );
        }
        finally
        {
            this.readLock.unlock ();
        }

    }

    @Override
    public void update ( final UserInformation userInformation, final String configurationId, final Map<String, String> properties ) throws Exception
    {
        final DataContext context = new DataContext ( this.executor, this.hiveSource, properties );

        final DataContext oldContext;

        this.writeLock.lock ();
        try
        {
            oldContext = this.contextMap.put ( configurationId, context );
        }
        finally
        {
            this.writeLock.unlock ();
        }

        if ( oldContext != null )
        {
            oldContext.dispose ();
        }
    }

    @Override
    public void delete ( final UserInformation userInformation, final String configurationId ) throws Exception
    {
        final DataContext oldContext;

        this.writeLock.lock ();
        try
        {
            oldContext = this.contextMap.remove ( configurationId );
        }
        finally
        {
            this.writeLock.unlock ();
        }

        if ( oldContext != null )
        {
            oldContext.dispose ();
        }
    }

    public void dispose ()
    {
        logger.info ( "Disposing ... " );

        final Collection<DataContext> disposeList;
        this.writeLock.lock ();
        try
        {
            disposeList = new ArrayList<> ( this.contextMap.size () );
            disposeList.addAll ( this.contextMap.values () );
            this.contextMap.clear ();
        }
        finally
        {
            this.writeLock.unlock ();
        }

        // dispose outside of the lock
        for ( final DataContext context : disposeList )
        {
            context.dispose ();
        }

        this.hiveSource.close ();

        this.executor.shutdown ();
    }

}
