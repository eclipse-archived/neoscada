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

import java.util.List;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecution;
import org.apache.maven.project.MavenProject;

public abstract class AbstractHelperMojo extends AbstractMojo
{
    /**
     * The Maven Project.
     * 
     * @parameter property="project"
     * @required
     * @readonly
     * @since 0.0.1
     */
    private MavenProject project;

    /**
     * The Maven Session.
     * 
     * @parameter property="session"
     * @required
     * @readonly
     * @since 0.0.1
     */
    protected MavenSession session;

    /**
     * @parameter property="mojoExecution"
     */
    protected MojoExecution execution;

    /**
     * @parameter property="reactorProjects"
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
}