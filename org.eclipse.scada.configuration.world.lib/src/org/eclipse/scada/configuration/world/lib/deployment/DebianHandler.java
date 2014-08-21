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

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.scada.configuration.lib.Nodes;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.deployment.ChangeEntry;
import org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.StartupMechanism;
import org.eclipse.scada.configuration.world.lib.deployment.startup.StartupHandler;
import org.eclipse.scada.configuration.world.lib.setup.SubModuleHandler;
import org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor;
import org.eclipse.scada.configuration.world.setup.SetupModuleContainer;
import org.eclipse.scada.utils.pkg.deb.DebianPackageWriter;
import org.eclipse.scada.utils.pkg.deb.EntryInformation;
import org.eclipse.scada.utils.pkg.deb.control.BinaryPackageControlFile;
import org.eclipse.scada.utils.str.StringHelper;

import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;

public class DebianHandler extends CommonPackageHandler
{
    private static final String CONTROL_SCRIPTS_DIR = "/usr/lib/eclipsescada/packagescripts";

    private final DebianDeploymentMechanism deploy;

    public DebianHandler ( final ApplicationNode applicationNode, final DebianDeploymentMechanism deploy )
    {
        super ( applicationNode, deploy );
        this.deploy = deploy;
    }

    @Override
    protected String getBaseFolderName ()
    {
        return "debian-packages"; //$NON-NLS-1$
    }

    @Override
    protected void handleProcess ( final IFolder nodeDir, final IProgressMonitor monitor, final Map<String, String> properties ) throws Exception
    {
        final File packageFolder = getPackageFolder ( nodeDir );

        final String packageName = getPackageName ();

        final String version = findVersion ();

        final BinaryPackageControlFile packageControlFile = new BinaryPackageControlFile ();
        packageControlFile.setPackage ( packageName );
        packageControlFile.setArchitecture ( "all" ); //$NON-NLS-1$
        packageControlFile.setVersion ( version );
        packageControlFile.setPriority ( "required" ); //$NON-NLS-1$
        packageControlFile.setSection ( "misc" ); //$NON-NLS-1$
        packageControlFile.setMaintainer ( String.format ( "%s <%s>", this.deploy.getMaintainer ().getName (), this.deploy.getMaintainer ().getEmail () ) ); //$NON-NLS-1$
        packageControlFile.setDescription ( String.format ( "Configuration package for %s", Nodes.makeName ( this.applicationNode ) ), "This is an automatically generated configuration package" );

        packageControlFile.set ( BinaryPackageControlFile.Fields.CONFLICTS, "org.openscada.drivers.common, org.openscada" ); //$NON-NLS-1$

        final Map<String, String> replacements = new HashMap<> ();
        replacements.put ( "packageName", packageName ); //$NON-NLS-1$
        replacements.put ( "authorName", this.deploy.getMaintainer ().getName () ); //$NON-NLS-1$
        replacements.put ( "authorEmail", this.deploy.getMaintainer ().getEmail () ); //$NON-NLS-1$
        replacements.put ( "nodeName", this.applicationNode.getName () == null ? this.applicationNode.getHostName () : this.applicationNode.getName () ); //$NON-NLS-1$

        replacements.put ( "stop.apps", createStopApps () ); //$NON-NLS-1$
        replacements.put ( "start.apps", createStartApps () ); //$NON-NLS-1$
        replacements.put ( "create.apps", makeCreate ( this.deploy ) ); //$NON-NLS-1$
        replacements.put ( "multiuserScreen", this.deploy.isMultiUserScreen () ? "1" : "0" );

        final Set<String> dependencies = new HashSet<> ();

        final StringBuilder postInstallation = new StringBuilder ();

        final Map<String, File> tempFiles = new HashMap<> ();

        final SetupModuleContainer setup = this.deploy.getSetup ();
        if ( setup != null )
        {
            final DeploymentContext context = new DeploymentContext () {

                @Override
                public void addInstallDependency ( final String packageName )
                {
                    dependencies.add ( packageName );
                }

                @Override
                public void addPostInstallationScript ( final Reader reader ) throws IOException
                {
                    try
                    {
                        CharStreams.copy ( reader, postInstallation );
                    }
                    finally
                    {
                        reader.close ();
                    }
                }

                @Override
                public void runAfterInstallation ( final String script )
                {
                    postInstallation.append ( "if test \"$1\" = configure ; then\n" );
                    postInstallation.append ( script );
                    postInstallation.append ( "\nfi\n" );
                }

                @Override
                public void addFile ( final InputStream resource, final String targetFile ) throws IOException
                {
                    try
                    {
                        final File tmp = Files.createTempFile ( "data", "" ).toFile ();
                        final File old = tempFiles.put ( targetFile, tmp );
                        if ( old != null )
                        {
                            old.delete ();
                        }
                        try ( BufferedOutputStream os = new BufferedOutputStream ( new FileOutputStream ( tmp ) ) )
                        {
                            ByteStreams.copy ( resource, os );
                        }
                    }
                    finally
                    {
                        resource.close ();
                    }
                }
            };
            runSetup ( setup, this.deploy.getOperatingSystem (), context, new SubProgressMonitor ( monitor, 1 ) );
        }

        replacements.put ( "postinst.scripts", postInstallation.toString () + "\n" + createUserScriptCallbacks ( packageFolder, "postinst" ) ); //$NON-NLS-1$ //$NON-NLS-2$
        replacements.put ( "preinst.scripts", createUserScriptCallbacks ( packageFolder, "preinst" ) ); //$NON-NLS-1$ //$NON-NLS-2$
        replacements.put ( "prerm.scripts", createUserScriptCallbacks ( packageFolder, "prerm" ) ); //$NON-NLS-1$ //$NON-NLS-2$
        replacements.put ( "postrm.scripts", createUserScriptCallbacks ( packageFolder, "postrm" ) ); //$NON-NLS-1$ //$NON-NLS-2$

        packageControlFile.set ( BinaryPackageControlFile.Fields.DEPENDS, makeDependencies ( dependencies ) );

        final File outputFile = new File ( nodeDir.getLocation ().toFile (), packageControlFile.makeFileName () );
        outputFile.getParentFile ().mkdirs ();
        try ( DebianPackageWriter deb = new DebianPackageWriter ( new FileOutputStream ( outputFile ), packageControlFile ) )
        {
            deb.setPostinstScript ( Contents.createContent ( DebianHandler.class.getResourceAsStream ( "templates/deb/postinst" ), replacements ) ); //$NON-NLS-1$
            deb.setPostrmScript ( Contents.createContent ( DebianHandler.class.getResourceAsStream ( "templates/deb/postrm" ), replacements ) ); //$NON-NLS-1$
            deb.setPrermScript ( Contents.createContent ( DebianHandler.class.getResourceAsStream ( "templates/deb/prerm" ), replacements ) ); //$NON-NLS-1$
            deb.setPreinstScript ( Contents.createContent ( DebianHandler.class.getResourceAsStream ( "templates/deb/preinst" ), replacements ) ); //$NON-NLS-1$

            if ( !makeEquinoxList ().isEmpty () )
            {
                deb.addFile ( StringHelper.join ( makeEquinoxList (), "\n" ) + "\n", "/etc/eclipsescada/applications", EntryInformation.DEFAULT_FILE_CONF );
            }

            for ( final Map.Entry<String, File> entry : tempFiles.entrySet () )
            {
                deb.addFile ( entry.getValue (), entry.getKey (), null );
            }

            createDrivers ( deb, nodeDir, monitor, packageFolder, replacements );
            createEquinox ( deb, nodeDir.getLocation ().toFile (), packageFolder, replacements, monitor );

            // scoop up "src" files
            final Path src = new File ( packageFolder, "src" ).toPath (); //$NON-NLS-1$
            if ( src.toFile ().isDirectory () )
            {
                final ScoopFilesVisitor scoop = new ScoopFilesVisitor ( src, deb, null );
                scoop.getIgnorePrefix ().add ( CONTROL_SCRIPTS_DIR );
                Files.walkFileTree ( src, scoop );
            }
        }

        nodeDir.refreshLocal ( IResource.DEPTH_INFINITE, monitor );
    }

    private void runSetup ( final SetupModuleContainer setup, final OperatingSystemDescriptor operatingSystem, final DeploymentContext context, final IProgressMonitor monitor ) throws Exception
    {
        SubModuleHandler.runSetup ( context, setup.getModules (), operatingSystem );
        monitor.done ();
    }

    private String findVersion ()
    {
        final ArrayList<ChangeEntry> sortedChanges = new ArrayList<> ( this.deploy.getChanges () );
        if ( sortedChanges.isEmpty () )
        {
            throw new IllegalStateException ( String.format ( "No change record found" ) );
        }

        Collections.sort ( sortedChanges, new ChangeEntryComparator ( true ) );
        return sortedChanges.get ( 0 ).getVersion ();
    }

    /**
     * This method scoops up all package scripts and create the calls in the
     * corresponding package scripts
     *
     * @throws IOException
     */
    private String createUserScriptCallbacks ( final File packageFolder, final String type ) throws IOException
    {
        final File dir = new File ( packageFolder, "src" + CONTROL_SCRIPTS_DIR + "/" + getPackageName () + "/" + type ); //$NON-NLS-1$ //$NON-NLS-2$

        if ( !dir.isDirectory () )
        {
            return "";
        }

        final StringWriter sw = new StringWriter ();
        final Charset cs = Charset.forName ( "UTF-8" );

        final File[] files = dir.listFiles ();
        Arrays.sort ( files );
        for ( final File file : files )
        {
            if ( !file.isFile () )
            {
                continue;
            }

            sw.write ( String.format ( "# ================== START - %s ==================\n", file ) );

            try ( Reader reader = Files.newBufferedReader ( file.toPath (), cs ) )
            {
                CharStreams.copy ( reader, sw );
            }

            sw.write ( String.format ( "# ==================  END - %s  ==================\n", file ) );

            file.setExecutable ( true );
        }

        return sw.toString ();
    }

    @Override
    protected StartupMechanism getDefaultStartupMechanism ()
    {
        return StartupMechanism.UPSTART;
    }

    private String makeDependencies ( final Set<String> dependencies )
    {
        final Set<String> result = new HashSet<> ();

        result.add ( "org.eclipse.scada" ); //$NON-NLS-1$

        if ( needP2 () )
        {
            result.add ( "org.eclipse.scada.p2" ); //$NON-NLS-1$
        }

        result.add ( "org.eclipse.scada.deploy.p2-incubation" ); //$NON-NLS-1$
        result.addAll ( this.deploy.getAdditionalDependencies () );

        final StartupHandler sh = getStartupHandler ();
        if ( sh != null )
        {
            result.addAll ( sh.getAdditionalPackageDependencies () );
        }
        result.addAll ( dependencies );

        return StringHelper.join ( result, ", " ); //$NON-NLS-1$
    }

    private String createStopApps ()
    {
        final StringBuilder sb = new StringBuilder ();
        stopApplications ( sb );
        return sb.toString ();
    }

    private String createStartApps ()
    {
        final StringBuilder sb = new StringBuilder ();
        startApplications ( sb );
        return sb.toString ();
    }

    protected void startApplications ( final StringBuilder sb )
    {
        final StartupHandler sh = getStartupHandler ();
        if ( sh == null )
        {
            return;
        }

        for ( final String driver : makeDriverList () )
        {
            final String cmd = sh.startDriverCommand ( driver );
            if ( cmd == null )
            {
                continue;
            }

            sb.append ( String.format ( "    %s || echo failed to start %s", cmd, driver ) ); //$NON-NLS-1$
            sb.append ( '\n' );
        }

        if ( this.deploy.isAutomaticCreate () )
        {
            for ( final String app : makeEquinoxList () )
            {
                final String cmd = sh.startEquinoxCommand ( app );
                if ( cmd == null )
                {
                    continue;
                }

                sb.append ( String.format ( "    %s || echo failed to start %s", cmd, app ) ); //$NON-NLS-1$
                sb.append ( '\n' );
            }
        }
    }

    protected void stopApplications ( final StringBuilder sb )
    {
        final StartupHandler sh = getStartupHandler ();
        if ( sh == null )
        {
            return;
        }

        for ( final String driver : makeDriverList () )
        {
            final String cmd = sh.stopDriverCommand ( driver );
            if ( cmd == null )
            {
                continue;
            }
            sb.append ( String.format ( "    %s || echo failed to stop %s", cmd, driver ) ); //$NON-NLS-1$
            sb.append ( '\n' );
        }

        if ( this.deploy.isAutomaticCreate () )
        {
            for ( final String app : makeEquinoxList () )
            {
                final String cmd = sh.stopEquinoxCommand ( app );
                if ( cmd == null )
                {
                    continue;
                }
                sb.append ( String.format ( "    %s || echo failed to stop %s", cmd, app ) ); //$NON-NLS-1$
                sb.append ( '\n' );
            }
        }
    }

    /*
    private String createChangeLog ( final String packageName, final List<ChangeEntry> changes )
    {
        final StringBuilder sb = new StringBuilder ();

        final ArrayList<ChangeEntry> sortedChanges = new ArrayList<> ( changes );
        Collections.sort ( sortedChanges, new ChangeEntryComparator ( true ) );

        for ( final ChangeEntry entry : sortedChanges )
        {
            sb.append ( String.format ( "%s (%s) stable; urgency=low\n", packageName, entry.getVersion () ) );
            sb.append ( '\n' );
            sb.append ( "  * " + entry.getDescription () );
            sb.append ( '\n' );
            sb.append ( '\n' ); // additional empty line

            try ( Formatter f = new Formatter ( sb, Locale.ENGLISH ) )
            {
                f.format ( " -- %1$s <%2$s>  %3$ta, %3$te %3$tb %3$tY %3$tT %3$tz", entry.getAuthor ().getName (), entry.getAuthor ().getEmail (), entry.getDate () );
            }

            sb.append ( "\n\n" );
        }

        return sb.toString ();
    }
     */
}
