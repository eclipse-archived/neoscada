/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.ui.styles;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.scada.core.ui.styles.generator.PreferenceSelectorStyleGenerator;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin
{

    // The plug-in ID
    public static final String PLUGIN_ID = "org.eclipse.scada.core.ui.styles"; //$NON-NLS-1$

    private PreferenceSelectorStyleGenerator defaultStyleGenerator;

    // The shared instance
    private static Activator plugin;

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
        this.defaultStyleGenerator = new PreferenceSelectorStyleGenerator ( getPreferenceStore () );
    }

    @Override
    protected void initializeImageRegistry ( final ImageRegistry reg )
    {
        super.initializeImageRegistry ( reg );

        reg.put ( ImageConstants.IMG_MANUAL, imageDescriptorFromPlugin ( PLUGIN_ID, "icons/manual.png" ) ); //$NON-NLS-1$
        reg.put ( ImageConstants.IMG_BLOCK, imageDescriptorFromPlugin ( PLUGIN_ID, "icons/block.png" ) ); //$NON-NLS-1$
        reg.put ( ImageConstants.IMG_DISCONNECTED, imageDescriptorFromPlugin ( PLUGIN_ID, "icons/disconnected.png" ) ); //$NON-NLS-1$
        reg.put ( ImageConstants.IMG_ERROR, imageDescriptorFromPlugin ( PLUGIN_ID, "icons/error.png" ) ); //$NON-NLS-1$
        reg.put ( ImageConstants.IMG_ALARM, imageDescriptorFromPlugin ( PLUGIN_ID, "icons/alarm.png" ) ); //$NON-NLS-1$
        reg.put ( ImageConstants.IMG_WARNING, imageDescriptorFromPlugin ( PLUGIN_ID, "icons/warning.png" ) ); //$NON-NLS-1$
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.defaultStyleGenerator.dispose ();
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

    public static StyleGenerator getDefaultStyleGenerator ()
    {
        return Activator.plugin.defaultStyleGenerator;
    }
}
