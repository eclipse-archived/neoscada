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
package org.eclipse.scada.core.ui.connection;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ObservableSet;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.scada.core.ui.connection.data.ConnectionDiscovererAdapterFactory;
import org.eclipse.scada.core.ui.connection.data.ConnectionDiscovererBean;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolderAdapterFactory;
import org.eclipse.scada.core.ui.connection.data.ConnectionManager;
import org.eclipse.scada.core.ui.connection.views.tree.ConnectionTreeManager;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin
{

    // The plug-in ID
    public static final String PLUGIN_ID = "org.eclipse.scada.core.ui.connection";

    public static final String EXTP_CONNECTON_DISCOVERER = "org.eclipse.scada.core.ui.connection.discoverer";

    private static final String ELE_DISCOVERER = "discoverer";

    // The shared instance
    private static Activator plugin;

    private ObservableSet discoverers;

    private WritableSet treeRoot;

    private final Map<Class<?>, IAdapterFactory> adaperFactories = new HashMap<Class<?>, IAdapterFactory> ();

    private ConnectionManager connectionManager;

    private ConnectionTreeManager treeRootManager;

    public static final Root ROOT = new Root ();

    /**
     * The constructor
     */
    public Activator ()
    {
        this.adaperFactories.put ( ConnectionDiscovererBean.class, new ConnectionDiscovererAdapterFactory () );
        this.adaperFactories.put ( ConnectionHolder.class, new ConnectionHolderAdapterFactory () );
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        super.start ( context );
        plugin = this;

        this.treeRoot = new WritableSet ( SWTObservables.getRealm ( getWorkbench ().getDisplay () ) );
        this.treeRootManager = new ConnectionTreeManager ( this.treeRoot );

        this.connectionManager = new ConnectionManager ( context );

        for ( final Map.Entry<Class<?>, IAdapterFactory> entry : this.adaperFactories.entrySet () )
        {
            Platform.getAdapterManager ().registerAdapters ( entry.getValue (), entry.getKey () );
        }

    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        for ( final Map.Entry<Class<?>, IAdapterFactory> entry : this.adaperFactories.entrySet () )
        {
            Platform.getAdapterManager ().unregisterAdapters ( entry.getValue (), entry.getKey () );
        }

        if ( this.connectionManager != null )
        {
            this.connectionManager.dispose ();
            this.connectionManager = null;
        }

        this.treeRootManager.dispose ();
        this.treeRoot.dispose ();

        plugin = null;
        super.stop ( context );
    }

    public IObservableSet getDiscovererSet ()
    {
        synchronized ( this )
        {
            if ( this.discoverers == null )
            {
                this.discoverers = createDiscoverers ();
            }
            return Observables.proxyObservableSet ( this.discoverers );
        }
    }

    public ObservableSet getTreeRoot ()
    {
        return this.treeRoot;
    }

    private ObservableSet createDiscoverers ()
    {
        final WritableSet result = new WritableSet ( SWTObservables.getRealm ( getWorkbench ().getDisplay () ) );

        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_CONNECTON_DISCOVERER ) )
        {
            if ( ELE_DISCOVERER.equals ( ele.getName () ) )
            {
                final String id = ele.getAttribute ( "id" );
                String name = ele.getAttribute ( "name" );
                if ( name == null )
                {
                    name = id;
                }

                final String icon = ele.getAttribute ( "icon" );
                ImageDescriptor imageDescriptor = null;
                if ( icon != null )
                {
                    imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin ( ele.getContributor ().getName (), icon );
                }

                final String description = ele.getAttribute ( "description" );

                // create
                try
                {
                    final ConnectionDiscovererBean bean = new ConnectionDiscovererBean ( id, name, description, imageDescriptor, (ConnectionDiscoverer)ele.createExecutableExtension ( "class" ) );
                    result.add ( bean );
                }
                catch ( final CoreException e )
                {
                    getLog ().log ( e.getStatus () );
                }
            }
        }

        return result;
    }

    public ConnectionManager getConnectionManager ()
    {
        return this.connectionManager;
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static Activator getDefault ()
    {
        return plugin;
    }

    public static ConnectionManager getDefaultConectionManager ()
    {
        return getDefault ().getConnectionManager ();
    }

}
