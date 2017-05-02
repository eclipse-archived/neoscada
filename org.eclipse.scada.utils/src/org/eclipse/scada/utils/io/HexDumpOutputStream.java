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
package org.eclipse.scada.utils.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class HexDumpOutputStream extends OutputStream
{
    private final PrintStream ps;

    private final int width = 16;

    public HexDumpOutputStream ( final PrintStream ps )
    {
        this.ps = ps;
    }

    public HexDumpOutputStream ( final OutputStream os )
    {
        this ( new PrintStream ( os ) );
    }

    private int counter = 0;

    public void wrap ()
    {
        if ( this.counter > 0 )
        {
            this.ps.println ();
        }

        this.ps.println ();
        this.counter = 0;
    }

    @Override
    public void write ( final int b ) throws IOException
    {
        if ( this.counter > 0 )
        {
            this.ps.print ( ' ' );
        }

        this.ps.print ( String.format ( "%02X", (byte) ( 0xFF & b ) ) );

        this.counter++;
        if ( this.counter > this.width )
        {
            this.counter = 0;
            wrap ();
        }

    }

    @Override
    public void close ()
    {
        this.ps.close ();
    }
}
