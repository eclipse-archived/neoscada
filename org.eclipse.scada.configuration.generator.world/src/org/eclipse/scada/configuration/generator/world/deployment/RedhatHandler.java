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
package org.eclipse.scada.configuration.generator.world.deployment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.eclipse.scada.configuration.generator.world.utils.Helper;
import org.eclipse.scada.configuration.generator.world.utils.ProcessRunner;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.deployment.ChangeEntry;
import org.eclipse.scada.configuration.world.deployment.RedhatDeploymentMechanism;
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
        return "rpm-packages";
    }

    @Override
    public void process ( final IFolder nodeDir, final IProgressMonitor monitor ) throws Exception
    {
        super.process ( nodeDir, monitor );

        final File packageFolder = getPackageFolder ( nodeDir );

        final String packageName = getPackageName ();

        final File buildRoot = packageFolder.getParentFile ();
        final File specsDir = new File ( buildRoot, "SPECS" );
        specsDir.mkdirs ();
        final File sourcesDir = new File ( buildRoot, "SOURCES" );
        sourcesDir.mkdirs ();

        // create content

        final String version = makeVersion ( this.deploy.getChanges () );
        final String qualifier = makeRelease ();

        final Map<String, String> replacements = new HashMap<> ();
        replacements.put ( "packageName", packageName );
        replacements.put ( "authorName", this.deploy.getMaintainer ().getName () );
        replacements.put ( "authorEmail", this.deploy.getMaintainer ().getEmail () );
        replacements.put ( "nodeName", this.applicationNode.getName () == null ? this.applicationNode.getHostName () : this.applicationNode.getName () );
        replacements.put ( "version", version );
        replacements.put ( "qualifier", qualifier );
        replacements.put ( "changeLog", makeChangeLog ( this.deploy.getChanges () ) );
        replacements.put ( "files", makeFiles () );
        replacements.put ( "depends", makeDependencies () );
        replacements.put ( "preun", makeStop () );
        replacements.put ( "post", makePost () );

        final File specFile = new File ( specsDir, packageName + ".spec" );
        Helper.createFile ( specFile, RedhatHandler.class.getResourceAsStream ( "templates/rpm/template.spec" ), replacements, monitor );
        Helper.createFile ( new File ( packageFolder, "Makefile" ), RedhatHandler.class.getResourceAsStream ( "templates/rpm/Makefile" ), replacements, monitor );

        createDrivers ( nodeDir, monitor, packageFolder, replacements );
        createEquinox ( nodeDir.getLocation ().toFile (), packageFolder, replacements, monitor );

        // make source file

        monitor.setTaskName ( "Running tar" );

        {
            final File sourceFile = new File ( sourcesDir, packageName + "_" + version + "." + qualifier + ".tar.gz" );
            final ProcessBuilder processBuilder = new ProcessBuilder ( "tar", "czf", sourceFile.toString (), packageName );
            processBuilder.directory ( packageFolder.getParentFile () );
            try
            {
                final int rc = new ProcessRunner ( processBuilder ).run ();
                logger.info ( "rc = {}", rc );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to generate tar package", e );
            }
        }

        // run rpmbuild

        monitor.setTaskName ( "Running rpmbuild" );

        {
            final ProcessBuilder processBuilder = new ProcessBuilder ( "rpmbuild", "--define", "_topdir " + buildRoot.toString (), "-bb", specFile.toString () );
            processBuilder.directory ( packageFolder );
            try
            {
                final int rc = new ProcessRunner ( processBuilder ).run ();
                logger.info ( "rc = {}", rc );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to generate rpm package", e );
            }
        }

        nodeDir.refreshLocal ( IResource.DEPTH_INFINITE, monitor );
    }

    private String makeStop ()
    {
        final StringBuilder sb = new StringBuilder ();
        for ( final String driver : makeDriverList () )
        {
            sb.append ( "test \"$1\" -eq \"0\" && /etc/init.d/scada.driver." + driver + " stop || true" );
            sb.append ( "\n" );
        }
        for ( final String driver : makeEquinoxList () )
        {
            sb.append ( "test \"$1\" -eq \"0\" && /etc/init.d/scada.app." + driver + " stop || true" );
            sb.append ( "\n" );
        }
        return sb.toString ();
    }

    private String makePost ()
    {
        final StringBuilder sb = new StringBuilder ();
        for ( final String driver : makeDriverList () )
        {
            sb.append ( "/etc/init.d/scada.driver." + driver + " condrestart || true" );
            sb.append ( "\n" );
        }
        for ( final String driver : makeEquinoxList () )
        {
            sb.append ( "/etc/init.d/scada.app." + driver + " condrestart || true" );
            sb.append ( "\n" );
        }
        return sb.toString ();
    }

    private static Pattern ALT_PATTERN = Pattern.compile ( "\\@\\@(.*?)\\@\\@" );

    @Override
    protected void processDriver ( final IProgressMonitor monitor, final File packageFolder, final Map<String, String> replacements, final String driverName, final File sourceDir, final File driverDir ) throws IOException, Exception
    {
        super.processDriver ( monitor, packageFolder, replacements, driverName, sourceDir, driverDir );
        File initFile;
        Helper.createFile ( initFile = new File ( packageFolder, "src/etc/init.d/scada.driver." + driverName ), RedhatHandler.class.getResourceAsStream ( "templates/rpm/driver.service.sh" ), replacements, monitor );
        initFile.setExecutable ( true );
    }

    @Override
    protected void processEquinox ( final File sourceBase, final File packageFolder, final Map<String, String> replacements, final IProgressMonitor monitor, final String name ) throws IOException, Exception, FileNotFoundException
    {
        super.processEquinox ( sourceBase, packageFolder, replacements, monitor, name );
        {
            final File file = new File ( packageFolder, "src/etc/init.d/scada.app." + name );
            Helper.createFile ( file, RedhatHandler.class.getResourceAsStream ( "templates/rpm/p2.service.sh" ), replacements, monitor );
            file.setExecutable ( true );
        }
        {
            final File file = new File ( packageFolder, "src/usr/bin/scada.app." + name + ".launcher" );
            Helper.createFile ( file, RedhatHandler.class.getResourceAsStream ( "templates/rpm/p2.launcher.sh" ), replacements, monitor, ALT_PATTERN );
            file.setExecutable ( true );
        }
    }

    private String makeDependencies ()
    {
        final Set<String> result = new HashSet<> ();

        result.add ( "Requires: org.eclipse.scada" );

        if ( needP2 () )
        {
            result.add ( "Requires: org.eclipse.scada.p2" );
        }

        return StringHelper.join ( result, "\n" );
    }

    private String makeFiles ()
    {
        final StringBuilder sb = new StringBuilder ();

        for ( final String driver : makeDriverList () )
        {
            sb.append ( "%dir %_sysconfdir/eclipsescada/drivers/" + driver );
            sb.append ( '\n' );
            sb.append ( "%attr(640,root,eclipsescada) %_sysconfdir/eclipsescada/drivers/" + driver + "/*" );
            sb.append ( '\n' );
            sb.append ( "%attr(755,root,root) /etc/init.d/scada.driver." + driver );
            sb.append ( '\n' );
        }

        for ( final String app : makeEquinoxList () )
        {
            sb.append ( "%attr(755,root,root) /etc/init.d/scada.app." + app );
            sb.append ( '\n' );
            sb.append ( "%attr(755,root,root) %_bindir/scada.create." + app );
            sb.append ( '\n' );
            sb.append ( "%attr(755,root,root) %_bindir/scada.app." + app + ".launcher" );
            sb.append ( '\n' );
            sb.append ( "%attr(640,root,eclipsescada) /usr/share/eclipsescada/ca.bootstrap/bootstrap." + app + ".json" );
            sb.append ( '\n' );
            sb.append ( "%attr(640,root,eclipsescada) /usr/share/eclipsescada/profiles/" + app + ".profile.xml" );
            sb.append ( '\n' );
            sb.append ( "%dir /usr/share/eclipsescada/profiles/" + app );
            sb.append ( '\n' );
            sb.append ( "%attr(640,root,eclipsescada) /usr/share/eclipsescada/profiles/" + app + "/*" );
            sb.append ( '\n' );
        }

        return sb.toString ();
    }

    private String makeRelease ()
    {
        return String.format ( "%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new Date () );
    }

    private String makeChangeLog ( final List<ChangeEntry> changes )
    {
        final StringBuilder sb = new StringBuilder ();

        for ( final ChangeEntry entry : changes )
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

        return version == null ? "0.0.0" : version;
    }
}
