/*******************************************************************************
 * Copyright (c) 2013, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.lib.deployment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.packagedrone.utils.deb.build.FileContentProvider;
import org.eclipse.packagedrone.utils.deb.build.StaticContentProvider;
import org.eclipse.scada.configuration.generator.Profiles;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.StartupMechanism;
import org.eclipse.scada.configuration.world.lib.deployment.startup.LSBSystemVHandler;
import org.eclipse.scada.configuration.world.lib.deployment.startup.RedhatSystemVHandler;
import org.eclipse.scada.configuration.world.lib.deployment.startup.StartupHandler;
import org.eclipse.scada.configuration.world.lib.deployment.startup.SystemdHandler;
import org.eclipse.scada.configuration.world.lib.deployment.startup.UpstartHandler;
import org.eclipse.scada.configuration.world.lib.setup.SubModuleHandler;
import org.eclipse.scada.configuration.world.lib.utils.Constants;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;
import org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage;
import org.eclipse.scada.utils.str.StringHelper;

public abstract class CommonPackageHandler extends CommonHandler
{
    private final CommonDeploymentMechanism deploy;

    private StartupHandler startupHandler;

    private DeploymentContext deploymentContext;

    public CommonPackageHandler ( final ApplicationNode applicationNode, final CommonDeploymentMechanism deploy )
    {
        super ( applicationNode );
        this.deploy = deploy;
    }

    @Override
    protected void handleProcess ( final IFolder nodeDir, final IProgressMonitor monitor, final Map<String, String> properties ) throws Exception
    {
        if ( this.deploymentContext != null )
        {
            runSetup ( this.deploy, this.deploymentContext, new SubProgressMonitor ( monitor, 1 ) );

            if ( !makeEquinoxList ().isEmpty () )
            {
                final String data = StringHelper.join ( makeEquinoxList (), "\n" ) + "\n";
                this.deploymentContext.addFile ( new StaticContentProvider ( data ), "/etc/" + Constants.NEOSCADA_USER + "/applications", new FileInformation ( 0644, null, null, FileOptions.CONFIGURATION ) );
            }
        }
    }

    protected void setDeploymentContext ( final DeploymentContext deploymentContext )
    {
        this.deploymentContext = deploymentContext;
    }

    protected void createDrivers ( final IFolder nodeDir, final IProgressMonitor monitor, final File packageFolder, final Map<String, String> replacements ) throws IOException, Exception
    {
        for ( final String driverName : makeDriverList () )
        {
            createDriver ( nodeDir, monitor, packageFolder, replacements, driverName );
        }
    }

    protected void createDriver ( final IFolder nodeDir, final IProgressMonitor monitor, final File packageFolder, final Map<String, String> replacements, final String driverName ) throws IOException, Exception
    {
        final File sourceDir = new File ( nodeDir.getLocation ().toFile (), driverName );

        replacements.put ( "driverName", driverName );

        processDriver ( monitor, packageFolder, replacements, driverName, sourceDir );

        replacements.remove ( "driverName" );
    }

    protected void processDriver ( final IProgressMonitor monitor, final File packageFolder, final Map<String, String> replacements, final String driverName, final File sourceDir ) throws IOException, Exception
    {
        final Path sourcePath = sourceDir.toPath ().toAbsolutePath ();
        final String driverDir = "/etc/" + Constants.NEOSCADA_USER + "/drivers/" + driverName;

        java.nio.file.Files.walkFileTree ( sourceDir.toPath (), new ScoopFilesVisitor ( sourcePath, this.deploymentContext, driverDir ) );

        this.deploymentContext.addDirectory ( driverDir, new FileInformation ( 0755 ) );
        this.deploymentContext.addFile ( Contents.createContent ( CommonPackageHandler.class.getResourceAsStream ( "templates/driver.logback.xml" ), replacements ), driverDir + "/logback.xml", new FileInformation ( 0644, null, null, FileOptions.CONFIGURATION ) );
        this.deploymentContext.addFile ( Contents.createContent ( CommonPackageHandler.class.getResourceAsStream ( "templates/jvm.args" ), replacements ), driverDir + "/jvm.args", new FileInformation ( 0644, null, null, FileOptions.CONFIGURATION ) );

        final StartupHandler sm = createStartupHandler ( getDefaultStartupMechanism () );
        if ( sm != null )
        {
            sm.createDriver ( this.deploymentContext, driverName, replacements, monitor );
        }
    }

    protected void createEquinox ( final File sourceBase, final File packageFolder, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        for ( final String name : makeEquinoxList () )
        {
            replacements.put ( "appName", name );

            processEquinox ( sourceBase, packageFolder, replacements, monitor, name );

            replacements.remove ( "appName" );
        }
    }

    protected void processEquinox ( final File sourceBase, final File packageFolder, final Map<String, String> replacements, final IProgressMonitor monitor, final String name ) throws IOException, Exception, FileNotFoundException
    {
        final File source = new File ( sourceBase, name + "/" + name + ".profile.xml" );
        {
            // patch the profile, we need a copy for that
            final File tempFile = File.createTempFile ( "profile", ".xml" );
            try
            {
                Files.copy ( source.toPath (), tempFile.toPath (), StandardCopyOption.REPLACE_EXISTING );
                patchProfile ( name, tempFile );

                this.deploymentContext.addFile ( new FileContentProvider ( tempFile ), "/usr/share/" + Constants.NEOSCADA_USER + "/profiles/" + name + ".profile.xml", new FileInformation ( 0640, "root", Constants.NEOSCADA_USER ) );
            }
            finally
            {
                tempFile.delete ();
            }
        }

        this.deploymentContext.addDirectory ( "/usr/share/" + Constants.NEOSCADA_USER + "/profiles/" + name, new FileInformation ( 0755 ) );
        this.deploymentContext.addFile ( Contents.createContent ( CommonPackageHandler.class.getResourceAsStream ( "templates/app.logback.xml" ), replacements ), "/usr/share/" + Constants.NEOSCADA_USER + "/profiles/" + name + "/logback.xml", null );
        this.deploymentContext.addFile ( Contents.createContent ( CommonPackageHandler.class.getResourceAsStream ( "templates/scada.createApplication" ), replacements ), "/usr/bin/scada.create." + name, new FileInformation ( 0755 ) );
        this.deploymentContext.addFile ( new FileContentProvider ( new File ( sourceBase, name + "/data.json" ) ), "/usr/share/" + Constants.NEOSCADA_USER + "/ca.bootstrap/bootstrap." + name + ".json", new FileInformation ( 0640, "root", Constants.NEOSCADA_USER ) );

        final StartupHandler sm = createStartupHandler ( getDefaultStartupMechanism () );
        if ( sm != null )
        {
            sm.createEquinox ( this.deploymentContext, name, replacements, monitor );
        }
    }

    /**
     * Inject the CA bootstrap property to the profile
     *
     * @param file
     *            the profile.xml file in the package target
     * @throws IOException
     */
    protected void patchProfile ( final String appName, final File file ) throws IOException
    {
        final ResourceSet rs = new ResourceSetImpl ();
        final Resource r = rs.createResource ( URI.createFileURI ( file.toString () ) );
        r.load ( null );

        final Profile profile = (Profile)EcoreUtil.getObjectByType ( r.getContents (), ProfilePackage.Literals.PROFILE );
        Profiles.addSystemProperty ( profile, "org.eclipse.scada.ca.file.provisionJsonUrl", "file:///usr/share/" + Constants.NEOSCADA_USER + "/ca.bootstrap/bootstrap." + appName + ".json" );
        r.save ( null );
    }

    protected abstract StartupMechanism getDefaultStartupMechanism ();

    protected StartupHandler getStartupHandler ()
    {
        if ( this.startupHandler == null )
        {
            this.startupHandler = createStartupHandler ();
        }

        return this.startupHandler;
    }

    private StartupHandler createStartupHandler ()
    {
        return createStartupHandler ( getDefaultStartupMechanism () );
    }

    private StartupHandler createStartupHandler ( final StartupMechanism defaultStartupMechanism )
    {
        final StartupMechanism sm = getStartupMechanism ( defaultStartupMechanism );
        if ( sm == null )
        {
            return null;
        }

        switch ( sm )
        {
            case REDHAT_SYSV:
                return new RedhatSystemVHandler ();
            case UPSTART:
                return new UpstartHandler ( this.deploy.getOperatingSystem () );
            case LSB_SYSV:
                return new LSBSystemVHandler ();
            case SYSTEMD:
                return new SystemdHandler ();
            case DEFAULT:
                return null; // we ran of options here
        }
        throw new IllegalStateException ( String.format ( "Startup method %s is unsupported", sm ) );
    }

    /**
     * Get the startup mechanism to use
     *
     * @param defaultStartupMechanism
     *            the default if none is set
     * @return the startup mechanism, or the default
     */
    private StartupMechanism getStartupMechanism ( final StartupMechanism defaultStartupMechanism )
    {
        if ( this.deploy.getStartupMechanism () == null || this.deploy.getStartupMechanism () == StartupMechanism.DEFAULT )
        {
            final String type = OperatingSystemDescriptors.getProperty ( this.deploy.getOperatingSystem (), "startup", defaultStartupMechanism.name () );
            return StartupMechanism.valueOf ( type );
        }
        else
        {
            return this.deploy.getStartupMechanism ();
        }
    }

    protected String makeCreate ( final CommonDeploymentMechanism deploy )
    {
        final StringBuilder sb = new StringBuilder ();
        if ( deploy.isAutomaticCreate () )
        {
            String flags;

            if ( deploy.getRecreateBackups () == null )
            {
                flags = "-i";
            }
            else if ( deploy.getRecreateBackups () > 0 )
            {
                flags = "-b " + deploy.getRecreateBackups ();
            }
            else
            {
                flags = "-d";
            }

            for ( final String app : makeEquinoxList () )
            {
                sb.append ( String.format ( "echo -n Creating application \\'%s\\' ...\n", app ) );
                sb.append ( String.format ( "scada.create.%s %s > /dev/null\n", app, flags ) );
                sb.append ( String.format ( "echo \" done!\"\n", app ) );
            }
        }
        return sb.toString ();
    }

    protected void runSetup ( final CommonDeploymentMechanism deploy, final DeploymentContext context, final IProgressMonitor monitor ) throws Exception
    {
        if ( deploy.getSetup () != null )
        {
            SubModuleHandler.runSetup ( context, deploy.getSetup ().getModules (), this.deploy.getOperatingSystem () );
        }
        SubModuleHandler.runSetup ( context, deploy.getAdditionalSetupModules (), deploy.getOperatingSystem () );
        monitor.done ();
    }

    protected String createStopApps ()
    {
        final StringBuilder sb = new StringBuilder ();
        stopApplications ( sb );
        return sb.toString ();
    }

    protected String createStartApps ()
    {
        final StringBuilder sb = new StringBuilder ();
        startApplications ( sb );
        return sb.toString ();
    }

    protected void startApplications ( final StringBuilder sb )
    {
        final ScriptMaker sm = new ScriptMaker ( getStartupHandler () );

        for ( final String driver : makeDriverList () )
        {
            sm.appendStartDriver ( sb, driver );
        }

        if ( this.deploy.isAutomaticCreate () )
        {
            for ( final String app : makeEquinoxList () )
            {
                sm.appendStartApp ( sb, app );
            }
        }
    }

    protected void stopApplications ( final StringBuilder sb )
    {
        final ScriptMaker sm = new ScriptMaker ( getStartupHandler () );

        for ( final String driver : makeDriverList () )
        {
            sm.appendStopDriver ( sb, driver );
        }

        if ( this.deploy.isAutomaticCreate () )
        {
            for ( final String app : makeEquinoxList () )
            {
                sm.appendStopApp ( sb, app );
            }
        }
    }

}
