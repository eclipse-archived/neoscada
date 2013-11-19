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

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3DomBuilder;
import org.eclipse.tycho.buildversion.BuildTimestampProvider;

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
     * Role hint of a custom build timestamp provider.
     * 
     * @parameter default-value="default" property="timestampProvider"
     */
    protected String timestampProvider;

    /**
     * @component role="org.eclipse.tycho.buildversion.BuildTimestampProvider"
     */
    protected Map<String, BuildTimestampProvider> timestampProviders;

    /**
     * The qualifier format string
     * <p>
     * This must be a format string for {@link SimpleDateFormat}
     * </p>
     * 
     * @parameter property="format"
     *            default-value="'v'yyyyMMdd-HHmm"
     * @required
     */

    private SimpleDateFormat format;

    public void setFormat ( final String format )
    {
        this.format = new SimpleDateFormat ( format );
        this.format.setTimeZone ( TimeZone.getTimeZone ( "UTC" ) );
    }

    protected Date getBuildTimestamp ( final MavenProject project ) throws MojoExecutionException
    {
        final BuildTimestampProvider provider = this.timestampProviders.get ( this.timestampProvider );
        if ( provider == null )
        {
            throw new MojoExecutionException ( "Unable to lookup BuildTimestampProvider with hint='" + this.timestampProvider + "'" );
        }

        return provider.getTimestamp ( this.session, project, this.execution );
    }

    @Override
    protected synchronized String getQualifier ( final MavenProject project )
    {
        try
        {
            return this.format.format ( getBuildTimestamp ( project ) );
        }
        catch ( final MojoExecutionException e )
        {
            throw new RuntimeException ( e );
        }
    }

    @Override
    public synchronized void execute () throws MojoExecutionException
    {
        if ( this.execution.getPlugin ().getConfiguration () == null )
        {
            try
            {
                this.execution.getPlugin ().setConfiguration ( Xpp3DomBuilder.build ( new StringReader ( "<configuration/>" ) ) );
            }
            catch ( final Exception e )
            {
                throw new RuntimeException ( e );
            }
        }

        final BuildTimestampProvider provider = this.timestampProviders.get ( this.timestampProvider );
        getLog ().info ( "Hint: " + this.timestampProvider );
        getLog ().info ( "Using provider: " + provider );

        getLog ().info ( "Providers: " + this.timestampProviders );

        super.execute ();
    }
}
