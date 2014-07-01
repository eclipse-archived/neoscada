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
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.scada.utils.pkg.deb.ContentProvider;
import org.eclipse.scada.utils.pkg.deb.StaticContentProvider;
import org.eclipse.scada.utils.str.StringReplacer;

import com.google.common.io.CharStreams;
import com.google.common.io.InputSupplier;

public class Contents
{

    private static Pattern PATTERN = Pattern.compile ( "\\$\\$(.*?)\\$\\$" ); //$NON-NLS-1$

    public static ContentProvider createContent ( final InputStream resource, final Map<String, String> replacements, final Pattern pattern ) throws IOException
    {
        return createContent ( resource, replacements, PATTERN );
    }

    public static ContentProvider createContent ( final InputStream resource, final Map<String, String> replacements ) throws IOException
    {
        String str = CharStreams.toString ( CharStreams.newReaderSupplier ( new InputSupplier<InputStream> () {
            @Override
            public InputStream getInput () throws IOException
            {
                return resource;
            }
        }, Charset.forName ( "UTF-8" ) ) ); //$NON-NLS-1$

        str = StringReplacer.replace ( str, StringReplacer.newSource ( replacements ), PATTERN );

        return new StaticContentProvider ( str );
    }
}
