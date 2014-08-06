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
import java.io.InputStream;
import java.io.Reader;

/**
 * Allow access to the context of the deployment <br/>
 * <em>Note:</em> The script interpreter is part of the target deployment
 * mechanism (e.g. deb,
 * rpm). In most Unix cases a plain "bourne shell" will most likely work. Also
 * is it not a complete shell script but a script fragment. Which means that
 * a wrong syntax can cause the whole setup to fail.
 */
public interface DeploymentContext
{
    public void addInstallDependency ( String packageName );

    public void addPostInstallationScript ( Reader reader ) throws IOException;

    /**
     * Run a shell script fragment after the installation or upgrade of the
     * package
     *
     * @param script
     *            the script fragment to run
     */
    public void runAfterInstallation ( String script );

    public void addFile ( InputStream resource, String targetFile ) throws IOException;
}
