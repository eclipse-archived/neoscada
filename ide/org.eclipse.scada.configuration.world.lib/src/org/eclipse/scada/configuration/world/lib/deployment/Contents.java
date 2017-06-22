/*******************************************************************************
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH and others.
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
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.packagedrone.utils.deb.build.ContentProvider;
import org.eclipse.packagedrone.utils.deb.build.StaticContentProvider;
import org.eclipse.scada.utils.str.StringReplacer;

import com.google.common.io.CharStreams;

public class Contents
{
    private static final Pattern PATTERN = Pattern.compile ( "\\$\\$(.*?)\\$\\$" ); //$NON-NLS-1$

    public static ContentProvider createContent ( final InputStream resource, final Map<String, String> replacements, final Pattern pattern ) throws IOException
    {
        try
        {
            String str = CharStreams.toString ( new InputStreamReader ( resource, StandardCharsets.UTF_8 ) );

            str = StringReplacer.replace ( str, StringReplacer.newSource ( replacements ), pattern );

            return new StaticContentProvider ( str );
        }
        finally
        {
            resource.close ();
        }
    }

    public static ContentProvider createContent ( final InputStream resource, final Map<String, String> replacements ) throws IOException
    {
        return createContent ( resource, replacements, PATTERN );
    }
}
