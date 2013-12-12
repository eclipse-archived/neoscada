/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.ui.project.create;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.component.ComponentFactory;
import org.eclipse.scada.configuration.component.ComponentWorld;
import org.eclipse.scada.configuration.component.DriverConnectionAnalyzer;
import org.eclipse.scada.configuration.component.Level;
import org.eclipse.scada.configuration.component.MarkerConfiguration;
import org.eclipse.scada.configuration.component.exec.ExecComponentsFactory;
import org.eclipse.scada.configuration.component.exec.LoadAverage;
import org.eclipse.scada.configuration.generator.Profiles;
import org.eclipse.scada.configuration.globalization.Authorative;
import org.eclipse.scada.configuration.globalization.GlobalizeFactory;
import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.CommonDriver;
import org.eclipse.scada.configuration.infrastructure.Driver;
import org.eclipse.scada.configuration.infrastructure.InfrastructureFactory;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.infrastructure.Options;
import org.eclipse.scada.configuration.infrastructure.SystemNode;
import org.eclipse.scada.configuration.infrastructure.SystemPropertyUserService;
import org.eclipse.scada.configuration.infrastructure.UserEntry;
import org.eclipse.scada.configuration.infrastructure.ValueArchiveServer;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.configuration.item.CustomizationPipeline;
import org.eclipse.scada.configuration.item.Selector;
import org.eclipse.scada.configuration.recipe.Definition;
import org.eclipse.scada.configuration.security.Configuration;
import org.eclipse.scada.configuration.security.GenericScript;
import org.eclipse.scada.configuration.security.LogonRule;
import org.eclipse.scada.configuration.security.ScriptRule;
import org.eclipse.scada.configuration.security.SecurityFactory;
import org.eclipse.scada.configuration.ui.project.Activator;
import org.eclipse.scada.configuration.ui.project.Constants;
import org.eclipse.scada.configuration.world.MasterHandlerPriorities;
import org.eclipse.scada.configuration.world.PasswordCredentials;
import org.eclipse.scada.configuration.world.WorldFactory;
import org.eclipse.scada.configuration.world.deployment.Author;
import org.eclipse.scada.configuration.world.deployment.DeploymentFactory;
import org.eclipse.scada.configuration.world.deployment.DeploymentInformation;
import org.eclipse.scada.configuration.world.deployment.ExpressionNodeMappingEntry;
import org.eclipse.scada.configuration.world.deployment.FallbackNodeMappingMode;
import org.eclipse.scada.configuration.world.deployment.NodeMappings;
import org.eclipse.scada.configuration.world.osgi.EventPool;
import org.eclipse.scada.configuration.world.osgi.MarkerEntry;
import org.eclipse.scada.configuration.world.osgi.MonitorPool;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;
import org.eclipse.scada.configuration.world.osgi.profile.ProfileFactory;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @noextend
 */
public class CreateProjectOperation extends WorkspaceModifyOperation
{
    private static final String BUILDER_JS_VALIDATOR = "org.eclipse.wst.jsdt.core.javascriptValidator"; //$NON-NLS-1$

    private static final String PROJECT_NATURE_JS = "org.eclipse.wst.jsdt.core.jsNature"; //$NON-NLS-1$

    private final ProjectInformation info;

    public CreateProjectOperation ( final ProjectInformation info )
    {
        this.info = info;
    }

    @Override
    protected void execute ( final IProgressMonitor monitor ) throws CoreException, InvocationTargetException, InterruptedException
    {
        monitor.beginTask ( "Creating project", 3 );

        createProject ( new SubProgressMonitor ( monitor, 1 ) );
        try
        {
            createContent ( new SubProgressMonitor ( monitor, 1 ) );
        }
        catch ( final IOException e )
        {
            throw new CoreException ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }
        this.info.getProject ().refreshLocal ( IResource.DEPTH_INFINITE, new SubProgressMonitor ( monitor, 1 ) );
    }

    protected void createContent ( final IProgressMonitor monitor ) throws IOException
    {
        final URI base = URI.createURI ( this.info.getProject ().getLocationURI ().toString () );

        final ResourceSet rs = new ResourceSetImpl ();

        final Configuration security = createDefaultSecurity ();
        final Profile hdProfile = createHDProfile ( rs );
        final Profile masterProfile = createMasterProfile ( rs );

        final CustomizationPipeline pipeline = createPipeline ( new Path ( "templates/default.icm_js" ) ); //$NON-NLS-1$
        final Selector archiveSelector = createSelector ( new Path ( "templates/archiveSelector.isel_js" ) ); //$NON-NLS-1$
        final Selector globalizeSelector = createSelector ( new Path ( "templates/globalize.isel_js" ) ); //$NON-NLS-1$

        final World world = createInfrastructure ( rs, security, masterProfile, hdProfile );
        final ComponentWorld system = createComponents ( world, pipeline, archiveSelector, globalizeSelector );
        final DeploymentInformation di = createDeploymentInformation ();

        final Definition defaultRecipe = RecipeBuilder.createDefaultRecipe ();
        final Definition integrationRecipe = RecipeBuilder.createIntegrationRecipe ();

        save ( rs, base, "global/deployment.information.esdi", di ); //$NON-NLS-1$

        save ( rs, base, "global/global.security", security ); //$NON-NLS-1$
        save ( rs, base, "global/master.customization.profile.xml", masterProfile ); //$NON-NLS-1$
        save ( rs, base, "global/hdserver.customization.profile.xml", hdProfile ); //$NON-NLS-1$

        save ( rs, base, "customization/default.icm_js", pipeline ); //$NON-NLS-1$
        save ( rs, base, "customization/archiveSelector.isel_js", archiveSelector ); //$NON-NLS-1$
        save ( rs, base, "customization/globalize.isel_js", globalizeSelector ); //$NON-NLS-1$

        save ( rs, base, "world.esim", world ); //$NON-NLS-1$
        save ( rs, base, "world.escm", system ); //$NON-NLS-1$

        if ( this.info.isEnableIntegrationSystem () )
        {
            final NodeMappings mappings = createNodeMappings ();
            save ( rs, base, "nodeMappings.esdi", mappings ); //$NON-NLS-1$ 

            save ( rs, base, "productive.recipe", defaultRecipe, "org.eclipse.scada.configuration.recipe" ); //$NON-NLS-1$ //$NON-NLS-2$
            save ( rs, base, "integration.recipe", integrationRecipe, "org.eclipse.scada.configuration.recipe" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        else
        {
            save ( rs, base, "default.recipe", defaultRecipe, "org.eclipse.scada.configuration.recipe" ); //$NON-NLS-1$ //$NON-NLS-2$
        }

    }

    private NodeMappings createNodeMappings ()
    {
        final NodeMappings mappings = DeploymentFactory.eINSTANCE.createNodeMappings ();
        mappings.setFallbackMode ( FallbackNodeMappingMode.IGNORE );
        final ExpressionNodeMappingEntry exp = DeploymentFactory.eINSTANCE.createExpressionNodeMappingEntry ();
        mappings.getEntries ().add ( exp );

        exp.setPattern ( Pattern.compile ( "node(\\d+)" ) ); //$NON-NLS-1$
        exp.setReplacement ( "testnode$1" ); //$NON-NLS-1$

        return mappings;
    }

    private DeploymentInformation createDeploymentInformation ()
    {
        final DeploymentInformation result = DeploymentFactory.eINSTANCE.createDeploymentInformation ();

        final Author author = DeploymentFactory.eINSTANCE.createAuthor ();

        final String username = java.lang.System.getProperty ( "user.name", "unknown" ); //$NON-NLS-1$
        String hostname;
        try
        {
            hostname = java.net.InetAddress.getLocalHost ().getHostName ();
        }
        catch ( final Exception e )
        {
            hostname = "unknown";
        }
        author.setEmail ( String.format ( "%s@%s", username, hostname ) );
        author.setName ( username );

        result.getAuthors ().add ( author );

        return result;
    }

    private World createInfrastructure ( final ResourceSet rs, final Configuration security, final Profile masterProfile, final Profile hdProfile )
    {
        final World world = InfrastructureFactory.eINSTANCE.createWorld ();

        world.setDefaultMasterCustomizationProfile ( masterProfile );
        world.setDefaultValueArchiveCustomizationProfile ( hdProfile );
        world.setDefaultSecurityConfiguration ( security );
        world.setDefaultCredentials ( this.info.getDefaultInterconnectCredentials () );

        final PasswordCredentials driverPassword = WorldFactory.eINSTANCE.createPasswordCredentials ();
        driverPassword.setPassword ( this.info.getDefaultDriverPassword () );
        world.setDefaultDriverPassword ( driverPassword );

        world.setOptions ( InfrastructureFactory.eINSTANCE.createOptions () );
        createAE ( world );
        createSystemPropertyUserService ( world );

        world.setDefaultMasterHandlerPriorities ( (MasterHandlerPriorities)rs.getEObject ( URI.createURI ( "platform:/plugin/org.eclipse.scada.configuration.lib/model/defaultPriorities.eswm#_sLVwoN_iEeKP_IG4d7_Nqg" ), true ) );

        for ( final Map.Entry<String, List<String>> entry : this.info.getNodes ().entrySet () )
        {
            final SystemNode node = InfrastructureFactory.eINSTANCE.createSystemNode ();
            node.setHostName ( entry.getKey () );
            world.getNodes ().add ( node );

            if ( this.info.getDebianDeploymentMechanism () != null )
            {
                node.getDeployment ().add ( this.info.getDebianDeploymentMechanism () );
            }

            final ValueArchiveServer archive = InfrastructureFactory.eINSTANCE.createValueArchiveServer ();
            archive.setName ( "hdserver" ); //$NON-NLS-1$
            archive.setInstanceNumber ( 2 );
            node.getValueArchives ().add ( archive );

            final MasterServer master = InfrastructureFactory.eINSTANCE.createMasterServer ();
            master.setInstanceNumber ( 1 );
            master.setName ( "master" ); //$NON-NLS-1$
            master.setArchiveTo ( archive );
            final Authorative auth = GlobalizeFactory.eINSTANCE.createAuthorative ();
            auth.getHierarchy ().addAll ( entry.getValue () );
            master.getAuthoratives ().add ( auth );
            node.getMasters ().add ( master );
            this.hierCache.put ( master, entry.getValue () );

            final CommonDriver execDriver = InfrastructureFactory.eINSTANCE.createCommonDriver ();
            execDriver.setName ( "exec" ); //$NON-NLS-1$
            execDriver.setPortNumber ( (short)2107 );
            execDriver.setDriverTypeId ( "org.eclipse.scada.da.server.exec" ); //$NON-NLS-1$
            master.getDriver ().add ( execDriver );
            node.getDrivers ().add ( execDriver );
        }

        return world;
    }

    private final Map<MasterServer, List<String>> hierCache = new HashMap<> ();

    private void createAE ( final World world )
    {
        final Options opt = world.getOptions ();
        createMonitorPool ( opt, "monitors.unsafe", "(status=UNSAFE)" ); //$NON-NLS-1$
        createMonitorPool ( opt, "monitors.inactive", "(status=INACTIVE)" ); //$NON-NLS-1$
        createMonitorPool ( opt, "monitors.not_ok", "(|(status=NOT_OK)(status=NOT_OK_NOT_AKN)(status=NOT_OK_AKN))" ); //$NON-NLS-1$
        createMonitorPool ( opt, "monitors.ack_required", "(|(status=NOT_AKN)(status=NOT_OK_NOT_AKN))" ); //$NON-NLS-1$
        createMonitorPool ( opt, "monitors.init", "(status=INIT)" ); //$NON-NLS-1$
        createMonitorPool ( opt, "monitors.all", "(status=*)" ); //$NON-NLS-1$
        createEventPool ( opt, "events.all", "(eventType=*)", 10000 ); //$NON-NLS-1$
    }

    private static void createMonitorPool ( final Options opt, final String name, final String filter )
    {
        final MonitorPool pool = OsgiFactory.eINSTANCE.createMonitorPool ();
        pool.setName ( name );
        pool.setFilter ( filter );
        opt.getMonitorPools ().add ( pool );
    }

    private static void createEventPool ( final Options opt, final String name, final String filter, final int size )
    {
        final EventPool pool = OsgiFactory.eINSTANCE.createEventPool ();
        pool.setName ( name );
        pool.setFilter ( filter );
        pool.setSize ( size );
        opt.getEventPools ().add ( pool );
    }

    private void createSystemPropertyUserService ( final World world )
    {
        final SystemPropertyUserService service = InfrastructureFactory.eINSTANCE.createSystemPropertyUserService ();

        final UserEntry user = InfrastructureFactory.eINSTANCE.createUserEntry ();
        user.setName ( "admin" ); //$NON-NLS-1$
        user.setPassword ( "admin12" ); //$NON-NLS-1$
        service.getUsers ().add ( user );

        final UserEntry user2 = InfrastructureFactory.eINSTANCE.createUserEntry ();
        user2.setName ( this.info.getDefaultInterconnectCredentials ().getUsername () );
        user2.setPassword ( this.info.getDefaultInterconnectCredentials ().getPassword () );
        service.getUsers ().add ( user2 );

        world.getOptions ().setDefaultUserService ( service );
    }

    private org.eclipse.scada.configuration.component.ComponentWorld createComponents ( final World world, final CustomizationPipeline pipeline, final Selector archiveSelector, final Selector globalizeSelector )
    {
        final ComponentWorld system = ComponentFactory.eINSTANCE.createComponentWorld ();

        system.setInfrastructure ( world );

        system.setDefaultCustomizationPipeline ( pipeline );
        system.setDefaultArchiveSelector ( archiveSelector );

        // markers

        final MarkerConfiguration markers = ComponentFactory.eINSTANCE.createMarkerConfiguration ();
        final MarkerEntry entry1 = OsgiFactory.eINSTANCE.createMarkerEntry ();
        entry1.setName ( "maintenance.warning" ); //$NON-NLS-1$
        markers.getMarkers ().add ( entry1 );
        final MarkerEntry entry2 = OsgiFactory.eINSTANCE.createMarkerEntry ();
        entry2.setName ( "maintenance.ack" ); //$NON-NLS-1$
        markers.getMarkers ().add ( entry2 );
        system.getConfigurations ().add ( markers );

        // create some components

        for ( final Map.Entry<MasterServer, List<String>> entry : this.hierCache.entrySet () )
        {
            Level level = makeLevel ( system, entry.getValue (), "SYS" ); //$NON-NLS-1$
            final LoadAverage avg = ExecComponentsFactory.eINSTANCE.createLoadAverage ();
            avg.setName ( "LAVG" ); //$NON-NLS-1$
            avg.getMasterOn ().add ( entry.getKey () );
            final AbstractFactoryDriver driver = findDriver ( entry.getKey (), "exec" ); //$NON-NLS-1$
            avg.setRunsOn ( driver );
            level.getComponents ().add ( avg );

            level = makeLevel ( system, entry.getValue (), "SYS", "DRV", "EXEC" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            final DriverConnectionAnalyzer dca = ComponentFactory.eINSTANCE.createDriverConnectionAnalyzer ();
            dca.setConnection ( driver );
            dca.getMasterOn ().add ( entry.getKey () );
            level.getComponents ().add ( dca );
        }

        // return

        return system;
    }

    private AbstractFactoryDriver findDriver ( final MasterServer master, final String driverName )
    {
        for ( final Driver driver : master.getDriver () )
        {
            if ( driver.getName ().equals ( driverName ) && driver instanceof AbstractFactoryDriver )
            {
                return (AbstractFactoryDriver)driver;
            }
        }
        return null;
    }

    private Level makeLevel ( final org.eclipse.scada.configuration.component.ComponentWorld system, final List<String> hier, final String... subs )
    {
        if ( hier.isEmpty () )
        {
            return null;
        }

        final List<String> levels = new LinkedList<> ( hier );
        levels.addAll ( Arrays.asList ( subs ) );

        Level level = null;
        for ( final String l : levels )
        {
            if ( level == null )
            {
                level = findLevel ( system.getLevels (), l );
            }
            else
            {
                level = findLevel ( level.getLevels (), l );
            }
        }
        return level;
    }

    private Level findLevel ( final EList<Level> levels, final String l )
    {
        for ( final Level level : levels )
        {
            if ( level.getName ().equals ( l ) )
            {
                return level;
            }
        }
        // create
        final Level level = ComponentFactory.eINSTANCE.createLevel ();
        level.setName ( l );
        levels.add ( level );
        return level;
    }

    private static Selector createSelector ( final IPath path ) throws IOException
    {
        final ResourceSet rs = new ResourceSetImpl ();
        final Resource r = rs.createResource ( URI.createFileURI ( path.toString () ) );
        r.load ( bundleResource ( path ), null );
        return EcoreUtil.copy ( (Selector)r.getContents ().get ( 0 ) );
    }

    private static CustomizationPipeline createPipeline ( final IPath path ) throws IOException
    {
        final ResourceSet rs = new ResourceSetImpl ();
        final Resource r = rs.createResource ( URI.createFileURI ( path.toString () ) );
        r.load ( bundleResource ( path ), null );
        return EcoreUtil.copy ( (CustomizationPipeline)r.getContents ().get ( 0 ) );
    }

    private static InputStream bundleResource ( final IPath location ) throws IOException
    {
        return FileLocator.openStream ( Activator.getDefault ().getBundle (), location, true );
    }

    protected static Resource save ( final ResourceSet rs, final URI base, final String localName, final EObject content ) throws IOException
    {
        return save ( rs, base, localName, content, null );
    }

    protected static Resource save ( final ResourceSet rs, final URI base, final String localName, final EObject content, final String contentType ) throws IOException
    {
        final Resource resource = rs.createResource ( base.appendSegments ( localName.split ( "\\/" ) ), contentType );
        resource.getContents ().add ( content );
        resource.save ( null );
        return resource;
    }

    private Profile createMasterProfile ( final ResourceSet rs )
    {
        final Profile profile = ProfileFactory.eINSTANCE.createProfile ();
        profile.setName ( "Master Server Customization Profile" );
        Profiles.addInclude ( profile, rs, URI.createURI ( "platform:/plugin/org.eclipse.scada.configuration.lib/model/database.h2.profile.xml#/" ) ); //$NON-NLS-1$

        this.info.getConfigurationPersistentBackend ().configure ( rs, profile, "master" ); //$NON-NLS-1$
        this.info.getDataStorePersistentBackend ().configure ( rs, profile, "master" ); //$NON-NLS-1$

        return profile;
    }

    private Profile createHDProfile ( final ResourceSet rs )
    {
        final Profile profile = ProfileFactory.eINSTANCE.createProfile ();
        profile.setName ( "Value Archive Server Customization Profile" );
        Profiles.addInclude ( profile, rs, URI.createURI ( "platform:/plugin/org.eclipse.scada.configuration.lib/model/database.h2.profile.xml#/" ) ); //$NON-NLS-1$

        this.info.getConfigurationPersistentBackend ().configure ( rs, profile, "hdserver" ); //$NON-NLS-1$

        return profile;
    }

    protected Configuration createDefaultSecurity ()
    {
        final Configuration cfg = SecurityFactory.eINSTANCE.createConfiguration ();
        cfg.setName ( "Global Security Policy" );

        final GenericScript trueScript = addSecurityScript ( cfg, "true;" ); //$NON-NLS-1$
        final GenericScript falseScript = addSecurityScript ( cfg, "false;" ); //$NON-NLS-1$
        final GenericScript hasUserScript = addSecurityScript ( cfg, "user != null;" ); //$NON-NLS-1$

        // logon rule
        final LogonRule logonRule = SecurityFactory.eINSTANCE.createLogonRule ();
        logonRule.setId ( "logon" ); //$NON-NLS-1$
        logonRule.setActionFilter ( Pattern.compile ( "CONNECT" ) ); //$NON-NLS-1$
        logonRule.setTypeFilter ( Pattern.compile ( "SESSION" ) ); //$NON-NLS-1$
        cfg.getRules ().add ( logonRule );

        addScriptRule ( cfg, "allow.logon", "CONNECT", "SESSION", trueScript ); //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
        addScriptRule ( cfg, "reject.all.session", "PRIV", "SESSION", falseScript ); //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
        addScriptRule ( cfg, "allow.all", null, null, hasUserScript ); //$NON-NLS-1$  

        return cfg;
    }

    protected static void addScriptRule ( final Configuration cfg, final String id, final String action, final String type, final GenericScript script )
    {
        final ScriptRule rule = SecurityFactory.eINSTANCE.createScriptRule ();
        rule.setId ( id );
        if ( action != null )
        {
            rule.setActionFilter ( Pattern.compile ( action ) );
        }
        if ( type != null )
        {
            rule.setTypeFilter ( Pattern.compile ( type ) );
        }
        rule.setScript ( script );
        cfg.getRules ().add ( rule );
    }

    protected static GenericScript addSecurityScript ( final Configuration cfg, final String script )
    {
        final GenericScript impl = SecurityFactory.eINSTANCE.createGenericScript ();
        impl.setType ( "JavaScript" ); //$NON-NLS-1$
        impl.setSource ( script );
        cfg.getScripts ().add ( impl );
        return impl;
    }

    protected void createProject ( final IProgressMonitor monitor ) throws CoreException
    {
        monitor.beginTask ( "Create project", 2 );

        final IProject project = this.info.getProject ();

        final IProjectDescription desc = project.getWorkspace ().newProjectDescription ( project.getName () );
        desc.setLocation ( this.info.getProjectLocation () );
        desc.setNatureIds ( new String[] { Constants.PROJECT_NATURE_CONFIGURATION, PROJECT_NATURE_JS } );

        final ICommand jsCmd = desc.newCommand ();
        jsCmd.setBuilderName ( BUILDER_JS_VALIDATOR );

        final ICommand localBuilder = desc.newCommand ();
        localBuilder.setBuilderName ( Constants.PROJECT_BUILDER );

        desc.setBuildSpec ( new ICommand[] { jsCmd, localBuilder } );

        if ( !project.exists () )
        {
            project.create ( desc, new SubProgressMonitor ( monitor, 1 ) );
            project.open ( new SubProgressMonitor ( monitor, 1 ) );
        }
        monitor.done ();
    }
}
