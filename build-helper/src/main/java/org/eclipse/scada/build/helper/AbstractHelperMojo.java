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
import java.util.List;
import java.util.Set;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.project.MavenProject;

public abstract class AbstractHelperMojo extends AbstractMojo
{
    /**
     * The Maven Project.
     * 
     * @parameter expression="${project}"
     * @required
     * @readonly
     * @since 0.0.1
     */
    private MavenProject project;

    /**
     * The Maven Session.
     * 
     * @parameter expression="${session}"
     * @required
     * @readonly
     * @since 0.0.1
     */
    protected MavenSession session;

    /**
     * @parameter expression="${reactorProjects}"
     * @required
     * @readonly
     * @since 0.0.1
     */
    protected List<MavenProject> reactorProjects;

    public MavenProject getProject ()
    {
        return this.project;
    }

    public void setProject ( final MavenProject project )
    {
        this.project = project;
    }

    public MavenSession getSession ()
    {
        return this.session;
    }

    public void setSession ( final MavenSession session )
    {
        this.session = session;
    }

    public List<MavenProject> getReactorProjects ()
    {
        return this.reactorProjects;
    }

    public void setReactorProjects ( final List<MavenProject> reactorProjects )
    {
        this.reactorProjects = reactorProjects;
    }

    public Collection<MavenProject> getChildProjects () throws IOException
    {
        final Set<MavenProject> result = new HashSet<MavenProject> ();

        fillChildren ( result, getProject () );

        return result;
    }

    private void fillChildren ( final Set<MavenProject> result, final MavenProject localProject ) throws IOException
    {
        getLog ().debug ( "Add children from: " + localProject );

        for ( final String module : localProject.getModules () )
        {
            final File moduleFile = new File ( localProject.getBasedir (), module ).getCanonicalFile ();

            for ( final MavenProject project : this.reactorProjects )
            {
                final File projectFile = project.getBasedir ().getAbsoluteFile ();

                if ( projectFile.equals ( moduleFile ) )
                {
                    if ( result.add ( project ) )
                    {
                        getLog ().debug ( "Dive into: " + project );
                        fillChildren ( result, project );
                    }
                }
            }
        }
    }
}