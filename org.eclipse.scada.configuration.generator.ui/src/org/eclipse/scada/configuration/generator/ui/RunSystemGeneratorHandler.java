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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.scada.configuration.generator.component.SystemRunner;
import org.eclipse.scada.configuration.world.World;

/**
 * Run a component model
 * 
 * @author IBH SYSTEMS GmbH
 */
public class RunSystemGeneratorHandler extends AbstractFileRunner
{

    @Override
    protected void runFile ( final IFile file, final IProgressMonitor monitor ) throws Exception
    {
        final IFolder outputContainer = file.getParent ().getFolder ( new Path ( "output" ) );

        if ( outputContainer.exists () )
        {
            outputContainer.delete ( true, monitor );
        }
        outputContainer.create ( true, true, monitor );

        final World world = new SystemRunner ().process ( URI.createURI ( file.getLocationURI ().toString () ), URI.createURI ( outputContainer.getLocationURI ().toString () ), monitor );
        RunWorldGeneratorHandler.runWithOutput ( world, outputContainer, monitor );

        outputContainer.refreshLocal ( IResource.DEPTH_INFINITE, monitor );
    }

}
