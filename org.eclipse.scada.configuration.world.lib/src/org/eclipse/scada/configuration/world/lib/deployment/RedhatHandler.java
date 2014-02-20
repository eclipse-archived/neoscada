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
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.deployment.ChangeEntry;
import org.eclipse.scada.configuration.world.deployment.RedhatDeploymentMechanism;
import org.eclipse.scada.configuration.world.lib.utils.Helper;
import org.eclipse.scada.configuration.world.lib.utils.ProcessRunner;
import org.eclipse.scada.utils.str.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedhatHandler extends CommonHandler
{

    private final static Logger logger = LoggerFactory.getLogger ( RedhatHandler.class );

    private final RedhatDeploymentMechanism deploy;

    public RedhatHandler ( final ApplicationNode applicationNode, final RedhatDeploymentMechanism deploy )
    {
        super ( applicationNode );
        this.deploy = deploy;
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
        replacements.put ( "files", makeFiles () ); //$NON-NLS-1$
        replacements.put ( "depends", makeDependencies () );
        replacements.put ( "preun", makeStop () ); //$NON-NLS-1$
        replacements.put ( "post", makePost () ); //$NON-NLS-1$

        final File specFile = new File ( specsDir, packageName + ".spec" ); //$NON-NLS-1$
        Helper.createFile ( specFile, RedhatHandler.class.getResourceAsStream ( "templates/rpm/template.spec" ), replacements, monitor );
        Helper.createFile ( new File ( packageFolder, "Makefile" ), RedhatHandler.class.getResourceAsStream ( "templates/rpm/Makefile" ), replacements, monitor );

        createDrivers ( nodeDir, monitor, packageFolder, replacements );
        createEquinox ( nodeDir.getLocation ().toFile (), packageFolder, replacements, monitor );

        // make source file

        monitor.setTaskName ( "Running tar" ); //$NON-NLS-1$

        {
            final File sourceFile = new File ( sourcesDir, packageName + "_" + version + "." + qualifier + ".tar.gz" );
            final ProcessBuilder processBuilder = new ProcessBuilder ( "tar", "czf", sourceFile.toString (), packageName );
            processBuilder.directory ( packageFolder.getParentFile () );
            try
            {
                final int rc = new ProcessRunner ( processBuilder ).run ();
                logger.info ( "rc = {}", rc ); //$NON-NLS-1$
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to generate tar package", e ); //$NON-NLS-1$
            }
        }

        // run rpmbuild

        if ( !Boolean.parseBoolean ( properties.get ( "skipRunDeployment" ) ) ) //$NON-NLS-1$
        {
            monitor.setTaskName ( "Running rpmbuild" ); //$NON-NLS-1$

            {
                final ProcessBuilder processBuilder = new ProcessBuilder ( "rpmbuild", "--define", "_topdir " + buildRoot.toString (), "-bb", specFile.toString () );
                processBuilder.directory ( packageFolder );
                try
                {
                    final int rc = new ProcessRunner ( processBuilder ).run ();
                    logger.info ( "rc = {}", rc ); //$NON-NLS-1$
                }
                catch ( final Exception e )
                {
                    logger.warn ( "Failed to generate rpm package", e ); //$NON-NLS-1$
                }
            }

            nodeDir.refreshLocal ( IResource.DEPTH_INFINITE, monitor );
        }
    }

    private String makeStop ()
    {
        final StringBuilder sb = new StringBuilder ();
        for ( final String driver : makeDriverList () )
        {
            sb.append ( "test \"$1\" -eq \"0\" && /etc/init.d/scada.driver." + driver + " stop || true" );
            sb.append ( "\n" ); //$NON-NLS-1$
        }
        for ( final String driver : makeEquinoxList () )
        {
            sb.append ( "test \"$1\" -eq \"0\" && /etc/init.d/scada.app." + driver + " stop || true" );
            sb.append ( "\n" ); //$NON-NLS-1$
        }
        return sb.toString ();
    }

    private String makePost ()
    {
        final StringBuilder sb = new StringBuilder ();
        for ( final String driver : makeDriverList () )
        {
            sb.append ( "/etc/init.d/scada.driver." + driver + " condrestart || true" );
            sb.append ( "\n" ); //$NON-NLS-1$
        }
        for ( final String driver : makeEquinoxList () )
        {
            sb.append ( "/etc/init.d/scada.app." + driver + " condrestart || true" );
            sb.append ( "\n" ); //$NON-NLS-1$
        }
        return sb.toString ();
    }

    private static Pattern ALT_PATTERN = Pattern.compile ( "\\@\\@(.*?)\\@\\@" ); //$NON-NLS-1$

    @Override
    protected void processDriver ( final IProgressMonitor monitor, final File packageFolder, final Map<String, String> replacements, final String driverName, final File sourceDir, final File driverDir ) throws IOException, Exception
    {
        super.processDriver ( monitor, packageFolder, replacements, driverName, sourceDir, driverDir );
        File initFile;
        Helper.createFile ( initFile = new File ( packageFolder, "src/etc/init.d/scada.driver." + driverName ), RedhatHandler.class.getResourceAsStream ( "templates/rpm/driver.service.sh" ), replacements, monitor ); //$NON-NLS-1$
        initFile.setExecutable ( true );
    }

    @Override
    protected void processEquinox ( final File sourceBase, final File packageFolder, final Map<String, String> replacements, final IProgressMonitor monitor, final String name ) throws IOException, Exception, FileNotFoundException
    {
        super.processEquinox ( sourceBase, packageFolder, replacements, monitor, name );
        {
            final File file = new File ( packageFolder, "src/etc/init.d/scada.app." + name ); //$NON-NLS-1$
            Helper.createFile ( file, RedhatHandler.class.getResourceAsStream ( "templates/rpm/p2.service.sh" ), replacements, monitor ); //$NON-NLS-1$
            file.setExecutable ( true );
        }
        {
            final File file = new File ( packageFolder, "src/usr/bin/scada.app." + name + ".launcher" ); //$NON-NLS-1$  //$NON-NLS-2$
            Helper.createFile ( file, RedhatHandler.class.getResourceAsStream ( "templates/rpm/p2.launcher.sh" ), replacements, monitor, ALT_PATTERN ); //$NON-NLS-1$
            file.setExecutable ( true );
        }
    }

    private String makeDependencies ()
    {
        final Set<String> result = new HashSet<> ();

        result.add ( "Requires: org.eclipse.scada" ); //$NON-NLS-1$

        if ( needP2 () )
        {
            result.add ( "Requires: org.eclipse.scada.p2" ); //$NON-NLS-1$
        }

        result.add ( "Requires: org.eclipse.scada.deploy.p2-incubation" ); //$NON-NLS-1$

        for ( final String dep : this.deploy.getAdditionalDependencies () )
        {
            result.add ( "Requires: " + dep );
        }

        return StringHelper.join ( result, "\n" );
    }

    private String makeFiles ()
    {
        final StringBuilder sb = new StringBuilder ();

        for ( final String driver : makeDriverList () )
        {
            sb.append ( "%dir %_sysconfdir/eclipsescada/drivers/" + driver ); //$NON-NLS-1$
            sb.append ( '\n' );
            sb.append ( "%attr(640,root,eclipsescada) %_sysconfdir/eclipsescada/drivers/" + driver + "/*" ); //$NON-NLS-1$
            sb.append ( '\n' );
            sb.append ( "%attr(755,root,root) /etc/init.d/scada.driver." + driver ); //$NON-NLS-1$
            sb.append ( '\n' );
        }

        for ( final String app : makeEquinoxList () )
        {
            sb.append ( "%attr(755,root,root) /etc/init.d/scada.app." + app ); //$NON-NLS-1$
            sb.append ( '\n' );
            sb.append ( "%attr(755,root,root) %_bindir/scada.create." + app ); //$NON-NLS-1$
            sb.append ( '\n' );
            sb.append ( "%attr(755,root,root) %_bindir/scada.app." + app + ".launcher" ); //$NON-NLS-1$
            sb.append ( '\n' );
            sb.append ( "%attr(640,root,eclipsescada) /usr/share/eclipsescada/ca.bootstrap/bootstrap." + app + ".json" ); //$NON-NLS-1$
            sb.append ( '\n' );
            sb.append ( "%attr(640,root,eclipsescada) /usr/share/eclipsescada/profiles/" + app + ".profile.xml" ); //$NON-NLS-1$
            sb.append ( '\n' );
            sb.append ( "%dir /usr/share/eclipsescada/profiles/" + app ); //$NON-NLS-1$
            sb.append ( '\n' );
            sb.append ( "%attr(640,root,eclipsescada) /usr/share/eclipsescada/profiles/" + app + "/*" ); //$NON-NLS-1$
            sb.append ( '\n' );
        }

        return sb.toString ();
    }

    private String makeRelease ()
    {
        return String.format ( "%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new Date () ); //$NON-NLS-1$
    }

    private String makeChangeLog ( final List<ChangeEntry> changes )
    {
        final ArrayList<ChangeEntry> sortedChanges = new ArrayList<> ( changes );
        Collections.sort ( sortedChanges, new ChangeEntryComparator ( false ) );

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
