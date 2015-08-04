/*******************************************************************************
 * Copyright (c) 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.updater;

import static java.nio.file.FileVisitResult.CONTINUE;
import static org.eclipse.scada.ca.oscar.OscarLoader.loadJsonData;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.ca.oscar.OscarLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DirectoryScanner
{
    private final static Logger logger = LoggerFactory.getLogger ( DirectoryScanner.class );

    public static enum FailMode
    {
        /**
         * Fail the whole process
         */
        FAIL,
        /**
         * Ignore the file in question
         */
        IGNORE;
    }

    private final Path path;

    private final int depth;

    private final FailMode failMode;

    public DirectoryScanner ( final Path path )
    {
        this ( path, 1, FailMode.IGNORE );
    }

    public DirectoryScanner ( final Path path, final int depth, final FailMode failMode )
    {
        this.path = path;
        this.depth = depth;
        this.failMode = failMode;
    }

    public Map<String, Map<String, Map<String, String>>> scan () throws IOException
    {
        final Map<String, Map<String, Map<String, String>>> result = new HashMap<> ();

        final FileVisitor<Path> visitor = new SimpleFileVisitor<Path> () {
            @Override
            public FileVisitResult visitFile ( final Path file, final BasicFileAttributes attrs ) throws IOException
            {
                final int entries = loadFile ( file, result );
                logger.info ( "Added file: {} - {} entries", file, entries );
                return CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed ( final Path file, final IOException exc ) throws IOException
            {
                logger.warn ( "Failed to read file: " + file, exc );
                switch ( DirectoryScanner.this.failMode )
                {
                    case FAIL:
                        throw exc;
                    case IGNORE:
                        break; // CONTINUE
                }
                return CONTINUE;
            }
        };

        Files.walkFileTree ( this.path, Collections.singleton ( FileVisitOption.FOLLOW_LINKS ), this.depth, visitor );

        return result;
    }

    protected int loadFile ( final Path file, final Map<String, Map<String, Map<String, String>>> result ) throws IOException
    {
        try ( Reader reader = Files.newBufferedReader ( file, StandardCharsets.UTF_8 ) )
        {
            final Map<String, Map<String, Map<String, String>>> data = loadJsonData ( reader );
            return OscarLoader.putAll ( result, data );
        }
    }
}
