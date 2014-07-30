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

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.scada.utils.pkg.deb.BinaryPackageBuilder;
import org.eclipse.scada.utils.pkg.deb.EntryInformation;
import org.eclipse.scada.utils.pkg.deb.FileContentProvider;

public class ScoopFilesVisitor extends SimpleFileVisitor<Path>
{
    private final Path baseDir;

    private final BinaryPackageBuilder builder;

    private final String targetPrefix;

    private Set<String> ignorePrefix = new HashSet<> ();

    private Set<String> execPrefix = new HashSet<> ();

    private Set<String> confPrefix = new HashSet<> ();

    public ScoopFilesVisitor ( final Path baseDir, final BinaryPackageBuilder builder, final String targetPrefix )
    {
        this.baseDir = baseDir;
        this.builder = builder;
        this.targetPrefix = targetPrefix;

        this.execPrefix.add ( "/bin" );
        this.execPrefix.add ( "/usr/bin" );
        this.execPrefix.add ( "/usr/local/bin" );
        this.execPrefix.add ( "/sbin" );
        this.execPrefix.add ( "/usr/sbin" );
        this.execPrefix.add ( "/usr/local/sbin" );

        this.confPrefix.add ( "/etc" );
    }

    public void setIgnorePrefix ( final Set<String> ignorePrefix )
    {
        this.ignorePrefix = ignorePrefix;
    }

    public Set<String> getIgnorePrefix ()
    {
        return this.ignorePrefix;
    }

    public void setExecPrefix ( final Set<String> execPrefix )
    {
        this.execPrefix = execPrefix;
    }

    public Set<String> getExecPrefix ()
    {
        return this.execPrefix;
    }

    public void setConfPrefix ( final Set<String> confPrefix )
    {
        this.confPrefix = confPrefix;
    }

    public Set<String> getConfPrefix ()
    {
        return this.confPrefix;
    }

    @Override
    public FileVisitResult visitFile ( final Path file, final BasicFileAttributes attrs ) throws IOException
    {
        final Path targetPath;
        if ( this.targetPrefix != null )
        {
            targetPath = Paths.get ( URI.create ( "file:" + this.targetPrefix + "/" + this.baseDir.relativize ( file ) ) );
        }
        else
        {
            targetPath = this.baseDir.relativize ( file );
        }

        String name = targetPath.toString ().replace ( '\\', '/' );
        if ( !name.startsWith ( "/" ) )
        {
            name = "/" + name;
        }

        boolean exec = Executables.getExecutable ( file );
        boolean conf = false;

        for ( final String prefix : this.ignorePrefix )
        {
            if ( name.startsWith ( prefix ) )
            {
                return FileVisitResult.CONTINUE;
            }
        }

        for ( final String prefix : this.execPrefix )
        {
            if ( name.startsWith ( prefix ) )
            {
                exec = true;
            }
        }
        for ( final String prefix : this.confPrefix )
        {
            if ( name.startsWith ( prefix ) )
            {
                conf = true;
            }
        }

        final EntryInformation entry = new EntryInformation ( "root", "root", 0644 | ( exec ? 0111 : 0 ), conf );

        this.builder.addFile ( new FileContentProvider ( file.toFile () ), name, entry );

        return FileVisitResult.CONTINUE;
    }
}