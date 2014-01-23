/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.discoverer.prefs;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;
import java.util.prefs.BackingStoreException;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.ui.connection.AbstractConnectionDiscoverer;
import org.eclipse.scada.core.ui.connection.ConnectionDescriptor;
import org.eclipse.scada.core.ui.connection.ConnectionStore;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPreferencesDiscoverer extends AbstractConnectionDiscoverer implements ConnectionStore
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractPreferencesDiscoverer.class );

    private static final String PREF_NAME = "connection"; //$NON-NLS-1$

    private PreferenceChangeListener listener;

    protected abstract Preferences getNode ();

    public AbstractPreferencesDiscoverer ()
    {
        initialize ();
    }

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
        try
        {
            final Set<ConnectionDescriptor> result = new HashSet<ConnectionDescriptor> ();
            for ( final String uri : getNode ().childrenNames () )
            {
                final ConnectionDescriptor cd = loadNode ( uri, getNode ().node ( uri ) );
                if ( cd != null )
                {
                    result.add ( cd );
                }
            }
            setConnections ( result );
        }
        catch ( final BackingStoreException e )
        {
            logger.warn ( "Failed to get children", e ); //$NON-NLS-1$
        }
    }

    private ConnectionDescriptor loadNode ( final String uriEncoded, final Preferences node )
    {
        try
        {
            final String uri = URLDecoder.decode ( uriEncoded, "UTF-8" ); //$NON-NLS-1$
            final String serviceId = node.get ( "serviceId", null ); //$NON-NLS-1$
            final String description = node.get ( "description", null ); //$NON-NLS-1$
            return new ConnectionDescriptor ( ConnectionInformation.fromURI ( uri ), serviceId, description );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to decode node", e ); //$NON-NLS-1$
        }
        return null;
    }

    protected void refresh ()
    {
        loadAll ();
    }

    @Override
    public void add ( final ConnectionDescriptor connectionInformation ) throws CoreException
    {
        try
        {
            if ( addConnection ( connectionInformation ) )
            {
                performAdd ( connectionInformation );
            }
        }
        catch ( final Exception e )
        {
            throw new CoreException ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }

    }

    private void performAdd ( final ConnectionDescriptor connectionInformation ) throws Exception
    {
        final String uri = URLEncoder.encode ( connectionInformation.getConnectionInformation ().toString (), "UTF-8" ); //$NON-NLS-1$
        final Preferences node = getNode ();
        final Preferences child = node.node ( uri );

        storeValue ( child, "description", connectionInformation.getDescription () ); //$NON-NLS-1$
        storeValue ( child, "serviceId", connectionInformation.getServiceId () ); //$NON-NLS-1$

        getNode ().flush ();
    }

    protected void storeValue ( final Preferences node, final String key, final String value )
    {
        if ( value != null )
        {
            node.put ( key, value );
        }
        else
        {
            node.remove ( key );
        }
    }

    @Override
    public void remove ( final ConnectionDescriptor connectionInformation ) throws CoreException
    {
        try
        {
            if ( removeConnection ( connectionInformation ) )
            {
                final String uri = URLEncoder.encode ( connectionInformation.getConnectionInformation ().toString (), "UTF-8" ); //$NON-NLS-1$
                if ( getNode ().nodeExists ( uri ) )
                {
                    final Preferences node = getNode ().node ( uri );
                    node.removeNode ();
                    getNode ().flush ();
                    fireDiscoveryUpdate ( null, new ConnectionDescriptor[] { connectionInformation } );
                }
            }
        }
        catch ( final Exception e )
        {
            throw new CoreException ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }
    }

    @Override
    public void update ( final ConnectionDescriptor original, final ConnectionDescriptor updated ) throws CoreException
    {
        remove ( original );
        add ( updated );
    }
}