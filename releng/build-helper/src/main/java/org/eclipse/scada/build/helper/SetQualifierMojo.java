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

import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

/**
 * Set qualifier
 * 
 * @author Jens Reimann
 * @since 0.0.1
 */
@Mojo (
        name = "set-qualifier",
        aggregator = true,
        requiresProject = true,
        requiresDirectInvocation = true )
public class SetQualifierMojo extends AbstractSetQualifierMojo
{
    /**
     * The new qualifier
     */
    @Parameter ( property = "newQualifier", required = true )
    private String newQualifier;

    @Override
    protected String getQualifier ( final MavenProject project )
    {
        return this.newQualifier;
    }
}
