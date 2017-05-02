/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.infrastructure.lib;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IRegistryEventListener;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin
{

    private final static Logger logger = LoggerFactory.getLogger ( Activator.class );

    // The plug-in ID
    public static final String PLUGIN_ID = "org.eclipse.scada.configuration.infrastructure.lib"; //$NON-NLS-1$

    private static final String EXTP_DRIVER = "org.eclipse.scada.configuration.infrastructure.lib.driver"; //$NON-NLS-1$

    private static final Object ELE_DRIVER_FACTORY = "driverFactory"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;

    private static Map<String, DriverFactory> cache;

    private IRegistryEventListener listener;

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
        Platform.getExtensionRegistry ().addListener ( this.listener = new IRegistryEventListener () {

            @Override
            public void removed ( final IExtensionPoint[] extensionPoints )
            {
                clearCache ();
            }

            @Override
            public void removed ( final IExtension[] extensions )
            {
                clearCache ();
            }

            @Override
            public void added ( final IExtensionPoint[] extensionPoints )
            {
                clearCache ();
            }

            @Override
            public void added ( final IExtension[] extensions )
            {
                clearCache ();
            }
        }, EXTP_DRIVER );
    }

    protected void clearCache ()
    {
        cache = null;
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        Platform.getExtensionRegistry ().removeListener ( this.listener );
        plugin = null;
        clearCache ();

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

    public static DriverFactory findDriverFactory ( final String typeId )
    {
        if ( plugin == null )
        {
            return null;
        }

        final Map<String, DriverFactory> cache = getFactories ();
        return cache.get ( typeId );
    }

    private static Map<String, DriverFactory> getFactories ()
    {
        Map<String, DriverFactory> cache = Activator.cache;
        if ( cache == null )
        {
            cache = createFactories ();
            Activator.cache = cache;
        }
        return cache;
    }

    protected static Map<String, DriverFactory> createFactories ()
    {
        final Map<String, DriverFactory> result = new HashMap<String, DriverFactory> ();

        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_DRIVER ) )
        {
            if ( !ELE_DRIVER_FACTORY.equals ( ele.getName () ) )
            {
                continue;
            }
            final String typeId = ele.getAttribute ( "typeId" );

            logger.debug ( "Found driver factory for type: {}", typeId );

            try
            {
                final DriverFactory factory = (DriverFactory)ele.createExecutableExtension ( "factoryClass" );
                if ( typeId != null && factory != null )
                {
                    result.put ( typeId, factory );
                }
            }
            catch ( final CoreException e )
            {
                getDefault ().getLog ().log ( e.getStatus () );
            }
        }

        return result;
    }

    public static Set<String> getAllDriverFactories ()
    {
        return Collections.unmodifiableSet ( getFactories ().keySet () );
    }

}
