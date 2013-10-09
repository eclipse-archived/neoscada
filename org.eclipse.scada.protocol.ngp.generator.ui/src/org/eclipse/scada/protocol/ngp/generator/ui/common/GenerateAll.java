/*******************************************************************************
 * Copyright (c) 2008, 2013 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.generator.ui.common;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.scada.protocol.ngp.generator.ui.Activator;
import org.osgi.framework.Bundle;

/**
 * Main entry point of the 'Generator' generation module.
 */
public class GenerateAll
{

    /**
     * The model URI.
     */
    private final URI modelURI;

    /**
     * The output folder.
     */
    private final IContainer targetFolder;

    /**
     * The other arguments.
     */
    List<? extends Object> arguments;

    private final String main;

    /**
     * Constructor.
     * 
     * @param modelURI
     *            is the URI of the model.
     * @param targetFolder
     *            is the output folder
     * @param arguments
     *            are the other arguments
     * @throws IOException
     *             Thrown when the output cannot be saved.
     * @generated NOT
     */
    public GenerateAll ( final URI modelURI, final IContainer targetFolder, final List<? extends Object> arguments, final String main )
    {
        this.modelURI = modelURI;
        this.targetFolder = targetFolder;
        this.arguments = arguments;
        this.main = main;
    }

    /**
     * Launches the generation.
     * 
     * @param monitor
     *            This will be used to display progress information to the user.
     * @generated NOT
     */
    @SuppressWarnings ( "unchecked" )
    public void doGenerate ( final IProgressMonitor monitor ) throws Exception
    {
        if ( !this.targetFolder.getLocation ().toFile ().exists () )
        {
            this.targetFolder.getLocation ().toFile ().mkdirs ();
        }

        // final URI template0 = getTemplateURI("org.eclipse.scada.protocol.ngp.generator", new Path("/org/eclipse/scada/protocol/ngp/generator/main/generate.emtl"));
        // org.eclipse.scada.protocol.ngp.generator.main.Generate gen0 = new org.eclipse.scada.protocol.ngp.generator.main.Generate(modelURI, targetFolder.getLocation().toFile(), arguments) {
        //	protected URI createTemplateURI(String entry) {
        //		return template0;
        //	}
        //};
        //gen0.doGenerate(BasicMonitor.toMonitor(monitor));
        monitor.subTask ( "Loading..." );

        final Class<? extends AbstractAcceleoGenerator> clazz = (Class<? extends AbstractAcceleoGenerator>)Activator.getDefault ().getBundle ().loadClass ( this.main );
        final Constructor<? extends AbstractAcceleoGenerator> ctor = clazz.getConstructor ( URI.class, File.class, List.class );
        final AbstractAcceleoGenerator gen0 = ctor.newInstance ( this.modelURI, this.targetFolder.getLocation ().toFile (), this.arguments );

        // final AbstractAcceleoGenerator gen0 = new org.eclipse.scada.protocol.ngp.generator.main.Generate ( this.modelURI, this.targetFolder.getLocation ().toFile (), this.arguments );
        monitor.worked ( 1 );

        final String generationID = org.eclipse.acceleo.engine.utils.AcceleoLaunchingUtil.computeUIProjectID ( "org.eclipse.scada.protocol.ngp.generator", this.main, this.modelURI.toString (), this.targetFolder.getFullPath ().toString (), new ArrayList<String> () );
        gen0.setGenerationID ( generationID );
        gen0.doGenerate ( BasicMonitor.toMonitor ( monitor ) );
    }

    /**
     * Finds the template in the plug-in. Returns the template plug-in URI.
     * 
     * @param bundleID
     *            is the plug-in ID
     * @param relativePath
     *            is the relative path of the template in the plug-in
     * @return the template URI
     * @throws IOException
     * @generated
     */
    @SuppressWarnings ( "unused" )
    private URI getTemplateURI ( final String bundleID, final IPath relativePath ) throws IOException
    {
        final Bundle bundle = Platform.getBundle ( bundleID );
        if ( bundle == null )
        {
            // no need to go any further 
            return URI.createPlatformResourceURI ( new Path ( bundleID ).append ( relativePath ).toString (), false );
        }
        URL url = bundle.getEntry ( relativePath.toString () );
        if ( url == null && relativePath.segmentCount () > 1 )
        {
            final Enumeration<URL> entries = bundle.findEntries ( "/", "*.emtl", true );
            if ( entries != null )
            {
                final String[] segmentsRelativePath = relativePath.segments ();
                while ( url == null && entries.hasMoreElements () )
                {
                    final URL entry = entries.nextElement ();
                    IPath path = new Path ( entry.getPath () );
                    if ( path.segmentCount () > relativePath.segmentCount () )
                    {
                        path = path.removeFirstSegments ( path.segmentCount () - relativePath.segmentCount () );
                    }
                    final String[] segmentsPath = path.segments ();
                    boolean equals = segmentsPath.length == segmentsRelativePath.length;
                    for ( int i = 0; equals && i < segmentsPath.length; i++ )
                    {
                        equals = segmentsPath[i].equals ( segmentsRelativePath[i] );
                    }
                    if ( equals )
                    {
                        url = bundle.getEntry ( entry.getPath () );
                    }
                }
            }
        }
        URI result;
        if ( url != null )
        {
            result = URI.createPlatformPluginURI ( new Path ( bundleID ).append ( new Path ( url.getPath () ) ).toString (), false );
        }
        else
        {
            result = URI.createPlatformResourceURI ( new Path ( bundleID ).append ( relativePath ).toString (), false );
        }
        return result;
    }

}
