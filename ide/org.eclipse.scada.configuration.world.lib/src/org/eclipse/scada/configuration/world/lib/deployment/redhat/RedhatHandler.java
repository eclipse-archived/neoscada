/*******************************************************************************
 * Copyright (c) 2013, 2016 IBH SYSTEMS GmbH and others.
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
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
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
import java.util.TreeMap;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.packagedrone.utils.rpm.build.BuilderContext;
import org.eclipse.packagedrone.utils.rpm.build.RpmBuilder;
import org.eclipse.packagedrone.utils.rpm.build.RpmBuilder.PackageInformation;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.deployment.ChangeEntry;
import org.eclipse.scada.configuration.world.deployment.RedhatDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.StartupMechanism;
import org.eclipse.scada.configuration.world.lib.deployment.ChangeEntryComparator;
import org.eclipse.scada.configuration.world.lib.deployment.CommonPackageHandler;
import org.eclipse.scada.configuration.world.lib.deployment.FileInformation;
import org.eclipse.scada.configuration.world.lib.deployment.FileOptions;
import org.eclipse.scada.configuration.world.lib.deployment.ScriptMaker;
import org.eclipse.scada.configuration.world.lib.deployment.startup.StartupHandler;
import org.eclipse.scada.configuration.world.lib.utils.Constants;

public class RedhatHandler extends CommonPackageHandler
{
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

        final File tempDir = new File ( packageFolder, "src" );
        final RedhatDeploymentContext context = new RedhatDeploymentContext ( tempDir, packageName );
        setDeploymentContext ( context );

        // process super

        super.handleProcess ( nodeDir, monitor, properties );

        // handle self

        final Path outputDir = nodeDir.getLocation ().toFile ().toPath ();
        Files.createDirectories ( outputDir );

        final String version = makeVersion ( this.deploy.getChanges () );
        final String qualifier = makeRelease ();
        final String nodeName = this.applicationNode.getName () == null ? this.applicationNode.getHostName () : this.applicationNode.getName ();

        try ( RpmBuilder builder = new RpmBuilder ( packageName, version, qualifier, outputDir ) )
        {
            final PackageInformation pinfo = builder.getInformation ();
            pinfo.setLicense ( this.deploy.getLicense () );
            pinfo.setSummary ( String.format ( "Eclipse NeoSCADA Configuration for \"%s\"", nodeName ) );
            pinfo.setDescription ( String.format ( "This is the configuration package for node \"%s\".", nodeName ) );
            pinfo.setPackager ( String.format ( "%s <%s>", this.deploy.getMaintainer ().getName (), this.deploy.getMaintainer ().getEmail () ) );
            pinfo.setGroup ( "Application/System" );

            // create content

            final Map<String, String> replacements = new HashMap<> ();
            replacements.put ( "packageName", packageName ); //$NON-NLS-1$
            replacements.put ( "authorName", this.deploy.getMaintainer ().getName () ); //$NON-NLS-1$
            replacements.put ( "authorEmail", this.deploy.getMaintainer ().getEmail () ); //$NON-NLS-1$
            replacements.put ( "nodeName", nodeName ); //$NON-NLS-1$
            replacements.put ( "version", version ); //$NON-NLS-1$
            replacements.put ( "qualifier", qualifier ); //$NON-NLS-1$
            replacements.put ( "changeLog", makeChangeLog ( this.deploy.getChanges () ) ); //$NON-NLS-1$

            createDrivers ( nodeDir, monitor, packageFolder, replacements );
            createEquinox ( nodeDir.getLocation ().toFile (), packageFolder, replacements, monitor );

            // create spec file - all content must be known

            final ScriptMaker sm = new ScriptMaker ( getStartupHandler () );

            builder.setPreInstallationScript ( createStopApps () + context.getPreInstallationString () + sm.makePreInst () );
            builder.setPostInstallationScript ( context.getPostInstallationString () + sm.makePostInst () + makeMultiScreenScript () + makeCreate ( this.deploy ) + createStartApps () );
            builder.setPreRemoveScript ( createStopApps () + context.getPreRemovalString () + sm.makePreRem () );
            builder.setPostRemoveScript ( context.getPostRemovalString () + sm.makePostRem () );

            for ( final String dep : makeDependencies ( context.getDependencies () ) )
            {
                builder.addRequirement ( dep, null );
            }

            final BuilderContext ctx = builder.newContext ();

            for ( final Map.Entry<String, FileInformation> dir : new TreeMap<> ( context.getDirectories () ).entrySet () /* Sorted */ )
            {
                ctx.addDirectory ( dir.getKey (), BuilderContext.simpleDirectoryProvider ().customize ( fi -> applyFileInformation ( fi, dir.getValue (), true ) ) );
            }

            final Path base = tempDir.toPath ();
            Files.walkFileTree ( base, new SimpleFileVisitor<Path> () {
                @Override
                public FileVisitResult visitFile ( final Path file, final BasicFileAttributes attrs ) throws IOException
                {
                    final Path localPath = Paths.get ( "/" ).resolve ( base.relativize ( file ) ).normalize ();
                    final String targetName = localPath.toString ().replace ( File.separator, "/" );
                    final FileInformation i = context.getFiles ().get ( targetName );
                    ctx.addFile ( targetName, file, BuilderContext.simpleFileProvider ().customize ( fi -> applyFileInformation ( fi, i, true ) ) );
                    return FileVisitResult.CONTINUE;
                }
            } );

            builder.build ();
        }

        nodeDir.refreshLocal ( IResource.DEPTH_INFINITE, monitor );
    }

    private static void applyFileInformation ( final org.eclipse.packagedrone.utils.rpm.build.FileInformation fi, final FileInformation i, final boolean directory )
    {
        if ( i == null )
        {
            return;
        }

        if ( i.getMode () != null )
        {
            fi.setMode ( i.getMode ().shortValue () );
        }
        if ( i.getOwner () == null )
        {
            fi.setUser ( i.getOwner () );
        }
        if ( i.getGroup () != null )
        {
            fi.setGroup ( i.getGroup () );
        }
        if ( !directory && i.getOptions () != null )
        {
            for ( final FileOptions opt : i.getOptions () )
            {
                switch ( opt )
                {
                    case CONFIGURATION:
                        fi.setConfiguration ( true );
                        break;
                }
            }
        }
    }

    private String makeMultiScreenScript ()
    {
        if ( this.deploy.isMultiUserScreen () )
        {
            return "test -f ~" + Constants.NEOSCADA_USER + "/.screenrc && echo \"multiuser on\nacladd root\" > ~" + Constants.NEOSCADA_USER + "/.screenrc";
        }
        else
        {
            return "";
        }
    }

    private Set<String> makeDependencies ( final Set<String> additional )
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

        return dependencies;
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
