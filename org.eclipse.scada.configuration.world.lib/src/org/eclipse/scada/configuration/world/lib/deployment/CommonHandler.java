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
package org.eclipse.scada.configuration.world.lib.deployment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.world.Application;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.CommonDriver;
import org.eclipse.scada.configuration.world.lib.NodeElementProcessor;
import org.eclipse.scada.configuration.world.lib.WorldRunner;
import org.eclipse.scada.configuration.world.lib.utils.CopyRecursive;
import org.eclipse.scada.configuration.world.lib.utils.Helper;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;
import org.eclipse.scada.configuration.world.osgi.profile.ProfileFactory;
import org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage;
import org.eclipse.scada.configuration.world.osgi.profile.SystemProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CommonHandler implements NodeElementProcessor
{

    private final static Logger logger = LoggerFactory.getLogger ( CommonHandler.class );

    protected final ApplicationNode applicationNode;

    public CommonHandler ( final ApplicationNode applicationNode )
    {
        this.applicationNode = applicationNode;
    }

    @Override
    public void process ( final IFolder nodeDir, final IProgressMonitor monitor ) throws Exception
    {
        getPackageFolder ( nodeDir );
    }

    protected abstract String getBaseFolderName ();

    public String getPackageName ()
    {
        return WorldRunner.makeName ( this.applicationNode ) + "-configuration";
    }

    protected File getPackageFolder ( final IFolder nodeDir )
    {
        final File folder = nodeDir.getFolder ( getBaseFolderName () ).getLocation ().toFile ();
        logger.debug ( "Output folder: {}", folder );

        final String packageName = getPackageName ();

        final File packageFolder = new File ( folder, packageName );
        return packageFolder;
    }

    protected void createDrivers ( final IFolder nodeDir, final IProgressMonitor monitor, final File packageFolder, final Map<String, String> replacements ) throws IOException, Exception
    {
        for ( final String driverName : makeDriverList () )
        {
            createDriver ( nodeDir, monitor, packageFolder, replacements, driverName );
        }
    }

    protected void createDriver ( final IFolder nodeDir, final IProgressMonitor monitor, final File packageFolder, final Map<String, String> replacements, final String driverName ) throws IOException, Exception
    {
        final File sourceDir = new File ( nodeDir.getLocation ().toFile (), driverName );
        final File driverDir = new File ( packageFolder, "src/etc/eclipsescada/drivers/" + driverName );

        replacements.put ( "driverName", driverName );

        processDriver ( monitor, packageFolder, replacements, driverName, sourceDir, driverDir );

        replacements.remove ( "driverName" );
    }

    protected void processDriver ( final IProgressMonitor monitor, final File packageFolder, final Map<String, String> replacements, final String driverName, final File sourceDir, final File driverDir ) throws IOException, Exception
    {
        driverDir.getParentFile ().mkdirs ();

        final CopyRecursive rec = new CopyRecursive ( sourceDir.toPath (), driverDir.toPath () );

        java.nio.file.Files.walkFileTree ( sourceDir.toPath (), rec );

        Helper.createFile ( new File ( packageFolder, "src/etc/eclipsescada/drivers/" + driverName + "/logback.xml" ), DebianHandler.class.getResourceAsStream ( "templates/driver.logback.xml" ), replacements, monitor );
        Helper.createFile ( new File ( packageFolder, "src/etc/eclipsescada/drivers/" + driverName + "/jvm.args" ), DebianHandler.class.getResourceAsStream ( "templates/jvm.args" ), replacements, monitor );
    }

    protected Set<String> makeDriverList ()
    {
        final Set<String> result = new HashSet<> ();
        for ( final Application app : this.applicationNode.getApplications () )
        {
            if ( app instanceof CommonDriver )
            {
                result.add ( app.getName () );
            }
        }
        return result;
    }

    protected Set<String> makeEquinoxList ()
    {
        final Set<String> result = new HashSet<> ();
        for ( final Application app : this.applicationNode.getApplications () )
        {
            if ( app instanceof EquinoxApplication )
            {
                result.add ( app.getName () );
            }
        }
        return result;
    }

    protected boolean needP2 ()
    {
        for ( final Application app : this.applicationNode.getApplications () )
        {
            if ( app instanceof EquinoxApplication )
            {
                return true;
            }
        }
        return false;
    }

    protected void createEquinox ( final File sourceBase, final File packageFolder, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        for ( final String name : makeEquinoxList () )
        {
            replacements.put ( "appName", name );

            processEquinox ( sourceBase, packageFolder, replacements, monitor, name );

            replacements.remove ( "appName" );
        }
    }

    protected void processEquinox ( final File sourceBase, final File packageFolder, final Map<String, String> replacements, final IProgressMonitor monitor, final String name ) throws IOException, Exception, FileNotFoundException
    {
        final File source = new File ( sourceBase, name + "/" + name + ".profile.xml" );
        final File target = new File ( packageFolder, "src/usr/share/eclipsescada/profiles/" + name + ".profile.xml" );
        target.getParentFile ().mkdirs ();

        java.nio.file.Files.copy ( source.toPath (), target.toPath (), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES );

        Helper.createFile ( new File ( packageFolder, "src/usr/share/eclipsescada/profiles/" + name + "/logback.xml" ), DebianHandler.class.getResourceAsStream ( "templates/app.logback.xml" ), replacements, monitor );

        final File createFile = new File ( packageFolder, "src/usr/bin/scada.create." + name );
        Helper.createFile ( createFile, DebianHandler.class.getResourceAsStream ( "templates/scada.createApplication" ), replacements, monitor );
        Helper.createFile ( new File ( packageFolder, "src/usr/share/eclipsescada/ca.bootstrap/bootstrap." + name + ".json" ), new FileInputStream ( new File ( sourceBase, name + "/data.json" ) ), monitor, false );

        createFile.setExecutable ( true );

        patchProfile ( name, target );
    }

    /**
     * Inject the CA bootstrap property to the profile
     * 
     * @param file
     *            the profile.xml file in the debian package target
     * @throws IOException
     */
    protected void patchProfile ( final String name, final File file ) throws IOException
    {
        final ResourceSet rs = new ResourceSetImpl ();
        final Resource r = rs.createResource ( URI.createFileURI ( file.toString () ) );
        r.load ( null );

        final Profile profile = (Profile)EcoreUtil.getObjectByType ( r.getContents (), ProfilePackage.Literals.PROFILE );
        final SystemProperty bootstrap = ProfileFactory.eINSTANCE.createSystemProperty ();
        bootstrap.setKey ( "org.eclipse.scada.ca.file.provisionJsonUrl" );
        bootstrap.setValue ( "file:///usr/share/eclipsescada/ca.bootstrap/bootstrap." + name + ".json" );
        profile.getProperty ().add ( bootstrap );
        r.save ( null );
    }
}
