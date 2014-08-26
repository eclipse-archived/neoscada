/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.lib.deployment;

import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

import com.google.common.io.CharStreams;

public abstract class CommonPackageDeploymentContext implements DeploymentContext
{
    private final Set<String> dependencies = new HashSet<> ();

    protected final StringBuilder postInstallation = new StringBuilder ();

    @Override
    public void addInstallDependency ( final String packageName )
    {
        this.dependencies.add ( packageName );
    }

    public Set<String> getDependencies ()
    {
        return this.dependencies;
    }

    public String getPostInstallationString ()
    {
        return this.postInstallation.toString ();
    }

    @Override
    public void addPostInstallationScript ( final Reader reader ) throws IOException
    {
        try
        {
            CharStreams.copy ( reader, this.postInstallation );
        }
        finally
        {
            reader.close ();
        }
    }

}
