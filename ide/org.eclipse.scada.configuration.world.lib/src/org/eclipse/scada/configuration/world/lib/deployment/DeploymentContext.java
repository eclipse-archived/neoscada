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

import org.eclipse.packagedrone.utils.deb.build.ContentProvider;

/**
 * Allow access to the context of the deployment <br/>
 * <em>Note:</em> The script interpreter is part of the target deployment
 * mechanism (e.g. deb,
 * rpm). In most Unix cases a plain "bourne shell" (not <q>bash</q>) will most
 * likely work. Also is it not a complete shell script but a script fragment.
 * Which means that a wrong syntax can cause the whole setup to fail.
 */
public interface DeploymentContext
{
    /**
     * Get the name of the package that will be built <br/>
     * This is the name, not the file name, of the package.
     *
     * @return the package name
     */
    public String getPackageName ();

    public void addInstallDependency ( String packageName );

    /**
     * Add a script as pre installation script
     * <p>
     * The method has to close the reader before it returns. Even in the case of
     * an exception.
     * </p>
     *
     * @param reader
     *            the content to add
     * @throws IOException
     *             if anything goes wrong
     */
    public void addPreInstallationScript ( Reader reader ) throws IOException;

    /**
     * Add a script as post installation script
     * <p>
     * The method has to close the reader before it returns. Even in the case of
     * an exception.
     * </p>
     *
     * @param reader
     *            the content to add
     * @throws IOException
     *             if anything goes wrong
     */
    public void addPostInstallationScript ( Reader reader ) throws IOException;

    /**
     * Add a script as pre removal script
     * <p>
     * The method has to close the reader before it returns. Even in the case of
     * an exception.
     * </p>
     *
     * @param reader
     *            the content to add
     * @throws IOException
     *             if anything goes wrong
     */
    public void addPreRemovalScript ( Reader reader ) throws IOException;

    /**
     * Add a script as post removal script
     * <p>
     * The method has to close the reader before it returns. Even in the case of
     * an exception.
     * </p>
     *
     * @param reader
     *            the content to add
     * @throws IOException
     *             if anything goes wrong
     */
    public void addPostRemovalScript ( Reader reader ) throws IOException;

    /**
     * Run a shell script fragment after the installation or upgrade of the
     * package
     *
     * @param script
     *            the script fragment to run
     */
    public void runAfterInstallation ( String script );

    /**
     * Run a shell script fragment after package was completely removed
     * 
     * @param script
     *            the script fragment to run
     */
    public void runAfterRemoval ( String script );

    /**
     * Add a file to the deployment package <br/>
     * Add the content of the input stream as a file in the target system
     * <p>
     * The method has to close the input stream before it returns. Even in the
     * case of an exception.
     * </p>
     *
     * @param content
     *            the content to add
     * @param targetFile
     *            the name of the file in the target system
     * @param options
     *            a list of options
     * @throws IOException
     *             if anything goes wrong
     */
    public void addFile ( ContentProvider content, String targetFile, FileInformation fileInformation ) throws IOException;

    public void addDirectory ( String targetDirectory, FileInformation fileInformation );
}
