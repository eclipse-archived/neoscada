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
package org.eclipse.scada.configuration.generator.world.internal;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.scada.configuration.generator.world.oscar.OscarProcessor;
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
    public static final String PLUGIN_ID = "org.eclipse.scada.configuration.generator.world"; //$NON-NLS-1$

    public static final String EXTP_GENERATOR = PLUGIN_ID + ".generator"; //$NON-NLS-1$

    public static final String ELE_OSCAR_PROCESSOR = "oscarProcessor"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;

    /**
     * The constructor
     */
    public Activator ()
    {
    }

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        super.start ( context );
        plugin = this;
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        plugin = null;
        super.stop ( context );
    }

    public static Collection<OscarProcessor> createProcessors ()
    {
        final Collection<OscarProcessor> result = new LinkedList<> ();
        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_GENERATOR ) )
        {
            if ( !ele.getName ().equals ( ELE_OSCAR_PROCESSOR ) )
            {
                continue;
            }
            try
            {
                result.add ( (OscarProcessor)ele.createExecutableExtension ( "class" ) );
            }
            catch ( final CoreException e )
            {
                logger.warn ( "Failed to create oscar processor", e );
                getDefault ().getLog ().log ( e.getStatus () );
            }
        }
        return result;
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

}
