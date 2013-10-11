/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.discoverer.file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.scada.core.ui.connection.ConnectionDescriptor;
import org.eclipse.scada.core.ui.connection.ConnectionStore;

public class DefaultFileResourceDiscoverer extends ResourceDiscoverer implements ConnectionStore
{
    private static final String FILENAME = "connections.txt"; //$NON-NLS-1$

    @Override
    protected void initialize ()
    {
        load ( getFile () );
    }

    @Override
    public void add ( final ConnectionDescriptor connectionInformation ) throws CoreException
    {
        if ( addConnection ( connectionInformation ) )
        {
            store ();
        }
    }

    @Override
    public void remove ( final ConnectionDescriptor connectionInformation ) throws CoreException
    {
        if ( removeConnection ( connectionInformation ) )
        {
            store ();
        }
    }

    @Override
    public void update ( final ConnectionDescriptor oldConnectionDescriptor, final ConnectionDescriptor newConnectionDescriptor ) throws CoreException
    {
        remove ( oldConnectionDescriptor );
        add ( newConnectionDescriptor );
    }

    private void store () throws CoreException
    {
        PrintWriter printer = null;
        try
        {
            printer = new PrintWriter ( getFile () );
            for ( final ConnectionDescriptor descriptor : getConnections () )
            {
                if ( descriptor.getServiceId () != null )
                {
                    printer.println ( descriptor.getServiceId () + STORE_ID_DELIM + descriptor.getConnectionInformation () );
                }
                else
                {
                    printer.println ( descriptor.getConnectionInformation ().toString () );
                }
            }
        }
        catch ( final IOException e )
        {
            throw new CoreException ( new Status ( IStatus.ERROR, Activator.PLUGIN_ID, Messages.DefaultFileResourceDiscoverer_ErrorStore, e ) );
        }
        finally
        {
            if ( printer != null )
            {
                printer.close ();
            }
        }
    }

    private File getFile ()
    {
        return Activator.getDefault ().getBundle ().getBundleContext ().getDataFile ( FILENAME );
    }

}
