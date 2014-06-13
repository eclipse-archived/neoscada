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

package org.eclipse.scada.configuration.validation.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class ValidationPlugin extends Plugin
{

    //The shared instance.
    private static ValidationPlugin plugin;

    /**
     * The constructor.
     */
    public ValidationPlugin ()
    {
        super ();
        plugin = this;
    }

    public static String getID ()
    {
        return getDefault ().getBundle ().getSymbolicName ();
    }

    public static void log ( final String message, final Throwable t )
    {
        getDefault ().getLog ().log ( new Status ( IStatus.ERROR, getID (), 1, message, t ) );
    }

    /**
     * This method is called upon plug-in activation
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        super.start ( context );
    }

    /**
     * This method is called when the plug-in is stopped
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        super.stop ( context );
    }

    /**
     * Returns the shared instance.
     */
    public static ValidationPlugin getDefault ()
    {
        return plugin;
    }
}
