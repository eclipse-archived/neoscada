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
package org.eclipse.scada.utils.osgi.autostart;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.startlevel.BundleStartLevel;
import org.osgi.framework.startlevel.FrameworkStartLevel;
import org.osgi.service.log.LogService;

public class Activator implements BundleActivator
{
    private BundleContext context;

    private int defaultStartLevel = 4;

    private final Map<String, Integer> bundleStartList = new LinkedHashMap<String, Integer> ();

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext bundleContext ) throws Exception
    {
        this.context = bundleContext;

        final ServiceReference<FrameworkStartLevel> frameworkStartLevel = this.context.getServiceReference ( FrameworkStartLevel.class );
        if ( frameworkStartLevel != null )
        {
            final FrameworkStartLevel service = this.context.getService ( frameworkStartLevel );
            if ( service != null )
            {
                try
                {
                    this.defaultStartLevel = service.getInitialBundleStartLevel ();
                }
                finally
                {
                    this.context.ungetService ( frameworkStartLevel );
                }
            }
        }

        loadStartLevels ();

        for ( final Map.Entry<String, Integer> entry : this.bundleStartList.entrySet () )
        {
            setStartLevel ( entry.getKey (), entry.getValue () );
        }
    }

    protected void log ( final int level, final String message )
    {
        final BundleContext context = this.context;
        if ( context == null )
        {
            return;
        }

        final ServiceReference<LogService> ref = context.getServiceReference ( LogService.class );
        if ( ref == null )
        {
            return;
        }

        final LogService service = context.getService ( ref );
        if ( service == null )
        {
            return;
        }

        try
        {
            service.log ( level, message );
        }
        finally
        {
            context.ungetService ( ref );
        }
    }

    protected void loadStartLevels () throws IOException
    {
        final String fileName = System.getProperty ( "org.eclipse.scada.utils.osgi.autostart.file", null );

        log ( LogService.LOG_INFO, String.format ( "Loading start bundles from: %s", fileName ) );

        this.bundleStartList.clear ();

        if ( fileName == null )
        {
            return;
        }

        final File file = new File ( fileName );
        final Properties p = new Properties ();
        final FileReader reader = new FileReader ( file );
        try
        {
            p.load ( reader );
        }
        finally
        {
            reader.close ();
        }

        for ( final String key : p.stringPropertyNames () )
        {
            final String value = p.getProperty ( key );
            this.bundleStartList.put ( key, Integer.parseInt ( value ) );
        }
    }

    private void setStartLevel ( final String symbolicName, final int startLevel ) throws BundleException
    {
        final Bundle bundle = findBundle ( symbolicName );
        if ( bundle == null )
        {
            return;
        }
        final BundleStartLevel bundleStartLevel = bundle.adapt ( BundleStartLevel.class );
        if ( bundleStartLevel == null )
        {
            return;
        }

        bundleStartLevel.setStartLevel ( startLevel < 0 ? this.defaultStartLevel : startLevel );
        bundle.start ();
    }

    private Bundle findBundle ( final String symbolicName )
    {
        final Bundle[] bundles = this.context.getBundles ();
        if ( bundles == null )
        {
            return null;
        }

        for ( final Bundle bundle : bundles )
        {
            if ( bundle.getSymbolicName ().equals ( symbolicName ) )
            {
                return bundle;
            }
        }

        return null;
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        this.context = null;
    }

}
