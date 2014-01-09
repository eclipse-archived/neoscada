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
package org.eclipse.scada.configuration.ui.project.template;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelFactory;

public abstract class AbstractVITemplate extends BaseTemplate
{

    protected IPluginElement createViewerExtension ( final IPluginModelFactory factory, final IPluginExtension ext, final String localId, final String align, final String location, final String className ) throws CoreException
    {
        final IPluginElement viewerExtension = addElement ( factory, ext, "viewerExtension", makeId ( localId ) ); //$NON-NLS-1$ 
        viewerExtension.setAttribute ( "align", align ); //$NON-NLS-1$ 
        viewerExtension.setAttribute ( "location", location ); //$NON-NLS-1$ 

        final IPluginElement classElement = addElement ( factory, viewerExtension, "class", null ); //$NON-NLS-1$ 
        classElement.setAttribute ( "class", className ); //$NON-NLS-1$ 

        return classElement;
    }

    protected IPluginElement createViewInstance ( final IPluginModelFactory factory, final IPluginExtension ext, final String localId, final boolean defaultInstance, final boolean mainView, final String label, final String resource, final boolean zooming ) throws CoreException
    {
        final IPluginElement viewExtension = addElement ( factory, ext, "viewInstance", makeId ( localId ) ); //$NON-NLS-1$ 

        viewExtension.setAttribute ( "factoryClass", "org.eclipse.scada.vi.ui.user.VisualInterfaceFactory" ); //$NON-NLS-1$ //$NON-NLS-2$
        viewExtension.setAttribute ( "defaultInstance", "" + defaultInstance ); //$NON-NLS-1$ //$NON-NLS-2$
        viewExtension.setAttribute ( "mainView", "" + mainView ); //$NON-NLS-1$ //$NON-NLS-2$
        viewExtension.setAttribute ( "zooming", "" + zooming ); //$NON-NLS-1$ //$NON-NLS-2$

        viewExtension.setAttribute ( "name", label ); //$NON-NLS-1$ 
        viewExtension.setAttribute ( "resource", resource ); //$NON-NLS-1$ 

        return viewExtension;
    }

    protected void addExpressionByDefinition ( final IPluginModelFactory factory, final IPluginExtension ext, final IPluginElement parent, final String elementName, final String definitionId ) throws CoreException
    {
        final IPluginElement expression = addElement ( factory, parent, elementName, null );
        final IPluginElement ref = addElement ( factory, expression, "reference", null );
        ref.setAttribute ( "definitionId", definitionId );
    }

}