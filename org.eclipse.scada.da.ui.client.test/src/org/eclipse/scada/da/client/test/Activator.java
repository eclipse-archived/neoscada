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
package org.eclipse.scada.da.client.test;

import org.eclipse.core.commands.operations.OperationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The main plugin class to be used in the desktop.
 */
public class Activator extends AbstractUIPlugin
{

    private final static Logger logger = LoggerFactory.getLogger ( Activator.class );

    public static final String PLUGIN_ID = "org.eclipse.scada.da.client.test";

    //The shared instance.
    private static Activator plugin = null;

    /**
     * The constructor.
     */
    public Activator ()
    {
        plugin = this;
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
        plugin = null;
    }

    /**
     * Returns the shared instance.
     */
    public static Activator getDefault ()
    {
        return plugin;
    }

    /**
     * Returns an image descriptor for the image file at the given
     * plug-in relative path.
     *
     * @param path the path
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor ( final String path )
    {
        return AbstractUIPlugin.imageDescriptorFromPlugin ( "org.eclipse.scada.da.client.test", path );
    }

    public static String getId ()
    {
        return getDefault ().getBundle ().getSymbolicName ();
    }

    public static void logError ( final int code, final String msg, final Throwable ex )
    {
        getDefault ().getLog ().log ( new Status ( IStatus.ERROR, getId (), code, msg, ex ) );
    }

    /**
     * Notify error using message box (thread safe).
     * @param message The message to display
     * @param error The error that occurred
     */
    public void notifyError ( final String message, final Throwable error )
    {
        final Display display = getWorkbench ().getDisplay ();

        if ( !display.isDisposed () )
        {
            display.asyncExec ( new Runnable () {

                @Override
                public void run ()
                {
                    final Shell shell = getWorkbench ().getActiveWorkbenchWindow ().getShell ();
                    logger.debug ( "Shell disposed: {}", shell.isDisposed () );
                    if ( !shell.isDisposed () )
                    {
                        final IStatus status = new OperationStatus ( IStatus.ERROR, PLUGIN_ID, 0, message + ":" + error.getMessage (), error );
                        ErrorDialog.openError ( shell, null, message, status );
                    }
                }
            } );
        }
    }
}
