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
package org.eclipse.scada.base.extractor.input.process;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReaderThread extends Thread
{
    private final InputStream stream;

    private ByteArrayOutputStream bos;

    private IOException error;

    public ReaderThread ( final InputStream stream )
    {
        this.stream = stream;
    }

    @Override
    public void run ()
    {
        this.bos = new ByteArrayOutputStream ();

        final byte[] buffer = new byte[4096];

        int rc;
        try
        {
            while ( ( rc = this.stream.read ( buffer ) ) > 0 )
            {
                this.bos.write ( buffer, 0, rc );
            }
        }
        catch ( final IOException e )
        {
            this.error = e;
        }
        finally
        {
            try
            {
                this.stream.close ();
            }
            catch ( final IOException e )
            {
                // we don't care much here
            }
        }
        try
        {
            this.bos.close ();
        }
        catch ( final IOException e )
        {
            // this should never ever happen
            this.error = e;
        }
    }

    public IOException getError ()
    {
        return this.error;
    }

    public byte[] getData ()
    {
        if ( this.error == null && this.bos != null )
        {
            return this.bos.toByteArray ();
        }
        else
        {
            return null;
        }
    }
}
