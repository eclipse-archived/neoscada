/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.recipe.lib.internal;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.scada.configuration.recipe.Execute;
import org.eclipse.scada.configuration.recipe.Task;
import org.eclipse.scada.configuration.recipe.lib.Executable;
import org.eclipse.scada.configuration.recipe.lib.ExecutableFactory;

public class TaskRunner
{
    private static final String KEY_PROGRESS_MONITOR = "progressMonitor"; //$NON-NLS-1$

    private final Task task;

    private final ExecutableFactory factory;

    public TaskRunner ( final Task task, final ExecutableFactory factory )
    {
        this.task = task;
        this.factory = factory;
    }

    public static String getTaskId ( final Task task )
    {
        return String.format ( "%s#%s", task.getDefinition ().getName (), task.getName () ); //$NON-NLS-1$
    }

    public String getId ()
    {
        return getTaskId ( this.task );
    }

    public void run ( final RunnerContext ctx, final IProgressMonitor monitor )
    {
        monitor.beginTask ( "Executing task", this.task.getExecute ().size () );

        for ( final Execute execute : this.task.getExecute () )
        {
            final Executable runnable = convert ( execute, ctx );

            // inject sub progress monitor
            final SubProgressMonitor sm = new SubProgressMonitor ( monitor, 1 );
            ctx.getMap ().put ( KEY_PROGRESS_MONITOR, sm );

            runnable.run ( ctx );

            // remove sub progress monitor
            ctx.getMap ().remove ( KEY_PROGRESS_MONITOR );
            // step is complete
            sm.done ();
        }

        monitor.done ();
    }

    private Executable convert ( final Execute execute, final RunnerContext ctx )
    {
        return this.factory.create ( execute, ctx );
    }

    public String getName ()
    {
        return this.task.getName ();
    }

}
