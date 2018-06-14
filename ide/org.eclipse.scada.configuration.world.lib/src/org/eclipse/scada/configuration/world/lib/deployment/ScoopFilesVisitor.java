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

import org.eclipse.packagedrone.utils.deb.build.FileContentProvider;
import org.eclipse.packagedrone.utils.deb.build.TextFileContentProvider;
import org.eclipse.scada.configuration.world.lib.utils.Constants;

public class ScoopFilesVisitor extends SimpleFileVisitor<Path>
{
    private final Path baseDir;

    private final DeploymentContext context;

    private final String targetPrefix;

    private Set<String> ignorePrefix = new HashSet<> ();

    private Set<String> execPrefix = new HashSet<> ();

    private Set<String> confPrefix = new HashSet<> ();

    public ScoopFilesVisitor ( final Path baseDir, final DeploymentContext context, final String targetPrefix )
    {
        this.baseDir = baseDir;
        this.context = context;
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

        if ( exec )
        {
            this.context.addFile ( new FileContentProvider ( file.toFile () ), name, new FileInformation ( 0755, "root", "root" ) );
        }
        else if ( conf )
        {
            this.context.addFile ( new TextFileContentProvider ( file.toFile () ), name, new FileInformation ( 0644, "root", Constants.NEOSCADA_USER, FileOptions.CONFIGURATION ) );
        }
        else
        {
            this.context.addFile ( new FileContentProvider ( file.toFile () ), name, null );
        }

        return FileVisitResult.CONTINUE;
    }
}