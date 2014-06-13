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
package org.eclipse.scada.configuration.ui.project.create;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.scada.configuration.recipe.CaptureOutput;
import org.eclipse.scada.configuration.recipe.Definition;
import org.eclipse.scada.configuration.recipe.Execute;
import org.eclipse.scada.configuration.recipe.MapInput;
import org.eclipse.scada.configuration.recipe.Profile;
import org.eclipse.scada.configuration.recipe.PropertyEntry;
import org.eclipse.scada.configuration.recipe.RecipeFactory;
import org.eclipse.scada.configuration.recipe.StringInputValue;
import org.eclipse.scada.configuration.recipe.Task;
import org.eclipse.scada.configuration.utils.LoadModel;
import org.eclipse.scada.configuration.utils.ModelLoader;
import org.eclipse.scada.configuration.utils.StoreModel;
import org.eclipse.scada.configuration.world.lib.deployment.NodeMappingHandler;
import org.osgi.framework.FrameworkUtil;

public class RecipeBuilder
{

    public static Definition createDefaultRecipe () throws IOException
    {
        return createRecipe ( "Production", false );
    }

    public static Definition createIntegrationRecipe () throws IOException
    {
        return createRecipe ( "Integration", true );
    }

    protected static Definition createRecipe ( final String name, final boolean nodeMappings ) throws IOException
    {
        final Definition recipe = RecipeFactory.eINSTANCE.createDefinition ();
        recipe.setName ( name );

        final Profile profile = RecipeFactory.eINSTANCE.createProfile ();
        profile.setName ( "No deployment actions" );

        addProperty ( profile.getProperties (), "skipRunDeployment", "true" ); //$NON-NLS-1$ //$NON-NLS-2$

        recipe.getProfiles ().add ( profile );

        recipe.getImport ().add ( new ModelLoader<Definition> ( Definition.class ).load ( URI.createURI ( "platform:/plugin/org.eclipse.scada.configuration.generator.component/default.recipe" ) ) ); //$NON-NLS-1$

        {
            final Task loadTask = createTask ( recipe, 0, "Load Models" );
            {
                final Execute exec = addExecute ( loadTask, LoadModel.class, "load" ); //$NON-NLS-1$
                createStringInputValue ( exec, "uri", "world.escm" ); //$NON-NLS-1$ //$NON-NLS-2$
                createOutputCapture ( exec, "model", "componentModel" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            if ( nodeMappings )
            {
                final Execute exec = addExecute ( loadTask, LoadModel.class, "load" ); //$NON-NLS-1$
                createStringInputValue ( exec, "uri", "nodeMappings.esdi" ); //$NON-NLS-1$ //$NON-NLS-2$
                createOutputCapture ( exec, "model", "nodeMappings" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
        if ( nodeMappings )
        {
            final Task mappings = createTask ( recipe, 550_000, "Node Mappings" );
            addExecute ( mappings, NodeMappingHandler.class, "execute" ); //$NON-NLS-1$
        }
        {
            final Task storeTask = createTask ( recipe, Integer.MAX_VALUE, "Store Models" );

            final Execute exec1 = addExecute ( storeTask, StoreModel.class, "store" ); //$NON-NLS-1$
            createStringInputValue ( exec1, "uri", "result.eswm" ); //$NON-NLS-1$ //$NON-NLS-2$
            createMapInput ( exec1, "worldModel", "model" ); //$NON-NLS-1$ //$NON-NLS-2$

            final Execute exec2 = addExecute ( storeTask, StoreModel.class, "store" ); //$NON-NLS-1$
            createStringInputValue ( exec2, "uri", "result.globalize" ); //$NON-NLS-1$ //$NON-NLS-2$
            createMapInput ( exec2, "globalizationModel", "model" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        return recipe;
    }

    protected static void addProperty ( final EList<PropertyEntry> properties, final String key, final String value )
    {
        final PropertyEntry pe = RecipeFactory.eINSTANCE.createPropertyEntry ();
        pe.setKey ( key );
        pe.setValue ( value );
        properties.add ( pe );
    }

    private static void createOutputCapture ( final Execute exec, final String localName, final String contextName )
    {
        final CaptureOutput out = RecipeFactory.eINSTANCE.createCaptureOutput ();
        out.setLocalName ( localName );
        out.setContextName ( contextName );
        exec.getOutput ().add ( out );
    }

    private static Task createTask ( final Definition recipe, final int order, final String name )
    {
        final Task task = RecipeFactory.eINSTANCE.createTask ();
        task.setOrder ( order );
        recipe.getTask ().add ( task );
        task.setName ( name );
        return task;
    }

    private static Execute addExecute ( final Task task, final Class<?> clazz, final String methodName )
    {
        final Execute exec = RecipeFactory.eINSTANCE.createExecute ();
        exec.setName ( String.format ( "bundle-class://%s/%s#%s", FrameworkUtil.getBundle ( clazz ).getSymbolicName (), clazz.getName (), methodName ) ); //$NON-NLS-1$
        task.getExecute ().add ( exec );
        return exec;
    }

    private static void createStringInputValue ( final Execute exec, final String name, final String value )
    {
        final StringInputValue iv = RecipeFactory.eINSTANCE.createStringInputValue ();
        iv.setName ( name );
        iv.setValue ( value );
        exec.getInputValue ().add ( iv );
    }

    private static void createMapInput ( final Execute exec, final String contextName, final String localName )
    {
        final MapInput map = RecipeFactory.eINSTANCE.createMapInput ();
        map.setContextName ( contextName );
        map.setLocalName ( localName );
        exec.getMapInput ().add ( map );
    }

}
