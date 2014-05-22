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
package org.eclipse.scada.configuration.world.lib.deployment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.StartupMechanism;
import org.eclipse.scada.configuration.world.lib.deployment.startup.LSBSystemVHandler;
import org.eclipse.scada.configuration.world.lib.deployment.startup.RedhatSystemVHandler;
import org.eclipse.scada.configuration.world.lib.deployment.startup.StartupHandler;
import org.eclipse.scada.configuration.world.lib.deployment.startup.UpstartHandler;
import org.eclipse.scada.configuration.world.lib.utils.CopyRecursive;
import org.eclipse.scada.configuration.world.lib.utils.Helper;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;
import org.eclipse.scada.configuration.world.osgi.profile.ProfileFactory;
import org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage;
import org.eclipse.scada.configuration.world.osgi.profile.SystemProperty;

public abstract class CommonPackageHandler extends CommonHandler
{
    private final CommonDeploymentMechanism deploy;

    private StartupHandler startupHandler;

    public CommonPackageHandler ( final ApplicationNode applicationNode, final CommonDeploymentMechanism deploy )
    {
        super ( applicationNode );
        this.deploy = deploy;
    }

    @Override
    protected abstract void handleProcess ( IFolder nodeDir, IProgressMonitor monitor, Map<String, String> properties ) throws Exception;

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
        final File driverDir = new File ( packageFolder, "src/etc/eclipsescada/drivers/" + driverName );

        replacements.put ( "driverName", driverName );

        processDriver ( monitor, packageFolder, replacements, driverName, sourceDir, driverDir );

        replacements.remove ( "driverName" );
    }

    protected void processDriver ( final IProgressMonitor monitor, final File packageFolder, final Map<String, String> replacements, final String driverName, final File sourceDir, final File driverDir ) throws IOException, Exception
    {
        driverDir.getParentFile ().mkdirs ();

        final CopyRecursive rec = new CopyRecursive ( sourceDir.toPath (), driverDir.toPath () );
        java.nio.file.Files.walkFileTree ( sourceDir.toPath (), rec );

        Helper.createFile ( new File ( packageFolder, "src/etc/eclipsescada/drivers/" + driverName + "/logback.xml" ), CommonPackageHandler.class.getResourceAsStream ( "templates/driver.logback.xml" ), replacements, monitor );
        Helper.createFile ( new File ( packageFolder, "src/etc/eclipsescada/drivers/" + driverName + "/jvm.args" ), CommonPackageHandler.class.getResourceAsStream ( "templates/jvm.args" ), replacements, monitor );

        final StartupHandler sm = createStartupHandler ( getDefaultStartupMechanism () );
        if ( sm != null )
        {
            sm.createDriver ( packageFolder, driverName, replacements, monitor );
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
        final File target = new File ( packageFolder, "src/usr/share/eclipsescada/profiles/" + name + ".profile.xml" );
        target.getParentFile ().mkdirs ();

        java.nio.file.Files.copy ( source.toPath (), target.toPath (), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES );

        Helper.createFile ( new File ( packageFolder, "src/usr/share/eclipsescada/profiles/" + name + "/logback.xml" ), DebianHandler.class.getResourceAsStream ( "templates/app.logback.xml" ), replacements, monitor );

        final File createFile = new File ( packageFolder, "src/usr/bin/scada.create." + name );
        Helper.createFile ( createFile, DebianHandler.class.getResourceAsStream ( "templates/scada.createApplication" ), replacements, monitor );
        Helper.createFile ( new File ( packageFolder, "src/usr/share/eclipsescada/ca.bootstrap/bootstrap." + name + ".json" ), new FileInputStream ( new File ( sourceBase, name + "/data.json" ) ), monitor, false );

        createFile.setExecutable ( true );

        patchProfile ( name, target );

        final StartupHandler sm = createStartupHandler ( getDefaultStartupMechanism () );
        if ( sm != null )
        {
            sm.createEquinox ( packageFolder, name, replacements, monitor );
        }
    }

    /**
     * Inject the CA bootstrap property to the profile
     * 
     * @param file
     *            the profile.xml file in the debian package target
     * @throws IOException
     */
    protected void patchProfile ( final String name, final File file ) throws IOException
    {
        final ResourceSet rs = new ResourceSetImpl ();
        final Resource r = rs.createResource ( URI.createFileURI ( file.toString () ) );
        r.load ( null );

        final Profile profile = (Profile)EcoreUtil.getObjectByType ( r.getContents (), ProfilePackage.Literals.PROFILE );
        final SystemProperty bootstrap = ProfileFactory.eINSTANCE.createSystemProperty ();
        bootstrap.setKey ( "org.eclipse.scada.ca.file.provisionJsonUrl" );
        bootstrap.setValue ( "file:///usr/share/eclipsescada/ca.bootstrap/bootstrap." + name + ".json" );
        profile.getProperty ().add ( bootstrap );
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
                return new UpstartHandler ();
            case LSB_SYSV:
                return new LSBSystemVHandler ();
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
            return defaultStartupMechanism;
        }
        else
        {
            return this.deploy.getStartupMechanism ();
        }
    }
}
