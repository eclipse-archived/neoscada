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
package org.eclipse.scada.configuration.world.lib.deployment.debian;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.lib.Nodes;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.deployment.ChangeEntry;
import org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.StartupMechanism;
import org.eclipse.scada.configuration.world.lib.deployment.ChangeEntryComparator;
import org.eclipse.scada.configuration.world.lib.deployment.CommonHandler;
import org.eclipse.scada.configuration.world.lib.deployment.CommonPackageHandler;
import org.eclipse.scada.configuration.world.lib.deployment.Contents;
import org.eclipse.scada.configuration.world.lib.deployment.ScoopFilesVisitor;
import org.eclipse.scada.configuration.world.lib.deployment.ScriptMaker;
import org.eclipse.scada.configuration.world.lib.deployment.startup.StartupHandler;
import org.eclipse.scada.configuration.world.lib.utils.Constants;
import org.eclipse.packagedrone.utils.deb.build.DebianPackageWriter;
import org.eclipse.packagedrone.utils.deb.control.BinaryPackageControlFile;
import org.eclipse.scada.utils.str.StringHelper;

import com.google.common.io.CharStreams;

public class DebianHandler extends CommonPackageHandler
{
    private static final String CONTROL_SCRIPTS_DIR = "/usr/lib/" + Constants.NEOSCADA_USER +"/packagescripts";

    private static final String NL = "\n";

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

        final DebianDeploymentContext context = new DebianDeploymentContext ( packageName );
        setDeploymentContext ( context );

        // call super

        super.handleProcess ( nodeDir, monitor, properties );

        // process self

        final String version = findVersion ();

        final BinaryPackageControlFile packageControlFile = new BinaryPackageControlFile ();
        packageControlFile.setPackage ( packageName );
        packageControlFile.setArchitecture ( "all" ); //$NON-NLS-1$
        packageControlFile.setVersion ( version );
        packageControlFile.setPriority ( "required" ); //$NON-NLS-1$
        packageControlFile.setSection ( "misc" ); //$NON-NLS-1$
        packageControlFile.setMaintainer ( String.format ( "%s <%s>", this.deploy.getMaintainer ().getName (), this.deploy.getMaintainer ().getEmail () ) ); //$NON-NLS-1$
        // packageControlFile.setDescription ( String.format ( "Configuration package for %s", Nodes.makeName ( this.applicationNode ) ), "This is an automatically generated configuration package" );
        // FIXME: use multiline option again at some point, but has to be implemented in package drone first
        packageControlFile.setDescription ( String.format ( "Configuration package for %s", Nodes.makeName ( this.applicationNode ) ) + "\n\nThis is an automatically generated configuration package" );

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

        createDrivers ( nodeDir, monitor, packageFolder, replacements );
        createEquinox ( nodeDir.getLocation ().toFile (), packageFolder, replacements, monitor );

        try
        {
            // scoop up "src" files
            final Path src = new File ( packageFolder, "src" ).toPath (); //$NON-NLS-1$
            if ( src.toFile ().isDirectory () )
            {
                final ScoopFilesVisitor scoop = new ScoopFilesVisitor ( src, context, null );
                scoop.getIgnorePrefix ().add ( CONTROL_SCRIPTS_DIR );
                Files.walkFileTree ( src, scoop );
            }

            packageControlFile.set ( BinaryPackageControlFile.Fields.PRE_DEPENDS, makePreDependencies ( Collections.<String> emptyList () ) );
            packageControlFile.set ( BinaryPackageControlFile.Fields.DEPENDS, makeDependencies ( context.getDependencies () ) );

            final File outputFile = new File ( nodeDir.getLocation ().toFile (), packageControlFile.makeFileName () );
            outputFile.getParentFile ().mkdirs ();

            try ( DebianPackageWriter deb = new DebianPackageWriter ( new FileOutputStream ( outputFile ), packageControlFile ) )
            {
                final ScriptMaker sm = new ScriptMaker ( getStartupHandler () );

                replacements.put ( "postinst.scripts", context.getPostInstallationString () + NL + createUserScriptCallbacks ( packageFolder, "postinst" ) + sm.makePostInst () ); //$NON-NLS-1$ //$NON-NLS-2$
                replacements.put ( "preinst.scripts", context.getPreInstallationString () + NL + createUserScriptCallbacks ( packageFolder, "preinst" + sm.makePreInst () ) ); //$NON-NLS-1$ //$NON-NLS-2$
                replacements.put ( "prerm.scripts", context.getPreRemovalString () + NL + createUserScriptCallbacks ( packageFolder, "prerm" ) + sm.makePreRem () ); //$NON-NLS-1$ //$NON-NLS-2$
                replacements.put ( "postrm.scripts", context.getPostRemovalString () + NL + createUserScriptCallbacks ( packageFolder, "postrm" + sm.makePostRem () ) ); //$NON-NLS-1$ //$NON-NLS-2$

                deb.setPostinstScript ( Contents.createContent ( CommonHandler.class.getResourceAsStream ( "templates/deb/postinst" ), replacements ) ); //$NON-NLS-1$
                deb.setPostrmScript ( Contents.createContent ( CommonHandler.class.getResourceAsStream ( "templates/deb/postrm" ), replacements ) ); //$NON-NLS-1$
                deb.setPrermScript ( Contents.createContent ( CommonHandler.class.getResourceAsStream ( "templates/deb/prerm" ), replacements ) ); //$NON-NLS-1$
                deb.setPreinstScript ( Contents.createContent ( CommonHandler.class.getResourceAsStream ( "templates/deb/preinst" ), replacements ) ); //$NON-NLS-1$

                context.scoopFiles ( deb );
            }
        }
        finally
        {
            nodeDir.refreshLocal ( IResource.DEPTH_INFINITE, monitor );
        }
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

    private String makePreDependencies ( final Collection<String> dependencies )
    {
        final Set<String> result = new TreeSet<> ( dependencies );

        result.add ( "neoscada.common" ); //$NON-NLS-1$

        return StringHelper.join ( result, ", " ); //$NON-NLS-1$
    }

    private String makeDependencies ( final Set<String> dependencies )
    {
        final Set<String> result = new HashSet<> ();

        if ( needP2 () )
        {
            result.add ( "org.eclipse.platform" ); //$NON-NLS-1$
            result.add ( "emf-xsd-Update" ); //$NON-NLS-1$
            result.add ( "equinox-sdk" ); //$NON-NLS-1$
            result.add ( "gemini-dbaccess" ); //$NON-NLS-1$
            result.add ( "neoscada.deploy.p2director" ); //$NON-NLS-1$
        }

        result.add ( "neoscada.protocols.p2" ); //$NON-NLS-1$
        result.addAll ( this.deploy.getAdditionalDependencies () );

        final StartupHandler sh = getStartupHandler ();
        if ( sh != null )
        {
            result.addAll ( sh.getAdditionalPackageDependencies () );
        }
        result.addAll ( dependencies );

        return StringHelper.join ( result, ", " ); //$NON-NLS-1$
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
