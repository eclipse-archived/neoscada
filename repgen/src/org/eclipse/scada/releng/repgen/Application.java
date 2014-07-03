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

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Pattern;

public class Application
{
    public static void main ( final String[] args ) throws Exception
    {
        final String release = getProperty ( "release" );
        final String buildTypeShort = getProperty ( "buildTypeShort" );
        final String buildTypeLong = getProperty ( "buildTypeLong" );
        final Pattern releasePattern = Pattern.compile ( Pattern.quote ( release ) + "\\..*" ); // e.g. "0.2.*"

        final String projectPrefix = getProperty ( "downloads.project.prefix" );
        final File downloadsBase = new File ( new File ( getProperty ( "downloads.base" ) ), projectPrefix );
        final File drops = new File ( downloadsBase, getProperty ( "drops.dir" ) );

        final String updatesDir = String.format ( "%s/%s/%s", getProperty ( "updates.prefix" ), buildTypeLong, release );
        final File updates = new File ( downloadsBase, updatesDir );

        System.out.format ( "Release: %s%n", release );
        System.out.format ( "Build Type: %s / %s%n", buildTypeShort, buildTypeLong );
        System.out.format ( "Release Pattern: %s%n", releasePattern.pattern () );
        System.out.format ( "Drops(src): %s%n", drops );
        System.out.format ( "Updates(dest): %s%n", updates );

        if ( !drops.isDirectory () )
        {
            throw new IllegalStateException ( String.format ( "Drops directory '%s' does not exist", drops ) );
        }

        if ( !updates.getParentFile ().isDirectory () )
        {
            throw new IllegalStateException ( String.format ( "Parent of target directory '%s' does not exist", updates ) );
        }

        if ( updates.exists () )
        {
            deleteRecursive ( updates );
        }
        else
        {
            updates.mkdirs ();
        }

        final CompositeBuilder builder = new CompositeBuilder ( "Eclipse SCADA" );

        builder.setProperty ( "p2.mirrorsURL", String.format ( "http://www.eclipse.org/downloads/download.php?file=%s&amp;protocol=http&amp;format=xml", projectPrefix + updatesDir ) );

        for ( final File drop : drops.listFiles () )
        {
            System.out.println ( "Checking drop: " + drop );
            if ( !releasePattern.matcher ( drop.getName () ).matches () )
            {
                continue;
            }
            for ( final File v : drop.listFiles () )
            {
                if ( !v.getName ().startsWith ( buildTypeShort ) )
                {
                    continue;
                }
                final File dir = new File ( v, "p2" );
                if ( isRepo ( dir ) )
                {
                    System.out.println ( "     Add drop: " + v );
                    builder.addRepository ( dir );
                }
            }

        }

        builder.build ( updates );
    }

    private static void deleteRecursive ( final File updates ) throws IOException
    {
        System.out.println ( "Deleting: " + updates );

        final FileVisitor<? super Path> visitor = new SimpleFileVisitor<Path> () {
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
        };

        Files.walkFileTree ( updates.toPath (), visitor );
    }

    private static boolean isRepo ( final File dir )
    {
        return new File ( dir, "p2.index" ).isFile ();
    }

    private static String getProperty ( final String string )
    {
        final String value = System.getProperty ( string );
        if ( value == null || value.isEmpty () )
        {
            throw new IllegalStateException ( String.format ( "System property '%s' is not set", string ) );
        }

        return value;
    }
}
