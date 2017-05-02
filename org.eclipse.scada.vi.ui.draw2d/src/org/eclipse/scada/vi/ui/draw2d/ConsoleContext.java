/*******************************************************************************
 * Copyright (c) 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.script.ScriptContext;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class ConsoleContext
{
    private PrintWriter errorPrintWriter;

    private MessageConsoleStream logStream;

    private MessageConsoleStream writerStream;

    public ConsoleContext ( final MessageConsole messageConsole )
    {
        this.writerStream = messageConsole.newMessageStream ();

        final MessageConsoleStream errorStream = messageConsole.newMessageStream ();
        errorStream.setColor ( Display.getDefault ().getSystemColor ( SWT.COLOR_RED ) );
        this.errorPrintWriter = new PrintWriter ( new OutputStreamWriter ( errorStream ) );

        this.logStream = messageConsole.newMessageStream ();
        this.logStream.setColor ( Display.getDefault ().getSystemColor ( SWT.COLOR_GRAY ) );
    }

    public void applyTo ( final ScriptContext scriptContext )
    {
        scriptContext.setWriter ( new PrintWriter ( new OutputStreamWriter ( this.writerStream ) ) );
        scriptContext.setErrorWriter ( this.errorPrintWriter );
    }

    public MessageConsoleStream getLogStream ()
    {
        return this.logStream;
    }

    public PrintWriter getErrorPrintWriter ()
    {
        return this.errorPrintWriter;
    }

    public void dispose ()
    {
        if ( this.writerStream != null )
        {
            try
            {
                this.writerStream.close ();
            }
            catch ( final IOException e )
            {
            }
            this.writerStream = null;
        }
        if ( this.errorPrintWriter != null )
        {
            try
            {
                this.errorPrintWriter.close ();
            }
            catch ( final Exception e )
            {
            }
            this.errorPrintWriter = null;
        }
        if ( this.logStream != null )
        {
            try
            {
                this.logStream.close ();
            }
            catch ( final IOException e )
            {
            }
            this.logStream = null;
        }
    }

}
