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
package org.eclipse.scada.utils.pkg.deb.control;

import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;

/**
 * Write control files <br/>
 * This class writes <a
 * href="https://www.debian.org/doc/debian-policy/ch-controlfields.html">debian
 * control files</a> to a target stream.
 */
public class ControlFileWriter implements Closeable
{
    private final Writer writer;

    public ControlFileWriter ( final Writer writer )
    {
        if ( writer == null )
        {
            throw new NullPointerException ( "'writer' must not be null" );
        }
        this.writer = writer;
    }

    public void writeField ( final ControlField field ) throws IOException
    {
        field.write ( this.writer );
    }

    public void writeBreak () throws IOException
    {
        this.writer.write ( '\n' );
    }

    @Override
    public void close () throws IOException
    {
        this.writer.close ();
    }
}
