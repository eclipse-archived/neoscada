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
package org.eclipse.scada.configuration.world.lib.deployment.redhat;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.deployment.ChangeEntry;
import org.eclipse.scada.configuration.world.deployment.RedhatDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.StartupMechanism;
import org.eclipse.scada.configuration.world.lib.deployment.ChangeEntryComparator;
import org.eclipse.scada.configuration.world.lib.deployment.CommonHandler;
import org.eclipse.scada.configuration.world.lib.deployment.CommonPackageHandler;
import org.eclipse.scada.configuration.world.lib.deployment.FileInformation;
import org.eclipse.scada.configuration.world.lib.deployment.FileOptions;
import org.eclipse.scada.configuration.world.lib.deployment.ScriptMaker;
import org.eclipse.scada.configuration.world.lib.deployment.startup.StartupHandler;
import org.eclipse.scada.configuration.world.lib.utils.Helper;
import org.eclipse.scada.configuration.world.lib.utils.ProcessRunner;
import org.eclipse.scada.utils.str.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LegacyRedhatHandler extends CommonPackageHandler
{
    private final static Logger logger = LoggerFactory.getLogger ( LegacyRedhatHandler.class );

    private final RedhatDeploymentMechanism deploy;

    public LegacyRedhatHandler ( final ApplicationNode applicationNode, final RedhatDeploymentMechanism deploy )
    {
        super ( applicationNode, deploy );
        this.deploy = deploy;
    }

    @Override
    protected StartupMechanism getDefaultStartupMechanism ()
    {
        return StartupMechanism.REDHAT_SYSV;
    }

    @Override
    protected String getBaseFolderName ()
    {
        return "rpm-packages"; //$NON-NLS-1$
    }

    @Override
    protected void handleProcess ( final IFolder nodeDir, final IProgressMonitor monitor, final Map<String, String> properties ) throws Exception
    {
        final File packageFolder = getPackageFolder ( nodeDir );

        final String packageName = getPackageName ();

        final RedhatDeploymentContext context = new RedhatDeploymentContext ( new File ( packageFolder, "src" ), packageName );
        setDeploymentContext ( context );

        // process super

        super.handleProcess ( nodeDir, monitor, properties );

        // handle self

        final File buildRoot = packageFolder.getParentFile ();
        final File specsDir = new File ( buildRoot, "SPECS" ); //$NON-NLS-1$
        specsDir.mkdirs ();
        final File sourcesDir = new File ( buildRoot, "SOURCES" ); //$NON-NLS-1$
        sourcesDir.mkdirs ();

        // create content

        final String version = makeVersion ( this.deploy.getChanges () );
        final String qualifier = makeRelease ();

        final Map<String, String> replacements = new HashMap<> ();
        replacements.put ( "packageName", packageName ); //$NON-NLS-1$
        replacements.put ( "authorName", this.deploy.getMaintainer ().getName () ); //$NON-NLS-1$
        replacements.put ( "authorEmail", this.deploy.getMaintainer ().getEmail () ); //$NON-NLS-1$
        replacements.put ( "nodeName", this.applicationNode.getName () == null ? this.applicationNode.getHostName () : this.applicationNode.getName () ); //$NON-NLS-1$
        replacements.put ( "version", version ); //$NON-NLS-1$
        replacements.put ( "qualifier", qualifier ); //$NON-NLS-1$
        replacements.put ( "changeLog", makeChangeLog ( this.deploy.getChanges () ) ); //$NON-NLS-1$
        replacements.put ( "start.apps", createStartApps () ); //$NON-NLS-1$
        replacements.put ( "stop.apps", createStopApps () ); //$NON-NLS-1$
        replacements.put ( "create.apps", makeCreate ( this.deploy ) ); //$NON-NLS-1$
        replacements.put ( "license", this.deploy.getLicense () ); //$NON-NLS-1$

        replacements.put ( "multiuserScreen", this.deploy.isMultiUserScreen () ? "1" : "0" );

        createDrivers ( nodeDir, monitor, packageFolder, replacements );
        createEquinox ( nodeDir.getLocation ().toFile (), packageFolder, replacements, monitor );

        // create spec file - all content must be known

        final ScriptMaker sm = new ScriptMaker ( getStartupHandler () );

        replacements.put ( "postinst.scripts", context.getPostInstallationString () + sm.makePostInst () );
        replacements.put ( "preinst.scripts", context.getPreInstallationString () + sm.makePreInst () );
        replacements.put ( "postrem.scripts", context.getPostRemovalString () + sm.makePostRem () );
        replacements.put ( "prerem.scripts", context.getPreRemovalString () + sm.makePreRem () );

        replacements.put ( "files", makeFiles ( context.getFiles (), context.getDirectories () ) ); //$NON-NLS-1$
        replacements.put ( "depends", makeDependencies ( context.getDependencies () ) );

        final File specFile = new File ( specsDir, packageName + ".spec" ); //$NON-NLS-1$
        Helper.createFile ( specFile, CommonHandler.class.getResourceAsStream ( "templates/rpm/template.spec" ), replacements, monitor );
        Helper.createFile ( new File ( packageFolder, "Makefile" ), CommonHandler.class.getResourceAsStream ( "templates/rpm/Makefile" ), replacements, monitor );

        // make source file
        if ( !Boolean.parseBoolean ( properties.get ( "skipRunDeployment" ) ) ) //$NON-NLS-1$
        {
            monitor.subTask ( "Running 'tar'" ); //$NON-NLS-1$

            {
                final File sourceFile = new File ( sourcesDir, packageName + "_" + version + "." + qualifier + ".tar.gz" );
                final ProcessBuilder processBuilder = new ProcessBuilder ( "tar", "czf", sourceFile.toString (), packageName );
                processBuilder.directory ( packageFolder.getParentFile () );
                final int rc = new ProcessRunner ( processBuilder ).run ();
                logger.info ( "rc = {}", rc ); //$NON-NLS-1$

                if ( rc != 0 )
                {
                    throw new IllegalStateException ( String.format ( "command '%s' failed: %s", processBuilder.command (), rc ) );
                }
            }

            // run rpmbuild

            monitor.subTask ( "Running 'rpmbuild'" ); //$NON-NLS-1$

            {
                final ProcessBuilder processBuilder = new ProcessBuilder ( "rpmbuild", "--define", "_topdir " + buildRoot.toString (), "-bb", specFile.toString () );
                processBuilder.directory ( packageFolder );

                final int rc = new ProcessRunner ( processBuilder ).run ();
                logger.info ( "rc = {}", rc ); //$NON-NLS-1$

                if ( rc != 0 )
                {
                    throw new IllegalStateException ( String.format ( "command '%s' failed: %s", processBuilder.command (), rc ) );
                }
            }
        }

        nodeDir.refreshLocal ( IResource.DEPTH_INFINITE, monitor );
    }

    private String makeDependencies ( final Set<String> additional )
    {
        final Set<String> dependencies = new HashSet<> ();

        dependencies.add ( "neoscada.common" );
        if ( needP2 () )
        {
            dependencies.add ( "org.eclipse.platform" ); //$NON-NLS-1$
            dependencies.add ( "emf-xsd-Update" ); //$NON-NLS-1$
            dependencies.add ( "equinox-sdk" ); //$NON-NLS-1$
            dependencies.add ( "gemini-dbaccess" ); //$NON-NLS-1$
            dependencies.add ( "neoscada.deploy.p2director" ); //$NON-NLS-1$
        }
        dependencies.add ( "neoscada.protocols.p2" );
        dependencies.addAll ( this.deploy.getAdditionalDependencies () );
        dependencies.addAll ( additional );

        final StartupHandler sh = getStartupHandler ();
        if ( sh != null )
        {
            dependencies.addAll ( sh.getAdditionalPackageDependencies () );
        }

        final Set<String> result = new HashSet<> ();

        for ( final String dep : dependencies )
        {
            result.add ( "Requires: " + dep );
        }

        return StringHelper.join ( result, "\n" );
    }

    private String makeFiles ( final Map<String, FileInformation> files, final Map<String, FileInformation> dirs )
    {
        final StringBuilder sb = new StringBuilder ();

        for ( final Map.Entry<String, FileInformation> de : dirs.entrySet () )
        {
            final FileInformation di = de.getValue ();

            final StringBuilder line = new StringBuilder ( "%dir " );
            writeMode ( line, de.getKey (), di );

            sb.append ( line ).append ( '\n' );
        }

        for ( final Map.Entry<String, FileInformation> fe : files.entrySet () )
        {
            final FileInformation fi = fe.getValue ();

            final StringBuilder line = new StringBuilder ();

            if ( fi != null )
            {
                for ( final FileOptions fo : fi.getOptions () )
                {
                    switch ( fo )
                    {
                        case CONFIGURATION:
                            line.append ( "%config " );
                            break;
                    }
                }
            }

            writeMode ( line, fe.getKey (), fi );

            sb.append ( line ).append ( '\n' );
        }

        return sb.toString ();
    }

    protected void writeMode ( final StringBuilder line, final String targetName, final FileInformation di )
    {
        if ( di != null )
        {
            if ( di.getMode () != null || di.getOwner () != null || di.getGroup () != null )
            {
                final String mode = di.getMode () == null ? "-" : String.format ( "%04o", di.getMode () );
                final String user = di.getOwner () == null ? "-" : di.getOwner ();
                final String group = di.getGroup () == null ? "-" : di.getGroup ();

                line.append ( String.format ( "%%attr(%s,%s,%s) ", mode, user, group ) );
            }
        }
        line.append ( targetName );
    }

    private String makeRelease ()
    {
        return String.format ( "%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new Date () ); //$NON-NLS-1$
    }

    private String makeChangeLog ( final List<ChangeEntry> changes )
    {
        final ArrayList<ChangeEntry> sortedChanges = new ArrayList<> ( changes );
        Collections.sort ( sortedChanges, new ChangeEntryComparator ( true ) );

        final StringBuilder sb = new StringBuilder ();

        for ( final ChangeEntry entry : sortedChanges )
        {
            final Formatter f = new Formatter ( sb, Locale.ENGLISH );
            f.format ( "* %3$ta %3$tb %3$td %3$tY %1$s <%2$s> %4$s", entry.getAuthor ().getName (), entry.getAuthor ().getEmail (), entry.getDate (), entry.getVersion () );
            f.close ();
            sb.append ( '\n' );
            sb.append ( entry.getDescription () );
            sb.append ( '\n' );
        }

        return sb.toString ();
    }

    private String makeVersion ( final List<ChangeEntry> changes )
    {
        String version = null;
        Date date = null;

        for ( final ChangeEntry entry : changes )
        {
            if ( date == null || date.before ( entry.getDate () ) )
            {
                date = entry.getDate ();
                version = entry.getVersion ();
            }
        }

        return version == null ? "0.0.0" : version; //$NON-NLS-1$
    }
}
