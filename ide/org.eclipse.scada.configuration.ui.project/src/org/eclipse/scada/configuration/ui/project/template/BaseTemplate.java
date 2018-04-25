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

import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginModelFactory;
import org.eclipse.pde.core.plugin.IPluginReference;
import org.eclipse.pde.ui.IFieldData;
import org.eclipse.pde.ui.templates.OptionTemplateSection;
import org.eclipse.pde.ui.templates.TemplateOption;
import org.eclipse.scada.configuration.ui.project.Activator;
import org.osgi.framework.Bundle;

public abstract class BaseTemplate extends OptionTemplateSection
{

    protected static IPluginElement addElement ( final IPluginModelFactory factory, final IPluginElement parent, final String name, final String id ) throws CoreException
    {
        final IPluginElement element = factory.createElement ( parent );
        parent.add ( element );
        element.setName ( name );
        if ( id != null )
        {
            element.setAttribute ( "id", id ); //$NON-NLS-1$
        }
        return element;
    }

    protected static IPluginElement addElement ( final IPluginModelFactory factory, final IPluginExtension parent, final String name, final String id ) throws CoreException
    {
        final IPluginElement element = factory.createElement ( parent );
        parent.add ( element );
        element.setName ( name );
        if ( id != null )
        {
            element.setAttribute ( "id", id ); //$NON-NLS-1$
        }
        return element;
    }

    protected static void addParameter ( final IPluginModelFactory factory, final IPluginElement ele, final String key, final String value ) throws CoreException
    {
        final IPluginElement param = factory.createElement ( ele );
        param.setName ( "parameter" ); //$NON-NLS-1$
        param.setAttribute ( "name", key ); //$NON-NLS-1$
        param.setAttribute ( "value", value ); //$NON-NLS-1$
        ele.add ( param );
    }

    protected static void addProperty ( final IPluginModelFactory factory, final IPluginElement ele, final String key, final String value ) throws CoreException
    {
        final IPluginElement param = factory.createElement ( ele );
        param.setName ( "property" ); //$NON-NLS-1$
        param.setAttribute ( "name", key ); //$NON-NLS-1$
        param.setAttribute ( "value", value ); //$NON-NLS-1$
        ele.add ( param );
    }

    protected String pluginId;

    protected String version;

    protected String getFormattedPackageName ( final String id )
    {
        final StringBuffer buffer = new StringBuffer ();
        for ( int i = 0; i < id.length (); i++ )
        {
            final char ch = id.charAt ( i );
            if ( buffer.length () == 0 )
            {
                if ( Character.isJavaIdentifierStart ( ch ) )
                {
                    buffer.append ( Character.toLowerCase ( ch ) );
                }
            }
            else
            {
                if ( Character.isJavaIdentifierPart ( ch ) || ch == '.' )
                {
                    buffer.append ( ch );
                }
            }
        }
        return buffer.toString ().toLowerCase ( Locale.ENGLISH );
    }

    @Override
    protected ResourceBundle getPluginResourceBundle ()
    {
        final Bundle bundle = Platform.getBundle ( Activator.getPluginId () );
        return Platform.getResourceBundle ( bundle );
    }

    @Override
    protected URL getInstallURL ()
    {
        return Activator.getDefault ().getInstallURL ();
    }

    @Override
    protected String getTemplateDirectory ()
    {
        return "templates/scada/0.1"; //$NON-NLS-1$
    }

    protected String makeConnectionId ( final String tag )
    {
        return String.format ( "connection.%s.main", tag ); //$NON-NLS-1$
    }

    @Override
    public IPluginReference[] getDependencies ( final String schemaVersion )
    {
        final List<IPluginReference> deps = new LinkedList<IPluginReference> ();
        IPluginReference[] parentDeps = super.getDependencies ( schemaVersion );
        if ( parentDeps != null )
        {
            deps.addAll ( Arrays.asList ( parentDeps ) );
        }

        fillDependencies ( deps, schemaVersion );

        return deps.toArray ( new IPluginReference[deps.size ()] );
    }

    protected abstract void fillDependencies ( Collection<IPluginReference> dependencies, String schemaVersion );

    @Override
    public boolean isDependentOnParentWizard ()
    {
        return true;
    }

    @Override
    protected void initializeFields ( final IFieldData data )
    {
        this.pluginId = data.getId ();
        this.version = data.getVersion ();
    }

    @Override
    public void initializeFields ( final IPluginModelBase model )
    {
        this.pluginId = model.getPluginBase ().getId ();
        this.version = model.getPluginBase ().getVersion ();
    }

    protected String makeId ( final String localId )
    {
        return getFormattedPackageName ( String.format ( "%s.%s", this.pluginId, localId ) ); //$NON-NLS-1$
    }

    /**
     * Locates the page that this option is presented in and flags that the
     * option
     * is required and is currently not set. The flagging is done by setting the
     * page incomplete and setting the error message that uses option's message
     * label.
     *
     * @param option
     *            the option that is required and currently not set
     */
    protected void flagErrorMessage ( final TemplateOption option, final String newMessage, final int newType )
    {
        for ( int i = 0; i < getPageCount (); i++ )
        {
            final WizardPage page = getPage ( i );
            for ( final TemplateOption pageOption : getOptions ( i ) )
            {
                if ( pageOption.equals ( option ) )
                {
                    page.setPageComplete ( false );
                    page.setMessage ( newMessage, newType );
                }
            }
        }
    }
}
