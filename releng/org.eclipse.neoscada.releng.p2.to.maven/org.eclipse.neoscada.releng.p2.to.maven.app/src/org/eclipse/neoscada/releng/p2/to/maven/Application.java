/*******************************************************************************
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     Red Hat Inc - enhancements
 *******************************************************************************/
package org.eclipse.neoscada.releng.p2.to.maven;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;

public class Application implements IApplication
{

    @Override
    public Object start ( final IApplicationContext context ) throws Exception
    {
        // final IProgressMonitor pm = new ConsoleProgressMonitor ( new PrintWriter ( System.out ) );
        final IProgressMonitor pm = new NullProgressMonitor ();

        Bundle bb = context.getBrandingBundle ();
        if ( bb == null )
        {
            Version version = Activator.getDefault ().getContext ().getBundle ().getVersion ();
            System.out.println ( "no branding found, using version from bundle" );
            System.out.format ( "P2 to Maven 2 converter - Version: %s%n", version );
        }
        else
        {
            final Version version = context.getBrandingBundle ().getVersion ();
            System.out.format ( "P2 to Maven 2 converter - Version: %s%n", version );
        }

        final String[] args = (String[])context.getArguments ().get ( IApplicationContext.APPLICATION_ARGS );

        if ( args.length < 2 )
        {
            System.err.println ( "p2tom2 <config.properties> <sourceRepositoryUri> [<validationRepoUri1>] ..." );
            return null;
        }

        final URL propertiesLocation = new URL ( args[0] );
        final Properties lp = new Properties ();
        try ( InputStream input = propertiesLocation.openStream () )
        {
            lp.load ( input );
        }

        final Properties p = new Properties ( lp );
        p.putAll ( System.getProperties () );

        final File output = new File ( p.getProperty ( "path.output" ) );
        output.mkdirs ();

        final File p2temp = new File ( p.getProperty ( "path.p2temp", p.getProperty ( "path.output" ) ) );
        p2temp.mkdirs ();

        System.out.format ( "Getting P2 agent: %s%n", p2temp );

        final IProvisioningAgent agent = Activator.getAgent ( p2temp.toURI () );

        try ( Processor processor = new Processor ( agent, output, new URI ( args[1] ), p ) )
        {
            for ( int i = 2; i < args.length; i++ )
            {
                processor.addValidationRepository ( new URI ( args[i] ) );
            }

            processor.process ( pm );

            System.out.println ( "=== START - MAVEN EXPORTS ===" );
            processor.getMavenExports ().stream ().forEach ( System.out::println );
            System.out.println ( "===  END  - MAVEN EXPORTS ===" );

            System.out.println ( "=== START - MAVEN EXTERNAL DEPENDENCIES ===" );
            final Set<MavenDependency> deps = new LinkedHashSet<> ( processor.getMavenDependencies () );
            processor.getMavenExports ().stream ().filter ( ref -> ref.getClassifier () == null ).map ( ref -> new MavenDependency ( ref.getGroupId (), ref.getArtifactId (), ref.getVersion (), false ) ).forEach ( deps::remove );
            deps.stream ().forEach ( System.out::println );
            System.out.println ( "===  END  - MAVEN EXTERNAL DEPENDENCIES ===" );

            final List<String> errors = processor.getErrors ();
            if ( !errors.isEmpty () )
            {
                System.out.println ( "=== START - ERRORS ===" );
                errors.stream ().forEach ( System.out::println );
                System.out.println ( "===  END  - ERRORS ===" );
            }

            if ( !errors.isEmpty () )
            {
                System.out.println ( "Exiting with validation errors!" );
                return 1;
            }
        }

        // default
        return null;
    }

    @Override
    public void stop ()
    {
    }

}
