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
package org.eclipse.scada.build.helper.name;

import java.util.Map;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.MojoExecution;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;

public interface QualifierNameProvider
{
    public class Configuration
    {
        private final MavenSession session;

        private final MojoExecution execution;

        private final MavenProject project;

        private final Map<String, String> properties;

        public Configuration ( final MavenSession session, final MojoExecution execution, final MavenProject project, final Map<String, String> properties )
        {
            this.session = session;
            this.execution = execution;
            this.project = project;
            this.properties = properties;
        }

        public MavenSession getSession ()
        {
            return session;
        }

        public MojoExecution getExecution ()
        {
            return execution;
        }

        public MavenProject getProject ()
        {
            return project;
        }

        public Map<String, String> getProperties ()
        {
            return properties;
        }
    }

    public String createName ( Configuration configuration ) throws MojoExecutionException;
}
