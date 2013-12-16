/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.ui.launcher.app;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.ILaunchShortcut2;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.DependencyManager;
import org.eclipse.pde.launching.IPDELauncherConstants;
import org.eclipse.scada.configuration.world.osgi.profile.BundleStartLevel;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;
import org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage;
import org.eclipse.scada.configuration.world.osgi.profile.StartBundle;
import org.eclipse.scada.configuration.world.osgi.profile.SystemProperty;
import org.eclipse.scada.da.server.ui.launcher.Activator;
import org.eclipse.scada.ui.databinding.SelectionHelper;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.scada.utils.lang.Pair;
import org.eclipse.scada.utils.str.StringHelper;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.statushandlers.StatusManager;

@SuppressWarnings ( "restriction" )
public class LaunchShortcut implements ILaunchShortcut2
{
    private static final String ATTR_ENV_VARS = "org.eclipse.debug.core.environmentVariables";

    private static final String CONFIGURATION_TYPE_ID = "org.eclipse.pde.ui.EquinoxLauncher";

    protected ILaunchConfiguration createConfiguration ( final IResource resource ) throws Exception
    {
        final ResourceSet rs = new ResourceSetImpl ();
        final Resource r = rs.createResource ( URI.createURI ( resource.getLocationURI ().toURL ().toString () ) );
        r.load ( null );
        final Profile profile = (Profile)EcoreUtil.getObjectByType ( r.getContents (), ProfilePackage.Literals.PROFILE );
        if ( profile == null )
        {
            return null;
        }

        String name = profile.getName ();
        if ( name == null || name.isEmpty () )
        {
            name = String.format ( "Application profile: %s", resource.getFullPath () );
        }

        final ILaunchConfigurationWorkingCopy cfg = getConfigurationType ().newInstance ( resource.getParent (), name );

        final Map<Object, Object> envs = new HashMap<> ();
        envs.put ( "SCADA_PROFILE", String.format ( "${project_loc:/%s}/%s", resource.getProject ().getName (), resource.getProjectRelativePath () ) );
        cfg.setAttribute ( ATTR_ENV_VARS, envs );

        cfg.setAttribute ( IPDELauncherConstants.INCLUDE_OPTIONAL, false );
        cfg.setAttribute ( IPDELauncherConstants.AUTOMATIC_ADD, false );
        cfg.setAttribute ( IPDELauncherConstants.AUTOMATIC_VALIDATE, true );
        cfg.setAttribute ( IPDELauncherConstants.DEFAULT_AUTO_START, false );

        addAllBundels ( cfg, profile );
        addJvmOptions ( cfg, profile );

        cfg.setAttribute ( IJavaLaunchConfigurationConstants.ATTR_PROGRAM_ARGUMENTS, "-os ${target.os} -ws ${target.ws} -arch ${target.arch} -nl ${target.nl}  -consoleLog -console" );

        return cfg.doSave ();
    }

    private void addJvmOptions ( final ILaunchConfigurationWorkingCopy cfg, final Profile profile ) throws CoreException
    {
        final List<String> args = new LinkedList<> ();

        for ( final String arg : profile.getJvmArgument () )
        {
            args.add ( arg );
        }

        for ( final SystemProperty p : profile.getProperty () )
        {
            addSystemProperty ( args, p.getKey (), p.getValue (), p.isEval () );
        }

        for ( final Map.Entry<String, String> entry : getInitialProperties ().entrySet () )
        {
            addSystemProperty ( args, entry.getKey (), entry.getValue (), false );
        }

        cfg.setAttribute ( IJavaLaunchConfigurationConstants.ATTR_VM_ARGUMENTS, StringHelper.join ( args, "\n" ) );
    }

    private String eval ( final String value, final boolean eval ) throws CoreException
    {
        if ( eval )
        {
            throw new CoreException ( new Status ( IStatus.ERROR, Activator.PLUGIN_ID, "Properties of type 'eval' are currently unsupported" ) );
        }
        return value;
    }

    private void addSystemProperty ( final List<String> args, final String key, final String value, final boolean eval ) throws CoreException
    {
        String wrap = "";
        if ( key.contains ( " " ) || value.contains ( " " ) )
        {
            wrap = "\"";
        }

        final Pair<String, String> result = interceptProperty ( new Pair<String, String> ( key, value ) );

        if ( result != null )
        {
            result.second = eval ( result.second, eval );
            args.add ( String.format ( "%1$s-D%2$s=%3$s%1$s", wrap, replace ( result.first ), replace ( result.second ) ) );
        }
    }

    /**
     * Allow intercepting properties
     * 
     * @param pair
     *            the property
     * @return the result, <code>null</code> suppresses the property
     */
    protected Pair<String, String> interceptProperty ( final Pair<String, String> pair )
    {
        if ( pair == null || pair.first == null )
        {
            return pair;
        }

        if ( "logback.configurationFile".equals ( pair.first ) )
        {
            return null;
        }

        return pair;
    }

    private String replace ( final String string )
    {
        final String s1 = Matcher.quoteReplacement ( "\\$\\{" );
        final String s2 = Matcher.quoteReplacement ( "\\}" );
        return string.replaceAll ( "\\$\\{(.*?)\\}", s1 + "$1" + s2 );
    }

    private static class Bundle
    {
        final String name;

        Boolean autostart;

        int startLevel = -1;

        public Bundle ( final String name )
        {
            this.name = name;
        }

        public Bundle ( final String name, final int level )
        {
            this.name = name;
            this.autostart = true;
            this.startLevel = level;
        }
    }

    private String toString ( final Collection<Bundle> bundles )
    {
        final StringBuilder sb = new StringBuilder ();

        boolean first = true;
        for ( final Bundle bundle : bundles )
        {
            if ( !first )
            {
                sb.append ( ',' );
            }
            else
            {
                first = false;
            }
            sb.append ( bundle.name );
            sb.append ( '@' );
            if ( bundle.startLevel >= 0 )
            {
                sb.append ( bundle.startLevel );
            }
            else
            {
                sb.append ( "default" );
            }
            sb.append ( ':' );
            sb.append ( bundle.autostart == null ? "default" : "" + bundle.autostart );
        }

        return sb.toString ();
    }

    protected void addAllBundels ( final ILaunchConfigurationWorkingCopy cfg, final Profile profile ) throws CoreException
    {
        // PluginRegistry

        final Map<String, Bundle> all = new HashMap<> ();

        for ( final Bundle b : getInitialBundles () )
        {
            all.put ( b.name, b );
        }

        for ( final StartBundle sb : profile.getStart () )
        {
            final Bundle b = new Bundle ( sb.getName () );
            b.autostart = true;
            all.put ( b.name, b );
        }

        for ( final BundleStartLevel sbl : profile.getSetbsl () )
        {
            final Bundle b = all.get ( sbl.getName () );
            if ( b == null )
            {
                throw new CoreException ( new Status ( IStatus.ERROR, Activator.PLUGIN_ID, String.format ( "Bundle start level for missing bundle (%s).", sbl.getName () ) ) );
            }

            b.startLevel = sbl.getLevel ();
        }

        resolve ( all );

        final Set<Bundle> targetResult = new HashSet<> ();
        final Set<Bundle> workspaceResult = new HashSet<> ();

        split ( all, targetResult, workspaceResult );

        cfg.setAttribute ( IPDELauncherConstants.TARGET_BUNDLES, toString ( targetResult ) );
        cfg.setAttribute ( IPDELauncherConstants.WORKSPACE_BUNDLES, toString ( workspaceResult ) );
    }

    private void split ( final Map<String, Bundle> all, final Set<Bundle> targetResult, final Set<Bundle> workspaceResult )
    {
        final Set<IPluginModelBase> workspaceSet = new HashSet<> ( Arrays.asList ( PluginRegistry.getWorkspaceModels () ) );

        for ( final Bundle b : all.values () )
        {
            final IPluginModelBase model = PluginRegistry.findModel ( b.name );
            if ( workspaceSet.contains ( model ) )
            {
                workspaceResult.add ( b );
            }
            else
            {
                targetResult.add ( b );
            }
        }
    }

    protected Set<Bundle> getInitialBundles ()
    {
        final Set<Bundle> result = new HashSet<> ();

        // osgi.bundles=org.eclipse.equinox.common@1:start, org.eclipse.update.configurator@2:start, org.eclipse.scada.utils.osgi.autostart@3:start

        result.add ( new Bundle ( "org.eclipse.equinox.common", 1 ) );
        // result.add ( new Bundle ( "org.eclipse.update.configurator", 2 ) );
        result.add ( new Bundle ( "org.eclipse.core.runtime", 1 ) );

        result.add ( new Bundle ( "org.eclipse.osgi", 0 ) );

        result.add ( new Bundle ( "org.eclipse.equinox.console", 1 ) );
        result.add ( new Bundle ( "org.apache.felix.gogo.command", 1 ) );
        result.add ( new Bundle ( "org.apache.felix.gogo.shell", 1 ) );
        result.add ( new Bundle ( "org.apache.felix.gogo.runtime", 1 ) );

        return result;
    }

    protected Map<String, String> getInitialProperties ()
    {
        final Map<String, String> result = new HashMap<> ();

        result.put ( "eclipse.ignoreApp", "true" );
        result.put ( "osgi.noShutdown", "true" );
        result.put ( "equinox.use.ds", "true" );

        return result;
    }

    private void resolve ( final Map<String, Bundle> all ) throws CoreException
    {
        final IPluginModelBase[] bundles = new IPluginModelBase[all.size ()];

        int i = 0;
        for ( final Bundle b : new HashMap<> ( all ).values () )
        {
            final IPluginModelBase model = PluginRegistry.findModel ( b.name );
            if ( model == null )
            {
                throw new CoreException ( new Status ( IStatus.ERROR, Activator.PLUGIN_ID, String.format ( "Bundle not found in target runtime (%s).", b.name ) ) );
            }
            bundles[i] = model;
            i++;
        }

        final Set<String> result = DependencyManager.getDependencies ( bundles, false, getExcludedFragments () );

        for ( final String bundle : result )
        {
            final Bundle b = new Bundle ( bundle );
            all.put ( bundle, b );
        }
    }

    private String[] getExcludedFragments ()
    {
        return new String[] { "org.eclipse.ui.workbench.compatibility" };
    }

    protected ILaunchConfiguration findConfiguration ( final IResource resource ) throws CoreException, IOException
    {
        final File sourceFile = resource.getLocation ().toFile ().getCanonicalFile ();

        final ILaunchConfiguration[] cfgs = DebugPlugin.getDefault ().getLaunchManager ().getLaunchConfigurations ( getConfigurationType () );
        for ( final ILaunchConfiguration cfg : cfgs )
        {
            final Map<?, ?> envs = cfg.getAttribute ( ATTR_ENV_VARS, Collections.EMPTY_MAP );
            if ( envs != null )
            {
                final Object profile = envs.get ( "SCADA_PROFILE" );
                if ( profile instanceof String )
                {
                    String profileString = (String)profile;
                    profileString = VariablesPlugin.getDefault ().getStringVariableManager ().performStringSubstitution ( profileString );
                    final File other = new File ( profileString );
                    try
                    {
                        if ( sourceFile.equals ( other.getCanonicalFile () ) )
                        {
                            return cfg;
                        }
                    }
                    catch ( final IOException e )
                    {
                        // ignore this one
                    }
                }
            }
        }
        return null;
    }

    protected ILaunchConfigurationType getConfigurationType ()
    {
        final ILaunchManager lm = DebugPlugin.getDefault ().getLaunchManager ();
        return lm.getLaunchConfigurationType ( CONFIGURATION_TYPE_ID );
    }

    protected void performLanuch ( final IResource resource, final String mode )
    {
        try
        {
            ILaunchConfiguration cfg = findConfiguration ( resource );
            if ( cfg == null )
            {
                cfg = createConfiguration ( resource );
            }
            if ( cfg != null )
            {
                DebugUITools.launch ( cfg, mode );
            }
        }
        catch ( final CoreException e )
        {
            log ( "Failed to launch profile", e.getStatus () );
        }
        catch ( final Exception e )
        {
            log ( "Failed to launch profile", StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }
    }

    protected void log ( final String string, final IStatus status )
    {
        StatusManager.getManager ().handle ( status, StatusManager.BLOCK );
    }

    @Override
    public void launch ( final ISelection selection, final String mode )
    {
        final IResource resource = SelectionHelper.first ( selection, IResource.class );
        if ( resource != null )
        {
            performLanuch ( resource, mode );
        }
    }

    @Override
    public void launch ( final IEditorPart editor, final String mode )
    {
        final IResource resource = (IResource)editor.getEditorInput ().getAdapter ( IResource.class );
        if ( resource != null )
        {
            performLanuch ( resource, mode );
        }
    }

    @Override
    public ILaunchConfiguration[] getLaunchConfigurations ( final ISelection selection )
    {
        return null;
    }

    @Override
    public ILaunchConfiguration[] getLaunchConfigurations ( final IEditorPart editorpart )
    {
        return null;
    }

    @Override
    public IResource getLaunchableResource ( final ISelection selection )
    {
        return null;
    }

    @Override
    public IResource getLaunchableResource ( final IEditorPart editorpart )
    {
        return null;
    }

}
