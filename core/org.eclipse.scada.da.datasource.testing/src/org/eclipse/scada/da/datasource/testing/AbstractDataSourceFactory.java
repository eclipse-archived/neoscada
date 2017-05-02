/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.datasource.testing;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.sec.UserInformation;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public abstract class AbstractDataSourceFactory implements ConfigurationFactory
{

    private final ScheduledExecutorService scheduler;

    private final BundleContext context;

    public AbstractDataSourceFactory ( final BundleContext context, final ScheduledExecutorService scheduler )
    {
        this.context = context;
        this.scheduler = scheduler;
    }

    public ScheduledExecutorService getScheduler ()
    {
        return this.scheduler;
    }

    private final Map<String, DefaultDataSource> dataSources = new HashMap<String, DefaultDataSource> ();

    private final Map<String, ServiceRegistration<DataSource>> regs = new HashMap<String, ServiceRegistration<DataSource>> ();

    @Override
    public synchronized void delete ( final UserInformation userInformation, final String configurationId ) throws Exception
    {
        final ServiceRegistration<DataSource> reg = this.regs.remove ( configurationId );
        reg.unregister ();

        final DefaultDataSource source = this.dataSources.remove ( configurationId );
        source.dispose ();
    }

    @Override
    public synchronized void update ( final UserInformation userInformation, final String configurationId, final Map<String, String> properties ) throws Exception
    {
        DefaultDataSource source = this.dataSources.get ( configurationId );
        if ( source == null )
        {
            source = createDataSource ();
            this.dataSources.put ( configurationId, source );
            final Dictionary<String, String> props = new Hashtable<String, String> ();
            props.put ( DataSource.DATA_SOURCE_ID, configurationId );

            this.regs.put ( configurationId, this.context.registerService ( DataSource.class, source, props ) );
        }
        source.update ( properties );
    }

    protected abstract DefaultDataSource createDataSource ();

    public synchronized void dispose ()
    {
        for ( final ServiceRegistration<DataSource> reg : this.regs.values () )
        {
            reg.unregister ();
        }
        this.regs.clear ();

        for ( final DefaultDataSource source : this.dataSources.values () )
        {
            source.dispose ();
        }
        this.dataSources.clear ();
    }
}
