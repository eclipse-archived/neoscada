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

import java.util.Collection;
import java.util.Set;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;

public interface PomHelper
{
    public static interface ProjectVisitor
    {
        public void visit ( MavenProject project ) throws Exception;
    }

    public Set<MavenProject> expandProjects ( final Collection<MavenProject> projects, final Log log, final MavenSession session );

    public void visitModulesWithParent ( final Collection<MavenProject> projects, final MavenProject parentProject, final ProjectVisitor visitor ) throws Exception;
}
