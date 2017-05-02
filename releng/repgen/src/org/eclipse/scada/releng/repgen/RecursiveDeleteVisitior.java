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
package org.eclipse.scada.releng.repgen;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public final class RecursiveDeleteVisitior extends SimpleFileVisitor<Path>
{
    @Override
    public FileVisitResult visitFile ( final Path file, final BasicFileAttributes attrs ) throws IOException
    {
        System.out.println ( "Delete file: " + file );
        Files.delete ( file );
        return super.visitFile ( file, attrs );
    }

    @Override
    public FileVisitResult postVisitDirectory ( final Path dir, final IOException exc ) throws IOException
    {
        System.out.println ( "Delete dir:  " + dir );
        Files.delete ( dir );
        return super.postVisitDirectory ( dir, exc );
    }
}