/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin
{

    // The plug-in ID
    public static final String PLUGIN_ID = "org.eclipse.scada.vi.ui.draw2d"; //$NON-NLS-1$

    private static final String EXTP_VIEW_ELEMENT_FACTORY = "org.eclipse.scada.vi.ui.draw2d.viewElementFactory";

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
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
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

    public static ViewElementFactory createFactory ( final EObject modelObject ) throws CoreException
    {
        if ( modelObject == null )
        {
            return null;
        }

        final String requestedClass = modelObject.eClass ().getInstanceClassName ();

        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_VIEW_ELEMENT_FACTORY ) )
        {
            if ( !"factory".equals ( ele.getName () ) )
            {
                continue;
            }

            for ( final IConfigurationElement child : ele.getChildren ( "supports" ) )
            {
                final String modelClass = child.getAttribute ( "modelClass" );
                if ( modelClass == null || modelClass.isEmpty () )
                {
                    continue;
                }

                if ( modelClass.equals ( requestedClass ) )
                {
                    return (ViewElementFactory)ele.createExecutableExtension ( "class" );
                }
            }

        }
        return null;
    }
}
