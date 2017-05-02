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

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.scada.configuration.recipe.lib.Recipe;

public class RecipeImpl implements Recipe
{

    private static final int MONITOR_AMOUNT = 10;

    private final List<TaskRunner> tasks;

    private final Map<String, Object> initialContent;

    private final Map<String, String> properties;

    public RecipeImpl ( final List<TaskRunner> tasks, final Map<String, Object> initialContent, final Map<String, String> properties )
    {
        this.tasks = tasks;
        this.initialContent = initialContent;
        this.properties = properties;
    }

    @Override
    public void execute ( final Map<String, Object> initialContext )
    {
        execute ( initialContext, new NullProgressMonitor () );
    }

    @Override
    public void execute ( final Map<String, Object> initialContext, final IProgressMonitor monitor )
    {
        final RunnerContext ctx = new RunnerContext ( this.properties );
        ctx.getMap ().putAll ( this.initialContent );
        ctx.getMap ().putAll ( initialContext );

        monitor.beginTask ( "Running recipe", this.tasks.size () * MONITOR_AMOUNT );

        try
        {
            for ( final TaskRunner task : this.tasks )
            {
                monitor.subTask ( task.getName () );
                task.run ( ctx, new SubProgressMonitor ( monitor, MONITOR_AMOUNT ) );
            }
        }
        finally
        {
            monitor.done ();
        }

    }

}
