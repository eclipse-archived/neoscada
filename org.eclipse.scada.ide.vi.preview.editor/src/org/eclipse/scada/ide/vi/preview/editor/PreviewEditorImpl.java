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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.scada.vi.model.Symbol;
import org.eclipse.scada.vi.ui.draw2d.VisualInterfaceViewer;
import org.eclipse.scada.vi.ui.draw2d.loader.StaticSymbolLoader;
import org.eclipse.scada.vi.ui.draw2d.loader.SymbolLoader;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PreviewEditorImpl extends AbstractModelEditor
{
    private final static Logger logger = LoggerFactory.getLogger ( PreviewEditorImpl.class );

    private final ComposedAdapterFactory adapterFactory;

    private final AdapterFactoryEditingDomain editingDomain;

    private Composite symbolArea;

    private VisualInterfaceViewer viewer;

    public PreviewEditorImpl ()
    {
        this.adapterFactory = new ComposedAdapterFactory ( ComposedAdapterFactory.Descriptor.Registry.INSTANCE );
        this.adapterFactory.addAdapterFactory ( new ResourceItemProviderAdapterFactory () );
        this.adapterFactory.addAdapterFactory ( new ReflectiveItemProviderAdapterFactory () );

        final BasicCommandStack commandStack = new BasicCommandStack ();

        this.editingDomain = new AdapterFactoryEditingDomain ( this.adapterFactory, commandStack, new HashMap<Resource, Boolean> () );
    }

    @Override
    public EditingDomain getEditingDomain ()
    {
        return this.editingDomain;
    }

    @Override
    public void dispose ()
    {
        this.adapterFactory.dispose ();
        super.dispose ();
    }

    private void dumpState ()
    {
        final EObject object = getModelObject ();

        logger.info ( "Main object: {}", object );

        if ( object instanceof Symbol )
        {
            if ( ( (Symbol)object ).getRoot () != null )
            {
                logger.info ( "root name: {}", ( (Symbol)object ).getRoot ().getName () );
            }
        }
    }

    @Override
    public void init ( final IEditorSite site, final IEditorInput input ) throws PartInitException
    {
        super.init ( site, input );
        dumpState ();
    }

    public void reload ()
    {
        dumpState ();
        updateSymbol ();
    }

    @Override
    protected void handleInputChanged ( final List<Resource> changedResources, final List<Resource> removedResources )
    {
        super.handleInputChanged ( changedResources, removedResources );
        dumpState ();
        updateSymbol ();
    }

    @Override
    public void createPartControl ( final Composite parent )
    {
        final Composite wrapper = new Composite ( parent, SWT.NONE );
        final GridLayout layout = new GridLayout ( 1, false );
        layout.marginHeight = layout.marginWidth = 0;
        wrapper.setLayout ( layout );

        this.symbolArea = new Composite ( wrapper, SWT.NONE );
        this.symbolArea.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );
        this.symbolArea.setLayout ( new FillLayout () );

        updateSymbol ();
    }

    private void updateSymbol ()
    {
        if ( this.symbolArea == null )
        {
            // too early
            return;
        }

        if ( this.viewer != null )
        {
            this.viewer.dispose ();
            this.viewer = null;
        }

        final Symbol symbol = getSymbol ();
        if ( symbol != null )
        {
            final Map<String, String> properties = new HashMap<> ();
            final SymbolLoader symbolLoader = new StaticSymbolLoader ( symbol, getInterfaceClassLoader () );
            final Map<String, Object> scriptObjects = new HashMap<> ();
            this.viewer = new VisualInterfaceViewer ( this.symbolArea, SWT.NONE, symbolLoader, scriptObjects, properties );
        }
        this.symbolArea.layout ();
    }

    protected ClassLoader getInterfaceClassLoader ()
    {
        return Activator.class.getClassLoader ();
    }

    private Symbol getSymbol ()
    {
        final Object o = getModelObject ();
        if ( o instanceof Symbol )
        {
            return (Symbol)o;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setFocus ()
    {
        if ( this.viewer != null )
        {
            this.viewer.setFocus ();
        }
    }

}
