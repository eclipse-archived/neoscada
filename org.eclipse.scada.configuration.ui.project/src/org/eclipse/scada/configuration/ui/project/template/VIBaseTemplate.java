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

import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelFactory;
import org.eclipse.pde.core.plugin.IPluginReference;
import org.eclipse.pde.ui.templates.PluginReference;

public class VIBaseTemplate extends AbstractVITemplate
{

    @Override
    public String getUsedExtensionPoint ()
    {
        return "org.eclipse.scada.vi.ui.user.viewer"; //$NON-NLS-1$
    }

    @Override
    public String[] getNewFiles ()
    {
        return new String[] { "resources/" }; //$NON-NLS-1$
    }

    @Override
    public String getSectionId ()
    {
        return "viBase"; //$NON-NLS-1$
    }

    @Override
    protected void fillDependencies ( final Collection<IPluginReference> dependencies, final String schemaVersion )
    {
        dependencies.add ( new PluginReference ( "org.eclipse.scada.vi.ui.user", "0.1.0", 0 ) ); //$NON-NLS-1$  //$NON-NLS-2$
        dependencies.add ( new PluginReference ( "org.eclipse.scada.vi.ui.viewer.ext", "0.1.0", 0 ) ); //$NON-NLS-1$  //$NON-NLS-2$

        dependencies.add ( new PluginReference ( "org.eclipse.scada.ui.chart.view", "0.1.0", 0 ) ); //$NON-NLS-1$  //$NON-NLS-2$
    }

    @Override
    protected void updateModel ( final IProgressMonitor monitor ) throws CoreException
    {
        final IPluginModelFactory factory = this.model.getPluginFactory ();

        final IPluginExtension ext = createExtension ( "org.eclipse.scada.vi.ui.user.viewer", false ); //$NON-NLS-1$
        if ( !ext.isInTheModel () )
        {
            this.model.getPluginBase ().add ( ext );
        }

        final IPluginExtension viewExt = createExtension ( "org.eclipse.scada.vi.ui.user.view", false );; //$NON-NLS-1$
        if ( !viewExt.isInTheModel () )
        {
            this.model.getPluginBase ().add ( viewExt );
        }

        IPluginElement classElement;

        classElement = createViewerExtension ( factory, ext, "main.navigator", "FILL", "LEFT", "org.eclipse.scada.vi.ui.user.viewer.ext.ToolBarNavigatorExtension" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        classElement = createViewerExtension ( factory, ext, "main.breadcrumbs", "FILL", "TOP", "org.eclipse.scada.vi.ui.user.viewer.ext.BreadcrumbNavigatorExtension" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

        classElement = createViewerExtension ( factory, ext, "main.sep1", "END", "TOP", "org.eclipse.scada.vi.ui.user.viewer.ext.SeparatorExtension" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        addParameter ( factory, classElement, "invisible", "true" ); //$NON-NLS-1$ //$NON-NLS-2$ 

        classElement = createViewerExtension ( factory, ext, "main.message", "FILL", "TOP", "org.eclipse.scada.vi.ui.viewer.ext.item.SystemMessageExtension" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        addParameter ( factory, classElement, "connectionId", makeConnectionId ( "main" ) ); //$NON-NLS-1$ //$NON-NLS-2$ 
        addParameter ( factory, classElement, "itemId", "ES.DEMO.SCADA.SYSMSG.V" ); //$NON-NLS-1$ //$NON-NLS-2$ 

        classElement = createViewerExtension ( factory, ext, "main.logo", "END", "TOP", "org.eclipse.scada.vi.ui.viewer.ext.image.ImageExtension" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        addParameter ( factory, classElement, "url", "platform:/plugin/" + this.pluginId + "/resources/customerLogo.png" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 

        classElement = createViewerExtension ( factory, ext, "main.debug", "END", "TOP", "org.eclipse.scada.vi.ui.user.viewer.ext.DebugActionExtension" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

        IPluginElement viewElement;
        viewElement = createViewInstance ( factory, viewExt, "placeholder", true, false, "Logon", "resources/views/placeholder.vi", false ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        addExpressionByDefinition ( factory, ext, viewElement, "visibility", makeId ( "noSession" ) );

        viewElement = createViewInstance ( factory, viewExt, "main", true, true, "Main", "resources/views/main.vi", false ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        addExpressionByDefinition ( factory, ext, viewElement, "visibility", makeId ( "hasSession" ) );
    }

}
