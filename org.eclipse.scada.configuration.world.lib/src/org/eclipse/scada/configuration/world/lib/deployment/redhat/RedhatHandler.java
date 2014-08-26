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
import org.eclipse.scada.configuration.world.lib.deployment.BinaryPackageBuilderWrapper;
import org.eclipse.scada.configuration.world.lib.deployment.ChangeEntryComparator;
import org.eclipse.scada.configuration.world.lib.deployment.CommonHandler;
import org.eclipse.scada.configuration.world.lib.deployment.CommonPackageHandler;
import org.eclipse.scada.configuration.world.lib.deployment.ResourceInformation;
import org.eclipse.scada.configuration.world.lib.deployment.startup.StartupHandler;
import org.eclipse.scada.configuration.world.lib.utils.Helper;
import org.eclipse.scada.configuration.world.lib.utils.ProcessRunner;
import org.eclipse.scada.utils.str.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedhatHandler extends CommonPackageHandler
{

    private final static Logger logger = LoggerFactory.getLogger ( RedhatHandler.class );

    private final RedhatDeploymentMechanism deploy;

    public RedhatHandler ( final ApplicationNode applicationNode, final RedhatDeploymentMechanism deploy )
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
        replacements.put ( "stop.apps", makeStop () ); //$NON-NLS-1$
        replacements.put ( "start.apps", makeStart () ); //$NON-NLS-1$
        replacements.put ( "create.apps", makeCreate ( this.deploy ) ); //$NON-NLS-1$
        replacements.put ( "license", this.deploy.getLicense () ); //$NON-NLS-1$

        replacements.put ( "multiuserScreen", this.deploy.isMultiUserScreen () ? "1" : "0" );

        final File specFile = new File ( specsDir, packageName + ".spec" ); //$NON-NLS-1$
        Helper.createFile ( specFile, CommonHandler.class.getResourceAsStream ( "templates/rpm/template.spec" ), replacements, monitor );
        Helper.createFile ( new File ( packageFolder, "Makefile" ), CommonHandler.class.getResourceAsStream ( "templates/rpm/Makefile" ), replacements, monitor );

        if ( !makeEquinoxList ().isEmpty () )
        {
            Helper.createFile ( new File ( packageFolder, "src/etc/eclipsescada/applications" ), StringHelper.join ( makeEquinoxList (), "\n" ) + "\n", monitor );
        }

        final BinaryPackageBuilderWrapper builder = new BinaryPackageBuilderWrapper ( new File ( packageFolder, "src" ) );

        createDrivers ( builder, nodeDir, monitor, packageFolder, replacements );
        createEquinox ( builder, nodeDir.getLocation ().toFile (), packageFolder, replacements, monitor );

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
        final StartupHandler sh = getStartupHandler ();
        if ( sh == null )
        {
            return "";
        }

        final StringBuilder sb = new StringBuilder ();
        for ( final String driver : makeDriverList () )
        {
            sb.append ( "test \"$1\" -eq \"0\" && " + sh.stopDriverCommand ( driver ) + " || true" );
            sb.append ( "\n" ); //$NON-NLS-1$
        }
        if ( this.deploy.isAutomaticCreate () )
        {
            for ( final String app : makeEquinoxList () )
            {
                sb.append ( "test \"$1\" -eq \"0\" && " + sh.stopEquinoxCommand ( app ) + " || true" );
                sb.append ( "\n" ); //$NON-NLS-1$
            }
        }
        return sb.toString ();
    }

    private String makeStart ()
    {
        final StartupHandler sh = getStartupHandler ();
        if ( sh == null )
        {
            return "";
        }

        final StringBuilder sb = new StringBuilder ();
        for ( final String driver : makeDriverList () )
        {
            sb.append ( sh.startDriverCommand ( driver ) + " || true" );
            sb.append ( "\n" ); //$NON-NLS-1$
        }
        if ( this.deploy.isAutomaticCreate () )
        {
            for ( final String app : makeEquinoxList () )
            {
                sb.append ( sh.startEquinoxCommand ( app ) + " || true" );
                sb.append ( "\n" ); //$NON-NLS-1$
            }
        }
        return sb.toString ();
    }

    private String makeDependencies ()
    {
        final Set<String> dependencies = new HashSet<> ();

        dependencies.add ( "org.eclipse.scada" );
        if ( needP2 () )
        {
            dependencies.add ( "org.eclipse.scada.p2" ); //$NON-NLS-1$
        }
        dependencies.add ( "org.eclipse.scada.deploy.p2-incubation" );
        dependencies.addAll ( this.deploy.getAdditionalDependencies () );

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

    private String makeFiles ()
    {
        final StartupHandler sh = getStartupHandler ();

        final StringBuilder sb = new StringBuilder ();

        for ( final String driver : makeDriverList () )
        {
            sb.append ( "%dir %_sysconfdir/eclipsescada/drivers/" + driver ); //$NON-NLS-1$
            sb.append ( '\n' );
            sb.append ( "%attr(640,root,eclipsescada) %_sysconfdir/eclipsescada/drivers/" + driver + "/*" ); //$NON-NLS-1$
            sb.append ( '\n' );

            if ( sh != null )
            {
                addFiles ( sb, sh.getDriverFiles ( driver ) );
            }
        }

        for ( final String app : makeEquinoxList () )
        {
            sb.append ( "%attr(755,root,root) %_bindir/scada.create." + app ); //$NON-NLS-1$
            sb.append ( '\n' );
            sb.append ( "%attr(640,root,eclipsescada) /usr/share/eclipsescada/ca.bootstrap/bootstrap." + app + ".json" ); //$NON-NLS-1$
            sb.append ( '\n' );
            sb.append ( "%attr(640,root,eclipsescada) /usr/share/eclipsescada/profiles/" + app + ".profile.xml" ); //$NON-NLS-1$
            sb.append ( '\n' );
            sb.append ( "%dir /usr/share/eclipsescada/profiles/" + app ); //$NON-NLS-1$
            sb.append ( '\n' );
            sb.append ( "%attr(640,root,eclipsescada) /usr/share/eclipsescada/profiles/" + app + "/*" ); //$NON-NLS-1$
            sb.append ( '\n' );

            if ( sh != null )
            {
                addFiles ( sb, sh.getEquinoxFiles ( app ) );
            }
        }

        return sb.toString ();
    }

    private void addFiles ( final StringBuilder sb, final Set<ResourceInformation> files )
    {
        for ( final ResourceInformation ri : files )
        {
            switch ( ri.getType () )
            {
                case EXECUTABLE:
                    sb.append ( "%attr(755,root,root) " );
                    break;
                case FILE:
                    sb.append ( "%attr(640,root,eclipsescada) " );
                    break;
                default:
                    continue; // ignore resource
            }
            sb.append ( ri.getTargetFilename () );
            sb.append ( '\n' );
        }
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
