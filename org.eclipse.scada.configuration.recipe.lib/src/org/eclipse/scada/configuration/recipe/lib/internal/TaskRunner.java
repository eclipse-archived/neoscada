/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.recipe.lib.internal;

import org.eclipse.scada.configuration.recipe.Execute;
import org.eclipse.scada.configuration.recipe.Task;
import org.eclipse.scada.configuration.recipe.lib.Executable;
import org.eclipse.scada.configuration.recipe.lib.ExecutableFactory;

public class TaskRunner
{
    private final Task task;

    private final ExecutableFactory factory;

    public TaskRunner ( final Task task, final ExecutableFactory factory )
    {
        this.task = task;
        this.factory = factory;
    }

    public static String getTaskId ( final Task task )
    {
        return String.format ( "%s#%s", task.getDefinition ().getName (), task.getName () );
    }

    public String getId ()
    {
        return getTaskId ( this.task );
    }

    public void run ( final RunnerContext ctx )
    {
        for ( final Execute execute : this.task.getExecute () )
        {
            final Executable runnable = convert ( execute, ctx );
            runnable.run ( ctx );
        }
    }

    private Executable convert ( final Execute execute, final RunnerContext ctx )
    {
        return this.factory.create ( execute, ctx );
    }

}
