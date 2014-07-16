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
package org.eclipse.scada.configuration.recipe.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.scada.configuration.recipe.Definition;
import org.eclipse.scada.configuration.recipe.Profile;
import org.eclipse.scada.configuration.recipe.lib.Builder;
import org.eclipse.scada.configuration.recipe.lib.Recipe;
import org.eclipse.scada.configuration.utils.ModelLoader;

public final class RecipeHelper
{
    private RecipeHelper ()
    {
    }

    public static void processFile ( final IContainer parent, final Definition definition, final Profile profile, final IProgressMonitor monitor ) throws Exception
    {
        monitor.beginTask ( makeJobLabel ( definition, profile ), 100 );

        final IFolder output = parent.getFolder ( new Path ( "output" ) ); //$NON-NLS-1$
        if ( output.exists () )
        {
            output.delete ( true, new SubProgressMonitor ( monitor, 9 ) );
        }
        output.create ( true, true, new SubProgressMonitor ( monitor, 1 ) );

        final Builder builder = new Builder ( definition, profile );
        final Recipe recipe = builder.build ();

        try
        {
            final Map<String, Object> initialContent = new HashMap<String, Object> ();
            initialContent.put ( "output", output ); //$NON-NLS-1$

            recipe.execute ( initialContent, new SubProgressMonitor ( monitor, 90 ) );
        }
        finally
        {
            monitor.done ();
        }
    }

    protected static String makeJobLabel ( final Definition definition, final Profile profile )
    {
        final String name = definition.getName () == null ? definition.getId () : definition.getName ();

        if ( profile == null )
        {
            return String.format ( "Running recipe: %s", name );
        }
        else
        {
            return String.format ( "Running recipe: %s (%s)", name, profile.getName () );
        }
    }

    public static void processFile ( final IResource file, final IProgressMonitor monitor ) throws Exception
    {
        final ModelLoader<Definition> loader = new ModelLoader<Definition> ( Definition.class );

        final Definition def = loader.load ( file.getLocationURI () );

        processFile ( file.getParent (), def, null, monitor );
    }
}
