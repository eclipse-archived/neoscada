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

import org.apache.maven.project.MavenProject;

/**
 * Set qualifier
 * 
 * @author Jens Reimann
 * @goal set-qualifier
 * @aggregator
 * @requiresProject true
 * @requiresDirectInocation true
 * @since 0.0.1
 */
public class SetQualifierMojo extends AbstractSetQualifierMojo
{
    /**
     * The new qualifier
     * 
     * @parameter expression="${newQualifier}"
     * @required
     */
    private String newQualifier;

    @Override
    protected String getQualifier ( final MavenProject project )
    {
        return this.newQualifier;
    }
}
