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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
import org.eclipse.scada.configuration.world.osgi.profile.Profile;
import org.eclipse.scada.configuration.world.osgi.profile.ProfileFactory;
import org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage;
import org.eclipse.scada.configuration.world.osgi.profile.SystemProperty;
import org.eclipse.scada.utils.pkg.deb.BinaryPackageBuilder;
import org.eclipse.scada.utils.pkg.deb.EntryInformation;
import org.eclipse.scada.utils.pkg.deb.FileContentProvider;

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

    protected void createDrivers ( final BinaryPackageBuilder builder, final IFolder nodeDir, final IProgressMonitor monitor, final File packageFolder, final Map<String, String> replacements ) throws IOException, Exception
    {
        for ( final String driverName : makeDriverList () )
        {
            createDriver ( builder, nodeDir, monitor, packageFolder, replacements, driverName );
        }
    }

    protected void createDriver ( final BinaryPackageBuilder builder, final IFolder nodeDir, final IProgressMonitor monitor, final File packageFolder, final Map<String, String> replacements, final String driverName ) throws IOException, Exception
    {
        final File sourceDir = new File ( nodeDir.getLocation ().toFile (), driverName );

        replacements.put ( "driverName", driverName );

        processDriver ( builder, monitor, packageFolder, replacements, driverName, sourceDir );

        replacements.remove ( "driverName" );
    }

    protected void processDriver ( final BinaryPackageBuilder builder, final IProgressMonitor monitor, final File packageFolder, final Map<String, String> replacements, final String driverName, final File sourceDir ) throws IOException, Exception
    {
        final Path sourcePath = sourceDir.toPath ().toAbsolutePath ();
        final String driverDir = "/etc/eclipsescada/drivers/" + driverName;

        java.nio.file.Files.walkFileTree ( sourceDir.toPath (), new ScoopFilesVisitor ( sourcePath, builder, driverDir ) );

        builder.addFile ( Contents.createContent ( CommonPackageHandler.class.getResourceAsStream ( "templates/driver.logback.xml" ), replacements ), driverDir + "/logback.xml", EntryInformation.DEFAULT_FILE_CONF );
        builder.addFile ( Contents.createContent ( CommonPackageHandler.class.getResourceAsStream ( "templates/jvm.args" ), replacements ), driverDir + "/jvm.args", EntryInformation.DEFAULT_FILE_CONF );

        final StartupHandler sm = createStartupHandler ( getDefaultStartupMechanism () );
        if ( sm != null )
        {
            sm.createDriver ( builder, driverName, replacements, monitor );
        }
    }

    protected void createEquinox ( final BinaryPackageBuilder builder, final File sourceBase, final File packageFolder, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        for ( final String name : makeEquinoxList () )
        {
            replacements.put ( "appName", name );

            processEquinox ( builder, sourceBase, packageFolder, replacements, monitor, name );

            replacements.remove ( "appName" );
        }
    }

    protected void processEquinox ( final BinaryPackageBuilder builder, final File sourceBase, final File packageFolder, final Map<String, String> replacements, final IProgressMonitor monitor, final String name ) throws IOException, Exception, FileNotFoundException
    {
        final File source = new File ( sourceBase, name + "/" + name + ".profile.xml" );
        {
            // patch the profile, we need a copy for that
            final File tempFile = File.createTempFile ( "profile", ".xml" );
            Files.copy ( source.toPath (), tempFile.toPath (), StandardCopyOption.REPLACE_EXISTING );
            patchProfile ( name, tempFile );

            builder.addFile ( new FileContentProvider ( tempFile ), "/usr/share/eclipsescada/profiles/" + name + ".profile.xml", null );
        }

        builder.addFile ( Contents.createContent ( CommonPackageHandler.class.getResourceAsStream ( "templates/app.logback.xml" ), replacements ), "/usr/share/eclipsescada/profiles/" + name + "/logback.xml", EntryInformation.DEFAULT_FILE );
        builder.addFile ( Contents.createContent ( CommonPackageHandler.class.getResourceAsStream ( "templates/scada.createApplication" ), replacements ), "/usr/bin/scada.create." + name, EntryInformation.DEFAULT_FILE_EXEC );
        builder.addFile ( new FileContentProvider ( new File ( sourceBase, name + "/data.json" ) ), "/usr/share/eclipsescada/ca.bootstrap/bootstrap." + name + ".json", EntryInformation.DEFAULT_FILE );

        final StartupHandler sm = createStartupHandler ( getDefaultStartupMechanism () );
        if ( sm != null )
        {
            sm.createEquinox ( builder, name, replacements, monitor );
        }
    }

    /**
     * Inject the CA bootstrap property to the profile
     *
     * @param file
     *            the profile.xml file in the debian package target
     * @throws IOException
     */
    protected void patchProfile ( final String appName, final File file ) throws IOException
    {
        final ResourceSet rs = new ResourceSetImpl ();
        final Resource r = rs.createResource ( URI.createFileURI ( file.toString () ) );
        r.load ( null );

        final Profile profile = (Profile)EcoreUtil.getObjectByType ( r.getContents (), ProfilePackage.Literals.PROFILE );
        final SystemProperty bootstrap = ProfileFactory.eINSTANCE.createSystemProperty ();
        bootstrap.setKey ( "org.eclipse.scada.ca.file.provisionJsonUrl" );
        bootstrap.setValue ( "file:///usr/share/eclipsescada/ca.bootstrap/bootstrap." + appName + ".json" );
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
