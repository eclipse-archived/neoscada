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
package org.eclipse.scada.build.helper;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.apache.maven.model.io.DefaultModelReader;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;

public class PomHelper
{
    public static interface ProjectVisitor
    {
        public void visit ( MavenProject project ) throws Exception;
    }

    public static void visitDirectChildModules ( final List<MavenProject> reactorProjects, final MavenProject project, final ProjectVisitor visitor ) throws Exception
    {
        for ( final String module : project.getModules () )
        {
            final File moduleFile = new File ( project.getBasedir (), module ).getCanonicalFile ();

            for ( final MavenProject reactorProject : reactorProjects )
            {
                final File projectFile = reactorProject.getBasedir ().getAbsoluteFile ();

                if ( projectFile.equals ( moduleFile ) )
                {
                    visitor.visit ( reactorProject );
                }
            }
        }
    }

    public static Set<MavenProject> expandProjects ( final Collection<MavenProject> projects, final Log log ) throws IOException
    {
        final Set<MavenProject> result = new HashSet<MavenProject> ();

        final Queue<MavenProject> queue = new LinkedList<MavenProject> ( projects );
        while ( !queue.isEmpty () )
        {
            final MavenProject project = queue.poll ();
            log.debug ( "Checking project: " + project );
            if ( project.getFile () == null )
            {
                log.info ( "Skipping non-local project: " + project );
                continue;
            }
            if ( !result.add ( project ) )
            {
                // if the project was already in our result, there is no need to process twice
                continue;
            }
            // add all children to the queue
            queue.addAll ( loadChildren ( project, log ) );
            if ( project.getParent () != null )
            {
                // if we have a parent, add the parent as well
                queue.add ( project.getParent () );
            }
        }
        return result;
    }

    private static Collection<MavenProject> loadChildren ( final MavenProject project, final Log log ) throws IOException
    {
        final Set<MavenProject> result = new HashSet<MavenProject> ();

        log.debug ( "Base dir: " + project.getBasedir () );

        if ( project.getBasedir () == null )
        {
            // if we don't have a base dir, we cannot change anything
            return result;
        }

        for ( final String module : project.getModules () )
        {
            File file = new File ( project.getBasedir (), module );
            if ( file.isDirectory () )
            {
                file = new File ( file, "pom.xml" );
            }
            log.debug ( "Loading: " + file );
            result.add ( loadProject ( file ) );
        }

        return result;
    }

    private static MavenProject loadProject ( final File file ) throws IOException
    {
        final MavenProject project = new MavenProject ( new DefaultModelReader ().read ( file, null ) );
        project.setFile ( file );
        return project;
    }

    public static void visitModulesWithParent ( final Collection<MavenProject> projects, final MavenProject parentProject, final ProjectVisitor visitor ) throws Exception
    {
        for ( final MavenProject project : projects )
        {
            if ( project.getParentFile () == null )
            {
                continue;
            }
            if ( project.getParentFile ().equals ( parentProject.getFile () ) )
            {
                visitor.visit ( project );
            }
        }
    }
}
