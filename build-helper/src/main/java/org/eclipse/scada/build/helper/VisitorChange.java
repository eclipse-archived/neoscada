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

import java.io.IOException;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.DefaultModelReader;
import org.apache.maven.model.io.DefaultModelWriter;
import org.apache.maven.project.MavenProject;
import org.eclipse.scada.build.helper.PomHelper.ProjectVisitor;

public abstract class VisitorChange implements ProjectVisitor
{

    public void visit ( final MavenProject project ) throws IOException
    {
        final Model model = new DefaultModelReader ().read ( project.getFile (), null );
        if ( performChange ( model ) )
        {
            new DefaultModelWriter ().write ( project.getFile (), null, model );
        }
    }

    protected abstract boolean performChange ( final Model model );

}
