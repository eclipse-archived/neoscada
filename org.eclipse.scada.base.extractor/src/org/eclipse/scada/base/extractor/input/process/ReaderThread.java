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

import java.io.IOException;
import java.io.InputStream;

/**
 * A thread that reads content from an input stream
 */
public abstract class ReaderThread extends Thread
{
    private final InputStream stream;

    protected abstract void handleError ( final IOException e );

    protected abstract void handleData ( final byte[] buffer, final int len );

    protected abstract void handleComplete ();

    public ReaderThread ( final InputStream stream )
    {
        this.stream = stream;
    }

    @Override
    public void run ()
    {
        final byte[] buffer = new byte[4096];

        int rc;
        try
        {
            while ( ( rc = this.stream.read ( buffer ) ) > 0 )
            {
                handleData ( buffer, rc );
            }
        }
        catch ( final IOException e )
        {
            handleError ( e );
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
        handleComplete ();
    }

}