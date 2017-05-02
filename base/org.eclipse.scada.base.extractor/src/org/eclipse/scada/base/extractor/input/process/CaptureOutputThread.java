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

/**
 * A thread which captures all content from an input stream
 */
public class CaptureOutputThread extends ReaderThread
{
    private ByteArrayOutputStream bos;

    private IOException error;

    public CaptureOutputThread ( final InputStream stream )
    {
        super ( stream );
    }

    @Override
    public void run ()
    {
        this.bos = new ByteArrayOutputStream ();

        // now continue
        super.run ();
    }

    @Override
    protected void handleComplete ()
    {
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

    @Override
    protected void handleData ( final byte[] buffer, final int len )
    {
        this.bos.write ( buffer, 0, len );
    }

    @Override
    protected void handleError ( final IOException e )
    {
        this.error = e;
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
