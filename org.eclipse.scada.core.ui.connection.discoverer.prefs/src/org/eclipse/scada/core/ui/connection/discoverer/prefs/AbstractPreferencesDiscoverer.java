/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.discoverer.prefs;

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.scada.core.ui.connection.ConnectionDescriptor;
import org.eclipse.scada.core.ui.connection.ConnectionStore;
import org.eclipse.scada.core.ui.connection.discoverer.file.ResourceDiscoverer;

public abstract class AbstractPreferencesDiscoverer extends ResourceDiscoverer implements ConnectionStore
{

    private static final String PREF_NAME = "connection"; //$NON-NLS-1$

    private PreferenceChangeListener listener;

    public AbstractPreferencesDiscoverer ()
    {
        super ();
    }

    protected abstract Preferences getNode ();

    @Override
    protected void initialize ()
    {
        loadAll ();

        getNode ().addPreferenceChangeListener ( this.listener = new PreferenceChangeListener () {

            @Override
            public void preferenceChange ( final PreferenceChangeEvent evt )
            {
                if ( PREF_NAME.equals ( evt.getKey () ) )
                {
                    refresh ();
                }
            }
        } );
    }

    @Override
    public synchronized void dispose ()
    {
        getNode ().removePreferenceChangeListener ( this.listener );
        super.dispose ();
    }

    private void loadAll ()
    {
        final String data = getNode ().get ( PREF_NAME, "" ); //$NON-NLS-1$  
        final StringReader reader = new StringReader ( data );
        load ( reader );
    }

    protected void refresh ()
    {
        loadAll ();
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
        final StringWriter sw = new StringWriter ();
        PrintWriter printer = null;
        try
        {
            printer = new PrintWriter ( sw );
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
            printer.close ();

            final Preferences node = getNode ();
            node.put ( PREF_NAME, sw.toString () );
            node.flush ();
        }
        catch ( final Exception e )
        {
            throw new CoreException ( new Status ( IStatus.ERROR, Activator.PLUGIN_ID, Messages.UserDiscoverer_ErrorStore, e ) );
        }
        finally
        {
            if ( printer != null )
            {
                printer.close ();
            }
        }

    }

}