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
package org.eclipse.scada.ide.vi.preview.editor;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractModelEditor extends EditorPart implements IEditingDomainProvider
{
    private final static Logger logger = LoggerFactory.getLogger ( AbstractModelEditor.class );

    private final IResourceChangeListener resourceChangeListener = new IResourceChangeListener () {
        @Override
        public void resourceChanged ( final IResourceChangeEvent event )
        {
            final IResourceDelta delta = event.getDelta ();

            try
            {
                class ResourceDeltaVisitor implements IResourceDeltaVisitor
                {
                    protected ResourceSet resourceSet = getEditingDomain ().getResourceSet ();

                    protected List<Resource> changedResources = new LinkedList<> ();

                    protected List<Resource> removedResources = new LinkedList<> ();

                    @Override
                    public boolean visit ( final IResourceDelta delta )
                    {
                        if ( delta.getResource ().getType () != IResource.FILE )
                        {
                            return true;
                        }

                        if ( delta.getFlags () == IResourceDelta.MARKERS )
                        {
                            // only a marker change
                            return false;
                        }

                        final Resource resource = this.resourceSet.getResource ( URI.createPlatformResourceURI ( delta.getFullPath ().toString (), true ), false );

                        if ( resource == null )
                        {
                            // something that we don't know of changed
                            return false;
                        }

                        switch ( delta.getKind () )
                        {
                            case IResourceDelta.REMOVED:
                                this.removedResources.add ( resource );
                                break;
                            case IResourceDelta.CHANGED:
                                this.changedResources.add ( resource );
                                break;
                        }

                        return false;
                    }

                    public boolean isChanged ()
                    {
                        return !this.removedResources.isEmpty () || !this.changedResources.isEmpty ();
                    }
                }

                final ResourceDeltaVisitor visitor = new ResourceDeltaVisitor ();
                delta.accept ( visitor );

                if ( visitor.isChanged () )
                {
                    getSite ().getShell ().getDisplay ().asyncExec ( new Runnable () {

                        @Override
                        public void run ()
                        {
                            handleInputChanged ( visitor.changedResources, visitor.removedResources );
                        }

                    } );
                }
            }
            catch ( final CoreException exception )
            {
                Activator.getDefault ().getLog ().log ( exception.getStatus () );
            }
        }
    };

    private IFileEditorInput fileInput;

    @Override
    public void init ( final IEditorSite site, final IEditorInput input ) throws PartInitException
    {
        setSite ( site );
        setInputWithNotify ( input );
        setPartName ( input.getName () );

        ResourcesPlugin.getWorkspace ().addResourceChangeListener ( this.resourceChangeListener, IResourceChangeEvent.POST_CHANGE );
    }

    @Override
    public void dispose ()
    {
        ResourcesPlugin.getWorkspace ().removeResourceChangeListener ( this.resourceChangeListener );

        super.dispose ();
    }

    @Override
    protected void setInputWithNotify ( final IEditorInput input )
    {
        super.setInputWithNotify ( input );

        this.fileInput = (IFileEditorInput)input;
        final IFile file = this.fileInput.getFile ();

        try
        {
            final URI uri = URI.createPlatformResourceURI ( file.getFullPath ().toString (), true );
            // we need a real platform URI since otherwise the StaticSymbolLoader cannot resolve URIs
            final Resource resource = getEditingDomain ().getResourceSet ().createResource ( uri );
            resource.load ( null );
        }
        catch ( final IOException e )
        {
            throw new RuntimeException ( "Failed to load input", e );
        }
    }

    @Override
    public boolean isDirty ()
    {
        return ( (BasicCommandStack)getEditingDomain ().getCommandStack () ).isSaveNeeded ();
    }

    @Override
    public void doSave ( final IProgressMonitor monitor )
    {
    }

    @Override
    public void doSaveAs ()
    {
    }

    @Override
    public boolean isSaveAsAllowed ()
    {
        return false;
    }

    protected Resource getEditorResource ()
    {
        if ( this.fileInput == null )
        {
            return null;
        }

        final IFile file = this.fileInput.getFile ();
        if ( file == null )
        {
            return null;
        }

        final Resource resource = getEditingDomain ().getResourceSet ().getResource ( URI.createPlatformResourceURI ( file.getFullPath ().toString (), true ), false );
        if ( resource == null )
        {
            return null;
        }

        return resource;
    }

    protected EObject getModelObject ()
    {
        final Resource resource = getEditorResource ();
        if ( resource == null || resource.getContents ().isEmpty () )
        {
            return null;
        }

        return resource.getContents ().get ( 0 );
    }

    protected void handleInputChanged ( final List<Resource> changedResources, final List<Resource> removedResources )
    {
        for ( final Resource resource : removedResources )
        {
            logger.debug ( "Resource removed: {}", resource );
            if ( resource.isLoaded () )
            {
                logger.debug ( "Unloading: {}", resource );
                resource.unload ();
            }
        }

        for ( final Resource resource : changedResources )
        {
            logger.debug ( "Resource changed: {}", resource );
            if ( resource.isLoaded () )
            {
                logger.debug ( "Reloading: {}", resource );
                resource.unload ();
                try
                {
                    resource.load ( null );
                }
                catch ( final IOException e )
                {
                    Activator.getDefault ().getLog ().log ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
                }
            }
        }
    }
}
