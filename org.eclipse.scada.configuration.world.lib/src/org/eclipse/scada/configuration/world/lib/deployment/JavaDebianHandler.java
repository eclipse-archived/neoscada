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
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.lib.Nodes;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.deployment.ChangeEntry;
import org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.StartupMechanism;
import org.eclipse.scada.configuration.world.lib.deployment.startup.StartupHandler;
import org.eclipse.scada.utils.pkg.deb.DebianPackageWriter;
import org.eclipse.scada.utils.pkg.deb.control.BinaryPackageControlFile;
import org.eclipse.scada.utils.str.StringHelper;

public class JavaDebianHandler extends CommonPackageHandler
{
    private final DebianDeploymentMechanism deploy;

    public JavaDebianHandler ( final ApplicationNode applicationNode, final DebianDeploymentMechanism deploy )
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
        packageControlFile.setMaintainer ( String.format ( "%s <%s>", this.deploy.getMaintainer ().getName (), this.deploy.getMaintainer ().getEmail () ) );
        packageControlFile.setDescription ( String.format ( "Configuration package for %s", Nodes.makeName ( this.applicationNode ) ), "This is an automatically generated configuration package" );

        packageControlFile.set ( BinaryPackageControlFile.Fields.CONFLICTS, "org.openscada.drivers.common, org.openscada" );
        packageControlFile.set ( BinaryPackageControlFile.Fields.DEPENDS, makeDependencies () );

        final Map<String, String> replacements = new HashMap<> ();
        replacements.put ( "packageName", packageName ); //$NON-NLS-1$
        replacements.put ( "authorName", this.deploy.getMaintainer ().getName () ); //$NON-NLS-1$
        replacements.put ( "authorEmail", this.deploy.getMaintainer ().getEmail () ); //$NON-NLS-1$
        replacements.put ( "nodeName", this.applicationNode.getName () == null ? this.applicationNode.getHostName () : this.applicationNode.getName () ); //$NON-NLS-1$
        replacements.put ( "postinst.restart", createPostInst () ); //$NON-NLS-1$
        replacements.put ( "prerm.stop", createPreRm () ); //$NON-NLS-1$

        replacements.put ( "postinst.scripts", createUserScriptCallbacks ( packageFolder, "postinst" ) );
        replacements.put ( "prerm.scripts", createUserScriptCallbacks ( packageFolder, "prerm" ) );
        replacements.put ( "postrm.scripts", createUserScriptCallbacks ( packageFolder, "postrm" ) );

        final File outputFile = new File ( nodeDir.getLocation ().toFile (), packageControlFile.makeFileName () );
        outputFile.getParentFile ().mkdirs ();
        try ( DebianPackageWriter deb = new DebianPackageWriter ( new FileOutputStream ( outputFile ), packageControlFile ) )
        {
            deb.setPostinstScript ( Contents.createContent ( JavaDebianHandler.class.getResourceAsStream ( "templates/deb/postinst" ), replacements ) );
            deb.setPostrmScript ( Contents.createContent ( JavaDebianHandler.class.getResourceAsStream ( "templates/deb/postrm" ), replacements ) );
            deb.setPrermScript ( Contents.createContent ( JavaDebianHandler.class.getResourceAsStream ( "templates/deb/prerm" ), replacements ) );

            createDrivers ( deb, nodeDir, monitor, packageFolder, replacements );
            createEquinox ( deb, nodeDir.getLocation ().toFile (), packageFolder, replacements, monitor );

            // scoop up "src" files
            final Path src = new File ( packageFolder, "src" ).toPath ();
            if ( src.toFile ().isDirectory () )
            {
                final ScoopFilesVisitor scoop = new ScoopFilesVisitor ( src, deb, null );
                scoop.getExecPrefix ().add ( "/usr/lib/eclipsescada/packagescripts" );
                Files.walkFileTree ( src, scoop );
            }

        }

        nodeDir.refreshLocal ( IResource.DEPTH_INFINITE, monitor );
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
     */
    private String createUserScriptCallbacks ( final File packageFolder, final String type )
    {
        final File dir = new File ( packageFolder, "src/usr/lib/eclipsescada/packagescripts/" + getPackageName () + "/" + type );
        final List<String> scripts = new LinkedList<> ();

        if ( !dir.isDirectory () )
        {
            return "";
        }

        for ( final File file : dir.listFiles () )
        {
            if ( !file.isFile () )
            {
                continue;
            }
            file.setExecutable ( true );
            scripts.add ( "/usr/lib/eclipsescada/packagescripts/" + getPackageName () + "/" + type + "/" + file.getName () + " $@" );
        }
        return StringHelper.join ( scripts, "\n" );
    }

    @Override
    protected StartupMechanism getDefaultStartupMechanism ()
    {
        return StartupMechanism.UPSTART;
    }

    private String makeDependencies ()
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

        return StringHelper.join ( result, ", " ); //$NON-NLS-1$
    }

    private String createPostInst ()
    {
        final StartupHandler sh = getStartupHandler ();
        if ( sh == null )
        {
            return "";
        }

        final StringBuilder sb = new StringBuilder ();

        for ( final String driver : makeDriverList () )
        {
            final String cmd = sh.restartDriverCommand ( driver );
            if ( cmd == null )
            {
                continue;
            }

            sb.append ( String.format ( "    %s || echo failed to restart %s", cmd, driver ) );
            sb.append ( '\n' );
        }

        for ( final String app : makeEquinoxList () )
        {
            final String cmd = sh.restartEquinoxCommand ( app );
            if ( cmd == null )
            {
                continue;
            }

            sb.append ( String.format ( "    %s || echo failed to restart %s", cmd, app ) );
            sb.append ( '\n' );
        }

        return sb.toString ();
    }

    private String createPreRm ()
    {
        final StringBuilder sb = new StringBuilder ();

        final StartupHandler sh = getStartupHandler ();
        if ( sh == null )
        {
            return "";
        }

        for ( final String driver : makeDriverList () )
        {
            final String cmd = sh.stopDriverCommand ( driver );
            if ( cmd == null )
            {
                continue;
            }
            sb.append ( String.format ( "    %s || echo failed to stop %s", cmd, driver ) );
            sb.append ( '\n' );
        }

        for ( final String app : makeEquinoxList () )
        {
            final String cmd = sh.stopEquinoxCommand ( app );
            if ( cmd == null )
            {
                continue;
            }
            sb.append ( String.format ( "    %s || echo failed to stop %s", cmd, app ) );
            sb.append ( '\n' );
        }

        return sb.toString ();
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
