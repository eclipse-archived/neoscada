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
package org.eclipse.scada.configuration.ui.project.template;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginModelFactory;
import org.eclipse.pde.core.plugin.IPluginReference;
import org.eclipse.pde.ui.templates.PluginReference;
import org.eclipse.scada.configuration.ui.project.Activator;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.scada.utils.str.StringReplacer;

import com.google.common.io.CharStreams;

public class ClientTemplate extends BaseTemplate
{

    private static final Pattern ALT_PATTERN = Pattern.compile ( "@@(.*?)@@" ); //$NON-NLS-1$

    @Override
    public String getUsedExtensionPoint ()
    {
        return null;
    }

    @Override
    public String[] getNewFiles ()
    {
        return new String[] { "splash.bmp" }; //$NON-NLS-1$
    }

    @Override
    protected void fillDependencies ( final Collection<IPluginReference> dependencies, final String schemaVersion )
    {
        dependencies.add ( new PluginReference ( "org.eclipse.core.runtime", null, 0 ) ); //$NON-NLS-1$
        dependencies.add ( new PluginReference ( "org.eclipse.ui", null, 0 ) ); //$NON-NLS-1$
    }

    @Override
    public String getSectionId ()
    {
        return "rcp"; //$NON-NLS-1$
    }

    @Override
    protected void updateModel ( final IProgressMonitor monitor ) throws CoreException
    {
        final IPluginModelFactory factory = this.model.getPluginFactory ();
        final IPluginBase plugin = this.model.getPluginBase ();

        createApplication ( factory, plugin );
        createProduct ( factory, plugin );
        createPerspective ( factory, plugin );
        createMenu ( factory, plugin );
        createActivity ( factory, plugin );
    }

    private void createActivity ( final IPluginModelFactory factory, final IPluginBase plugin ) throws CoreException
    {
        final String aid = this.pluginId + ".default"; //$NON-NLS-1$

        final IPluginExtension ae = createExtension ( "org.eclipse.ui.activities", true ); //$NON-NLS-1$
        plugin.add ( ae );

        addElement ( factory, ae, "activity", aid ).setAttribute ( "name", "Default" ); //$NON-NLS-1$ //$NON-NLS-2$

        {
            final IPluginElement e = addElement ( factory, ae, "activityPatternBinding", null ); //$NON-NLS-1$
            e.setAttribute ( "activityId", aid ); //$NON-NLS-1$
            e.setAttribute ( "isEqualityPattern", "false" ); //$NON-NLS-1$ //$NON-NLS-2$
            e.setAttribute ( "pattern", ".*\\/org.eclipse.ui.openLocalFile" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        {
            final IPluginElement e = addElement ( factory, ae, "activityPatternBinding", null ); //$NON-NLS-1$
            e.setAttribute ( "activityId", aid ); //$NON-NLS-1$
            e.setAttribute ( "isEqualityPattern", "false" ); //$NON-NLS-1$ //$NON-NLS-2$
            e.setAttribute ( "pattern", ".*\\/org.eclipse.ui.edit.text.delimiter\\..*" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    private void createMenu ( final IPluginModelFactory factory, final IPluginBase plugin ) throws CoreException
    {
        final IPluginExtension me = createExtension ( "org.eclipse.ui.menus", true ); //$NON-NLS-1$
        plugin.add ( me );

        final IPluginElement mc = addElement ( factory, me, "menuContribution", null ); //$NON-NLS-1$
        mc.setAttribute ( "locationURI", "menu:org.eclipse.ui.main.menu" ); //$NON-NLS-1$ //$NON-NLS-2$

        {
            final IPluginElement m = addMenu ( factory, mc, "file", "File" ); //$NON-NLS-1$
            addMenuSep ( factory, m, "new.ext", true ); //$NON-NLS-1$
            addMenuCommand ( factory, m, "org.eclipse.ui.file.exit", null ); //$NON-NLS-1$
        }
        addMenuSep ( factory, mc, "additions", null ); //$NON-NLS-1$
        {
            final IPluginElement m = addMenu ( factory, mc, "window", "Window" ); //$NON-NLS-1$
            addMenuCommand ( factory, m, "org.eclipse.ui.window.newWindow", null ); //$NON-NLS-1$
            addMenuSep ( factory, m, "resetPerspectiveSeparator", false ); //$NON-NLS-1$
            addMenuCommand ( factory, m, "org.eclipse.ui.window.resetPerspective", null ); //$NON-NLS-1$
            addMenuSep ( factory, m, "additions", null ); //$NON-NLS-1$
            addMenuSep ( factory, m, "sep3", true ); //$NON-NLS-1$
            addMenuCommand ( factory, m, "org.eclipse.ui.window.preferences", null ); //$NON-NLS-1$

            final IPluginElement c = addMenuCommand ( factory, m, "org.eclipse.ui.views.showView", null ); //$NON-NLS-1$
            c.setAttribute ( "style", "pulldown" ); //$NON-NLS-1$ //$NON-NLS-2$
            final IPluginElement vw = addElement ( factory, c, "visibleWhen", null ); //$NON-NLS-1$
            vw.setAttribute ( "checkEnabled", "false" ); //$NON-NLS-1$ //$NON-NLS-2$
            final IPluginElement st = addElement ( factory, vw, "systemTest", null ); //$NON-NLS-1$
            st.setAttribute ( "property", "scada.debug" ); //$NON-NLS-1$ //$NON-NLS-2$
            st.setAttribute ( "value", "true" ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        {
            final IPluginElement m = addMenu ( factory, mc, "help", "Help" ); //$NON-NLS-1$
            addMenuCommand ( factory, m, "org.eclipse.ui.help.aboutAction", null ); //$NON-NLS-1$
        }
    }

    private IPluginElement addMenuCommand ( final IPluginModelFactory factory, final IPluginElement m, final String commandId, final String label ) throws CoreException
    {
        final IPluginElement c = addElement ( factory, m, "command", null ); //$NON-NLS-1$
        c.setAttribute ( "commandId", commandId ); //$NON-NLS-1$
        if ( label != null )
        {
            c.setAttribute ( "label", label ); //$NON-NLS-1$
        }
        return c;
    }

    private void addMenuSep ( final IPluginModelFactory factory, final IPluginElement m, final String name, final Boolean visible ) throws CoreException
    {
        final IPluginElement s = addElement ( factory, m, "separator", null ); //$NON-NLS-1$
        s.setAttribute ( "name", name ); //$NON-NLS-1$
        if ( visible != null )
        {
            s.setAttribute ( "visible", "" + visible ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    private IPluginElement addMenu ( final IPluginModelFactory factory, final IPluginElement mc, final String id, final String label ) throws CoreException
    {
        final IPluginElement m = addElement ( factory, mc, "menu", id ); //$NON-NLS-1$
        m.setAttribute ( "label", label ); //$NON-NLS-1$
        return m;
    }

    private void createPerspective ( final IPluginModelFactory factory, final IPluginBase plugin ) throws CoreException
    {
        final String perspectiveId = this.pluginId + ".perspective"; //$NON-NLS-1$

        final IPluginExtension pe = createExtension ( "org.eclipse.ui.perspectives", true ); //$NON-NLS-1$
        plugin.add ( pe );

        final IPluginElement p = addElement ( factory, pe, "perspective", perspectiveId ); //$NON-NLS-1$
        p.setAttribute ( "name", "Default perspective" ); //$NON-NLS-1$
        p.setAttribute ( "class", this.pluginId + ".Perspective" ); //$NON-NLS-1$ //$NON-NLS-2$

        final IPluginExtension px = createExtension ( "org.eclipse.ui.perspectiveExtensions", true ); //$NON-NLS-1$
        plugin.add ( px );

        final IPluginElement pex = addElement ( factory, px, "perspectiveExtension", null ); //$NON-NLS-1$
        pex.setAttribute ( "targetID", "*" ); //$NON-NLS-1$ //$NON-NLS-2$

        addElement ( factory, pex, "perspectiveShortcut", perspectiveId ); //$NON-NLS-1$

        final IPluginElement pex2 = addElement ( factory, px, "perspectiveExtension", null ); //$NON-NLS-1$
        pex2.setAttribute ( "targetID", perspectiveId ); //$NON-NLS-1$

        final IPluginElement view = addElement ( factory, pex2, "view", "org.eclipse.scada.vi.ui.user.SingleVisualInterfaceView" ); //$NON-NLS-1$ //$NON-NLS-2$
        view.setAttribute ( "closeable", "false" ); //$NON-NLS-1$ //$NON-NLS-2$
        view.setAttribute ( "minimized", "false" ); //$NON-NLS-1$ //$NON-NLS-2$
        view.setAttribute ( "moveable", "false" ); //$NON-NLS-1$ //$NON-NLS-2$
        view.setAttribute ( "relationship", "top" ); //$NON-NLS-1$ //$NON-NLS-2$
        view.setAttribute ( "relative", "org.eclipse.ui.editorss" ); //$NON-NLS-1$ //$NON-NLS-2$
        view.setAttribute ( "showTitle", "false" ); //$NON-NLS-1$ //$NON-NLS-2$
        view.setAttribute ( "standalone", "true" ); //$NON-NLS-1$ //$NON-NLS-2$
        view.setAttribute ( "visible", "true" ); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private void createProduct ( final IPluginModelFactory factory, final IPluginBase plugin ) throws CoreException
    {
        final IPluginExtension prodExt = createExtension ( "org.eclipse.core.runtime.products", false ); //$NON-NLS-1$
        prodExt.setId ( "product" ); //$NON-NLS-1$
        plugin.add ( prodExt );

        final IPluginElement prod = addElement ( factory, prodExt, "product", null ); //$NON-NLS-1$
        prod.setAttribute ( "application", this.pluginId + ".application" ); //$NON-NLS-1$ //$NON-NLS-2$
        prod.setAttribute ( "name", "Eclipse SCADA Client Application" );//$NON-NLS-1$

        addProperty ( factory, prod, "cssTheme", "org.eclipse.e4.ui.css.theme.e4_default" ); //$NON-NLS-1$ //$NON-NLS-2$
        addProperty ( factory, prod, "appName", "Eclipse SCADA Client Application" );
    }

    protected void createApplication ( final IPluginModelFactory factory, final IPluginBase plugin ) throws CoreException
    {
        final IPluginExtension appExt = createExtension ( "org.eclipse.core.runtime.applications", false ); //$NON-NLS-1$
        appExt.setId ( "application" ); //$NON-NLS-1$
        plugin.add ( appExt );

        final IPluginElement app = addElement ( factory, appExt, "application", null ); //$NON-NLS-1$
        final IPluginElement run = addElement ( factory, app, "run", null ); //$NON-NLS-1$
        run.setAttribute ( "class", this.pluginId + ".Application" ); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private final String[] resources = new String[] { //
            "icons/feature.png", //$NON-NLS-1$
            "icons/app/icon.ico", //$NON-NLS-1$
            "icons/app/icon.xpm", //$NON-NLS-1$
            "icons/app/icon.icns", //$NON-NLS-1$
            "icons/app/icon_16px.png", //$NON-NLS-1$
            "icons/app/icon_32px.png", //$NON-NLS-1$
            "icons/app/icon_48px.png", //$NON-NLS-1$
            "icons/app/icon_64px.png", //$NON-NLS-1$
            "icons/app/icon_128px.png", //$NON-NLS-1$
    };

    private final String[] filteredResources = new String[] { //
    "app.product" //$NON-NLS-1$
    };

    @Override
    public void execute ( final IProject project, final IPluginModelBase model, final IProgressMonitor monitor ) throws CoreException
    {
        monitor.beginTask ( "Creating client", 5 );

        super.execute ( project, model, new SubProgressMonitor ( monitor, 1 ) ); // COUNT:1

        final Map<String, String> properties = new HashMap<> ();
        properties.put ( "pluginId", this.pluginId ); //$NON-NLS-1$
        properties.put ( "version", this.version ); //$NON-NLS-1$
        properties.put ( "mavenVersion", this.version.replaceFirst ( "\\.qualifier$", "-SNAPSHOT" ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

        createParentProject ( project, properties, new SubProgressMonitor ( monitor, 1 ) ); // COUNT:1
        createProductProject ( project, properties, new SubProgressMonitor ( monitor, 1 ) ); // COUNT:1
        createFeatureProject ( project, properties, new SubProgressMonitor ( monitor, 1 ) ); // COUNT:1

        addFilteredResource ( project, "pom.xml", getResource ( "app-pom.xml" ), "UTF-8", properties, new SubProgressMonitor ( monitor, 1 ) ); // COUNT:1
    }

    private void createParentProject ( final IProject project, final Map<String, String> properties, final IProgressMonitor monitor ) throws CoreException
    {
        monitor.beginTask ( "Creating parent project", 3 );

        final String name = this.pluginId + "-parent"; //$NON-NLS-1$
        final IProjectDescription desc = project.getWorkspace ().newProjectDescription ( name );

        final IProject newProject = project.getWorkspace ().getRoot ().getProject ( name );
        newProject.create ( desc, new SubProgressMonitor ( monitor, 1 ) ); // COUNT:1
        newProject.open ( new SubProgressMonitor ( monitor, 1 ) ); // COUNT:1

        addFilteredResource ( newProject, "pom.xml", getResource ( "parent-pom.xml" ), "UTF-8", properties, new SubProgressMonitor ( monitor, 1 ) ); // COUNT:1

        monitor.done ();
    }

    private void createFeatureProject ( final IProject project, final Map<String, String> properties, final IProgressMonitor monitor ) throws CoreException
    {
        monitor.beginTask ( "Creating feature project", 6 );

        final String name = this.pluginId + ".feature"; //$NON-NLS-1$
        final IProjectDescription desc = project.getWorkspace ().newProjectDescription ( name );

        final ICommand featureBuilder = desc.newCommand ();
        featureBuilder.setBuilderName ( "org.eclipse.pde.FeatureBuilder" ); //$NON-NLS-1$

        desc.setNatureIds ( new String[] { "org.eclipse.pde.FeatureNature" } ); //$NON-NLS-1$
        desc.setBuildSpec ( new ICommand[] {
                featureBuilder
        } );

        final IProject newProject = project.getWorkspace ().getRoot ().getProject ( name );
        newProject.create ( desc, new SubProgressMonitor ( monitor, 1 ) ); // COUNT:1
        newProject.open ( new SubProgressMonitor ( monitor, 1 ) ); // COUNT:1

        addFilteredResource ( newProject, "pom.xml", getResource ( "feature-pom.xml" ), "UTF-8", properties, new SubProgressMonitor ( monitor, 1 ) ); // COUNT:1
        addFilteredResource ( newProject, "feature.xml", getResource ( "feature/feature.xml" ), "UTF-8", properties, new SubProgressMonitor ( monitor, 1 ) ); // COUNT:1
        addFilteredResource ( newProject, "feature.properties", getResource ( "feature/feature.properties" ), "ISO-8859-1", properties, new SubProgressMonitor ( monitor, 1 ) ); // COUNT:1
        addFilteredResource ( newProject, "build.properties", getResource ( "feature/build.properties" ), "ISO-8859-1", properties, new SubProgressMonitor ( monitor, 1 ) ); // COUNT:1

        monitor.done ();
    }

    protected void createProductProject ( final IProject project, final Map<String, String> properties, final IProgressMonitor monitor ) throws CoreException
    {
        monitor.beginTask ( "Creating product project", 3 + this.resources.length + this.filteredResources.length );

        final String name = this.pluginId + "-product"; //$NON-NLS-1$
        final IProjectDescription desc = project.getWorkspace ().newProjectDescription ( name );

        final IProject newProject = project.getWorkspace ().getRoot ().getProject ( name );
        newProject.create ( desc, new SubProgressMonitor ( monitor, 1 ) ); // COUNT:1
        newProject.open ( new SubProgressMonitor ( monitor, 1 ) ); // COUNT:1

        addFilteredResource ( newProject, "pom.xml", getResource ( "product-pom.xml" ), "UTF-8", properties, new SubProgressMonitor ( monitor, 1 ) ); // COUNT:1

        for ( final String r : this.resources )
        {
            addResource ( newProject, r, getResource ( r ), new SubProgressMonitor ( monitor, 1 ) );
        }

        for ( final String r : this.filteredResources )
        {
            addFilteredResource ( newProject, r, getResource ( r ), "UTF-8", properties, new SubProgressMonitor ( monitor, 1 ) ); //$NON-NLS-1$
        }

        monitor.done ();
    }

    private InputStream getResource ( final String name )
    {
        return ClientTemplate.class.getResourceAsStream ( "resource/" + name ); //$NON-NLS-1$
    }

    private void addFilteredResource ( final IProject newProject, final String name, final InputStream stream, final String cs, final Map<?, ?> properties, final IProgressMonitor monitor ) throws CoreException
    {
        try
        {
            String data = CharStreams.toString ( new InputStreamReader ( stream, cs ) );
            data = StringReplacer.replace ( data, StringReplacer.newSource ( properties ), ALT_PATTERN );
            addResource ( newProject, name, new ByteArrayInputStream ( data.getBytes ( cs ) ), monitor );
        }
        catch ( final Exception e )
        {
            throw new CoreException ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }
    }

    private void addResource ( final IProject project, final String name, final InputStream stream, final IProgressMonitor monitor ) throws CoreException
    {
        try
        {
            final String[] toks = name.split ( "\\/" ); //$NON-NLS-1$
            IContainer container = project;
            for ( int i = 0; i < toks.length - 1; i++ )
            {
                final IFolder folder = container.getFolder ( new Path ( toks[i] ) );
                if ( !folder.exists () )
                {
                    folder.create ( true, true, null );
                }
                container = folder;
            }
            final IFile file = project.getFile ( name );
            if ( file.exists () )
            {
                file.setContents ( stream, IResource.FORCE, monitor );
            }
            else
            {
                file.create ( stream, true, monitor );
            }
        }
        finally
        {
            try
            {
                stream.close ();
            }
            catch ( final IOException e )
            {
            }
        }
        monitor.done ();
    }
}
