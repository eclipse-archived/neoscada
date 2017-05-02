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
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelFactory;
import org.eclipse.pde.core.plugin.IPluginReference;
import org.eclipse.pde.ui.templates.PluginReference;
import org.eclipse.scada.configuration.ui.project.IHelpContextIds;

public class DetailViewTemplate extends BaseTemplate
{

    private static final String OPT_NAME = "name"; //$NON-NLS-1$  

    private String id;

    private String name;

    public DetailViewTemplate ()
    {
        setPageCount ( 1 );
        createOptions ( "detailView" );
    }

    public DetailViewTemplate ( final String id, final String name )
    {
        this.id = id;
        this.name = name;

        setPageCount ( 1 );
        createOptions ( name );

        setOptionEnabled ( OPT_NAME, false );
    }

    private void createOptions ( final String name )
    {
        addOption ( OPT_NAME, Messages.DetailViewTemplate_Option_Name_Label, name, 0 );
    }

    @Override
    public void addPages ( final Wizard wizard )
    {
        if ( this.id == null )
        {
            final WizardPage page = createPage ( 0, IHelpContextIds.TEMPLATE_DETAIL_VIEW );
            page.setTitle ( Messages.DetailViewTemplate_Page_Title );
            page.setDescription ( Messages.DetailViewTemplate_Page_Description );
            wizard.addPage ( page );
            markPagesAdded ();
        }
    }

    @Override
    public String getUsedExtensionPoint ()
    {
        return "org.eclipse.scada.vi.details.detailView"; //$NON-NLS-1$
    }

    @Override
    public String[] getNewFiles ()
    {
        return new String[] { "resources/" }; //$NON-NLS-1$
    }

    @Override
    public String getSectionId ()
    {
        return "detailView"; //$NON-NLS-1$
    }

    @Override
    protected void fillDependencies ( final Collection<IPluginReference> dependencies, final String schemaVersion )
    {
        dependencies.add ( new PluginReference ( "org.eclipse.scada.vi.details", "0.1.0", 0 ) ); //$NON-NLS-1$  //$NON-NLS-2$
        dependencies.add ( new PluginReference ( "org.eclipse.scada.vi.details.swt", "0.1.0", 0 ) ); //$NON-NLS-1$  //$NON-NLS-2$
    }

    @Override
    protected void updateModel ( final IProgressMonitor monitor ) throws CoreException
    {
        final String name = this.name != null ? this.name : getName ();

        final IPluginModelFactory factory = this.model.getPluginFactory ();

        final IPluginExtension ext = createExtension ( "org.eclipse.scada.vi.details.detailView", true ); //$NON-NLS-1$
        if ( !ext.isInTheModel () )
        {
            this.model.getPluginBase ().add ( ext );
        }

        final IPluginElement view = addElement ( factory, ext, "detailView", makeId ( name ) ); //$NON-NLS-1$
        final IPluginElement viewClass = addElement ( factory, view, "class", null ); //$NON-NLS-1$
        viewClass.setAttribute ( "class", "org.eclipse.scada.vi.details.swt.impl.DetailViewImpl" ); //$NON-NLS-1$  //$NON-NLS-2$

        addParameter ( factory, viewClass, "uri", String.format ( "platform:/plugin/%s/%s", this.model.getPluginBase ().getId (), makeViewFileName ( name ) ) ); //$NON-NLS-1$  //$NON-NLS-2$
    }

    @Override
    protected String makeId ( final String name )
    {
        if ( this.id != null )
        {
            return this.id;
        }
        else
        {
            return super.makeId ( name );
        }
    }

    protected String makeViewFileName ( final String name )
    {
        return String.format ( "resources/details/%s.detailview", name ); //$NON-NLS-1$
    }

    private String getName ()
    {
        return getStringOption ( OPT_NAME );
    }

}
