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

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.scada.configuration.recipe.lib.Recipe;

public class RecipeImpl implements Recipe
{

    private final List<TaskRunner> tasks;

    private final Map<String, Object> initialContent;

    public RecipeImpl ( final List<TaskRunner> tasks, final Map<String, Object> initialContent )
    {
        this.tasks = tasks;
        this.initialContent = initialContent;
    }

    @Override
    public void execute ( final Map<String, Object> initialContext )
    {
        execute ( initialContext, new NullProgressMonitor () );
    }

    @Override
    public void execute ( final Map<String, Object> initialContext, final IProgressMonitor monitor )
    {
        final RunnerContext ctx = new RunnerContext ();
        ctx.getMap ().putAll ( this.initialContent );
        ctx.getMap ().putAll ( initialContext );

        monitor.beginTask ( "Running recipe", this.tasks.size () );

        try
        {
            for ( final TaskRunner task : this.tasks )
            {
                task.run ( ctx );
                monitor.worked ( 1 );
            }
        }
        finally
        {
            monitor.done ();
        }

    }

}
