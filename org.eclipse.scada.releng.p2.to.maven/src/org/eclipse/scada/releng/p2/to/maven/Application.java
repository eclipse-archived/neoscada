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
package org.eclipse.scada.releng.p2.to.maven;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.equinox.p2.core.IProvisioningAgent;

public class Application implements IApplication
{

    @Override
    public Object start ( final IApplicationContext context ) throws Exception
    {
        // final IProgressMonitor pm = new ConsoleProgressMonitor ( new PrintWriter ( System.out ) );
        final IProgressMonitor pm = new NullProgressMonitor ();

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

        final IProvisioningAgent agent = Activator.getAgent ( p2temp.toURI () );

        final Processor processor = new Processor ( agent, output, new URI ( args[1] ), p );

        for ( int i = 2; i < args.length; i++ )
        {
            processor.addValidationRepository ( new URI ( args[i] ) );
        }

        processor.process ( pm );

        // default
        return null;
    }

    @Override
    public void stop ()
    {
    }

}
