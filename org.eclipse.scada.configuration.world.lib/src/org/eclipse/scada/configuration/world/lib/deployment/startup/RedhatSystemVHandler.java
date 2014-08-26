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
package org.eclipse.scada.configuration.world.lib.deployment.startup;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.world.lib.deployment.Contents;
import org.eclipse.scada.configuration.world.lib.deployment.DeploymentContext;
import org.eclipse.scada.configuration.world.lib.deployment.FileInformation;

public class RedhatSystemVHandler implements StartupHandler
{

    private static Pattern ALT_PATTERN = Pattern.compile ( "\\@\\@(.*?)\\@\\@" ); //$NON-NLS-1$

    @Override
    public void createDriver ( final DeploymentContext context, final String driverName, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        context.addFile ( Contents.createContent ( RedhatSystemVHandler.class.getResourceAsStream ( "templates/redhat_sysv/driver.service.sh" ), replacements, ALT_PATTERN ), "/etc/init.d/scada.driver." + driverName, new FileInformation ( 0755 ) );
    }

    @Override
    public void createEquinox ( final DeploymentContext context, final String appName, final Map<String, String> replacements, final IProgressMonitor monitor ) throws Exception
    {
        context.addFile ( Contents.createContent ( RedhatSystemVHandler.class.getResourceAsStream ( "templates/redhat_sysv/p2.service.sh" ), replacements, ALT_PATTERN ), "/etc/init.d/scada.app." + appName, new FileInformation ( 0755 ) );
        context.addFile ( Contents.createContent ( RedhatSystemVHandler.class.getResourceAsStream ( "templates/redhat_sysv/p2.launcher.sh" ), replacements, ALT_PATTERN ), "/usr/bin/scada.app." + appName + ".launcher", new FileInformation ( 0755 ) );
    }

    @Override
    public String startDriverCommand ( final String driverName )
    {
        return "/etc/init.d/scada.driver." + driverName + " start";
    }

    @Override
    public String stopDriverCommand ( final String driverName )
    {
        return "/etc/init.d/scada.driver." + driverName + " stop";
    }

    @Override
    public String startEquinoxCommand ( final String appName )
    {
        return "/etc/init.d/scada.app." + appName + " start";
    }

    @Override
    public String stopEquinoxCommand ( final String appName )
    {
        return "/etc/init.d/scada.app." + appName + " stop";
    }

    @Override
    public Set<String> getAdditionalPackageDependencies ()
    {
        return Collections.singleton ( "screen" );
    }
}
