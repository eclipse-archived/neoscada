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
package org.eclipse.scada.configuration.world.lib.deployment.redhat;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.world.lib.deployment.CommonPackageDeploymentContext;
import org.eclipse.scada.configuration.world.lib.deployment.FileInformation;
import org.eclipse.packagedrone.utils.deb.build.ContentProvider;

import com.google.common.io.ByteStreams;

public class RedhatDeploymentContext extends CommonPackageDeploymentContext
{
    private final File tempBase;

    private final Map<String, FileInformation> tempInformationMap = new HashMap<> ();

    private final Map<String, FileInformation> directories = new HashMap<> ();

    public RedhatDeploymentContext ( final File tempBase, final String packageName )
    {
        super ( packageName );
        this.tempBase = tempBase;
    }

    public Map<String, FileInformation> getDirectories ()
    {
        return this.directories;
    }

    @Override
    public void addDirectory ( final String targetDirectory, final FileInformation fileInformation )
    {
        this.directories.put ( targetDirectory, fileInformation );
    }

    @Override
    public void addFile ( final ContentProvider content, final String targetFile, final FileInformation fileInformation ) throws IOException
    {
        try ( InputStream resource = content.createInputStream () )
        {
            final File file = new File ( this.tempBase, targetFile );
            file.getParentFile ().mkdirs ();
            try ( BufferedOutputStream to = new BufferedOutputStream ( new FileOutputStream ( file ) ) )
            {
                ByteStreams.copy ( resource, to );
            }
        }

        this.tempInformationMap.put ( targetFile, fileInformation );
    }

    public Map<String, FileInformation> getFiles ()
    {
        return this.tempInformationMap;
    }

    @Override
    public void runAfterInstallation ( final String script )
    {
        this.postInstallation.append ( '\n' );
        this.postInstallation.append ( script );
        this.postInstallation.append ( '\n' );
    }

    @Override
    public void runAfterRemoval ( final String script )
    {
        this.postRemoval.append ( '\n' );
        this.postRemoval.append ( "if [ $1 -eq 0 ]; then\n" );
        this.postRemoval.append ( script );
        this.postRemoval.append ( "\nfi\n" );
    }
}
