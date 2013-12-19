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
package org.eclipse.scada.configuration.recipe.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.scada.configuration.recipe.Definition;
import org.eclipse.scada.configuration.recipe.PropertyEntry;
import org.eclipse.scada.configuration.recipe.Task;
import org.eclipse.scada.configuration.recipe.lib.internal.DefaultExecutableFactory;
import org.eclipse.scada.configuration.recipe.lib.internal.RecipeImpl;
import org.eclipse.scada.configuration.recipe.lib.internal.TaskRunner;

public class Builder
{
    private final Definition rootDefinition;

    public Builder ( final Definition rootDefinition )
    {
        this.rootDefinition = rootDefinition;
    }

    public Recipe build ()
    {
        return build ( new DefaultExecutableFactory () );
    }

    public Recipe build ( final ExecutableFactory factory )
    {
        final List<Task> result = new ArrayList<> ( gatherTasks () );
        Collections.sort ( result, new Comparator<Task> () {

            @Override
            public int compare ( final Task o1, final Task o2 )
            {
                return Integer.compare ( o1.getOrder (), o2.getOrder () );
            }
        } );

        final URI rootUri = this.rootDefinition.eResource ().getURI ();

        final Map<String, String> properties = new HashMap<> ();
        gatherProperties ( properties );

        final Map<String, Object> initialContent = new HashMap<String, Object> ();
        initialContent.put ( "documentRoot", rootUri.toString () ); //$NON-NLS-1$

        return new RecipeImpl ( convert ( result, factory ), initialContent, properties );
    }

    protected void gatherProperties ( final Map<String, String> properties )
    {
        gatherProperties ( this.rootDefinition, properties );
    }

    protected void gatherProperties ( final Definition definition, final Map<String, String> properties )
    {
        for ( final Definition imported : definition.getImport () )
        {
            gatherProperties ( imported, properties );
        }

        for ( final PropertyEntry entry : definition.getProperties () )
        {
            if ( entry.getValue () != null )
            {
                properties.put ( entry.getKey (), entry.getValue () );
            }
            else
            {
                properties.remove ( entry.getKey () );
            }
        }
    }

    private List<TaskRunner> convert ( final List<Task> input, final ExecutableFactory factory )
    {
        final List<TaskRunner> result = new ArrayList<> ( input.size () );

        for ( final Task task : input )
        {
            result.add ( new TaskRunner ( task, factory ) );
        }

        return result;
    }

    private Set<Task> gatherTasks ()
    {
        final Set<Task> result = new HashSet<> ();
        final Set<Definition> defs = new HashSet<> ();

        gatherTasks ( this.rootDefinition, defs, result );

        return result;
    }

    private static void gatherTasks ( final Definition definition, final Set<Definition> defs, final Set<Task> result )
    {
        if ( defs.contains ( definition ) )
        {
            return;
        }

        defs.add ( definition );
        result.addAll ( definition.getTask () );

        for ( final Definition importDef : definition.getImport () )
        {
            gatherTasks ( importDef, defs, result );
        }
    }
}
