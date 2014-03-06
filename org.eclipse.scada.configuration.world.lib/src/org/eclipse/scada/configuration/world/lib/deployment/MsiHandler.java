/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
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
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.scada.configuration.world.Application;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.P2Platform;
import org.eclipse.scada.configuration.world.lib.Nodes;
import org.eclipse.scada.configuration.world.lib.deployment.wix.AntWixBuilder;
import org.eclipse.scada.configuration.world.lib.deployment.wix.MsiPlatform;
import org.eclipse.scada.configuration.world.lib.deployment.wix.WixDeploymentSetupBuilder;
import org.eclipse.scada.configuration.world.lib.oscar.P2ProfileProcessor;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

public class MsiHandler extends CommonHandler
{

    private final MsiDeploymentMechanism deployment;

    public MsiHandler ( final ApplicationNode applicationNode, final MsiDeploymentMechanism deployment )
    {
        super ( applicationNode );
        this.deployment = deployment;
    }

    @Override
    protected void handleProcess ( final IFolder nodeDir, final IProgressMonitor monitor, final Map<String, String> properties ) throws Exception
    {
        final File packageFolder = getPackageFolder ( nodeDir );

        final String packageName = getPackageName ();

        final MsiPlatform platform = convertPlatform ();

        File licenseFile;

        if ( this.deployment.getLicenseFile () != null && !this.deployment.getLicenseFile ().isEmpty () )
        {
            licenseFile = nodeDir.getProject ().getFile ( new Path ( this.deployment.getLicenseFile () ) ).getLocation ().toFile ();
        }
        else
        {
            licenseFile = null;
        }

        final File stage = new File ( packageFolder, "staging" );
        stage.mkdirs ();

        // fill staging

        createStage ( nodeDir.getLocation ().toFile (), stage, monitor );

        // create wix setup project

        final WixDeploymentSetupBuilder wixBuilder = new WixDeploymentSetupBuilder ();

        wixBuilder.setLicenseFile ( licenseFile );
        wixBuilder.setUseFirewall ( this.deployment.isEnableFirewall () );
        wixBuilder.setUseUserInterface ( this.deployment.isEnableUserInterface () );

        wixBuilder.setPlatform ( platform );
        wixBuilder.setName ( String.format ( "Deployment package for node %s", Nodes.makeName ( this.applicationNode ) ) ); //$NON-NLS-1$
        wixBuilder.setVersion ( this.deployment.getVersion () );
        wixBuilder.setManufacturer ( this.deployment.getManufacturer () );
        wixBuilder.setUpgradeCode ( this.deployment.getUpgradeCode () );

        for ( final String driverName : makeDriverList () )
        {
            createDriver ( wixBuilder, nodeDir.getLocation ().toFile (), driverName );
        }

        // create ant builder project

        final Set<String> wixExt = new HashSet<> ();

        if ( this.deployment.isEnableFirewall () )
        {
            wixExt.add ( "WixFirewallExtension" ); //$NON-NLS-1$
        }
        if ( this.deployment.isEnableFirewall () )
        {
            wixExt.add ( "WixUIExtension" ); //$NON-NLS-1$
        }

        final AntWixBuilder antBuilder = new AntWixBuilder ( String.format ( "%s_%s.msi", packageName, this.deployment.getVersion () ), platform, findPlatform (), wixExt ); //$NON-NLS-1$
        createApplications ( nodeDir.getLocation ().toFile (), antBuilder, wixBuilder );

        // write out

        wixBuilder.write ( packageFolder );
        antBuilder.write ( packageFolder );
    }

    private P2Platform findPlatform ()
    {
        if ( this.deployment.getLocalPlatform () != null )
        {
            return this.deployment.getLocalPlatform ();
        }
        if ( this.deployment.getSharedPlatform () != null )
        {
            return this.deployment.getSharedPlatform ();
        }
        throw new IllegalStateException ( "MSI deployment has not P2 target platform assigned. Use either local or shared platform." );
    }

    private MsiPlatform convertPlatform ()
    {
        switch ( this.deployment.getArchitecture () )
        {
            case I386:
                return MsiPlatform.WIN32;
            case AMD64:
                return MsiPlatform.WIN64;
            default:
                throw new IllegalStateException ( String.format ( "Architecture %s is not supported.", this.deployment.getArchitecture () ) );
        }
    }

    private void createApplications ( final File baseDir, final AntWixBuilder antBuilder, final WixDeploymentSetupBuilder wixBuilder )
    {
        for ( final Application app : this.applicationNode.getApplications () )
        {
            if ( ! ( app instanceof EquinoxApplication ) )
            {
                continue;
            }

            final EquinoxApplication eapp = (EquinoxApplication)app;

            final Profile profile = P2ProfileProcessor.makeProfile ( eapp );
            antBuilder.addApplication ( new AntWixBuilder.Application ( app.getName (), profile ) );

            final File configurationBaseDir = new File ( baseDir, eapp.getName () );

            wixBuilder.addApplication ( new WixDeploymentSetupBuilder.EquinoxAppService ( app.getName (), profile, configurationBaseDir ) );
        }
    }

    private void createDriver ( final WixDeploymentSetupBuilder wixBuilder, final File nodeDir, final String driverName ) throws Exception
    {
        final File sourceDir = new File ( nodeDir, driverName );

        final Properties p = new Properties ();
        final File properties = new File ( sourceDir, "application.properties" ); //$NON-NLS-1$
        if ( properties.isFile () )
        {
            p.load ( new FileInputStream ( properties ) );
        }

        final File exporter = new File ( sourceDir, "exporter.xml" ); //$NON-NLS-1$

        wixBuilder.addCommonDriver ( new WixDeploymentSetupBuilder.CommonDriverService ( driverName, exporter, p ) );
    }

    private void createStage ( final File nodeDir, final File stage, final IProgressMonitor monitor ) throws IOException
    {
    }

    @Override
    protected String getBaseFolderName ()
    {
        return "msi-packages"; //$NON-NLS-1$
    }

}
