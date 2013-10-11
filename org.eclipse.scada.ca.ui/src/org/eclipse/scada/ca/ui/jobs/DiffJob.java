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
package org.eclipse.scada.ca.ui.jobs;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.scada.ca.client.Connection;
import org.eclipse.scada.ca.data.DiffEntry;
import org.eclipse.scada.ca.ui.Activator;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.connection.provider.ConnectionRequest;
import org.eclipse.scada.core.connection.provider.ConnectionRequestTracker;
import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.eclipse.scada.sec.ui.DisplayCallbackHandler;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.UIJob;

public class DiffJob extends UIJob
{

    private final List<DiffEntry> diffEntries;

    private final String connectionUri;

    private final AtomicReference<Thread> runner = new AtomicReference<Thread> ();

    private final ConnectionService connectionService;

    public DiffJob ( final String jobName, final String connectionUri, final DiffEntry diffEntry )
    {
        super ( jobName );
        this.connectionUri = connectionUri;
        this.connectionService = null;
        this.diffEntries = Arrays.asList ( diffEntry );
    }

    public DiffJob ( final String jobName, final String connectionUri, final List<DiffEntry> diffEntries )
    {
        super ( jobName );
        this.connectionUri = connectionUri;
        this.connectionService = null;
        this.diffEntries = diffEntries;
    }

    public DiffJob ( final String jobName, final ConnectionService connectionService, final List<DiffEntry> diffEntries )
    {
        super ( jobName );
        this.connectionUri = null;
        this.connectionService = connectionService;
        this.diffEntries = diffEntries;
    }

    public DiffJob ( final String jobName, final ConnectionService connectionService, final DiffEntry entry )
    {
        this ( jobName, connectionService, Arrays.asList ( entry ) );
    }

    @Override
    protected void canceling ()
    {
        final Thread thread = this.runner.getAndSet ( null );
        thread.interrupt ();
    }

    @Override
    public IStatus runInUIThread(final IProgressMonitor monitor)
    {
        if ( this.connectionService != null )
        {
            try
            {
                runWithService ( this.connectionService );
            }
            catch ( final Exception e )
            {
                return new Status ( IStatus.ERROR, Activator.PLUGIN_ID, "Failed to save data", e );
            }
            return Status.OK_STATUS;
        }
        else
        {
            final ConnectionInformation connectionInformation = ConnectionInformation.fromURI ( this.connectionUri );
            final ConnectionRequestTracker tracker = new ConnectionRequestTracker ( Activator.getBundleContext (), new ConnectionRequest ( null, connectionInformation, 10 * 1000, true ), null );

            try
            {
                this.runner.set ( Thread.currentThread () );

                tracker.open ();

                tracker.waitForService ( 0 );

                final ConnectionService connectionService = tracker.getService ();
                runWithService ( connectionService );

                return Status.OK_STATUS;
            }
            catch ( final InterruptedException e )
            {
                return Status.CANCEL_STATUS;
            }
            catch ( final Exception e )
            {
                return new Status ( IStatus.ERROR, Activator.PLUGIN_ID, "Failed to save data", e );
            }
            finally
            {
                this.runner.set ( null );
                tracker.close ();
            }
        }
    }

    private void runWithService ( final ConnectionService connectionService )
    {
        final Connection connection = (Connection)connectionService.getConnection ();
        connection.applyDiff ( this.diffEntries, null, new DisplayCallbackHandler ( PlatformUI.getWorkbench ().getActiveWorkbenchWindow ().getShell (), "Apply diff", "Confirmation on applying diff required" ) );
    }
}