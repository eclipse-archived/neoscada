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

import java.text.SimpleDateFormat;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.eclipse.tycho.buildversion.BuildTimestampProvider;
import org.eclipse.tycho.extras.buildtimestamp.jgit.JGitBuildTimestampProvider;

/**
 * Generate qualifier
 * 
 * @author Jens Reimann
 * @goal generate-qualifier
 * @aggregator
 * @requiresProject true
 * @requiresDirectInocation true
 * @since 0.0.1
 */
public class GenerateQualifierMojo extends AbstractSetQualifierMojo
{
    /**
     * @component
     */
    private BuildTimestampProvider buildTimestampProvider;

    /**
     * The qualifier format string
     * <p>
     * This must be a format string for {@link SimpleDateFormat}
     * </p>
     * 
     * @parameter expression="${format}"
     *            default-value="'v'yyyyMMdd-HHmm"
     * @required
     */
    private String format;

    private SimpleDateFormat formatImpl;

    @Override
    protected synchronized String getQualifier ( final MavenProject project )
    {
        if ( this.buildTimestampProvider == null )
        {
            getLog ().info ( "Using time stamp provider: " + this.buildTimestampProvider );
            this.buildTimestampProvider = new JGitBuildTimestampProvider ();
        }

        if ( this.formatImpl == null )
        {
            getLog ().info ( "Using format: " + this.format );
            this.formatImpl = new SimpleDateFormat ( this.format );
        }

        try
        {
            return this.formatImpl.format ( this.buildTimestampProvider.getTimestamp ( getSession (), project, this.execution ) );
        }
        catch ( final MojoExecutionException e )
        {
            throw new RuntimeException ( e );
        }
    }
}
