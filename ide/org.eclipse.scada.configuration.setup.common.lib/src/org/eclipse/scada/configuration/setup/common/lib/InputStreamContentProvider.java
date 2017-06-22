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
package org.eclipse.scada.configuration.setup.common.lib;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.packagedrone.utils.deb.build.ContentProvider;

import com.google.common.io.ByteStreams;

public class InputStreamContentProvider implements ContentProvider
{

    private final byte[] data;

    public InputStreamContentProvider ( final InputStream resource ) throws IOException
    {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream ();
        try
        {
            ByteStreams.copy ( resource, bos );
        }
        finally
        {
            resource.close ();
        }
        this.data = bos.toByteArray ();
    }

    @Override
    public long getSize ()
    {
        return this.data.length;
    }

    @Override
    public InputStream createInputStream () throws IOException
    {
        return new ByteArrayInputStream ( this.data );
    }

    @Override
    public boolean hasContent ()
    {
        return this.data != null && this.data.length > 0;
    }

}
