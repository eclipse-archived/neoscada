/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - provide scheduled executor for image loading
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.eclipse.scada.vi.details.swt.impl.visibility.VisibilityTester;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin
{

    // The plug-in ID
    public static final String PLUGIN_ID = "org.eclipse.scada.vi.details.swt"; //$NON-NLS-1$

    public static final String IMG_CONTROLLER_BLOCKED = "blocked"; //$NON-NLS-1$

    public static final String IMG_CONTROLLER_UNBLOCKED = "unblocked"; //$NON-NLS-1$

    public static final String IMG_WARN_BIG = "warn.big"; //$NON-NLS-1$

    public static final String IMG_TREND = "trend"; //$NON-NLS-1$

    public static final String IMG_ATTR_OK = "attr.ok"; //$NON-NLS-1$

    public static final String IMG_EMPTY = "empty"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;

    private ScheduledExecutorService executor;

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        super.start ( context );

        VisibilityTester.INSTANCE = new VisibilityTester ();

        plugin = this;
        this.executor = Executors.newSingleThreadScheduledExecutor ( new NamedThreadFactory ( "org.eclipse.scada.vi.details.swt/Image loader" ) );
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.executor.shutdown ();

        if ( VisibilityTester.INSTANCE != null )
        {
            VisibilityTester.INSTANCE.dispose ();
            VisibilityTester.INSTANCE = null;
        }

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

    public static ScheduledExecutorService getExecutor ()
    {
        return plugin.executor;
    }

    @Override
    protected void initializeImageRegistry ( final ImageRegistry reg )
    {
        super.initializeImageRegistry ( reg );
        reg.put ( IMG_CONTROLLER_BLOCKED, imageDescriptorFromPlugin ( PLUGIN_ID, "icons/blocked.gif" ) ); //$NON-NLS-1$
        reg.put ( IMG_CONTROLLER_UNBLOCKED, imageDescriptorFromPlugin ( PLUGIN_ID, "icons/unblocked.gif" ) ); //$NON-NLS-1$
        reg.put ( IMG_WARN_BIG, imageDescriptorFromPlugin ( PLUGIN_ID, "icons/warn.gif" ) ); //$NON-NLS-1$
        reg.put ( IMG_TREND, imageDescriptorFromPlugin ( PLUGIN_ID, "icons/trend_10.png" ) ); //$NON-NLS-1$
        reg.put ( IMG_ATTR_OK, imageDescriptorFromPlugin ( PLUGIN_ID, "icons/ok.png" ) ); //$NON-NLS-1$
        reg.put ( IMG_EMPTY, imageDescriptorFromPlugin ( PLUGIN_ID, "icons/empty.png" ) ); //$NON-NLS-1$
    }

}
