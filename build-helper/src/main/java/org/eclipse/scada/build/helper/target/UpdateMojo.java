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
package org.eclipse.scada.build.helper.target;

import java.io.File;
import java.util.Map;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.eclipse.scada.build.helper.AbstractHelperMojo;
import org.eclipse.scada.build.helper.XmlHelper;
import org.eclipse.tycho.core.TychoProject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @since 0.0.19
 */
@Mojo (
        name = "update-target-platform",
        defaultPhase = LifecyclePhase.COMPILE,
        aggregator = false,
        requiresProject = true,
        requiresDirectInvocation = false )
public class UpdateMojo extends AbstractHelperMojo
{
    @Parameter ( property = "sourceFile", required = true )
    protected File sourceFile;

    @Parameter ( property = "targetFile", required = true )
    protected File targetFile;

    @Component ( role = TychoProject.class )
    protected Map<String, TychoProject> projectTypes;

    @Parameter ( property = "downloadUrl", required = false )
    protected String downloadUrl;

    @Override
    public void execute () throws MojoExecutionException, MojoFailureException
    {
        getLog ().debug ( "START HERE" );

        try
        {
            final Document doc = XmlHelper.parse ( this.sourceFile );
            updateFile ( doc );
            XmlHelper.write ( doc, this.targetFile );
        }
        catch ( final Exception e )
        {
            throw new MojoExecutionException ( "Failed to update version", e );
        }
    }

    protected void updateFile ( final Document doc ) throws Exception
    {
        for ( final Node node : XmlHelper.findNodes ( doc, "//unit" ) )
        {
            if ( ! ( node instanceof Element ) )
            {
                continue;
            }

            final Element ele = (Element)node;
            final String id = ele.getAttribute ( "id" );

            final String oldVersion = ele.getAttribute ( "version" );
            final String newVersion = findVersion ( id );
            getLog ().info ( String.format ( "Updating version - %s = %s (was: %s)", id, newVersion, oldVersion ) );
            ele.setAttribute ( "version", newVersion );
        }

        if ( this.downloadUrl != null )
        {
            for ( final Node node : XmlHelper.findNodes ( doc, "//repository" ) )
            {
                if ( ! ( node instanceof Element ) )
                {
                    continue;
                }
                final Element ele = (Element)node;
                final String oldLink = ele.getAttribute ( "location" );
                ele.setAttribute ( "location", this.downloadUrl );
                getLog ().info ( String.format ( "Changed download link: %s -> %s", oldLink, this.downloadUrl ) );
            }
        }
    }

    protected String findVersion ( final String id )
    {
        getLog ().debug ( String.format ( "Looking for '%s'", id ) );
        for ( final MavenProject p : getReactorProjects () )
        {
            final String artifactId = p.getArtifactId ();
            final String packaging = p.getPackaging ();

            getLog ().debug ( String.format ( "Found %s:%s:%s:%s", p.getGroupId (), p.getArtifactId (), p.getVersion (), p.getPackaging () ) );

            if ( "eclipse-plugin".equals ( packaging ) && artifactId.equals ( id ) )
            {
                return getVersion ( p );
            }
            if ( "eclipse-feature".equals ( packaging ) && ( artifactId + ".feature.group" ).equals ( id ) )
            {
                return getVersion ( p );
            }
        }

        throw new IllegalStateException ( String.format ( "Unable to find installable unit: %s", id ) );
    }

    protected String getVersion ( final MavenProject project )
    {
        getLog ().debug ( "Properties: " + project.getProperties () );

        if ( !project.getVersion ().endsWith ( "-SNAPSHOT" ) )
        {
            // project version is already qualified
            return project.getVersion ();
        }

        final String version = project.getProperties ().getProperty ( "qualifiedVersion" );
        if ( version != null )
        {
            // we do have a direct qualified version
            return version;
        }

        final String q = project.getProperties ().getProperty ( "buildQualifier" );
        final String v = project.getProperties ().getProperty ( "unqualifiedVersion" );

        if ( q == null || v == null )
        {
            throw new IllegalStateException ( String.format ( "Unable to find qualified version for: %s", project.getArtifactId () ) );
        }

        // just stick it together
        return v + "." + q;
    }
}
