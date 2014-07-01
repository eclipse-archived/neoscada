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
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public final class Executables
{
    private static final Charset CHARSET = Charset.defaultCharset ();

    private static final String ATTR_EXECUTE = "user.execute";

    private static byte[] marker = "true".getBytes ( CHARSET );

    private Executables ()
    {
    }

    public static void setExecutable ( final File file, final boolean state ) throws IOException
    {
        setExecutable ( file.toPath (), state );
    }

    public static boolean getExecutable ( final File file ) throws IOException
    {
        return getExecutable ( file.toPath () );
    }

    public static void setExecutable ( final Path path, final boolean state ) throws IOException
    {
        final UserDefinedFileAttributeView ua = Files.getFileAttributeView ( path, UserDefinedFileAttributeView.class );
        if ( state )
        {
            ua.write ( ATTR_EXECUTE, ByteBuffer.wrap ( marker ) );
        }
        else
        {
            ua.delete ( ATTR_EXECUTE );
        }
    }

    public static boolean getExecutable ( final Path path ) throws IOException
    {
        final UserDefinedFileAttributeView ua = Files.getFileAttributeView ( path, UserDefinedFileAttributeView.class );

        if ( !ua.list ().contains ( ATTR_EXECUTE ) )
        {
            // check first, otherwise the size() call with give an exception
            return false;
        }

        final ByteBuffer buf = ByteBuffer.allocate ( ua.size ( ATTR_EXECUTE ) );
        ua.read ( ATTR_EXECUTE, buf );
        buf.flip ();
        return Boolean.parseBoolean ( CHARSET.decode ( buf ).toString () );
    }
}
