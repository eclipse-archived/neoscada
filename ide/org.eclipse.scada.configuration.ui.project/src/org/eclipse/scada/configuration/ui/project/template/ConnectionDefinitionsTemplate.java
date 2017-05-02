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

public class ConnectionDefinitionsTemplate extends BaseTemplate
{

    @Override
    public String getUsedExtensionPoint ()
    {
        return "org.eclipse.core.expressions.definitions"; //$NON-NLS-1$
    }

    @Override
    public String getSectionId ()
    {
        return "connectionDefinitions"; //$NON-NLS-1$
    }

    @Override
    public String[] getNewFiles ()
    {
        return new String[0];
    }

    @Override
    protected void fillDependencies ( final Collection<IPluginReference> dependencies, final String schemaVersion )
    {
        dependencies.add ( new PluginReference ( "org.eclipse.core.expressions", null, 0 ) ); //$NON-NLS-1$ 
        dependencies.add ( new PluginReference ( "org.eclipse.scada.core.ui.connection.login", "0.1.0", 0 ) ); //$NON-NLS-1$ //$NON-NLS-2$ 
    }

    @Override
    protected void updateModel ( final IProgressMonitor monitor ) throws CoreException
    {
        final IPluginModelFactory factory = this.model.getPluginFactory ();

        createExpressions ( factory );
    }

    protected void createExpressions ( final IPluginModelFactory factory ) throws CoreException
    {

        final IPluginExtension ext = factory.createExtension ();
        this.model.getPluginBase ().add ( ext );
        ext.setPoint ( "org.eclipse.core.expressions.definitions" ); //$NON-NLS-1$ 

        {
            final IPluginElement def = addElement ( factory, ext, "definition", makeId ( "noSession" ) ); //$NON-NLS-1$ //$NON-NLS-2$ 
            final IPluginElement and = addElement ( factory, def, "and", null ); //$NON-NLS-1$ 
            final IPluginElement not = addElement ( factory, and, "not", null ); //$NON-NLS-1$ 
            final IPluginElement with = addElement ( factory, not, "with", null ); //$NON-NLS-1$ 
            with.setAttribute ( "variable", "org.eclipse.scada.core.ui.connection.login.sessionState" ); //$NON-NLS-1$ //$NON-NLS-2$ 
            final IPluginElement equals = addElement ( factory, with, "equals", null ); //$NON-NLS-1$ 
            equals.setAttribute ( "value", "loggedIn" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        }
        {
            final IPluginElement def = addElement ( factory, ext, "definition", makeId ( "hasSession" ) ); //$NON-NLS-1$ //$NON-NLS-2$ 
            final IPluginElement and = addElement ( factory, def, "and", null ); //$NON-NLS-1$ 
            final IPluginElement with = addElement ( factory, and, "with", null ); //$NON-NLS-1$ 
            with.setAttribute ( "variable", "org.eclipse.scada.core.ui.connection.login.sessionState" ); //$NON-NLS-1$ //$NON-NLS-2$ 
            final IPluginElement equals = addElement ( factory, with, "equals", null ); //$NON-NLS-1$ 
            equals.setAttribute ( "value", "loggedIn" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        }
    }
}
