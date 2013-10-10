/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.hd.server.storage.master.hds;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.scada.hd.server.storage.master.hds.console.Console;
import org.eclipse.scada.hds.DataFilePool;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator
{

    private final static Logger logger = LoggerFactory.getLogger ( Activator.class );

    private static BundleContext context;

    private StorageManager manager;

    private DataFilePool pool;

    static BundleContext getContext ()
    {
        return context;
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext bundleContext ) throws Exception
    {
        Activator.context = bundleContext;

        this.pool = new DataFilePool ( Integer.getInteger ( "org.eclipse.scada.hd.server.storage.master.hds.instanceCountTarget", 10 ) ); //$NON-NLS-1$

        this.manager = new StorageManager ( bundleContext, this.pool );
        registerConsole ();
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        this.manager.dispose ();
        this.manager = null;

        this.pool.dispose ();

        Activator.context = null;
    }

    private void registerConsole ()
    {
        try
        {
            final Console console = new Console ( this.manager );
            final Dictionary<String, Object> properties = new Hashtable<String, Object> ();
            properties.put ( "osgi.command.scope", "hds" ); //$NON-NLS-1$
            properties.put ( "osgi.command.function", new String[] { "list", "purgeAll", "remove", "create" } ); //$NON-NLS-1$

            context.registerService ( Console.class, console, properties );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to register console", e ); //$NON-NLS-1$
        }
    }

}
