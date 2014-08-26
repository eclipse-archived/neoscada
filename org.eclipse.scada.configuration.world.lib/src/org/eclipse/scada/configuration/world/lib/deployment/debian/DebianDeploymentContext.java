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
package org.eclipse.scada.configuration.world.lib.deployment.debian;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.configuration.world.lib.deployment.DeploymentContext;
import org.eclipse.scada.configuration.world.lib.deployment.FileOptions;
import org.eclipse.scada.utils.pkg.deb.DebianPackageWriter;
import org.eclipse.scada.utils.pkg.deb.EntryInformation;

import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;

public class DebianDeploymentContext implements DeploymentContext
{
    private final Set<String> dependencies = new HashSet<> ();

    private final StringBuilder postInstallation = new StringBuilder ();

    private final Map<String, File> tempFiles = new HashMap<> ();

    private final Map<String, EntryInformation> tempFilesOptions = new HashMap<> ();

    @Override
    public void addInstallDependency ( final String packageName )
    {
        this.dependencies.add ( packageName );
    }

    @Override
    public void addPostInstallationScript ( final Reader reader ) throws IOException
    {
        try
        {
            CharStreams.copy ( reader, this.postInstallation );
        }
        finally
        {
            reader.close ();
        }
    }

    @Override
    public void runAfterInstallation ( final String script )
    {
        this.postInstallation.append ( "if test \"$1\" = configure ; then\n" );
        this.postInstallation.append ( script );
        this.postInstallation.append ( "\nfi\n" );
    }

    @Override
    public void addFile ( final InputStream resource, final String targetFile, final FileOptions... options ) throws IOException
    {
        try
        {
            final File tmp = Files.createTempFile ( "data", "" ).toFile ();
            final File old = this.tempFiles.put ( targetFile, tmp );
            if ( old != null )
            {
                old.delete ();
            }
            try ( BufferedOutputStream os = new BufferedOutputStream ( new FileOutputStream ( tmp ) ) )
            {
                ByteStreams.copy ( resource, os );
            }

            EntryInformation ei = null;

            for ( final FileOptions option : options )
            {
                switch ( option )
                {
                    case CONFIGURATION:
                        ei = EntryInformation.DEFAULT_FILE_CONF;
                        break;
                }
            }
            if ( ei != null )
            {
                this.tempFilesOptions.put ( targetFile, ei );
            }
        }
        finally
        {
            resource.close ();
        }
    }

    public Set<String> getDependencies ()
    {
        return this.dependencies;
    }

    public String getPostInstallationString ()
    {
        return this.postInstallation.toString ();
    }

    public void scoopFiles ( final DebianPackageWriter deb ) throws IOException
    {
        for ( final Map.Entry<String, File> entry : this.tempFiles.entrySet () )
        {
            deb.addFile ( entry.getValue (), entry.getKey (), this.tempFilesOptions.get ( entry.getKey () ) );
            entry.getValue ().delete ();
        }
    }
}