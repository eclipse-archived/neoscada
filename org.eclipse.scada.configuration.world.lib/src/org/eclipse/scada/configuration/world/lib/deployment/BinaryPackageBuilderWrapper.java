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
package org.eclipse.scada.configuration.world.lib.deployment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.scada.utils.pkg.deb.BinaryPackageBuilder;
import org.eclipse.scada.utils.pkg.deb.ContentProvider;
import org.eclipse.scada.utils.pkg.deb.EntryInformation;

import com.google.common.io.ByteStreams;

public class BinaryPackageBuilderWrapper implements BinaryPackageBuilder
{

    private final File folder;

    public BinaryPackageBuilderWrapper ( final File folder )
    {
        this.folder = folder;
    }

    @Override
    public void addFile ( final ContentProvider contentProvider, final String fileName, EntryInformation entryInformation ) throws IOException
    {
        if ( entryInformation == null )
        {
            entryInformation = EntryInformation.DEFAULT_FILE;
        }

        final File file = new File ( this.folder, fileName );
        file.getParentFile ().mkdirs ();
        try ( InputStream is = contentProvider.createInputStream ();
                OutputStream os = new FileOutputStream ( file ) )
                {
            ByteStreams.copy ( is, os );
            if ( ( entryInformation.getMode () & 0444 ) > 0 )
            {
                file.setExecutable ( true );
            }
                }
    }

    @Override
    public void addDirectory ( final String directory, final EntryInformation entryInformation ) throws IOException
    {
    }

}
