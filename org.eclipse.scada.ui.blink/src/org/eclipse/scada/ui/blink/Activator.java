/*******************************************************************************
 * Copyright (c) 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ui.blink;

import org.eclipse.scada.ui.blink.internal.DisplayBlinkServiceImpl;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin
{

    // The plug-in ID
    public static final String PLUGIN_ID = "org.eclipse.scada.ui.blink"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;

    private DisplayBlinkServiceImpl toggle;

    /**
     * The constructor
     */
    public Activator ()
    {
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

        this.toggle = new DisplayBlinkServiceImpl ( getWorkbench ().getDisplay () );

        Display.getDefault ().asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                Activator.this.toggle.start ();
            }
        } );
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        Display.getDefault ().asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                Activator.this.toggle.stop ();
            }
        } );

        this.toggle = null;

        plugin = null;
        super.stop ( context );
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

    private void addToggle ( final BlinkCallback callback )
    {
        this.toggle.addListener ( callback );
    }

    private void removeToggle ( final BlinkCallback callback )
    {
        this.toggle.removeListener ( callback );
    }

    public static void addDefaultToggle ( final BlinkCallback callback )
    {
        getDefault ().addToggle ( callback );
    }

    public static void removeDefaultToggle ( final BlinkCallback callback )
    {
        final Activator defaultInstance = getDefault ();
        if ( defaultInstance != null )
        {
            defaultInstance.removeToggle ( callback );
        }
    }

}
