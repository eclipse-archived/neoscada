/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.osgi.daemon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;

import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.Version;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;
import org.osgi.framework.startlevel.BundleStartLevel;

public class Starter
{

    private static final String PROP_OSGI_INSTALL_AREA = "osgi.install.area";

    private static final String FILE_PROTO = "file:";

    private static final String PATTERN_BUNDLES_SPLITTER = ", *";

    private static final String PROP_OSGI_BUNDLES = "osgi.bundles";

    private Framework framework;

    private File bundleRoot;

    private HashMap<String, String> properties;

    private boolean debug;

    private boolean started;

    private Formatter logger;

    public void start ( final String[] args ) throws Exception
    {
        if ( this.started )
        {
            return;
        }
        this.started = true;

        this.debug = Boolean.getBoolean ( "org.eclipse.scada.utils.osgi.daemon.debug" ); //$NON-NLS-1$
        if ( this.debug )
        {
            this.logger = new Formatter ( System.out );
        }

        final ServiceLoader<FrameworkFactory> loader = ServiceLoader.load ( FrameworkFactory.class );
        final Iterator<FrameworkFactory> i = loader.iterator ();
        if ( !i.hasNext () )
        {
            throw new IllegalStateException ( "No FrameworkFactory found!" );
        }

        final FrameworkFactory factory = i.next ();

        this.properties = new HashMap<String, String> ();

        for ( final String arg : args )
        {
            final String[] toks = arg.split ( "=", 2 );
            if ( toks.length >= 2 )
            {
                this.properties.put ( toks[0], toks[1] );
            }
            else
            {
                this.properties.put ( toks[0], null );
            }
        }

        this.properties.put ( Constants.FRAMEWORK_BEGINNING_STARTLEVEL, "4" );

        this.framework = factory.newFramework ( this.properties );

        this.framework.init ();

        try
        {
            loadStartBundles ( this.framework, this.properties );
        }
        catch ( final Exception e )
        {
            this.framework.stop ();
            throw e;
        }

        this.framework.start ();
    }

    private static String NL = System.getProperty ( "line.separator", "\n" );

    protected void log ( final String format, final Throwable e, final Object... args )
    {
        if ( this.logger != null )
        {
            this.logger.format ( format + NL, args );
            e.printStackTrace ( System.out );
        }
    }

    protected void log ( final String format, final Object... args )
    {
        if ( this.logger != null )
        {
            this.logger.format ( format + NL, args );
        }
    }

    public void stop () throws Exception
    {
        if ( this.started )
        {
            this.framework.stop ();
            this.framework.waitForStop ( 0 );
            this.started = false;
        }
    }

    private String getProperty ( final String key )
    {
        final String value = this.properties.get ( key );
        if ( value != null )
        {
            return value;
        }
        return System.getProperty ( key );
    }

    private void loadStartBundles ( final Framework framework, final Map<String, String> properties )
    {
        final String bundles = getProperty ( PROP_OSGI_BUNDLES );
        if ( bundles == null || bundles.isEmpty () )
        {
            return;
        }

        final Map<String, Bundle> best = getBestBundles ( findRoot () );
        for ( final String bundle : bundles.split ( PATTERN_BUNDLES_SPLITTER ) )
        {
            processBundle ( framework, bundle, best );
        }
    }

    private File findRoot ()
    {
        if ( this.bundleRoot != null )
        {
            return this.bundleRoot;
        }

        this.bundleRoot = makeRoot ();

        if ( this.bundleRoot == null )
        {
            throw new IllegalStateException ( String.format ( "Unable to determine bundle root. Specify '%s' manually.", PROP_OSGI_INSTALL_AREA ) );
        }

        log ( "Bundle root: %s", this.bundleRoot );

        return this.bundleRoot;
    }

    private File makeRoot ()
    {
        String installArea = getProperty ( PROP_OSGI_INSTALL_AREA );
        if ( installArea != null && !installArea.isEmpty () )
        {
            if ( installArea.startsWith ( FILE_PROTO ) )
            {
                installArea = installArea.substring ( FILE_PROTO.length () );
            }

            File base = new File ( installArea );
            base = new File ( base, "plugins" );
            if ( base.isDirectory () )
            {
                return base;
            }
        }

        String frameworkPath = getProperty ( "osgi.framework" );
        if ( frameworkPath != null && !frameworkPath.isEmpty () )
        {
            if ( frameworkPath.startsWith ( FILE_PROTO ) )
            {
                frameworkPath = frameworkPath.substring ( FILE_PROTO.length () );
            }
            final File fw = new File ( frameworkPath.substring ( FILE_PROTO.length () ) );
            return fw.getParentFile ();
        }

        return null;
    }

    private static class Bundle
    {
        private final String symbolicName;

        private final Version version;

        private final String location;

        public Bundle ( final String symbolicName, final Version version, final String location )
        {
            this.symbolicName = symbolicName;
            this.version = version;
            this.location = location;
        }

        public String getSymbolicName ()
        {
            return this.symbolicName;
        }

        public Version getVersion ()
        {
            return this.version;
        }

        public String getLocation ()
        {
            return this.location;
        }
    }

    public Map<String, Bundle> getBestBundles ( final File root )
    {
        final Map<String, Bundle> result = new HashMap<> ();

        for ( final File file : root.listFiles () )
        {
            if ( file.isDirectory () )
            {
                final File manifest = new File ( file, "META-INF" + File.separator + "MANIFEST.MF" );
                if ( manifest.isFile () && manifest.canRead () )
                {
                    try
                    {
                        try ( FileInputStream in = new FileInputStream ( file ) )
                        {
                            final Bundle bundle = readFromManifest ( "reference:file:plugins/" + file.getName () + "/", new Manifest ( in ) );
                            if ( bundle != null )
                            {
                                addToResult ( result, bundle );
                            }
                        }
                    }
                    catch ( final Exception e )
                    {
                        log ( "Failed to check: %s", e, file );
                        // but continue
                    }
                }
            }
            if ( file.isFile () && file.getName ().endsWith ( ".jar" ) )
            {
                try
                {
                    try ( JarInputStream jis = new JarInputStream ( new FileInputStream ( file ) ) )
                    {
                        final Manifest m = jis.getManifest ();
                        final Bundle bundle = readFromManifest ( "reference:file:plugins/" + file.getName (), m );
                        if ( bundle != null )
                        {
                            addToResult ( result, bundle );
                        }
                    }
                }
                catch ( final Exception e )
                {
                    log ( "Failed to check: %s", e, file );
                    // but continue
                }
            }
        }

        return result;
    }

    private Bundle readFromManifest ( final String location, final Manifest m ) throws IOException
    {
        final Object sn = m.getMainAttributes ().getValue ( Constants.BUNDLE_SYMBOLICNAME );
        if ( ! ( sn instanceof String ) )
        {
            return null;
        }

        final Object version = m.getMainAttributes ().getValue ( Constants.BUNDLE_VERSION );
        if ( ! ( version instanceof String ) )
        {
            return null;
        }

        String symName = (String)sn;
        symName = symName.split ( ";", 2 )[0];

        return new Bundle ( symName, new Version ( (String)version ), location );
    }

    private void addToResult ( final Map<String, Bundle> result, final Bundle bundle )
    {
        final Bundle old = result.get ( bundle.getSymbolicName () );
        if ( old == null || old.getVersion ().compareTo ( bundle.getVersion () ) < 0 )
        {
            log ( "New best bundle: %s - %s", bundle.getSymbolicName (), bundle.getVersion () );
            result.put ( bundle.getSymbolicName (), bundle );
        }
    }

    private void processBundle ( final Framework framework, final String bundle, final Map<String, Bundle> best )
    {
        final String toks[] = bundle.split ( "@", 2 );
        final String sn = toks[0];

        Integer startLevel = null;
        boolean autoStart = false;

        if ( toks.length > 1 && !toks[1].isEmpty () )
        {
            final String[] toks2 = toks[1].split ( ":", 2 );
            try
            {
                if ( toks2.length > 1 )
                {
                    startLevel = Integer.parseInt ( toks2[0] );
                }
            }
            catch ( final NumberFormatException e )
            {
                // be silent
            }
            if ( toks2.length > 1 )
            {
                autoStart = "start".equals ( toks2[toks2.length - 1] );
            }
        }

        final Bundle bb = best.get ( sn );
        if ( bb == null )
        {
            log ( "Unable to find start bundle: %s", sn );
            return;
        }

        try
        {
            log ( "Initial install for %s", sn );
            org.osgi.framework.Bundle theBundle = findBundle ( bb );
            if ( theBundle == null )
            {
                theBundle = framework.getBundleContext ().installBundle ( bb.getLocation () );
            }
            if ( startLevel != null )
            {
                log ( "Setting start level: %s", startLevel );
                final BundleStartLevel bsl = theBundle.adapt ( BundleStartLevel.class );
                bsl.setStartLevel ( startLevel );
            }
            if ( autoStart )
            {
                log ( "Auto start" );
                theBundle.start ();
            }
        }
        catch ( final BundleException e )
        {
            log ( "Failed to install initial bundle: %s", e, toks[0] );
        }
    }

    private org.osgi.framework.Bundle findBundle ( final Bundle bb )
    {
        for ( final org.osgi.framework.Bundle b : this.framework.getBundleContext ().getBundles () )
        {
            if ( b.getSymbolicName ().equals ( bb.getSymbolicName () ) )
            {
                return b;
            }
        }
        return null;
    }
}
