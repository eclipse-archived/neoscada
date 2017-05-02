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
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Profile;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.ProjectBuilder;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;
import org.codehaus.plexus.logging.Logger;

@Component ( role = PomHelper.class )
public class DefaultPomHelper implements PomHelper
{

    @Requirement
    private ProjectBuilder projectBuilder;

    @Requirement
    private Logger logger;

    protected List<String> getModules ( final MavenProject project )
    {
        final List<String> result = new LinkedList<String> ();

        result.addAll ( project.getModules () );
        for ( final Profile profile : project.getModel ().getProfiles () )
        {
            result.addAll ( profile.getModules () );
        }

        return result;
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.build.helper.PomHelper#expandProjects(java.util.Collection, org.apache.maven.plugin.logging.Log, org.apache.maven.execution.MavenSession)
     */
    @Override
    public Set<MavenProject> expandProjects ( final Collection<MavenProject> projects, final Log log, final MavenSession session )
    {
        try
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
                queue.addAll ( loadChildren ( project, log, session ) );
                if ( hasLocalParent ( project ) )
                {
                    // if we have a parent, add the parent as well
                    queue.add ( project.getParent () );
                }
            }
            return result;
        }
        catch ( final Exception e )
        {
            throw new RuntimeException ( e );
        }
    }

    private boolean hasLocalParent ( final MavenProject project )
    {
        if ( project.getParentFile () != null )
        {
            return true;
        }
        return false;
    }

    private Collection<MavenProject> loadChildren ( final MavenProject project, final Log log, final MavenSession session ) throws Exception
    {
        final Set<MavenProject> result = new HashSet<MavenProject> ();

        log.debug ( "Loading children for: " + project );

        log.debug ( "Base dir: " + project.getBasedir () );

        if ( project.getBasedir () == null )
        {
            log.debug ( "Don't have a base dir" );
            // if we don't have a base dir, we cannot change anything
            return result;
        }

        for ( final String module : getModules ( project ) )
        {
            File file = new File ( project.getBasedir (), module );
            if ( file.isDirectory () )
            {
                file = new File ( file, "pom.xml" );
            }
            log.debug ( "Looking up: " + file );
            result.add ( loadProject ( file, session ) );
        }

        return result;
    }

    private MavenProject loadProject ( File file, final MavenSession session ) throws Exception
    {
        file = file.getCanonicalFile ();
        for ( final MavenProject project : session.getProjects () )
        {
            final File projectFile = project.getFile ().getCanonicalFile ();
            if ( projectFile.equals ( file ) )
            {
                return project;
            }
        }

        throw new MojoExecutionException ( file, "Unreferenced project found", String.format ( "Project at '%s' is not in the list of active projects. This plugin can only"
                + "work on projects there were loaded by maven. You need to include the project in your build.", file ) );
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.build.helper.PomHelper#visitModulesWithParent(java.util.Collection, org.apache.maven.project.MavenProject, org.eclipse.scada.build.helper.DefaultPomHelper.ProjectVisitor)
     */
    @Override
    public void visitModulesWithParent ( final Collection<MavenProject> projects, final MavenProject parentProject, final ProjectVisitor visitor ) throws Exception
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
