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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.deployment.ChangeEntry;
import org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.StartupMechanism;
import org.eclipse.scada.configuration.world.lib.utils.Helper;
import org.eclipse.scada.configuration.world.lib.utils.ProcessRunner;
import org.eclipse.scada.utils.str.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DebianHandler extends CommonPackageHandler
{

    private final static Logger logger = LoggerFactory.getLogger ( DebianHandler.class );

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

        final Map<String, String> replacements = new HashMap<> ();
        replacements.put ( "packageName", packageName ); //$NON-NLS-1$
        replacements.put ( "authorName", this.deploy.getMaintainer ().getName () ); //$NON-NLS-1$
        replacements.put ( "authorEmail", this.deploy.getMaintainer ().getEmail () ); //$NON-NLS-1$
        replacements.put ( "nodeName", this.applicationNode.getName () == null ? this.applicationNode.getHostName () : this.applicationNode.getName () ); //$NON-NLS-1$
        replacements.put ( "postinst.restart", createPostInst ( makeDriverList () ) ); //$NON-NLS-1$
        replacements.put ( "prerm.stop", createPreRm ( makeDriverList () ) ); //$NON-NLS-1$
        replacements.put ( "depends", makeDependencies () ); //$NON-NLS-1$

        replacements.put ( "postinst.scripts", createScriptFile ( packageFolder, "postinst" ) );
        replacements.put ( "prerm.scripts", createScriptFile ( packageFolder, "prerm" ) );
        replacements.put ( "postrm.scripts", createScriptFile ( packageFolder, "postrm" ) );

        Helper.createFile ( new File ( packageFolder, "debian/source/format" ), "3.0 (native)", monitor );
        Helper.createFile ( new File ( packageFolder, "debian/compat" ), "8", monitor );
        Helper.createFile ( new File ( packageFolder, "debian/docs" ), "", monitor );
        Helper.createFile ( new File ( packageFolder, "debian/" + packageName + ".install" ), "src/* /", monitor );
        Helper.createFile ( new File ( packageFolder, "debian/postinst" ), DebianHandler.class.getResourceAsStream ( "templates/deb/postinst" ), replacements, monitor );
        Helper.createFile ( new File ( packageFolder, "debian/prerm" ), DebianHandler.class.getResourceAsStream ( "templates/deb/prerm" ), replacements, monitor );
        Helper.createFile ( new File ( packageFolder, "debian/postrm" ), DebianHandler.class.getResourceAsStream ( "templates/deb/postrm" ), replacements, monitor );
        Helper.createFile ( new File ( packageFolder, "debian/rules" ), DebianHandler.class.getResourceAsStream ( "templates/deb/rules" ), monitor, true );
        Helper.createFile ( new File ( packageFolder, "debian/control" ), DebianHandler.class.getResourceAsStream ( "templates/deb/control" ), replacements, monitor );
        Helper.createFile ( new File ( packageFolder, "debian/changelog" ), createChangeLog ( packageName, this.deploy.getChanges () ), monitor );

        createDrivers ( nodeDir, monitor, packageFolder, replacements );
        createEquinox ( nodeDir.getLocation ().toFile (), packageFolder, replacements, monitor );

        // run debuild

        if ( !Boolean.parseBoolean ( properties.get ( "skipRunDeployment" ) ) ) //$NON-NLS-1$
        {

            monitor.setTaskName ( "Running \"debuild -us -uc\"" ); //$NON-NLS-1$

            final ProcessBuilder processBuilder = new ProcessBuilder ( Arrays.asList ( "debuild", "-us", "-uc" ) );
            processBuilder.directory ( packageFolder );
            try
            {
                new ProcessRunner ( processBuilder ).run ();
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to generate debian package", e ); //$NON-NLS-1$
            }

            nodeDir.refreshLocal ( IResource.DEPTH_INFINITE, monitor );
        }
    }

    private String createScriptFile ( final File packageFolder, final String type )
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

        return StringHelper.join ( result, ", " ); //$NON-NLS-1$
    }

    private String createPostInst ( final Set<String> driverName )
    {
        final StringBuilder sb = new StringBuilder ();

        for ( final String driver : driverName )
        {
            sb.append ( String.format ( "    restart scada.driver.%1$s || echo failed to restart %1$s", driver ) );
            sb.append ( "\n" );
        }

        return sb.toString ();
    }

    private String createPreRm ( final Set<String> driverName )
    {
        final StringBuilder sb = new StringBuilder ();

        for ( final String driver : driverName )
        {
            sb.append ( String.format ( "    stop scada.driver.%1$s || echo failed to restart %1$s", driver ) );
            sb.append ( "\n" );
        }

        return sb.toString ();
    }

    private String createChangeLog ( final String packageName, final List<ChangeEntry> changes )
    {
        final StringBuilder sb = new StringBuilder ();

        final ArrayList<ChangeEntry> sortedChanges = new ArrayList<> ( changes );
        Collections.sort ( sortedChanges, new ChangeEntryComparator ( true ) );

        for ( final ChangeEntry entry : sortedChanges )
        {
            sb.append ( String.format ( "%s (%s) stable; urgency=low\n", packageName, entry.getVersion () ) );
            sb.append ( '\n' );
            sb.append ( entry.getDescription () );
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
}
