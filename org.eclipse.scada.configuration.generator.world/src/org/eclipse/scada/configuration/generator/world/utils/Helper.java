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
package org.eclipse.scada.configuration.generator.world.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.utils.str.StringReplacer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;
import com.google.common.io.InputSupplier;

public class Helper
{
    private final static Logger logger = LoggerFactory.getLogger ( Helper.class );

    private static Pattern PATTERN = Pattern.compile ( "\\$\\$(.*?)\\$\\$" );

    public static void createFile ( final File file, final InputStream resource, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        createFile ( file, resource, replacements, monitor, PATTERN );
    }

    public static void createFile ( final File file, final InputStream resource, final Map<String, String> replacements, final IProgressMonitor monitor, final Pattern pattern ) throws Exception
    {
        String str = CharStreams.toString ( CharStreams.newReaderSupplier ( new InputSupplier<InputStream> () {
            @Override
            public InputStream getInput () throws IOException
            {
                return resource;
            }
        }, Charset.forName ( "UTF-8" ) ) );

        str = StringReplacer.replace ( str, StringReplacer.newSource ( replacements ), pattern );

        createFile ( file, str, monitor );
    }

    public static void createFile ( final File file, final InputStream resource, final IProgressMonitor monitor, final boolean exec ) throws Exception
    {
        file.getParentFile ().mkdirs ();

        try
        {
            try (FileOutputStream fos = new FileOutputStream ( file ))
            {
                ByteStreams.copy ( resource, fos );
            }
            file.setExecutable ( exec );
        }
        finally
        {
            resource.close ();
        }
    }

    public static void createFile ( final File file, final String data, final IProgressMonitor monitor ) throws Exception
    {
        logger.debug ( "Writing string data file: {}", file );

        file.getParentFile ().mkdirs ();

        Files.write ( data, file, Charset.forName ( "UTF-8" ) );
    }
}
