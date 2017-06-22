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
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.world.lib.deployment.CommonPackageDeploymentContext;
import org.eclipse.scada.configuration.world.lib.deployment.FileInformation;
import org.eclipse.scada.configuration.world.lib.deployment.FileOptions;
import org.eclipse.packagedrone.utils.deb.build.ContentProvider;
import org.eclipse.packagedrone.utils.deb.build.DebianPackageWriter;
import org.eclipse.packagedrone.utils.deb.build.EntryInformation;

import com.google.common.io.ByteStreams;

public class DebianDeploymentContext extends CommonPackageDeploymentContext
{
    private final Map<String, EntryInformation> tempFilesOptions = new HashMap<> ();

    private final Map<String, File> tempFiles = new HashMap<> ();

    public DebianDeploymentContext ( final String packageName )
    {
        super ( packageName );
    }

    @Override
    public void runAfterInstallation ( final String script )
    {
        this.postInstallation.append ( '\n' );
        this.postInstallation.append ( "if test \"$1\" = configure ; then\n" );
        this.postInstallation.append ( script );
        this.postInstallation.append ( "\nfi\n" );
    }

    @Override
    public void runAfterRemoval ( final String script )
    {
        this.postRemoval.append ( '\n' );
        this.postRemoval.append ( "case \"$1\" in\n" );
        this.postRemoval.append ( "\tremove|purge)\n" );
        this.postRemoval.append ( script );
        this.postRemoval.append ( "\n\t;;\n" );
        this.postRemoval.append ( "\nesac\n" );
    }

    public void scoopFiles ( final DebianPackageWriter deb ) throws IOException
    {
        for ( final Map.Entry<String, File> entry : this.tempFiles.entrySet () )
        {
            deb.addFile ( entry.getValue (), entry.getKey (), this.tempFilesOptions.get ( entry.getKey () ) );
        }
        deleteTempFiles ();
    }

    protected void deleteTempFiles ()
    {
        for ( final Map.Entry<String, File> entry : this.tempFiles.entrySet () )
        {
            entry.getValue ().delete ();
        }
    }

    @Override
    public void addDirectory ( final String targetDirectory, final FileInformation fileInformation )
    {
    }

    @Override
    public void addFile ( final ContentProvider content, final String targetFile, final FileInformation fileInformation ) throws IOException
    {
        try ( InputStream resource = content.createInputStream () )
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
        }

        if ( fileInformation != null )
        {
            boolean conf = false;

            for ( final FileOptions option : fileInformation.getOptions () )
            {
                switch ( option )
                {
                    case CONFIGURATION:
                        conf = true;
                        break;
                }
            }

            final EntryInformation ei = new EntryInformation ( fileInformation.getOwner (), fileInformation.getGroup (), fileInformation.getMode (), conf );

            this.tempFilesOptions.put ( targetFile, ei );
        }
    }
}
