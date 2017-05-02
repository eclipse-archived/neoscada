/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.common.lib;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import com.google.common.io.Resources;

final class Helper
{
    private Helper ()
    {
    }

    static String loadResource ( final String resourceName )
    {
        final URL updateUrl = Resources.getResource ( Helper.class, resourceName );
        try
        {
            return Resources.toString ( updateUrl, Charset.forName ( "UTF-8" ) );
        }
        catch ( final IOException e )
        {
            throw new RuntimeException ( String.format ( "Unable to load '%s'", resourceName ), e );
        }
    }
}
