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
package org.eclipse.scada.core.ui.connection.data;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.scada.core.client.Connection;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.ConnectionStateListener;
import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.eclipse.scada.core.ui.connection.Activator;
import org.eclipse.scada.core.ui.connection.ConnectionDescriptor;
import org.eclipse.scada.core.ui.connection.creator.ConnectionCreatorHelper;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

import com.google.common.collect.HashMultimap;

public class ConnectionManager
{
    public class EntryWrapper implements Entry
    {
        private final EntryImpl entry;

        public EntryWrapper ( final EntryImpl entry )
        {
            this.entry = entry;
        }

        public EntryImpl getEntry ()
        {
            return this.entry;
        }

        @Override
        public ConnectionDescriptor getConnectionDescriptor ()
        {
            return this.entry.getConnectionDescriptor ();
        }

        @Override
        public ConnectionService getConnectionService ()
        {
            return this.entry.getConnectionService ();
        }

        @Override
        public void dispose ()
        {
            unwrapConnection ( this );
        }
    }

    public interface Entry
    {
        public ConnectionDescriptor getConnectionDescriptor ();

        public ConnectionService getConnectionService ();

        public void dispose ();
    }

    public class EntryImpl implements Entry, ConnectionStateListener
    {
        private final ConnectionService connectionService;

        private final ConnectionDescriptor connectionDescriptor;

        private final ServiceRegistration<?> serviceRegistration;

        public EntryImpl ( final ConnectionDescriptor connectionDescriptor, final ConnectionService connectionService, final ServiceRegistration<?> serviceRegistration )
        {
            this.connectionDescriptor = connectionDescriptor;
            this.connectionService = connectionService;
            this.serviceRegistration = serviceRegistration;

            connectionService.getConnection ().addConnectionStateListener ( this );
        }

        @Override
        public void stateChange ( final Connection connection, final ConnectionState state, final Throwable error )
        {
            final IStatus status = makeStatus ( connection, state, error );
            Activator.getDefault ().getLog ().log ( status );

            showError ( status );
        }

        private void showError ( final IStatus status )
        {
            if ( !status.matches ( IStatus.ERROR ) )
            {
                return;
            }

            final Display display = PlatformUI.getWorkbench ().getDisplay ();
            if ( !display.isDisposed () )
            {
                display.asyncExec ( new Runnable () {

                    @Override
                    public void run ()
                    {
                        if ( !display.isDisposed () )
                        {
                            ErrorDialog.openError ( PlatformUI.getWorkbench ().getActiveWorkbenchWindow ().getShell (), "Connection error", "Connection failed", status, IStatus.ERROR );
                        }
                    }
                } );
            }
        }

        private IStatus makeStatus ( final Connection connection, final ConnectionState state, final Throwable error )
        {
            int severity;
            String message;
            if ( error != null )
            {
                message = error.getMessage ();
                severity = IStatus.ERROR;
            }
            else if ( state == ConnectionState.CLOSED )
            {
                message = "Connection closed";
                severity = IStatus.WARNING;
            }
            else
            {
                message = String.format ( "State changed: %s", state );
                severity = IStatus.INFO;
            }

            return new Status ( severity, Activator.PLUGIN_ID, message, error );
        }

        @Override
        public ConnectionDescriptor getConnectionDescriptor ()
        {
            return this.connectionDescriptor;
        }

        @Override
        public ConnectionService getConnectionService ()
        {
            return this.connectionService;
        }

        @Override
        public void dispose ()
        {
            this.connectionService.getConnection ().removeConnectionStateListener ( this );
            try
            {
                this.serviceRegistration.unregister ();
            }
            finally
            {
                this.connectionService.dispose ();
            }
        }
    }

    private final BundleContext context;

    private final HashMultimap<ConnectionDescriptor, EntryWrapper> entryMap;

    public ConnectionManager ( final BundleContext context )
    {
        this.context = context;
        this.entryMap = HashMultimap.create ();
    }

    public synchronized Entry getConnection ( final ConnectionDescriptor connectionDescriptor )
    {
        final Set<EntryWrapper> entries = this.entryMap.get ( connectionDescriptor );
        if ( !entries.isEmpty () )
        {
            return wrapConnection ( entries.iterator ().next ().getEntry () );
        }

        final ConnectionService connectionService = ConnectionCreatorHelper.createConnection ( connectionDescriptor.getConnectionInformation (), null, false );

        if ( connectionService == null )
        {
            return null;
        }

        return wrapConnection ( registerConnection ( connectionDescriptor, connectionService ) );
    }

    protected synchronized Entry wrapConnection ( final EntryImpl entry )
    {
        if ( entry == null )
        {
            return null;
        }

        final EntryWrapper wrapper = new EntryWrapper ( entry );

        this.entryMap.put ( entry.getConnectionDescriptor (), wrapper );

        return wrapper;
    }

    protected synchronized void unwrapConnection ( final EntryWrapper wrapper )
    {
        this.entryMap.remove ( wrapper.getConnectionDescriptor (), wrapper );
        if ( !this.entryMap.containsKey ( wrapper.getConnectionDescriptor () ) )
        {
            wrapper.getEntry ().dispose ();
        }
    }

    /**
     * Register the current connection as an OSGi service
     */
    private EntryImpl registerConnection ( final ConnectionDescriptor connectionDescriptor, final ConnectionService connectionService )
    {
        final Class<?>[] interfaces = connectionService.getSupportedInterfaces ();

        final String[] clazzes = new String[interfaces.length];

        int i = 0;
        for ( final Class<?> iface : interfaces )
        {
            clazzes[i] = iface.getName ();
            i++;
        }

        final Dictionary<String, String> properties = new Hashtable<String, String> ();
        properties.put ( ConnectionService.CONNECTION_URI, connectionDescriptor.getConnectionInformation ().toString () );
        if ( connectionDescriptor.getServiceId () != null )
        {
            properties.put ( Constants.SERVICE_PID, connectionDescriptor.getServiceId () );
        }
        final ServiceRegistration<?> serviceRegistration = this.context.registerService ( clazzes, connectionService, properties );
        return new EntryImpl ( connectionDescriptor, connectionService, serviceRegistration );
    }

    public void dispose ()
    {
        for ( final EntryWrapper wrapper : this.entryMap.values ().toArray ( new EntryWrapper[0] ) )
        {
            wrapper.dispose ();
        }
        this.entryMap.clear ();
    }
}
