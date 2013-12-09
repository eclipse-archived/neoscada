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
package org.eclipse.scada.configuration.world.lib;

import javax.inject.Named;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.utils.Factories;
import org.eclipse.scada.configuration.utils.ModelLoader;
import org.eclipse.scada.configuration.world.Application;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.Node;
import org.eclipse.scada.configuration.world.Service;
import org.eclipse.scada.configuration.world.World;
import org.eclipse.scada.configuration.world.deployment.DeploymentMechanism;
import org.eclipse.scada.configuration.world.lib.internal.Activator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorldRunner
{
    private static final String ATTR_CLASS = "class"; //$NON-NLS-1$

    private static final String ELE_FOR_CLASS = "forClass"; //$NON-NLS-1$

    private static final String ATTR_FOR_CLASS = "forClass"; //$NON-NLS-1$

    private final static Logger logger = LoggerFactory.getLogger ( WorldRunner.class );

    private static final String ELE_NODE_ELEMENT_PROCESSOR = "nodeElementProcessor"; //$NON-NLS-1$

    public void processUri ( final URI input, final IContainer output, final IProgressMonitor monitor ) throws Exception
    {
        logger.debug ( "Processing file: {}", input ); //$NON-NLS-1$

        monitor.setTaskName ( "Loading model" );

        process ( null, new ModelLoader<World> ( World.class ).load ( input ), output, monitor );
    }

    public void process (
            @Named ( "phase" )
            final String phase,
            final World world, final IContainer output, final IProgressMonitor monitor ) throws Exception
    {
        monitor.beginTask ( "Processing world", world.getNodes ().size () );

        for ( final Node node : world.getNodes () )
        {
            if ( node instanceof ApplicationNode )
            {
                processNode ( phase, world, (ApplicationNode)node, output, new SubProgressMonitor ( monitor, 1 ) );
            }
            monitor.worked ( 1 );
        }

        monitor.done ();
    }

    private void processNode ( final String phase, final World world, final ApplicationNode applicationNode, final IContainer output, final IProgressMonitor monitor ) throws Exception
    {
        logger.debug ( "Processing node: {}", applicationNode ); //$NON-NLS-1$

        final String name = Nodes.makeName ( applicationNode );

        final IFolder nodeDir = output.getFolder ( new Path ( name ) );

        if ( !nodeDir.exists () )
        {
            nodeDir.create ( true, true, monitor );
        }

        for ( final Application app : applicationNode.getApplications () )
        {
            logger.debug ( "Processing application: {}", app ); //$NON-NLS-1$

            final NodeElementProcessor processor = createProcessor ( app, world, applicationNode );
            processor.process ( phase, nodeDir, monitor );
        }

        for ( final DeploymentMechanism deploy : applicationNode.getDeployments () )
        {
            logger.debug ( "Processing deployment: {}", deploy ); //$NON-NLS-1$

            final NodeElementProcessor processor = createProcessor ( deploy, world, applicationNode );
            processor.process ( phase, nodeDir, monitor );
        }

        for ( final Service service : applicationNode.getServices () )
        {
            logger.debug ( "Processing service: {}", service ); //$NON-NLS-1$

            final NodeElementProcessor processor = createProcessor ( service, world, applicationNode );
            processor.process ( phase, nodeDir, monitor );
        }
    }

    private NodeElementProcessor createProcessor ( final EObject element, final World world, final ApplicationNode applicationNode ) throws CoreException
    {
        final EAnnotation an = element.eClass ().getEAnnotation ( "http://eclipse.org/SCADA/Configuration/World" );

        if ( an != null && Boolean.parseBoolean ( an.getDetails ().get ( "ignore" ) ) )
        {
            return new NodeElementProcessor () {

                @Override
                public void process ( final String phase, final IFolder baseDir, final IProgressMonitor monitor ) throws Exception
                {
                    // no-op
                }
            };
        }

        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( Activator.EXTP_GENERATOR ) )
        {
            if ( !ele.getName ().equals ( ELE_NODE_ELEMENT_PROCESSOR ) )
            {
                continue;
            }
            if ( isMatch ( Activator.getDefault ().getBundle ().getBundleContext (), ele, element ) )
            {
                final NodeElementProcessorFactory factory = (NodeElementProcessorFactory)ele.createExecutableExtension ( "factoryClass" );
                return factory.createProcessor ( element, world, applicationNode );
            }
        }

        throw new IllegalStateException ( String.format ( "No processor found for element: %s", element ) );
    }

    private boolean isMatch ( final BundleContext ctx, final IConfigurationElement ele, final Object element )
    {
        if ( isMatch ( Factories.loadClass ( ctx, ele, ATTR_FOR_CLASS ), element ) )
        {
            return true;
        }

        for ( final IConfigurationElement child : ele.getChildren ( ELE_FOR_CLASS ) )
        {
            if ( isMatch ( Factories.loadClass ( ctx, child, ATTR_CLASS ), element ) )
            {
                return true;
            }
        }
        return false;
    }

    private boolean isMatch ( final Class<?> clazz, final Object element )
    {
        if ( clazz == null )
        {
            return false;
        }

        return clazz.isAssignableFrom ( element.getClass () );
    }
}
