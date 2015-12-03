/*******************************************************************************
 * Copyright (c) 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.lib.deployment.startup;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.world.lib.deployment.Contents;
import org.eclipse.scada.configuration.world.lib.deployment.DeploymentContext;
import org.eclipse.scada.configuration.world.lib.deployment.FileInformation;
import org.eclipse.scada.configuration.world.lib.deployment.FileOptions;

public class SystemdHandler extends AbstractStartupHandler
{
    private static final Pattern ALT_PATTERN = Pattern.compile ( "\\@\\@(.*?)\\@\\@" ); //$NON-NLS-1$

    @Override
    public void createDriver ( final DeploymentContext context, final String driverName, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        context.addFile ( Contents.createContent ( SystemdHandler.class.getResourceAsStream ( "templates/systemd/driver.service" ), replacements, ALT_PATTERN ), "/usr/lib/systemd/system/scada.driver." + driverName + ".service", new FileInformation ( 0644, null, null, FileOptions.CONFIGURATION ) );
        context.addFile ( Contents.createContent ( SystemdHandler.class.getResourceAsStream ( "templates/systemd/driver.launcher.sh" ), replacements, ALT_PATTERN ), "/usr/bin/scada.driver." + driverName + ".launcher", new FileInformation ( 0755, null, null ) );
    }

    @Override
    public void createEquinox ( final DeploymentContext context, final String appName, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        context.addFile ( Contents.createContent ( SystemdHandler.class.getResourceAsStream ( "templates/systemd/p2.service" ), replacements, ALT_PATTERN ), "/usr/lib/systemd/system/scada.app." + appName + ".service", new FileInformation ( 0644, null, null, FileOptions.CONFIGURATION ) );
        context.addFile ( Contents.createContent ( SystemdHandler.class.getResourceAsStream ( "templates/systemd/p2.launcher.sh" ), replacements, ALT_PATTERN ), "/usr/bin/scada.app." + appName + ".launcher", new FileInformation ( 0755, null, null ) );
    }

    @Override
    public String[] startDriverCommand ( final String driverName )
    {
        return new String[] { //
                String.format ( "systemctl enable \"scada.driver.%s\".service", driverName ), //
                String.format ( "systemctl start \"scada.driver.%s\"", driverName ) //
        };
    }

    @Override
    public String[] stopDriverCommand ( final String driverName )
    {
        return new String[] { //
                String.format ( "systemctl disable \"scada.driver.%s\".service", driverName ), //
                String.format ( "systemctl stop \"scada.driver.%s\"", driverName ) //
        };
    }

    @Override
    public String[] startEquinoxCommand ( final String appName )
    {
        return new String[] { //
                String.format ( "systemctl enable \"scada.app.%s\".service", appName ), //
                String.format ( "systemctl start \"scada.app.%s\"", appName ) //
        };
    }

    @Override
    public String[] stopEquinoxCommand ( final String appName )
    {
        return new String[] { //
                String.format ( "systemctl disable \"scada.app.%s\".service", appName ), //
                String.format ( "systemctl stop \"scada.app.%s\"", appName ) //
        };
    }

    @Override
    public String[] postinstCommands ()
    {
        return new String[] { "systemctl daemon-reload" };
    }

    @Override
    public String[] postremCommands ()
    {
        return new String[] { "systemctl daemon-reload" };
    }

    @Override
    public Set<String> getAdditionalPackageDependencies ()
    {
        return Collections.singleton ( "screen" );
    }
}
