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

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.scada.ca.data.FactoryInformation;
import org.eclipse.scada.ca.ui.Activator;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.ca.connection.provider.ConnectionService;

public class LoadFactoryJob extends Job
{
    private final ConnectionService service;

    private final String factoryId;

    private FactoryInformation factory;

    private final AtomicReference<NotifyFuture<FactoryInformation>> task = new AtomicReference<NotifyFuture<FactoryInformation>> ();

    public LoadFactoryJob ( final ConnectionService service, final String factoryId )
    {
        super ( "Loading data" );
        setUser ( true );
        this.service = service;
        this.factoryId = factoryId;
    }

    public FactoryInformation getFactory ()
    {
        return this.factory;
    }

    @Override
    protected void canceling ()
    {
        final NotifyFuture<FactoryInformation> task = this.task.getAndSet ( null );
        if ( task != null )
        {
            task.cancel ( true );
        }
    }

    @Override
    protected IStatus run ( final IProgressMonitor monitor )
    {
        try
        {
            final NotifyFuture<FactoryInformation> task = this.service.getConnection ().getFactoryWithData ( this.factoryId );
            this.task.set ( task );
            this.factory = task.get ();
        }
        catch ( final InterruptedException e )
        {
            return Status.CANCEL_STATUS;
        }
        catch ( final ExecutionException e )
        {
            return new Status ( IStatus.ERROR, Activator.PLUGIN_ID, "Failed to load data", e );
        }
        finally
        {
            this.task.set ( null );
            monitor.done ();
        }
        return Status.OK_STATUS;
    }
}