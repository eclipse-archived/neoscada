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
import java.util.List;

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
}
