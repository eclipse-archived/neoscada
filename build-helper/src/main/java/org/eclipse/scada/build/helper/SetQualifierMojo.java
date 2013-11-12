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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.jar.Manifest;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.DefaultModelReader;
import org.apache.maven.model.io.DefaultModelWriter;
import org.apache.maven.model.io.ModelReader;
import org.apache.maven.model.io.ModelWriter;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

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
public class SetQualifierMojo extends AbstractHelperMojo
{
    /**
     * The new qualifier
     * 
     * @parameter expression="${newQualifier}"
     * @required
     */
    private String newQualifier;

    /**
     * Perform a dry run
     * 
     * @parameter expression="${dryRun}"
     */
    private boolean dryRun;

    public synchronized void execute () throws MojoExecutionException
    {
        try
        {
            getLog ().info ( "Setting qualifier: " + this.newQualifier );
            if ( this.dryRun )
            {
                getLog ().info ( "This is a dry run" );
            }

            final Collection<MavenProject> projects = getChildProjects ();
            projects.add ( getProject () );

            getLog ().info ( String.format ( "Processing %s modules", projects.size () ) );

            for ( final MavenProject project : projects )
            {
                getLog ().debug ( String.format ( " -> %s", project ) );
                process ( project );
            }
        }
        catch ( final Exception e )
        {
            throw new MojoExecutionException ( "Failed to set qualifier", e );
        }
    }

    private void process ( final MavenProject project ) throws Exception
    {
        getLog ().debug ( "Processing: " + project + " / " + project.getVersion () );

        final String version = makeVersion ( project.getVersion () );
        if ( version == null )
        {
            // no version
            return;
        }

        if ( version.equals ( project.getVersion () ) )
        {
            // no change
            return;
        }

        // write model

        getLog ().info ( String.format ( "Update from %s to %s", project.getVersion (), version ) );

        if ( !this.dryRun )
        {
            final ModelReader reader = new DefaultModelReader ();

            final Model model = reader.read ( project.getFile (), null );
            model.setVersion ( version );
            final ModelWriter writer = new DefaultModelWriter ();
            writer.write ( project.getFile (), null, model );

            PomHelper.visitDirectChildModules ( this.reactorProjects, project, new VisitorChange () {
                @Override
                protected boolean performChange ( final Model model )
                {
                    getLog ().debug ( String.format ( "Update parent version in module: " + model ) );
                    model.getParent ().setVersion ( version );
                    return true;
                }
            } );
        }

        // this is only called when the version changed ... for now
        syncModule ( project, version );
    }

    protected void syncModule ( final MavenProject project, final String version ) throws Exception
    {
        final String packaging = project.getPackaging ();
        getLog ().debug ( "Project type: " + packaging );
        if ( "eclipse-plugin".equals ( packaging ) )
        {
            handleBundle ( project, version );
        }
        else if ( "eclipse-feature".equals ( packaging ) )
        {
            handleFeature ( project, version );
        }
        else if ( "eclipse-repository".equals ( packaging ) )
        {
            handleRepository ( project, version );
        }
    }

    private void handleRepository ( final MavenProject project, final String version ) throws Exception
    {
        final File file = new File ( project.getBasedir (), "category.xml" );
        if ( !file.exists () )
        {
            return;
        }

        final Document doc = XmlHelper.parse ( file );
        // XmlHelper.updateValue ( doc, "/site/feature/@version", version );

        for ( final Node node : XmlHelper.findNodes ( doc, "/site/feature" ) )
        {
            final Element ele = (Element)node;
            ele.setAttribute ( "version", version );
            final String featureId = ele.getAttribute ( "id" );
            ele.setAttribute ( "url", String.format ( "features/%s_%s.jar", featureId, version ) );
        }

        XmlHelper.write ( doc, file );
    }

    private void handleBundle ( final MavenProject project, final String version ) throws Exception
    {
        final File file = new File ( project.getBasedir (), "META-INF/MANIFEST.MF" );

        final Manifest manifest = new Manifest ( new FileInputStream ( file ) );

        // process

        manifest.getMainAttributes ().putValue ( "Bundle-Version", version );

        // write

        final FileOutputStream out = new FileOutputStream ( file );
        try
        {
            manifest.write ( out );
        }
        finally
        {
            out.close ();
        }
    }

    private void handleFeature ( final MavenProject project, final String version ) throws Exception
    {
        final File file = new File ( project.getBasedir (), "feature.xml" );
        final Document doc = XmlHelper.parse ( file );
        XmlHelper.updateValue ( doc, "/feature/@version", version );
        XmlHelper.write ( doc, file );
    }

    private String makeVersion ( final String version )
    {
        if ( version == null )
        {
            // no version at all
            return null;
        }

        final LinkedList<String> toks = new LinkedList<String> ( Arrays.asList ( version.split ( "(\\.|-)" ) ) );

        getLog ().debug ( "Version split: " + toks );

        while ( toks.size () > 3 )
        {
            toks.removeLast ();
        }
        while ( toks.size () < 3 )
        {
            toks.add ( "0" );
        }

        toks.add ( this.newQualifier );

        return String.format ( "%s.%s.%s.%s", toks.pollFirst (), toks.pollFirst (), toks.pollFirst (), toks.pollFirst () );
    }
}
