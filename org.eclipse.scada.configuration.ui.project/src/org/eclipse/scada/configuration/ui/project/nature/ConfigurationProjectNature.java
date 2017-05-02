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
package org.eclipse.scada.configuration.ui.project.nature;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class ConfigurationProjectNature implements IProjectNature
{

    private IProject project;

    @Override
    public void configure () throws CoreException
    {
    }

    @Override
    public void deconfigure () throws CoreException
    {
    }

    @Override
    public IProject getProject ()
    {
        return this.project;
    }

    @Override
    public void setProject ( final IProject project )
    {
        this.project = project;
    }

}
