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
package org.eclipse.scada.da.server.ui;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.scada.da.server.ui.internal.ServerHostImpl;
import org.eclipse.scada.da.server.ui.internal.ServerManagerImpl;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class HivesPlugin extends AbstractUIPlugin
{

    // The plug-in ID
    public static final String PLUGIN_ID = "org.eclipse.scada.da.server.ui"; //$NON-NLS-1$

    // The shared instance
    private static HivesPlugin plugin;

    private ServerManagerImpl serverManager;

    private ServerHostImpl serverHost;

    /**
     * The constructor
     */
    public HivesPlugin ()
    {
    }

    @Override
    protected void initializeImageRegistry ( final ImageRegistry reg )
    {
        super.initializeImageRegistry ( reg );
        reg.put ( ImageConstants.IMG_ERROR, imageDescriptorFromPlugin ( PLUGIN_ID, "icons/error.gif" ) ); //$NON-NLS-1$
        reg.put ( ImageConstants.IMG_STOPPED, imageDescriptorFromPlugin ( PLUGIN_ID, "icons/stopped.gif" ) ); //$NON-NLS-1$
        reg.put ( ImageConstants.IMG_RUNNING, imageDescriptorFromPlugin ( PLUGIN_ID, "icons/running.gif" ) ); //$NON-NLS-1$
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        super.start ( context );
        this.serverManager = new ServerManagerImpl ( Realm.getDefault () );
        this.serverHost = new ServerHostImpl ( Realm.getDefault () );
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        if ( this.serverHost != null )
        {
            this.serverHost.dispose ();
            this.serverHost = null;
        }
        // shutdown the manager after the host, since the manager needs the hoster
        if ( this.serverManager != null )
        {
            this.serverManager.dispose ();
            this.serverManager = null;
        }
        plugin = null;
        super.stop ( context );
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static HivesPlugin getDefault ()
    {
        return plugin;
    }

    public ServerManagerImpl getServerManager ()
    {
        return this.serverManager;
    }

    public ServerHost getServerHost ()
    {
        return this.serverHost;
    }

    public static void registerServer ( final ServerDescriptor descriptor )
    {
        final HivesPlugin p = getDefault ();
        if ( p == null )
        {
            return;
        }

        p.getServerManager ().register ( descriptor );
    }

    public static void unregisterServer ( final ServerDescriptor descriptor )
    {
        final HivesPlugin p = getDefault ();
        if ( p == null )
        {
            return;
        }

        p.getServerManager ().unregister ( descriptor );
    }
}
