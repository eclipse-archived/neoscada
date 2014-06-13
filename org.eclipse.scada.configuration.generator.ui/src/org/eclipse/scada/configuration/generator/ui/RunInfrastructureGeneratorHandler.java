/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.generator.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.configuration.infrastructure.lib.WorldGenerator;
import org.eclipse.scada.configuration.utils.ModelLoader;

/**
 * Convert a Component/Infrastructure Model to a world model
 *
 * @author Jens Reimann
 */
public class RunInfrastructureGeneratorHandler extends AbstractFileRunner
{
    @Override
    protected void runFile ( final IFile file, final IProgressMonitor monitor ) throws Exception
    {
        run ( file, monitor );
    }

    public static void run ( final IFile file, final IProgressMonitor monitor ) throws CoreException, Exception
    {
        monitor.beginTask ( "Creating world", 11 );

        monitor.setTaskName ( "Loading source model" );
        final World infra = new ModelLoader<> ( World.class ).load ( URI.createURI ( file.getLocationURI ().toString () ) );
        monitor.worked ( 1 );

        monitor.setTaskName ( "Generating world" );
        final WorldGenerator gen = new WorldGenerator ( infra );
        gen.generate ( new SubProgressMonitor ( monitor, 7 ) );

        monitor.setTaskName ( "Creating output files" );
        store ( gen, file, monitor );
        monitor.worked ( 1 );

        monitor.setTaskName ( "Refreshing" );

        monitor.done ();
    }

    private static void store ( final WorldGenerator gen, final IFile sourceFile, final IProgressMonitor monitor ) throws Exception
    {
        final IFile outputfile = sourceFile.getParent ().getFile ( new Path ( sourceFile.getName () + ".eswm" ) );
        final IFile globfile = sourceFile.getParent ().getFile ( new Path ( sourceFile.getName () + ".globalize" ) );

        final ResourceSet rs = new ResourceSetImpl ();
        final Resource r1 = rs.createResource ( URI.createURI ( outputfile.getLocationURI ().toString () ), "org.eclipse.scada.configuration.world" );
        final Resource r2 = rs.createResource ( URI.createURI ( globfile.getLocationURI ().toString () ), "org.eclipse.scada.configuration.globalization" );

        r1.getContents ().add ( gen.getWorld () );
        r2.getContents ().add ( gen.getGlobalize () );

        r1.save ( null );
        r2.save ( null );

        globfile.getParent ().refreshLocal ( 1, new SubProgressMonitor ( monitor, 1 ) );
        outputfile.getParent ().refreshLocal ( 1, new SubProgressMonitor ( monitor, 1 ) );
    }
}
