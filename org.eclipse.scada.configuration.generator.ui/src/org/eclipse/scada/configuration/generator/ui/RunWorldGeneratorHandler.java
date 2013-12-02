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
package org.eclipse.scada.configuration.generator.ui;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.scada.configuration.generator.world.WorldRunner;
import org.eclipse.scada.configuration.world.World;

/**
 * Create artifacts from an existing world model
 * 
 * @author Jens Reimann
 */
public class RunWorldGeneratorHandler extends AbstractFileRunner
{

    @Override
    protected void runFile ( final IFile file, final IProgressMonitor monitor ) throws Exception
    {
        run ( file, monitor );
    }

    public static void run ( final IFile file, final IProgressMonitor monitor ) throws CoreException, Exception
    {
        monitor.beginTask ( "Creating world", 10 );

        final IContainer parent = file.getParent ();
        final IFolder outputContainer = parent.getFolder ( new Path ( "output" ) );

        if ( outputContainer.exists () )
        {
            monitor.setTaskName ( "Cleaning up" );
            outputContainer.delete ( true, new SubProgressMonitor ( monitor, 1 ) );
        }

        outputContainer.create ( true, true, new SubProgressMonitor ( monitor, 1 ) );

        monitor.setTaskName ( "Creating output" );
        new WorldRunner ().process ( URI.createURI ( file.getLocationURI ().toString () ), outputContainer, new SubProgressMonitor ( monitor, 8 ) );

        monitor.done ();
    }

    public static void run ( final World world, final IContainer parent, final IProgressMonitor monitor ) throws CoreException, Exception
    {
        monitor.beginTask ( "Creating world", 10 );

        final IFolder outputContainer = parent.getFolder ( new Path ( "output" ) );

        if ( outputContainer.exists () )
        {
            monitor.setTaskName ( "Cleaning up" );
            outputContainer.delete ( true, new SubProgressMonitor ( monitor, 1 ) );
        }

        outputContainer.create ( true, true, new SubProgressMonitor ( monitor, 1 ) );

        runWithOutput ( world, outputContainer, monitor );

        monitor.done ();
    }

    public static void runWithOutput ( final World world, final IContainer outputContainer, final IProgressMonitor monitor ) throws CoreException, Exception
    {
        monitor.setTaskName ( "Creating output" );
        new WorldRunner ().process ( world, outputContainer, monitor );
    }

}
