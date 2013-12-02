/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.lib.utils;

import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyRecursive extends SimpleFileVisitor<Path>
{
    private final Path source;

    private final Path target;

    public CopyRecursive ( final Path source, final Path target )
    {
        this.source = source;
        this.target = target;
    }

    @Override
    public FileVisitResult preVisitDirectory ( final Path dir, final BasicFileAttributes attrs )
    {
        final Path newdir = this.target.resolve ( this.source.relativize ( dir ) );
        try
        {
            Files.copy ( dir, newdir, new CopyOption[] { COPY_ATTRIBUTES } );
        }
        catch ( final Exception e )
        {
            throw new RuntimeException ( e );
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile ( final Path file, final BasicFileAttributes attrs )
    {
        try
        {
            Files.copy ( file, this.target.resolve ( this.source.relativize ( file ) ), new CopyOption[] { COPY_ATTRIBUTES, REPLACE_EXISTING } );
        }
        catch ( final IOException e )
        {
            throw new RuntimeException ( e );
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory ( final Path dir, final IOException exc )
    {
        if ( exc == null )
        {
            final Path newdir = this.target.resolve ( this.source.relativize ( dir ) );
            try
            {
                Files.setLastModifiedTime ( newdir, Files.getLastModifiedTime ( dir ) );
            }
            catch ( final IOException e )
            {
                throw new RuntimeException ( e );
            }
        }
        return CONTINUE;
    }

}