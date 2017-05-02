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
package org.eclipse.scada.configuration.ui.project.builder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.action.ValidateAction.EclipseResourcesUtil;
import org.eclipse.scada.configuration.ui.project.Activator;
import org.eclipse.scada.configuration.ui.project.Constants;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.ui.statushandlers.StatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectBuilder extends IncrementalProjectBuilder
{

    private final static Logger logger = LoggerFactory.getLogger ( ProjectBuilder.class );

    private final class ProjectDiagnostician extends Diagnostician
    {
        private final ComposedAdapterFactory adapterFactory;

        public ProjectDiagnostician ( final ComposedAdapterFactory adapterFactory )
        {
            this.adapterFactory = adapterFactory;
        }

        @Override
        public String getObjectLabel ( final EObject eObject )
        {
            if ( eObject.eIsProxy () )
            {
                return super.getObjectLabel ( eObject );
            }

            final IItemLabelProvider itemLabelProvider = (IItemLabelProvider)this.adapterFactory.adapt ( eObject, IItemLabelProvider.class );
            logger.debug ( "Label provider: {} - for {}", itemLabelProvider, eObject );

            if ( itemLabelProvider != null )
            {
                return itemLabelProvider.getText ( eObject );
            }
            return super.getObjectLabel ( eObject );
        }
    }

    private class DeltaVisitor implements IResourceDeltaVisitor
    {
        private final IProgressMonitor monitor;

        private final ComposedAdapterFactory adapterFactory;

        private final Set<String> extensions;

        public DeltaVisitor ( final IProgressMonitor monitor, final ComposedAdapterFactory adapterFactory, final Set<String> extensions )
        {
            this.monitor = monitor;
            this.adapterFactory = adapterFactory;
            this.extensions = extensions;
        }

        @Override
        public boolean visit ( final IResourceDelta delta )
        {
            final IResource resource = delta.getResource ();

            return handleResource ( delta, resource, this.adapterFactory, this.extensions, this.monitor );
        }
    }

    private final EclipseResourcesUtil helper = new EclipseResourcesUtil ();

    public ProjectBuilder ()
    {
    }

    protected Set<String> getExtensions ( final Map<String, String> args )
    {
        final String str = args.get ( "extensions" );
        if ( str == null || str.isEmpty () )
        {
            return getDefaultExtensions ();
        }
        return new HashSet<> ( Arrays.asList ( str.split ( " *, *" ) ) );
    }

    private Set<String> getDefaultExtensions ()
    {
        return new HashSet<> ( Arrays.asList ( "escm", "esim", "security", "esdi", "recipe", "setup" ) );
    }

    @Override
    protected IProject[] build ( final int kind, final Map<String, String> args, final IProgressMonitor monitor ) throws CoreException
    {
        final ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory ( ComposedAdapterFactory.Descriptor.Registry.INSTANCE );
        try
        {

            logger.debug ( "Requested build" );

            final Set<String> extensions = getExtensions ( args );

            IResourceDelta delta = null;
            if ( kind != FULL_BUILD )
            {
                delta = getDelta ( getProject () );
            }

            if ( delta == null || kind == FULL_BUILD )
            {
                if ( isInterestingProject ( getProject () ) )
                {
                    validateAll ( getProject (), adapterFactory, extensions, monitor );
                }
            }
            else
            {
                delta.accept ( new DeltaVisitor ( monitor, adapterFactory, extensions ) );
            }
            return null;
        }
        finally
        {
            adapterFactory.dispose ();
        }
    }

    protected void validateAll ( final IProject project, final ComposedAdapterFactory adapterFactory, final Set<String> extensions, final IProgressMonitor monitor )
    {
        logger.debug ( "Validating all resources of {}", project );

        try
        {
            project.accept ( new IResourceVisitor () {

                @Override
                public boolean visit ( final IResource resource ) throws CoreException
                {
                    return handleResource ( null, resource, adapterFactory, extensions, monitor );
                }
            } );
        }
        catch ( final CoreException e )
        {
            StatusManager.getManager ().handle ( e.getStatus () );
        }
    }

    private boolean isInterestingProject ( final IProject project )
    {
        try
        {
            final boolean result = project.hasNature ( Constants.PROJECT_NATURE_CONFIGURATION );
            logger.debug ( "Checking project - project: {}, result: {}", project, result );
            return result;
        }
        catch ( final CoreException e )
        {
            StatusManager.getManager ().handle ( e.getStatus () );
            return false;
        }

    }

    public static URI makeUri ( final IResource resource )
    {
        return URI.createPlatformResourceURI ( resource.getFullPath ().toString (), true );
    }

    public void validateFile ( final IFile candidate, final ComposedAdapterFactory adapterFactory, final IProgressMonitor monitor )
    {
        logger.trace ( "Validate file - file: {}", candidate );

        try
        {
            // delete all validation markers before starting
            candidate.deleteMarkers ( EValidator.MARKER, false, IResource.DEPTH_ZERO );

            final ResourceSet rs = new ResourceSetImpl ();

            final Resource r = rs.createResource ( makeUri ( candidate ) );
            r.load ( null );

            final Diagnostician diag = new ProjectDiagnostician ( adapterFactory );

            final EList<EObject> contents = r.getContents ();
            final String message = null;

            final BasicDiagnostic diagnostic = new BasicDiagnostic ( EObjectValidator.DIAGNOSTIC_SOURCE, 0, message, contents.toArray () );
            final Map<Object, Object> context = diag.createDefaultContext ();
            for ( final EObject content : contents )
            {
                diag.validate ( content, diagnostic, context );
            }

            this.helper.createMarkers ( diagnostic );
        }
        catch ( final CoreException e )
        {
            StatusManager.getManager ().handle ( e.getStatus () );
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }
    }

    public boolean isModelFile ( final IFile candidate, final Set<String> extensions )
    {
        final String ext = candidate.getFileExtension ();
        logger.debug ( "Is model file - file: {}, ext: {}, list: {}", candidate, ext, extensions );

        if ( extensions.contains ( ext ) )
        {
            logger.debug ( "This file is a model file" );
            return true;
        }
        return false;
    }

    public boolean handleResource ( final IResourceDelta delta, final IResource resource, final ComposedAdapterFactory adapterFactory, final Set<String> extensions, final IProgressMonitor monitor )
    {
        logger.debug ( "Handle resource - file: {}", resource );

        if ( resource instanceof IProject )
        {
            return isInterestingProject ( (IProject)resource );
        }

        if ( resource instanceof IFolder )
        {
            return true;
        }

        if ( resource instanceof IFile )
        {
            final IFile file = (IFile)resource;
            if ( !isModelFile ( file, extensions ) )
            {
                return false;
            }

            if ( delta == null || delta.getKind () != IResourceDelta.REMOVED )
            {
                validateFile ( file, adapterFactory, monitor );
            }
        }
        return false;
    }
}
