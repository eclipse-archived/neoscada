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
package org.eclipse.scada.ca.ui.jobs;

import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.scada.ca.data.ConfigurationInformation;
import org.eclipse.scada.ca.ui.Activator;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.connection.provider.ConnectionRequest;
import org.eclipse.scada.core.connection.provider.ConnectionRequestTracker;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.ca.connection.provider.ConnectionService;

public class LoadJob extends Job
{
    private final String connectionUri;

    private final String factoryId;

    private final String configurationId;

    private ConfigurationInformation configuration;

    private final AtomicReference<Thread> runner = new AtomicReference<Thread> ();

    public LoadJob ( final String connectionUri, final String factoryId, final String configurationId )
    {
        super ( "Loading data" );
        this.connectionUri = connectionUri;
        this.factoryId = factoryId;
        this.configurationId = configurationId;
    }

    public ConfigurationInformation getConfiguration ()
    {
        return this.configuration;
    }

    @Override
    protected void canceling ()
    {
        final Thread thread = this.runner.getAndSet ( null );
        thread.interrupt ();
    }

    @Override
    protected IStatus run ( final IProgressMonitor monitor )
    {
        monitor.beginTask ( "Loading configuration", 3 );

        final ConnectionInformation connectionInformation = ConnectionInformation.fromURI ( this.connectionUri );
        final ConnectionRequestTracker tracker = new ConnectionRequestTracker ( Activator.getBundleContext (), new ConnectionRequest ( null, connectionInformation, 10 * 1000, true ), null );

        try
        {
            this.runner.set ( Thread.currentThread () );

            monitor.worked ( 1 );
            monitor.subTask ( "Opening tracker" );
            tracker.open ();

            monitor.subTask ( "Waiting for service" );
            tracker.waitForService ( 0 );

            final ConnectionService service = (ConnectionService)tracker.getService ();

            monitor.worked ( 1 );
            monitor.subTask ( "Retrieving data" );
            final NotifyFuture<ConfigurationInformation> task = service.getConnection ().getConfiguration ( this.factoryId, this.configurationId );
            this.configuration = task.get ();
            monitor.worked ( 1 );
        }
        catch ( final InterruptedException e )
        {
            return Status.CANCEL_STATUS;
        }
        catch ( final Exception e )
        {
            return new Status ( IStatus.ERROR, Activator.PLUGIN_ID, "Failed to load data", e );
        }
        finally
        {
            this.runner.set ( null );
            monitor.done ();
            tracker.close ();
        }
        return Status.OK_STATUS;
    }
}