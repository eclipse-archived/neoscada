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
import org.apache.maven.project.MavenProject;
import org.eclipse.scada.build.helper.PomHelper.ProjectVisitor;

public abstract class VisitorChange implements ProjectVisitor
{

    private final ChangeManager changeManager;

    public VisitorChange ( final ChangeManager changeManager )
    {
        this.changeManager = changeManager;
    }

    public void visit ( final MavenProject project ) throws IOException
    {
        this.changeManager.addChange ( project.getFile (), new ModelModifier () {

            public boolean apply ( final Model model )
            {
                return performChange ( model );
            }

            @Override
            public String toString ()
            {
                return VisitorChange.this.toString ();
            };
        } );
    }

    protected abstract boolean performChange ( final Model model );
}
