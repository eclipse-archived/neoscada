/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.sysinfo.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils
{
    public static String[] readFile ( final File file ) throws IOException
    {
        final BufferedReader reader = new BufferedReader ( new FileReader ( file ) );
        final List<String> content = new ArrayList<String> ();

        try
        {

            String line = null;
            while ( ( line = reader.readLine () ) != null )
            {
                content.add ( line );
            }
        }
        finally
        {
            reader.close ();
        }

        return content.toArray ( new String[content.size ()] );
    }
}
