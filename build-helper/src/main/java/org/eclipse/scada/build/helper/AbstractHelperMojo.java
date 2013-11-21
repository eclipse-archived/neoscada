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
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

/**
 * Abstract helper mojo
 * 
 * @author Jens Reimann
 * @since 0.0.1
 */
public abstract class AbstractHelperMojo extends AbstractMojo
{
    /**
     * The maven project
     * 
     * @since 0.0.1
     */
    @Parameter ( property = "project", readonly = true, required = true )
    protected MavenProject project;

    /**
     * The maven session
     * 
     * @since 0.0.1
     */
    @Parameter ( property = "session", readonly = true, required = true )
    protected MavenSession session;

    /**
     * The maven mojo execution
     * 
     * @since 0.0.1
     */
    @Parameter ( property = "mojoExecution", readonly = true, required = true )
    protected MojoExecution execution;

    /**
     * @since 0.0.1
     */
    @Parameter ( property = "reactorProjects", readonly = true, required = true )
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