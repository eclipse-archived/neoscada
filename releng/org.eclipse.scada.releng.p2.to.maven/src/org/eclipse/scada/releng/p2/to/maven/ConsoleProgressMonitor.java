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
package org.eclipse.scada.releng.p2.to.maven;

import java.io.PrintWriter;
import java.io.Writer;

import org.eclipse.core.runtime.IProgressMonitor;

public class ConsoleProgressMonitor implements IProgressMonitor
{

    private boolean canceled;

    private String taskName;

    private final PrintWriter writer;

    public ConsoleProgressMonitor ( final Writer writer )
    {
        this.writer = new PrintWriter ( writer );
    }

    @Override
    public void beginTask ( final String name, final int totalWork )
    {
        this.writer.println ( "*** Begin - " + name );
        this.writer.flush ();
        this.taskName = name;
    }

    @Override
    public void done ()
    {
        this.writer.println ( "*** Complete - " + this.taskName );
        this.writer.flush ();
    }

    @Override
    public void internalWorked ( final double work )
    {
    }

    @Override
    public boolean isCanceled ()
    {
        return this.canceled;
    }

    @Override
    public void setCanceled ( final boolean value )
    {
        this.canceled = value;
    }

    @Override
    public void setTaskName ( final String name )
    {
        this.taskName = name;
    }

    @Override
    public void subTask ( final String name )
    {
        this.writer.println ( "*** " + this.taskName + " - " + name );
        this.writer.flush ();
    }

    @Override
    public void worked ( final int work )
    {
    }

}
