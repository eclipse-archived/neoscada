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
package org.eclipse.scada.protocol.ngp.generator.ui.popupMenus;

import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.scada.protocol.ngp.generator.ui.Activator;
import org.eclipse.scada.protocol.ngp.generator.ui.common.GenerateAll;
import org.eclipse.scada.protocol.ngp.model.Protocol.Protocol;
import org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;

/**
 * Generator code generation.
 */
public class AcceleoGenerateGeneratorAction extends ActionDelegate implements IActionDelegate, IExecutableExtension
{

    /**
     * Selected model files.
     */
    protected List<IFile> files;

    private String main = "org.eclipse.scada.protocol.ngp.generator.main.Generate";

    private String projectFormat;

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.ui.actions.ActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
     *      org.eclipse.jface.viewers.ISelection)
     * @generated
     */
    @Override
    @SuppressWarnings ( "unchecked" )
    public void selectionChanged ( final IAction action, final ISelection selection )
    {
        if ( selection instanceof IStructuredSelection )
        {
            this.files = ( (IStructuredSelection)selection ).toList ();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.ui.actions.ActionDelegate#run(org.eclipse.jface.action.IAction)
     * @generated NOT
     */
    @Override
    public void run ( final IAction action )
    {
        if ( this.files != null )
        {
            final IRunnableWithProgress operation = new IRunnableWithProgress () {
                @Override
                public void run ( final IProgressMonitor monitor )
                {
                    try
                    {
                        final Iterator<IFile> filesIt = AcceleoGenerateGeneratorAction.this.files.iterator ();
                        while ( filesIt.hasNext () )
                        {
                            final IFile model = filesIt.next ();
                            final URI modelURI = URI.createPlatformResourceURI ( model.getFullPath ().toString (), true );
                            final Protocol protocol = loadProtocol ( modelURI );

                            try
                            {
                                final IContainer target = findTarget ( protocol, model.getProject () );

                                final List<Object> arguments = new LinkedList<Object> ();

                                final GenerateAll generator = new GenerateAll ( modelURI, target, arguments, AcceleoGenerateGeneratorAction.this.main );
                                generator.doGenerate ( monitor );
                            }
                            catch ( final Exception e )
                            {
                                final IStatus status = new Status ( IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage (), e );
                                Activator.getDefault ().getLog ().log ( status );
                            }
                            finally
                            {
                                findProject ( protocol, model.getProject () ).refreshLocal ( IResource.DEPTH_INFINITE, monitor );
                            }
                        }
                    }
                    catch ( final CoreException e )
                    {
                        final IStatus status = new Status ( IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage (), e );
                        Activator.getDefault ().getLog ().log ( status );
                    }
                }
            };
            try
            {
                PlatformUI.getWorkbench ().getProgressService ().run ( true, true, operation );
            }
            catch ( final InvocationTargetException e )
            {
                final IStatus status = new Status ( IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage (), e );
                Activator.getDefault ().getLog ().log ( status );
            }
            catch ( final InterruptedException e )
            {
                final IStatus status = new Status ( IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage (), e );
                Activator.getDefault ().getLog ().log ( status );
            }
        }
    }

    protected Protocol loadProtocol ( final URI modelURI )
    {
        final ResourceSet rs = new ResourceSetImpl ();
        rs.getResourceFactoryRegistry ().getExtensionToFactoryMap ().put ( "protocol", new XMIResourceFactoryImpl () );

        final Resource resource = rs.getResource ( modelURI, true );

        return (Protocol)EcoreUtil.getObjectByType ( resource.getContents (), ProtocolPackage.Literals.PROTOCOL );
    }

    protected IProject findProject ( final Protocol protocol, final IProject modelProject )
    {
        if ( this.projectFormat == null )
        {
            return modelProject;
        }

        final IWorkspaceRoot root = modelProject.getWorkspace ().getRoot ();
        final String projectName = String.format ( this.projectFormat, protocol.getPackagePrefix (), protocol.getName () );
        return root.getProject ( projectName );
    }

    protected IContainer findTarget ( final Protocol protocol, final IProject modelProject )
    {
        final IProject project = findProject ( protocol, modelProject );
        if ( !project.exists () )
        {
            throw new RuntimeException ( String.format ( "Project '%s' does not exists", project.getName () ) );
        }
        return project.getFolder ( "src" );
    }

    @SuppressWarnings ( "rawtypes" )
    @Override
    public void setInitializationData ( final IConfigurationElement config, final String propertyName, final Object data ) throws CoreException
    {
        if ( data instanceof String )
        {
            this.main = (String)data;
        }
        else if ( data instanceof Hashtable )
        {
            {
                final Object o = ( (Hashtable)data ).get ( "generatorName" );
                if ( o instanceof String )
                {
                    this.main = (String)o;
                }
            }
            {
                final Object o = ( (Hashtable)data ).get ( "projectFormat" );
                if ( o instanceof String )
                {
                    this.projectFormat = (String)o;
                }
            }
        }
    }

}