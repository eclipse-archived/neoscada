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
package org.eclipse.scada.configuration.setup.common.lib;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.packagedrone.utils.deb.build.StaticContentProvider;
import org.eclipse.scada.configuration.setup.common.SerialToNetwork;
import org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping;
import org.eclipse.scada.configuration.setup.common.SerialToNetworkSetupModule;
import org.eclipse.scada.configuration.world.lib.deployment.DeploymentContext;
import org.eclipse.scada.configuration.world.lib.deployment.FileInformation;
import org.eclipse.scada.configuration.world.lib.deployment.FileOptions;
import org.eclipse.scada.configuration.world.lib.deployment.OperatingSystemDescriptors;
import org.eclipse.scada.configuration.world.lib.setup.SetupModuleHandler;
import org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor;
import org.eclipse.scada.utils.str.StringHelper;
import org.eclipse.scada.utils.str.StringReplacer;

import com.google.common.io.Resources;

public class SerialToNetworkHandler implements SetupModuleHandler
{
    private static final Pattern PATTERN = Pattern.compile ( "@@(.*?)@@" );

    private final SerialToNetworkSetupModule target;

    public SerialToNetworkHandler ( final SerialToNetworkSetupModule target )
    {
        this.target = target;
    }

    @Override
    public void perform ( final DeploymentContext context, final OperatingSystemDescriptor operatingSystem ) throws Exception
    {
        SerialToNetwork.validate ( this.target, operatingSystem );

        final StringBuilder sb = new StringBuilder ();

        sb.append ( "# Configuration file create by Eclipse SCADA Configurator IDE" );
        sb.append ( '\n' ).append ( '\n' );

        for ( final SerialToNetworkMapping entry : this.target.getMappings () )
        {
            sb.append ( String.format ( "%s:raw:%s:%s:%s", entry.getTcpPort (), Math.max ( 0, entry.getTimeout () ), entry.getDevice (), makeOptions ( entry ) ) );
            sb.append ( '\n' );
        }

        context.addFile ( new StaticContentProvider ( sb.toString () ), "/etc/site/ser2net.conf", new FileInformation ( 06440, null, null, FileOptions.CONFIGURATION ) );

        divert ( context, context.getPackageName (), "/etc/ser2net.conf", "/etc/site/ser2net.conf" );
        context.addInstallDependency ( OperatingSystemDescriptors.getProperty ( operatingSystem, "ser2net.package", "ser2net" ) );

        context.runAfterInstallation ( "/etc/init.d/ser2net restart || true" );
        context.runAfterRemoval ( "/etc/init.d/ser2net restart || true" );
    }

    private void divert ( final DeploymentContext context, final String packageName, final String targetFile, final String diversionFile ) throws IOException
    {
        final Map<String, String> properties = new HashMap<> ( 3 );

        properties.put ( "PKG", packageName );
        properties.put ( "TARGET", targetFile );
        properties.put ( "DIVERSION", diversionFile );

        context.addPostInstallationScript ( makeScript ( properties, "dpkg-divert.add.txt" ) );
        context.addPostRemovalScript ( makeScript ( properties, "dpkg-divert.remove.txt" ) );
    }

    protected StringReader makeScript ( final Map<String, String> properties, final String resourceName ) throws IOException
    {
        return new StringReader ( StringReplacer.replace ( Resources.toString ( this.getClass ().getResource ( resourceName ), StandardCharsets.UTF_8 ), StringReplacer.newSource ( properties ), PATTERN ) );
    }

    private String makeOptions ( final SerialToNetworkMapping entry )
    {
        final List<String> options = new LinkedList<> ();

        options.add ( "" + entry.getBaudRate () );
        options.add ( entry.getDataBits () + "DATABITS" );
        options.add ( MessageFormat.format ( "{0,choice,1#1STOPBIT|1<{0}STOPBITS}", entry.getStopBits () ) );
        options.add ( "" + entry.getParity () );

        if ( !entry.isBreak () )
        {
            options.add ( "NOBREAK" );
        }

        addOption ( options, !entry.isModemControl (), "LOCAL" );
        addOption ( options, entry.isXonxoff (), "XONXOFF" );
        addOption ( options, entry.isRtscts (), "RTSCTS" );

        return StringHelper.join ( options, " " );
    }

    private void addOption ( final List<String> options, final boolean flag, final String string )
    {
        if ( flag )
        {
            options.add ( string );
        }
        else
        {
            options.add ( "-" + string );
        }
    }
}
