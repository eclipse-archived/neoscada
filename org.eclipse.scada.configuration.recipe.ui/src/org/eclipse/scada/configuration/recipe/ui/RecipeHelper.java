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

    public static final int MONITOR_FILE_AMOUNT = 100_000;

    public static void processFile ( final IContainer parent, final Definition definition, final Profile profile, final IProgressMonitor monitor ) throws Exception
    {
        final IFolder output = parent.getFolder ( new Path ( "output" ) ); //$NON-NLS-1$
        if ( output.exists () )
        {
            output.delete ( true, monitor );
        }
        output.create ( true, true, monitor );

        final Builder builder = new Builder ( definition, profile );
        final Recipe recipe = builder.build ();

        try
        {
            final Map<String, Object> initialContent = new HashMap<String, Object> ();
            initialContent.put ( "progressMonitor", monitor ); //$NON-NLS-1$
            initialContent.put ( "output", output ); //$NON-NLS-1$

            recipe.execute ( initialContent, monitor );
        }
        finally
        {
            monitor.done ();
        }
    }

    public static void processFile ( final IResource file, final IProgressMonitor monitor ) throws Exception
    {
        final ModelLoader<Definition> loader = new ModelLoader<Definition> ( Definition.class );

        final Definition def = loader.load ( file.getLocationURI () );

        processFile ( file.getParent (), def, null, monitor );
    }
}
